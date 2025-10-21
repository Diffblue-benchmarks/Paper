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

class BlockGrowEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockGrowEvent#BlockGrowEvent(Block, BlockState)}
   *   <li>{@link BlockGrowEvent#setCancelled(boolean)}
   *   <li>{@link BlockGrowEvent#getHandlerList()}
   *   <li>{@link BlockGrowEvent#getHandlers()}
   *   <li>{@link BlockGrowEvent#getNewState()}
   *   <li>{@link BlockGrowEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockGrowEvent.<init>(Block, BlockState)",
    "HandlerList BlockGrowEvent.getHandlerList()",
    "HandlerList BlockGrowEvent.getHandlers()",
    "BlockState BlockGrowEvent.getNewState()",
    "boolean BlockGrowEvent.isCancelled()",
    "void BlockGrowEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    BlockState newState = mock(BlockState.class);

    // Act
    BlockGrowEvent actualBlockGrowEvent = new BlockGrowEvent(block, newState);
    actualBlockGrowEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockGrowEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockGrowEvent.getHandlers();
    BlockState actualNewState = actualBlockGrowEvent.getNewState();
    boolean actualIsCancelledResult = actualBlockGrowEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockGrowEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockGrowEvent.getBlock());
    assertSame(newState, actualNewState);
  }
}
