package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return left.compareTo(right);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return right.length() - left.length();
        };
        System.out.println(cmpText.compare("dsfg", "sdfd"));
        System.out.println(cmpText.compare("vsfg", "sdfddfg"));
        System.out.println(cmpDescSize.compare("ghghhhhh", "sdfddfg"));
        System.out.println(cmpDescSize.compare("ghghhhhh", "sdfddfgs"));
    }
}

