package io.papermc.paper.registry.legacy;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.bukkit.Keyed;
import org.bukkit.Registry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DelayedRegistryDiffblueTest {
  /**
   * Test {@link DelayedRegistry#load(Supplier)}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor) load {@link Supplier}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#load(Supplier)}
   */
  @Test
  @DisplayName(
      "Test load(Supplier); given DelayedRegistry (default constructor) load Supplier; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedRegistry.load(Supplier)"})
  void testLoad_givenDelayedRegistryLoadSupplier_thenThrowIllegalStateException() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(mock(Supplier.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.load(mock(Supplier.class)));
  }

  /**
   * Test {@link DelayedRegistry#load(Supplier)}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   *   <li>Then {@link DelayedRegistry} (default constructor) delegate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#load(Supplier)}
   */
  @Test
  @DisplayName(
      "Test load(Supplier); given DelayedRegistry (default constructor); then DelayedRegistry (default constructor) delegate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedRegistry.load(Supplier)"})
  void testLoad_givenDelayedRegistry_thenDelayedRegistryDelegateIsNull() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act
    delayedRegistry.load(mock(Supplier.class));

    // Assert
    assertNull(delayedRegistry.delegate());
  }
}
