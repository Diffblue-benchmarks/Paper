package org.bukkit.potion;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.potion.PotionEffectType.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PotionEffectTypeDiffblueTest {
  /**
   * Test Category {@link Category#getColor()}.
   *
   * <p>Method under test: {@link Category#getColor()}
   */
  @Test
  @DisplayName("Test Category getColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor Category.getColor()"})
  void testCategoryGetColor() {
    // Arrange and Act
    TextColor actualColor = Category.valueOf("BENEFICIAL").getColor();

    // Assert
    assertSame(((NamedTextColor) actualColor).BLUE, actualColor);
  }
}
