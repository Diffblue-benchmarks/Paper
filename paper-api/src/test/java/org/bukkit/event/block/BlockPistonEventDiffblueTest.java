package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockPistonEventDiffblueTest {
  /**
   * Test {@link BlockPistonEvent#isSticky()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getType()} return {@code ACACIA_BOAT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonEvent#isSticky()}
   */
  @Test
  @DisplayName("Test isSticky(); given Block getType() return 'ACACIA_BOAT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockPistonEvent.isSticky()"})
  void testIsSticky_givenBlockGetTypeReturnAcaciaBoat_thenReturnFalse() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsStickyResult = new BlockPistonExtendEvent(block, 3, BlockFace.NORTH).isSticky();

    // Assert
    verify(block, atLeast(1)).getType();
    assertFalse(actualIsStickyResult);
  }

  /**
   * Test {@link BlockPistonEvent#isSticky()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getType()} return {@link Material#MOVING_PISTON}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonEvent#isSticky()}
   */
  @Test
  @DisplayName("Test isSticky(); given Block getType() return MOVING_PISTON; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockPistonEvent.isSticky()"})
  void testIsSticky_givenBlockGetTypeReturnMoving_piston_thenReturnTrue() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getType()).thenReturn(Material.MOVING_PISTON);

    // Act
    boolean actualIsStickyResult = new BlockPistonExtendEvent(block, 3, BlockFace.NORTH).isSticky();

    // Assert
    verify(block, atLeast(1)).getType();
    assertTrue(actualIsStickyResult);
  }

  /**
   * Test {@link BlockPistonEvent#isSticky()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getType()} return {@link Material#STICKY_PISTON}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonEvent#isSticky()}
   */
  @Test
  @DisplayName("Test isSticky(); given Block getType() return STICKY_PISTON; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockPistonEvent.isSticky()"})
  void testIsSticky_givenBlockGetTypeReturnSticky_piston_thenReturnTrue() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getType()).thenReturn(Material.STICKY_PISTON);

    // Act
    boolean actualIsStickyResult = new BlockPistonExtendEvent(block, 3, BlockFace.NORTH).isSticky();

    // Assert
    verify(block).getType();
    assertTrue(actualIsStickyResult);
  }

  /**
   * Test {@link BlockPistonEvent#getDirection()}.
   *
   * <p>Method under test: {@link BlockPistonEvent#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockPistonEvent.getDirection()"})
  void testGetDirection() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH,
        new BlockPistonExtendEvent(mock(Block.class), 3, BlockFace.NORTH).getDirection());
  }

  /**
   * Test {@link BlockPistonEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockPistonEvent.isCancelled()"})
  void testIsCancelled_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BlockPistonExtendEvent(mock(Block.class), 3, BlockFace.NORTH).isCancelled());
  }

  /**
   * Test {@link BlockPistonEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPistonEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockPistonEvent.isCancelled()"})
  void testIsCancelled_thenReturnTrue() {
    // Arrange
    BlockPistonExtendEvent blockPistonExtendEvent =
        new BlockPistonExtendEvent(mock(Block.class), 3, BlockFace.NORTH);
    blockPistonExtendEvent.setCancelled(true);

    // Act and Assert
    assertTrue(blockPistonExtendEvent.isCancelled());
  }

  /**
   * Test {@link BlockPistonEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link BlockPistonEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockPistonEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    BlockPistonExtendEvent blockPistonExtendEvent =
        new BlockPistonExtendEvent(mock(Block.class), 3, BlockFace.NORTH);

    // Act
    blockPistonExtendEvent.setCancelled(true);

    // Assert
    assertTrue(blockPistonExtendEvent.isCancelled());
  }
}
