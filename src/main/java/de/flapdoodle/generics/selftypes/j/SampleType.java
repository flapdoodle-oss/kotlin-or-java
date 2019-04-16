package de.flapdoodle.generics.selftypes.j;

import java.util.List;

interface SampleType<T extends SampleType<T>> {
  T changeName(String name);

  String name();

  List<? extends SampleType<?>> children();
}
