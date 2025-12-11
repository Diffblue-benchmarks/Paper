package io.papermc.paper.registry.set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
import io.papermc.paper.adventure.AdventureComponent;
import io.papermc.paper.registry.RegistryKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.kyori.adventure.text.Component;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Direct;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.RegistryOps.RegistryInfo;
import net.minecraft.resources.RegistryOps.RegistryInfoLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import org.bukkit.Keyed;
import org.bukkit.craftbukkit.CraftJukeboxSong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaperRegistrySetsDiffblueTest {
  /**
   * Test {@link PaperRegistrySets#convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link RegistryKeySet#values()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToNms(ResourceKey, RegistryInfoLookup,
   * RegistryKeySet)}
   */
  @Test
  @DisplayName(
      "Test convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet); given ArrayList(); then calls values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HolderSet PaperRegistrySets.convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet)"
  })
  void testConvertToNms_givenArrayList_thenCallsValues() {
    // Arrange
    RegistryInfoLookup lookup = mock(RegistryInfoLookup.class);
    ResourceKey<? extends Registry<Object>> key = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> owner =
        new DefaultedMappedRegistry<>("42", key, Lifecycle.experimental(), true);
    ResourceKey<? extends Registry<Object>> key2 = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> getter =
        new DefaultedMappedRegistry<>("42", key2, Lifecycle.experimental(), true);

    RegistryInfo<Object> registryInfo = new RegistryInfo<>(owner, getter, Lifecycle.experimental());
    Optional<RegistryInfo<Object>> ofResult = Optional.of(registryInfo);
    when(lookup.lookup(Mockito.<ResourceKey<Registry<Object>>>any())).thenReturn(ofResult);

    RegistryKeySet<Keyed> registryKeySet = mock(RegistryKeySet.class);
    when(registryKeySet.values()).thenReturn(new ArrayList<>());

    // Act
    HolderSet<Object> actualConvertToNmsResult =
        PaperRegistrySets.convertToNms(null, lookup, registryKeySet);

    // Assert
    verify(registryKeySet).values();
    verify(lookup).lookup(isNull());
    assertTrue(actualConvertToNmsResult instanceof Direct);
    assertEquals(0, actualConvertToNmsResult.size());
    assertEquals(0L, actualConvertToNmsResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualConvertToNmsResult.iterator().hasNext());
    Stream<Holder<Object>> streamResult = actualConvertToNmsResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualConvertToNmsResult.isBound());
  }

  /**
   * Test {@link PaperRegistrySets#convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet)}.
   *
   * <ul>
   *   <li>Then return {@link Direct}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToNms(ResourceKey, RegistryInfoLookup,
   * RegistryKeySet)}
   */
  @Test
  @DisplayName(
      "Test convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet); then return Direct")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HolderSet PaperRegistrySets.convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet)"
  })
  void testConvertToNms_thenReturnDirect() {
    // Arrange
    RegistryInfoLookup lookup = mock(RegistryInfoLookup.class);
    ResourceKey<? extends Registry<Object>> key = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> owner =
        new DefaultedMappedRegistry<>("42", key, Lifecycle.experimental(), true);
    ResourceKey<? extends Registry<Object>> key2 = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> getter =
        new DefaultedMappedRegistry<>("42", key2, Lifecycle.experimental(), true);

    RegistryInfo<Object> registryInfo = new RegistryInfo<>(owner, getter, Lifecycle.experimental());
    Optional<RegistryInfo<Object>> ofResult = Optional.of(registryInfo);
    when(lookup.lookup(Mockito.<ResourceKey<Registry<Object>>>any())).thenReturn(ofResult);
    RegistryKeySetImpl<Keyed> registryKeySet = new RegistryKeySetImpl<>(null, new ArrayList<>());

    // Act
    HolderSet<Object> actualConvertToNmsResult =
        PaperRegistrySets.convertToNms(null, lookup, registryKeySet);

    // Assert
    verify(lookup).lookup(isNull());
    assertTrue(actualConvertToNmsResult instanceof Direct);
    assertEquals(0, actualConvertToNmsResult.size());
    assertEquals(0L, actualConvertToNmsResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualConvertToNmsResult.iterator().hasNext());
    Stream<Holder<Object>> streamResult = actualConvertToNmsResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualConvertToNmsResult.isBound());
  }

  /**
   * Test {@link PaperRegistrySets#convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToNms(ResourceKey, RegistryInfoLookup,
   * RegistryKeySet)}
   */
  @Test
  @DisplayName(
      "Test convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HolderSet PaperRegistrySets.convertToNms(ResourceKey, RegistryInfoLookup, RegistryKeySet)"
  })
  void testConvertToNms_thenReturnNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    NamedRegistryKeySetImpl<Keyed, Object> registryKeySet =
        new NamedRegistryKeySetImpl<>(null, null);

    // Act
    HolderSet<Object> actualConvertToNmsResult =
        PaperRegistrySets.convertToNms(null, lookup, registryKeySet);

    // Assert
    assertNull(actualConvertToNmsResult);
  }

  /**
   * Test {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey, RegistryInfoLookup,
   * RegistrySet)}.
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey,
   * RegistryInfoLookup, RegistrySet)}
   */
  @Test
  @DisplayName("Test convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HolderSet PaperRegistrySets.convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet)"
  })
  void testConvertToNmsWithDirects() {
    // Arrange
    ResourceKey<? extends Registry<Object>> resourceKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    RegistryKeySetImpl<Keyed> registrySet = new RegistryKeySetImpl<>(null, new ArrayList<>());

    // Act
    HolderSet<Object> actualConvertToNmsWithDirectsResult =
        PaperRegistrySets.convertToNmsWithDirects(resourceKey, lookup, registrySet);

    // Assert
    assertTrue(actualConvertToNmsWithDirectsResult instanceof Direct);
    assertEquals(0, actualConvertToNmsWithDirectsResult.size());
    assertEquals(0L, actualConvertToNmsWithDirectsResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualConvertToNmsWithDirectsResult.iterator().hasNext());
    Stream<Holder<Object>> streamResult = actualConvertToNmsWithDirectsResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey, RegistryInfoLookup,
   * RegistrySet)}.
   *
   * <ul>
   *   <li>Given {@link Keyed}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey,
   * RegistryInfoLookup, RegistrySet)}
   */
  @Test
  @DisplayName(
      "Test convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet); given Keyed; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HolderSet PaperRegistrySets.convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet)"
  })
  void testConvertToNmsWithDirects_givenKeyed_thenThrowUnsupportedOperationException() {
    // Arrange
    ResourceKey<? extends Registry<Object>> resourceKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    ArrayList<Keyed> values = new ArrayList<>();
    values.add(mock(Keyed.class));
    RegistryValueSetImpl<Keyed> registrySet = new RegistryValueSetImpl<>(null, values);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> PaperRegistrySets.convertToNmsWithDirects(resourceKey, lookup, registrySet));
  }

  /**
   * Test {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey, RegistryInfoLookup,
   * RegistrySet)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey,
   * RegistryInfoLookup, RegistrySet)}
   */
  @Test
  @DisplayName(
      "Test convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HolderSet PaperRegistrySets.convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet)"
  })
  void testConvertToNmsWithDirects_thenDoesNotThrow() {
    // Arrange
    ResourceKey<? extends Registry<Object>> resourceKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    NamedRegistryKeySetImpl<Keyed, Object> registrySet =
        new NamedRegistryKeySetImpl<>(null, mock(Named.class));

    // Act
    assertDoesNotThrow(
        () -> PaperRegistrySets.convertToNmsWithDirects(resourceKey, lookup, registrySet));
  }

  /**
   * Test {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey, RegistryInfoLookup,
   * RegistrySet)}.
   *
   * <ul>
   *   <li>Then return iterator next is {@link Holder.Direct#Direct(Object)} with value is {@link
   *       JukeboxSong#JukeboxSong(Holder, Component, float, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey,
   * RegistryInfoLookup, RegistrySet)}
   */
  @Test
  @DisplayName(
      "Test convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet); then return iterator next is Direct(Object) with value is JukeboxSong(Holder, Component, float, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HolderSet PaperRegistrySets.convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet)"
  })
  void testConvertToNmsWithDirects_thenReturnIteratorNextIsDirectWithValueIsJukeboxSong() {
    // Arrange
    ResourceKey<? extends Registry<Object>> resourceKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    ArrayList<Keyed> values = new ArrayList<>();
    Reference<SoundEvent> soundEvent = Reference.createIntrusive(mock(HolderOwner.class), null);
    AdventureComponent description = new AdventureComponent(mock(Component.class));

    JukeboxSong jukeboxSong = new JukeboxSong(soundEvent, description, 10.0f, 1);
    Holder.Direct<JukeboxSong> holder = new Holder.Direct<>(jukeboxSong);
    values.add(new CraftJukeboxSong(holder));
    RegistryValueSetImpl<Keyed> registrySet = new RegistryValueSetImpl<>(null, values);

    // Act
    HolderSet<Object> actualConvertToNmsWithDirectsResult =
        PaperRegistrySets.convertToNmsWithDirects(resourceKey, lookup, registrySet);

    // Assert
    assertTrue(actualConvertToNmsWithDirectsResult instanceof Direct);
    Iterator<Holder<Object>> iteratorResult = actualConvertToNmsWithDirectsResult.iterator();
    Holder<Object> actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(holder, actualNextResult);
    assertEquals(1, actualConvertToNmsWithDirectsResult.size());
    assertEquals(1L, actualConvertToNmsWithDirectsResult.spliterator().getExactSizeIfKnown());
    Stream<Holder<Object>> streamResult = actualConvertToNmsWithDirectsResult.stream();
    List<Holder<Object>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertSame(holder, collectResult.get(0));
  }

  /**
   * Test {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey, RegistryInfoLookup,
   * RegistrySet)}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToNmsWithDirects(ResourceKey,
   * RegistryInfoLookup, RegistrySet)}
   */
  @Test
  @DisplayName(
      "Test convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HolderSet PaperRegistrySets.convertToNmsWithDirects(ResourceKey, RegistryInfoLookup, RegistrySet)"
  })
  void testConvertToNmsWithDirects_thenReturnSizeIsZero() {
    // Arrange
    ResourceKey<? extends Registry<Object>> resourceKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    RegistryValueSetImpl<Keyed> registrySet = new RegistryValueSetImpl<>(null, new ArrayList<>());

    // Act
    HolderSet<Object> actualConvertToNmsWithDirectsResult =
        PaperRegistrySets.convertToNmsWithDirects(resourceKey, lookup, registrySet);

    // Assert
    assertTrue(actualConvertToNmsWithDirectsResult instanceof Direct);
    assertEquals(0, actualConvertToNmsWithDirectsResult.size());
    assertEquals(0L, actualConvertToNmsWithDirectsResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualConvertToNmsWithDirectsResult.iterator().hasNext());
    Stream<Holder<Object>> streamResult = actualConvertToNmsWithDirectsResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link PaperRegistrySets#convertToApi(RegistryKey, HolderSet)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToApi(RegistryKey, HolderSet)}
   */
  @Test
  @DisplayName(
      "Test convertToApi(RegistryKey, HolderSet); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet PaperRegistrySets.convertToApi(RegistryKey, HolderSet)"})
  void testConvertToApi_thenThrowUnsupportedOperationException() {
    // Arrange
    Named<Object> holders = mock(Named.class);
    when(holders.key()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> PaperRegistrySets.convertToApi(null, holders));
    verify(holders).key();
  }

  /**
   * Test {@link PaperRegistrySets#convertToApiWithDirects(RegistryKey, HolderSet)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistrySets#convertToApiWithDirects(RegistryKey, HolderSet)}
   */
  @Test
  @DisplayName(
      "Test convertToApiWithDirects(RegistryKey, HolderSet); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RegistrySet PaperRegistrySets.convertToApiWithDirects(RegistryKey, HolderSet)"
  })
  void testConvertToApiWithDirects_thenThrowUnsupportedOperationException() {
    // Arrange
    Named<Object> holders = mock(Named.class);
    when(holders.key()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> PaperRegistrySets.convertToApiWithDirects(null, holders));
    verify(holders).key();
  }
}
