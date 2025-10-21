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
import org.bukkit.event.world.TimeSkipEvent.SkipReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimeSkipEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimeSkipEvent#TimeSkipEvent(World, SkipReason, long)}
   *   <li>{@link TimeSkipEvent#setCancelled(boolean)}
   *   <li>{@link TimeSkipEvent#setSkipAmount(long)}
   *   <li>{@link TimeSkipEvent#getHandlerList()}
   *   <li>{@link TimeSkipEvent#getHandlers()}
   *   <li>{@link TimeSkipEvent#getSkipAmount()}
   *   <li>{@link TimeSkipEvent#getSkipReason()}
   *   <li>{@link TimeSkipEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimeSkipEvent.<init>(World, SkipReason, long)",
    "HandlerList TimeSkipEvent.getHandlerList()",
    "HandlerList TimeSkipEvent.getHandlers()",
    "long TimeSkipEvent.getSkipAmount()",
    "SkipReason TimeSkipEvent.getSkipReason()",
    "boolean TimeSkipEvent.isCancelled()",
    "void TimeSkipEvent.setCancelled(boolean)",
    "void TimeSkipEvent.setSkipAmount(long)"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);

    // Act
    TimeSkipEvent actualTimeSkipEvent = new TimeSkipEvent(world, SkipReason.COMMAND, 1L);
    actualTimeSkipEvent.setCancelled(true);
    actualTimeSkipEvent.setSkipAmount(1L);
    HandlerList actualHandlerList = actualTimeSkipEvent.getHandlerList();
    HandlerList actualHandlers = actualTimeSkipEvent.getHandlers();
    long actualSkipAmount = actualTimeSkipEvent.getSkipAmount();
    SkipReason actualSkipReason = actualTimeSkipEvent.getSkipReason();
    boolean actualIsCancelledResult = actualTimeSkipEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1L, actualSkipAmount);
    assertEquals(SkipReason.COMMAND, actualSkipReason);
    assertFalse(actualTimeSkipEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualTimeSkipEvent.getWorld());
  }
}
