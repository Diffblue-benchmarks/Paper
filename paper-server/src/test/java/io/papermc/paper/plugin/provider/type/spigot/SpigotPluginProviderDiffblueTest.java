package io.papermc.paper.plugin.provider.type.spigot;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.entrypoint.dependency.BootstrapMetaDependencyTree;
import io.papermc.paper.plugin.provider.configuration.LoadOrderConfiguration;
import io.papermc.paper.plugin.provider.entrypoint.DependencyContext;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarFile;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.bukkit.plugin.PluginDescriptionFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpigotPluginProviderDiffblueTest {
  /**
   * Test {@link SpigotPluginProvider#SpigotPluginProvider(Path, JarFile, PluginDescriptionFile,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   * </ul>
   *
   * <p>Method under test: {@link SpigotPluginProvider#SpigotPluginProvider(Path, JarFile,
   * PluginDescriptionFile, List)}
   */
  @Test
  @DisplayName(
      "Test new SpigotPluginProvider(Path, JarFile, PluginDescriptionFile, List); given PROFILING_RESULTS_DIR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpigotPluginProvider.<init>(Path, JarFile, PluginDescriptionFile, List)"
  })
  void testNewSpigotPluginProvider_givenProfiling_results_dir() {
    // Arrange
    Path path = MetricsPersister.PROFILING_RESULTS_DIR;
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    ArrayList<Path> paperLibraryPaths = new ArrayList<>();
    paperLibraryPaths.add(MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    SpigotPluginProvider actualSpigotPluginProvider =
        new SpigotPluginProvider(path, null, description, paperLibraryPaths);

    // Assert
    assertNull(actualSpigotPluginProvider.getLastProvidedStatus());
    assertSame(description, actualSpigotPluginProvider.getMeta());
    assertSame(path, actualSpigotPluginProvider.getSource());
  }

  /**
   * Test {@link SpigotPluginProvider#SpigotPluginProvider(Path, JarFile, PluginDescriptionFile,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   * </ul>
   *
   * <p>Method under test: {@link SpigotPluginProvider#SpigotPluginProvider(Path, JarFile,
   * PluginDescriptionFile, List)}
   */
  @Test
  @DisplayName(
      "Test new SpigotPluginProvider(Path, JarFile, PluginDescriptionFile, List); given PROFILING_RESULTS_DIR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpigotPluginProvider.<init>(Path, JarFile, PluginDescriptionFile, List)"
  })
  void testNewSpigotPluginProvider_givenProfiling_results_dir2() {
    // Arrange
    Path path = MetricsPersister.PROFILING_RESULTS_DIR;
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    ArrayList<Path> paperLibraryPaths = new ArrayList<>();
    paperLibraryPaths.add(MetricsPersister.PROFILING_RESULTS_DIR);
    paperLibraryPaths.add(MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    SpigotPluginProvider actualSpigotPluginProvider =
        new SpigotPluginProvider(path, null, description, paperLibraryPaths);

    // Assert
    assertNull(actualSpigotPluginProvider.getLastProvidedStatus());
    assertSame(description, actualSpigotPluginProvider.getMeta());
    assertSame(path, actualSpigotPluginProvider.getSource());
  }

  /**
   * Test {@link SpigotPluginProvider#SpigotPluginProvider(Path, JarFile, PluginDescriptionFile,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return LastProvidedStatus is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpigotPluginProvider#SpigotPluginProvider(Path, JarFile,
   * PluginDescriptionFile, List)}
   */
  @Test
  @DisplayName(
      "Test new SpigotPluginProvider(Path, JarFile, PluginDescriptionFile, List); when ArrayList(); then return LastProvidedStatus is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpigotPluginProvider.<init>(Path, JarFile, PluginDescriptionFile, List)"
  })
  void testNewSpigotPluginProvider_whenArrayList_thenReturnLastProvidedStatusIsNull() {
    // Arrange
    Path path = MetricsPersister.PROFILING_RESULTS_DIR;
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act
    SpigotPluginProvider actualSpigotPluginProvider =
        new SpigotPluginProvider(path, null, description, new ArrayList<>());

    // Assert
    assertNull(actualSpigotPluginProvider.getLastProvidedStatus());
    assertSame(description, actualSpigotPluginProvider.getMeta());
    assertSame(path, actualSpigotPluginProvider.getSource());
  }

  /**
   * Test {@link SpigotPluginProvider#file()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpigotPluginProvider#file()}
   */
  @Test
  @DisplayName("Test file(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JarFile SpigotPluginProvider.file()"})
  void testFile_thenReturnNull() {
    // Arrange
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    SpigotPluginProvider spigotPluginProvider =
        new SpigotPluginProvider(
            MetricsPersister.PROFILING_RESULTS_DIR, null, description, new ArrayList<>());

    // Act and Assert
    assertNull(spigotPluginProvider.file());
  }

  /**
   * Test {@link SpigotPluginProvider#getMeta()}.
   *
   * <p>Method under test: {@link SpigotPluginProvider#getMeta()}
   */
  @Test
  @DisplayName("Test getMeta()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PluginDescriptionFile SpigotPluginProvider.getMeta()"})
  void testGetMeta() {
    // Arrange
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    SpigotPluginProvider spigotPluginProvider =
        new SpigotPluginProvider(
            MetricsPersister.PROFILING_RESULTS_DIR, null, description, new ArrayList<>());

    // Act and Assert
    assertSame(description, spigotPluginProvider.getMeta());
  }

  /**
   * Test {@link SpigotPluginProvider#createConfiguration(Map)}.
   *
   * <ul>
   *   <li>Then return {@link SpigotLoadOrderConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link SpigotPluginProvider#createConfiguration(Map)}
   */
  @Test
  @DisplayName("Test createConfiguration(Map); then return SpigotLoadOrderConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LoadOrderConfiguration SpigotPluginProvider.createConfiguration(Map)"})
  void testCreateConfiguration_thenReturnSpigotLoadOrderConfiguration() {
    // Arrange
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    SpigotPluginProvider spigotPluginProvider =
        new SpigotPluginProvider(
            MetricsPersister.PROFILING_RESULTS_DIR, null, description, new ArrayList<>());

    // Act
    LoadOrderConfiguration actualCreateConfigurationResult =
        spigotPluginProvider.createConfiguration(new HashMap<>());

    // Assert
    assertTrue(actualCreateConfigurationResult instanceof SpigotLoadOrderConfiguration);
    PluginMeta meta = actualCreateConfigurationResult.getMeta();
    assertTrue(meta instanceof PluginDescriptionFile);
    assertTrue(actualCreateConfigurationResult.getLoadAfter().isEmpty());
    assertTrue(actualCreateConfigurationResult.getLoadBefore().isEmpty());
    assertSame(description, meta);
  }

  /**
   * Test {@link SpigotPluginProvider#validateDependencies(DependencyContext)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SpigotPluginProvider#validateDependencies(DependencyContext)}
   */
  @Test
  @DisplayName("Test validateDependencies(DependencyContext); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SpigotPluginProvider.validateDependencies(DependencyContext)"})
  void testValidateDependencies_thenReturnEmpty() {
    // Arrange
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    SpigotPluginProvider spigotPluginProvider =
        new SpigotPluginProvider(
            MetricsPersister.PROFILING_RESULTS_DIR, null, description, new ArrayList<>());

    // Act and Assert
    assertTrue(
        spigotPluginProvider.validateDependencies(new BootstrapMetaDependencyTree()).isEmpty());
  }
}
