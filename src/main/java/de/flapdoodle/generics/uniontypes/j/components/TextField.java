package de.flapdoodle.generics.uniontypes.j.components;

import de.flapdoodle.generics.uniontypes.j.framework.Component;
import de.flapdoodle.generics.uniontypes.j.framework.HasValidation;
import de.flapdoodle.generics.uniontypes.j.framework.HasValue;

public class TextField extends Component implements HasValue<String>, HasValidation {
  private String value = null;
  private boolean invalid= false;

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public void setInvalid(Boolean flag) {
    this.invalid = flag;
  }
}
