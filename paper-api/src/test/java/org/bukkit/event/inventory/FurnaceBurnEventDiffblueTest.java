package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FurnaceBurnEventDiffblueTest {
  /**
   * Test {@link FurnaceBurnEvent#willConsumeFuel()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FurnaceBurnEvent#willConsumeFuel()}
   */
  @Test
  @DisplayName("Test willConsumeFuel(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FurnaceBurnEvent.willConsumeFuel()"})
  void testWillConsumeFuel_thenReturnFalse() {
    // Arrange
    FurnaceBurnEvent furnaceBurnEvent =
        new FurnaceBurnEvent(mock(Block.class), mock(ItemStack.class), 1);
    furnaceBurnEvent.setConsumeFuel(false);

    // Act and Assert
    assertFalse(furnaceBurnEvent.willConsumeFuel());
  }

  /**
   * Test {@link FurnaceBurnEvent#willConsumeFuel()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FurnaceBurnEvent#willConsumeFuel()}
   */
  @Test
  @DisplayName("Test willConsumeFuel(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FurnaceBurnEvent.willConsumeFuel()"})
  void testWillConsumeFuel_thenReturnTrue() {
    // Arrange
    FurnaceBurnEvent furnaceBurnEvent =
        new FurnaceBurnEvent(mock(Block.class), mock(ItemStack.class), 1);

    // Act and Assert
    assertTrue(furnaceBurnEvent.willConsumeFuel());
  }
}
