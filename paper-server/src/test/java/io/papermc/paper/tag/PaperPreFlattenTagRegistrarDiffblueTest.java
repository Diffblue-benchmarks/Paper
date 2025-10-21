package io.papermc.paper.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.adventure.providers.ClickCallbackProviderImpl;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent.Cause;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import io.papermc.paper.registry.tag.TagKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.TagLoader;
import net.minecraft.tags.TagLoader.EntryWithSource;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPreFlattenTagRegistrarDiffblueTest {
  /**
   * Test {@link PaperPreFlattenTagRegistrar#PaperPreFlattenTagRegistrar(Map, TagEventConfig)}.
   *
   * <ul>
   *   <li>Then return AllTags size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#PaperPreFlattenTagRegistrar(Map,
   * TagEventConfig)}
   */
  @Test
  @DisplayName(
      "Test new PaperPreFlattenTagRegistrar(Map, TagEventConfig); then return AllTags size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.<init>(Map, TagEventConfig)"})
  void testNewPaperPreFlattenTagRegistrar_thenReturnAllTagsSizeIsOne() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    ResourceLocation withDefaultNamespaceResult =
        ResourceLocation.withDefaultNamespace("argument.id.invalid");
    tags.put(withDefaultNamespaceResult, new ArrayList<>());
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    // Act
    PaperPreFlattenTagRegistrar<Object> actualPaperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);

    // Assert
    assertNull(actualPaperPreFlattenTagRegistrar.registryKey());
    assertEquals(1, actualPaperPreFlattenTagRegistrar.getAllTags().size());
    assertEquals(tags, actualPaperPreFlattenTagRegistrar.tags);
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#PaperPreFlattenTagRegistrar(Map, TagEventConfig)}.
   *
   * <ul>
   *   <li>Then return AllTags size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#PaperPreFlattenTagRegistrar(Map,
   * TagEventConfig)}
   */
  @Test
  @DisplayName(
      "Test new PaperPreFlattenTagRegistrar(Map, TagEventConfig); then return AllTags size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.<init>(Map, TagEventConfig)"})
  void testNewPaperPreFlattenTagRegistrar_thenReturnAllTagsSizeIsTwo() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    ResourceLocation withDefaultNamespaceResult = ResourceLocation.withDefaultNamespace("42");
    tags.put(withDefaultNamespaceResult, new ArrayList<>());
    ResourceLocation withDefaultNamespaceResult2 =
        ResourceLocation.withDefaultNamespace("argument.id.invalid");
    tags.put(withDefaultNamespaceResult2, new ArrayList<>());
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    // Act
    PaperPreFlattenTagRegistrar<Object> actualPaperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);

    // Assert
    assertNull(actualPaperPreFlattenTagRegistrar.registryKey());
    assertEquals(2, actualPaperPreFlattenTagRegistrar.getAllTags().size());
    assertEquals(tags, actualPaperPreFlattenTagRegistrar.tags);
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#PaperPreFlattenTagRegistrar(Map, TagEventConfig)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return AllTags Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#PaperPreFlattenTagRegistrar(Map,
   * TagEventConfig)}
   */
  @Test
  @DisplayName(
      "Test new PaperPreFlattenTagRegistrar(Map, TagEventConfig); when HashMap(); then return AllTags Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.<init>(Map, TagEventConfig)"})
  void testNewPaperPreFlattenTagRegistrar_whenHashMap_thenReturnAllTagsEmpty() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    // Act
    PaperPreFlattenTagRegistrar<Object> actualPaperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);

    // Assert
    assertNull(actualPaperPreFlattenTagRegistrar.registryKey());
    assertTrue(actualPaperPreFlattenTagRegistrar.getAllTags().isEmpty());
    assertTrue(actualPaperPreFlattenTagRegistrar.tags.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperPreFlattenTagRegistrar#setCurrentContext(BootstrapContext)}
   *   <li>{@link PaperPreFlattenTagRegistrar#registryKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.registry.RegistryKey PaperPreFlattenTagRegistrar.registryKey()",
    "void PaperPreFlattenTagRegistrar.setCurrentContext(BootstrapContext)"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    paperPreFlattenTagRegistrar.setCurrentContext(owner);

    // Assert
    assertNull(paperPreFlattenTagRegistrar.registryKey());
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#getAllTags()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} withDefaultNamespace {@code 42} is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#getAllTags()}
   */
  @Test
  @DisplayName(
      "Test getAllTags(); given HashMap() withDefaultNamespace '42' is ArrayList(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPreFlattenTagRegistrar.getAllTags()"})
  void testGetAllTags_givenHashMapWithDefaultNamespace42IsArrayList_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    ResourceLocation withDefaultNamespaceResult = ResourceLocation.withDefaultNamespace("42");
    tags.put(withDefaultNamespaceResult, new ArrayList<>());
    ResourceLocation withDefaultNamespaceResult2 =
        ResourceLocation.withDefaultNamespace("argument.id.invalid");
    tags.put(withDefaultNamespaceResult2, new ArrayList<>());
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);

    // Act and Assert
    assertEquals(2, paperPreFlattenTagRegistrar.getAllTags().size());
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#getAllTags()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} withDefaultNamespace empty string is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#getAllTags()}
   */
  @Test
  @DisplayName(
      "Test getAllTags(); given HashMap() withDefaultNamespace empty string is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPreFlattenTagRegistrar.getAllTags()"})
  void testGetAllTags_givenHashMapWithDefaultNamespaceEmptyStringIsArrayList() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    ResourceLocation withDefaultNamespaceResult = ResourceLocation.withDefaultNamespace("");
    tags.put(withDefaultNamespaceResult, new ArrayList<>());
    ResourceLocation withDefaultNamespaceResult2 =
        ResourceLocation.withDefaultNamespace("argument.id.invalid");
    tags.put(withDefaultNamespaceResult2, new ArrayList<>());
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);

    // Act and Assert
    assertEquals(2, paperPreFlattenTagRegistrar.getAllTags().size());
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#getAllTags()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#getAllTags()}
   */
  @Test
  @DisplayName("Test getAllTags(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPreFlattenTagRegistrar.getAllTags()"})
  void testGetAllTags_thenReturnEmpty() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);

    // Act and Assert
    assertTrue(paperPreFlattenTagRegistrar.getAllTags().isEmpty());
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#getAllTags()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#getAllTags()}
   */
  @Test
  @DisplayName("Test getAllTags(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPreFlattenTagRegistrar.getAllTags()"})
  void testGetAllTags_thenReturnSizeIsOne() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    ResourceLocation withDefaultNamespaceResult =
        ResourceLocation.withDefaultNamespace("argument.id.invalid");
    tags.put(withDefaultNamespaceResult, new ArrayList<>());
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            mock(AbstractLifecycleEventType.class),
            mock(AbstractLifecycleEventType.class),
            Cause.INITIAL,
            mock(Function.class),
            mock(Function.class),
            null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);

    // Act and Assert
    assertEquals(1, paperPreFlattenTagRegistrar.getAllTags().size());
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}.
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}
   */
  @Test
  @DisplayName("Test setTag(TagKey, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.setTag(TagKey, Collection)"})
  void testSetTag() {
    // Arrange
    PluginBootstrapContextImpl owner = mock(PluginBootstrapContextImpl.class);
    when(owner.getPluginMeta()).thenThrow(new NoSuchElementException());
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);
    paperPreFlattenTagRegistrar.setCurrentContext(owner);

    ArrayList<TagEntry<Object>> entries = new ArrayList<>();
    entries.add(new TagEntryImpl<>(ServerBuildInfo.BRAND_PAPER_ID, true, true));

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> paperPreFlattenTagRegistrar.setTag(null, entries));
    verify(owner).getPluginMeta();
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}.
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}
   */
  @Test
  @DisplayName("Test setTag(TagKey, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.setTag(TagKey, Collection)"})
  void testSetTag2() {
    // Arrange
    PluginBootstrapContextImpl owner = mock(PluginBootstrapContextImpl.class);
    when(owner.getPluginMeta()).thenThrow(new NoSuchElementException());
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);
    paperPreFlattenTagRegistrar.setCurrentContext(owner);

    ArrayList<TagEntry<Object>> entries = new ArrayList<>();
    entries.add(
        new TagEntryImpl<>(ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY, true, true));

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> paperPreFlattenTagRegistrar.setTag(null, entries));
    verify(owner).getPluginMeta();
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@link TagEntryImpl#TagEntryImpl(Key, boolean, boolean)} with key is randomKey and
   *       isTag is {@code true} and isRequired is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test setTag(TagKey, Collection); given TagEntryImpl(Key, boolean, boolean) with key is randomKey and isTag is 'true' and isRequired is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.setTag(TagKey, Collection)"})
  void testSetTag_givenTagEntryImplWithKeyIsRandomKeyAndIsTagIsTrueAndIsRequiredIsTrue() {
    // Arrange
    PluginBootstrapContextImpl owner = mock(PluginBootstrapContextImpl.class);
    when(owner.getPluginMeta()).thenThrow(new NoSuchElementException());
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);
    paperPreFlattenTagRegistrar.setCurrentContext(owner);

    ArrayList<TagEntry<Object>> entries = new ArrayList<>();
    entries.add(new TagEntryImpl<>(NamespacedKey.randomKey(), true, true));

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> paperPreFlattenTagRegistrar.setTag(null, entries));
    verify(owner).getPluginMeta();
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@link TagEntry} {@link TagEntry#isRequired()} return {@code false}.
   *   <li>Then calls {@link TagEntry#isRequired()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test setTag(TagKey, Collection); given TagEntry isRequired() return 'false'; then calls isRequired()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.setTag(TagKey, Collection)"})
  void testSetTag_givenTagEntryIsRequiredReturnFalse_thenCallsIsRequired() {
    // Arrange
    PluginBootstrapContextImpl owner = mock(PluginBootstrapContextImpl.class);
    when(owner.getPluginMeta()).thenThrow(new NoSuchElementException());
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);
    paperPreFlattenTagRegistrar.setCurrentContext(owner);

    TagEntry<Object> tagEntry = mock(TagEntry.class);
    when(tagEntry.isRequired()).thenReturn(false);
    when(tagEntry.isTag()).thenReturn(false);
    when(tagEntry.key()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);

    ArrayList<TagEntry<Object>> entries = new ArrayList<>();
    entries.add(tagEntry);

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> paperPreFlattenTagRegistrar.setTag(null, entries));
    verify(owner).getPluginMeta();
    verify(tagEntry).isRequired();
    verify(tagEntry).isTag();
    verify(tagEntry).key();
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@link TagEntry} {@link TagEntry#isRequired()} return {@code true}.
   *   <li>Then calls {@link TagEntry#isRequired()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test setTag(TagKey, Collection); given TagEntry isRequired() return 'true'; then calls isRequired()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.setTag(TagKey, Collection)"})
  void testSetTag_givenTagEntryIsRequiredReturnTrue_thenCallsIsRequired() {
    // Arrange
    PluginBootstrapContextImpl owner = mock(PluginBootstrapContextImpl.class);
    when(owner.getPluginMeta()).thenThrow(new NoSuchElementException());
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);
    paperPreFlattenTagRegistrar.setCurrentContext(owner);

    TagEntry<Object> tagEntry = mock(TagEntry.class);
    when(tagEntry.isRequired()).thenReturn(true);
    when(tagEntry.isTag()).thenReturn(false);
    when(tagEntry.key()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);

    ArrayList<TagEntry<Object>> entries = new ArrayList<>();
    entries.add(tagEntry);

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> paperPreFlattenTagRegistrar.setTag(null, entries));
    verify(owner).getPluginMeta();
    verify(tagEntry).isRequired();
    verify(tagEntry).isTag();
    verify(tagEntry).key();
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@link TagEntry} {@link TagEntry#isTag()} return {@code true}.
   *   <li>Then calls {@link TagEntry#isRequired()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test setTag(TagKey, Collection); given TagEntry isTag() return 'true'; then calls isRequired()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.setTag(TagKey, Collection)"})
  void testSetTag_givenTagEntryIsTagReturnTrue_thenCallsIsRequired() {
    // Arrange
    PluginBootstrapContextImpl owner = mock(PluginBootstrapContextImpl.class);
    when(owner.getPluginMeta()).thenThrow(new NoSuchElementException());
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);
    paperPreFlattenTagRegistrar.setCurrentContext(owner);

    TagEntry<Object> tagEntry = mock(TagEntry.class);
    when(tagEntry.isRequired()).thenReturn(false);
    when(tagEntry.isTag()).thenReturn(true);
    when(tagEntry.key()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);

    ArrayList<TagEntry<Object>> entries = new ArrayList<>();
    entries.add(tagEntry);

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> paperPreFlattenTagRegistrar.setTag(null, entries));
    verify(owner).getPluginMeta();
    verify(tagEntry).isRequired();
    verify(tagEntry).isTag();
    verify(tagEntry).key();
  }

  /**
   * Test {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@link TagEntry} {@link TagEntry#isTag()} throw {@link
   *       NoSuchElementException#NoSuchElementException()}.
   *   <li>Then calls {@link TagEntry#isTag()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPreFlattenTagRegistrar#setTag(TagKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test setTag(TagKey, Collection); given TagEntry isTag() throw NoSuchElementException(); then calls isTag()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPreFlattenTagRegistrar.setTag(TagKey, Collection)"})
  void testSetTag_givenTagEntryIsTagThrowNoSuchElementException_thenCallsIsTag() {
    // Arrange
    HashMap<ResourceLocation, List<EntryWithSource>> tags = new HashMap<>();
    TagEventConfig<?, Object> config =
        new TagEventConfig<>(
            null, null, Cause.INITIAL, mock(Function.class), mock(Function.class), null);

    PaperPreFlattenTagRegistrar<Object> paperPreFlattenTagRegistrar =
        new PaperPreFlattenTagRegistrar<>(tags, config);
    paperPreFlattenTagRegistrar.setCurrentContext(mock(PluginBootstrapContextImpl.class));

    TagEntry<Object> tagEntry = mock(TagEntry.class);
    when(tagEntry.isTag()).thenThrow(new NoSuchElementException());
    when(tagEntry.key()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);

    ArrayList<TagEntry<Object>> entries = new ArrayList<>();
    entries.add(tagEntry);

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> paperPreFlattenTagRegistrar.setTag(null, entries));
    verify(tagEntry).isTag();
    verify(tagEntry).key();
  }
}
