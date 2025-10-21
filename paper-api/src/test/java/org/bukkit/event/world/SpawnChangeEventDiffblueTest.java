package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpawnChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpawnChangeEvent#SpawnChangeEvent(World, Location)}
   *   <li>{@link SpawnChangeEvent#getHandlerList()}
   *   <li>{@link SpawnChangeEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpawnChangeEvent.<init>(World, Location)",
    "HandlerList SpawnChangeEvent.getHandlerList()",
    "HandlerList SpawnChangeEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);
    Location previousLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    SpawnChangeEvent actualSpawnChangeEvent = new SpawnChangeEvent(world, previousLocation);
    HandlerList actualHandlerList = actualSpawnChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualSpawnChangeEvent.getHandlers();

    // Assert
    assertFalse(actualSpawnChangeEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualSpawnChangeEvent.getWorld());
  }

  /**
   * Test {@link SpawnChangeEvent#getPreviousLocation()}.
   *
   * <p>Method under test: {@link SpawnChangeEvent#getPreviousLocation()}
   */
  @Test
  @DisplayName("Test getPreviousLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location SpawnChangeEvent.getPreviousLocation()"})
  void testGetPreviousLocation() {
    // Arrange
    World world = mock(World.class);
    Location previousLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    SpawnChangeEvent spawnChangeEvent = new SpawnChangeEvent(world, previousLocation);

    // Act and Assert
    assertEquals(previousLocation, spawnChangeEvent.getPreviousLocation());
  }
}
