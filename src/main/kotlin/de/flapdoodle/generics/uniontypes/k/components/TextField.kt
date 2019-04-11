package de.flapdoodle.generics.uniontypes.k.components

import de.flapdoodle.generics.uniontypes.k.framework.Component
import de.flapdoodle.generics.uniontypes.k.framework.HasValidation
import de.flapdoodle.generics.uniontypes.k.framework.HasValue

class TextField : Component(), HasValue<String>, HasValidation {
  private var value: String? = null
  private var invalid: Boolean = false

  override fun getValue(): String? = value

  override fun setValue(value: String?) {
    this.value = value
  }

  override fun setInvalid(flag: Boolean) {
    this.invalid = flag
  }
}