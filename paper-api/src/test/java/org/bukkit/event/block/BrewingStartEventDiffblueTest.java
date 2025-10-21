package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BrewingStartEventDiffblueTest {
  /**
   * Test {@link BrewingStartEvent#setRecipeBrewTime(int)}.
   *
   * <p>Method under test: {@link BrewingStartEvent#setRecipeBrewTime(int)}
   */
  @Test
  @DisplayName("Test setRecipeBrewTime(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BrewingStartEvent.setRecipeBrewTime(int)"})
  void testSetRecipeBrewTime() {
    // Arrange
    BrewingStartEvent brewingStartEvent =
        new BrewingStartEvent(mock(Block.class), mock(ItemStack.class), 1);

    // Act
    brewingStartEvent.setRecipeBrewTime(1);

    // Assert
    assertEquals(1, brewingStartEvent.getRecipeBrewTime());
  }
}
