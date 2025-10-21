package io.papermc.paper.registry.event.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType.RegisteredHandler;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import io.papermc.paper.registry.RegistryBuilder;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.data.util.Conversions;
import io.papermc.paper.registry.event.RegistryEntryAddEvent;
import io.papermc.paper.registry.event.RegistryEntryAddEventImpl;
import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegistryEntryAddEventTypeImplDiffblueTest {
  /**
   * Test {@link RegistryEntryAddEventTypeImpl#RegistryEntryAddEventTypeImpl(RegistryKey, String)}.
   *
   * <p>Method under test: {@link
   * RegistryEntryAddEventTypeImpl#RegistryEntryAddEventTypeImpl(RegistryKey, String)}
   */
  @Test
  @DisplayName("Test new RegistryEntryAddEventTypeImpl(RegistryKey, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegistryEntryAddEventTypeImpl.<init>(RegistryKey, String)"})
  void testNewRegistryEntryAddEventTypeImpl() {
    // Arrange and Act
    RegistryEntryAddEventTypeImpl<Object, RegistryBuilder<Object>>
        actualRegistryEntryAddEventTypeImpl =
            new RegistryEntryAddEventTypeImpl<>(null, "Event Name");

    // Assert
    assertEquals("null / Event Name", actualRegistryEntryAddEventTypeImpl.name());
    assertFalse(actualRegistryEntryAddEventTypeImpl.hasHandlers());
  }

  /**
   * Test {@link RegistryEntryAddEventTypeImpl#blocksReloading(BootstrapContext)} with {@code
   * eventOwner}.
   *
   * <p>Method under test: {@link RegistryEntryAddEventTypeImpl#blocksReloading(BootstrapContext)}
   */
  @Test
  @DisplayName("Test blocksReloading(BootstrapContext) with 'eventOwner'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryEntryAddEventTypeImpl.blocksReloading(BootstrapContext)"})
  void testBlocksReloadingWithEventOwner() {
    // Arrange
    RegistryEntryAddEventTypeImpl<Object, RegistryBuilder<Object>> registryEntryAddEventTypeImpl =
        new RegistryEntryAddEventTypeImpl<>(null, "Event Name");
    PluginBootstrapContextImpl eventOwner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    boolean actualBlocksReloadingResult = registryEntryAddEventTypeImpl.blocksReloading(eventOwner);

    // Assert
    assertFalse(actualBlocksReloadingResult);
  }

  /**
   * Test {@link RegistryEntryAddEventTypeImpl#newHandler(LifecycleEventHandler)}.
   *
   * <p>Method under test: {@link RegistryEntryAddEventTypeImpl#newHandler(LifecycleEventHandler)}
   */
  @Test
  @DisplayName("Test newHandler(LifecycleEventHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RegistryEntryAddConfiguration RegistryEntryAddEventTypeImpl.newHandler(LifecycleEventHandler)"
  })
  void testNewHandler() {
    // Arrange
    RegistryEntryAddEventTypeImpl<Object, RegistryBuilder<Object>> registryEntryAddEventTypeImpl =
        new RegistryEntryAddEventTypeImpl<>(null, "Event Name");
    LifecycleEventHandler<RegistryEntryAddEvent<Object, RegistryBuilder<Object>>> handler =
        mock(LifecycleEventHandler.class);

    // Act
    RegistryEntryAddConfiguration<Object> actualNewHandlerResult =
        registryEntryAddEventTypeImpl.newHandler(handler);

    // Assert
    assertTrue(actualNewHandlerResult instanceof RegistryEntryAddHandlerConfiguration);
    assertNull(
        ((RegistryEntryAddHandlerConfiguration<Object, RegistryBuilder<Object>>)
                actualNewHandlerResult)
            .filter());
    OptionalInt priorityResult =
        ((RegistryEntryAddHandlerConfiguration<Object, RegistryBuilder<Object>>)
                actualNewHandlerResult)
            .priority();
    assertEquals(0, priorityResult.getAsInt());
    assertTrue(priorityResult.isPresent());
    assertSame(
        handler,
        ((RegistryEntryAddHandlerConfiguration<Object, RegistryBuilder<Object>>)
                actualNewHandlerResult)
            .handler());
  }

  /**
   * Test {@link RegistryEntryAddEventTypeImpl#forEachHandler(RegistryEntryAddEvent, Consumer,
   * Predicate)} with {@code event}, {@code consumer}, {@code predicate}.
   *
   * <ul>
   *   <li>Given {@link Predicate}.
   *   <li>Then calls {@link Predicate#and(Predicate)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RegistryEntryAddEventTypeImpl#forEachHandler(RegistryEntryAddEvent, Consumer, Predicate)}
   */
  @Test
  @DisplayName(
      "Test forEachHandler(RegistryEntryAddEvent, Consumer, Predicate) with 'event', 'consumer', 'predicate'; given Predicate; then calls and(Predicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegistryEntryAddEventTypeImpl.forEachHandler(RegistryEntryAddEvent, Consumer, Predicate)"
  })
  void testForEachHandlerWithEventConsumerPredicate_givenPredicate_thenCallsAnd() {
    // Arrange
    RegistryEntryAddEventTypeImpl<Object, RegistryBuilder<Object>> registryEntryAddEventTypeImpl =
        new RegistryEntryAddEventTypeImpl<>(null, "Event Name");
    RegistryBuilder<Object> registryBuilder = mock(RegistryBuilder.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    RegistryEntryAddEventImpl<Object, RegistryBuilder<Object>> event =
        new RegistryEntryAddEventImpl<>(null, registryBuilder, null, conversions);
    Consumer<
            RegisteredHandler<
                BootstrapContext, RegistryEntryAddEvent<Object, RegistryBuilder<Object>>>>
        consumer = mock(Consumer.class);

    Predicate<
            RegisteredHandler<
                BootstrapContext, RegistryEntryAddEvent<Object, RegistryBuilder<Object>>>>
        predicate = mock(Predicate.class);
    when(predicate.and(
            Mockito
                .<Predicate<
                        RegisteredHandler<
                            BootstrapContext,
                            RegistryEntryAddEvent<Object, RegistryBuilder<Object>>>>>
                    any()))
        .thenReturn(mock(Predicate.class));

    // Act
    registryEntryAddEventTypeImpl.forEachHandler(event, consumer, predicate);

    // Assert
    verify(predicate).and(isA(Predicate.class));
  }
}
