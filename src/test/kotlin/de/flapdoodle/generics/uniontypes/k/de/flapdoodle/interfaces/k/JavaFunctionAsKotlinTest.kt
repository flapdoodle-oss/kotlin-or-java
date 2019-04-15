package de.flapdoodle.generics.uniontypes.k.de.flapdoodle.interfaces.k

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JavaFunctionAsKotlinTest {
  @Test
  fun delegateMustWork() {
    val a = object : JavaFunctionAsKotlin<Int,Double> {
      override fun map(source: Int): Double {
        return source.toDouble()
      }
    }
    val testee = a.andThen(object : JavaFunctionAsKotlin <Double, String> {
      override fun map(source: Double): String {
        return source.toString()
      }
    })

    assertEquals("2.0", testee.map(2))
  }

}