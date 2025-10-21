package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AsyncChatDecorateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AsyncChatDecorateEvent#AsyncChatDecorateEvent(Player, Component)}
   *   <li>{@link AsyncChatDecorateEvent#result(Component)}
   *   <li>{@link AsyncChatDecorateEvent#setCancelled(boolean)}
   *   <li>{@link AsyncChatDecorateEvent#getHandlerList()}
   *   <li>{@link AsyncChatDecorateEvent#getHandlers()}
   *   <li>{@link AsyncChatDecorateEvent#isCancelled()}
   *   <li>{@link AsyncChatDecorateEvent#originalMessage()}
   *   <li>{@link AsyncChatDecorateEvent#player()}
   *   <li>{@link AsyncChatDecorateEvent#result()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncChatDecorateEvent.<init>(Player, Component)",
    "HandlerList AsyncChatDecorateEvent.getHandlerList()",
    "HandlerList AsyncChatDecorateEvent.getHandlers()",
    "boolean AsyncChatDecorateEvent.isCancelled()",
    "Component AsyncChatDecorateEvent.originalMessage()",
    "Player AsyncChatDecorateEvent.player()",
    "Component AsyncChatDecorateEvent.result()",
    "void AsyncChatDecorateEvent.result(Component)",
    "void AsyncChatDecorateEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Component originalMessage = mock(Component.class);

    // Act
    AsyncChatDecorateEvent actualAsyncChatDecorateEvent =
        new AsyncChatDecorateEvent(player, originalMessage);
    Component result = mock(Component.class);
    actualAsyncChatDecorateEvent.result(result);
    actualAsyncChatDecorateEvent.setCancelled(true);
    HandlerList actualHandlerList = actualAsyncChatDecorateEvent.getHandlerList();
    HandlerList actualHandlers = actualAsyncChatDecorateEvent.getHandlers();
    boolean actualIsCancelledResult = actualAsyncChatDecorateEvent.isCancelled();
    Component actualOriginalMessageResult = actualAsyncChatDecorateEvent.originalMessage();
    Player actualPlayerResult = actualAsyncChatDecorateEvent.player();
    Component actualResultResult = actualAsyncChatDecorateEvent.result();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualIsCancelledResult);
    assertTrue(actualAsyncChatDecorateEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(originalMessage, actualOriginalMessageResult);
    assertSame(result, actualResultResult);
    assertSame(player, actualPlayerResult);
  }
}
