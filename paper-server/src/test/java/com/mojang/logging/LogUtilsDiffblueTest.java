package com.mojang.logging;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LogUtilsDiffblueTest {
  /**
   * Test {@link LogUtils#isLoggerActive()}.
   *
   * <p>Method under test: {@link LogUtils#isLoggerActive()}
   */
  @Test
  @DisplayName("Test isLoggerActive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogUtils.isLoggerActive()"})
  void testIsLoggerActive() {
    // Arrange, Act and Assert
    assertTrue(LogUtils.isLoggerActive());
  }
}
