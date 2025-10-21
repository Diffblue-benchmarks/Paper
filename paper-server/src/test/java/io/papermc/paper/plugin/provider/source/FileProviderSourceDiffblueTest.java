package io.papermc.paper.plugin.provider.source;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.EntrypointHandler;
import io.papermc.paper.plugin.entrypoint.LaunchEntryPointHandler;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FileProviderSourceDiffblueTest {
  /**
   * Test {@link FileProviderSource#prepareContext(Path)} with {@code context}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FileProviderSource#prepareContext(Path)}
   */
  @Test
  @DisplayName(
      "Test prepareContext(Path) with 'context'; given Function apply(Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path FileProviderSource.prepareContext(Path)"})
  void testPrepareContextWithContext_givenFunctionApplyThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    Function<Path, String> contextChecker = mock(Function.class);
    when(contextChecker.apply(Mockito.<Path>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FileProviderSource(contextChecker)
                .prepareContext(MetricsPersister.PROFILING_RESULTS_DIR));
    verify(contextChecker).apply(isA(Path.class));
  }

  /**
   * Test {@link FileProviderSource#prepareContext(Path)} with {@code context}.
   *
   * <ul>
   *   <li>When {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   * </ul>
   *
   * <p>Method under test: {@link FileProviderSource#prepareContext(Path)}
   */
  @Test
  @DisplayName("Test prepareContext(Path) with 'context'; when PROFILING_RESULTS_DIR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path FileProviderSource.prepareContext(Path)"})
  void testPrepareContextWithContext_whenProfiling_results_dir() throws IOException {
    // Arrange
    Function<Path, String> contextChecker = mock(Function.class);
    when(contextChecker.apply(Mockito.<Path>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FileProviderSource(contextChecker)
                .prepareContext(MetricsPersister.PROFILING_RESULTS_DIR));
    verify(contextChecker).apply(isA(Path.class));
  }

  /**
   * Test {@link FileProviderSource#prepareContext(Path)} with {@code context}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link FileProviderSource#prepareContext(Path)}
   */
  @Test
  @DisplayName(
      "Test prepareContext(Path) with 'context'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path FileProviderSource.prepareContext(Path)"})
  void testPrepareContextWithContext_whenPropertyIsJavaIoTmpdirIsTestTxt() throws IOException {
    // Arrange
    Function<Path, String> contextChecker = mock(Function.class);
    when(contextChecker.apply(Mockito.<Path>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FileProviderSource(contextChecker)
                .prepareContext(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    verify(contextChecker).apply(isA(Path.class));
  }

  /**
   * Test {@link FileProviderSource#registerProviders(EntrypointHandler, Path)} with {@code
   * entrypointHandler}, {@code context}.
   *
   * <p>Method under test: {@link FileProviderSource#registerProviders(EntrypointHandler, Path)}
   */
  @Test
  @DisplayName(
      "Test registerProviders(EntrypointHandler, Path) with 'entrypointHandler', 'context'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileProviderSource.registerProviders(EntrypointHandler, Path)"})
  void testRegisterProvidersWithEntrypointHandlerContext() throws Exception {
    // Arrange
    Function<Path, String> contextChecker = mock(Function.class);
    when(contextChecker.apply(Mockito.<Path>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FileProviderSource(contextChecker)
                .registerProviders(
                    LaunchEntryPointHandler.INSTANCE, MetricsPersister.PROFILING_RESULTS_DIR));
    verify(contextChecker).apply(isA(Path.class));
  }
}
