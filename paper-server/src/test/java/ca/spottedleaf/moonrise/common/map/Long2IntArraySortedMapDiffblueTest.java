package ca.spottedleaf.moonrise.common.map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import it.unimi.dsi.fastutil.longs.Long2IntFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Long2IntArraySortedMapDiffblueTest {
  /**
   * Test new {@link Long2IntArraySortedMap} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Long2IntArraySortedMap}
   */
  @Test
  @DisplayName("Test new Long2IntArraySortedMap (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Long2IntArraySortedMap.<init>()"})
  void testNewLong2IntArraySortedMap() {
    // Arrange and Act
    Long2IntArraySortedMap actualLong2IntArraySortedMap = new Long2IntArraySortedMap();

    // Assert
    assertEquals(0, actualLong2IntArraySortedMap.size);
    assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0, 0}, actualLong2IntArraySortedMap.val);
    assertArrayEquals(
        new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, actualLong2IntArraySortedMap.key);
  }

  /**
   * Test {@link Long2IntArraySortedMap#put(long, int)}.
   *
   * <ul>
   *   <li>Given {@link Long2IntArraySortedMap} (default constructor) five is forty-two.
   *   <li>When five.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#put(long, int)}
   */
  @Test
  @DisplayName(
      "Test put(long, int); given Long2IntArraySortedMap (default constructor) five is forty-two; when five; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.put(long, int)"})
  void testPut_givenLong2IntArraySortedMapFiveIsFortyTwo_whenFive_thenReturnFortyTwo() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();
    long2IntArraySortedMap.put(5L, 42);

    // Act
    int actualPutResult = long2IntArraySortedMap.put(5L, 42);

    // Assert
    assertEquals(1, long2IntArraySortedMap.size);
    assertEquals(42, actualPutResult);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, long2IntArraySortedMap.val);
    assertArrayEquals(new long[] {5L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, long2IntArraySortedMap.key);
  }

  /**
   * Test {@link Long2IntArraySortedMap#put(long, int)}.
   *
   * <ul>
   *   <li>Then {@link Long2IntArraySortedMap} (default constructor) {@link
   *       Long2IntArraySortedMap#key} is array of {@code long} with minus one and zero.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#put(long, int)}
   */
  @Test
  @DisplayName(
      "Test put(long, int); then Long2IntArraySortedMap (default constructor) key is array of long with minus one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.put(long, int)"})
  void testPut_thenLong2IntArraySortedMapKeyIsArrayOfLongWithMinusOneAndZero() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();

    // Act and Assert
    assertEquals(0, long2IntArraySortedMap.put(-1L, 42));
    assertEquals(1, long2IntArraySortedMap.size);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, long2IntArraySortedMap.val);
    assertArrayEquals(new long[] {-1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, long2IntArraySortedMap.key);
  }

  /**
   * Test {@link Long2IntArraySortedMap#put(long, int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then {@link Long2IntArraySortedMap} (default constructor) {@link
   *       Long2IntArraySortedMap#key} is array of {@code long} with eight and zero.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#put(long, int)}
   */
  @Test
  @DisplayName(
      "Test put(long, int); when eight; then Long2IntArraySortedMap (default constructor) key is array of long with eight and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.put(long, int)"})
  void testPut_whenEight_thenLong2IntArraySortedMapKeyIsArrayOfLongWithEightAndZero() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();

    // Act and Assert
    assertEquals(0, long2IntArraySortedMap.put(8L, 42));
    assertEquals(1, long2IntArraySortedMap.size);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, long2IntArraySortedMap.val);
    assertArrayEquals(new long[] {8L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, long2IntArraySortedMap.key);
  }

  /**
   * Test {@link Long2IntArraySortedMap#put(long, int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then {@link Long2IntArraySortedMap} (default constructor) {@link
   *       Long2IntArraySortedMap#key} is array of {@code long} with five and zero.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#put(long, int)}
   */
  @Test
  @DisplayName(
      "Test put(long, int); when five; then Long2IntArraySortedMap (default constructor) key is array of long with five and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.put(long, int)"})
  void testPut_whenFive_thenLong2IntArraySortedMapKeyIsArrayOfLongWithFiveAndZero() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();

    // Act and Assert
    assertEquals(0, long2IntArraySortedMap.put(5L, 42));
    assertEquals(1, long2IntArraySortedMap.size);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, long2IntArraySortedMap.val);
    assertArrayEquals(new long[] {5L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, long2IntArraySortedMap.key);
  }

  /**
   * Test {@link Long2IntArraySortedMap#put(long, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link Long2IntArraySortedMap} (default constructor) {@link
   *       Long2IntArraySortedMap#key} is array of {@code long} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#put(long, int)}
   */
  @Test
  @DisplayName(
      "Test put(long, int); when one; then Long2IntArraySortedMap (default constructor) key is array of long with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.put(long, int)"})
  void testPut_whenOne_thenLong2IntArraySortedMapKeyIsArrayOfLongWithOneAndZero() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();

    // Act and Assert
    assertEquals(0, long2IntArraySortedMap.put(1L, 42));
    assertEquals(1, long2IntArraySortedMap.size);
    assertArrayEquals(new int[] {42, 0, 0, 0, 0, 0, 0, 0}, long2IntArraySortedMap.val);
    assertArrayEquals(new long[] {1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, long2IntArraySortedMap.key);
  }

  /**
   * Test {@link Long2IntArraySortedMap#computeIfAbsent(long, Long2IntFunction)}.
   *
   * <ul>
   *   <li>Given {@link Long2IntArraySortedMap} (default constructor) {@link Long#MAX_VALUE} is
   *       zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#computeIfAbsent(long, Long2IntFunction)}
   */
  @Test
  @DisplayName(
      "Test computeIfAbsent(long, Long2IntFunction); given Long2IntArraySortedMap (default constructor) MAX_VALUE is zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.computeIfAbsent(long, Long2IntFunction)"})
  void testComputeIfAbsent_givenLong2IntArraySortedMapMax_valueIsZero_thenReturnZero() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();
    long2IntArraySortedMap.put(Long.MAX_VALUE, 0);

    // Act and Assert
    assertEquals(
        0, long2IntArraySortedMap.computeIfAbsent(Long.MAX_VALUE, mock(Long2IntFunction.class)));
    assertEquals(1, long2IntArraySortedMap.size);
    assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0, 0}, long2IntArraySortedMap.val);
    assertArrayEquals(
        new long[] {Long.MAX_VALUE, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, long2IntArraySortedMap.key);
  }

  /**
   * Test {@link Long2IntArraySortedMap#computeIfAbsent(long, Long2IntFunction)}.
   *
   * <ul>
   *   <li>Given {@link Long2IntArraySortedMap} (default constructor).
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#computeIfAbsent(long, Long2IntFunction)}
   */
  @Test
  @DisplayName(
      "Test computeIfAbsent(long, Long2IntFunction); given Long2IntArraySortedMap (default constructor); when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.computeIfAbsent(long, Long2IntFunction)"})
  void testComputeIfAbsent_givenLong2IntArraySortedMap_whenOne_thenReturnOne() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();

    Long2IntFunction producer = mock(Long2IntFunction.class);
    when(producer.apply(Mockito.<Long>any())).thenReturn(1);

    // Act
    int actualComputeIfAbsentResult = long2IntArraySortedMap.computeIfAbsent(1L, producer);

    // Assert
    verify(producer).apply(1L);
    assertEquals(1, actualComputeIfAbsentResult);
    assertEquals(1, long2IntArraySortedMap.size);
    assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0, 0}, long2IntArraySortedMap.val);
    assertArrayEquals(new long[] {1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, long2IntArraySortedMap.key);
  }

  /**
   * Test {@link Long2IntArraySortedMap#get(long)}.
   *
   * <ul>
   *   <li>Given {@link Long2IntArraySortedMap} (default constructor) one is forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#get(long)}
   */
  @Test
  @DisplayName(
      "Test get(long); given Long2IntArraySortedMap (default constructor) one is forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.get(long)"})
  void testGet_givenLong2IntArraySortedMapOneIsFortyTwo_thenReturnFortyTwo() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();
    long2IntArraySortedMap.put(1L, 42);

    // Act and Assert
    assertEquals(42, long2IntArraySortedMap.get(1L));
  }

  /**
   * Test {@link Long2IntArraySortedMap#get(long)}.
   *
   * <ul>
   *   <li>Given {@link Long2IntArraySortedMap} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#get(long)}
   */
  @Test
  @DisplayName(
      "Test get(long); given Long2IntArraySortedMap (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.get(long)"})
  void testGet_givenLong2IntArraySortedMap_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new Long2IntArraySortedMap().get(1L));
  }

  /**
   * Test {@link Long2IntArraySortedMap#getFloor(long)}.
   *
   * <ul>
   *   <li>Given {@link Long2IntArraySortedMap} (default constructor) minus one is forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#getFloor(long)}
   */
  @Test
  @DisplayName(
      "Test getFloor(long); given Long2IntArraySortedMap (default constructor) minus one is forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.getFloor(long)"})
  void testGetFloor_givenLong2IntArraySortedMapMinusOneIsFortyTwo_thenReturnFortyTwo() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();
    long2IntArraySortedMap.put(-1L, 42);

    // Act and Assert
    assertEquals(42, long2IntArraySortedMap.getFloor(1L));
  }

  /**
   * Test {@link Long2IntArraySortedMap#getFloor(long)}.
   *
   * <ul>
   *   <li>Given {@link Long2IntArraySortedMap} (default constructor) one is minus two.
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#getFloor(long)}
   */
  @Test
  @DisplayName(
      "Test getFloor(long); given Long2IntArraySortedMap (default constructor) one is minus two; then return minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.getFloor(long)"})
  void testGetFloor_givenLong2IntArraySortedMapOneIsMinusTwo_thenReturnMinusTwo() {
    // Arrange
    Long2IntArraySortedMap long2IntArraySortedMap = new Long2IntArraySortedMap();
    long2IntArraySortedMap.put(1L, -2);
    long2IntArraySortedMap.put(-1L, 42);

    // Act and Assert
    assertEquals(-2, long2IntArraySortedMap.getFloor(1L));
  }

  /**
   * Test {@link Long2IntArraySortedMap#getFloor(long)}.
   *
   * <ul>
   *   <li>Given {@link Long2IntArraySortedMap} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Long2IntArraySortedMap#getFloor(long)}
   */
  @Test
  @DisplayName(
      "Test getFloor(long); given Long2IntArraySortedMap (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Long2IntArraySortedMap.getFloor(long)"})
  void testGetFloor_givenLong2IntArraySortedMap_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new Long2IntArraySortedMap().getFloor(1L));
  }
}
