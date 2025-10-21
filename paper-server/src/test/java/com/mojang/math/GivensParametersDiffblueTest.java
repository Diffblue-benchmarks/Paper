package com.mojang.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.joml.Matrix3f;
import org.joml.Quaternionf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GivensParametersDiffblueTest {
  /**
   * Test {@link GivensParameters#fromUnnormalized(float, float)}.
   *
   * <p>Method under test: {@link GivensParameters#fromUnnormalized(float, float)}
   */
  @Test
  @DisplayName("Test fromUnnormalized(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GivensParameters GivensParameters.fromUnnormalized(float, float)"})
  void testFromUnnormalized() {
    // Arrange and Act
    GivensParameters actualFromUnnormalizedResult = GivensParameters.fromUnnormalized(10.0f, 10.0f);

    // Assert
    assertEquals(0.7071068f, actualFromUnnormalizedResult.cosHalf());
    assertEquals(0.7071068f, actualFromUnnormalizedResult.sinHalf());
  }

  /**
   * Test {@link GivensParameters#fromPositiveAngle(float)}.
   *
   * <p>Method under test: {@link GivensParameters#fromPositiveAngle(float)}
   */
  @Test
  @DisplayName("Test fromPositiveAngle(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GivensParameters GivensParameters.fromPositiveAngle(float)"})
  void testFromPositiveAngle() {
    // Arrange and Act
    GivensParameters actualFromPositiveAngleResult = GivensParameters.fromPositiveAngle(10.0f);

    // Assert
    assertEquals(-0.9589243f, actualFromPositiveAngleResult.sinHalf());
    assertEquals(0.28366208f, actualFromPositiveAngleResult.cosHalf());
  }

  /**
   * Test {@link GivensParameters#inverse()}.
   *
   * <p>Method under test: {@link GivensParameters#inverse()}
   */
  @Test
  @DisplayName("Test inverse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GivensParameters GivensParameters.inverse()"})
  void testInverse() {
    // Arrange and Act
    GivensParameters actualInverseResult = new GivensParameters(10.0f, 10.0f).inverse();

    // Assert
    assertEquals(-10.0f, actualInverseResult.sinHalf());
    assertEquals(10.0f, actualInverseResult.cosHalf());
  }

  /**
   * Test {@link GivensParameters#aroundX(Matrix3f)} with {@code matrix}.
   *
   * <p>Method under test: {@link GivensParameters#aroundX(Matrix3f)}
   */
  @Test
  @DisplayName("Test aroundX(Matrix3f) with 'matrix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix3f GivensParameters.aroundX(Matrix3f)"})
  void testAroundXWithMatrix() {
    // Arrange
    GivensParameters givensParameters = new GivensParameters(10.0f, 10.0f);
    Matrix3f matrix = new Matrix3f(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Matrix3f actualAroundXResult = givensParameters.aroundX(matrix);

    // Assert
    assertSame(matrix, actualAroundXResult);
  }

  /**
   * Test {@link GivensParameters#aroundX(Quaternionf)} with {@code quaternion}.
   *
   * <p>Method under test: {@link GivensParameters#aroundX(Quaternionf)}
   */
  @Test
  @DisplayName("Test aroundX(Quaternionf) with 'quaternion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf GivensParameters.aroundX(Quaternionf)"})
  void testAroundXWithQuaternion() {
    // Arrange
    GivensParameters givensParameters = new GivensParameters(10.0f, 10.0f);
    Quaternionf quaternion = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Quaternionf actualAroundXResult = givensParameters.aroundX(quaternion);

    // Assert
    assertEquals(0.0f, quaternion.y());
    assertEquals(0.0f, quaternion.z());
    assertEquals(0.0f, quaternion.y);
    assertEquals(0.0f, quaternion.z);
    assertSame(quaternion, actualAroundXResult);
  }

  /**
   * Test {@link GivensParameters#aroundY(Matrix3f)} with {@code matrix}.
   *
   * <p>Method under test: {@link GivensParameters#aroundY(Matrix3f)}
   */
  @Test
  @DisplayName("Test aroundY(Matrix3f) with 'matrix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix3f GivensParameters.aroundY(Matrix3f)"})
  void testAroundYWithMatrix() {
    // Arrange
    GivensParameters givensParameters = new GivensParameters(10.0f, 10.0f);
    Matrix3f matrix = new Matrix3f(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Matrix3f actualAroundYResult = givensParameters.aroundY(matrix);

    // Assert
    assertSame(matrix, actualAroundYResult);
  }

  /**
   * Test {@link GivensParameters#aroundY(Quaternionf)} with {@code quaternion}.
   *
   * <p>Method under test: {@link GivensParameters#aroundY(Quaternionf)}
   */
  @Test
  @DisplayName("Test aroundY(Quaternionf) with 'quaternion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf GivensParameters.aroundY(Quaternionf)"})
  void testAroundYWithQuaternion() {
    // Arrange
    GivensParameters givensParameters = new GivensParameters(10.0f, 10.0f);
    Quaternionf quaternion = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Quaternionf actualAroundYResult = givensParameters.aroundY(quaternion);

    // Assert
    assertEquals(0.0f, quaternion.x());
    assertEquals(0.0f, quaternion.z());
    assertEquals(0.0f, quaternion.x);
    assertEquals(0.0f, quaternion.z);
    assertSame(quaternion, actualAroundYResult);
  }

  /**
   * Test {@link GivensParameters#aroundZ(Matrix3f)} with {@code matrix}.
   *
   * <p>Method under test: {@link GivensParameters#aroundZ(Matrix3f)}
   */
  @Test
  @DisplayName("Test aroundZ(Matrix3f) with 'matrix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix3f GivensParameters.aroundZ(Matrix3f)"})
  void testAroundZWithMatrix() {
    // Arrange
    GivensParameters givensParameters = new GivensParameters(10.0f, 10.0f);
    Matrix3f matrix = new Matrix3f(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Matrix3f actualAroundZResult = givensParameters.aroundZ(matrix);

    // Assert
    assertSame(matrix, actualAroundZResult);
  }

  /**
   * Test {@link GivensParameters#aroundZ(Quaternionf)} with {@code quaternion}.
   *
   * <p>Method under test: {@link GivensParameters#aroundZ(Quaternionf)}
   */
  @Test
  @DisplayName("Test aroundZ(Quaternionf) with 'quaternion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quaternionf GivensParameters.aroundZ(Quaternionf)"})
  void testAroundZWithQuaternion() {
    // Arrange
    GivensParameters givensParameters = new GivensParameters(10.0f, 10.0f);
    Quaternionf quaternion = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Quaternionf actualAroundZResult = givensParameters.aroundZ(quaternion);

    // Assert
    assertEquals(0.0f, quaternion.x());
    assertEquals(0.0f, quaternion.y());
    assertEquals(0.0f, quaternion.x);
    assertEquals(0.0f, quaternion.y);
    assertSame(quaternion, actualAroundZResult);
  }

  /**
   * Test {@link GivensParameters#cos()}.
   *
   * <p>Method under test: {@link GivensParameters#cos()}
   */
  @Test
  @DisplayName("Test cos()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float GivensParameters.cos()"})
  void testCos() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new GivensParameters(10.0f, 10.0f).cos());
  }

  /**
   * Test {@link GivensParameters#sin()}.
   *
   * <p>Method under test: {@link GivensParameters#sin()}
   */
  @Test
  @DisplayName("Test sin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float GivensParameters.sin()"})
  void testSin() {
    // Arrange, Act and Assert
    assertEquals(200.0f, new GivensParameters(10.0f, 10.0f).sin());
  }
}
