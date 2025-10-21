package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InventoryEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryEvent#InventoryEvent(InventoryView)}
   *   <li>{@link InventoryEvent#getHandlerList()}
   *   <li>{@link InventoryEvent#getHandlers()}
   *   <li>{@link InventoryEvent#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryEvent.<init>(InventoryView)",
    "HandlerList InventoryEvent.getHandlerList()",
    "HandlerList InventoryEvent.getHandlers()",
    "InventoryView InventoryEvent.getView()"
  })
  void testGettersAndSetters() {
    // Arrange
    InventoryView transaction = mock(InventoryView.class);

    // Act
    InventoryEvent actualInventoryEvent = new InventoryEvent(transaction);
    HandlerList actualHandlerList = actualInventoryEvent.getHandlerList();
    HandlerList actualHandlers = actualInventoryEvent.getHandlers();
    InventoryView actualView = actualInventoryEvent.getView();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualInventoryEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(transaction, actualView);
  }

  /**
   * Test {@link InventoryEvent#getInventory()}.
   *
   * <p>Method under test: {@link InventoryEvent#getInventory()}
   */
  @Test
  @DisplayName("Test getInventory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Inventory InventoryEvent.getInventory()"})
  void testGetInventory() {
    // Arrange
    InventoryView transaction = mock(InventoryView.class);
    when(transaction.getTopInventory()).thenReturn(mock(Inventory.class));

    // Act
    new InventoryEvent(transaction).getInventory();

    // Assert
    verify(transaction).getTopInventory();
  }

  /**
   * Test {@link InventoryEvent#getViewers()}.
   *
   * <p>Method under test: {@link InventoryEvent#getViewers()}
   */
  @Test
  @DisplayName("Test getViewers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InventoryEvent.getViewers()"})
  void testGetViewers() {
    // Arrange
    Inventory inventory = mock(Inventory.class);
    when(inventory.getViewers()).thenReturn(new ArrayList<>());

    InventoryView transaction = mock(InventoryView.class);
    when(transaction.getTopInventory()).thenReturn(inventory);

    // Act
    List<HumanEntity> actualViewers = new InventoryEvent(transaction).getViewers();

    // Assert
    verify(inventory).getViewers();
    verify(transaction).getTopInventory();
    assertTrue(actualViewers.isEmpty());
  }
}
