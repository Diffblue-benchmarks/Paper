package org.bukkit.potion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PotionTypeDiffblueTest {
  /**
   * Test {@link PotionType#getKey()}.
   *
   * <p>Method under test: {@link PotionType#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey PotionType.getKey()"})
  void testGetKey() {
    // Arrange and Act
    NamespacedKey actualKey = PotionType.valueOf("AWKWARD").getKey();

    // Assert
    assertEquals("awkward", actualKey.getKey());
    assertEquals("minecraft", actualKey.getNamespace());
    assertEquals("minecraft", actualKey.namespace());
  }
}
