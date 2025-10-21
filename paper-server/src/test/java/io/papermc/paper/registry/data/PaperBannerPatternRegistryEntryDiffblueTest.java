package io.papermc.paper.registry.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.adventure.providers.ClickCallbackProviderImpl;
import io.papermc.paper.registry.data.BannerPatternRegistryEntry.Builder;
import io.papermc.paper.registry.data.PaperBannerPatternRegistryEntry.PaperBuilder;
import io.papermc.paper.registry.data.util.Conversions;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.kyori.adventure.key.Key;
import net.kyori.examination.ExaminableProperty;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperBannerPatternRegistryEntryDiffblueTest {
  /**
   * Test {@link PaperBannerPatternRegistryEntry#PaperBannerPatternRegistryEntry(Conversions,
   * BannerPattern)}.
   *
   * <ul>
   *   <li>Then return {@code Translation Key}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperBannerPatternRegistryEntry#PaperBannerPatternRegistryEntry(Conversions, BannerPattern)}
   */
  @Test
  @DisplayName(
      "Test new PaperBannerPatternRegistryEntry(Conversions, BannerPattern); then return 'Translation Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBannerPatternRegistryEntry.<init>(Conversions, BannerPattern)"})
  void testNewPaperBannerPatternRegistryEntry_thenReturnTranslationKey() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions ignoredConversions = new Conversions(lookup);
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    // Act
    PaperBannerPatternRegistryEntry actualPaperBannerPatternRegistryEntry =
        new PaperBannerPatternRegistryEntry(ignoredConversions, internal);

    // Assert
    assertEquals("Translation Key", actualPaperBannerPatternRegistryEntry.translationKey);
    ResourceLocation resourceLocation = actualPaperBannerPatternRegistryEntry.assetId;
    assertEquals("argument.id.invalid", resourceLocation.getPath());
    assertEquals("argument.id.invalid", resourceLocation.toShortLanguageKey());
    assertEquals("minecraft", resourceLocation.getNamespace());
    ResourceLocation expectedAssetIdResult = actualPaperBannerPatternRegistryEntry.assetId;
    assertSame(expectedAssetIdResult, internal.assetId());
  }

  /**
   * Test {@link PaperBannerPatternRegistryEntry#PaperBannerPatternRegistryEntry(Conversions,
   * BannerPattern)}.
   *
   * <ul>
   *   <li>Then return {@link PaperBannerPatternRegistryEntry#translationKey} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperBannerPatternRegistryEntry#PaperBannerPatternRegistryEntry(Conversions, BannerPattern)}
   */
  @Test
  @DisplayName(
      "Test new PaperBannerPatternRegistryEntry(Conversions, BannerPattern); then return translationKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBannerPatternRegistryEntry.<init>(Conversions, BannerPattern)"})
  void testNewPaperBannerPatternRegistryEntry_thenReturnTranslationKeyIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions ignoredConversions = new Conversions(lookup);

    // Act
    PaperBannerPatternRegistryEntry actualPaperBannerPatternRegistryEntry =
        new PaperBannerPatternRegistryEntry(ignoredConversions, null);

    // Assert
    assertNull(actualPaperBannerPatternRegistryEntry.translationKey);
    assertNull(actualPaperBannerPatternRegistryEntry.assetId);
  }

  /**
   * Test {@link PaperBannerPatternRegistryEntry#assetId()}.
   *
   * <p>Method under test: {@link PaperBannerPatternRegistryEntry#assetId()}
   */
  @Test
  @DisplayName("Test assetId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperBannerPatternRegistryEntry.assetId()"})
  void testAssetId() {
    // Arrange
    ArrayList<Registry<?>> registries = new ArrayList<>();
    DefaultedMappedRegistry<?> defaultedMappedRegistry =
        new DefaultedMappedRegistry<>("42", mock(ResourceKey.class), mock(Lifecycle.class), true);
    registries.add(defaultedMappedRegistry);
    HolderLookupAdapter lookup = new HolderLookupAdapter(new ImmutableRegistryAccess(registries));
    Conversions ignoredConversions = new Conversions(lookup);
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    PaperBannerPatternRegistryEntry paperBannerPatternRegistryEntry =
        new PaperBannerPatternRegistryEntry(ignoredConversions, internal);

    // Act
    Key actualAssetIdResult = paperBannerPatternRegistryEntry.assetId();

    // Assert
    assertEquals("KeyImpl", actualAssetIdResult.examinableName());
    assertEquals("argument.id.invalid", actualAssetIdResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualAssetIdResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }

  /**
   * Test {@link PaperBannerPatternRegistryEntry#assetId()}.
   *
   * <ul>
   *   <li>Then return examinableName is {@code KeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBannerPatternRegistryEntry#assetId()}
   */
  @Test
  @DisplayName("Test assetId(); then return examinableName is 'KeyImpl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperBannerPatternRegistryEntry.assetId()"})
  void testAssetId_thenReturnExaminableNameIsKeyImpl() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions ignoredConversions = new Conversions(lookup);
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    PaperBannerPatternRegistryEntry paperBannerPatternRegistryEntry =
        new PaperBannerPatternRegistryEntry(ignoredConversions, internal);

    // Act
    Key actualAssetIdResult = paperBannerPatternRegistryEntry.assetId();

    // Assert
    assertEquals("KeyImpl", actualAssetIdResult.examinableName());
    assertEquals("argument.id.invalid", actualAssetIdResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualAssetIdResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
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
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    PaperBuilder paperBuilder = new PaperBuilder(conversions, internal);

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
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    PaperBuilder paperBuilder = new PaperBuilder(conversions, internal);

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
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    PaperBuilder paperBuilder = new PaperBuilder(conversions, internal);

    // Act
    Builder actualAssetIdResult = paperBuilder.assetId(NamespacedKey.randomKey());

    // Assert
    assertEquals("bukkit", paperBuilder.assetId.getNamespace());
    assertSame(paperBuilder, actualAssetIdResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, BannerPattern)}.
   *
   * <ul>
   *   <li>Then return {@code Translation Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, BannerPattern)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, BannerPattern); then return 'Translation Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, BannerPattern)"})
  void testPaperBuilderNewPaperBuilder_thenReturnTranslationKey() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, internal);

    // Assert
    assertEquals("Translation Key", actualPaperBuilder.translationKey);
    ResourceLocation resourceLocation = actualPaperBuilder.assetId;
    assertEquals("argument.id.invalid", resourceLocation.getPath());
    assertEquals("argument.id.invalid", resourceLocation.toShortLanguageKey());
    assertEquals("minecraft", resourceLocation.getNamespace());
    ResourceLocation expectedAssetIdResult = actualPaperBuilder.assetId;
    assertSame(expectedAssetIdResult, internal.assetId());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, BannerPattern)}.
   *
   * <ul>
   *   <li>Then return {@link PaperBannerPatternRegistryEntry#translationKey} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, BannerPattern)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, BannerPattern); then return translationKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, BannerPattern)"})
  void testPaperBuilderNewPaperBuilder_thenReturnTranslationKeyIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, null);

    // Assert
    assertNull(actualPaperBuilder.translationKey);
    assertNull(actualPaperBuilder.assetId);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#translationKey(String)} with {@code String}.
   *
   * <p>Method under test: {@link PaperBuilder#translationKey(String)}
   */
  @Test
  @DisplayName("Test PaperBuilder translationKey(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.translationKey(String)"})
  void testPaperBuilderTranslationKeyWithString() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    PaperBuilder paperBuilder = new PaperBuilder(conversions, internal);

    // Act
    Builder actualTranslationKeyResult = paperBuilder.translationKey("Translation Key");

    // Assert
    assertSame(paperBuilder, actualTranslationKeyResult);
  }

  /**
   * Test {@link PaperBannerPatternRegistryEntry#translationKey()}.
   *
   * <ul>
   *   <li>Then return {@code Translation Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBannerPatternRegistryEntry#translationKey()}
   */
  @Test
  @DisplayName("Test translationKey(); then return 'Translation Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperBannerPatternRegistryEntry.translationKey()"})
  void testTranslationKey_thenReturnTranslationKey() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions ignoredConversions = new Conversions(lookup);
    BannerPattern internal =
        new BannerPattern(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"), "Translation Key");

    PaperBannerPatternRegistryEntry paperBannerPatternRegistryEntry =
        new PaperBannerPatternRegistryEntry(ignoredConversions, internal);

    // Act and Assert
    assertEquals("Translation Key", paperBannerPatternRegistryEntry.translationKey());
  }
}
