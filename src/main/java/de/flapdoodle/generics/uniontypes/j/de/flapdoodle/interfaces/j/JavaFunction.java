package de.flapdoodle.generics.uniontypes.j.de.flapdoodle.interfaces.j;

@FunctionalInterface
public interface JavaFunction<S,D> {
  D map(S source);

  default <T> JavaFunction<S,T> andThen(JavaFunction<D,T> after) {
    return s -> after.map(map(s));
  }
}
