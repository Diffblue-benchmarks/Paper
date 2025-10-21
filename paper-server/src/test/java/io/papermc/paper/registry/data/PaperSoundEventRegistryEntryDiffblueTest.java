package io.papermc.paper.registry.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.adventure.providers.ClickCallbackProviderImpl;
import io.papermc.paper.registry.data.PaperSoundEventRegistryEntry.PaperBuilder;
import io.papermc.paper.registry.data.SoundEventRegistryEntry.Builder;
import io.papermc.paper.registry.data.util.Conversions;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.kyori.adventure.key.Key;
import net.kyori.examination.ExaminableProperty;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.RegistryOps.RegistryInfoLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperSoundEventRegistryEntryDiffblueTest {
  /**
   * Test {@link PaperSoundEventRegistryEntry#PaperSoundEventRegistryEntry(Conversions,
   * SoundEvent)}.
   *
   * <p>Method under test: {@link
   * PaperSoundEventRegistryEntry#PaperSoundEventRegistryEntry(Conversions, SoundEvent)}
   */
  @Test
  @DisplayName("Test new PaperSoundEventRegistryEntry(Conversions, SoundEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperSoundEventRegistryEntry.<init>(Conversions, SoundEvent)"})
  void testNewPaperSoundEventRegistryEntry() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperSoundEventRegistryEntry actualPaperSoundEventRegistryEntry =
        new PaperSoundEventRegistryEntry(conversions, null);

    // Assert
    RegistryInfoLookup lookupResult = actualPaperSoundEventRegistryEntry.conversions.lookup();
    assertTrue(lookupResult instanceof HolderLookupAdapter);
    assertNull(actualPaperSoundEventRegistryEntry.fixedRange());
    assertNull(actualPaperSoundEventRegistryEntry.fixedRange);
    assertNull(actualPaperSoundEventRegistryEntry.location);
    assertSame(lookup, lookupResult);
  }

  /**
   * Test {@link PaperSoundEventRegistryEntry#PaperSoundEventRegistryEntry(Conversions,
   * SoundEvent)}.
   *
   * <ul>
   *   <li>Then return {@link PaperSoundEventRegistryEntry#location} Path is {@code
   *       argument.id.invalid}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperSoundEventRegistryEntry#PaperSoundEventRegistryEntry(Conversions, SoundEvent)}
   */
  @Test
  @DisplayName(
      "Test new PaperSoundEventRegistryEntry(Conversions, SoundEvent); then return location Path is 'argument.id.invalid'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperSoundEventRegistryEntry.<init>(Conversions, SoundEvent)"})
  void testNewPaperSoundEventRegistryEntry_thenReturnLocationPathIsArgumentIdInvalid() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);

    // Act
    PaperSoundEventRegistryEntry actualPaperSoundEventRegistryEntry =
        new PaperSoundEventRegistryEntry(conversions, soundEvent);

    // Assert
    ResourceLocation resourceLocation = actualPaperSoundEventRegistryEntry.location;
    assertEquals("argument.id.invalid", resourceLocation.getPath());
    assertEquals("argument.id.invalid", resourceLocation.toShortLanguageKey());
    assertEquals("minecraft", resourceLocation.getNamespace());
    assertEquals(10.0f, actualPaperSoundEventRegistryEntry.fixedRange().floatValue());
    assertEquals(10.0f, actualPaperSoundEventRegistryEntry.fixedRange.floatValue());
    ResourceLocation expectedLocationResult = actualPaperSoundEventRegistryEntry.location;
    assertSame(expectedLocationResult, soundEvent.location());
  }

  /**
   * Test {@link PaperSoundEventRegistryEntry#location()}.
   *
   * <ul>
   *   <li>Then return examinableName is {@code KeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSoundEventRegistryEntry#location()}
   */
  @Test
  @DisplayName("Test location(); then return examinableName is 'KeyImpl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperSoundEventRegistryEntry.location()"})
  void testLocation_thenReturnExaminableNameIsKeyImpl() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);

    PaperSoundEventRegistryEntry paperSoundEventRegistryEntry =
        new PaperSoundEventRegistryEntry(conversions, soundEvent);

    // Act
    Key actualLocationResult = paperSoundEventRegistryEntry.location();

    // Assert
    assertEquals("KeyImpl", actualLocationResult.examinableName());
    assertEquals("argument.id.invalid", actualLocationResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualLocationResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#location(Key)} with {@code Key}.
   *
   * <p>Method under test: {@link PaperBuilder#location(Key)}
   */
  @Test
  @DisplayName("Test PaperBuilder location(Key) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.location(Key)"})
  void testPaperBuilderLocationWithKey() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);

    PaperBuilder paperBuilder = new PaperBuilder(conversions, soundEvent);

    // Act
    Builder actualLocationResult = paperBuilder.location(ServerBuildInfo.BRAND_PAPER_ID);

    // Assert
    assertTrue(actualLocationResult instanceof PaperBuilder);
    ResourceLocation resourceLocation = paperBuilder.location;
    assertEquals("paper", resourceLocation.getPath());
    ResourceLocation resourceLocation2 = ((PaperBuilder) actualLocationResult).location;
    assertEquals("paper", resourceLocation2.getPath());
    assertEquals("papermc", resourceLocation.getNamespace());
    assertEquals("papermc", resourceLocation2.getNamespace());
    assertEquals("papermc.paper", resourceLocation.toShortLanguageKey());
    assertEquals("papermc.paper", resourceLocation2.toShortLanguageKey());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#location(Key)} with {@code Key}.
   *
   * <p>Method under test: {@link PaperBuilder#location(Key)}
   */
  @Test
  @DisplayName("Test PaperBuilder location(Key) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.location(Key)"})
  void testPaperBuilderLocationWithKey2() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);

    PaperBuilder paperBuilder = new PaperBuilder(conversions, soundEvent);

    // Act
    Builder actualLocationResult =
        paperBuilder.location(ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY);

    // Assert
    assertTrue(actualLocationResult instanceof PaperBuilder);
    ResourceLocation resourceLocation = paperBuilder.location;
    assertEquals("dialog_click_callback", resourceLocation.getPath());
    ResourceLocation resourceLocation2 = ((PaperBuilder) actualLocationResult).location;
    assertEquals("dialog_click_callback", resourceLocation2.getPath());
    assertEquals("paper", resourceLocation.getNamespace());
    assertEquals("paper", resourceLocation2.getNamespace());
    assertEquals("paper.dialog_click_callback", resourceLocation.toShortLanguageKey());
    assertEquals("paper.dialog_click_callback", resourceLocation2.toShortLanguageKey());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#location(Key)} with {@code Key}.
   *
   * <p>Method under test: {@link PaperBuilder#location(Key)}
   */
  @Test
  @DisplayName("Test PaperBuilder location(Key) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.location(Key)"})
  void testPaperBuilderLocationWithKey3() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);

    PaperBuilder paperBuilder = new PaperBuilder(conversions, soundEvent);

    // Act
    Builder actualLocationResult = paperBuilder.location(NamespacedKey.randomKey());

    // Assert
    assertEquals("bukkit", paperBuilder.location.getNamespace());
    assertSame(paperBuilder, actualLocationResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, SoundEvent)}.
   *
   * <ul>
   *   <li>Then {@link PaperSoundEventRegistryEntry#conversions} lookup return {@link
   *       HolderLookupAdapter}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, SoundEvent)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, SoundEvent); then conversions lookup return HolderLookupAdapter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, SoundEvent)"})
  void testPaperBuilderNewPaperBuilder_thenConversionsLookupReturnHolderLookupAdapter() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, null);

    // Assert
    RegistryInfoLookup lookupResult = actualPaperBuilder.conversions.lookup();
    assertTrue(lookupResult instanceof HolderLookupAdapter);
    assertNull(actualPaperBuilder.fixedRange());
    assertNull(actualPaperBuilder.fixedRange);
    assertNull(actualPaperBuilder.location);
    assertSame(lookup, lookupResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, SoundEvent)}.
   *
   * <ul>
   *   <li>Then return {@link PaperSoundEventRegistryEntry#location} Path is {@code
   *       argument.id.invalid}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, SoundEvent)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, SoundEvent); then return location Path is 'argument.id.invalid'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, SoundEvent)"})
  void testPaperBuilderNewPaperBuilder_thenReturnLocationPathIsArgumentIdInvalid() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, soundEvent);

    // Assert
    ResourceLocation resourceLocation = actualPaperBuilder.location;
    assertEquals("argument.id.invalid", resourceLocation.getPath());
    assertEquals("argument.id.invalid", resourceLocation.toShortLanguageKey());
    assertEquals("minecraft", resourceLocation.getNamespace());
    assertEquals(10.0f, actualPaperBuilder.fixedRange().floatValue());
    assertEquals(10.0f, actualPaperBuilder.fixedRange.floatValue());
    ResourceLocation expectedLocationResult = actualPaperBuilder.location;
    assertSame(expectedLocationResult, soundEvent.location());
  }
}
