package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerKickEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerKickEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerKickEvent#PlayerKickEvent(Player, Component, Component, Cause)}
   *   <li>{@link PlayerKickEvent#leaveMessage(Component)}
   *   <li>{@link PlayerKickEvent#reason(Component)}
   *   <li>{@link PlayerKickEvent#setCancelled(boolean)}
   *   <li>{@link PlayerKickEvent#getHandlerList()}
   *   <li>{@link PlayerKickEvent#getCause()}
   *   <li>{@link PlayerKickEvent#getHandlers()}
   *   <li>{@link PlayerKickEvent#isCancelled()}
   *   <li>{@link PlayerKickEvent#leaveMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerKickEvent.<init>(Player, Component, Component, Cause)",
    "Cause PlayerKickEvent.getCause()",
    "HandlerList PlayerKickEvent.getHandlerList()",
    "HandlerList PlayerKickEvent.getHandlers()",
    "boolean PlayerKickEvent.isCancelled()",
    "Component PlayerKickEvent.leaveMessage()",
    "void PlayerKickEvent.leaveMessage(Component)",
    "void PlayerKickEvent.reason(Component)",
    "void PlayerKickEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player playerKicked = mock(Player.class);

    // Act
    PlayerKickEvent actualPlayerKickEvent =
        new PlayerKickEvent(
            playerKicked, mock(Component.class), mock(Component.class), Cause.PLUGIN);
    Component leaveMessage = mock(Component.class);
    actualPlayerKickEvent.leaveMessage(leaveMessage);
    actualPlayerKickEvent.reason(mock(Component.class));
    actualPlayerKickEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerKickEvent.getHandlerList();
    Cause actualCause = actualPlayerKickEvent.getCause();
    HandlerList actualHandlers = actualPlayerKickEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerKickEvent.isCancelled();
    Component actualLeaveMessageResult = actualPlayerKickEvent.leaveMessage();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Cause.PLUGIN, actualCause);
    assertFalse(actualPlayerKickEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(leaveMessage, actualLeaveMessageResult);
    assertSame(playerKicked, actualPlayerKickEvent.getPlayer());
  }

  /**
   * Test {@link PlayerKickEvent#PlayerKickEvent(Player, String, String)}.
   *
   * <p>Method under test: {@link PlayerKickEvent#PlayerKickEvent(Player, String, String)}
   */
  @Test
  @DisplayName("Test new PlayerKickEvent(Player, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerKickEvent.<init>(Player, String, String)"})
  void testNewPlayerKickEvent() {
    // Arrange
    Player playerKicked = mock(Player.class);

    // Act
    PlayerKickEvent actualPlayerKickEvent =
        new PlayerKickEvent(playerKicked, "Just cause", "Leave Message");

    // Assert
    assertEquals("Just cause", actualPlayerKickEvent.getReason());
    assertEquals("Leave Message", actualPlayerKickEvent.getLeaveMessage());
    assertEquals("PlayerKickEvent", actualPlayerKickEvent.getEventName());
    assertEquals(Cause.UNKNOWN, actualPlayerKickEvent.getCause());
    assertFalse(actualPlayerKickEvent.isAsynchronous());
    assertFalse(actualPlayerKickEvent.isCancelled());
    assertSame(playerKicked, actualPlayerKickEvent.getPlayer());
  }

  /**
   * Test {@link PlayerKickEvent#PlayerKickEvent(Player, Component, Component)}.
   *
   * <p>Method under test: {@link PlayerKickEvent#PlayerKickEvent(Player, Component, Component)}
   */
  @Test
  @DisplayName("Test new PlayerKickEvent(Player, Component, Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerKickEvent.<init>(Player, Component, Component)"})
  void testNewPlayerKickEvent2() {
    // Arrange
    Player playerKicked = mock(Player.class);
    Component kickReason = mock(Component.class);
    Component leaveMessage = mock(Component.class);

    // Act
    PlayerKickEvent actualPlayerKickEvent =
        new PlayerKickEvent(playerKicked, kickReason, leaveMessage);

    // Assert
    assertEquals("PlayerKickEvent", actualPlayerKickEvent.getEventName());
    assertEquals(0, actualPlayerKickEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Cause.UNKNOWN, actualPlayerKickEvent.getCause());
    assertFalse(actualPlayerKickEvent.isAsynchronous());
    assertFalse(actualPlayerKickEvent.isCancelled());
    assertSame(leaveMessage, actualPlayerKickEvent.leaveMessage());
    assertSame(kickReason, actualPlayerKickEvent.reason());
    assertSame(playerKicked, actualPlayerKickEvent.getPlayer());
  }

  /**
   * Test {@link PlayerKickEvent#reason()}.
   *
   * <p>Method under test: {@link PlayerKickEvent#reason()}
   */
  @Test
  @DisplayName("Test reason()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component PlayerKickEvent.reason()"})
  void testReason() {
    // Arrange
    PlayerKickEvent playerKickEvent =
        new PlayerKickEvent(mock(Player.class), "Just cause", "Leave Message");

    // Act
    Component actualReasonResult = playerKickEvent.reason();

    // Assert
    assertNull(actualReasonResult.insertion());
    assertNull(actualReasonResult.font());
    assertNull(actualReasonResult.color());
    Map<TextDecoration, State> decorationsResult = actualReasonResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualReasonResult.hasStyling());
    Component actualCompactResult = actualReasonResult.compact();
    assertEquals(actualReasonResult, actualCompactResult);
  }

  /**
   * Test {@link PlayerKickEvent#getReason()}.
   *
   * <p>Method under test: {@link PlayerKickEvent#getReason()}
   */
  @Test
  @DisplayName("Test getReason()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlayerKickEvent.getReason()"})
  void testGetReason() {
    // Arrange
    PlayerKickEvent playerKickEvent =
        new PlayerKickEvent(mock(Player.class), "Just cause", "Leave Message");

    // Act and Assert
    assertEquals("Just cause", playerKickEvent.getReason());
  }

  /**
   * Test {@link PlayerKickEvent#getLeaveMessage()}.
   *
   * <p>Method under test: {@link PlayerKickEvent#getLeaveMessage()}
   */
  @Test
  @DisplayName("Test getLeaveMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlayerKickEvent.getLeaveMessage()"})
  void testGetLeaveMessage() {
    // Arrange
    PlayerKickEvent playerKickEvent =
        new PlayerKickEvent(mock(Player.class), "Just cause", "Leave Message");

    // Act and Assert
    assertEquals("Leave Message", playerKickEvent.getLeaveMessage());
  }
}
