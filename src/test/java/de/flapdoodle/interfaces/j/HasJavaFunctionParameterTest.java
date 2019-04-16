package de.flapdoodle.interfaces.j;

import de.flapdoodle.interfaces.j.HasJavaFunctionParameter;
import org.junit.jupiter.api.Test;

class HasJavaFunctionParameterTest {

  @Test
  void callFunction() {
    HasJavaFunctionParameter testee=new HasJavaFunctionParameter();

    testee.javaFunction(s -> s);
    testee.javaFunction(Integer::doubleValue);
  }
}