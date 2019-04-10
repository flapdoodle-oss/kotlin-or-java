package de.mosmann.bugs.model

data class Property<T>(val type: Class<T>, val value: T?)