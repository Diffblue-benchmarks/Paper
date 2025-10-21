package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerGameModeChangeEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerGameModeChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerGameModeChangeEvent#PlayerGameModeChangeEvent(Player, GameMode, Cause,
   *       Component)}
   *   <li>{@link PlayerGameModeChangeEvent#cancelMessage(Component)}
   *   <li>{@link PlayerGameModeChangeEvent#setCancelled(boolean)}
   *   <li>{@link PlayerGameModeChangeEvent#getHandlerList()}
   *   <li>{@link PlayerGameModeChangeEvent#cancelMessage()}
   *   <li>{@link PlayerGameModeChangeEvent#getCause()}
   *   <li>{@link PlayerGameModeChangeEvent#getHandlers()}
   *   <li>{@link PlayerGameModeChangeEvent#getNewGameMode()}
   *   <li>{@link PlayerGameModeChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerGameModeChangeEvent.<init>(Player, GameMode, Cause, Component)",
    "Component PlayerGameModeChangeEvent.cancelMessage()",
    "void PlayerGameModeChangeEvent.cancelMessage(Component)",
    "Cause PlayerGameModeChangeEvent.getCause()",
    "HandlerList PlayerGameModeChangeEvent.getHandlerList()",
    "HandlerList PlayerGameModeChangeEvent.getHandlers()",
    "GameMode PlayerGameModeChangeEvent.getNewGameMode()",
    "boolean PlayerGameModeChangeEvent.isCancelled()",
    "void PlayerGameModeChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerGameModeChangeEvent actualPlayerGameModeChangeEvent =
        new PlayerGameModeChangeEvent(
            player, GameMode.CREATIVE, Cause.PLUGIN, mock(Component.class));
    Component message = mock(Component.class);
    actualPlayerGameModeChangeEvent.cancelMessage(message);
    actualPlayerGameModeChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerGameModeChangeEvent.getHandlerList();
    Component actualCancelMessageResult = actualPlayerGameModeChangeEvent.cancelMessage();
    Cause actualCause = actualPlayerGameModeChangeEvent.getCause();
    HandlerList actualHandlers = actualPlayerGameModeChangeEvent.getHandlers();
    GameMode actualNewGameMode = actualPlayerGameModeChangeEvent.getNewGameMode();
    boolean actualIsCancelledResult = actualPlayerGameModeChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(GameMode.CREATIVE, actualNewGameMode);
    assertEquals(Cause.PLUGIN, actualCause);
    assertFalse(actualPlayerGameModeChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(message, actualCancelMessageResult);
    assertSame(player, actualPlayerGameModeChangeEvent.getPlayer());
  }

  /**
   * Test {@link PlayerGameModeChangeEvent#PlayerGameModeChangeEvent(Player, GameMode)}.
   *
   * <p>Method under test: {@link PlayerGameModeChangeEvent#PlayerGameModeChangeEvent(Player,
   * GameMode)}
   */
  @Test
  @DisplayName("Test new PlayerGameModeChangeEvent(Player, GameMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerGameModeChangeEvent.<init>(Player, GameMode)"})
  void testNewPlayerGameModeChangeEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerGameModeChangeEvent actualPlayerGameModeChangeEvent =
        new PlayerGameModeChangeEvent(player, GameMode.CREATIVE);

    // Assert
    assertEquals("PlayerGameModeChangeEvent", actualPlayerGameModeChangeEvent.getEventName());
    assertNull(actualPlayerGameModeChangeEvent.cancelMessage());
    assertEquals(0, actualPlayerGameModeChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(GameMode.CREATIVE, actualPlayerGameModeChangeEvent.getNewGameMode());
    assertEquals(Cause.UNKNOWN, actualPlayerGameModeChangeEvent.getCause());
    assertFalse(actualPlayerGameModeChangeEvent.isAsynchronous());
    assertFalse(actualPlayerGameModeChangeEvent.isCancelled());
    assertSame(player, actualPlayerGameModeChangeEvent.getPlayer());
  }
}
