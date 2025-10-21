package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerHandshakeEventDiffblueTest {
  /**
   * Test {@link PlayerHandshakeEvent#PlayerHandshakeEvent(String, String, boolean)}.
   *
   * <p>Method under test: {@link PlayerHandshakeEvent#PlayerHandshakeEvent(String, String,
   * boolean)}
   */
  @Test
  @DisplayName("Test new PlayerHandshakeEvent(String, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerHandshakeEvent.<init>(String, String, boolean)"})
  void testNewPlayerHandshakeEvent() {
    // Arrange and Act
    PlayerHandshakeEvent actualPlayerHandshakeEvent =
        new PlayerHandshakeEvent("Original Handshake", "42 Main St", true);

    // Assert
    assertEquals("42 Main St", actualPlayerHandshakeEvent.getOriginalSocketAddressHostname());
    assertEquals("Original Handshake", actualPlayerHandshakeEvent.getOriginalHandshake());
    assertEquals("PlayerHandshakeEvent", actualPlayerHandshakeEvent.getEventName());
    assertEquals(
        "§eIf you wish to use IP forwarding, please enable it in your BungeeCord config as well!",
        actualPlayerHandshakeEvent.getFailMessage());
    assertNull(actualPlayerHandshakeEvent.getPropertiesJson());
    assertNull(actualPlayerHandshakeEvent.getServerHostname());
    assertNull(actualPlayerHandshakeEvent.getSocketAddressHostname());
    assertNull(actualPlayerHandshakeEvent.getUniqueId());
    assertFalse(actualPlayerHandshakeEvent.isFailed());
    assertTrue(actualPlayerHandshakeEvent.isCancelled());
    assertTrue(actualPlayerHandshakeEvent.isAsynchronous());
  }

  /**
   * Test {@link PlayerHandshakeEvent#PlayerHandshakeEvent(String, boolean)}.
   *
   * <p>Method under test: {@link PlayerHandshakeEvent#PlayerHandshakeEvent(String, boolean)}
   */
  @Test
  @DisplayName("Test new PlayerHandshakeEvent(String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerHandshakeEvent.<init>(String, boolean)"})
  void testNewPlayerHandshakeEvent2() {
    // Arrange and Act
    PlayerHandshakeEvent actualPlayerHandshakeEvent =
        new PlayerHandshakeEvent("Original Handshake", true);

    // Assert
    assertEquals("Original Handshake", actualPlayerHandshakeEvent.getOriginalHandshake());
    assertEquals("PlayerHandshakeEvent", actualPlayerHandshakeEvent.getEventName());
    assertEquals(
        "§eIf you wish to use IP forwarding, please enable it in your BungeeCord config as well!",
        actualPlayerHandshakeEvent.getFailMessage());
    assertNull(actualPlayerHandshakeEvent.getPropertiesJson());
    assertNull(actualPlayerHandshakeEvent.getServerHostname());
    assertNull(actualPlayerHandshakeEvent.getSocketAddressHostname());
    assertNull(actualPlayerHandshakeEvent.getUniqueId());
    assertFalse(actualPlayerHandshakeEvent.isFailed());
    assertTrue(actualPlayerHandshakeEvent.isCancelled());
    assertTrue(actualPlayerHandshakeEvent.isAsynchronous());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerHandshakeEvent#failMessage(Component)}
   *   <li>{@link PlayerHandshakeEvent#setCancelled(boolean)}
   *   <li>{@link PlayerHandshakeEvent#setFailed(boolean)}
   *   <li>{@link PlayerHandshakeEvent#setPropertiesJson(String)}
   *   <li>{@link PlayerHandshakeEvent#setServerHostname(String)}
   *   <li>{@link PlayerHandshakeEvent#setSocketAddressHostname(String)}
   *   <li>{@link PlayerHandshakeEvent#setUniqueId(UUID)}
   *   <li>{@link PlayerHandshakeEvent#getHandlerList()}
   *   <li>{@link PlayerHandshakeEvent#failMessage()}
   *   <li>{@link PlayerHandshakeEvent#getHandlers()}
   *   <li>{@link PlayerHandshakeEvent#getOriginalHandshake()}
   *   <li>{@link PlayerHandshakeEvent#getOriginalSocketAddressHostname()}
   *   <li>{@link PlayerHandshakeEvent#getPropertiesJson()}
   *   <li>{@link PlayerHandshakeEvent#getServerHostname()}
   *   <li>{@link PlayerHandshakeEvent#getSocketAddressHostname()}
   *   <li>{@link PlayerHandshakeEvent#getUniqueId()}
   *   <li>{@link PlayerHandshakeEvent#isCancelled()}
   *   <li>{@link PlayerHandshakeEvent#isFailed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Component PlayerHandshakeEvent.failMessage()",
    "void PlayerHandshakeEvent.failMessage(Component)",
    "HandlerList PlayerHandshakeEvent.getHandlerList()",
    "HandlerList PlayerHandshakeEvent.getHandlers()",
    "String PlayerHandshakeEvent.getOriginalHandshake()",
    "String PlayerHandshakeEvent.getOriginalSocketAddressHostname()",
    "String PlayerHandshakeEvent.getPropertiesJson()",
    "String PlayerHandshakeEvent.getServerHostname()",
    "String PlayerHandshakeEvent.getSocketAddressHostname()",
    "UUID PlayerHandshakeEvent.getUniqueId()",
    "boolean PlayerHandshakeEvent.isCancelled()",
    "boolean PlayerHandshakeEvent.isFailed()",
    "void PlayerHandshakeEvent.setCancelled(boolean)",
    "void PlayerHandshakeEvent.setFailed(boolean)",
    "void PlayerHandshakeEvent.setPropertiesJson(String)",
    "void PlayerHandshakeEvent.setServerHostname(String)",
    "void PlayerHandshakeEvent.setSocketAddressHostname(String)",
    "void PlayerHandshakeEvent.setUniqueId(UUID)"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerHandshakeEvent playerHandshakeEvent =
        new PlayerHandshakeEvent("Original Handshake", true);
    Component failMessage = mock(Component.class);

    // Act
    playerHandshakeEvent.failMessage(failMessage);
    playerHandshakeEvent.setCancelled(true);
    playerHandshakeEvent.setFailed(true);
    playerHandshakeEvent.setPropertiesJson("Properties Json");
    playerHandshakeEvent.setServerHostname("localhost");
    playerHandshakeEvent.setSocketAddressHostname("42 Main St");
    UUID uniqueId = UUID.randomUUID();
    playerHandshakeEvent.setUniqueId(uniqueId);
    HandlerList actualHandlerList = playerHandshakeEvent.getHandlerList();
    Component actualFailMessageResult = playerHandshakeEvent.failMessage();
    HandlerList actualHandlers = playerHandshakeEvent.getHandlers();
    String actualOriginalHandshake = playerHandshakeEvent.getOriginalHandshake();
    playerHandshakeEvent.getOriginalSocketAddressHostname();
    String actualPropertiesJson = playerHandshakeEvent.getPropertiesJson();
    String actualServerHostname = playerHandshakeEvent.getServerHostname();
    String actualSocketAddressHostname = playerHandshakeEvent.getSocketAddressHostname();
    UUID actualUniqueId = playerHandshakeEvent.getUniqueId();
    boolean actualIsCancelledResult = playerHandshakeEvent.isCancelled();

    // Assert
    assertEquals("42 Main St", actualSocketAddressHostname);
    assertEquals("Original Handshake", actualOriginalHandshake);
    assertEquals("Properties Json", actualPropertiesJson);
    assertEquals("localhost", actualServerHostname);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualIsCancelledResult);
    assertTrue(playerHandshakeEvent.isFailed());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(uniqueId, actualUniqueId);
    assertSame(failMessage, actualFailMessageResult);
  }

  /**
   * Test {@link PlayerHandshakeEvent#getFailMessage()}.
   *
   * <p>Method under test: {@link PlayerHandshakeEvent#getFailMessage()}
   */
  @Test
  @DisplayName("Test getFailMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlayerHandshakeEvent.getFailMessage()"})
  void testGetFailMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "§eIf you wish to use IP forwarding, please enable it in your BungeeCord config as well!",
        new PlayerHandshakeEvent("Original Handshake", true).getFailMessage());
  }

  /**
   * Test {@link PlayerHandshakeEvent#setFailMessage(String)}.
   *
   * <p>Method under test: {@link PlayerHandshakeEvent#setFailMessage(String)}
   */
  @Test
  @DisplayName("Test setFailMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerHandshakeEvent.setFailMessage(String)"})
  void testSetFailMessage() {
    // Arrange
    PlayerHandshakeEvent playerHandshakeEvent =
        new PlayerHandshakeEvent("Original Handshake", true);

    // Act
    playerHandshakeEvent.setFailMessage("Fail Message");

    // Assert
    assertEquals("Fail Message", playerHandshakeEvent.getFailMessage());
    Component failMessageResult = playerHandshakeEvent.failMessage();
    assertNull(failMessageResult.color());
    Component compactResult = failMessageResult.compact();
    assertNull(compactResult.color());
    Component compactResult2 = compactResult.compact();
    assertNull(compactResult2.color());
    Component compactResult3 = compactResult2.compact();
    assertNull(compactResult3.color());
    Component compactResult4 = compactResult3.compact();
    assertNull(compactResult4.color());
    assertFalse(failMessageResult.hasStyling());
    assertFalse(compactResult.hasStyling());
    assertFalse(compactResult2.hasStyling());
    assertFalse(compactResult3.hasStyling());
    assertFalse(compactResult4.hasStyling());
  }
}
