package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TransformationDiffblueTest {
  /**
   * Test {@link Transformation#Transformation(Vector3f, AxisAngle4f, Vector3f, AxisAngle4f)}.
   *
   * <ul>
   *   <li>Then return LeftRotation conjugate is LeftRotation.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, AxisAngle4f, Vector3f,
   * AxisAngle4f)}
   */
  @Test
  @DisplayName(
      "Test new Transformation(Vector3f, AxisAngle4f, Vector3f, AxisAngle4f); then return LeftRotation conjugate is LeftRotation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, AxisAngle4f, Vector3f, AxisAngle4f)"})
  void testNewTransformation_thenReturnLeftRotationConjugateIsLeftRotation() {
    // Arrange
    Vector3f translation = new Vector3f(10.0f);
    AxisAngle4f leftRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale = new Vector3f(10.0f);
    AxisAngle4f rightRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Transformation actualTransformation =
        new Transformation(translation, leftRotation, scale, rightRotation);

    // Assert
    Quaternionf leftRotation2 = actualTransformation.getLeftRotation();
    Quaternionf actualConjugateResult = leftRotation2.conjugate();
    assertSame(leftRotation2, actualConjugateResult);
    Quaternionf actualInvertResult = leftRotation2.invert();
    assertSame(leftRotation2, actualInvertResult);
    Quaternionf actualNormalizeResult = leftRotation2.normalize();
    assertSame(leftRotation2, actualNormalizeResult);
    Quaternionf rightRotation2 = actualTransformation.getRightRotation();
    Quaternionf actualConjugateResult2 = rightRotation2.conjugate();
    assertSame(rightRotation2, actualConjugateResult2);
    Quaternionf actualInvertResult2 = rightRotation2.invert();
    assertSame(rightRotation2, actualInvertResult2);
    Quaternionf actualNormalizeResult2 = rightRotation2.normalize();
    assertSame(rightRotation2, actualNormalizeResult2);
    Vector3f scale2 = actualTransformation.getScale();
    Vector3f actualAbsoluteResult = scale2.absolute();
    assertSame(scale2, actualAbsoluteResult);
    Vector3f actualCeilResult = scale2.ceil();
    assertSame(scale2, actualCeilResult);
    Vector3f actualFloorResult = scale2.floor();
    assertSame(scale2, actualFloorResult);
    Vector3f actualNormalizeResult3 = scale2.normalize();
    assertSame(scale2, actualNormalizeResult3);
    Vector3f translation2 = actualTransformation.getTranslation();
    Vector3f actualAbsoluteResult2 = translation2.absolute();
    assertSame(translation2, actualAbsoluteResult2);
    Vector3f actualCeilResult2 = translation2.ceil();
    assertSame(translation2, actualCeilResult2);
    Vector3f actualFloorResult2 = translation2.floor();
    assertSame(translation2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = translation2.normalize();
    assertSame(translation2, actualNormalizeResult4);
  }

  /**
   * Test {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf)}.
   *
   * <ul>
   *   <li>Then return LeftRotation Finite.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, Quaternionf, Vector3f,
   * Quaternionf)}
   */
  @Test
  @DisplayName(
      "Test new Transformation(Vector3f, Quaternionf, Vector3f, Quaternionf); then return LeftRotation Finite")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, Quaternionf, Vector3f, Quaternionf)"})
  void testNewTransformation_thenReturnLeftRotationFinite() {
    // Arrange
    Vector3f translation = new Vector3f(10.0f);
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Vector3f scale = new Vector3f(10.0f);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    // Act
    Transformation actualTransformation =
        new Transformation(translation, leftRotation, scale, rightRotation);

    // Assert
    Quaternionf leftRotation2 = actualTransformation.getLeftRotation();
    assertTrue(leftRotation2.isFinite());
    Quaternionf rightRotation2 = actualTransformation.getRightRotation();
    assertTrue(rightRotation2.isFinite());
    Vector3f scale2 = actualTransformation.getScale();
    assertTrue(scale2.isFinite());
    Vector3f translation2 = actualTransformation.getTranslation();
    assertTrue(translation2.isFinite());
    Quaternionf actualConjugateResult = leftRotation2.conjugate();
    assertSame(leftRotation2, actualConjugateResult);
    Quaternionf actualInvertResult = leftRotation2.invert();
    assertSame(leftRotation2, actualInvertResult);
    Quaternionf actualNormalizeResult = leftRotation2.normalize();
    assertSame(leftRotation2, actualNormalizeResult);
    Quaternionf actualConjugateResult2 = rightRotation2.conjugate();
    assertSame(rightRotation2, actualConjugateResult2);
    Quaternionf actualInvertResult2 = rightRotation2.invert();
    assertSame(rightRotation2, actualInvertResult2);
    Quaternionf actualNormalizeResult2 = rightRotation2.normalize();
    assertSame(rightRotation2, actualNormalizeResult2);
    Vector3f actualAbsoluteResult = scale2.absolute();
    assertSame(scale2, actualAbsoluteResult);
    Vector3f actualCeilResult = scale2.ceil();
    assertSame(scale2, actualCeilResult);
    Vector3f actualFloorResult = scale2.floor();
    assertSame(scale2, actualFloorResult);
    Vector3f actualNormalizeResult3 = scale2.normalize();
    assertSame(scale2, actualNormalizeResult3);
    Vector3f actualAbsoluteResult2 = translation2.absolute();
    assertSame(translation2, actualAbsoluteResult2);
    Vector3f actualCeilResult2 = translation2.ceil();
    assertSame(translation2, actualCeilResult2);
    Vector3f actualFloorResult2 = translation2.floor();
    assertSame(translation2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = translation2.normalize();
    assertSame(translation2, actualNormalizeResult4);
  }

  /**
   * Test {@link Transformation#Transformation(Vector3f, AxisAngle4f, Vector3f, AxisAngle4f)}.
   *
   * <ul>
   *   <li>When {@link AxisAngle4f#AxisAngle4f()}.
   *   <li>Then return LeftRotation x is zero.
   * </ul>
   *
   * <p>Method under test: {@link Transformation#Transformation(Vector3f, AxisAngle4f, Vector3f,
   * AxisAngle4f)}
   */
  @Test
  @DisplayName(
      "Test new Transformation(Vector3f, AxisAngle4f, Vector3f, AxisAngle4f); when AxisAngle4f(); then return LeftRotation x is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Transformation.<init>(Vector3f, AxisAngle4f, Vector3f, AxisAngle4f)"})
  void testNewTransformation_whenAxisAngle4f_thenReturnLeftRotationXIsZero() {
    // Arrange
    Vector3f translation = new Vector3f(10.0f);
    AxisAngle4f leftRotation = new AxisAngle4f();
    Vector3f scale = new Vector3f(10.0f);
    AxisAngle4f rightRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    Transformation actualTransformation =
        new Transformation(translation, leftRotation, scale, rightRotation);

    // Assert
    Quaternionf leftRotation2 = actualTransformation.getLeftRotation();
    assertEquals(0.0f, leftRotation2.x());
    assertEquals(0.0f, leftRotation2.y());
    assertEquals(0.0f, leftRotation2.z());
    assertEquals(0.0f, leftRotation2.x);
    assertEquals(0.0f, leftRotation2.y);
    assertEquals(0.0f, leftRotation2.z);
    assertEquals(1.0f, leftRotation2.w());
    assertEquals(1.0f, leftRotation2.w);
    Quaternionf actualConjugateResult = leftRotation2.conjugate();
    assertSame(leftRotation2, actualConjugateResult);
    Quaternionf actualInvertResult = leftRotation2.invert();
    assertSame(leftRotation2, actualInvertResult);
    Quaternionf actualNormalizeResult = leftRotation2.normalize();
    assertSame(leftRotation2, actualNormalizeResult);
    Quaternionf rightRotation2 = actualTransformation.getRightRotation();
    Quaternionf actualConjugateResult2 = rightRotation2.conjugate();
    assertSame(rightRotation2, actualConjugateResult2);
    Quaternionf actualInvertResult2 = rightRotation2.invert();
    assertSame(rightRotation2, actualInvertResult2);
    Quaternionf actualNormalizeResult2 = rightRotation2.normalize();
    assertSame(rightRotation2, actualNormalizeResult2);
    Vector3f scale2 = actualTransformation.getScale();
    Vector3f actualAbsoluteResult = scale2.absolute();
    assertSame(scale2, actualAbsoluteResult);
    Vector3f actualCeilResult = scale2.ceil();
    assertSame(scale2, actualCeilResult);
    Vector3f actualFloorResult = scale2.floor();
    assertSame(scale2, actualFloorResult);
    Vector3f actualNormalizeResult3 = scale2.normalize();
    assertSame(scale2, actualNormalizeResult3);
    Vector3f translation2 = actualTransformation.getTranslation();
    Vector3f actualAbsoluteResult2 = translation2.absolute();
    assertSame(translation2, actualAbsoluteResult2);
    Vector3f actualCeilResult2 = translation2.ceil();
    assertSame(translation2, actualCeilResult2);
    Vector3f actualFloorResult2 = translation2.floor();
    assertSame(translation2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = translation2.normalize();
    assertSame(translation2, actualNormalizeResult4);
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
    Vector3f translation = new Vector3f(10.0f);
    AxisAngle4f leftRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale = new Vector3f(10.0f);
    AxisAngle4f rightRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    Transformation transformation =
        new Transformation(translation, leftRotation, scale, rightRotation);
    Vector3f translation2 = new Vector3f(10.0f);
    AxisAngle4f leftRotation2 = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale2 = new Vector3f(10.0f);
    AxisAngle4f rightRotation2 = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    Transformation transformation2 =
        new Transformation(translation2, leftRotation2, scale2, rightRotation2);

    // Act and Assert
    assertEquals(transformation, transformation2);
    assertEquals(transformation.hashCode(), transformation2.hashCode());
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
    Vector3f translation = new Vector3f(10.0f);
    AxisAngle4f leftRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale = new Vector3f(10.0f);
    AxisAngle4f rightRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    Transformation transformation =
        new Transformation(translation, leftRotation, scale, rightRotation);

    // Act and Assert
    assertEquals(transformation, transformation);
    int expectedHashCodeResult = transformation.hashCode();
    assertEquals(expectedHashCodeResult, transformation.hashCode());
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
    Vector3f translation = new Vector3f(10.0f);
    Quaternionf leftRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);
    Vector3f scale = new Vector3f(10.0f);
    Quaternionf rightRotation = new Quaternionf(2.0d, 3.0d, 10.0d, 10.0d);

    Transformation transformation =
        new Transformation(translation, leftRotation, scale, rightRotation);
    Vector3f translation2 = new Vector3f(10.0f);
    AxisAngle4f leftRotation2 = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale2 = new Vector3f(10.0f);
    AxisAngle4f rightRotation2 = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertNotEquals(
        transformation, new Transformation(translation2, leftRotation2, scale2, rightRotation2));
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Vector3f translation = new Vector3f(0.5f);
    AxisAngle4f leftRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale = new Vector3f(10.0f);
    AxisAngle4f rightRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    Transformation transformation =
        new Transformation(translation, leftRotation, scale, rightRotation);
    Vector3f translation2 = new Vector3f(10.0f);
    AxisAngle4f leftRotation2 = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale2 = new Vector3f(10.0f);
    AxisAngle4f rightRotation2 = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertNotEquals(
        transformation, new Transformation(translation2, leftRotation2, scale2, rightRotation2));
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Vector3f translation = new Vector3f(10.0f);
    AxisAngle4f leftRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale = new Vector3f(0.5f);
    AxisAngle4f rightRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    Transformation transformation =
        new Transformation(translation, leftRotation, scale, rightRotation);
    Vector3f translation2 = new Vector3f(10.0f);
    AxisAngle4f leftRotation2 = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale2 = new Vector3f(10.0f);
    AxisAngle4f rightRotation2 = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertNotEquals(
        transformation, new Transformation(translation2, leftRotation2, scale2, rightRotation2));
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
    // Arrange
    Vector3f translation = new Vector3f(10.0f);
    AxisAngle4f leftRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale = new Vector3f(10.0f);
    AxisAngle4f rightRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertNotEquals(new Transformation(translation, leftRotation, scale, rightRotation), null);
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
    // Arrange
    Vector3f translation = new Vector3f(10.0f);
    AxisAngle4f leftRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);
    Vector3f scale = new Vector3f(10.0f);
    AxisAngle4f rightRotation = new AxisAngle4f(10.0f, 10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertNotEquals(
        new Transformation(translation, leftRotation, scale, rightRotation),
        "Different type to Transformation");
  }
}
