package io.papermc.paper.plugin.lifecycle.event.handler.configuration;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEvent;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AbstractLifecycleEventHandlerConfigurationDiffblueTest {
  /**
   * Test {@link AbstractLifecycleEventHandlerConfiguration#registerFrom(LifecycleEventOwner)}.
   *
   * <ul>
   *   <li>Then calls {@link AbstractLifecycleEventType#tryRegister(LifecycleEventOwner,
   *       AbstractLifecycleEventHandlerConfiguration)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLifecycleEventHandlerConfiguration#registerFrom(LifecycleEventOwner)}
   */
  @Test
  @DisplayName(
      "Test registerFrom(LifecycleEventOwner); then calls tryRegister(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractLifecycleEventHandlerConfiguration.registerFrom(LifecycleEventOwner)"
  })
  void testRegisterFrom_thenCallsTryRegister() {
    // Arrange
    AbstractLifecycleEventType<LifecycleEventOwner, LifecycleEvent, ?> eventType =
        mock(AbstractLifecycleEventType.class);
    doNothing()
        .when(eventType)
        .tryRegister(
            Mockito.<LifecycleEventOwner>any(),
            Mockito
                .<AbstractLifecycleEventHandlerConfiguration<LifecycleEventOwner, LifecycleEvent>>
                    any());
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>
        monitorLifecycleEventHandlerConfigurationImpl =
            new MonitorLifecycleEventHandlerConfigurationImpl<>(
                mock(LifecycleEventHandler.class), eventType);

    // Act
    monitorLifecycleEventHandlerConfigurationImpl.registerFrom(mock(LifecycleEventOwner.class));

    // Assert
    verify(eventType)
        .tryRegister(
            isA(LifecycleEventOwner.class), isA(AbstractLifecycleEventHandlerConfiguration.class));
  }
}
