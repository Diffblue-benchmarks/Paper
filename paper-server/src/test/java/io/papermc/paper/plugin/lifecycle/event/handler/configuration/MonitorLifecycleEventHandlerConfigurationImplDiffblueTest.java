package io.papermc.paper.plugin.lifecycle.event.handler.configuration;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEvent;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.MonitorableLifecycleEventType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MonitorLifecycleEventHandlerConfigurationImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       MonitorLifecycleEventHandlerConfigurationImpl#MonitorLifecycleEventHandlerConfigurationImpl(LifecycleEventHandler,
   *       AbstractLifecycleEventType)}
   *   <li>{@link MonitorLifecycleEventHandlerConfigurationImpl#monitor()}
   *   <li>{@link MonitorLifecycleEventHandlerConfigurationImpl#isMonitor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MonitorLifecycleEventHandlerConfigurationImpl.<init>(LifecycleEventHandler, AbstractLifecycleEventType)",
    "boolean MonitorLifecycleEventHandlerConfigurationImpl.isMonitor()",
    "MonitorLifecycleEventHandlerConfiguration MonitorLifecycleEventHandlerConfigurationImpl.monitor()"
  })
  void testGettersAndSetters() {
    // Arrange
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    // Act
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>
        actualMonitorLifecycleEventHandlerConfigurationImpl =
            new MonitorLifecycleEventHandlerConfigurationImpl<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));
    MonitorLifecycleEventHandlerConfiguration<LifecycleEventOwner> actualMonitorResult =
        actualMonitorLifecycleEventHandlerConfigurationImpl.monitor();

    // Assert
    assertTrue(actualMonitorLifecycleEventHandlerConfigurationImpl.isMonitor());
    assertSame(actualMonitorLifecycleEventHandlerConfigurationImpl, actualMonitorResult);
  }
}
