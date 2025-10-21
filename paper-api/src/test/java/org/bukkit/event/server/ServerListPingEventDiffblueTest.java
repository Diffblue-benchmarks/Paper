package org.bukkit.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerListPingEventDiffblueTest {
  /**
   * Test {@link ServerListPingEvent#ServerListPingEvent(String, InetAddress, String, int)}.
   *
   * <p>Method under test: {@link ServerListPingEvent#ServerListPingEvent(String, InetAddress,
   * String, int)}
   */
  @Test
  @DisplayName("Test new ServerListPingEvent(String, InetAddress, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerListPingEvent.<init>(String, InetAddress, String, int)"})
  void testNewServerListPingEvent() {
    // Arrange and Act
    ServerListPingEvent actualServerListPingEvent =
        new ServerListPingEvent("localhost", null, "Motd", 3);

    // Assert
    assertEquals("Motd", actualServerListPingEvent.getMotd());
    assertEquals("ServerListPingEvent", actualServerListPingEvent.getEventName());
    assertEquals("localhost", actualServerListPingEvent.getHostname());
    Component motdResult = actualServerListPingEvent.motd();
    assertNull(motdResult.insertion());
    assertNull(actualServerListPingEvent.getAddress());
    assertNull(motdResult.font());
    assertNull(motdResult.color());
    assertEquals(0, actualServerListPingEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(3, actualServerListPingEvent.getMaxPlayers());
    Map<TextDecoration, State> decorationsResult = motdResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(motdResult.hasStyling());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    assertTrue(actualServerListPingEvent.isAsynchronous());
    Component actualCompactResult = motdResult.compact();
    assertEquals(motdResult, actualCompactResult);
  }

  /**
   * Test {@link ServerListPingEvent#ServerListPingEvent(String, InetAddress, String, int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code Motd}.
   * </ul>
   *
   * <p>Method under test: {@link ServerListPingEvent#ServerListPingEvent(String, InetAddress,
   * String, int, int)}
   */
  @Test
  @DisplayName(
      "Test new ServerListPingEvent(String, InetAddress, String, int, int); when zero; then return 'Motd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerListPingEvent.<init>(String, InetAddress, String, int, int)"})
  void testNewServerListPingEvent_whenZero_thenReturnMotd() {
    // Arrange and Act
    ServerListPingEvent actualServerListPingEvent =
        new ServerListPingEvent("localhost", null, "Motd", 0, 3);

    // Assert
    assertEquals("Motd", actualServerListPingEvent.getMotd());
    assertEquals("ServerListPingEvent", actualServerListPingEvent.getEventName());
    assertEquals("localhost", actualServerListPingEvent.getHostname());
    Component motdResult = actualServerListPingEvent.motd();
    assertNull(motdResult.insertion());
    assertNull(actualServerListPingEvent.getAddress());
    assertNull(motdResult.font());
    assertNull(motdResult.color());
    assertEquals(0, actualServerListPingEvent.getNumPlayers());
    assertEquals(0, actualServerListPingEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(3, actualServerListPingEvent.getMaxPlayers());
    Map<TextDecoration, State> decorationsResult = motdResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(motdResult.hasStyling());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    assertTrue(actualServerListPingEvent.isAsynchronous());
    Component actualCompactResult = motdResult.compact();
    assertEquals(motdResult, actualCompactResult);
  }
}
