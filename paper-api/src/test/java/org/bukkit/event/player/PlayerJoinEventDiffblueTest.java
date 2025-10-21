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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerJoinEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerJoinEvent#PlayerJoinEvent(Player, Component)}
   *   <li>{@link PlayerJoinEvent#joinMessage(Component)}
   *   <li>{@link PlayerJoinEvent#getHandlerList()}
   *   <li>{@link PlayerJoinEvent#getHandlers()}
   *   <li>{@link PlayerJoinEvent#joinMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerJoinEvent.<init>(Player, Component)",
    "HandlerList PlayerJoinEvent.getHandlerList()",
    "HandlerList PlayerJoinEvent.getHandlers()",
    "Component PlayerJoinEvent.joinMessage()",
    "void PlayerJoinEvent.joinMessage(Component)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player playerJoined = mock(Player.class);

    // Act
    PlayerJoinEvent actualPlayerJoinEvent =
        new PlayerJoinEvent(playerJoined, mock(Component.class));
    Component joinMessage = mock(Component.class);
    actualPlayerJoinEvent.joinMessage(joinMessage);
    HandlerList actualHandlerList = actualPlayerJoinEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerJoinEvent.getHandlers();
    Component actualJoinMessageResult = actualPlayerJoinEvent.joinMessage();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerJoinEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(joinMessage, actualJoinMessageResult);
    assertSame(playerJoined, actualPlayerJoinEvent.getPlayer());
  }

  /**
   * Test {@link PlayerJoinEvent#PlayerJoinEvent(Player, String)}.
   *
   * <ul>
   *   <li>When {@code Join Message}.
   *   <li>Then return {@code Join Message}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerJoinEvent#PlayerJoinEvent(Player, String)}
   */
  @Test
  @DisplayName(
      "Test new PlayerJoinEvent(Player, String); when 'Join Message'; then return 'Join Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerJoinEvent.<init>(Player, String)"})
  void testNewPlayerJoinEvent_whenJoinMessage_thenReturnJoinMessage() {
    // Arrange and Act
    PlayerJoinEvent actualPlayerJoinEvent = new PlayerJoinEvent(mock(Player.class), "Join Message");

    // Assert
    assertEquals("Join Message", actualPlayerJoinEvent.getJoinMessage());
    Component joinMessageResult = actualPlayerJoinEvent.joinMessage();
    assertNull(joinMessageResult.insertion());
    assertNull(joinMessageResult.font());
    assertNull(joinMessageResult.color());
    Map<TextDecoration, State> decorationsResult = joinMessageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(joinMessageResult.hasStyling());
    Component actualCompactResult = joinMessageResult.compact();
    assertEquals(joinMessageResult, actualCompactResult);
  }

  /**
   * Test {@link PlayerJoinEvent#PlayerJoinEvent(Player, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EventName is {@code PlayerJoinEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerJoinEvent#PlayerJoinEvent(Player, String)}
   */
  @Test
  @DisplayName(
      "Test new PlayerJoinEvent(Player, String); when 'null'; then return EventName is 'PlayerJoinEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerJoinEvent.<init>(Player, String)"})
  void testNewPlayerJoinEvent_whenNull_thenReturnEventNameIsPlayerJoinEvent() {
    // Arrange
    Player playerJoined = mock(Player.class);

    // Act
    PlayerJoinEvent actualPlayerJoinEvent = new PlayerJoinEvent(playerJoined, (String) null);

    // Assert
    assertEquals("PlayerJoinEvent", actualPlayerJoinEvent.getEventName());
    assertNull(actualPlayerJoinEvent.getJoinMessage());
    assertNull(actualPlayerJoinEvent.joinMessage());
    assertEquals(0, actualPlayerJoinEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerJoinEvent.isAsynchronous());
    assertSame(playerJoined, actualPlayerJoinEvent.getPlayer());
  }

  /**
   * Test {@link PlayerJoinEvent#getJoinMessage()}.
   *
   * <ul>
   *   <li>Then return {@code Join Message}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerJoinEvent#getJoinMessage()}
   */
  @Test
  @DisplayName("Test getJoinMessage(); then return 'Join Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlayerJoinEvent.getJoinMessage()"})
  void testGetJoinMessage_thenReturnJoinMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "Join Message", new PlayerJoinEvent(mock(Player.class), "Join Message").getJoinMessage());
  }

  /**
   * Test {@link PlayerJoinEvent#getJoinMessage()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerJoinEvent#getJoinMessage()}
   */
  @Test
  @DisplayName("Test getJoinMessage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlayerJoinEvent.getJoinMessage()"})
  void testGetJoinMessage_thenReturnNull() {
    // Arrange
    PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(mock(Player.class), "Join Message");
    playerJoinEvent.joinMessage(null);

    // Act and Assert
    assertNull(playerJoinEvent.getJoinMessage());
  }

  /**
   * Test {@link PlayerJoinEvent#setJoinMessage(String)}.
   *
   * <p>Method under test: {@link PlayerJoinEvent#setJoinMessage(String)}
   */
  @Test
  @DisplayName("Test setJoinMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerJoinEvent.setJoinMessage(String)"})
  void testSetJoinMessage() {
    // Arrange
    PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(mock(Player.class), "Join Message");

    // Act
    playerJoinEvent.setJoinMessage("Join Message");

    // Assert that nothing has changed
    assertEquals("Join Message", playerJoinEvent.getJoinMessage());
  }

  /**
   * Test {@link PlayerJoinEvent#setJoinMessage(String)}.
   *
   * <p>Method under test: {@link PlayerJoinEvent#setJoinMessage(String)}
   */
  @Test
  @DisplayName("Test setJoinMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerJoinEvent.setJoinMessage(String)"})
  void testSetJoinMessage2() {
    // Arrange
    PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(mock(Player.class), "Join Message");

    // Act
    playerJoinEvent.setJoinMessage(null);

    // Assert
    assertNull(playerJoinEvent.getJoinMessage());
    assertNull(playerJoinEvent.joinMessage());
  }
}
