package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerSignOpenEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerSignOpenEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerSignOpenEvent#PlayerSignOpenEvent(Player, Sign, Side, Cause)}
   *   <li>{@link PlayerSignOpenEvent#setCancelled(boolean)}
   *   <li>{@link PlayerSignOpenEvent#getHandlerList()}
   *   <li>{@link PlayerSignOpenEvent#getCause()}
   *   <li>{@link PlayerSignOpenEvent#getHandlers()}
   *   <li>{@link PlayerSignOpenEvent#getSide()}
   *   <li>{@link PlayerSignOpenEvent#getSign()}
   *   <li>{@link PlayerSignOpenEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerSignOpenEvent.<init>(Player, Sign, Side, Cause)",
    "Cause PlayerSignOpenEvent.getCause()",
    "HandlerList PlayerSignOpenEvent.getHandlerList()",
    "HandlerList PlayerSignOpenEvent.getHandlers()",
    "Side PlayerSignOpenEvent.getSide()",
    "Sign PlayerSignOpenEvent.getSign()",
    "boolean PlayerSignOpenEvent.isCancelled()",
    "void PlayerSignOpenEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Sign sign = mock(Sign.class);

    // Act
    PlayerSignOpenEvent actualPlayerSignOpenEvent =
        new PlayerSignOpenEvent(player, sign, Side.FRONT, Cause.INTERACT);
    actualPlayerSignOpenEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerSignOpenEvent.getHandlerList();
    Cause actualCause = actualPlayerSignOpenEvent.getCause();
    HandlerList actualHandlers = actualPlayerSignOpenEvent.getHandlers();
    Side actualSide = actualPlayerSignOpenEvent.getSide();
    Sign actualSign = actualPlayerSignOpenEvent.getSign();
    boolean actualIsCancelledResult = actualPlayerSignOpenEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Side.FRONT, actualSide);
    assertEquals(Cause.INTERACT, actualCause);
    assertFalse(actualPlayerSignOpenEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(sign, actualSign);
    assertSame(player, actualPlayerSignOpenEvent.getPlayer());
  }
}
