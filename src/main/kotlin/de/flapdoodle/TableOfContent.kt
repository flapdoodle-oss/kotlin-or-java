package de.flapdoodle

import kotlin.reflect.KClass

/**
 * Zu den Beispielen sollte es Tests geben, die das Problem in der Nutzung zeigen.
 */
object TableOfContent {

  val topics = listOf(
      LocalTypes(),
      UnionTypes(),
      SelfTypes(),
      FunctionInterfaces()
  )

  interface Topic {
    val kotlin: KClass<out Any>?
    val java: Class<out Any>?
  }

  /**
   * kotlin kann lokale typedeklarationen nicht ignorieren.. also muss man pflaster drauf kleben
   * das kann unter umständen sehr schwer werden.. (siehe UnionTypes)
   */
  data class LocalTypes(
      override val kotlin: KClass<out Any> = de.flapdoodle.generics.local.k.HasLocalTypeMethod::class,
      override val java: Class<out Any> = de.flapdoodle.generics.local.j.HasLocalTypeMethod::class.java
  ) : Topic

  /**
   * kotlin kann mit lokalen typdeclarationen nicht umgehen..
   * das wird besonders hart bei uniontypes
   */
  data class UnionTypes(
      override val kotlin: KClass<out Any> = de.flapdoodle.generics.uniontypes.k.FieldGenerator::class,
      override val java: Class<out Any> = de.flapdoodle.generics.uniontypes.j.FieldGenerator::class.java
  ) : Topic

  /**
   * java hat probleme mit selftypes, aber das kann man durch das löschen von typinformationen einfach beheben
   * kotlins type inference stellt sich da wesentlich weniger kulant an, was dann in bösen casts endet
   */
  data class SelfTypes(
      override val kotlin: KClass<out Any> = de.flapdoodle.generics.selftypes.k.Sample::class,
      override val java: Class<out Any> = de.flapdoodle.generics.selftypes.k.Sample::class.java
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