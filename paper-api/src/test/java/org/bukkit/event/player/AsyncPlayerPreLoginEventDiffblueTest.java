package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.connection.PlayerLoginConnection;
import java.net.InetAddress;
import java.util.UUID;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AsyncPlayerPreLoginEventDiffblueTest {
  /**
   * Test {@link AsyncPlayerPreLoginEvent#AsyncPlayerPreLoginEvent(String, InetAddress, InetAddress,
   * UUID, boolean, PlayerProfile, String, PlayerLoginConnection)}.
   *
   * <p>Method under test: {@link AsyncPlayerPreLoginEvent#AsyncPlayerPreLoginEvent(String,
   * InetAddress, InetAddress, UUID, boolean, PlayerProfile, String, PlayerLoginConnection)}
   */
  @Test
  @DisplayName(
      "Test new AsyncPlayerPreLoginEvent(String, InetAddress, InetAddress, UUID, boolean, PlayerProfile, String, PlayerLoginConnection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncPlayerPreLoginEvent.<init>(String, InetAddress, InetAddress, UUID, boolean, PlayerProfile, String, PlayerLoginConnection)"
  })
  void testNewAsyncPlayerPreLoginEvent() {
    // Arrange
    PlayerProfile profile = mock(PlayerProfile.class);
    PlayerLoginConnection playerLoginConnection = mock(PlayerLoginConnection.class);

    // Act
    AsyncPlayerPreLoginEvent actualAsyncPlayerPreLoginEvent =
        new AsyncPlayerPreLoginEvent(
            "Name",
            null,
            null,
            UUID.randomUUID(),
            true,
            profile,
            "localhost",
            playerLoginConnection);

    // Assert
    assertEquals("", actualAsyncPlayerPreLoginEvent.getKickMessage());
    assertEquals("AsyncPlayerPreLoginEvent", actualAsyncPlayerPreLoginEvent.getEventName());
    assertEquals("localhost", actualAsyncPlayerPreLoginEvent.getHostname());
    assertNull(actualAsyncPlayerPreLoginEvent.getName());
    assertNull(actualAsyncPlayerPreLoginEvent.getAddress());
    assertNull(actualAsyncPlayerPreLoginEvent.getRawAddress());
    assertNull(actualAsyncPlayerPreLoginEvent.getUniqueId());
    assertEquals(Result.ALLOWED, actualAsyncPlayerPreLoginEvent.getLoginResult());
    assertEquals(PlayerPreLoginEvent.Result.ALLOWED, actualAsyncPlayerPreLoginEvent.getResult());
    assertTrue(actualAsyncPlayerPreLoginEvent.isAsynchronous());
    assertTrue(actualAsyncPlayerPreLoginEvent.isTransferred());
    assertSame(profile, actualAsyncPlayerPreLoginEvent.getPlayerProfile());
    assertSame(playerLoginConnection, actualAsyncPlayerPreLoginEvent.getConnection());
  }

  /**
   * Test {@link AsyncPlayerPreLoginEvent#AsyncPlayerPreLoginEvent(String, InetAddress, UUID,
   * boolean, PlayerProfile)}.
   *
   * <p>Method under test: {@link AsyncPlayerPreLoginEvent#AsyncPlayerPreLoginEvent(String,
   * InetAddress, UUID, boolean, PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test new AsyncPlayerPreLoginEvent(String, InetAddress, UUID, boolean, PlayerProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncPlayerPreLoginEvent.<init>(String, InetAddress, UUID, boolean, PlayerProfile)"
  })
  void testNewAsyncPlayerPreLoginEvent2() {
    // Arrange
    PlayerProfile profile = mock(PlayerProfile.class);

    // Act
    AsyncPlayerPreLoginEvent actualAsyncPlayerPreLoginEvent =
        new AsyncPlayerPreLoginEvent("Name", null, UUID.randomUUID(), true, profile);

    // Assert
    assertEquals("", actualAsyncPlayerPreLoginEvent.getHostname());
    assertEquals("", actualAsyncPlayerPreLoginEvent.getKickMessage());
    assertEquals("AsyncPlayerPreLoginEvent", actualAsyncPlayerPreLoginEvent.getEventName());
    assertNull(actualAsyncPlayerPreLoginEvent.getConnection());
    assertNull(actualAsyncPlayerPreLoginEvent.getName());
    assertNull(actualAsyncPlayerPreLoginEvent.getAddress());
    assertNull(actualAsyncPlayerPreLoginEvent.getRawAddress());
    assertNull(actualAsyncPlayerPreLoginEvent.getUniqueId());
    assertEquals(Result.ALLOWED, actualAsyncPlayerPreLoginEvent.getLoginResult());
    assertEquals(PlayerPreLoginEvent.Result.ALLOWED, actualAsyncPlayerPreLoginEvent.getResult());
    assertTrue(actualAsyncPlayerPreLoginEvent.isAsynchronous());
    assertTrue(actualAsyncPlayerPreLoginEvent.isTransferred());
    assertSame(profile, actualAsyncPlayerPreLoginEvent.getPlayerProfile());
  }

  /**
   * Test {@link AsyncPlayerPreLoginEvent#AsyncPlayerPreLoginEvent(String, InetAddress, InetAddress,
   * UUID, boolean, PlayerProfile)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AsyncPlayerPreLoginEvent#AsyncPlayerPreLoginEvent(String,
   * InetAddress, InetAddress, UUID, boolean, PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test new AsyncPlayerPreLoginEvent(String, InetAddress, InetAddress, UUID, boolean, PlayerProfile); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncPlayerPreLoginEvent.<init>(String, InetAddress, InetAddress, UUID, boolean, PlayerProfile)"
  })
  void testNewAsyncPlayerPreLoginEvent_whenEmptyString() {
    // Arrange
    PlayerProfile profile = mock(PlayerProfile.class);

    // Act
    AsyncPlayerPreLoginEvent actualAsyncPlayerPreLoginEvent =
        new AsyncPlayerPreLoginEvent("", null, null, UUID.randomUUID(), true, profile);

    // Assert
    assertEquals("", actualAsyncPlayerPreLoginEvent.getHostname());
    assertEquals("", actualAsyncPlayerPreLoginEvent.getKickMessage());
    assertEquals("AsyncPlayerPreLoginEvent", actualAsyncPlayerPreLoginEvent.getEventName());
    assertNull(actualAsyncPlayerPreLoginEvent.getConnection());
    assertNull(actualAsyncPlayerPreLoginEvent.getName());
    assertNull(actualAsyncPlayerPreLoginEvent.getAddress());
    assertNull(actualAsyncPlayerPreLoginEvent.getRawAddress());
    assertNull(actualAsyncPlayerPreLoginEvent.getUniqueId());
    assertEquals(Result.ALLOWED, actualAsyncPlayerPreLoginEvent.getLoginResult());
    assertEquals(PlayerPreLoginEvent.Result.ALLOWED, actualAsyncPlayerPreLoginEvent.getResult());
    assertTrue(actualAsyncPlayerPreLoginEvent.isAsynchronous());
    assertTrue(actualAsyncPlayerPreLoginEvent.isTransferred());
    assertSame(profile, actualAsyncPlayerPreLoginEvent.getPlayerProfile());
  }

  /**
   * Test {@link AsyncPlayerPreLoginEvent#AsyncPlayerPreLoginEvent(String, InetAddress, InetAddress,
   * UUID, boolean, PlayerProfile)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link AsyncPlayerPreLoginEvent#AsyncPlayerPreLoginEvent(String,
   * InetAddress, InetAddress, UUID, boolean, PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test new AsyncPlayerPreLoginEvent(String, InetAddress, InetAddress, UUID, boolean, PlayerProfile); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncPlayerPreLoginEvent.<init>(String, InetAddress, InetAddress, UUID, boolean, PlayerProfile)"
  })
  void testNewAsyncPlayerPreLoginEvent_whenName() {
    // Arrange
    PlayerProfile profile = mock(PlayerProfile.class);

    // Act
    AsyncPlayerPreLoginEvent actualAsyncPlayerPreLoginEvent =
        new AsyncPlayerPreLoginEvent("Name", null, null, UUID.randomUUID(), true, profile);

    // Assert
    assertEquals("", actualAsyncPlayerPreLoginEvent.getHostname());
    assertEquals("", actualAsyncPlayerPreLoginEvent.getKickMessage());
    assertEquals("AsyncPlayerPreLoginEvent", actualAsyncPlayerPreLoginEvent.getEventName());
    assertNull(actualAsyncPlayerPreLoginEvent.getConnection());
    assertNull(actualAsyncPlayerPreLoginEvent.getName());
    assertNull(actualAsyncPlayerPreLoginEvent.getAddress());
    assertNull(actualAsyncPlayerPreLoginEvent.getRawAddress());
    assertNull(actualAsyncPlayerPreLoginEvent.getUniqueId());
    assertEquals(Result.ALLOWED, actualAsyncPlayerPreLoginEvent.getLoginResult());
    assertEquals(PlayerPreLoginEvent.Result.ALLOWED, actualAsyncPlayerPreLoginEvent.getResult());
    assertTrue(actualAsyncPlayerPreLoginEvent.isAsynchronous());
    assertTrue(actualAsyncPlayerPreLoginEvent.isTransferred());
    assertSame(profile, actualAsyncPlayerPreLoginEvent.getPlayerProfile());
  }
}
