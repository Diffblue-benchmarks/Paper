package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Set;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AsyncPlayerChatEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AsyncPlayerChatEvent#AsyncPlayerChatEvent(boolean, Player, String, Set)}
   *   <li>{@link AsyncPlayerChatEvent#setCancelled(boolean)}
   *   <li>{@link AsyncPlayerChatEvent#setMessage(String)}
   *   <li>{@link AsyncPlayerChatEvent#getHandlerList()}
   *   <li>{@link AsyncPlayerChatEvent#getFormat()}
   *   <li>{@link AsyncPlayerChatEvent#getHandlers()}
   *   <li>{@link AsyncPlayerChatEvent#getMessage()}
   *   <li>{@link AsyncPlayerChatEvent#getRecipients()}
   *   <li>{@link AsyncPlayerChatEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncPlayerChatEvent.<init>(boolean, Player, String, Set)",
    "String AsyncPlayerChatEvent.getFormat()",
    "HandlerList AsyncPlayerChatEvent.getHandlerList()",
    "HandlerList AsyncPlayerChatEvent.getHandlers()",
    "String AsyncPlayerChatEvent.getMessage()",
    "Set AsyncPlayerChatEvent.getRecipients()",
    "boolean AsyncPlayerChatEvent.isCancelled()",
    "void AsyncPlayerChatEvent.setCancelled(boolean)",
    "void AsyncPlayerChatEvent.setMessage(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    HashSet<Player> players = new HashSet<>();

    // Act
    AsyncPlayerChatEvent actualAsyncPlayerChatEvent =
        new AsyncPlayerChatEvent(true, player, "Not all who wander are lost", players);
    actualAsyncPlayerChatEvent.setCancelled(true);
    actualAsyncPlayerChatEvent.setMessage("Not all who wander are lost");
    HandlerList actualHandlerList = actualAsyncPlayerChatEvent.getHandlerList();
    String actualFormat = actualAsyncPlayerChatEvent.getFormat();
    HandlerList actualHandlers = actualAsyncPlayerChatEvent.getHandlers();
    String actualMessage = actualAsyncPlayerChatEvent.getMessage();
    Set<Player> actualRecipients = actualAsyncPlayerChatEvent.getRecipients();
    boolean actualIsCancelledResult = actualAsyncPlayerChatEvent.isCancelled();

    // Assert
    assertEquals("<%1$s> %2$s", actualFormat);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualRecipients.isEmpty());
    assertTrue(actualAsyncPlayerChatEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(players, actualRecipients);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualAsyncPlayerChatEvent.getPlayer());
  }

  /**
   * Test {@link AsyncPlayerChatEvent#setFormat(String)}.
   *
   * <p>Method under test: {@link AsyncPlayerChatEvent#setFormat(String)}
   */
  @Test
  @DisplayName("Test setFormat(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AsyncPlayerChatEvent.setFormat(String)"})
  void testSetFormat() throws NullPointerException, IllegalFormatException {
    // Arrange
    Player player = mock(Player.class);
    AsyncPlayerChatEvent asyncPlayerChatEvent =
        new AsyncPlayerChatEvent(true, player, "Not all who wander are lost", new HashSet<>());

    // Act
    asyncPlayerChatEvent.setFormat("Format");

    // Assert
    assertEquals("Format", asyncPlayerChatEvent.getFormat());
  }
}
