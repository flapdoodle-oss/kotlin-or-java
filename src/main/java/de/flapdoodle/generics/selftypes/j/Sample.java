package de.flapdoodle.generics.selftypes.j;

import java.util.List;

public class Sample implements SampleType<Sample> {

  private final String name;
  private final List<? extends SampleType<?>> children;

  public Sample(String name, List<? extends SampleType<?>> children) {
    this.name = name;
    this.children = children;
  }

  @Override
  public Sample changeName(String name) {
    return new Sample(name, this.children);
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<? extends SampleType<?>> children() {
    return children;
  }
}
