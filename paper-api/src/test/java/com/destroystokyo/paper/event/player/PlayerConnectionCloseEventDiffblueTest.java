package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.util.UUID;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerConnectionCloseEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerConnectionCloseEvent#PlayerConnectionCloseEvent(UUID, String, InetAddress,
   *       boolean)}
   *   <li>{@link PlayerConnectionCloseEvent#getHandlerList()}
   *   <li>{@link PlayerConnectionCloseEvent#getHandlers()}
   *   <li>{@link PlayerConnectionCloseEvent#getIpAddress()}
   *   <li>{@link PlayerConnectionCloseEvent#getPlayerName()}
   *   <li>{@link PlayerConnectionCloseEvent#getPlayerUniqueId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerConnectionCloseEvent.<init>(UUID, String, InetAddress, boolean)",
    "HandlerList PlayerConnectionCloseEvent.getHandlerList()",
    "HandlerList PlayerConnectionCloseEvent.getHandlers()",
    "InetAddress PlayerConnectionCloseEvent.getIpAddress()",
    "String PlayerConnectionCloseEvent.getPlayerName()",
    "UUID PlayerConnectionCloseEvent.getPlayerUniqueId()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID playerUniqueId = UUID.randomUUID();

    // Act
    PlayerConnectionCloseEvent actualPlayerConnectionCloseEvent =
        new PlayerConnectionCloseEvent(playerUniqueId, "Player Name", null, true);
    HandlerList actualHandlerList = actualPlayerConnectionCloseEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerConnectionCloseEvent.getHandlers();
    InetAddress actualIpAddress = actualPlayerConnectionCloseEvent.getIpAddress();
    String actualPlayerName = actualPlayerConnectionCloseEvent.getPlayerName();
    UUID actualPlayerUniqueId = actualPlayerConnectionCloseEvent.getPlayerUniqueId();

    // Assert
    assertEquals("Player Name", actualPlayerName);
    assertNull(actualIpAddress);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualPlayerConnectionCloseEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(playerUniqueId, actualPlayerUniqueId);
  }
}
