package io.papermc.paper.plugin.provider.configuration.serializer.constraints;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import io.papermc.paper.plugin.provider.configuration.serializer.constraints.PluginConfigConstraints.PluginName;
import io.papermc.paper.plugin.provider.configuration.serializer.constraints.PluginConfigConstraints.PluginName.Factory;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.serialize.SerializationException;

class PluginConfigConstraintsDiffblueTest {
  /**
   * Test PluginName_Factory {@link PluginName.Factory#make(PluginName, Type)} with {@code data},
   * {@code type}.
   *
   * <ul>
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link PluginName.Factory#make(PluginName, Type)}
   */
  @Test
  @DisplayName(
      "Test PluginName_Factory make(PluginName, Type) with 'data', 'type'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint PluginName.Factory.make(PluginName, Type)"
  })
  void testPluginName_FactoryMakeWithDataType_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    Factory factory = new Factory();
    PluginName data = mock(PluginName.class);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> factory.make(data, new PlaceholderForType(1)).validate(""));
  }
}
