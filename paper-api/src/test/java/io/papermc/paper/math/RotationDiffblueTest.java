package io.papermc.paper.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RotationDiffblueTest {
  /**
   * Test {@link Rotation#rotation(float, float)}.
   *
   * <p>Method under test: {@link Rotation#rotation(float, float)}
   */
  @Test
  @DisplayName("Test rotation(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rotation Rotation.rotation(float, float)"})
  void testRotation() {
    // Arrange and Act
    Rotation actualRotationResult = Rotation.rotation(10.0f, 10.0f);

    // Assert
    assertTrue(actualRotationResult instanceof RotationImpl);
    assertEquals(10.0f, actualRotationResult.pitch());
    assertEquals(10.0f, actualRotationResult.yaw());
  }
}
