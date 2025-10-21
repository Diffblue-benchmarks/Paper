package io.papermc.paper.event.packet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClientTickEndEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClientTickEndEvent#ClientTickEndEvent(Player)}
   *   <li>{@link ClientTickEndEvent#getHandlerList()}
   *   <li>{@link ClientTickEndEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientTickEndEvent.<init>(Player)",
    "HandlerList ClientTickEndEvent.getHandlerList()",
    "HandlerList ClientTickEndEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    ClientTickEndEvent actualClientTickEndEvent = new ClientTickEndEvent(player);
    HandlerList actualHandlerList = actualClientTickEndEvent.getHandlerList();
    HandlerList actualHandlers = actualClientTickEndEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualClientTickEndEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualClientTickEndEvent.getPlayer());
  }
}
