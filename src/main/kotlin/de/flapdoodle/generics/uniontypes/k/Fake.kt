package de.flapdoodle.generics.uniontypes.k

import de.flapdoodle.generics.uniontypes.k.framework.Component
import de.flapdoodle.generics.uniontypes.k.framework.HasValidation
import de.flapdoodle.generics.uniontypes.k.framework.HasValue

@Deprecated("needed for a hack to make the code compile")
class Fake<T> : Component(), HasValue<T>, HasValidation {
  override fun getValue(): T? {
    throw IllegalArgumentException("not implemented")
  }

  override fun setValue(value: T?) {
    throw IllegalArgumentException("not implemented")
  }

  override fun setInvalid(flag: Boolean) {
    throw IllegalArgumentException("not implemented")
  }
}