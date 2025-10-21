package io.papermc.paper.registry.entry;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.entry.RegistryEntryMeta.ApiOnly;
import io.papermc.paper.registry.legacy.DelayedRegistryEntry;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryEntryDiffblueTest {
  /**
   * Test {@link RegistryEntry#apiKey()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryEntry#apiKey()}
   */
  @Test
  @DisplayName("Test apiKey(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"io.papermc.paper.registry.RegistryKey RegistryEntry.apiKey()"})
  void testApiKey_thenReturnNull() {
    // Arrange
    ApiOnly<Object, Keyed> meta =
        new ApiOnly<>(mock(ResourceKey.class), null, mock(Supplier.class));
    RegistryEntryImpl<Object, Keyed> registryEntryImpl = new RegistryEntryImpl<>(meta);

    // Act and Assert
    assertNull(registryEntryImpl.apiKey());
  }

  /**
   * Test {@link RegistryEntry#mcKey()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryEntry#mcKey()}
   */
  @Test
  @DisplayName("Test mcKey(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceKey RegistryEntry.mcKey()"})
  void testMcKey_thenReturnNull() {
    // Arrange
    ApiOnly<Object, Keyed> meta = new ApiOnly<>(null, null, mock(Supplier.class));
    RegistryEntryImpl<Object, Keyed> registryEntryImpl = new RegistryEntryImpl<>(meta);

    // Act and Assert
    assertNull(registryEntryImpl.mcKey());
  }

  /**
   * Test {@link RegistryEntry#delayed()}.
   *
   * <p>Method under test: {@link RegistryEntry#delayed()}
   */
  @Test
  @DisplayName("Test delayed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntry RegistryEntry.delayed()"})
  void testDelayed() {
    // Arrange
    ApiOnly<Object, Keyed> meta =
        new ApiOnly<>(mock(ResourceKey.class), null, mock(Supplier.class));
    RegistryEntryImpl<Object, Keyed> registryEntryImpl = new RegistryEntryImpl<>(meta);

    // Act
    RegistryEntry<Object, Keyed> actualDelayedResult = registryEntryImpl.delayed();

    // Assert
    assertTrue(actualDelayedResult instanceof DelayedRegistryEntry);
    assertSame(
        registryEntryImpl, ((DelayedRegistryEntry<Object, Keyed>) actualDelayedResult).delegate());
  }
}
