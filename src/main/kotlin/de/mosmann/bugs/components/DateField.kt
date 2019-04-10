package de.mosmann.bugs.components

import de.mosmann.bugs.framework.Component
import de.mosmann.bugs.framework.HasValidation
import de.mosmann.bugs.framework.HasValue
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