package de.flapdoodle.generics.uniontypes.k

import de.flapdoodle.generics.uniontypes.k.components.FieldFactory
import de.flapdoodle.generics.uniontypes.k.framework.Component
import de.flapdoodle.generics.uniontypes.k.framework.HasValidation
import de.flapdoodle.generics.uniontypes.k.framework.HasValue
import de.flapdoodle.generics.uniontypes.k.model.Property

class FieldGenerator(private val fieldFactory: FieldFactory) {

  fun addFields(parent: Component, properties: List<Property<out Any>>) {
    properties.forEach{
      //addField(parent, it) // TODO should compile
      addField<Any, Fake<Any>>(parent, it) // TODO should not compile??
    }
  }

  fun <T, C> addField(parent: Component, property: Property<out T>)
      where C: Component,
            C: HasValue<T>,
            C: HasValidation {
    val factory = fieldFactory.factoryFor<T, C>(property.type)
    val field = factory.invoke()
    field.setValue(property.value)
    parent.add(field)
  }

  /**
   * compiles with -XXLanguage:+NewInference
   *
   * where factory has this type:
   *  {Component & HasValue<T> & HasValidation}
   */
//  fun <T> addField(parent: Component, property: Property<out T>) {
//    val factory = fieldFactory.factoryFor(property.type)
//    val field = factory.invoke()
//    field.setValue(property.value)
//    parent.add(field)
//  }
}
