package io.papermc.paper.plugin.bootstrap;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.TestPluginMeta;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.nio.file.Path;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginProviderContextImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginProviderContextImpl#PluginProviderContextImpl(PluginMeta, Path,
   *       ComponentLogger, Path)}
   *   <li>{@link PluginProviderContextImpl#getConfiguration()}
   *   <li>{@link PluginProviderContextImpl#getDataDirectory()}
   *   <li>{@link PluginProviderContextImpl#getLogger()}
   *   <li>{@link PluginProviderContextImpl#getPluginSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginProviderContextImpl.<init>(PluginMeta, Path, ComponentLogger, Path)",
    "PluginMeta PluginProviderContextImpl.getConfiguration()",
    "Path PluginProviderContextImpl.getDataDirectory()",
    "ComponentLogger PluginProviderContextImpl.getLogger()",
    "Path PluginProviderContextImpl.getPluginSource()"
  })
  void testGettersAndSetters() {
    // Arrange
    PaperPluginMeta config = new PaperPluginMeta();
    ComponentLogger logger = MinecraftServer.COMPONENT_LOGGER;
    Path pluginSource = MetricsPersister.PROFILING_RESULTS_DIR;

    // Act
    PluginProviderContextImpl actualPluginProviderContextImpl =
        new PluginProviderContextImpl(
            config, MetricsPersister.PROFILING_RESULTS_DIR, logger, pluginSource);
    PluginMeta actualConfiguration = actualPluginProviderContextImpl.getConfiguration();
    Path actualDataDirectory = actualPluginProviderContextImpl.getDataDirectory();
    ComponentLogger actualLogger = actualPluginProviderContextImpl.getLogger();

    // Assert
    assertSame(config, actualConfiguration);
    assertSame(logger, actualLogger);
    assertSame(pluginSource, actualDataDirectory);
    assertSame(pluginSource, actualPluginProviderContextImpl.getPluginSource());
  }

  /**
   * Test {@link PluginProviderContextImpl#create(PluginMeta, ComponentLogger, Path)}.
   *
   * <ul>
   *   <li>Then Configuration return {@link TestPluginMeta}.
   * </ul>
   *
   * <p>Method under test: {@link PluginProviderContextImpl#create(PluginMeta, ComponentLogger,
   * Path)}
   */
  @Test
  @DisplayName(
      "Test create(PluginMeta, ComponentLogger, Path); then Configuration return TestPluginMeta")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginProviderContextImpl PluginProviderContextImpl.create(PluginMeta, ComponentLogger, Path)"
  })
  void testCreate_thenConfigurationReturnTestPluginMeta() {
    // Arrange
    TestPluginMeta config = new TestPluginMeta("42");
    ComponentLogger logger = MinecraftServer.COMPONENT_LOGGER;
    Path pluginSource = MetricsPersister.PROFILING_RESULTS_DIR;

    // Act
    PluginProviderContextImpl actualCreateResult =
        PluginProviderContextImpl.create(config, logger, pluginSource);

    // Assert
    PluginMeta configuration = actualCreateResult.getConfiguration();
    assertTrue(configuration instanceof TestPluginMeta);
    assertSame(config, configuration);
    assertSame(logger, actualCreateResult.getLogger());
    assertSame(pluginSource, actualCreateResult.getPluginSource());
  }
}
