package de.flapdoodle.generics.uniontypes.j.framework;

public interface HasValue<V> {
  V getValue();
  void setValue(V value);
}
