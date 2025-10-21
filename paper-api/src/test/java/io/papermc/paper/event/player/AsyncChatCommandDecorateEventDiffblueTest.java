package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

class AsyncChatCommandDecorateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AsyncChatCommandDecorateEvent#AsyncChatCommandDecorateEvent(Player, Component)}
   *   <li>{@link AsyncChatCommandDecorateEvent#getHandlerList()}
   *   <li>{@link AsyncChatCommandDecorateEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncChatCommandDecorateEvent.<init>(Player, Component)",
    "HandlerList AsyncChatCommandDecorateEvent.getHandlerList()",
    "HandlerList AsyncChatCommandDecorateEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AsyncChatCommandDecorateEvent actualAsyncChatCommandDecorateEvent =
        new AsyncChatCommandDecorateEvent(mock(Player.class), mock(Component.class));
    HandlerList actualHandlerList = actualAsyncChatCommandDecorateEvent.getHandlerList();
    HandlerList actualHandlers = actualAsyncChatCommandDecorateEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualAsyncChatCommandDecorateEvent.isCancelled());
    assertTrue(actualAsyncChatCommandDecorateEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
  }
}
