package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InventoryMoveItemEventDiffblueTest {
  /**
   * Test {@link InventoryMoveItemEvent#InventoryMoveItemEvent(Inventory, ItemStack, Inventory,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code InventoryMoveItemEvent}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryMoveItemEvent#InventoryMoveItemEvent(Inventory,
   * ItemStack, Inventory, boolean)}
   */
  @Test
  @DisplayName(
      "Test new InventoryMoveItemEvent(Inventory, ItemStack, Inventory, boolean); then return EventName is 'InventoryMoveItemEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryMoveItemEvent.<init>(Inventory, ItemStack, Inventory, boolean)"
  })
  void testNewInventoryMoveItemEvent_thenReturnEventNameIsInventoryMoveItemEvent() {
    // Arrange
    Inventory sourceInventory = mock(Inventory.class);
    ItemStack itemStack = mock(ItemStack.class);
    Inventory destinationInventory = mock(Inventory.class);

    // Act
    InventoryMoveItemEvent actualInventoryMoveItemEvent =
        new InventoryMoveItemEvent(sourceInventory, itemStack, destinationInventory, true);

    // Assert
    assertEquals("InventoryMoveItemEvent", actualInventoryMoveItemEvent.getEventName());
    assertEquals(0, actualInventoryMoveItemEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualInventoryMoveItemEvent.isAsynchronous());
    assertFalse(actualInventoryMoveItemEvent.isCancelled());
    assertSame(destinationInventory, actualInventoryMoveItemEvent.getDestination());
    assertSame(sourceInventory, actualInventoryMoveItemEvent.getInitiator());
    assertSame(sourceInventory, actualInventoryMoveItemEvent.getSource());
    assertSame(itemStack, actualInventoryMoveItemEvent.getItem());
  }
}
