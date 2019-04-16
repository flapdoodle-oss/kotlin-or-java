package de.flapdoodle.interfaces.j;

import de.flapdoodle.interfaces.j.JavaFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaFunctionTest {

  @Test
  public void delegateMustWork() {
    JavaFunction<Integer,Double> a= i -> i.doubleValue();
    JavaFunction<Integer, String> testee = a.andThen(d -> d.toString());

    assertEquals("2.0", testee.map(2));
  }
}