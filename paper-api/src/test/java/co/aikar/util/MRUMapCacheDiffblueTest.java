package co.aikar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MRUMapCacheDiffblueTest {
  /**
   * Test {@link MRUMapCache#MRUMapCache(Map)}.
   *
   * <p>Method under test: {@link MRUMapCache#MRUMapCache(Map)}
   */
  @Test
  @DisplayName("Test new MRUMapCache(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MRUMapCache.<init>(Map)"})
  void testNewMRUMapCache() {
    // Arrange and Act
    MRUMapCache<Object, Object> actualObjectObjectMap = new MRUMapCache<>(new HashMap<>());

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }

  /**
   * Test {@link MRUMapCache#containsKey(Object)}.
   *
   * <ul>
   *   <li>Given {@link MRUMapCache#MRUMapCache(Map)} with backingMap is {@link HashMap#HashMap()}
   *       IfAbsent {@code 42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#containsKey(Object)}
   */
  @Test
  @DisplayName(
      "Test containsKey(Object); given MRUMapCache(Map) with backingMap is HashMap() IfAbsent '42' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MRUMapCache.containsKey(Object)"})
  void testContainsKey_givenMRUMapCacheWithBackingMapIsHashMapIfAbsent42Is42() {
    // Arrange
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(new HashMap<>());
    objectObjectMap.put("Key", "Value");
    objectObjectMap.putIfAbsent("42", "42");

    // Act and Assert
    assertTrue(objectObjectMap.containsKey("Key"));
  }

  /**
   * Test {@link MRUMapCache#containsKey(Object)}.
   *
   * <ul>
   *   <li>Given {@link MRUMapCache#MRUMapCache(Map)} with backingMap is {@link HashMap#HashMap()}
   *       {@code Key} is {@code Value}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#containsKey(Object)}
   */
  @Test
  @DisplayName(
      "Test containsKey(Object); given MRUMapCache(Map) with backingMap is HashMap() 'Key' is 'Value'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MRUMapCache.containsKey(Object)"})
  void testContainsKey_givenMRUMapCacheWithBackingMapIsHashMapKeyIsValue_thenReturnTrue() {
    // Arrange
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(new HashMap<>());
    objectObjectMap.put("Key", "Value");

    // Act and Assert
    assertTrue(objectObjectMap.containsKey("Key"));
  }

  /**
   * Test {@link MRUMapCache#containsKey(Object)}.
   *
   * <ul>
   *   <li>Given {@link MRUMapCache#MRUMapCache(Map)} with backingMap is {@link HashMap#HashMap()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#containsKey(Object)}
   */
  @Test
  @DisplayName(
      "Test containsKey(Object); given MRUMapCache(Map) with backingMap is HashMap(); when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MRUMapCache.containsKey(Object)"})
  void testContainsKey_givenMRUMapCacheWithBackingMapIsHashMap_whenKey_thenReturnFalse() {
    // Arrange
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(new HashMap<>());

    // Act and Assert
    assertFalse(objectObjectMap.containsKey("Key"));
  }

  /**
   * Test {@link MRUMapCache#containsKey(Object)}.
   *
   * <ul>
   *   <li>Given {@link MRUMapCache#MRUMapCache(Map)} with backingMap is {@link HashMap#HashMap()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#containsKey(Object)}
   */
  @Test
  @DisplayName(
      "Test containsKey(Object); given MRUMapCache(Map) with backingMap is HashMap(); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MRUMapCache.containsKey(Object)"})
  void testContainsKey_givenMRUMapCacheWithBackingMapIsHashMap_whenNull_thenReturnFalse() {
    // Arrange
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(new HashMap<>());

    // Act and Assert
    assertFalse(objectObjectMap.containsKey(null));
  }

  /**
   * Test {@link MRUMapCache#containsValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link MRUMapCache#MRUMapCache(Map)} with backingMap is {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#containsValue(Object)}
   */
  @Test
  @DisplayName(
      "Test containsValue(Object); given MRUMapCache(Map) with backingMap is HashMap(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MRUMapCache.containsValue(Object)"})
  void testContainsValue_givenMRUMapCacheWithBackingMapIsHashMap_thenReturnFalse() {
    // Arrange
    HashMap<Object, Object> backingMap = new HashMap<>();
    backingMap.put("Backing Map", "Backing Map");
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(backingMap);

    // Act and Assert
    assertFalse(objectObjectMap.containsValue("Value"));
  }

  /**
   * Test {@link MRUMapCache#containsValue(Object)}.
   *
   * <ul>
   *   <li>Then {@link MRUMapCache#MRUMapCache(Map)} with backingMap is {@link HashMap#HashMap()}
   *       size is two.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#containsValue(Object)}
   */
  @Test
  @DisplayName(
      "Test containsValue(Object); then MRUMapCache(Map) with backingMap is HashMap() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MRUMapCache.containsValue(Object)"})
  void testContainsValue_thenMRUMapCacheWithBackingMapIsHashMapSizeIsTwo() {
    // Arrange
    HashMap<Object, Object> backingMap = new HashMap<>();
    backingMap.put("Backing Map", "Backing Map");

    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(backingMap);
    objectObjectMap.put("Key", "Value");
    objectObjectMap.put("Key", "Value");

    // Act
    boolean actualContainsValueResult = objectObjectMap.containsValue("Value");

    // Assert
    assertEquals(2, objectObjectMap.size());
    Object getResult = objectObjectMap.get("Key");
    assertEquals("Value", getResult);
    assertTrue(objectObjectMap.containsKey("Backing Map"));
    assertTrue(actualContainsValueResult);
    assertSame(objectObjectMap.cacheValue, getResult);
  }

  /**
   * Test {@link MRUMapCache#containsValue(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MRUMapCache.containsValue(Object)"})
  void testContainsValue_thenReturnTrue() {
    // Arrange
    HashMap<Object, Object> backingMap = new HashMap<>();
    backingMap.put("Backing Map", "Backing Map");

    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(backingMap);
    objectObjectMap.put("Key", "Value");

    // Act and Assert
    assertTrue(objectObjectMap.containsValue("Value"));
  }

  /**
   * Test {@link MRUMapCache#containsValue(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MRUMapCache.containsValue(Object)"})
  void testContainsValue_whenNull_thenReturnFalse() {
    // Arrange
    HashMap<Object, Object> backingMap = new HashMap<>();
    backingMap.put("Backing Map", "Backing Map");
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(backingMap);

    // Act and Assert
    assertFalse(objectObjectMap.containsValue(null));
  }

  /**
   * Test {@link MRUMapCache#put(Object, Object)}.
   *
   * <p>Method under test: {@link MRUMapCache#put(Object, Object)}
   */
  @Test
  @DisplayName("Test put(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MRUMapCache.put(Object, Object)"})
  void testPut() {
    // Arrange
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(new HashMap<>());

    // Act
    Object actualPutResult = objectObjectMap.put("Key", "Value");

    // Assert
    assertEquals(1, objectObjectMap.size());
    assertNull(objectObjectMap.get("Key"));
    assertNull(actualPutResult);
  }

  /**
   * Test {@link MRUMapCache#remove(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>Given {@link MRUMapCache#MRUMapCache(Map)} with backingMap is {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'Object'; given MRUMapCache(Map) with backingMap is HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MRUMapCache.remove(Object)"})
  void testRemoveWithObject_givenMRUMapCacheWithBackingMapIsHashMap_thenReturnNull() {
    // Arrange
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(new HashMap<>());

    // Act and Assert
    assertNull(objectObjectMap.remove("Key"));
    assertTrue(objectObjectMap.isEmpty());
  }

  /**
   * Test {@link MRUMapCache#remove(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'Object'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MRUMapCache.remove(Object)"})
  void testRemoveWithObject_thenReturnValue() {
    // Arrange
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(new HashMap<>());
    objectObjectMap.put("Key", "Value");

    // Act and Assert
    assertEquals("Value", objectObjectMap.remove("Key"));
    assertTrue(objectObjectMap.isEmpty());
  }

  /**
   * Test {@link MRUMapCache#remove(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MRUMapCache#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'Object'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MRUMapCache.remove(Object)"})
  void testRemoveWithObject_whenNull_thenReturnNull() {
    // Arrange
    MRUMapCache<Object, Object> objectObjectMap = new MRUMapCache<>(new HashMap<>());

    // Act and Assert
    assertNull(objectObjectMap.remove(null));
    assertTrue(objectObjectMap.isEmpty());
  }

  /**
   * Test {@link MRUMapCache#of(Map)}.
   *
   * <p>Method under test: {@link MRUMapCache#of(Map)}
   */
  @Test
  @DisplayName("Test of(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MRUMapCache.of(Map)"})
  void testOf() {
    // Arrange and Act
    Map<Object, Object> actualOfResult = MRUMapCache.of(new HashMap<>());

    // Assert
    assertTrue(actualOfResult.isEmpty());
  }
}
