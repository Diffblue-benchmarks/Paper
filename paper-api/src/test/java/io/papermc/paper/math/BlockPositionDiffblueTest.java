package io.papermc.paper.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Axis;
import org.bukkit.block.BlockFace;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockPositionDiffblueTest {
  /**
   * Test {@link BlockPosition#x()}.
   *
   * <p>Method under test: {@link BlockPosition#x()}
   */
  @Test
  @DisplayName("Test x()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BlockPosition.x()"})
  void testX() {
    // Arrange, Act and Assert
    assertEquals(1.0d, new BlockPositionImpl(1, 1, 1).x());
  }

  /**
   * Test {@link BlockPosition#y()}.
   *
   * <p>Method under test: {@link BlockPosition#y()}
   */
  @Test
  @DisplayName("Test y()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BlockPosition.y()"})
  void testY() {
    // Arrange, Act and Assert
    assertEquals(1.0d, new BlockPositionImpl(1, 1, 1).y());
  }

  /**
   * Test {@link BlockPosition#z()}.
   *
   * <p>Method under test: {@link BlockPosition#z()}
   */
  @Test
  @DisplayName("Test z()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BlockPosition.z()"})
  void testZ() {
    // Arrange, Act and Assert
    assertEquals(1.0d, new BlockPositionImpl(1, 1, 1).z());
  }

  /**
   * Test {@link BlockPosition#isBlock()}.
   *
   * <p>Method under test: {@link BlockPosition#isBlock()}
   */
  @Test
  @DisplayName("Test isBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockPosition.isBlock()"})
  void testIsBlock() {
    // Arrange, Act and Assert
    assertTrue(new BlockPositionImpl(1, 1, 1).isBlock());
  }

  /**
   * Test {@link BlockPosition#isFine()}.
   *
   * <p>Method under test: {@link BlockPosition#isFine()}
   */
  @Test
  @DisplayName("Test isFine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockPosition.isFine()"})
  void testIsFine() {
    // Arrange, Act and Assert
    assertFalse(new BlockPositionImpl(1, 1, 1).isFine());
  }

  /**
   * Test {@link BlockPosition#toBlock()}.
   *
   * <p>Method under test: {@link BlockPosition#toBlock()}
   */
  @Test
  @DisplayName("Test toBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.toBlock()"})
  void testToBlock() {
    // Arrange
    BlockPositionImpl blockPositionImpl = new BlockPositionImpl(1, 1, 1);

    // Act
    BlockPosition actualToBlockResult = blockPositionImpl.toBlock();

    // Assert
    assertSame(blockPositionImpl, actualToBlockResult);
  }

  /**
   * Test {@link BlockPosition#offset(Axis, int)} with {@code Axis}, {@code int}.
   *
   * <ul>
   *   <li>Given {@link Position#BLOCK_ZERO}.
   *   <li>When zero.
   *   <li>Then return {@link Position#BLOCK_ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(Axis, int)}
   */
  @Test
  @DisplayName(
      "Test offset(Axis, int) with 'Axis', 'int'; given BLOCK_ZERO; when zero; then return BLOCK_ZERO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(Axis, int)"})
  void testOffsetWithAxisInt_givenBlock_zero_whenZero_thenReturnBlock_zero() {
    // Arrange
    BlockPosition blockPosition = Position.BLOCK_ZERO;

    // Act
    BlockPosition actualOffsetResult = blockPosition.offset(Axis.X, 0);

    // Assert
    assertSame(blockPosition, actualOffsetResult);
  }

  /**
   * Test {@link BlockPosition#offset(Axis, int)} with {@code Axis}, {@code int}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return blockX is eleven.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(Axis, int)}
   */
  @Test
  @DisplayName("Test offset(Axis, int) with 'Axis', 'int'; when 'X'; then return blockX is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(Axis, int)"})
  void testOffsetWithAxisInt_whenX_thenReturnBlockXIsEleven() {
    // Arrange and Act
    BlockPosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(Axis.X, 10);

    // Assert
    assertTrue(actualOffsetResult instanceof BlockPositionImpl);
    assertEquals(11, actualOffsetResult.blockX());
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(11, toVectorResult.getBlockX());
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(11, toBlockVectorResult.getBlockX());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
    assertEquals(11, toVector3iResult.x());
    assertEquals(11, toVector3iResult.x);
    assertEquals(11.0d, toVectorResult.getX());
    assertEquals(11.0d, toBlockVectorResult.getX());
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d toVector3dResult = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = toVectorResult.toVector3f();
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
   * Test {@link BlockPosition#offset(Axis, int)} with {@code Axis}, {@code int}.
   *
   * <ul>
   *   <li>When {@code Y}.
   *   <li>Then return blockY is eleven.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(Axis, int)}
   */
  @Test
  @DisplayName("Test offset(Axis, int) with 'Axis', 'int'; when 'Y'; then return blockY is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(Axis, int)"})
  void testOffsetWithAxisInt_whenY_thenReturnBlockYIsEleven() {
    // Arrange and Act
    BlockPosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(Axis.Y, 10);

    // Assert
    assertTrue(actualOffsetResult instanceof BlockPositionImpl);
    assertEquals(11, actualOffsetResult.blockY());
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(11, toVectorResult.getBlockY());
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(11, toBlockVectorResult.getBlockY());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
    assertEquals(11, toVector3iResult.y());
    assertEquals(11, toVector3iResult.y);
    assertEquals(11.0d, toVectorResult.getY());
    assertEquals(11.0d, toBlockVectorResult.getY());
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d toVector3dResult = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = toVectorResult.toVector3f();
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
   * Test {@link BlockPosition#offset(Axis, int)} with {@code Axis}, {@code int}.
   *
   * <ul>
   *   <li>When {@code Z}.
   *   <li>Then return blockZ is eleven.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(Axis, int)}
   */
  @Test
  @DisplayName("Test offset(Axis, int) with 'Axis', 'int'; when 'Z'; then return blockZ is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(Axis, int)"})
  void testOffsetWithAxisInt_whenZ_thenReturnBlockZIsEleven() {
    // Arrange and Act
    BlockPosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(Axis.Z, 10);

    // Assert
    assertTrue(actualOffsetResult instanceof BlockPositionImpl);
    assertEquals(11, actualOffsetResult.blockZ());
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(11, toVectorResult.getBlockZ());
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(11, toBlockVectorResult.getBlockZ());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
    assertEquals(11, toVector3iResult.z());
    assertEquals(11, toVector3iResult.z);
    assertEquals(11.0d, toVectorResult.getZ());
    assertEquals(11.0d, toBlockVectorResult.getZ());
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d toVector3dResult = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = toVectorResult.toVector3f();
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
   * Test {@link BlockPosition#offset(BlockFace)} with {@code BlockFace}.
   *
   * <p>Method under test: {@link BlockPosition#offset(BlockFace)}
   */
  @Test
  @DisplayName("Test offset(BlockFace) with 'BlockFace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(BlockFace)"})
  void testOffsetWithBlockFace() {
    // Arrange and Act
    BlockPosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(BlockFace.NORTH);

    // Assert
    assertTrue(actualOffsetResult instanceof BlockPositionImpl);
    assertEquals(0, actualOffsetResult.blockZ());
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(0, toVectorResult.getBlockZ());
    assertEquals(0.0d, toVectorResult.getZ());
    assertEquals(1, actualOffsetResult.blockX());
    assertEquals(1, actualOffsetResult.blockY());
    assertEquals(1, toVectorResult.getBlockX());
    assertEquals(1, toVectorResult.getBlockY());
    assertEquals(1.0d, toVectorResult.getX());
    assertEquals(1.0d, toVectorResult.getY());
    assertEquals(1.4142135623730951d, toVectorResult.length());
    assertFalse(actualOffsetResult.isFine());
    assertFalse(toVectorResult.isZero());
    assertTrue(actualOffsetResult.isBlock());
    assertTrue(actualOffsetResult.isFinite());
  }

  /**
   * Test {@link BlockPosition#offset(BlockFace, int)} with {@code BlockFace}, {@code int}.
   *
   * <ul>
   *   <li>Given {@link Position#BLOCK_ZERO}.
   *   <li>When zero.
   *   <li>Then return {@link Position#BLOCK_ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(BlockFace, int)}
   */
  @Test
  @DisplayName(
      "Test offset(BlockFace, int) with 'BlockFace', 'int'; given BLOCK_ZERO; when zero; then return BLOCK_ZERO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(BlockFace, int)"})
  void testOffsetWithBlockFaceInt_givenBlock_zero_whenZero_thenReturnBlock_zero() {
    // Arrange
    BlockPosition blockPosition = Position.BLOCK_ZERO;

    // Act
    BlockPosition actualOffsetResult = blockPosition.offset(BlockFace.NORTH, 0);

    // Assert
    assertSame(blockPosition, actualOffsetResult);
  }

  /**
   * Test {@link BlockPosition#offset(BlockFace, int)} with {@code BlockFace}, {@code int}.
   *
   * <ul>
   *   <li>Then return {@link BlockPositionImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(BlockFace, int)}
   */
  @Test
  @DisplayName("Test offset(BlockFace, int) with 'BlockFace', 'int'; then return BlockPositionImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(BlockFace, int)"})
  void testOffsetWithBlockFaceInt_thenReturnBlockPositionImpl() {
    // Arrange and Act
    BlockPosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(BlockFace.NORTH, 10);

    // Assert
    assertTrue(actualOffsetResult instanceof BlockPositionImpl);
    assertEquals(-9, actualOffsetResult.blockZ());
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(-9, toVectorResult.getBlockZ());
    assertEquals(-9.0d, toVectorResult.getZ());
    assertEquals(1, actualOffsetResult.blockX());
    assertEquals(1, actualOffsetResult.blockY());
    assertEquals(1, toVectorResult.getBlockX());
    assertEquals(1, toVectorResult.getBlockY());
    assertEquals(1.0d, toVectorResult.getX());
    assertEquals(1.0d, toVectorResult.getY());
    assertEquals(9.1104335791443d, toVectorResult.length());
    assertFalse(toVectorResult.isZero());
  }

  /**
   * Test {@link BlockPosition#offset(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <p>Method under test: {@link BlockPosition#offset(double, double, double)}
   */
  @Test
  @DisplayName("Test offset(double, double, double) with 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition BlockPosition.offset(double, double, double)"})
  void testOffsetWithDoubleDoubleDouble() {
    // Arrange and Act
    FinePosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(2.0d, 3.0d, 10.0d);

    // Assert
    assertTrue(actualOffsetResult instanceof FinePositionImpl);
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(11, toVectorResult.getBlockZ());
    assertEquals(11.0d, actualOffsetResult.z());
    assertEquals(11.0d, toVectorResult.getZ());
    assertEquals(12.083045973594572d, toVectorResult.length());
    assertEquals(3, toVectorResult.getBlockX());
    assertEquals(3.0d, actualOffsetResult.x());
    assertEquals(3.0d, toVectorResult.getX());
    assertEquals(4, toVectorResult.getBlockY());
    assertEquals(4.0d, actualOffsetResult.y());
    assertEquals(4.0d, toVectorResult.getY());
    assertFalse(actualOffsetResult.isBlock());
    assertFalse(toVectorResult.isZero());
    assertTrue(actualOffsetResult.isFine());
    assertTrue(actualOffsetResult.isFinite());
  }

  /**
   * Test {@link BlockPosition#offset(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Given {@link Position#BLOCK_ZERO}.
   *   <li>When zero.
   *   <li>Then return {@link Position#BLOCK_ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test offset(int, int, int) with 'int', 'int', 'int'; given BLOCK_ZERO; when zero; then return BLOCK_ZERO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(int, int, int)"})
  void testOffsetWithIntIntInt_givenBlock_zero_whenZero_thenReturnBlock_zero() {
    // Arrange
    BlockPosition blockPosition = Position.BLOCK_ZERO;

    // Act
    BlockPosition actualOffsetResult = blockPosition.offset(0, 0, 0);

    // Assert
    assertSame(blockPosition, actualOffsetResult);
  }

  /**
   * Test {@link BlockPosition#offset(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then return blockY is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(int, int, int)}
   */
  @Test
  @DisplayName("Test offset(int, int, int) with 'int', 'int', 'int'; then return blockY is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(int, int, int)"})
  void testOffsetWithIntIntInt_thenReturnBlockYIsOne() {
    // Arrange and Act
    BlockPosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(0, 0, 1);

    // Assert
    assertTrue(actualOffsetResult instanceof BlockPositionImpl);
    assertEquals(1, actualOffsetResult.blockY());
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(1, toVectorResult.getBlockY());
    assertEquals(1.0d, toVectorResult.getY());
    assertEquals(2.449489742783178d, toVectorResult.length());
  }

  /**
   * Test {@link BlockPosition#offset(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return toVector length is {@code 4.58257569495584}.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test offset(int, int, int) with 'int', 'int', 'int'; when three; then return toVector length is '4.58257569495584'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(int, int, int)"})
  void testOffsetWithIntIntInt_whenThree_thenReturnToVectorLengthIs458257569495584() {
    // Arrange and Act
    BlockPosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(0, 3, 1);

    // Assert
    assertTrue(actualOffsetResult instanceof BlockPositionImpl);
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(4.58257569495584d, toVectorResult.length());
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(4.58257569495584d, toBlockVectorResult.length());
    Vector3d toVector3dResult = toVectorResult.toVector3d();
    assertEquals(4.58257569495584d, toVector3dResult.length());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
    assertEquals(4.582575798034668d, toVector3iResult.length());
    Vector3f toVector3fResult = toVectorResult.toVector3f();
    assertEquals(4.582576f, toVector3fResult.length());
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
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
   * Test {@link BlockPosition#offset(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return blockX is three.
   * </ul>
   *
   * <p>Method under test: {@link BlockPosition#offset(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test offset(int, int, int) with 'int', 'int', 'int'; when two; then return blockX is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition BlockPosition.offset(int, int, int)"})
  void testOffsetWithIntIntInt_whenTwo_thenReturnBlockXIsThree() {
    // Arrange and Act
    BlockPosition actualOffsetResult = new BlockPositionImpl(1, 1, 1).offset(2, 3, 1);

    // Assert
    assertTrue(actualOffsetResult instanceof BlockPositionImpl);
    assertEquals(3, actualOffsetResult.blockX());
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(3, toVectorResult.getBlockX());
    assertEquals(3.0d, toVectorResult.getX());
    assertEquals(5.385164807134504d, toVectorResult.length());
  }
}
