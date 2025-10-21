package ca.spottedleaf.moonrise.common.list;

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
import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class SortedListDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SortedList#SortedList(Object[], Comparator)}
   *   <li>{@link SortedList#size()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SortedList.<init>(Object[], Comparator)", "int SortedList.size()"})
  void testGettersAndSetters() {
    // Arrange
    Object[] elements = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};

    // Act
    SortedList<Object> actualSortedList = new SortedList<>(elements, mock(Comparator.class));

    // Assert
    assertEquals(0, actualSortedList.size());
  }

  /**
   * Test {@link SortedList#SortedList(Comparator)}.
   *
   * <p>Method under test: {@link SortedList#SortedList(Comparator)}
   */
  @Test
  @DisplayName("Test new SortedList(Comparator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SortedList.<init>(Comparator)"})
  void testNewSortedList() {
    // Arrange and Act
    SortedList<Object> actualSortedList = new SortedList<>(mock(Comparator.class));

    // Assert
    assertEquals(0, actualSortedList.size());
    assertTrue(actualSortedList.isEmpty());
  }

  /**
   * Test {@link SortedList#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link SortedList#SortedList(Comparator)} with {@link Comparator} add {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SortedList#isEmpty()}
   */
  @Test
  @DisplayName(
      "Test isEmpty(); given SortedList(Comparator) with Comparator add WILDCARD_OBJECT; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortedList.isEmpty()"})
  void testIsEmpty_givenSortedListWithComparatorAddWildcard_object_thenReturnFalse() {
    // Arrange
    SortedList<Object> sortedList = new SortedList<>(mock(Comparator.class));
    sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertFalse(sortedList.isEmpty());
  }

  /**
   * Test {@link SortedList#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link SortedList#SortedList(Comparator)} with {@link Comparator}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SortedList#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given SortedList(Comparator) with Comparator; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortedList.isEmpty()"})
  void testIsEmpty_givenSortedListWithComparator_thenReturnTrue() {
    // Arrange
    SortedList<Object> sortedList = new SortedList<>(mock(Comparator.class));

    // Act and Assert
    assertTrue(sortedList.isEmpty());
  }

  /**
   * Test {@link SortedList#add(Object)}.
   *
   * <p>Method under test: {@link SortedList#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SortedList.add(Object)"})
  void testAdd() {
    // Arrange
    Object[] elements = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};
    SortedList<Object> sortedList = new SortedList<>(elements, mock(Comparator.class));

    // Act and Assert
    assertEquals(0, sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT));
    assertEquals(1, sortedList.size());
    assertFalse(sortedList.isEmpty());
  }

  /**
   * Test {@link SortedList#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return minus one.
   * </ul>
   *
   * <p>Method under test: {@link SortedList#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); given Comparator compare(Object, Object) return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SortedList.add(Object)"})
  void testAdd_givenComparatorCompareReturnMinusOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(-1);

    SortedList<Object> sortedList = new SortedList<>(comparator);
    sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    int actualAddResult = sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(0, actualAddResult);
    assertEquals(2, sortedList.size());
    assertFalse(sortedList.isEmpty());
  }

  /**
   * Test {@link SortedList#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SortedList#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given Comparator compare(Object, Object) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SortedList.add(Object)"})
  void testAdd_givenComparatorCompareReturnOne_thenReturnOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    SortedList<Object> sortedList = new SortedList<>(comparator);
    sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    int actualAddResult = sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, actualAddResult);
    assertEquals(2, sortedList.size());
    assertFalse(sortedList.isEmpty());
  }

  /**
   * Test {@link SortedList#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link SortedList#SortedList(Comparator)} with {@link Comparator}.
   *   <li>Then {@link SortedList#SortedList(Comparator)} with {@link Comparator} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SortedList#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given SortedList(Comparator) with Comparator; then SortedList(Comparator) with Comparator size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SortedList.add(Object)"})
  void testAdd_givenSortedListWithComparator_thenSortedListWithComparatorSizeIsOne() {
    // Arrange
    SortedList<Object> sortedList = new SortedList<>(mock(Comparator.class));

    // Act and Assert
    assertEquals(0, sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT));
    assertEquals(1, sortedList.size());
    assertFalse(sortedList.isEmpty());
  }

  /**
   * Test {@link SortedList#get(int)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   *   <li>When one.
   *   <li>Then calls {@link Comparator#compare(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SortedList#get(int)}
   */
  @Test
  @DisplayName(
      "Test get(int); given Comparator compare(Object, Object) return one; when one; then calls compare(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SortedList.get(int)"})
  void testGet_givenComparatorCompareReturnOne_whenOne_thenCallsCompare() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    SortedList<Object> sortedList = new SortedList<>(comparator);
    sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT);
    sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    sortedList.get(1);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
  }

  /**
   * Test {@link SortedList#remove(Object)}.
   *
   * <p>Method under test: {@link SortedList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SortedList.remove(Object)"})
  void testRemove() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);
    Object[] elements = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};

    SortedList<Object> sortedList = new SortedList<>(elements, comparator);
    sortedList.add(ConfigurationTransformation.WILDCARD_OBJECT);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualRemoveResult = sortedList.remove(object);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(0, sortedList.size());
    assertTrue(sortedList.isEmpty());
    assertSame(object, actualRemoveResult);
  }

  /**
   * Test {@link SortedList#remove(Object)}.
   *
   * <ul>
   *   <li>Given {@link SortedList#SortedList(Comparator)} with {@link Comparator}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SortedList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); given SortedList(Comparator) with Comparator; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SortedList.remove(Object)"})
  void testRemove_givenSortedListWithComparator_thenReturnNull() {
    // Arrange
    SortedList<Object> sortedList = new SortedList<>(mock(Comparator.class));

    // Act and Assert
    assertNull(sortedList.remove(ConfigurationTransformation.WILDCARD_OBJECT));
    assertEquals(0, sortedList.size());
    assertTrue(sortedList.isEmpty());
  }
}
