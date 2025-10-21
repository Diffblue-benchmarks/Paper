package io.papermc.paper.plugin.provider.source;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.stream.Stream;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class DirectoryProviderSourceDiffblueTest {
  /**
   * Test {@link DirectoryProviderSource#prepareContext(Path)} with {@code context}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryProviderSource#prepareContext(Path)}
   */
  @Test
  @DisplayName(
      "Test prepareContext(Path) with 'context'; given Files isDirectory(Path, LinkOption[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DirectoryProviderSource.prepareContext(Path)"})
  void testPrepareContextWithContext_givenFilesIsDirectoryThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(new IllegalArgumentException());
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IllegalArgumentException());
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), anyInt(), isA(FileVisitOption[].class)))
          .thenThrow(new IllegalArgumentException());

      // Act and Assert
      assertThrows(
          IllegalArgumentException.class,
          () ->
              DirectoryProviderSource.INSTANCE.prepareContext(
                  MetricsPersister.PROFILING_RESULTS_DIR));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }

  /**
   * Test {@link DirectoryProviderSource#prepareContext(Path)} with {@code context}.
   *
   * <ul>
   *   <li>Then calls {@link Files#isRegularFile(Path, LinkOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryProviderSource#prepareContext(Path)}
   */
  @Test
  @DisplayName(
      "Test prepareContext(Path) with 'context'; then calls isRegularFile(Path, LinkOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DirectoryProviderSource.prepareContext(Path)"})
  void testPrepareContextWithContext_thenCallsIsRegularFile() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      ArrayList<Path> pathList = new ArrayList<>();
      pathList.add(MetricsPersister.PROFILING_RESULTS_DIR);
      Stream<Path> streamResult = pathList.stream();
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(new IllegalArgumentException());
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.walk(Mockito.<Path>any(), anyInt(), isA(FileVisitOption[].class)))
          .thenReturn(streamResult);

      // Act and Assert
      assertThrows(
          IllegalArgumentException.class,
          () ->
              DirectoryProviderSource.INSTANCE.prepareContext(
                  MetricsPersister.PROFILING_RESULTS_DIR));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(
          () -> Files.walk(Mockito.<Path>any(), anyInt(), isA(FileVisitOption[].class)));
    }
  }

  /**
   * Test {@link DirectoryProviderSource#isValidFile(Path)}.
   *
   * <ul>
   *   <li>When {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryProviderSource#isValidFile(Path)}
   */
  @Test
  @DisplayName("Test isValidFile(Path); when PROFILING_RESULTS_DIR; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectoryProviderSource.isValidFile(Path)"})
  void testIsValidFile_whenProfiling_results_dir_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        DirectoryProviderSource.INSTANCE.isValidFile(MetricsPersister.PROFILING_RESULTS_DIR));
  }
}
