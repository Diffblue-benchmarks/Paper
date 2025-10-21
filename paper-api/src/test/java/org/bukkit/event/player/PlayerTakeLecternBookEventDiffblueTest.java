package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Lectern;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerTakeLecternBookEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerTakeLecternBookEvent#PlayerTakeLecternBookEvent(Player, Lectern)}
   *   <li>{@link PlayerTakeLecternBookEvent#setCancelled(boolean)}
   *   <li>{@link PlayerTakeLecternBookEvent#getHandlerList()}
   *   <li>{@link PlayerTakeLecternBookEvent#getHandlers()}
   *   <li>{@link PlayerTakeLecternBookEvent#getLectern()}
   *   <li>{@link PlayerTakeLecternBookEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerTakeLecternBookEvent.<init>(Player, Lectern)",
    "HandlerList PlayerTakeLecternBookEvent.getHandlerList()",
    "HandlerList PlayerTakeLecternBookEvent.getHandlers()",
    "Lectern PlayerTakeLecternBookEvent.getLectern()",
    "boolean PlayerTakeLecternBookEvent.isCancelled()",
    "void PlayerTakeLecternBookEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Lectern lectern = mock(Lectern.class);

    // Act
    PlayerTakeLecternBookEvent actualPlayerTakeLecternBookEvent =
        new PlayerTakeLecternBookEvent(player, lectern);
    actualPlayerTakeLecternBookEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerTakeLecternBookEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerTakeLecternBookEvent.getHandlers();
    Lectern actualLectern = actualPlayerTakeLecternBookEvent.getLectern();
    boolean actualIsCancelledResult = actualPlayerTakeLecternBookEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerTakeLecternBookEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(lectern, actualLectern);
    assertSame(player, actualPlayerTakeLecternBookEvent.getPlayer());
  }
}
