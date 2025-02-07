package ru.job4j.bank;

import java.util.*;

/**
 * Класс организует работу по добавлению, изменению пользователей, а так же счетов пользователей.
 * Осуществляет работу со счетами (переводы).
 */
public class BankService {
    /**
     * Хранение списка пользователей (клиентов)
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя, если в базе нет такого пользователя,
     * то происходит его добавление в базу
     *
     * @param user добавляемый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта и новый счет пользователя,
     * если у пользователя в базе, найденного по номеру паспорта, нет добавляемого счёта,
     * то происходит довабление нового счёта в базу
     *
     * @param passport номер паспорта, по которому происходит поиск пользователя
     * @param account  счёт для добавления
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта, по котрому ищется пользователь
     *
     * @param passport номер паспорта
     * @return найденный пользователь, если не найден то возращается null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход номер паспорта, по которому ищется пользователь,
     * а также реквизиты счёта, по которому ищется аккаунт
     *
     * @param passport  номер паспорта, по которому происходит поиск пользователя
     * @param requisite реквизиты счёта для поиска
     * @return возвращает найденный счет либо null, если счёт не найден по реквизитам
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(e -> requisite.equals(e.getRequisite()))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * метод принимает на вход номера паспортов пользователей, также счета,
     * между которыми будет происходить перевод, а так же сумма. Производит перевод
     * между счетами с предварительной проверкой достаточности средств
     *
     * @param srcPassport   номер паспорта отправителя
     * @param srcRequisite  реквизиты счета отправителя
     * @param destPassport  номер паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount        сумма для перевода
     * @return если перевод успешено,то возврат true, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}