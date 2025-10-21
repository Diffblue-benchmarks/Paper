package io.papermc.paper.pluginremap;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginRemapperDiffblueTest {
  /**
   * Test {@link PluginRemapper#create(Path)}.
   *
   * <p>Method under test: {@link PluginRemapper#create(Path)}
   */
  @Test
  @DisplayName("Test create(Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PluginRemapper PluginRemapper.create(Path)"})
  void testCreate() {
    // Arrange, Act and Assert
    assertNull(PluginRemapper.create(MetricsPersister.PROFILING_RESULTS_DIR));
  }

  /**
   * Test {@link PluginRemapper#list(Path, Predicate)}.
   *
   * <ul>
   *   <li>When {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PluginRemapper#list(Path, Predicate)}
   */
  @Test
  @DisplayName(
      "Test list(Path, Predicate); when PROFILING_RESULTS_DIR; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PluginRemapper.list(Path, Predicate)"})
  void testList_whenProfiling_results_dir_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> PluginRemapper.list(MetricsPersister.PROFILING_RESULTS_DIR, mock(Predicate.class)));
  }

  /**
   * Test {@link PluginRemapper#list(Path, Predicate)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PluginRemapper#list(Path, Predicate)}
   */
  @Test
  @DisplayName(
      "Test list(Path, Predicate); when Property is 'java.io.tmpdir' is 'test.txt'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PluginRemapper.list(Path, Predicate)"})
  void testList_whenPropertyIsJavaIoTmpdirIsTestTxt_thenReturnEmpty() {
    // Arrange and Act
    List<Path> actualListResult =
        PluginRemapper.list(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(Predicate.class));

    // Assert
    assertTrue(actualListResult.isEmpty());
  }
}
