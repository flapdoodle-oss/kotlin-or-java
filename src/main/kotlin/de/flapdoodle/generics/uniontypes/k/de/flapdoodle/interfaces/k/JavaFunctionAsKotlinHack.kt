package de.flapdoodle.generics.uniontypes.k.de.flapdoodle.interfaces.k

@FunctionalInterface
interface JavaFunctionAsKotlinHack<S, D> {
  fun map(source: S): D

  fun <T> andThen(after: JavaFunctionAsKotlinHack<D, T>): JavaFunctionAsKotlinHack<S, T> {
    return JavaFunctionAsKotlinHack { source -> after.map(this.map(source)) }
  }

  companion object {
    inline operator fun <S,D> invoke (noinline delegate: (S) -> D): JavaFunctionAsKotlinHack<S, D> {
      return object : JavaFunctionAsKotlinHack<S,D> {
        override fun map(source: S): D {
          return delegate(source)
        }
      }
    }
  }
}
