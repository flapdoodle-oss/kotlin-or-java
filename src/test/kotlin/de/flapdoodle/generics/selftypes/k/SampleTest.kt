package de.flapdoodle.generics.selftypes.k

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*
import java.util.stream.Collectors
import kotlin.streams.toList

class SampleTest {
  @Test
  fun callChangeName() {
    val testee = Sample("foo", ArrayList())

    val result = testee.changeName("bar")

    assertEquals("bar", result.name())
  }

  @Test
  fun typeOfChildren() {
    val testee = Sample("foo", Arrays.asList(Sample("blub", ArrayList())))

    val children = testee.children()

    val result = children.stream()
        .map { s -> changeName(s, "bar") }
        .toList()

    assertEquals(1, result.size)
    assertEquals("bar", result[0].name())
  }

  fun <T : SampleType<*>> changeName(instance: T, name: String): T {
    @Suppress("UNCHECKED_CAST")
    return instance.changeName(name) as T
  }

}