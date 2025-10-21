package org.bukkit.event.raid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Raid;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RaidFinishEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RaidFinishEvent#RaidFinishEvent(Raid, World, List)}
   *   <li>{@link RaidFinishEvent#getHandlerList()}
   *   <li>{@link RaidFinishEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RaidFinishEvent.<init>(Raid, World, List)",
    "HandlerList RaidFinishEvent.getHandlerList()",
    "HandlerList RaidFinishEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Raid raid = mock(Raid.class);
    World world = mock(World.class);

    // Act
    RaidFinishEvent actualRaidFinishEvent = new RaidFinishEvent(raid, world, new ArrayList<>());
    HandlerList actualHandlerList = actualRaidFinishEvent.getHandlerList();
    HandlerList actualHandlers = actualRaidFinishEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualRaidFinishEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(raid, actualRaidFinishEvent.getRaid());
    assertSame(world, actualRaidFinishEvent.getWorld());
  }

  /**
   * Test {@link RaidFinishEvent#getWinners()}.
   *
   * <p>Method under test: {@link RaidFinishEvent#getWinners()}
   */
  @Test
  @DisplayName("Test getWinners()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RaidFinishEvent.getWinners()"})
  void testGetWinners() {
    // Arrange
    Raid raid = mock(Raid.class);
    World world = mock(World.class);

    RaidFinishEvent raidFinishEvent = new RaidFinishEvent(raid, world, new ArrayList<>());

    // Act and Assert
    assertTrue(raidFinishEvent.getWinners().isEmpty());
  }
}
