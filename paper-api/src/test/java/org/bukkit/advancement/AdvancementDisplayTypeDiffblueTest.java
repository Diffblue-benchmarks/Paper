package org.bukkit.advancement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.ChatColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdvancementDisplayTypeDiffblueTest {
  /**
   * Test {@link AdvancementDisplayType#getColor()}.
   *
   * <p>Method under test: {@link AdvancementDisplayType#getColor()}
   */
  @Test
  @DisplayName("Test getColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatColor AdvancementDisplayType.getColor()"})
  void testGetColor() {
    // Arrange, Act and Assert
    assertEquals(ChatColor.GREEN, AdvancementDisplayType.valueOf("TASK").getColor());
  }
}
