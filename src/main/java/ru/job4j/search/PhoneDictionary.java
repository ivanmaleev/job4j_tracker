package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> nameContainsKey = (s) -> s.getName().contains(key);
        Predicate<Person> phoneContainsKey = (s) -> s.getPhone().contains(key);
        Predicate<Person> addressContainsKey = (s) -> s.getAddress().contains(key);
        Predicate<Person> surnameContainsKey = (s) -> s.getSurname().contains(key);
        Predicate<Person> combine = nameContainsKey.or(phoneContainsKey)
                .or(addressContainsKey).or(surnameContainsKey);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
