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
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryCloseEvent.Reason;
import org.bukkit.inventory.InventoryView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InventoryCloseEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryCloseEvent#InventoryCloseEvent(InventoryView, Reason)}
   *   <li>{@link InventoryCloseEvent#getHandlerList()}
   *   <li>{@link InventoryCloseEvent#getHandlers()}
   *   <li>{@link InventoryCloseEvent#getReason()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryCloseEvent.<init>(InventoryView, Reason)",
    "HandlerList InventoryCloseEvent.getHandlerList()",
    "HandlerList InventoryCloseEvent.getHandlers()",
    "Reason InventoryCloseEvent.getReason()"
  })
  void testGettersAndSetters() {
    // Arrange
    InventoryView transaction = mock(InventoryView.class);

    // Act
    InventoryCloseEvent actualInventoryCloseEvent =
        new InventoryCloseEvent(transaction, Reason.UNKNOWN);
    HandlerList actualHandlerList = actualInventoryCloseEvent.getHandlerList();
    HandlerList actualHandlers = actualInventoryCloseEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Reason.UNKNOWN, actualInventoryCloseEvent.getReason());
    assertFalse(actualInventoryCloseEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(transaction, actualInventoryCloseEvent.getView());
  }

  /**
   * Test {@link InventoryCloseEvent#InventoryCloseEvent(InventoryView)}.
   *
   * <p>Method under test: {@link InventoryCloseEvent#InventoryCloseEvent(InventoryView)}
   */
  @Test
  @DisplayName("Test new InventoryCloseEvent(InventoryView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryCloseEvent.<init>(InventoryView)"})
  void testNewInventoryCloseEvent() {
    // Arrange
    InventoryView transaction = mock(InventoryView.class);

    // Act
    InventoryCloseEvent actualInventoryCloseEvent = new InventoryCloseEvent(transaction);

    // Assert
    assertEquals("InventoryCloseEvent", actualInventoryCloseEvent.getEventName());
    assertNull(actualInventoryCloseEvent.getPlayer());
    assertNull(actualInventoryCloseEvent.getInventory());
    assertEquals(0, actualInventoryCloseEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Reason.UNKNOWN, actualInventoryCloseEvent.getReason());
    assertFalse(actualInventoryCloseEvent.isAsynchronous());
    assertSame(transaction, actualInventoryCloseEvent.getView());
  }

  /**
   * Test {@link InventoryCloseEvent#getPlayer()}.
   *
   * <p>Method under test: {@link InventoryCloseEvent#getPlayer()}
   */
  @Test
  @DisplayName("Test getPlayer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HumanEntity InventoryCloseEvent.getPlayer()"})
  void testGetPlayer() {
    // Arrange
    InventoryView transaction = mock(InventoryView.class);
    when(transaction.getPlayer()).thenReturn(mock(HumanEntity.class));

    // Act
    new InventoryCloseEvent(transaction).getPlayer();

    // Assert
    verify(transaction).getPlayer();
  }
}
