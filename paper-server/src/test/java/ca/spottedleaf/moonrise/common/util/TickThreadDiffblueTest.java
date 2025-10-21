package ca.spottedleaf.moonrise.common.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TickThreadDiffblueTest {
  /**
   * Test {@link TickThread#ensureTickThread(String)} with {@code String}.
   *
   * <p>Method under test: {@link TickThread#ensureTickThread(String)}
   */
  @Test
  @DisplayName("Test ensureTickThread(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TickThread.ensureTickThread(String)"})
  void testEnsureTickThreadWithString() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TickThread.ensureTickThread("Just cause"));
  }

  /**
   * Test {@link TickThread#isTickThread()}.
   *
   * <p>Method under test: {@link TickThread#isTickThread()}
   */
  @Test
  @DisplayName("Test isTickThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TickThread.isTickThread()"})
  void testIsTickThread() {
    // Arrange, Act and Assert
    assertFalse(TickThread.isTickThread());
  }

  /**
   * Test {@link TickThread#isShutdownThread()}.
   *
   * <p>Method under test: {@link TickThread#isShutdownThread()}
   */
  @Test
  @DisplayName("Test isShutdownThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TickThread.isShutdownThread()"})
  void testIsShutdownThread() {
    // Arrange, Act and Assert
    assertFalse(new TickThread("Name").isShutdownThread());
  }
}
