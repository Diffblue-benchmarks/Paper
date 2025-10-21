package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NullTimingHandlerDiffblueTest {
  /**
   * Test {@link NullTimingHandler#startTiming()}.
   *
   * <p>Method under test: {@link NullTimingHandler#startTiming()}
   */
  @Test
  @DisplayName("Test startTiming()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timing NullTimingHandler.startTiming()"})
  void testStartTiming() {
    // Arrange
    NullTimingHandler nullTimingHandler = new NullTimingHandler();

    // Act
    Timing actualStartTimingResult = nullTimingHandler.startTiming();

    // Assert
    assertTrue(actualStartTimingResult instanceof NullTimingHandler);
    assertNull(actualStartTimingResult.getTimingHandler());
    assertSame(nullTimingHandler, actualStartTimingResult);
  }

  /**
   * Test {@link NullTimingHandler#startTimingIfSync()}.
   *
   * <p>Method under test: {@link NullTimingHandler#startTimingIfSync()}
   */
  @Test
  @DisplayName("Test startTimingIfSync()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timing NullTimingHandler.startTimingIfSync()"})
  void testStartTimingIfSync() {
    // Arrange
    NullTimingHandler nullTimingHandler = new NullTimingHandler();

    // Act
    Timing actualStartTimingIfSyncResult = nullTimingHandler.startTimingIfSync();

    // Assert
    assertTrue(actualStartTimingIfSyncResult instanceof NullTimingHandler);
    assertNull(actualStartTimingIfSyncResult.getTimingHandler());
    assertSame(nullTimingHandler, actualStartTimingIfSyncResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NullTimingHandler}
   *   <li>{@link NullTimingHandler#abort()}
   *   <li>{@link NullTimingHandler#close()}
   *   <li>{@link NullTimingHandler#stopTiming()}
   *   <li>{@link NullTimingHandler#stopTimingIfSync()}
   *   <li>{@link NullTimingHandler#getTimingHandler()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NullTimingHandler.<init>()",
    "void NullTimingHandler.abort()",
    "void NullTimingHandler.close()",
    "TimingHandler NullTimingHandler.getTimingHandler()",
    "void NullTimingHandler.stopTiming()",
    "void NullTimingHandler.stopTimingIfSync()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NullTimingHandler actualNullTimingHandler = new NullTimingHandler();
    actualNullTimingHandler.abort();
    actualNullTimingHandler.close();
    actualNullTimingHandler.stopTiming();
    actualNullTimingHandler.stopTimingIfSync();

    // Assert
    assertNull(actualNullTimingHandler.getTimingHandler());
  }
}
