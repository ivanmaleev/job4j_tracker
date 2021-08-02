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
        List<Profile> listOfProfiles = List.of(
                new Profile(moscow),
                new Profile(petersburg),
                new Profile(cheboksary)
        );
        List<Address> expected = new ArrayList<>();
        expected.add(moscow);
        expected.add(petersburg);
        expected.add(cheboksary);
        Profiles profiles = new Profiles();
        List<Address> collectOfAddresses = profiles.collect(listOfProfiles);
        assertThat(collectOfAddresses, is(expected));
    }

}