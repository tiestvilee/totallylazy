package com.googlecode.totallylazy.predicates;

import com.googlecode.totallylazy.Predicate;

public class Null<T> implements Predicate<T> {
    public boolean matches(T other) {
        return other == null;
    }
}
