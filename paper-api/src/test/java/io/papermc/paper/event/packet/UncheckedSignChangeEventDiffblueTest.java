package io.papermc.paper.event.packet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.math.BlockPosition;
import io.papermc.paper.math.Position;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UncheckedSignChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UncheckedSignChangeEvent#UncheckedSignChangeEvent(Player, BlockPosition, Side,
   *       List)}
   *   <li>{@link UncheckedSignChangeEvent#setCancelled(boolean)}
   *   <li>{@link UncheckedSignChangeEvent#getHandlerList()}
   *   <li>{@link UncheckedSignChangeEvent#getEditedBlockPosition()}
   *   <li>{@link UncheckedSignChangeEvent#getHandlers()}
   *   <li>{@link UncheckedSignChangeEvent#getSide()}
   *   <li>{@link UncheckedSignChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UncheckedSignChangeEvent.<init>(Player, BlockPosition, Side, List)",
    "BlockPosition UncheckedSignChangeEvent.getEditedBlockPosition()",
    "HandlerList UncheckedSignChangeEvent.getHandlerList()",
    "HandlerList UncheckedSignChangeEvent.getHandlers()",
    "Side UncheckedSignChangeEvent.getSide()",
    "boolean UncheckedSignChangeEvent.isCancelled()",
    "void UncheckedSignChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player editor = mock(Player.class);
    BlockPosition editedBlockPosition = Position.BLOCK_ZERO;

    // Act
    UncheckedSignChangeEvent actualUncheckedSignChangeEvent =
        new UncheckedSignChangeEvent(editor, editedBlockPosition, Side.FRONT, new ArrayList<>());
    actualUncheckedSignChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualUncheckedSignChangeEvent.getHandlerList();
    BlockPosition actualEditedBlockPosition =
        actualUncheckedSignChangeEvent.getEditedBlockPosition();
    HandlerList actualHandlers = actualUncheckedSignChangeEvent.getHandlers();
    Side actualSide = actualUncheckedSignChangeEvent.getSide();
    boolean actualIsCancelledResult = actualUncheckedSignChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Side.FRONT, actualSide);
    assertFalse(actualUncheckedSignChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(editedBlockPosition, actualEditedBlockPosition);
    assertSame(editor, actualUncheckedSignChangeEvent.getPlayer());
  }

  /**
   * Test {@link UncheckedSignChangeEvent#lines()}.
   *
   * <p>Method under test: {@link UncheckedSignChangeEvent#lines()}
   */
  @Test
  @DisplayName("Test lines()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UncheckedSignChangeEvent.lines()"})
  void testLines() {
    // Arrange
    Player editor = mock(Player.class);
    UncheckedSignChangeEvent uncheckedSignChangeEvent =
        new UncheckedSignChangeEvent(editor, Position.BLOCK_ZERO, Side.FRONT, new ArrayList<>());

    // Act and Assert
    assertTrue(uncheckedSignChangeEvent.lines().isEmpty());
  }
}
