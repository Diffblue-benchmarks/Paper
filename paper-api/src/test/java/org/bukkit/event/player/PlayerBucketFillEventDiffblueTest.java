package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerBucketFillEventDiffblueTest {
  /**
   * Test {@link PlayerBucketFillEvent#PlayerBucketFillEvent(Player, Block, Block, BlockFace,
   * Material, ItemStack)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerBucketFillEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketFillEvent#PlayerBucketFillEvent(Player, Block, Block,
   * BlockFace, Material, ItemStack)}
   */
  @Test
  @DisplayName(
      "Test new PlayerBucketFillEvent(Player, Block, Block, BlockFace, Material, ItemStack); then return EventName is 'PlayerBucketFillEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerBucketFillEvent.<init>(Player, Block, Block, BlockFace, Material, ItemStack)"
  })
  void testNewPlayerBucketFillEvent_thenReturnEventNameIsPlayerBucketFillEvent() {
    // Arrange
    Player player = mock(Player.class);
    Block block = mock(Block.class);
    Block blockClicked = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);

    // Act
    PlayerBucketFillEvent actualPlayerBucketFillEvent =
        new PlayerBucketFillEvent(
            player, block, blockClicked, BlockFace.NORTH, Material.ACACIA_BOAT, itemInHand);

    // Assert
    assertEquals("PlayerBucketFillEvent", actualPlayerBucketFillEvent.getEventName());
    assertEquals(0, actualPlayerBucketFillEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Material.ACACIA_BOAT, actualPlayerBucketFillEvent.getBucket());
    assertEquals(BlockFace.NORTH, actualPlayerBucketFillEvent.getBlockFace());
    assertEquals(EquipmentSlot.HAND, actualPlayerBucketFillEvent.getHand());
    assertFalse(actualPlayerBucketFillEvent.isAsynchronous());
    assertFalse(actualPlayerBucketFillEvent.isCancelled());
    assertSame(block, actualPlayerBucketFillEvent.getBlock());
    assertSame(blockClicked, actualPlayerBucketFillEvent.getBlockClicked());
    assertSame(player, actualPlayerBucketFillEvent.getPlayer());
    assertSame(itemInHand, actualPlayerBucketFillEvent.getItemStack());
  }

  /**
   * Test {@link PlayerBucketFillEvent#PlayerBucketFillEvent(Player, Block, Block, BlockFace,
   * Material, ItemStack, EquipmentSlot)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerBucketFillEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketFillEvent#PlayerBucketFillEvent(Player, Block, Block,
   * BlockFace, Material, ItemStack, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new PlayerBucketFillEvent(Player, Block, Block, BlockFace, Material, ItemStack, EquipmentSlot); then return EventName is 'PlayerBucketFillEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerBucketFillEvent.<init>(Player, Block, Block, BlockFace, Material, ItemStack, EquipmentSlot)"
  })
  void testNewPlayerBucketFillEvent_thenReturnEventNameIsPlayerBucketFillEvent2() {
    // Arrange
    Player player = mock(Player.class);
    Block block = mock(Block.class);
    Block blockClicked = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);

    // Act
    PlayerBucketFillEvent actualPlayerBucketFillEvent =
        new PlayerBucketFillEvent(
            player,
            block,
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            itemInHand,
            EquipmentSlot.HAND);

    // Assert
    assertEquals("PlayerBucketFillEvent", actualPlayerBucketFillEvent.getEventName());
    assertEquals(0, actualPlayerBucketFillEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Material.ACACIA_BOAT, actualPlayerBucketFillEvent.getBucket());
    assertEquals(BlockFace.NORTH, actualPlayerBucketFillEvent.getBlockFace());
    assertEquals(EquipmentSlot.HAND, actualPlayerBucketFillEvent.getHand());
    assertFalse(actualPlayerBucketFillEvent.isAsynchronous());
    assertFalse(actualPlayerBucketFillEvent.isCancelled());
    assertSame(block, actualPlayerBucketFillEvent.getBlock());
    assertSame(blockClicked, actualPlayerBucketFillEvent.getBlockClicked());
    assertSame(player, actualPlayerBucketFillEvent.getPlayer());
    assertSame(itemInHand, actualPlayerBucketFillEvent.getItemStack());
  }

  /**
   * Test {@link PlayerBucketFillEvent#PlayerBucketFillEvent(Player, Block, BlockFace, Material,
   * ItemStack)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerBucketFillEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketFillEvent#PlayerBucketFillEvent(Player, Block,
   * BlockFace, Material, ItemStack)}
   */
  @Test
  @DisplayName(
      "Test new PlayerBucketFillEvent(Player, Block, BlockFace, Material, ItemStack); then return EventName is 'PlayerBucketFillEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerBucketFillEvent.<init>(Player, Block, BlockFace, Material, ItemStack)"
  })
  void testNewPlayerBucketFillEvent_thenReturnEventNameIsPlayerBucketFillEvent3() {
    // Arrange
    Player player = mock(Player.class);

    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    ItemStack itemInHand = mock(ItemStack.class);

    // Act
    PlayerBucketFillEvent actualPlayerBucketFillEvent =
        new PlayerBucketFillEvent(
            player, blockClicked, BlockFace.NORTH, Material.ACACIA_BOAT, itemInHand);

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertEquals("PlayerBucketFillEvent", actualPlayerBucketFillEvent.getEventName());
    assertNull(actualPlayerBucketFillEvent.getBlock());
    assertEquals(0, actualPlayerBucketFillEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Material.ACACIA_BOAT, actualPlayerBucketFillEvent.getBucket());
    assertEquals(BlockFace.NORTH, actualPlayerBucketFillEvent.getBlockFace());
    assertEquals(EquipmentSlot.HAND, actualPlayerBucketFillEvent.getHand());
    assertFalse(actualPlayerBucketFillEvent.isAsynchronous());
    assertFalse(actualPlayerBucketFillEvent.isCancelled());
    assertSame(player, actualPlayerBucketFillEvent.getPlayer());
    assertSame(itemInHand, actualPlayerBucketFillEvent.getItemStack());
  }
}
