package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.PortalType;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityPortalEnterEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPortalEnterEvent#EntityPortalEnterEvent(Entity, Location, PortalType)}
   *   <li>{@link EntityPortalEnterEvent#setCancelled(boolean)}
   *   <li>{@link EntityPortalEnterEvent#getHandlerList()}
   *   <li>{@link EntityPortalEnterEvent#getHandlers()}
   *   <li>{@link EntityPortalEnterEvent#getPortalType()}
   *   <li>{@link EntityPortalEnterEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPortalEnterEvent.<init>(Entity, Location, PortalType)",
    "HandlerList EntityPortalEnterEvent.getHandlerList()",
    "HandlerList EntityPortalEnterEvent.getHandlers()",
    "PortalType EntityPortalEnterEvent.getPortalType()",
    "boolean EntityPortalEnterEvent.isCancelled()",
    "void EntityPortalEnterEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityPortalEnterEvent actualEntityPortalEnterEvent =
        new EntityPortalEnterEvent(entity, location, PortalType.NETHER);
    actualEntityPortalEnterEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityPortalEnterEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityPortalEnterEvent.getHandlers();
    PortalType actualPortalType = actualEntityPortalEnterEvent.getPortalType();
    boolean actualIsCancelledResult = actualEntityPortalEnterEvent.isCancelled();

    // Assert
    assertEquals(PortalType.NETHER, actualPortalType);
    assertFalse(actualEntityPortalEnterEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityPortalEnterEvent.getEntity());
  }

  /**
   * Test {@link EntityPortalEnterEvent#EntityPortalEnterEvent(Entity, Location)}.
   *
   * <p>Method under test: {@link EntityPortalEnterEvent#EntityPortalEnterEvent(Entity, Location)}
   */
  @Test
  @DisplayName("Test new EntityPortalEnterEvent(Entity, Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityPortalEnterEvent.<init>(Entity, Location)"})
  void testNewEntityPortalEnterEvent() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityPortalEnterEvent actualEntityPortalEnterEvent =
        new EntityPortalEnterEvent(entity, location);

    // Assert
    assertEquals("EntityPortalEnterEvent", actualEntityPortalEnterEvent.getEventName());
    assertNull(actualEntityPortalEnterEvent.getEntityType());
    assertEquals(PortalType.CUSTOM, actualEntityPortalEnterEvent.getPortalType());
    assertFalse(actualEntityPortalEnterEvent.isAsynchronous());
    assertFalse(actualEntityPortalEnterEvent.isCancelled());
    assertEquals(location, actualEntityPortalEnterEvent.getLocation());
    assertSame(entity, actualEntityPortalEnterEvent.getEntity());
  }

  /**
   * Test {@link EntityPortalEnterEvent#getLocation()}.
   *
   * <p>Method under test: {@link EntityPortalEnterEvent#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location EntityPortalEnterEvent.getLocation()"})
  void testGetLocation() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityPortalEnterEvent entityPortalEnterEvent = new EntityPortalEnterEvent(entity, location);

    // Act and Assert
    assertEquals(location, entityPortalEnterEvent.getLocation());
  }
}
