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
import org.bukkit.inventory.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CraftItemEventDiffblueTest {
  /**
   * Test {@link CraftItemEvent#CraftItemEvent(Recipe, InventoryView, SlotType, int, ClickType,
   * InventoryAction)}.
   *
   * <p>Method under test: {@link CraftItemEvent#CraftItemEvent(Recipe, InventoryView, SlotType,
   * int, ClickType, InventoryAction)}
   */
  @Test
  @DisplayName(
      "Test new CraftItemEvent(Recipe, InventoryView, SlotType, int, ClickType, InventoryAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CraftItemEvent.<init>(Recipe, InventoryView, SlotType, int, ClickType, InventoryAction)"
  })
  void testNewCraftItemEvent() {
    // Arrange
    Recipe recipe = mock(Recipe.class);

    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    CraftItemEvent actualCraftItemEvent =
        new CraftItemEvent(
            recipe, view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("CraftItemEvent", actualCraftItemEvent.getEventName());
    assertNull(actualCraftItemEvent.getWhoClicked());
    assertNull(actualCraftItemEvent.getInventory());
    assertNull(actualCraftItemEvent.getClickedInventory());
    assertNull(actualCraftItemEvent.getCurrentItem());
    assertNull(actualCraftItemEvent.getCursor());
    assertEquals(-1, actualCraftItemEvent.getHotbarButton());
    assertEquals(1, actualCraftItemEvent.getRawSlot());
    assertEquals(1, actualCraftItemEvent.getSlot());
    assertEquals(Result.DEFAULT, actualCraftItemEvent.getResult());
    assertEquals(ClickType.LEFT, actualCraftItemEvent.getClick());
    assertEquals(InventoryAction.NOTHING, actualCraftItemEvent.getAction());
    assertEquals(SlotType.RESULT, actualCraftItemEvent.getSlotType());
    assertFalse(actualCraftItemEvent.isAsynchronous());
    assertFalse(actualCraftItemEvent.isRightClick());
    assertFalse(actualCraftItemEvent.isShiftClick());
    assertFalse(actualCraftItemEvent.isCancelled());
    assertTrue(actualCraftItemEvent.isLeftClick());
    assertSame(view, actualCraftItemEvent.getView());
    assertSame(recipe, actualCraftItemEvent.getRecipe());
  }

  /**
   * Test {@link CraftItemEvent#CraftItemEvent(Recipe, InventoryView, SlotType, int, ClickType,
   * InventoryAction, int)}.
   *
   * <p>Method under test: {@link CraftItemEvent#CraftItemEvent(Recipe, InventoryView, SlotType,
   * int, ClickType, InventoryAction, int)}
   */
  @Test
  @DisplayName(
      "Test new CraftItemEvent(Recipe, InventoryView, SlotType, int, ClickType, InventoryAction, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CraftItemEvent.<init>(Recipe, InventoryView, SlotType, int, ClickType, InventoryAction, int)"
  })
  void testNewCraftItemEvent2() {
    // Arrange
    Recipe recipe = mock(Recipe.class);

    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    CraftItemEvent actualCraftItemEvent =
        new CraftItemEvent(
            recipe, view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING, 1);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("CraftItemEvent", actualCraftItemEvent.getEventName());
    assertNull(actualCraftItemEvent.getWhoClicked());
    assertNull(actualCraftItemEvent.getInventory());
    assertNull(actualCraftItemEvent.getClickedInventory());
    assertNull(actualCraftItemEvent.getCurrentItem());
    assertNull(actualCraftItemEvent.getCursor());
    assertEquals(1, actualCraftItemEvent.getHotbarButton());
    assertEquals(1, actualCraftItemEvent.getRawSlot());
    assertEquals(1, actualCraftItemEvent.getSlot());
    assertEquals(Result.DEFAULT, actualCraftItemEvent.getResult());
    assertEquals(ClickType.LEFT, actualCraftItemEvent.getClick());
    assertEquals(InventoryAction.NOTHING, actualCraftItemEvent.getAction());
    assertEquals(SlotType.RESULT, actualCraftItemEvent.getSlotType());
    assertFalse(actualCraftItemEvent.isAsynchronous());
    assertFalse(actualCraftItemEvent.isRightClick());
    assertFalse(actualCraftItemEvent.isShiftClick());
    assertFalse(actualCraftItemEvent.isCancelled());
    assertTrue(actualCraftItemEvent.isLeftClick());
    assertSame(view, actualCraftItemEvent.getView());
    assertSame(recipe, actualCraftItemEvent.getRecipe());
  }
}
