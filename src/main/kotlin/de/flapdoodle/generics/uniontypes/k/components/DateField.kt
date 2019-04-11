package de.flapdoodle.generics.uniontypes.k.components

import de.flapdoodle.generics.uniontypes.k.framework.Component
import de.flapdoodle.generics.uniontypes.k.framework.HasValidation
import de.flapdoodle.generics.uniontypes.k.framework.HasValue
import java.time.LocalDate

class DateField : Component(), HasValue<LocalDate>, HasValidation {
  private var value: LocalDate? = null
  private var invalid: Boolean = false

  override fun getValue(): LocalDate? = value

  override fun setValue(value: LocalDate?) {
    this.value = value
  }

  override fun setInvalid(flag: Boolean) {
    this.invalid=flag
  }
}