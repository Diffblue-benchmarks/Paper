package io.papermc.paper.configuration.serializer.registry;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.ResourceKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class RegistryEntrySerializerDiffblueTest {
  /**
   * Test {@link RegistryEntrySerializer#registry()}.
   *
   * <p>Method under test: {@link RegistryEntrySerializer#registry()}
   */
  @Test
  @DisplayName("Test registry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Registry RegistryEntrySerializer.registry()"})
  void testRegistry() {
    // Arrange
    ImmutableRegistryAccess registryAccess = mock(ImmutableRegistryAccess.class);
    ResourceKey<? extends Registry<Object>> key = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> defaultedMappedRegistry =
        new DefaultedMappedRegistry<>("42", key, Lifecycle.experimental(), true);
    when(registryAccess.lookupOrThrow(Mockito.<ResourceKey<Registry<Object>>>any()))
        .thenReturn(defaultedMappedRegistry);
    Class<Object> type = Object.class;

    RegistryHolderSerializer<Object> registryHolderSerializer =
        new RegistryHolderSerializer<>(type, registryAccess, null, true);

    // Act
    Registry<Object> actualRegistryResult = registryHolderSerializer.registry();

    // Assert
    verify(registryAccess).lookupOrThrow(isNull());
    assertSame(defaultedMappedRegistry, actualRegistryResult);
  }

  /**
   * Test {@link RegistryEntrySerializer#deserialize(AnnotatedType, Object)} with {@code
   * AnnotatedType}, {@code Object}.
   *
   * <ul>
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryEntrySerializer#deserialize(AnnotatedType, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(AnnotatedType, Object) with 'AnnotatedType', 'Object'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RegistryEntrySerializer.deserialize(AnnotatedType, Object)"})
  void testDeserializeWithAnnotatedTypeObject_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    Class<Object> type = Object.class;
    RegistryHolderSerializer<Object> registryHolderSerializer =
        new RegistryHolderSerializer<>(
            type, new ImmutableRegistryAccess(new ArrayList<>()), mock(ResourceKey.class), true);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () ->
            registryHolderSerializer.deserialize(
                (AnnotatedType) null, ConfigurationTransformation.WILDCARD_OBJECT));
  }
}
