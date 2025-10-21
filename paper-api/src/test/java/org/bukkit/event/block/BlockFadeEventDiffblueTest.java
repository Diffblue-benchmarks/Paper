package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockFadeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockFadeEvent#BlockFadeEvent(Block, BlockState)}
   *   <li>{@link BlockFadeEvent#setCancelled(boolean)}
   *   <li>{@link BlockFadeEvent#getHandlerList()}
   *   <li>{@link BlockFadeEvent#getHandlers()}
   *   <li>{@link BlockFadeEvent#getNewState()}
   *   <li>{@link BlockFadeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockFadeEvent.<init>(Block, BlockState)",
    "HandlerList BlockFadeEvent.getHandlerList()",
    "HandlerList BlockFadeEvent.getHandlers()",
    "BlockState BlockFadeEvent.getNewState()",
    "boolean BlockFadeEvent.isCancelled()",
    "void BlockFadeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    BlockState newState = mock(BlockState.class);

    // Act
    BlockFadeEvent actualBlockFadeEvent = new BlockFadeEvent(block, newState);
    actualBlockFadeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockFadeEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockFadeEvent.getHandlers();
    BlockState actualNewState = actualBlockFadeEvent.getNewState();
    boolean actualIsCancelledResult = actualBlockFadeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockFadeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockFadeEvent.getBlock());
    assertSame(newState, actualNewState);
  }
}
