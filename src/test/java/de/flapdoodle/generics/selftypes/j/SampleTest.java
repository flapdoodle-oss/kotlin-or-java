package de.flapdoodle.generics.selftypes.j;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

  @Test
  void callChangeName() {
    Sample testee = new Sample("foo", new ArrayList<>());

    Sample result = testee.changeName("bar");

    assertEquals("bar", result.name());
  }

  @Test
  void typeOfChildren() {
    Sample testee = new Sample("foo", Arrays.asList(new Sample("blub", new ArrayList<>())));

    List<? extends SampleType> children = testee.children();

    List<? extends SampleType> result = children.stream()
        .map(s -> changeName(s, "bar"))
        .collect(Collectors.toList());

    assertEquals(1, result.size());
    assertEquals("bar", result.get(0).name());
  }

  <T extends SampleType<T>> T changeName(T instance, String name) {
    return instance.changeName(name);
  }
}