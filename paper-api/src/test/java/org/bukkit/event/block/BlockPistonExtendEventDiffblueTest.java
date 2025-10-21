package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BlockPistonExtendEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockPistonExtendEvent#BlockPistonExtendEvent(Block, int, BlockFace)}
   *   <li>{@link BlockPistonExtendEvent#getHandlerList()}
   *   <li>{@link BlockPistonExtendEvent#getHandlers()}
   *   <li>{@link BlockPistonExtendEvent#getLength()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockPistonExtendEvent.<init>(Block, int, BlockFace)",
    "HandlerList BlockPistonExtendEvent.getHandlerList()",
    "HandlerList BlockPistonExtendEvent.getHandlers()",
    "int BlockPistonExtendEvent.getLength()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockPistonExtendEvent actualBlockPistonExtendEvent =
        new BlockPistonExtendEvent(block, 3, BlockFace.NORTH);
    HandlerList actualHandlerList = actualBlockPistonExtendEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockPistonExtendEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(3, actualBlockPistonExtendEvent.getLength());
    assertEquals(BlockFace.NORTH, actualBlockPistonExtendEvent.getDirection());
    assertFalse(actualBlockPistonExtendEvent.isAsynchronous());
    assertFalse(actualBlockPistonExtendEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockPistonExtendEvent.getBlock());
  }

  /**
   * Test {@link BlockPistonExtendEvent#BlockPistonExtendEvent(Block, List, BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Block}.
   *   <li>Then return Length is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonExtendEvent#BlockPistonExtendEvent(Block, List,
   * BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new BlockPistonExtendEvent(Block, List, BlockFace); given Block; then return Length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockPistonExtendEvent.<init>(Block, List, BlockFace)"})
  void testNewBlockPistonExtendEvent_givenBlock_thenReturnLengthIsOne() {
    // Arrange
    Block block = mock(Block.class);

    ArrayList<Block> blocks = new ArrayList<>();
    blocks.add(mock(Block.class));

    // Act
    BlockPistonExtendEvent actualBlockPistonExtendEvent =
        new BlockPistonExtendEvent(block, blocks, BlockFace.NORTH);

    // Assert
    assertEquals("BlockPistonExtendEvent", actualBlockPistonExtendEvent.getEventName());
    assertEquals(0, actualBlockPistonExtendEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1, actualBlockPistonExtendEvent.getLength());
    assertEquals(BlockFace.NORTH, actualBlockPistonExtendEvent.getDirection());
    assertFalse(actualBlockPistonExtendEvent.isAsynchronous());
    assertFalse(actualBlockPistonExtendEvent.isCancelled());
    assertFalse(actualBlockPistonExtendEvent.isSticky());
    assertSame(blocks, actualBlockPistonExtendEvent.getBlocks());
    assertSame(block, actualBlockPistonExtendEvent.getBlock());
  }

  /**
   * Test {@link BlockPistonExtendEvent#BlockPistonExtendEvent(Block, List, BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Block}.
   *   <li>Then return Length is two.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonExtendEvent#BlockPistonExtendEvent(Block, List,
   * BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new BlockPistonExtendEvent(Block, List, BlockFace); given Block; then return Length is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockPistonExtendEvent.<init>(Block, List, BlockFace)"})
  void testNewBlockPistonExtendEvent_givenBlock_thenReturnLengthIsTwo() {
    // Arrange
    Block block = mock(Block.class);

    ArrayList<Block> blocks = new ArrayList<>();
    blocks.add(mock(Block.class));
    blocks.add(mock(Block.class));

    // Act
    BlockPistonExtendEvent actualBlockPistonExtendEvent =
        new BlockPistonExtendEvent(block, blocks, BlockFace.NORTH);

    // Assert
    assertEquals("BlockPistonExtendEvent", actualBlockPistonExtendEvent.getEventName());
    assertEquals(0, actualBlockPistonExtendEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(2, actualBlockPistonExtendEvent.getLength());
    assertEquals(BlockFace.NORTH, actualBlockPistonExtendEvent.getDirection());
    assertFalse(actualBlockPistonExtendEvent.isAsynchronous());
    assertFalse(actualBlockPistonExtendEvent.isCancelled());
    assertFalse(actualBlockPistonExtendEvent.isSticky());
    assertSame(blocks, actualBlockPistonExtendEvent.getBlocks());
    assertSame(block, actualBlockPistonExtendEvent.getBlock());
  }

  /**
   * Test {@link BlockPistonExtendEvent#BlockPistonExtendEvent(Block, List, BlockFace)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Length is zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonExtendEvent#BlockPistonExtendEvent(Block, List,
   * BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new BlockPistonExtendEvent(Block, List, BlockFace); when ArrayList(); then return Length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockPistonExtendEvent.<init>(Block, List, BlockFace)"})
  void testNewBlockPistonExtendEvent_whenArrayList_thenReturnLengthIsZero() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockPistonExtendEvent actualBlockPistonExtendEvent =
        new BlockPistonExtendEvent(block, new ArrayList<>(), BlockFace.NORTH);

    // Assert
    assertEquals("BlockPistonExtendEvent", actualBlockPistonExtendEvent.getEventName());
    assertEquals(0, actualBlockPistonExtendEvent.getLength());
    assertEquals(0, actualBlockPistonExtendEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualBlockPistonExtendEvent.getDirection());
    assertFalse(actualBlockPistonExtendEvent.isAsynchronous());
    assertFalse(actualBlockPistonExtendEvent.isCancelled());
    assertFalse(actualBlockPistonExtendEvent.isSticky());
    assertTrue(actualBlockPistonExtendEvent.getBlocks().isEmpty());
    assertSame(block, actualBlockPistonExtendEvent.getBlock());
  }

  /**
   * Test {@link BlockPistonExtendEvent#getBlocks()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace, int)} return {@link Block}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonExtendEvent#getBlocks()}
   */
  @Test
  @DisplayName(
      "Test getBlocks(); given Block getRelative(BlockFace, int) return Block; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BlockPistonExtendEvent.getBlocks()"})
  void testGetBlocks_givenBlockGetRelativeReturnBlock_thenReturnSizeIsThree() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any(), anyInt())).thenReturn(mock(Block.class));

    // Act
    List<Block> actualBlocks = new BlockPistonExtendEvent(block, 3, BlockFace.NORTH).getBlocks();

    // Assert
    verify(block, atLeast(1)).getRelative(eq(BlockFace.NORTH), anyInt());
    assertEquals(3, actualBlocks.size());
    Block getResult = actualBlocks.get(0);
    assertSame(getResult, actualBlocks.get(1));
    assertSame(getResult, actualBlocks.get(2));
  }

  /**
   * Test {@link BlockPistonExtendEvent#getBlocks()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonExtendEvent#getBlocks()}
   */
  @Test
  @DisplayName("Test getBlocks(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BlockPistonExtendEvent.getBlocks()"})
  void testGetBlocks_thenReturnEmpty() {
    // Arrange
    Block block = mock(Block.class);
    BlockPistonExtendEvent blockPistonExtendEvent =
        new BlockPistonExtendEvent(block, new ArrayList<>(), BlockFace.NORTH);

    // Act and Assert
    assertTrue(blockPistonExtendEvent.getBlocks().isEmpty());
  }
}
