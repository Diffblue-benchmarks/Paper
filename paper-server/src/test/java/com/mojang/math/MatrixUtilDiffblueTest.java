package com.mojang.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MatrixUtilDiffblueTest {
  /**
   * Test {@link MatrixUtil#mulComponentWise(Matrix4f, float)}.
   *
   * <p>Method under test: {@link MatrixUtil#mulComponentWise(Matrix4f, float)}
   */
  @Test
  @DisplayName("Test mulComponentWise(Matrix4f, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix4f MatrixUtil.mulComponentWise(Matrix4f, float)"})
  void testMulComponentWise() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
            10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Matrix4f actualMulComponentWiseResult = MatrixUtil.mulComponentWise(matrix, 10.0f);

    // Assert
    Matrix4f actualCofactor3x3Result = actualMulComponentWiseResult.cofactor3x3();
    assertSame(actualMulComponentWiseResult, actualCofactor3x3Result);
    Matrix4f actualInvertResult = actualMulComponentWiseResult.invert();
    assertSame(actualMulComponentWiseResult, actualInvertResult);
    Matrix4f actualNormalResult = actualMulComponentWiseResult.normal();
    assertSame(actualMulComponentWiseResult, actualNormalResult);
    Matrix4f actualNormalize3x3Result = actualMulComponentWiseResult.normalize3x3();
    assertSame(actualMulComponentWiseResult, actualNormalize3x3Result);
    Matrix4f actualTransposeResult = actualMulComponentWiseResult.transpose();
    assertSame(actualMulComponentWiseResult, actualTransposeResult);
    Matrix4f actualTranspose3x3Result = actualMulComponentWiseResult.transpose3x3();
    assertSame(actualMulComponentWiseResult, actualTranspose3x3Result);
  }

  /**
   * Test {@link MatrixUtil#mulComponentWise(Matrix4f, float)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add4x3 {@link Matrix4f#Matrix4f()}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#mulComponentWise(Matrix4f, float)}
   */
  @Test
  @DisplayName(
      "Test mulComponentWise(Matrix4f, float); given Matrix4f(); when Matrix4f() add4x3 Matrix4f()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix4f MatrixUtil.mulComponentWise(Matrix4f, float)"})
  void testMulComponentWise_givenMatrix4f_whenMatrix4fAdd4x3Matrix4f() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add4x3(new Matrix4f());
    matrix.add(new Matrix4f());

    // Act
    Matrix4f actualMulComponentWiseResult = MatrixUtil.mulComponentWise(matrix, 0.5f);

    // Assert
    Matrix4f actualCofactor3x3Result = actualMulComponentWiseResult.cofactor3x3();
    assertSame(actualMulComponentWiseResult, actualCofactor3x3Result);
    Matrix4f actualInvertResult = actualMulComponentWiseResult.invert();
    assertSame(actualMulComponentWiseResult, actualInvertResult);
    Matrix4f actualNormalResult = actualMulComponentWiseResult.normal();
    assertSame(actualMulComponentWiseResult, actualNormalResult);
    Matrix4f actualNormalize3x3Result = actualMulComponentWiseResult.normalize3x3();
    assertSame(actualMulComponentWiseResult, actualNormalize3x3Result);
    Matrix4f actualTransposeResult = actualMulComponentWiseResult.transpose();
    assertSame(actualMulComponentWiseResult, actualTransposeResult);
    Matrix4f actualTranspose3x3Result = actualMulComponentWiseResult.transpose3x3();
    assertSame(actualMulComponentWiseResult, actualTranspose3x3Result);
  }

  /**
   * Test {@link MatrixUtil#mulComponentWise(Matrix4f, float)}.
   *
   * <ul>
   *   <li>When {@link Matrix4f#Matrix4f()}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#mulComponentWise(Matrix4f, float)}
   */
  @Test
  @DisplayName("Test mulComponentWise(Matrix4f, float); when Matrix4f()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix4f MatrixUtil.mulComponentWise(Matrix4f, float)"})
  void testMulComponentWise_whenMatrix4f() {
    // Arrange and Act
    Matrix4f actualMulComponentWiseResult = MatrixUtil.mulComponentWise(new Matrix4f(), 10.0f);

    // Assert
    Matrix4f actualCofactor3x3Result = actualMulComponentWiseResult.cofactor3x3();
    assertSame(actualMulComponentWiseResult, actualCofactor3x3Result);
    Matrix4f actualInvertResult = actualMulComponentWiseResult.invert();
    assertSame(actualMulComponentWiseResult, actualInvertResult);
    Matrix4f actualNormalResult = actualMulComponentWiseResult.normal();
    assertSame(actualMulComponentWiseResult, actualNormalResult);
    Matrix4f actualNormalize3x3Result = actualMulComponentWiseResult.normalize3x3();
    assertSame(actualMulComponentWiseResult, actualNormalize3x3Result);
    Matrix4f actualTransposeResult = actualMulComponentWiseResult.transpose();
    assertSame(actualMulComponentWiseResult, actualTransposeResult);
    Matrix4f actualTranspose3x3Result = actualMulComponentWiseResult.transpose3x3();
    assertSame(actualMulComponentWiseResult, actualTranspose3x3Result);
  }

  /**
   * Test {@link MatrixUtil#mulComponentWise(Matrix4f, float)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link Matrix4f#Matrix4f()} determinant3x3 is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#mulComponentWise(Matrix4f, float)}
   */
  @Test
  @DisplayName(
      "Test mulComponentWise(Matrix4f, float); when zero; then Matrix4f() determinant3x3 is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix4f MatrixUtil.mulComponentWise(Matrix4f, float)"})
  void testMulComponentWise_whenZero_thenMatrix4fDeterminant3x3IsNaN() {
    // Arrange
    Matrix4f matrix = new Matrix4f();

    // Act
    Matrix4f actualMulComponentWiseResult = MatrixUtil.mulComponentWise(matrix, 0.0f);

    // Assert
    Matrix4f actualCofactor3x3Result = actualMulComponentWiseResult.cofactor3x3();
    assertSame(actualMulComponentWiseResult, actualCofactor3x3Result);
    Matrix4f actualInvertResult = actualMulComponentWiseResult.invert();
    assertSame(actualMulComponentWiseResult, actualInvertResult);
    Matrix4f actualNormalResult = actualMulComponentWiseResult.normal();
    assertSame(actualMulComponentWiseResult, actualNormalResult);
    Matrix4f actualNormalize3x3Result = actualMulComponentWiseResult.normalize3x3();
    assertSame(actualMulComponentWiseResult, actualNormalize3x3Result);
    Matrix4f actualTransposeResult = actualMulComponentWiseResult.transpose();
    assertSame(actualMulComponentWiseResult, actualTransposeResult);
    Matrix4f actualTranspose3x3Result = actualMulComponentWiseResult.transpose3x3();
    assertSame(actualMulComponentWiseResult, actualTranspose3x3Result);
    assertEquals(Float.NaN, matrix.determinant3x3());
    assertFalse(matrix.isFinite());
    assertEquals(Float.NaN, matrix.m00());
    assertEquals(Float.NaN, matrix.m01());
    assertEquals(Float.NaN, matrix.m02());
    assertEquals(Float.NaN, matrix.m10());
    assertEquals(Float.NaN, matrix.m11());
    assertEquals(Float.NaN, matrix.m12());
    assertEquals(Float.NaN, matrix.m20());
    assertEquals(Float.NaN, matrix.m21());
    assertEquals(Float.NaN, matrix.m22());
  }

  /**
   * Test {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}.
   *
   * <ul>
   *   <li>Then return y is {@code -0.3535534}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}
   */
  @Test
  @DisplayName("Test eigenvalueJacobi(Matrix3f, int); then return y is '-0.3535534'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf MatrixUtil.eigenvalueJacobi(Matrix3f, int)"})
  void testEigenvalueJacobi_thenReturnYIs03535534() {
    // Arrange
    Matrix3f input = new Matrix3f(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Quaternionf actualEigenvalueJacobiResult = MatrixUtil.eigenvalueJacobi(input, 1);

    // Assert
    assertEquals(-0.3535534f, actualEigenvalueJacobiResult.y());
    assertEquals(-0.3535534f, actualEigenvalueJacobiResult.y);
    assertEquals(0.14644663f, actualEigenvalueJacobiResult.x());
    assertEquals(0.14644663f, actualEigenvalueJacobiResult.x);
    assertEquals(0.3535534f, actualEigenvalueJacobiResult.z());
    assertEquals(0.3535534f, actualEigenvalueJacobiResult.z);
    assertEquals(0.85355335f, actualEigenvalueJacobiResult.w());
    assertEquals(0.85355335f, actualEigenvalueJacobiResult.w);
    Quaternionf actualConjugateResult = actualEigenvalueJacobiResult.conjugate();
    assertSame(actualEigenvalueJacobiResult, actualConjugateResult);
    Quaternionf actualInvertResult = actualEigenvalueJacobiResult.invert();
    assertSame(actualEigenvalueJacobiResult, actualInvertResult);
    Quaternionf actualNormalizeResult = actualEigenvalueJacobiResult.normalize();
    assertSame(actualEigenvalueJacobiResult, actualNormalizeResult);
  }

  /**
   * Test {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}.
   *
   * <ul>
   *   <li>Then return y is {@code -0.19134171}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}
   */
  @Test
  @DisplayName("Test eigenvalueJacobi(Matrix3f, int); then return y is '-0.19134171'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf MatrixUtil.eigenvalueJacobi(Matrix3f, int)"})
  void testEigenvalueJacobi_thenReturnYIs019134171() {
    // Arrange
    Matrix3f input =
        new Matrix3f(Constants.EPSILON, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Quaternionf actualEigenvalueJacobiResult = MatrixUtil.eigenvalueJacobi(input, 1);

    // Assert
    assertEquals(-0.19134171f, actualEigenvalueJacobiResult.y());
    assertEquals(-0.19134171f, actualEigenvalueJacobiResult.y);
    assertEquals(0.4619398f, actualEigenvalueJacobiResult.x());
    assertEquals(0.4619398f, actualEigenvalueJacobiResult.z());
    assertEquals(0.4619398f, actualEigenvalueJacobiResult.x);
    assertEquals(0.4619398f, actualEigenvalueJacobiResult.z);
    assertEquals(0.73253775f, actualEigenvalueJacobiResult.w());
    assertEquals(0.73253775f, actualEigenvalueJacobiResult.w);
    Quaternionf actualConjugateResult = actualEigenvalueJacobiResult.conjugate();
    assertSame(actualEigenvalueJacobiResult, actualConjugateResult);
    Quaternionf actualInvertResult = actualEigenvalueJacobiResult.invert();
    assertSame(actualEigenvalueJacobiResult, actualInvertResult);
    Quaternionf actualNormalizeResult = actualEigenvalueJacobiResult.normalize();
    assertSame(actualEigenvalueJacobiResult, actualNormalizeResult);
  }

  /**
   * Test {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}.
   *
   * <ul>
   *   <li>Then return y is {@code -0.38268346}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}
   */
  @Test
  @DisplayName("Test eigenvalueJacobi(Matrix3f, int); then return y is '-0.38268346'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf MatrixUtil.eigenvalueJacobi(Matrix3f, int)"})
  void testEigenvalueJacobi_thenReturnYIs038268346() {
    // Arrange
    Matrix3f input =
        new Matrix3f(10.0f, Float.NaN, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Quaternionf actualEigenvalueJacobiResult = MatrixUtil.eigenvalueJacobi(input, 1);

    // Assert
    assertEquals(-0.38268346f, actualEigenvalueJacobiResult.y());
    assertEquals(-0.38268346f, actualEigenvalueJacobiResult.y);
    assertEquals(0.0f, actualEigenvalueJacobiResult.z());
    assertEquals(0.0f, actualEigenvalueJacobiResult.z);
    Quaternionf actualConjugateResult = actualEigenvalueJacobiResult.conjugate();
    assertSame(actualEigenvalueJacobiResult, actualConjugateResult);
    Quaternionf actualInvertResult = actualEigenvalueJacobiResult.invert();
    assertSame(actualEigenvalueJacobiResult, actualInvertResult);
    Quaternionf actualNormalizeResult = actualEigenvalueJacobiResult.normalize();
    assertSame(actualEigenvalueJacobiResult, actualNormalizeResult);
  }

  /**
   * Test {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}.
   *
   * <ul>
   *   <li>Then return y is {@code -0.0154054705}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}
   */
  @Test
  @DisplayName("Test eigenvalueJacobi(Matrix3f, int); then return y is '-0.0154054705'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf MatrixUtil.eigenvalueJacobi(Matrix3f, int)"})
  void testEigenvalueJacobi_thenReturnYIs00154054705() {
    // Arrange
    Matrix3f input = new Matrix3f(200.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Quaternionf actualEigenvalueJacobiResult = MatrixUtil.eigenvalueJacobi(input, 1);

    // Assert
    assertEquals(-0.0154054705f, actualEigenvalueJacobiResult.y());
    assertEquals(-0.0154054705f, actualEigenvalueJacobiResult.y);
    assertEquals(0.034844473f, actualEigenvalueJacobiResult.z());
    assertEquals(0.034844473f, actualEigenvalueJacobiResult.z);
    assertEquals(0.38307577f, actualEigenvalueJacobiResult.x());
    assertEquals(0.38307577f, actualEigenvalueJacobiResult.x);
    assertEquals(0.9229309f, actualEigenvalueJacobiResult.w());
    assertEquals(0.9229309f, actualEigenvalueJacobiResult.w);
    Quaternionf actualConjugateResult = actualEigenvalueJacobiResult.conjugate();
    assertSame(actualEigenvalueJacobiResult, actualConjugateResult);
    Quaternionf actualInvertResult = actualEigenvalueJacobiResult.invert();
    assertSame(actualEigenvalueJacobiResult, actualInvertResult);
    Quaternionf actualNormalizeResult = actualEigenvalueJacobiResult.normalize();
    assertSame(actualEigenvalueJacobiResult, actualNormalizeResult);
  }

  /**
   * Test {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}.
   *
   * <ul>
   *   <li>Then return y is zero.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#eigenvalueJacobi(Matrix3f, int)}
   */
  @Test
  @DisplayName("Test eigenvalueJacobi(Matrix3f, int); then return y is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf MatrixUtil.eigenvalueJacobi(Matrix3f, int)"})
  void testEigenvalueJacobi_thenReturnYIsZero() {
    // Arrange
    Matrix3f input =
        new Matrix3f(Float.NaN, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Quaternionf actualEigenvalueJacobiResult = MatrixUtil.eigenvalueJacobi(input, 1);

    // Assert
    assertEquals(0.0f, actualEigenvalueJacobiResult.y());
    assertEquals(0.0f, actualEigenvalueJacobiResult.y);
    assertEquals(0.38268346f, actualEigenvalueJacobiResult.z());
    assertEquals(0.38268346f, actualEigenvalueJacobiResult.z);
    Quaternionf actualConjugateResult = actualEigenvalueJacobiResult.conjugate();
    assertSame(actualEigenvalueJacobiResult, actualConjugateResult);
    Quaternionf actualInvertResult = actualEigenvalueJacobiResult.invert();
    assertSame(actualEigenvalueJacobiResult, actualInvertResult);
    Quaternionf actualNormalizeResult = actualEigenvalueJacobiResult.normalize();
    assertSame(actualEigenvalueJacobiResult, actualNormalizeResult);
  }

  /**
   * Test {@link MatrixUtil#svdDecompose(Matrix3f)}.
   *
   * <ul>
   *   <li>Then return Left w is {@code -0.32693136}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#svdDecompose(Matrix3f)}
   */
  @Test
  @DisplayName("Test svdDecompose(Matrix3f); then return Left w is '-0.32693136'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Triple MatrixUtil.svdDecompose(Matrix3f)"})
  void testSvdDecompose_thenReturnLeftWIs032693136() {
    // Arrange
    Matrix3f matrix =
        new Matrix3f(Constants.EPSILON, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Triple<Quaternionf, Vector3f, Quaternionf> actualSvdDecomposeResult =
        MatrixUtil.svdDecompose(matrix);

    // Assert
    assertTrue(actualSvdDecomposeResult instanceof ImmutableTriple);
    Quaternionf left = actualSvdDecomposeResult.getLeft();
    assertEquals(-0.32693136f, left.w());
    Quaternionf right = actualSvdDecomposeResult.getRight();
    assertEquals(-0.3269314f, right.x());
    assertEquals(-0.3269314f, right.x);
    assertEquals(-0.48019484f, right.z());
    assertEquals(-0.48019484f, right.z);
    assertEquals(0.19890317f, left.z());
    assertEquals(0.19890332f, right.y());
    assertEquals(0.19890332f, right.y);
    assertEquals(0.48019487f, left.y());
    assertEquals(0.78928214f, right.w());
    assertEquals(0.78928214f, right.w);
    assertEquals(0.7892822f, left.x());
    Quaternionf actualConjugateResult = left.conjugate();
    assertSame(left, actualConjugateResult);
    Quaternionf actualInvertResult = left.invert();
    assertSame(left, actualInvertResult);
    Quaternionf actualNormalizeResult = left.normalize();
    assertSame(left, actualNormalizeResult);
    Vector3f middle = actualSvdDecomposeResult.getMiddle();
    Vector3f actualAbsoluteResult = middle.absolute();
    assertSame(middle, actualAbsoluteResult);
    Vector3f actualCeilResult = middle.ceil();
    assertSame(middle, actualCeilResult);
    Vector3f actualFloorResult = middle.floor();
    assertSame(middle, actualFloorResult);
    Vector3f actualNormalizeResult2 = middle.normalize();
    assertSame(middle, actualNormalizeResult2);
    Quaternionf actualConjugateResult2 = right.conjugate();
    assertSame(right, actualConjugateResult2);
    Quaternionf actualInvertResult2 = right.invert();
    assertSame(right, actualInvertResult2);
    Quaternionf actualNormalizeResult3 = right.normalize();
    assertSame(right, actualNormalizeResult3);
  }

  /**
   * Test {@link MatrixUtil#svdDecompose(Matrix3f)}.
   *
   * <ul>
   *   <li>Then return Right x is {@code -0.115916975}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#svdDecompose(Matrix3f)}
   */
  @Test
  @DisplayName("Test svdDecompose(Matrix3f); then return Right x is '-0.115916975'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Triple MatrixUtil.svdDecompose(Matrix3f)"})
  void testSvdDecompose_thenReturnRightXIs0115916975() {
    // Arrange
    Matrix3f matrix = new Matrix3f(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Triple<Quaternionf, Vector3f, Quaternionf> actualSvdDecomposeResult =
        MatrixUtil.svdDecompose(matrix);

    // Assert
    assertTrue(actualSvdDecomposeResult instanceof ImmutableTriple);
    Quaternionf right = actualSvdDecomposeResult.getRight();
    assertEquals(-0.115916975f, right.x());
    Quaternionf left = actualSvdDecomposeResult.getLeft();
    assertEquals(-0.27984816f, left.y());
    assertEquals(-0.3647052f, right.z());
    Vector3f middle = actualSvdDecomposeResult.getMiddle();
    assertEquals(0.0f, middle.z());
    assertEquals(0.0f, middle.z);
    assertEquals(0.11591689f, left.x());
    assertEquals(0.2798483f, right.y());
    assertEquals(0.3647052f, left.z());
    assertEquals(0.88047624f, right.w());
    assertEquals(0.8804763f, left.w());
    Quaternionf actualConjugateResult = left.conjugate();
    assertSame(left, actualConjugateResult);
    Quaternionf actualInvertResult = left.invert();
    assertSame(left, actualInvertResult);
    Quaternionf actualNormalizeResult = left.normalize();
    assertSame(left, actualNormalizeResult);
    Vector3f actualAbsoluteResult = middle.absolute();
    assertSame(middle, actualAbsoluteResult);
    Vector3f actualCeilResult = middle.ceil();
    assertSame(middle, actualCeilResult);
    Vector3f actualFloorResult = middle.floor();
    assertSame(middle, actualFloorResult);
    Vector3f actualNormalizeResult2 = middle.normalize();
    assertSame(middle, actualNormalizeResult2);
    Quaternionf actualConjugateResult2 = right.conjugate();
    assertSame(right, actualConjugateResult2);
    Quaternionf actualInvertResult2 = right.invert();
    assertSame(right, actualInvertResult2);
    Quaternionf actualNormalizeResult3 = right.normalize();
    assertSame(right, actualNormalizeResult3);
  }

  /**
   * Test {@link MatrixUtil#checkProperty(Matrix4fc, int)}.
   *
   * <p>Method under test: {@link MatrixUtil#checkProperty(Matrix4fc, int)}
   */
  @Test
  @DisplayName("Test checkProperty(Matrix4fc, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.checkProperty(Matrix4fc, int)"})
  void testCheckProperty() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
            10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertFalse(MatrixUtil.checkProperty(matrix, 1));
  }

  /**
   * Test {@link MatrixUtil#checkProperty(Matrix4fc, int)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add4x3 {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#checkProperty(Matrix4fc, int)}
   */
  @Test
  @DisplayName(
      "Test checkProperty(Matrix4fc, int); given Matrix4f(); when Matrix4f() add4x3 Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.checkProperty(Matrix4fc, int)"})
  void testCheckProperty_givenMatrix4f_whenMatrix4fAdd4x3Matrix4f_thenReturnFalse() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add4x3(new Matrix4f());

    // Act and Assert
    assertFalse(MatrixUtil.checkProperty(matrix, 1));
  }

  /**
   * Test {@link MatrixUtil#checkProperty(Matrix4fc, int)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#checkProperty(Matrix4fc, int)}
   */
  @Test
  @DisplayName(
      "Test checkProperty(Matrix4fc, int); given Matrix4f(); when Matrix4f() add Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.checkProperty(Matrix4fc, int)"})
  void testCheckProperty_givenMatrix4f_whenMatrix4fAddMatrix4f_thenReturnFalse() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add(new Matrix4f());

    // Act and Assert
    assertFalse(MatrixUtil.checkProperty(matrix, 1));
  }

  /**
   * Test {@link MatrixUtil#checkProperty(Matrix4fc, int)}.
   *
   * <ul>
   *   <li>When {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#checkProperty(Matrix4fc, int)}
   */
  @Test
  @DisplayName("Test checkProperty(Matrix4fc, int); when Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.checkProperty(Matrix4fc, int)"})
  void testCheckProperty_whenMatrix4f_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MatrixUtil.checkProperty(new Matrix4f(), 1));
  }

  /**
   * Test {@link MatrixUtil#checkProperty(Matrix4fc, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#checkProperty(Matrix4fc, int)}
   */
  @Test
  @DisplayName("Test checkProperty(Matrix4fc, int); when minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.checkProperty(Matrix4fc, int)"})
  void testCheckProperty_whenMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MatrixUtil.checkProperty(new Matrix4f(), -1));
  }

  /**
   * Test {@link MatrixUtil#isIdentity(Matrix4fc)}.
   *
   * <p>Method under test: {@link MatrixUtil#isIdentity(Matrix4fc)}
   */
  @Test
  @DisplayName("Test isIdentity(Matrix4fc)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isIdentity(Matrix4fc)"})
  void testIsIdentity() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
            10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertFalse(MatrixUtil.isIdentity(matrix));
  }

  /**
   * Test {@link MatrixUtil#isIdentity(Matrix4fc)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add4x3 {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isIdentity(Matrix4fc)}
   */
  @Test
  @DisplayName(
      "Test isIdentity(Matrix4fc); given Matrix4f(); when Matrix4f() add4x3 Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isIdentity(Matrix4fc)"})
  void testIsIdentity_givenMatrix4f_whenMatrix4fAdd4x3Matrix4f_thenReturnFalse() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add4x3(new Matrix4f());

    // Act and Assert
    assertFalse(MatrixUtil.isIdentity(matrix));
  }

  /**
   * Test {@link MatrixUtil#isIdentity(Matrix4fc)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isIdentity(Matrix4fc)}
   */
  @Test
  @DisplayName(
      "Test isIdentity(Matrix4fc); given Matrix4f(); when Matrix4f() add Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isIdentity(Matrix4fc)"})
  void testIsIdentity_givenMatrix4f_whenMatrix4fAddMatrix4f_thenReturnFalse() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add(new Matrix4f());

    // Act and Assert
    assertFalse(MatrixUtil.isIdentity(matrix));
  }

  /**
   * Test {@link MatrixUtil#isIdentity(Matrix4fc)}.
   *
   * <ul>
   *   <li>When {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isIdentity(Matrix4fc)}
   */
  @Test
  @DisplayName("Test isIdentity(Matrix4fc); when Matrix4f(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isIdentity(Matrix4fc)"})
  void testIsIdentity_whenMatrix4f_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MatrixUtil.isIdentity(new Matrix4f()));
  }

  /**
   * Test {@link MatrixUtil#isPureTranslation(Matrix4fc)}.
   *
   * <p>Method under test: {@link MatrixUtil#isPureTranslation(Matrix4fc)}
   */
  @Test
  @DisplayName("Test isPureTranslation(Matrix4fc)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isPureTranslation(Matrix4fc)"})
  void testIsPureTranslation() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
            10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertFalse(MatrixUtil.isPureTranslation(matrix));
  }

  /**
   * Test {@link MatrixUtil#isPureTranslation(Matrix4fc)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add4x3 {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isPureTranslation(Matrix4fc)}
   */
  @Test
  @DisplayName(
      "Test isPureTranslation(Matrix4fc); given Matrix4f(); when Matrix4f() add4x3 Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isPureTranslation(Matrix4fc)"})
  void testIsPureTranslation_givenMatrix4f_whenMatrix4fAdd4x3Matrix4f_thenReturnFalse() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add4x3(new Matrix4f());

    // Act and Assert
    assertFalse(MatrixUtil.isPureTranslation(matrix));
  }

  /**
   * Test {@link MatrixUtil#isPureTranslation(Matrix4fc)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isPureTranslation(Matrix4fc)}
   */
  @Test
  @DisplayName(
      "Test isPureTranslation(Matrix4fc); given Matrix4f(); when Matrix4f() add Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isPureTranslation(Matrix4fc)"})
  void testIsPureTranslation_givenMatrix4f_whenMatrix4fAddMatrix4f_thenReturnFalse() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add(new Matrix4f());

    // Act and Assert
    assertFalse(MatrixUtil.isPureTranslation(matrix));
  }

  /**
   * Test {@link MatrixUtil#isPureTranslation(Matrix4fc)}.
   *
   * <ul>
   *   <li>When {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isPureTranslation(Matrix4fc)}
   */
  @Test
  @DisplayName("Test isPureTranslation(Matrix4fc); when Matrix4f(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isPureTranslation(Matrix4fc)"})
  void testIsPureTranslation_whenMatrix4f_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MatrixUtil.isPureTranslation(new Matrix4f()));
  }

  /**
   * Test {@link MatrixUtil#isOrthonormal(Matrix4fc)}.
   *
   * <p>Method under test: {@link MatrixUtil#isOrthonormal(Matrix4fc)}
   */
  @Test
  @DisplayName("Test isOrthonormal(Matrix4fc)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isOrthonormal(Matrix4fc)"})
  void testIsOrthonormal() {
    // Arrange
    Matrix4f matrix =
        new Matrix4f(
            10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
            10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertFalse(MatrixUtil.isOrthonormal(matrix));
  }

  /**
   * Test {@link MatrixUtil#isOrthonormal(Matrix4fc)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add4x3 {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isOrthonormal(Matrix4fc)}
   */
  @Test
  @DisplayName(
      "Test isOrthonormal(Matrix4fc); given Matrix4f(); when Matrix4f() add4x3 Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isOrthonormal(Matrix4fc)"})
  void testIsOrthonormal_givenMatrix4f_whenMatrix4fAdd4x3Matrix4f_thenReturnFalse() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add4x3(new Matrix4f());

    // Act and Assert
    assertFalse(MatrixUtil.isOrthonormal(matrix));
  }

  /**
   * Test {@link MatrixUtil#isOrthonormal(Matrix4fc)}.
   *
   * <ul>
   *   <li>Given {@link Matrix4f#Matrix4f()}.
   *   <li>When {@link Matrix4f#Matrix4f()} add {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isOrthonormal(Matrix4fc)}
   */
  @Test
  @DisplayName(
      "Test isOrthonormal(Matrix4fc); given Matrix4f(); when Matrix4f() add Matrix4f(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isOrthonormal(Matrix4fc)"})
  void testIsOrthonormal_givenMatrix4f_whenMatrix4fAddMatrix4f_thenReturnFalse() {
    // Arrange
    Matrix4f matrix = new Matrix4f();
    matrix.add(new Matrix4f());

    // Act and Assert
    assertFalse(MatrixUtil.isOrthonormal(matrix));
  }

  /**
   * Test {@link MatrixUtil#isOrthonormal(Matrix4fc)}.
   *
   * <ul>
   *   <li>When {@link Matrix4f#Matrix4f()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatrixUtil#isOrthonormal(Matrix4fc)}
   */
  @Test
  @DisplayName("Test isOrthonormal(Matrix4fc); when Matrix4f(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatrixUtil.isOrthonormal(Matrix4fc)"})
  void testIsOrthonormal_whenMatrix4f_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MatrixUtil.isOrthonormal(new Matrix4f()));
  }
}
