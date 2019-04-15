package de.flapdoodle.generics.uniontypes.k.de.flapdoodle.interfaces.k

@FunctionalInterface
interface JavaFunctionAsKotlin<S, D> {
  fun map(source: S): D

  fun <T> andThen(after: JavaFunctionAsKotlin<D, T>): JavaFunctionAsKotlin<S, T> {
    val that = this
    return object  : JavaFunctionAsKotlin<S,T> {
      override fun map(source: S): T {
        return after.map(that.map(source))
      }
    }
  }
}
