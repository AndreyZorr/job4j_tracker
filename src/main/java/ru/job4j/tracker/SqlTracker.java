package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement  = cn.prepareStatement(
                "INSERT INTO items(name, created) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    item.setId(resultSet.getInt("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean isSuccessful = false;
        try (PreparedStatement statement  = cn.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            isSuccessful = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }

    @Override
    public void delete(int id) {
        boolean isSuccessful = false;
        try (PreparedStatement statement  = cn.prepareStatement(
                "DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            isSuccessful = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemsList = new ArrayList<>();
        try (PreparedStatement statement  = cn.prepareStatement(
                "SELECT * FROM items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    itemsList.add(createItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemsList = new ArrayList<>();
        try (PreparedStatement statement  = cn.prepareStatement(
                "SELECT * FROM items WHERE name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    itemsList.add(createItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsList;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement statement  = cn.prepareStatement(
                "SELECT * FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item.setId(resultSet.getInt("id"));
                    item.setName((resultSet.getString("name")));
                    item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item createItem(ResultSet resultSet) {
        try {
            return new Item(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getTimestamp("created").toLocalDateTime());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
