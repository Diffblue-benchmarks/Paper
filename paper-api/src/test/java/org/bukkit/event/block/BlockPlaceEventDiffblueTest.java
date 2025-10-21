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
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockPlaceEventDiffblueTest {
  /**
   * Test {@link BlockPlaceEvent#BlockPlaceEvent(Block, BlockState, Block, ItemStack, Player,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ItemStack}.
   *   <li>Then return EventName is {@code BlockPlaceEvent}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPlaceEvent#BlockPlaceEvent(Block, BlockState, Block,
   * ItemStack, Player, boolean)}
   */
  @Test
  @DisplayName(
      "Test new BlockPlaceEvent(Block, BlockState, Block, ItemStack, Player, boolean); when ItemStack; then return EventName is 'BlockPlaceEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockPlaceEvent.<init>(Block, BlockState, Block, ItemStack, Player, boolean)"
  })
  void testNewBlockPlaceEvent_whenItemStack_thenReturnEventNameIsBlockPlaceEvent() {
    // Arrange
    Block placedBlock = mock(Block.class);
    BlockState replacedBlockState = mock(BlockState.class);
    Block placedAgainst = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);
    Player thePlayer = mock(Player.class);

    // Act
    BlockPlaceEvent actualBlockPlaceEvent =
        new BlockPlaceEvent(
            placedBlock, replacedBlockState, placedAgainst, itemInHand, thePlayer, true);

    // Assert
    assertEquals("BlockPlaceEvent", actualBlockPlaceEvent.getEventName());
    assertEquals(EquipmentSlot.HAND, actualBlockPlaceEvent.getHand());
    assertFalse(actualBlockPlaceEvent.isAsynchronous());
    assertFalse(actualBlockPlaceEvent.isCancelled());
    assertTrue(actualBlockPlaceEvent.canBuild());
    assertTrue(actualBlockPlaceEvent.canBuild);
    assertSame(placedBlock, actualBlockPlaceEvent.getBlock());
    assertSame(placedAgainst, actualBlockPlaceEvent.getBlockAgainst());
    assertSame(placedBlock, actualBlockPlaceEvent.getBlockPlaced());
    assertSame(replacedBlockState, actualBlockPlaceEvent.getBlockReplacedState());
    assertSame(thePlayer, actualBlockPlaceEvent.getPlayer());
    assertSame(itemInHand, actualBlockPlaceEvent.getItemInHand());
  }
}
