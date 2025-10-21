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

class PlayerStartSpectatingEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerStartSpectatingEntityEvent#PlayerStartSpectatingEntityEvent(Player, Entity,
   *       Entity)}
   *   <li>{@link PlayerStartSpectatingEntityEvent#setCancelled(boolean)}
   *   <li>{@link PlayerStartSpectatingEntityEvent#getHandlerList()}
   *   <li>{@link PlayerStartSpectatingEntityEvent#getCurrentSpectatorTarget()}
   *   <li>{@link PlayerStartSpectatingEntityEvent#getHandlers()}
   *   <li>{@link PlayerStartSpectatingEntityEvent#getNewSpectatorTarget()}
   *   <li>{@link PlayerStartSpectatingEntityEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerStartSpectatingEntityEvent.<init>(Player, Entity, Entity)",
    "Entity PlayerStartSpectatingEntityEvent.getCurrentSpectatorTarget()",
    "HandlerList PlayerStartSpectatingEntityEvent.getHandlerList()",
    "HandlerList PlayerStartSpectatingEntityEvent.getHandlers()",
    "Entity PlayerStartSpectatingEntityEvent.getNewSpectatorTarget()",
    "boolean PlayerStartSpectatingEntityEvent.isCancelled()",
    "void PlayerStartSpectatingEntityEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity currentSpectatorTarget = mock(Entity.class);
    Entity newSpectatorTarget = mock(Entity.class);

    // Act
    PlayerStartSpectatingEntityEvent actualPlayerStartSpectatingEntityEvent =
        new PlayerStartSpectatingEntityEvent(player, currentSpectatorTarget, newSpectatorTarget);
    actualPlayerStartSpectatingEntityEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerStartSpectatingEntityEvent.getHandlerList();
    Entity actualCurrentSpectatorTarget =
        actualPlayerStartSpectatingEntityEvent.getCurrentSpectatorTarget();
    HandlerList actualHandlers = actualPlayerStartSpectatingEntityEvent.getHandlers();
    Entity actualNewSpectatorTarget =
        actualPlayerStartSpectatingEntityEvent.getNewSpectatorTarget();
    boolean actualIsCancelledResult = actualPlayerStartSpectatingEntityEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerStartSpectatingEntityEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(currentSpectatorTarget, actualCurrentSpectatorTarget);
    assertSame(newSpectatorTarget, actualNewSpectatorTarget);
    assertSame(player, actualPlayerStartSpectatingEntityEvent.getPlayer());
  }
}
