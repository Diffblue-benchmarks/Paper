package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.chat.ChatRenderer;
import java.util.HashSet;
import java.util.Set;
import net.kyori.adventure.chat.SignedMessage;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AsyncChatEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AsyncChatEvent#AsyncChatEvent(boolean, Player, Set, ChatRenderer, Component,
   *       Component, SignedMessage)}
   *   <li>{@link AsyncChatEvent#getHandlerList()}
   *   <li>{@link AsyncChatEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncChatEvent.<init>(boolean, Player, Set, ChatRenderer, Component, Component, SignedMessage)",
    "HandlerList AsyncChatEvent.getHandlerList()",
    "HandlerList AsyncChatEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    AsyncChatEvent actualAsyncChatEvent =
        new AsyncChatEvent(
            true,
            player,
            new HashSet<>(),
            mock(ChatRenderer.class),
            mock(Component.class),
            mock(Component.class),
            mock(SignedMessage.class));
    HandlerList actualHandlerList = actualAsyncChatEvent.getHandlerList();
    HandlerList actualHandlers = actualAsyncChatEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualAsyncChatEvent.isCancelled());
    assertTrue(actualAsyncChatEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualAsyncChatEvent.getPlayer());
  }
}
