package io.papermc.paper.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RotationsDiffblueTest {
  /**
   * Test {@link Rotations#ofDegrees(double, double, double)}.
   *
   * <p>Method under test: {@link Rotations#ofDegrees(double, double, double)}
   */
  @Test
  @DisplayName("Test ofDegrees(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rotations Rotations.ofDegrees(double, double, double)"})
  void testOfDegrees() {
    // Arrange and Act
    Rotations actualOfDegreesResult = Rotations.ofDegrees(2.0d, 3.0d, 10.0d);

    // Assert
    assertTrue(actualOfDegreesResult instanceof RotationsImpl);
    assertEquals(10.0d, actualOfDegreesResult.z());
    assertEquals(2.0d, actualOfDegreesResult.x());
    assertEquals(3.0d, actualOfDegreesResult.y());
  }

  /**
   * Test {@link Rotations#subtract(double, double, double)}.
   *
   * <p>Method under test: {@link Rotations#subtract(double, double, double)}
   */
  @Test
  @DisplayName("Test subtract(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rotations Rotations.subtract(double, double, double)"})
  void testSubtract() {
    // Arrange and Act
    Rotations actualSubtractResult =
        new RotationsImpl(2.0d, 3.0d, 10.0d).subtract(2.0d, 3.0d, 10.0d);

    // Assert
    assertTrue(actualSubtractResult instanceof RotationsImpl);
    assertEquals(0.0d, actualSubtractResult.x());
    assertEquals(0.0d, actualSubtractResult.y());
    assertEquals(0.0d, actualSubtractResult.z());
  }
}
