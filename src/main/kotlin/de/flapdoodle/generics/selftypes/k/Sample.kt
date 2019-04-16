package de.flapdoodle.generics.selftypes.k

class Sample(
    private val name: String,
    private val children: List<SampleType<*>>
) : SampleType<Sample> {

  override fun changeName(name: String): Sample {
    return Sample(name, this.children)
  }

  override fun name(): String {
    return name
  }

  override fun children(): List<SampleType<*>> {
    return children
  }
}
