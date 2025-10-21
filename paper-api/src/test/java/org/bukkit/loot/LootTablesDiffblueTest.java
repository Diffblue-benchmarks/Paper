package org.bukkit.loot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LootTablesDiffblueTest {
  /**
   * Test {@link LootTables#getKey()}.
   *
   * <p>Method under test: {@link LootTables#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey LootTables.getKey()"})
  void testGetKey() {
    // Arrange and Act
    NamespacedKey actualKey = LootTables.ABANDONED_MINESHAFT.getKey();

    // Assert
    assertEquals("chests/abandoned_mineshaft", actualKey.getKey());
    assertEquals("minecraft", actualKey.getNamespace());
    assertEquals("minecraft", actualKey.namespace());
  }
}
