package ca.spottedleaf.moonrise.common.misc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LazyRunnableDiffblueTest {
  @InjectMocks private LazyRunnable lazyRunnable;

  @Mock private Runnable runnable;

  /**
   * Test {@link LazyRunnable#setRunnable(Runnable)}.
   *
   * <p>Method under test: {@link LazyRunnable#setRunnable(Runnable)}
   */
  @Test
  @DisplayName("Test setRunnable(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyRunnable.setRunnable(Runnable)"})
  void testSetRunnable() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> lazyRunnable.setRunnable(mock(Runnable.class)));
  }

  /**
   * Test {@link LazyRunnable#run()}.
   *
   * <ul>
   *   <li>Given {@link Runnable} {@link Runnable#run()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link LazyRunnable#run()}
   */
  @Test
  @DisplayName("Test run(); given Runnable run() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyRunnable.run()"})
  void testRun_givenRunnableRunDoesNothing() {
    // Arrange
    doNothing().when(runnable).run();

    // Act
    lazyRunnable.run();

    // Assert
    verify(runnable).run();
  }

  /**
   * Test {@link LazyRunnable#run()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link LazyRunnable#run()}
   */
  @Test
  @DisplayName("Test run(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyRunnable.run()"})
  void testRun_thenThrowIllegalStateException() {
    // Arrange
    doThrow(new IllegalStateException()).when(runnable).run();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> lazyRunnable.run());
    verify(runnable).run();
  }
}
