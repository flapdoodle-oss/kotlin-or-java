package de.mosmann.bugs.components

import de.mosmann.bugs.framework.Component
import de.mosmann.bugs.framework.HasValidation
import de.mosmann.bugs.framework.HasValue

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