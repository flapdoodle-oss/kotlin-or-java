package de.flapdoodle.generics.uniontypes.k.de.flapdoodle.interfaces.k

import de.flapdoodle.generics.uniontypes.j.de.flapdoodle.interfaces.j.JavaFunction

class HasJavaFunctionParameterAsKotlin {

  fun <S, D> javaFunction(function: JavaFunction<S, D>) {

  }

  fun <S, D> javaFunctionAsKotlin(function: JavaFunctionAsKotlin<S, D>) {

  }

  fun <S, D> kotlin(function: (S) -> D) {

  }
}
