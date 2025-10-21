package com.mojang.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult.Error;
import com.mojang.serialization.DataResult.Success;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import net.minecraft.resources.RegistryOps;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DynamicDiffblueTest {
  /**
   * Test {@link Dynamic#Dynamic(DynamicOps)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RegistryOps} {@link RegistryOps#empty()} return {@code null}.
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#Dynamic(DynamicOps)}
   */
  @Test
  @DisplayName(
      "Test new Dynamic(DynamicOps); given 'null'; when RegistryOps empty() return 'null'; then return Value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dynamic.<init>(DynamicOps)"})
  void testNewDynamic_givenNull_whenRegistryOpsEmptyReturnNull_thenReturnValueIsNull() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(null);

    // Act
    Dynamic<Object> actualDynamic = new Dynamic<>(ops);

    // Assert
    verify(ops, atLeast(1)).empty();
    assertNull(actualDynamic.getValue());
    assertSame(ops, actualDynamic.getOps());
  }

  /**
   * Test {@link Dynamic#Dynamic(DynamicOps, Object)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return Ops is {@link RegistryOps}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#Dynamic(DynamicOps, Object)}
   */
  @Test
  @DisplayName(
      "Test new Dynamic(DynamicOps, Object); given WILDCARD_OBJECT; then return Ops is RegistryOps")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dynamic.<init>(DynamicOps, Object)"})
  void testNewDynamic_givenWildcard_object_thenReturnOpsIsRegistryOps() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Dynamic<Object> actualDynamic = new Dynamic<>(ops, null);

    // Assert
    verify(ops).empty();
    assertSame(ops, actualDynamic.getOps());
  }

  /**
   * Test {@link Dynamic#Dynamic(DynamicOps)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>When {@link RegistryOps} {@link RegistryOps#empty()} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#Dynamic(DynamicOps)}
   */
  @Test
  @DisplayName(
      "Test new Dynamic(DynamicOps); given WILDCARD_OBJECT; when RegistryOps empty() return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dynamic.<init>(DynamicOps)"})
  void testNewDynamic_givenWildcard_object_whenRegistryOpsEmptyReturnWildcard_object() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Dynamic<Object> actualDynamic = new Dynamic<>(ops);

    // Assert
    verify(ops).empty();
    assertSame(ops, actualDynamic.getOps());
  }

  /**
   * Test {@link Dynamic#Dynamic(DynamicOps, Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return Ops is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#Dynamic(DynamicOps, Object)}
   */
  @Test
  @DisplayName(
      "Test new Dynamic(DynamicOps, Object); when WILDCARD_OBJECT; then return Ops is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dynamic.<init>(DynamicOps, Object)"})
  void testNewDynamic_whenWildcard_object_thenReturnOpsIsNull() {
    // Arrange
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Dynamic<Object> actualDynamic = new Dynamic<>(null, object);

    // Assert
    assertNull(actualDynamic.getOps());
    assertSame(object, actualDynamic.getValue());
  }

  /**
   * Test {@link Dynamic#map(Function)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#map(Function)}
   */
  @Test
  @DisplayName(
      "Test map(Function); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.map(Function)"})
  void testMap_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    Function<Object, Object> function = mock(Function.class);
    when(function.apply(Mockito.<Object>any())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.map(function));
    verify(function).apply(isA(Object.class));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#map(Function)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@link Dynamic#Dynamic(DynamicOps)} with ops is {@link RegistryOps}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#map(Function)}
   */
  @Test
  @DisplayName(
      "Test map(Function); given 'null'; then return Dynamic(DynamicOps) with ops is RegistryOps")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.map(Function)"})
  void testMap_givenNull_thenReturnDynamicWithOpsIsRegistryOps() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    Function<Object, Object> function = mock(Function.class);
    when(function.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    Dynamic<Object> actualMapResult = dynamic.map(function);

    // Assert
    verify(function).apply(isA(Object.class));
    verify(ops, atLeast(1)).empty();
    assertEquals(dynamic, actualMapResult);
  }

  /**
   * Test {@link Dynamic#map(Function)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#map(Function)}
   */
  @Test
  @DisplayName(
      "Test map(Function); given WILDCARD_OBJECT; when Function apply(Object) return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.map(Function)"})
  void testMap_givenWildcard_object_whenFunctionApplyReturnWildcard_object() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    Function<Object, Object> function = mock(Function.class);
    when(function.apply(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Dynamic<Object> actualMapResult = dynamic.map(function);

    // Assert
    verify(function).apply(isA(Object.class));
    verify(ops).empty();
    assertEquals(dynamic, actualMapResult);
  }

  /**
   * Test {@link Dynamic#castTyped(DynamicOps)}.
   *
   * <ul>
   *   <li>Then return Ops is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#castTyped(DynamicOps)}
   */
  @Test
  @DisplayName("Test castTyped(DynamicOps); then return Ops is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.castTyped(DynamicOps)"})
  void testCastTyped_thenReturnOpsIsNull() {
    // Arrange
    Dynamic<Object> dynamic = new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Dynamic<Object> actualCastTypedResult = dynamic.castTyped(null);

    // Assert
    assertNull(actualCastTypedResult.getOps());
    assertSame(dynamic, actualCastTypedResult);
  }

  /**
   * Test {@link Dynamic#castTyped(DynamicOps)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#castTyped(DynamicOps)}
   */
  @Test
  @DisplayName("Test castTyped(DynamicOps); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.castTyped(DynamicOps)"})
  void testCastTyped_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.castTyped(null));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#cast(DynamicOps)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#cast(DynamicOps)}
   */
  @Test
  @DisplayName("Test cast(DynamicOps); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Dynamic.cast(DynamicOps)"})
  void testCast_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.cast(null));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#merge(Dynamic, Dynamic)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#empty()} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then calls {@link RegistryOps#empty()}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#merge(Dynamic, Dynamic)}
   */
  @Test
  @DisplayName(
      "Test merge(Dynamic, Dynamic) with 'key', 'value'; given RegistryOps empty() return WILDCARD_OBJECT; then calls empty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.merge(Dynamic, Dynamic)"})
  void testMergeWithKeyValue_givenRegistryOpsEmptyReturnWildcard_object_thenCallsEmpty() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);
    Dynamic<?> key = new Dynamic<>(new JsonOps(true));

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> dynamic.merge(key, new Dynamic<>(new JsonOps(true))));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#merge(Dynamic, Dynamic)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#merge(Dynamic, Dynamic)}
   */
  @Test
  @DisplayName("Test merge(Dynamic, Dynamic) with 'key', 'value'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.merge(Dynamic, Dynamic)"})
  void testMergeWithKeyValue_thenThrowIllegalStateException() {
    // Arrange
    Dynamic<Object> dynamic = new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> key = new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> dynamic.merge(key, new Dynamic<>(new JsonOps(true))));
  }

  /**
   * Test {@link Dynamic#merge(Dynamic)} with {@code value}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#merge(Dynamic)}
   */
  @Test
  @DisplayName("Test merge(Dynamic) with 'value'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.merge(Dynamic)"})
  void testMergeWithValue_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> dynamic.merge(new Dynamic<>(new JsonOps(true))));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#getMapValues()}.
   *
   * <p>Method under test: {@link Dynamic#getMapValues()}
   */
  @Test
  @DisplayName("Test getMapValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getMapValues()"})
  void testGetMapValues() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.empty();

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Map<Dynamic<Object>, Dynamic<Object>>> actualMapValues = dynamic.getMapValues();

    // Assert
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertSame(error, actualMapValues);
  }

  /**
   * Test {@link Dynamic#getMapValues()}.
   *
   * <p>Method under test: {@link Dynamic#getMapValues()}
   */
  @Test
  @DisplayName("Test getMapValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getMapValues()"})
  void testGetMapValues2() {
    // Arrange
    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    pairList.add(new Pair<>(31, ConfigurationTransformation.WILDCARD_OBJECT));
    pairList.add(
        new Pair<>(
            ConfigurationTransformation.WILDCARD_OBJECT,
            ConfigurationTransformation.WILDCARD_OBJECT));
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Lifecycle lifecycle = Lifecycle.experimental();

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, lifecycle);

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Map<Dynamic<Object>, Dynamic<Object>>> actualMapValues = dynamic.getMapValues();

    // Assert
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertTrue(actualMapValues instanceof Error);
    Map<Dynamic<Object>, Dynamic<Object>> partialOrThrow = actualMapValues.getPartialOrThrow();
    assertEquals(2, partialOrThrow.size());
    assertTrue(actualMapValues.isError());
    Optional<Map<Dynamic<Object>, Dynamic<Object>>> partialValueResult =
        ((Error<Map<Dynamic<Object>, Dynamic<Object>>>) actualMapValues).partialValue();
    assertTrue(partialValueResult.isPresent());
    assertSame(partialOrThrow, partialValueResult.get());
    assertSame(lifecycle, actualMapValues.lifecycle());
  }

  /**
   * Test {@link Dynamic#getMapValues()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Pair#Pair(Object, Object)} with first is
   *       {@code null} and second is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#getMapValues()}
   */
  @Test
  @DisplayName(
      "Test getMapValues(); given ArrayList() add Pair(Object, Object) with first is 'null' and second is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getMapValues()"})
  void testGetMapValues_givenArrayListAddPairWithFirstIsNullAndSecondIsWildcard_object() {
    // Arrange
    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    pairList.add(new Pair<>(null, ConfigurationTransformation.WILDCARD_OBJECT));
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Lifecycle lifecycle = Lifecycle.experimental();

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, lifecycle);

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Map<Dynamic<Object>, Dynamic<Object>>> actualMapValues = dynamic.getMapValues();

    // Assert
    verify(ops, atLeast(1)).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertTrue(actualMapValues instanceof Error);
    Map<Dynamic<Object>, Dynamic<Object>> partialOrThrow = actualMapValues.getPartialOrThrow();
    assertEquals(1, partialOrThrow.size());
    assertTrue(actualMapValues.isError());
    Optional<Map<Dynamic<Object>, Dynamic<Object>>> partialValueResult =
        ((Error<Map<Dynamic<Object>, Dynamic<Object>>>) actualMapValues).partialValue();
    assertTrue(partialValueResult.isPresent());
    assertSame(partialOrThrow, partialValueResult.get());
    assertSame(lifecycle, actualMapValues.lifecycle());
  }

  /**
   * Test {@link Dynamic#getMapValues()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Pair#Pair(Object, Object)} with first is
   *       zero and second is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#getMapValues()}
   */
  @Test
  @DisplayName(
      "Test getMapValues(); given ArrayList() add Pair(Object, Object) with first is zero and second is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getMapValues()"})
  void testGetMapValues_givenArrayListAddPairWithFirstIsZeroAndSecondIsWildcard_object() {
    // Arrange
    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    pairList.add(new Pair<>(0, ConfigurationTransformation.WILDCARD_OBJECT));
    pairList.add(
        new Pair<>(
            ConfigurationTransformation.WILDCARD_OBJECT,
            ConfigurationTransformation.WILDCARD_OBJECT));
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Lifecycle lifecycle = Lifecycle.experimental();

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, lifecycle);

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Map<Dynamic<Object>, Dynamic<Object>>> actualMapValues = dynamic.getMapValues();

    // Assert
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertTrue(actualMapValues instanceof Error);
    Map<Dynamic<Object>, Dynamic<Object>> partialOrThrow = actualMapValues.getPartialOrThrow();
    assertEquals(2, partialOrThrow.size());
    assertTrue(actualMapValues.isError());
    Optional<Map<Dynamic<Object>, Dynamic<Object>>> partialValueResult =
        ((Error<Map<Dynamic<Object>, Dynamic<Object>>>) actualMapValues).partialValue();
    assertTrue(partialValueResult.isPresent());
    assertSame(partialOrThrow, partialValueResult.get());
    assertSame(lifecycle, actualMapValues.lifecycle());
  }

  /**
   * Test {@link Dynamic#getMapValues()}.
   *
   * <ul>
   *   <li>Then return PartialOrThrow Empty.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#getMapValues()}
   */
  @Test
  @DisplayName("Test getMapValues(); then return PartialOrThrow Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getMapValues()"})
  void testGetMapValues_thenReturnPartialOrThrowEmpty() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);

    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);
    Lifecycle lifecycle = Lifecycle.experimental();

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, lifecycle);
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Map<Dynamic<Object>, Dynamic<Object>>> actualMapValues = dynamic.getMapValues();

    // Assert
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertTrue(actualMapValues instanceof Error);
    assertTrue(actualMapValues.isError());
    Map<Dynamic<Object>, Dynamic<Object>> partialOrThrow = actualMapValues.getPartialOrThrow();
    assertTrue(partialOrThrow.isEmpty());
    Optional<Map<Dynamic<Object>, Dynamic<Object>>> partialValueResult =
        ((Error<Map<Dynamic<Object>, Dynamic<Object>>>) actualMapValues).partialValue();
    assertTrue(partialValueResult.isPresent());
    assertSame(partialOrThrow, partialValueResult.get());
    assertSame(lifecycle, actualMapValues.lifecycle());
  }

  /**
   * Test {@link Dynamic#getMapValues()}.
   *
   * <ul>
   *   <li>Then return PartialOrThrow size is one.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#getMapValues()}
   */
  @Test
  @DisplayName("Test getMapValues(); then return PartialOrThrow size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getMapValues()"})
  void testGetMapValues_thenReturnPartialOrThrowSizeIsOne() {
    // Arrange
    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    pairList.add(
        new Pair<>(
            ConfigurationTransformation.WILDCARD_OBJECT,
            ConfigurationTransformation.WILDCARD_OBJECT));
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Lifecycle lifecycle = Lifecycle.experimental();

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, lifecycle);

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Map<Dynamic<Object>, Dynamic<Object>>> actualMapValues = dynamic.getMapValues();

    // Assert
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertTrue(actualMapValues instanceof Error);
    Map<Dynamic<Object>, Dynamic<Object>> partialOrThrow = actualMapValues.getPartialOrThrow();
    assertEquals(1, partialOrThrow.size());
    assertTrue(actualMapValues.isError());
    Optional<Map<Dynamic<Object>, Dynamic<Object>>> partialValueResult =
        ((Error<Map<Dynamic<Object>, Dynamic<Object>>>) actualMapValues).partialValue();
    assertTrue(partialValueResult.isPresent());
    assertSame(partialOrThrow, partialValueResult.get());
    assertSame(lifecycle, actualMapValues.lifecycle());
  }

  /**
   * Test {@link Dynamic#updateMapValues(Function)}.
   *
   * <p>Method under test: {@link Dynamic#updateMapValues(Function)}
   */
  @Test
  @DisplayName("Test updateMapValues(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.updateMapValues(Function)"})
  void testUpdateMapValues() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.createMap(Mockito.<Map<Object, Object>>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    when(ops.getMapValues(Mockito.<Object>any()))
        .thenReturn(new Success<>(streamResult, Lifecycle.experimental()));
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualUpdateMapValuesResult = dynamic.updateMapValues(mock(Function.class));

    // Assert
    verify(ops).createMap(isA(Map.class));
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertEquals(dynamic, actualUpdateMapValuesResult);
  }

  /**
   * Test {@link Dynamic#updateMapValues(Function)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#createMap(Map)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#updateMapValues(Function)}
   */
  @Test
  @DisplayName("Test updateMapValues(Function); given RegistryOps createMap(Map) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.updateMapValues(Function)"})
  void testUpdateMapValues_givenRegistryOpsCreateMapReturnNull() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.createMap(Mockito.<Map<Object, Object>>any())).thenReturn(null);
    Supplier<String> messageSupplier = mock(Supplier.class);

    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualUpdateMapValuesResult = dynamic.updateMapValues(mock(Function.class));

    // Assert
    verify(ops).createMap(isA(Map.class));
    verify(ops, atLeast(1)).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertSame(dynamic, actualUpdateMapValuesResult);
  }

  /**
   * Test {@link Dynamic#updateMapValues(Function)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#createMap(Map)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#updateMapValues(Function)}
   */
  @Test
  @DisplayName(
      "Test updateMapValues(Function); given RegistryOps createMap(Map) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.updateMapValues(Function)"})
  void testUpdateMapValues_givenRegistryOpsCreateMapThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.createMap(Mockito.<Map<Object, Object>>any())).thenThrow(new IllegalStateException());
    Supplier<String> messageSupplier = mock(Supplier.class);

    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.updateMapValues(mock(Function.class)));
    verify(ops).createMap(isA(Map.class));
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
  }

  /**
   * Test {@link Dynamic#updateMapValues(Function)}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then return {@link Dynamic#Dynamic(DynamicOps)} with ops is {@link RegistryOps}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#updateMapValues(Function)}
   */
  @Test
  @DisplayName(
      "Test updateMapValues(Function); when Function; then return Dynamic(DynamicOps) with ops is RegistryOps")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.updateMapValues(Function)"})
  void testUpdateMapValues_whenFunction_thenReturnDynamicWithOpsIsRegistryOps() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.createMap(Mockito.<Map<Object, Object>>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Supplier<String> messageSupplier = mock(Supplier.class);

    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualUpdateMapValuesResult = dynamic.updateMapValues(mock(Function.class));

    // Assert
    verify(ops).createMap(isA(Map.class));
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertSame(dynamic, actualUpdateMapValuesResult);
  }

  /**
   * Test {@link Dynamic#asNumber()}.
   *
   * <p>Method under test: {@link Dynamic#asNumber()}
   */
  @Test
  @DisplayName("Test asNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asNumber()"})
  void testAsNumber() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Number> partialValue = Optional.of(Bootstrap.bootstrapDuration);

    Error<Number> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getNumberValue(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Number> actualAsNumberResult = dynamic.asNumber();

    // Assert
    verify(ops).empty();
    verify(ops).getNumberValue(isA(Object.class));
    assertSame(error, actualAsNumberResult);
  }

  /**
   * Test {@link Dynamic#asString()}.
   *
   * <p>Method under test: {@link Dynamic#asString()}
   */
  @Test
  @DisplayName("Test asString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asString()"})
  void testAsString() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<String> partialValue = Optional.of("foo");

    Error<String> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getStringValue(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<String> actualAsStringResult = dynamic.asString();

    // Assert
    verify(ops).empty();
    verify(ops).getStringValue(isA(Object.class));
    assertSame(error, actualAsStringResult);
  }

  /**
   * Test {@link Dynamic#asBoolean()}.
   *
   * <p>Method under test: {@link Dynamic#asBoolean()}
   */
  @Test
  @DisplayName("Test asBoolean()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asBoolean()"})
  void testAsBoolean() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Boolean> partialValue = Optional.of(true);

    Error<Boolean> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getBooleanValue(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Boolean> actualAsBooleanResult = dynamic.asBoolean();

    // Assert
    verify(ops).empty();
    verify(ops).getBooleanValue(isA(Object.class));
    assertSame(error, actualAsBooleanResult);
  }

  /**
   * Test {@link Dynamic#asStreamOpt()}.
   *
   * <p>Method under test: {@link Dynamic#asStreamOpt()}
   */
  @Test
  @DisplayName("Test asStreamOpt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asStreamOpt()"})
  void testAsStreamOpt() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Stream<Object>> partialValue = Optional.empty();

    Error<Stream<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getStream(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Stream<Dynamic<Object>>> actualAsStreamOptResult = dynamic.asStreamOpt();

    // Assert
    verify(ops).empty();
    verify(ops).getStream(isA(Object.class));
    assertSame(error, actualAsStreamOptResult);
  }

  /**
   * Test {@link Dynamic#asStreamOpt()}.
   *
   * <ul>
   *   <li>Then return {@link Error}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#asStreamOpt()}
   */
  @Test
  @DisplayName("Test asStreamOpt(); then return Error")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asStreamOpt()"})
  void testAsStreamOpt_thenReturnError() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    Optional<Stream<Object>> partialValue = Optional.of(streamResult);
    Lifecycle lifecycle = Lifecycle.experimental();

    Error<Stream<Object>> error = new Error<>(messageSupplier, partialValue, lifecycle);
    when(ops.getStream(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Stream<Dynamic<Object>>> actualAsStreamOptResult = dynamic.asStreamOpt();

    // Assert
    verify(ops).empty();
    verify(ops).getStream(isA(Object.class));
    assertTrue(actualAsStreamOptResult instanceof Error);
    assertTrue(actualAsStreamOptResult.isError());
    Stream<Dynamic<Object>> partialOrThrow = actualAsStreamOptResult.getPartialOrThrow();
    assertTrue(partialOrThrow.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(
        ((Error<Stream<Dynamic<Object>>>) actualAsStreamOptResult).partialValue().isPresent());
    assertSame(lifecycle, actualAsStreamOptResult.lifecycle());
  }

  /**
   * Test {@link Dynamic#asMapOpt()}.
   *
   * <p>Method under test: {@link Dynamic#asMapOpt()}
   */
  @Test
  @DisplayName("Test asMapOpt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asMapOpt()"})
  void testAsMapOpt() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.empty();

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Stream<Pair<Dynamic<Object>, Dynamic<Object>>>> actualAsMapOptResult =
        dynamic.asMapOpt();

    // Assert
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertSame(error, actualAsMapOptResult);
  }

  /**
   * Test {@link Dynamic#asMapOpt()}.
   *
   * <ul>
   *   <li>Then return {@link Error}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#asMapOpt()}
   */
  @Test
  @DisplayName("Test asMapOpt(); then return Error")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asMapOpt()"})
  void testAsMapOpt_thenReturnError() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);

    ArrayList<Pair<Object, Object>> pairList = new ArrayList<>();
    Stream<Pair<Object, Object>> streamResult = pairList.stream();
    Optional<Stream<Pair<Object, Object>>> partialValue = Optional.of(streamResult);
    Lifecycle lifecycle = Lifecycle.experimental();

    Error<Stream<Pair<Object, Object>>> error =
        new Error<>(messageSupplier, partialValue, lifecycle);
    when(ops.getMapValues(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Stream<Pair<Dynamic<Object>, Dynamic<Object>>>> actualAsMapOptResult =
        dynamic.asMapOpt();

    // Assert
    verify(ops).empty();
    verify(ops).getMapValues(isA(Object.class));
    assertTrue(actualAsMapOptResult instanceof Error);
    assertTrue(actualAsMapOptResult.isError());
    Stream<Pair<Dynamic<Object>, Dynamic<Object>>> partialOrThrow =
        actualAsMapOptResult.getPartialOrThrow();
    assertTrue(partialOrThrow.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(
        ((Error<Stream<Pair<Dynamic<Object>, Dynamic<Object>>>>) actualAsMapOptResult)
            .partialValue()
            .isPresent());
    assertSame(lifecycle, actualAsMapOptResult.lifecycle());
  }

  /**
   * Test {@link Dynamic#asByteBufferOpt()}.
   *
   * <p>Method under test: {@link Dynamic#asByteBufferOpt()}
   */
  @Test
  @DisplayName("Test asByteBufferOpt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asByteBufferOpt()"})
  void testAsByteBufferOpt() throws UnsupportedEncodingException {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<ByteBuffer> partialValue = Optional.of(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    Error<ByteBuffer> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getByteBuffer(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<ByteBuffer> actualAsByteBufferOptResult = dynamic.asByteBufferOpt();

    // Assert
    verify(ops).empty();
    verify(ops).getByteBuffer(isA(Object.class));
    assertSame(error, actualAsByteBufferOptResult);
  }

  /**
   * Test {@link Dynamic#asIntStreamOpt()}.
   *
   * <p>Method under test: {@link Dynamic#asIntStreamOpt()}
   */
  @Test
  @DisplayName("Test asIntStreamOpt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asIntStreamOpt()"})
  void testAsIntStreamOpt() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<IntStream> partialValue = Optional.empty();

    Error<IntStream> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getIntStream(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<IntStream> actualAsIntStreamOptResult = dynamic.asIntStreamOpt();

    // Assert
    verify(ops).empty();
    verify(ops).getIntStream(isA(Object.class));
    assertSame(error, actualAsIntStreamOptResult);
  }

  /**
   * Test {@link Dynamic#asLongStreamOpt()}.
   *
   * <p>Method under test: {@link Dynamic#asLongStreamOpt()}
   */
  @Test
  @DisplayName("Test asLongStreamOpt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.asLongStreamOpt()"})
  void testAsLongStreamOpt() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<LongStream> partialValue = Optional.empty();

    Error<LongStream> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getLongStream(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<LongStream> actualAsLongStreamOptResult = dynamic.asLongStreamOpt();

    // Assert
    verify(ops).empty();
    verify(ops).getLongStream(isA(Object.class));
    assertSame(error, actualAsLongStreamOptResult);
  }

  /**
   * Test {@link Dynamic#get(String)}.
   *
   * <p>Method under test: {@link Dynamic#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.get(String)"})
  void testGet() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<MapLike<Object>> partialValue = Optional.empty();

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    OptionalDynamic<Object> actualGetResult = dynamic.get("Key");

    // Assert
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    assertSame(error, actualGetResult.get());
  }

  /**
   * Test {@link Dynamic#get(String)}.
   *
   * <p>Method under test: {@link Dynamic#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.get(String)"})
  void testGet2() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error = new Error<>(messageSupplier, partialValue, Lifecycle.stable());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    OptionalDynamic<Object> actualGetResult = dynamic.get("Key");

    // Assert
    verify(mapLike).get("Key");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    DataResult<Dynamic<Object>> getResult = actualGetResult.get();
    assertTrue(getResult instanceof Error);
    Optional<Dynamic<Object>> partialValueResult =
        ((Error<Dynamic<Object>>) getResult).partialValue();
    assertTrue(partialValueResult.isPresent());
    assertSame(getResult.getPartialOrThrow(), partialValueResult.get());
  }

  /**
   * Test {@link Dynamic#get(String)}.
   *
   * <ul>
   *   <li>Given {@link MapLike} {@link MapLike#get(String)} return {@code null}.
   *   <li>Then return not {@link OptionalDynamic#get()} partialValue Present.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#get(String)}
   */
  @Test
  @DisplayName(
      "Test get(String); given MapLike get(String) return 'null'; then return not get() partialValue Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.get(String)"})
  void testGet_givenMapLikeGetReturnNull_thenReturnNotGetPartialValuePresent() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any())).thenReturn(null);
    Lifecycle lifecycle = Lifecycle.experimental();

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(new Success<>(mapLike, lifecycle));
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    OptionalDynamic<Object> actualGetResult = dynamic.get("Key");

    // Assert
    verify(mapLike).get("Key");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    DataResult<Dynamic<Object>> getResult = actualGetResult.get();
    assertTrue(getResult instanceof Error);
    assertFalse(((Error<Dynamic<Object>>) getResult).partialValue().isPresent());
    assertTrue(getResult.isError());
    assertSame(lifecycle, getResult.lifecycle());
  }

  /**
   * Test {@link Dynamic#get(String)}.
   *
   * <ul>
   *   <li>Given {@link MapLike} {@link MapLike#get(String)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#get(String)}
   */
  @Test
  @DisplayName(
      "Test get(String); given MapLike get(String) throw IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.get(String)"})
  void testGet_givenMapLikeGetThrowIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any())).thenThrow(new IllegalStateException());
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.get("Key"));
    verify(mapLike).get("Key");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
  }

  /**
   * Test {@link Dynamic#get(String)}.
   *
   * <ul>
   *   <li>Then {@link OptionalDynamic#get()} return {@link Success}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#get(String)}
   */
  @Test
  @DisplayName("Test get(String); then get() return Success")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.get(String)"})
  void testGet_thenGetReturnSuccess() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Lifecycle lifecycle = Lifecycle.experimental();

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(new Success<>(mapLike, lifecycle));
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    OptionalDynamic<Object> actualGetResult = dynamic.get("Key");

    // Assert
    verify(mapLike).get("Key");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    DataResult<Dynamic<Object>> getResult = actualGetResult.get();
    assertTrue(getResult instanceof Success);
    assertFalse(getResult.isError());
    Dynamic<Object> orThrow = getResult.getOrThrow();
    assertSame(orThrow, getResult.getPartialOrThrow());
    assertSame(orThrow, ((Success<Dynamic<Object>>) getResult).value());
    assertSame(lifecycle, getResult.lifecycle());
  }

  /**
   * Test {@link Dynamic#get(String)}.
   *
   * <ul>
   *   <li>Then return {@link OptionalDynamic#get()} partialValue Present.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#get(String)}
   */
  @Test
  @DisplayName("Test get(String); then return get() partialValue Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDynamic Dynamic.get(String)"})
  void testGet_thenReturnGetPartialValuePresent() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    OptionalDynamic<Object> actualGetResult = dynamic.get("Key");

    // Assert
    verify(mapLike).get("Key");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    DataResult<Dynamic<Object>> getResult = actualGetResult.get();
    assertTrue(getResult instanceof Error);
    Optional<Dynamic<Object>> partialValueResult =
        ((Error<Dynamic<Object>>) getResult).partialValue();
    assertTrue(partialValueResult.isPresent());
    assertSame(getResult.getPartialOrThrow(), partialValueResult.get());
  }

  /**
   * Test {@link Dynamic#getGeneric(Object)}.
   *
   * <p>Method under test: {@link Dynamic#getGeneric(Object)}
   */
  @Test
  @DisplayName("Test getGeneric(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getGeneric(Object)"})
  void testGetGeneric() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Object> partialValue = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);

    Error<Object> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getGeneric(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Object> actualGeneric =
        dynamic.getGeneric(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(ops).getGeneric(isA(Object.class), isA(Object.class));
    verify(ops).empty();
    assertSame(error, actualGeneric);
  }

  /**
   * Test {@link Dynamic#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#remove(Object, String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#remove(String)}
   */
  @Test
  @DisplayName("Test remove(String); given RegistryOps remove(Object, String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.remove(String)"})
  void testRemove_givenRegistryOpsRemoveReturnNull() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(null);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRemoveResult = dynamic.remove("Key");

    // Assert
    verify(ops, atLeast(1)).empty();
    verify(ops).remove(isA(Object.class), eq("Key"));
    assertEquals(dynamic, actualRemoveResult);
  }

  /**
   * Test {@link Dynamic#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#remove(Object, String)} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); given RegistryOps remove(Object, String) return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.remove(String)"})
  void testRemove_givenRegistryOpsRemoveReturnWildcard_object() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRemoveResult = dynamic.remove("Key");

    // Assert
    verify(ops).empty();
    verify(ops).remove(isA(Object.class), eq("Key"));
    assertEquals(dynamic, actualRemoveResult);
  }

  /**
   * Test {@link Dynamic#set(String, Dynamic)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#set(String, Dynamic)}
   */
  @Test
  @DisplayName("Test set(String, Dynamic); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.set(String, Dynamic)"})
  void testSet_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> dynamic.set("Key", new Dynamic<>(new JsonOps(true))));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#update(String, Function)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#update(Object, String, Function)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#update(String, Function)}
   */
  @Test
  @DisplayName(
      "Test update(String, Function); given RegistryOps update(Object, String, Function) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.update(String, Function)"})
  void testUpdate_givenRegistryOpsUpdateReturnNull() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.update(
            Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Function<Object, Object>>any()))
        .thenReturn(null);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualUpdateResult = dynamic.update("Key", mock(Function.class));

    // Assert
    verify(ops).update(isA(Object.class), eq("Key"), isA(Function.class));
    verify(ops, atLeast(1)).empty();
    assertEquals(dynamic, actualUpdateResult);
  }

  /**
   * Test {@link Dynamic#update(String, Function)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#update(Object, String, Function)} return
   *       {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#update(String, Function)}
   */
  @Test
  @DisplayName(
      "Test update(String, Function); given RegistryOps update(Object, String, Function) return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.update(String, Function)"})
  void testUpdate_givenRegistryOpsUpdateReturnWildcard_object() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.update(
            Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Function<Object, Object>>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualUpdateResult = dynamic.update("Key", mock(Function.class));

    // Assert
    verify(ops).update(isA(Object.class), eq("Key"), isA(Function.class));
    verify(ops).empty();
    assertEquals(dynamic, actualUpdateResult);
  }

  /**
   * Test {@link Dynamic#updateGeneric(Object, Function)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#updateGeneric(Object, Object, Function)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#updateGeneric(Object, Function)}
   */
  @Test
  @DisplayName(
      "Test updateGeneric(Object, Function); given RegistryOps updateGeneric(Object, Object, Function) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.updateGeneric(Object, Function)"})
  void testUpdateGeneric_givenRegistryOpsUpdateGenericReturnNull() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.updateGeneric(
            Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Function<Object, Object>>any()))
        .thenReturn(null);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Dynamic<Object> actualUpdateGenericResult = dynamic.updateGeneric(object, mock(Function.class));

    // Assert
    verify(ops).updateGeneric(isA(Object.class), isA(Object.class), isA(Function.class));
    verify(ops, atLeast(1)).empty();
    assertSame(object, actualUpdateGenericResult.getValue());
  }

  /**
   * Test {@link Dynamic#updateGeneric(Object, Function)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#updateGeneric(Object, Object, Function)}
   *       return {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#updateGeneric(Object, Function)}
   */
  @Test
  @DisplayName(
      "Test updateGeneric(Object, Function); given RegistryOps updateGeneric(Object, Object, Function) return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.updateGeneric(Object, Function)"})
  void testUpdateGeneric_givenRegistryOpsUpdateGenericReturnWildcard_object() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.updateGeneric(
            Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Function<Object, Object>>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Dynamic<Object> actualUpdateGenericResult = dynamic.updateGeneric(object, mock(Function.class));

    // Assert
    verify(ops).updateGeneric(isA(Object.class), isA(Object.class), isA(Function.class));
    verify(ops).empty();
    assertSame(object, actualUpdateGenericResult.getValue());
  }

  /**
   * Test {@link Dynamic#setFieldIfPresent(String, Optional)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#setFieldIfPresent(String, Optional)}
   */
  @Test
  @DisplayName("Test setFieldIfPresent(String, Optional); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.setFieldIfPresent(String, Optional)"})
  void testSetFieldIfPresent_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);
    Optional<? extends Dynamic<?>> value = Optional.of(new Dynamic<>(new JsonOps(true)));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.setFieldIfPresent("Field", value));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#setFieldIfPresent(String, Optional)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return {@link Dynamic#Dynamic(DynamicOps)} with ops is {@link RegistryOps}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#setFieldIfPresent(String, Optional)}
   */
  @Test
  @DisplayName(
      "Test setFieldIfPresent(String, Optional); when empty; then return Dynamic(DynamicOps) with ops is RegistryOps")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.setFieldIfPresent(String, Optional)"})
  void testSetFieldIfPresent_whenEmpty_thenReturnDynamicWithOpsIsRegistryOps() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);
    Optional<? extends Dynamic<?>> value = Optional.empty();

    // Act
    Dynamic<Object> actualSetFieldIfPresentResult = dynamic.setFieldIfPresent("Field", value);

    // Assert
    verify(ops).empty();
    assertSame(dynamic, actualSetFieldIfPresentResult);
  }

  /**
   * Test {@link Dynamic#renameField(String, String)}.
   *
   * <p>Method under test: {@link Dynamic#renameField(String, String)}
   */
  @Test
  @DisplayName("Test renameField(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameField(String, String)"})
  void testRenameField() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRenameFieldResult =
        dynamic.renameField("Old Field Name", "New Field Name");

    // Assert
    verify(mapLike).get("Old Field Name");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
    assertEquals(dynamic, actualRenameFieldResult);
  }

  /**
   * Test {@link Dynamic#renameField(String, String)}.
   *
   * <p>Method under test: {@link Dynamic#renameField(String, String)}
   */
  @Test
  @DisplayName("Test renameField(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameField(String, String)"})
  void testRenameField2() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<MapLike<Object>> partialValue = Optional.empty();

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRenameFieldResult =
        dynamic.renameField("Old Field Name", "New Field Name");

    // Assert
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
    assertEquals(dynamic, actualRenameFieldResult);
  }

  /**
   * Test {@link Dynamic#renameField(String, String)}.
   *
   * <p>Method under test: {@link Dynamic#renameField(String, String)}
   */
  @Test
  @DisplayName("Test renameField(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameField(String, String)"})
  void testRenameField3() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error = new Error<>(messageSupplier, partialValue, Lifecycle.stable());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRenameFieldResult =
        dynamic.renameField("Old Field Name", "New Field Name");

    // Assert
    verify(mapLike).get("Old Field Name");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
    assertEquals(dynamic, actualRenameFieldResult);
  }

  /**
   * Test {@link Dynamic#renameField(String, String)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#set(Object, String, Object)} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then calls {@link RegistryOps#set(Object, String, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#renameField(String, String)}
   */
  @Test
  @DisplayName(
      "Test renameField(String, String); given RegistryOps set(Object, String, Object) return WILDCARD_OBJECT; then calls set(Object, String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameField(String, String)"})
  void testRenameField_givenRegistryOpsSetReturnWildcard_object_thenCallsSet() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Success<MapLike<Object>> success = new Success<>(mapLike, Lifecycle.experimental());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.set(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(success);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRenameFieldResult =
        dynamic.renameField("Old Field Name", "New Field Name");

    // Assert
    verify(ops).set(isA(Object.class), eq("New Field Name"), isA(Object.class));
    verify(mapLike).get("Old Field Name");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
    assertEquals(dynamic, actualRenameFieldResult);
  }

  /**
   * Test {@link Dynamic#renameField(String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#renameField(String, String)}
   */
  @Test
  @DisplayName("Test renameField(String, String); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameField(String, String)"})
  void testRenameField_thenThrowIllegalStateException() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any())).thenThrow(new IllegalStateException());
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> dynamic.renameField("Old Field Name", "New Field Name"));
    verify(mapLike).get("Old Field Name");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
  }

  /**
   * Test {@link Dynamic#replaceField(String, String, Optional)}.
   *
   * <ul>
   *   <li>Given {@link RegistryOps} {@link RegistryOps#remove(Object, String)} return {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#replaceField(String, String, Optional)}
   */
  @Test
  @DisplayName(
      "Test replaceField(String, String, Optional); given RegistryOps remove(Object, String) return 'null'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.replaceField(String, String, Optional)"})
  void testReplaceField_givenRegistryOpsRemoveReturnNull_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(null);
    Dynamic<Object> dynamic = new Dynamic<>(ops);
    Optional<? extends Dynamic<?>> newValue = Optional.of(new Dynamic<>(new JsonOps(true)));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> dynamic.replaceField("Old Field Name", "New Field Name", newValue));
    verify(ops, atLeast(1)).empty();
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
  }

  /**
   * Test {@link Dynamic#replaceField(String, String, Optional)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#replaceField(String, String, Optional)}
   */
  @Test
  @DisplayName("Test replaceField(String, String, Optional); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.replaceField(String, String, Optional)"})
  void testReplaceField_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);
    Optional<? extends Dynamic<?>> newValue = Optional.of(new Dynamic<>(new JsonOps(true)));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> dynamic.replaceField("Old Field Name", "New Field Name", newValue));
    verify(ops).empty();
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
  }

  /**
   * Test {@link Dynamic#replaceField(String, String, Optional)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return {@link Dynamic#Dynamic(DynamicOps)} with ops is {@link RegistryOps}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#replaceField(String, String, Optional)}
   */
  @Test
  @DisplayName(
      "Test replaceField(String, String, Optional); when empty; then return Dynamic(DynamicOps) with ops is RegistryOps")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.replaceField(String, String, Optional)"})
  void testReplaceField_whenEmpty_thenReturnDynamicWithOpsIsRegistryOps() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);
    Optional<? extends Dynamic<?>> newValue = Optional.empty();

    // Act
    Dynamic<Object> actualReplaceFieldResult =
        dynamic.replaceField("Old Field Name", "New Field Name", newValue);

    // Assert
    verify(ops).empty();
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
    assertEquals(dynamic, actualReplaceFieldResult);
  }

  /**
   * Test {@link Dynamic#renameAndFixField(String, String, UnaryOperator)}.
   *
   * <p>Method under test: {@link Dynamic#renameAndFixField(String, String, UnaryOperator)}
   */
  @Test
  @DisplayName("Test renameAndFixField(String, String, UnaryOperator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameAndFixField(String, String, UnaryOperator)"})
  void testRenameAndFixField() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRenameAndFixFieldResult =
        dynamic.renameAndFixField("Old Field Name", "New Field Name", mock(UnaryOperator.class));

    // Assert
    verify(mapLike).get("Old Field Name");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
    assertEquals(dynamic, actualRenameAndFixFieldResult);
  }

  /**
   * Test {@link Dynamic#renameAndFixField(String, String, UnaryOperator)}.
   *
   * <p>Method under test: {@link Dynamic#renameAndFixField(String, String, UnaryOperator)}
   */
  @Test
  @DisplayName("Test renameAndFixField(String, String, UnaryOperator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameAndFixField(String, String, UnaryOperator)"})
  void testRenameAndFixField2() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<MapLike<Object>> partialValue = Optional.empty();

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRenameAndFixFieldResult =
        dynamic.renameAndFixField("Old Field Name", "New Field Name", mock(UnaryOperator.class));

    // Assert
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
    assertEquals(dynamic, actualRenameAndFixFieldResult);
  }

  /**
   * Test {@link Dynamic#renameAndFixField(String, String, UnaryOperator)}.
   *
   * <p>Method under test: {@link Dynamic#renameAndFixField(String, String, UnaryOperator)}
   */
  @Test
  @DisplayName("Test renameAndFixField(String, String, UnaryOperator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameAndFixField(String, String, UnaryOperator)"})
  void testRenameAndFixField3() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error = new Error<>(messageSupplier, partialValue, Lifecycle.stable());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualRenameAndFixFieldResult =
        dynamic.renameAndFixField("Old Field Name", "New Field Name", mock(UnaryOperator.class));

    // Assert
    verify(mapLike).get("Old Field Name");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
    assertEquals(dynamic, actualRenameAndFixFieldResult);
  }

  /**
   * Test {@link Dynamic#renameAndFixField(String, String, UnaryOperator)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#renameAndFixField(String, String, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test renameAndFixField(String, String, UnaryOperator); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.renameAndFixField(String, String, UnaryOperator)"})
  void testRenameAndFixField_thenThrowIllegalStateException() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any())).thenThrow(new IllegalStateException());
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.remove(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            dynamic.renameAndFixField(
                "Old Field Name", "New Field Name", mock(UnaryOperator.class)));
    verify(mapLike).get("Old Field Name");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
    verify(ops).remove(isA(Object.class), eq("Old Field Name"));
  }

  /**
   * Test {@link Dynamic#getElement(String)} with {@code key}.
   *
   * <p>Method under test: {@link Dynamic#getElement(String)}
   */
  @Test
  @DisplayName("Test getElement(String) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getElement(String)"})
  void testGetElementWithKey() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Object> partialValue = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);

    Error<Object> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getGeneric(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(error);
    when(ops.createString(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Object> actualElement = dynamic.getElement("Key");

    // Assert
    verify(ops).getGeneric(isA(Object.class), isA(Object.class));
    verify(ops).createString("Key");
    verify(ops).empty();
    assertSame(error, actualElement);
  }

  /**
   * Test {@link Dynamic#getElementGeneric(Object)} with {@code key}.
   *
   * <p>Method under test: {@link Dynamic#getElementGeneric(Object)}
   */
  @Test
  @DisplayName("Test getElementGeneric(Object) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.getElementGeneric(Object)"})
  void testGetElementGenericWithKey() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Object> partialValue = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);

    Error<Object> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(ops.getGeneric(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    DataResult<Object> actualElementGeneric =
        dynamic.getElementGeneric(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(ops).getGeneric(isA(Object.class), isA(Object.class));
    verify(ops).empty();
    assertSame(error, actualElementGeneric);
  }

  /**
   * Test {@link Dynamic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dynamic.equals(Object)", "int Dynamic.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    RegistryOps<Object> ops2 = mock(RegistryOps.class);
    when(ops2.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertNotEquals(dynamic, new Dynamic<>(ops2));
  }

  /**
   * Test {@link Dynamic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dynamic.equals(Object)", "int Dynamic.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertNotEquals(dynamic, null);
  }

  /**
   * Test {@link Dynamic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dynamic.equals(Object)", "int Dynamic.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act and Assert
    assertNotEquals(dynamic, 1);
  }

  /**
   * Test {@link Dynamic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dynamic.equals(Object)", "int Dynamic.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Dynamic<Object> dynamic = new Dynamic<>(null, 42);

    // Act and Assert
    assertNotEquals(dynamic, new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link Dynamic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dynamic.equals(Object)", "int Dynamic.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Dynamic<Object> dynamic =
        new Dynamic<>(null, new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT));

    // Act and Assert
    assertNotEquals(dynamic, new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link Dynamic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dynamic.equals(Object)", "int Dynamic.hashCode()"})
  void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Dynamic<Object> dynamic = new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertEquals(dynamic, new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link Dynamic#convert(DynamicOps, DynamicOps, Object)} with {@code inOps}, {@code
   * outOps}, {@code input}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#convert(DynamicOps, DynamicOps, Object)}
   */
  @Test
  @DisplayName(
      "Test convert(DynamicOps, DynamicOps, Object) with 'inOps', 'outOps', 'input'; given WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Dynamic.convert(DynamicOps, DynamicOps, Object)"})
  void testConvertWithInOpsOutOpsInput_givenWildcard_object() {
    // Arrange
    RegistryOps<Object> inOps = mock(RegistryOps.class);
    when(inOps.convertTo(Mockito.<DynamicOps<Object>>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Dynamic.convert(inOps, null, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(inOps).convertTo(isNull(), isA(Object.class));
  }

  /**
   * Test {@link Dynamic#convert(DynamicOps, DynamicOps, Object)} with {@code inOps}, {@code
   * outOps}, {@code input}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#convert(DynamicOps, DynamicOps, Object)}
   */
  @Test
  @DisplayName(
      "Test convert(DynamicOps, DynamicOps, Object) with 'inOps', 'outOps', 'input'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Dynamic.convert(DynamicOps, DynamicOps, Object)"})
  void testConvertWithInOpsOutOpsInput_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> inOps = mock(RegistryOps.class);
    when(inOps.convertTo(Mockito.<DynamicOps<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> Dynamic.convert(inOps, null, ConfigurationTransformation.WILDCARD_OBJECT));
    verify(inOps).convertTo(isNull(), isA(Object.class));
  }

  /**
   * Test {@link Dynamic#convert(DynamicOps)} with {@code outOps}.
   *
   * <ul>
   *   <li>Given {@link Dynamic#Dynamic(DynamicOps, Object)} with ops is {@code null} and value is
   *       {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#convert(DynamicOps)}
   */
  @Test
  @DisplayName(
      "Test convert(DynamicOps) with 'outOps'; given Dynamic(DynamicOps, Object) with ops is 'null' and value is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.convert(DynamicOps)"})
  void testConvertWithOutOps_givenDynamicWithOpsIsNullAndValueIsWildcard_object() {
    // Arrange
    Dynamic<Object> dynamic = new Dynamic<>(null, ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertNull(dynamic.convert(null).getOps());
  }

  /**
   * Test {@link Dynamic#convert(DynamicOps)} with {@code outOps}.
   *
   * <ul>
   *   <li>Then calls {@link RegistryOps#empty()}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#convert(DynamicOps)}
   */
  @Test
  @DisplayName("Test convert(DynamicOps) with 'outOps'; then calls empty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.convert(DynamicOps)"})
  void testConvertWithOutOps_thenCallsEmpty() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.convertTo(Mockito.<DynamicOps<Object>>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    // Act
    Dynamic<Object> actualConvertResult = dynamic.convert(null);

    // Assert
    verify(ops).convertTo(isNull(), isA(Object.class));
    verify(ops).empty();
    assertNull(actualConvertResult.getOps());
  }

  /**
   * Test {@link Dynamic#convert(DynamicOps)} with {@code outOps}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#convert(DynamicOps)}
   */
  @Test
  @DisplayName("Test convert(DynamicOps) with 'outOps'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dynamic Dynamic.convert(DynamicOps)"})
  void testConvertWithOutOps_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.convertTo(Mockito.<DynamicOps<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());
    Dynamic<Object> dynamic = new Dynamic<>(ops, ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.convert(null));
    verify(ops).convertTo(isNull(), isA(Object.class));
  }

  /**
   * Test {@link Dynamic#into(Function)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#into(Function)}
   */
  @Test
  @DisplayName(
      "Test into(Function); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Dynamic.into(Function)"})
  void testInto_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    Function<Dynamic<Object>, Object> action = mock(Function.class);
    when(action.apply(Mockito.<Dynamic<Object>>any())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.into(action));
    verify(action).apply(isA(Dynamic.class));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#into(Function)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#into(Function)}
   */
  @Test
  @DisplayName(
      "Test into(Function); given WILDCARD_OBJECT; when Function apply(Object) return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Dynamic.into(Function)"})
  void testInto_givenWildcard_object_whenFunctionApplyReturnWildcard_object() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    Function<Dynamic<Object>, Object> action = mock(Function.class);
    when(action.apply(Mockito.<Dynamic<Object>>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    dynamic.into(action);

    // Assert
    verify(action).apply(isA(Dynamic.class));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#copyAndFixField(Dynamic, String, Dynamic, String, UnaryOperator)}.
   *
   * <ul>
   *   <li>Given {@link MapLike} {@link MapLike#get(String)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#copyAndFixField(Dynamic, String, Dynamic, String,
   * UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test copyAndFixField(Dynamic, String, Dynamic, String, UnaryOperator); given MapLike get(String) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dynamic Dynamic.copyAndFixField(Dynamic, String, Dynamic, String, UnaryOperator)"
  })
  void testCopyAndFixField_givenMapLikeGetThrowIllegalStateException() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any())).thenThrow(new IllegalStateException());
    Optional<MapLike<Object>> partialValue = Optional.of(mapLike);
    Supplier<String> messageSupplier = mock(Supplier.class);

    Error<MapLike<Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any())).thenReturn(error);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> source = new Dynamic<>(ops);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            Dynamic.copyAndFixField(
                source,
                "Source Field Name",
                new Dynamic<>(new JsonOps(true)),
                "Target Field Name",
                mock(UnaryOperator.class)));
    verify(mapLike).get("Source Field Name");
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
  }

  /**
   * Test {@link Dynamic#copyAndFixField(Dynamic, String, Dynamic, String, UnaryOperator)}.
   *
   * <ul>
   *   <li>Then calls {@link UnaryOperator#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#copyAndFixField(Dynamic, String, Dynamic, String,
   * UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test copyAndFixField(Dynamic, String, Dynamic, String, UnaryOperator); then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dynamic Dynamic.copyAndFixField(Dynamic, String, Dynamic, String, UnaryOperator)"
  })
  void testCopyAndFixField_thenCallsApply() {
    // Arrange
    MapLike<Object> mapLike = mock(MapLike.class);
    when(mapLike.get(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.getMap(Mockito.<Object>any()))
        .thenReturn(new Success<>(mapLike, Lifecycle.experimental()));
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> source = new Dynamic<>(ops);
    Dynamic<?> target = new Dynamic<>(new JsonOps(true));

    UnaryOperator<Dynamic<Object>> fixer = mock(UnaryOperator.class);
    when(fixer.apply(Mockito.<Dynamic<Object>>any())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            Dynamic.copyAndFixField(
                source, "Source Field Name", target, "Target Field Name", fixer));
    verify(mapLike).get("Source Field Name");
    verify(fixer).apply(isA(Dynamic.class));
    verify(ops).empty();
    verify(ops).getMap(isA(Object.class));
  }

  /**
   * Test {@link Dynamic#decode(Decoder)}.
   *
   * <p>Method under test: {@link Dynamic#decode(Decoder)}
   */
  @Test
  @DisplayName("Test decode(Decoder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.decode(Decoder)"})
  void testDecode() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    Decoder<Object> decoder = mock(Decoder.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Pair<Object, Object>> partialValue = Optional.empty();

    Error<Pair<Object, Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(decoder.decode(Mockito.<DynamicOps<Object>>any(), Mockito.<Object>any()))
        .thenReturn(error);

    // Act
    DataResult<Pair<Object, Object>> actualDecodeResult = dynamic.decode(decoder);

    // Assert
    verify(decoder).decode(isA(DynamicOps.class), isA(Object.class));
    verify(ops).empty();
    assertSame(error, actualDecodeResult);
  }

  /**
   * Test {@link Dynamic#decode(Decoder)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#decode(Decoder)}
   */
  @Test
  @DisplayName(
      "Test decode(Decoder); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.decode(Decoder)"})
  void testDecode_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    Decoder<Object> decoder = mock(Decoder.class);
    when(decoder.decode(Mockito.<DynamicOps<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> dynamic.decode(decoder));
    verify(decoder).decode(isA(DynamicOps.class), isA(Object.class));
    verify(ops).empty();
  }

  /**
   * Test {@link Dynamic#decode(Decoder)}.
   *
   * <ul>
   *   <li>Then return {@link Error}.
   * </ul>
   *
   * <p>Method under test: {@link Dynamic#decode(Decoder)}
   */
  @Test
  @DisplayName("Test decode(Decoder); then return Error")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataResult Dynamic.decode(Decoder)"})
  void testDecode_thenReturnError() {
    // Arrange
    RegistryOps<Object> ops = mock(RegistryOps.class);
    when(ops.empty()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    Dynamic<Object> dynamic = new Dynamic<>(ops);

    Decoder<Object> decoder = mock(Decoder.class);
    Supplier<String> messageSupplier = mock(Supplier.class);
    Optional<Pair<Object, Object>> partialValue =
        Optional.of(
            new Pair<>(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ConfigurationTransformation.WILDCARD_OBJECT));

    Error<Pair<Object, Object>> error =
        new Error<>(messageSupplier, partialValue, Lifecycle.experimental());
    when(decoder.decode(Mockito.<DynamicOps<Object>>any(), Mockito.<Object>any()))
        .thenReturn(error);

    // Act
    DataResult<Pair<Object, Object>> actualDecodeResult = dynamic.decode(decoder);

    // Assert
    verify(decoder).decode(isA(DynamicOps.class), isA(Object.class));
    verify(ops).empty();
    assertTrue(actualDecodeResult instanceof Error);
    assertEquals(error, actualDecodeResult);
  }
}
