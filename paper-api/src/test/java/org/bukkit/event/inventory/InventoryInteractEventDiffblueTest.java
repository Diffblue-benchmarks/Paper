package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.player.CartographyItemEvent;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Result;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.view.MerchantView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InventoryInteractEventDiffblueTest {
  /**
   * Test {@link InventoryInteractEvent#getWhoClicked()}.
   *
   * <p>Method under test: {@link InventoryInteractEvent#getWhoClicked()}
   */
  @Test
  @DisplayName("Test getWhoClicked()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HumanEntity InventoryInteractEvent.getWhoClicked()"})
  void testGetWhoClicked() {
    // Arrange
    MerchantView transaction = mock(MerchantView.class);
    when(transaction.getPlayer()).thenReturn(mock(HumanEntity.class));

    // Act
    new TradeSelectEvent(transaction, 1).getWhoClicked();

    // Assert
    verify(transaction).getPlayer();
  }

  /**
   * Test {@link InventoryInteractEvent#setResult(Result)}.
   *
   * <p>Method under test: {@link InventoryInteractEvent#setResult(Result)}
   */
  @Test
  @DisplayName("Test setResult(Result)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryInteractEvent.setResult(Result)"})
  void testSetResult() {
    // Arrange
    TradeSelectEvent tradeSelectEvent = new TradeSelectEvent(mock(MerchantView.class), 1);

    // Act
    tradeSelectEvent.setResult(Result.DENY);

    // Assert
    assertEquals(Result.DENY, tradeSelectEvent.getResult());
    assertTrue(tradeSelectEvent.isCancelled());
  }

  /**
   * Test {@link InventoryInteractEvent#getResult()}.
   *
   * <p>Method under test: {@link InventoryInteractEvent#getResult()}
   */
  @Test
  @DisplayName("Test getResult()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result InventoryInteractEvent.getResult()"})
  void testGetResult() {
    // Arrange, Act and Assert
    assertEquals(Result.DEFAULT, new TradeSelectEvent(mock(MerchantView.class), 1).getResult());
  }

  /**
   * Test {@link InventoryInteractEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Given {@link InventoryView} {@link InventoryView#convertSlot(int)} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryInteractEvent#isCancelled()}
   */
  @Test
  @DisplayName(
      "Test isCancelled(); given InventoryView convertSlot(int) return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryInteractEvent.isCancelled()"})
  void testIsCancelled_givenInventoryViewConvertSlotReturnOne_thenReturnTrue() {
    // Arrange
    InventoryView view = mock(InventoryView.class);
    when(view.convertSlot(anyInt())).thenReturn(1);

    CartographyItemEvent cartographyItemEvent =
        new CartographyItemEvent(view, SlotType.RESULT, 1, ClickType.LEFT, InventoryAction.NOTHING);
    cartographyItemEvent.setResult(Result.DENY);

    // Act
    boolean actualIsCancelledResult = cartographyItemEvent.isCancelled();

    // Assert
    verify(view).convertSlot(1);
    assertTrue(actualIsCancelledResult);
  }

  /**
   * Test {@link InventoryInteractEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryInteractEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryInteractEvent.isCancelled()"})
  void testIsCancelled_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TradeSelectEvent(mock(MerchantView.class), 1).isCancelled());
  }

  /**
   * Test {@link InventoryInteractEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link InventoryInteractEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryInteractEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    TradeSelectEvent tradeSelectEvent = new TradeSelectEvent(mock(MerchantView.class), 1);

    // Act
    tradeSelectEvent.setCancelled(true);

    // Assert
    assertEquals(Result.DENY, tradeSelectEvent.getResult());
    assertTrue(tradeSelectEvent.isCancelled());
  }

  /**
   * Test {@link InventoryInteractEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link InventoryInteractEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryInteractEvent.setCancelled(boolean)"})
  void testSetCancelled2() {
    // Arrange
    TradeSelectEvent tradeSelectEvent = new TradeSelectEvent(mock(MerchantView.class), 1);

    // Act
    tradeSelectEvent.setCancelled(false);

    // Assert
    assertEquals(Result.ALLOW, tradeSelectEvent.getResult());
    assertFalse(tradeSelectEvent.isCancelled());
  }
}
