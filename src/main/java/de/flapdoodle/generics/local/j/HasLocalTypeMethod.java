package de.flapdoodle.generics.local.j;

import java.util.function.Supplier;

public class HasLocalTypeMethod {

  public <T> T outer(Factory<T,?> factory, T value) {
    return sample(factory, value);
  }

  public <T,R extends Supplier<T>> T sample(Factory<T,R> factory, T value) {
    R supplier = factory.create(value);
    return supplier.get();
  }
}
