package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Item;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InventoryPickupItemEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryPickupItemEvent#InventoryPickupItemEvent(Inventory, Item)}
   *   <li>{@link InventoryPickupItemEvent#setCancelled(boolean)}
   *   <li>{@link InventoryPickupItemEvent#getHandlerList()}
   *   <li>{@link InventoryPickupItemEvent#getHandlers()}
   *   <li>{@link InventoryPickupItemEvent#getInventory()}
   *   <li>{@link InventoryPickupItemEvent#getItem()}
   *   <li>{@link InventoryPickupItemEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryPickupItemEvent.<init>(Inventory, Item)",
    "HandlerList InventoryPickupItemEvent.getHandlerList()",
    "HandlerList InventoryPickupItemEvent.getHandlers()",
    "Inventory InventoryPickupItemEvent.getInventory()",
    "Item InventoryPickupItemEvent.getItem()",
    "boolean InventoryPickupItemEvent.isCancelled()",
    "void InventoryPickupItemEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Inventory inventory = mock(Inventory.class);
    Item item = mock(Item.class);

    // Act
    InventoryPickupItemEvent actualInventoryPickupItemEvent =
        new InventoryPickupItemEvent(inventory, item);
    actualInventoryPickupItemEvent.setCancelled(true);
    HandlerList actualHandlerList = actualInventoryPickupItemEvent.getHandlerList();
    HandlerList actualHandlers = actualInventoryPickupItemEvent.getHandlers();
    Inventory actualInventory = actualInventoryPickupItemEvent.getInventory();
    Item actualItem = actualInventoryPickupItemEvent.getItem();
    boolean actualIsCancelledResult = actualInventoryPickupItemEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualInventoryPickupItemEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(item, actualItem);
    assertSame(inventory, actualInventory);
  }
}
