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

class TurtleLayEggEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TurtleLayEggEvent#TurtleLayEggEvent(Turtle, Location, int)}
   *   <li>{@link TurtleLayEggEvent#setCancelled(boolean)}
   *   <li>{@link TurtleLayEggEvent#getHandlerList()}
   *   <li>{@link TurtleLayEggEvent#getEggCount()}
   *   <li>{@link TurtleLayEggEvent#getHandlers()}
   *   <li>{@link TurtleLayEggEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TurtleLayEggEvent.<init>(Turtle, Location, int)",
    "int TurtleLayEggEvent.getEggCount()",
    "HandlerList TurtleLayEggEvent.getHandlerList()",
    "HandlerList TurtleLayEggEvent.getHandlers()",
    "boolean TurtleLayEggEvent.isCancelled()",
    "void TurtleLayEggEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Turtle turtle = mock(Turtle.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    TurtleLayEggEvent actualTurtleLayEggEvent = new TurtleLayEggEvent(turtle, location, 3);
    actualTurtleLayEggEvent.setCancelled(true);
    HandlerList actualHandlerList = actualTurtleLayEggEvent.getHandlerList();
    int actualEggCount = actualTurtleLayEggEvent.getEggCount();
    HandlerList actualHandlers = actualTurtleLayEggEvent.getHandlers();
    boolean actualIsCancelledResult = actualTurtleLayEggEvent.isCancelled();

    // Assert
    assertEquals(3, actualEggCount);
    assertFalse(actualTurtleLayEggEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(turtle, actualTurtleLayEggEvent.getEntity());
  }

  /**
   * Test {@link TurtleLayEggEvent#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link TurtleLayEggEvent#getLocation()}
   */
  @Test
  @DisplayName(
      "Test getLocation(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location TurtleLayEggEvent.getLocation()"})
  void testGetLocation_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Turtle turtle = mock(Turtle.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    TurtleLayEggEvent turtleLayEggEvent = new TurtleLayEggEvent(turtle, location, 3);

    // Act and Assert
    assertEquals(location, turtleLayEggEvent.getLocation());
  }

  /**
   * Test {@link TurtleLayEggEvent#setEggCount(int)}.
   *
   * <p>Method under test: {@link TurtleLayEggEvent#setEggCount(int)}
   */
  @Test
  @DisplayName("Test setEggCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TurtleLayEggEvent.setEggCount(int)"})
  void testSetEggCount() {
    // Arrange
    Turtle turtle = mock(Turtle.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    TurtleLayEggEvent turtleLayEggEvent = new TurtleLayEggEvent(turtle, location, 3);

    // Act
    turtleLayEggEvent.setEggCount(3);

    // Assert that nothing has changed
    assertFalse(turtleLayEggEvent.isCancelled());
  }

  /**
   * Test {@link TurtleLayEggEvent#setEggCount(int)}.
   *
   * <p>Method under test: {@link TurtleLayEggEvent#setEggCount(int)}
   */
  @Test
  @DisplayName("Test setEggCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TurtleLayEggEvent.setEggCount(int)"})
  void testSetEggCount2() {
    // Arrange
    Turtle turtle = mock(Turtle.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    TurtleLayEggEvent turtleLayEggEvent = new TurtleLayEggEvent(turtle, location, 3);

    // Act
    turtleLayEggEvent.setEggCount(0);

    // Assert
    assertTrue(turtleLayEggEvent.isCancelled());
  }
}
