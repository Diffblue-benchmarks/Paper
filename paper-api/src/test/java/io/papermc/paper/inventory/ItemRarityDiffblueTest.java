package io.papermc.paper.inventory;

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
   * Test {@link ItemRarity#getColor()}.
   *
   * <p>Method under test: {@link ItemRarity#getColor()}
   */
  @Test
  @DisplayName("Test getColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor ItemRarity.getColor()"})
  void testGetColor() {
    // Arrange and Act
    TextColor actualColor = ItemRarity.valueOf("COMMON").getColor();

    // Assert
    assertSame(((NamedTextColor) actualColor).WHITE, actualColor);
  }
}
