package io.papermc.paper.plugin.lifecycle.event.handler.configuration;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEvent;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AbstractLifecycleEventHandlerConfigurationDiffblueTest {
  @Mock
  private AbstractLifecycleEventType<LifecycleEventOwner, LifecycleEvent, ?>
      abstractLifecycleEventType;

  /**
   * Test {@link AbstractLifecycleEventHandlerConfiguration#registerFrom(LifecycleEventOwner)}.
   *
   * <p>Method under test: {@link
   * AbstractLifecycleEventHandlerConfiguration#registerFrom(LifecycleEventOwner)}
   */
  @Test
  @DisplayName("Test registerFrom(LifecycleEventOwner)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractLifecycleEventHandlerConfiguration.registerFrom(LifecycleEventOwner)"
  })
  void testRegisterFrom() {
    // Arrange
    doNothing()
        .when(abstractLifecycleEventType)
        .tryRegister(
            Mockito.<LifecycleEventOwner>any(),
            Mockito
                .<AbstractLifecycleEventHandlerConfiguration<LifecycleEventOwner, LifecycleEvent>>
                    any());
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>
        monitorLifecycleEventHandlerConfigurationImpl =
            new MonitorLifecycleEventHandlerConfigurationImpl<>(
                mock(LifecycleEventHandler.class), abstractLifecycleEventType);
    PluginBootstrapContextImpl pluginBootstrapContextImpl =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    monitorLifecycleEventHandlerConfigurationImpl.registerFrom(pluginBootstrapContextImpl);

    // Assert
    verify(abstractLifecycleEventType)
        .tryRegister(
            isA(LifecycleEventOwner.class), isA(AbstractLifecycleEventHandlerConfiguration.class));
  }
}
