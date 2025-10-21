package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class V2832DiffblueTest {
  /**
   * Test {@link V2832#ceilLog2(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link V2832#ceilLog2(int)}
   */
  @Test
  @DisplayName("Test ceilLog2(int); when forty-two; then return six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V2832.ceilLog2(int)"})
  void testCeilLog2_whenFortyTwo_thenReturnSix() {
    // Arrange, Act and Assert
    assertEquals(6, V2832.ceilLog2(42));
  }

  /**
   * Test {@link V2832#ceilLog2(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link V2832#ceilLog2(int)}
   */
  @Test
  @DisplayName("Test ceilLog2(int); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V2832.ceilLog2(int)"})
  void testCeilLog2_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, V2832.ceilLog2(0));
  }
}
