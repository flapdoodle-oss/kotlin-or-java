package de.flapdoodle.generics.uniontypes.k

import de.flapdoodle.generics.uniontypes.k.components.DateField
import de.flapdoodle.generics.uniontypes.k.components.FieldFactory
import de.flapdoodle.generics.uniontypes.k.components.TextField
import de.flapdoodle.generics.uniontypes.k.framework.Component
import de.flapdoodle.generics.uniontypes.k.framework.HasValidation
import de.flapdoodle.generics.uniontypes.k.framework.HasValue
import de.flapdoodle.generics.uniontypes.k.model.Property
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class FieldGeneratorTest {

  @Test
  fun fieldGeneratorUseCase() {
    val generator = FieldGenerator(DummyFieldFactory())
    val container = Container()

    generator.addFields(container, listOf(Property(String::class.java, "One")))

    assertEquals(1, container.children.size)
    assertEquals(TextField::class.java, container.children.get(0)::class.java)
  }

  class Container(val children: MutableList<Component> = mutableListOf()) : Component() {
    override fun add(component: Component) {
      children.add(component)
    }
  }

  @Suppress("UNCHECKED_CAST")
  class DummyFieldFactory : FieldFactory {
    override fun <T, C> factoryFor(type: Class<out T>): () -> C
        where C : Component, C : HasValue<T>, C: HasValidation {
      if (type == String::class.java) {
        return { TextField() as C }
      }
      if (type == LocalDate::class.java) {
        return { DateField() as C }
      }
      throw IllegalArgumentException("unknown $type")
    }

  }
}