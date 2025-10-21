package io.papermc.paper.plugin;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import joptsimple.OptionSet;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PluginInitializerManagerDiffblueTest {
  /**
   * Test {@link PluginInitializerManager#PluginInitializerManager(Path, Path)}.
   *
   * <ul>
   *   <li>When {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   * </ul>
   *
   * <p>Method under test: {@link PluginInitializerManager#PluginInitializerManager(Path, Path)}
   */
  @Test
  @DisplayName("Test new PluginInitializerManager(Path, Path); when PROFILING_RESULTS_DIR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginInitializerManager.<init>(Path, Path)"})
  void testNewPluginInitializerManager_whenProfiling_results_dir() {
    // Arrange, Act and Assert
    assertNull(
        new PluginInitializerManager(
                MetricsPersister.PROFILING_RESULTS_DIR, MetricsPersister.PROFILING_RESULTS_DIR)
            .pluginRemapper);
  }

  /**
   * Test {@link PluginInitializerManager#PluginInitializerManager(Path, Path)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link PluginInitializerManager#PluginInitializerManager(Path, Path)}
   */
  @Test
  @DisplayName(
      "Test new PluginInitializerManager(Path, Path); when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginInitializerManager.<init>(Path, Path)"})
  void testNewPluginInitializerManager_whenPropertyIsJavaIoTmpdirIsTestTxt() {
    // Arrange
    Path pluginDirectory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertNull(
        new PluginInitializerManager(pluginDirectory, MetricsPersister.PROFILING_RESULTS_DIR)
            .pluginRemapper);
  }

  /**
   * Test {@link PluginInitializerManager#init(OptionSet)}.
   *
   * <ul>
   *   <li>Given {@link OldUsersConverter#OLD_IPBANLIST}.
   *   <li>When {@link OptionSet} {@link OptionSet#valueOf(String)} return {@link
   *       OldUsersConverter#OLD_IPBANLIST}.
   * </ul>
   *
   * <p>Method under test: {@link PluginInitializerManager#init(OptionSet)}
   */
  @Test
  @DisplayName(
      "Test init(OptionSet); given OLD_IPBANLIST; when OptionSet valueOf(String) return OLD_IPBANLIST")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PluginInitializerManager PluginInitializerManager.init(OptionSet)"})
  void testInit_givenOld_ipbanlist_whenOptionSetValueOfReturnOld_ipbanlist() throws Exception {
    // Arrange
    OptionSet optionSet = mock(OptionSet.class);
    when(optionSet.valueOf(Mockito.<String>any())).thenReturn(OldUsersConverter.OLD_IPBANLIST);

    // Act
    PluginInitializerManager actualInitResult = PluginInitializerManager.init(optionSet);

    // Assert
    verify(optionSet, atLeast(1)).valueOf(Mockito.<String>any());
    assertNull(actualInitResult.pluginRemapper);
  }

  /**
   * Test {@link PluginInitializerManager#init(OptionSet)}.
   *
   * <ul>
   *   <li>Given {@link OldUsersConverter#OLD_OPLIST}.
   *   <li>When {@link OptionSet} {@link OptionSet#valueOf(String)} return {@link
   *       OldUsersConverter#OLD_OPLIST}.
   * </ul>
   *
   * <p>Method under test: {@link PluginInitializerManager#init(OptionSet)}
   */
  @Test
  @DisplayName(
      "Test init(OptionSet); given OLD_OPLIST; when OptionSet valueOf(String) return OLD_OPLIST")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PluginInitializerManager PluginInitializerManager.init(OptionSet)"})
  void testInit_givenOld_oplist_whenOptionSetValueOfReturnOld_oplist() throws Exception {
    // Arrange
    OptionSet optionSet = mock(OptionSet.class);
    when(optionSet.valueOf(Mockito.<String>any())).thenReturn(OldUsersConverter.OLD_OPLIST);

    // Act
    PluginInitializerManager actualInitResult = PluginInitializerManager.init(optionSet);

    // Assert
    verify(optionSet, atLeast(1)).valueOf(Mockito.<String>any());
    assertNull(actualInitResult.pluginRemapper);
  }

  /**
   * Test {@link PluginInitializerManager#instance()}.
   *
   * <p>Method under test: {@link PluginInitializerManager#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PluginInitializerManager PluginInitializerManager.instance()"})
  void testInstance() {
    // Arrange, Act and Assert
    assertNull(PluginInitializerManager.instance().pluginRemapper);
  }

  /**
   * Test {@link PluginInitializerManager#pluginUpdatePath()}.
   *
   * <p>Method under test: {@link PluginInitializerManager#pluginUpdatePath()}
   */
  @Test
  @DisplayName("Test pluginUpdatePath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path PluginInitializerManager.pluginUpdatePath()"})
  void testPluginUpdatePath() {
    // Arrange, Act and Assert
    assertNull(PluginInitializerManager.instance().pluginUpdatePath());
  }
}
