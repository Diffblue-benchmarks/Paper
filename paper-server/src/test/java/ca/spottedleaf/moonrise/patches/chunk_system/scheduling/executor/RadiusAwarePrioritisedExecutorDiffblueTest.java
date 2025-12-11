package ca.spottedleaf.moonrise.patches.chunk_system.scheduling.executor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.concurrentutil.executor.PrioritisedExecutor;
import ca.spottedleaf.concurrentutil.executor.PrioritisedExecutor.PrioritisedTask;
import ca.spottedleaf.concurrentutil.executor.queue.PrioritisedTaskQueue;
import ca.spottedleaf.concurrentutil.util.Priority;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RadiusAwarePrioritisedExecutorDiffblueTest {
  /**
   * Test {@link RadiusAwarePrioritisedExecutor#createTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#createTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test createTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.createTask(int, int, int, Runnable, Priority)"
  })
  void testCreateTaskWithChunkXChunkZRadiusRunPriority() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .createTask(1, 1, -1, mock(Runnable.class), Priority.COMPLETING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#createTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>When {@link Runnable}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#createTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test createTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; when Runnable; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.createTask(int, int, int, Runnable, Priority)"
  })
  void testCreateTaskWithChunkXChunkZRadiusRunPriority_whenRunnable_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .createTask(1, 1, 1, mock(Runnable.class), Priority.COMPLETING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#createTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#createTask(int, int, int,
   * Runnable)}
   */
  @Test
  @DisplayName(
      "Test createTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.createTask(int, int, int, Runnable)"
  })
  void testCreateTaskWithChunkXChunkZRadiusRun_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .createTask(1, 1, -1, mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#createTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <ul>
   *   <li>When {@link Runnable}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#createTask(int, int, int,
   * Runnable)}
   */
  @Test
  @DisplayName(
      "Test createTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; when Runnable; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.createTask(int, int, int, Runnable)"
  })
  void testCreateTaskWithChunkXChunkZRadiusRun_whenRunnable_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .createTask(1, 1, 1, mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName("Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, 1, mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName("Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun2() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 1)
                .queueTask(1, 1, 1, mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName("Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun3() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), -1)
                .queueTask(1, 1, 1, mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 1)
                .queueTask(1, 1, 1, mock(Runnable.class), Priority.BLOCKING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority2() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), -1)
                .queueTask(1, 1, 1, mock(Runnable.class), Priority.BLOCKING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, 1, mock(Runnable.class), Priority.BLOCKING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, -1, mock(Runnable.class), Priority.COMPLETING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>When {@code COMPLETING}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; when 'COMPLETING'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_whenCompleting_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, 1, mock(Runnable.class), Priority.COMPLETING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; when SIZE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_whenSize_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, Integer.SIZE, mock(Runnable.class), Priority.BLOCKING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; when two; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_whenTwo_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, 2, mock(Runnable.class), Priority.BLOCKING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, -1, mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; when SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun_whenSize() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, Integer.SIZE, mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun_whenTwo() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueTask(1, 1, 2, mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)} with {@code run}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)}
   */
  @Test
  @DisplayName("Test queueInfiniteRadiusTask(Runnable) with 'run'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable)"
  })
  void testQueueInfiniteRadiusTaskWithRun() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueInfiniteRadiusTask(mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)} with {@code run}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)}
   */
  @Test
  @DisplayName("Test queueInfiniteRadiusTask(Runnable) with 'run'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable)"
  })
  void testQueueInfiniteRadiusTaskWithRun2() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(mock(PrioritisedExecutor.class), -1)
                .queueInfiniteRadiusTask(mock(Runnable.class)));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable, Priority)} with
   * {@code run}, {@code priority}.
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable,
   * Priority)}
   */
  @Test
  @DisplayName("Test queueInfiniteRadiusTask(Runnable, Priority) with 'run', 'priority'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable, Priority)"
  })
  void testQueueInfiniteRadiusTaskWithRunPriority() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(mock(PrioritisedExecutor.class), -1)
                .queueInfiniteRadiusTask(mock(Runnable.class), Priority.BLOCKING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable, Priority)} with
   * {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>Given {@link PrioritisedExecutor.PrioritisedTask} {@link
   *       PrioritisedExecutor.PrioritisedTask#queue()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueInfiniteRadiusTask(Runnable, Priority) with 'run', 'priority'; given PrioritisedTask queue() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable, Priority)"
  })
  void testQueueInfiniteRadiusTaskWithRunPriority_givenPrioritisedTaskQueueReturnTrue() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 3)
        .queueInfiniteRadiusTask(mock(Runnable.class), Priority.BLOCKING);

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.BLOCKING));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable, Priority)} with
   * {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueInfiniteRadiusTask(Runnable, Priority) with 'run', 'priority'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable, Priority)"
  })
  void testQueueInfiniteRadiusTaskWithRunPriority_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueInfiniteRadiusTask(mock(Runnable.class), Priority.BLOCKING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable, Priority)} with
   * {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueInfiniteRadiusTask(Runnable, Priority) with 'run', 'priority'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable, Priority)"
  })
  void testQueueInfiniteRadiusTaskWithRunPriority_thenThrowIllegalStateException() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenThrow(new IllegalStateException());

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new RadiusAwarePrioritisedExecutor(executor, 3)
                .queueInfiniteRadiusTask(mock(Runnable.class), Priority.BLOCKING));
    verify(executor).createTask(isA(Runnable.class), eq(Priority.BLOCKING));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable, Priority)} with
   * {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>When {@code COMPLETING}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueInfiniteRadiusTask(Runnable, Priority) with 'run', 'priority'; when 'COMPLETING'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable, Priority)"
  })
  void testQueueInfiniteRadiusTaskWithRunPriority_whenCompleting_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RadiusAwarePrioritisedExecutor(new PrioritisedTaskQueue(), 3)
                .queueInfiniteRadiusTask(mock(Runnable.class), Priority.COMPLETING));
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)} with {@code run}.
   *
   * <ul>
   *   <li>Given {@link PrioritisedExecutor.PrioritisedTask} {@link
   *       PrioritisedExecutor.PrioritisedTask#queue()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueInfiniteRadiusTask(Runnable) with 'run'; given PrioritisedTask queue() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable)"
  })
  void testQueueInfiniteRadiusTaskWithRun_givenPrioritisedTaskQueueReturnTrue() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 3).queueInfiniteRadiusTask(mock(Runnable.class));

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.NORMAL));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)} with {@code run}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueInfiniteRadiusTask(Runnable) with 'run'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable)"
  })
  void testQueueInfiniteRadiusTaskWithRun_thenThrowIllegalStateException() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenThrow(new IllegalStateException());

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new RadiusAwarePrioritisedExecutor(executor, 3)
                .queueInfiniteRadiusTask(mock(Runnable.class)));
    verify(executor).createTask(isA(Runnable.class), eq(Priority.NORMAL));
    verify(prioritisedTask).queue();
  }
}
