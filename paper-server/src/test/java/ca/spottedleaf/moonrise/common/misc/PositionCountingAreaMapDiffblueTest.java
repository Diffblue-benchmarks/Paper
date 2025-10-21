package ca.spottedleaf.moonrise.common.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import it.unimi.dsi.fastutil.objects.ReferenceSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class PositionCountingAreaMapDiffblueTest {
  /**
   * Test {@link PositionCountingAreaMap#getObjects()}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceSet PositionCountingAreaMap.getObjects()"})
  void testGetObjects() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertTrue(positionCountingAreaMap.getObjects().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#getPositions()}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getPositions()}
   */
  @Test
  @DisplayName("Test getPositions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"it.unimi.dsi.fastutil.longs.LongSet PositionCountingAreaMap.getPositions()"})
  void testGetPositions() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#getTotalPositions()}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getTotalPositions()}
   */
  @Test
  @DisplayName("Test getTotalPositions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getTotalPositions()"})
  void testGetTotalPositions() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(long)} with {@code pos}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(long)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(long) with 'pos'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(long)"})
  void testHasObjectsNearWithPos() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act and Assert
    assertTrue(positionCountingAreaMap.hasObjectsNear(1L));
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(long)} with {@code pos}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(long)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(long) with 'pos'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(long)"})
  void testHasObjectsNearWithPos2() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 5, 2, 2);

    // Act and Assert
    assertFalse(positionCountingAreaMap.hasObjectsNear(1L));
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(long)} with {@code pos}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(long)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(long) with 'pos'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(long)"})
  void testHasObjectsNearWithPos3() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 0, 2, 2);

    // Act and Assert
    assertTrue(positionCountingAreaMap.hasObjectsNear(1L));
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(long)} with {@code pos}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(long)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(long) with 'pos'; when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(long)"})
  void testHasObjectsNearWithPos_whenOne_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertFalse(positionCountingAreaMap.hasObjectsNear(1L));
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(long)} with {@code pos}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(long)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(long) with 'pos'; when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(long)"})
  void testHasObjectsNearWithPos_whenZero_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertFalse(positionCountingAreaMap.hasObjectsNear(0L));
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(int, int)} with {@code toX}, {@code toZ}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(int, int) with 'toX', 'toZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(int, int)"})
  void testHasObjectsNearWithToXToZ() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act and Assert
    assertTrue(positionCountingAreaMap.hasObjectsNear(1, 1));
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(int, int)} with {@code toX}, {@code toZ}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(int, int) with 'toX', 'toZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(int, int)"})
  void testHasObjectsNearWithToXToZ2() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, Integer.SIZE, 2, 2);

    // Act and Assert
    assertFalse(positionCountingAreaMap.hasObjectsNear(1, 1));
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(int, int)} with {@code toX}, {@code toZ}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(int, int) with 'toX', 'toZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(int, int)"})
  void testHasObjectsNearWithToXToZ3() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 7);

    // Act and Assert
    assertTrue(positionCountingAreaMap.hasObjectsNear(1, 1));
  }

  /**
   * Test {@link PositionCountingAreaMap#hasObjectsNear(int, int)} with {@code toX}, {@code toZ}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#hasObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test hasObjectsNear(int, int) with 'toX', 'toZ'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.hasObjectsNear(int, int)"})
  void testHasObjectsNearWithToXToZ_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertFalse(positionCountingAreaMap.hasObjectsNear(1, 1));
  }

  /**
   * Test {@link PositionCountingAreaMap#getObjectsNear(int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test getObjectsNear(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getObjectsNear(int, int)"})
  void testGetObjectsNear() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, -1, 2, 2);

    // Act and Assert
    assertEquals(0, positionCountingAreaMap.getObjectsNear(3, 3));
  }

  /**
   * Test {@link PositionCountingAreaMap#getObjectsNear(int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test getObjectsNear(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getObjectsNear(int, int)"})
  void testGetObjectsNear2() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(
        ConfigurationTransformation.WILDCARD_OBJECT, Integer.SIZE, Integer.SIZE, 3);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act and Assert
    assertEquals(0, positionCountingAreaMap.getObjectsNear(3, 3));
  }

  /**
   * Test {@link PositionCountingAreaMap#getObjectsNear(int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test getObjectsNear(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getObjectsNear(int, int)"})
  void testGetObjectsNear3() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(
        ConfigurationTransformation.WILDCARD_OBJECT, Integer.SIZE, 1, Integer.SIZE);

    // Act and Assert
    assertEquals(1, positionCountingAreaMap.getObjectsNear(Integer.SIZE, 3));
  }

  /**
   * Test {@link PositionCountingAreaMap#getObjectsNear(int, int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test getObjectsNear(int, int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getObjectsNear(int, int)"})
  void testGetObjectsNear_thenReturnOne() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act and Assert
    assertEquals(1, positionCountingAreaMap.getObjectsNear(3, 3));
  }

  /**
   * Test {@link PositionCountingAreaMap#getObjectsNear(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test getObjectsNear(int, int); when minus one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getObjectsNear(int, int)"})
  void testGetObjectsNear_whenMinusOne_thenReturnZero() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertEquals(0, positionCountingAreaMap.getObjectsNear(-1, 3));
  }

  /**
   * Test {@link PositionCountingAreaMap#getObjectsNear(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test getObjectsNear(int, int); when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getObjectsNear(int, int)"})
  void testGetObjectsNear_whenOne_thenReturnZero() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertEquals(0, positionCountingAreaMap.getObjectsNear(1, 3));
  }

  /**
   * Test {@link PositionCountingAreaMap#getObjectsNear(int, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test getObjectsNear(int, int); when SIZE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getObjectsNear(int, int)"})
  void testGetObjectsNear_whenSize_thenReturnZero() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertEquals(0, positionCountingAreaMap.getObjectsNear(Integer.SIZE, 3));
  }

  /**
   * Test {@link PositionCountingAreaMap#getObjectsNear(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#getObjectsNear(int, int)}
   */
  @Test
  @DisplayName("Test getObjectsNear(int, int); when three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionCountingAreaMap.getObjectsNear(int, int)"})
  void testGetObjectsNear_whenThree_thenReturnZero() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertEquals(0, positionCountingAreaMap.getObjectsNear(3, 3));
  }

  /**
   * Test {@link PositionCountingAreaMap#add(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#add(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test add(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.add(Object, int, int, int)"})
  void testAdd() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualAddResult =
        positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#add(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#add(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test add(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.add(Object, int, int, int)"})
  void testAdd2() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 4, 4);

    // Act
    positionCountingAreaMap.add(null, 2, 2, 2);

    // Assert
    assertEquals(2, positionCountingAreaMap.getObjects().size());
    assertEquals(81, positionCountingAreaMap.getTotalPositions());
    assertEquals(81, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#add(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link PositionCountingAreaMap#add(Object, int, int, int)} with {@code Parameter}
   *       and toX is two and toZ is two and distance is two.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#add(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test add(Object, int, int, int); given add(Object, int, int, int) with 'Parameter' and toX is two and toZ is two and distance is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.add(Object, int, int, int)"})
  void testAdd_givenAddWithParameterAndToXIsTwoAndToZIsTwoAndDistanceIsTwo() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert
    assertEquals(2, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#add(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link PositionCountingAreaMap#add(Object, int, int, int)} with parameter is {@code
   *       null} and toX is four and toZ is four and distance is four.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#add(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test add(Object, int, int, int); given add(Object, int, int, int) with parameter is 'null' and toX is four and toZ is four and distance is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.add(Object, int, int, int)"})
  void testAdd_givenAddWithParameterIsNullAndToXIsFourAndToZIsFourAndDistanceIsFour() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(null, 4, 4, 4);

    // Act
    boolean actualAddResult = positionCountingAreaMap.add(null, 2, 2, 2);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(81, positionCountingAreaMap.getTotalPositions());
    assertEquals(81, positionCountingAreaMap.getPositions().size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#add(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#add(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test add(Object, int, int, int); then PositionCountingAreaMap (default constructor) TotalPositions is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.add(Object, int, int, int)"})
  void testAdd_thenPositionCountingAreaMapTotalPositionsIsTwentyFive() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#add(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#add(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test add(Object, int, int, int); when four; then PositionCountingAreaMap (default constructor) TotalPositions is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.add(Object, int, int, int)"})
  void testAdd_whenFour_thenPositionCountingAreaMapTotalPositionsIsTwentyFive() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 2, 2);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#add(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link SingleUserAreaMap#NOT_SET}.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is zero.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#add(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test add(Object, int, int, int); when NOT_SET; then PositionCountingAreaMap (default constructor) TotalPositions is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.add(Object, int, int, int)"})
  void testAdd_whenNot_set_thenPositionCountingAreaMapTotalPositionsIsZero() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    positionCountingAreaMap.add(
        ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 2, 2);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#add(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#add(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test add(Object, int, int, int); when 'null'; then PositionCountingAreaMap (default constructor) TotalPositions is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.add(Object, int, int, int)"})
  void testAdd_whenNull_thenPositionCountingAreaMapTotalPositionsIsTwentyFive() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    positionCountingAreaMap.add(null, 2, 2, 2);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert that nothing has changed
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate2() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert that nothing has changed
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate3() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 1, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert that nothing has changed
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate4() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 31, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert that nothing has changed
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate5() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 0, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert that nothing has changed
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate6() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, -1, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert that nothing has changed
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate7() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 0, 4);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(
        ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 2, 2);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate8() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, -1, 2, 2);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 0, 4);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(
        ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 2, 2);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link PositionCountingAreaMap#add(Object, int, int, int)} with {@code Parameter}
   *       and toX is two and toZ is two and distance is two.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(Object, int, int, int); given add(Object, int, int, int) with 'Parameter' and toX is two and toZ is two and distance is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate_givenAddWithParameterAndToXIsTwoAndToZIsTwoAndDistanceIsTwo() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert
    assertEquals(2, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(Object, int, int, int); then PositionCountingAreaMap (default constructor) TotalPositions is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate_thenPositionCountingAreaMapTotalPositionsIsTwentyFive() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is zero.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(Object, int, int, int); then PositionCountingAreaMap (default constructor) TotalPositions is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate_thenPositionCountingAreaMapTotalPositionsIsZero() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(
        ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 2, 2);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test addOrUpdate(Object, int, int, int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(
        ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 2, 2);

    // Act
    boolean actualAddOrUpdateResult =
        positionCountingAreaMap.addOrUpdate(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertFalse(actualAddOrUpdateResult);
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link SingleUserAreaMap#NOT_SET}.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is zero.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(Object, int, int, int); when NOT_SET; then PositionCountingAreaMap (default constructor) TotalPositions is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate_whenNot_set_thenPositionCountingAreaMapTotalPositionsIsZero() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    positionCountingAreaMap.addOrUpdate(
        ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 2, 2);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) Objects size is two.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(Object, int, int, int); when 'null'; then PositionCountingAreaMap (default constructor) Objects size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate_whenNull_thenPositionCountingAreaMapObjectsSizeIsTwo() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    positionCountingAreaMap.addOrUpdate(null, 2, 2, 2);

    // Assert
    assertEquals(2, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#addOrUpdate(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(Object, int, int, int); when 'null'; then PositionCountingAreaMap (default constructor) TotalPositions is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.addOrUpdate(Object, int, int, int)"})
  void testAddOrUpdate_whenNull_thenPositionCountingAreaMapTotalPositionsIsTwentyFive() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    positionCountingAreaMap.addOrUpdate(null, 2, 2, 2);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualRemoveResult =
        positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertTrue(actualRemoveResult);
    ReferenceSet<Object> objects = positionCountingAreaMap.getObjects();
    assertTrue(objects.isEmpty());
    assertEquals(objects, positionCountingAreaMap.getPositions());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove2() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(
        ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 2, 2);

    // Act
    boolean actualRemoveResult =
        positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertTrue(actualRemoveResult);
    ReferenceSet<Object> objects = positionCountingAreaMap.getObjects();
    assertTrue(objects.isEmpty());
    assertEquals(objects, positionCountingAreaMap.getPositions());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove3() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 2, 2);

    // Act
    boolean actualRemoveResult =
        positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertTrue(actualRemoveResult);
    ReferenceSet<Object> objects = positionCountingAreaMap.getObjects();
    assertTrue(objects.isEmpty());
    assertEquals(objects, positionCountingAreaMap.getPositions());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove4() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, -1, 2, 2);

    // Act
    boolean actualRemoveResult =
        positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertTrue(actualRemoveResult);
    ReferenceSet<Object> objects = positionCountingAreaMap.getObjects();
    assertTrue(objects.isEmpty());
    assertEquals(objects, positionCountingAreaMap.getPositions());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove5() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove6() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 4, 4);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, -1, 2);
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <ul>
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); then PositionCountingAreaMap (default constructor) TotalPositions is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove_thenPositionCountingAreaMapTotalPositionsIsTwentyFive() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, -1, 2);
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    boolean actualRemoveResult =
        positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <ul>
   *   <li>When {@link SingleUserAreaMap#NOT_SET}.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) Objects size is two.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); when NOT_SET; then PositionCountingAreaMap (default constructor) Objects size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove_whenNot_set_thenPositionCountingAreaMapObjectsSizeIsTwo() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 4, 4);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, -1, 2);
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    boolean actualRemoveResult = positionCountingAreaMap.remove(SingleUserAreaMap.NOT_SET);

    // Assert
    assertEquals(2, positionCountingAreaMap.getObjects().size());
    assertEquals(81, positionCountingAreaMap.getPositions().size());
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove_whenNull_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertFalse(positionCountingAreaMap.remove(null));
    ReferenceSet<Object> objects = positionCountingAreaMap.getObjects();
    assertTrue(objects.isEmpty());
    assertEquals(objects, positionCountingAreaMap.getPositions());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <ul>
   *   <li>When {@code Parameter}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object); when 'Parameter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove_whenParameter() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    positionCountingAreaMap.remove("Parameter");

    // Assert
    assertEquals(1, positionCountingAreaMap.getObjects().size());
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
  }

  /**
   * Test {@link PositionCountingAreaMap#remove(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object); when WILDCARD_OBJECT; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.remove(Object)"})
  void testRemove_whenWildcard_object_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act and Assert
    assertFalse(positionCountingAreaMap.remove(ConfigurationTransformation.WILDCARD_OBJECT));
    ReferenceSet<Object> objects = positionCountingAreaMap.getObjects();
    assertTrue(objects.isEmpty());
    assertEquals(objects, positionCountingAreaMap.getPositions());
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(9, positionCountingAreaMap.getTotalPositions());
    assertEquals(9, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate2() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 4, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(9, positionCountingAreaMap.getTotalPositions());
    assertEquals(9, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate3() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 1, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(9, positionCountingAreaMap.getTotalPositions());
    assertEquals(9, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate4() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 1, 0, 1);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(9, positionCountingAreaMap.getTotalPositions());
    assertEquals(9, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate5() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 1, -1, 1);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(9, positionCountingAreaMap.getTotalPositions());
    assertEquals(9, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate6() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 1, 1);
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate7() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, -1, 0, 1);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(9, positionCountingAreaMap.getTotalPositions());
    assertEquals(9, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link PositionCountingAreaMap#add(Object, int, int, int)} with {@code Parameter}
   *       and toX is one and toZ is one and distance is one.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test update(Object, int, int, int); given add(Object, int, int, int) with 'Parameter' and toX is one and toZ is one and distance is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate_givenAddWithParameterAndToXIsOneAndToZIsOneAndDistanceIsOne() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add("Parameter", 1, 1, 1);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(9, positionCountingAreaMap.getTotalPositions());
    assertEquals(9, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) Positions Empty.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test update(Object, int, int, int); then PositionCountingAreaMap (default constructor) Positions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate_thenPositionCountingAreaMapPositionsEmpty() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, -1, 2, 2);
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(
            ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 1, 1);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertTrue(actualUpdateResult);
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is nine.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test update(Object, int, int, int); then PositionCountingAreaMap (default constructor) TotalPositions is nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate_thenPositionCountingAreaMapTotalPositionsIsNine() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(9, positionCountingAreaMap.getTotalPositions());
    assertEquals(9, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test update(Object, int, int, int); then PositionCountingAreaMap (default constructor) TotalPositions is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate_thenPositionCountingAreaMapTotalPositionsIsTwentyFive() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add("Parameter", 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(25, positionCountingAreaMap.getTotalPositions());
    assertEquals(25, positionCountingAreaMap.getPositions().size());
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) TotalPositions is eighty-one.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test update(Object, int, int, int); when four; then PositionCountingAreaMap (default constructor) TotalPositions is eighty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate_whenFour_thenPositionCountingAreaMapTotalPositionsIsEightyOne() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 4);

    // Assert
    assertEquals(81, positionCountingAreaMap.getTotalPositions());
    assertEquals(81, positionCountingAreaMap.getPositions().size());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link SingleUserAreaMap#NOT_SET}.
   *   <li>Then {@link PositionCountingAreaMap} (default constructor) Positions Empty.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test update(Object, int, int, int); when NOT_SET; then PositionCountingAreaMap (default constructor) Positions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate_whenNot_set_thenPositionCountingAreaMapPositionsEmpty() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();
    positionCountingAreaMap.add(ConfigurationTransformation.WILDCARD_OBJECT, 2, 2, 2);

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(
            ConfigurationTransformation.WILDCARD_OBJECT, SingleUserAreaMap.NOT_SET, 1, 1);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertTrue(actualUpdateResult);
    assertTrue(positionCountingAreaMap.getPositions().isEmpty());
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate_whenNull_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    boolean actualUpdateResult = positionCountingAreaMap.update(null, 1, 1, 1);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link PositionCountingAreaMap#update(Object, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionCountingAreaMap#update(Object, int, int, int)}
   */
  @Test
  @DisplayName("Test update(Object, int, int, int); when WILDCARD_OBJECT; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionCountingAreaMap.update(Object, int, int, int)"})
  void testUpdate_whenWildcard_object_thenReturnFalse() {
    // Arrange
    PositionCountingAreaMap<Object> positionCountingAreaMap = new PositionCountingAreaMap<>();

    // Act
    boolean actualUpdateResult =
        positionCountingAreaMap.update(ConfigurationTransformation.WILDCARD_OBJECT, 1, 1, 1);

    // Assert
    assertEquals(0, positionCountingAreaMap.getTotalPositions());
    assertFalse(actualUpdateResult);
  }

  /**
   * Test new {@link PositionCountingAreaMap} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PositionCountingAreaMap}
   */
  @Test
  @DisplayName("Test new PositionCountingAreaMap (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionCountingAreaMap.<init>()"})
  void testNewPositionCountingAreaMap() {
    // Arrange and Act
    PositionCountingAreaMap<Object> actualPositionCountingAreaMap = new PositionCountingAreaMap<>();

    // Assert
    assertEquals(0, actualPositionCountingAreaMap.getTotalPositions());
    ReferenceSet<Object> objects = actualPositionCountingAreaMap.getObjects();
    assertTrue(objects.isEmpty());
    assertEquals(objects, actualPositionCountingAreaMap.getPositions());
  }
}
