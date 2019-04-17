package de.flapdoodle.generics.local.j;

import java.util.function.Supplier;

public interface Factory<T,R extends Supplier<T>> {
  R create(T source);
}
