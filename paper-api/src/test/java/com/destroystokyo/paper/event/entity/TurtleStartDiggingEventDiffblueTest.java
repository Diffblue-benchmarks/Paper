package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Turtle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TurtleStartDiggingEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TurtleStartDiggingEvent#TurtleStartDiggingEvent(Turtle, Location)}
   *   <li>{@link TurtleStartDiggingEvent#setCancelled(boolean)}
   *   <li>{@link TurtleStartDiggingEvent#getHandlerList()}
   *   <li>{@link TurtleStartDiggingEvent#getHandlers()}
   *   <li>{@link TurtleStartDiggingEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TurtleStartDiggingEvent.<init>(Turtle, Location)",
    "HandlerList TurtleStartDiggingEvent.getHandlerList()",
    "HandlerList TurtleStartDiggingEvent.getHandlers()",
    "boolean TurtleStartDiggingEvent.isCancelled()",
    "void TurtleStartDiggingEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Turtle turtle = mock(Turtle.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    TurtleStartDiggingEvent actualTurtleStartDiggingEvent =
        new TurtleStartDiggingEvent(turtle, location);
    actualTurtleStartDiggingEvent.setCancelled(true);
    HandlerList actualHandlerList = actualTurtleStartDiggingEvent.getHandlerList();
    HandlerList actualHandlers = actualTurtleStartDiggingEvent.getHandlers();
    boolean actualIsCancelledResult = actualTurtleStartDiggingEvent.isCancelled();

    // Assert
    assertFalse(actualTurtleStartDiggingEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(turtle, actualTurtleStartDiggingEvent.getEntity());
  }

  /**
   * Test {@link TurtleStartDiggingEvent#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link TurtleStartDiggingEvent#getLocation()}
   */
  @Test
  @DisplayName(
      "Test getLocation(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location TurtleStartDiggingEvent.getLocation()"})
  void testGetLocation_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Turtle turtle = mock(Turtle.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    TurtleStartDiggingEvent turtleStartDiggingEvent = new TurtleStartDiggingEvent(turtle, location);

    // Act and Assert
    assertEquals(location, turtleStartDiggingEvent.getLocation());
  }
}
