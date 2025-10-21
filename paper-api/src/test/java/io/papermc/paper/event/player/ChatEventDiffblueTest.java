package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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

class ChatEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ChatEvent#ChatEvent(Player, Set, ChatRenderer, Component, Component,
   *       SignedMessage)}
   *   <li>{@link ChatEvent#getHandlerList()}
   *   <li>{@link ChatEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChatEvent.<init>(Player, Set, ChatRenderer, Component, Component, SignedMessage)",
    "HandlerList ChatEvent.getHandlerList()",
    "HandlerList ChatEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    ChatEvent actualChatEvent =
        new ChatEvent(
            player,
            new HashSet<>(),
            mock(ChatRenderer.class),
            mock(Component.class),
            mock(Component.class),
            mock(SignedMessage.class));
    HandlerList actualHandlerList = actualChatEvent.getHandlerList();
    HandlerList actualHandlers = actualChatEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualChatEvent.isCancelled());
    assertFalse(actualChatEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualChatEvent.getPlayer());
  }
}
