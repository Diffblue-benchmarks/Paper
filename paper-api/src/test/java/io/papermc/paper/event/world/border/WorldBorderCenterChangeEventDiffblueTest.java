package io.papermc.paper.event.world.border;

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
import org.bukkit.WorldBorder;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldBorderCenterChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorldBorderCenterChangeEvent#WorldBorderCenterChangeEvent(World, WorldBorder,
   *       Location, Location)}
   *   <li>{@link WorldBorderCenterChangeEvent#setCancelled(boolean)}
   *   <li>{@link WorldBorderCenterChangeEvent#getHandlerList()}
   *   <li>{@link WorldBorderCenterChangeEvent#getHandlers()}
   *   <li>{@link WorldBorderCenterChangeEvent#getNewCenter()}
   *   <li>{@link WorldBorderCenterChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorldBorderCenterChangeEvent.<init>(World, WorldBorder, Location, Location)",
    "HandlerList WorldBorderCenterChangeEvent.getHandlerList()",
    "HandlerList WorldBorderCenterChangeEvent.getHandlers()",
    "Location WorldBorderCenterChangeEvent.getNewCenter()",
    "boolean WorldBorderCenterChangeEvent.isCancelled()",
    "void WorldBorderCenterChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);
    WorldBorder worldBorder = mock(WorldBorder.class);
    Location oldCenter = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location newCenter = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    WorldBorderCenterChangeEvent actualWorldBorderCenterChangeEvent =
        new WorldBorderCenterChangeEvent(world, worldBorder, oldCenter, newCenter);
    actualWorldBorderCenterChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualWorldBorderCenterChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualWorldBorderCenterChangeEvent.getHandlers();
    Location actualNewCenter = actualWorldBorderCenterChangeEvent.getNewCenter();
    boolean actualIsCancelledResult = actualWorldBorderCenterChangeEvent.isCancelled();

    // Assert
    assertFalse(actualWorldBorderCenterChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(newCenter, actualNewCenter);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualWorldBorderCenterChangeEvent.getWorld());
    assertSame(worldBorder, actualWorldBorderCenterChangeEvent.getWorldBorder());
  }

  /**
   * Test {@link WorldBorderCenterChangeEvent#getOldCenter()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link WorldBorderCenterChangeEvent#getOldCenter()}
   */
  @Test
  @DisplayName(
      "Test getOldCenter(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location WorldBorderCenterChangeEvent.getOldCenter()"})
  void testGetOldCenter_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    World world = mock(World.class);
    WorldBorder worldBorder = mock(WorldBorder.class);
    Location oldCenter = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location newCenter = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    WorldBorderCenterChangeEvent worldBorderCenterChangeEvent =
        new WorldBorderCenterChangeEvent(world, worldBorder, oldCenter, newCenter);

    // Act and Assert
    assertEquals(oldCenter, worldBorderCenterChangeEvent.getOldCenter());
  }

  /**
   * Test {@link WorldBorderCenterChangeEvent#setNewCenter(Location)}.
   *
   * <ul>
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link WorldBorderCenterChangeEvent#setNewCenter(Location)}
   */
  @Test
  @DisplayName("Test setNewCenter(Location); then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorldBorderCenterChangeEvent.setNewCenter(Location)"})
  void testSetNewCenter_thenCallsClone() {
    // Arrange
    World world = mock(World.class);
    WorldBorder worldBorder = mock(WorldBorder.class);
    Location oldCenter = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location newCenter = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    WorldBorderCenterChangeEvent worldBorderCenterChangeEvent =
        new WorldBorderCenterChangeEvent(world, worldBorder, oldCenter, newCenter);

    Location newCenter2 = mock(Location.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(newCenter2.clone()).thenReturn(location);

    // Act
    worldBorderCenterChangeEvent.setNewCenter(newCenter2);

    // Assert
    verify(newCenter2).clone();
  }
}
