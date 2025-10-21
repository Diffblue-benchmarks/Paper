package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ExplosionResult;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockExplodeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockExplodeEvent#BlockExplodeEvent(Block, BlockState, List, float,
   *       ExplosionResult)}
   *   <li>{@link BlockExplodeEvent#setCancelled(boolean)}
   *   <li>{@link BlockExplodeEvent#setYield(float)}
   *   <li>{@link BlockExplodeEvent#getHandlerList()}
   *   <li>{@link BlockExplodeEvent#getExplodedBlockState()}
   *   <li>{@link BlockExplodeEvent#getExplosionResult()}
   *   <li>{@link BlockExplodeEvent#getHandlers()}
   *   <li>{@link BlockExplodeEvent#getYield()}
   *   <li>{@link BlockExplodeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockExplodeEvent.<init>(Block, BlockState, List, float, ExplosionResult)",
    "BlockState BlockExplodeEvent.getExplodedBlockState()",
    "ExplosionResult BlockExplodeEvent.getExplosionResult()",
    "HandlerList BlockExplodeEvent.getHandlerList()",
    "HandlerList BlockExplodeEvent.getHandlers()",
    "float BlockExplodeEvent.getYield()",
    "boolean BlockExplodeEvent.isCancelled()",
    "void BlockExplodeEvent.setCancelled(boolean)",
    "void BlockExplodeEvent.setYield(float)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    BlockState blockState = mock(BlockState.class);

    // Act
    BlockExplodeEvent actualBlockExplodeEvent =
        new BlockExplodeEvent(block, blockState, new ArrayList<>(), 10.0f, ExplosionResult.KEEP);
    actualBlockExplodeEvent.setCancelled(true);
    actualBlockExplodeEvent.setYield(10.0f);
    HandlerList actualHandlerList = actualBlockExplodeEvent.getHandlerList();
    BlockState actualExplodedBlockState = actualBlockExplodeEvent.getExplodedBlockState();
    ExplosionResult actualExplosionResult = actualBlockExplodeEvent.getExplosionResult();
    HandlerList actualHandlers = actualBlockExplodeEvent.getHandlers();
    float actualYield = actualBlockExplodeEvent.getYield();
    boolean actualIsCancelledResult = actualBlockExplodeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0f, actualYield);
    assertEquals(ExplosionResult.KEEP, actualExplosionResult);
    assertFalse(actualBlockExplodeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockExplodeEvent.getBlock());
    assertSame(blockState, actualExplodedBlockState);
  }

  /**
   * Test {@link BlockExplodeEvent#blockList()}.
   *
   * <p>Method under test: {@link BlockExplodeEvent#blockList()}
   */
  @Test
  @DisplayName("Test blockList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BlockExplodeEvent.blockList()"})
  void testBlockList() {
    // Arrange
    Block block = mock(Block.class);
    BlockState blockState = mock(BlockState.class);

    BlockExplodeEvent blockExplodeEvent =
        new BlockExplodeEvent(block, blockState, new ArrayList<>(), 10.0f, ExplosionResult.KEEP);

    // Act and Assert
    assertTrue(blockExplodeEvent.blockList().isEmpty());
  }
}
