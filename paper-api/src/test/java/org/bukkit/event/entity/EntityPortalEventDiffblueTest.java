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

class EntityPortalEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPortalEvent#EntityPortalEvent(Entity, Location, Location, int, boolean, int,
   *       PortalType)}
   *   <li>{@link EntityPortalEvent#setCanCreatePortal(boolean)}
   *   <li>{@link EntityPortalEvent#setCreationRadius(int)}
   *   <li>{@link EntityPortalEvent#setSearchRadius(int)}
   *   <li>{@link EntityPortalEvent#getHandlerList()}
   *   <li>{@link EntityPortalEvent#getCanCreatePortal()}
   *   <li>{@link EntityPortalEvent#getCreationRadius()}
   *   <li>{@link EntityPortalEvent#getHandlers()}
   *   <li>{@link EntityPortalEvent#getPortalType()}
   *   <li>{@link EntityPortalEvent#getSearchRadius()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPortalEvent.<init>(Entity, Location, Location, int, boolean, int, PortalType)",
    "boolean EntityPortalEvent.getCanCreatePortal()",
    "int EntityPortalEvent.getCreationRadius()",
    "HandlerList EntityPortalEvent.getHandlerList()",
    "HandlerList EntityPortalEvent.getHandlers()",
    "PortalType EntityPortalEvent.getPortalType()",
    "int EntityPortalEvent.getSearchRadius()",
    "void EntityPortalEvent.setCanCreatePortal(boolean)",
    "void EntityPortalEvent.setCreationRadius(int)",
    "void EntityPortalEvent.setSearchRadius(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityPortalEvent actualEntityPortalEvent =
        new EntityPortalEvent(entity, from, resultTo, 1, true, 1, PortalType.NETHER);
    actualEntityPortalEvent.setCanCreatePortal(true);
    actualEntityPortalEvent.setCreationRadius(1);
    actualEntityPortalEvent.setSearchRadius(1);
    HandlerList actualHandlerList = actualEntityPortalEvent.getHandlerList();
    boolean actualCanCreatePortal = actualEntityPortalEvent.getCanCreatePortal();
    int actualCreationRadius = actualEntityPortalEvent.getCreationRadius();
    HandlerList actualHandlers = actualEntityPortalEvent.getHandlers();
    PortalType actualPortalType = actualEntityPortalEvent.getPortalType();

    // Assert
    assertEquals(1, actualCreationRadius);
    assertEquals(1, actualEntityPortalEvent.getSearchRadius());
    assertEquals(PortalType.NETHER, actualPortalType);
    assertFalse(actualEntityPortalEvent.isAsynchronous());
    assertFalse(actualEntityPortalEvent.isCancelled());
    assertTrue(actualCanCreatePortal);
    assertSame(resultTo, actualEntityPortalEvent.getTo());
    assertSame(from, actualEntityPortalEvent.getFrom());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityPortalEvent.getEntity());
  }

  /**
   * Test {@link EntityPortalEvent#EntityPortalEvent(Entity, Location, Location)}.
   *
   * <p>Method under test: {@link EntityPortalEvent#EntityPortalEvent(Entity, Location, Location)}
   */
  @Test
  @DisplayName("Test new EntityPortalEvent(Entity, Location, Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityPortalEvent.<init>(Entity, Location, Location)"})
  void testNewEntityPortalEvent() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityPortalEvent actualEntityPortalEvent = new EntityPortalEvent(entity, from, resultTo);

    // Assert
    assertEquals("EntityPortalEvent", actualEntityPortalEvent.getEventName());
    assertNull(actualEntityPortalEvent.getEntityType());
    assertEquals(128, actualEntityPortalEvent.getSearchRadius());
    assertEquals(PortalType.CUSTOM, actualEntityPortalEvent.getPortalType());
    assertFalse(actualEntityPortalEvent.isAsynchronous());
    assertFalse(actualEntityPortalEvent.isCancelled());
    assertTrue(actualEntityPortalEvent.getCanCreatePortal());
    assertEquals(Short.SIZE, actualEntityPortalEvent.getCreationRadius());
    assertSame(resultTo, actualEntityPortalEvent.getTo());
    assertSame(from, actualEntityPortalEvent.getFrom());
    assertSame(entity, actualEntityPortalEvent.getEntity());
  }

  /**
   * Test {@link EntityPortalEvent#EntityPortalEvent(Entity, Location, Location, int)}.
   *
   * <p>Method under test: {@link EntityPortalEvent#EntityPortalEvent(Entity, Location, Location,
   * int)}
   */
  @Test
  @DisplayName("Test new EntityPortalEvent(Entity, Location, Location, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityPortalEvent.<init>(Entity, Location, Location, int)"})
  void testNewEntityPortalEvent2() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityPortalEvent actualEntityPortalEvent = new EntityPortalEvent(entity, from, resultTo, 1);

    // Assert
    assertEquals("EntityPortalEvent", actualEntityPortalEvent.getEventName());
    assertNull(actualEntityPortalEvent.getEntityType());
    assertEquals(1, actualEntityPortalEvent.getSearchRadius());
    assertEquals(PortalType.CUSTOM, actualEntityPortalEvent.getPortalType());
    assertFalse(actualEntityPortalEvent.isAsynchronous());
    assertFalse(actualEntityPortalEvent.isCancelled());
    assertTrue(actualEntityPortalEvent.getCanCreatePortal());
    assertEquals(Short.SIZE, actualEntityPortalEvent.getCreationRadius());
    assertSame(resultTo, actualEntityPortalEvent.getTo());
    assertSame(from, actualEntityPortalEvent.getFrom());
    assertSame(entity, actualEntityPortalEvent.getEntity());
  }

  /**
   * Test {@link EntityPortalEvent#EntityPortalEvent(Entity, Location, Location, int, boolean,
   * int)}.
   *
   * <p>Method under test: {@link EntityPortalEvent#EntityPortalEvent(Entity, Location, Location,
   * int, boolean, int)}
   */
  @Test
  @DisplayName("Test new EntityPortalEvent(Entity, Location, Location, int, boolean, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPortalEvent.<init>(Entity, Location, Location, int, boolean, int)"
  })
  void testNewEntityPortalEvent3() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityPortalEvent actualEntityPortalEvent =
        new EntityPortalEvent(entity, from, resultTo, 1, true, 1);

    // Assert
    assertEquals("EntityPortalEvent", actualEntityPortalEvent.getEventName());
    assertNull(actualEntityPortalEvent.getEntityType());
    assertEquals(1, actualEntityPortalEvent.getCreationRadius());
    assertEquals(1, actualEntityPortalEvent.getSearchRadius());
    assertEquals(PortalType.CUSTOM, actualEntityPortalEvent.getPortalType());
    assertFalse(actualEntityPortalEvent.isAsynchronous());
    assertFalse(actualEntityPortalEvent.isCancelled());
    assertTrue(actualEntityPortalEvent.getCanCreatePortal());
    assertSame(resultTo, actualEntityPortalEvent.getTo());
    assertSame(from, actualEntityPortalEvent.getFrom());
    assertSame(entity, actualEntityPortalEvent.getEntity());
  }

  /**
   * Test {@link EntityPortalEvent#getTo()}.
   *
   * <p>Method under test: {@link EntityPortalEvent#getTo()}
   */
  @Test
  @DisplayName("Test getTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location EntityPortalEvent.getTo()"})
  void testGetTo() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityPortalEvent entityPortalEvent = new EntityPortalEvent(entity, from, resultTo);

    // Act and Assert
    assertSame(resultTo, entityPortalEvent.getTo());
  }
}
