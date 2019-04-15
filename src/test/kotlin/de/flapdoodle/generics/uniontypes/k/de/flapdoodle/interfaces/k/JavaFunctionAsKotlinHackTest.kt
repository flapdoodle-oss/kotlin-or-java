package de.flapdoodle.generics.uniontypes.k.de.flapdoodle.interfaces.k

import de.flapdoodle.generics.uniontypes.j.de.flapdoodle.interfaces.j.JavaFunction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JavaFunctionAsKotlinHackTest {

  @Test
  fun delegateMustWork() {
    val a = JavaFunctionAsKotlinHack<Int,Double> { i -> i.toDouble() }
    val testee = a.andThen(JavaFunctionAsKotlinHack <Double, String> { d -> d.toString() })

    assertEquals("2.0", testee.map(2))
  }

}