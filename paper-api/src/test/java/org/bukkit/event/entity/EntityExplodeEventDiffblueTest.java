package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ExplosionResult;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityExplodeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExplodeEvent#EntityExplodeEvent(Entity, Location, List, float,
   *       ExplosionResult)}
   *   <li>{@link EntityExplodeEvent#setCancelled(boolean)}
   *   <li>{@link EntityExplodeEvent#setYield(float)}
   *   <li>{@link EntityExplodeEvent#getHandlerList()}
   *   <li>{@link EntityExplodeEvent#getExplosionResult()}
   *   <li>{@link EntityExplodeEvent#getHandlers()}
   *   <li>{@link EntityExplodeEvent#getYield()}
   *   <li>{@link EntityExplodeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityExplodeEvent.<init>(Entity, Location, List, float, ExplosionResult)",
    "ExplosionResult EntityExplodeEvent.getExplosionResult()",
    "HandlerList EntityExplodeEvent.getHandlerList()",
    "HandlerList EntityExplodeEvent.getHandlers()",
    "float EntityExplodeEvent.getYield()",
    "boolean EntityExplodeEvent.isCancelled()",
    "void EntityExplodeEvent.setCancelled(boolean)",
    "void EntityExplodeEvent.setYield(float)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityExplodeEvent actualEntityExplodeEvent =
        new EntityExplodeEvent(entity, location, new ArrayList<>(), 10.0f, ExplosionResult.KEEP);
    actualEntityExplodeEvent.setCancelled(true);
    actualEntityExplodeEvent.setYield(10.0f);
    HandlerList actualHandlerList = actualEntityExplodeEvent.getHandlerList();
    ExplosionResult actualExplosionResult = actualEntityExplodeEvent.getExplosionResult();
    HandlerList actualHandlers = actualEntityExplodeEvent.getHandlers();
    float actualYield = actualEntityExplodeEvent.getYield();
    boolean actualIsCancelledResult = actualEntityExplodeEvent.isCancelled();

    // Assert
    assertEquals(10.0f, actualYield);
    assertEquals(ExplosionResult.KEEP, actualExplosionResult);
    assertFalse(actualEntityExplodeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityExplodeEvent.getEntity());
  }

  /**
   * Test {@link EntityExplodeEvent#blockList()}.
   *
   * <p>Method under test: {@link EntityExplodeEvent#blockList()}
   */
  @Test
  @DisplayName("Test blockList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityExplodeEvent.blockList()"})
  void testBlockList() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityExplodeEvent entityExplodeEvent =
        new EntityExplodeEvent(entity, location, new ArrayList<>(), 10.0f, ExplosionResult.KEEP);

    // Act and Assert
    assertTrue(entityExplodeEvent.blockList().isEmpty());
  }

  /**
   * Test {@link EntityExplodeEvent#getLocation()}.
   *
   * <p>Method under test: {@link EntityExplodeEvent#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location EntityExplodeEvent.getLocation()"})
  void testGetLocation() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityExplodeEvent entityExplodeEvent =
        new EntityExplodeEvent(entity, location, new ArrayList<>(), 10.0f, ExplosionResult.KEEP);

    // Act and Assert
    assertEquals(location, entityExplodeEvent.getLocation());
  }
}
