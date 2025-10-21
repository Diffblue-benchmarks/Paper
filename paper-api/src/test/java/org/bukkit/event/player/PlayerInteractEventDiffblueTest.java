package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerInteractEventDiffblueTest {
  /**
   * Test {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack, Block,
   * BlockFace)}.
   *
   * <ul>
   *   <li>When {@link Block}.
   *   <li>Then return hasBlock.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack,
   * Block, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new PlayerInteractEvent(Player, Action, ItemStack, Block, BlockFace); when Block; then return hasBlock")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInteractEvent.<init>(Player, Action, ItemStack, Block, BlockFace)"
  })
  void testNewPlayerInteractEvent_whenBlock_thenReturnHasBlock() {
    // Arrange
    Player player = mock(Player.class);
    Block clickedBlock = mock(Block.class);

    // Act
    PlayerInteractEvent actualPlayerInteractEvent =
        new PlayerInteractEvent(
            player, Action.LEFT_CLICK_BLOCK, null, clickedBlock, BlockFace.NORTH);

    // Assert
    assertEquals("PlayerInteractEvent", actualPlayerInteractEvent.getEventName());
    assertNull(actualPlayerInteractEvent.getInteractionPoint());
    assertNull(actualPlayerInteractEvent.getItem());
    assertNull(actualPlayerInteractEvent.getClickedPosition());
    assertEquals(Material.AIR, actualPlayerInteractEvent.getMaterial());
    assertEquals(BlockFace.NORTH, actualPlayerInteractEvent.getBlockFace());
    assertEquals(Result.DEFAULT, actualPlayerInteractEvent.useItemInHand());
    assertEquals(Action.LEFT_CLICK_BLOCK, actualPlayerInteractEvent.getAction());
    assertEquals(EquipmentSlot.HAND, actualPlayerInteractEvent.getHand());
    assertFalse(actualPlayerInteractEvent.isAsynchronous());
    assertFalse(actualPlayerInteractEvent.hasItem());
    assertFalse(actualPlayerInteractEvent.isBlockInHand());
    assertTrue(actualPlayerInteractEvent.hasBlock());
    assertSame(clickedBlock, actualPlayerInteractEvent.getClickedBlock());
    assertSame(player, actualPlayerInteractEvent.getPlayer());
  }

  /**
   * Test {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack, Block,
   * BlockFace, EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@link Block}.
   *   <li>Then return hasBlock.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack,
   * Block, BlockFace, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new PlayerInteractEvent(Player, Action, ItemStack, Block, BlockFace, EquipmentSlot); when Block; then return hasBlock")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInteractEvent.<init>(Player, Action, ItemStack, Block, BlockFace, EquipmentSlot)"
  })
  void testNewPlayerInteractEvent_whenBlock_thenReturnHasBlock2() {
    // Arrange
    Player player = mock(Player.class);
    Block clickedBlock = mock(Block.class);

    // Act
    PlayerInteractEvent actualPlayerInteractEvent =
        new PlayerInteractEvent(
            player,
            Action.LEFT_CLICK_BLOCK,
            null,
            clickedBlock,
            BlockFace.NORTH,
            EquipmentSlot.HAND);

    // Assert
    assertEquals("PlayerInteractEvent", actualPlayerInteractEvent.getEventName());
    assertNull(actualPlayerInteractEvent.getInteractionPoint());
    assertNull(actualPlayerInteractEvent.getItem());
    assertNull(actualPlayerInteractEvent.getClickedPosition());
    assertEquals(Material.AIR, actualPlayerInteractEvent.getMaterial());
    assertEquals(BlockFace.NORTH, actualPlayerInteractEvent.getBlockFace());
    assertEquals(Result.DEFAULT, actualPlayerInteractEvent.useItemInHand());
    assertEquals(Action.LEFT_CLICK_BLOCK, actualPlayerInteractEvent.getAction());
    assertEquals(EquipmentSlot.HAND, actualPlayerInteractEvent.getHand());
    assertFalse(actualPlayerInteractEvent.isAsynchronous());
    assertFalse(actualPlayerInteractEvent.hasItem());
    assertFalse(actualPlayerInteractEvent.isBlockInHand());
    assertTrue(actualPlayerInteractEvent.hasBlock());
    assertSame(clickedBlock, actualPlayerInteractEvent.getClickedBlock());
    assertSame(player, actualPlayerInteractEvent.getPlayer());
  }

  /**
   * Test {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack, Block,
   * BlockFace, EquipmentSlot, Vector)}.
   *
   * <ul>
   *   <li>When {@link Block}.
   *   <li>Then return hasBlock.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack,
   * Block, BlockFace, EquipmentSlot, Vector)}
   */
  @Test
  @DisplayName(
      "Test new PlayerInteractEvent(Player, Action, ItemStack, Block, BlockFace, EquipmentSlot, Vector); when Block; then return hasBlock")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInteractEvent.<init>(Player, Action, ItemStack, Block, BlockFace, EquipmentSlot, Vector)"
  })
  void testNewPlayerInteractEvent_whenBlock_thenReturnHasBlock3() {
    // Arrange
    Block clickedBlock = mock(Block.class);

    // Act
    PlayerInteractEvent actualPlayerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class),
            Action.LEFT_CLICK_BLOCK,
            null,
            clickedBlock,
            BlockFace.NORTH,
            EquipmentSlot.HAND,
            Vector.getRandom());

    // Assert
    assertTrue(actualPlayerInteractEvent.hasBlock());
    Vector clickedPosition = actualPlayerInteractEvent.getClickedPosition();
    BlockVector toBlockVectorResult = clickedPosition.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector3i toVector3iResult = clickedPosition.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d toVector3dResult = clickedPosition.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = clickedPosition.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
    assertSame(clickedBlock, actualPlayerInteractEvent.getClickedBlock());
  }

  /**
   * Test {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack, Block,
   * BlockFace)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ClickedBlock is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack,
   * Block, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new PlayerInteractEvent(Player, Action, ItemStack, Block, BlockFace); when 'null'; then return ClickedBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInteractEvent.<init>(Player, Action, ItemStack, Block, BlockFace)"
  })
  void testNewPlayerInteractEvent_whenNull_thenReturnClickedBlockIsNull() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerInteractEvent actualPlayerInteractEvent =
        new PlayerInteractEvent(player, Action.LEFT_CLICK_BLOCK, null, null, BlockFace.NORTH);

    // Assert
    assertEquals("PlayerInteractEvent", actualPlayerInteractEvent.getEventName());
    assertNull(actualPlayerInteractEvent.getInteractionPoint());
    assertNull(actualPlayerInteractEvent.getClickedBlock());
    assertNull(actualPlayerInteractEvent.getItem());
    assertNull(actualPlayerInteractEvent.getClickedPosition());
    assertEquals(Material.AIR, actualPlayerInteractEvent.getMaterial());
    assertEquals(BlockFace.NORTH, actualPlayerInteractEvent.getBlockFace());
    assertEquals(Result.DEFAULT, actualPlayerInteractEvent.useItemInHand());
    assertEquals(Action.LEFT_CLICK_BLOCK, actualPlayerInteractEvent.getAction());
    assertEquals(EquipmentSlot.HAND, actualPlayerInteractEvent.getHand());
    assertFalse(actualPlayerInteractEvent.isAsynchronous());
    assertFalse(actualPlayerInteractEvent.hasBlock());
    assertFalse(actualPlayerInteractEvent.hasItem());
    assertFalse(actualPlayerInteractEvent.isBlockInHand());
    assertSame(player, actualPlayerInteractEvent.getPlayer());
  }

  /**
   * Test {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack, Block,
   * BlockFace, EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ClickedBlock is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack,
   * Block, BlockFace, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new PlayerInteractEvent(Player, Action, ItemStack, Block, BlockFace, EquipmentSlot); when 'null'; then return ClickedBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInteractEvent.<init>(Player, Action, ItemStack, Block, BlockFace, EquipmentSlot)"
  })
  void testNewPlayerInteractEvent_whenNull_thenReturnClickedBlockIsNull2() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerInteractEvent actualPlayerInteractEvent =
        new PlayerInteractEvent(
            player, Action.LEFT_CLICK_BLOCK, null, null, BlockFace.NORTH, EquipmentSlot.HAND);

    // Assert
    assertEquals("PlayerInteractEvent", actualPlayerInteractEvent.getEventName());
    assertNull(actualPlayerInteractEvent.getInteractionPoint());
    assertNull(actualPlayerInteractEvent.getClickedBlock());
    assertNull(actualPlayerInteractEvent.getItem());
    assertNull(actualPlayerInteractEvent.getClickedPosition());
    assertEquals(Material.AIR, actualPlayerInteractEvent.getMaterial());
    assertEquals(BlockFace.NORTH, actualPlayerInteractEvent.getBlockFace());
    assertEquals(Result.DEFAULT, actualPlayerInteractEvent.useItemInHand());
    assertEquals(Action.LEFT_CLICK_BLOCK, actualPlayerInteractEvent.getAction());
    assertEquals(EquipmentSlot.HAND, actualPlayerInteractEvent.getHand());
    assertFalse(actualPlayerInteractEvent.isAsynchronous());
    assertFalse(actualPlayerInteractEvent.hasBlock());
    assertFalse(actualPlayerInteractEvent.hasItem());
    assertFalse(actualPlayerInteractEvent.isBlockInHand());
    assertSame(player, actualPlayerInteractEvent.getPlayer());
  }

  /**
   * Test {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack, Block,
   * BlockFace, EquipmentSlot, Vector)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return InteractionPoint is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#PlayerInteractEvent(Player, Action, ItemStack,
   * Block, BlockFace, EquipmentSlot, Vector)}
   */
  @Test
  @DisplayName(
      "Test new PlayerInteractEvent(Player, Action, ItemStack, Block, BlockFace, EquipmentSlot, Vector); when 'null'; then return InteractionPoint is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInteractEvent.<init>(Player, Action, ItemStack, Block, BlockFace, EquipmentSlot, Vector)"
  })
  void testNewPlayerInteractEvent_whenNull_thenReturnInteractionPointIsNull() {
    // Arrange and Act
    PlayerInteractEvent actualPlayerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class),
            Action.LEFT_CLICK_BLOCK,
            null,
            null,
            BlockFace.NORTH,
            EquipmentSlot.HAND,
            Vector.getRandom());

    // Assert
    assertNull(actualPlayerInteractEvent.getInteractionPoint());
    assertNull(actualPlayerInteractEvent.getClickedBlock());
    assertFalse(actualPlayerInteractEvent.hasBlock());
    Vector clickedPosition = actualPlayerInteractEvent.getClickedPosition();
    BlockVector toBlockVectorResult = clickedPosition.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector3i toVector3iResult = clickedPosition.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d toVector3dResult = clickedPosition.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = clickedPosition.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link PlayerInteractEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerInteractEvent.isCancelled()"})
  void testIsCancelled_thenReturnFalse() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act and Assert
    assertFalse(playerInteractEvent.isCancelled());
  }

  /**
   * Test {@link PlayerInteractEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerInteractEvent.isCancelled()"})
  void testIsCancelled_thenReturnTrue() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);
    playerInteractEvent.setUseInteractedBlock(Result.DENY);

    // Act and Assert
    assertTrue(playerInteractEvent.isCancelled());
  }

  /**
   * Test {@link PlayerInteractEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PlayerInteractEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerInteractEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act
    playerInteractEvent.setCancelled(true);

    // Assert
    assertEquals(Result.DENY, playerInteractEvent.useItemInHand());
  }

  /**
   * Test {@link PlayerInteractEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PlayerInteractEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerInteractEvent.setCancelled(boolean)"})
  void testSetCancelled2() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act
    playerInteractEvent.setCancelled(false);

    // Assert that nothing has changed
    assertEquals(Result.DEFAULT, playerInteractEvent.useItemInHand());
  }

  /**
   * Test {@link PlayerInteractEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PlayerInteractEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerInteractEvent.setCancelled(boolean)"})
  void testSetCancelled3() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);
    playerInteractEvent.setUseInteractedBlock(Result.DENY);

    // Act
    playerInteractEvent.setCancelled(false);

    // Assert that nothing has changed
    assertEquals(Result.DEFAULT, playerInteractEvent.useItemInHand());
  }

  /**
   * Test {@link PlayerInteractEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PlayerInteractEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerInteractEvent.setCancelled(boolean)"})
  void testSetCancelled4() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);
    playerInteractEvent.setUseItemInHand(Result.DENY);

    // Act
    playerInteractEvent.setCancelled(false);

    // Assert
    assertEquals(Result.DEFAULT, playerInteractEvent.useItemInHand());
  }

  /**
   * Test {@link PlayerInteractEvent#getMaterial()}.
   *
   * <ul>
   *   <li>Then return {@code AIR}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#getMaterial()}
   */
  @Test
  @DisplayName("Test getMaterial(); then return 'AIR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material PlayerInteractEvent.getMaterial()"})
  void testGetMaterial_thenReturnAir() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act and Assert
    assertEquals(Material.AIR, playerInteractEvent.getMaterial());
  }

  /**
   * Test {@link PlayerInteractEvent#hasBlock()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#hasBlock()}
   */
  @Test
  @DisplayName("Test hasBlock(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerInteractEvent.hasBlock()"})
  void testHasBlock_thenReturnFalse() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, null, BlockFace.NORTH);

    // Act and Assert
    assertFalse(playerInteractEvent.hasBlock());
  }

  /**
   * Test {@link PlayerInteractEvent#hasBlock()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#hasBlock()}
   */
  @Test
  @DisplayName("Test hasBlock(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerInteractEvent.hasBlock()"})
  void testHasBlock_thenReturnTrue() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act and Assert
    assertTrue(playerInteractEvent.hasBlock());
  }

  /**
   * Test {@link PlayerInteractEvent#hasItem()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#hasItem()}
   */
  @Test
  @DisplayName("Test hasItem(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerInteractEvent.hasItem()"})
  void testHasItem_thenReturnFalse() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act and Assert
    assertFalse(playerInteractEvent.hasItem());
  }

  /**
   * Test {@link PlayerInteractEvent#isBlockInHand()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#isBlockInHand()}
   */
  @Test
  @DisplayName("Test isBlockInHand(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerInteractEvent.isBlockInHand()"})
  void testIsBlockInHand_thenReturnFalse() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act and Assert
    assertFalse(playerInteractEvent.isBlockInHand());
  }

  /**
   * Test {@link PlayerInteractEvent#getClickedPosition()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#getClickedPosition()}
   */
  @Test
  @DisplayName("Test getClickedPosition(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PlayerInteractEvent.getClickedPosition()"})
  void testGetClickedPosition_thenReturnNull() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act and Assert
    assertNull(playerInteractEvent.getClickedPosition());
  }

  /**
   * Test {@link PlayerInteractEvent#getInteractionPoint()}.
   *
   * <p>Method under test: {@link PlayerInteractEvent#getInteractionPoint()}
   */
  @Test
  @DisplayName("Test getInteractionPoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.Location PlayerInteractEvent.getInteractionPoint()"})
  void testGetInteractionPoint() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act and Assert
    assertNull(playerInteractEvent.getInteractionPoint());
  }

  /**
   * Test {@link PlayerInteractEvent#getInteractionPoint()}.
   *
   * <p>Method under test: {@link PlayerInteractEvent#getInteractionPoint()}
   */
  @Test
  @DisplayName("Test getInteractionPoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.Location PlayerInteractEvent.getInteractionPoint()"})
  void testGetInteractionPoint2() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, null, BlockFace.NORTH);

    // Act and Assert
    assertNull(playerInteractEvent.getInteractionPoint());
  }

  /**
   * Test {@link PlayerInteractEvent#useInteractedBlock()}.
   *
   * <ul>
   *   <li>Then return {@code ALLOW}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractEvent#useInteractedBlock()}
   */
  @Test
  @DisplayName("Test useInteractedBlock(); then return 'ALLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PlayerInteractEvent.useInteractedBlock()"})
  void testUseInteractedBlock_thenReturnAllow() {
    // Arrange
    PlayerInteractEvent playerInteractEvent =
        new PlayerInteractEvent(
            mock(Player.class), Action.LEFT_CLICK_BLOCK, null, mock(Block.class), BlockFace.NORTH);

    // Act and Assert
    assertEquals(Result.ALLOW, playerInteractEvent.useInteractedBlock());
  }
}
