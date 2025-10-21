package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.World;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VectorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Vector#Vector()}
   *   <li>{@link Vector#setX(double)}
   *   <li>{@link Vector#setX(float)}
   *   <li>{@link Vector#setX(int)}
   *   <li>{@link Vector#setY(double)}
   *   <li>{@link Vector#setY(float)}
   *   <li>{@link Vector#setY(int)}
   *   <li>{@link Vector#setZ(double)}
   *   <li>{@link Vector#setZ(float)}
   *   <li>{@link Vector#setZ(int)}
   *   <li>{@link Vector#getEpsilon()}
   *   <li>{@link Vector#toString()}
   *   <li>{@link Vector#getX()}
   *   <li>{@link Vector#getY()}
   *   <li>{@link Vector#getZ()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Vector.<init>()",
    "double Vector.getEpsilon()",
    "double Vector.getX()",
    "double Vector.getY()",
    "double Vector.getZ()",
    "Vector Vector.setX(double)",
    "Vector Vector.setX(float)",
    "Vector Vector.setX(int)",
    "Vector Vector.setY(double)",
    "Vector Vector.setY(float)",
    "Vector Vector.setY(int)",
    "Vector Vector.setZ(double)",
    "Vector Vector.setZ(float)",
    "Vector Vector.setZ(int)",
    "String Vector.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Vector actualVector = new Vector();
    Vector actualSetXResult = actualVector.setX(2.0d);
    Vector actualSetXResult2 = actualVector.setX(10.0f);
    Vector actualSetXResult3 = actualVector.setX(2);
    Vector actualSetYResult = actualVector.setY(3.0d);
    Vector actualSetYResult2 = actualVector.setY(10.0f);
    Vector actualSetYResult3 = actualVector.setY(3);
    Vector actualSetZResult = actualVector.setZ(10.0d);
    Vector actualSetZResult2 = actualVector.setZ(10.0f);
    Vector actualSetZResult3 = actualVector.setZ(1);
    double actualEpsilon = actualVector.getEpsilon();
    String actualToStringResult = actualVector.toString();
    double actualX = actualVector.getX();
    double actualY = actualVector.getY();

    // Assert
    assertEquals("2.0,3.0,1.0", actualToStringResult);
    assertEquals(1.0E-6d, actualEpsilon);
    assertEquals(1.0d, actualVector.getZ());
    assertEquals(2.0d, actualX);
    assertEquals(3.0d, actualY);
    assertSame(actualVector, actualSetXResult);
    assertSame(actualVector, actualSetXResult2);
    assertSame(actualVector, actualSetXResult3);
    assertSame(actualVector, actualSetYResult);
    assertSame(actualVector, actualSetYResult2);
    assertSame(actualVector, actualSetYResult3);
    assertSame(actualVector, actualSetZResult);
    assertSame(actualVector, actualSetZResult2);
    assertSame(actualVector, actualSetZResult3);
  }

  /**
   * Test {@link Vector#Vector(double, double, double)}.
   *
   * <p>Method under test: {@link Vector#Vector(double, double, double)}
   */
  @Test
  @DisplayName("Test new Vector(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vector.<init>(double, double, double)"})
  void testNewVector() {
    // Arrange and Act
    Vector actualVector = new Vector(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(10.0d, actualVector.getZ());
    assertEquals(10.63014581273465d, actualVector.length());
    assertEquals(2, actualVector.getBlockX());
    assertEquals(2.0d, actualVector.getX());
    assertEquals(3, actualVector.getBlockY());
    assertEquals(3.0d, actualVector.getY());
    assertFalse(actualVector.isZero());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualVector.getBlockZ());
  }

  /**
   * Test {@link Vector#Vector(float, float, float)}.
   *
   * <p>Method under test: {@link Vector#Vector(float, float, float)}
   */
  @Test
  @DisplayName("Test new Vector(float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vector.<init>(float, float, float)"})
  void testNewVector2() {
    // Arrange and Act
    Vector actualVector = new Vector(10.0f, 10.0f, 10.0f);

    // Assert
    assertEquals(10.0d, actualVector.getX());
    assertEquals(10.0d, actualVector.getY());
    assertEquals(10.0d, actualVector.getZ());
    assertEquals(17.320508075688775d, actualVector.length());
    assertFalse(actualVector.isZero());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualVector.getBlockX());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualVector.getBlockY());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualVector.getBlockZ());
  }

  /**
   * Test {@link Vector#Vector(int, int, int)}.
   *
   * <p>Method under test: {@link Vector#Vector(int, int, int)}
   */
  @Test
  @DisplayName("Test new Vector(int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vector.<init>(int, int, int)"})
  void testNewVector3() {
    // Arrange and Act
    Vector actualVector = new Vector(2, 3, 1);

    // Assert
    assertEquals(1, actualVector.getBlockZ());
    assertEquals(1.0d, actualVector.getZ());
    assertEquals(2, actualVector.getBlockX());
    assertEquals(2.0d, actualVector.getX());
    assertEquals(3, actualVector.getBlockY());
    assertEquals(3.0d, actualVector.getY());
    assertEquals(3.7416573867739413d, actualVector.length());
    assertFalse(actualVector.isZero());
  }

  /**
   * Test {@link Vector#add(Vector)}.
   *
   * <p>Method under test: {@link Vector#add(Vector)}
   */
  @Test
  @DisplayName("Test add(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.add(Vector)"})
  void testAdd() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualAddResult = random.add(Vector.getRandom());

    // Assert
    assertSame(random, actualAddResult);
  }

  /**
   * Test {@link Vector#subtract(Vector)}.
   *
   * <p>Method under test: {@link Vector#subtract(Vector)}
   */
  @Test
  @DisplayName("Test subtract(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.subtract(Vector)"})
  void testSubtract() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualSubtractResult = random.subtract(Vector.getRandom());

    // Assert
    assertSame(random, actualSubtractResult);
  }

  /**
   * Test {@link Vector#multiply(double)} with {@code double}.
   *
   * <p>Method under test: {@link Vector#multiply(double)}
   */
  @Test
  @DisplayName("Test multiply(double) with 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.multiply(double)"})
  void testMultiplyWithDouble() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualMultiplyResult = random.multiply(10.0d);

    // Assert
    assertSame(random, actualMultiplyResult);
  }

  /**
   * Test {@link Vector#multiply(float)} with {@code float}.
   *
   * <p>Method under test: {@link Vector#multiply(float)}
   */
  @Test
  @DisplayName("Test multiply(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.multiply(float)"})
  void testMultiplyWithFloat() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualMultiplyResult = random.multiply(10.0f);

    // Assert
    assertSame(random, actualMultiplyResult);
  }

  /**
   * Test {@link Vector#multiply(int)} with {@code int}.
   *
   * <p>Method under test: {@link Vector#multiply(int)}
   */
  @Test
  @DisplayName("Test multiply(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.multiply(int)"})
  void testMultiplyWithInt() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualMultiplyResult = random.multiply(1);

    // Assert
    assertSame(random, actualMultiplyResult);
  }

  /**
   * Test {@link Vector#multiply(Vector)} with {@code Vector}.
   *
   * <p>Method under test: {@link Vector#multiply(Vector)}
   */
  @Test
  @DisplayName("Test multiply(Vector) with 'Vector'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.multiply(Vector)"})
  void testMultiplyWithVector() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualMultiplyResult = random.multiply(Vector.getRandom());

    // Assert
    assertSame(random, actualMultiplyResult);
  }

  /**
   * Test {@link Vector#divide(Vector)}.
   *
   * <p>Method under test: {@link Vector#divide(Vector)}
   */
  @Test
  @DisplayName("Test divide(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.divide(Vector)"})
  void testDivide() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualDivideResult = random.divide(Vector.getRandom());

    // Assert
    assertSame(random, actualDivideResult);
  }

  /**
   * Test {@link Vector#copy(Vector)}.
   *
   * <p>Method under test: {@link Vector#copy(Vector)}
   */
  @Test
  @DisplayName("Test copy(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.copy(Vector)"})
  void testCopy() {
    // Arrange
    Vector random = Vector.getRandom();
    Vector vec = Vector.getRandom();

    // Act
    Vector actualCopyResult = random.copy(vec);

    // Assert
    assertEquals(random, vec);
    assertSame(random, actualCopyResult);
  }

  /**
   * Test {@link Vector#angle(Vector)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#angle(Vector)}
   */
  @Test
  @DisplayName(
      "Test angle(Vector); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Vector.angle(Vector)"})
  void testAngle_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    Vector random = Vector.getRandom();

    BlockVector other = mock(BlockVector.class);
    when(other.length()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> random.angle(other));
    verify(other).length();
  }

  /**
   * Test {@link Vector#angle(Vector)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link BlockVector} {@link BlockVector#length()} return ten.
   *   <li>Then return {@code 1.5707964}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#angle(Vector)}
   */
  @Test
  @DisplayName(
      "Test angle(Vector); given ten; when BlockVector length() return ten; then return '1.5707964'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Vector.angle(Vector)"})
  void testAngle_givenTen_whenBlockVectorLengthReturnTen_thenReturn15707964() {
    // Arrange
    Vector random = Vector.getRandom();

    BlockVector other = mock(BlockVector.class);
    when(other.length()).thenReturn(10.0d);

    // Act
    float actualAngleResult = random.angle(other);

    // Assert
    verify(other).length();
    assertEquals(1.5707964f, actualAngleResult);
  }

  /**
   * Test {@link Vector#midpoint(Vector)}.
   *
   * <p>Method under test: {@link Vector#midpoint(Vector)}
   */
  @Test
  @DisplayName("Test midpoint(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.midpoint(Vector)"})
  void testMidpoint() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualMidpointResult = random.midpoint(Vector.getRandom());

    // Assert
    assertSame(random, actualMidpointResult);
  }

  /**
   * Test {@link Vector#getMidpoint(Vector)}.
   *
   * <p>Method under test: {@link Vector#getMidpoint(Vector)}
   */
  @Test
  @DisplayName("Test getMidpoint(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.getMidpoint(Vector)"})
  void testGetMidpoint() {
    // Arrange and Act
    Vector actualMidpoint = Vector.getRandom().getMidpoint(Vector.getRandom());

    // Assert
    assertEquals(0, actualMidpoint.getBlockX());
    assertEquals(0, actualMidpoint.getBlockY());
    assertEquals(0, actualMidpoint.getBlockZ());
    assertFalse(actualMidpoint.isZero());
  }

  /**
   * Test {@link Vector#crossProduct(Vector)}.
   *
   * <p>Method under test: {@link Vector#crossProduct(Vector)}
   */
  @Test
  @DisplayName("Test crossProduct(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.crossProduct(Vector)"})
  void testCrossProduct() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualCrossProductResult = random.crossProduct(Vector.getRandom());

    // Assert
    assertSame(random, actualCrossProductResult);
  }

  /**
   * Test {@link Vector#getCrossProduct(Vector)}.
   *
   * <p>Method under test: {@link Vector#getCrossProduct(Vector)}
   */
  @Test
  @DisplayName("Test getCrossProduct(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.getCrossProduct(Vector)"})
  void testGetCrossProduct() {
    // Arrange and Act
    Vector actualCrossProduct = Vector.getRandom().getCrossProduct(Vector.getRandom());

    // Assert
    assertFalse(actualCrossProduct.isZero());
    BlockVector toBlockVectorResult = actualCrossProduct.toBlockVector();
    assertFalse(toBlockVectorResult.isZero());
    Vector3d toVector3dResult = actualCrossProduct.toVector3d();
    assertTrue(toVector3dResult.isFinite());
    Vector3f toVector3fResult = actualCrossProduct.toVector3f();
    assertTrue(toVector3fResult.isFinite());
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
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
    Vector3i toVector3iResult = actualCrossProduct.toVector3i();
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link Vector#normalize()}.
   *
   * <p>Method under test: {@link Vector#normalize()}
   */
  @Test
  @DisplayName("Test normalize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.normalize()"})
  void testNormalize() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualNormalizeResult = random.normalize();

    // Assert
    assertSame(random, actualNormalizeResult);
  }

  /**
   * Test {@link Vector#zero()}.
   *
   * <p>Method under test: {@link Vector#zero()}
   */
  @Test
  @DisplayName("Test zero()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.zero()"})
  void testZero() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualZeroResult = random.zero();

    // Assert
    assertEquals(0.0d, random.getX());
    assertEquals(0.0d, random.getY());
    assertEquals(0.0d, random.getZ());
    assertEquals(0.0d, random.length());
    assertTrue(random.isZero());
    assertSame(random, actualZeroResult);
  }

  /**
   * Test {@link Vector#isZero()}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isZero()}
   */
  @Test
  @DisplayName("Test isZero(); given Random; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isZero()"})
  void testIsZero_givenRandom_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Vector.getRandom().isZero());
  }

  /**
   * Test {@link Vector#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is three and z
   *       is zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isZero()}
   */
  @Test
  @DisplayName(
      "Test isZero(); given Vector(double, double, double) with x is zero and y is three and z is zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isZero()"})
  void testIsZero_givenVectorWithXIsZeroAndYIsThreeAndZIsZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vector(0.0d, 3.0d, 0.0d).isZero());
  }

  /**
   * Test {@link Vector#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isZero()}
   */
  @Test
  @DisplayName(
      "Test isZero(); given Vector(double, double, double) with x is zero and y is zero and z is ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isZero()"})
  void testIsZero_givenVectorWithXIsZeroAndYIsZeroAndZIsTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vector(0.0d, 0.0d, 10.0d).isZero());
  }

  /**
   * Test {@link Vector#isZero()}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isZero()}
   */
  @Test
  @DisplayName(
      "Test isZero(); given Vector(double, double, double) with x is zero and y is zero and z is zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isZero()"})
  void testIsZero_givenVectorWithXIsZeroAndYIsZeroAndZIsZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Vector(0.0d, 0.0d, 0.0d).isZero());
  }

  /**
   * Test {@link Vector#normalizeZeros()}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link Vector#normalizeZeros()}
   */
  @Test
  @DisplayName("Test normalizeZeros(); given Random; then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.normalizeZeros()"})
  void testNormalizeZeros_givenRandom_thenReturnRandom() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualNormalizeZerosResult = random.normalizeZeros();

    // Assert
    assertSame(random, actualNormalizeZerosResult);
  }

  /**
   * Test {@link Vector#normalizeZeros()}.
   *
   * <ul>
   *   <li>Then {@link Vector#Vector(double, double, double)} with x is {@code -0.0} and y is {@code
   *       -0.0} and z is {@code -0.0} X is zero.
   * </ul>
   *
   * <p>Method under test: {@link Vector#normalizeZeros()}
   */
  @Test
  @DisplayName(
      "Test normalizeZeros(); then Vector(double, double, double) with x is '-0.0' and y is '-0.0' and z is '-0.0' X is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.normalizeZeros()"})
  void testNormalizeZeros_thenVectorWithXIs00AndYIs00AndZIs00XIsZero() {
    // Arrange
    Vector vector = new Vector(-0.0d, -0.0d, -0.0d);

    // Act
    Vector actualNormalizeZerosResult = vector.normalizeZeros();

    // Assert
    assertEquals(0.0d, vector.getX());
    assertEquals(0.0d, vector.getY());
    assertEquals(0.0d, vector.getZ());
    assertSame(vector, actualNormalizeZerosResult);
  }

  /**
   * Test {@link Vector#isInAABB(Vector, Vector)}.
   *
   * <p>Method under test: {@link Vector#isInAABB(Vector, Vector)}
   */
  @Test
  @DisplayName("Test isInAABB(Vector, Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isInAABB(Vector, Vector)"})
  void testIsInAABB() {
    // Arrange
    BlockVector blockVector = new BlockVector(0.33514747104651643d, 3.0d, 0.9040783347623879d);
    Vector min = Vector.getRandom();

    // Act and Assert
    assertFalse(blockVector.isInAABB(min, new BlockVector(2.0d, 3.0d, 0.33514747104651643d)));
  }

  /**
   * Test {@link Vector#isInAABB(Vector, Vector)}.
   *
   * <ul>
   *   <li>Given {@code 0.9040783347623879}.
   *   <li>When Random Z is {@code 0.9040783347623879}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isInAABB(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test isInAABB(Vector, Vector); given '0.9040783347623879'; when Random Z is '0.9040783347623879'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isInAABB(Vector, Vector)"})
  void testIsInAABB_given09040783347623879_whenRandomZIs09040783347623879() {
    // Arrange
    Vector random = Vector.getRandom();

    Vector min = Vector.getRandom();
    min.setZ(0.9040783347623879d);

    // Act and Assert
    assertFalse(random.isInAABB(min, Vector.getRandom()));
  }

  /**
   * Test {@link Vector#isInAABB(Vector, Vector)}.
   *
   * <ul>
   *   <li>Given {@link BlockVector#BlockVector(double, double, double)} with x is two and y is
   *       three and z is {@code 0.9040783347623879}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isInAABB(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test isInAABB(Vector, Vector); given BlockVector(double, double, double) with x is two and y is three and z is '0.9040783347623879'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isInAABB(Vector, Vector)"})
  void testIsInAABB_givenBlockVectorWithXIsTwoAndYIsThreeAndZIs09040783347623879() {
    // Arrange, Act and Assert
    assertFalse(
        new BlockVector(2.0d, 3.0d, 0.9040783347623879d)
            .isInAABB(Vector.getRandom(), Vector.getRandom()));
  }

  /**
   * Test {@link Vector#isInAABB(Vector, Vector)}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>When Random.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isInAABB(Vector, Vector)}
   */
  @Test
  @DisplayName("Test isInAABB(Vector, Vector); given Random; when Random; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isInAABB(Vector, Vector)"})
  void testIsInAABB_givenRandom_whenRandom_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Vector.getRandom().isInAABB(Vector.getRandom(), Vector.getRandom()));
  }

  /**
   * Test {@link Vector#isInAABB(Vector, Vector)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When Random X is two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isInAABB(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test isInAABB(Vector, Vector); given two; when Random X is two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isInAABB(Vector, Vector)"})
  void testIsInAABB_givenTwo_whenRandomXIsTwo_thenReturnFalse() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 0.9040783347623879d);
    Vector min = Vector.getRandom();

    Vector max = Vector.getRandom();
    max.setX(2);

    // Act and Assert
    assertFalse(blockVector.isInAABB(min, max));
  }

  /**
   * Test {@link Vector#isInAABB(Vector, Vector)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is two and y is three
   *       and z is {@code 0.33514747104651643}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isInAABB(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test isInAABB(Vector, Vector); when BlockVector(double, double, double) with x is two and y is three and z is '0.33514747104651643'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isInAABB(Vector, Vector)"})
  void testIsInAABB_whenBlockVectorWithXIsTwoAndYIsThreeAndZIs033514747104651643() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 0.9040783347623879d);
    Vector min = Vector.getRandom();

    // Act and Assert
    assertFalse(blockVector.isInAABB(min, new BlockVector(2.0d, 3.0d, 0.33514747104651643d)));
  }

  /**
   * Test {@link Vector#isInSphere(Vector, double)}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isInSphere(Vector, double)}
   */
  @Test
  @DisplayName("Test isInSphere(Vector, double); given Random; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isInSphere(Vector, double)"})
  void testIsInSphere_givenRandom_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Vector.getRandom().isInSphere(Vector.getRandom(), 10.0d));
  }

  /**
   * Test {@link Vector#isInSphere(Vector, double)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isInSphere(Vector, double)}
   */
  @Test
  @DisplayName("Test isInSphere(Vector, double); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isInSphere(Vector, double)"})
  void testIsInSphere_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BlockVector(2.0d, 3.0d, 100.0d).isInSphere(Vector.getRandom(), 10.0d));
  }

  /**
   * Test {@link Vector#isNormalized()}.
   *
   * <ul>
   *   <li>Given {@link BlockVector#BlockVector()} Z is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isNormalized()}
   */
  @Test
  @DisplayName("Test isNormalized(); given BlockVector() Z is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isNormalized()"})
  void testIsNormalized_givenBlockVectorZIsOne_thenReturnTrue() {
    // Arrange
    BlockVector blockVector = new BlockVector();
    blockVector.setZ(1);

    // Act and Assert
    assertTrue(blockVector.isNormalized());
  }

  /**
   * Test {@link Vector#isNormalized()}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#isNormalized()}
   */
  @Test
  @DisplayName("Test isNormalized(); given Random; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.isNormalized()"})
  void testIsNormalized_givenRandom_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Vector.getRandom().isNormalized());
  }

  /**
   * Test {@link Vector#rotateAroundX(double)}.
   *
   * <p>Method under test: {@link Vector#rotateAroundX(double)}
   */
  @Test
  @DisplayName("Test rotateAroundX(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.rotateAroundX(double)"})
  void testRotateAroundX() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualRotateAroundXResult = random.rotateAroundX(10.0d);

    // Assert
    assertEquals(-1, random.getBlockY());
    assertSame(random, actualRotateAroundXResult);
  }

  /**
   * Test {@link Vector#rotateAroundY(double)}.
   *
   * <p>Method under test: {@link Vector#rotateAroundY(double)}
   */
  @Test
  @DisplayName("Test rotateAroundY(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.rotateAroundY(double)"})
  void testRotateAroundY() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualRotateAroundYResult = random.rotateAroundY(10.0d);

    // Assert
    assertSame(random, actualRotateAroundYResult);
  }

  /**
   * Test {@link Vector#rotateAroundZ(double)}.
   *
   * <p>Method under test: {@link Vector#rotateAroundZ(double)}
   */
  @Test
  @DisplayName("Test rotateAroundZ(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.rotateAroundZ(double)"})
  void testRotateAroundZ() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualRotateAroundZResult = random.rotateAroundZ(10.0d);

    // Assert
    assertSame(random, actualRotateAroundZResult);
  }

  /**
   * Test {@link Vector#rotateAroundAxis(Vector, double)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is two and y is three
   *       and z is one.
   * </ul>
   *
   * <p>Method under test: {@link Vector#rotateAroundAxis(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rotateAroundAxis(Vector, double); when BlockVector(double, double, double) with x is two and y is three and z is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.rotateAroundAxis(Vector, double)"})
  void testRotateAroundAxis_whenBlockVectorWithXIsTwoAndYIsThreeAndZIsOne()
      throws IllegalArgumentException {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualRotateAroundAxisResult =
        random.rotateAroundAxis(new BlockVector(2.0d, 3.0d, 1.0d), 10.0d);

    // Assert
    assertEquals(
        actualRotateAroundAxisResult.toBlockVector().toBlockVector(),
        actualRotateAroundAxisResult.toBlockVector().toBlockVector());
    Vector3d toVector3dResult = actualRotateAroundAxisResult.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = actualRotateAroundAxisResult.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i toVector3iResult = actualRotateAroundAxisResult.toVector3i();
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link Vector#rotateAroundAxis(Vector, double)}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return toBlockVector toBlockVector.
   * </ul>
   *
   * <p>Method under test: {@link Vector#rotateAroundAxis(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rotateAroundAxis(Vector, double); when Random; then return toBlockVector toBlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.rotateAroundAxis(Vector, double)"})
  void testRotateAroundAxis_whenRandom_thenReturnToBlockVectorToBlockVector()
      throws IllegalArgumentException {
    // Arrange and Act
    Vector actualRotateAroundAxisResult =
        Vector.getRandom().rotateAroundAxis(Vector.getRandom(), 10.0d);

    // Assert
    assertEquals(
        actualRotateAroundAxisResult.toBlockVector().toBlockVector(),
        actualRotateAroundAxisResult.toBlockVector().toBlockVector());
    Vector3d toVector3dResult = actualRotateAroundAxisResult.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = actualRotateAroundAxisResult.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i toVector3iResult = actualRotateAroundAxisResult.toVector3i();
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link Vector#rotateAroundNonUnitAxis(Vector, double)}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link Vector#rotateAroundNonUnitAxis(Vector, double)}
   */
  @Test
  @DisplayName("Test rotateAroundNonUnitAxis(Vector, double); when Random; then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.rotateAroundNonUnitAxis(Vector, double)"})
  void testRotateAroundNonUnitAxis_whenRandom_thenReturnRandom() throws IllegalArgumentException {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualRotateAroundNonUnitAxisResult =
        random.rotateAroundNonUnitAxis(Vector.getRandom(), 10.0d);

    // Assert
    assertSame(random, actualRotateAroundNonUnitAxisResult);
  }

  /**
   * Test {@link Vector#getBlockX()}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Vector#getBlockX()}
   */
  @Test
  @DisplayName("Test getBlockX(); given Random; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Vector.getBlockX()"})
  void testGetBlockX_givenRandom_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Vector.getRandom().getBlockX());
  }

  /**
   * Test {@link Vector#getBlockX()}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link Vector#getBlockX()}
   */
  @Test
  @DisplayName("Test getBlockX(); then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Vector.getBlockX()"})
  void testGetBlockX_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, new BlockVector(2.0d, 3.0d, 0.054675746296776184d).getBlockX());
  }

  /**
   * Test {@link Vector#getBlockY()}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Vector#getBlockY()}
   */
  @Test
  @DisplayName("Test getBlockY(); given Random; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Vector.getBlockY()"})
  void testGetBlockY_givenRandom_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Vector.getRandom().getBlockY());
  }

  /**
   * Test {@link Vector#getBlockY()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link Vector#getBlockY()}
   */
  @Test
  @DisplayName("Test getBlockY(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Vector.getBlockY()"})
  void testGetBlockY_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, new BlockVector(2.0d, 3.0d, 0.02321102040156664d).getBlockY());
  }

  /**
   * Test {@link Vector#getBlockZ()}.
   *
   * <ul>
   *   <li>Given {@link BlockVector#BlockVector()}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#getBlockZ()}
   */
  @Test
  @DisplayName("Test getBlockZ(); given BlockVector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Vector.getBlockZ()"})
  void testGetBlockZ_givenBlockVector() {
    // Arrange, Act and Assert
    assertEquals(0, new BlockVector().getBlockZ());
  }

  /**
   * Test {@link Vector#getBlockZ()}.
   *
   * <ul>
   *   <li>Given Random.
   * </ul>
   *
   * <p>Method under test: {@link Vector#getBlockZ()}
   */
  @Test
  @DisplayName("Test getBlockZ(); given Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Vector.getBlockZ()"})
  void testGetBlockZ_givenRandom() {
    // Arrange, Act and Assert
    assertEquals(0, Vector.getRandom().getBlockZ());
  }

  /**
   * Test {@link Vector#equals(Object)}, and {@link Vector#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Vector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.equals(Object)", "int Vector.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 1.0E-6d);
    BlockVector blockVector2 = new BlockVector(2.0d, 3.0d, 1.0E-6d);

    // Act and Assert
    assertEquals(blockVector, blockVector2);
    assertEquals(blockVector.hashCode(), blockVector2.hashCode());
  }

  /**
   * Test {@link Vector#equals(Object)}, and {@link Vector#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Vector#equals(Object)}
   *   <li>{@link Vector#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.equals(Object)", "int Vector.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act and Assert
    assertEquals(random, random);
    int expectedHashCodeResult = random.hashCode();
    assertEquals(expectedHashCodeResult, random.hashCode());
  }

  /**
   * Test {@link Vector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Vector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.equals(Object)", "int Vector.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Vector.getRandom(), Vector.getRandom());
  }

  /**
   * Test {@link Vector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Vector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.equals(Object)", "int Vector.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Vector vector = new Vector(2.0d, 3.0d, 1.0E-6d);

    // Act and Assert
    assertNotEquals(vector, new BlockVector(2.0d, 3.0d, 1.0E-6d));
  }

  /**
   * Test {@link Vector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Vector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.equals(Object)", "int Vector.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Vector vector = new Vector(2.0d, 1.0E-6d, 1.0E-6d);

    // Act and Assert
    assertNotEquals(vector, new BlockVector(2.0d, 3.0d, 1.0E-6d));
  }

  /**
   * Test {@link Vector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Vector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.equals(Object)", "int Vector.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Vector vector = new Vector(2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertNotEquals(vector, new BlockVector(2.0d, 3.0d, 1.0E-6d));
  }

  /**
   * Test {@link Vector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Vector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.equals(Object)", "int Vector.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Vector.getRandom(), null);
  }

  /**
   * Test {@link Vector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Vector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vector.equals(Object)", "int Vector.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Vector.getRandom(), "Different type to Vector");
  }

  /**
   * Test {@link Vector#clone()}.
   *
   * <ul>
   *   <li>Given {@link BlockVector#BlockVector(double, double, double)} with x is two and y is
   *       three and z is ten.
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); given BlockVector(double, double, double) with x is two and y is three and z is ten; then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.clone()"})
  void testClone_givenBlockVectorWithXIsTwoAndYIsThreeAndZIsTen_thenReturnBlockVector() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    BlockVector actualCloneResult = blockVector.clone();

    // Assert
    assertTrue(actualCloneResult instanceof BlockVector);
    assertEquals(blockVector, actualCloneResult);
  }

  /**
   * Test {@link Vector#clone()}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link Vector#clone()}
   */
  @Test
  @DisplayName("Test clone(); given Random; then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.clone()"})
  void testClone_givenRandom_thenReturnRandom() {
    // Arrange
    Vector random = Vector.getRandom();

    // Act
    Vector actualCloneResult = random.clone();

    // Assert
    assertEquals(random, actualCloneResult);
  }

  /**
   * Test {@link Vector#toLocation(World, float, float)} with {@code world}, {@code yaw}, {@code
   * pitch}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toLocation(World, float, float)}
   */
  @Test
  @DisplayName(
      "Test toLocation(World, float, float) with 'world', 'yaw', 'pitch'; when 'null'; then return World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Vector.toLocation(World, float, float)"})
  void testToLocationWithWorldYawPitch_whenNull_thenReturnWorldIsNull() {
    // Arrange and Act
    Location actualToLocationResult = Vector.getRandom().toLocation(null, 10.0f, 10.0f);

    // Assert
    assertNull(actualToLocationResult.getWorld());
    assertFalse(actualToLocationResult.isWorldLoaded());
    Vector direction = actualToLocationResult.getDirection();
    BlockVector toBlockVectorResult = direction.toBlockVector().toBlockVector();
    Vector toVectorResult = actualToLocationResult.toVector();
    assertEquals(toBlockVectorResult, toVectorResult.toBlockVector());
    assertEquals(toBlockVectorResult, toBlockVectorResult);
    Vector3d toVector3dResult = direction.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3f toVector3fResult = direction.toVector3f();
    Vector3f actualAbsoluteResult3 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult3);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult3 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult3);
    Vector3f toVector3fResult2 = toVectorResult.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult4);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult4);
    Vector3i toVector3iResult = direction.toVector3i();
    Vector3i actualAbsoluteResult5 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult5);
    Vector3i toVector3iResult2 = toVectorResult.toVector3i();
    Vector3i actualAbsoluteResult6 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult6);
  }

  /**
   * Test {@link Vector#toLocation(World, float, float)} with {@code world}, {@code yaw}, {@code
   * pitch}.
   *
   * <ul>
   *   <li>When {@link World}.
   *   <li>Then return Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toLocation(World, float, float)}
   */
  @Test
  @DisplayName(
      "Test toLocation(World, float, float) with 'world', 'yaw', 'pitch'; when World; then return Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Vector.toLocation(World, float, float)"})
  void testToLocationWithWorldYawPitch_whenWorld_thenReturnChunkIsNull() {
    // Arrange
    World world = mock(World.class);

    // Act
    Location actualToLocationResult = Vector.getRandom().toLocation(world, 10.0f, 10.0f);

    // Assert
    assertNull(actualToLocationResult.getChunk());
    assertNull(actualToLocationResult.getBlock());
    assertSame(world, actualToLocationResult.getWorld());
  }

  /**
   * Test {@link Vector#toLocation(World)} with {@code world}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toLocation(World)}
   */
  @Test
  @DisplayName("Test toLocation(World) with 'world'; when 'null'; then return World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Vector.toLocation(World)"})
  void testToLocationWithWorld_whenNull_thenReturnWorldIsNull() {
    // Arrange and Act
    Location actualToLocationResult = Vector.getRandom().toLocation(null);

    // Assert
    assertNull(actualToLocationResult.getWorld());
    assertFalse(actualToLocationResult.isWorldLoaded());
    Vector direction = actualToLocationResult.getDirection();
    BlockVector toBlockVectorResult = direction.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector toVectorResult = actualToLocationResult.toVector();
    BlockVector toBlockVectorResult2 = toVectorResult.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector3i toVector3iResult = direction.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = toVectorResult.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = direction.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3f toVector3fResult = direction.toVector3f();
    Vector3f actualAbsoluteResult3 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult3);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult3 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult3);
    Vector3f toVector3fResult2 = toVectorResult.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult4);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult4);
    Vector3i actualAbsoluteResult5 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult5);
    Vector3i actualAbsoluteResult6 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult6);
  }

  /**
   * Test {@link Vector#toLocation(World)} with {@code world}.
   *
   * <ul>
   *   <li>When {@link World}.
   *   <li>Then return toHighestLocation Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toLocation(World)}
   */
  @Test
  @DisplayName(
      "Test toLocation(World) with 'world'; when World; then return toHighestLocation Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Vector.toLocation(World)"})
  void testToLocationWithWorld_whenWorld_thenReturnToHighestLocationChunkIsNull() {
    // Arrange
    World world = mock(World.class);

    // Act
    Location actualToLocationResult = Vector.getRandom().toLocation(world);

    // Assert
    Location toHighestLocationResult = actualToLocationResult.toHighestLocation();
    assertNull(toHighestLocationResult.getChunk());
    assertNull(actualToLocationResult.getChunk());
    assertNull(toHighestLocationResult.getBlock());
    assertNull(actualToLocationResult.getBlock());
    assertEquals(0, toHighestLocationResult.getBlockX());
    assertEquals(0, toHighestLocationResult.getBlockY());
    assertEquals(0, toHighestLocationResult.getBlockZ());
    assertEquals(0.0d, toHighestLocationResult.getY());
    assertEquals(0.0d, toHighestLocationResult.y());
    assertEquals(0.0f, toHighestLocationResult.getPitch());
    assertEquals(0.0f, toHighestLocationResult.getYaw());
    assertEquals(0L, toHighestLocationResult.toBlockKey());
    assertFalse(toHighestLocationResult.isBlock());
    assertTrue(toHighestLocationResult.isFine());
    assertTrue(toHighestLocationResult.isFinite());
    assertEquals(
        toHighestLocationResult.toHighestLocation(), toHighestLocationResult.toHighestLocation());
    assertSame(world, toHighestLocationResult.getWorld());
    assertSame(world, actualToLocationResult.getWorld());
  }

  /**
   * Test {@link Vector#toBlockVector()}.
   *
   * <p>Method under test: {@link Vector#toBlockVector()}
   */
  @Test
  @DisplayName("Test toBlockVector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockVector Vector.toBlockVector()"})
  void testToBlockVector() {
    // Arrange and Act
    BlockVector actualToBlockVectorResult = Vector.getRandom().toBlockVector();

    // Assert
    assertEquals(0, actualToBlockVectorResult.getBlockX());
    assertEquals(0, actualToBlockVectorResult.getBlockY());
    assertEquals(0, actualToBlockVectorResult.getBlockZ());
    assertFalse(actualToBlockVectorResult.isZero());
  }

  /**
   * Test {@link Vector#toVector3f()}.
   *
   * <p>Method under test: {@link Vector#toVector3f()}
   */
  @Test
  @DisplayName("Test toVector3f()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3f Vector.toVector3f()"})
  void testToVector3f() {
    // Arrange and Act
    Vector3f actualToVector3fResult = Vector.getRandom().toVector3f();

    // Assert
    Vector3f actualAbsoluteResult = actualToVector3fResult.absolute();
    assertSame(actualToVector3fResult, actualAbsoluteResult);
    Vector3f actualCeilResult = actualToVector3fResult.ceil();
    assertSame(actualToVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = actualToVector3fResult.floor();
    assertSame(actualToVector3fResult, actualFloorResult);
    assertTrue(actualToVector3fResult.isFinite());
    Vector3f actualNormalizeResult = actualToVector3fResult.normalize();
    assertSame(actualToVector3fResult, actualNormalizeResult);
    assertEquals(0.57735026f, actualToVector3fResult.x());
    assertEquals(0.57735026f, actualToVector3fResult.y());
    assertEquals(0.57735026f, actualToVector3fResult.z());
  }

  /**
   * Test {@link Vector#toVector3d()}.
   *
   * <p>Method under test: {@link Vector#toVector3d()}
   */
  @Test
  @DisplayName("Test toVector3d()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3d Vector.toVector3d()"})
  void testToVector3d() {
    // Arrange and Act
    Vector3d actualToVector3dResult = Vector.getRandom().toVector3d();

    // Assert
    assertTrue(actualToVector3dResult.isFinite());
    Vector3d actualAbsoluteResult = actualToVector3dResult.absolute();
    assertSame(actualToVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = actualToVector3dResult.normalize();
    assertSame(actualToVector3dResult, actualNormalizeResult);
  }

  /**
   * Test {@link Vector#toVector3i()}.
   *
   * <p>Method under test: {@link Vector#toVector3i()}
   */
  @Test
  @DisplayName("Test toVector3i()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i()"})
  void testToVector3i() {
    // Arrange and Act
    Vector3i actualToVector3iResult = Vector.getRandom().toVector3i();

    // Assert
    assertEquals(0, actualToVector3iResult.x());
    assertEquals(0, actualToVector3iResult.y());
    assertEquals(0, actualToVector3iResult.z());
    assertEquals(0, actualToVector3iResult.x);
    assertEquals(0, actualToVector3iResult.y);
    assertEquals(0, actualToVector3iResult.z);
    assertEquals(0.0d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#toVector3i(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>When one.
   *   <li>Then return x is one.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toVector3i(int)}
   */
  @Test
  @DisplayName("Test toVector3i(int) with 'int'; given Random; when one; then return x is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i(int)"})
  void testToVector3iWithInt_givenRandom_whenOne_thenReturnXIsOne() {
    // Arrange and Act
    Vector3i actualToVector3iResult = Vector.getRandom().toVector3i(1);

    // Assert
    assertEquals(1, actualToVector3iResult.x());
    assertEquals(1, actualToVector3iResult.y());
    assertEquals(1, actualToVector3iResult.z());
    assertEquals(1, actualToVector3iResult.x);
    assertEquals(1, actualToVector3iResult.y);
    assertEquals(1, actualToVector3iResult.z);
    assertEquals(1.7320507764816284d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#toVector3i(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       {@code 1.0E-10}.
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toVector3i(int)}
   */
  @Test
  @DisplayName(
      "Test toVector3i(int) with 'int'; given Vector(double, double, double) with x is zero and y is zero and z is '1.0E-10'; when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i(int)"})
  void testToVector3iWithInt_givenVectorWithXIsZeroAndYIsZeroAndZIs10e10_whenFive() {
    // Arrange and Act
    Vector3i actualToVector3iResult = new Vector(0.0d, 0.0d, 1.0E-10d).toVector3i(5);

    // Assert
    assertEquals(0, actualToVector3iResult.x());
    assertEquals(0, actualToVector3iResult.y());
    assertEquals(0, actualToVector3iResult.z());
    assertEquals(0, actualToVector3iResult.x);
    assertEquals(0, actualToVector3iResult.y);
    assertEquals(0, actualToVector3iResult.z);
    assertEquals(0.0d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#toVector3i(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       {@code 1.0E-10}.
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toVector3i(int)}
   */
  @Test
  @DisplayName(
      "Test toVector3i(int) with 'int'; given Vector(double, double, double) with x is zero and y is zero and z is '1.0E-10'; when four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i(int)"})
  void testToVector3iWithInt_givenVectorWithXIsZeroAndYIsZeroAndZIs10e10_whenFour() {
    // Arrange and Act
    Vector3i actualToVector3iResult = new Vector(0.0d, 0.0d, 1.0E-10d).toVector3i(4);

    // Assert
    assertEquals(0, actualToVector3iResult.x());
    assertEquals(0, actualToVector3iResult.y());
    assertEquals(0, actualToVector3iResult.z());
    assertEquals(0, actualToVector3iResult.x);
    assertEquals(0, actualToVector3iResult.y);
    assertEquals(0, actualToVector3iResult.z);
    assertEquals(0.0d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#toVector3i(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       zero.
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toVector3i(int)}
   */
  @Test
  @DisplayName(
      "Test toVector3i(int) with 'int'; given Vector(double, double, double) with x is zero and y is zero and z is zero; when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i(int)"})
  void testToVector3iWithInt_givenVectorWithXIsZeroAndYIsZeroAndZIsZero_whenFive() {
    // Arrange and Act
    Vector3i actualToVector3iResult = new Vector(0.0d, 0.0d, 0.0d).toVector3i(5);

    // Assert
    assertEquals(0, actualToVector3iResult.x());
    assertEquals(0, actualToVector3iResult.y());
    assertEquals(0, actualToVector3iResult.z());
    assertEquals(0, actualToVector3iResult.x);
    assertEquals(0, actualToVector3iResult.y);
    assertEquals(0, actualToVector3iResult.z);
    assertEquals(0.0d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#toVector3i(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       zero.
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toVector3i(int)}
   */
  @Test
  @DisplayName(
      "Test toVector3i(int) with 'int'; given Vector(double, double, double) with x is zero and y is zero and z is zero; when four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i(int)"})
  void testToVector3iWithInt_givenVectorWithXIsZeroAndYIsZeroAndZIsZero_whenFour() {
    // Arrange and Act
    Vector3i actualToVector3iResult = new Vector(0.0d, 0.0d, 0.0d).toVector3i(4);

    // Assert
    assertEquals(0, actualToVector3iResult.x());
    assertEquals(0, actualToVector3iResult.y());
    assertEquals(0, actualToVector3iResult.z());
    assertEquals(0, actualToVector3iResult.x);
    assertEquals(0, actualToVector3iResult.y);
    assertEquals(0, actualToVector3iResult.z);
    assertEquals(0.0d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#toVector3i(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       zero.
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toVector3i(int)}
   */
  @Test
  @DisplayName(
      "Test toVector3i(int) with 'int'; given Vector(double, double, double) with x is zero and y is zero and z is zero; when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i(int)"})
  void testToVector3iWithInt_givenVectorWithXIsZeroAndYIsZeroAndZIsZero_whenThree() {
    // Arrange and Act
    Vector3i actualToVector3iResult = new Vector(0.0d, 0.0d, 0.0d).toVector3i(3);

    // Assert
    assertEquals(0, actualToVector3iResult.x());
    assertEquals(0, actualToVector3iResult.y());
    assertEquals(0, actualToVector3iResult.z());
    assertEquals(0, actualToVector3iResult.x);
    assertEquals(0, actualToVector3iResult.y);
    assertEquals(0, actualToVector3iResult.z);
    assertEquals(0.0d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#toVector3i(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       zero.
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toVector3i(int)}
   */
  @Test
  @DisplayName(
      "Test toVector3i(int) with 'int'; given Vector(double, double, double) with x is zero and y is zero and z is zero; when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i(int)"})
  void testToVector3iWithInt_givenVectorWithXIsZeroAndYIsZeroAndZIsZero_whenTwo() {
    // Arrange and Act
    Vector3i actualToVector3iResult = new Vector(0.0d, 0.0d, 0.0d).toVector3i(2);

    // Assert
    assertEquals(0, actualToVector3iResult.x());
    assertEquals(0, actualToVector3iResult.y());
    assertEquals(0, actualToVector3iResult.z());
    assertEquals(0, actualToVector3iResult.x);
    assertEquals(0, actualToVector3iResult.y);
    assertEquals(0, actualToVector3iResult.z);
    assertEquals(0.0d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#toVector3i(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link Vector#Vector(double, double, double)} with x is zero and y is zero and z is
   *       zero.
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link Vector#toVector3i(int)}
   */
  @Test
  @DisplayName(
      "Test toVector3i(int) with 'int'; given Vector(double, double, double) with x is zero and y is zero and z is zero; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3i Vector.toVector3i(int)"})
  void testToVector3iWithInt_givenVectorWithXIsZeroAndYIsZeroAndZIsZero_whenZero() {
    // Arrange and Act
    Vector3i actualToVector3iResult = new Vector(0.0d, 0.0d, 0.0d).toVector3i(0);

    // Assert
    assertEquals(0, actualToVector3iResult.x());
    assertEquals(0, actualToVector3iResult.y());
    assertEquals(0, actualToVector3iResult.z());
    assertEquals(0, actualToVector3iResult.x);
    assertEquals(0, actualToVector3iResult.y);
    assertEquals(0, actualToVector3iResult.z);
    assertEquals(0.0d, actualToVector3iResult.length());
    Vector3i actualAbsoluteResult = actualToVector3iResult.absolute();
    assertSame(actualToVector3iResult, actualAbsoluteResult);
  }

  /**
   * Test {@link Vector#getMinimum(Vector, Vector)}.
   *
   * <p>Method under test: {@link Vector#getMinimum(Vector, Vector)}
   */
  @Test
  @DisplayName("Test getMinimum(Vector, Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.getMinimum(Vector, Vector)"})
  void testGetMinimum() {
    // Arrange and Act
    Vector actualMinimum = Vector.getMinimum(Vector.getRandom(), Vector.getRandom());

    // Assert
    assertEquals(0, actualMinimum.getBlockX());
    assertEquals(0, actualMinimum.getBlockY());
    assertEquals(0, actualMinimum.getBlockZ());
    assertFalse(actualMinimum.isZero());
  }

  /**
   * Test {@link Vector#getRandom()}.
   *
   * <p>Method under test: {@link Vector#getRandom()}
   */
  @Test
  @DisplayName("Test getRandom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.getRandom()"})
  void testGetRandom() {
    // Arrange and Act
    Vector actualRandom = Vector.getRandom();

    // Assert
    assertEquals(0, actualRandom.getBlockX());
    assertEquals(0, actualRandom.getBlockY());
    assertEquals(0, actualRandom.getBlockZ());
    assertFalse(actualRandom.isZero());
  }

  /**
   * Test {@link Vector#fromJOML(Vector3d)} with {@code Vector3d}.
   *
   * <p>Method under test: {@link Vector#fromJOML(Vector3d)}
   */
  @Test
  @DisplayName("Test fromJOML(Vector3d) with 'Vector3d'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.fromJOML(Vector3d)"})
  void testFromJOMLWithVector3d() {
    // Arrange and Act
    Vector actualFromJOMLResult = Vector.fromJOML(new Vector3d(10.0d));

    // Assert
    assertEquals(10.0d, actualFromJOMLResult.getX());
    assertEquals(10.0d, actualFromJOMLResult.getY());
    assertEquals(10.0d, actualFromJOMLResult.getZ());
    assertEquals(17.320508075688775d, actualFromJOMLResult.length());
    assertFalse(actualFromJOMLResult.isZero());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockX());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockY());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockZ());
  }

  /**
   * Test {@link Vector#fromJOML(Vector3dc)} with {@code Vector3dc}.
   *
   * <p>Method under test: {@link Vector#fromJOML(Vector3dc)}
   */
  @Test
  @DisplayName("Test fromJOML(Vector3dc) with 'Vector3dc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.fromJOML(Vector3dc)"})
  void testFromJOMLWithVector3dc() {
    // Arrange and Act
    Vector actualFromJOMLResult = Vector.fromJOML((Vector3dc) new Vector3d(10.0d));

    // Assert
    assertEquals(10.0d, actualFromJOMLResult.getX());
    assertEquals(10.0d, actualFromJOMLResult.getY());
    assertEquals(10.0d, actualFromJOMLResult.getZ());
    assertEquals(17.320508075688775d, actualFromJOMLResult.length());
    assertFalse(actualFromJOMLResult.isZero());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockX());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockY());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockZ());
  }

  /**
   * Test {@link Vector#fromJOML(Vector3f)} with {@code Vector3f}.
   *
   * <p>Method under test: {@link Vector#fromJOML(Vector3f)}
   */
  @Test
  @DisplayName("Test fromJOML(Vector3f) with 'Vector3f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.fromJOML(Vector3f)"})
  void testFromJOMLWithVector3f() {
    // Arrange and Act
    Vector actualFromJOMLResult = Vector.fromJOML(new Vector3f(10.0f));

    // Assert
    assertEquals(10.0d, actualFromJOMLResult.getX());
    assertEquals(10.0d, actualFromJOMLResult.getY());
    assertEquals(10.0d, actualFromJOMLResult.getZ());
    assertEquals(17.320508075688775d, actualFromJOMLResult.length());
    assertFalse(actualFromJOMLResult.isZero());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockX());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockY());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockZ());
  }

  /**
   * Test {@link Vector#fromJOML(Vector3fc)} with {@code Vector3fc}.
   *
   * <p>Method under test: {@link Vector#fromJOML(Vector3fc)}
   */
  @Test
  @DisplayName("Test fromJOML(Vector3fc) with 'Vector3fc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.fromJOML(Vector3fc)"})
  void testFromJOMLWithVector3fc() {
    // Arrange and Act
    Vector actualFromJOMLResult = Vector.fromJOML((Vector3fc) new Vector3f(10.0f));

    // Assert
    assertEquals(10.0d, actualFromJOMLResult.getX());
    assertEquals(10.0d, actualFromJOMLResult.getY());
    assertEquals(10.0d, actualFromJOMLResult.getZ());
    assertEquals(17.320508075688775d, actualFromJOMLResult.length());
    assertFalse(actualFromJOMLResult.isZero());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockX());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockY());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualFromJOMLResult.getBlockZ());
  }

  /**
   * Test {@link Vector#fromJOML(Vector3i)} with {@code Vector3i}.
   *
   * <p>Method under test: {@link Vector#fromJOML(Vector3i)}
   */
  @Test
  @DisplayName("Test fromJOML(Vector3i) with 'Vector3i'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.fromJOML(Vector3i)"})
  void testFromJOMLWithVector3i() {
    // Arrange
    Vector3i vector = new Vector3i(1);

    // Act
    Vector actualFromJOMLResult = Vector.fromJOML(vector);

    // Assert
    assertEquals(1, actualFromJOMLResult.getBlockX());
    assertEquals(1, actualFromJOMLResult.getBlockY());
    assertEquals(1, actualFromJOMLResult.getBlockZ());
    assertEquals(1.0d, actualFromJOMLResult.getX());
    assertEquals(1.0d, actualFromJOMLResult.getY());
    assertEquals(1.0d, actualFromJOMLResult.getZ());
    assertEquals(1.7320508075688772d, actualFromJOMLResult.length());
    assertFalse(actualFromJOMLResult.isZero());
    assertEquals(vector, actualFromJOMLResult.toVector3i());
  }

  /**
   * Test {@link Vector#fromJOML(Vector3ic)} with {@code Vector3ic}.
   *
   * <p>Method under test: {@link Vector#fromJOML(Vector3ic)}
   */
  @Test
  @DisplayName("Test fromJOML(Vector3ic) with 'Vector3ic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.fromJOML(Vector3ic)"})
  void testFromJOMLWithVector3ic() {
    // Arrange
    Vector3i vector = new Vector3i(1);

    // Act
    Vector actualFromJOMLResult = Vector.fromJOML((Vector3ic) vector);

    // Assert
    assertEquals(1, actualFromJOMLResult.getBlockX());
    assertEquals(1, actualFromJOMLResult.getBlockY());
    assertEquals(1, actualFromJOMLResult.getBlockZ());
    assertEquals(1.0d, actualFromJOMLResult.getX());
    assertEquals(1.0d, actualFromJOMLResult.getY());
    assertEquals(1.0d, actualFromJOMLResult.getZ());
    assertEquals(1.7320508075688772d, actualFromJOMLResult.length());
    assertFalse(actualFromJOMLResult.isZero());
    assertEquals(vector, actualFromJOMLResult.toVector3i());
  }

  /**
   * Test {@link Vector#serialize()}.
   *
   * <p>Method under test: {@link Vector#serialize()}
   */
  @Test
  @DisplayName("Test serialize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Vector.serialize()"})
  void testSerialize() {
    // Arrange and Act
    Map<String, Object> actualSerializeResult = Vector.getRandom().serialize();

    // Assert
    assertEquals(3, actualSerializeResult.size());
    assertTrue(actualSerializeResult.containsKey("x"));
    assertTrue(actualSerializeResult.containsKey("y"));
    assertTrue(actualSerializeResult.containsKey("z"));
  }

  /**
   * Test {@link Vector#deserialize(Map)}.
   *
   * <p>Method under test: {@link Vector#deserialize(Map)}
   */
  @Test
  @DisplayName("Test deserialize(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Vector.deserialize(Map)"})
  void testDeserialize() {
    // Arrange and Act
    Vector actualDeserializeResult = Vector.deserialize(new HashMap<>());

    // Assert
    assertEquals(0, actualDeserializeResult.getBlockX());
    assertEquals(0, actualDeserializeResult.getBlockY());
    assertEquals(0, actualDeserializeResult.getBlockZ());
    assertEquals(0.0d, actualDeserializeResult.getX());
    assertEquals(0.0d, actualDeserializeResult.getY());
    assertEquals(0.0d, actualDeserializeResult.getZ());
    assertEquals(0.0d, actualDeserializeResult.length());
    assertTrue(actualDeserializeResult.isZero());
  }
}
