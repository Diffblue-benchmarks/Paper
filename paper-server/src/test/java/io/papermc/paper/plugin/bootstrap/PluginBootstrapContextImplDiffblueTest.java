package io.papermc.paper.plugin.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.TestJavaPluginProvider;
import io.papermc.paper.plugin.TestPluginMeta;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.PaperLifecycleEventManager;
import io.papermc.paper.plugin.provider.PluginProvider;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.io.File;
import java.nio.file.Path;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginBootstrapContextImplDiffblueTest {
  /**
   * Test {@link PluginBootstrapContextImpl#PluginBootstrapContextImpl(PluginMeta, Path,
   * ComponentLogger, Path)}.
   *
   * <p>Method under test: {@link PluginBootstrapContextImpl#PluginBootstrapContextImpl(PluginMeta,
   * Path, ComponentLogger, Path)}
   */
  @Test
  @DisplayName("Test new PluginBootstrapContextImpl(PluginMeta, Path, ComponentLogger, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginBootstrapContextImpl.<init>(PluginMeta, Path, ComponentLogger, Path)"
  })
  void testNewPluginBootstrapContextImpl() {
    // Arrange
    PaperPluginMeta config = new PaperPluginMeta();
    ComponentLogger logger = MinecraftServer.COMPONENT_LOGGER;
    Path pluginSource = MetricsPersister.PROFILING_RESULTS_DIR;

    // Act
    PluginBootstrapContextImpl actualPluginBootstrapContextImpl =
        new PluginBootstrapContextImpl(
            config, MetricsPersister.PROFILING_RESULTS_DIR, logger, pluginSource);

    // Assert
    assertTrue(
        actualPluginBootstrapContextImpl.getLifecycleManager()
            instanceof PaperLifecycleEventManager);
    PluginMeta configuration = actualPluginBootstrapContextImpl.getConfiguration();
    assertTrue(configuration instanceof PaperPluginMeta);
    assertSame(config, configuration);
    assertSame(config, actualPluginBootstrapContextImpl.getPluginMeta());
    assertSame(logger, actualPluginBootstrapContextImpl.getLogger());
    assertSame(pluginSource, actualPluginBootstrapContextImpl.getDataDirectory());
    assertSame(pluginSource, actualPluginBootstrapContextImpl.getPluginSource());
  }

  /**
   * Test {@link PluginBootstrapContextImpl#create(PluginProvider, Path)}.
   *
   * <ul>
   *   <li>Then Configuration return {@link TestPluginMeta}.
   * </ul>
   *
   * <p>Method under test: {@link PluginBootstrapContextImpl#create(PluginProvider, Path)}
   */
  @Test
  @DisplayName("Test create(PluginProvider, Path); then Configuration return TestPluginMeta")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginBootstrapContextImpl PluginBootstrapContextImpl.create(PluginProvider, Path)"
  })
  void testCreate_thenConfigurationReturnTestPluginMeta() {
    // Arrange
    TestPluginMeta testPluginConfiguration = new TestPluginMeta("42");

    // Act
    PluginBootstrapContextImpl actualCreateResult =
        PluginBootstrapContextImpl.create(
            new TestJavaPluginProvider(testPluginConfiguration),
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Assert
    PluginMeta configuration = actualCreateResult.getConfiguration();
    assertTrue(configuration instanceof TestPluginMeta);
    assertTrue(actualCreateResult.getLifecycleManager() instanceof PaperLifecycleEventManager);
    assertSame(testPluginConfiguration, configuration);
    assertSame(testPluginConfiguration, actualCreateResult.getPluginMeta());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginBootstrapContextImpl#lockLifecycleEventRegistration()}
   *   <li>{@link PluginBootstrapContextImpl#getConfiguration()}
   *   <li>{@link PluginBootstrapContextImpl#getDataDirectory()}
   *   <li>{@link PluginBootstrapContextImpl#getLifecycleManager()}
   *   <li>{@link PluginBootstrapContextImpl#getLogger()}
   *   <li>{@link PluginBootstrapContextImpl#getPluginMeta()}
   *   <li>{@link PluginBootstrapContextImpl#getPluginSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMeta PluginBootstrapContextImpl.getConfiguration()",
    "Path PluginBootstrapContextImpl.getDataDirectory()",
    "LifecycleEventManager PluginBootstrapContextImpl.getLifecycleManager()",
    "ComponentLogger PluginBootstrapContextImpl.getLogger()",
    "PluginMeta PluginBootstrapContextImpl.getPluginMeta()",
    "Path PluginBootstrapContextImpl.getPluginSource()",
    "void PluginBootstrapContextImpl.lockLifecycleEventRegistration()"
  })
  void testGettersAndSetters() {
    // Arrange
    TestPluginMeta testPluginConfiguration = new TestPluginMeta("42");
    PluginBootstrapContextImpl createResult =
        PluginBootstrapContextImpl.create(
            new TestJavaPluginProvider(testPluginConfiguration),
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    createResult.lockLifecycleEventRegistration();
    PluginMeta actualConfiguration = createResult.getConfiguration();
    Path actualDataDirectory = createResult.getDataDirectory();
    LifecycleEventManager<BootstrapContext> actualLifecycleManager =
        createResult.getLifecycleManager();
    createResult.getLogger();
    PluginMeta actualPluginMeta = createResult.getPluginMeta();

    // Assert
    assertTrue(actualLifecycleManager instanceof PaperLifecycleEventManager);
    File toFileResult = actualDataDirectory.toFile();
    assertEquals("42", toFileResult.getName());
    File toFileResult2 = createResult.getPluginSource().toFile();
    assertEquals("dummy", toFileResult2.getName());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(toFileResult2.isAbsolute());
    assertSame(testPluginConfiguration, actualConfiguration);
    assertSame(testPluginConfiguration, actualPluginMeta);
  }
}
