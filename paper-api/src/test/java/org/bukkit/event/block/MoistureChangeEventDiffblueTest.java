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

class MoistureChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MoistureChangeEvent#MoistureChangeEvent(Block, BlockState)}
   *   <li>{@link MoistureChangeEvent#setCancelled(boolean)}
   *   <li>{@link MoistureChangeEvent#getHandlerList()}
   *   <li>{@link MoistureChangeEvent#getHandlers()}
   *   <li>{@link MoistureChangeEvent#getNewState()}
   *   <li>{@link MoistureChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MoistureChangeEvent.<init>(Block, BlockState)",
    "HandlerList MoistureChangeEvent.getHandlerList()",
    "HandlerList MoistureChangeEvent.getHandlers()",
    "BlockState MoistureChangeEvent.getNewState()",
    "boolean MoistureChangeEvent.isCancelled()",
    "void MoistureChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    BlockState newState = mock(BlockState.class);

    // Act
    MoistureChangeEvent actualMoistureChangeEvent = new MoistureChangeEvent(block, newState);
    actualMoistureChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualMoistureChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualMoistureChangeEvent.getHandlers();
    BlockState actualNewState = actualMoistureChangeEvent.getNewState();
    boolean actualIsCancelledResult = actualMoistureChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualMoistureChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualMoistureChangeEvent.getBlock());
    assertSame(newState, actualNewState);
  }
}
