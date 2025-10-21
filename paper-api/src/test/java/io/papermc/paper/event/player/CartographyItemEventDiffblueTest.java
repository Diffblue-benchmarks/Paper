package io.papermc.paper.event.player;

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
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.InventoryView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CartographyItemEventDiffblueTest {
  /**
   * Test {@link CartographyItemEvent#CartographyItemEvent(InventoryView, SlotType, int, ClickType,
   * InventoryAction)}.
   *
   * <p>Method under test: {@link CartographyItemEvent#CartographyItemEvent(InventoryView,
   * InventoryType.SlotType, int, ClickType, InventoryAction)}
   */
  @Test
  @DisplayName(
      "Test new CartographyItemEvent(InventoryView, SlotType, int, ClickType, InventoryAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartographyItemEvent.<init>(InventoryView, InventoryType.SlotType, int, ClickType, InventoryAction)"
  })
  void testNewCartographyItemEvent() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    CartographyItemEvent actualCartographyItemEvent =
        new CartographyItemEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("CartographyItemEvent", actualCartographyItemEvent.getEventName());
    assertNull(actualCartographyItemEvent.getWhoClicked());
    assertNull(actualCartographyItemEvent.getInventory());
    assertNull(actualCartographyItemEvent.getClickedInventory());
    assertNull(actualCartographyItemEvent.getCurrentItem());
    assertNull(actualCartographyItemEvent.getCursor());
    assertEquals(-1, actualCartographyItemEvent.getHotbarButton());
    assertEquals(1, actualCartographyItemEvent.getRawSlot());
    assertEquals(1, actualCartographyItemEvent.getSlot());
    assertEquals(Result.DEFAULT, actualCartographyItemEvent.getResult());
    assertEquals(ClickType.LEFT, actualCartographyItemEvent.getClick());
    assertEquals(InventoryAction.NOTHING, actualCartographyItemEvent.getAction());
    assertEquals(SlotType.RESULT, actualCartographyItemEvent.getSlotType());
    assertFalse(actualCartographyItemEvent.isAsynchronous());
    assertFalse(actualCartographyItemEvent.isRightClick());
    assertFalse(actualCartographyItemEvent.isShiftClick());
    assertFalse(actualCartographyItemEvent.isCancelled());
    assertTrue(actualCartographyItemEvent.isLeftClick());
    assertSame(view, actualCartographyItemEvent.getView());
  }

  /**
   * Test {@link CartographyItemEvent#CartographyItemEvent(InventoryView, SlotType, int, ClickType,
   * InventoryAction, int)}.
   *
   * <p>Method under test: {@link CartographyItemEvent#CartographyItemEvent(InventoryView,
   * InventoryType.SlotType, int, ClickType, InventoryAction, int)}
   */
  @Test
  @DisplayName(
      "Test new CartographyItemEvent(InventoryView, SlotType, int, ClickType, InventoryAction, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartographyItemEvent.<init>(InventoryView, InventoryType.SlotType, int, ClickType, InventoryAction, int)"
  })
  void testNewCartographyItemEvent2() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    CartographyItemEvent actualCartographyItemEvent =
        new CartographyItemEvent(
            view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING, 1);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("CartographyItemEvent", actualCartographyItemEvent.getEventName());
    assertNull(actualCartographyItemEvent.getWhoClicked());
    assertNull(actualCartographyItemEvent.getInventory());
    assertNull(actualCartographyItemEvent.getClickedInventory());
    assertNull(actualCartographyItemEvent.getCurrentItem());
    assertNull(actualCartographyItemEvent.getCursor());
    assertEquals(1, actualCartographyItemEvent.getHotbarButton());
    assertEquals(1, actualCartographyItemEvent.getRawSlot());
    assertEquals(1, actualCartographyItemEvent.getSlot());
    assertEquals(Result.DEFAULT, actualCartographyItemEvent.getResult());
    assertEquals(ClickType.LEFT, actualCartographyItemEvent.getClick());
    assertEquals(InventoryAction.NOTHING, actualCartographyItemEvent.getAction());
    assertEquals(SlotType.RESULT, actualCartographyItemEvent.getSlotType());
    assertFalse(actualCartographyItemEvent.isAsynchronous());
    assertFalse(actualCartographyItemEvent.isRightClick());
    assertFalse(actualCartographyItemEvent.isShiftClick());
    assertFalse(actualCartographyItemEvent.isCancelled());
    assertTrue(actualCartographyItemEvent.isLeftClick());
    assertSame(view, actualCartographyItemEvent.getView());
  }
}
