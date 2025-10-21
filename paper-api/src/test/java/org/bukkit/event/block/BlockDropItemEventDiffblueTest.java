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
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockDropItemEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockDropItemEvent#BlockDropItemEvent(Block, BlockState, Player, List)}
   *   <li>{@link BlockDropItemEvent#setCancelled(boolean)}
   *   <li>{@link BlockDropItemEvent#getHandlerList()}
   *   <li>{@link BlockDropItemEvent#getBlockState()}
   *   <li>{@link BlockDropItemEvent#getHandlers()}
   *   <li>{@link BlockDropItemEvent#getItems()}
   *   <li>{@link BlockDropItemEvent#getPlayer()}
   *   <li>{@link BlockDropItemEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockDropItemEvent.<init>(Block, BlockState, Player, List)",
    "BlockState BlockDropItemEvent.getBlockState()",
    "HandlerList BlockDropItemEvent.getHandlerList()",
    "HandlerList BlockDropItemEvent.getHandlers()",
    "List BlockDropItemEvent.getItems()",
    "Player BlockDropItemEvent.getPlayer()",
    "boolean BlockDropItemEvent.isCancelled()",
    "void BlockDropItemEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    BlockState blockState = mock(BlockState.class);
    Player player = mock(Player.class);
    ArrayList<Item> items = new ArrayList<>();

    // Act
    BlockDropItemEvent actualBlockDropItemEvent =
        new BlockDropItemEvent(block, blockState, player, items);
    actualBlockDropItemEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockDropItemEvent.getHandlerList();
    BlockState actualBlockState = actualBlockDropItemEvent.getBlockState();
    HandlerList actualHandlers = actualBlockDropItemEvent.getHandlers();
    List<Item> actualItems = actualBlockDropItemEvent.getItems();
    Player actualPlayer = actualBlockDropItemEvent.getPlayer();
    boolean actualIsCancelledResult = actualBlockDropItemEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockDropItemEvent.isAsynchronous());
    assertTrue(actualItems.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(items, actualItems);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockDropItemEvent.getBlock());
    assertSame(blockState, actualBlockState);
    assertSame(player, actualPlayer);
  }
}
