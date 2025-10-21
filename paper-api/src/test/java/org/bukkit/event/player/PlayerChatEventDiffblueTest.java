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

class PlayerChatEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerChatEvent#PlayerChatEvent(Player, String, String, Set)}
   *   <li>{@link PlayerChatEvent#setCancelled(boolean)}
   *   <li>{@link PlayerChatEvent#setMessage(String)}
   *   <li>{@link PlayerChatEvent#getHandlerList()}
   *   <li>{@link PlayerChatEvent#getFormat()}
   *   <li>{@link PlayerChatEvent#getHandlers()}
   *   <li>{@link PlayerChatEvent#getMessage()}
   *   <li>{@link PlayerChatEvent#getRecipients()}
   *   <li>{@link PlayerChatEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerChatEvent.<init>(Player, String, String, Set)",
    "String PlayerChatEvent.getFormat()",
    "HandlerList PlayerChatEvent.getHandlerList()",
    "HandlerList PlayerChatEvent.getHandlers()",
    "String PlayerChatEvent.getMessage()",
    "Set PlayerChatEvent.getRecipients()",
    "boolean PlayerChatEvent.isCancelled()",
    "void PlayerChatEvent.setCancelled(boolean)",
    "void PlayerChatEvent.setMessage(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    HashSet<Player> recipients = new HashSet<>();

    // Act
    PlayerChatEvent actualPlayerChatEvent =
        new PlayerChatEvent(player, "Not all who wander are lost", "Format", recipients);
    actualPlayerChatEvent.setCancelled(true);
    actualPlayerChatEvent.setMessage("Not all who wander are lost");
    HandlerList actualHandlerList = actualPlayerChatEvent.getHandlerList();
    String actualFormat = actualPlayerChatEvent.getFormat();
    HandlerList actualHandlers = actualPlayerChatEvent.getHandlers();
    String actualMessage = actualPlayerChatEvent.getMessage();
    Set<Player> actualRecipients = actualPlayerChatEvent.getRecipients();
    boolean actualIsCancelledResult = actualPlayerChatEvent.isCancelled();

    // Assert
    assertEquals("Format", actualFormat);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerChatEvent.isAsynchronous());
    assertTrue(actualRecipients.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(recipients, actualRecipients);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerChatEvent.getPlayer());
  }

  /**
   * Test {@link PlayerChatEvent#PlayerChatEvent(Player, String)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChatEvent#PlayerChatEvent(Player, String)}
   */
  @Test
  @DisplayName("Test new PlayerChatEvent(Player, String); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatEvent.<init>(Player, String)"})
  void testNewPlayerChatEvent_givenRuntimeException() {
    // Arrange
    Player player = mock(Player.class);
    when(player.getServer()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new PlayerChatEvent(player, "Not all who wander are lost"));
    verify(player).getServer();
  }

  /**
   * Test {@link PlayerChatEvent#PlayerChatEvent(Player, String)}.
   *
   * <ul>
   *   <li>Given {@link Server} {@link Server#getOnlinePlayers()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChatEvent#PlayerChatEvent(Player, String)}
   */
  @Test
  @DisplayName(
      "Test new PlayerChatEvent(Player, String); given Server getOnlinePlayers() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatEvent.<init>(Player, String)"})
  void testNewPlayerChatEvent_givenServerGetOnlinePlayersThrowRuntimeException() {
    // Arrange
    Server server = mock(Server.class);
    org.mockito.Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenThrow(new RuntimeException());

    Player player = mock(Player.class);
    when(player.getServer()).thenReturn(server);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new PlayerChatEvent(player, "Not all who wander are lost"));
    verify(server).getOnlinePlayers();
    verify(player).getServer();
  }

  /**
   * Test {@link PlayerChatEvent#PlayerChatEvent(Player, String)}.
   *
   * <ul>
   *   <li>Then return Format is {@code <%1$s> %2$s}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChatEvent#PlayerChatEvent(Player, String)}
   */
  @Test
  @DisplayName("Test new PlayerChatEvent(Player, String); then return Format is '<%1$s> %2$s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatEvent.<init>(Player, String)"})
  void testNewPlayerChatEvent_thenReturnFormatIs1S2S() {
    // Arrange
    Server server = mock(Server.class);
    org.mockito.Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenReturn(new ArrayList<>());

    Player player = mock(Player.class);
    when(player.getServer()).thenReturn(server);

    // Act
    PlayerChatEvent actualPlayerChatEvent =
        new PlayerChatEvent(player, "Not all who wander are lost");

    // Assert
    verify(server).getOnlinePlayers();
    verify(player).getServer();
    assertEquals("<%1$s> %2$s", actualPlayerChatEvent.getFormat());
    assertEquals("Not all who wander are lost", actualPlayerChatEvent.getMessage());
    assertEquals("PlayerChatEvent", actualPlayerChatEvent.getEventName());
    assertEquals(0, actualPlayerChatEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerChatEvent.isAsynchronous());
    assertFalse(actualPlayerChatEvent.isCancelled());
    assertTrue(actualPlayerChatEvent.getRecipients().isEmpty());
    assertSame(player, actualPlayerChatEvent.getPlayer());
  }

  /**
   * Test {@link PlayerChatEvent#setPlayer(Player)}.
   *
   * <p>Method under test: {@link PlayerChatEvent#setPlayer(Player)}
   */
  @Test
  @DisplayName("Test setPlayer(Player)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatEvent.setPlayer(Player)"})
  void testSetPlayer() {
    // Arrange
    Server server = mock(Server.class);
    org.mockito.Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenReturn(new ArrayList<>());

    Player player = mock(Player.class);
    when(player.getServer()).thenReturn(server);
    PlayerChatEvent playerChatEvent = new PlayerChatEvent(player, "Not all who wander are lost");
    Player player2 = mock(Player.class);

    // Act
    playerChatEvent.setPlayer(player2);

    // Assert
    verify(server).getOnlinePlayers();
    verify(player).getServer();
    assertSame(player2, playerChatEvent.getPlayer());
  }

  /**
   * Test {@link PlayerChatEvent#setFormat(String)}.
   *
   * <p>Method under test: {@link PlayerChatEvent#setFormat(String)}
   */
  @Test
  @DisplayName("Test setFormat(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChatEvent.setFormat(String)"})
  void testSetFormat() {
    // Arrange
    Server server = mock(Server.class);
    org.mockito.Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenReturn(new ArrayList<>());

    Player player = mock(Player.class);
    when(player.getServer()).thenReturn(server);
    PlayerChatEvent playerChatEvent = new PlayerChatEvent(player, "Not all who wander are lost");

    // Act
    playerChatEvent.setFormat("Format");

    // Assert
    verify(server).getOnlinePlayers();
    verify(player).getServer();
    assertEquals("Format", playerChatEvent.getFormat());
  }
}
