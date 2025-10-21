package com.mojang.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TransformationDiffblueTest {
  /**
   * Test {@link Transformation#Transformation(Matrix4fc)}.
   *
   * <ul>
   *   <li>When {@link Matrix4f#Matrix4f()}.
   *   <li>Then return Matrix is {@link Matrix4f#Matrix4f()}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Matrix4fc)}
   */
  @Test
  @DisplayName(
      "Test new Transformation(Matrix4fc); when Matrix4f(); then return Matrix is Matrix4f()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Matrix4fc)"})
  void testNewTransformation_whenMatrix4f_thenReturnMatrixIsMatrix4f() {
    // Arrange
    Matrix4f matrix = new Matrix4f();

    // Act and Assert
    Matrix4fc matrix2 = new Transformation(matrix).getMatrix();
    assertTrue(matrix2 instanceof Matrix4f);
    assertSame(matrix, matrix2);
  }

  /**
   * Test {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f,
   * Quaternionf)}
   */
  @Test
  @DisplayName("Test new Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, Quaternionf, Vector3f, Quaternionf)"})
  void testNewTransformation_whenNull() {
    // Arrange
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Transformation actualTransformation =
        new Transformation(null, leftRotation, Mth.X_AXIS, rightRotation);

    // Assert
    Matrix4fc matrix = actualTransformation.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualTransformation.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f,
   * Quaternionf)}
   */
  @Test
  @DisplayName("Test new Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, Quaternionf, Vector3f, Quaternionf)"})
  void testNewTransformation_whenNull2() {
    // Arrange
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Transformation actualTransformation =
        new Transformation(Mth.X_AXIS, null, Mth.X_AXIS, rightRotation);

    // Assert
    Matrix4fc matrix = actualTransformation.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualTransformation.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f,
   * Quaternionf)}
   */
  @Test
  @DisplayName("Test new Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, Quaternionf, Vector3f, Quaternionf)"})
  void testNewTransformation_whenNull3() {
    // Arrange
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Transformation actualTransformation =
        new Transformation(Mth.X_AXIS, leftRotation, null, rightRotation);

    // Assert
    Matrix4fc matrix = actualTransformation.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualTransformation.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f,
   * Quaternionf)}
   */
  @Test
  @DisplayName("Test new Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, Quaternionf, Vector3f, Quaternionf)"})
  void testNewTransformation_whenNull4() {
    // Arrange
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Transformation actualTransformation =
        new Transformation(Mth.X_AXIS, leftRotation, Mth.X_AXIS, null);

    // Assert
    Matrix4fc matrix = actualTransformation.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualTransformation.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f,
   * Quaternionf)}
   */
  @Test
  @DisplayName("Test new Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, Quaternionf, Vector3f, Quaternionf)"})
  void testNewTransformation_whenNull5() {
    // Arrange
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Transformation actualTransformation = new Transformation(null, null, Mth.X_AXIS, rightRotation);

    // Assert
    Matrix4fc matrix = actualTransformation.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualTransformation.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#Transformation(Matrix4fc)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return MatrixCopy is Matrix.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Matrix4fc)}
   */
  @Test
  @DisplayName("Test new Transformation(Matrix4fc); when 'null'; then return MatrixCopy is Matrix")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Matrix4fc)"})
  void testNewTransformation_whenNull_thenReturnMatrixCopyIsMatrix() {
    // Arrange and Act
    Transformation actualTransformation = new Transformation(null);

    // Assert
    Matrix4fc matrix = actualTransformation.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualTransformation.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf)}.
   *
   * <ul>
   *   <li>When {@link Quaternionf#Quaternionf(double, double, double, double)} with x is two and y
   *       is three and z is ten and w is ten.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f,
   * Quaternionf)}
   */
  @Test
  @DisplayName(
      "Test new Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf); when Quaternionf(double, double, double, double) with x is two and y is three and z is ten and w is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, Quaternionf, Vector3f, Quaternionf)"})
  void testNewTransformation_whenQuaternionfWithXIsTwoAndYIsThreeAndZIsTenAndWIsTen() {
    // Arrange
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Transformation actualTransformation =
        new Transformation(Mth.X_AXIS, leftRotation, Mth.X_AXIS, rightRotation);

    // Assert
    Matrix4fc matrix = actualTransformation.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualTransformation.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#identity()}.
   *
   * <p>Method under test: {@link Transformation#identity()}
   */
  @Test
  @DisplayName("Test identity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.identity()"})
  void testIdentity() {
    // Arrange and Act
    Transformation actualIdentityResult = Transformation.identity();

    // Assert
    Matrix4fc matrix = actualIdentityResult.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualIdentityResult.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#compose(Transformation)} with {@code other}.
   *
   * <p>Method under test: {@link Transformation#compose(Transformation)}
   */
  @Test
  @DisplayName("Test compose(Transformation) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.compose(Transformation)"})
  void testComposeWithOther() {
    // Arrange
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    Transformation transformation =
        new Transformation(Mth.X_AXIS, leftRotation, Mth.X_AXIS, rightRotation);

    // Act
    Transformation actualComposeResult = transformation.compose(Transformation.identity());

    // Assert
    assertEquals(transformation, actualComposeResult);
  }

  /**
   * Test {@link Transformation#compose(Transformation)} with {@code other}.
   *
   * <ul>
   *   <li>Given identity.
   *   <li>When identity.
   *   <li>Then return identity.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#compose(Transformation)}
   */
  @Test
  @DisplayName(
      "Test compose(Transformation) with 'other'; given identity; when identity; then return identity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.compose(Transformation)"})
  void testComposeWithOther_givenIdentity_whenIdentity_thenReturnIdentity() {
    // Arrange
    Transformation identityResult = Transformation.identity();
    Transformation other = Transformation.identity();

    // Act
    Transformation actualComposeResult = identityResult.compose(other);

    // Assert
    assertEquals(other, actualComposeResult);
  }

  /**
   * Test {@link Transformation#compose(Transformation)} with {@code other}.
   *
   * <ul>
   *   <li>Then Matrix return {@link Matrix4f}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#compose(Transformation)}
   */
  @Test
  @DisplayName("Test compose(Transformation) with 'other'; then Matrix return Matrix4f")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.compose(Transformation)"})
  void testComposeWithOther_thenMatrixReturnMatrix4f() {
    // Arrange
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    Transformation transformation =
        new Transformation(Mth.X_AXIS, leftRotation, Mth.X_AXIS, rightRotation);
    Quaternionf leftRotation2 = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Quaternionf rightRotation2 = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    Transformation other =
        new Transformation(Mth.X_AXIS, leftRotation2, Mth.X_AXIS, rightRotation2);

    // Act
    Transformation actualComposeResult = transformation.compose(other);

    // Assert
    Matrix4fc matrix = actualComposeResult.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualComposeResult.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#inverse()}.
   *
   * <p>Method under test: {@link Transformation#inverse()}
   */
  @Test
  @DisplayName("Test inverse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.inverse()"})
  void testInverse() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
            10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertNull(new Transformation(matrix).inverse());
  }

  /**
   * Test {@link Transformation#inverse()}.
   *
   * <p>Method under test: {@link Transformation#inverse()}
   */
  @Test
  @DisplayName("Test inverse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.inverse()"})
  void testInverse2() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
            Float.NaN, 10.0f, 10.0f, 10.0f);
    matrix.add(new Matrix4f());

    // Act and Assert
    assertNull(new Transformation(matrix).inverse());
  }

  /**
   * Test {@link Transformation#inverse()}.
   *
   * <ul>
   *   <li>Given identity.
   *   <li>Then return identity.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#inverse()}
   */
  @Test
  @DisplayName("Test inverse(); given identity; then return identity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.inverse()"})
  void testInverse_givenIdentity_thenReturnIdentity() {
    // Arrange
    Transformation identityResult = Transformation.identity();

    // Act
    Transformation actualInverseResult = identityResult.inverse();

    // Assert
    assertSame(identityResult, actualInverseResult);
  }

  /**
   * Test {@link Transformation#inverse()}.
   *
   * <ul>
   *   <li>Then return {@link Transformation#Transformation(Matrix4fc)} with matrix is {@link
   *       Matrix4f#Matrix4f()}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#inverse()}
   */
  @Test
  @DisplayName("Test inverse(); then return Transformation(Matrix4fc) with matrix is Matrix4f()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.inverse()"})
  void testInverse_thenReturnTransformationWithMatrixIsMatrix4f() {
    // Arrange
    Transformation transformation = new Transformation(new Matrix4f());

    // Act
    Transformation actualInverseResult = transformation.inverse();

    // Assert
    assertEquals(transformation, actualInverseResult);
  }

  /**
   * Test {@link Transformation#getMatrix()}.
   *
   * <p>Method under test: {@link Transformation#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix4fc Transformation.getMatrix()"})
  void testGetMatrix() {
    // Arrange, Act and Assert
    assertTrue(Transformation.identity().getMatrix() instanceof Matrix4f);
  }

  /**
   * Test {@link Transformation#getTranslation()}.
   *
   * <p>Method under test: {@link Transformation#getTranslation()}
   */
  @Test
  @DisplayName("Test getTranslation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3f Transformation.getTranslation()"})
  void testGetTranslation() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
            1.0f, 1.0f);

    // Act
    Vector3f actualTranslation = new Transformation(matrix).getTranslation();

    // Assert
    Vector3f actualAbsoluteResult = actualTranslation.absolute();
    assertSame(actualTranslation, actualAbsoluteResult);
    Vector3f actualCeilResult = actualTranslation.ceil();
    assertSame(actualTranslation, actualCeilResult);
    Vector3f actualFloorResult = actualTranslation.floor();
    assertSame(actualTranslation, actualFloorResult);
    Vector3f actualNormalizeResult = actualTranslation.normalize();
    assertSame(actualTranslation, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getTranslation()}.
   *
   * <p>Method under test: {@link Transformation#getTranslation()}
   */
  @Test
  @DisplayName("Test getTranslation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3f Transformation.getTranslation()"})
  void testGetTranslation2() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            Constants.EPSILON,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f);

    // Act
    Vector3f actualTranslation = new Transformation(matrix).getTranslation();

    // Assert
    Vector3f actualAbsoluteResult = actualTranslation.absolute();
    assertSame(actualTranslation, actualAbsoluteResult);
    Vector3f actualCeilResult = actualTranslation.ceil();
    assertSame(actualTranslation, actualCeilResult);
    Vector3f actualFloorResult = actualTranslation.floor();
    assertSame(actualTranslation, actualFloorResult);
    Vector3f actualNormalizeResult = actualTranslation.normalize();
    assertSame(actualTranslation, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getTranslation()}.
   *
   * <ul>
   *   <li>Given identity.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getTranslation()}
   */
  @Test
  @DisplayName("Test getTranslation(); given identity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3f Transformation.getTranslation()"})
  void testGetTranslation_givenIdentity() {
    // Arrange and Act
    Vector3f actualTranslation = Transformation.identity().getTranslation();

    // Assert
    Vector3f actualAbsoluteResult = actualTranslation.absolute();
    assertSame(actualTranslation, actualAbsoluteResult);
    Vector3f actualCeilResult = actualTranslation.ceil();
    assertSame(actualTranslation, actualCeilResult);
    Vector3f actualFloorResult = actualTranslation.floor();
    assertSame(actualTranslation, actualFloorResult);
    Vector3f actualNormalizeResult = actualTranslation.normalize();
    assertSame(actualTranslation, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getTranslation()}.
   *
   * <ul>
   *   <li>Given {@link Transformation#Transformation(Matrix4fc)} with matrix is {@link
   *       Matrix4f#Matrix4f()}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getTranslation()}
   */
  @Test
  @DisplayName("Test getTranslation(); given Transformation(Matrix4fc) with matrix is Matrix4f()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3f Transformation.getTranslation()"})
  void testGetTranslation_givenTransformationWithMatrixIsMatrix4f() {
    // Arrange and Act
    Vector3f actualTranslation = new Transformation(new Matrix4f()).getTranslation();

    // Assert
    Vector3f actualAbsoluteResult = actualTranslation.absolute();
    assertSame(actualTranslation, actualAbsoluteResult);
    Vector3f actualCeilResult = actualTranslation.ceil();
    assertSame(actualTranslation, actualCeilResult);
    Vector3f actualFloorResult = actualTranslation.floor();
    assertSame(actualTranslation, actualFloorResult);
    Vector3f actualNormalizeResult = actualTranslation.normalize();
    assertSame(actualTranslation, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getLeftRotation()}.
   *
   * <ul>
   *   <li>Given identity.
   *   <li>Then return x is zero.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getLeftRotation()}
   */
  @Test
  @DisplayName("Test getLeftRotation(); given identity; then return x is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf Transformation.getLeftRotation()"})
  void testGetLeftRotation_givenIdentity_thenReturnXIsZero() {
    // Arrange and Act
    Quaternionf actualLeftRotation = Transformation.identity().getLeftRotation();

    // Assert
    assertEquals(0.0f, actualLeftRotation.x());
    assertEquals(0.0f, actualLeftRotation.y());
    assertEquals(0.0f, actualLeftRotation.z());
    assertEquals(0.0f, actualLeftRotation.x);
    assertEquals(0.0f, actualLeftRotation.y);
    assertEquals(0.0f, actualLeftRotation.z);
    assertEquals(1.0f, actualLeftRotation.w());
    assertEquals(1.0f, actualLeftRotation.w);
    Quaternionf actualConjugateResult = actualLeftRotation.conjugate();
    assertSame(actualLeftRotation, actualConjugateResult);
    Quaternionf actualInvertResult = actualLeftRotation.invert();
    assertSame(actualLeftRotation, actualInvertResult);
    Quaternionf actualNormalizeResult = actualLeftRotation.normalize();
    assertSame(actualLeftRotation, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getLeftRotation()}.
   *
   * <ul>
   *   <li>Given {@link Transformation#Transformation(Matrix4fc)} with matrix is {@link
   *       Matrix4f#Matrix4f()}.
   *   <li>Then return x is zero.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getLeftRotation()}
   */
  @Test
  @DisplayName(
      "Test getLeftRotation(); given Transformation(Matrix4fc) with matrix is Matrix4f(); then return x is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf Transformation.getLeftRotation()"})
  void testGetLeftRotation_givenTransformationWithMatrixIsMatrix4f_thenReturnXIsZero() {
    // Arrange and Act
    Quaternionf actualLeftRotation = new Transformation(new Matrix4f()).getLeftRotation();

    // Assert
    assertEquals(0.0f, actualLeftRotation.x());
    assertEquals(0.0f, actualLeftRotation.y());
    assertEquals(0.0f, actualLeftRotation.z());
    assertEquals(0.0f, actualLeftRotation.x);
    assertEquals(0.0f, actualLeftRotation.y);
    assertEquals(0.0f, actualLeftRotation.z);
    assertEquals(1.0f, actualLeftRotation.w());
    assertEquals(1.0f, actualLeftRotation.w);
    Quaternionf actualConjugateResult = actualLeftRotation.conjugate();
    assertSame(actualLeftRotation, actualConjugateResult);
    Quaternionf actualInvertResult = actualLeftRotation.invert();
    assertSame(actualLeftRotation, actualInvertResult);
    Quaternionf actualNormalizeResult = actualLeftRotation.normalize();
    assertSame(actualLeftRotation, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getLeftRotation()}.
   *
   * <ul>
   *   <li>Then return w is {@code -0.11591689}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getLeftRotation()}
   */
  @Test
  @DisplayName("Test getLeftRotation(); then return w is '-0.11591689'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf Transformation.getLeftRotation()"})
  void testGetLeftRotation_thenReturnWIs011591689() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
            1.0f, 1.0f);
    Transformation transformation = new Transformation(matrix);

    // Act
    Quaternionf actualLeftRotation = transformation.getLeftRotation();

    // Assert
    Quaternionf actualConjugateResult = actualLeftRotation.conjugate();
    assertSame(actualLeftRotation, actualConjugateResult);
    Quaternionf actualInvertResult = actualLeftRotation.invert();
    assertSame(actualLeftRotation, actualInvertResult);
    Quaternionf actualNormalizeResult = actualLeftRotation.normalize();
    assertSame(actualLeftRotation, actualNormalizeResult);
    assertEquals(-0.11591689f, actualLeftRotation.w());
    assertEquals(0.8804763f, actualLeftRotation.x());
    assertEquals(0.36470523f, actualLeftRotation.y());
    assertEquals(0.27984813f, actualLeftRotation.z());
    Quaternionf rightRotation = transformation.getRightRotation();
    assertEquals(0.88047624f, rightRotation.w);
    assertEquals(-0.11591697f, rightRotation.x);
    assertEquals(0.27984828f, rightRotation.y);
    assertEquals(-0.3647052f, rightRotation.z);
    assertEquals(0.88047624f, rightRotation.w());
    assertEquals(-0.11591697f, rightRotation.x());
    assertEquals(0.27984828f, rightRotation.y());
    assertEquals(-0.3647052f, rightRotation.z());
  }

  /**
   * Test {@link Transformation#getLeftRotation()}.
   *
   * <ul>
   *   <li>Then return w is {@code -0.32693142}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getLeftRotation()}
   */
  @Test
  @DisplayName("Test getLeftRotation(); then return w is '-0.32693142'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf Transformation.getLeftRotation()"})
  void testGetLeftRotation_thenReturnWIs032693142() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            Constants.EPSILON,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f);
    Transformation transformation = new Transformation(matrix);

    // Act
    Quaternionf actualLeftRotation = transformation.getLeftRotation();

    // Assert
    Quaternionf actualConjugateResult = actualLeftRotation.conjugate();
    assertSame(actualLeftRotation, actualConjugateResult);
    Quaternionf actualInvertResult = actualLeftRotation.invert();
    assertSame(actualLeftRotation, actualInvertResult);
    Quaternionf actualNormalizeResult = actualLeftRotation.normalize();
    assertSame(actualLeftRotation, actualNormalizeResult);
    assertEquals(-0.32693142f, actualLeftRotation.w());
    assertEquals(0.7892822f, actualLeftRotation.x());
    assertEquals(0.4801948f, actualLeftRotation.y());
    assertEquals(0.1989032f, actualLeftRotation.z());
    Quaternionf rightRotation = transformation.getRightRotation();
    assertEquals(0.78927726f, rightRotation.w);
    assertEquals(-0.32694343f, rightRotation.x);
    assertEquals(0.19889592f, rightRotation.y);
    assertEquals(-0.4801978f, rightRotation.z);
    assertEquals(0.78927726f, rightRotation.w());
    assertEquals(-0.32694343f, rightRotation.x());
    assertEquals(0.19889592f, rightRotation.y());
    assertEquals(-0.4801978f, rightRotation.z());
  }

  /**
   * Test {@link Transformation#getScale()}.
   *
   * <p>Method under test: {@link Transformation#getScale()}
   */
  @Test
  @DisplayName("Test getScale()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3f Transformation.getScale()"})
  void testGetScale() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            Constants.EPSILON,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f);

    // Act
    Vector3f actualScale = new Transformation(matrix).getScale();

    // Assert
    Vector3f actualAbsoluteResult = actualScale.absolute();
    assertSame(actualScale, actualAbsoluteResult);
    Vector3f actualCeilResult = actualScale.ceil();
    assertSame(actualScale, actualCeilResult);
    Vector3f actualFloorResult = actualScale.floor();
    assertSame(actualScale, actualFloorResult);
    Vector3f actualNormalizeResult = actualScale.normalize();
    assertSame(actualScale, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getScale()}.
   *
   * <ul>
   *   <li>Given identity.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getScale()}
   */
  @Test
  @DisplayName("Test getScale(); given identity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3f Transformation.getScale()"})
  void testGetScale_givenIdentity() {
    // Arrange and Act
    Vector3f actualScale = Transformation.identity().getScale();

    // Assert
    Vector3f actualAbsoluteResult = actualScale.absolute();
    assertSame(actualScale, actualAbsoluteResult);
    Vector3f actualCeilResult = actualScale.ceil();
    assertSame(actualScale, actualCeilResult);
    Vector3f actualFloorResult = actualScale.floor();
    assertSame(actualScale, actualFloorResult);
    Vector3f actualNormalizeResult = actualScale.normalize();
    assertSame(actualScale, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getScale()}.
   *
   * <ul>
   *   <li>Given {@link Transformation#Transformation(Matrix4fc)} with matrix is {@link
   *       Matrix4f#Matrix4f()}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getScale()}
   */
  @Test
  @DisplayName("Test getScale(); given Transformation(Matrix4fc) with matrix is Matrix4f()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector3f Transformation.getScale()"})
  void testGetScale_givenTransformationWithMatrixIsMatrix4f() {
    // Arrange and Act
    Vector3f actualScale = new Transformation(new Matrix4f()).getScale();

    // Assert
    Vector3f actualAbsoluteResult = actualScale.absolute();
    assertSame(actualScale, actualAbsoluteResult);
    Vector3f actualCeilResult = actualScale.ceil();
    assertSame(actualScale, actualCeilResult);
    Vector3f actualFloorResult = actualScale.floor();
    assertSame(actualScale, actualFloorResult);
    Vector3f actualNormalizeResult = actualScale.normalize();
    assertSame(actualScale, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getRightRotation()}.
   *
   * <ul>
   *   <li>Given identity.
   *   <li>Then return x is zero.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getRightRotation()}
   */
  @Test
  @DisplayName("Test getRightRotation(); given identity; then return x is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf Transformation.getRightRotation()"})
  void testGetRightRotation_givenIdentity_thenReturnXIsZero() {
    // Arrange and Act
    Quaternionf actualRightRotation = Transformation.identity().getRightRotation();

    // Assert
    assertEquals(0.0f, actualRightRotation.x());
    assertEquals(0.0f, actualRightRotation.y());
    assertEquals(0.0f, actualRightRotation.z());
    assertEquals(0.0f, actualRightRotation.x);
    assertEquals(0.0f, actualRightRotation.y);
    assertEquals(0.0f, actualRightRotation.z);
    Quaternionf actualConjugateResult = actualRightRotation.conjugate();
    assertSame(actualRightRotation, actualConjugateResult);
    Quaternionf actualInvertResult = actualRightRotation.invert();
    assertSame(actualRightRotation, actualInvertResult);
    Quaternionf actualNormalizeResult = actualRightRotation.normalize();
    assertSame(actualRightRotation, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getRightRotation()}.
   *
   * <ul>
   *   <li>Given {@link Transformation#Transformation(Matrix4fc)} with matrix is {@link
   *       Matrix4f#Matrix4f()}.
   *   <li>Then return x is {@code -0.0}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getRightRotation()}
   */
  @Test
  @DisplayName(
      "Test getRightRotation(); given Transformation(Matrix4fc) with matrix is Matrix4f(); then return x is '-0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf Transformation.getRightRotation()"})
  void testGetRightRotation_givenTransformationWithMatrixIsMatrix4f_thenReturnXIs00() {
    // Arrange and Act
    Quaternionf actualRightRotation = new Transformation(new Matrix4f()).getRightRotation();

    // Assert
    assertEquals(-0.0f, actualRightRotation.x());
    assertEquals(-0.0f, actualRightRotation.y());
    assertEquals(-0.0f, actualRightRotation.z());
    assertEquals(-0.0f, actualRightRotation.x);
    assertEquals(-0.0f, actualRightRotation.y);
    assertEquals(-0.0f, actualRightRotation.z);
    Quaternionf actualConjugateResult = actualRightRotation.conjugate();
    assertSame(actualRightRotation, actualConjugateResult);
    Quaternionf actualInvertResult = actualRightRotation.invert();
    assertSame(actualRightRotation, actualInvertResult);
    Quaternionf actualNormalizeResult = actualRightRotation.normalize();
    assertSame(actualRightRotation, actualNormalizeResult);
  }

  /**
   * Test {@link Transformation#getRightRotation()}.
   *
   * <ul>
   *   <li>Then return w is {@code 0.78927726}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getRightRotation()}
   */
  @Test
  @DisplayName("Test getRightRotation(); then return w is '0.78927726'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf Transformation.getRightRotation()"})
  void testGetRightRotation_thenReturnWIs078927726() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            Constants.EPSILON,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f);
    Transformation transformation = new Transformation(matrix);

    // Act
    Quaternionf actualRightRotation = transformation.getRightRotation();

    // Assert
    Quaternionf actualConjugateResult = actualRightRotation.conjugate();
    assertSame(actualRightRotation, actualConjugateResult);
    Quaternionf actualInvertResult = actualRightRotation.invert();
    assertSame(actualRightRotation, actualInvertResult);
    Quaternionf actualNormalizeResult = actualRightRotation.normalize();
    assertSame(actualRightRotation, actualNormalizeResult);
    assertEquals(0.78927726f, actualRightRotation.w());
    assertEquals(-0.32694343f, actualRightRotation.x());
    assertEquals(0.19889592f, actualRightRotation.y());
    assertEquals(-0.4801978f, actualRightRotation.z());
    Quaternionf leftRotation = transformation.getLeftRotation();
    assertEquals(-0.32693142f, leftRotation.w);
    assertEquals(0.7892822f, leftRotation.x);
    assertEquals(0.4801948f, leftRotation.y);
    assertEquals(0.1989032f, leftRotation.z);
    assertEquals(-0.32693142f, leftRotation.w());
    assertEquals(0.7892822f, leftRotation.x());
    assertEquals(0.4801948f, leftRotation.y());
    assertEquals(0.1989032f, leftRotation.z());
  }

  /**
   * Test {@link Transformation#getRightRotation()}.
   *
   * <ul>
   *   <li>Then return w is {@code 0.88047624}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#getRightRotation()}
   */
  @Test
  @DisplayName("Test getRightRotation(); then return w is '0.88047624'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf Transformation.getRightRotation()"})
  void testGetRightRotation_thenReturnWIs088047624() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
            1.0f, 1.0f);
    Transformation transformation = new Transformation(matrix);

    // Act
    Quaternionf actualRightRotation = transformation.getRightRotation();

    // Assert
    Quaternionf actualConjugateResult = actualRightRotation.conjugate();
    assertSame(actualRightRotation, actualConjugateResult);
    Quaternionf actualInvertResult = actualRightRotation.invert();
    assertSame(actualRightRotation, actualInvertResult);
    Quaternionf actualNormalizeResult = actualRightRotation.normalize();
    assertSame(actualRightRotation, actualNormalizeResult);
    assertEquals(0.88047624f, actualRightRotation.w());
    assertEquals(-0.11591697f, actualRightRotation.x());
    assertEquals(0.27984828f, actualRightRotation.y());
    assertEquals(-0.3647052f, actualRightRotation.z());
    Quaternionf leftRotation = transformation.getLeftRotation();
    assertEquals(-0.11591689f, leftRotation.w);
    assertEquals(0.8804763f, leftRotation.x);
    assertEquals(0.36470523f, leftRotation.y);
    assertEquals(0.27984813f, leftRotation.z);
    assertEquals(-0.11591689f, leftRotation.w());
    assertEquals(0.8804763f, leftRotation.x());
    assertEquals(0.36470523f, leftRotation.y());
    assertEquals(0.27984813f, leftRotation.z());
  }

  /**
   * Test {@link Transformation#equals(Object)}, and {@link Transformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Transformation#equals(Object)}
   *   <li>{@link Transformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Transformation.equals(Object)", "int Transformation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Transformation identityResult = Transformation.identity();
    Transformation identityResult2 = Transformation.identity();

    // Act and Assert
    assertEquals(identityResult, identityResult2);
    assertEquals(identityResult.hashCode(), identityResult2.hashCode());
  }

  /**
   * Test {@link Transformation#equals(Object)}, and {@link Transformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Transformation#equals(Object)}
   *   <li>{@link Transformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Transformation.equals(Object)", "int Transformation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Transformation transformation = new Transformation(new Matrix4f());
    Transformation identityResult = Transformation.identity();

    // Act and Assert
    assertEquals(transformation, identityResult);
    assertEquals(transformation.hashCode(), identityResult.hashCode());
  }

  /**
   * Test {@link Transformation#equals(Object)}, and {@link Transformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Transformation#equals(Object)}
   *   <li>{@link Transformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Transformation.equals(Object)", "int Transformation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Transformation identityResult = Transformation.identity();

    // Act and Assert
    assertEquals(identityResult, identityResult);
    int expectedHashCodeResult = identityResult.hashCode();
    assertEquals(expectedHashCodeResult, identityResult.hashCode());
  }

  /**
   * Test {@link Transformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Transformation.equals(Object)", "int Transformation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    Transformation transformation =
        new Transformation(Mth.X_AXIS, leftRotation, Mth.X_AXIS, rightRotation);

    // Act and Assert
    assertNotEquals(transformation, Transformation.identity());
  }

  /**
   * Test {@link Transformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Transformation.equals(Object)", "int Transformation.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Transformation.identity(), null);
  }

  /**
   * Test {@link Transformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Transformation.equals(Object)", "int Transformation.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Transformation.identity(), "Different type to Transformation");
  }

  /**
   * Test {@link Transformation#slerp(Transformation, float)}.
   *
   * <p>Method under test: {@link Transformation#slerp(Transformation, float)}
   */
  @Test
  @DisplayName("Test slerp(Transformation, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.slerp(Transformation, float)"})
  void testSlerp() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
            1.0f, 1.0f);
    Transformation transformation = new Transformation(matrix);

    // Act
    Transformation actualSlerpResult = transformation.slerp(Transformation.identity(), 0.5f);

    // Assert
    Matrix4fc matrix2 = actualSlerpResult.getMatrix();
    assertTrue(matrix2 instanceof Matrix4f);
    assertEquals(matrix2, actualSlerpResult.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#slerp(Transformation, float)}.
   *
   * <p>Method under test: {@link Transformation#slerp(Transformation, float)}
   */
  @Test
  @DisplayName("Test slerp(Transformation, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.slerp(Transformation, float)"})
  void testSlerp2() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            Constants.EPSILON,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f,
            1.0f);
    Transformation transformation = new Transformation(matrix);

    // Act
    Transformation actualSlerpResult = transformation.slerp(Transformation.identity(), 0.5f);

    // Assert
    Matrix4fc matrix2 = actualSlerpResult.getMatrix();
    assertTrue(matrix2 instanceof Matrix4f);
    assertEquals(matrix2, actualSlerpResult.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#slerp(Transformation, float)}.
   *
   * <ul>
   *   <li>Given identity.
   *   <li>Then return identity.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#slerp(Transformation, float)}
   */
  @Test
  @DisplayName("Test slerp(Transformation, float); given identity; then return identity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.slerp(Transformation, float)"})
  void testSlerp_givenIdentity_thenReturnIdentity() {
    // Arrange
    Transformation identityResult = Transformation.identity();
    Transformation transformation = Transformation.identity();

    // Act
    Transformation actualSlerpResult = identityResult.slerp(transformation, 0.5f);

    // Assert
    assertEquals(transformation, actualSlerpResult);
  }

  /**
   * Test {@link Transformation#slerp(Transformation, float)}.
   *
   * <ul>
   *   <li>Given {@link Quaternionf#Quaternionf(double, double, double, double)} with x is two and y
   *       is three and z is ten and w is ten.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#slerp(Transformation, float)}
   */
  @Test
  @DisplayName(
      "Test slerp(Transformation, float); given Quaternionf(double, double, double, double) with x is two and y is three and z is ten and w is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.slerp(Transformation, float)"})
  void testSlerp_givenQuaternionfWithXIsTwoAndYIsThreeAndZIsTenAndWIsTen() {
    // Arrange
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    Transformation transformation =
        new Transformation(Mth.X_AXIS, leftRotation, Mth.X_AXIS, rightRotation);

    // Act
    Transformation actualSlerpResult = transformation.slerp(Transformation.identity(), 0.5f);

    // Assert
    Matrix4fc matrix = actualSlerpResult.getMatrix();
    assertTrue(matrix instanceof Matrix4f);
    assertEquals(matrix, actualSlerpResult.getMatrixCopy());
  }

  /**
   * Test {@link Transformation#slerp(Transformation, float)}.
   *
   * <ul>
   *   <li>Then return {@link Transformation#Transformation(Matrix4fc)} with matrix is {@link
   *       Matrix4f#Matrix4f()}.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#slerp(Transformation, float)}
   */
  @Test
  @DisplayName(
      "Test slerp(Transformation, float); then return Transformation(Matrix4fc) with matrix is Matrix4f()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformation Transformation.slerp(Transformation, float)"})
  void testSlerp_thenReturnTransformationWithMatrixIsMatrix4f() {
    // Arrange
    Transformation transformation = new Transformation(new Matrix4f());

    // Act
    Transformation actualSlerpResult = transformation.slerp(Transformation.identity(), 0.5f);

    // Assert
    assertEquals(transformation, actualSlerpResult);
  }
}
