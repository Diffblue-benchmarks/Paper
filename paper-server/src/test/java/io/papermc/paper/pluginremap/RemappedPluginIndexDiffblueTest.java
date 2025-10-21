package io.papermc.paper.pluginremap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class RemappedPluginIndexDiffblueTest {
  /**
   * Test {@link RemappedPluginIndex#RemappedPluginIndex(Path, boolean)}.
   *
   * <ul>
   *   <li>Given {@link FileReader#FileReader(FileDescriptor)} with {@link
   *       FileDescriptor#FileDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link RemappedPluginIndex#RemappedPluginIndex(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test new RemappedPluginIndex(Path, boolean); given FileReader(FileDescriptor) with FileDescriptor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemappedPluginIndex.<init>(Path, boolean)"})
  void testNewRemappedPluginIndex_givenFileReaderWithFileDescriptor() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.newBufferedReader(Mockito.<Path>any()))
          .thenReturn(new BufferedReader(new FileReader(new FileDescriptor()), 1));
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () -> new RemappedPluginIndex(MetricsPersister.PROFILING_RESULTS_DIR, true));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newBufferedReader(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link RemappedPluginIndex#RemappedPluginIndex(Path, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link Files#createDirectories(Path, FileAttribute[])}.
   * </ul>
   *
   * <p>Method under test: {@link RemappedPluginIndex#RemappedPluginIndex(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test new RemappedPluginIndex(Path, boolean); then calls createDirectories(Path, FileAttribute[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemappedPluginIndex.<init>(Path, boolean)"})
  void testNewRemappedPluginIndex_thenCallsCreateDirectories() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.newBufferedReader(Mockito.<Path>any()))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () -> new RemappedPluginIndex(MetricsPersister.PROFILING_RESULTS_DIR, true));
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newBufferedReader(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link RemappedPluginIndex#RemappedPluginIndex(Path, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RemappedPluginIndex#RemappedPluginIndex(Path, boolean)}
   */
  @Test
  @DisplayName("Test new RemappedPluginIndex(Path, boolean); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemappedPluginIndex.<init>(Path, boolean)"})
  void testNewRemappedPluginIndex_thenThrowRuntimeException() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.newBufferedReader(Mockito.<Path>any()))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () -> new RemappedPluginIndex(MetricsPersister.PROFILING_RESULTS_DIR, true));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newBufferedReader(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link RemappedPluginIndex#RemappedPluginIndex(Path, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link UncheckedIOException}.
   * </ul>
   *
   * <p>Method under test: {@link RemappedPluginIndex#RemappedPluginIndex(Path, boolean)}
   */
  @Test
  @DisplayName("Test new RemappedPluginIndex(Path, boolean); then throw UncheckedIOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemappedPluginIndex.<init>(Path, boolean)"})
  void testNewRemappedPluginIndex_thenThrowUncheckedIOException() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(new UncheckedIOException(new IOException()));
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(new UncheckedIOException(new IOException()));
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException());

      // Act and Assert
      assertThrows(
          UncheckedIOException.class,
          () -> new RemappedPluginIndex(MetricsPersister.PROFILING_RESULTS_DIR, true));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }
}
