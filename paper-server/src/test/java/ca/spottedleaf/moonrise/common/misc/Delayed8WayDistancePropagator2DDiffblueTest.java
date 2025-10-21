package ca.spottedleaf.moonrise.common.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyByte;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import ca.spottedleaf.moonrise.common.misc.Delayed8WayDistancePropagator2D.LevelChangeCallback;
import ca.spottedleaf.moonrise.common.misc.Delayed8WayDistancePropagator2D.LevelMap;
import ca.spottedleaf.moonrise.common.misc.Delayed8WayDistancePropagator2D.NoResizeByteArrayFIFODeque;
import ca.spottedleaf.moonrise.common.misc.Delayed8WayDistancePropagator2D.NoResizeLongArrayFIFODeque;
import ca.spottedleaf.moonrise.common.misc.Delayed8WayDistancePropagator2D.WorkQueue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import it.unimi.dsi.fastutil.longs.Long2ByteOpenHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Delayed8WayDistancePropagator2DDiffblueTest {
  /**
   * Test LevelMap {@link LevelMap#LevelMap()}.
   *
   * <p>Method under test: {@link LevelMap#LevelMap()}
   */
  @Test
  @DisplayName("Test LevelMap new LevelMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelMap.<init>()"})
  void testLevelMapNewLevelMap() {
    // Arrange, Act and Assert
    assertTrue(new LevelMap().isEmpty());
  }

  /**
   * Test LevelMap {@link LevelMap#LevelMap(int, float)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#LevelMap(int, float)}
   */
  @Test
  @DisplayName(
      "Test LevelMap new LevelMap(int, float); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelMap.<init>(int, float)"})
  void testLevelMapNewLevelMap_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LevelMap(-1, 1.0E-5f));
  }

  /**
   * Test LevelMap {@link LevelMap#LevelMap(int, float)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#LevelMap(int, float)}
   */
  @Test
  @DisplayName(
      "Test LevelMap new LevelMap(int, float); when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelMap.<init>(int, float)"})
  void testLevelMapNewLevelMap_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LevelMap(1, 10.0f));
  }

  /**
   * Test LevelMap {@link LevelMap#LevelMap(int, float)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#LevelMap(int, float)}
   */
  @Test
  @DisplayName("Test LevelMap new LevelMap(int, float); when zero; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelMap.<init>(int, float)"})
  void testLevelMapNewLevelMap_whenZero_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new LevelMap(0, 1.0E-5f).isEmpty());
  }

  /**
   * Test LevelMap {@link LevelMap#LevelMap(int, float)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#LevelMap(int, float)}
   */
  @Test
  @DisplayName(
      "Test LevelMap new LevelMap(int, float); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelMap.<init>(int, float)"})
  void testLevelMapNewLevelMap_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LevelMap(0, 0.0f));
  }

  /**
   * Test LevelMap {@link LevelMap#putIfGreater(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()} defaultReturnValue {@code A}.
   *   <li>Then {@link LevelMap#LevelMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#putIfGreater(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap putIfGreater(long, byte); given LevelMap() defaultReturnValue 'A'; then LevelMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.putIfGreater(long, byte)"})
  void testLevelMapPutIfGreater_givenLevelMapDefaultReturnValueA_thenLevelMapEmpty() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.defaultReturnValue((byte) 'A');
    levelMap.putIfGreater(5L, (byte) 'A');

    // Act
    byte actualPutIfGreaterResult = levelMap.putIfGreater(5L, (byte) 'A');

    // Assert
    assertTrue(levelMap.isEmpty());
    assertEquals('A', actualPutIfGreaterResult);
  }

  /**
   * Test LevelMap {@link LevelMap#putIfGreater(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()} IfGreater five is {@code A}.
   *   <li>When five.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#putIfGreater(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap putIfGreater(long, byte); given LevelMap() IfGreater five is 'A'; when five; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.putIfGreater(long, byte)"})
  void testLevelMapPutIfGreater_givenLevelMapIfGreaterFiveIsA_whenFive_thenReturnA() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(5L, (byte) 'A');

    // Act
    byte actualPutIfGreaterResult = levelMap.putIfGreater(5L, (byte) 'A');

    // Assert
    assertEquals(1, levelMap.size());
    assertEquals('A', actualPutIfGreaterResult);
    assertEquals('A', levelMap.get((Object) 5L).byteValue());
  }

  /**
   * Test LevelMap {@link LevelMap#putIfGreater(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()} IfGreater five is five.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#putIfGreater(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap putIfGreater(long, byte); given LevelMap() IfGreater five is five; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.putIfGreater(long, byte)"})
  void testLevelMapPutIfGreater_givenLevelMapIfGreaterFiveIsFive_thenReturnFive() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(5L, (byte) 5);

    // Act
    byte actualPutIfGreaterResult = levelMap.putIfGreater(5L, (byte) 'A');

    // Assert
    assertEquals(1, levelMap.size());
    assertEquals((byte) 5, actualPutIfGreaterResult);
    assertEquals('A', levelMap.get((Object) 5L).byteValue());
  }

  /**
   * Test LevelMap {@link LevelMap#putIfGreater(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()} IfGreater zero is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#putIfGreater(long, byte)}
   */
  @Test
  @DisplayName("Test LevelMap putIfGreater(long, byte); given LevelMap() IfGreater zero is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.putIfGreater(long, byte)"})
  void testLevelMapPutIfGreater_givenLevelMapIfGreaterZeroIsA() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(0L, (byte) 'A');

    // Act
    byte actualPutIfGreaterResult = levelMap.putIfGreater(0L, (byte) 'A');

    // Assert
    assertEquals(1, levelMap.size());
    assertEquals('A', actualPutIfGreaterResult);
    assertEquals('A', levelMap.get((Object) 0L).byteValue());
  }

  /**
   * Test LevelMap {@link LevelMap#putIfGreater(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()}.
   *   <li>When five.
   *   <li>Then {@link LevelMap#LevelMap()} five byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#putIfGreater(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap putIfGreater(long, byte); given LevelMap(); when five; then LevelMap() five byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.putIfGreater(long, byte)"})
  void testLevelMapPutIfGreater_givenLevelMap_whenFive_thenLevelMapFiveByteValueIsA() {
    // Arrange
    LevelMap levelMap = new LevelMap();

    // Act and Assert
    assertEquals((byte) 0, levelMap.putIfGreater(5L, (byte) 'A'));
    assertEquals(1, levelMap.size());
    assertEquals('A', levelMap.get((Object) 5L).byteValue());
  }

  /**
   * Test LevelMap {@link LevelMap#putIfGreater(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()}.
   *   <li>When one.
   *   <li>Then {@link LevelMap#LevelMap()} one byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#putIfGreater(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap putIfGreater(long, byte); given LevelMap(); when one; then LevelMap() one byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.putIfGreater(long, byte)"})
  void testLevelMapPutIfGreater_givenLevelMap_whenOne_thenLevelMapOneByteValueIsA() {
    // Arrange
    LevelMap levelMap = new LevelMap();

    // Act and Assert
    assertEquals((byte) 0, levelMap.putIfGreater(1L, (byte) 'A'));
    assertEquals(1, levelMap.size());
    assertEquals('A', levelMap.get((Object) 1L).byteValue());
  }

  /**
   * Test LevelMap {@link LevelMap#putIfGreater(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()}.
   *   <li>When zero.
   *   <li>Then {@link LevelMap#LevelMap()} zero byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#putIfGreater(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap putIfGreater(long, byte); given LevelMap(); when zero; then LevelMap() zero byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.putIfGreater(long, byte)"})
  void testLevelMapPutIfGreater_givenLevelMap_whenZero_thenLevelMapZeroByteValueIsA() {
    // Arrange
    LevelMap levelMap = new LevelMap();

    // Act and Assert
    assertEquals((byte) 0, levelMap.putIfGreater(0L, (byte) 'A'));
    assertEquals(1, levelMap.size());
    assertEquals('A', levelMap.get((Object) 0L).byteValue());
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()} IfGreater five is {@code A}.
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap removeIfGreaterOrEqual(long, byte); given LevelMap() IfGreater five is 'A'; when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_givenLevelMapIfGreaterFiveIsA_whenFive() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(5L, (byte) 'A');

    // Act
    byte actualRemoveIfGreaterOrEqualResult = levelMap.removeIfGreaterOrEqual(5L, (byte) 'A');

    // Assert
    assertTrue(levelMap.isEmpty());
    assertEquals('A', actualRemoveIfGreaterOrEqualResult);
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()} IfGreater zero is {@code A}.
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap removeIfGreaterOrEqual(long, byte); given LevelMap() IfGreater zero is 'A'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_givenLevelMapIfGreaterZeroIsA_whenZero() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(0L, (byte) 'A');

    // Act
    byte actualRemoveIfGreaterOrEqualResult = levelMap.removeIfGreaterOrEqual(0L, (byte) 'A');

    // Assert
    assertTrue(levelMap.isEmpty());
    assertEquals('A', actualRemoveIfGreaterOrEqualResult);
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()}.
   *   <li>When five.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap removeIfGreaterOrEqual(long, byte); given LevelMap(); when five; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_givenLevelMap_whenFive_thenReturnZero() {
    // Arrange
    LevelMap levelMap = new LevelMap();

    // Act and Assert
    assertEquals((byte) 0, levelMap.removeIfGreaterOrEqual(5L, (byte) 'A'));
    assertTrue(levelMap.isEmpty());
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()}.
   *   <li>When minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap removeIfGreaterOrEqual(long, byte); given LevelMap(); when minus one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_givenLevelMap_whenMinusOne_thenReturnZero() {
    // Arrange
    LevelMap levelMap = new LevelMap();

    // Act and Assert
    assertEquals((byte) 0, levelMap.removeIfGreaterOrEqual(-1L, (byte) 'A'));
    assertTrue(levelMap.isEmpty());
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()}.
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap removeIfGreaterOrEqual(long, byte); given LevelMap(); when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_givenLevelMap_whenOne_thenReturnZero() {
    // Arrange
    LevelMap levelMap = new LevelMap();

    // Act and Assert
    assertEquals((byte) 0, levelMap.removeIfGreaterOrEqual(1L, (byte) 'A'));
    assertTrue(levelMap.isEmpty());
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Given {@link LevelMap#LevelMap()}.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName(
      "Test LevelMap removeIfGreaterOrEqual(long, byte); given LevelMap(); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_givenLevelMap_whenZero_thenReturnZero() {
    // Arrange
    LevelMap levelMap = new LevelMap();

    // Act and Assert
    assertEquals((byte) 0, levelMap.removeIfGreaterOrEqual(0L, (byte) 'A'));
    assertTrue(levelMap.isEmpty());
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Then {@link LevelMap#LevelMap()} containsKey five.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName("Test LevelMap removeIfGreaterOrEqual(long, byte); then LevelMap() containsKey five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_thenLevelMapContainsKeyFive() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(5L, (byte) 'X');

    // Act
    byte actualRemoveIfGreaterOrEqualResult = levelMap.removeIfGreaterOrEqual(5L, (byte) 'A');

    // Assert
    assertEquals(1, levelMap.size());
    assertTrue(levelMap.containsKey((Object) 5L));
    assertEquals('X', actualRemoveIfGreaterOrEqualResult);
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Then {@link LevelMap#LevelMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName("Test LevelMap removeIfGreaterOrEqual(long, byte); then LevelMap() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_thenLevelMapSizeIsOne() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.put(Long.MAX_VALUE, (byte) -1);

    // Act and Assert
    assertEquals((byte) 0, levelMap.removeIfGreaterOrEqual(-1L, (byte) 'A'));
    assertEquals(1, levelMap.size());
    assertTrue(levelMap.containsKey((Object) Long.MAX_VALUE));
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Then {@link LevelMap#LevelMap()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName("Test LevelMap removeIfGreaterOrEqual(long, byte); then LevelMap() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_thenLevelMapSizeIsThree() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.put(65L, (byte) -1);
    levelMap.putIfGreater(-1L, (byte) 'A');
    levelMap.putIfGreater(1L, (byte) 1);
    levelMap.put(Long.MAX_VALUE, (byte) -1);

    // Act
    byte actualRemoveIfGreaterOrEqualResult = levelMap.removeIfGreaterOrEqual(-1L, (byte) 'A');

    // Assert
    assertEquals(3, levelMap.size());
    assertTrue(levelMap.containsKey((Object) 1L));
    assertTrue(levelMap.containsKey((Object) 65L));
    assertTrue(levelMap.containsKey((Object) Long.MAX_VALUE));
    assertEquals('A', actualRemoveIfGreaterOrEqualResult);
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Then {@link LevelMap#LevelMap()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName("Test LevelMap removeIfGreaterOrEqual(long, byte); then LevelMap() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_thenLevelMapSizeIsTwo() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(1L, (byte) 1);
    levelMap.put(Long.MAX_VALUE, (byte) -1);

    // Act and Assert
    assertEquals((byte) 0, levelMap.removeIfGreaterOrEqual(-1L, (byte) 'A'));
    assertEquals(2, levelMap.size());
    assertTrue(levelMap.containsKey((Object) 1L));
    assertTrue(levelMap.containsKey((Object) Long.MAX_VALUE));
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Then {@link LevelMap#LevelMap()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName("Test LevelMap removeIfGreaterOrEqual(long, byte); then LevelMap() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_thenLevelMapSizeIsTwo2() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(-1L, (byte) 'A');
    levelMap.putIfGreater(1L, (byte) 1);
    levelMap.put(Long.MAX_VALUE, (byte) -1);

    // Act
    byte actualRemoveIfGreaterOrEqualResult = levelMap.removeIfGreaterOrEqual(-1L, (byte) 'A');

    // Assert
    assertEquals(2, levelMap.size());
    assertTrue(levelMap.containsKey((Object) 1L));
    assertTrue(levelMap.containsKey((Object) Long.MAX_VALUE));
    assertEquals('A', actualRemoveIfGreaterOrEqualResult);
  }

  /**
   * Test LevelMap {@link LevelMap#removeIfGreaterOrEqual(long, byte)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link LevelMap#removeIfGreaterOrEqual(long, byte)}
   */
  @Test
  @DisplayName("Test LevelMap removeIfGreaterOrEqual(long, byte); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte LevelMap.removeIfGreaterOrEqual(long, byte)"})
  void testLevelMapRemoveIfGreaterOrEqual_thenReturnOne() {
    // Arrange
    LevelMap levelMap = new LevelMap();
    levelMap.putIfGreater(-1L, (byte) 1);
    levelMap.put(Long.MAX_VALUE, (byte) -1);

    // Act
    byte actualRemoveIfGreaterOrEqualResult = levelMap.removeIfGreaterOrEqual(-1L, (byte) 'A');

    // Assert
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, actualRemoveIfGreaterOrEqualResult);
    assertTrue(levelMap.containsKey((Object) Long.MAX_VALUE));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#Delayed8WayDistancePropagator2D()}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#Delayed8WayDistancePropagator2D()}
   */
  @Test
  @DisplayName("Test new Delayed8WayDistancePropagator2D()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.<init>()"})
  void testNewDelayed8WayDistancePropagator2D() {
    // Arrange and Act
    Delayed8WayDistancePropagator2D actualDelayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Assert
    assertNull(actualDelayed8WayDistancePropagator2D.changeCallback);
    assertEquals(0L, actualDelayed8WayDistancePropagator2D.levelIncreaseWorkQueueBitset);
    assertEquals(0L, actualDelayed8WayDistancePropagator2D.levelRemoveWorkQueueBitset);
    assertTrue(actualDelayed8WayDistancePropagator2D.levels.isEmpty());
    assertTrue(actualDelayed8WayDistancePropagator2D.sources.isEmpty());
    assertTrue(actualDelayed8WayDistancePropagator2D.updatedSources.isEmpty());
    assertEquals(Double.SIZE, actualDelayed8WayDistancePropagator2D.levelIncreaseWorkQueues.length);
    assertEquals(Double.SIZE, actualDelayed8WayDistancePropagator2D.levelRemoveWorkQueues.length);
  }

  /**
   * Test {@link
   * Delayed8WayDistancePropagator2D#Delayed8WayDistancePropagator2D(LevelChangeCallback)}.
   *
   * <p>Method under test: {@link
   * Delayed8WayDistancePropagator2D#Delayed8WayDistancePropagator2D(LevelChangeCallback)}
   */
  @Test
  @DisplayName("Test new Delayed8WayDistancePropagator2D(LevelChangeCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.<init>(LevelChangeCallback)"})
  void testNewDelayed8WayDistancePropagator2D2() {
    // Arrange and Act
    Delayed8WayDistancePropagator2D actualDelayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D(mock(LevelChangeCallback.class));

    // Assert
    assertEquals(0L, actualDelayed8WayDistancePropagator2D.levelIncreaseWorkQueueBitset);
    assertEquals(0L, actualDelayed8WayDistancePropagator2D.levelRemoveWorkQueueBitset);
    assertTrue(actualDelayed8WayDistancePropagator2D.levels.isEmpty());
    assertTrue(actualDelayed8WayDistancePropagator2D.sources.isEmpty());
    assertTrue(actualDelayed8WayDistancePropagator2D.updatedSources.isEmpty());
    assertEquals(Double.SIZE, actualDelayed8WayDistancePropagator2D.levelIncreaseWorkQueues.length);
    assertEquals(Double.SIZE, actualDelayed8WayDistancePropagator2D.levelRemoveWorkQueues.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#getLevel(long)} with {@code pos}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#getLevel(long)}
   */
  @Test
  @DisplayName("Test getLevel(long) with 'pos'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed8WayDistancePropagator2D.getLevel(long)"})
  void testGetLevelWithPos_whenOne() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed8WayDistancePropagator2D().getLevel(1L));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#getLevel(long)} with {@code pos}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#getLevel(long)}
   */
  @Test
  @DisplayName("Test getLevel(long) with 'pos'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed8WayDistancePropagator2D.getLevel(long)"})
  void testGetLevelWithPos_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed8WayDistancePropagator2D().getLevel(0L));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#getLevel(int, int)} with {@code x}, {@code z}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#getLevel(int, int)}
   */
  @Test
  @DisplayName("Test getLevel(int, int) with 'x', 'z'; when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed8WayDistancePropagator2D.getLevel(int, int)"})
  void testGetLevelWithXZ_whenMinusOne() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed8WayDistancePropagator2D().getLevel(-1, 3));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#getLevel(int, int)} with {@code x}, {@code z}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#getLevel(int, int)}
   */
  @Test
  @DisplayName("Test getLevel(int, int) with 'x', 'z'; when SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed8WayDistancePropagator2D.getLevel(int, int)"})
  void testGetLevelWithXZ_whenSize() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed8WayDistancePropagator2D().getLevel(Integer.SIZE, 3));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#getLevel(int, int)} with {@code x}, {@code z}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#getLevel(int, int)}
   */
  @Test
  @DisplayName("Test getLevel(int, int) with 'x', 'z'; when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed8WayDistancePropagator2D.getLevel(int, int)"})
  void testGetLevelWithXZ_whenThree() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed8WayDistancePropagator2D().getLevel(3, 3));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#getLevel(int, int)} with {@code x}, {@code z}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#getLevel(int, int)}
   */
  @Test
  @DisplayName("Test getLevel(int, int) with 'x', 'z'; when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed8WayDistancePropagator2D.getLevel(int, int)"})
  void testGetLevelWithXZ_whenTwo() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed8WayDistancePropagator2D().getLevel(2, 3));
  }

  /**
   * Test NoResizeByteArrayFIFODeque new {@link NoResizeByteArrayFIFODeque} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * NoResizeByteArrayFIFODeque}
   */
  @Test
  @DisplayName(
      "Test NoResizeByteArrayFIFODeque new NoResizeByteArrayFIFODeque (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NoResizeByteArrayFIFODeque.<init>()"})
  void testNoResizeByteArrayFIFODequeNewNoResizeByteArrayFIFODeque() {
    // Arrange and Act
    NoResizeByteArrayFIFODeque actualNoResizeByteArrayFIFODeque = new NoResizeByteArrayFIFODeque();

    // Assert
    assertNull(actualNoResizeByteArrayFIFODeque.comparator());
    assertEquals(0, actualNoResizeByteArrayFIFODeque.size());
    assertTrue(actualNoResizeByteArrayFIFODeque.isEmpty());
  }

  /**
   * Test NoResizeByteArrayFIFODeque {@link NoResizeByteArrayFIFODeque#removeFirstByte()}.
   *
   * <p>Method under test: {@link NoResizeByteArrayFIFODeque#removeFirstByte()}
   */
  @Test
  @DisplayName("Test NoResizeByteArrayFIFODeque removeFirstByte()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NoResizeByteArrayFIFODeque.removeFirstByte()"})
  void testNoResizeByteArrayFIFODequeRemoveFirstByte() {
    // Arrange
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = new NoResizeByteArrayFIFODeque();
    noResizeByteArrayFIFODeque.enqueueFirst((byte) 'A');

    // Act
    byte actualRemoveFirstByteResult = noResizeByteArrayFIFODeque.removeFirstByte();

    // Assert
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals('A', actualRemoveFirstByteResult);
  }

  /**
   * Test NoResizeByteArrayFIFODeque {@link NoResizeByteArrayFIFODeque#removeFirstByte()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoResizeByteArrayFIFODeque#removeFirstByte()}
   */
  @Test
  @DisplayName("Test NoResizeByteArrayFIFODeque removeFirstByte(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NoResizeByteArrayFIFODeque.removeFirstByte()"})
  void testNoResizeByteArrayFIFODequeRemoveFirstByte_thenReturnZero() {
    // Arrange
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = new NoResizeByteArrayFIFODeque();

    // Act and Assert
    assertEquals((byte) 0, noResizeByteArrayFIFODeque.removeFirstByte());
    assertEquals(4, noResizeByteArrayFIFODeque.size());
    assertFalse(noResizeByteArrayFIFODeque.isEmpty());
  }

  /**
   * Test NoResizeLongArrayFIFODeque new {@link NoResizeLongArrayFIFODeque} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * NoResizeLongArrayFIFODeque}
   */
  @Test
  @DisplayName(
      "Test NoResizeLongArrayFIFODeque new NoResizeLongArrayFIFODeque (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NoResizeLongArrayFIFODeque.<init>()"})
  void testNoResizeLongArrayFIFODequeNewNoResizeLongArrayFIFODeque() {
    // Arrange and Act
    NoResizeLongArrayFIFODeque actualNoResizeLongArrayFIFODeque = new NoResizeLongArrayFIFODeque();

    // Assert
    assertNull(actualNoResizeLongArrayFIFODeque.comparator());
    assertEquals(0, actualNoResizeLongArrayFIFODeque.size());
    assertTrue(actualNoResizeLongArrayFIFODeque.isEmpty());
  }

  /**
   * Test NoResizeLongArrayFIFODeque {@link NoResizeLongArrayFIFODeque#removeFirstLong()}.
   *
   * <p>Method under test: {@link NoResizeLongArrayFIFODeque#removeFirstLong()}
   */
  @Test
  @DisplayName("Test NoResizeLongArrayFIFODeque removeFirstLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NoResizeLongArrayFIFODeque.removeFirstLong()"})
  void testNoResizeLongArrayFIFODequeRemoveFirstLong() {
    // Arrange
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = new NoResizeLongArrayFIFODeque();
    noResizeLongArrayFIFODeque.enqueueFirst(1L);

    // Act
    long actualRemoveFirstLongResult = noResizeLongArrayFIFODeque.removeFirstLong();

    // Assert
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertEquals(1L, actualRemoveFirstLongResult);
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
  }

  /**
   * Test NoResizeLongArrayFIFODeque {@link NoResizeLongArrayFIFODeque#removeFirstLong()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoResizeLongArrayFIFODeque#removeFirstLong()}
   */
  @Test
  @DisplayName("Test NoResizeLongArrayFIFODeque removeFirstLong(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NoResizeLongArrayFIFODeque.removeFirstLong()"})
  void testNoResizeLongArrayFIFODequeRemoveFirstLong_thenReturnZero() {
    // Arrange
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = new NoResizeLongArrayFIFODeque();

    // Act and Assert
    assertEquals(0L, noResizeLongArrayFIFODeque.removeFirstLong());
    assertEquals(4, noResizeLongArrayFIFODeque.size());
    assertFalse(noResizeLongArrayFIFODeque.isEmpty());
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#setSource(long, int)} with {@code coordinate},
   * {@code level}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#setSource(long, int)}
   */
  @Test
  @DisplayName("Test setSource(long, int) with 'coordinate', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.setSource(long, int)"})
  void testSetSourceWithCoordinateLevel() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.setSource(1L, 1);

    // Assert
    Long2ByteOpenHashMap long2ByteOpenHashMap = delayed8WayDistancePropagator2D.sources;
    assertEquals(1, long2ByteOpenHashMap.size());
    assertEquals(1, delayed8WayDistancePropagator2D.updatedSources.size());
    assertEquals((byte) 1, long2ByteOpenHashMap.get((Object) 1L).byteValue());
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#setSource(long, int)} with {@code coordinate},
   * {@code level}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#setSource(long, int)}
   */
  @Test
  @DisplayName("Test setSource(long, int) with 'coordinate', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.setSource(long, int)"})
  void testSetSourceWithCoordinateLevel2() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.setSource(0L, 1);

    // Assert
    Long2ByteOpenHashMap long2ByteOpenHashMap = delayed8WayDistancePropagator2D.sources;
    assertEquals(1, long2ByteOpenHashMap.size());
    assertEquals(1, delayed8WayDistancePropagator2D.updatedSources.size());
    assertEquals((byte) 1, long2ByteOpenHashMap.get((Object) 0L).byteValue());
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#setSource(long, int)} with {@code coordinate},
   * {@code level}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#setSource(long, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(long, int) with 'coordinate', 'level'; when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.setSource(long, int)"})
  void testSetSourceWithCoordinateLevel_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Delayed8WayDistancePropagator2D().setSource(1L, -1));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#setSource(long, int)} with {@code coordinate},
   * {@code level}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#setSource(long, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(long, int) with 'coordinate', 'level'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.setSource(long, int)"})
  void testSetSourceWithCoordinateLevel_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Delayed8WayDistancePropagator2D().setSource(1L, 0));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#setSource(int, int, int)} with {@code x}, {@code
   * z}, {@code level}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#setSource(int, int, int)}
   */
  @Test
  @DisplayName("Test setSource(int, int, int) with 'x', 'z', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.setSource(int, int, int)"})
  void testSetSourceWithXZLevel() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.setSource(2, 1, 1);

    // Assert
    Long2ByteOpenHashMap long2ByteOpenHashMap = delayed8WayDistancePropagator2D.sources;
    assertEquals(1, long2ByteOpenHashMap.size());
    assertEquals(1, delayed8WayDistancePropagator2D.updatedSources.size());
    assertEquals((byte) 1, long2ByteOpenHashMap.get((Object) 4294967298L).byteValue());
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#setSource(int, int, int)} with {@code x}, {@code
   * z}, {@code level}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#setSource(int, int, int)}
   */
  @Test
  @DisplayName("Test setSource(int, int, int) with 'x', 'z', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.setSource(int, int, int)"})
  void testSetSourceWithXZLevel2() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.setSource(0, 0, 1);

    // Assert
    Long2ByteOpenHashMap long2ByteOpenHashMap = delayed8WayDistancePropagator2D.sources;
    assertEquals(1, long2ByteOpenHashMap.size());
    assertEquals(1, delayed8WayDistancePropagator2D.updatedSources.size());
    assertEquals((byte) 1, long2ByteOpenHashMap.get((Object) 0L).byteValue());
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#setSource(int, int, int)} with {@code x}, {@code
   * z}, {@code level}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#setSource(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(int, int, int) with 'x', 'z', 'level'; when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.setSource(int, int, int)"})
  void testSetSourceWithXZLevel_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Delayed8WayDistancePropagator2D().setSource(2, 1, -1));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#setSource(int, int, int)} with {@code x}, {@code
   * z}, {@code level}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#setSource(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(int, int, int) with 'x', 'z', 'level'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.setSource(int, int, int)"})
  void testSetSourceWithXZLevel_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Delayed8WayDistancePropagator2D().setSource(2, 1, 0));
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#addToIncreaseWorkQueue(long, byte, byte)} with
   * {@code coordinate}, {@code index}, {@code level}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#addToIncreaseWorkQueue(long, byte,
   * byte)}
   */
  @Test
  @DisplayName("Test addToIncreaseWorkQueue(long, byte, byte) with 'coordinate', 'index', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(long, byte, byte)"
  })
  void testAddToIncreaseWorkQueueWithCoordinateIndexLevel() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(1L, (byte) 0, (byte) 'A');

    // Assert
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[0];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(1, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(1, noResizeLongArrayFIFODeque.size());
    assertEquals(1L, delayed8WayDistancePropagator2D.levelIncreaseWorkQueueBitset);
    assertFalse(noResizeLongArrayFIFODeque.isEmpty());
    assertFalse(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#addToIncreaseWorkQueue(long, byte)} with {@code
   * coordinate}, {@code level}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#addToIncreaseWorkQueue(long,
   * byte)}
   */
  @Test
  @DisplayName("Test addToIncreaseWorkQueue(long, byte) with 'coordinate', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(long, byte)"})
  void testAddToIncreaseWorkQueueWithCoordinateLevel() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(1L, (byte) 0);

    // Assert
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[0];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(1, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(1, noResizeLongArrayFIFODeque.size());
    assertEquals(1L, delayed8WayDistancePropagator2D.levelIncreaseWorkQueueBitset);
    assertFalse(noResizeLongArrayFIFODeque.isEmpty());
    assertFalse(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#addToRemoveWorkQueue(long, byte)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then first element {@link WorkQueue#queuedLevels} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#addToRemoveWorkQueue(long, byte)}
   */
  @Test
  @DisplayName(
      "Test addToRemoveWorkQueue(long, byte); when zero; then first element queuedLevels size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.addToRemoveWorkQueue(long, byte)"})
  void testAddToRemoveWorkQueue_whenZero_thenFirstElementQueuedLevelsSizeIsOne() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.addToRemoveWorkQueue(1L, (byte) 0);

    // Assert
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelRemoveWorkQueues;
    WorkQueue workQueue = workQueueArray[0];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(1, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(1, noResizeLongArrayFIFODeque.size());
    assertEquals(1L, delayed8WayDistancePropagator2D.levelRemoveWorkQueueBitset);
    assertFalse(noResizeLongArrayFIFODeque.isEmpty());
    assertFalse(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateUpdates()}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateUpdates()}
   */
  @Test
  @DisplayName("Test propagateUpdates()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Delayed8WayDistancePropagator2D.propagateUpdates()"})
  void testPropagateUpdates() {
    // Arrange, Act and Assert
    assertFalse(new Delayed8WayDistancePropagator2D().propagateUpdates());
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateIncreases()}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateIncreases()}
   */
  @Test
  @DisplayName("Test propagateIncreases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateIncreases()"})
  void testPropagateIncreases() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doNothing().when(changeCallback).onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D(changeCallback);
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(63L, (byte) 1);

    // Act
    delayed8WayDistancePropagator2D.propagateIncreases();

    // Assert
    verify(changeCallback).onLevelUpdate(63L, (byte) 0, (byte) 1);
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed8WayDistancePropagator2D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 63L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateIncreases()}.
   *
   * <ul>
   *   <li>Then {@link Delayed8WayDistancePropagator2D#Delayed8WayDistancePropagator2D()} {@link
   *       Delayed8WayDistancePropagator2D#levels} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateIncreases()}
   */
  @Test
  @DisplayName("Test propagateIncreases(); then Delayed8WayDistancePropagator2D() levels Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateIncreases()"})
  void testPropagateIncreases_thenDelayed8WayDistancePropagator2DLevelsEmpty() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.propagateIncreases();

    // Assert that nothing has changed
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertTrue(delayed8WayDistancePropagator2D.levels.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateIncreases()}.
   *
   * <ul>
   *   <li>Then {@link Delayed8WayDistancePropagator2D#Delayed8WayDistancePropagator2D()} {@link
   *       Delayed8WayDistancePropagator2D#levels} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateIncreases()}
   */
  @Test
  @DisplayName(
      "Test propagateIncreases(); then Delayed8WayDistancePropagator2D() levels size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateIncreases()"})
  void testPropagateIncreases_thenDelayed8WayDistancePropagator2DLevelsSizeIsOne() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(63L, (byte) 1);

    // Act
    delayed8WayDistancePropagator2D.propagateIncreases();

    // Assert
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed8WayDistancePropagator2D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 63L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateIncreases()}.
   *
   * <ul>
   *   <li>Then first element {@link WorkQueue#queuedLevels} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateIncreases()}
   */
  @Test
  @DisplayName("Test propagateIncreases(); then first element queuedLevels size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateIncreases()"})
  void testPropagateIncreases_thenFirstElementQueuedLevelsSizeIsZero() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D(mock(LevelChangeCallback.class));
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(63L, (byte) 0);

    // Act
    delayed8WayDistancePropagator2D.propagateIncreases();

    // Assert
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[0];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateIncreases()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateIncreases()}
   */
  @Test
  @DisplayName("Test propagateIncreases(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateIncreases()"})
  void testPropagateIncreases_thenThrowIllegalArgumentException() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doThrow(new IllegalArgumentException())
        .when(changeCallback)
        .onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D(changeCallback);
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(63L, (byte) '?');

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> delayed8WayDistancePropagator2D.propagateIncreases());
    verify(changeCallback).onLevelUpdate(63L, (byte) 0, (byte) 63);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateDecreases()}.
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateDecreases()"})
  void testPropagateDecreases() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doNothing().when(changeCallback).onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D(changeCallback);
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(63L, (byte) 1);

    // Act
    delayed8WayDistancePropagator2D.propagateDecreases();

    // Assert
    verify(changeCallback).onLevelUpdate(63L, (byte) 0, (byte) 1);
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed8WayDistancePropagator2D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 63L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then {@link Delayed8WayDistancePropagator2D#Delayed8WayDistancePropagator2D()} {@link
   *       Delayed8WayDistancePropagator2D#levels} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases(); then Delayed8WayDistancePropagator2D() levels Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateDecreases()"})
  void testPropagateDecreases_thenDelayed8WayDistancePropagator2DLevelsEmpty() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();

    // Act
    delayed8WayDistancePropagator2D.propagateDecreases();

    // Assert that nothing has changed
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertTrue(delayed8WayDistancePropagator2D.levels.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then {@link Delayed8WayDistancePropagator2D#Delayed8WayDistancePropagator2D()} {@link
   *       Delayed8WayDistancePropagator2D#levels} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateDecreases()}
   */
  @Test
  @DisplayName(
      "Test propagateDecreases(); then Delayed8WayDistancePropagator2D() levels size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateDecreases()"})
  void testPropagateDecreases_thenDelayed8WayDistancePropagator2DLevelsSizeIsOne() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(63L, (byte) 1);

    // Act
    delayed8WayDistancePropagator2D.propagateDecreases();

    // Assert
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed8WayDistancePropagator2D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 63L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then first element {@link WorkQueue#queuedLevels} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases(); then first element queuedLevels size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateDecreases()"})
  void testPropagateDecreases_thenFirstElementQueuedLevelsSizeIsZero() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D(mock(LevelChangeCallback.class));
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(63L, (byte) 0);

    // Act
    delayed8WayDistancePropagator2D.propagateDecreases();

    // Assert
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[0];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then sixty-fourth element {@link WorkQueue#queuedLevels} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases(); then sixty-fourth element queuedLevels size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateDecreases()"})
  void testPropagateDecreases_thenSixtyFourthElementQueuedLevelsSizeIsZero() {
    // Arrange
    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D();
    delayed8WayDistancePropagator2D.addToRemoveWorkQueue(63L, (byte) '?');

    // Act
    delayed8WayDistancePropagator2D.propagateDecreases();

    // Assert
    WorkQueue[] workQueueArray = delayed8WayDistancePropagator2D.levelRemoveWorkQueues;
    WorkQueue workQueue = workQueueArray[63];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertEquals(0L, delayed8WayDistancePropagator2D.levelRemoveWorkQueueBitset);
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed8WayDistancePropagator2D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed8WayDistancePropagator2D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed8WayDistancePropagator2D.propagateDecreases()"})
  void testPropagateDecreases_thenThrowIllegalArgumentException() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doThrow(new IllegalArgumentException())
        .when(changeCallback)
        .onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed8WayDistancePropagator2D delayed8WayDistancePropagator2D =
        new Delayed8WayDistancePropagator2D(changeCallback);
    delayed8WayDistancePropagator2D.addToIncreaseWorkQueue(63L, (byte) '?');

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> delayed8WayDistancePropagator2D.propagateDecreases());
    verify(changeCallback).onLevelUpdate(63L, (byte) 0, (byte) 63);
  }

  /**
   * Test WorkQueue new {@link WorkQueue} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link WorkQueue}
   */
  @Test
  @DisplayName("Test WorkQueue new WorkQueue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorkQueue.<init>()"})
  void testWorkQueueNewWorkQueue() {
    // Arrange and Act
    WorkQueue actualWorkQueue = new WorkQueue();

    // Assert
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = actualWorkQueue.queuedLevels;
    assertNull(noResizeByteArrayFIFODeque.comparator());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = actualWorkQueue.queuedCoordinates;
    assertNull(noResizeLongArrayFIFODeque.comparator());
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
  }
}
