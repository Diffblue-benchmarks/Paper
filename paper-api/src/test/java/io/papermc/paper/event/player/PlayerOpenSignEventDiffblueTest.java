package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.player.PlayerOpenSignEvent.Cause;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerOpenSignEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerOpenSignEvent#PlayerOpenSignEvent(Player, Sign, Side, Cause)}
   *   <li>{@link PlayerOpenSignEvent#setCancelled(boolean)}
   *   <li>{@link PlayerOpenSignEvent#getHandlerList()}
   *   <li>{@link PlayerOpenSignEvent#getCause()}
   *   <li>{@link PlayerOpenSignEvent#getHandlers()}
   *   <li>{@link PlayerOpenSignEvent#getSide()}
   *   <li>{@link PlayerOpenSignEvent#getSign()}
   *   <li>{@link PlayerOpenSignEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerOpenSignEvent.<init>(Player, Sign, Side, Cause)",
    "Cause PlayerOpenSignEvent.getCause()",
    "HandlerList PlayerOpenSignEvent.getHandlerList()",
    "HandlerList PlayerOpenSignEvent.getHandlers()",
    "Side PlayerOpenSignEvent.getSide()",
    "Sign PlayerOpenSignEvent.getSign()",
    "boolean PlayerOpenSignEvent.isCancelled()",
    "void PlayerOpenSignEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player editor = mock(Player.class);
    Sign sign = mock(Sign.class);

    // Act
    PlayerOpenSignEvent actualPlayerOpenSignEvent =
        new PlayerOpenSignEvent(editor, sign, Side.FRONT, Cause.PLACE);
    actualPlayerOpenSignEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerOpenSignEvent.getHandlerList();
    Cause actualCause = actualPlayerOpenSignEvent.getCause();
    HandlerList actualHandlers = actualPlayerOpenSignEvent.getHandlers();
    Side actualSide = actualPlayerOpenSignEvent.getSide();
    Sign actualSign = actualPlayerOpenSignEvent.getSign();
    boolean actualIsCancelledResult = actualPlayerOpenSignEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Cause.PLACE, actualCause);
    assertEquals(Side.FRONT, actualSide);
    assertFalse(actualPlayerOpenSignEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(sign, actualSign);
    assertSame(editor, actualPlayerOpenSignEvent.getPlayer());
  }
}
