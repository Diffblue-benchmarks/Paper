package org.bukkit.event.player;

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

class PlayerItemHeldEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerItemHeldEvent#PlayerItemHeldEvent(Player, int, int)}
   *   <li>{@link PlayerItemHeldEvent#setCancelled(boolean)}
   *   <li>{@link PlayerItemHeldEvent#getHandlerList()}
   *   <li>{@link PlayerItemHeldEvent#getHandlers()}
   *   <li>{@link PlayerItemHeldEvent#getNewSlot()}
   *   <li>{@link PlayerItemHeldEvent#getPreviousSlot()}
   *   <li>{@link PlayerItemHeldEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerItemHeldEvent.<init>(Player, int, int)",
    "HandlerList PlayerItemHeldEvent.getHandlerList()",
    "HandlerList PlayerItemHeldEvent.getHandlers()",
    "int PlayerItemHeldEvent.getNewSlot()",
    "int PlayerItemHeldEvent.getPreviousSlot()",
    "boolean PlayerItemHeldEvent.isCancelled()",
    "void PlayerItemHeldEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerItemHeldEvent actualPlayerItemHeldEvent = new PlayerItemHeldEvent(player, 1, 1);
    actualPlayerItemHeldEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerItemHeldEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerItemHeldEvent.getHandlers();
    int actualNewSlot = actualPlayerItemHeldEvent.getNewSlot();
    int actualPreviousSlot = actualPlayerItemHeldEvent.getPreviousSlot();
    boolean actualIsCancelledResult = actualPlayerItemHeldEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualNewSlot);
    assertEquals(1, actualPreviousSlot);
    assertFalse(actualPlayerItemHeldEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerItemHeldEvent.getPlayer());
  }
}
