package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatisticDiffblueTest {
  /**
   * Test {@link Statistic#isSubstatistic()}.
   *
   * <p>Method under test: {@link Statistic#isSubstatistic()}
   */
  @Test
  @DisplayName("Test isSubstatistic()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Statistic.isSubstatistic()"})
  void testIsSubstatistic() {
    // Arrange, Act and Assert
    assertFalse(Statistic.ANIMALS_BRED.isSubstatistic());
  }

  /**
   * Test {@link Statistic#isBlock()}.
   *
   * <p>Method under test: {@link Statistic#isBlock()}
   */
  @Test
  @DisplayName("Test isBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Statistic.isBlock()"})
  void testIsBlock() {
    // Arrange, Act and Assert
    assertFalse(Statistic.ANIMALS_BRED.isBlock());
  }
}
