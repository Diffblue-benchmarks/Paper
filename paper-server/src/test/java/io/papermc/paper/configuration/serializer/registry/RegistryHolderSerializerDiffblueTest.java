package io.papermc.paper.configuration.serializer.registry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
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

class RegistryHolderSerializerDiffblueTest {
  /**
   * Test {@link RegistryHolderSerializer#RegistryHolderSerializer(Class, RegistryAccess,
   * ResourceKey, boolean)}.
   *
   * <p>Method under test: {@link RegistryHolderSerializer#RegistryHolderSerializer(Class,
   * RegistryAccess, ResourceKey, boolean)}
   */
  @Test
  @DisplayName("Test new RegistryHolderSerializer(Class, RegistryAccess, ResourceKey, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegistryHolderSerializer.<init>(Class, RegistryAccess, ResourceKey, boolean)"
  })
  void testNewRegistryHolderSerializer() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    RegistryHolderSerializer<Object> actualRegistryHolderSerializer =
        new RegistryHolderSerializer<>(
            type, new ImmutableRegistryAccess(new ArrayList<>()), mock(ResourceKey.class), true);

    // Assert
    assertEquals(
        "net.minecraft.core.Holder<java.lang.Object>",
        actualRegistryHolderSerializer.type().getType().getTypeName());
  }

  /**
   * Test {@link RegistryHolderSerializer#convertFromResourceKey(ResourceKey)}.
   *
   * <ul>
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryHolderSerializer#convertFromResourceKey(ResourceKey)}
   */
  @Test
  @DisplayName("Test convertFromResourceKey(ResourceKey); then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.core.Holder RegistryHolderSerializer.convertFromResourceKey(ResourceKey)"
  })
  void testConvertFromResourceKey_thenThrowSerializationException() throws SerializationException {
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

    // Act and Assert
    assertThrows(
        SerializationException.class, () -> registryHolderSerializer.convertFromResourceKey(null));
    verify(registryAccess, atLeast(1)).lookupOrThrow(isNull());
  }
}
