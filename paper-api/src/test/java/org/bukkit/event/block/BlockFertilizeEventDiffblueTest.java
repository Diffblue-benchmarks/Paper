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
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockFertilizeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockFertilizeEvent#BlockFertilizeEvent(Block, Player, List)}
   *   <li>{@link BlockFertilizeEvent#setCancelled(boolean)}
   *   <li>{@link BlockFertilizeEvent#getHandlerList()}
   *   <li>{@link BlockFertilizeEvent#getBlocks()}
   *   <li>{@link BlockFertilizeEvent#getHandlers()}
   *   <li>{@link BlockFertilizeEvent#getPlayer()}
   *   <li>{@link BlockFertilizeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockFertilizeEvent.<init>(Block, Player, List)",
    "List BlockFertilizeEvent.getBlocks()",
    "HandlerList BlockFertilizeEvent.getHandlerList()",
    "HandlerList BlockFertilizeEvent.getHandlers()",
    "Player BlockFertilizeEvent.getPlayer()",
    "boolean BlockFertilizeEvent.isCancelled()",
    "void BlockFertilizeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Player player = mock(Player.class);
    ArrayList<BlockState> blocks = new ArrayList<>();

    // Act
    BlockFertilizeEvent actualBlockFertilizeEvent = new BlockFertilizeEvent(block, player, blocks);
    actualBlockFertilizeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockFertilizeEvent.getHandlerList();
    List<BlockState> actualBlocks = actualBlockFertilizeEvent.getBlocks();
    HandlerList actualHandlers = actualBlockFertilizeEvent.getHandlers();
    Player actualPlayer = actualBlockFertilizeEvent.getPlayer();
    boolean actualIsCancelledResult = actualBlockFertilizeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockFertilizeEvent.isAsynchronous());
    assertTrue(actualBlocks.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(blocks, actualBlocks);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockFertilizeEvent.getBlock());
    assertSame(player, actualPlayer);
  }
}
