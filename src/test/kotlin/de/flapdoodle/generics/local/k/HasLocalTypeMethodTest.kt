package de.flapdoodle.generics.local.k

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.function.Supplier

class HasLocalTypeMethodTest {

  @Test
  fun usage() {
    val factory = object : Factory<String, Supplier<String>> {
      override fun create(source: String): Supplier<String> {
        return Supplier { source }
      }
    }
    val result = HasLocalTypeMethod().outer(factory, "foo")
    assertEquals("foo", result)
  }

}