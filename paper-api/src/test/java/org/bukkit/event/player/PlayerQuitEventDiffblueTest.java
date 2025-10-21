package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerQuitEvent.QuitReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerQuitEventDiffblueTest {
  /**
   * Test {@link PlayerQuitEvent#PlayerQuitEvent(Player, Component)}.
   *
   * <p>Method under test: {@link PlayerQuitEvent#PlayerQuitEvent(Player, Component)}
   */
  @Test
  @DisplayName("Test new PlayerQuitEvent(Player, Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.<init>(Player, Component)"})
  void testNewPlayerQuitEvent() {
    // Arrange
    Player player = mock(Player.class);
    Component quitMessage = mock(Component.class);

    // Act
    PlayerQuitEvent actualPlayerQuitEvent = new PlayerQuitEvent(player, quitMessage);

    // Assert
    assertEquals("PlayerQuitEvent", actualPlayerQuitEvent.getEventName());
    assertEquals(0, actualPlayerQuitEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(QuitReason.DISCONNECTED, actualPlayerQuitEvent.getReason());
    assertFalse(actualPlayerQuitEvent.isAsynchronous());
    assertSame(quitMessage, actualPlayerQuitEvent.quitMessage());
    assertSame(player, actualPlayerQuitEvent.getPlayer());
  }

  /**
   * Test {@link PlayerQuitEvent#PlayerQuitEvent(Player, Component, QuitReason)}.
   *
   * <ul>
   *   <li>When {@code DISCONNECTED}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#PlayerQuitEvent(Player, Component, QuitReason)}
   */
  @Test
  @DisplayName("Test new PlayerQuitEvent(Player, Component, QuitReason); when 'DISCONNECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.<init>(Player, Component, QuitReason)"})
  void testNewPlayerQuitEvent_whenDisconnected() {
    // Arrange
    Player player = mock(Player.class);
    Component quitMessage = mock(Component.class);

    // Act
    PlayerQuitEvent actualPlayerQuitEvent =
        new PlayerQuitEvent(player, quitMessage, QuitReason.DISCONNECTED);

    // Assert
    assertEquals("PlayerQuitEvent", actualPlayerQuitEvent.getEventName());
    assertEquals(0, actualPlayerQuitEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(QuitReason.DISCONNECTED, actualPlayerQuitEvent.getReason());
    assertFalse(actualPlayerQuitEvent.isAsynchronous());
    assertSame(quitMessage, actualPlayerQuitEvent.quitMessage());
    assertSame(player, actualPlayerQuitEvent.getPlayer());
  }

  /**
   * Test {@link PlayerQuitEvent#PlayerQuitEvent(Player, Component, QuitReason)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#PlayerQuitEvent(Player, Component, QuitReason)}
   */
  @Test
  @DisplayName("Test new PlayerQuitEvent(Player, Component, QuitReason); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.<init>(Player, Component, QuitReason)"})
  void testNewPlayerQuitEvent_whenNull() {
    // Arrange
    Player player = mock(Player.class);
    Component quitMessage = mock(Component.class);

    // Act
    PlayerQuitEvent actualPlayerQuitEvent = new PlayerQuitEvent(player, quitMessage, null);

    // Assert
    assertEquals("PlayerQuitEvent", actualPlayerQuitEvent.getEventName());
    assertEquals(0, actualPlayerQuitEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(QuitReason.DISCONNECTED, actualPlayerQuitEvent.getReason());
    assertFalse(actualPlayerQuitEvent.isAsynchronous());
    assertSame(quitMessage, actualPlayerQuitEvent.quitMessage());
    assertSame(player, actualPlayerQuitEvent.getPlayer());
  }

  /**
   * Test {@link PlayerQuitEvent#PlayerQuitEvent(Player, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EventName is {@code PlayerQuitEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#PlayerQuitEvent(Player, String)}
   */
  @Test
  @DisplayName(
      "Test new PlayerQuitEvent(Player, String); when 'null'; then return EventName is 'PlayerQuitEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.<init>(Player, String)"})
  void testNewPlayerQuitEvent_whenNull_thenReturnEventNameIsPlayerQuitEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerQuitEvent actualPlayerQuitEvent = new PlayerQuitEvent(player, (String) null);

    // Assert
    assertEquals("PlayerQuitEvent", actualPlayerQuitEvent.getEventName());
    assertNull(actualPlayerQuitEvent.getQuitMessage());
    assertNull(actualPlayerQuitEvent.quitMessage());
    assertEquals(0, actualPlayerQuitEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(QuitReason.DISCONNECTED, actualPlayerQuitEvent.getReason());
    assertFalse(actualPlayerQuitEvent.isAsynchronous());
    assertSame(player, actualPlayerQuitEvent.getPlayer());
  }

  /**
   * Test {@link PlayerQuitEvent#PlayerQuitEvent(Player, String, QuitReason)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EventName is {@code PlayerQuitEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#PlayerQuitEvent(Player, String, QuitReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerQuitEvent(Player, String, QuitReason); when 'null'; then return EventName is 'PlayerQuitEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.<init>(Player, String, QuitReason)"})
  void testNewPlayerQuitEvent_whenNull_thenReturnEventNameIsPlayerQuitEvent2() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerQuitEvent actualPlayerQuitEvent = new PlayerQuitEvent(player, (String) null, null);

    // Assert
    assertEquals("PlayerQuitEvent", actualPlayerQuitEvent.getEventName());
    assertNull(actualPlayerQuitEvent.getQuitMessage());
    assertNull(actualPlayerQuitEvent.quitMessage());
    assertEquals(0, actualPlayerQuitEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(QuitReason.DISCONNECTED, actualPlayerQuitEvent.getReason());
    assertFalse(actualPlayerQuitEvent.isAsynchronous());
    assertSame(player, actualPlayerQuitEvent.getPlayer());
  }

  /**
   * Test {@link PlayerQuitEvent#PlayerQuitEvent(Player, String)}.
   *
   * <ul>
   *   <li>When {@code Quit Message}.
   *   <li>Then return {@code Quit Message}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#PlayerQuitEvent(Player, String)}
   */
  @Test
  @DisplayName(
      "Test new PlayerQuitEvent(Player, String); when 'Quit Message'; then return 'Quit Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.<init>(Player, String)"})
  void testNewPlayerQuitEvent_whenQuitMessage_thenReturnQuitMessage() {
    // Arrange and Act
    PlayerQuitEvent actualPlayerQuitEvent = new PlayerQuitEvent(mock(Player.class), "Quit Message");

    // Assert
    assertEquals("Quit Message", actualPlayerQuitEvent.getQuitMessage());
    Component quitMessageResult = actualPlayerQuitEvent.quitMessage();
    assertNull(quitMessageResult.insertion());
    assertNull(quitMessageResult.font());
    assertNull(quitMessageResult.color());
    Map<TextDecoration, State> decorationsResult = quitMessageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(quitMessageResult.hasStyling());
    Component actualCompactResult = quitMessageResult.compact();
    assertEquals(quitMessageResult, actualCompactResult);
  }

  /**
   * Test {@link PlayerQuitEvent#PlayerQuitEvent(Player, String, QuitReason)}.
   *
   * <ul>
   *   <li>When {@code Quit Message}.
   *   <li>Then return {@code Quit Message}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#PlayerQuitEvent(Player, String, QuitReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerQuitEvent(Player, String, QuitReason); when 'Quit Message'; then return 'Quit Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.<init>(Player, String, QuitReason)"})
  void testNewPlayerQuitEvent_whenQuitMessage_thenReturnQuitMessage2() {
    // Arrange and Act
    PlayerQuitEvent actualPlayerQuitEvent =
        new PlayerQuitEvent(mock(Player.class), "Quit Message", QuitReason.DISCONNECTED);

    // Assert
    assertEquals("Quit Message", actualPlayerQuitEvent.getQuitMessage());
    Component quitMessageResult = actualPlayerQuitEvent.quitMessage();
    assertNull(quitMessageResult.insertion());
    assertNull(quitMessageResult.font());
    assertNull(quitMessageResult.color());
    Map<TextDecoration, State> decorationsResult = quitMessageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(quitMessageResult.hasStyling());
    Component actualCompactResult = quitMessageResult.compact();
    assertEquals(quitMessageResult, actualCompactResult);
  }

  /**
   * Test {@link PlayerQuitEvent#getQuitMessage()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#getQuitMessage()}
   */
  @Test
  @DisplayName("Test getQuitMessage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlayerQuitEvent.getQuitMessage()"})
  void testGetQuitMessage_thenReturnNull() {
    // Arrange
    PlayerQuitEvent playerQuitEvent = new PlayerQuitEvent(mock(Player.class), "Quit Message");
    playerQuitEvent.quitMessage(null);

    // Act and Assert
    assertNull(playerQuitEvent.getQuitMessage());
  }

  /**
   * Test {@link PlayerQuitEvent#getQuitMessage()}.
   *
   * <ul>
   *   <li>Then return {@code Quit Message}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#getQuitMessage()}
   */
  @Test
  @DisplayName("Test getQuitMessage(); then return 'Quit Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlayerQuitEvent.getQuitMessage()"})
  void testGetQuitMessage_thenReturnQuitMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "Quit Message", new PlayerQuitEvent(mock(Player.class), "Quit Message").getQuitMessage());
  }

  /**
   * Test {@link PlayerQuitEvent#setQuitMessage(String)}.
   *
   * <p>Method under test: {@link PlayerQuitEvent#setQuitMessage(String)}
   */
  @Test
  @DisplayName("Test setQuitMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.setQuitMessage(String)"})
  void testSetQuitMessage() {
    // Arrange
    PlayerQuitEvent playerQuitEvent = new PlayerQuitEvent(mock(Player.class), "Quit Message");

    // Act
    playerQuitEvent.setQuitMessage("Quit Message");

    // Assert that nothing has changed
    assertEquals("Quit Message", playerQuitEvent.getQuitMessage());
  }

  /**
   * Test {@link PlayerQuitEvent#setQuitMessage(String)}.
   *
   * <ul>
   *   <li>Then {@link PlayerQuitEvent#PlayerQuitEvent(Player, String)} with {@link Player} and
   *       {@code Quit Message} QuitMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerQuitEvent#setQuitMessage(String)}
   */
  @Test
  @DisplayName(
      "Test setQuitMessage(String); then PlayerQuitEvent(Player, String) with Player and 'Quit Message' QuitMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerQuitEvent.setQuitMessage(String)"})
  void testSetQuitMessage_thenPlayerQuitEventWithPlayerAndQuitMessageQuitMessageIsNull() {
    // Arrange
    PlayerQuitEvent playerQuitEvent = new PlayerQuitEvent(mock(Player.class), "Quit Message");

    // Act
    playerQuitEvent.setQuitMessage(null);

    // Assert
    assertNull(playerQuitEvent.getQuitMessage());
    assertNull(playerQuitEvent.quitMessage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerQuitEvent#quitMessage(Component)}
   *   <li>{@link PlayerQuitEvent#getHandlerList()}
   *   <li>{@link PlayerQuitEvent#getHandlers()}
   *   <li>{@link PlayerQuitEvent#getReason()}
   *   <li>{@link PlayerQuitEvent#quitMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList PlayerQuitEvent.getHandlerList()",
    "HandlerList PlayerQuitEvent.getHandlers()",
    "QuitReason PlayerQuitEvent.getReason()",
    "Component PlayerQuitEvent.quitMessage()",
    "void PlayerQuitEvent.quitMessage(Component)"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerQuitEvent playerQuitEvent = new PlayerQuitEvent(mock(Player.class), "Quit Message");
    Component quitMessage = mock(Component.class);

    // Act
    playerQuitEvent.quitMessage(quitMessage);
    HandlerList actualHandlerList = playerQuitEvent.getHandlerList();
    HandlerList actualHandlers = playerQuitEvent.getHandlers();
    QuitReason actualReason = playerQuitEvent.getReason();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(QuitReason.DISCONNECTED, actualReason);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(quitMessage, playerQuitEvent.quitMessage());
  }
}
