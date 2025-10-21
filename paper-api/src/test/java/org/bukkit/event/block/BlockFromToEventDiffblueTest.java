package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BlockFromToEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockFromToEvent#BlockFromToEvent(Block, BlockFace)}
   *   <li>{@link BlockFromToEvent#setCancelled(boolean)}
   *   <li>{@link BlockFromToEvent#getHandlerList()}
   *   <li>{@link BlockFromToEvent#getFace()}
   *   <li>{@link BlockFromToEvent#getHandlers()}
   *   <li>{@link BlockFromToEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockFromToEvent.<init>(Block, BlockFace)",
    "BlockFace BlockFromToEvent.getFace()",
    "HandlerList BlockFromToEvent.getHandlerList()",
    "HandlerList BlockFromToEvent.getHandlers()",
    "boolean BlockFromToEvent.isCancelled()",
    "void BlockFromToEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockFromToEvent actualBlockFromToEvent = new BlockFromToEvent(block, BlockFace.NORTH);
    actualBlockFromToEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockFromToEvent.getHandlerList();
    BlockFace actualFace = actualBlockFromToEvent.getFace();
    HandlerList actualHandlers = actualBlockFromToEvent.getHandlers();
    boolean actualIsCancelledResult = actualBlockFromToEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualFace);
    assertFalse(actualBlockFromToEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockFromToEvent.getBlock());
  }

  /**
   * Test {@link BlockFromToEvent#BlockFromToEvent(Block, Block)}.
   *
   * <p>Method under test: {@link BlockFromToEvent#BlockFromToEvent(Block, Block)}
   */
  @Test
  @DisplayName("Test new BlockFromToEvent(Block, Block)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockFromToEvent.<init>(Block, Block)"})
  void testNewBlockFromToEvent() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockFromToEvent actualBlockFromToEvent = new BlockFromToEvent(block, mock(Block.class));

    // Assert
    assertEquals("BlockFromToEvent", actualBlockFromToEvent.getEventName());
    assertEquals(0, actualBlockFromToEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(BlockFace.SELF, actualBlockFromToEvent.getFace());
    assertFalse(actualBlockFromToEvent.isAsynchronous());
    assertFalse(actualBlockFromToEvent.isCancelled());
    Block expectedToBlock = actualBlockFromToEvent.to;
    assertSame(expectedToBlock, actualBlockFromToEvent.getToBlock());
    assertSame(block, actualBlockFromToEvent.getBlock());
  }

  /**
   * Test {@link BlockFromToEvent#getToBlock()}.
   *
   * <ul>
   *   <li>Then return {@link BlockFromToEvent#BlockFromToEvent(Block, Block)} with {@link Block}
   *       and toBlock is {@link Block} {@link BlockFromToEvent#to}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFromToEvent#getToBlock()}
   */
  @Test
  @DisplayName(
      "Test getToBlock(); then return BlockFromToEvent(Block, Block) with Block and toBlock is Block to")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Block BlockFromToEvent.getToBlock()"})
  void testGetToBlock_thenReturnBlockFromToEventWithBlockAndToBlockIsBlockTo() {
    // Arrange
    BlockFromToEvent blockFromToEvent = new BlockFromToEvent(mock(Block.class), mock(Block.class));

    // Act
    Block actualToBlock = blockFromToEvent.getToBlock();

    // Assert
    assertSame(blockFromToEvent.to, actualToBlock);
  }

  /**
   * Test {@link BlockFromToEvent#getToBlock()}.
   *
   * <ul>
   *   <li>Then return {@link BlockFromToEvent#BlockFromToEvent(Block, Block)} with {@link Block}
   *       and toBlock is {@code null} {@link BlockFromToEvent#to}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFromToEvent#getToBlock()}
   */
  @Test
  @DisplayName(
      "Test getToBlock(); then return BlockFromToEvent(Block, Block) with Block and toBlock is 'null' to")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Block BlockFromToEvent.getToBlock()"})
  void testGetToBlock_thenReturnBlockFromToEventWithBlockAndToBlockIsNullTo() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    BlockFromToEvent blockFromToEvent = new BlockFromToEvent(block, (Block) null);

    // Act
    Block actualToBlock = blockFromToEvent.getToBlock();

    // Assert
    verify(block).getRelative(BlockFace.SELF);
    assertSame(blockFromToEvent.to, actualToBlock);
  }
}
