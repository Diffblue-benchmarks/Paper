package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerStopSpectatingEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerStopSpectatingEntityEvent#PlayerStopSpectatingEntityEvent(Player, Entity)}
   *   <li>{@link PlayerStopSpectatingEntityEvent#setCancelled(boolean)}
   *   <li>{@link PlayerStopSpectatingEntityEvent#getHandlerList()}
   *   <li>{@link PlayerStopSpectatingEntityEvent#getHandlers()}
   *   <li>{@link PlayerStopSpectatingEntityEvent#getSpectatorTarget()}
   *   <li>{@link PlayerStopSpectatingEntityEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerStopSpectatingEntityEvent.<init>(Player, Entity)",
    "HandlerList PlayerStopSpectatingEntityEvent.getHandlerList()",
    "HandlerList PlayerStopSpectatingEntityEvent.getHandlers()",
    "Entity PlayerStopSpectatingEntityEvent.getSpectatorTarget()",
    "boolean PlayerStopSpectatingEntityEvent.isCancelled()",
    "void PlayerStopSpectatingEntityEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity spectatorTarget = mock(Entity.class);

    // Act
    PlayerStopSpectatingEntityEvent actualPlayerStopSpectatingEntityEvent =
        new PlayerStopSpectatingEntityEvent(player, spectatorTarget);
    actualPlayerStopSpectatingEntityEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerStopSpectatingEntityEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerStopSpectatingEntityEvent.getHandlers();
    Entity actualSpectatorTarget = actualPlayerStopSpectatingEntityEvent.getSpectatorTarget();
    boolean actualIsCancelledResult = actualPlayerStopSpectatingEntityEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerStopSpectatingEntityEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(spectatorTarget, actualSpectatorTarget);
    assertSame(player, actualPlayerStopSpectatingEntityEvent.getPlayer());
  }
}
