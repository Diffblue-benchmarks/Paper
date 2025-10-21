package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Result;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InventoryClickEventDiffblueTest {
  /**
   * Test {@link InventoryClickEvent#InventoryClickEvent(InventoryView, SlotType, int, ClickType,
   * InventoryAction)}.
   *
   * <p>Method under test: {@link InventoryClickEvent#InventoryClickEvent(InventoryView, SlotType,
   * int, ClickType, InventoryAction)}
   */
  @Test
  @DisplayName(
      "Test new InventoryClickEvent(InventoryView, SlotType, int, ClickType, InventoryAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryClickEvent.<init>(InventoryView, SlotType, int, ClickType, InventoryAction)"
  })
  void testNewInventoryClickEvent() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    InventoryClickEvent actualInventoryClickEvent =
        new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("InventoryClickEvent", actualInventoryClickEvent.getEventName());
    assertNull(actualInventoryClickEvent.getWhoClicked());
    assertNull(actualInventoryClickEvent.getClickedInventory());
    assertNull(actualInventoryClickEvent.getInventory());
    assertNull(actualInventoryClickEvent.getCurrentItem());
    assertNull(actualInventoryClickEvent.getCursor());
    assertEquals(-1, actualInventoryClickEvent.getHotbarButton());
    assertEquals(1, actualInventoryClickEvent.getRawSlot());
    assertEquals(1, actualInventoryClickEvent.getSlot());
    assertEquals(Result.DEFAULT, actualInventoryClickEvent.getResult());
    assertEquals(ClickType.LEFT, actualInventoryClickEvent.getClick());
    assertEquals(InventoryAction.NOTHING, actualInventoryClickEvent.getAction());
    assertEquals(SlotType.RESULT, actualInventoryClickEvent.getSlotType());
    assertFalse(actualInventoryClickEvent.isAsynchronous());
    assertFalse(actualInventoryClickEvent.isRightClick());
    assertFalse(actualInventoryClickEvent.isShiftClick());
    assertFalse(actualInventoryClickEvent.isCancelled());
    assertTrue(actualInventoryClickEvent.isLeftClick());
    assertSame(view, actualInventoryClickEvent.getView());
  }

  /**
   * Test {@link InventoryClickEvent#InventoryClickEvent(InventoryView, SlotType, int, ClickType,
   * InventoryAction, int)}.
   *
   * <p>Method under test: {@link InventoryClickEvent#InventoryClickEvent(InventoryView, SlotType,
   * int, ClickType, InventoryAction, int)}
   */
  @Test
  @DisplayName(
      "Test new InventoryClickEvent(InventoryView, SlotType, int, ClickType, InventoryAction, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryClickEvent.<init>(InventoryView, SlotType, int, ClickType, InventoryAction, int)"
  })
  void testNewInventoryClickEvent2() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    InventoryClickEvent actualInventoryClickEvent =
        new InventoryClickEvent(
            view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING, 1);

    // Assert
    verify(view).convertSlot(1);
    assertEquals("InventoryClickEvent", actualInventoryClickEvent.getEventName());
    assertNull(actualInventoryClickEvent.getWhoClicked());
    assertNull(actualInventoryClickEvent.getClickedInventory());
    assertNull(actualInventoryClickEvent.getInventory());
    assertNull(actualInventoryClickEvent.getCurrentItem());
    assertNull(actualInventoryClickEvent.getCursor());
    assertEquals(1, actualInventoryClickEvent.getHotbarButton());
    assertEquals(1, actualInventoryClickEvent.getRawSlot());
    assertEquals(1, actualInventoryClickEvent.getSlot());
    assertEquals(Result.DEFAULT, actualInventoryClickEvent.getResult());
    assertEquals(ClickType.LEFT, actualInventoryClickEvent.getClick());
    assertEquals(InventoryAction.NOTHING, actualInventoryClickEvent.getAction());
    assertEquals(SlotType.RESULT, actualInventoryClickEvent.getSlotType());
    assertFalse(actualInventoryClickEvent.isAsynchronous());
    assertFalse(actualInventoryClickEvent.isRightClick());
    assertFalse(actualInventoryClickEvent.isShiftClick());
    assertFalse(actualInventoryClickEvent.isCancelled());
    assertTrue(actualInventoryClickEvent.isLeftClick());
    assertSame(view, actualInventoryClickEvent.getView());
  }

  /**
   * Test {@link InventoryClickEvent#getCurrentItem()}.
   *
   * <p>Method under test: {@link InventoryClickEvent#getCurrentItem()}
   */
  @Test
  @DisplayName("Test getCurrentItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack InventoryClickEvent.getCurrentItem()"})
  void testGetCurrentItem() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);
    InventoryClickEvent inventoryClickEvent =
        new InventoryClickEvent(view, SlotType.OUTSIDE, 1, ClickType.LEFT, InventoryAction.NOTHING);

    // Act
    ItemStack actualCurrentItem = inventoryClickEvent.getCurrentItem();

    // Assert
    verify(view).convertSlot(1);
    assertNull(actualCurrentItem);
  }

  /**
   * Test {@link InventoryClickEvent#isRightClick()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryClickEvent#isRightClick()}
   */
  @Test
  @DisplayName("Test isRightClick(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryClickEvent.isRightClick()"})
  void testIsRightClick_thenReturnFalse() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    boolean actualIsRightClickResult =
        new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING)
            .isRightClick();

    // Assert
    verify(view).convertSlot(1);
    assertFalse(actualIsRightClickResult);
  }

  /**
   * Test {@link InventoryClickEvent#isRightClick()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryClickEvent#isRightClick()}
   */
  @Test
  @DisplayName("Test isRightClick(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryClickEvent.isRightClick()"})
  void testIsRightClick_thenReturnTrue() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    boolean actualIsRightClickResult =
        new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.RIGHT, InventoryAction.NOTHING)
            .isRightClick();

    // Assert
    verify(view).convertSlot(1);
    assertTrue(actualIsRightClickResult);
  }

  /**
   * Test {@link InventoryClickEvent#isLeftClick()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryClickEvent#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryClickEvent.isLeftClick()"})
  void testIsLeftClick_thenReturnFalse() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    boolean actualIsLeftClickResult =
        new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.RIGHT, InventoryAction.NOTHING)
            .isLeftClick();

    // Assert
    verify(view).convertSlot(1);
    assertFalse(actualIsLeftClickResult);
  }

  /**
   * Test {@link InventoryClickEvent#isLeftClick()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryClickEvent#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryClickEvent.isLeftClick()"})
  void testIsLeftClick_thenReturnTrue() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    boolean actualIsLeftClickResult =
        new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING)
            .isLeftClick();

    // Assert
    verify(view).convertSlot(1);
    assertTrue(actualIsLeftClickResult);
  }

  /**
   * Test {@link InventoryClickEvent#isShiftClick()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryClickEvent#isShiftClick()}
   */
  @Test
  @DisplayName("Test isShiftClick(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryClickEvent.isShiftClick()"})
  void testIsShiftClick_thenReturnFalse() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    boolean actualIsShiftClickResult =
        new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING)
            .isShiftClick();

    // Assert
    verify(view).convertSlot(1);
    assertFalse(actualIsShiftClickResult);
  }

  /**
   * Test {@link InventoryClickEvent#isShiftClick()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryClickEvent#isShiftClick()}
   */
  @Test
  @DisplayName("Test isShiftClick(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryClickEvent.isShiftClick()"})
  void testIsShiftClick_thenReturnTrue() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    boolean actualIsShiftClickResult =
        new InventoryClickEvent(
                view, SlotType.RESULT, 1, ClickType.SHIFT_LEFT, InventoryAction.NOTHING)
            .isShiftClick();

    // Assert
    verify(view).convertSlot(1);
    assertTrue(actualIsShiftClickResult);
  }

  /**
   * Test {@link InventoryClickEvent#setCursor(ItemStack)}.
   *
   * <ul>
   *   <li>Given {@link InventoryView} {@link InventoryView#convertSlot(int)} return one.
   *   <li>Then calls {@link InventoryView#convertSlot(int)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryClickEvent#setCursor(ItemStack)}
   */
  @Test
  @DisplayName(
      "Test setCursor(ItemStack); given InventoryView convertSlot(int) return one; then calls convertSlot(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryClickEvent.setCursor(ItemStack)"})
  void testSetCursor_givenInventoryViewConvertSlotReturnOne_thenCallsConvertSlot() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);
    doNothing().when(view).setCursor(Mockito.<ItemStack>any());

    // Act
    new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING)
        .setCursor(null);

    // Assert
    verify(view).convertSlot(1);
    verify(view).setCursor(isNull());
  }

  /**
   * Test {@link InventoryClickEvent#setCurrentItem(ItemStack)}.
   *
   * <p>Method under test: {@link InventoryClickEvent#setCurrentItem(ItemStack)}
   */
  @Test
  @DisplayName("Test setCurrentItem(ItemStack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryClickEvent.setCurrentItem(ItemStack)"})
  void testSetCurrentItem() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    // Act
    new InventoryClickEvent(view, SlotType.OUTSIDE, 1, ClickType.LEFT, InventoryAction.NOTHING)
        .setCurrentItem(null);

    // Assert
    verify(view).convertSlot(1);
  }

  /**
   * Test {@link InventoryClickEvent#setCurrentItem(ItemStack)}.
   *
   * <ul>
   *   <li>Given {@link InventoryView} {@link InventoryView#setItem(int, ItemStack)} does nothing.
   *   <li>Then calls {@link InventoryView#setItem(int, ItemStack)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryClickEvent#setCurrentItem(ItemStack)}
   */
  @Test
  @DisplayName(
      "Test setCurrentItem(ItemStack); given InventoryView setItem(int, ItemStack) does nothing; then calls setItem(int, ItemStack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryClickEvent.setCurrentItem(ItemStack)"})
  void testSetCurrentItem_givenInventoryViewSetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);
    doNothing().when(view).setItem(anyInt(), Mockito.<ItemStack>any());

    // Act
    new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING)
        .setCurrentItem(null);

    // Assert
    verify(view).convertSlot(1);
    verify(view).setItem(eq(1), isNull());
  }

  /**
   * Test {@link InventoryClickEvent#getClickedInventory()}.
   *
   * <p>Method under test: {@link InventoryClickEvent#getClickedInventory()}
   */
  @Test
  @DisplayName("Test getClickedInventory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Inventory InventoryClickEvent.getClickedInventory()"})
  void testGetClickedInventory() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);
    when(view.getInventory(anyInt())).thenReturn(mock(Inventory.class));

    // Act
    new InventoryClickEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING)
        .getClickedInventory();

    // Assert
    verify(view).convertSlot(1);
    verify(view).getInventory(1);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryClickEvent#getHandlerList()}
   *   <li>{@link InventoryClickEvent#getAction()}
   *   <li>{@link InventoryClickEvent#getClick()}
   *   <li>{@link InventoryClickEvent#getHandlers()}
   *   <li>{@link InventoryClickEvent#getHotbarButton()}
   *   <li>{@link InventoryClickEvent#getRawSlot()}
   *   <li>{@link InventoryClickEvent#getSlot()}
   *   <li>{@link InventoryClickEvent#getSlotType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InventoryAction InventoryClickEvent.getAction()",
    "ClickType InventoryClickEvent.getClick()",
    "HandlerList InventoryClickEvent.getHandlerList()",
    "HandlerList InventoryClickEvent.getHandlers()",
    "int InventoryClickEvent.getHotbarButton()",
    "int InventoryClickEvent.getRawSlot()",
    "int InventoryClickEvent.getSlot()",
    "SlotType InventoryClickEvent.getSlotType()"
  })
  void testGettersAndSetters() {
    // Arrange
    InventoryClickEvent inventoryClickEvent =
        new InventoryClickEvent(
            mock(InventoryView.class), SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING);

    // Act
    HandlerList actualHandlerList = inventoryClickEvent.getHandlerList();
    InventoryAction actualAction = inventoryClickEvent.getAction();
    ClickType actualClick = inventoryClickEvent.getClick();
    HandlerList actualHandlers = inventoryClickEvent.getHandlers();
    int actualHotbarButton = inventoryClickEvent.getHotbarButton();
    int actualRawSlot = inventoryClickEvent.getRawSlot();
    int actualSlot = inventoryClickEvent.getSlot();

    // Assert
    assertEquals(-1, actualHotbarButton);
    assertEquals(0, actualSlot);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualRawSlot);
    assertEquals(ClickType.LEFT, actualClick);
    assertEquals(InventoryAction.NOTHING, actualAction);
    assertEquals(SlotType.RESULT, inventoryClickEvent.getSlotType());
    assertSame(actualHandlerList, actualHandlers);
  }
}
