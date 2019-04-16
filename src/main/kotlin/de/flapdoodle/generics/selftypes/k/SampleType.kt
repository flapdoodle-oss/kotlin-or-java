package de.flapdoodle.generics.selftypes.k

interface SampleType<T : SampleType<T>> {
  fun changeName(name: String): T

  fun name(): String

  // sollte List<SampleType<out Any>> sein
  // das mag kotlin aber nicht.. und damit fängt es dann an
  fun children(): List<SampleType<*>>
}
