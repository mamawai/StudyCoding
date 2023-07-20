package com.mashibing.dp;

import lombok.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TestEntity {
    public static void main(String[] args) {
        ArrayList<A> as = new ArrayList<>();
        ArrayList<A> as2 = new ArrayList<>();
        as.add(new A("A",5));
//        as.add(new A("B",3));
//        as.add(new A("B",4));
        as.add(new A("A",6));


        Map<String, Optional<A>> collect = as.stream().collect(Collectors.groupingBy(A::getName, Collectors.maxBy(Comparator.comparing(A::getAge))));
        Optional<A> a = collect.getOrDefault("A", Optional.empty());
        Optional<A> b = collect.getOrDefault("B", Optional.empty());
        Optional<A> c = collect.getOrDefault("C", Optional.empty());
        a.ifPresent(as2::add);
        b.ifPresent(as2::add);
        c.ifPresent(as2::add);
        System.out.println(as2);


    }
}
