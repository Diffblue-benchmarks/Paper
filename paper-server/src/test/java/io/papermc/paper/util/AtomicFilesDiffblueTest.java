package io.papermc.paper.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.spongepowered.configurate.util.CheckedConsumer;

class AtomicFilesDiffblueTest {
  /**
   * Test {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#deleteIfExists(Path)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test atomicWrite(Path, CheckedConsumer); given Files deleteIfExists(Path) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicWrite(Path, CheckedConsumer)"})
  void testAtomicWrite_givenFilesDeleteIfExistsThrowIOException_thenThrowIOException()
      throws Throwable {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.deleteIfExists(Mockito.<Path>any())).thenThrow(new IOException());
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(new IOException());

      CheckedConsumer<Path, IOException> op = mock(CheckedConsumer.class);
      doNothing().when(op).accept(Mockito.<Path>any());

      // Act and Assert
      assertThrows(
          IOException.class,
          () -> AtomicFiles.atomicWrite(MetricsPersister.PROFILING_RESULTS_DIR, op));
      mockFiles.verify(() -> Files.deleteIfExists(Mockito.<Path>any()));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      verify(op).accept(isA(Path.class));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#move(Path, Path, CopyOption[])} return {@link
   *       MetricsPersister#PROFILING_RESULTS_DIR}.
   *   <li>Then calls {@link Files#move(Path, Path, CopyOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test atomicWrite(Path, CheckedConsumer); given Files move(Path, Path, CopyOption[]) return PROFILING_RESULTS_DIR; then calls move(Path, Path, CopyOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicWrite(Path, CheckedConsumer)"})
  void testAtomicWrite_givenFilesMoveReturnProfiling_results_dir_thenCallsMove() throws Throwable {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      CheckedConsumer<Path, IOException> op = mock(CheckedConsumer.class);
      doNothing().when(op).accept(Mockito.<Path>any());

      // Act
      AtomicFiles.atomicWrite(MetricsPersister.PROFILING_RESULTS_DIR, op);

      // Assert
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      verify(op).accept(isA(Path.class));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#move(Path, Path, CopyOption[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test atomicWrite(Path, CheckedConsumer); given Files move(Path, Path, CopyOption[]) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicWrite(Path, CheckedConsumer)"})
  void testAtomicWrite_givenFilesMoveThrowIOException_thenThrowIOException() throws Throwable {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.deleteIfExists(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(new IOException());

      CheckedConsumer<Path, IOException> op = mock(CheckedConsumer.class);
      doNothing().when(op).accept(Mockito.<Path>any());

      // Act and Assert
      assertThrows(
          IOException.class,
          () -> AtomicFiles.atomicWrite(MetricsPersister.PROFILING_RESULTS_DIR, op));
      mockFiles.verify(() -> Files.deleteIfExists(Mockito.<Path>any()));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      verify(op).accept(isA(Path.class));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>When {@link CheckedConsumer} {@link CheckedConsumer#accept(Object)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test atomicWrite(Path, CheckedConsumer); given IOException(); when CheckedConsumer accept(Object) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicWrite(Path, CheckedConsumer)"})
  void testAtomicWrite_givenIOException_whenCheckedConsumerAcceptThrowIOException()
      throws Throwable {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.deleteIfExists(Mockito.<Path>any())).thenReturn(true);

      CheckedConsumer<Path, IOException> op = mock(CheckedConsumer.class);
      doThrow(new IOException()).when(op).accept(Mockito.<Path>any());

      // Act and Assert
      assertThrows(
          IOException.class,
          () -> AtomicFiles.atomicWrite(MetricsPersister.PROFILING_RESULTS_DIR, op));
      mockFiles.verify(() -> Files.deleteIfExists(Mockito.<Path>any()));
      verify(op).accept(isA(Path.class));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}.
   *
   * <ul>
   *   <li>Given {@link InterruptedException#InterruptedException()}.
   *   <li>Then throw {@link InterruptedException}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test atomicWrite(Path, CheckedConsumer); given InterruptedException(); then throw InterruptedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicWrite(Path, CheckedConsumer)"})
  void testAtomicWrite_givenInterruptedException_thenThrowInterruptedException() throws Throwable {
    // Arrange
    CheckedConsumer<Path, IOException> op = mock(CheckedConsumer.class);
    doThrow(new InterruptedException()).when(op).accept(Mockito.<Path>any());

    // Act and Assert
    assertThrows(
        InterruptedException.class,
        () -> AtomicFiles.atomicWrite(MetricsPersister.PROFILING_RESULTS_DIR, op));
    verify(op).accept(isA(Path.class));
  }

  /**
   * Test {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}.
   *
   * <ul>
   *   <li>Then throw {@link AtomicMoveNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicWrite(Path, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test atomicWrite(Path, CheckedConsumer); then throw AtomicMoveNotSupportedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicWrite(Path, CheckedConsumer)"})
  void testAtomicWrite_thenThrowAtomicMoveNotSupportedException() throws Throwable {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.deleteIfExists(Mockito.<Path>any())).thenReturn(true);
      AtomicMoveNotSupportedException atomicMoveNotSupportedException =
          new AtomicMoveNotSupportedException("foo", "foo", "foo");
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(atomicMoveNotSupportedException);

      CheckedConsumer<Path, IOException> op = mock(CheckedConsumer.class);
      doNothing().when(op).accept(Mockito.<Path>any());

      // Act and Assert
      assertThrows(
          AtomicMoveNotSupportedException.class,
          () -> AtomicFiles.atomicWrite(MetricsPersister.PROFILING_RESULTS_DIR, op));
      mockFiles.verify(() -> Files.deleteIfExists(Mockito.<Path>any()));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)),
          atLeast(1));
      verify(op).accept(isA(Path.class));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicMove(Path, Path, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#move(Path, Path, CopyOption[])} return {@link
   *       MetricsPersister#PROFILING_RESULTS_DIR}.
   *   <li>When {@code false}.
   *   <li>Then calls {@link Files#move(Path, Path, CopyOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicMove(Path, Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test atomicMove(Path, Path, boolean); given Files move(Path, Path, CopyOption[]) return PROFILING_RESULTS_DIR; when 'false'; then calls move(Path, Path, CopyOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicMove(Path, Path, boolean)"})
  void testAtomicMove_givenFilesMoveReturnProfiling_results_dir_whenFalse_thenCallsMove()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act
      AtomicFiles.atomicMove(
          MetricsPersister.PROFILING_RESULTS_DIR, MetricsPersister.PROFILING_RESULTS_DIR, false);

      // Assert
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicMove(Path, Path, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#move(Path, Path, CopyOption[])} return {@link
   *       MetricsPersister#PROFILING_RESULTS_DIR}.
   *   <li>When {@code true}.
   *   <li>Then calls {@link Files#move(Path, Path, CopyOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicMove(Path, Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test atomicMove(Path, Path, boolean); given Files move(Path, Path, CopyOption[]) return PROFILING_RESULTS_DIR; when 'true'; then calls move(Path, Path, CopyOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicMove(Path, Path, boolean)"})
  void testAtomicMove_givenFilesMoveReturnProfiling_results_dir_whenTrue_thenCallsMove()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act
      AtomicFiles.atomicMove(
          MetricsPersister.PROFILING_RESULTS_DIR, MetricsPersister.PROFILING_RESULTS_DIR, true);

      // Assert
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicMove(Path, Path, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#move(Path, Path, CopyOption[])} throw {@link
   *       IOException#IOException()}.
   *   <li>When {@code true}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicMove(Path, Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test atomicMove(Path, Path, boolean); given Files move(Path, Path, CopyOption[]) throw IOException(); when 'true'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicMove(Path, Path, boolean)"})
  void testAtomicMove_givenFilesMoveThrowIOException_whenTrue_thenThrowIOException()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(new IOException());

      // Act and Assert
      assertThrows(
          IOException.class,
          () ->
              AtomicFiles.atomicMove(
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  true));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicMove(Path, Path, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link AtomicMoveNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicMove(Path, Path, boolean)}
   */
  @Test
  @DisplayName("Test atomicMove(Path, Path, boolean); then throw AtomicMoveNotSupportedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicMove(Path, Path, boolean)"})
  void testAtomicMove_thenThrowAtomicMoveNotSupportedException() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      AtomicMoveNotSupportedException atomicMoveNotSupportedException =
          new AtomicMoveNotSupportedException("foo", "foo", "foo");
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(atomicMoveNotSupportedException);

      // Act and Assert
      assertThrows(
          AtomicMoveNotSupportedException.class,
          () ->
              AtomicFiles.atomicMove(
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  true));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)),
          atLeast(1));
    }
  }

  /**
   * Test {@link AtomicFiles#atomicMove(Path, Path, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link AtomicMoveNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link AtomicFiles#atomicMove(Path, Path, boolean)}
   */
  @Test
  @DisplayName("Test atomicMove(Path, Path, boolean); then throw AtomicMoveNotSupportedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AtomicFiles.atomicMove(Path, Path, boolean)"})
  void testAtomicMove_thenThrowAtomicMoveNotSupportedException2() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      AtomicMoveNotSupportedException atomicMoveNotSupportedException =
          new AtomicMoveNotSupportedException("foo", "foo", "foo");
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(atomicMoveNotSupportedException);

      // Act and Assert
      assertThrows(
          AtomicMoveNotSupportedException.class,
          () ->
              AtomicFiles.atomicMove(
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  false));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)),
          atLeast(1));
    }
  }
}
