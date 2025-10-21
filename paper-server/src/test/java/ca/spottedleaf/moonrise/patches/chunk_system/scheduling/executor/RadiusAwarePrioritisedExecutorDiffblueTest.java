package ca.spottedleaf.moonrise.patches.chunk_system.scheduling.executor;

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
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 1).queueTask(1, 1, 1, mock(Runnable.class));

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.NORMAL));
    verify(prioritisedTask).queue();
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
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 1)
        .queueTask(1, 1, 1, mock(Runnable.class), Priority.BLOCKING);

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.BLOCKING));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>Then calls {@link PrioritisedExecutor#createTask(Runnable, Priority)}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; then calls createTask(Runnable, Priority)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_thenCallsCreateTask() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 3)
        .queueTask(1, 1, 1, mock(Runnable.class), Priority.BLOCKING);

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.BLOCKING));
    verify(prioritisedTask).queue();
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
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_thenThrowIllegalStateException() {
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
                .queueTask(1, 1, 1, mock(Runnable.class), Priority.BLOCKING));
    verify(executor).createTask(isA(Runnable.class), eq(Priority.BLOCKING));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then calls {@link PrioritisedExecutor#createTask(Runnable, Priority)}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; when three; then calls createTask(Runnable, Priority)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_whenThree_thenCallsCreateTask() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 3)
        .queueTask(3, 1, 2, mock(Runnable.class), Priority.BLOCKING);

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.BLOCKING));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable, Priority)} with
   * {@code chunkX}, {@code chunkZ}, {@code radius}, {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then calls {@link PrioritisedExecutor#createTask(Runnable, Priority)}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable, Priority) with 'chunkX', 'chunkZ', 'radius', 'run', 'priority'; when two; then calls createTask(Runnable, Priority)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable, Priority)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRunPriority_whenTwo_thenCallsCreateTask() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 3)
        .queueTask(1, 1, 2, mock(Runnable.class), Priority.BLOCKING);

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.BLOCKING));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <ul>
   *   <li>Then calls {@link PrioritisedExecutor#createTask(Runnable, Priority)}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; then calls createTask(Runnable, Priority)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun_thenCallsCreateTask() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 3).queueTask(1, 1, 1, mock(Runnable.class));

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.NORMAL));
    verify(prioritisedTask).queue();
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
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun_thenThrowIllegalStateException() {
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
                .queueTask(1, 1, 1, mock(Runnable.class)));
    verify(executor).createTask(isA(Runnable.class), eq(Priority.NORMAL));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then calls {@link PrioritisedExecutor#createTask(Runnable, Priority)}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; when SIZE; then calls createTask(Runnable, Priority)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun_whenSize_thenCallsCreateTask() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 3)
        .queueTask(1, 1, Integer.SIZE, mock(Runnable.class));

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.NORMAL));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)} with {@code
   * chunkX}, {@code chunkZ}, {@code radius}, {@code run}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then calls {@link PrioritisedExecutor#createTask(Runnable, Priority)}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueTask(int, int, int, Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueTask(int, int, int, Runnable) with 'chunkX', 'chunkZ', 'radius', 'run'; when two; then calls createTask(Runnable, Priority)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueTask(int, int, int, Runnable)"
  })
  void testQueueTaskWithChunkXChunkZRadiusRun_whenTwo_thenCallsCreateTask() {
    // Arrange
    PrioritisedTask prioritisedTask = mock(PrioritisedTask.class);
    when(prioritisedTask.queue()).thenReturn(true);

    PrioritisedExecutor executor = mock(PrioritisedExecutor.class);
    when(executor.createTask(Mockito.<Runnable>any(), Mockito.<Priority>any()))
        .thenReturn(prioritisedTask);

    // Act
    new RadiusAwarePrioritisedExecutor(executor, 3).queueTask(1, 1, 2, mock(Runnable.class));

    // Assert
    verify(executor).createTask(isA(Runnable.class), eq(Priority.NORMAL));
    verify(prioritisedTask).queue();
  }

  /**
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable, Priority)} with
   * {@code run}, {@code priority}.
   *
   * <ul>
   *   <li>Then calls {@link PrioritisedExecutor#createTask(Runnable, Priority)}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable,
   * Priority)}
   */
  @Test
  @DisplayName(
      "Test queueInfiniteRadiusTask(Runnable, Priority) with 'run', 'priority'; then calls createTask(Runnable, Priority)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable, Priority)"
  })
  void testQueueInfiniteRadiusTaskWithRunPriority_thenCallsCreateTask() {
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
   * Test {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)} with {@code run}.
   *
   * <ul>
   *   <li>Then calls {@link PrioritisedExecutor#createTask(Runnable, Priority)}.
   * </ul>
   *
   * <p>Method under test: {@link RadiusAwarePrioritisedExecutor#queueInfiniteRadiusTask(Runnable)}
   */
  @Test
  @DisplayName(
      "Test queueInfiniteRadiusTask(Runnable) with 'run'; then calls createTask(Runnable, Priority)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritisedExecutor.PrioritisedTask RadiusAwarePrioritisedExecutor.queueInfiniteRadiusTask(Runnable)"
  })
  void testQueueInfiniteRadiusTaskWithRun_thenCallsCreateTask() {
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
