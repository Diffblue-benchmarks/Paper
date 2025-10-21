package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldSaveEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorldSaveEvent#WorldSaveEvent(World)}
   *   <li>{@link WorldSaveEvent#getHandlerList()}
   *   <li>{@link WorldSaveEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorldSaveEvent.<init>(World)",
    "HandlerList WorldSaveEvent.getHandlerList()",
    "HandlerList WorldSaveEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);

    // Act
    WorldSaveEvent actualWorldSaveEvent = new WorldSaveEvent(world);
    HandlerList actualHandlerList = actualWorldSaveEvent.getHandlerList();
    HandlerList actualHandlers = actualWorldSaveEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualWorldSaveEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualWorldSaveEvent.getWorld());
  }
}
