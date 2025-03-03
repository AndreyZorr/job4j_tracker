package ru.job4j.tracker.store;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

 class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Assertions.assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

     @Test
     void whereShowDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item(1, "item1");
         Item item2 = new Item(2, "item2");
         Item item3 = new Item(3, "item3");
         tracker.add(item1);
         tracker.add(item2);
         tracker.add(item3);
         List<Item> items = List.of(item1, item2, item3);
         Assertions.assertThat(tracker.findAll()).isEqualTo(items);
     }

     @Test
     void whenShowFindAll() {
         SqlTracker tracker = new SqlTracker(connection);
         List<Item> items = new ArrayList<>();
         Item item1 = new Item(1, "item1");
         Item item2 = new Item(2, "item2");
         items.add(item1);
         items.add(item2);
         tracker.add(item1);
         tracker.add(item2);
         assertThat(tracker.findAll().containsAll(items));
     }

     @Test
     void whenFindByName() {
         SqlTracker tracker = new SqlTracker(connection);
         List<Item> items = new ArrayList<>();
         Item item1 = new Item(1, "item1");
         Item item2 = new Item(2, "item2");
         Item item3 = new Item(3, "new");
         items.add(item1);
         items.add(item2);
         tracker.add(item1);
         tracker.add(item2);
         tracker.add(item3);
         assertThat(tracker.findAll().containsAll(items));
         }

     @Test
     public void whenReplaceItemAndFindByGeneratedIdThenMustBeReplaced() {
         SqlTracker tracker = new SqlTracker(connection);
         Item item = new Item("item");
         Item item1 = new Item("item1");
         tracker.add(item);
         tracker.replace(item.getId(), item1);
         assertThat(tracker.findById(item.getId()).getName()).isEqualTo(item1.getName());
     }
}