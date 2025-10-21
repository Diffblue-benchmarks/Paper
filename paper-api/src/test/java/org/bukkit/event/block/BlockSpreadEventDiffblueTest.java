package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockSpreadEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockSpreadEvent#BlockSpreadEvent(Block, Block, BlockState)}
   *   <li>{@link BlockSpreadEvent#getHandlerList()}
   *   <li>{@link BlockSpreadEvent#getHandlers()}
   *   <li>{@link BlockSpreadEvent#getSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockSpreadEvent.<init>(Block, Block, BlockState)",
    "HandlerList BlockSpreadEvent.getHandlerList()",
    "HandlerList BlockSpreadEvent.getHandlers()",
    "Block BlockSpreadEvent.getSource()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Block source = mock(Block.class);
    BlockState newState = mock(BlockState.class);

    // Act
    BlockSpreadEvent actualBlockSpreadEvent = new BlockSpreadEvent(block, source, newState);
    HandlerList actualHandlerList = actualBlockSpreadEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockSpreadEvent.getHandlers();
    Block actualSource = actualBlockSpreadEvent.getSource();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockSpreadEvent.isAsynchronous());
    assertFalse(actualBlockSpreadEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockSpreadEvent.getBlock());
    assertSame(source, actualSource);
    assertSame(newState, actualBlockSpreadEvent.getNewState());
  }
}
