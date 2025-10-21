package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

class EntitySpawnEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitySpawnEvent#EntitySpawnEvent(Entity)}
   *   <li>{@link EntitySpawnEvent#setCancelled(boolean)}
   *   <li>{@link EntitySpawnEvent#getHandlerList()}
   *   <li>{@link EntitySpawnEvent#getHandlers()}
   *   <li>{@link EntitySpawnEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitySpawnEvent.<init>(Entity)",
    "HandlerList EntitySpawnEvent.getHandlerList()",
    "HandlerList EntitySpawnEvent.getHandlers()",
    "boolean EntitySpawnEvent.isCancelled()",
    "void EntitySpawnEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity spawnee = mock(Entity.class);

    // Act
    EntitySpawnEvent actualEntitySpawnEvent = new EntitySpawnEvent(spawnee);
    actualEntitySpawnEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntitySpawnEvent.getHandlerList();
    HandlerList actualHandlers = actualEntitySpawnEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntitySpawnEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntitySpawnEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(spawnee, actualEntitySpawnEvent.getEntity());
  }

  /**
   * Test {@link EntitySpawnEvent#getLocation()}.
   *
   * <p>Method under test: {@link EntitySpawnEvent#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location EntitySpawnEvent.getLocation()"})
  void testGetLocation() {
    // Arrange
    Entity spawnee = mock(Entity.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(spawnee.getLocation()).thenReturn(location);

    // Act
    Location actualLocation = new EntitySpawnEvent(spawnee).getLocation();

    // Assert
    verify(spawnee).getLocation();
    assertSame(location, actualLocation);
  }
}
