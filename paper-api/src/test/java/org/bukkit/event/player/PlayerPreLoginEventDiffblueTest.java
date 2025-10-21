package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.util.UUID;
import org.bukkit.event.player.PlayerPreLoginEvent.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPreLoginEventDiffblueTest {
  /**
   * Test {@link PlayerPreLoginEvent#PlayerPreLoginEvent(String, InetAddress)}.
   *
   * <p>Method under test: {@link PlayerPreLoginEvent#PlayerPreLoginEvent(String, InetAddress)}
   */
  @Test
  @DisplayName("Test new PlayerPreLoginEvent(String, InetAddress)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerPreLoginEvent.<init>(String, InetAddress)"})
  void testNewPlayerPreLoginEvent() {
    // Arrange and Act
    PlayerPreLoginEvent actualPlayerPreLoginEvent = new PlayerPreLoginEvent("Name", null);

    // Assert
    assertEquals("", actualPlayerPreLoginEvent.getKickMessage());
    assertEquals("Name", actualPlayerPreLoginEvent.getName());
    assertEquals("PlayerPreLoginEvent", actualPlayerPreLoginEvent.getEventName());
    assertNull(actualPlayerPreLoginEvent.getAddress());
    assertNull(actualPlayerPreLoginEvent.getUniqueId());
    assertEquals(0, actualPlayerPreLoginEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.ALLOWED, actualPlayerPreLoginEvent.getResult());
    assertFalse(actualPlayerPreLoginEvent.isAsynchronous());
  }

  /**
   * Test {@link PlayerPreLoginEvent#PlayerPreLoginEvent(String, InetAddress, UUID)}.
   *
   * <p>Method under test: {@link PlayerPreLoginEvent#PlayerPreLoginEvent(String, InetAddress,
   * UUID)}
   */
  @Test
  @DisplayName("Test new PlayerPreLoginEvent(String, InetAddress, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerPreLoginEvent.<init>(String, InetAddress, UUID)"})
  void testNewPlayerPreLoginEvent2() {
    // Arrange
    UUID uniqueId = UUID.randomUUID();

    // Act
    PlayerPreLoginEvent actualPlayerPreLoginEvent = new PlayerPreLoginEvent("Name", null, uniqueId);

    // Assert
    assertEquals("", actualPlayerPreLoginEvent.getKickMessage());
    assertEquals("Name", actualPlayerPreLoginEvent.getName());
    assertEquals("PlayerPreLoginEvent", actualPlayerPreLoginEvent.getEventName());
    assertNull(actualPlayerPreLoginEvent.getAddress());
    assertEquals(0, actualPlayerPreLoginEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.ALLOWED, actualPlayerPreLoginEvent.getResult());
    assertFalse(actualPlayerPreLoginEvent.isAsynchronous());
    assertSame(uniqueId, actualPlayerPreLoginEvent.getUniqueId());
  }
}
