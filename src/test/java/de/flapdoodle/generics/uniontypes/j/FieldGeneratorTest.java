package de.flapdoodle.generics.uniontypes.j;

import de.flapdoodle.generics.uniontypes.j.components.DateField;
import de.flapdoodle.generics.uniontypes.j.components.FieldFactory;
import de.flapdoodle.generics.uniontypes.j.components.TextField;
import de.flapdoodle.generics.uniontypes.j.framework.Component;
import de.flapdoodle.generics.uniontypes.j.framework.HasValidation;
import de.flapdoodle.generics.uniontypes.j.framework.HasValue;
import de.flapdoodle.generics.uniontypes.j.model.Property;
import kotlin.Suppress;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class FieldGeneratorTest {
  @Test
  void fieldGeneratorUseCase() {
    FieldGenerator generator = new FieldGenerator(new DummyFieldFactory());
    Container container = new Container();

    generator.addFields(container, listOf(new Property<>(String.class, "One")));

    assertEquals(1, container.children.size());
    assertEquals(TextField.class, container.children.get(0).getClass());
  }

  private <T> List<T> listOf(T...values) {
    return Arrays.asList(values);
  }

  class Container extends Component {
  private List<Component> children = new ArrayList<>();
    public void add(Component component) {
      children.add(component);
    }
  }

  class DummyFieldFactory implements FieldFactory {
    @Override
    public <T, C extends Component & HasValue<T> & HasValidation> Supplier<C>
    factoryFor(Class<T> type) {
      if (type == String.class) {
        return () -> (C) new TextField();
      }
      if (type == LocalDate.class) {
        return () -> (C) new DateField();
      }
      throw new IllegalArgumentException("unknown $type");
    }
  }
}