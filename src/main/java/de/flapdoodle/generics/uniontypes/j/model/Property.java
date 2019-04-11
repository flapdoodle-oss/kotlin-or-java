package de.flapdoodle.generics.uniontypes.j.model;

public class Property<T> {
  public final Class<T> type;
  public final T value;

  public Property(Class<T> type, T value) {
    this.type = type;
    this.value = value;
  }
}
