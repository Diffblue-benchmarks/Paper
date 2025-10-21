package ca.spottedleaf.moonrise.common.map;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class SynchronisedLong2ObjectMapDiffblueTest {
  /**
   * Test {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)}.
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)}
   */
  @Test
  @DisplayName("Test new SynchronisedLong2ObjectMap(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SynchronisedLong2ObjectMap.<init>(int)"})
  void testNewSynchronisedLong2ObjectMap() {
    // Arrange and Act
    SynchronisedLong2ObjectMap<Object> actualSynchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);

    // Assert
    assertNull(actualSynchronisedLong2ObjectMap.get(1L));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#get(long)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one minus one is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#get(long)}
   */
  @Test
  @DisplayName(
      "Test get(long); given SynchronisedLong2ObjectMap(int) with limit is one minus one is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.get(long)"})
  void testGet_givenSynchronisedLong2ObjectMapWithLimitIsOneMinusOneIsWildcard_object() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(-1L, ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertNull(synchronisedLong2ObjectMap.get(Long.MAX_VALUE));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#get(long)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#get(long)}
   */
  @Test
  @DisplayName(
      "Test get(long); given SynchronisedLong2ObjectMap(int) with limit is one; when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.get(long)"})
  void testGet_givenSynchronisedLong2ObjectMapWithLimitIsOne_whenOne_thenReturnNull() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);

    // Act and Assert
    assertNull(synchronisedLong2ObjectMap.get(1L));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#get(long)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one.
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#get(long)}
   */
  @Test
  @DisplayName(
      "Test get(long); given SynchronisedLong2ObjectMap(int) with limit is one; when zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.get(long)"})
  void testGet_givenSynchronisedLong2ObjectMapWithLimitIsOne_whenZero_thenReturnNull() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);

    // Act and Assert
    assertNull(synchronisedLong2ObjectMap.get(0L));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName("Test put(long, Object); given SynchronisedLong2ObjectMap(int) with limit is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_givenSynchronisedLong2ObjectMapWithLimitIsOne() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act and Assert
    assertNull(synchronisedLong2ObjectMap.put(1L, object));
    assertSame(object, synchronisedLong2ObjectMap.get(1L));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName("Test put(long, Object); given SynchronisedLong2ObjectMap(int) with limit is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_givenSynchronisedLong2ObjectMapWithLimitIsOne2() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);

    // Act
    Object actualPutResult =
        synchronisedLong2ObjectMap.put(0L, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertNull(synchronisedLong2ObjectMap.get(1L));
    assertNull(actualPutResult);
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one minus one is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName(
      "Test put(long, Object); given SynchronisedLong2ObjectMap(int) with limit is one minus one is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_givenSynchronisedLong2ObjectMapWithLimitIsOneMinusOneIsWildcard_object() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(-1L, ConfigurationTransformation.WILDCARD_OBJECT);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act and Assert
    assertNull(synchronisedLong2ObjectMap.put(1L, object));
    assertSame(object, synchronisedLong2ObjectMap.get(1L));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one one is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName(
      "Test put(long, Object); given SynchronisedLong2ObjectMap(int) with limit is one one is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_givenSynchronisedLong2ObjectMapWithLimitIsOneOneIsWildcard_object() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(1L, ConfigurationTransformation.WILDCARD_OBJECT);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualPutResult = synchronisedLong2ObjectMap.put(1L, object);

    // Assert
    assertSame(object, synchronisedLong2ObjectMap.get(1L));
    assertSame(object, actualPutResult);
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one zero is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName(
      "Test put(long, Object); given SynchronisedLong2ObjectMap(int) with limit is one zero is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_givenSynchronisedLong2ObjectMapWithLimitIsOneZeroIsWildcard_object() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(0L, ConfigurationTransformation.WILDCARD_OBJECT);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act and Assert
    assertNull(synchronisedLong2ObjectMap.put(1L, object));
    assertSame(object, synchronisedLong2ObjectMap.get(1L));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one zero is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName(
      "Test put(long, Object); given SynchronisedLong2ObjectMap(int) with limit is one zero is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_givenSynchronisedLong2ObjectMapWithLimitIsOneZeroIsWildcard_object2() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(0L, ConfigurationTransformation.WILDCARD_OBJECT);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualPutResult = synchronisedLong2ObjectMap.put(0L, object);

    // Assert
    assertNull(synchronisedLong2ObjectMap.get(1L));
    assertSame(object, actualPutResult);
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Then {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is two
   *       one is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName(
      "Test put(long, Object); then SynchronisedLong2ObjectMap(int) with limit is two one is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_thenSynchronisedLong2ObjectMapWithLimitIsTwoOneIsWildcard_object() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(2);
    synchronisedLong2ObjectMap.put(1L, ConfigurationTransformation.WILDCARD_OBJECT);
    synchronisedLong2ObjectMap.put(0L, ConfigurationTransformation.WILDCARD_OBJECT);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualPutResult = synchronisedLong2ObjectMap.put(1L, object);

    // Assert
    assertSame(object, synchronisedLong2ObjectMap.get(1L));
    assertSame(object, actualPutResult);
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Then {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is two
   *       one is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName(
      "Test put(long, Object); then SynchronisedLong2ObjectMap(int) with limit is two one is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_thenSynchronisedLong2ObjectMapWithLimitIsTwoOneIsWildcard_object2() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(2);
    synchronisedLong2ObjectMap.put(1L, ConfigurationTransformation.WILDCARD_OBJECT);
    synchronisedLong2ObjectMap.put(0L, ConfigurationTransformation.WILDCARD_OBJECT);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualPutResult = synchronisedLong2ObjectMap.put(0L, object);

    // Assert
    assertSame(object, synchronisedLong2ObjectMap.get(1L));
    assertSame(object, actualPutResult);
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>Then {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       zero one is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName(
      "Test put(long, Object); then SynchronisedLong2ObjectMap(int) with limit is zero one is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_thenSynchronisedLong2ObjectMapWithLimitIsZeroOneIsNull() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(0);

    // Act
    Object actualPutResult =
        synchronisedLong2ObjectMap.put(1L, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertNull(synchronisedLong2ObjectMap.get(1L));
    assertNull(actualPutResult);
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#put(long, Object)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#put(long, Object)}
   */
  @Test
  @DisplayName("Test put(long, Object); when MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.put(long, Object)"})
  void testPut_whenMax_value() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(-1L, ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Object actualPutResult =
        synchronisedLong2ObjectMap.put(Long.MAX_VALUE, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertNull(synchronisedLong2ObjectMap.get(1L));
    assertNull(actualPutResult);
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName("Test compute(long, BiFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(-1L, ConfigurationTransformation.WILDCARD_OBJECT);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(1L, remappingFunction);

    // Assert
    verify(remappingFunction).apply(eq(1L), isNull());
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one one is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test compute(long, BiFunction); given SynchronisedLong2ObjectMap(int) with limit is one one is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute_givenSynchronisedLong2ObjectMapWithLimitIsOneOneIsWildcard_object() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(1L, ConfigurationTransformation.WILDCARD_OBJECT);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(1L, remappingFunction);

    // Assert
    verify(remappingFunction).apply(eq(1L), isA(Object.class));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one zero is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test compute(long, BiFunction); given SynchronisedLong2ObjectMap(int) with limit is one zero is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute_givenSynchronisedLong2ObjectMapWithLimitIsOneZeroIsWildcard_object() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(0L, ConfigurationTransformation.WILDCARD_OBJECT);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(0L, remappingFunction);

    // Assert that nothing has changed
    verify(remappingFunction).apply(eq(0L), isA(Object.class));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one.
   *   <li>When one.
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test compute(long, BiFunction); given SynchronisedLong2ObjectMap(int) with limit is one; when one; then calls apply(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute_givenSynchronisedLong2ObjectMapWithLimitIsOne_whenOne_thenCallsApply() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(1L, remappingFunction);

    // Assert
    verify(remappingFunction).apply(eq(1L), isNull());
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       one.
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test compute(long, BiFunction); given SynchronisedLong2ObjectMap(int) with limit is one; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute_givenSynchronisedLong2ObjectMapWithLimitIsOne_whenZero() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(0L, remappingFunction);

    // Assert that nothing has changed
    verify(remappingFunction).apply(eq(0L), isNull());
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       zero.
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test compute(long, BiFunction); given SynchronisedLong2ObjectMap(int) with limit is zero; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute_givenSynchronisedLong2ObjectMapWithLimitIsZero_whenOne() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(0);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(1L, remappingFunction);

    // Assert that nothing has changed
    verify(remappingFunction).apply(eq(1L), isNull());
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is
   *       zero.
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test compute(long, BiFunction); given SynchronisedLong2ObjectMap(int) with limit is zero; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute_givenSynchronisedLong2ObjectMapWithLimitIsZero_whenZero() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(0);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(0L, remappingFunction);

    // Assert that nothing has changed
    verify(remappingFunction).apply(eq(0L), isNull());
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <ul>
   *   <li>Then {@link SynchronisedLong2ObjectMap#SynchronisedLong2ObjectMap(int)} with limit is one
   *       one is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test compute(long, BiFunction); then SynchronisedLong2ObjectMap(int) with limit is one one is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute_thenSynchronisedLong2ObjectMapWithLimitIsOneOneIsNull() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(1L, ConfigurationTransformation.WILDCARD_OBJECT);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(0L, remappingFunction);

    // Assert
    verify(remappingFunction).apply(eq(0L), isNull());
    assertNull(synchronisedLong2ObjectMap.get(1L));
  }

  /**
   * Test {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2ObjectMap#compute(long, BiFunction)}
   */
  @Test
  @DisplayName("Test compute(long, BiFunction); when MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SynchronisedLong2ObjectMap.compute(long, BiFunction)"})
  void testCompute_whenMax_value() {
    // Arrange
    SynchronisedLong2ObjectMap<Object> synchronisedLong2ObjectMap =
        new SynchronisedLong2ObjectMap<>(1);
    synchronisedLong2ObjectMap.put(-1L, ConfigurationTransformation.WILDCARD_OBJECT);

    BiFunction<Long, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Long>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    synchronisedLong2ObjectMap.compute(Long.MAX_VALUE, remappingFunction);

    // Assert that nothing has changed
    verify(remappingFunction).apply(eq(9223372036854775807L), isNull());
  }
}
