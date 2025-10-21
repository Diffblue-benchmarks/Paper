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

class BlockFormEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockFormEvent#BlockFormEvent(Block, BlockState)}
   *   <li>{@link BlockFormEvent#getHandlerList()}
   *   <li>{@link BlockFormEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockFormEvent.<init>(Block, BlockState)",
    "HandlerList BlockFormEvent.getHandlerList()",
    "HandlerList BlockFormEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    BlockState newState = mock(BlockState.class);

    // Act
    BlockFormEvent actualBlockFormEvent = new BlockFormEvent(block, newState);
    HandlerList actualHandlerList = actualBlockFormEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockFormEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockFormEvent.isAsynchronous());
    assertFalse(actualBlockFormEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockFormEvent.getBlock());
    assertSame(newState, actualBlockFormEvent.getNewState());
  }
}
