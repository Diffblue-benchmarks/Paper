package io.papermc.paper.registry.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.adventure.AdventureComponent;
import io.papermc.paper.registry.PaperRegistryBuilder;
import io.papermc.paper.registry.PaperRegistryBuilderFactory;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.data.InstrumentRegistryEntry.Builder;
import io.papermc.paper.registry.data.PaperInstrumentRegistryEntry.PaperBuilder;
import io.papermc.paper.registry.data.util.Conversions;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Direct;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Instrument;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class PaperInstrumentRegistryEntryDiffblueTest {
  /**
   * Test {@link PaperInstrumentRegistryEntry#PaperInstrumentRegistryEntry(Conversions,
   * Instrument)}.
   *
   * <ul>
   *   <li>Then {@link PaperInstrumentRegistryEntry#description} return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperInstrumentRegistryEntry#PaperInstrumentRegistryEntry(Conversions, Instrument)}
   */
  @Test
  @DisplayName(
      "Test new PaperInstrumentRegistryEntry(Conversions, Instrument); then description return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperInstrumentRegistryEntry.<init>(Conversions, Instrument)"})
  void testNewPaperInstrumentRegistryEntry_thenDescriptionReturnAdventureComponent() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    Instrument internal = new Instrument(soundEvent2, 10.0f, 10.0f, description);

    // Act
    PaperInstrumentRegistryEntry actualPaperInstrumentRegistryEntry =
        new PaperInstrumentRegistryEntry(conversions, internal);

    // Assert
    assertTrue(actualPaperInstrumentRegistryEntry.description instanceof AdventureComponent);
    Holder<SoundEvent> holder = actualPaperInstrumentRegistryEntry.soundEvent;
    assertTrue(holder instanceof Direct);
    assertEquals("[unregistered]", holder.getRegisteredName());
    assertEquals(10.0f, actualPaperInstrumentRegistryEntry.range.floatValue());
    assertEquals(10.0f, actualPaperInstrumentRegistryEntry.useDuration.floatValue());
    assertSame(soundEvent, holder.value());
    net.minecraft.network.chat.Component expectedDescriptionResult =
        actualPaperInstrumentRegistryEntry.description;
    assertSame(expectedDescriptionResult, internal.description());
    Holder<SoundEvent> expectedSoundEventResult = actualPaperInstrumentRegistryEntry.soundEvent;
    assertSame(expectedSoundEventResult, internal.soundEvent());
  }

  /**
   * Test {@link PaperInstrumentRegistryEntry#PaperInstrumentRegistryEntry(Conversions,
   * Instrument)}.
   *
   * <ul>
   *   <li>Then return {@link PaperInstrumentRegistryEntry#range} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperInstrumentRegistryEntry#PaperInstrumentRegistryEntry(Conversions, Instrument)}
   */
  @Test
  @DisplayName(
      "Test new PaperInstrumentRegistryEntry(Conversions, Instrument); then return range is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperInstrumentRegistryEntry.<init>(Conversions, Instrument)"})
  void testNewPaperInstrumentRegistryEntry_thenReturnRangeIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperInstrumentRegistryEntry actualPaperInstrumentRegistryEntry =
        new PaperInstrumentRegistryEntry(conversions, null);

    // Assert
    assertNull(actualPaperInstrumentRegistryEntry.range);
    assertNull(actualPaperInstrumentRegistryEntry.useDuration);
    assertNull(actualPaperInstrumentRegistryEntry.soundEvent);
    assertNull(actualPaperInstrumentRegistryEntry.description);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#description(Component)} with {@code Component}.
   *
   * <p>Method under test: {@link PaperBuilder#description(Component)}
   */
  @Test
  @DisplayName("Test PaperBuilder description(Component) with 'Component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.description(Component)"})
  void testPaperBuilderDescriptionWithComponent() {
    // Arrange
    Conversions conversions = mock(Conversions.class);
    when(conversions.asVanilla(Mockito.<Component>any()))
        .thenReturn(new AdventureComponent(mock(Component.class)));
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new Instrument(soundEvent2, 10.0f, 10.0f, description));

    // Act
    Builder actualDescriptionResult = paperBuilder.description(mock(Component.class));

    // Assert
    verify(conversions).asVanilla(isA(Component.class));
    assertSame(paperBuilder, actualDescriptionResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#duration(float)} with {@code float}.
   *
   * <p>Method under test: {@link PaperBuilder#duration(float)}
   */
  @Test
  @DisplayName("Test PaperBuilder duration(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.duration(float)"})
  void testPaperBuilderDurationWithFloat() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new Instrument(soundEvent2, 10.0f, 10.0f, description));

    // Act
    Builder actualDurationResult = paperBuilder.duration(10.0f);

    // Assert
    assertSame(paperBuilder, actualDurationResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, Instrument)}.
   *
   * <ul>
   *   <li>Then {@link PaperInstrumentRegistryEntry#description} return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, Instrument)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, Instrument); then description return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, Instrument)"})
  void testPaperBuilderNewPaperBuilder_thenDescriptionReturnAdventureComponent() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    Instrument internal = new Instrument(soundEvent2, 10.0f, 10.0f, description);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, internal);

    // Assert
    assertTrue(actualPaperBuilder.description instanceof AdventureComponent);
    Holder<SoundEvent> holder = actualPaperBuilder.soundEvent;
    assertTrue(holder instanceof Direct);
    assertEquals("[unregistered]", holder.getRegisteredName());
    assertEquals(10.0f, actualPaperBuilder.range.floatValue());
    assertEquals(10.0f, actualPaperBuilder.useDuration.floatValue());
    assertSame(soundEvent, holder.value());
    net.minecraft.network.chat.Component expectedDescriptionResult = actualPaperBuilder.description;
    assertSame(expectedDescriptionResult, internal.description());
    Holder<SoundEvent> expectedSoundEventResult = actualPaperBuilder.soundEvent;
    assertSame(expectedSoundEventResult, internal.soundEvent());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, Instrument)}.
   *
   * <ul>
   *   <li>Then return {@link PaperInstrumentRegistryEntry#range} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, Instrument)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, Instrument); then return range is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, Instrument)"})
  void testPaperBuilderNewPaperBuilder_thenReturnRangeIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, null);

    // Assert
    assertNull(actualPaperBuilder.range);
    assertNull(actualPaperBuilder.useDuration);
    assertNull(actualPaperBuilder.soundEvent);
    assertNull(actualPaperBuilder.description);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#range(float)} with {@code float}.
   *
   * <p>Method under test: {@link PaperBuilder#range(float)}
   */
  @Test
  @DisplayName("Test PaperBuilder range(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.range(float)"})
  void testPaperBuilderRangeWithFloat() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new Instrument(soundEvent2, 10.0f, 10.0f, description));

    // Act
    Builder actualRangeResult = paperBuilder.range(10.0f);

    // Assert
    assertSame(paperBuilder, actualRangeResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#soundEvent(Consumer)} with {@code Consumer}.
   *
   * <p>Method under test: {@link PaperBuilder#soundEvent(Consumer)}
   */
  @Test
  @DisplayName("Test PaperBuilder soundEvent(Consumer) with 'Consumer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.soundEvent(Consumer)"})
  void testPaperBuilderSoundEventWithConsumer() {
    // Arrange
    Conversions conversions = mock(Conversions.class);
    when(conversions.createHolderFromBuilder(
            Mockito.<RegistryKey<Keyed>>any(),
            Mockito
                .<Consumer<
                        PaperRegistryBuilderFactory<
                            Object, Keyed, PaperRegistryBuilder<Object, Keyed>>>>
                    any()))
        .thenReturn(new Direct<>(ConfigurationTransformation.WILDCARD_OBJECT));
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    PaperBuilder paperBuilder =
        new PaperBuilder(conversions, new Instrument(soundEvent2, 10.0f, 10.0f, description));

    // Act
    Builder actualSoundEventResult = paperBuilder.soundEvent(mock(Consumer.class));

    // Assert
    verify(conversions).createHolderFromBuilder(isA(RegistryKey.class), isA(Consumer.class));
    assertSame(paperBuilder, actualSoundEventResult);
  }

  /**
   * Test {@link PaperInstrumentRegistryEntry#soundEvent()}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceKey#location()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperInstrumentRegistryEntry#soundEvent()}
   */
  @Test
  @DisplayName("Test soundEvent(); then calls location()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.registry.holder.RegistryHolder PaperInstrumentRegistryEntry.soundEvent()"
  })
  void testSoundEvent_thenCallsLocation() {
    // Arrange
    ResourceKey<SoundEvent> key = mock(ResourceKey.class);
    when(key.location()).thenReturn(ResourceLocation.withDefaultNamespace("argument.id.invalid"));
    when(key.registryKey()).thenReturn(Registries.SOUND_EVENT);
    Reference<SoundEvent> soundEvent = Reference.createStandAlone(mock(HolderOwner.class), key);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    Instrument internal = new Instrument(soundEvent, 10.0f, 10.0f, description);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    PaperInstrumentRegistryEntry paperInstrumentRegistryEntry =
        new PaperInstrumentRegistryEntry(conversions, internal);

    // Act
    paperInstrumentRegistryEntry.soundEvent();

    // Assert
    verify(key).location();
    verify(key).registryKey();
  }

  /**
   * Test {@link PaperInstrumentRegistryEntry#duration()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperInstrumentRegistryEntry#duration()}
   */
  @Test
  @DisplayName("Test duration(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperInstrumentRegistryEntry.duration()"})
  void testDuration_thenReturnTen() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    PaperInstrumentRegistryEntry paperInstrumentRegistryEntry =
        new PaperInstrumentRegistryEntry(
            conversions, new Instrument(soundEvent2, 10.0f, 10.0f, description));

    // Act and Assert
    assertEquals(10.0f, paperInstrumentRegistryEntry.duration());
  }

  /**
   * Test {@link PaperInstrumentRegistryEntry#range()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperInstrumentRegistryEntry#range()}
   */
  @Test
  @DisplayName("Test range(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperInstrumentRegistryEntry.range()"})
  void testRange_thenReturnTen() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    PaperInstrumentRegistryEntry paperInstrumentRegistryEntry =
        new PaperInstrumentRegistryEntry(
            conversions, new Instrument(soundEvent2, 10.0f, 10.0f, description));

    // Act and Assert
    assertEquals(10.0f, paperInstrumentRegistryEntry.range());
  }
}
