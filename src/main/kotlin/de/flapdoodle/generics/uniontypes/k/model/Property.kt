package de.flapdoodle.generics.uniontypes.k.model

data class Property<T>(val type: Class<T>, val value: T?)