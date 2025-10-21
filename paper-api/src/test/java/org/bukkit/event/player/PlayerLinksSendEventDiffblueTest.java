package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.connection.PlayerCommonConnection;
import io.papermc.paper.connection.PlayerConfigurationConnection;
import org.bukkit.ServerLinks;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerLinksSendEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerLinksSendEvent#PlayerLinksSendEvent(PlayerConfigurationConnection,
   *       ServerLinks)}
   *   <li>{@link PlayerLinksSendEvent#getHandlerList()}
   *   <li>{@link PlayerLinksSendEvent#getConnection()}
   *   <li>{@link PlayerLinksSendEvent#getHandlers()}
   *   <li>{@link PlayerLinksSendEvent#getLinks()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerLinksSendEvent.<init>(PlayerConfigurationConnection, ServerLinks)",
    "PlayerCommonConnection PlayerLinksSendEvent.getConnection()",
    "HandlerList PlayerLinksSendEvent.getHandlerList()",
    "HandlerList PlayerLinksSendEvent.getHandlers()",
    "ServerLinks PlayerLinksSendEvent.getLinks()"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerConfigurationConnection connection = mock(PlayerConfigurationConnection.class);
    ServerLinks links = mock(ServerLinks.class);

    // Act
    PlayerLinksSendEvent actualPlayerLinksSendEvent = new PlayerLinksSendEvent(connection, links);
    HandlerList actualHandlerList = actualPlayerLinksSendEvent.getHandlerList();
    PlayerCommonConnection actualConnection = actualPlayerLinksSendEvent.getConnection();
    HandlerList actualHandlers = actualPlayerLinksSendEvent.getHandlers();
    ServerLinks actualLinks = actualPlayerLinksSendEvent.getLinks();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerLinksSendEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(connection, actualConnection);
    assertSame(links, actualLinks);
  }
}
