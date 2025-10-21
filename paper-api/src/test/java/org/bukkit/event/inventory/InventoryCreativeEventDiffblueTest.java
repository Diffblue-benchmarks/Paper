package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Result;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InventoryCreativeEventDiffblueTest {
  /**
   * Test {@link InventoryCreativeEvent#InventoryCreativeEvent(InventoryView, SlotType, int,
   * ItemStack)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code InventoryCreativeEvent}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryCreativeEvent#InventoryCreativeEvent(InventoryView,
   * SlotType, int, ItemStack)}
   */
  @Test
  @DisplayName(
      "Test new InventoryCreativeEvent(InventoryView, SlotType, int, ItemStack); then return EventName is 'InventoryCreativeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryCreativeEvent.<init>(InventoryView, SlotType, int, ItemStack)"})
  void testNewInventoryCreativeEvent_thenReturnEventNameIsInventoryCreativeEvent() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);
    ItemStack newItem = mock(ItemStack.class);

    // Act
    InventoryCreativeEvent actualInventoryCreativeEvent =
        new InventoryCreativeEvent(view, SlotType.RESULT, 1, newItem);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("InventoryCreativeEvent", actualInventoryCreativeEvent.getEventName());
    assertNull(actualInventoryCreativeEvent.getWhoClicked());
    assertNull(actualInventoryCreativeEvent.getClickedInventory());
    assertNull(actualInventoryCreativeEvent.getInventory());
    assertNull(actualInventoryCreativeEvent.getCurrentItem());
    assertEquals(-1, actualInventoryCreativeEvent.getHotbarButton());
    assertEquals(1, actualInventoryCreativeEvent.getRawSlot());
    assertEquals(1, actualInventoryCreativeEvent.getSlot());
    assertEquals(Result.DEFAULT, actualInventoryCreativeEvent.getResult());
    assertEquals(ClickType.CREATIVE, actualInventoryCreativeEvent.getClick());
    assertEquals(InventoryAction.PLACE_ALL, actualInventoryCreativeEvent.getAction());
    assertEquals(SlotType.RESULT, actualInventoryCreativeEvent.getSlotType());
    assertFalse(actualInventoryCreativeEvent.isAsynchronous());
    assertFalse(actualInventoryCreativeEvent.isRightClick());
    assertFalse(actualInventoryCreativeEvent.isShiftClick());
    assertFalse(actualInventoryCreativeEvent.isCancelled());
    assertTrue(actualInventoryCreativeEvent.isLeftClick());
    assertSame(view, actualInventoryCreativeEvent.getView());
    assertSame(newItem, actualInventoryCreativeEvent.getCursor());
  }
}
