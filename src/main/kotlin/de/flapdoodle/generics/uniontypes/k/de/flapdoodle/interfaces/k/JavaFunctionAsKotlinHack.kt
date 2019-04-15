package de.flapdoodle.generics.uniontypes.k.de.flapdoodle.interfaces.k

@FunctionalInterface
interface JavaFunctionAsKotlinHack<S, D> {
  fun map(source: S): D

  fun <T> andThen(after: JavaFunctionAsKotlinHack<D, T>): JavaFunctionAsKotlinHack<S, T> {
    return JavaFunctionAsKotlinHack { source -> after.map(this.map(source)) }
  }

  companion object {
    operator fun <S,D> invoke (delegate: (S) -> D): JavaFunctionAsKotlinHack<S, D> {
      return object : JavaFunctionAsKotlinHack<S,D> {
        override fun map(source: S): D {
          return delegate(source)
        }
      }
    }
  }
}
