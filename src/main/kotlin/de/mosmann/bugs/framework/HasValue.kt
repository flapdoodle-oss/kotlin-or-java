package de.mosmann.bugs.framework

interface HasValue<V> {
  fun getValue(): V?
  fun setValue(value: V?)
}