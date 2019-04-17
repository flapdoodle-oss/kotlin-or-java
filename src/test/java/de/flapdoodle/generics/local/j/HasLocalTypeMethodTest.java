package de.flapdoodle.generics.local.j;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class HasLocalTypeMethodTest {

  @Test
  void usage() {
    Factory<String, Supplier<String>> factory = x -> () -> x;
    String result = new HasLocalTypeMethod().outer(factory, "foo");
    assertEquals("foo", result);
  }
}