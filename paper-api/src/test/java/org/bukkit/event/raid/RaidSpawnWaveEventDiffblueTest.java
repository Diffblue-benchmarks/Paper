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
import org.bukkit.entity.Raider;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RaidSpawnWaveEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RaidSpawnWaveEvent#RaidSpawnWaveEvent(Raid, World, Raider, List)}
   *   <li>{@link RaidSpawnWaveEvent#getHandlerList()}
   *   <li>{@link RaidSpawnWaveEvent#getHandlers()}
   *   <li>{@link RaidSpawnWaveEvent#getPatrolLeader()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RaidSpawnWaveEvent.<init>(Raid, World, Raider, List)",
    "HandlerList RaidSpawnWaveEvent.getHandlerList()",
    "HandlerList RaidSpawnWaveEvent.getHandlers()",
    "Raider RaidSpawnWaveEvent.getPatrolLeader()"
  })
  void testGettersAndSetters() {
    // Arrange
    Raid raid = mock(Raid.class);
    World world = mock(World.class);
    Raider leader = mock(Raider.class);

    // Act
    RaidSpawnWaveEvent actualRaidSpawnWaveEvent =
        new RaidSpawnWaveEvent(raid, world, leader, new ArrayList<>());
    HandlerList actualHandlerList = actualRaidSpawnWaveEvent.getHandlerList();
    HandlerList actualHandlers = actualRaidSpawnWaveEvent.getHandlers();
    Raider actualPatrolLeader = actualRaidSpawnWaveEvent.getPatrolLeader();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualRaidSpawnWaveEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(raid, actualRaidSpawnWaveEvent.getRaid());
    assertSame(world, actualRaidSpawnWaveEvent.getWorld());
    assertSame(leader, actualPatrolLeader);
  }

  /**
   * Test {@link RaidSpawnWaveEvent#getRaiders()}.
   *
   * <p>Method under test: {@link RaidSpawnWaveEvent#getRaiders()}
   */
  @Test
  @DisplayName("Test getRaiders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RaidSpawnWaveEvent.getRaiders()"})
  void testGetRaiders() {
    // Arrange
    Raid raid = mock(Raid.class);
    World world = mock(World.class);
    Raider leader = mock(Raider.class);

    RaidSpawnWaveEvent raidSpawnWaveEvent =
        new RaidSpawnWaveEvent(raid, world, leader, new ArrayList<>());

    // Act and Assert
    assertTrue(raidSpawnWaveEvent.getRaiders().isEmpty());
  }
}
