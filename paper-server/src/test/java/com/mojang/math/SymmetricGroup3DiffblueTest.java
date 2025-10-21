package com.mojang.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SymmetricGroup3DiffblueTest {
  /**
   * Test {@link SymmetricGroup3#compose(SymmetricGroup3)}.
   *
   * <p>Method under test: {@link SymmetricGroup3#compose(SymmetricGroup3)}
   */
  @Test
  @DisplayName("Test compose(SymmetricGroup3)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymmetricGroup3 SymmetricGroup3.compose(SymmetricGroup3)"})
  void testCompose() {
    // Arrange, Act and Assert
    assertEquals(SymmetricGroup3.P123, SymmetricGroup3.P123.compose(SymmetricGroup3.P123));
  }

  /**
   * Test {@link SymmetricGroup3#permutation(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SymmetricGroup3#permutation(int)}
   */
  @Test
  @DisplayName("Test permutation(int); when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SymmetricGroup3.permutation(int)"})
  void testPermutation_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, SymmetricGroup3.P123.permutation(1));
  }
}
