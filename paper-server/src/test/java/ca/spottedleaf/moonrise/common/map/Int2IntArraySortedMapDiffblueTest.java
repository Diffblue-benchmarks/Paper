package ca.spottedleaf.moonrise.common.map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Int2IntArraySortedMapDiffblueTest {
  /**
   * Test new {@link Int2IntArraySortedMap} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Int2IntArraySortedMap}
   */
  @Test
  @DisplayName("Test new Int2IntArraySortedMap (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Int2IntArraySortedMap.<init>()"})
  void testNewInt2IntArraySortedMap() {
    // Arrange and Act
    Int2IntArraySortedMap actualInt2IntArraySortedMap = new Int2IntArraySortedMap();

    // Assert
    assertEquals(0, actualInt2IntArraySortedMap.size);
    assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0, 0}, actualInt2IntArraySortedMap.key);
    assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0, 0}, actualInt2IntArraySortedMap.val);
  }

  /**
   * Test {@link Int2IntArraySortedMap#put(int, int)}.
   *
   * <ul>
   *   <li>Given {@link Int2IntArraySortedMap} (default constructor) three is forty-two.
   *   <li>When three.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#put(int, int)}
   */
  @Test
  @DisplayName(
      "Test put(int, int); given Int2IntArraySortedMap (default constructor) three is forty-two; when three; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.put(int, int)"})
  void testPut_givenInt2IntArraySortedMapThreeIsFortyTwo_whenThree_thenReturnFortyTwo() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();
    int2IntArraySortedMap.put(3, 42);

    // Act
    int actualPutResult = int2IntArraySortedMap.put(3, 42);

    // Assert
    assertEquals(1, int2IntArraySortedMap.size);
    assertEquals(42, actualPutResult);
    assertArrayEquals(new int[] {3, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.key);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.val);
  }

  /**
   * Test {@link Int2IntArraySortedMap#put(int, int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then {@link Int2IntArraySortedMap} (default constructor) {@link
   *       Int2IntArraySortedMap#key} is array of {@code int} with eight and zero.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#put(int, int)}
   */
  @Test
  @DisplayName(
      "Test put(int, int); when eight; then Int2IntArraySortedMap (default constructor) key is array of int with eight and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.put(int, int)"})
  void testPut_whenEight_thenInt2IntArraySortedMapKeyIsArrayOfIntWithEightAndZero() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();

    // Act and Assert
    assertEquals(0, int2IntArraySortedMap.put(8, 42));
    assertEquals(1, int2IntArraySortedMap.size);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.val);
    assertArrayEquals(new int[] {8, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.key);
  }

  /**
   * Test {@link Int2IntArraySortedMap#put(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then {@link Int2IntArraySortedMap} (default constructor) {@link
   *       Int2IntArraySortedMap#key} is array of {@code int} with minus one and zero.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#put(int, int)}
   */
  @Test
  @DisplayName(
      "Test put(int, int); when minus one; then Int2IntArraySortedMap (default constructor) key is array of int with minus one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.put(int, int)"})
  void testPut_whenMinusOne_thenInt2IntArraySortedMapKeyIsArrayOfIntWithMinusOneAndZero() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();

    // Act and Assert
    assertEquals(0, int2IntArraySortedMap.put(-1, 42));
    assertEquals(1, int2IntArraySortedMap.size);
    assertArrayEquals(new int[] {-1, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.key);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.val);
  }

  /**
   * Test {@link Int2IntArraySortedMap#put(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link Int2IntArraySortedMap} (default constructor) {@link
   *       Int2IntArraySortedMap#key} is array of {@code int} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#put(int, int)}
   */
  @Test
  @DisplayName(
      "Test put(int, int); when one; then Int2IntArraySortedMap (default constructor) key is array of int with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.put(int, int)"})
  void testPut_whenOne_thenInt2IntArraySortedMapKeyIsArrayOfIntWithOneAndZero() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();

    // Act and Assert
    assertEquals(0, int2IntArraySortedMap.put(1, 42));
    assertEquals(1, int2IntArraySortedMap.size);
    assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.key);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.val);
  }

  /**
   * Test {@link Int2IntArraySortedMap#put(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then {@link Int2IntArraySortedMap} (default constructor) {@link
   *       Int2IntArraySortedMap#key} is array of {@code int} with three and zero.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#put(int, int)}
   */
  @Test
  @DisplayName(
      "Test put(int, int); when three; then Int2IntArraySortedMap (default constructor) key is array of int with three and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.put(int, int)"})
  void testPut_whenThree_thenInt2IntArraySortedMapKeyIsArrayOfIntWithThreeAndZero() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();

    // Act and Assert
    assertEquals(0, int2IntArraySortedMap.put(3, 42));
    assertEquals(1, int2IntArraySortedMap.size);
    assertArrayEquals(new int[] {3, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.key);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.val);
  }

  /**
   * Test {@link Int2IntArraySortedMap#computeIfAbsent(int, Int2IntFunction)}.
   *
   * <ul>
   *   <li>Given {@link Int2IntArraySortedMap} (default constructor) minus one is zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#computeIfAbsent(int, Int2IntFunction)}
   */
  @Test
  @DisplayName(
      "Test computeIfAbsent(int, Int2IntFunction); given Int2IntArraySortedMap (default constructor) minus one is zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.computeIfAbsent(int, Int2IntFunction)"})
  void testComputeIfAbsent_givenInt2IntArraySortedMapMinusOneIsZero_thenReturnZero() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();
    int2IntArraySortedMap.put(-1, 0);

    // Act and Assert
    assertEquals(0, int2IntArraySortedMap.computeIfAbsent(-1, mock(Int2IntFunction.class)));
    assertEquals(1, int2IntArraySortedMap.size);
    assertArrayEquals(new int[] {-1, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.key);
    assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.val);
  }

  /**
   * Test {@link Int2IntArraySortedMap#computeIfAbsent(int, Int2IntFunction)}.
   *
   * <ul>
   *   <li>Given {@link Int2IntArraySortedMap} (default constructor).
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#computeIfAbsent(int, Int2IntFunction)}
   */
  @Test
  @DisplayName(
      "Test computeIfAbsent(int, Int2IntFunction); given Int2IntArraySortedMap (default constructor); when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.computeIfAbsent(int, Int2IntFunction)"})
  void testComputeIfAbsent_givenInt2IntArraySortedMap_whenOne_thenReturnOne() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();

    Int2IntFunction producer = mock(Int2IntFunction.class);
    when(producer.apply(Mockito.<Integer>any())).thenReturn(1);

    // Act
    int actualComputeIfAbsentResult = int2IntArraySortedMap.computeIfAbsent(1, producer);

    // Assert
    verify(producer).apply(1);
    assertEquals(1, actualComputeIfAbsentResult);
    assertEquals(1, int2IntArraySortedMap.size);
    assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.key);
    assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0, 0}, int2IntArraySortedMap.val);
  }

  /**
   * Test {@link Int2IntArraySortedMap#get(int)}.
   *
   * <ul>
   *   <li>Given {@link Int2IntArraySortedMap} (default constructor) one is forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#get(int)}
   */
  @Test
  @DisplayName(
      "Test get(int); given Int2IntArraySortedMap (default constructor) one is forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.get(int)"})
  void testGet_givenInt2IntArraySortedMapOneIsFortyTwo_thenReturnFortyTwo() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();
    int2IntArraySortedMap.put(1, 42);

    // Act and Assert
    assertEquals(42, int2IntArraySortedMap.get(1));
  }

  /**
   * Test {@link Int2IntArraySortedMap#get(int)}.
   *
   * <ul>
   *   <li>Given {@link Int2IntArraySortedMap} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#get(int)}
   */
  @Test
  @DisplayName("Test get(int); given Int2IntArraySortedMap (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.get(int)"})
  void testGet_givenInt2IntArraySortedMap_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new Int2IntArraySortedMap().get(1));
  }

  /**
   * Test {@link Int2IntArraySortedMap#getFloor(int)}.
   *
   * <ul>
   *   <li>Given {@link Int2IntArraySortedMap} (default constructor) minus one is forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#getFloor(int)}
   */
  @Test
  @DisplayName(
      "Test getFloor(int); given Int2IntArraySortedMap (default constructor) minus one is forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.getFloor(int)"})
  void testGetFloor_givenInt2IntArraySortedMapMinusOneIsFortyTwo_thenReturnFortyTwo() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();
    int2IntArraySortedMap.put(-1, 42);

    // Act and Assert
    assertEquals(42, int2IntArraySortedMap.getFloor(1));
  }

  /**
   * Test {@link Int2IntArraySortedMap#getFloor(int)}.
   *
   * <ul>
   *   <li>Given {@link Int2IntArraySortedMap} (default constructor) one is minus two.
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#getFloor(int)}
   */
  @Test
  @DisplayName(
      "Test getFloor(int); given Int2IntArraySortedMap (default constructor) one is minus two; then return minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.getFloor(int)"})
  void testGetFloor_givenInt2IntArraySortedMapOneIsMinusTwo_thenReturnMinusTwo() {
    // Arrange
    Int2IntArraySortedMap int2IntArraySortedMap = new Int2IntArraySortedMap();
    int2IntArraySortedMap.put(1, -2);
    int2IntArraySortedMap.put(-1, 42);

    // Act and Assert
    assertEquals(-2, int2IntArraySortedMap.getFloor(1));
  }

  /**
   * Test {@link Int2IntArraySortedMap#getFloor(int)}.
   *
   * <ul>
   *   <li>Given {@link Int2IntArraySortedMap} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Int2IntArraySortedMap#getFloor(int)}
   */
  @Test
  @DisplayName(
      "Test getFloor(int); given Int2IntArraySortedMap (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int2IntArraySortedMap.getFloor(int)"})
  void testGetFloor_givenInt2IntArraySortedMap_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new Int2IntArraySortedMap().getFloor(1));
  }
}
