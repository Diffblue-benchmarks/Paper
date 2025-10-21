package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTeleportEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTeleportEvent#EntityTeleportEvent(Entity, Location, Location)}
   *   <li>{@link EntityTeleportEvent#setCancelled(boolean)}
   *   <li>{@link EntityTeleportEvent#getHandlerList()}
   *   <li>{@link EntityTeleportEvent#getFrom()}
   *   <li>{@link EntityTeleportEvent#getHandlers()}
   *   <li>{@link EntityTeleportEvent#getTo()}
   *   <li>{@link EntityTeleportEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTeleportEvent.<init>(Entity, Location, Location)",
    "Location EntityTeleportEvent.getFrom()",
    "HandlerList EntityTeleportEvent.getHandlerList()",
    "HandlerList EntityTeleportEvent.getHandlers()",
    "Location EntityTeleportEvent.getTo()",
    "boolean EntityTeleportEvent.isCancelled()",
    "void EntityTeleportEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityTeleportEvent actualEntityTeleportEvent = new EntityTeleportEvent(entity, from, resultTo);
    actualEntityTeleportEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityTeleportEvent.getHandlerList();
    Location actualFrom = actualEntityTeleportEvent.getFrom();
    HandlerList actualHandlers = actualEntityTeleportEvent.getHandlers();
    Location actualTo = actualEntityTeleportEvent.getTo();
    boolean actualIsCancelledResult = actualEntityTeleportEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityTeleportEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(from, actualFrom);
    assertSame(resultTo, actualTo);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityTeleportEvent.getEntity());
  }

  /**
   * Test {@link EntityTeleportEvent#setFrom(Location)}.
   *
   * <ul>
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityTeleportEvent#setFrom(Location)}
   */
  @Test
  @DisplayName("Test setFrom(Location); then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityTeleportEvent.setFrom(Location)"})
  void testSetFrom_thenCallsClone() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityTeleportEvent entityTeleportEvent = new EntityTeleportEvent(entity, from, resultTo);

    Location from2 = mock(Location.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(from2.clone()).thenReturn(location);

    // Act
    entityTeleportEvent.setFrom(from2);

    // Assert
    verify(from2).clone();
  }

  /**
   * Test {@link EntityTeleportEvent#setTo(Location)}.
   *
   * <p>Method under test: {@link EntityTeleportEvent#setTo(Location)}
   */
  @Test
  @DisplayName("Test setTo(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityTeleportEvent.setTo(Location)"})
  void testSetTo() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityTeleportEvent entityTeleportEvent = new EntityTeleportEvent(entity, from, resultTo);

    // Act
    entityTeleportEvent.setTo(null);

    // Assert
    assertNull(entityTeleportEvent.getTo());
  }
}
