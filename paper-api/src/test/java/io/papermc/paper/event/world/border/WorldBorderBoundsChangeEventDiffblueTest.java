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
import io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent.Type;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldBorderBoundsChangeEventDiffblueTest {
  /**
   * Test {@link WorldBorderBoundsChangeEvent#WorldBorderBoundsChangeEvent(World, WorldBorder, Type,
   * double, double, long)}.
   *
   * <p>Method under test: {@link WorldBorderBoundsChangeEvent#WorldBorderBoundsChangeEvent(World,
   * WorldBorder, Type, double, double, long)}
   */
  @Test
  @DisplayName(
      "Test new WorldBorderBoundsChangeEvent(World, WorldBorder, Type, double, double, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorldBorderBoundsChangeEvent.<init>(World, WorldBorder, Type, double, double, long)"
  })
  void testNewWorldBorderBoundsChangeEvent() {
    // Arrange
    World world = mock(World.class);
    WorldBorder worldBorder = mock(WorldBorder.class);

    // Act
    WorldBorderBoundsChangeEvent actualWorldBorderBoundsChangeEvent =
        new WorldBorderBoundsChangeEvent(world, worldBorder, Type.STARTED_MOVE, 10.0d, 10.0d, 1L);

    // Assert
    assertEquals("WorldBorderBoundsChangeEvent", actualWorldBorderBoundsChangeEvent.getEventName());
    assertEquals(
        0, actualWorldBorderBoundsChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualWorldBorderBoundsChangeEvent.getNewSize());
    assertEquals(10.0d, actualWorldBorderBoundsChangeEvent.getOldSize());
    assertEquals(1L, actualWorldBorderBoundsChangeEvent.getDuration());
    assertEquals(Type.STARTED_MOVE, actualWorldBorderBoundsChangeEvent.getType());
    assertFalse(actualWorldBorderBoundsChangeEvent.isCancelled());
    assertFalse(actualWorldBorderBoundsChangeEvent.isAsynchronous());
    assertSame(world, actualWorldBorderBoundsChangeEvent.getWorld());
    assertSame(worldBorder, actualWorldBorderBoundsChangeEvent.getWorldBorder());
  }

  /**
   * Test {@link WorldBorderBoundsChangeEvent#setNewSize(double)}.
   *
   * <p>Method under test: {@link WorldBorderBoundsChangeEvent#setNewSize(double)}
   */
  @Test
  @DisplayName("Test setNewSize(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorldBorderBoundsChangeEvent.setNewSize(double)"})
  void testSetNewSize() {
    // Arrange
    WorldBorder worldBorder = mock(WorldBorder.class);
    when(worldBorder.getMaxSize()).thenReturn(10.0d);
    WorldBorderBoundsChangeEvent worldBorderBoundsChangeEvent =
        new WorldBorderBoundsChangeEvent(
            mock(World.class), worldBorder, Type.STARTED_MOVE, 10.0d, 10.0d, 1L);

    // Act
    worldBorderBoundsChangeEvent.setNewSize(10.0d);

    // Assert
    verify(worldBorder).getMaxSize();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorldBorderBoundsChangeEvent#setCancelled(boolean)}
   *   <li>{@link WorldBorderBoundsChangeEvent#getHandlerList()}
   *   <li>{@link WorldBorderBoundsChangeEvent#getDuration()}
   *   <li>{@link WorldBorderBoundsChangeEvent#getHandlers()}
   *   <li>{@link WorldBorderBoundsChangeEvent#getNewSize()}
   *   <li>{@link WorldBorderBoundsChangeEvent#getOldSize()}
   *   <li>{@link WorldBorderBoundsChangeEvent#getType()}
   *   <li>{@link WorldBorderBoundsChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long WorldBorderBoundsChangeEvent.getDuration()",
    "HandlerList WorldBorderBoundsChangeEvent.getHandlerList()",
    "HandlerList WorldBorderBoundsChangeEvent.getHandlers()",
    "double WorldBorderBoundsChangeEvent.getNewSize()",
    "double WorldBorderBoundsChangeEvent.getOldSize()",
    "Type WorldBorderBoundsChangeEvent.getType()",
    "boolean WorldBorderBoundsChangeEvent.isCancelled()",
    "void WorldBorderBoundsChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    WorldBorderBoundsChangeEvent worldBorderBoundsChangeEvent =
        new WorldBorderBoundsChangeEvent(
            mock(World.class), mock(WorldBorder.class), Type.STARTED_MOVE, 10.0d, 10.0d, 1L);

    // Act
    worldBorderBoundsChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = worldBorderBoundsChangeEvent.getHandlerList();
    long actualDuration = worldBorderBoundsChangeEvent.getDuration();
    HandlerList actualHandlers = worldBorderBoundsChangeEvent.getHandlers();
    double actualNewSize = worldBorderBoundsChangeEvent.getNewSize();
    double actualOldSize = worldBorderBoundsChangeEvent.getOldSize();
    Type actualType = worldBorderBoundsChangeEvent.getType();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0d, actualNewSize);
    assertEquals(10.0d, actualOldSize);
    assertEquals(1L, actualDuration);
    assertEquals(Type.STARTED_MOVE, actualType);
    assertTrue(worldBorderBoundsChangeEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link WorldBorderBoundsChangeEvent#setDuration(long)}.
   *
   * <p>Method under test: {@link WorldBorderBoundsChangeEvent#setDuration(long)}
   */
  @Test
  @DisplayName("Test setDuration(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorldBorderBoundsChangeEvent.setDuration(long)"})
  void testSetDuration() {
    // Arrange
    WorldBorderBoundsChangeEvent worldBorderBoundsChangeEvent =
        new WorldBorderBoundsChangeEvent(
            mock(World.class), mock(WorldBorder.class), Type.STARTED_MOVE, 10.0d, 10.0d, 1L);

    // Act
    worldBorderBoundsChangeEvent.setDuration(1L);

    // Assert that nothing has changed
    assertEquals(1L, worldBorderBoundsChangeEvent.getDuration());
    assertEquals(Type.STARTED_MOVE, worldBorderBoundsChangeEvent.getType());
  }

  /**
   * Test {@link WorldBorderBoundsChangeEvent#setDuration(long)}.
   *
   * <p>Method under test: {@link WorldBorderBoundsChangeEvent#setDuration(long)}
   */
  @Test
  @DisplayName("Test setDuration(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorldBorderBoundsChangeEvent.setDuration(long)"})
  void testSetDuration2() {
    // Arrange
    WorldBorderBoundsChangeEvent worldBorderBoundsChangeEvent =
        new WorldBorderBoundsChangeEvent(
            mock(World.class), mock(WorldBorder.class), Type.INSTANT_MOVE, 10.0d, 10.0d, 1L);

    // Act
    worldBorderBoundsChangeEvent.setDuration(0L);

    // Assert
    assertEquals(0L, worldBorderBoundsChangeEvent.getDuration());
    assertEquals(Type.STARTED_MOVE, worldBorderBoundsChangeEvent.getType());
  }

  /**
   * Test {@link WorldBorderBoundsChangeEvent#setDuration(long)}.
   *
   * <p>Method under test: {@link WorldBorderBoundsChangeEvent#setDuration(long)}
   */
  @Test
  @DisplayName("Test setDuration(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorldBorderBoundsChangeEvent.setDuration(long)"})
  void testSetDuration3() {
    // Arrange
    WorldBorderBoundsChangeEvent worldBorderBoundsChangeEvent =
        new WorldBorderBoundsChangeEvent(
            mock(World.class), mock(WorldBorder.class), Type.INSTANT_MOVE, 10.0d, 10.0d, 1L);

    // Act
    worldBorderBoundsChangeEvent.setDuration(-1L);

    // Assert
    assertEquals(0L, worldBorderBoundsChangeEvent.getDuration());
    assertEquals(Type.INSTANT_MOVE, worldBorderBoundsChangeEvent.getType());
  }
}
