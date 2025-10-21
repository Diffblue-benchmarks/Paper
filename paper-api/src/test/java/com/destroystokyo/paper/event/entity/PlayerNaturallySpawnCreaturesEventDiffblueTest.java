package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerNaturallySpawnCreaturesEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerNaturallySpawnCreaturesEvent#PlayerNaturallySpawnCreaturesEvent(Player,
   *       byte)}
   *   <li>{@link PlayerNaturallySpawnCreaturesEvent#setCancelled(boolean)}
   *   <li>{@link PlayerNaturallySpawnCreaturesEvent#setSpawnRadius(byte)}
   *   <li>{@link PlayerNaturallySpawnCreaturesEvent#getHandlerList()}
   *   <li>{@link PlayerNaturallySpawnCreaturesEvent#getHandlers()}
   *   <li>{@link PlayerNaturallySpawnCreaturesEvent#getSpawnRadius()}
   *   <li>{@link PlayerNaturallySpawnCreaturesEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerNaturallySpawnCreaturesEvent.<init>(Player, byte)",
    "HandlerList PlayerNaturallySpawnCreaturesEvent.getHandlerList()",
    "HandlerList PlayerNaturallySpawnCreaturesEvent.getHandlers()",
    "byte PlayerNaturallySpawnCreaturesEvent.getSpawnRadius()",
    "boolean PlayerNaturallySpawnCreaturesEvent.isCancelled()",
    "void PlayerNaturallySpawnCreaturesEvent.setCancelled(boolean)",
    "void PlayerNaturallySpawnCreaturesEvent.setSpawnRadius(byte)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerNaturallySpawnCreaturesEvent actualPlayerNaturallySpawnCreaturesEvent =
        new PlayerNaturallySpawnCreaturesEvent(player, (byte) 'A');
    actualPlayerNaturallySpawnCreaturesEvent.setCancelled(true);
    actualPlayerNaturallySpawnCreaturesEvent.setSpawnRadius((byte) 'A');
    HandlerList actualHandlerList = actualPlayerNaturallySpawnCreaturesEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerNaturallySpawnCreaturesEvent.getHandlers();
    byte actualSpawnRadius = actualPlayerNaturallySpawnCreaturesEvent.getSpawnRadius();
    boolean actualIsCancelledResult = actualPlayerNaturallySpawnCreaturesEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerNaturallySpawnCreaturesEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertEquals('A', actualSpawnRadius);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerNaturallySpawnCreaturesEvent.getPlayer());
  }
}
