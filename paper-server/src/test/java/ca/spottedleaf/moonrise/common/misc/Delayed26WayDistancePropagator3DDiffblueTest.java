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
import ca.spottedleaf.moonrise.common.misc.Delayed26WayDistancePropagator3D.LevelChangeCallback;
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

class Delayed26WayDistancePropagator3DDiffblueTest {
  /**
   * Test {@link Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D()}.
   *
   * <p>Method under test: {@link
   * Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D()}
   */
  @Test
  @DisplayName("Test new Delayed26WayDistancePropagator3D()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.<init>()"})
  void testNewDelayed26WayDistancePropagator3D() {
    // Arrange and Act
    Delayed26WayDistancePropagator3D actualDelayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Assert
    assertNull(actualDelayed26WayDistancePropagator3D.changeCallback);
    assertEquals(0L, actualDelayed26WayDistancePropagator3D.levelIncreaseWorkQueueBitset);
    assertEquals(0L, actualDelayed26WayDistancePropagator3D.levelRemoveWorkQueueBitset);
    assertTrue(actualDelayed26WayDistancePropagator3D.levels.isEmpty());
    assertTrue(actualDelayed26WayDistancePropagator3D.sources.isEmpty());
    assertTrue(actualDelayed26WayDistancePropagator3D.updatedSources.isEmpty());
    assertEquals(
        Double.SIZE, actualDelayed26WayDistancePropagator3D.levelIncreaseWorkQueues.length);
    assertEquals(Double.SIZE, actualDelayed26WayDistancePropagator3D.levelRemoveWorkQueues.length);
  }

  /**
   * Test {@link
   * Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D(LevelChangeCallback)}.
   *
   * <p>Method under test: {@link
   * Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D(LevelChangeCallback)}
   */
  @Test
  @DisplayName("Test new Delayed26WayDistancePropagator3D(LevelChangeCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.<init>(LevelChangeCallback)"})
  void testNewDelayed26WayDistancePropagator3D2() {
    // Arrange and Act
    Delayed26WayDistancePropagator3D actualDelayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D(mock(LevelChangeCallback.class));

    // Assert
    assertEquals(0L, actualDelayed26WayDistancePropagator3D.levelIncreaseWorkQueueBitset);
    assertEquals(0L, actualDelayed26WayDistancePropagator3D.levelRemoveWorkQueueBitset);
    assertTrue(actualDelayed26WayDistancePropagator3D.levels.isEmpty());
    assertTrue(actualDelayed26WayDistancePropagator3D.sources.isEmpty());
    assertTrue(actualDelayed26WayDistancePropagator3D.updatedSources.isEmpty());
    assertEquals(
        Double.SIZE, actualDelayed26WayDistancePropagator3D.levelIncreaseWorkQueues.length);
    assertEquals(Double.SIZE, actualDelayed26WayDistancePropagator3D.levelRemoveWorkQueues.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#getLevel(long)} with {@code pos}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#getLevel(long)}
   */
  @Test
  @DisplayName("Test getLevel(long) with 'pos'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed26WayDistancePropagator3D.getLevel(long)"})
  void testGetLevelWithPos_whenOne() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed26WayDistancePropagator3D().getLevel(1L));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#getLevel(long)} with {@code pos}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#getLevel(long)}
   */
  @Test
  @DisplayName("Test getLevel(long) with 'pos'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed26WayDistancePropagator3D.getLevel(long)"})
  void testGetLevelWithPos_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed26WayDistancePropagator3D().getLevel(0L));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#getLevel(int, int, int)} with {@code x}, {@code
   * y}, {@code z}.
   *
   * <ul>
   *   <li>When {@code 1048575}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#getLevel(int, int, int)}
   */
  @Test
  @DisplayName("Test getLevel(int, int, int) with 'x', 'y', 'z'; when '1048575'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed26WayDistancePropagator3D.getLevel(int, int, int)"})
  void testGetLevelWithXYZ_when1048575() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed26WayDistancePropagator3D().getLevel(1048575, 3, 3));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#getLevel(int, int, int)} with {@code x}, {@code
   * y}, {@code z}.
   *
   * <ul>
   *   <li>When {@code 4194303}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#getLevel(int, int, int)}
   */
  @Test
  @DisplayName("Test getLevel(int, int, int) with 'x', 'y', 'z'; when '4194303'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed26WayDistancePropagator3D.getLevel(int, int, int)"})
  void testGetLevelWithXYZ_when4194303() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed26WayDistancePropagator3D().getLevel(4194303, 3, 3));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#getLevel(int, int, int)} with {@code x}, {@code
   * y}, {@code z}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#getLevel(int, int, int)}
   */
  @Test
  @DisplayName("Test getLevel(int, int, int) with 'x', 'y', 'z'; when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed26WayDistancePropagator3D.getLevel(int, int, int)"})
  void testGetLevelWithXYZ_whenFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed26WayDistancePropagator3D().getLevel(42, 3, 3));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#getLevel(int, int, int)} with {@code x}, {@code
   * y}, {@code z}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#getLevel(int, int, int)}
   */
  @Test
  @DisplayName("Test getLevel(int, int, int) with 'x', 'y', 'z'; when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Delayed26WayDistancePropagator3D.getLevel(int, int, int)"})
  void testGetLevelWithXYZ_whenTwo() {
    // Arrange, Act and Assert
    assertEquals(0, new Delayed26WayDistancePropagator3D().getLevel(2, 3, 3));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#setSource(long, int)} with {@code coordinate},
   * {@code level}.
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#setSource(long, int)}
   */
  @Test
  @DisplayName("Test setSource(long, int) with 'coordinate', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.setSource(long, int)"})
  void testSetSourceWithCoordinateLevel() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Act
    delayed26WayDistancePropagator3D.setSource(1L, 1);

    // Assert
    Long2ByteOpenHashMap long2ByteOpenHashMap = delayed26WayDistancePropagator3D.sources;
    assertEquals(1, long2ByteOpenHashMap.size());
    assertEquals(1, delayed26WayDistancePropagator3D.updatedSources.size());
    assertEquals((byte) 1, long2ByteOpenHashMap.get((Object) 1L).byteValue());
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#setSource(long, int)} with {@code coordinate},
   * {@code level}.
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#setSource(long, int)}
   */
  @Test
  @DisplayName("Test setSource(long, int) with 'coordinate', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.setSource(long, int)"})
  void testSetSourceWithCoordinateLevel2() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Act
    delayed26WayDistancePropagator3D.setSource(0L, 1);

    // Assert
    Long2ByteOpenHashMap long2ByteOpenHashMap = delayed26WayDistancePropagator3D.sources;
    assertEquals(1, long2ByteOpenHashMap.size());
    assertEquals(1, delayed26WayDistancePropagator3D.updatedSources.size());
    assertEquals((byte) 1, long2ByteOpenHashMap.get((Object) 0L).byteValue());
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#setSource(long, int)} with {@code coordinate},
   * {@code level}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#setSource(long, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(long, int) with 'coordinate', 'level'; when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.setSource(long, int)"})
  void testSetSourceWithCoordinateLevel_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Delayed26WayDistancePropagator3D().setSource(1L, -1));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#setSource(long, int)} with {@code coordinate},
   * {@code level}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#setSource(long, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(long, int) with 'coordinate', 'level'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.setSource(long, int)"})
  void testSetSourceWithCoordinateLevel_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Delayed26WayDistancePropagator3D().setSource(1L, 0));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#setSource(int, int, int, int)} with {@code x},
   * {@code y}, {@code z}, {@code level}.
   *
   * <ul>
   *   <li>Then {@link Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D()} {@link
   *       Delayed26WayDistancePropagator3D#sources} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#setSource(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(int, int, int, int) with 'x', 'y', 'z', 'level'; then Delayed26WayDistancePropagator3D() sources size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.setSource(int, int, int, int)"})
  void testSetSourceWithXYZLevel_thenDelayed26WayDistancePropagator3DSourcesSizeIsOne() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Act
    delayed26WayDistancePropagator3D.setSource(2, 3, 1, 1);

    // Assert
    Long2ByteOpenHashMap long2ByteOpenHashMap = delayed26WayDistancePropagator3D.sources;
    assertEquals(1, long2ByteOpenHashMap.size());
    assertEquals(1, delayed26WayDistancePropagator3D.updatedSources.size());
    assertEquals((byte) 1, long2ByteOpenHashMap.get((Object) 8796094070787L).byteValue());
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#setSource(int, int, int, int)} with {@code x},
   * {@code y}, {@code z}, {@code level}.
   *
   * <ul>
   *   <li>When {@code 4194303}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#setSource(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(int, int, int, int) with 'x', 'y', 'z', 'level'; when '4194303'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.setSource(int, int, int, int)"})
  void testSetSourceWithXYZLevel_when4194303_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Delayed26WayDistancePropagator3D().setSource(2, 3, 1, 4194303));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#setSource(int, int, int, int)} with {@code x},
   * {@code y}, {@code z}, {@code level}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#setSource(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setSource(int, int, int, int) with 'x', 'y', 'z', 'level'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.setSource(int, int, int, int)"})
  void testSetSourceWithXYZLevel_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Delayed26WayDistancePropagator3D().setSource(2, 3, 1, 0));
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#addToIncreaseWorkQueue(long, byte, byte)} with
   * {@code coordinate}, {@code index}, {@code level}.
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#addToIncreaseWorkQueue(long,
   * byte, byte)}
   */
  @Test
  @DisplayName("Test addToIncreaseWorkQueue(long, byte, byte) with 'coordinate', 'index', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(long, byte, byte)"
  })
  void testAddToIncreaseWorkQueueWithCoordinateIndexLevel() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Act
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(1L, (byte) 0, (byte) 'A');

    // Assert
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[0];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(1, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(1, noResizeLongArrayFIFODeque.size());
    assertEquals(1L, delayed26WayDistancePropagator3D.levelIncreaseWorkQueueBitset);
    assertFalse(noResizeLongArrayFIFODeque.isEmpty());
    assertFalse(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#addToIncreaseWorkQueue(long, byte)} with {@code
   * coordinate}, {@code level}.
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#addToIncreaseWorkQueue(long,
   * byte)}
   */
  @Test
  @DisplayName("Test addToIncreaseWorkQueue(long, byte) with 'coordinate', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(long, byte)"})
  void testAddToIncreaseWorkQueueWithCoordinateLevel() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Act
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(1L, (byte) 0);

    // Assert
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[0];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(1, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(1, noResizeLongArrayFIFODeque.size());
    assertEquals(1L, delayed26WayDistancePropagator3D.levelIncreaseWorkQueueBitset);
    assertFalse(noResizeLongArrayFIFODeque.isEmpty());
    assertFalse(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#addToRemoveWorkQueue(long, byte)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then first element {@link WorkQueue#queuedLevels} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#addToRemoveWorkQueue(long, byte)}
   */
  @Test
  @DisplayName(
      "Test addToRemoveWorkQueue(long, byte); when zero; then first element queuedLevels size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.addToRemoveWorkQueue(long, byte)"})
  void testAddToRemoveWorkQueue_whenZero_thenFirstElementQueuedLevelsSizeIsOne() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Act
    delayed26WayDistancePropagator3D.addToRemoveWorkQueue(1L, (byte) 0);

    // Assert
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelRemoveWorkQueues;
    WorkQueue workQueue = workQueueArray[0];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(1, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(1, noResizeLongArrayFIFODeque.size());
    assertEquals(1L, delayed26WayDistancePropagator3D.levelRemoveWorkQueueBitset);
    assertFalse(noResizeLongArrayFIFODeque.isEmpty());
    assertFalse(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateUpdates()}.
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateUpdates()}
   */
  @Test
  @DisplayName("Test propagateUpdates()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Delayed26WayDistancePropagator3D.propagateUpdates()"})
  void testPropagateUpdates() {
    // Arrange, Act and Assert
    assertFalse(new Delayed26WayDistancePropagator3D().propagateUpdates());
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateIncreases()}.
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateIncreases()}
   */
  @Test
  @DisplayName("Test propagateIncreases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateIncreases()"})
  void testPropagateIncreases() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doNothing().when(changeCallback).onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D(changeCallback);
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(63L, (byte) 1);

    // Act
    delayed26WayDistancePropagator3D.propagateIncreases();

    // Assert
    verify(changeCallback).onLevelUpdate(63L, (byte) 0, (byte) 1);
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed26WayDistancePropagator3D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 63L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateIncreases()}.
   *
   * <ul>
   *   <li>Then {@link Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D()} {@link
   *       Delayed26WayDistancePropagator3D#levels} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateIncreases()}
   */
  @Test
  @DisplayName("Test propagateIncreases(); then Delayed26WayDistancePropagator3D() levels Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateIncreases()"})
  void testPropagateIncreases_thenDelayed26WayDistancePropagator3DLevelsEmpty() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Act
    delayed26WayDistancePropagator3D.propagateIncreases();

    // Assert that nothing has changed
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertTrue(delayed26WayDistancePropagator3D.levels.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateIncreases()}.
   *
   * <ul>
   *   <li>Then {@link Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D()} {@link
   *       Delayed26WayDistancePropagator3D#levels} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateIncreases()}
   */
  @Test
  @DisplayName(
      "Test propagateIncreases(); then Delayed26WayDistancePropagator3D() levels size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateIncreases()"})
  void testPropagateIncreases_thenDelayed26WayDistancePropagator3DLevelsSizeIsOne() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(63L, (byte) 1);

    // Act
    delayed26WayDistancePropagator3D.propagateIncreases();

    // Assert
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed26WayDistancePropagator3D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 63L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateIncreases()}.
   *
   * <ul>
   *   <li>Then first element {@link WorkQueue#queuedLevels} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateIncreases()}
   */
  @Test
  @DisplayName("Test propagateIncreases(); then first element queuedLevels size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateIncreases()"})
  void testPropagateIncreases_thenFirstElementQueuedLevelsSizeIsZero() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D(mock(LevelChangeCallback.class));
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(63L, (byte) 0);

    // Act
    delayed26WayDistancePropagator3D.propagateIncreases();

    // Assert
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
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
   * Test {@link Delayed26WayDistancePropagator3D#propagateIncreases()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateIncreases()}
   */
  @Test
  @DisplayName("Test propagateIncreases(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateIncreases()"})
  void testPropagateIncreases_thenThrowIllegalArgumentException() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doThrow(new IllegalArgumentException())
        .when(changeCallback)
        .onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D(changeCallback);
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(63L, (byte) '?');

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> delayed26WayDistancePropagator3D.propagateIncreases());
    verify(changeCallback).onLevelUpdate(63L, (byte) 0, (byte) 63);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateDecreases()}.
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateDecreases()"})
  void testPropagateDecreases() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doNothing().when(changeCallback).onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D(changeCallback);
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(63L, (byte) 1);

    // Act
    delayed26WayDistancePropagator3D.propagateDecreases();

    // Assert
    verify(changeCallback).onLevelUpdate(63L, (byte) 0, (byte) 1);
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed26WayDistancePropagator3D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 63L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateDecreases()}.
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateDecreases()"})
  void testPropagateDecreases2() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doNothing().when(changeCallback).onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D(changeCallback);
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(0L, (byte) 1);

    // Act
    delayed26WayDistancePropagator3D.propagateDecreases();

    // Assert
    verify(changeCallback).onLevelUpdate(0L, (byte) 0, (byte) 1);
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed26WayDistancePropagator3D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 0L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then {@link Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D()} {@link
   *       Delayed26WayDistancePropagator3D#levels} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases(); then Delayed26WayDistancePropagator3D() levels Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateDecreases()"})
  void testPropagateDecreases_thenDelayed26WayDistancePropagator3DLevelsEmpty() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();

    // Act
    delayed26WayDistancePropagator3D.propagateDecreases();

    // Assert that nothing has changed
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertTrue(delayed26WayDistancePropagator3D.levels.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then {@link Delayed26WayDistancePropagator3D#Delayed26WayDistancePropagator3D()} {@link
   *       Delayed26WayDistancePropagator3D#levels} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateDecreases()}
   */
  @Test
  @DisplayName(
      "Test propagateDecreases(); then Delayed26WayDistancePropagator3D() levels size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateDecreases()"})
  void testPropagateDecreases_thenDelayed26WayDistancePropagator3DLevelsSizeIsOne() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(63L, (byte) 1);

    // Act
    delayed26WayDistancePropagator3D.propagateDecreases();

    // Assert
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
    WorkQueue workQueue = workQueueArray[1];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    LevelMap levelMap = delayed26WayDistancePropagator3D.levels;
    assertEquals(1, levelMap.size());
    assertEquals((byte) 1, levelMap.get((Object) 63L).byteValue());
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then first element {@link WorkQueue#queuedLevels} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases(); then first element queuedLevels size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateDecreases()"})
  void testPropagateDecreases_thenFirstElementQueuedLevelsSizeIsZero() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D(mock(LevelChangeCallback.class));
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(63L, (byte) 0);

    // Act
    delayed26WayDistancePropagator3D.propagateDecreases();

    // Assert
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelIncreaseWorkQueues;
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
   * Test {@link Delayed26WayDistancePropagator3D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then sixty-fourth element {@link WorkQueue#queuedLevels} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases(); then sixty-fourth element queuedLevels size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateDecreases()"})
  void testPropagateDecreases_thenSixtyFourthElementQueuedLevelsSizeIsZero() {
    // Arrange
    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D();
    delayed26WayDistancePropagator3D.addToRemoveWorkQueue(63L, (byte) '?');

    // Act
    delayed26WayDistancePropagator3D.propagateDecreases();

    // Assert
    WorkQueue[] workQueueArray = delayed26WayDistancePropagator3D.levelRemoveWorkQueues;
    WorkQueue workQueue = workQueueArray[63];
    NoResizeByteArrayFIFODeque noResizeByteArrayFIFODeque = workQueue.queuedLevels;
    assertEquals(0, noResizeByteArrayFIFODeque.size());
    NoResizeLongArrayFIFODeque noResizeLongArrayFIFODeque = workQueue.queuedCoordinates;
    assertEquals(0, noResizeLongArrayFIFODeque.size());
    assertEquals(0L, delayed26WayDistancePropagator3D.levelRemoveWorkQueueBitset);
    assertTrue(noResizeLongArrayFIFODeque.isEmpty());
    assertTrue(noResizeByteArrayFIFODeque.isEmpty());
    assertEquals(Double.SIZE, workQueueArray.length);
  }

  /**
   * Test {@link Delayed26WayDistancePropagator3D#propagateDecreases()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Delayed26WayDistancePropagator3D#propagateDecreases()}
   */
  @Test
  @DisplayName("Test propagateDecreases(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Delayed26WayDistancePropagator3D.propagateDecreases()"})
  void testPropagateDecreases_thenThrowIllegalArgumentException() {
    // Arrange
    LevelChangeCallback changeCallback = mock(LevelChangeCallback.class);
    doThrow(new IllegalArgumentException())
        .when(changeCallback)
        .onLevelUpdate(anyLong(), anyByte(), anyByte());

    Delayed26WayDistancePropagator3D delayed26WayDistancePropagator3D =
        new Delayed26WayDistancePropagator3D(changeCallback);
    delayed26WayDistancePropagator3D.addToIncreaseWorkQueue(63L, (byte) '?');

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> delayed26WayDistancePropagator3D.propagateDecreases());
    verify(changeCallback).onLevelUpdate(63L, (byte) 0, (byte) 63);
  }
}
