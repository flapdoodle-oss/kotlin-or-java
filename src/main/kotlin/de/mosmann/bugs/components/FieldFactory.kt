package de.mosmann.bugs.components

import de.mosmann.bugs.framework.Component
import de.mosmann.bugs.framework.HasValidation
import de.mosmann.bugs.framework.HasValue

interface FieldFactory {
  fun <T, C> factoryFor(type: Class<out T>): () -> C
      where C: Component,
            C: HasValue<T>,
            C: HasValidation
}