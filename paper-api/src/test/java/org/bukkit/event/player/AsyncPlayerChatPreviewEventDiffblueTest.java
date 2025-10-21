package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AsyncPlayerChatPreviewEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AsyncPlayerChatPreviewEvent#AsyncPlayerChatPreviewEvent(boolean, Player, String,
   *       Set)}
   *   <li>{@link AsyncPlayerChatPreviewEvent#getHandlerList()}
   *   <li>{@link AsyncPlayerChatPreviewEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncPlayerChatPreviewEvent.<init>(boolean, Player, String, Set)",
    "HandlerList AsyncPlayerChatPreviewEvent.getHandlerList()",
    "HandlerList AsyncPlayerChatPreviewEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    HashSet<Player> players = new HashSet<>();

    // Act
    AsyncPlayerChatPreviewEvent actualAsyncPlayerChatPreviewEvent =
        new AsyncPlayerChatPreviewEvent(true, player, "Not all who wander are lost", players);
    HandlerList actualHandlerList = actualAsyncPlayerChatPreviewEvent.getHandlerList();
    HandlerList actualHandlers = actualAsyncPlayerChatPreviewEvent.getHandlers();

    // Assert
    assertEquals("<%1$s> %2$s", actualAsyncPlayerChatPreviewEvent.getFormat());
    assertEquals("Not all who wander are lost", actualAsyncPlayerChatPreviewEvent.getMessage());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualAsyncPlayerChatPreviewEvent.isCancelled());
    Set<Player> recipients = actualAsyncPlayerChatPreviewEvent.getRecipients();
    assertTrue(recipients.isEmpty());
    assertTrue(actualAsyncPlayerChatPreviewEvent.isAsynchronous());
    assertSame(players, recipients);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualAsyncPlayerChatPreviewEvent.getPlayer());
  }
}
