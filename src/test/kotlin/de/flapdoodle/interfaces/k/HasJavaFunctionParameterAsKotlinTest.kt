package de.flapdoodle.interfaces.k

import de.flapdoodle.interfaces.j.HasJavaFunctionParameter
import de.flapdoodle.interfaces.j.JavaFunction
import de.flapdoodle.interfaces.k.HasJavaFunctionParameterAsKotlin
import de.flapdoodle.interfaces.k.JavaFunctionAsKotlin
import org.junit.jupiter.api.Test

class HasJavaFunctionParameterAsKotlinTest {

  @Test
  fun callFunction() {
    val testee = HasJavaFunctionParameter()

    testee.javaFunction<Any, Any> { s -> s }
    testee.javaFunction<Int, Double> { it.toDouble() }
  }

  @Test
  fun callFunctionAsKotlin() {
    val testee = HasJavaFunctionParameterAsKotlin()

    // TODO does not compile
    // testee.javaFunction<Any, Any> { s -> s }
    // testee.javaFunction<Int, Double> { it.toDouble() }

    testee.javaFunction(JavaFunction<Any, Any> { source -> source })
    testee.javaFunction(JavaFunction<Int, Double> { it.toDouble() })

    testee.javaFunctionAsKotlin(object : JavaFunctionAsKotlin<Any, Any> {
      override fun map(source: Any): Any {
        return source
      }
    })

    testee.javaFunctionAsKotlin(object : JavaFunctionAsKotlin<Int, Double> {
      override fun map(source: Int): Double {
        return source.toDouble()
      }
    })

    testee.kotlin<Any, Any> { s -> s }
    testee.kotlin<Int, Double> { it.toDouble() }
  }
}