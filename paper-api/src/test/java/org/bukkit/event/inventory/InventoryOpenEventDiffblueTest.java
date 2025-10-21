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
import net.kyori.adventure.text.Component;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InventoryOpenEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryOpenEvent#InventoryOpenEvent(InventoryView)}
   *   <li>{@link InventoryOpenEvent#setCancelled(boolean)}
   *   <li>{@link InventoryOpenEvent#titleOverride(Component)}
   *   <li>{@link InventoryOpenEvent#getHandlerList()}
   *   <li>{@link InventoryOpenEvent#getHandlers()}
   *   <li>{@link InventoryOpenEvent#isCancelled()}
   *   <li>{@link InventoryOpenEvent#titleOverride()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryOpenEvent.<init>(InventoryView)",
    "HandlerList InventoryOpenEvent.getHandlerList()",
    "HandlerList InventoryOpenEvent.getHandlers()",
    "boolean InventoryOpenEvent.isCancelled()",
    "void InventoryOpenEvent.setCancelled(boolean)",
    "Component InventoryOpenEvent.titleOverride()",
    "void InventoryOpenEvent.titleOverride(Component)"
  })
  void testGettersAndSetters() {
    // Arrange
    InventoryView transaction = mock(InventoryView.class);

    // Act
    InventoryOpenEvent actualInventoryOpenEvent = new InventoryOpenEvent(transaction);
    actualInventoryOpenEvent.setCancelled(true);
    Component titleOverride = mock(Component.class);
    actualInventoryOpenEvent.titleOverride(titleOverride);
    HandlerList actualHandlerList = actualInventoryOpenEvent.getHandlerList();
    HandlerList actualHandlers = actualInventoryOpenEvent.getHandlers();
    boolean actualIsCancelledResult = actualInventoryOpenEvent.isCancelled();
    Component actualTitleOverrideResult = actualInventoryOpenEvent.titleOverride();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualInventoryOpenEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(titleOverride, actualTitleOverrideResult);
    assertSame(transaction, actualInventoryOpenEvent.getView());
  }

  /**
   * Test {@link InventoryOpenEvent#getPlayer()}.
   *
   * <p>Method under test: {@link InventoryOpenEvent#getPlayer()}
   */
  @Test
  @DisplayName("Test getPlayer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HumanEntity InventoryOpenEvent.getPlayer()"})
  void testGetPlayer() {
    // Arrange
    InventoryView transaction = mock(InventoryView.class);
    when(transaction.getPlayer()).thenReturn(mock(HumanEntity.class));

    // Act
    new InventoryOpenEvent(transaction).getPlayer();

    // Assert
    verify(transaction).getPlayer();
  }
}
