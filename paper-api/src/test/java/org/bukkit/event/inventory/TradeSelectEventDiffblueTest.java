package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Result;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.view.MerchantView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TradeSelectEventDiffblueTest {
  /**
   * Test {@link TradeSelectEvent#TradeSelectEvent(MerchantView, int)}.
   *
   * <p>Method under test: {@link TradeSelectEvent#TradeSelectEvent(MerchantView, int)}
   */
  @Test
  @DisplayName("Test new TradeSelectEvent(MerchantView, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeSelectEvent.<init>(MerchantView, int)"})
  void testNewTradeSelectEvent() {
    // Arrange
    MerchantView transaction = mock(MerchantView.class);

    // Act
    TradeSelectEvent actualTradeSelectEvent = new TradeSelectEvent(transaction, 1);

    // Assert
    assertEquals("TradeSelectEvent", actualTradeSelectEvent.getEventName());
    assertNull(actualTradeSelectEvent.getWhoClicked());
    assertNull(actualTradeSelectEvent.getInventory());
    assertEquals(0, actualTradeSelectEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1, actualTradeSelectEvent.getIndex());
    assertEquals(Result.DEFAULT, actualTradeSelectEvent.getResult());
    assertFalse(actualTradeSelectEvent.isAsynchronous());
    assertFalse(actualTradeSelectEvent.isCancelled());
    assertSame(transaction, actualTradeSelectEvent.getView());
  }

  /**
   * Test {@link TradeSelectEvent#getInventory()}.
   *
   * <p>Method under test: {@link TradeSelectEvent#getInventory()}
   */
  @Test
  @DisplayName("Test getInventory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MerchantInventory TradeSelectEvent.getInventory()"})
  void testGetInventory() {
    // Arrange
    MerchantView transaction = mock(MerchantView.class);
    when(transaction.getTopInventory()).thenReturn(mock(MerchantInventory.class));

    // Act
    new TradeSelectEvent(transaction, 1).getInventory();

    // Assert
    verify(transaction).getTopInventory();
  }

  /**
   * Test {@link TradeSelectEvent#getMerchant()}.
   *
   * <p>Method under test: {@link TradeSelectEvent#getMerchant()}
   */
  @Test
  @DisplayName("Test getMerchant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Merchant TradeSelectEvent.getMerchant()"})
  void testGetMerchant() {
    // Arrange
    MerchantInventory merchantInventory = mock(MerchantInventory.class);
    when(merchantInventory.getMerchant()).thenReturn(mock(Merchant.class));

    MerchantView transaction = mock(MerchantView.class);
    when(transaction.getTopInventory()).thenReturn(merchantInventory);

    // Act
    new TradeSelectEvent(transaction, 1).getMerchant();

    // Assert
    verify(merchantInventory).getMerchant();
    verify(transaction).getTopInventory();
  }

  /**
   * Test {@link TradeSelectEvent#getView()}.
   *
   * <p>Method under test: {@link TradeSelectEvent#getView()}
   */
  @Test
  @DisplayName("Test getView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MerchantView TradeSelectEvent.getView()"})
  void testGetView() {
    // Arrange
    TradeSelectEvent tradeSelectEvent = new TradeSelectEvent(mock(MerchantView.class), 1);

    // Act
    MerchantView actualView = tradeSelectEvent.getView();

    // Assert
    assertSame(tradeSelectEvent.transaction, actualView);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TradeSelectEvent#getHandlerList()}
   *   <li>{@link TradeSelectEvent#getHandlers()}
   *   <li>{@link TradeSelectEvent#getIndex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList TradeSelectEvent.getHandlerList()",
    "HandlerList TradeSelectEvent.getHandlers()",
    "int TradeSelectEvent.getIndex()"
  })
  void testGettersAndSetters() {
    // Arrange
    TradeSelectEvent tradeSelectEvent = new TradeSelectEvent(mock(MerchantView.class), 1);

    // Act
    HandlerList actualHandlerList = tradeSelectEvent.getHandlerList();
    HandlerList actualHandlers = tradeSelectEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, tradeSelectEvent.getIndex());
    assertSame(actualHandlerList, actualHandlers);
  }
}
