package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EulerAngleDiffblueTest {
  /**
   * Test {@link EulerAngle#EulerAngle(double, double, double)}.
   *
   * <p>Method under test: {@link EulerAngle#EulerAngle(double, double, double)}
   */
  @Test
  @DisplayName("Test new EulerAngle(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EulerAngle.<init>(double, double, double)"})
  void testNewEulerAngle() {
    // Arrange and Act
    EulerAngle actualEulerAngle = new EulerAngle(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(10.0d, actualEulerAngle.getZ());
    assertEquals(2.0d, actualEulerAngle.getX());
    assertEquals(3.0d, actualEulerAngle.getY());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EulerAngle#getX()}
   *   <li>{@link EulerAngle#getY()}
   *   <li>{@link EulerAngle#getZ()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double EulerAngle.getX()",
    "double EulerAngle.getY()",
    "double EulerAngle.getZ()"
  })
  void testGettersAndSetters() {
    // Arrange
    EulerAngle eulerAngle = new EulerAngle(2.0d, 3.0d, 10.0d);

    // Act
    double actualX = eulerAngle.getX();
    double actualY = eulerAngle.getY();

    // Assert
    assertEquals(10.0d, eulerAngle.getZ());
    assertEquals(2.0d, actualX);
    assertEquals(3.0d, actualY);
  }

  /**
   * Test {@link EulerAngle#setX(double)}.
   *
   * <p>Method under test: {@link EulerAngle#setX(double)}
   */
  @Test
  @DisplayName("Test setX(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EulerAngle EulerAngle.setX(double)"})
  void testSetX() {
    // Arrange and Act
    EulerAngle actualSetXResult = EulerAngle.ZERO.setX(2.0d);

    // Assert
    assertEquals(0.0d, actualSetXResult.getY());
    assertEquals(0.0d, actualSetXResult.getZ());
    assertEquals(2.0d, actualSetXResult.getX());
  }

  /**
   * Test {@link EulerAngle#setY(double)}.
   *
   * <p>Method under test: {@link EulerAngle#setY(double)}
   */
  @Test
  @DisplayName("Test setY(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EulerAngle EulerAngle.setY(double)"})
  void testSetY() {
    // Arrange and Act
    EulerAngle actualSetYResult = EulerAngle.ZERO.setY(3.0d);

    // Assert
    assertEquals(0.0d, actualSetYResult.getX());
    assertEquals(0.0d, actualSetYResult.getZ());
    assertEquals(3.0d, actualSetYResult.getY());
  }

  /**
   * Test {@link EulerAngle#setZ(double)}.
   *
   * <p>Method under test: {@link EulerAngle#setZ(double)}
   */
  @Test
  @DisplayName("Test setZ(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EulerAngle EulerAngle.setZ(double)"})
  void testSetZ() {
    // Arrange and Act
    EulerAngle actualSetZResult = EulerAngle.ZERO.setZ(10.0d);

    // Assert
    assertEquals(0.0d, actualSetZResult.getX());
    assertEquals(0.0d, actualSetZResult.getY());
    assertEquals(10.0d, actualSetZResult.getZ());
  }

  /**
   * Test {@link EulerAngle#add(double, double, double)}.
   *
   * <p>Method under test: {@link EulerAngle#add(double, double, double)}
   */
  @Test
  @DisplayName("Test add(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EulerAngle EulerAngle.add(double, double, double)"})
  void testAdd() {
    // Arrange and Act
    EulerAngle actualAddResult = EulerAngle.ZERO.add(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(10.0d, actualAddResult.getZ());
    assertEquals(2.0d, actualAddResult.getX());
    assertEquals(3.0d, actualAddResult.getY());
  }

  /**
   * Test {@link EulerAngle#subtract(double, double, double)}.
   *
   * <p>Method under test: {@link EulerAngle#subtract(double, double, double)}
   */
  @Test
  @DisplayName("Test subtract(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EulerAngle EulerAngle.subtract(double, double, double)"})
  void testSubtract() {
    // Arrange and Act
    EulerAngle actualSubtractResult = EulerAngle.ZERO.subtract(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(-10.0d, actualSubtractResult.getZ());
    assertEquals(-2.0d, actualSubtractResult.getX());
    assertEquals(-3.0d, actualSubtractResult.getY());
  }

  /**
   * Test {@link EulerAngle#equals(Object)}, and {@link EulerAngle#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EulerAngle#equals(Object)}
   *   <li>{@link EulerAngle#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EulerAngle.equals(Object)", "int EulerAngle.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EulerAngle eulerAngle = EulerAngle.ZERO;
    EulerAngle eulerAngle2 = EulerAngle.ZERO;

    // Act and Assert
    assertEquals(eulerAngle, eulerAngle2);
    assertEquals(eulerAngle.hashCode(), eulerAngle2.hashCode());
  }

  /**
   * Test {@link EulerAngle#equals(Object)}, and {@link EulerAngle#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EulerAngle#equals(Object)}
   *   <li>{@link EulerAngle#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EulerAngle.equals(Object)", "int EulerAngle.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EulerAngle eulerAngle = new EulerAngle(2.0d, 3.0d, 10.0d);
    EulerAngle eulerAngle2 = new EulerAngle(2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(eulerAngle, eulerAngle2);
    assertEquals(eulerAngle.hashCode(), eulerAngle2.hashCode());
  }

  /**
   * Test {@link EulerAngle#equals(Object)}, and {@link EulerAngle#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EulerAngle#equals(Object)}
   *   <li>{@link EulerAngle#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EulerAngle.equals(Object)", "int EulerAngle.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EulerAngle eulerAngle = EulerAngle.ZERO;

    // Act and Assert
    assertEquals(eulerAngle, eulerAngle);
    int expectedHashCodeResult = eulerAngle.hashCode();
    assertEquals(expectedHashCodeResult, eulerAngle.hashCode());
  }

  /**
   * Test {@link EulerAngle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EulerAngle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EulerAngle.equals(Object)", "int EulerAngle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EulerAngle(2.0d, 3.0d, 10.0d), EulerAngle.ZERO);
  }

  /**
   * Test {@link EulerAngle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EulerAngle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EulerAngle.equals(Object)", "int EulerAngle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EulerAngle eulerAngle = new EulerAngle(2.0d, 10.0d, 10.0d);

    // Act and Assert
    assertNotEquals(eulerAngle, new EulerAngle(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link EulerAngle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EulerAngle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EulerAngle.equals(Object)", "int EulerAngle.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EulerAngle eulerAngle = new EulerAngle(2.0d, 3.0d, 1.0d);

    // Act and Assert
    assertNotEquals(eulerAngle, new EulerAngle(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link EulerAngle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EulerAngle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EulerAngle.equals(Object)", "int EulerAngle.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EulerAngle.ZERO, null);
  }

  /**
   * Test {@link EulerAngle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EulerAngle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EulerAngle.equals(Object)", "int EulerAngle.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EulerAngle.ZERO, "Different type to EulerAngle");
  }
}
