package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.meta.BookMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerEditBookEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerEditBookEvent#PlayerEditBookEvent(Player, int, BookMeta, BookMeta, boolean)}
   *   <li>{@link PlayerEditBookEvent#setCancelled(boolean)}
   *   <li>{@link PlayerEditBookEvent#setSigning(boolean)}
   *   <li>{@link PlayerEditBookEvent#getHandlerList()}
   *   <li>{@link PlayerEditBookEvent#getHandlers()}
   *   <li>{@link PlayerEditBookEvent#getSlot()}
   *   <li>{@link PlayerEditBookEvent#isCancelled()}
   *   <li>{@link PlayerEditBookEvent#isSigning()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerEditBookEvent.<init>(Player, int, BookMeta, BookMeta, boolean)",
    "HandlerList PlayerEditBookEvent.getHandlerList()",
    "HandlerList PlayerEditBookEvent.getHandlers()",
    "int PlayerEditBookEvent.getSlot()",
    "boolean PlayerEditBookEvent.isCancelled()",
    "boolean PlayerEditBookEvent.isSigning()",
    "void PlayerEditBookEvent.setCancelled(boolean)",
    "void PlayerEditBookEvent.setSigning(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerEditBookEvent actualPlayerEditBookEvent =
        new PlayerEditBookEvent(player, 1, mock(BookMeta.class), mock(BookMeta.class), true);
    actualPlayerEditBookEvent.setCancelled(true);
    actualPlayerEditBookEvent.setSigning(true);
    HandlerList actualHandlerList = actualPlayerEditBookEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerEditBookEvent.getHandlers();
    int actualSlot = actualPlayerEditBookEvent.getSlot();
    boolean actualIsCancelledResult = actualPlayerEditBookEvent.isCancelled();
    boolean actualIsSigningResult = actualPlayerEditBookEvent.isSigning();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualSlot);
    assertFalse(actualPlayerEditBookEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsSigningResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerEditBookEvent.getPlayer());
  }

  /**
   * Test {@link PlayerEditBookEvent#getPreviousBookMeta()}.
   *
   * <p>Method under test: {@link PlayerEditBookEvent#getPreviousBookMeta()}
   */
  @Test
  @DisplayName("Test getPreviousBookMeta()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BookMeta PlayerEditBookEvent.getPreviousBookMeta()"})
  void testGetPreviousBookMeta() {
    // Arrange, Act and Assert
    assertNull(
        new PlayerEditBookEvent(
                mock(Player.class), 1, mock(BookMeta.class), mock(BookMeta.class), true)
            .getPreviousBookMeta());
  }

  /**
   * Test {@link PlayerEditBookEvent#getNewBookMeta()}.
   *
   * <p>Method under test: {@link PlayerEditBookEvent#getNewBookMeta()}
   */
  @Test
  @DisplayName("Test getNewBookMeta()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BookMeta PlayerEditBookEvent.getNewBookMeta()"})
  void testGetNewBookMeta() {
    // Arrange, Act and Assert
    assertNull(
        new PlayerEditBookEvent(
                mock(Player.class), 1, mock(BookMeta.class), mock(BookMeta.class), true)
            .getNewBookMeta());
  }
}
