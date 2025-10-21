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

class PlayerBucketEmptyEventDiffblueTest {
  /**
   * Test {@link PlayerBucketEmptyEvent#PlayerBucketEmptyEvent(Player, Block, Block, BlockFace,
   * Material, ItemStack)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerBucketEmptyEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEmptyEvent#PlayerBucketEmptyEvent(Player, Block,
   * Block, BlockFace, Material, ItemStack)}
   */
  @Test
  @DisplayName(
      "Test new PlayerBucketEmptyEvent(Player, Block, Block, BlockFace, Material, ItemStack); then return EventName is 'PlayerBucketEmptyEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerBucketEmptyEvent.<init>(Player, Block, Block, BlockFace, Material, ItemStack)"
  })
  void testNewPlayerBucketEmptyEvent_thenReturnEventNameIsPlayerBucketEmptyEvent() {
    // Arrange
    Player player = mock(Player.class);
    Block block = mock(Block.class);
    Block blockClicked = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);

    // Act
    PlayerBucketEmptyEvent actualPlayerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            player, block, blockClicked, BlockFace.NORTH, Material.ACACIA_BOAT, itemInHand);

    // Assert
    assertEquals("PlayerBucketEmptyEvent", actualPlayerBucketEmptyEvent.getEventName());
    assertEquals(0, actualPlayerBucketEmptyEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Material.ACACIA_BOAT, actualPlayerBucketEmptyEvent.getBucket());
    assertEquals(BlockFace.NORTH, actualPlayerBucketEmptyEvent.getBlockFace());
    assertEquals(EquipmentSlot.HAND, actualPlayerBucketEmptyEvent.getHand());
    assertFalse(actualPlayerBucketEmptyEvent.isAsynchronous());
    assertFalse(actualPlayerBucketEmptyEvent.isCancelled());
    assertSame(block, actualPlayerBucketEmptyEvent.getBlock());
    assertSame(blockClicked, actualPlayerBucketEmptyEvent.getBlockClicked());
    assertSame(player, actualPlayerBucketEmptyEvent.getPlayer());
    assertSame(itemInHand, actualPlayerBucketEmptyEvent.getItemStack());
  }

  /**
   * Test {@link PlayerBucketEmptyEvent#PlayerBucketEmptyEvent(Player, Block, Block, BlockFace,
   * Material, ItemStack, EquipmentSlot)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerBucketEmptyEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEmptyEvent#PlayerBucketEmptyEvent(Player, Block,
   * Block, BlockFace, Material, ItemStack, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new PlayerBucketEmptyEvent(Player, Block, Block, BlockFace, Material, ItemStack, EquipmentSlot); then return EventName is 'PlayerBucketEmptyEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerBucketEmptyEvent.<init>(Player, Block, Block, BlockFace, Material, ItemStack, EquipmentSlot)"
  })
  void testNewPlayerBucketEmptyEvent_thenReturnEventNameIsPlayerBucketEmptyEvent2() {
    // Arrange
    Player player = mock(Player.class);
    Block block = mock(Block.class);
    Block blockClicked = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);

    // Act
    PlayerBucketEmptyEvent actualPlayerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            player,
            block,
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            itemInHand,
            EquipmentSlot.HAND);

    // Assert
    assertEquals("PlayerBucketEmptyEvent", actualPlayerBucketEmptyEvent.getEventName());
    assertEquals(0, actualPlayerBucketEmptyEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Material.ACACIA_BOAT, actualPlayerBucketEmptyEvent.getBucket());
    assertEquals(BlockFace.NORTH, actualPlayerBucketEmptyEvent.getBlockFace());
    assertEquals(EquipmentSlot.HAND, actualPlayerBucketEmptyEvent.getHand());
    assertFalse(actualPlayerBucketEmptyEvent.isAsynchronous());
    assertFalse(actualPlayerBucketEmptyEvent.isCancelled());
    assertSame(block, actualPlayerBucketEmptyEvent.getBlock());
    assertSame(blockClicked, actualPlayerBucketEmptyEvent.getBlockClicked());
    assertSame(player, actualPlayerBucketEmptyEvent.getPlayer());
    assertSame(itemInHand, actualPlayerBucketEmptyEvent.getItemStack());
  }

  /**
   * Test {@link PlayerBucketEmptyEvent#PlayerBucketEmptyEvent(Player, Block, BlockFace, Material,
   * ItemStack)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerBucketEmptyEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEmptyEvent#PlayerBucketEmptyEvent(Player, Block,
   * BlockFace, Material, ItemStack)}
   */
  @Test
  @DisplayName(
      "Test new PlayerBucketEmptyEvent(Player, Block, BlockFace, Material, ItemStack); then return EventName is 'PlayerBucketEmptyEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerBucketEmptyEvent.<init>(Player, Block, BlockFace, Material, ItemStack)"
  })
  void testNewPlayerBucketEmptyEvent_thenReturnEventNameIsPlayerBucketEmptyEvent3() {
    // Arrange
    Player player = mock(Player.class);

    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    ItemStack itemInHand = mock(ItemStack.class);

    // Act
    PlayerBucketEmptyEvent actualPlayerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            player, blockClicked, BlockFace.NORTH, Material.ACACIA_BOAT, itemInHand);

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertEquals("PlayerBucketEmptyEvent", actualPlayerBucketEmptyEvent.getEventName());
    assertNull(actualPlayerBucketEmptyEvent.getBlock());
    assertEquals(0, actualPlayerBucketEmptyEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Material.ACACIA_BOAT, actualPlayerBucketEmptyEvent.getBucket());
    assertEquals(BlockFace.NORTH, actualPlayerBucketEmptyEvent.getBlockFace());
    assertEquals(EquipmentSlot.HAND, actualPlayerBucketEmptyEvent.getHand());
    assertFalse(actualPlayerBucketEmptyEvent.isAsynchronous());
    assertFalse(actualPlayerBucketEmptyEvent.isCancelled());
    assertSame(player, actualPlayerBucketEmptyEvent.getPlayer());
    assertSame(itemInHand, actualPlayerBucketEmptyEvent.getItemStack());
  }
}
