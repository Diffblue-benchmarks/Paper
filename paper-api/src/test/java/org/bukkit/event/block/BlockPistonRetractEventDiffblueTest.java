package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BlockPistonRetractEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockPistonRetractEvent#BlockPistonRetractEvent(Block, List, BlockFace)}
   *   <li>{@link BlockPistonRetractEvent#getHandlerList()}
   *   <li>{@link BlockPistonRetractEvent#getBlocks()}
   *   <li>{@link BlockPistonRetractEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockPistonRetractEvent.<init>(Block, List, BlockFace)",
    "List BlockPistonRetractEvent.getBlocks()",
    "HandlerList BlockPistonRetractEvent.getHandlerList()",
    "HandlerList BlockPistonRetractEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    ArrayList<Block> blocks = new ArrayList<>();

    // Act
    BlockPistonRetractEvent actualBlockPistonRetractEvent =
        new BlockPistonRetractEvent(block, blocks, BlockFace.NORTH);
    HandlerList actualHandlerList = actualBlockPistonRetractEvent.getHandlerList();
    List<Block> actualBlocks = actualBlockPistonRetractEvent.getBlocks();
    HandlerList actualHandlers = actualBlockPistonRetractEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualBlockPistonRetractEvent.getDirection());
    assertFalse(actualBlockPistonRetractEvent.isAsynchronous());
    assertFalse(actualBlockPistonRetractEvent.isCancelled());
    assertTrue(actualBlocks.isEmpty());
    assertSame(blocks, actualBlocks);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockPistonRetractEvent.getBlock());
  }

  /**
   * Test {@link BlockPistonRetractEvent#getRetractLocation()}.
   *
   * <p>Method under test: {@link BlockPistonRetractEvent#getRetractLocation()}
   */
  @Test
  @DisplayName("Test getRetractLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location BlockPistonRetractEvent.getRetractLocation()"})
  void testGetRetractLocation() {
    // Arrange
    Block block = mock(Block.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(block.getLocation()).thenReturn(location);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any(), anyInt())).thenReturn(block);
    BlockPistonRetractEvent blockPistonRetractEvent =
        new BlockPistonRetractEvent(block2, new ArrayList<>(), BlockFace.NORTH);

    // Act
    Location actualRetractLocation = blockPistonRetractEvent.getRetractLocation();

    // Assert
    verify(block).getLocation();
    verify(block2).getRelative(BlockFace.NORTH, 2);
    assertSame(location, actualRetractLocation);
  }
}
