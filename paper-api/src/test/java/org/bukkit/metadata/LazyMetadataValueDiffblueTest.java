package org.bukkit.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import org.bukkit.metadata.LazyMetadataValue.CacheStrategy;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LazyMetadataValueDiffblueTest {
  /**
   * Test {@link LazyMetadataValue#LazyMetadataValue(Plugin)}.
   *
   * <ul>
   *   <li>Then return not {@link MetadataValueAdapter#owningPlugin} Enqueued.
   * </ul>
   *
   * <p>Method under test: {@link LazyMetadataValue#LazyMetadataValue(Plugin)}
   */
  @Test
  @DisplayName("Test new LazyMetadataValue(Plugin); then return not owningPlugin Enqueued")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyMetadataValue.<init>(Plugin)"})
  void testNewLazyMetadataValue_thenReturnNotOwningPluginEnqueued() {
    // Arrange
    TestPlugin owningPlugin = new TestPlugin("Plugin Name");

    // Act
    LazyMetadataValue actualLazyMetadataValue = new LazyMetadataValue(owningPlugin);

    // Assert
    WeakReference<Plugin> weakReference = actualLazyMetadataValue.owningPlugin;
    assertFalse(weakReference.isEnqueued());
    assertSame(owningPlugin, weakReference.get());
    assertSame(owningPlugin, actualLazyMetadataValue.getOwningPlugin());
  }

  /**
   * Test {@link LazyMetadataValue#LazyMetadataValue(Plugin, Callable)}.
   *
   * <ul>
   *   <li>When {@link Callable}.
   *   <li>Then return not {@link MetadataValueAdapter#owningPlugin} Enqueued.
   * </ul>
   *
   * <p>Method under test: {@link LazyMetadataValue#LazyMetadataValue(Plugin, Callable)}
   */
  @Test
  @DisplayName(
      "Test new LazyMetadataValue(Plugin, Callable); when Callable; then return not owningPlugin Enqueued")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyMetadataValue.<init>(Plugin, Callable)"})
  void testNewLazyMetadataValue_whenCallable_thenReturnNotOwningPluginEnqueued() {
    // Arrange
    TestPlugin owningPlugin = new TestPlugin("Plugin Name");

    // Act
    LazyMetadataValue actualLazyMetadataValue =
        new LazyMetadataValue(owningPlugin, mock(Callable.class));

    // Assert
    WeakReference<Plugin> weakReference = actualLazyMetadataValue.owningPlugin;
    assertFalse(weakReference.isEnqueued());
    assertSame(owningPlugin, weakReference.get());
    assertSame(owningPlugin, actualLazyMetadataValue.getOwningPlugin());
  }

  /**
   * Test {@link LazyMetadataValue#LazyMetadataValue(Plugin, CacheStrategy, Callable)}.
   *
   * <ul>
   *   <li>When {@link Callable}.
   *   <li>Then return not {@link MetadataValueAdapter#owningPlugin} Enqueued.
   * </ul>
   *
   * <p>Method under test: {@link LazyMetadataValue#LazyMetadataValue(Plugin, CacheStrategy,
   * Callable)}
   */
  @Test
  @DisplayName(
      "Test new LazyMetadataValue(Plugin, CacheStrategy, Callable); when Callable; then return not owningPlugin Enqueued")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyMetadataValue.<init>(Plugin, CacheStrategy, Callable)"})
  void testNewLazyMetadataValue_whenCallable_thenReturnNotOwningPluginEnqueued2() {
    // Arrange
    TestPlugin owningPlugin = new TestPlugin("Plugin Name");

    // Act
    LazyMetadataValue actualLazyMetadataValue =
        new LazyMetadataValue(
            owningPlugin, CacheStrategy.CACHE_AFTER_FIRST_EVAL, mock(Callable.class));

    // Assert
    WeakReference<Plugin> weakReference = actualLazyMetadataValue.owningPlugin;
    assertFalse(weakReference.isEnqueued());
    assertSame(owningPlugin, weakReference.get());
    assertSame(owningPlugin, actualLazyMetadataValue.getOwningPlugin());
  }

  /**
   * Test {@link LazyMetadataValue#value()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code Call}.
   *   <li>Then return {@code Call}.
   * </ul>
   *
   * <p>Method under test: {@link LazyMetadataValue#value()}
   */
  @Test
  @DisplayName("Test value(); given Callable call() return 'Call'; then return 'Call'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyMetadataValue.value()"})
  void testValue_givenCallableCallReturnCall_thenReturnCall() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn("Call");
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(new TestPlugin("Plugin Name"), lazyValue);

    // Act
    Object actualValueResult = lazyMetadataValue.value();

    // Assert
    verify(lazyValue).call();
    assertEquals("Call", actualValueResult);
  }

  /**
   * Test {@link LazyMetadataValue#value()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code Call}.
   *   <li>Then return {@code Call}.
   * </ul>
   *
   * <p>Method under test: {@link LazyMetadataValue#value()}
   */
  @Test
  @DisplayName("Test value(); given Callable call() return 'Call'; then return 'Call'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyMetadataValue.value()"})
  void testValue_givenCallableCallReturnCall_thenReturnCall2() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn("Call");
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(new TestPlugin("Plugin Name"), CacheStrategy.NEVER_CACHE, lazyValue);

    // Act
    Object actualValueResult = lazyMetadataValue.value();

    // Assert
    verify(lazyValue).call();
    assertEquals("Call", actualValueResult);
  }

  /**
   * Test {@link LazyMetadataValue#value()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LazyMetadataValue#value()}
   */
  @Test
  @DisplayName("Test value(); given Callable call() return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyMetadataValue.value()"})
  void testValue_givenCallableCallReturnNull_thenReturnNull() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(null);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(new TestPlugin("Plugin Name"), CacheStrategy.NEVER_CACHE, lazyValue);

    // Act
    Object actualValueResult = lazyMetadataValue.value();

    // Assert
    verify(lazyValue).call();
    assertNull(actualValueResult);
  }

  /**
   * Test {@link LazyMetadataValue#value()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} throw {@link Exception#Exception()}.
   *   <li>Then throw {@link MetadataEvaluationException}.
   * </ul>
   *
   * <p>Method under test: {@link LazyMetadataValue#value()}
   */
  @Test
  @DisplayName(
      "Test value(); given Callable call() throw Exception(); then throw MetadataEvaluationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyMetadataValue.value()"})
  void testValue_givenCallableCallThrowException_thenThrowMetadataEvaluationException()
      throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenThrow(new Exception());
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(new TestPlugin("Plugin Name"), lazyValue);

    // Act and Assert
    assertThrows(MetadataEvaluationException.class, () -> lazyMetadataValue.value());
    verify(lazyValue).call();
  }
}
