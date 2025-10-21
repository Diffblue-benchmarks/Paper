package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockBurnEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return IgnitingBlock is {@link Block}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockBurnEvent#BlockBurnEvent(Block, Block)}
   *   <li>{@link BlockBurnEvent#setCancelled(boolean)}
   *   <li>{@link BlockBurnEvent#getHandlerList()}
   *   <li>{@link BlockBurnEvent#getHandlers()}
   *   <li>{@link BlockBurnEvent#getIgnitingBlock()}
   *   <li>{@link BlockBurnEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return IgnitingBlock is Block")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockBurnEvent.<init>(Block)",
    "void BlockBurnEvent.<init>(Block, Block)",
    "HandlerList BlockBurnEvent.getHandlerList()",
    "HandlerList BlockBurnEvent.getHandlers()",
    "Block BlockBurnEvent.getIgnitingBlock()",
    "boolean BlockBurnEvent.isCancelled()",
    "void BlockBurnEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_thenReturnIgnitingBlockIsBlock() {
    // Arrange
    Block block = mock(Block.class);
    Block ignitingBlock = mock(Block.class);

    // Act
    BlockBurnEvent actualBlockBurnEvent = new BlockBurnEvent(block, ignitingBlock);
    actualBlockBurnEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockBurnEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockBurnEvent.getHandlers();
    Block actualIgnitingBlock = actualBlockBurnEvent.getIgnitingBlock();
    boolean actualIsCancelledResult = actualBlockBurnEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockBurnEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(ignitingBlock, actualIgnitingBlock);
    assertSame(block, actualBlockBurnEvent.getBlock());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return IgnitingBlock is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockBurnEvent#BlockBurnEvent(Block)}
   *   <li>{@link BlockBurnEvent#setCancelled(boolean)}
   *   <li>{@link BlockBurnEvent#getHandlerList()}
   *   <li>{@link BlockBurnEvent#getHandlers()}
   *   <li>{@link BlockBurnEvent#getIgnitingBlock()}
   *   <li>{@link BlockBurnEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return IgnitingBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockBurnEvent.<init>(Block)",
    "void BlockBurnEvent.<init>(Block, Block)",
    "HandlerList BlockBurnEvent.getHandlerList()",
    "HandlerList BlockBurnEvent.getHandlers()",
    "Block BlockBurnEvent.getIgnitingBlock()",
    "boolean BlockBurnEvent.isCancelled()",
    "void BlockBurnEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_thenReturnIgnitingBlockIsNull() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockBurnEvent actualBlockBurnEvent = new BlockBurnEvent(block);
    actualBlockBurnEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockBurnEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockBurnEvent.getHandlers();
    Block actualIgnitingBlock = actualBlockBurnEvent.getIgnitingBlock();
    boolean actualIsCancelledResult = actualBlockBurnEvent.isCancelled();

    // Assert
    assertNull(actualIgnitingBlock);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockBurnEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockBurnEvent.getBlock());
  }
}
