package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RotationDiffblueTest {
  /**
   * Test {@link Rotation#rotateClockwise()}.
   *
   * <p>Method under test: {@link Rotation#rotateClockwise()}
   */
  @Test
  @DisplayName("Test rotateClockwise()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rotation Rotation.rotateClockwise()"})
  void testRotateClockwise() {
    // Arrange, Act and Assert
    assertEquals(Rotation.CLOCKWISE_45, Rotation.NONE.rotateClockwise());
  }

  /**
   * Test {@link Rotation#rotateCounterClockwise()}.
   *
   * <p>Method under test: {@link Rotation#rotateCounterClockwise()}
   */
  @Test
  @DisplayName("Test rotateCounterClockwise()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rotation Rotation.rotateCounterClockwise()"})
  void testRotateCounterClockwise() {
    // Arrange, Act and Assert
    assertEquals(Rotation.COUNTER_CLOCKWISE_45, Rotation.NONE.rotateCounterClockwise());
  }
}
