package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerChatTabCompleteEventDiffblueTest {
  /**
   * Test {@link PlayerChatTabCompleteEvent#PlayerChatTabCompleteEvent(Player, String, Collection)}.
   *
   * <ul>
   *   <li>Given {@code Completions cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChatTabCompleteEvent#PlayerChatTabCompleteEvent(Player,
   * String, Collection)}
   */
  @Test
  @DisplayName(
      "Test new PlayerChatTabCompleteEvent(Player, String, Collection); given 'Completions cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatTabCompleteEvent.<init>(Player, String, Collection)"})
  void testNewPlayerChatTabCompleteEvent_givenCompletionsCannotBeNull() {
    // Arrange
    Player player = mock(Player.class);

    ArrayList<String> completions = new ArrayList<>();
    completions.add("Completions cannot be null");
    completions.add("Message cannot be null");

    // Act
    PlayerChatTabCompleteEvent actualPlayerChatTabCompleteEvent =
        new PlayerChatTabCompleteEvent(player, "Not all who wander are lost", completions);

    // Assert
    assertEquals("Not all who wander are lost", actualPlayerChatTabCompleteEvent.getChatMessage());
    assertEquals("PlayerChatTabCompleteEvent", actualPlayerChatTabCompleteEvent.getEventName());
    assertEquals("lost", actualPlayerChatTabCompleteEvent.getLastToken());
    assertEquals(0, actualPlayerChatTabCompleteEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerChatTabCompleteEvent.isAsynchronous());
    assertSame(completions, actualPlayerChatTabCompleteEvent.getTabCompletions());
    assertSame(player, actualPlayerChatTabCompleteEvent.getPlayer());
  }

  /**
   * Test {@link PlayerChatTabCompleteEvent#PlayerChatTabCompleteEvent(Player, String, Collection)}.
   *
   * <ul>
   *   <li>Given {@code Message cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChatTabCompleteEvent#PlayerChatTabCompleteEvent(Player,
   * String, Collection)}
   */
  @Test
  @DisplayName(
      "Test new PlayerChatTabCompleteEvent(Player, String, Collection); given 'Message cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatTabCompleteEvent.<init>(Player, String, Collection)"})
  void testNewPlayerChatTabCompleteEvent_givenMessageCannotBeNull() {
    // Arrange
    Player player = mock(Player.class);

    ArrayList<String> completions = new ArrayList<>();
    completions.add("Message cannot be null");

    // Act
    PlayerChatTabCompleteEvent actualPlayerChatTabCompleteEvent =
        new PlayerChatTabCompleteEvent(player, "Not all who wander are lost", completions);

    // Assert
    assertEquals("Not all who wander are lost", actualPlayerChatTabCompleteEvent.getChatMessage());
    assertEquals("PlayerChatTabCompleteEvent", actualPlayerChatTabCompleteEvent.getEventName());
    assertEquals("lost", actualPlayerChatTabCompleteEvent.getLastToken());
    assertEquals(0, actualPlayerChatTabCompleteEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerChatTabCompleteEvent.isAsynchronous());
    assertSame(completions, actualPlayerChatTabCompleteEvent.getTabCompletions());
    assertSame(player, actualPlayerChatTabCompleteEvent.getPlayer());
  }

  /**
   * Test {@link PlayerChatTabCompleteEvent#PlayerChatTabCompleteEvent(Player, String, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChatTabCompleteEvent#PlayerChatTabCompleteEvent(Player,
   * String, Collection)}
   */
  @Test
  @DisplayName("Test new PlayerChatTabCompleteEvent(Player, String, Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatTabCompleteEvent.<init>(Player, String, Collection)"})
  void testNewPlayerChatTabCompleteEvent_whenArrayList() {
    // Arrange
    Player player = mock(Player.class);
    ArrayList<String> completions = new ArrayList<>();

    // Act
    PlayerChatTabCompleteEvent actualPlayerChatTabCompleteEvent =
        new PlayerChatTabCompleteEvent(player, "Not all who wander are lost", completions);

    // Assert
    assertEquals("Not all who wander are lost", actualPlayerChatTabCompleteEvent.getChatMessage());
    assertEquals("PlayerChatTabCompleteEvent", actualPlayerChatTabCompleteEvent.getEventName());
    assertEquals("lost", actualPlayerChatTabCompleteEvent.getLastToken());
    assertEquals(0, actualPlayerChatTabCompleteEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerChatTabCompleteEvent.isAsynchronous());
    assertSame(completions, actualPlayerChatTabCompleteEvent.getTabCompletions());
    assertSame(player, actualPlayerChatTabCompleteEvent.getPlayer());
  }

  /**
   * Test {@link PlayerChatTabCompleteEvent#PlayerChatTabCompleteEvent(Player, String, Collection)}.
   *
   * <ul>
   *   <li>When {@code Message}.
   *   <li>Then return ChatMessage is {@code Message}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChatTabCompleteEvent#PlayerChatTabCompleteEvent(Player,
   * String, Collection)}
   */
  @Test
  @DisplayName(
      "Test new PlayerChatTabCompleteEvent(Player, String, Collection); when 'Message'; then return ChatMessage is 'Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatTabCompleteEvent.<init>(Player, String, Collection)"})
  void testNewPlayerChatTabCompleteEvent_whenMessage_thenReturnChatMessageIsMessage() {
    // Arrange
    Player player = mock(Player.class);
    ArrayList<String> completions = new ArrayList<>();

    // Act
    PlayerChatTabCompleteEvent actualPlayerChatTabCompleteEvent =
        new PlayerChatTabCompleteEvent(player, "Message", completions);

    // Assert
    assertEquals("Message", actualPlayerChatTabCompleteEvent.getChatMessage());
    assertEquals("Message", actualPlayerChatTabCompleteEvent.getLastToken());
    assertEquals("PlayerChatTabCompleteEvent", actualPlayerChatTabCompleteEvent.getEventName());
    assertEquals(0, actualPlayerChatTabCompleteEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerChatTabCompleteEvent.isAsynchronous());
    assertSame(completions, actualPlayerChatTabCompleteEvent.getTabCompletions());
    assertSame(player, actualPlayerChatTabCompleteEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerChatTabCompleteEvent#getHandlerList()}
   *   <li>{@link PlayerChatTabCompleteEvent#getChatMessage()}
   *   <li>{@link PlayerChatTabCompleteEvent#getHandlers()}
   *   <li>{@link PlayerChatTabCompleteEvent#getLastToken()}
   *   <li>{@link PlayerChatTabCompleteEvent#getTabCompletions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PlayerChatTabCompleteEvent.getChatMessage()",
    "HandlerList PlayerChatTabCompleteEvent.getHandlerList()",
    "HandlerList PlayerChatTabCompleteEvent.getHandlers()",
    "String PlayerChatTabCompleteEvent.getLastToken()",
    "Collection PlayerChatTabCompleteEvent.getTabCompletions()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    ArrayList<String> completions = new ArrayList<>();

    PlayerChatTabCompleteEvent playerChatTabCompleteEvent =
        new PlayerChatTabCompleteEvent(player, "Not all who wander are lost", completions);

    // Act
    HandlerList actualHandlerList = playerChatTabCompleteEvent.getHandlerList();
    String actualChatMessage = playerChatTabCompleteEvent.getChatMessage();
    HandlerList actualHandlers = playerChatTabCompleteEvent.getHandlers();
    String actualLastToken = playerChatTabCompleteEvent.getLastToken();
    Collection<String> actualTabCompletions = playerChatTabCompleteEvent.getTabCompletions();

    // Assert
    assertTrue(actualTabCompletions instanceof List);
    assertEquals("Not all who wander are lost", actualChatMessage);
    assertEquals("lost", actualLastToken);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertSame(completions, actualTabCompletions);
    assertSame(actualHandlerList, actualHandlers);
  }
}
