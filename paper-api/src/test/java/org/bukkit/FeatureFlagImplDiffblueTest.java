package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.FeatureFlagImpl.Deprecated;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FeatureFlagImplDiffblueTest {
  /**
   * Test Deprecated {@link Deprecated#getKey()}.
   *
   * <p>Method under test: {@link Deprecated#getKey()}
   */
  @Test
  @DisplayName("Test Deprecated getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey Deprecated.getKey()"})
  void testDeprecatedGetKey() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act and Assert
    assertSame(key, new Deprecated(key).getKey());
  }

  /**
   * Test Deprecated {@link Deprecated#key()}.
   *
   * <p>Method under test: {@link Deprecated#key()}
   */
  @Test
  @DisplayName("Test Deprecated key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey Deprecated.key()"})
  void testDeprecatedKey() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act and Assert
    assertSame(key, new Deprecated(key).key());
  }

  /**
   * Test {@link FeatureFlagImpl#getKey()}.
   *
   * <p>Method under test: {@link FeatureFlagImpl#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey FeatureFlagImpl.getKey()"})
  void testGetKey() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act and Assert
    assertSame(key, new FeatureFlagImpl(key).getKey());
  }

  /**
   * Test {@link FeatureFlagImpl#key()}.
   *
   * <p>Method under test: {@link FeatureFlagImpl#key()}
   */
  @Test
  @DisplayName("Test key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey FeatureFlagImpl.key()"})
  void testKey() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act and Assert
    assertSame(key, new FeatureFlagImpl(key).key());
  }
}
