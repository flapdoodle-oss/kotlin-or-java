package de.flapdoodle.generics.uniontypes.k.components

import de.flapdoodle.generics.uniontypes.k.framework.Component
import de.flapdoodle.generics.uniontypes.k.framework.HasValidation
import de.flapdoodle.generics.uniontypes.k.framework.HasValue

interface FieldFactory {
  fun <T, C> factoryFor(type: Class<out T>): () -> C
      where C: Component,
            C: HasValue<T>,
            C: HasValidation
}