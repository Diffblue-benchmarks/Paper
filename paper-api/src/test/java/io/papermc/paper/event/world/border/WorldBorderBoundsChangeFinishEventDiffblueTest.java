package io.papermc.paper.event.world.border;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldBorderBoundsChangeFinishEventDiffblueTest {
  /**
   * Test {@link WorldBorderBoundsChangeFinishEvent#WorldBorderBoundsChangeFinishEvent(World,
   * WorldBorder, double, double, double)}.
   *
   * <p>Method under test: {@link
   * WorldBorderBoundsChangeFinishEvent#WorldBorderBoundsChangeFinishEvent(World, WorldBorder,
   * double, double, double)}
   */
  @Test
  @DisplayName(
      "Test new WorldBorderBoundsChangeFinishEvent(World, WorldBorder, double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorldBorderBoundsChangeFinishEvent.<init>(World, WorldBorder, double, double, double)"
  })
  void testNewWorldBorderBoundsChangeFinishEvent() {
    // Arrange
    World world = mock(World.class);
    WorldBorder worldBorder = mock(WorldBorder.class);

    // Act
    WorldBorderBoundsChangeFinishEvent actualWorldBorderBoundsChangeFinishEvent =
        new WorldBorderBoundsChangeFinishEvent(world, worldBorder, 10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(
        "WorldBorderBoundsChangeFinishEvent",
        actualWorldBorderBoundsChangeFinishEvent.getEventName());
    assertEquals(
        0, actualWorldBorderBoundsChangeFinishEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualWorldBorderBoundsChangeFinishEvent.getDuration());
    assertEquals(10.0d, actualWorldBorderBoundsChangeFinishEvent.getNewSize());
    assertEquals(10.0d, actualWorldBorderBoundsChangeFinishEvent.getOldSize());
    assertFalse(actualWorldBorderBoundsChangeFinishEvent.isAsynchronous());
    assertSame(world, actualWorldBorderBoundsChangeFinishEvent.getWorld());
    assertSame(worldBorder, actualWorldBorderBoundsChangeFinishEvent.getWorldBorder());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorldBorderBoundsChangeFinishEvent#getHandlerList()}
   *   <li>{@link WorldBorderBoundsChangeFinishEvent#getDuration()}
   *   <li>{@link WorldBorderBoundsChangeFinishEvent#getHandlers()}
   *   <li>{@link WorldBorderBoundsChangeFinishEvent#getNewSize()}
   *   <li>{@link WorldBorderBoundsChangeFinishEvent#getOldSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double WorldBorderBoundsChangeFinishEvent.getDuration()",
    "HandlerList WorldBorderBoundsChangeFinishEvent.getHandlerList()",
    "HandlerList WorldBorderBoundsChangeFinishEvent.getHandlers()",
    "double WorldBorderBoundsChangeFinishEvent.getNewSize()",
    "double WorldBorderBoundsChangeFinishEvent.getOldSize()"
  })
  void testGettersAndSetters() {
    // Arrange
    WorldBorderBoundsChangeFinishEvent worldBorderBoundsChangeFinishEvent =
        new WorldBorderBoundsChangeFinishEvent(
            mock(World.class), mock(WorldBorder.class), 10.0d, 10.0d, 10.0d);

    // Act
    HandlerList actualHandlerList = worldBorderBoundsChangeFinishEvent.getHandlerList();
    double actualDuration = worldBorderBoundsChangeFinishEvent.getDuration();
    HandlerList actualHandlers = worldBorderBoundsChangeFinishEvent.getHandlers();
    double actualNewSize = worldBorderBoundsChangeFinishEvent.getNewSize();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0d, actualDuration);
    assertEquals(10.0d, actualNewSize);
    assertEquals(10.0d, worldBorderBoundsChangeFinishEvent.getOldSize());
    assertSame(actualHandlerList, actualHandlers);
  }
}
