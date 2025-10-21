package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.event.entity.EndermanEscapeEvent.Reason;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Enderman;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EndermanEscapeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EndermanEscapeEvent#EndermanEscapeEvent(Enderman, Reason)}
   *   <li>{@link EndermanEscapeEvent#setCancelled(boolean)}
   *   <li>{@link EndermanEscapeEvent#getHandlerList()}
   *   <li>{@link EndermanEscapeEvent#getHandlers()}
   *   <li>{@link EndermanEscapeEvent#getReason()}
   *   <li>{@link EndermanEscapeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EndermanEscapeEvent.<init>(Enderman, Reason)",
    "HandlerList EndermanEscapeEvent.getHandlerList()",
    "HandlerList EndermanEscapeEvent.getHandlers()",
    "Reason EndermanEscapeEvent.getReason()",
    "boolean EndermanEscapeEvent.isCancelled()",
    "void EndermanEscapeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Enderman entity = mock(Enderman.class);

    // Act
    EndermanEscapeEvent actualEndermanEscapeEvent = new EndermanEscapeEvent(entity, Reason.RUNAWAY);
    actualEndermanEscapeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEndermanEscapeEvent.getHandlerList();
    HandlerList actualHandlers = actualEndermanEscapeEvent.getHandlers();
    Reason actualReason = actualEndermanEscapeEvent.getReason();
    boolean actualIsCancelledResult = actualEndermanEscapeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Reason.RUNAWAY, actualReason);
    assertFalse(actualEndermanEscapeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEndermanEscapeEvent.getEntity());
  }
}
