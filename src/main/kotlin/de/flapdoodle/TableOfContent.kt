package de.flapdoodle

import kotlin.reflect.KClass

object TableOfContent {

  val topics = listOf(
      UnionTypes(),
      FunctionInterfaces()
  )

  interface Topic {
    val kotlin: KClass<out Any>
    val java: Class<out Any>
  }

  /**
   * kotlin kann mit lokalen typdeclarationen nicht umgehen..
   * das wird besonders hart bei uniontypes
   */
  data class UnionTypes(
      override val kotlin: KClass<out Any> = de.flapdoodle.generics.uniontypes.k.FieldGenerator::class,
      override val java: Class<out Any> = de.flapdoodle.generics.uniontypes.j.FieldGenerator::class.java
  ) : Topic

  /**
   * die interop mit java im bereich funktionaler interfaces ist merkwürdig...
   * da gibt es eine latte von unterschiedlichen problemen, die man eigentlich vermeiden können sollte
   * aber scheinbar ist das absicht.
   */
  data class FunctionInterfaces(
      override val kotlin: KClass<out Any> = de.flapdoodle.interfaces.k.JavaFunctionAsKotlin::class,
      override val java: Class<out Any> = de.flapdoodle.interfaces.j.JavaFunction::class.java
  ) : Topic
}