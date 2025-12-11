package io.papermc.paper.registry.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.adventure.AdventureComponent;
import io.papermc.paper.adventure.providers.ClickCallbackProviderImpl;
import io.papermc.paper.registry.data.PaintingVariantRegistryEntry.Builder;
import io.papermc.paper.registry.data.PaperPaintingVariantRegistryEntry.PaperBuilder;
import io.papermc.paper.registry.data.util.Conversions;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.kyori.adventure.key.Key;
import net.kyori.examination.ExaminableProperty;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPaintingVariantRegistryEntryDiffblueTest {
  /**
   * Test {@link PaperPaintingVariantRegistryEntry#PaperPaintingVariantRegistryEntry(Conversions,
   * PaintingVariant)}.
   *
   * <ul>
   *   <li>Then {@link PaperPaintingVariantRegistryEntry#author} return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperPaintingVariantRegistryEntry#PaperPaintingVariantRegistryEntry(Conversions,
   * PaintingVariant)}
   */
  @Test
  @DisplayName(
      "Test new PaperPaintingVariantRegistryEntry(Conversions, PaintingVariant); then author return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPaintingVariantRegistryEntry.<init>(Conversions, PaintingVariant)"})
  void testNewPaperPaintingVariantRegistryEntry_thenAuthorReturnAdventureComponent() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));

    PaintingVariant internal = new PaintingVariant(1, 1, assetId, title, author);

    // Act
    PaperPaintingVariantRegistryEntry actualPaperPaintingVariantRegistryEntry =
        new PaperPaintingVariantRegistryEntry(conversions, internal);

    // Assert
    assertTrue(actualPaperPaintingVariantRegistryEntry.author instanceof AdventureComponent);
    assertTrue(actualPaperPaintingVariantRegistryEntry.title instanceof AdventureComponent);
    ResourceLocation resourceLocation = actualPaperPaintingVariantRegistryEntry.assetId;
    assertEquals("argument.id.invalid", resourceLocation.getPath());
    assertEquals("argument.id.invalid", resourceLocation.toShortLanguageKey());
    assertEquals("minecraft", resourceLocation.getNamespace());
    OptionalInt optionalInt = actualPaperPaintingVariantRegistryEntry.height;
    assertEquals(1, optionalInt.getAsInt());
    assertFalse(optionalInt.isEmpty());
    assertTrue(optionalInt.isPresent());
    OptionalInt expectedOptionalInt = actualPaperPaintingVariantRegistryEntry.height;
    assertEquals(expectedOptionalInt, actualPaperPaintingVariantRegistryEntry.width);
    ResourceLocation expectedAssetIdResult = actualPaperPaintingVariantRegistryEntry.assetId;
    assertSame(expectedAssetIdResult, internal.assetId());
    Component expectedGetResult = actualPaperPaintingVariantRegistryEntry.author;
    assertSame(expectedGetResult, internal.author().get());
    Component expectedGetResult2 = actualPaperPaintingVariantRegistryEntry.title;
    assertSame(expectedGetResult2, internal.title().get());
  }

  /**
   * Test {@link PaperPaintingVariantRegistryEntry#PaperPaintingVariantRegistryEntry(Conversions,
   * PaintingVariant)}.
   *
   * <ul>
   *   <li>Then return {@link PaperPaintingVariantRegistryEntry#author} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperPaintingVariantRegistryEntry#PaperPaintingVariantRegistryEntry(Conversions,
   * PaintingVariant)}
   */
  @Test
  @DisplayName(
      "Test new PaperPaintingVariantRegistryEntry(Conversions, PaintingVariant); then return author is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPaintingVariantRegistryEntry.<init>(Conversions, PaintingVariant)"})
  void testNewPaperPaintingVariantRegistryEntry_thenReturnAuthorIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperPaintingVariantRegistryEntry actualPaperPaintingVariantRegistryEntry =
        new PaperPaintingVariantRegistryEntry(conversions, null);

    // Assert
    assertNull(actualPaperPaintingVariantRegistryEntry.author);
    assertNull(actualPaperPaintingVariantRegistryEntry.title);
    assertNull(actualPaperPaintingVariantRegistryEntry.assetId);
    OptionalInt optionalInt = actualPaperPaintingVariantRegistryEntry.height;
    assertFalse(optionalInt.isPresent());
    OptionalInt optionalInt2 = actualPaperPaintingVariantRegistryEntry.width;
    assertFalse(optionalInt2.isPresent());
    assertTrue(optionalInt.isEmpty());
    assertTrue(optionalInt2.isEmpty());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#assetId(Key)} with {@code Key}.
   *
   * <p>Method under test: {@link PaperBuilder#assetId(Key)}
   */
  @Test
  @DisplayName("Test PaperBuilder assetId(Key) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.assetId(Key)"})
  void testPaperBuilderAssetIdWithKey() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act
    Builder actualAssetIdResult = paperBuilder.assetId(ServerBuildInfo.BRAND_PAPER_ID);

    // Assert
    assertTrue(actualAssetIdResult instanceof PaperBuilder);
    ResourceLocation resourceLocation = paperBuilder.assetId;
    assertEquals("paper", resourceLocation.getPath());
    ResourceLocation resourceLocation2 = ((PaperBuilder) actualAssetIdResult).assetId;
    assertEquals("paper", resourceLocation2.getPath());
    assertEquals("papermc", resourceLocation.getNamespace());
    assertEquals("papermc", resourceLocation2.getNamespace());
    assertEquals("papermc.paper", resourceLocation.toShortLanguageKey());
    assertEquals("papermc.paper", resourceLocation2.toShortLanguageKey());
    OptionalInt optionalInt = ((PaperPaintingVariantRegistryEntry) actualAssetIdResult).height;
    assertEquals(optionalInt, paperBuilder.width);
    assertEquals(optionalInt, ((PaperBuilder) actualAssetIdResult).width);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#assetId(Key)} with {@code Key}.
   *
   * <p>Method under test: {@link PaperBuilder#assetId(Key)}
   */
  @Test
  @DisplayName("Test PaperBuilder assetId(Key) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.assetId(Key)"})
  void testPaperBuilderAssetIdWithKey2() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act
    Builder actualAssetIdResult =
        paperBuilder.assetId(ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY);

    // Assert
    assertTrue(actualAssetIdResult instanceof PaperBuilder);
    ResourceLocation resourceLocation = paperBuilder.assetId;
    assertEquals("dialog_click_callback", resourceLocation.getPath());
    ResourceLocation resourceLocation2 = ((PaperBuilder) actualAssetIdResult).assetId;
    assertEquals("dialog_click_callback", resourceLocation2.getPath());
    assertEquals("paper", resourceLocation.getNamespace());
    assertEquals("paper", resourceLocation2.getNamespace());
    assertEquals("paper.dialog_click_callback", resourceLocation.toShortLanguageKey());
    assertEquals("paper.dialog_click_callback", resourceLocation2.toShortLanguageKey());
    OptionalInt optionalInt = ((PaperPaintingVariantRegistryEntry) actualAssetIdResult).height;
    assertEquals(optionalInt, paperBuilder.width);
    assertEquals(optionalInt, ((PaperBuilder) actualAssetIdResult).width);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#assetId(Key)} with {@code Key}.
   *
   * <p>Method under test: {@link PaperBuilder#assetId(Key)}
   */
  @Test
  @DisplayName("Test PaperBuilder assetId(Key) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.assetId(Key)"})
  void testPaperBuilderAssetIdWithKey3() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act
    Builder actualAssetIdResult = paperBuilder.assetId(NamespacedKey.randomKey());

    // Assert
    assertTrue(actualAssetIdResult instanceof PaperBuilder);
    assertEquals("bukkit", paperBuilder.assetId.getNamespace());
    assertEquals("bukkit", ((PaperBuilder) actualAssetIdResult).assetId.getNamespace());
    OptionalInt optionalInt = ((PaperPaintingVariantRegistryEntry) actualAssetIdResult).height;
    assertEquals(optionalInt, paperBuilder.width);
    assertEquals(optionalInt, ((PaperBuilder) actualAssetIdResult).width);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#height(int)} with {@code int}.
   *
   * <p>Method under test: {@link PaperBuilder#height(int)}
   */
  @Test
  @DisplayName("Test PaperBuilder height(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.height(int)"})
  void testPaperBuilderHeightWithInt() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act
    Builder actualHeightResult = paperBuilder.height(1);

    // Assert
    assertEquals(
        ((PaperPaintingVariantRegistryEntry) actualHeightResult).height, paperBuilder.width);
    assertSame(paperBuilder, actualHeightResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, PaintingVariant)}.
   *
   * <ul>
   *   <li>Then {@link PaperPaintingVariantRegistryEntry#author} return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, PaintingVariant)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, PaintingVariant); then author return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, PaintingVariant)"})
  void testPaperBuilderNewPaperBuilder_thenAuthorReturnAdventureComponent() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));

    PaintingVariant internal = new PaintingVariant(1, 1, assetId, title, author);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, internal);

    // Assert
    assertTrue(actualPaperBuilder.author instanceof AdventureComponent);
    assertTrue(actualPaperBuilder.title instanceof AdventureComponent);
    ResourceLocation resourceLocation = actualPaperBuilder.assetId;
    assertEquals("argument.id.invalid", resourceLocation.getPath());
    assertEquals("argument.id.invalid", resourceLocation.toShortLanguageKey());
    assertEquals("minecraft", resourceLocation.getNamespace());
    OptionalInt optionalInt = actualPaperBuilder.height;
    assertEquals(1, optionalInt.getAsInt());
    assertFalse(optionalInt.isEmpty());
    assertTrue(optionalInt.isPresent());
    OptionalInt expectedOptionalInt = actualPaperBuilder.height;
    assertEquals(expectedOptionalInt, actualPaperBuilder.width);
    ResourceLocation expectedAssetIdResult = actualPaperBuilder.assetId;
    assertSame(expectedAssetIdResult, internal.assetId());
    Component expectedGetResult = actualPaperBuilder.author;
    assertSame(expectedGetResult, internal.author().get());
    Component expectedGetResult2 = actualPaperBuilder.title;
    assertSame(expectedGetResult2, internal.title().get());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, PaintingVariant)}.
   *
   * <ul>
   *   <li>Then return {@link PaperPaintingVariantRegistryEntry#author} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, PaintingVariant)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, PaintingVariant); then return author is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, PaintingVariant)"})
  void testPaperBuilderNewPaperBuilder_thenReturnAuthorIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, null);

    // Assert
    assertNull(actualPaperBuilder.author);
    assertNull(actualPaperBuilder.title);
    assertNull(actualPaperBuilder.assetId);
    OptionalInt optionalInt = actualPaperBuilder.height;
    assertFalse(optionalInt.isPresent());
    OptionalInt optionalInt2 = actualPaperBuilder.width;
    assertFalse(optionalInt2.isPresent());
    assertTrue(optionalInt.isEmpty());
    assertTrue(optionalInt2.isEmpty());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#width(int)} with {@code int}.
   *
   * <p>Method under test: {@link PaperBuilder#width(int)}
   */
  @Test
  @DisplayName("Test PaperBuilder width(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.width(int)"})
  void testPaperBuilderWidthWithInt() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act
    Builder actualWidthResult = paperBuilder.width(1);

    // Assert
    assertEquals(
        ((PaperPaintingVariantRegistryEntry) actualWidthResult).height, paperBuilder.width);
    assertSame(paperBuilder, actualWidthResult);
  }

  /**
   * Test {@link PaperPaintingVariantRegistryEntry#width()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPaintingVariantRegistryEntry#width()}
   */
  @Test
  @DisplayName("Test width(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperPaintingVariantRegistryEntry.width()"})
  void testWidth_thenReturnOne() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperPaintingVariantRegistryEntry paperPaintingVariantRegistryEntry =
        new PaperPaintingVariantRegistryEntry(
            conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act and Assert
    assertEquals(1, paperPaintingVariantRegistryEntry.width());
  }

  /**
   * Test {@link PaperPaintingVariantRegistryEntry#height()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPaintingVariantRegistryEntry#height()}
   */
  @Test
  @DisplayName("Test height(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperPaintingVariantRegistryEntry.height()"})
  void testHeight_thenReturnOne() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperPaintingVariantRegistryEntry paperPaintingVariantRegistryEntry =
        new PaperPaintingVariantRegistryEntry(
            conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act and Assert
    assertEquals(1, paperPaintingVariantRegistryEntry.height());
  }

  /**
   * Test {@link PaperPaintingVariantRegistryEntry#title()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPaintingVariantRegistryEntry#title()}
   */
  @Test
  @DisplayName("Test title(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.kyori.adventure.text.Component PaperPaintingVariantRegistryEntry.title()"
  })
  void testTitle_thenReturnNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title = Optional.empty();
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperPaintingVariantRegistryEntry paperPaintingVariantRegistryEntry =
        new PaperPaintingVariantRegistryEntry(
            conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act and Assert
    assertNull(paperPaintingVariantRegistryEntry.title());
  }

  /**
   * Test {@link PaperPaintingVariantRegistryEntry#author()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPaintingVariantRegistryEntry#author()}
   */
  @Test
  @DisplayName("Test author(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.kyori.adventure.text.Component PaperPaintingVariantRegistryEntry.author()"
  })
  void testAuthor_thenReturnNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author = Optional.empty();
    PaperPaintingVariantRegistryEntry paperPaintingVariantRegistryEntry =
        new PaperPaintingVariantRegistryEntry(
            conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act and Assert
    assertNull(paperPaintingVariantRegistryEntry.author());
  }

  /**
   * Test {@link PaperPaintingVariantRegistryEntry#assetId()}.
   *
   * <ul>
   *   <li>Then return examinableName is {@code KeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPaintingVariantRegistryEntry#assetId()}
   */
  @Test
  @DisplayName("Test assetId(); then return examinableName is 'KeyImpl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperPaintingVariantRegistryEntry.assetId()"})
  void testAssetId_thenReturnExaminableNameIsKeyImpl() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation assetId = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Component> title =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    Optional<Component> author =
        Optional.of(new AdventureComponent(mock(net.kyori.adventure.text.Component.class)));
    PaperPaintingVariantRegistryEntry paperPaintingVariantRegistryEntry =
        new PaperPaintingVariantRegistryEntry(
            conversions, new PaintingVariant(1, 1, assetId, title, author));

    // Act
    Key actualAssetIdResult = paperPaintingVariantRegistryEntry.assetId();

    // Assert
    assertEquals("KeyImpl", actualAssetIdResult.examinableName());
    assertEquals("argument.id.invalid", actualAssetIdResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualAssetIdResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }
}
