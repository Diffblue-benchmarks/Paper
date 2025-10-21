package com.destroystokyo.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockDestroyEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockDestroyEvent#BlockDestroyEvent(Block, BlockData, BlockData, int, boolean)}
   *   <li>{@link BlockDestroyEvent#setCancelled(boolean)}
   *   <li>{@link BlockDestroyEvent#setPlayEffect(boolean)}
   *   <li>{@link BlockDestroyEvent#setWillDrop(boolean)}
   *   <li>{@link BlockDestroyEvent#getHandlerList()}
   *   <li>{@link BlockDestroyEvent#getEffectBlock()}
   *   <li>{@link BlockDestroyEvent#getHandlers()}
   *   <li>{@link BlockDestroyEvent#isCancelled()}
   *   <li>{@link BlockDestroyEvent#playEffect()}
   *   <li>{@link BlockDestroyEvent#willDrop()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockDestroyEvent.<init>(Block, BlockData, BlockData, int, boolean)",
    "BlockData BlockDestroyEvent.getEffectBlock()",
    "HandlerList BlockDestroyEvent.getHandlerList()",
    "HandlerList BlockDestroyEvent.getHandlers()",
    "boolean BlockDestroyEvent.isCancelled()",
    "boolean BlockDestroyEvent.playEffect()",
    "void BlockDestroyEvent.setCancelled(boolean)",
    "void BlockDestroyEvent.setPlayEffect(boolean)",
    "void BlockDestroyEvent.setWillDrop(boolean)",
    "boolean BlockDestroyEvent.willDrop()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    BlockData effectBlock = mock(BlockData.class);

    // Act
    BlockDestroyEvent actualBlockDestroyEvent =
        new BlockDestroyEvent(block, mock(BlockData.class), effectBlock, 1, true);
    actualBlockDestroyEvent.setCancelled(true);
    actualBlockDestroyEvent.setPlayEffect(true);
    actualBlockDestroyEvent.setWillDrop(true);
    HandlerList actualHandlerList = actualBlockDestroyEvent.getHandlerList();
    BlockData actualEffectBlock = actualBlockDestroyEvent.getEffectBlock();
    HandlerList actualHandlers = actualBlockDestroyEvent.getHandlers();
    boolean actualIsCancelledResult = actualBlockDestroyEvent.isCancelled();
    boolean actualPlayEffectResult = actualBlockDestroyEvent.playEffect();
    boolean actualWillDropResult = actualBlockDestroyEvent.willDrop();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualBlockDestroyEvent.getExpToDrop());
    assertFalse(actualBlockDestroyEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualPlayEffectResult);
    assertTrue(actualWillDropResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockDestroyEvent.getBlock());
    assertSame(effectBlock, actualEffectBlock);
  }

  /**
   * Test {@link BlockDestroyEvent#setEffectBlock(BlockData)}.
   *
   * <p>Method under test: {@link BlockDestroyEvent#setEffectBlock(BlockData)}
   */
  @Test
  @DisplayName("Test setEffectBlock(BlockData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockDestroyEvent.setEffectBlock(BlockData)"})
  void testSetEffectBlock() {
    // Arrange
    BlockDestroyEvent blockDestroyEvent =
        new BlockDestroyEvent(
            mock(Block.class), mock(BlockData.class), mock(BlockData.class), 1, true);

    // Act
    blockDestroyEvent.setEffectBlock(mock(BlockData.class));

    // Assert
    assertNull(blockDestroyEvent.getEffectBlock());
  }

  /**
   * Test {@link BlockDestroyEvent#getNewState()}.
   *
   * <p>Method under test: {@link BlockDestroyEvent#getNewState()}
   */
  @Test
  @DisplayName("Test getNewState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockData BlockDestroyEvent.getNewState()"})
  void testGetNewState() {
    // Arrange
    BlockDestroyEvent blockDestroyEvent =
        new BlockDestroyEvent(
            mock(Block.class), mock(BlockData.class), mock(BlockData.class), 1, true);

    // Act and Assert
    assertNull(blockDestroyEvent.getNewState());
  }
}
