package com.destroystokyo.paper.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TargetBlockInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TargetBlockInfo#TargetBlockInfo(Block, BlockFace)}
   *   <li>{@link TargetBlockInfo#getBlock()}
   *   <li>{@link TargetBlockInfo#getBlockFace()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TargetBlockInfo.<init>(Block, BlockFace)",
    "Block TargetBlockInfo.getBlock()",
    "BlockFace TargetBlockInfo.getBlockFace()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    TargetBlockInfo actualTargetBlockInfo = new TargetBlockInfo(block, BlockFace.NORTH);
    Block actualBlock = actualTargetBlockInfo.getBlock();

    // Assert
    assertEquals(BlockFace.NORTH, actualTargetBlockInfo.getBlockFace());
    assertSame(block, actualBlock);
  }

  /**
   * Test {@link TargetBlockInfo#getRelativeBlock()}.
   *
   * <p>Method under test: {@link TargetBlockInfo#getRelativeBlock()}
   */
  @Test
  @DisplayName("Test getRelativeBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Block TargetBlockInfo.getRelativeBlock()"})
  void testGetRelativeBlock() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    // Act
    new TargetBlockInfo(block, BlockFace.NORTH).getRelativeBlock();

    // Assert
    verify(block).getRelative(BlockFace.NORTH);
  }
}
