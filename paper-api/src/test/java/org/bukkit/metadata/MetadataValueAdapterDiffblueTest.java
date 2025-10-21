package org.bukkit.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Callable;
import org.bukkit.metadata.LazyMetadataValue.CacheStrategy;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataValueAdapterDiffblueTest {
  /**
   * Test {@link MetadataValueAdapter#getOwningPlugin()}.
   *
   * <p>Method under test: {@link MetadataValueAdapter#getOwningPlugin()}
   */
  @Test
  @DisplayName("Test getOwningPlugin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.plugin.Plugin MetadataValueAdapter.getOwningPlugin()"})
  void testGetOwningPlugin() {
    // Arrange
    TestPlugin owningPlugin = new TestPlugin("Plugin Name");

    // Act and Assert
    assertSame(owningPlugin, new LazyMetadataValue(owningPlugin).getOwningPlugin());
  }

  /**
   * Test {@link MetadataValueAdapter#asInt()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asInt()}
   */
  @Test
  @DisplayName("Test asInt(); given Callable call() return '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MetadataValueAdapter.asInt()"})
  void testAsInt_givenCallableCallReturn42_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn("42");
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    int actualAsIntResult = lazyMetadataValue.asInt();

    // Assert
    verify(lazyValue).call();
    assertEquals(42, actualAsIntResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asInt()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asInt()}
   */
  @Test
  @DisplayName("Test asInt(); given Callable call() return forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MetadataValueAdapter.asInt()"})
  void testAsInt_givenCallableCallReturnFortyTwo_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(42);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    int actualAsIntResult = lazyMetadataValue.asInt();

    // Assert
    verify(lazyValue).call();
    assertEquals(42, actualAsIntResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asInt()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asInt()}
   */
  @Test
  @DisplayName("Test asInt(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MetadataValueAdapter.asInt()"})
  void testAsInt_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").asInt());
  }

  /**
   * Test {@link MetadataValueAdapter#asFloat()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asFloat()}
   */
  @Test
  @DisplayName("Test asFloat(); given Callable call() return '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float MetadataValueAdapter.asFloat()"})
  void testAsFloat_givenCallableCallReturn42_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn("42");
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    float actualAsFloatResult = lazyMetadataValue.asFloat();

    // Assert
    verify(lazyValue).call();
    assertEquals(42.0f, actualAsFloatResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asFloat()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asFloat()}
   */
  @Test
  @DisplayName("Test asFloat(); given Callable call() return forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float MetadataValueAdapter.asFloat()"})
  void testAsFloat_givenCallableCallReturnFortyTwo_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(42);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    float actualAsFloatResult = lazyMetadataValue.asFloat();

    // Assert
    verify(lazyValue).call();
    assertEquals(42.0f, actualAsFloatResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asFloat()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asFloat()}
   */
  @Test
  @DisplayName("Test asFloat(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float MetadataValueAdapter.asFloat()"})
  void testAsFloat_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").asFloat());
  }

  /**
   * Test {@link MetadataValueAdapter#asDouble()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asDouble()}
   */
  @Test
  @DisplayName("Test asDouble(); given Callable call() return '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MetadataValueAdapter.asDouble()"})
  void testAsDouble_givenCallableCallReturn42_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn("42");
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    double actualAsDoubleResult = lazyMetadataValue.asDouble();

    // Assert
    verify(lazyValue).call();
    assertEquals(42.0d, actualAsDoubleResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asDouble()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asDouble()}
   */
  @Test
  @DisplayName("Test asDouble(); given Callable call() return forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MetadataValueAdapter.asDouble()"})
  void testAsDouble_givenCallableCallReturnFortyTwo_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(42);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    double actualAsDoubleResult = lazyMetadataValue.asDouble();

    // Assert
    verify(lazyValue).call();
    assertEquals(42.0d, actualAsDoubleResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asDouble()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asDouble()}
   */
  @Test
  @DisplayName("Test asDouble(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MetadataValueAdapter.asDouble()"})
  void testAsDouble_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").asDouble());
  }

  /**
   * Test {@link MetadataValueAdapter#asLong()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asLong()}
   */
  @Test
  @DisplayName("Test asLong(); given Callable call() return '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MetadataValueAdapter.asLong()"})
  void testAsLong_givenCallableCallReturn42_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn("42");
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    long actualAsLongResult = lazyMetadataValue.asLong();

    // Assert
    verify(lazyValue).call();
    assertEquals(42L, actualAsLongResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asLong()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asLong()}
   */
  @Test
  @DisplayName("Test asLong(); given Callable call() return forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MetadataValueAdapter.asLong()"})
  void testAsLong_givenCallableCallReturnFortyTwo_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(42);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    long actualAsLongResult = lazyMetadataValue.asLong();

    // Assert
    verify(lazyValue).call();
    assertEquals(42L, actualAsLongResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asLong()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asLong()}
   */
  @Test
  @DisplayName("Test asLong(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MetadataValueAdapter.asLong()"})
  void testAsLong_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").asLong());
  }

  /**
   * Test {@link MetadataValueAdapter#asShort()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asShort()}
   */
  @Test
  @DisplayName("Test asShort(); given Callable call() return '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short MetadataValueAdapter.asShort()"})
  void testAsShort_givenCallableCallReturn42_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn("42");
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    short actualAsShortResult = lazyMetadataValue.asShort();

    // Assert
    verify(lazyValue).call();
    assertEquals((short) 42, actualAsShortResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asShort()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asShort()}
   */
  @Test
  @DisplayName("Test asShort(); given Callable call() return forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short MetadataValueAdapter.asShort()"})
  void testAsShort_givenCallableCallReturnFortyTwo_thenReturnFortyTwo() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(42);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    short actualAsShortResult = lazyMetadataValue.asShort();

    // Assert
    verify(lazyValue).call();
    assertEquals((short) 42, actualAsShortResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asShort()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asShort()}
   */
  @Test
  @DisplayName("Test asShort(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short MetadataValueAdapter.asShort()"})
  void testAsShort_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        (short) 0, new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").asShort());
  }

  /**
   * Test {@link MetadataValueAdapter#asByte()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code 42}.
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asByte()}
   */
  @Test
  @DisplayName("Test asByte(); given Callable call() return '42'; then return '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MetadataValueAdapter.asByte()"})
  void testAsByte_givenCallableCallReturn42_thenReturnAsterisk() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn("42");
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    byte actualAsByteResult = lazyMetadataValue.asByte();

    // Assert
    verify(lazyValue).call();
    assertEquals('*', actualAsByteResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asByte()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return forty-two.
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asByte()}
   */
  @Test
  @DisplayName("Test asByte(); given Callable call() return forty-two; then return '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MetadataValueAdapter.asByte()"})
  void testAsByte_givenCallableCallReturnFortyTwo_thenReturnAsterisk() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(42);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    byte actualAsByteResult = lazyMetadataValue.asByte();

    // Assert
    verify(lazyValue).call();
    assertEquals('*', actualAsByteResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asByte()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asByte()}
   */
  @Test
  @DisplayName("Test asByte(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MetadataValueAdapter.asByte()"})
  void testAsByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").asByte());
  }

  /**
   * Test {@link MetadataValueAdapter#asBoolean()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asBoolean()}
   */
  @Test
  @DisplayName("Test asBoolean(); given Callable call() return forty-two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataValueAdapter.asBoolean()"})
  void testAsBoolean_givenCallableCallReturnFortyTwo_thenReturnTrue() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(42);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    boolean actualAsBooleanResult = lazyMetadataValue.asBoolean();

    // Assert
    verify(lazyValue).call();
    assertTrue(actualAsBooleanResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asBoolean()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asBoolean()}
   */
  @Test
  @DisplayName("Test asBoolean(); given Callable call() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataValueAdapter.asBoolean()"})
  void testAsBoolean_givenCallableCallReturnZero_thenReturnFalse() throws Exception {
    // Arrange
    Callable<Object> lazyValue = mock(Callable.class);
    when(lazyValue.call()).thenReturn(0);
    LazyMetadataValue lazyMetadataValue =
        new LazyMetadataValue(
            new TestPlugin("Plugin Name"), CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);

    // Act
    boolean actualAsBooleanResult = lazyMetadataValue.asBoolean();

    // Assert
    verify(lazyValue).call();
    assertFalse(actualAsBooleanResult);
  }

  /**
   * Test {@link MetadataValueAdapter#asBoolean()}.
   *
   * <ul>
   *   <li>Given {@link FixedMetadataValue#FixedMetadataValue(Plugin, Object)} with owningPlugin is
   *       {@link TestPlugin#TestPlugin(String)} and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asBoolean()}
   */
  @Test
  @DisplayName(
      "Test asBoolean(); given FixedMetadataValue(Plugin, Object) with owningPlugin is TestPlugin(String) and 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetadataValueAdapter.asBoolean()"})
  void testAsBoolean_givenFixedMetadataValueWithOwningPluginIsTestPluginAndValue() {
    // Arrange, Act and Assert
    assertFalse(new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").asBoolean());
  }

  /**
   * Test {@link MetadataValueAdapter#asString()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataValueAdapter#asString()}
   */
  @Test
  @DisplayName("Test asString(); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String MetadataValueAdapter.asString()"})
  void testAsString_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals(
        "Value", new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").asString());
  }
}
