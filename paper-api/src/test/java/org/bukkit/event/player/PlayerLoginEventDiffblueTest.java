package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerLoginEventDiffblueTest {
  /**
   * Test {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress)}.
   *
   * <p>Method under test: {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress)}
   */
  @Test
  @DisplayName("Test new PlayerLoginEvent(Player, String, InetAddress)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerLoginEvent.<init>(Player, String, InetAddress)"})
  void testNewPlayerLoginEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerLoginEvent actualPlayerLoginEvent = new PlayerLoginEvent(player, "localhost", null);

    // Assert
    assertEquals("", actualPlayerLoginEvent.getKickMessage());
    assertEquals("PlayerLoginEvent", actualPlayerLoginEvent.getEventName());
    assertEquals("localhost", actualPlayerLoginEvent.getHostname());
    assertNull(actualPlayerLoginEvent.getAddress());
    assertNull(actualPlayerLoginEvent.getRealAddress());
    assertEquals(0, actualPlayerLoginEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.ALLOWED, actualPlayerLoginEvent.getResult());
    assertFalse(actualPlayerLoginEvent.isAsynchronous());
    assertSame(player, actualPlayerLoginEvent.getPlayer());
  }

  /**
   * Test {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress, InetAddress)}.
   *
   * <p>Method under test: {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress,
   * InetAddress)}
   */
  @Test
  @DisplayName("Test new PlayerLoginEvent(Player, String, InetAddress, InetAddress)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerLoginEvent.<init>(Player, String, InetAddress, InetAddress)"})
  void testNewPlayerLoginEvent2() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerLoginEvent actualPlayerLoginEvent = new PlayerLoginEvent(player, "localhost", null, null);

    // Assert
    assertEquals("", actualPlayerLoginEvent.getKickMessage());
    assertEquals("PlayerLoginEvent", actualPlayerLoginEvent.getEventName());
    assertEquals("localhost", actualPlayerLoginEvent.getHostname());
    assertNull(actualPlayerLoginEvent.getAddress());
    assertNull(actualPlayerLoginEvent.getRealAddress());
    assertEquals(0, actualPlayerLoginEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.ALLOWED, actualPlayerLoginEvent.getResult());
    assertFalse(actualPlayerLoginEvent.isAsynchronous());
    assertSame(player, actualPlayerLoginEvent.getPlayer());
  }

  /**
   * Test {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress, Result, Component,
   * InetAddress)}.
   *
   * <p>Method under test: {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress,
   * Result, Component, InetAddress)}
   */
  @Test
  @DisplayName(
      "Test new PlayerLoginEvent(Player, String, InetAddress, Result, Component, InetAddress)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerLoginEvent.<init>(Player, String, InetAddress, Result, Component, InetAddress)"
  })
  void testNewPlayerLoginEvent3() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerLoginEvent actualPlayerLoginEvent =
        new PlayerLoginEvent(
            player, "localhost", null, Result.ALLOWED, mock(Component.class), null);

    // Assert
    assertEquals("PlayerLoginEvent", actualPlayerLoginEvent.getEventName());
    assertEquals("localhost", actualPlayerLoginEvent.getHostname());
    assertNull(actualPlayerLoginEvent.getAddress());
    assertNull(actualPlayerLoginEvent.getRealAddress());
    assertEquals(0, actualPlayerLoginEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.ALLOWED, actualPlayerLoginEvent.getResult());
    assertFalse(actualPlayerLoginEvent.isAsynchronous());
    assertSame(player, actualPlayerLoginEvent.getPlayer());
  }

  /**
   * Test {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress, Result, String,
   * InetAddress)}.
   *
   * <ul>
   *   <li>Then return KickMessage is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress,
   * Result, String, InetAddress)}
   */
  @Test
  @DisplayName(
      "Test new PlayerLoginEvent(Player, String, InetAddress, Result, String, InetAddress); then return KickMessage is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerLoginEvent.<init>(Player, String, InetAddress, Result, String, InetAddress)"
  })
  void testNewPlayerLoginEvent_thenReturnKickMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerLoginEvent actualPlayerLoginEvent =
        new PlayerLoginEvent(
            player, "localhost", null, Result.ALLOWED, "Not all who wander are lost", null);

    // Assert
    assertEquals("Not all who wander are lost", actualPlayerLoginEvent.getKickMessage());
    assertEquals("PlayerLoginEvent", actualPlayerLoginEvent.getEventName());
    assertEquals("localhost", actualPlayerLoginEvent.getHostname());
    assertNull(actualPlayerLoginEvent.getAddress());
    assertNull(actualPlayerLoginEvent.getRealAddress());
    assertEquals(0, actualPlayerLoginEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.ALLOWED, actualPlayerLoginEvent.getResult());
    assertFalse(actualPlayerLoginEvent.isAsynchronous());
    assertSame(player, actualPlayerLoginEvent.getPlayer());
  }

  /**
   * Test {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress, Result, String,
   * InetAddress)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return KickMessage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PlayerLoginEvent#PlayerLoginEvent(Player, String, InetAddress,
   * Result, String, InetAddress)}
   */
  @Test
  @DisplayName(
      "Test new PlayerLoginEvent(Player, String, InetAddress, Result, String, InetAddress); when empty string; then return KickMessage is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerLoginEvent.<init>(Player, String, InetAddress, Result, String, InetAddress)"
  })
  void testNewPlayerLoginEvent_whenEmptyString_thenReturnKickMessageIsEmptyString() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerLoginEvent actualPlayerLoginEvent =
        new PlayerLoginEvent(player, "localhost", null, Result.ALLOWED, "", null);

    // Assert
    assertEquals("", actualPlayerLoginEvent.getKickMessage());
    assertEquals("PlayerLoginEvent", actualPlayerLoginEvent.getEventName());
    assertEquals("localhost", actualPlayerLoginEvent.getHostname());
    assertNull(actualPlayerLoginEvent.getAddress());
    assertNull(actualPlayerLoginEvent.getRealAddress());
    assertEquals(0, actualPlayerLoginEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.ALLOWED, actualPlayerLoginEvent.getResult());
    assertFalse(actualPlayerLoginEvent.isAsynchronous());
    assertSame(player, actualPlayerLoginEvent.getPlayer());
  }
}
