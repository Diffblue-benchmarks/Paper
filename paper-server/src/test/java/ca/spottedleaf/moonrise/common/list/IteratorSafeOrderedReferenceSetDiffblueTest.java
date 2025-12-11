package ca.spottedleaf.moonrise.common.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.common.list.IteratorSafeOrderedReferenceSet.Iterator;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import it.unimi.dsi.fastutil.objects.AbstractReference2IntMap;
import it.unimi.dsi.fastutil.objects.AbstractReference2IntMap.BasicEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class IteratorSafeOrderedReferenceSetDiffblueTest {
  /**
   * Test {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()}.
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()}
   */
  @Test
  @DisplayName("Test new IteratorSafeOrderedReferenceSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorSafeOrderedReferenceSet.<init>()"})
  void testNewIteratorSafeOrderedReferenceSet() {
    // Arrange and Act
    IteratorSafeOrderedReferenceSet<Object> actualIteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Assert
    assertEquals(0, actualIteratorSafeOrderedReferenceSet.getListSize());
    assertEquals(0, actualIteratorSafeOrderedReferenceSet.size());
    assertFalse(actualIteratorSafeOrderedReferenceSet.iterator().hasNext());
    assertEquals(Short.SIZE, actualIteratorSafeOrderedReferenceSet.getListRaw().length);
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet(Class)}.
   *
   * <ul>
   *   <li>Then return ListSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet(Class)}
   */
  @Test
  @DisplayName("Test new IteratorSafeOrderedReferenceSet(Class); then return ListSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorSafeOrderedReferenceSet.<init>(Class)"})
  void testNewIteratorSafeOrderedReferenceSet_thenReturnListSizeIsZero() {
    // Arrange
    Class<Object> arrComponent = Object.class;

    // Act
    IteratorSafeOrderedReferenceSet<Object> actualIteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>(arrComponent);

    // Assert
    assertEquals(0, actualIteratorSafeOrderedReferenceSet.getListSize());
    assertEquals(0, actualIteratorSafeOrderedReferenceSet.size());
    assertFalse(actualIteratorSafeOrderedReferenceSet.iterator().hasNext());
    assertEquals(Short.SIZE, actualIteratorSafeOrderedReferenceSet.getListRaw().length);
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet(int, float, int,
   * double)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet(int, float, int, double)}
   */
  @Test
  @DisplayName(
      "Test new IteratorSafeOrderedReferenceSet(int, float, int, double); when zero; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorSafeOrderedReferenceSet.<init>(int, float, int, double)"})
  void testNewIteratorSafeOrderedReferenceSet_whenZero_thenReturnFirstElementIsNull() {
    // Arrange and Act
    IteratorSafeOrderedReferenceSet<Object> actualIteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>(0, 1.0E-5f, 1, 10.0d);

    // Assert
    Object[] listRaw = actualIteratorSafeOrderedReferenceSet.getListRaw();
    assertNull(listRaw[0]);
    assertEquals(0, actualIteratorSafeOrderedReferenceSet.getListSize());
    assertEquals(0, actualIteratorSafeOrderedReferenceSet.size());
    assertEquals(1, listRaw.length);
    assertFalse(actualIteratorSafeOrderedReferenceSet.iterator().hasNext());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet(int, float, int,
   * double, Class)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet(int, float, int, double,
   * Class)}
   */
  @Test
  @DisplayName(
      "Test new IteratorSafeOrderedReferenceSet(int, float, int, double, Class); when zero; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorSafeOrderedReferenceSet.<init>(int, float, int, double, Class)"})
  void testNewIteratorSafeOrderedReferenceSet_whenZero_thenReturnFirstElementIsNull2() {
    // Arrange
    Class<Object> arrComponent = Object.class;

    // Act
    IteratorSafeOrderedReferenceSet<Object> actualIteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>(0, 1.0E-5f, 1, 10.0d, arrComponent);

    // Assert
    Object[] listRaw = actualIteratorSafeOrderedReferenceSet.getListRaw();
    assertNull(listRaw[0]);
    assertEquals(0, actualIteratorSafeOrderedReferenceSet.getListSize());
    assertEquals(0, actualIteratorSafeOrderedReferenceSet.size());
    assertEquals(1, listRaw.length);
    assertFalse(actualIteratorSafeOrderedReferenceSet.iterator().hasNext());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IteratorSafeOrderedReferenceSet#getListRaw()}
   *   <li>{@link IteratorSafeOrderedReferenceSet#getListSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object[] IteratorSafeOrderedReferenceSet.getListRaw()",
    "int IteratorSafeOrderedReferenceSet.getListSize()"
  })
  void testGettersAndSetters() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act
    Object[] actualListRaw = iteratorSafeOrderedReferenceSet.getListRaw();

    // Assert
    assertNull(actualListRaw[0]);
    assertNull(actualListRaw[1]);
    assertNull(actualListRaw[10]);
    assertNull(actualListRaw[11]);
    assertNull(actualListRaw[12]);
    assertNull(actualListRaw[13]);
    assertNull(actualListRaw[14]);
    assertNull(actualListRaw[15]);
    assertNull(actualListRaw[2]);
    assertNull(actualListRaw[3]);
    assertNull(actualListRaw[4]);
    assertNull(actualListRaw[5]);
    assertNull(actualListRaw[6]);
    assertNull(actualListRaw[7]);
    assertNull(actualListRaw[8]);
    assertNull(actualListRaw[9]);
    assertEquals(0, iteratorSafeOrderedReferenceSet.getListSize());
    assertEquals(Short.SIZE, actualListRaw.length);
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#createRawIterator()}.
   *
   * <ul>
   *   <li>Given {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()}.
   *   <li>Then return {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#createRawIterator()}
   */
  @Test
  @DisplayName(
      "Test createRawIterator(); given IteratorSafeOrderedReferenceSet(); then return MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IteratorSafeOrderedReferenceSet.createRawIterator()"})
  void testCreateRawIterator_givenIteratorSafeOrderedReferenceSet_thenReturnMax_value() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, iteratorSafeOrderedReferenceSet.createRawIterator());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#createRawIterator()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#createRawIterator()}
   */
  @Test
  @DisplayName("Test createRawIterator(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IteratorSafeOrderedReferenceSet.createRawIterator()"})
  void testCreateRawIterator_thenReturnZero() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertEquals(0, iteratorSafeOrderedReferenceSet.createRawIterator());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#advanceRawIterator(int)}.
   *
   * <ul>
   *   <li>Given {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()} add
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#advanceRawIterator(int)}
   */
  @Test
  @DisplayName("Test advanceRawIterator(int); given IteratorSafeOrderedReferenceSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IteratorSafeOrderedReferenceSet.advanceRawIterator(int)"})
  void testAdvanceRawIterator_givenIteratorSafeOrderedReferenceSetAddNull() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(null);

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, iteratorSafeOrderedReferenceSet.advanceRawIterator(-1));
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#advanceRawIterator(int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#advanceRawIterator(int)}
   */
  @Test
  @DisplayName("Test advanceRawIterator(int); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IteratorSafeOrderedReferenceSet.advanceRawIterator(int)"})
  void testAdvanceRawIterator_thenReturnZero() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertEquals(0, iteratorSafeOrderedReferenceSet.advanceRawIterator(-1));
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#advanceRawIterator(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#advanceRawIterator(int)}
   */
  @Test
  @DisplayName("Test advanceRawIterator(int); when one; then return MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IteratorSafeOrderedReferenceSet.advanceRawIterator(int)"})
  void testAdvanceRawIterator_whenOne_thenReturnMax_value() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, iteratorSafeOrderedReferenceSet.advanceRawIterator(1));
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#remove(Object)}.
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.remove(Object)"})
  void testRemove() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(ConfigurationTransformation.WILDCARD_OBJECT);
    iteratorSafeOrderedReferenceSet.add(ConfigurationTransformation.WILDCARD_OBJECT);
    BasicEntry<Object> basicEntry =
        new BasicEntry<>(ConfigurationTransformation.WILDCARD_OBJECT, (Integer) 42);
    iteratorSafeOrderedReferenceSet.add(basicEntry);

    // Act
    iteratorSafeOrderedReferenceSet.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    Object[] listRaw = iteratorSafeOrderedReferenceSet.getListRaw();
    assertEquals(Short.SIZE, listRaw.length);
    assertSame(basicEntry, listRaw[0]);
    Iterator<Object> iteratorResult = iteratorSafeOrderedReferenceSet.iterator();
    Object actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(basicEntry, actualNextResult);
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#remove(Object)}.
   *
   * <ul>
   *   <li>Given {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object); given IteratorSafeOrderedReferenceSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.remove(Object)"})
  void testRemove_givenIteratorSafeOrderedReferenceSet() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act
    boolean actualRemoveResult =
        iteratorSafeOrderedReferenceSet.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(0, iteratorSafeOrderedReferenceSet.getListSize());
    assertEquals(0, iteratorSafeOrderedReferenceSet.size());
    assertFalse(actualRemoveResult);
    assertFalse(iteratorSafeOrderedReferenceSet.iterator().hasNext());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#remove(Object)}.
   *
   * <ul>
   *   <li>Then {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()} iterator
   *       next intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); then IteratorSafeOrderedReferenceSet() iterator next intValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.remove(Object)"})
  void testRemove_thenIteratorSafeOrderedReferenceSetIteratorNextIntValueIsTwo() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(ConfigurationTransformation.WILDCARD_OBJECT);
    iteratorSafeOrderedReferenceSet.add(2);

    // Act
    iteratorSafeOrderedReferenceSet.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    Iterator<Object> iteratorResult = iteratorSafeOrderedReferenceSet.iterator();
    assertEquals(2, ((Integer) iteratorResult.next()).intValue());
    Object[] listRaw = iteratorSafeOrderedReferenceSet.getListRaw();
    assertEquals(2, ((Integer) listRaw[0]).intValue());
    assertFalse(iteratorResult.hasNext());
    assertEquals(Short.SIZE, listRaw.length);
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#remove(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object); when WILDCARD_OBJECT; then first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.remove(Object)"})
  void testRemove_whenWildcard_object_thenFirstElementIsNull() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    iteratorSafeOrderedReferenceSet.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    Object[] listRaw = iteratorSafeOrderedReferenceSet.getListRaw();
    assertNull(listRaw[0]);
    assertEquals(0, iteratorSafeOrderedReferenceSet.getListSize());
    assertEquals(0, iteratorSafeOrderedReferenceSet.size());
    assertFalse(iteratorSafeOrderedReferenceSet.iterator().hasNext());
    assertEquals(Short.SIZE, listRaw.length);
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()} add
   *       forty-two.
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given IteratorSafeOrderedReferenceSet() add forty-two; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.contains(Object)"})
  void testContains_givenIteratorSafeOrderedReferenceSetAddFortyTwo_whenOne() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(42);

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.contains(1));
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()} add
   *       {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given IteratorSafeOrderedReferenceSet() add WILDCARD_OBJECT; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.contains(Object)"})
  void testContains_givenIteratorSafeOrderedReferenceSetAddWildcard_object_whenOne() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(ConfigurationTransformation.WILDCARD_OBJECT);
    iteratorSafeOrderedReferenceSet.add(42);

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.contains(1));
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given IteratorSafeOrderedReferenceSet(); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.contains(Object)"})
  void testContains_givenIteratorSafeOrderedReferenceSet_whenNull_thenReturnFalse() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.contains(null));
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given IteratorSafeOrderedReferenceSet(); when WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.contains(Object)"})
  void testContains_givenIteratorSafeOrderedReferenceSet_whenWildcard_object() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertFalse(
        iteratorSafeOrderedReferenceSet.contains(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#contains(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.contains(Object)"})
  void testContains_thenReturnTrue() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    iteratorSafeOrderedReferenceSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertTrue(
        iteratorSafeOrderedReferenceSet.contains(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link IteratorSafeOrderedReferenceSet#IteratorSafeOrderedReferenceSet()}.
   *   <li>Then first element is {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given IteratorSafeOrderedReferenceSet(); then first element is WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IteratorSafeOrderedReferenceSet.add(Object)"})
  void testAdd_givenIteratorSafeOrderedReferenceSet_thenFirstElementIsWildcard_object() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    iteratorSafeOrderedReferenceSet.add(object);

    // Assert
    Object[] listRaw = iteratorSafeOrderedReferenceSet.getListRaw();
    assertEquals(Short.SIZE, listRaw.length);
    assertSame(object, listRaw[0]);
    assertEquals(1, iteratorSafeOrderedReferenceSet.getListSize());
    Iterator<Object> iteratorResult = iteratorSafeOrderedReferenceSet.iterator();
    Object actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(object, actualNextResult);
    assertEquals(1, iteratorSafeOrderedReferenceSet.size());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#size()}.
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IteratorSafeOrderedReferenceSet.size()"})
  void testSize() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertEquals(0, iteratorSafeOrderedReferenceSet.size());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#iterator()}.
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator IteratorSafeOrderedReferenceSet.iterator()"})
  void testIterator() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.iterator().hasNext());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#iterator(int)} with {@code int}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#iterator(int)}
   */
  @Test
  @DisplayName("Test iterator(int) with 'int'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator IteratorSafeOrderedReferenceSet.iterator(int)"})
  void testIteratorWithInt_whenOne() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.iterator(1).hasNext());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#iterator(int)} with {@code int}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#iterator(int)}
   */
  @Test
  @DisplayName("Test iterator(int) with 'int'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator IteratorSafeOrderedReferenceSet.iterator(int)"})
  void testIteratorWithInt_whenZero() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.iterator(0).hasNext());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#unsafeIterator()}.
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#unsafeIterator()}
   */
  @Test
  @DisplayName("Test unsafeIterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator IteratorSafeOrderedReferenceSet.unsafeIterator()"})
  void testUnsafeIterator() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.unsafeIterator().hasNext());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#unsafeIterator(int)} with {@code int}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#unsafeIterator(int)}
   */
  @Test
  @DisplayName("Test unsafeIterator(int) with 'int'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator IteratorSafeOrderedReferenceSet.unsafeIterator(int)"})
  void testUnsafeIteratorWithInt_whenOne() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.unsafeIterator(1).hasNext());
  }

  /**
   * Test {@link IteratorSafeOrderedReferenceSet#unsafeIterator(int)} with {@code int}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSafeOrderedReferenceSet#unsafeIterator(int)}
   */
  @Test
  @DisplayName("Test unsafeIterator(int) with 'int'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator IteratorSafeOrderedReferenceSet.unsafeIterator(int)"})
  void testUnsafeIteratorWithInt_whenZero() {
    // Arrange
    IteratorSafeOrderedReferenceSet<Object> iteratorSafeOrderedReferenceSet =
        new IteratorSafeOrderedReferenceSet<>();

    // Act and Assert
    assertFalse(iteratorSafeOrderedReferenceSet.unsafeIterator(0).hasNext());
  }
}
