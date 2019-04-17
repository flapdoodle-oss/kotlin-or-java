package de.flapdoodle.generics.local.k

import java.util.function.Supplier

interface Factory<T, R : Supplier<T>> {
  fun create(source: T): R
}
