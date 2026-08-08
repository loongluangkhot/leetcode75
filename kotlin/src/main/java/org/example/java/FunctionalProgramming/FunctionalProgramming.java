package org.example.java.FunctionalProgramming;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalProgramming {
    public void useFunction(IFunction f) {
        // Do nothing
    }

    public void doUsingAnonymousClass() {
        IFunction f = new IFunction() {
            @Override
            public Object doSomething(Object input) {
                return input;
            }
        };

        useFunction(f);
    }

    public void doUsingLambda() {
        IFunction f = input -> { return input; };
        useFunction(f);
    }

    public Predicate<Object> predicate = i -> true;
    public Supplier<Object> supplier = () -> new Object();
    public Consumer<Object> consumer = i -> {};
    public UnaryOperator<Object> unaryOperator = i -> i;
    public Function<Object, Integer> func = i -> 1;
    public BiFunction<Object, Integer, Boolean> biFunc = (i, j) -> true;
}
