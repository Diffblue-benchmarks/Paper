package io.papermc.paper.event.connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.connection.PlayerConnection;
import net.kyori.adventure.text.Component;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerConnectionValidateLoginEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       PlayerConnectionValidateLoginEvent#PlayerConnectionValidateLoginEvent(PlayerConnection,
   *       Component)}
   *   <li>{@link PlayerConnectionValidateLoginEvent#kickMessage(Component)}
   *   <li>{@link PlayerConnectionValidateLoginEvent#allow()}
   *   <li>{@link PlayerConnectionValidateLoginEvent#getHandlerList()}
   *   <li>{@link PlayerConnectionValidateLoginEvent#getConnection()}
   *   <li>{@link PlayerConnectionValidateLoginEvent#getHandlers()}
   *   <li>{@link PlayerConnectionValidateLoginEvent#getKickMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerConnectionValidateLoginEvent.<init>(PlayerConnection, Component)",
    "void PlayerConnectionValidateLoginEvent.allow()",
    "PlayerConnection PlayerConnectionValidateLoginEvent.getConnection()",
    "HandlerList PlayerConnectionValidateLoginEvent.getHandlerList()",
    "HandlerList PlayerConnectionValidateLoginEvent.getHandlers()",
    "Component PlayerConnectionValidateLoginEvent.getKickMessage()",
    "void PlayerConnectionValidateLoginEvent.kickMessage(Component)"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerConnection connection = mock(PlayerConnection.class);

    // Act
    PlayerConnectionValidateLoginEvent actualPlayerConnectionValidateLoginEvent =
        new PlayerConnectionValidateLoginEvent(connection, mock(Component.class));
    actualPlayerConnectionValidateLoginEvent.kickMessage(mock(Component.class));
    actualPlayerConnectionValidateLoginEvent.allow();
    HandlerList actualHandlerList = actualPlayerConnectionValidateLoginEvent.getHandlerList();
    PlayerConnection actualConnection = actualPlayerConnectionValidateLoginEvent.getConnection();
    HandlerList actualHandlers = actualPlayerConnectionValidateLoginEvent.getHandlers();

    // Assert
    assertNull(actualPlayerConnectionValidateLoginEvent.getKickMessage());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerConnectionValidateLoginEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(connection, actualConnection);
  }

  /**
   * Test {@link PlayerConnectionValidateLoginEvent#isAllowed()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerConnectionValidateLoginEvent#isAllowed()}
   */
  @Test
  @DisplayName("Test isAllowed(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerConnectionValidateLoginEvent.isAllowed()"})
  void testIsAllowed_thenReturnFalse() {
    // Arrange
    PlayerConnectionValidateLoginEvent playerConnectionValidateLoginEvent =
        new PlayerConnectionValidateLoginEvent(mock(PlayerConnection.class), mock(Component.class));

    // Act and Assert
    assertFalse(playerConnectionValidateLoginEvent.isAllowed());
  }

  /**
   * Test {@link PlayerConnectionValidateLoginEvent#isAllowed()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerConnectionValidateLoginEvent#isAllowed()}
   */
  @Test
  @DisplayName("Test isAllowed(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerConnectionValidateLoginEvent.isAllowed()"})
  void testIsAllowed_thenReturnTrue() {
    // Arrange
    PlayerConnectionValidateLoginEvent playerConnectionValidateLoginEvent =
        new PlayerConnectionValidateLoginEvent(mock(PlayerConnection.class), null);

    // Act and Assert
    assertTrue(playerConnectionValidateLoginEvent.isAllowed());
  }
}
