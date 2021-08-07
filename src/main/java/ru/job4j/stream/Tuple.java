package ru.job4j.stream;

import java.util.Objects;

public class Tuple implements Comparable<Tuple> {
    private String name;
    private double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public int compareTo(Tuple tuple) {
        if (this.score == tuple.getScore()) {
            return this.name.compareTo(tuple.getName());
        }
        return Double.compare(this.score, tuple.getScore());
    }
}