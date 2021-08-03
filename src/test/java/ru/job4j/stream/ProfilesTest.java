package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenProfiles() {
        Address moscow = new Address("Moscow", "Lenina str.", 5, 123);
        Address petersburg = new Address("St-Petersburg", "Mira pr.", 3, 73);
        Address cheboksary = new Address("Cheboksary", "Egersky bul.", 2, 56);
        Address cheboksary2 = new Address("Cheboksary", "Kalinina", 6, 33);
        Address cheboksary3 = new Address("Cheboksary", "Kalinina", 6, 33);
        List<Profile> listOfProfiles = List.of(
                new Profile(petersburg),
                new Profile(moscow),
                new Profile(cheboksary),
                new Profile(cheboksary2),
                new Profile(cheboksary3)
        );
        List<Address> expected = new ArrayList<>();
        expected.add(cheboksary);
        expected.add(cheboksary2);
        expected.add(moscow);
        expected.add(petersburg);
        Profiles profiles = new Profiles();
        List<Address> collectOfAddresses = profiles.collect(listOfProfiles);
        assertThat(collectOfAddresses, is(expected));
    }
}