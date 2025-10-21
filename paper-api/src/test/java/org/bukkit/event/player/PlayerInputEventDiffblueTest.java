package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Input;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerInputEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerInputEvent#PlayerInputEvent(Player, Input)}
   *   <li>{@link PlayerInputEvent#getHandlerList()}
   *   <li>{@link PlayerInputEvent#getHandlers()}
   *   <li>{@link PlayerInputEvent#getInput()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInputEvent.<init>(Player, Input)",
    "HandlerList PlayerInputEvent.getHandlerList()",
    "HandlerList PlayerInputEvent.getHandlers()",
    "Input PlayerInputEvent.getInput()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Input input = mock(Input.class);

    // Act
    PlayerInputEvent actualPlayerInputEvent = new PlayerInputEvent(player, input);
    HandlerList actualHandlerList = actualPlayerInputEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerInputEvent.getHandlers();
    Input actualInput = actualPlayerInputEvent.getInput();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerInputEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(input, actualInput);
    assertSame(player, actualPlayerInputEvent.getPlayer());
  }
}
