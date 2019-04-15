package de.flapdoodle.generics.uniontypes.j.de.flapdoodle.interfaces.j;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasJavaFunctionParameterTest {

  @Test
  void callFunction() {
    HasJavaFunctionParameter testee=new HasJavaFunctionParameter();

    testee.javaFunction(s -> s);
    testee.javaFunction(Integer::doubleValue);
  }
}