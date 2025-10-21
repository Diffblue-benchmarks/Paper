package io.papermc.paper.registry.legacy;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
import io.papermc.paper.registry.RegistryHolder;
import io.papermc.paper.registry.entry.RegistryEntry;
import io.papermc.paper.registry.entry.RegistryEntryMeta;
import io.papermc.paper.registry.entry.RegistryEntryMeta.ApiOnly;
import java.util.function.Supplier;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DelayedRegistryEntryDiffblueTest {
  /**
   * Test {@link DelayedRegistryEntry#meta()}.
   *
   * <p>Method under test: {@link DelayedRegistryEntry#meta()}
   */
  @Test
  @DisplayName("Test meta()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntryMeta DelayedRegistryEntry.meta()"})
  void testMeta() {
    // Arrange
    RegistryEntry<Object, Keyed> delegate = mock(RegistryEntry.class);
    ApiOnly<Object, Keyed> apiOnly =
        new ApiOnly<>(mock(ResourceKey.class), null, mock(Supplier.class));
    when(delegate.meta()).thenReturn(apiOnly);
    DelayedRegistryEntry<Object, Keyed> delayedRegistryEntry = new DelayedRegistryEntry<>(delegate);

    // Act
    RegistryEntryMeta<Object, Keyed> actualMetaResult = delayedRegistryEntry.meta();

    // Assert
    verify(delegate).meta();
    assertTrue(actualMetaResult instanceof ApiOnly);
    assertNull(actualMetaResult.apiKey());
    assertSame(apiOnly, actualMetaResult);
  }

  /**
   * Test {@link DelayedRegistryEntry#createRegistryHolder(Registry)}.
   *
   * <ul>
   *   <li>Then calls {@link RegistryEntry#createRegistryHolder(Registry)}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistryEntry#createRegistryHolder(Registry)}
   */
  @Test
  @DisplayName("Test createRegistryHolder(Registry); then calls createRegistryHolder(Registry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryHolder DelayedRegistryEntry.createRegistryHolder(Registry)"})
  void testCreateRegistryHolder_thenCallsCreateRegistryHolder() {
    // Arrange
    RegistryEntry<Object, Keyed> delegate = mock(RegistryEntry.class);
    when(delegate.createRegistryHolder(Mockito.<Registry<Object>>any()))
        .thenReturn(mock(RegistryHolder.class));
    DelayedRegistryEntry<Object, Keyed> delayedRegistryEntry = new DelayedRegistryEntry<>(delegate);
    ResourceKey<? extends Registry<Object>> key = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> nmsRegistry =
        new DefaultedMappedRegistry<>("42", key, Lifecycle.experimental(), true);

    // Act
    delayedRegistryEntry.createRegistryHolder(nmsRegistry);

    // Assert
    verify(delegate).createRegistryHolder(isA(Registry.class));
  }

  /**
   * Test {@link DelayedRegistryEntry#createRegistryHolder(Registry)}.
   *
   * <ul>
   *   <li>Then calls {@link RegistryEntry#createRegistryHolder(Registry)}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistryEntry#createRegistryHolder(Registry)}
   */
  @Test
  @DisplayName("Test createRegistryHolder(Registry); then calls createRegistryHolder(Registry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryHolder DelayedRegistryEntry.createRegistryHolder(Registry)"})
  void testCreateRegistryHolder_thenCallsCreateRegistryHolder2() {
    // Arrange
    RegistryEntry<Object, Keyed> delegate = mock(RegistryEntry.class);
    when(delegate.createRegistryHolder(Mockito.<Registry<Object>>any()))
        .thenReturn(mock(RegistryHolder.class));
    DelayedRegistryEntry<Object, Keyed> delegate2 = new DelayedRegistryEntry<>(delegate);
    DelayedRegistryEntry<Object, Keyed> delayedRegistryEntry =
        new DelayedRegistryEntry<>(delegate2);
    ResourceKey<? extends Registry<Object>> key = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> nmsRegistry =
        new DefaultedMappedRegistry<>("42", key, Lifecycle.experimental(), true);

    // Act
    delayedRegistryEntry.createRegistryHolder(nmsRegistry);

    // Assert
    verify(delegate).createRegistryHolder(isA(Registry.class));
  }
}
