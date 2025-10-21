package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockPhysicsEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockPhysicsEvent#BlockPhysicsEvent(Block, BlockData)}
   *   <li>{@link BlockPhysicsEvent#setCancelled(boolean)}
   *   <li>{@link BlockPhysicsEvent#getHandlerList()}
   *   <li>{@link BlockPhysicsEvent#getHandlers()}
   *   <li>{@link BlockPhysicsEvent#getSourceBlock()}
   *   <li>{@link BlockPhysicsEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockPhysicsEvent.<init>(Block, BlockData)",
    "void BlockPhysicsEvent.<init>(Block, BlockData, Block)",
    "HandlerList BlockPhysicsEvent.getHandlerList()",
    "HandlerList BlockPhysicsEvent.getHandlers()",
    "Block BlockPhysicsEvent.getSourceBlock()",
    "boolean BlockPhysicsEvent.isCancelled()",
    "void BlockPhysicsEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockPhysicsEvent actualBlockPhysicsEvent = new BlockPhysicsEvent(block, mock(BlockData.class));
    actualBlockPhysicsEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockPhysicsEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockPhysicsEvent.getHandlers();
    Block actualSourceBlock = actualBlockPhysicsEvent.getSourceBlock();
    boolean actualIsCancelledResult = actualBlockPhysicsEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockPhysicsEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockPhysicsEvent.getBlock());
    assertSame(block, actualSourceBlock);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockPhysicsEvent#BlockPhysicsEvent(Block, BlockData, Block)}
   *   <li>{@link BlockPhysicsEvent#setCancelled(boolean)}
   *   <li>{@link BlockPhysicsEvent#getHandlerList()}
   *   <li>{@link BlockPhysicsEvent#getHandlers()}
   *   <li>{@link BlockPhysicsEvent#getSourceBlock()}
   *   <li>{@link BlockPhysicsEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockPhysicsEvent.<init>(Block, BlockData)",
    "void BlockPhysicsEvent.<init>(Block, BlockData, Block)",
    "HandlerList BlockPhysicsEvent.getHandlerList()",
    "HandlerList BlockPhysicsEvent.getHandlers()",
    "Block BlockPhysicsEvent.getSourceBlock()",
    "boolean BlockPhysicsEvent.isCancelled()",
    "void BlockPhysicsEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters2() {
    // Arrange
    Block block = mock(Block.class);
    Block sourceBlock = mock(Block.class);

    // Act
    BlockPhysicsEvent actualBlockPhysicsEvent =
        new BlockPhysicsEvent(block, mock(BlockData.class), sourceBlock);
    actualBlockPhysicsEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockPhysicsEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockPhysicsEvent.getHandlers();
    Block actualSourceBlock = actualBlockPhysicsEvent.getSourceBlock();
    boolean actualIsCancelledResult = actualBlockPhysicsEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockPhysicsEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockPhysicsEvent.getBlock());
    assertSame(sourceBlock, actualSourceBlock);
  }

  /**
   * Test {@link BlockPhysicsEvent#BlockPhysicsEvent(Block, BlockData, int, int, int)}.
   *
   * <p>Method under test: {@link BlockPhysicsEvent#BlockPhysicsEvent(Block, BlockData, int, int,
   * int)}
   */
  @Test
  @DisplayName("Test new BlockPhysicsEvent(Block, BlockData, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockPhysicsEvent.<init>(Block, BlockData, int, int, int)"})
  void testNewBlockPhysicsEvent() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(mock(Block.class));

    Block block = mock(Block.class);
    when(block.getWorld()).thenReturn(world);

    // Act
    BlockPhysicsEvent actualBlockPhysicsEvent =
        new BlockPhysicsEvent(block, mock(BlockData.class), 1, 1, 1);

    // Assert
    verify(world).getBlockAt(1, 1, 1);
    verify(block).getWorld();
    assertEquals("BlockPhysicsEvent", actualBlockPhysicsEvent.getEventName());
    assertNull(actualBlockPhysicsEvent.getChangedType());
    assertNull(actualBlockPhysicsEvent.getChangedBlockData());
    assertEquals(0, actualBlockPhysicsEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualBlockPhysicsEvent.isAsynchronous());
    assertFalse(actualBlockPhysicsEvent.isCancelled());
    assertSame(block, actualBlockPhysicsEvent.getBlock());
  }

  /**
   * Test {@link BlockPhysicsEvent#getChangedType()}.
   *
   * <p>Method under test: {@link BlockPhysicsEvent#getChangedType()}
   */
  @Test
  @DisplayName("Test getChangedType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material BlockPhysicsEvent.getChangedType()"})
  void testGetChangedType() {
    // Arrange
    BlockData changed = mock(BlockData.class);
    when(changed.getMaterial()).thenReturn(Material.ACACIA_BOAT);
    BlockPhysicsEvent blockPhysicsEvent = new BlockPhysicsEvent(mock(Block.class), changed);

    // Act
    Material actualChangedType = blockPhysicsEvent.getChangedType();

    // Assert
    verify(changed).getMaterial();
    assertEquals(Material.ACACIA_BOAT, actualChangedType);
  }

  /**
   * Test {@link BlockPhysicsEvent#getChangedBlockData()}.
   *
   * <p>Method under test: {@link BlockPhysicsEvent#getChangedBlockData()}
   */
  @Test
  @DisplayName("Test getChangedBlockData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockData BlockPhysicsEvent.getChangedBlockData()"})
  void testGetChangedBlockData() {
    // Arrange
    BlockPhysicsEvent blockPhysicsEvent =
        new BlockPhysicsEvent(mock(Block.class), mock(BlockData.class));

    // Act and Assert
    assertNull(blockPhysicsEvent.getChangedBlockData());
  }
}
