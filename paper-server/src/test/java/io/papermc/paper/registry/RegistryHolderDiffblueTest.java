package io.papermc.paper.registry;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
import io.papermc.paper.registry.RegistryHolder.Delayed;
import io.papermc.paper.registry.RegistryHolder.Memoized;
import io.papermc.paper.registry.entry.RegistryEntry;
import io.papermc.paper.registry.legacy.DelayedRegistryEntry;
import java.util.function.Supplier;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegistryHolderDiffblueTest {
  /**
   * Test Delayed {@link Delayed#loadFrom(DelayedRegistryEntry, Registry)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed#loadFrom(DelayedRegistryEntry, Registry)}
   */
  @Test
  @DisplayName(
      "Test Delayed loadFrom(DelayedRegistryEntry, Registry); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed.loadFrom(DelayedRegistryEntry, Registry)"})
  void testDelayedLoadFrom_givenIllegalArgumentException() {
    // Arrange
    Delayed<Keyed, org.bukkit.Registry<Keyed>> delayed = new Delayed<>();

    RegistryEntry<Object, Keyed> delegate = mock(RegistryEntry.class);
    when(delegate.createRegistryHolder(Mockito.<Registry<Object>>any()))
        .thenThrow(new IllegalArgumentException());
    DelayedRegistryEntry<Object, Keyed> delayedEntry = new DelayedRegistryEntry<>(delegate);
    DefaultedMappedRegistry<Object> registry =
        new DefaultedMappedRegistry<>("42", mock(ResourceKey.class), mock(Lifecycle.class), true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> delayed.loadFrom(delayedEntry, registry));
    verify(delegate).createRegistryHolder(isA(Registry.class));
  }

  /**
   * Test Delayed {@link Delayed#loadFrom(DelayedRegistryEntry, Registry)}.
   *
   * <ul>
   *   <li>Given {@link Memoized#Memoized(Supplier)} with {@link Supplier}.
   *   <li>Then {@link Delayed} (default constructor) delegate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed#loadFrom(DelayedRegistryEntry, Registry)}
   */
  @Test
  @DisplayName(
      "Test Delayed loadFrom(DelayedRegistryEntry, Registry); given Memoized(Supplier) with Supplier; then Delayed (default constructor) delegate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed.loadFrom(DelayedRegistryEntry, Registry)"})
  void testDelayedLoadFrom_givenMemoizedWithSupplier_thenDelayedDelegateIsNull() {
    // Arrange
    Delayed<Keyed, org.bukkit.Registry<Keyed>> delayed = new Delayed<>();

    RegistryEntry<Object, Keyed> delegate = mock(RegistryEntry.class);
    when(delegate.createRegistryHolder(Mockito.<Registry<Object>>any()))
        .thenReturn(new Memoized<>(mock(Supplier.class)));
    DelayedRegistryEntry<Object, Keyed> delayedEntry = new DelayedRegistryEntry<>(delegate);
    DefaultedMappedRegistry<Object> registry =
        new DefaultedMappedRegistry<>("42", mock(ResourceKey.class), mock(Lifecycle.class), true);

    // Act
    delayed.loadFrom(delayedEntry, registry);

    // Assert
    verify(delegate).createRegistryHolder(isA(Registry.class));
    assertNull(delayed.get().delegate());
  }

  /**
   * Test Delayed {@link Delayed#loadFrom(DelayedRegistryEntry, Registry)}.
   *
   * <ul>
   *   <li>Given {@link RegistryHolder}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed#loadFrom(DelayedRegistryEntry, Registry)}
   */
  @Test
  @DisplayName("Test Delayed loadFrom(DelayedRegistryEntry, Registry); given RegistryHolder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed.loadFrom(DelayedRegistryEntry, Registry)"})
  void testDelayedLoadFrom_givenRegistryHolder() {
    // Arrange
    Delayed<Keyed, org.bukkit.Registry<Keyed>> delayed = new Delayed<>();

    RegistryEntry<Object, Keyed> delegate = mock(RegistryEntry.class);
    when(delegate.createRegistryHolder(Mockito.<Registry<Object>>any()))
        .thenReturn(mock(RegistryHolder.class));
    DelayedRegistryEntry<Object, Keyed> delayedEntry = new DelayedRegistryEntry<>(delegate);
    DefaultedMappedRegistry<Object> registry =
        new DefaultedMappedRegistry<>("42", mock(ResourceKey.class), mock(Lifecycle.class), true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> delayed.loadFrom(delayedEntry, registry));
    verify(delegate).createRegistryHolder(isA(Registry.class));
  }
}
