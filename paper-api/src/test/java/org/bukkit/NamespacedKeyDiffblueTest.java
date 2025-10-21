package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NamespacedKeyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NamespacedKey#toString()}
   *   <li>{@link NamespacedKey#getKey()}
   *   <li>{@link NamespacedKey#getNamespace()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String NamespacedKey.getKey()",
    "java.lang.String NamespacedKey.getNamespace()",
    "java.lang.String NamespacedKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    NamespacedKey randomKeyResult = NamespacedKey.randomKey();

    // Act
    randomKeyResult.toString();
    randomKeyResult.getKey();

    // Assert
    assertEquals(NamespacedKey.BUKKIT, randomKeyResult.getNamespace());
  }

  /**
   * Test {@link NamespacedKey#randomKey()}.
   *
   * <p>Method under test: {@link NamespacedKey#randomKey()}
   */
  @Test
  @DisplayName("Test randomKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey NamespacedKey.randomKey()"})
  void testRandomKey() {
    // Arrange and Act
    NamespacedKey actualRandomKeyResult = NamespacedKey.randomKey();

    // Assert
    assertEquals(NamespacedKey.BUKKIT, actualRandomKeyResult.getNamespace());
    assertEquals(NamespacedKey.BUKKIT, actualRandomKeyResult.namespace());
  }

  /**
   * Test {@link NamespacedKey#namespace()}.
   *
   * <p>Method under test: {@link NamespacedKey#namespace()}
   */
  @Test
  @DisplayName("Test namespace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NamespacedKey.namespace()"})
  void testNamespace() {
    // Arrange, Act and Assert
    assertEquals(NamespacedKey.BUKKIT, NamespacedKey.randomKey().namespace());
  }
}
