package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Turtle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TurtleGoHomeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TurtleGoHomeEvent#TurtleGoHomeEvent(Turtle)}
   *   <li>{@link TurtleGoHomeEvent#setCancelled(boolean)}
   *   <li>{@link TurtleGoHomeEvent#getHandlerList()}
   *   <li>{@link TurtleGoHomeEvent#getHandlers()}
   *   <li>{@link TurtleGoHomeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TurtleGoHomeEvent.<init>(Turtle)",
    "HandlerList TurtleGoHomeEvent.getHandlerList()",
    "HandlerList TurtleGoHomeEvent.getHandlers()",
    "boolean TurtleGoHomeEvent.isCancelled()",
    "void TurtleGoHomeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Turtle turtle = mock(Turtle.class);

    // Act
    TurtleGoHomeEvent actualTurtleGoHomeEvent = new TurtleGoHomeEvent(turtle);
    actualTurtleGoHomeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualTurtleGoHomeEvent.getHandlerList();
    HandlerList actualHandlers = actualTurtleGoHomeEvent.getHandlers();
    boolean actualIsCancelledResult = actualTurtleGoHomeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualTurtleGoHomeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(turtle, actualTurtleGoHomeEvent.getEntity());
  }
}
