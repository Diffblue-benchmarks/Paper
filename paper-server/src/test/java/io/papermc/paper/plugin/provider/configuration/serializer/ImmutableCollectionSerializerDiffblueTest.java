package io.papermc.paper.plugin.provider.configuration.serializer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.ConfigurationOptions;

class ImmutableCollectionSerializerDiffblueTest {
  /**
   * Test {@link ImmutableCollectionSerializer#emptyValue(Type, ConfigurationOptions)} with {@code
   * Type}, {@code ConfigurationOptions}.
   *
   * <p>Method under test: {@link ImmutableCollectionSerializer#emptyValue(Type,
   * ConfigurationOptions)}
   */
  @Test
  @DisplayName("Test emptyValue(Type, ConfigurationOptions) with 'Type', 'ConfigurationOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Collection ImmutableCollectionSerializer.emptyValue(Type, ConfigurationOptions)"
  })
  void testEmptyValueWithTypeConfigurationOptions() {
    // Arrange
    ImmutableListSerializer immutableListSerializer = new ImmutableListSerializer();

    // Act and Assert
    assertTrue(
        immutableListSerializer
            .emptyValue(new PlaceholderForType(1), mock(ConfigurationOptions.class))
            .isEmpty());
  }
}
