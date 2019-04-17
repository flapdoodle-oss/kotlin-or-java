package de.flapdoodle.generics.local.k

import java.util.function.Supplier

class HasLocalTypeMethod {

  fun <T> outer(factory: Factory<T, *>, value: T): T {
    @Suppress("UNCHECKED_CAST")
    return sample(factory as Factory<T, Supplier<T>>, value)
  }

  fun <T, R : Supplier<T>> sample(factory: Factory<T, R>, value: T): T {
    val supplier = factory.create(value)
    return supplier.get()
  }
}
