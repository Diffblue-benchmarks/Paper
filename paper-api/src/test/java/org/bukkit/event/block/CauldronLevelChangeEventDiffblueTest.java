package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.CauldronLevelChangeEvent.ChangeReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CauldronLevelChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CauldronLevelChangeEvent#CauldronLevelChangeEvent(Block, Entity, ChangeReason,
   *       BlockState)}
   *   <li>{@link CauldronLevelChangeEvent#setCancelled(boolean)}
   *   <li>{@link CauldronLevelChangeEvent#getHandlerList()}
   *   <li>{@link CauldronLevelChangeEvent#getEntity()}
   *   <li>{@link CauldronLevelChangeEvent#getHandlers()}
   *   <li>{@link CauldronLevelChangeEvent#getNewState()}
   *   <li>{@link CauldronLevelChangeEvent#getReason()}
   *   <li>{@link CauldronLevelChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CauldronLevelChangeEvent.<init>(Block, Entity, ChangeReason, BlockState)",
    "Entity CauldronLevelChangeEvent.getEntity()",
    "HandlerList CauldronLevelChangeEvent.getHandlerList()",
    "HandlerList CauldronLevelChangeEvent.getHandlers()",
    "BlockState CauldronLevelChangeEvent.getNewState()",
    "ChangeReason CauldronLevelChangeEvent.getReason()",
    "boolean CauldronLevelChangeEvent.isCancelled()",
    "void CauldronLevelChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Entity entity = mock(Entity.class);
    BlockState newBlock = mock(BlockState.class);

    // Act
    CauldronLevelChangeEvent actualCauldronLevelChangeEvent =
        new CauldronLevelChangeEvent(block, entity, ChangeReason.BUCKET_FILL, newBlock);
    actualCauldronLevelChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualCauldronLevelChangeEvent.getHandlerList();
    Entity actualEntity = actualCauldronLevelChangeEvent.getEntity();
    HandlerList actualHandlers = actualCauldronLevelChangeEvent.getHandlers();
    BlockState actualNewState = actualCauldronLevelChangeEvent.getNewState();
    ChangeReason actualReason = actualCauldronLevelChangeEvent.getReason();
    boolean actualIsCancelledResult = actualCauldronLevelChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(ChangeReason.BUCKET_FILL, actualReason);
    assertFalse(actualCauldronLevelChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualCauldronLevelChangeEvent.getBlock());
    assertSame(newBlock, actualNewState);
    assertSame(entity, actualEntity);
  }

  /**
   * Test {@link CauldronLevelChangeEvent#getOldLevel()}.
   *
   * <ul>
   *   <li>Given {@link BlockData} {@link BlockData#getMaterial()} return {@code ACACIA_BOAT}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link CauldronLevelChangeEvent#getOldLevel()}
   */
  @Test
  @DisplayName(
      "Test getOldLevel(); given BlockData getMaterial() return 'ACACIA_BOAT'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CauldronLevelChangeEvent.getOldLevel()"})
  void testGetOldLevel_givenBlockDataGetMaterialReturnAcaciaBoat_thenReturnThree() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.ACACIA_BOAT);

    Block block = mock(Block.class);
    when(block.getBlockData()).thenReturn(blockData);
    CauldronLevelChangeEvent cauldronLevelChangeEvent =
        new CauldronLevelChangeEvent(
            block, mock(Entity.class), ChangeReason.BUCKET_FILL, mock(BlockState.class));

    // Act
    int actualOldLevel = cauldronLevelChangeEvent.getOldLevel();

    // Assert
    verify(block).getBlockData();
    verify(blockData).getMaterial();
    assertEquals(3, actualOldLevel);
  }

  /**
   * Test {@link CauldronLevelChangeEvent#getOldLevel()}.
   *
   * <ul>
   *   <li>Given {@link BlockData} {@link BlockData#getMaterial()} return {@link Material#CAULDRON}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CauldronLevelChangeEvent#getOldLevel()}
   */
  @Test
  @DisplayName(
      "Test getOldLevel(); given BlockData getMaterial() return CAULDRON; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CauldronLevelChangeEvent.getOldLevel()"})
  void testGetOldLevel_givenBlockDataGetMaterialReturnCauldron_thenReturnZero() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.CAULDRON);

    Block block = mock(Block.class);
    when(block.getBlockData()).thenReturn(blockData);
    CauldronLevelChangeEvent cauldronLevelChangeEvent =
        new CauldronLevelChangeEvent(
            block, mock(Entity.class), ChangeReason.BUCKET_FILL, mock(BlockState.class));

    // Act
    int actualOldLevel = cauldronLevelChangeEvent.getOldLevel();

    // Assert
    verify(block).getBlockData();
    verify(blockData).getMaterial();
    assertEquals(0, actualOldLevel);
  }

  /**
   * Test {@link CauldronLevelChangeEvent#getOldLevel()}.
   *
   * <ul>
   *   <li>Given {@link Levelled} {@link Levelled#getLevel()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CauldronLevelChangeEvent#getOldLevel()}
   */
  @Test
  @DisplayName("Test getOldLevel(); given Levelled getLevel() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CauldronLevelChangeEvent.getOldLevel()"})
  void testGetOldLevel_givenLevelledGetLevelReturnOne_thenReturnOne() {
    // Arrange
    Levelled levelled = mock(Levelled.class);
    when(levelled.getLevel()).thenReturn(1);

    Block block = mock(Block.class);
    when(block.getBlockData()).thenReturn(levelled);
    CauldronLevelChangeEvent cauldronLevelChangeEvent =
        new CauldronLevelChangeEvent(
            block, mock(Entity.class), ChangeReason.BUCKET_FILL, mock(BlockState.class));

    // Act
    int actualOldLevel = cauldronLevelChangeEvent.getOldLevel();

    // Assert
    verify(block).getBlockData();
    verify(levelled).getLevel();
    assertEquals(1, actualOldLevel);
  }

  /**
   * Test {@link CauldronLevelChangeEvent#getNewLevel()}.
   *
   * <ul>
   *   <li>Given {@link BlockData} {@link BlockData#getMaterial()} return {@code ACACIA_BOAT}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link CauldronLevelChangeEvent#getNewLevel()}
   */
  @Test
  @DisplayName(
      "Test getNewLevel(); given BlockData getMaterial() return 'ACACIA_BOAT'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CauldronLevelChangeEvent.getNewLevel()"})
  void testGetNewLevel_givenBlockDataGetMaterialReturnAcaciaBoat_thenReturnThree() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.ACACIA_BOAT);

    BlockState newBlock = mock(BlockState.class);
    when(newBlock.getBlockData()).thenReturn(blockData);
    CauldronLevelChangeEvent cauldronLevelChangeEvent =
        new CauldronLevelChangeEvent(
            mock(Block.class), mock(Entity.class), ChangeReason.BUCKET_FILL, newBlock);

    // Act
    int actualNewLevel = cauldronLevelChangeEvent.getNewLevel();

    // Assert
    verify(newBlock).getBlockData();
    verify(blockData).getMaterial();
    assertEquals(3, actualNewLevel);
  }

  /**
   * Test {@link CauldronLevelChangeEvent#getNewLevel()}.
   *
   * <ul>
   *   <li>Given {@link BlockData} {@link BlockData#getMaterial()} return {@link Material#CAULDRON}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CauldronLevelChangeEvent#getNewLevel()}
   */
  @Test
  @DisplayName(
      "Test getNewLevel(); given BlockData getMaterial() return CAULDRON; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CauldronLevelChangeEvent.getNewLevel()"})
  void testGetNewLevel_givenBlockDataGetMaterialReturnCauldron_thenReturnZero() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.CAULDRON);

    BlockState newBlock = mock(BlockState.class);
    when(newBlock.getBlockData()).thenReturn(blockData);
    CauldronLevelChangeEvent cauldronLevelChangeEvent =
        new CauldronLevelChangeEvent(
            mock(Block.class), mock(Entity.class), ChangeReason.BUCKET_FILL, newBlock);

    // Act
    int actualNewLevel = cauldronLevelChangeEvent.getNewLevel();

    // Assert
    verify(newBlock).getBlockData();
    verify(blockData).getMaterial();
    assertEquals(0, actualNewLevel);
  }

  /**
   * Test {@link CauldronLevelChangeEvent#setNewLevel(int)}.
   *
   * <ul>
   *   <li>Given {@link BlockState} {@link BlockState#getBlockData()} return {@link BlockData}.
   *   <li>Then calls {@link BlockState#getBlockData()}.
   * </ul>
   *
   * <p>Method under test: {@link CauldronLevelChangeEvent#setNewLevel(int)}
   */
  @Test
  @DisplayName(
      "Test setNewLevel(int); given BlockState getBlockData() return BlockData; then calls getBlockData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CauldronLevelChangeEvent.setNewLevel(int)"})
  void testSetNewLevel_givenBlockStateGetBlockDataReturnBlockData_thenCallsGetBlockData() {
    // Arrange
    BlockState newBlock = mock(BlockState.class);
    when(newBlock.getBlockData()).thenReturn(mock(BlockData.class));
    CauldronLevelChangeEvent cauldronLevelChangeEvent =
        new CauldronLevelChangeEvent(
            mock(Block.class), mock(Entity.class), ChangeReason.BUCKET_FILL, newBlock);

    // Act
    cauldronLevelChangeEvent.setNewLevel(1);

    // Assert
    verify(newBlock).getBlockData();
  }

  /**
   * Test {@link CauldronLevelChangeEvent#setNewLevel(int)}.
   *
   * <ul>
   *   <li>Given {@link BlockState} {@link BlockState#setType(Material)} does nothing.
   *   <li>When zero.
   *   <li>Then calls {@link BlockState#setType(Material)}.
   * </ul>
   *
   * <p>Method under test: {@link CauldronLevelChangeEvent#setNewLevel(int)}
   */
  @Test
  @DisplayName(
      "Test setNewLevel(int); given BlockState setType(Material) does nothing; when zero; then calls setType(Material)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CauldronLevelChangeEvent.setNewLevel(int)"})
  void testSetNewLevel_givenBlockStateSetTypeDoesNothing_whenZero_thenCallsSetType() {
    // Arrange
    BlockState newBlock = mock(BlockState.class);
    doNothing().when(newBlock).setType(Mockito.<Material>any());
    CauldronLevelChangeEvent cauldronLevelChangeEvent =
        new CauldronLevelChangeEvent(
            mock(Block.class), mock(Entity.class), ChangeReason.BUCKET_FILL, newBlock);

    // Act
    cauldronLevelChangeEvent.setNewLevel(0);

    // Assert
    verify(newBlock).setType(Material.CAULDRON);
  }
}
