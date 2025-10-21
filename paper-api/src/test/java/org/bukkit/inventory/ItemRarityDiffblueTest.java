package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ItemRarityDiffblueTest {
  /**
   * Test {@link ItemRarity#color()}.
   *
   * <p>Method under test: {@link ItemRarity#color()}
   */
  @Test
  @DisplayName("Test color()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor ItemRarity.color()"})
  void testColor() {
    // Arrange and Act
    TextColor actualColorResult = ItemRarity.valueOf("COMMON").color();

    // Assert
    assertSame(((NamedTextColor) actualColorResult).WHITE, actualColorResult);
  }
}
