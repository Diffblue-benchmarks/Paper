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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryValueSetImplDiffblueTest {
  /**
   * Test {@link RegistryValueSetImpl#create(RegistryKey, Iterable)}.
   *
   * <p>Method under test: {@link RegistryValueSetImpl#create(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName("Test create(RegistryKey, Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistryValueSetImpl.create(RegistryKey, Iterable)"})
  void testCreate() {
    // Arrange
    RegistryValueSetImpl<?> values = new RegistryValueSetImpl<>(null, new ArrayList<>());

    // Act
    RegistryValueSet<Object> actualCreateResult = RegistryValueSetImpl.create(null, values);

    // Assert
    assertTrue(actualCreateResult instanceof RegistryValueSetImpl);
    assertEquals(values, actualCreateResult);
  }

  /**
   * Test {@link RegistryValueSetImpl#create(RegistryKey, Iterable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return values size is one.
   * </ul>
   *
   * <p>Method under test: {@link RegistryValueSetImpl#create(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test create(RegistryKey, Iterable); given ArrayList() add '42'; then return values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistryValueSetImpl.create(RegistryKey, Iterable)"})
  void testCreate_givenArrayListAdd42_thenReturnValuesSizeIsOne() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    Iterable<Object> values = mock(Iterable.class);
    when(values.iterator()).thenReturn(objectList.iterator());

    // Act
    RegistryValueSet<Object> actualCreateResult = RegistryValueSetImpl.create(null, values);

    // Assert
    verify(values).iterator();
    assertTrue(actualCreateResult instanceof RegistryValueSetImpl);
    Collection<Object> valuesResult = actualCreateResult.values();
    assertEquals(1, valuesResult.size());
    assertEquals("42", ((List<Object>) valuesResult).get(0));
    assertEquals(1, actualCreateResult.size());
    assertFalse(actualCreateResult.isEmpty());
  }

  /**
   * Test {@link RegistryValueSetImpl#create(RegistryKey, Iterable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then return registryKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryValueSetImpl#create(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test create(RegistryKey, Iterable); given ArrayList() iterator; then return registryKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistryValueSetImpl.create(RegistryKey, Iterable)"})
  void testCreate_givenArrayListIterator_thenReturnRegistryKeyIsNull() {
    // Arrange
    Iterable<Object> values = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(values.iterator()).thenReturn(objectList.iterator());

    // Act
    RegistryValueSet<Object> actualCreateResult = RegistryValueSetImpl.create(null, values);

    // Assert
    verify(values).iterator();
    assertTrue(actualCreateResult instanceof RegistryValueSetImpl);
    assertNull(actualCreateResult.registryKey());
    assertEquals(0, actualCreateResult.size());
    assertTrue(actualCreateResult.isEmpty());
    assertTrue(actualCreateResult.values().isEmpty());
  }

  /**
   * Test {@link RegistryValueSetImpl#create(RegistryKey, Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return registryKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryValueSetImpl#create(RegistryKey, Iterable)}
   */
  @Test
  @DisplayName(
      "Test create(RegistryKey, Iterable); when ArrayList(); then return registryKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSet RegistryValueSetImpl.create(RegistryKey, Iterable)"})
  void testCreate_whenArrayList_thenReturnRegistryKeyIsNull() {
    // Arrange and Act
    RegistryValueSet<Object> actualCreateResult =
        RegistryValueSetImpl.create(null, new ArrayList<>());

    // Assert
    assertTrue(actualCreateResult instanceof RegistryValueSetImpl);
    assertNull(actualCreateResult.registryKey());
    assertEquals(0, actualCreateResult.size());
    assertTrue(actualCreateResult.isEmpty());
    assertTrue(actualCreateResult.values().isEmpty());
  }

  /**
   * Test {@link RegistryValueSetImpl#values()}.
   *
   * <p>Method under test: {@link RegistryValueSetImpl#values()}
   */
  @Test
  @DisplayName("Test values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RegistryValueSetImpl.values()"})
  void testValues() {
    // Arrange
    RegistryValueSetImpl<Object> registryValueSetImpl =
        new RegistryValueSetImpl<>(null, new ArrayList<>());

    // Act and Assert
    assertTrue(registryValueSetImpl.values().isEmpty());
  }
}
