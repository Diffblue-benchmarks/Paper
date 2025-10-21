package io.papermc.paper.registry;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.registry.entry.RegistryEntry;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperRegistriesDiffblueTest {
  /**
   * Test {@link PaperRegistries#getEntry(RegistryKey)} with {@code registryKey}.
   *
   * <p>Method under test: {@link PaperRegistries#getEntry(RegistryKey)}
   */
  @Test
  @DisplayName("Test getEntry(RegistryKey) with 'registryKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntry PaperRegistries.getEntry(RegistryKey)"})
  void testGetEntryWithRegistryKey() {
    // Arrange and Act
    RegistryEntry<Object, Keyed> actualEntry =
        PaperRegistries.getEntry(new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID));

    // Assert
    assertNull(actualEntry);
  }

  /**
   * Test {@link PaperRegistries#getEntry(ResourceKey)} with {@code resourceKey}.
   *
   * <p>Method under test: {@link PaperRegistries#getEntry(ResourceKey)}
   */
  @Test
  @DisplayName("Test getEntry(ResourceKey) with 'resourceKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntry PaperRegistries.getEntry(ResourceKey)"})
  void testGetEntryWithResourceKey() {
    // Arrange and Act
    RegistryEntry<Object, Keyed> actualEntry = PaperRegistries.getEntry(mock(ResourceKey.class));

    // Assert
    assertNull(actualEntry);
  }

  /**
   * Test {@link PaperRegistries#getBuildableMeta(RegistryKey)}.
   *
   * <ul>
   *   <li>When {@link RegistryKeyImpl#RegistryKeyImpl(Key)} with key is {@link
   *       ServerBuildInfo#BRAND_PAPER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistries#getBuildableMeta(RegistryKey)}
   */
  @Test
  @DisplayName(
      "Test getBuildableMeta(RegistryKey); when RegistryKeyImpl(Key) with key is BRAND_PAPER_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntryMeta.Buildable PaperRegistries.getBuildableMeta(RegistryKey)"})
  void testGetBuildableMeta_whenRegistryKeyImplWithKeyIsBrand_paper_id() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            PaperRegistries.getBuildableMeta(
                new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID)));
  }

  /**
   * Test {@link PaperRegistries#getBuildableMeta(RegistryKey)}.
   *
   * <ul>
   *   <li>When {@link RegistryKeyImpl#RegistryKeyImpl(Key)} with key is randomKey.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistries#getBuildableMeta(RegistryKey)}
   */
  @Test
  @DisplayName(
      "Test getBuildableMeta(RegistryKey); when RegistryKeyImpl(Key) with key is randomKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntryMeta.Buildable PaperRegistries.getBuildableMeta(RegistryKey)"})
  void testGetBuildableMeta_whenRegistryKeyImplWithKeyIsRandomKey() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistries.getBuildableMeta(new RegistryKeyImpl<>(NamespacedKey.randomKey())));
  }

  /**
   * Test {@link PaperRegistries#fromNms(ResourceKey)} with {@code resourceKey}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistries#fromNms(ResourceKey)}
   */
  @Test
  @DisplayName("Test fromNms(ResourceKey) with 'resourceKey'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"io.papermc.paper.registry.TypedKey PaperRegistries.fromNms(ResourceKey)"})
  void testFromNmsWithResourceKey_thenThrowIllegalArgumentException() {
    // Arrange
    ResourceKey<Object> resourceKey = mock(ResourceKey.class);
    when(resourceKey.registryKey()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PaperRegistries.fromNms(resourceKey));
    verify(resourceKey).registryKey();
  }
}
