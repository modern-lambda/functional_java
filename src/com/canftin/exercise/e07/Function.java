package com.canftin.exercise.e07;

public interface Function<T, U> {
    U apply(T arg);

    static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T,V>>> higherCompose() {
        return f -> g -> x -> f.apply(g.apply(x));
    }

    static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T,V>>> higherAndThen() {
        return f -> g -> z -> g.apply(f.apply(z));
    }

    static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T, V>>> higherAndThen2() {
        return f -> g -> Function.<T, U, V>higherCompose().apply(g).apply(f);
    }
}
