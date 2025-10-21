package ca.spottedleaf.moonrise.common.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ReferenceListDiffblueTest {
  /**
   * Test {@link ReferenceList#ReferenceList()}.
   *
   * <p>Method under test: {@link ReferenceList#ReferenceList()}
   */
  @Test
  @DisplayName("Test new ReferenceList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReferenceList.<init>()"})
  void testNewReferenceList() {
    // Arrange and Act
    ReferenceList<Object> actualReferenceList = new ReferenceList<>();

    // Assert
    assertEquals(0, actualReferenceList.size());
    Object[] rawData = actualReferenceList.getRawData();
    assertEquals(0, rawData.length);
    assertFalse(actualReferenceList.iterator().hasNext());
    assertSame(rawData, actualReferenceList.getRawDataUnchecked());
  }

  /**
   * Test {@link ReferenceList#ReferenceList(Object[])}.
   *
   * <p>Method under test: {@link ReferenceList#ReferenceList(Object[])}
   */
  @Test
  @DisplayName("Test new ReferenceList(Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReferenceList.<init>(Object[])"})
  void testNewReferenceList2() {
    // Arrange
    Object[] referenceArray = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};

    // Act
    ReferenceList<Object> actualReferenceList = new ReferenceList<>(referenceArray);

    // Assert
    assertEquals(0, actualReferenceList.size());
    assertFalse(actualReferenceList.iterator().hasNext());
    assertSame(referenceArray, actualReferenceList.getRawData());
    assertSame(referenceArray, actualReferenceList.getRawDataUnchecked());
  }

  /**
   * Test {@link ReferenceList#copy()}.
   *
   * <p>Method under test: {@link ReferenceList#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceList ReferenceList.copy()"})
  void testCopy() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();

    // Act
    ReferenceList<Object> actualCopyResult = referenceList.copy();

    // Assert
    assertEquals(0, actualCopyResult.size());
    Object[] rawData = actualCopyResult.getRawData();
    assertEquals(0, rawData.length);
    assertFalse(actualCopyResult.iterator().hasNext());
    assertSame(rawData, actualCopyResult.getRawDataUnchecked());
  }

  /**
   * Test {@link ReferenceList#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add five.
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given ReferenceList() add five; when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.contains(Object)"})
  void testContains_givenReferenceListAddFive_whenObj_thenReturnFalse() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add(ConfigurationTransformation.WILDCARD_OBJECT);
    referenceList.add(5);

    // Act and Assert
    assertFalse(referenceList.contains("Obj"));
  }

  /**
   * Test {@link ReferenceList#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add {@code Obj}.
   *   <li>When {@code Obj}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given ReferenceList() add 'Obj'; when 'Obj'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.contains(Object)"})
  void testContains_givenReferenceListAddObj_whenObj_thenReturnTrue() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add(ConfigurationTransformation.WILDCARD_OBJECT);
    referenceList.add("Obj");

    // Act and Assert
    assertTrue(referenceList.contains("Obj"));
  }

  /**
   * Test {@link ReferenceList#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add {@code Obj}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given ReferenceList() add 'Obj'; when WILDCARD_OBJECT; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.contains(Object)"})
  void testContains_givenReferenceListAddObj_whenWildcard_object_thenReturnFalse() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add("Obj");

    // Act and Assert
    assertFalse(referenceList.contains(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link ReferenceList#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given ReferenceList() add WILDCARD_OBJECT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.contains(Object)"})
  void testContains_givenReferenceListAddWildcard_object_thenReturnTrue() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertTrue(referenceList.contains(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link ReferenceList#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given ReferenceList(); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.contains(Object)"})
  void testContains_givenReferenceList_whenNull_thenReturnFalse() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();

    // Act and Assert
    assertFalse(referenceList.contains(null));
  }

  /**
   * Test {@link ReferenceList#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given ReferenceList(); when WILDCARD_OBJECT; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.contains(Object)"})
  void testContains_givenReferenceList_whenWildcard_object_thenReturnFalse() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();

    // Act and Assert
    assertFalse(referenceList.contains(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link ReferenceList#remove(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add {@code Obj}.
   *   <li>Then {@link ReferenceList#ReferenceList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); given ReferenceList() add 'Obj'; then ReferenceList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.remove(Object)"})
  void testRemove_givenReferenceListAddObj_thenReferenceListSizeIsOne() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add("Obj");

    // Act
    boolean actualRemoveResult = referenceList.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    Iterator<Object> iteratorResult = referenceList.iterator();
    assertEquals("Obj", iteratorResult.next());
    Object[] rawData = referenceList.getRawData();
    assertEquals("Obj", rawData[0]);
    assertEquals(1, referenceList.size());
    assertEquals(4, rawData.length);
    assertFalse(actualRemoveResult);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link ReferenceList#remove(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); given ReferenceList() add WILDCARD_OBJECT; then first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.remove(Object)"})
  void testRemove_givenReferenceListAddWildcard_object_thenFirstElementIsNull() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    boolean actualRemoveResult = referenceList.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    Object[] rawData = referenceList.getRawData();
    assertNull(rawData[0]);
    assertEquals(0, referenceList.size());
    assertEquals(4, rawData.length);
    assertFalse(referenceList.iterator().hasNext());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ReferenceList#remove(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); given ReferenceList() add WILDCARD_OBJECT; then second element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.remove(Object)"})
  void testRemove_givenReferenceListAddWildcard_object_thenSecondElementIsNull() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add(ConfigurationTransformation.WILDCARD_OBJECT);
    referenceList.add("Obj");

    // Act
    referenceList.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    Iterator<Object> iteratorResult = referenceList.iterator();
    assertEquals("Obj", iteratorResult.next());
    Object[] rawData = referenceList.getRawData();
    assertEquals("Obj", rawData[0]);
    assertNull(rawData[1]);
    assertEquals(1, referenceList.size());
    assertEquals(4, rawData.length);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link ReferenceList#remove(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then {@link ReferenceList#ReferenceList()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); given ReferenceList(); when WILDCARD_OBJECT; then ReferenceList() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.remove(Object)"})
  void testRemove_givenReferenceList_whenWildcard_object_thenReferenceListSizeIsZero() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();

    // Act
    boolean actualRemoveResult = referenceList.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(0, referenceList.size());
    assertFalse(actualRemoveResult);
    assertFalse(referenceList.iterator().hasNext());
  }

  /**
   * Test {@link ReferenceList#remove(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then {@link ReferenceList#ReferenceList()} iterator next is first element.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); when 'Obj'; then ReferenceList() iterator next is first element")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.remove(Object)"})
  void testRemove_whenObj_thenReferenceListIteratorNextIsFirstElement() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add(ConfigurationTransformation.WILDCARD_OBJECT);
    referenceList.add("Obj");

    // Act
    referenceList.remove("Obj");

    // Assert
    Object[] rawData = referenceList.getRawData();
    assertEquals(4, rawData.length);
    Object expectedNextResult = rawData[0];
    assertNull(rawData[1]);
    Iterator<Object> iteratorResult = referenceList.iterator();
    Object actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, referenceList.size());
  }

  /**
   * Test {@link ReferenceList#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given ReferenceList(); when WILDCARD_OBJECT; then second element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.add(Object)"})
  void testAdd_givenReferenceList_whenWildcard_object_thenSecondElementIsNull() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    referenceList.add(object);

    // Assert
    Object[] rawData = referenceList.getRawData();
    assertNull(rawData[1]);
    assertNull(rawData[2]);
    assertNull(rawData[3]);
    assertEquals(4, rawData.length);
    assertSame(object, rawData[0]);
  }

  /**
   * Test {@link ReferenceList#add(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceList.add(Object)"})
  void testAdd_thenReturnTrue() {
    // Arrange
    Object[] referenceArray = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};
    ReferenceList<Object> referenceList = new ReferenceList<>(referenceArray);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act and Assert
    assertTrue(referenceList.add(object));
    Iterator<Object> iteratorResult = referenceList.iterator();
    Object actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(object, actualNextResult);
    assertEquals(1, referenceList.size());
  }

  /**
   * Test {@link ReferenceList#getUnchecked(int)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#getUnchecked(int)}
   */
  @Test
  @DisplayName(
      "Test getUnchecked(int); given ReferenceList() add WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ReferenceList.getUnchecked(int)"})
  void testGetUnchecked_givenReferenceListAddWildcard_object_thenReturnNull() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act and Assert
    assertNull(referenceList.getUnchecked(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReferenceList#getRawData()}
   *   <li>{@link ReferenceList#getRawDataUnchecked()}
   *   <li>{@link ReferenceList#size()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object[] ReferenceList.getRawData()",
    "Object[] ReferenceList.getRawDataUnchecked()",
    "int ReferenceList.size()"
  })
  void testGettersAndSetters() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();

    // Act
    Object[] actualRawData = referenceList.getRawData();
    Object[] actualRawDataUnchecked = referenceList.getRawDataUnchecked();

    // Assert
    assertEquals(0, referenceList.size());
    assertEquals(0, actualRawData.length);
    assertSame(actualRawData, actualRawDataUnchecked);
  }

  /**
   * Test {@link ReferenceList#clear()}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#clear()}
   */
  @Test
  @DisplayName("Test clear(); given ReferenceList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReferenceList.clear()"})
  void testClear_givenReferenceList() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();

    // Act
    referenceList.clear();

    // Assert that nothing has changed
    assertEquals(0, referenceList.size());
    assertFalse(referenceList.iterator().hasNext());
  }

  /**
   * Test {@link ReferenceList#clear()}.
   *
   * <ul>
   *   <li>Given {@link ReferenceList#ReferenceList()} add {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceList#clear()}
   */
  @Test
  @DisplayName(
      "Test clear(); given ReferenceList() add WILDCARD_OBJECT; then first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReferenceList.clear()"})
  void testClear_givenReferenceListAddWildcard_object_thenFirstElementIsNull() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();
    referenceList.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    referenceList.clear();

    // Assert
    Object[] rawData = referenceList.getRawData();
    assertNull(rawData[0]);
    assertEquals(0, referenceList.size());
    assertEquals(4, rawData.length);
    assertFalse(referenceList.iterator().hasNext());
  }

  /**
   * Test {@link ReferenceList#iterator()}.
   *
   * <p>Method under test: {@link ReferenceList#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator ReferenceList.iterator()"})
  void testIterator() {
    // Arrange
    ReferenceList<Object> referenceList = new ReferenceList<>();

    // Act and Assert
    assertFalse(referenceList.iterator().hasNext());
  }
}
