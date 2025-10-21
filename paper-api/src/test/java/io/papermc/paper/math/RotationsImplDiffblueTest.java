package io.papermc.paper.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RotationsImplDiffblueTest {
  /**
   * Test {@link RotationsImpl#withX(double)}.
   *
   * <p>Method under test: {@link RotationsImpl#withX(double)}
   */
  @Test
  @DisplayName("Test withX(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RotationsImpl RotationsImpl.withX(double)"})
  void testWithX() {
    // Arrange
    RotationsImpl rotationsImpl = new RotationsImpl(2.0d, 3.0d, 10.0d);

    // Act
    RotationsImpl actualWithXResult = rotationsImpl.withX(2.0d);

    // Assert
    assertEquals(rotationsImpl, actualWithXResult);
  }

  /**
   * Test {@link RotationsImpl#withY(double)}.
   *
   * <p>Method under test: {@link RotationsImpl#withY(double)}
   */
  @Test
  @DisplayName("Test withY(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RotationsImpl RotationsImpl.withY(double)"})
  void testWithY() {
    // Arrange
    RotationsImpl rotationsImpl = new RotationsImpl(2.0d, 3.0d, 10.0d);

    // Act
    RotationsImpl actualWithYResult = rotationsImpl.withY(3.0d);

    // Assert
    assertEquals(rotationsImpl, actualWithYResult);
  }

  /**
   * Test {@link RotationsImpl#withZ(double)}.
   *
   * <p>Method under test: {@link RotationsImpl#withZ(double)}
   */
  @Test
  @DisplayName("Test withZ(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RotationsImpl RotationsImpl.withZ(double)"})
  void testWithZ() {
    // Arrange
    RotationsImpl rotationsImpl = new RotationsImpl(2.0d, 3.0d, 10.0d);

    // Act
    RotationsImpl actualWithZResult = rotationsImpl.withZ(10.0d);

    // Assert
    assertEquals(rotationsImpl, actualWithZResult);
  }

  /**
   * Test {@link RotationsImpl#add(double, double, double)}.
   *
   * <p>Method under test: {@link RotationsImpl#add(double, double, double)}
   */
  @Test
  @DisplayName("Test add(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RotationsImpl RotationsImpl.add(double, double, double)"})
  void testAdd() {
    // Arrange and Act
    RotationsImpl actualAddResult = new RotationsImpl(2.0d, 3.0d, 10.0d).add(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(20.0d, actualAddResult.z());
    assertEquals(4.0d, actualAddResult.x());
    assertEquals(6.0d, actualAddResult.y());
  }
}
