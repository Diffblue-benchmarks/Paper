package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldUnloadEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorldUnloadEvent#WorldUnloadEvent(World)}
   *   <li>{@link WorldUnloadEvent#setCancelled(boolean)}
   *   <li>{@link WorldUnloadEvent#getHandlerList()}
   *   <li>{@link WorldUnloadEvent#getHandlers()}
   *   <li>{@link WorldUnloadEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorldUnloadEvent.<init>(World)",
    "HandlerList WorldUnloadEvent.getHandlerList()",
    "HandlerList WorldUnloadEvent.getHandlers()",
    "boolean WorldUnloadEvent.isCancelled()",
    "void WorldUnloadEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);

    // Act
    WorldUnloadEvent actualWorldUnloadEvent = new WorldUnloadEvent(world);
    actualWorldUnloadEvent.setCancelled(true);
    HandlerList actualHandlerList = actualWorldUnloadEvent.getHandlerList();
    HandlerList actualHandlers = actualWorldUnloadEvent.getHandlers();
    boolean actualIsCancelledResult = actualWorldUnloadEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualWorldUnloadEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualWorldUnloadEvent.getWorld());
  }
}
