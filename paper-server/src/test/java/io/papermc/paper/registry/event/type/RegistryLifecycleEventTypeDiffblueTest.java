package io.papermc.paper.registry.event.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.event.RegistryEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryLifecycleEventTypeDiffblueTest {
  /**
   * Test {@link RegistryLifecycleEventType#RegistryLifecycleEventType(RegistryKey, String)}.
   *
   * <p>Method under test: {@link RegistryLifecycleEventType#RegistryLifecycleEventType(RegistryKey,
   * String)}
   */
  @Test
  @DisplayName("Test new RegistryLifecycleEventType(RegistryKey, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegistryLifecycleEventType.<init>(RegistryKey, String)"})
  void testNewRegistryLifecycleEventType() {
    // Arrange and Act
    RegistryLifecycleEventType<Object, RegistryEvent<Object>> actualRegistryLifecycleEventType =
        new RegistryLifecycleEventType<>(null, "Event Name");

    // Assert
    assertEquals("null / Event Name", actualRegistryLifecycleEventType.name());
    assertFalse(actualRegistryLifecycleEventType.hasHandlers());
  }

  /**
   * Test {@link RegistryLifecycleEventType#blocksReloading(BootstrapContext)} with {@code
   * eventOwner}.
   *
   * <p>Method under test: {@link RegistryLifecycleEventType#blocksReloading(BootstrapContext)}
   */
  @Test
  @DisplayName("Test blocksReloading(BootstrapContext) with 'eventOwner'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryLifecycleEventType.blocksReloading(BootstrapContext)"})
  void testBlocksReloadingWithEventOwner() {
    // Arrange
    RegistryLifecycleEventType<Object, RegistryEvent<Object>> registryLifecycleEventType =
        new RegistryLifecycleEventType<>(null, "Event Name");
    PluginBootstrapContextImpl eventOwner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    boolean actualBlocksReloadingResult = registryLifecycleEventType.blocksReloading(eventOwner);

    // Assert
    assertFalse(actualBlocksReloadingResult);
  }
}
