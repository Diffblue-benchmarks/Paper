package io.papermc.paper.plugin.lifecycle.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.LifecycleEventHandlerConfiguration;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.MonitorLifecycleEventHandlerConfigurationImpl;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.PrioritizedLifecycleEventHandlerConfigurationImpl;
import io.papermc.paper.plugin.lifecycle.event.types.MonitorableLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.PrioritizableLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.PrioritizableLifecycleEventType.Simple;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.util.function.BooleanSupplier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperLifecycleEventManagerDiffblueTest {
  /**
   * Test {@link
   * PaperLifecycleEventManager#registerEventHandler(LifecycleEventHandlerConfiguration)} with
   * {@code handlerConfiguration}.
   *
   * <p>Method under test: {@link
   * PaperLifecycleEventManager#registerEventHandler(LifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName(
      "Test registerEventHandler(LifecycleEventHandlerConfiguration) with 'handlerConfiguration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperLifecycleEventManager.registerEventHandler(LifecycleEventHandlerConfiguration)"
  })
  void testRegisterEventHandlerWithHandlerConfiguration() {
    // Arrange
    BooleanSupplier registrationCheck = mock(BooleanSupplier.class);
    when(registrationCheck.getAsBoolean()).thenReturn(true);
    PluginBootstrapContextImpl pluginBootstrapContextImpl =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    PaperLifecycleEventManager<LifecycleEventOwner> paperLifecycleEventManager =
        new PaperLifecycleEventManager<>(pluginBootstrapContextImpl, registrationCheck);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<? super LifecycleEventOwner, LifecycleEvent>
        handlerConfiguration =
            new MonitorLifecycleEventHandlerConfigurationImpl<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));

    // Act
    paperLifecycleEventManager.registerEventHandler(handlerConfiguration);

    // Assert
    verify(registrationCheck).getAsBoolean();
  }

  /**
   * Test {@link
   * PaperLifecycleEventManager#registerEventHandler(LifecycleEventHandlerConfiguration)} with
   * {@code handlerConfiguration}.
   *
   * <p>Method under test: {@link
   * PaperLifecycleEventManager#registerEventHandler(LifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName(
      "Test registerEventHandler(LifecycleEventHandlerConfiguration) with 'handlerConfiguration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperLifecycleEventManager.registerEventHandler(LifecycleEventHandlerConfiguration)"
  })
  void testRegisterEventHandlerWithHandlerConfiguration2() {
    // Arrange
    BooleanSupplier registrationCheck = mock(BooleanSupplier.class);
    when(registrationCheck.getAsBoolean()).thenReturn(true);
    PaperLifecycleEventManager<LifecycleEventOwner> paperLifecycleEventManager =
        new PaperLifecycleEventManager<>(mock(LifecycleEventOwner.class), registrationCheck);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    PrioritizedLifecycleEventHandlerConfigurationImpl<? super LifecycleEventOwner, LifecycleEvent>
        handlerConfiguration =
            new PrioritizedLifecycleEventHandlerConfigurationImpl<>(
                handler, new Simple<>("Name", ownerType));

    // Act
    paperLifecycleEventManager.registerEventHandler(handlerConfiguration);

    // Assert
    verify(registrationCheck).getAsBoolean();
  }

  /**
   * Test {@link
   * PaperLifecycleEventManager#registerEventHandler(LifecycleEventHandlerConfiguration)} with
   * {@code handlerConfiguration}.
   *
   * <ul>
   *   <li>Then calls {@link BooleanSupplier#getAsBoolean()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperLifecycleEventManager#registerEventHandler(LifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName(
      "Test registerEventHandler(LifecycleEventHandlerConfiguration) with 'handlerConfiguration'; then calls getAsBoolean()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperLifecycleEventManager.registerEventHandler(LifecycleEventHandlerConfiguration)"
  })
  void testRegisterEventHandlerWithHandlerConfiguration_thenCallsGetAsBoolean() {
    // Arrange
    BooleanSupplier registrationCheck = mock(BooleanSupplier.class);
    when(registrationCheck.getAsBoolean()).thenReturn(true);
    PaperLifecycleEventManager<LifecycleEventOwner> paperLifecycleEventManager =
        new PaperLifecycleEventManager<>(mock(LifecycleEventOwner.class), registrationCheck);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<? super LifecycleEventOwner, LifecycleEvent>
        handlerConfiguration =
            new MonitorLifecycleEventHandlerConfigurationImpl<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));

    // Act
    paperLifecycleEventManager.registerEventHandler(handlerConfiguration);

    // Assert
    verify(registrationCheck).getAsBoolean();
  }
}
