package org.bukkit.event.hanging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Hanging;
import org.bukkit.event.HandlerList;
import org.bukkit.event.hanging.HangingBreakEvent.RemoveCause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HangingBreakEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HangingBreakEvent#HangingBreakEvent(Hanging, RemoveCause)}
   *   <li>{@link HangingBreakEvent#setCancelled(boolean)}
   *   <li>{@link HangingBreakEvent#getHandlerList()}
   *   <li>{@link HangingBreakEvent#getCause()}
   *   <li>{@link HangingBreakEvent#getHandlers()}
   *   <li>{@link HangingBreakEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HangingBreakEvent.<init>(Hanging, RemoveCause)",
    "RemoveCause HangingBreakEvent.getCause()",
    "HandlerList HangingBreakEvent.getHandlerList()",
    "HandlerList HangingBreakEvent.getHandlers()",
    "boolean HangingBreakEvent.isCancelled()",
    "void HangingBreakEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Hanging hanging = mock(Hanging.class);

    // Act
    HangingBreakEvent actualHangingBreakEvent = new HangingBreakEvent(hanging, RemoveCause.ENTITY);
    actualHangingBreakEvent.setCancelled(true);
    HandlerList actualHandlerList = actualHangingBreakEvent.getHandlerList();
    RemoveCause actualCause = actualHangingBreakEvent.getCause();
    HandlerList actualHandlers = actualHangingBreakEvent.getHandlers();
    boolean actualIsCancelledResult = actualHangingBreakEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(RemoveCause.ENTITY, actualCause);
    assertFalse(actualHangingBreakEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hanging, actualHangingBreakEvent.getEntity());
  }
}
