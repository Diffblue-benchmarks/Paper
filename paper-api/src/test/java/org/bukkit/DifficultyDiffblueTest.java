package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DifficultyDiffblueTest {
  /**
   * Test {@link Difficulty#getByValue(int)}.
   *
   * <p>Method under test: {@link Difficulty#getByValue(int)}
   */
  @Test
  @DisplayName("Test getByValue(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Difficulty Difficulty.getByValue(int)"})
  void testGetByValue() {
    // Arrange, Act and Assert
    assertNull(Difficulty.getByValue(42));
  }
}
