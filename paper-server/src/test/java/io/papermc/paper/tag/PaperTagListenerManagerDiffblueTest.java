package io.papermc.paper.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent.Cause;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.PrioritizableLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.PrioritizableLifecycleEventType.Simple;
import io.papermc.paper.registry.RegistryKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagLoader;
import net.minecraft.tags.TagLoader.EntryWithSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperTagListenerManagerDiffblueTest {
  /**
   * Test {@link PaperTagListenerManager#firePreFlattenEvent(Map, TagEventConfig)}.
   *
   * <p>Method under test: {@link PaperTagListenerManager#firePreFlattenEvent(Map, TagEventConfig)}
   */
  @Test
  @DisplayName("Test firePreFlattenEvent(Map, TagEventConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperTagListenerManager.firePreFlattenEvent(Map, TagEventConfig)"})
  void testFirePreFlattenEvent() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> initial = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null,
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    // Act and Assert
    assertTrue(PaperTagListenerManager.INSTANCE.firePreFlattenEvent(initial, config).isEmpty());
  }

  /**
   * Test {@link PaperTagListenerManager#firePreFlattenEvent(Map, TagEventConfig)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperTagListenerManager#firePreFlattenEvent(Map, TagEventConfig)}
   */
  @Test
  @DisplayName("Test firePreFlattenEvent(Map, TagEventConfig); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperTagListenerManager.firePreFlattenEvent(Map, TagEventConfig)"})
  void testFirePreFlattenEvent_givenFalse() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> initial = new HashMap<>();

    AbstractLifecycleEventType<
            BootstrapContext, ? extends ReloadableRegistrarEvent<PreFlattenTagRegistrar<Object>>, ?>
        preFlatten = mock(AbstractLifecycleEventType.class);
    when(preFlatten.hasHandlers()).thenReturn(false);
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            preFlatten,
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    // Act
    Map<ResourceLocation, List<EntryWithSource>> actualFirePreFlattenEventResult =
        PaperTagListenerManager.INSTANCE.firePreFlattenEvent(initial, config);

    // Assert
    verify(preFlatten).hasHandlers();
    assertTrue(actualFirePreFlattenEventResult.isEmpty());
  }

  /**
   * Test {@link PaperTagListenerManager#firePreFlattenEvent(Map, TagEventConfig)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperTagListenerManager#firePreFlattenEvent(Map, TagEventConfig)}
   */
  @Test
  @DisplayName("Test firePreFlattenEvent(Map, TagEventConfig); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperTagListenerManager.firePreFlattenEvent(Map, TagEventConfig)"})
  void testFirePreFlattenEvent_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        PaperTagListenerManager.INSTANCE.firePreFlattenEvent(new HashMap<>(), null).isEmpty());
  }

  /**
   * Test {@link PaperTagListenerManager#firePostFlattenEvent(Map, TagEventConfig)}.
   *
   * <p>Method under test: {@link PaperTagListenerManager#firePostFlattenEvent(Map, TagEventConfig)}
   */
  @Test
  @DisplayName("Test firePostFlattenEvent(Map, TagEventConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperTagListenerManager.firePostFlattenEvent(Map, TagEventConfig)"})
  void testFirePostFlattenEvent() {
    // Arrange
    HashMap<ResourceLocation, List<Object>> initial = new HashMap<>();
    TagEventConfig<Object, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            null,
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    // Act and Assert
    assertTrue(PaperTagListenerManager.INSTANCE.firePostFlattenEvent(initial, config).isEmpty());
  }

  /**
   * Test {@link PaperTagListenerManager#firePostFlattenEvent(Map, TagEventConfig)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperTagListenerManager#firePostFlattenEvent(Map, TagEventConfig)}
   */
  @Test
  @DisplayName("Test firePostFlattenEvent(Map, TagEventConfig); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperTagListenerManager.firePostFlattenEvent(Map, TagEventConfig)"})
  void testFirePostFlattenEvent_givenFalse() {
    // Arrange
    HashMap<ResourceLocation, List<Object>> initial = new HashMap<>();

    AbstractLifecycleEventType<
            BootstrapContext,
            ? extends ReloadableRegistrarEvent<PostFlattenTagRegistrar<Object>>,
            ?>
        postFlatten = mock(AbstractLifecycleEventType.class);
    when(postFlatten.hasHandlers()).thenReturn(false);
    TagEventConfig<Object, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            postFlatten,
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    // Act
    Map<ResourceLocation, List<Object>> actualFirePostFlattenEventResult =
        PaperTagListenerManager.INSTANCE.firePostFlattenEvent(initial, config);

    // Assert
    verify(postFlatten).hasHandlers();
    assertTrue(actualFirePostFlattenEventResult.isEmpty());
  }

  /**
   * Test {@link PaperTagListenerManager#firePostFlattenEvent(Map, TagEventConfig)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperTagListenerManager#firePostFlattenEvent(Map, TagEventConfig)}
   */
  @Test
  @DisplayName("Test firePostFlattenEvent(Map, TagEventConfig); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperTagListenerManager.firePostFlattenEvent(Map, TagEventConfig)"})
  void testFirePostFlattenEvent_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        PaperTagListenerManager.INSTANCE.firePostFlattenEvent(new HashMap<>(), null).isEmpty());
  }

  /**
   * Test {@link PaperTagListenerManager#createEventConfig(Registry, Cause)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperTagListenerManager#createEventConfig(Registry,
   * ReloadableRegistrarEvent.Cause)}
   */
  @Test
  @DisplayName("Test createEventConfig(Registry, Cause); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TagEventConfig PaperTagListenerManager.createEventConfig(Registry, ReloadableRegistrarEvent.Cause)"
  })
  void testCreateEventConfig_thenReturnNull() {
    // Arrange
    DefaultedMappedRegistry<Object> registry =
        new DefaultedMappedRegistry<>("42", mock(ResourceKey.class), mock(Lifecycle.class), true);

    // Act
    TagEventConfig<Holder<Object>, Object> actualCreateEventConfigResult =
        PaperTagListenerManager.INSTANCE.createEventConfig(registry, Cause.INITIAL);

    // Assert
    assertNull(actualCreateEventConfigResult);
  }

  /**
   * Test {@link PaperTagListenerManager#getPreFlattenType(RegistryKey)}.
   *
   * <p>Method under test: {@link PaperTagListenerManager#getPreFlattenType(RegistryKey)}
   */
  @Test
  @DisplayName("Test getPreFlattenType(RegistryKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Simple PaperTagListenerManager.getPreFlattenType(RegistryKey)"})
  void testGetPreFlattenType() {
    // Arrange and Act
    Simple<BootstrapContext, ReloadableRegistrarEvent<PreFlattenTagRegistrar<Object>>>
        actualPreFlattenType = PaperTagListenerManager.INSTANCE.getPreFlattenType(null);

    // Assert
    assertFalse(actualPreFlattenType.hasHandlers());
    assertEquals(PaperTagListenerManager.PRE_FLATTEN_EVENT_NAME, actualPreFlattenType.name());
  }

  /**
   * Test {@link PaperTagListenerManager#getPostFlattenType(RegistryKey)}.
   *
   * <p>Method under test: {@link PaperTagListenerManager#getPostFlattenType(RegistryKey)}
   */
  @Test
  @DisplayName("Test getPostFlattenType(RegistryKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Simple PaperTagListenerManager.getPostFlattenType(RegistryKey)"})
  void testGetPostFlattenType() {
    // Arrange and Act
    Simple<BootstrapContext, ReloadableRegistrarEvent<PostFlattenTagRegistrar<Object>>>
        actualPostFlattenType = PaperTagListenerManager.INSTANCE.getPostFlattenType(null);

    // Assert
    assertFalse(actualPostFlattenType.hasHandlers());
    assertEquals(PaperTagListenerManager.POST_FLATTEN_EVENT_NAME, actualPostFlattenType.name());
  }
}
