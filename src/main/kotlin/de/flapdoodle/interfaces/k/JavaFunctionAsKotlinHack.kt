package de.flapdoodle.interfaces.k

@FunctionalInterface
interface JavaFunctionAsKotlinHack<S, D> {
  fun map(source: S): D

  fun <T> andThen(after: JavaFunctionAsKotlinHack<D, T>): JavaFunctionAsKotlinHack<S, T> {
    return JavaFunctionAsKotlinHack { source -> after.map(this.map(source)) }
  }

  companion object {

    /**
     * helper method which trying to reduce boilerplate code
     *
     * see https://youtrack.jetbrains.com/issue/KT-7770#focus=streamItem-27-3290802.0-0
     */
    inline operator fun <S,D> invoke (noinline delegate: (S) -> D): JavaFunctionAsKotlinHack<S, D> {
      return object : JavaFunctionAsKotlinHack<S, D> {
        override fun map(source: S): D {
          return delegate(source)
        }
      }
    }
  }
}
