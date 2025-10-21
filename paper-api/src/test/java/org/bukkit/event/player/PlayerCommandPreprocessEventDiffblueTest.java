package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerCommandPreprocessEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerCommandPreprocessEvent#PlayerCommandPreprocessEvent(Player, String, Set)}
   *   <li>{@link PlayerCommandPreprocessEvent#setCancelled(boolean)}
   *   <li>{@link PlayerCommandPreprocessEvent#getHandlerList()}
   *   <li>{@link PlayerCommandPreprocessEvent#getHandlers()}
   *   <li>{@link PlayerCommandPreprocessEvent#getMessage()}
   *   <li>{@link PlayerCommandPreprocessEvent#getRecipients()}
   *   <li>{@link PlayerCommandPreprocessEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerCommandPreprocessEvent.<init>(Player, String, Set)",
    "HandlerList PlayerCommandPreprocessEvent.getHandlerList()",
    "HandlerList PlayerCommandPreprocessEvent.getHandlers()",
    "String PlayerCommandPreprocessEvent.getMessage()",
    "Set PlayerCommandPreprocessEvent.getRecipients()",
    "boolean PlayerCommandPreprocessEvent.isCancelled()",
    "void PlayerCommandPreprocessEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    HashSet<Player> recipients = new HashSet<>();

    // Act
    PlayerCommandPreprocessEvent actualPlayerCommandPreprocessEvent =
        new PlayerCommandPreprocessEvent(player, "Not all who wander are lost", recipients);
    actualPlayerCommandPreprocessEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerCommandPreprocessEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerCommandPreprocessEvent.getHandlers();
    String actualMessage = actualPlayerCommandPreprocessEvent.getMessage();
    Set<Player> actualRecipients = actualPlayerCommandPreprocessEvent.getRecipients();
    boolean actualIsCancelledResult = actualPlayerCommandPreprocessEvent.isCancelled();

    // Assert
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerCommandPreprocessEvent.isAsynchronous());
    assertTrue(actualRecipients.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(recipients, actualRecipients);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerCommandPreprocessEvent.getPlayer());
  }

  /**
   * Test {@link PlayerCommandPreprocessEvent#PlayerCommandPreprocessEvent(Player, String)}.
   *
   * <p>Method under test: {@link PlayerCommandPreprocessEvent#PlayerCommandPreprocessEvent(Player,
   * String)}
   */
  @Test
  @DisplayName("Test new PlayerCommandPreprocessEvent(Player, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerCommandPreprocessEvent.<init>(Player, String)"})
  void testNewPlayerCommandPreprocessEvent() {
    // Arrange
    Server server = mock(Server.class);
    org.mockito.Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenThrow(new IllegalArgumentException());

    Player player = mock(Player.class);
    when(player.getServer()).thenReturn(server);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PlayerCommandPreprocessEvent(player, "Not all who wander are lost"));
    verify(server).getOnlinePlayers();
    verify(player).getServer();
  }

  /**
   * Test {@link PlayerCommandPreprocessEvent#PlayerCommandPreprocessEvent(Player, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerCommandPreprocessEvent#PlayerCommandPreprocessEvent(Player,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new PlayerCommandPreprocessEvent(Player, String); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerCommandPreprocessEvent.<init>(Player, String)"})
  void testNewPlayerCommandPreprocessEvent_givenIllegalArgumentException() {
    // Arrange
    Player player = mock(Player.class);
    when(player.getServer()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PlayerCommandPreprocessEvent(player, "Not all who wander are lost"));
    verify(player).getServer();
  }

  /**
   * Test {@link PlayerCommandPreprocessEvent#PlayerCommandPreprocessEvent(Player, String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerCommandPreprocessEvent#PlayerCommandPreprocessEvent(Player,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new PlayerCommandPreprocessEvent(Player, String); then return Message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerCommandPreprocessEvent.<init>(Player, String)"})
  void testNewPlayerCommandPreprocessEvent_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    Server server = mock(Server.class);
    org.mockito.Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenReturn(new ArrayList<>());

    Player player = mock(Player.class);
    when(player.getServer()).thenReturn(server);

    // Act
    PlayerCommandPreprocessEvent actualPlayerCommandPreprocessEvent =
        new PlayerCommandPreprocessEvent(player, "Not all who wander are lost");

    // Assert
    verify(server).getOnlinePlayers();
    verify(player).getServer();
    assertEquals("Not all who wander are lost", actualPlayerCommandPreprocessEvent.getMessage());
    assertEquals("PlayerCommandPreprocessEvent", actualPlayerCommandPreprocessEvent.getEventName());
    assertEquals(
        0, actualPlayerCommandPreprocessEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerCommandPreprocessEvent.isAsynchronous());
    assertFalse(actualPlayerCommandPreprocessEvent.isCancelled());
    assertTrue(actualPlayerCommandPreprocessEvent.getRecipients().isEmpty());
    assertSame(player, actualPlayerCommandPreprocessEvent.getPlayer());
  }

  /**
   * Test {@link PlayerCommandPreprocessEvent#setMessage(String)}.
   *
   * <p>Method under test: {@link PlayerCommandPreprocessEvent#setMessage(String)}
   */
  @Test
  @DisplayName("Test setMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerCommandPreprocessEvent.setMessage(String)"})
  void testSetMessage() throws IllegalArgumentException {
    // Arrange
    Server server = mock(Server.class);
    org.mockito.Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenReturn(new ArrayList<>());

    Player player = mock(Player.class);
    when(player.getServer()).thenReturn(server);
    PlayerCommandPreprocessEvent playerCommandPreprocessEvent =
        new PlayerCommandPreprocessEvent(player, "Not all who wander are lost");

    // Act
    playerCommandPreprocessEvent.setMessage("Command");

    // Assert
    verify(server).getOnlinePlayers();
    verify(player).getServer();
    assertEquals("Command", playerCommandPreprocessEvent.getMessage());
  }

  /**
   * Test {@link PlayerCommandPreprocessEvent#setPlayer(Player)}.
   *
   * <p>Method under test: {@link PlayerCommandPreprocessEvent#setPlayer(Player)}
   */
  @Test
  @DisplayName("Test setPlayer(Player)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerCommandPreprocessEvent.setPlayer(Player)"})
  void testSetPlayer() throws IllegalArgumentException {
    // Arrange
    Server server = mock(Server.class);
    org.mockito.Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenReturn(new ArrayList<>());

    Player player = mock(Player.class);
    when(player.getServer()).thenReturn(server);
    PlayerCommandPreprocessEvent playerCommandPreprocessEvent =
        new PlayerCommandPreprocessEvent(player, "Not all who wander are lost");
    Player player2 = mock(Player.class);

    // Act
    playerCommandPreprocessEvent.setPlayer(player2);

    // Assert
    verify(server).getOnlinePlayers();
    verify(player).getServer();
    assertSame(player2, playerCommandPreprocessEvent.getPlayer());
  }
}
