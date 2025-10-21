package io.papermc.paper.registry.event.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.MonitorableLifecycleEventType;
import io.papermc.paper.registry.RegistryBuilder;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.event.RegistryEntryAddEvent;
import java.util.OptionalInt;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryEntryAddHandlerConfigurationDiffblueTest {
  /**
   * Test {@link
   * RegistryEntryAddHandlerConfiguration#RegistryEntryAddHandlerConfiguration(LifecycleEventHandler,
   * AbstractLifecycleEventType)}.
   *
   * <p>Method under test: {@link
   * RegistryEntryAddHandlerConfiguration#RegistryEntryAddHandlerConfiguration(LifecycleEventHandler,
   * AbstractLifecycleEventType)}
   */
  @Test
  @DisplayName(
      "Test new RegistryEntryAddHandlerConfiguration(LifecycleEventHandler, AbstractLifecycleEventType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegistryEntryAddHandlerConfiguration.<init>(LifecycleEventHandler, AbstractLifecycleEventType)"
  })
  void testNewRegistryEntryAddHandlerConfiguration() {
    // Arrange
    LifecycleEventHandler<RegistryEntryAddEvent<Object, RegistryBuilder<Object>>> handler =
        mock(LifecycleEventHandler.class);
    Class<BootstrapContext> ownerType = BootstrapContext.class;

    // Act
    RegistryEntryAddHandlerConfiguration<Object, RegistryBuilder<Object>>
        actualRegistryEntryAddHandlerConfiguration =
            new RegistryEntryAddHandlerConfiguration<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));

    // Assert
    assertNull(actualRegistryEntryAddHandlerConfiguration.filter());
    OptionalInt priorityResult = actualRegistryEntryAddHandlerConfiguration.priority();
    assertEquals(0, priorityResult.getAsInt());
    assertTrue(priorityResult.isPresent());
    assertSame(handler, actualRegistryEntryAddHandlerConfiguration.handler());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegistryEntryAddHandlerConfiguration#filter(Predicate)}
   *   <li>{@link RegistryEntryAddHandlerConfiguration#filter()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Predicate RegistryEntryAddHandlerConfiguration.filter()",
    "RegistryEntryAddConfiguration RegistryEntryAddHandlerConfiguration.filter(Predicate)"
  })
  void testGettersAndSetters() {
    // Arrange
    LifecycleEventHandler<RegistryEntryAddEvent<Object, RegistryBuilder<Object>>> handler =
        mock(LifecycleEventHandler.class);
    Class<BootstrapContext> ownerType = BootstrapContext.class;
    RegistryEntryAddHandlerConfiguration<Object, RegistryBuilder<Object>>
        registryEntryAddHandlerConfiguration =
            new RegistryEntryAddHandlerConfiguration<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));
    Predicate<TypedKey<Object>> filter = mock(Predicate.class);

    // Act
    RegistryEntryAddConfiguration<Object> actualFilterResult =
        registryEntryAddHandlerConfiguration.filter(filter);
    Predicate<TypedKey<Object>> actualFilterResult2 = registryEntryAddHandlerConfiguration.filter();

    // Assert
    assertSame(registryEntryAddHandlerConfiguration, actualFilterResult);
    assertSame(filter, actualFilterResult2);
  }

  /**
   * Test {@link RegistryEntryAddHandlerConfiguration#priority(int)} with {@code int}.
   *
   * <p>Method under test: {@link RegistryEntryAddHandlerConfiguration#priority(int)}
   */
  @Test
  @DisplayName("Test priority(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RegistryEntryAddConfiguration RegistryEntryAddHandlerConfiguration.priority(int)"
  })
  void testPriorityWithInt() {
    // Arrange
    LifecycleEventHandler<RegistryEntryAddEvent<Object, RegistryBuilder<Object>>> handler =
        mock(LifecycleEventHandler.class);
    Class<BootstrapContext> ownerType = BootstrapContext.class;
    RegistryEntryAddHandlerConfiguration<Object, RegistryBuilder<Object>>
        registryEntryAddHandlerConfiguration =
            new RegistryEntryAddHandlerConfiguration<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));

    // Act
    RegistryEntryAddConfiguration<Object> actualPriorityResult =
        registryEntryAddHandlerConfiguration.priority(1);

    // Assert
    assertSame(registryEntryAddHandlerConfiguration, actualPriorityResult);
  }

  /**
   * Test {@link RegistryEntryAddHandlerConfiguration#monitor()}.
   *
   * <p>Method under test: {@link RegistryEntryAddHandlerConfiguration#monitor()}
   */
  @Test
  @DisplayName("Test monitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RegistryEntryAddConfiguration RegistryEntryAddHandlerConfiguration.monitor()"
  })
  void testMonitor() {
    // Arrange
    LifecycleEventHandler<RegistryEntryAddEvent<Object, RegistryBuilder<Object>>> handler =
        mock(LifecycleEventHandler.class);
    Class<BootstrapContext> ownerType = BootstrapContext.class;
    RegistryEntryAddHandlerConfiguration<Object, RegistryBuilder<Object>>
        registryEntryAddHandlerConfiguration =
            new RegistryEntryAddHandlerConfiguration<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));

    // Act
    RegistryEntryAddConfiguration<Object> actualMonitorResult =
        registryEntryAddHandlerConfiguration.monitor();

    // Assert
    assertSame(registryEntryAddHandlerConfiguration, actualMonitorResult);
  }
}
