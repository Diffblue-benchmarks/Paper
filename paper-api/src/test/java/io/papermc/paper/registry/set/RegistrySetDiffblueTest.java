package io.papermc.paper.registry.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistrySetDiffblueTest {
  /**
   * Test {@link RegistrySet#valueSet(RegistryKey, Iterable)}.
   *
   * <p>Method under test: {@link RegistrySet#valueSet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName("Test valueSet(RegistryKey, Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistrySet.valueSet(RegistryKey, Iterable)"})
  void testValueSet() {
    // Arrange
    RegistryValueSetImpl<?> values = new RegistryValueSetImpl<>(null, new ArrayList<>());

    // Act
    RegistryValueSet<Object> actualValueSetResult = RegistrySet.valueSet(null, values);

    // Assert
    assertTrue(actualValueSetResult instanceof RegistryValueSetImpl);
    assertEquals(values, actualValueSetResult);
  }

  /**
   * Test {@link RegistrySet#valueSet(RegistryKey, Iterable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return values size is one.
   * </ul>
   *
   * <p>Method under test: {@link RegistrySet#valueSet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test valueSet(RegistryKey, Iterable); given ArrayList() add '42'; then return values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistrySet.valueSet(RegistryKey, Iterable)"})
  void testValueSet_givenArrayListAdd42_thenReturnValuesSizeIsOne() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    Iterable<Object> values = mock(Iterable.class);
    when(values.iterator()).thenReturn(objectList.iterator());

    // Act
    RegistryValueSet<Object> actualValueSetResult = RegistrySet.valueSet(null, values);

    // Assert
    verify(values).iterator();
    assertTrue(actualValueSetResult instanceof RegistryValueSetImpl);
    Collection<Object> valuesResult = actualValueSetResult.values();
    assertEquals(1, valuesResult.size());
    assertEquals("42", ((List<Object>) valuesResult).get(0));
    assertEquals(1, actualValueSetResult.size());
    assertFalse(actualValueSetResult.isEmpty());
  }

  /**
   * Test {@link RegistrySet#valueSet(RegistryKey, Iterable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link Iterable#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link RegistrySet#valueSet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test valueSet(RegistryKey, Iterable); given ArrayList() iterator; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistrySet.valueSet(RegistryKey, Iterable)"})
  void testValueSet_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    Iterable<Object> values = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(values.iterator()).thenReturn(objectList.iterator());

    // Act
    RegistryValueSet<Object> actualValueSetResult = RegistrySet.valueSet(null, values);

    // Assert
    verify(values).iterator();
    assertTrue(actualValueSetResult instanceof RegistryValueSetImpl);
    assertNull(actualValueSetResult.registryKey());
    assertEquals(0, actualValueSetResult.size());
    assertTrue(actualValueSetResult.isEmpty());
    assertTrue(actualValueSetResult.values().isEmpty());
  }

  /**
   * Test {@link RegistrySet#valueSet(RegistryKey, Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return registryKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegistrySet#valueSet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test valueSet(RegistryKey, Iterable); when ArrayList(); then return registryKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistrySet.valueSet(RegistryKey, Iterable)"})
  void testValueSet_whenArrayList_thenReturnRegistryKeyIsNull() {
    // Arrange and Act
    RegistryValueSet<Object> actualValueSetResult = RegistrySet.valueSet(null, new ArrayList<>());

    // Assert
    assertTrue(actualValueSetResult instanceof RegistryValueSetImpl);
    assertNull(actualValueSetResult.registryKey());
    assertEquals(0, actualValueSetResult.size());
    assertTrue(actualValueSetResult.isEmpty());
    assertTrue(actualValueSetResult.values().isEmpty());
  }

  /**
   * Test {@link RegistrySet#valueSet(RegistryKey, Iterable)}.
   *
   * <ul>
   *   <li>When {@link RegistryKeySetImpl#RegistryKeySetImpl(RegistryKey, List)} with registryKey is
   *       {@code null} and values is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RegistrySet#valueSet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test valueSet(RegistryKey, Iterable); when RegistryKeySetImpl(RegistryKey, List) with registryKey is 'null' and values is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistrySet.valueSet(RegistryKey, Iterable)"})
  void testValueSet_whenRegistryKeySetImplWithRegistryKeyIsNullAndValuesIsArrayList() {
    // Arrange
    RegistryKeySetImpl<Keyed> values = new RegistryKeySetImpl<>(null, new ArrayList<>());

    // Act
    RegistryValueSet<Object> actualValueSetResult = RegistrySet.valueSet(null, values);

    // Assert
    assertTrue(actualValueSetResult instanceof RegistryValueSetImpl);
    assertNull(actualValueSetResult.registryKey());
    assertEquals(0, actualValueSetResult.size());
    assertTrue(actualValueSetResult.isEmpty());
    assertTrue(actualValueSetResult.values().isEmpty());
  }

  /**
   * Test {@link RegistrySet#keySet(RegistryKey, Iterable)} with {@code RegistryKey}, {@code
   * Iterable}.
   *
   * <p>Method under test: {@link RegistrySet#keySet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName("Test keySet(RegistryKey, Iterable) with 'RegistryKey', 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet RegistrySet.keySet(RegistryKey, Iterable)"})
  void testKeySetWithRegistryKeyIterable() {
    // Arrange
    RegistryKeySetImpl<Keyed> keys = new RegistryKeySetImpl<>(null, new ArrayList<>());

    // Act
    RegistryKeySet<Keyed> actualKeySetResult = RegistrySet.keySet(null, keys);

    // Assert
    assertTrue(actualKeySetResult instanceof RegistryKeySetImpl);
    assertEquals(keys, actualKeySetResult);
  }

  /**
   * Test {@link RegistrySet#keySet(RegistryKey, Iterable)} with {@code RegistryKey}, {@code
   * Iterable}.
   *
   * <p>Method under test: {@link RegistrySet#keySet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName("Test keySet(RegistryKey, Iterable) with 'RegistryKey', 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet RegistrySet.keySet(RegistryKey, Iterable)"})
  void testKeySetWithRegistryKeyIterable2() {
    // Arrange
    RegistryValueSetImpl<TypedKey<Keyed>> keys =
        new RegistryValueSetImpl<>(null, new ArrayList<>());

    // Act
    RegistryKeySet<Keyed> actualKeySetResult = RegistrySet.keySet(null, keys);

    // Assert
    assertTrue(actualKeySetResult instanceof RegistryKeySetImpl);
    assertNull(actualKeySetResult.registryKey());
    assertEquals(0, actualKeySetResult.size());
    assertTrue(actualKeySetResult.isEmpty());
    assertTrue(actualKeySetResult.values().isEmpty());
  }

  /**
   * Test {@link RegistrySet#keySet(RegistryKey, Iterable)} with {@code RegistryKey}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link Iterable#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link RegistrySet#keySet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test keySet(RegistryKey, Iterable) with 'RegistryKey', 'Iterable'; given ArrayList() iterator; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet RegistrySet.keySet(RegistryKey, Iterable)"})
  void testKeySetWithRegistryKeyIterable_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    Iterable<TypedKey<Keyed>> keys = mock(Iterable.class);

    ArrayList<TypedKey<Keyed>> typedKeyList = new ArrayList<>();
    when(keys.iterator()).thenReturn(typedKeyList.iterator());

    // Act
    RegistryKeySet<Keyed> actualKeySetResult = RegistrySet.keySet(null, keys);

    // Assert
    verify(keys).iterator();
    assertTrue(actualKeySetResult instanceof RegistryKeySetImpl);
    assertNull(actualKeySetResult.registryKey());
    assertEquals(0, actualKeySetResult.size());
    assertTrue(actualKeySetResult.isEmpty());
    assertTrue(actualKeySetResult.values().isEmpty());
  }

  /**
   * Test {@link RegistrySet#keySet(RegistryKey, Iterable)} with {@code RegistryKey}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return registryKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegistrySet#keySet(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test keySet(RegistryKey, Iterable) with 'RegistryKey', 'Iterable'; when ArrayList(); then return registryKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet RegistrySet.keySet(RegistryKey, Iterable)"})
  void testKeySetWithRegistryKeyIterable_whenArrayList_thenReturnRegistryKeyIsNull() {
    // Arrange and Act
    RegistryKeySet<Keyed> actualKeySetResult = RegistrySet.keySet(null, new ArrayList<>());

    // Assert
    assertTrue(actualKeySetResult instanceof RegistryKeySetImpl);
    assertNull(actualKeySetResult.registryKey());
    assertEquals(0, actualKeySetResult.size());
    assertTrue(actualKeySetResult.isEmpty());
    assertTrue(actualKeySetResult.values().isEmpty());
  }

  /**
   * Test {@link RegistrySet#keySet(RegistryKey, TypedKey[])} with {@code RegistryKey}, {@code
   * TypedKey[]}.
   *
   * <ul>
   *   <li>Then return {@link RegistryKeySetImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RegistrySet#keySet(RegistryKey, TypedKey[])}
   */
  @Test
  @DisplayName(
      "Test keySet(RegistryKey, TypedKey[]) with 'RegistryKey', 'TypedKey[]'; then return RegistryKeySetImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet RegistrySet.keySet(RegistryKey, TypedKey[])"})
  void testKeySetWithRegistryKeyTypedKey_thenReturnRegistryKeySetImpl() {
    // Arrange and Act
    RegistryKeySet<Keyed> actualKeySetResult = RegistrySet.keySet(null);

    // Assert
    assertTrue(actualKeySetResult instanceof RegistryKeySetImpl);
    assertNull(actualKeySetResult.registryKey());
    assertEquals(0, actualKeySetResult.size());
    assertTrue(actualKeySetResult.isEmpty());
    assertTrue(actualKeySetResult.values().isEmpty());
  }

  /**
   * Test {@link RegistrySet#isEmpty()}.
   *
   * <p>Method under test: {@link RegistrySet#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistrySet.isEmpty()"})
  void testIsEmpty() {
    // Arrange
    RegistryKeySetImpl<Keyed> registryKeySetImpl =
        new RegistryKeySetImpl<>(null, new ArrayList<>());

    // Act and Assert
    assertTrue(registryKeySetImpl.isEmpty());
  }
}
