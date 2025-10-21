package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class PlayerBucketEventDiffblueTest {
  /**
   * Test {@link PlayerBucketEvent#getBlock()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} return {@link Block}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEvent#getBlock()}
   */
  @Test
  @DisplayName(
      "Test getBlock(); given Block getRelative(BlockFace) return Block; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Block PlayerBucketEvent.getBlock()"})
  void testGetBlock_givenBlockGetRelativeReturnBlock_thenReturnNull() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));

    // Act
    Block actualBlock = playerBucketEmptyEvent.getBlock();

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertNull(actualBlock);
  }

  /**
   * Test {@link PlayerBucketEvent#getBlockClicked()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} return {@link Block}.
   *   <li>Then calls {@link Block#getRelative(BlockFace)}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEvent#getBlockClicked()}
   */
  @Test
  @DisplayName(
      "Test getBlockClicked(); given Block getRelative(BlockFace) return Block; then calls getRelative(BlockFace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Block PlayerBucketEvent.getBlockClicked()"})
  void testGetBlockClicked_givenBlockGetRelativeReturnBlock_thenCallsGetRelative() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));

    // Act
    playerBucketEmptyEvent.getBlockClicked();

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
  }

  /**
   * Test {@link PlayerBucketEvent#getBlockFace()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} return {@link Block}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEvent#getBlockFace()}
   */
  @Test
  @DisplayName(
      "Test getBlockFace(); given Block getRelative(BlockFace) return Block; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PlayerBucketEvent.getBlockFace()"})
  void testGetBlockFace_givenBlockGetRelativeReturnBlock_thenReturnNorth() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));

    // Act
    BlockFace actualBlockFace = playerBucketEmptyEvent.getBlockFace();

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertEquals(BlockFace.NORTH, actualBlockFace);
  }

  /**
   * Test {@link PlayerBucketEvent#getBucket()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} return {@link Block}.
   *   <li>Then return {@code ACACIA_BOAT}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEvent#getBucket()}
   */
  @Test
  @DisplayName(
      "Test getBucket(); given Block getRelative(BlockFace) return Block; then return 'ACACIA_BOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material PlayerBucketEvent.getBucket()"})
  void testGetBucket_givenBlockGetRelativeReturnBlock_thenReturnAcaciaBoat() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));

    // Act
    Material actualBucket = playerBucketEmptyEvent.getBucket();

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertEquals(Material.ACACIA_BOAT, actualBucket);
  }

  /**
   * Test {@link PlayerBucketEvent#getHand()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} return {@link Block}.
   *   <li>Then return {@code HAND}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEvent#getHand()}
   */
  @Test
  @DisplayName(
      "Test getHand(); given Block getRelative(BlockFace) return Block; then return 'HAND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlot PlayerBucketEvent.getHand()"})
  void testGetHand_givenBlockGetRelativeReturnBlock_thenReturnHand() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));

    // Act
    EquipmentSlot actualHand = playerBucketEmptyEvent.getHand();

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertEquals(EquipmentSlot.HAND, actualHand);
  }

  /**
   * Test {@link PlayerBucketEvent#getItemStack()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} return {@link Block}.
   *   <li>Then calls {@link Block#getRelative(BlockFace)}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEvent#getItemStack()}
   */
  @Test
  @DisplayName(
      "Test getItemStack(); given Block getRelative(BlockFace) return Block; then calls getRelative(BlockFace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack PlayerBucketEvent.getItemStack()"})
  void testGetItemStack_givenBlockGetRelativeReturnBlock_thenCallsGetRelative() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));

    // Act
    playerBucketEmptyEvent.getItemStack();

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
  }

  /**
   * Test {@link PlayerBucketEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerBucketEvent.isCancelled()"})
  void testIsCancelled_thenReturnFalse() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));

    // Act
    boolean actualIsCancelledResult = playerBucketEmptyEvent.isCancelled();

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertFalse(actualIsCancelledResult);
  }

  /**
   * Test {@link PlayerBucketEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBucketEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerBucketEvent.isCancelled()"})
  void testIsCancelled_thenReturnTrue() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));
    playerBucketEmptyEvent.setCancelled(true);

    // Act
    boolean actualIsCancelledResult = playerBucketEmptyEvent.isCancelled();

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertTrue(actualIsCancelledResult);
  }

  /**
   * Test {@link PlayerBucketEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PlayerBucketEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerBucketEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    Block blockClicked = mock(Block.class);
    when(blockClicked.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    PlayerBucketEmptyEvent playerBucketEmptyEvent =
        new PlayerBucketEmptyEvent(
            mock(Player.class),
            blockClicked,
            BlockFace.NORTH,
            Material.ACACIA_BOAT,
            mock(ItemStack.class));

    // Act
    playerBucketEmptyEvent.setCancelled(true);

    // Assert
    verify(blockClicked).getRelative(BlockFace.NORTH);
    assertTrue(playerBucketEmptyEvent.isCancelled());
  }
}
