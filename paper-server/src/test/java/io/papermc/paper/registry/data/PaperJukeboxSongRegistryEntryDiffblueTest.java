package io.papermc.paper.registry.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import io.papermc.paper.registry.data.JukeboxSongRegistryEntry.Builder;
import io.papermc.paper.registry.data.PaperJukeboxSongRegistryEntry.PaperBuilder;
import io.papermc.paper.registry.data.util.Conversions;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;
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
import net.minecraft.world.item.JukeboxSong;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class PaperJukeboxSongRegistryEntryDiffblueTest {
  /**
   * Test {@link PaperJukeboxSongRegistryEntry#PaperJukeboxSongRegistryEntry(Conversions,
   * JukeboxSong)}.
   *
   * <ul>
   *   <li>Then {@link PaperJukeboxSongRegistryEntry#description} return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperJukeboxSongRegistryEntry#PaperJukeboxSongRegistryEntry(Conversions, JukeboxSong)}
   */
  @Test
  @DisplayName(
      "Test new PaperJukeboxSongRegistryEntry(Conversions, JukeboxSong); then description return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperJukeboxSongRegistryEntry.<init>(Conversions, JukeboxSong)"})
  void testNewPaperJukeboxSongRegistryEntry_thenDescriptionReturnAdventureComponent() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    JukeboxSong internal = new JukeboxSong(soundEvent2, description, 10.0f, 1);

    // Act
    PaperJukeboxSongRegistryEntry actualPaperJukeboxSongRegistryEntry =
        new PaperJukeboxSongRegistryEntry(conversions, internal);

    // Assert
    assertTrue(actualPaperJukeboxSongRegistryEntry.description instanceof AdventureComponent);
    Holder<SoundEvent> holder = actualPaperJukeboxSongRegistryEntry.soundEvent;
    assertTrue(holder instanceof Direct);
    assertEquals("[unregistered]", holder.getRegisteredName());
    OptionalInt optionalInt = actualPaperJukeboxSongRegistryEntry.comparatorOutput;
    assertEquals(1, optionalInt.getAsInt());
    assertEquals(10.0f, actualPaperJukeboxSongRegistryEntry.lengthInSeconds.floatValue());
    assertFalse(optionalInt.isEmpty());
    assertTrue(optionalInt.isPresent());
    assertSame(soundEvent, holder.value());
    net.minecraft.network.chat.Component expectedDescriptionResult =
        actualPaperJukeboxSongRegistryEntry.description;
    assertSame(expectedDescriptionResult, internal.description());
    Holder<SoundEvent> expectedSoundEventResult = actualPaperJukeboxSongRegistryEntry.soundEvent;
    assertSame(expectedSoundEventResult, internal.soundEvent());
  }

  /**
   * Test {@link PaperJukeboxSongRegistryEntry#PaperJukeboxSongRegistryEntry(Conversions,
   * JukeboxSong)}.
   *
   * <ul>
   *   <li>Then return {@link PaperJukeboxSongRegistryEntry#lengthInSeconds} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperJukeboxSongRegistryEntry#PaperJukeboxSongRegistryEntry(Conversions, JukeboxSong)}
   */
  @Test
  @DisplayName(
      "Test new PaperJukeboxSongRegistryEntry(Conversions, JukeboxSong); then return lengthInSeconds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperJukeboxSongRegistryEntry.<init>(Conversions, JukeboxSong)"})
  void testNewPaperJukeboxSongRegistryEntry_thenReturnLengthInSecondsIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperJukeboxSongRegistryEntry actualPaperJukeboxSongRegistryEntry =
        new PaperJukeboxSongRegistryEntry(conversions, null);

    // Assert
    assertNull(actualPaperJukeboxSongRegistryEntry.lengthInSeconds);
    assertNull(actualPaperJukeboxSongRegistryEntry.soundEvent);
    assertNull(actualPaperJukeboxSongRegistryEntry.description);
    OptionalInt optionalInt = actualPaperJukeboxSongRegistryEntry.comparatorOutput;
    assertFalse(optionalInt.isPresent());
    assertTrue(optionalInt.isEmpty());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#comparatorOutput(int)} with {@code int}.
   *
   * <p>Method under test: {@link PaperBuilder#comparatorOutput(int)}
   */
  @Test
  @DisplayName("Test PaperBuilder comparatorOutput(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.comparatorOutput(int)"})
  void testPaperBuilderComparatorOutputWithInt() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    JukeboxSong internal = new JukeboxSong(soundEvent2, description, 10.0f, 1);

    PaperBuilder paperBuilder = new PaperBuilder(conversions, internal);

    // Act
    Builder actualComparatorOutputResult = paperBuilder.comparatorOutput(1);

    // Assert
    assertSame(paperBuilder, actualComparatorOutputResult);
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

    JukeboxSong internal = new JukeboxSong(soundEvent2, description, 10.0f, 1);

    PaperBuilder paperBuilder = new PaperBuilder(conversions, internal);

    // Act
    Builder actualDescriptionResult = paperBuilder.description(mock(Component.class));

    // Assert
    verify(conversions).asVanilla(isA(Component.class));
    assertSame(paperBuilder, actualDescriptionResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#lengthInSeconds(float)} with {@code float}.
   *
   * <p>Method under test: {@link PaperBuilder#lengthInSeconds(float)}
   */
  @Test
  @DisplayName("Test PaperBuilder lengthInSeconds(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.lengthInSeconds(float)"})
  void testPaperBuilderLengthInSecondsWithFloat() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    JukeboxSong internal = new JukeboxSong(soundEvent2, description, 10.0f, 1);

    PaperBuilder paperBuilder = new PaperBuilder(conversions, internal);

    // Act
    Builder actualLengthInSecondsResult = paperBuilder.lengthInSeconds(10.0f);

    // Assert
    assertSame(paperBuilder, actualLengthInSecondsResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, JukeboxSong)}.
   *
   * <ul>
   *   <li>Then {@link PaperJukeboxSongRegistryEntry#description} return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, JukeboxSong)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, JukeboxSong); then description return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, JukeboxSong)"})
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

    JukeboxSong internal = new JukeboxSong(soundEvent2, description, 10.0f, 1);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, internal);

    // Assert
    assertTrue(actualPaperBuilder.description instanceof AdventureComponent);
    Holder<SoundEvent> holder = actualPaperBuilder.soundEvent;
    assertTrue(holder instanceof Direct);
    assertEquals("[unregistered]", holder.getRegisteredName());
    OptionalInt optionalInt = actualPaperBuilder.comparatorOutput;
    assertEquals(1, optionalInt.getAsInt());
    assertEquals(10.0f, actualPaperBuilder.lengthInSeconds.floatValue());
    assertFalse(optionalInt.isEmpty());
    assertTrue(optionalInt.isPresent());
    assertSame(soundEvent, holder.value());
    net.minecraft.network.chat.Component expectedDescriptionResult = actualPaperBuilder.description;
    assertSame(expectedDescriptionResult, internal.description());
    Holder<SoundEvent> expectedSoundEventResult = actualPaperBuilder.soundEvent;
    assertSame(expectedSoundEventResult, internal.soundEvent());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#PaperBuilder(Conversions, JukeboxSong)}.
   *
   * <ul>
   *   <li>Then return {@link PaperJukeboxSongRegistryEntry#lengthInSeconds} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#PaperBuilder(Conversions, JukeboxSong)}
   */
  @Test
  @DisplayName(
      "Test PaperBuilder new PaperBuilder(Conversions, JukeboxSong); then return lengthInSeconds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBuilder.<init>(Conversions, JukeboxSong)"})
  void testPaperBuilderNewPaperBuilder_thenReturnLengthInSecondsIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    PaperBuilder actualPaperBuilder = new PaperBuilder(conversions, null);

    // Assert
    assertNull(actualPaperBuilder.lengthInSeconds);
    assertNull(actualPaperBuilder.soundEvent);
    assertNull(actualPaperBuilder.description);
    OptionalInt optionalInt = actualPaperBuilder.comparatorOutput;
    assertFalse(optionalInt.isPresent());
    assertTrue(optionalInt.isEmpty());
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

    JukeboxSong internal = new JukeboxSong(soundEvent2, description, 10.0f, 1);

    PaperBuilder paperBuilder = new PaperBuilder(conversions, internal);

    // Act
    Builder actualSoundEventResult = paperBuilder.soundEvent(mock(Consumer.class));

    // Assert
    verify(conversions).createHolderFromBuilder(isA(RegistryKey.class), isA(Consumer.class));
    assertSame(paperBuilder, actualSoundEventResult);
  }

  /**
   * Test {@link PaperJukeboxSongRegistryEntry#soundEvent()}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceKey#location()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperJukeboxSongRegistryEntry#soundEvent()}
   */
  @Test
  @DisplayName("Test soundEvent(); then calls location()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.registry.holder.RegistryHolder PaperJukeboxSongRegistryEntry.soundEvent()"
  })
  void testSoundEvent_thenCallsLocation() {
    // Arrange
    ResourceKey<SoundEvent> key = mock(ResourceKey.class);
    when(key.location()).thenReturn(ResourceLocation.withDefaultNamespace("argument.id.invalid"));
    when(key.registryKey()).thenReturn(Registries.SOUND_EVENT);
    Reference<SoundEvent> soundEvent = Reference.createStandAlone(mock(HolderOwner.class), key);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    JukeboxSong internal = new JukeboxSong(soundEvent, description, 10.0f, 1);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    PaperJukeboxSongRegistryEntry paperJukeboxSongRegistryEntry =
        new PaperJukeboxSongRegistryEntry(conversions, internal);

    // Act
    paperJukeboxSongRegistryEntry.soundEvent();

    // Assert
    verify(key).location();
    verify(key).registryKey();
  }

  /**
   * Test {@link PaperJukeboxSongRegistryEntry#lengthInSeconds()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperJukeboxSongRegistryEntry#lengthInSeconds()}
   */
  @Test
  @DisplayName("Test lengthInSeconds(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperJukeboxSongRegistryEntry.lengthInSeconds()"})
  void testLengthInSeconds_thenReturnTen() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    JukeboxSong internal = new JukeboxSong(soundEvent2, description, 10.0f, 1);

    PaperJukeboxSongRegistryEntry paperJukeboxSongRegistryEntry =
        new PaperJukeboxSongRegistryEntry(conversions, internal);

    // Act and Assert
    assertEquals(10.0f, paperJukeboxSongRegistryEntry.lengthInSeconds());
  }

  /**
   * Test {@link PaperJukeboxSongRegistryEntry#comparatorOutput()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PaperJukeboxSongRegistryEntry#comparatorOutput()}
   */
  @Test
  @DisplayName("Test comparatorOutput(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperJukeboxSongRegistryEntry.comparatorOutput()"})
  void testComparatorOutput_thenReturnOne() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    ResourceLocation location = mock(ResourceLocation.class);
    Optional<Float> fixedRange = Optional.empty();

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    Direct<SoundEvent> soundEvent2 = new Direct<>(soundEvent);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    JukeboxSong internal = new JukeboxSong(soundEvent2, description, 10.0f, 1);

    PaperJukeboxSongRegistryEntry paperJukeboxSongRegistryEntry =
        new PaperJukeboxSongRegistryEntry(conversions, internal);

    // Act and Assert
    assertEquals(1, paperJukeboxSongRegistryEntry.comparatorOutput());
  }
}
