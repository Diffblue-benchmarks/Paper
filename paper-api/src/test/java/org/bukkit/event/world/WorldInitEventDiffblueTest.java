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

class WorldInitEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorldInitEvent#WorldInitEvent(World)}
   *   <li>{@link WorldInitEvent#getHandlerList()}
   *   <li>{@link WorldInitEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorldInitEvent.<init>(World)",
    "HandlerList WorldInitEvent.getHandlerList()",
    "HandlerList WorldInitEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);

    // Act
    WorldInitEvent actualWorldInitEvent = new WorldInitEvent(world);
    HandlerList actualHandlerList = actualWorldInitEvent.getHandlerList();
    HandlerList actualHandlers = actualWorldInitEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualWorldInitEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualWorldInitEvent.getWorld());
  }
}
