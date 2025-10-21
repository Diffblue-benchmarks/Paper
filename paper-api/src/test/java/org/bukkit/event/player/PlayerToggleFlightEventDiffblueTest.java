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

class PlayerToggleFlightEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerToggleFlightEvent#PlayerToggleFlightEvent(Player, boolean)}
   *   <li>{@link PlayerToggleFlightEvent#setCancelled(boolean)}
   *   <li>{@link PlayerToggleFlightEvent#getHandlerList()}
   *   <li>{@link PlayerToggleFlightEvent#getHandlers()}
   *   <li>{@link PlayerToggleFlightEvent#isCancelled()}
   *   <li>{@link PlayerToggleFlightEvent#isFlying()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerToggleFlightEvent.<init>(Player, boolean)",
    "HandlerList PlayerToggleFlightEvent.getHandlerList()",
    "HandlerList PlayerToggleFlightEvent.getHandlers()",
    "boolean PlayerToggleFlightEvent.isCancelled()",
    "boolean PlayerToggleFlightEvent.isFlying()",
    "void PlayerToggleFlightEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerToggleFlightEvent actualPlayerToggleFlightEvent =
        new PlayerToggleFlightEvent(player, true);
    actualPlayerToggleFlightEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerToggleFlightEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerToggleFlightEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerToggleFlightEvent.isCancelled();
    boolean actualIsFlyingResult = actualPlayerToggleFlightEvent.isFlying();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerToggleFlightEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsFlyingResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerToggleFlightEvent.getPlayer());
  }
}
