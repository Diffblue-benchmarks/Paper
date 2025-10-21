package org.bukkit.event.raid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Raid;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RaidTriggerEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RaidTriggerEvent#RaidTriggerEvent(Raid, World, Player)}
   *   <li>{@link RaidTriggerEvent#setCancelled(boolean)}
   *   <li>{@link RaidTriggerEvent#getHandlerList()}
   *   <li>{@link RaidTriggerEvent#getHandlers()}
   *   <li>{@link RaidTriggerEvent#getPlayer()}
   *   <li>{@link RaidTriggerEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RaidTriggerEvent.<init>(Raid, World, Player)",
    "HandlerList RaidTriggerEvent.getHandlerList()",
    "HandlerList RaidTriggerEvent.getHandlers()",
    "Player RaidTriggerEvent.getPlayer()",
    "boolean RaidTriggerEvent.isCancelled()",
    "void RaidTriggerEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Raid raid = mock(Raid.class);
    World world = mock(World.class);
    Player player = mock(Player.class);

    // Act
    RaidTriggerEvent actualRaidTriggerEvent = new RaidTriggerEvent(raid, world, player);
    actualRaidTriggerEvent.setCancelled(true);
    HandlerList actualHandlerList = actualRaidTriggerEvent.getHandlerList();
    HandlerList actualHandlers = actualRaidTriggerEvent.getHandlers();
    Player actualPlayer = actualRaidTriggerEvent.getPlayer();
    boolean actualIsCancelledResult = actualRaidTriggerEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualRaidTriggerEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(raid, actualRaidTriggerEvent.getRaid());
    assertSame(world, actualRaidTriggerEvent.getWorld());
    assertSame(player, actualPlayer);
  }
}
