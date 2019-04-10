package de.mosmann.bugs

import de.mosmann.bugs.components.DateField
import de.mosmann.bugs.components.FieldFactory
import de.mosmann.bugs.components.TextField
import de.mosmann.bugs.framework.Component
import de.mosmann.bugs.framework.HasValidation
import de.mosmann.bugs.framework.HasValue
import de.mosmann.bugs.model.Property
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