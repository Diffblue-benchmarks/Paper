package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerCommandSendEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerCommandSendEvent#PlayerCommandSendEvent(Player, Collection)}
   *   <li>{@link PlayerCommandSendEvent#getHandlerList()}
   *   <li>{@link PlayerCommandSendEvent#getCommands()}
   *   <li>{@link PlayerCommandSendEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerCommandSendEvent.<init>(Player, Collection)",
    "Collection PlayerCommandSendEvent.getCommands()",
    "HandlerList PlayerCommandSendEvent.getHandlerList()",
    "HandlerList PlayerCommandSendEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    ArrayList<String> commands = new ArrayList<>();

    // Act
    PlayerCommandSendEvent actualPlayerCommandSendEvent =
        new PlayerCommandSendEvent(player, commands);
    HandlerList actualHandlerList = actualPlayerCommandSendEvent.getHandlerList();
    Collection<String> actualCommands = actualPlayerCommandSendEvent.getCommands();
    HandlerList actualHandlers = actualPlayerCommandSendEvent.getHandlers();

    // Assert
    assertTrue(actualCommands instanceof List);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerCommandSendEvent.isAsynchronous());
    assertSame(commands, actualCommands);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerCommandSendEvent.getPlayer());
  }
}
