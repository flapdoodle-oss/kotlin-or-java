package de.flapdoodle.generics.uniontypes.j;

import de.flapdoodle.generics.uniontypes.j.components.FieldFactory;
import de.flapdoodle.generics.uniontypes.j.framework.Component;
import de.flapdoodle.generics.uniontypes.j.framework.HasValidation;
import de.flapdoodle.generics.uniontypes.j.framework.HasValue;
import de.flapdoodle.generics.uniontypes.j.model.Property;

import java.util.List;
import java.util.function.Supplier;

public class FieldGenerator {

  private FieldFactory fieldFactory;

  public FieldGenerator(FieldFactory fieldFactory) {
    this.fieldFactory = fieldFactory;
  }

  void addFields(Component parent, List<Property<?>> properties) {
    properties.forEach(it -> addField(parent, it));
  }

  private <T, C extends Component & HasValue<T> & HasValidation>
  void addField(Component parent, Property<T> property) {
    Supplier<C> factory = fieldFactory.factoryFor(property.type);
    C field = factory.get();
    field.setValue(property.value);
    parent.add(field);
  }
}
