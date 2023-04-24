package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует банковскую систему.
 * @author Andrey Alpatov.
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему, если его нет в системе.
     * @param user пользователь которого нужно добавить в систему
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Медод удаляет пользователя из системы.
     * @param passport сравнение по полю.
     * @return список пользователей без удаленого.
     */

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет счет к пользователю.
     * @param passport поиск пользователя по паспорту.
     * @param account получим список всех счетовпользователя и добавим новый счет.
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     * @param passport паспорт пользователя.
     * @return возвращает пользователя, если ничего не найдено, вернет null.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизитам, с помощью метода findByPassport.
     * @param passport ищет пользователя по паспорту.
     * @param requisite получает список счетов этого пользователя и в нем находит нужный счет.
     * @return возвращает нужный счет.
     */

  public Account findByRequisite(String passport, String requisite) {
      User user = findByPassport(passport);
      if (user != null) {
          return getAccounts(user)
                  .stream()
                  .filter(p -> p.getRequisite().equals(requisite))
                  .findFirst()
                  .orElse(null);
      }
      return null;
  }

    /**
     * Метод перечисляет деньги с одного счета на другой.
     * @param srcPassport паспорт пользователя списания
     * @param srcRequisite реквизиты пользователя списания
     * @param destPassport паспорт пользователя зачисления
     * @param destRequisite реквизиты пользователя зачисления
     * @param amount сумма для перевода
     * @return возвращает true если деньги переведены и false если счет не найден или не хватает денег.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод получает доступ к списку счетов пользователя
     * @param user принимает карточку пользователя
     * @return возвращает счета ползователя
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}