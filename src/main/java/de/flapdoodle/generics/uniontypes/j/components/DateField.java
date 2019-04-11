package de.flapdoodle.generics.uniontypes.j.components;

import de.flapdoodle.generics.uniontypes.j.framework.Component;
import de.flapdoodle.generics.uniontypes.j.framework.HasValidation;
import de.flapdoodle.generics.uniontypes.j.framework.HasValue;

import java.time.LocalDate;

public class DateField extends Component implements HasValue<LocalDate>, HasValidation {
  private LocalDate value = null;
  private boolean invalid= false;

  @Override
  public LocalDate getValue() {
    return value;
  }

  @Override
  public void setValue(LocalDate value) {
    this.value = value;
  }

  @Override
  public void setInvalid(Boolean flag) {
    this.invalid = flag;
  }
}
