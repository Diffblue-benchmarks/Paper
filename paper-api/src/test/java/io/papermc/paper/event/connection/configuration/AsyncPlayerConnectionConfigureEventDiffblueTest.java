package io.papermc.paper.event.connection.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.connection.PlayerConfigurationConnection;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AsyncPlayerConnectionConfigureEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       AsyncPlayerConnectionConfigureEvent#AsyncPlayerConnectionConfigureEvent(PlayerConfigurationConnection)}
   *   <li>{@link AsyncPlayerConnectionConfigureEvent#getHandlerList()}
   *   <li>{@link AsyncPlayerConnectionConfigureEvent#getConnection()}
   *   <li>{@link AsyncPlayerConnectionConfigureEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncPlayerConnectionConfigureEvent.<init>(PlayerConfigurationConnection)",
    "PlayerConfigurationConnection AsyncPlayerConnectionConfigureEvent.getConnection()",
    "HandlerList AsyncPlayerConnectionConfigureEvent.getHandlerList()",
    "HandlerList AsyncPlayerConnectionConfigureEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerConfigurationConnection connection = mock(PlayerConfigurationConnection.class);

    // Act
    AsyncPlayerConnectionConfigureEvent actualAsyncPlayerConnectionConfigureEvent =
        new AsyncPlayerConnectionConfigureEvent(connection);
    HandlerList actualHandlerList = actualAsyncPlayerConnectionConfigureEvent.getHandlerList();
    PlayerConfigurationConnection actualConnection =
        actualAsyncPlayerConnectionConfigureEvent.getConnection();
    HandlerList actualHandlers = actualAsyncPlayerConnectionConfigureEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualAsyncPlayerConnectionConfigureEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(connection, actualConnection);
  }
}
