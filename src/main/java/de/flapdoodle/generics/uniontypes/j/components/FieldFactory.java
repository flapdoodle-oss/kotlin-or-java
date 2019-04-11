package de.flapdoodle.generics.uniontypes.j.components;

import de.flapdoodle.generics.uniontypes.j.framework.Component;
import de.flapdoodle.generics.uniontypes.j.framework.HasValidation;
import de.flapdoodle.generics.uniontypes.j.framework.HasValue;

import java.util.function.Supplier;

public interface FieldFactory {
  <T, C extends Component & HasValue<T> & HasValidation> Supplier<C> factoryFor(Class<T> type);
}
