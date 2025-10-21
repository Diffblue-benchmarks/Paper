package io.papermc.paper.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent.Cause;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPostFlattenTagRegistrarDiffblueTest {
  /**
   * Test {@link PaperPostFlattenTagRegistrar#PaperPostFlattenTagRegistrar(Map, TagEventConfig)}.
   *
   * <ul>
   *   <li>Then return registryKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPostFlattenTagRegistrar#PaperPostFlattenTagRegistrar(Map,
   * TagEventConfig)}
   */
  @Test
  @DisplayName(
      "Test new PaperPostFlattenTagRegistrar(Map, TagEventConfig); then return registryKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPostFlattenTagRegistrar.<init>(Map, TagEventConfig)"})
  void testNewPaperPostFlattenTagRegistrar_thenReturnRegistryKeyIsNull() {
    // Arrange
    HashMap<ResourceLocation, List<Object>> tags = new HashMap<>();
    TagEventConfig<Object, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    // Act
    PaperPostFlattenTagRegistrar<Object, Object> actualPaperPostFlattenTagRegistrar =
        new PaperPostFlattenTagRegistrar<>(tags, config);

    // Assert
    assertNull(actualPaperPostFlattenTagRegistrar.registryKey());
    assertTrue(actualPaperPostFlattenTagRegistrar.getAllTags().isEmpty());
    assertTrue(actualPaperPostFlattenTagRegistrar.tags.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperPostFlattenTagRegistrar#setCurrentContext(BootstrapContext)}
   *   <li>{@link PaperPostFlattenTagRegistrar#registryKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.registry.RegistryKey PaperPostFlattenTagRegistrar.registryKey()",
    "void PaperPostFlattenTagRegistrar.setCurrentContext(BootstrapContext)"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<ResourceLocation, List<Object>> tags = new HashMap<>();
    TagEventConfig<Object, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPostFlattenTagRegistrar<Object, Object> paperPostFlattenTagRegistrar =
        new PaperPostFlattenTagRegistrar<>(tags, config);
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    paperPostFlattenTagRegistrar.setCurrentContext(owner);

    // Assert
    assertNull(paperPostFlattenTagRegistrar.registryKey());
  }

  /**
   * Test {@link PaperPostFlattenTagRegistrar#getAllTags()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} withDefaultNamespace {@code 42} is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperPostFlattenTagRegistrar#getAllTags()}
   */
  @Test
  @DisplayName(
      "Test getAllTags(); given HashMap() withDefaultNamespace '42' is ArrayList(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPostFlattenTagRegistrar.getAllTags()"})
  void testGetAllTags_givenHashMapWithDefaultNamespace42IsArrayList_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<ResourceLocation, List<Object>> tags = new HashMap<>();
    ResourceLocation withDefaultNamespaceResult = ResourceLocation.withDefaultNamespace("42");
    tags.put(withDefaultNamespaceResult, new ArrayList<>());
    ResourceLocation withDefaultNamespaceResult2 =
        ResourceLocation.withDefaultNamespace("argument.id.invalid");
    tags.put(withDefaultNamespaceResult2, new ArrayList<>());
    TagEventConfig<Object, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    PaperPostFlattenTagRegistrar<Object, Object> paperPostFlattenTagRegistrar =
        new PaperPostFlattenTagRegistrar<>(tags, config);

    // Act and Assert
    assertEquals(2, paperPostFlattenTagRegistrar.getAllTags().size());
  }

  /**
   * Test {@link PaperPostFlattenTagRegistrar#getAllTags()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} withDefaultNamespace empty string is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPostFlattenTagRegistrar#getAllTags()}
   */
  @Test
  @DisplayName(
      "Test getAllTags(); given HashMap() withDefaultNamespace empty string is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPostFlattenTagRegistrar.getAllTags()"})
  void testGetAllTags_givenHashMapWithDefaultNamespaceEmptyStringIsArrayList() {
    // Arrange
    HashMap<ResourceLocation, List<Object>> tags = new HashMap<>();
    ResourceLocation withDefaultNamespaceResult = ResourceLocation.withDefaultNamespace("");
    tags.put(withDefaultNamespaceResult, new ArrayList<>());
    ResourceLocation withDefaultNamespaceResult2 =
        ResourceLocation.withDefaultNamespace("argument.id.invalid");
    tags.put(withDefaultNamespaceResult2, new ArrayList<>());
    TagEventConfig<Object, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    PaperPostFlattenTagRegistrar<Object, Object> paperPostFlattenTagRegistrar =
        new PaperPostFlattenTagRegistrar<>(tags, config);

    // Act and Assert
    assertEquals(2, paperPostFlattenTagRegistrar.getAllTags().size());
  }

  /**
   * Test {@link PaperPostFlattenTagRegistrar#getAllTags()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPostFlattenTagRegistrar#getAllTags()}
   */
  @Test
  @DisplayName("Test getAllTags(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPostFlattenTagRegistrar.getAllTags()"})
  void testGetAllTags_thenReturnEmpty() {
    // Arrange
    HashMap<ResourceLocation, List<Object>> tags = new HashMap<>();
    TagEventConfig<Object, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    PaperPostFlattenTagRegistrar<Object, Object> paperPostFlattenTagRegistrar =
        new PaperPostFlattenTagRegistrar<>(tags, config);

    // Act and Assert
    assertTrue(paperPostFlattenTagRegistrar.getAllTags().isEmpty());
  }

  /**
   * Test {@link PaperPostFlattenTagRegistrar#getAllTags()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPostFlattenTagRegistrar#getAllTags()}
   */
  @Test
  @DisplayName("Test getAllTags(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPostFlattenTagRegistrar.getAllTags()"})
  void testGetAllTags_thenReturnSizeIsOne() {
    // Arrange
    HashMap<ResourceLocation, List<Object>> tags = new HashMap<>();
    ResourceLocation withDefaultNamespaceResult =
        ResourceLocation.withDefaultNamespace("argument.id.invalid");
    tags.put(withDefaultNamespaceResult, new ArrayList<>());
    TagEventConfig<Object, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    PaperPostFlattenTagRegistrar<Object, Object> paperPostFlattenTagRegistrar =
        new PaperPostFlattenTagRegistrar<>(tags, config);

    // Act and Assert
    assertEquals(1, paperPostFlattenTagRegistrar.getAllTags().size());
  }
}
