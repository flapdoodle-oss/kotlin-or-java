package de.flapdoodle.generics.uniontypes.k.framework

interface HasValue<V> {
  fun getValue(): V?
  fun setValue(value: V?)
}