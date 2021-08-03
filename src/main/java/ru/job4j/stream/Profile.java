package ru.job4j.stream;

public class Profile implements Comparable<Profile> {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public int compareTo(Profile o) {
        return address.compareTo(o.getAddress());
    }
}
