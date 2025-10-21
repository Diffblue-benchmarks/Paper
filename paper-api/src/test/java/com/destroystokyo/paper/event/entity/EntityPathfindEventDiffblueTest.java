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
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityPathfindEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPathfindEvent#EntityPathfindEvent(Entity, Location, Entity)}
   *   <li>{@link EntityPathfindEvent#setCancelled(boolean)}
   *   <li>{@link EntityPathfindEvent#getHandlerList()}
   *   <li>{@link EntityPathfindEvent#getEntity()}
   *   <li>{@link EntityPathfindEvent#getHandlers()}
   *   <li>{@link EntityPathfindEvent#getTargetEntity()}
   *   <li>{@link EntityPathfindEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPathfindEvent.<init>(Entity, Location, Entity)",
    "Entity EntityPathfindEvent.getEntity()",
    "HandlerList EntityPathfindEvent.getHandlerList()",
    "HandlerList EntityPathfindEvent.getHandlers()",
    "Entity EntityPathfindEvent.getTargetEntity()",
    "boolean EntityPathfindEvent.isCancelled()",
    "void EntityPathfindEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Entity targetEntity = mock(Entity.class);

    // Act
    EntityPathfindEvent actualEntityPathfindEvent =
        new EntityPathfindEvent(entity, location, targetEntity);
    actualEntityPathfindEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityPathfindEvent.getHandlerList();
    Entity actualEntity = actualEntityPathfindEvent.getEntity();
    HandlerList actualHandlers = actualEntityPathfindEvent.getHandlers();
    Entity actualTargetEntity = actualEntityPathfindEvent.getTargetEntity();
    boolean actualIsCancelledResult = actualEntityPathfindEvent.isCancelled();

    // Assert
    assertFalse(actualEntityPathfindEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntity);
    assertSame(targetEntity, actualTargetEntity);
  }

  /**
   * Test {@link EntityPathfindEvent#getLoc()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityPathfindEvent#getLoc()}
   */
  @Test
  @DisplayName(
      "Test getLoc(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location EntityPathfindEvent.getLoc()"})
  void testGetLoc_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityPathfindEvent entityPathfindEvent =
        new EntityPathfindEvent(entity, location, mock(Entity.class));

    // Act and Assert
    assertEquals(location, entityPathfindEvent.getLoc());
  }
}
