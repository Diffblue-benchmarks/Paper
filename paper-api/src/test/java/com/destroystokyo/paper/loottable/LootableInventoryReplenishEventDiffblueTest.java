package com.destroystokyo.paper.loottable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LootableInventoryReplenishEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LootableInventoryReplenishEvent#LootableInventoryReplenishEvent(Player,
   *       LootableInventory)}
   *   <li>{@link LootableInventoryReplenishEvent#setCancelled(boolean)}
   *   <li>{@link LootableInventoryReplenishEvent#getHandlerList()}
   *   <li>{@link LootableInventoryReplenishEvent#getHandlers()}
   *   <li>{@link LootableInventoryReplenishEvent#getInventory()}
   *   <li>{@link LootableInventoryReplenishEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LootableInventoryReplenishEvent.<init>(Player, LootableInventory)",
    "HandlerList LootableInventoryReplenishEvent.getHandlerList()",
    "HandlerList LootableInventoryReplenishEvent.getHandlers()",
    "LootableInventory LootableInventoryReplenishEvent.getInventory()",
    "boolean LootableInventoryReplenishEvent.isCancelled()",
    "void LootableInventoryReplenishEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    LootableInventory inventory = mock(LootableInventory.class);

    // Act
    LootableInventoryReplenishEvent actualLootableInventoryReplenishEvent =
        new LootableInventoryReplenishEvent(player, inventory);
    actualLootableInventoryReplenishEvent.setCancelled(true);
    HandlerList actualHandlerList = actualLootableInventoryReplenishEvent.getHandlerList();
    HandlerList actualHandlers = actualLootableInventoryReplenishEvent.getHandlers();
    LootableInventory actualInventory = actualLootableInventoryReplenishEvent.getInventory();
    boolean actualIsCancelledResult = actualLootableInventoryReplenishEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualLootableInventoryReplenishEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(inventory, actualInventory);
    assertSame(player, actualLootableInventoryReplenishEvent.getPlayer());
  }
}
