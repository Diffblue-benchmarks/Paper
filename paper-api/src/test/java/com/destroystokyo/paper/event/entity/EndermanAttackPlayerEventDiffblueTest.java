package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EndermanAttackPlayerEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EndermanAttackPlayerEvent#EndermanAttackPlayerEvent(Enderman, Player)}
   *   <li>{@link EndermanAttackPlayerEvent#setCancelled(boolean)}
   *   <li>{@link EndermanAttackPlayerEvent#getHandlerList()}
   *   <li>{@link EndermanAttackPlayerEvent#getHandlers()}
   *   <li>{@link EndermanAttackPlayerEvent#getPlayer()}
   *   <li>{@link EndermanAttackPlayerEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EndermanAttackPlayerEvent.<init>(Enderman, Player)",
    "HandlerList EndermanAttackPlayerEvent.getHandlerList()",
    "HandlerList EndermanAttackPlayerEvent.getHandlers()",
    "Player EndermanAttackPlayerEvent.getPlayer()",
    "boolean EndermanAttackPlayerEvent.isCancelled()",
    "void EndermanAttackPlayerEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Enderman entity = mock(Enderman.class);
    Player player = mock(Player.class);

    // Act
    EndermanAttackPlayerEvent actualEndermanAttackPlayerEvent =
        new EndermanAttackPlayerEvent(entity, player);
    actualEndermanAttackPlayerEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEndermanAttackPlayerEvent.getHandlerList();
    HandlerList actualHandlers = actualEndermanAttackPlayerEvent.getHandlers();
    Player actualPlayer = actualEndermanAttackPlayerEvent.getPlayer();
    boolean actualIsCancelledResult = actualEndermanAttackPlayerEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEndermanAttackPlayerEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEndermanAttackPlayerEvent.getEntity());
    assertSame(player, actualPlayer);
  }
}
