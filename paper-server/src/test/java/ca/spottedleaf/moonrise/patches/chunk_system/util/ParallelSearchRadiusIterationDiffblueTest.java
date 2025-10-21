package ca.spottedleaf.moonrise.patches.chunk_system.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ParallelSearchRadiusIterationDiffblueTest {
  /**
   * Test {@link ParallelSearchRadiusIteration#getSearchIteration(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array of {@code long} with zero and {@code 4294967296}.
   * </ul>
   *
   * <p>Method under test: {@link ParallelSearchRadiusIteration#getSearchIteration(int)}
   */
  @Test
  @DisplayName(
      "Test getSearchIteration(int); when one; then return array of long with zero and '4294967296'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] ParallelSearchRadiusIteration.getSearchIteration(int)"})
  void testGetSearchIteration_whenOne_thenReturnArrayOfLongWithZeroAnd4294967296() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new long[] {
          0L,
          4294967296L,
          -4294967296L,
          1L,
          4294967295L,
          4294967297L,
          8589934591L,
          -1L,
          -4294967295L
        },
        ParallelSearchRadiusIteration.getSearchIteration(1));
  }
}
