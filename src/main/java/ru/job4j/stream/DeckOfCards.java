package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }
}

public class DeckOfCards {
    public static void main(String[] args) {
        List<Card> deckOfCards = Stream.of(Value.values())
                .flatMap(value -> Stream.of(Suit.values())
                        .map(suit -> new Card(suit, value)))
                .collect(Collectors.toList());
        deckOfCards.stream()
                .forEach(System.out::println);
    }
}