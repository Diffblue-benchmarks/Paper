package org.bukkit.event.raid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Raid;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.bukkit.event.raid.RaidStopEvent.Reason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RaidStopEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RaidStopEvent#RaidStopEvent(Raid, World, Reason)}
   *   <li>{@link RaidStopEvent#getHandlerList()}
   *   <li>{@link RaidStopEvent#getHandlers()}
   *   <li>{@link RaidStopEvent#getReason()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RaidStopEvent.<init>(Raid, World, Reason)",
    "HandlerList RaidStopEvent.getHandlerList()",
    "HandlerList RaidStopEvent.getHandlers()",
    "Reason RaidStopEvent.getReason()"
  })
  void testGettersAndSetters() {
    // Arrange
    Raid raid = mock(Raid.class);
    World world = mock(World.class);

    // Act
    RaidStopEvent actualRaidStopEvent = new RaidStopEvent(raid, world, Reason.PEACE);
    HandlerList actualHandlerList = actualRaidStopEvent.getHandlerList();
    HandlerList actualHandlers = actualRaidStopEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Reason.PEACE, actualRaidStopEvent.getReason());
    assertFalse(actualRaidStopEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(raid, actualRaidStopEvent.getRaid());
    assertSame(world, actualRaidStopEvent.getWorld());
  }
}
