package io.papermc.paper.registry;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.registry.event.RegistryEventProvider;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class PaperRegistryListenerManagerDiffblueTest {
  /**
   * Test {@link PaperRegistryListenerManager#registerWithListeners(Registry, String, Object)} with
   * {@code registry}, {@code id}, {@code nms}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryListenerManager#registerWithListeners(Registry,
   * String, Object)}
   */
  @Test
  @DisplayName(
      "Test registerWithListeners(Registry, String, Object) with 'registry', 'id', 'nms'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object PaperRegistryListenerManager.registerWithListeners(Registry, String, Object)"
  })
  void testRegisterWithListenersWithRegistryIdNms_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultedMappedRegistry<Object> registry = mock(DefaultedMappedRegistry.class);
    org.mockito.Mockito.<ResourceKey<? extends Registry<Object>>>when(registry.key())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            PaperRegistryListenerManager.INSTANCE.registerWithListeners(
                registry, "compose", ConfigurationTransformation.WILDCARD_OBJECT));
    verify(registry).key();
  }

  /**
   * Test {@link PaperRegistryListenerManager#getRegistryValueAddEventType(RegistryEventProvider)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperRegistryListenerManager#getRegistryValueAddEventType(RegistryEventProvider)}
   */
  @Test
  @DisplayName(
      "Test getRegistryValueAddEventType(RegistryEventProvider); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.registry.event.type.RegistryEntryAddEventType PaperRegistryListenerManager.getRegistryValueAddEventType(RegistryEventProvider)"
  })
  void testGetRegistryValueAddEventType_givenIllegalArgumentException() {
    // Arrange
    RegistryEventProvider<Object, RegistryBuilder<Object>> type = mock(RegistryEventProvider.class);
    when(type.registryKey()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistryListenerManager.INSTANCE.getRegistryValueAddEventType(type));
    verify(type).registryKey();
  }

  /**
   * Test {@link PaperRegistryListenerManager#getRegistryValueAddEventType(RegistryEventProvider)}.
   *
   * <ul>
   *   <li>Given {@link RegistryKeyImpl#RegistryKeyImpl(Key)} with key is {@link
   *       ServerBuildInfo#BRAND_PAPER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperRegistryListenerManager#getRegistryValueAddEventType(RegistryEventProvider)}
   */
  @Test
  @DisplayName(
      "Test getRegistryValueAddEventType(RegistryEventProvider); given RegistryKeyImpl(Key) with key is BRAND_PAPER_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.registry.event.type.RegistryEntryAddEventType PaperRegistryListenerManager.getRegistryValueAddEventType(RegistryEventProvider)"
  })
  void testGetRegistryValueAddEventType_givenRegistryKeyImplWithKeyIsBrand_paper_id() {
    // Arrange
    RegistryEventProvider<Object, RegistryBuilder<Object>> type = mock(RegistryEventProvider.class);
    when(type.registryKey()).thenReturn(new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistryListenerManager.INSTANCE.getRegistryValueAddEventType(type));
    verify(type, atLeast(1)).registryKey();
  }

  /**
   * Test {@link PaperRegistryListenerManager#getRegistryValueAddEventType(RegistryEventProvider)}.
   *
   * <ul>
   *   <li>Given {@link RegistryKeyImpl#RegistryKeyImpl(Key)} with key is randomKey.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperRegistryListenerManager#getRegistryValueAddEventType(RegistryEventProvider)}
   */
  @Test
  @DisplayName(
      "Test getRegistryValueAddEventType(RegistryEventProvider); given RegistryKeyImpl(Key) with key is randomKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.registry.event.type.RegistryEntryAddEventType PaperRegistryListenerManager.getRegistryValueAddEventType(RegistryEventProvider)"
  })
  void testGetRegistryValueAddEventType_givenRegistryKeyImplWithKeyIsRandomKey() {
    // Arrange
    RegistryEventProvider<Object, RegistryBuilder<Object>> type = mock(RegistryEventProvider.class);
    when(type.registryKey()).thenReturn(new RegistryKeyImpl<>(NamespacedKey.randomKey()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistryListenerManager.INSTANCE.getRegistryValueAddEventType(type));
    verify(type, atLeast(1)).registryKey();
  }

  /**
   * Test {@link PaperRegistryListenerManager#getRegistryComposeEventType(RegistryEventProvider)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperRegistryListenerManager#getRegistryComposeEventType(RegistryEventProvider)}
   */
  @Test
  @DisplayName(
      "Test getRegistryComposeEventType(RegistryEventProvider); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.lifecycle.event.types.LifecycleEventType.Prioritizable PaperRegistryListenerManager.getRegistryComposeEventType(RegistryEventProvider)"
  })
  void testGetRegistryComposeEventType_givenIllegalArgumentException() {
    // Arrange
    RegistryEventProvider<Object, RegistryBuilder<Object>> type = mock(RegistryEventProvider.class);
    when(type.registryKey()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistryListenerManager.INSTANCE.getRegistryComposeEventType(type));
    verify(type).registryKey();
  }

  /**
   * Test {@link PaperRegistryListenerManager#getRegistryComposeEventType(RegistryEventProvider)}.
   *
   * <ul>
   *   <li>Given {@link RegistryKeyImpl#RegistryKeyImpl(Key)} with key is {@link
   *       ServerBuildInfo#BRAND_PAPER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperRegistryListenerManager#getRegistryComposeEventType(RegistryEventProvider)}
   */
  @Test
  @DisplayName(
      "Test getRegistryComposeEventType(RegistryEventProvider); given RegistryKeyImpl(Key) with key is BRAND_PAPER_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.lifecycle.event.types.LifecycleEventType.Prioritizable PaperRegistryListenerManager.getRegistryComposeEventType(RegistryEventProvider)"
  })
  void testGetRegistryComposeEventType_givenRegistryKeyImplWithKeyIsBrand_paper_id() {
    // Arrange
    RegistryEventProvider<Object, RegistryBuilder<Object>> type = mock(RegistryEventProvider.class);
    when(type.registryKey()).thenReturn(new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistryListenerManager.INSTANCE.getRegistryComposeEventType(type));
    verify(type, atLeast(1)).registryKey();
  }

  /**
   * Test {@link PaperRegistryListenerManager#getRegistryComposeEventType(RegistryEventProvider)}.
   *
   * <ul>
   *   <li>Given {@link RegistryKeyImpl#RegistryKeyImpl(Key)} with key is randomKey.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperRegistryListenerManager#getRegistryComposeEventType(RegistryEventProvider)}
   */
  @Test
  @DisplayName(
      "Test getRegistryComposeEventType(RegistryEventProvider); given RegistryKeyImpl(Key) with key is randomKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.lifecycle.event.types.LifecycleEventType.Prioritizable PaperRegistryListenerManager.getRegistryComposeEventType(RegistryEventProvider)"
  })
  void testGetRegistryComposeEventType_givenRegistryKeyImplWithKeyIsRandomKey() {
    // Arrange
    RegistryEventProvider<Object, RegistryBuilder<Object>> type = mock(RegistryEventProvider.class);
    when(type.registryKey()).thenReturn(new RegistryKeyImpl<>(NamespacedKey.randomKey()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistryListenerManager.INSTANCE.getRegistryComposeEventType(type));
    verify(type, atLeast(1)).registryKey();
  }
}
