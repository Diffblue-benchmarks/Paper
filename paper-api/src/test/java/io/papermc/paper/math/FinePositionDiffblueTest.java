package io.papermc.paper.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FinePositionDiffblueTest {
  /**
   * Test {@link FinePosition#blockX()}.
   *
   * <ul>
   *   <li>Given {@link FinePositionImpl#FinePositionImpl(double, double, double)} with x is {@code
   *       0.5} and y is three and z is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockX()}
   */
  @Test
  @DisplayName(
      "Test blockX(); given FinePositionImpl(double, double, double) with x is '0.5' and y is three and z is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockX()"})
  void testBlockX_givenFinePositionImplWithXIs05AndYIsThreeAndZIsTen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new FinePositionImpl(0.5d, 3.0d, 10.0d).blockX());
  }

  /**
   * Test {@link FinePosition#blockX()}.
   *
   * <ul>
   *   <li>Given {@link FinePositionImpl#FinePositionImpl(double, double, double)} with x is two and
   *       y is three and z is ten.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockX()}
   */
  @Test
  @DisplayName(
      "Test blockX(); given FinePositionImpl(double, double, double) with x is two and y is three and z is ten; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockX()"})
  void testBlockX_givenFinePositionImplWithXIsTwoAndYIsThreeAndZIsTen_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, new FinePositionImpl(2.0d, 3.0d, 10.0d).blockX());
  }

  /**
   * Test {@link FinePosition#blockX()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is ten.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockX()}
   */
  @Test
  @DisplayName(
      "Test blockX(); given Location(World, double, double, double) with World and x is two and y is three and z is ten; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockX()"})
  void testBlockX_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen_thenReturnTwo() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(2, location.blockX());
  }

  /**
   * Test {@link FinePosition#blockY()}.
   *
   * <ul>
   *   <li>Given {@link FinePositionImpl#FinePositionImpl(double, double, double)} with x is two and
   *       y is {@code 0.5} and z is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockY()}
   */
  @Test
  @DisplayName(
      "Test blockY(); given FinePositionImpl(double, double, double) with x is two and y is '0.5' and z is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockY()"})
  void testBlockY_givenFinePositionImplWithXIsTwoAndYIs05AndZIsTen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new FinePositionImpl(2.0d, 0.5d, 10.0d).blockY());
  }

  /**
   * Test {@link FinePosition#blockY()}.
   *
   * <ul>
   *   <li>Given {@link FinePositionImpl#FinePositionImpl(double, double, double)} with x is two and
   *       y is three and z is ten.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockY()}
   */
  @Test
  @DisplayName(
      "Test blockY(); given FinePositionImpl(double, double, double) with x is two and y is three and z is ten; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockY()"})
  void testBlockY_givenFinePositionImplWithXIsTwoAndYIsThreeAndZIsTen_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, new FinePositionImpl(2.0d, 3.0d, 10.0d).blockY());
  }

  /**
   * Test {@link FinePosition#blockY()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is ten.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockY()}
   */
  @Test
  @DisplayName(
      "Test blockY(); given Location(World, double, double, double) with World and x is two and y is three and z is ten; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockY()"})
  void testBlockY_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen_thenReturnThree() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(3, location.blockY());
  }

  /**
   * Test {@link FinePosition#blockZ()}.
   *
   * <ul>
   *   <li>Given {@link FinePositionImpl#FinePositionImpl(double, double, double)} with x is two and
   *       y is three and z is {@code 0.5}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockZ()}
   */
  @Test
  @DisplayName(
      "Test blockZ(); given FinePositionImpl(double, double, double) with x is two and y is three and z is '0.5'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockZ()"})
  void testBlockZ_givenFinePositionImplWithXIsTwoAndYIsThreeAndZIs05_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new FinePositionImpl(2.0d, 3.0d, 0.5d).blockZ());
  }

  /**
   * Test {@link FinePosition#blockZ()}.
   *
   * <ul>
   *   <li>Given {@link FinePositionImpl#FinePositionImpl(double, double, double)} with x is two and
   *       y is three and z is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockZ()}
   */
  @Test
  @DisplayName(
      "Test blockZ(); given FinePositionImpl(double, double, double) with x is two and y is three and z is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockZ()"})
  void testBlockZ_givenFinePositionImplWithXIsTwoAndYIsThreeAndZIsTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, new FinePositionImpl(2.0d, 3.0d, 10.0d).blockZ());
  }

  /**
   * Test {@link FinePosition#blockZ()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#blockZ()}
   */
  @Test
  @DisplayName(
      "Test blockZ(); given Location(World, double, double, double) with World and x is two and y is three and z is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FinePosition.blockZ()"})
  void testBlockZ_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen_thenReturnTen() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(10, location.blockZ());
  }

  /**
   * Test {@link FinePosition#isBlock()}.
   *
   * <p>Method under test: {@link FinePosition#isBlock()}
   */
  @Test
  @DisplayName("Test isBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FinePosition.isBlock()"})
  void testIsBlock() {
    // Arrange, Act and Assert
    assertFalse(new FinePositionImpl(2.0d, 3.0d, 10.0d).isBlock());
  }

  /**
   * Test {@link FinePosition#isFine()}.
   *
   * <p>Method under test: {@link FinePosition#isFine()}
   */
  @Test
  @DisplayName("Test isFine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FinePosition.isFine()"})
  void testIsFine() {
    // Arrange, Act and Assert
    assertTrue(new FinePositionImpl(2.0d, 3.0d, 10.0d).isFine());
  }

  /**
   * Test {@link FinePosition#toBlock()}.
   *
   * <ul>
   *   <li>Given {@link FinePositionImpl#FinePositionImpl(double, double, double)} with x is two and
   *       y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#toBlock()}
   */
  @Test
  @DisplayName(
      "Test toBlock(); given FinePositionImpl(double, double, double) with x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition FinePosition.toBlock()"})
  void testToBlock_givenFinePositionImplWithXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange and Act
    BlockPosition actualToBlockResult = new FinePositionImpl(2.0d, 3.0d, 10.0d).toBlock();

    // Assert
    assertTrue(actualToBlockResult instanceof BlockPositionImpl);
    Vector toVectorResult = actualToBlockResult.toVector();
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
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
   * Test {@link FinePosition#toBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#toBlock()}
   */
  @Test
  @DisplayName(
      "Test toBlock(); given Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition FinePosition.toBlock()"})
  void testToBlock_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    BlockPosition actualToBlockResult = location.toBlock();

    // Assert
    assertTrue(actualToBlockResult instanceof BlockPositionImpl);
    Vector toVectorResult = actualToBlockResult.toVector();
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
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
   * Test {@link FinePosition#toBlock()}.
   *
   * <ul>
   *   <li>Then return blockX is zero.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#toBlock()}
   */
  @Test
  @DisplayName("Test toBlock(); then return blockX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition FinePosition.toBlock()"})
  void testToBlock_thenReturnBlockXIsZero() {
    // Arrange and Act
    BlockPosition actualToBlockResult = new FinePositionImpl(0.5d, 3.0d, 10.0d).toBlock();

    // Assert
    assertTrue(actualToBlockResult instanceof BlockPositionImpl);
    assertEquals(0, actualToBlockResult.blockX());
    Vector toVectorResult = actualToBlockResult.toVector();
    assertEquals(0, toVectorResult.getBlockX());
    assertEquals(0.0d, toVectorResult.getX());
    assertEquals(10.44030650891055d, toVectorResult.length());
  }

  /**
   * Test {@link FinePosition#offset(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Given {@link Position#FINE_ZERO}.
   *   <li>When zero.
   *   <li>Then return {@link Position#FINE_ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#offset(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test offset(double, double, double) with 'double', 'double', 'double'; given FINE_ZERO; when zero; then return FINE_ZERO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition FinePosition.offset(double, double, double)"})
  void testOffsetWithDoubleDoubleDouble_givenFine_zero_whenZero_thenReturnFine_zero() {
    // Arrange
    FinePosition finePosition = Position.FINE_ZERO;

    // Act
    FinePosition actualOffsetResult = finePosition.offset(0.0d, 0.0d, 0.0d);

    // Assert
    assertSame(finePosition, actualOffsetResult);
  }

  /**
   * Test {@link FinePosition#offset(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then return toVector length is {@code 21.2602916254693}.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#offset(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test offset(double, double, double) with 'double', 'double', 'double'; then return toVector length is '21.2602916254693'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition FinePosition.offset(double, double, double)"})
  void testOffsetWithDoubleDoubleDouble_thenReturnToVectorLengthIs212602916254693() {
    // Arrange and Act
    FinePosition actualOffsetResult =
        new FinePositionImpl(2.0d, 3.0d, 10.0d).offset(2.0d, 3.0d, 10.0d);

    // Assert
    assertTrue(actualOffsetResult instanceof FinePositionImpl);
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(21.2602916254693d, toVectorResult.length());
    assertEquals(4, toVectorResult.getBlockX());
    assertEquals(4.0d, actualOffsetResult.x());
    assertEquals(4.0d, toVectorResult.getX());
  }

  /**
   * Test {@link FinePosition#offset(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then return toVector length is {@code 20.97617696340303}.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#offset(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test offset(double, double, double) with 'double', 'double', 'double'; then return toVector length is '20.97617696340303'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition FinePosition.offset(double, double, double)"})
  void testOffsetWithDoubleDoubleDouble_thenReturnToVectorLengthIs2097617696340303() {
    // Arrange and Act
    FinePosition actualOffsetResult =
        new FinePositionImpl(2.0d, 3.0d, 10.0d).offset(0.0d, 3.0d, 10.0d);

    // Assert
    assertTrue(actualOffsetResult instanceof FinePositionImpl);
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(20.97617696340303d, toVectorResult.length());
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(20.97617696340303d, toBlockVectorResult.length());
    Vector3d toVector3dResult = toVectorResult.toVector3d();
    assertEquals(20.97617696340303d, toVector3dResult.length());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
    assertEquals(20.976177215576172d, toVector3iResult.length());
    Vector3f toVector3fResult = toVectorResult.toVector3f();
    assertEquals(20.976177f, toVector3fResult.length());
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
   * Test {@link FinePosition#offset(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then return toVector length is {@code 20.322401432901575}.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#offset(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test offset(double, double, double) with 'double', 'double', 'double'; then return toVector length is '20.322401432901575'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition FinePosition.offset(double, double, double)"})
  void testOffsetWithDoubleDoubleDouble_thenReturnToVectorLengthIs20322401432901575() {
    // Arrange and Act
    FinePosition actualOffsetResult =
        new FinePositionImpl(2.0d, 3.0d, 10.0d).offset(0.0d, 0.0d, 10.0d);

    // Assert
    assertTrue(actualOffsetResult instanceof FinePositionImpl);
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(20.322401432901575d, toVectorResult.length());
    assertEquals(3, toVectorResult.getBlockY());
    assertEquals(3.0d, actualOffsetResult.y());
    assertEquals(3.0d, toVectorResult.getY());
  }

  /**
   * Test {@link FinePosition#offset(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then return {@link FinePositionImpl#FinePositionImpl(double, double, double)} with x is
   *       two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#offset(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test offset(int, int, int) with 'int', 'int', 'int'; then return FinePositionImpl(double, double, double) with x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition FinePosition.offset(int, int, int)"})
  void testOffsetWithIntIntInt_thenReturnFinePositionImplWithXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    FinePositionImpl finePositionImpl = new FinePositionImpl(2.0d, 3.0d, 10.0d);

    // Act
    FinePosition actualOffsetResult = finePositionImpl.offset(0, 0, 0);

    // Assert
    assertSame(finePositionImpl, actualOffsetResult);
  }

  /**
   * Test {@link FinePosition#offset(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return toVector length is {@code 12.68857754044952}.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#offset(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test offset(int, int, int) with 'int', 'int', 'int'; when three; then return toVector length is '12.68857754044952'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition FinePosition.offset(int, int, int)"})
  void testOffsetWithIntIntInt_whenThree_thenReturnToVectorLengthIs1268857754044952() {
    // Arrange and Act
    FinePosition actualOffsetResult = new FinePositionImpl(2.0d, 3.0d, 10.0d).offset(0, 3, 1);

    // Assert
    assertTrue(actualOffsetResult instanceof FinePositionImpl);
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(12.68857754044952d, toVectorResult.length());
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(12.68857754044952d, toBlockVectorResult.length());
    Vector3d toVector3dResult = toVectorResult.toVector3d();
    assertEquals(12.68857754044952d, toVector3dResult.length());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
    assertEquals(12.688577651977539d, toVector3iResult.length());
    Vector3f toVector3fResult = toVectorResult.toVector3f();
    assertEquals(12.688578f, toVector3fResult.length());
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
   * Test {@link FinePosition#offset(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return toVector length is {@code 13.152946437965905}.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#offset(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test offset(int, int, int) with 'int', 'int', 'int'; when two; then return toVector length is '13.152946437965905'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition FinePosition.offset(int, int, int)"})
  void testOffsetWithIntIntInt_whenTwo_thenReturnToVectorLengthIs13152946437965905() {
    // Arrange and Act
    FinePosition actualOffsetResult = new FinePositionImpl(2.0d, 3.0d, 10.0d).offset(2, 3, 1);

    // Assert
    assertTrue(actualOffsetResult instanceof FinePositionImpl);
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(13.152946437965905d, toVectorResult.length());
    assertEquals(4, toVectorResult.getBlockX());
    assertEquals(4.0d, actualOffsetResult.x());
    assertEquals(4.0d, toVectorResult.getX());
  }

  /**
   * Test {@link FinePosition#offset(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return toVector length is {@code 11.575836902790225}.
   * </ul>
   *
   * <p>Method under test: {@link FinePosition#offset(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test offset(int, int, int) with 'int', 'int', 'int'; when zero; then return toVector length is '11.575836902790225'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition FinePosition.offset(int, int, int)"})
  void testOffsetWithIntIntInt_whenZero_thenReturnToVectorLengthIs11575836902790225() {
    // Arrange and Act
    FinePosition actualOffsetResult = new FinePositionImpl(2.0d, 3.0d, 10.0d).offset(0, 0, 1);

    // Assert
    assertTrue(actualOffsetResult instanceof FinePositionImpl);
    Vector toVectorResult = actualOffsetResult.toVector();
    assertEquals(11.575836902790225d, toVectorResult.length());
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(11.575836902790225d, toBlockVectorResult.length());
    Vector3d toVector3dResult = toVectorResult.toVector3d();
    assertEquals(11.575836902790225d, toVector3dResult.length());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
    assertEquals(11.575837135314941d, toVector3iResult.length());
    Vector3f toVector3fResult = toVectorResult.toVector3f();
    assertEquals(11.575837f, toVector3fResult.length());
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
}
