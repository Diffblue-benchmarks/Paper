package io.papermc.paper.plugin.lifecycle.event.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEvent;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.AbstractLifecycleEventHandlerConfiguration;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.MonitorLifecycleEventHandlerConfigurationImpl;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType.RegisteredHandler;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractLifecycleEventTypeDiffblueTest {
  /**
   * Test {@link AbstractLifecycleEventType#name()}.
   *
   * <p>Method under test: {@link AbstractLifecycleEventType#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractLifecycleEventType.name()"})
  void testName() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);

    // Act and Assert
    assertEquals("Name", monitorableLifecycleEventType.name());
  }

  /**
   * Test {@link AbstractLifecycleEventType#blocksReloading(LifecycleEventOwner)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractLifecycleEventType#blocksReloading(LifecycleEventOwner)}
   */
  @Test
  @DisplayName("Test blocksReloading(LifecycleEventOwner); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractLifecycleEventType.blocksReloading(LifecycleEventOwner)"})
  void testBlocksReloading_thenReturnTrue() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    PluginBootstrapContextImpl pluginBootstrapContextImpl =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    boolean actualBlocksReloadingResult =
        monitorableLifecycleEventType.blocksReloading(pluginBootstrapContextImpl);

    // Assert
    assertTrue(actualBlocksReloadingResult);
  }

  /**
   * Test {@link AbstractLifecycleEventType#blocksReloading(LifecycleEventOwner)}.
   *
   * <ul>
   *   <li>When {@link LifecycleEventOwner}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractLifecycleEventType#blocksReloading(LifecycleEventOwner)}
   */
  @Test
  @DisplayName(
      "Test blocksReloading(LifecycleEventOwner); when LifecycleEventOwner; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractLifecycleEventType.blocksReloading(LifecycleEventOwner)"})
  void testBlocksReloading_whenLifecycleEventOwner_thenReturnFalse() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);

    // Act and Assert
    assertFalse(monitorableLifecycleEventType.blocksReloading(mock(LifecycleEventOwner.class)));
  }

  /**
   * Test {@link AbstractLifecycleEventType#tryRegister(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}.
   *
   * <p>Method under test: {@link AbstractLifecycleEventType#tryRegister(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName("Test tryRegister(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractLifecycleEventType.tryRegister(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)"
  })
  void testTryRegister() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    // Act
    monitorableLifecycleEventType.tryRegister(lifecycleEventOwner, config);

    // Assert
    List<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> registeredHandlerList =
        monitorableLifecycleEventType.handlers;
    assertEquals(1, registeredHandlerList.size());
    assertEquals(1, monitorableLifecycleEventType.nonMonitorIdx);
    assertTrue(monitorableLifecycleEventType.hasHandlers());
    RegisteredHandler<LifecycleEventOwner, LifecycleEvent> getResult = registeredHandlerList.get(0);
    assertSame(config, getResult.config());
    assertSame(lifecycleEventOwner, getResult.owner());
  }

  /**
   * Test {@link AbstractLifecycleEventType#tryRegister(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}.
   *
   * <p>Method under test: {@link AbstractLifecycleEventType#tryRegister(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName("Test tryRegister(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractLifecycleEventType.tryRegister(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)"
  })
  void testTryRegister2() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    PluginBootstrapContextImpl pluginBootstrapContextImpl =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    // Act
    monitorableLifecycleEventType.tryRegister(pluginBootstrapContextImpl, config);

    // Assert
    List<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> registeredHandlerList =
        monitorableLifecycleEventType.handlers;
    assertEquals(1, registeredHandlerList.size());
    assertEquals(1, monitorableLifecycleEventType.nonMonitorIdx);
    assertTrue(monitorableLifecycleEventType.hasHandlers());
    RegisteredHandler<LifecycleEventOwner, LifecycleEvent> getResult = registeredHandlerList.get(0);
    assertSame(pluginBootstrapContextImpl, getResult.owner());
    assertSame(config, getResult.config());
  }

  /**
   * Test {@link AbstractLifecycleEventType#tryRegister(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractLifecycleEventType#tryRegister(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName(
      "Test tryRegister(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractLifecycleEventType.tryRegister(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)"
  })
  void testTryRegister_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> monitorableLifecycleEventType.tryRegister(null, config));
  }
}
