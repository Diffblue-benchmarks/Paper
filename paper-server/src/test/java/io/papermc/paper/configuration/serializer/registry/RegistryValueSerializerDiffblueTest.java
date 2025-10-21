package io.papermc.paper.configuration.serializer.registry;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import io.leangen.geantyref.TypeToken;
import java.util.ArrayList;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class RegistryValueSerializerDiffblueTest {
  /**
   * Test {@link RegistryValueSerializer#RegistryValueSerializer(TypeToken, RegistryAccess,
   * ResourceKey, boolean)}.
   *
   * <p>Method under test: {@link RegistryValueSerializer#RegistryValueSerializer(TypeToken,
   * RegistryAccess, ResourceKey, boolean)}
   */
  @Test
  @DisplayName("Test new RegistryValueSerializer(TypeToken, RegistryAccess, ResourceKey, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegistryValueSerializer.<init>(TypeToken, RegistryAccess, ResourceKey, boolean)"
  })
  void testNewRegistryValueSerializer() {
    // Arrange
    TypeToken<Object> type = mock(TypeToken.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act
    RegistryValueSerializer<Object> actualRegistryValueSerializer =
        new RegistryValueSerializer<>(
            type, new ImmutableRegistryAccess(new ArrayList<>()), mock(ResourceKey.class), true);

    // Assert
    verify(type, atLeast(1)).getType();
    assertSame(type, actualRegistryValueSerializer.type());
  }

  /**
   * Test {@link RegistryValueSerializer#RegistryValueSerializer(Class, RegistryAccess, ResourceKey,
   * boolean)}.
   *
   * <p>Method under test: {@link RegistryValueSerializer#RegistryValueSerializer(Class,
   * RegistryAccess, ResourceKey, boolean)}
   */
  @Test
  @DisplayName("Test new RegistryValueSerializer(Class, RegistryAccess, ResourceKey, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegistryValueSerializer.<init>(Class, RegistryAccess, ResourceKey, boolean)"
  })
  void testNewRegistryValueSerializer2() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    RegistryValueSerializer<Object> actualRegistryValueSerializer =
        new RegistryValueSerializer<>(
            type, new ImmutableRegistryAccess(new ArrayList<>()), mock(ResourceKey.class), true);

    // Assert
    assertSame(type, actualRegistryValueSerializer.type().getType());
  }

  /**
   * Test {@link RegistryValueSerializer#convertFromResourceKey(ResourceKey)}.
   *
   * <p>Method under test: {@link RegistryValueSerializer#convertFromResourceKey(ResourceKey)}
   */
  @Test
  @DisplayName("Test convertFromResourceKey(ResourceKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RegistryValueSerializer.convertFromResourceKey(ResourceKey)"})
  void testConvertFromResourceKey() throws SerializationException {
    // Arrange
    DefaultedMappedRegistry<Object> defaultedMappedRegistry = mock(DefaultedMappedRegistry.class);
    when(defaultedMappedRegistry.getValue(Mockito.<ResourceKey<Object>>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    ImmutableRegistryAccess registryAccess = mock(ImmutableRegistryAccess.class);
    when(registryAccess.lookupOrThrow(Mockito.<ResourceKey<Registry<Object>>>any()))
        .thenReturn(defaultedMappedRegistry);
    Class<Object> type = Object.class;

    RegistryValueSerializer<Object> registryValueSerializer =
        new RegistryValueSerializer<>(type, registryAccess, null, true);

    // Act
    registryValueSerializer.convertFromResourceKey(null);

    // Assert
    verify(defaultedMappedRegistry).getValue((ResourceKey<Object>) isNull());
    verify(registryAccess).lookupOrThrow(isNull());
  }

  /**
   * Test {@link RegistryValueSerializer#convertFromResourceKey(ResourceKey)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ResourceKey} {@link ResourceKey#location()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryValueSerializer#convertFromResourceKey(ResourceKey)}
   */
  @Test
  @DisplayName(
      "Test convertFromResourceKey(ResourceKey); given 'null'; when ResourceKey location() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RegistryValueSerializer.convertFromResourceKey(ResourceKey)"})
  void testConvertFromResourceKey_givenNull_whenResourceKeyLocationReturnNull()
      throws SerializationException {
    // Arrange
    DefaultedMappedRegistry<Object> defaultedMappedRegistry = mock(DefaultedMappedRegistry.class);
    when(defaultedMappedRegistry.getValue(Mockito.<ResourceKey<Object>>any())).thenReturn(null);

    ImmutableRegistryAccess registryAccess = mock(ImmutableRegistryAccess.class);
    when(registryAccess.lookupOrThrow(Mockito.<ResourceKey<Registry<Object>>>any()))
        .thenReturn(defaultedMappedRegistry);
    Class<Object> type = Object.class;

    RegistryValueSerializer<Object> registryValueSerializer =
        new RegistryValueSerializer<>(type, registryAccess, null, true);

    ResourceKey<Object> key = mock(ResourceKey.class);
    when(key.location()).thenReturn(null);

    // Act and Assert
    assertThrows(
        SerializationException.class, () -> registryValueSerializer.convertFromResourceKey(key));
    verify(defaultedMappedRegistry).getValue(isA(ResourceKey.class));
    verify(registryAccess, atLeast(1)).lookupOrThrow(isNull());
    verify(key).location();
  }

  /**
   * Test {@link RegistryValueSerializer#convertFromResourceKey(ResourceKey)}.
   *
   * <ul>
   *   <li>Given withDefaultNamespace {@code argument.id.invalid}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryValueSerializer#convertFromResourceKey(ResourceKey)}
   */
  @Test
  @DisplayName(
      "Test convertFromResourceKey(ResourceKey); given withDefaultNamespace 'argument.id.invalid'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RegistryValueSerializer.convertFromResourceKey(ResourceKey)"})
  void testConvertFromResourceKey_givenWithDefaultNamespaceArgumentIdInvalid()
      throws SerializationException {
    // Arrange
    DefaultedMappedRegistry<Object> defaultedMappedRegistry = mock(DefaultedMappedRegistry.class);
    when(defaultedMappedRegistry.getValue(Mockito.<ResourceKey<Object>>any())).thenReturn(null);

    ImmutableRegistryAccess registryAccess = mock(ImmutableRegistryAccess.class);
    when(registryAccess.lookupOrThrow(Mockito.<ResourceKey<Registry<Object>>>any()))
        .thenReturn(defaultedMappedRegistry);
    Class<Object> type = Object.class;

    RegistryValueSerializer<Object> registryValueSerializer =
        new RegistryValueSerializer<>(type, registryAccess, null, true);

    ResourceKey<Object> key = mock(ResourceKey.class);
    when(key.location()).thenReturn(ResourceLocation.withDefaultNamespace("argument.id.invalid"));

    // Act and Assert
    assertThrows(
        SerializationException.class, () -> registryValueSerializer.convertFromResourceKey(key));
    verify(defaultedMappedRegistry).getValue(isA(ResourceKey.class));
    verify(registryAccess, atLeast(1)).lookupOrThrow(isNull());
    verify(key).location();
  }
}
