package co.aikar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoadingMapDiffblueTest {
  /**
   * Test {@link LoadingMap#LoadingMap(Map, Function)}.
   *
   * <p>Method under test: {@link LoadingMap#LoadingMap(Map, Function)}
   */
  @Test
  @DisplayName("Test new LoadingMap(Map, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadingMap.<init>(Map, Function)"})
  void testNewLoadingMap() {
    // Arrange and Act
    LoadingMap<Object, Object> actualObjectObjectMap =
        new LoadingMap<>(new HashMap<>(), mock(Function.class));

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }

  /**
   * Test {@link LoadingMap#of(Map, Function)}.
   *
   * <p>Method under test: {@link LoadingMap#of(Map, Function)}
   */
  @Test
  @DisplayName("Test of(Map, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.of(Map, Function)"})
  void testOf() {
    // Arrange and Act
    Map<Object, Object> actualOfResult = LoadingMap.of(new HashMap<>(), mock(Function.class));

    // Assert
    assertTrue(actualOfResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newAutoMap(Map, Class, Class)} with {@code backingMap}, {@code
   * keyClass}, {@code valueClass}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#newAutoMap(Map, Class, Class)}
   */
  @Test
  @DisplayName(
      "Test newAutoMap(Map, Class, Class) with 'backingMap', 'keyClass', 'valueClass'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newAutoMap(Map, Class, Class)"})
  void testNewAutoMapWithBackingMapKeyClassValueClass_whenNull_thenReturnEmpty() {
    // Arrange
    HashMap<Object, Object> backingMap = new HashMap<>();
    Class<Object> valueClass = Object.class;

    // Act
    Map<Object, Object> actualNewAutoMapResult =
        LoadingMap.newAutoMap(backingMap, null, valueClass);

    // Assert
    assertTrue(actualNewAutoMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newAutoMap(Map, Class)} with {@code backingMap}, {@code valueClass}.
   *
   * <p>Method under test: {@link LoadingMap#newAutoMap(Map, Class)}
   */
  @Test
  @DisplayName("Test newAutoMap(Map, Class) with 'backingMap', 'valueClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newAutoMap(Map, Class)"})
  void testNewAutoMapWithBackingMapValueClass() {
    // Arrange
    HashMap<Object, Object> backingMap = new HashMap<>();
    Class<Object> valueClass = Object.class;

    // Act
    Map<Object, Object> actualNewAutoMapResult = LoadingMap.newAutoMap(backingMap, valueClass);

    // Assert
    assertTrue(actualNewAutoMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newHashAutoMap(Class, Class, int, float)} with {@code keyClass}, {@code
   * valueClass}, {@code initialCapacity}, {@code loadFactor}.
   *
   * <p>Method under test: {@link LoadingMap#newHashAutoMap(Class, Class, int, float)}
   */
  @Test
  @DisplayName(
      "Test newHashAutoMap(Class, Class, int, float) with 'keyClass', 'valueClass', 'initialCapacity', 'loadFactor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newHashAutoMap(Class, Class, int, float)"})
  void testNewHashAutoMapWithKeyClassValueClassInitialCapacityLoadFactor() {
    // Arrange
    Class<Object> valueClass = Object.class;

    // Act
    Map<Object, Object> actualNewHashAutoMapResult =
        LoadingMap.newHashAutoMap(null, valueClass, 19088743, 10.0f);

    // Assert
    assertTrue(actualNewHashAutoMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newHashAutoMap(Class, Class)} with {@code keyClass}, {@code valueClass}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#newHashAutoMap(Class, Class)}
   */
  @Test
  @DisplayName(
      "Test newHashAutoMap(Class, Class) with 'keyClass', 'valueClass'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newHashAutoMap(Class, Class)"})
  void testNewHashAutoMapWithKeyClassValueClass_whenNull_thenReturnEmpty() {
    // Arrange
    Class<Object> valueClass = Object.class;

    // Act
    Map<Object, Object> actualNewHashAutoMapResult = LoadingMap.newHashAutoMap(null, valueClass);

    // Assert
    assertTrue(actualNewHashAutoMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newHashAutoMap(Class)} with {@code valueClass}.
   *
   * <p>Method under test: {@link LoadingMap#newHashAutoMap(Class)}
   */
  @Test
  @DisplayName("Test newHashAutoMap(Class) with 'valueClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newHashAutoMap(Class)"})
  void testNewHashAutoMapWithValueClass() {
    // Arrange
    Class<Object> valueClass = Object.class;

    // Act
    Map<Object, Object> actualNewHashAutoMapResult = LoadingMap.newHashAutoMap(valueClass);

    // Assert
    assertTrue(actualNewHashAutoMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newHashAutoMap(Class, int, float)} with {@code valueClass}, {@code
   * initialCapacity}, {@code loadFactor}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#newHashAutoMap(Class, int, float)}
   */
  @Test
  @DisplayName(
      "Test newHashAutoMap(Class, int, float) with 'valueClass', 'initialCapacity', 'loadFactor'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newHashAutoMap(Class, int, float)"})
  void testNewHashAutoMapWithValueClassInitialCapacityLoadFactor_thenReturnEmpty() {
    // Arrange
    Class<Object> valueClass = Object.class;

    // Act
    Map<Object, Object> actualNewHashAutoMapResult =
        LoadingMap.newHashAutoMap(valueClass, 19088743, 10.0f);

    // Assert
    assertTrue(actualNewHashAutoMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newHashMap(Function)} with {@code loader}.
   *
   * <p>Method under test: {@link LoadingMap#newHashMap(Function)}
   */
  @Test
  @DisplayName("Test newHashMap(Function) with 'loader'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newHashMap(Function)"})
  void testNewHashMapWithLoader() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = LoadingMap.newHashMap(mock(Function.class));

    // Assert
    assertTrue(actualNewHashMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newHashMap(Function, int, float)} with {@code loader}, {@code
   * initialCapacity}, {@code loadFactor}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#newHashMap(Function, int, float)}
   */
  @Test
  @DisplayName(
      "Test newHashMap(Function, int, float) with 'loader', 'initialCapacity', 'loadFactor'; when '19088743'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newHashMap(Function, int, float)"})
  void testNewHashMapWithLoaderInitialCapacityLoadFactor_when19088743_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult =
        LoadingMap.newHashMap(mock(Function.class), 19088743, 10.0f);

    // Assert
    assertTrue(actualNewHashMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newHashMap(Function, int)} with {@code loader}, {@code initialCapacity}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#newHashMap(Function, int)}
   */
  @Test
  @DisplayName(
      "Test newHashMap(Function, int) with 'loader', 'initialCapacity'; when '19088743'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newHashMap(Function, int)"})
  void testNewHashMapWithLoaderInitialCapacity_when19088743_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult =
        LoadingMap.newHashMap(mock(Function.class), 19088743);

    // Assert
    assertTrue(actualNewHashMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newIdentityHashMap(Function)} with {@code loader}.
   *
   * <p>Method under test: {@link LoadingMap#newIdentityHashMap(Function)}
   */
  @Test
  @DisplayName("Test newIdentityHashMap(Function) with 'loader'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newIdentityHashMap(Function)"})
  void testNewIdentityHashMapWithLoader() {
    // Arrange and Act
    Map<Object, Object> actualNewIdentityHashMapResult =
        LoadingMap.newIdentityHashMap(mock(Function.class));

    // Assert
    assertTrue(actualNewIdentityHashMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#newIdentityHashMap(Function, int)} with {@code loader}, {@code
   * initialCapacity}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#newIdentityHashMap(Function, int)}
   */
  @Test
  @DisplayName(
      "Test newIdentityHashMap(Function, int) with 'loader', 'initialCapacity'; when '19088743'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LoadingMap.newIdentityHashMap(Function, int)"})
  void testNewIdentityHashMapWithLoaderInitialCapacity_when19088743_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualNewIdentityHashMapResult =
        LoadingMap.newIdentityHashMap(mock(Function.class), 19088743);

    // Assert
    assertTrue(actualNewIdentityHashMapResult.isEmpty());
  }

  /**
   * Test {@link LoadingMap#containsKey(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LoadingMap.containsKey(Object)"})
  void testContainsKey_thenReturnFalse() {
    // Arrange
    LoadingMap<Object, Object> objectObjectMap =
        new LoadingMap<>(new HashMap<>(), mock(Function.class));

    // Act and Assert
    assertFalse(objectObjectMap.containsKey("Key"));
  }

  /**
   * Test {@link LoadingMap#containsKey(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LoadingMap.containsKey(Object)"})
  void testContainsKey_thenReturnTrue() {
    // Arrange
    LoadingMap<Object, Object> objectObjectMap =
        new LoadingMap<>(new HashMap<>(), mock(Function.class));
    objectObjectMap.put("Key", "Value");

    // Act and Assert
    assertTrue(objectObjectMap.containsKey("Key"));
  }

  /**
   * Test {@link LoadingMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LoadingMap.containsValue(Object)"})
  void testContainsValue_thenReturnFalse() {
    // Arrange
    HashMap<Object, Object> backingMap = new HashMap<>();
    backingMap.put("Backing Map", "Backing Map");
    LoadingMap<Object, Object> objectObjectMap = new LoadingMap<>(backingMap, mock(Function.class));

    // Act and Assert
    assertFalse(objectObjectMap.containsValue("Value"));
  }

  /**
   * Test {@link LoadingMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LoadingMap.containsValue(Object)"})
  void testContainsValue_thenReturnTrue() {
    // Arrange
    HashMap<Object, Object> backingMap = new HashMap<>();
    backingMap.put("Backing Map", "Backing Map");

    LoadingMap<Object, Object> objectObjectMap = new LoadingMap<>(backingMap, mock(Function.class));
    objectObjectMap.put("Key", "Value");

    // Act and Assert
    assertTrue(objectObjectMap.containsValue("Value"));
  }

  /**
   * Test {@link LoadingMap#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return {@code Apply}.
   *   <li>Then return {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object); given Function apply(Object) return 'Apply'; then return 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LoadingMap.get(Object)"})
  void testGet_givenFunctionApplyReturnApply_thenReturnApply() {
    // Arrange
    Function<Object, Object> loader = mock(Function.class);
    when(loader.apply(Mockito.<Object>any())).thenReturn("Apply");
    LoadingMap<Object, Object> objectObjectMap = new LoadingMap<>(new HashMap<>(), loader);

    // Act
    Object actualGetResult = objectObjectMap.get("Key");

    // Assert
    verify(loader).apply(isA(Object.class));
    assertEquals(1, objectObjectMap.size());
    assertEquals("Apply", actualGetResult);
    assertEquals("Apply", objectObjectMap.get("Key"));
  }

  /**
   * Test {@link LoadingMap#get(Object)}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingMap#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LoadingMap.get(Object)"})
  void testGet_thenReturnValue() {
    // Arrange
    LoadingMap<Object, Object> objectObjectMap =
        new LoadingMap<>(new HashMap<>(), mock(Function.class));
    objectObjectMap.put("Key", "Value");

    // Act
    Object actualGetResult = objectObjectMap.get("Key");

    // Assert
    assertEquals(1, objectObjectMap.size());
    assertEquals("Value", actualGetResult);
    assertEquals("Value", objectObjectMap.get("Key"));
  }

  /**
   * Test {@link LoadingMap#put(Object, Object)}.
   *
   * <p>Method under test: {@link LoadingMap#put(Object, Object)}
   */
  @Test
  @DisplayName("Test put(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LoadingMap.put(Object, Object)"})
  void testPut() {
    // Arrange
    LoadingMap<Object, Object> objectObjectMap =
        new LoadingMap<>(new HashMap<>(), mock(Function.class));

    // Act
    Object actualPutResult = objectObjectMap.put("Key", "Value");

    // Assert
    assertEquals(1, objectObjectMap.size());
    assertEquals("Value", objectObjectMap.get("Key"));
    assertNull(actualPutResult);
  }

  /**
   * Test {@link LoadingMap#remove(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link LoadingMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LoadingMap.remove(Object)"})
  void testRemoveWithObject() {
    // Arrange
    LoadingMap<Object, Object> objectObjectMap =
        new LoadingMap<>(new HashMap<>(), mock(Function.class));

    // Act and Assert
    assertNull(objectObjectMap.remove("Key"));
  }
}
