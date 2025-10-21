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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SmithItemEventDiffblueTest {
  /**
   * Test {@link SmithItemEvent#SmithItemEvent(InventoryView, SlotType, int, ClickType,
   * InventoryAction)}.
   *
   * <p>Method under test: {@link SmithItemEvent#SmithItemEvent(InventoryView, SlotType, int,
   * ClickType, InventoryAction)}
   */
  @Test
  @DisplayName("Test new SmithItemEvent(InventoryView, SlotType, int, ClickType, InventoryAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithItemEvent.<init>(InventoryView, SlotType, int, ClickType, InventoryAction)"
  })
  void testNewSmithItemEvent() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    SmithItemEvent actualSmithItemEvent =
        new SmithItemEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("SmithItemEvent", actualSmithItemEvent.getEventName());
    assertNull(actualSmithItemEvent.getWhoClicked());
    assertNull(actualSmithItemEvent.getClickedInventory());
    assertNull(actualSmithItemEvent.getCurrentItem());
    assertNull(actualSmithItemEvent.getCursor());
    assertNull(actualSmithItemEvent.getInventory());
    assertEquals(-1, actualSmithItemEvent.getHotbarButton());
    assertEquals(1, actualSmithItemEvent.getRawSlot());
    assertEquals(1, actualSmithItemEvent.getSlot());
    assertEquals(Result.DEFAULT, actualSmithItemEvent.getResult());
    assertEquals(ClickType.LEFT, actualSmithItemEvent.getClick());
    assertEquals(InventoryAction.NOTHING, actualSmithItemEvent.getAction());
    assertEquals(SlotType.RESULT, actualSmithItemEvent.getSlotType());
    assertFalse(actualSmithItemEvent.isAsynchronous());
    assertFalse(actualSmithItemEvent.isRightClick());
    assertFalse(actualSmithItemEvent.isShiftClick());
    assertFalse(actualSmithItemEvent.isCancelled());
    assertTrue(actualSmithItemEvent.isLeftClick());
    assertSame(view, actualSmithItemEvent.getView());
  }

  /**
   * Test {@link SmithItemEvent#SmithItemEvent(InventoryView, SlotType, int, ClickType,
   * InventoryAction, int)}.
   *
   * <p>Method under test: {@link SmithItemEvent#SmithItemEvent(InventoryView, SlotType, int,
   * ClickType, InventoryAction, int)}
   */
  @Test
  @DisplayName(
      "Test new SmithItemEvent(InventoryView, SlotType, int, ClickType, InventoryAction, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithItemEvent.<init>(InventoryView, SlotType, int, ClickType, InventoryAction, int)"
  })
  void testNewSmithItemEvent2() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    SmithItemEvent actualSmithItemEvent =
        new SmithItemEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING, 1);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("SmithItemEvent", actualSmithItemEvent.getEventName());
    assertNull(actualSmithItemEvent.getWhoClicked());
    assertNull(actualSmithItemEvent.getClickedInventory());
    assertNull(actualSmithItemEvent.getCurrentItem());
    assertNull(actualSmithItemEvent.getCursor());
    assertNull(actualSmithItemEvent.getInventory());
    assertEquals(1, actualSmithItemEvent.getHotbarButton());
    assertEquals(1, actualSmithItemEvent.getRawSlot());
    assertEquals(1, actualSmithItemEvent.getSlot());
    assertEquals(Result.DEFAULT, actualSmithItemEvent.getResult());
    assertEquals(ClickType.LEFT, actualSmithItemEvent.getClick());
    assertEquals(InventoryAction.NOTHING, actualSmithItemEvent.getAction());
    assertEquals(SlotType.RESULT, actualSmithItemEvent.getSlotType());
    assertFalse(actualSmithItemEvent.isAsynchronous());
    assertFalse(actualSmithItemEvent.isRightClick());
    assertFalse(actualSmithItemEvent.isShiftClick());
    assertFalse(actualSmithItemEvent.isCancelled());
    assertTrue(actualSmithItemEvent.isLeftClick());
    assertSame(view, actualSmithItemEvent.getView());
  }
}
