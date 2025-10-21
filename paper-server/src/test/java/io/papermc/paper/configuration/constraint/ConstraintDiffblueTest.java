package io.papermc.paper.configuration.constraint;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import io.papermc.paper.configuration.constraint.Constraint.Factory;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConstraintDiffblueTest {
  /**
   * Test Factory {@link Factory#make(Constraint, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Factory#make(Constraint, Type)}
   */
  @Test
  @DisplayName(
      "Test Factory make(Constraint, Type) with 'data', 'type'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Factory.make(Constraint, Type)"
  })
  void testFactoryMakeWithDataType_thenThrowRuntimeException() {
    // Arrange
    Factory factory = new Factory();

    Constraint data = mock(Constraint.class);
    Class<org.spongepowered.configurate.objectmapping.meta.Constraint> forNameResult =
        org.spongepowered.configurate.objectmapping.meta.Constraint.class;
    org.mockito.Mockito
        .<Class<? extends org.spongepowered.configurate.objectmapping.meta.Constraint<?>>>when(
            data.value())
        .thenReturn(
            (Class<org.spongepowered.configurate.objectmapping.meta.Constraint<?>>)
                (Class) forNameResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> factory.make(data, new PlaceholderForType(1)));
    verify(data).value();
  }
}
