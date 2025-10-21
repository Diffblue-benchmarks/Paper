package ca.spottedleaf.moonrise.patches.chunk_system.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.patches.chunk_system.queue.ChunkUnloadQueue.SectionToUnload;
import ca.spottedleaf.moonrise.patches.chunk_system.queue.ChunkUnloadQueue.UnloadSection;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChunkUnloadQueueDiffblueTest {
  /**
   * Test {@link ChunkUnloadQueue#ChunkUnloadQueue(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link ChunkUnloadQueue#coordinateShift} is one.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#ChunkUnloadQueue(int)}
   */
  @Test
  @DisplayName("Test new ChunkUnloadQueue(int); when one; then return coordinateShift is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkUnloadQueue.<init>(int)"})
  void testNewChunkUnloadQueue_whenOne_thenReturnCoordinateShiftIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, new ChunkUnloadQueue(1).coordinateShift);
  }

  /**
   * Test {@link ChunkUnloadQueue#ChunkUnloadQueue(int)}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@link ChunkUnloadQueue#coordinateShift} is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#ChunkUnloadQueue(int)}
   */
  @Test
  @DisplayName("Test new ChunkUnloadQueue(int); when SIZE; then return coordinateShift is SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkUnloadQueue.<init>(int)"})
  void testNewChunkUnloadQueue_whenSize_thenReturnCoordinateShiftIsSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, new ChunkUnloadQueue(Short.SIZE).coordinateShift);
  }

  /**
   * Test {@link ChunkUnloadQueue#retrieveForAllRegions()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#retrieveForAllRegions()}
   */
  @Test
  @DisplayName("Test retrieveForAllRegions(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChunkUnloadQueue.retrieveForAllRegions()"})
  void testRetrieveForAllRegions_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ChunkUnloadQueue(1).retrieveForAllRegions().isEmpty());
  }

  /**
   * Test {@link ChunkUnloadQueue#retrieveForAllRegions()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#retrieveForAllRegions()}
   */
  @Test
  @DisplayName("Test retrieveForAllRegions(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChunkUnloadQueue.retrieveForAllRegions()"})
  void testRetrieveForAllRegions_thenReturnSizeIsOne() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act
    List<SectionToUnload> actualRetrieveForAllRegionsResult =
        chunkUnloadQueue.retrieveForAllRegions();

    // Assert
    assertEquals(1, actualRetrieveForAllRegionsResult.size());
    SectionToUnload getResult = actualRetrieveForAllRegionsResult.get(0);
    assertEquals(0L, getResult.order());
    assertEquals(1, getResult.count());
    assertEquals(1, getResult.sectionX());
    assertEquals(1, getResult.sectionZ());
  }

  /**
   * Test {@link ChunkUnloadQueue#retrieveForAllRegions()}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#retrieveForAllRegions()}
   */
  @Test
  @DisplayName("Test retrieveForAllRegions(); then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChunkUnloadQueue.retrieveForAllRegions()"})
  void testRetrieveForAllRegions_thenReturnSizeIsThree() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(Short.SIZE, Short.SIZE);
    chunkUnloadQueue.addChunk(1, 1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act
    List<SectionToUnload> actualRetrieveForAllRegionsResult =
        chunkUnloadQueue.retrieveForAllRegions();

    // Assert
    assertEquals(3, actualRetrieveForAllRegionsResult.size());
    SectionToUnload getResult = actualRetrieveForAllRegionsResult.get(1);
    assertEquals(0, getResult.sectionX());
    assertEquals(0, getResult.sectionZ());
    SectionToUnload getResult2 = actualRetrieveForAllRegionsResult.get(2);
    assertEquals(1, getResult2.count());
    assertEquals(1, getResult2.sectionX());
    assertEquals(1, getResult2.sectionZ());
    assertEquals(2L, getResult2.order());
    SectionToUnload getResult3 = actualRetrieveForAllRegionsResult.get(0);
    assertEquals(8, getResult3.sectionX());
    assertEquals(8, getResult3.sectionZ());
  }

  /**
   * Test {@link ChunkUnloadQueue#retrieveForAllRegions()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#retrieveForAllRegions()}
   */
  @Test
  @DisplayName("Test retrieveForAllRegions(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChunkUnloadQueue.retrieveForAllRegions()"})
  void testRetrieveForAllRegions_thenReturnSizeIsTwo() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(1, 1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act
    List<SectionToUnload> actualRetrieveForAllRegionsResult =
        chunkUnloadQueue.retrieveForAllRegions();

    // Assert
    assertEquals(2, actualRetrieveForAllRegionsResult.size());
    SectionToUnload getResult = actualRetrieveForAllRegionsResult.get(0);
    assertEquals(0, getResult.sectionX());
    assertEquals(0, getResult.sectionZ());
    SectionToUnload getResult2 = actualRetrieveForAllRegionsResult.get(1);
    assertEquals(1, getResult2.sectionX());
    assertEquals(1, getResult2.sectionZ());
  }

  /**
   * Test {@link ChunkUnloadQueue#getSectionUnsynchronized(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#getSectionUnsynchronized(int, int)}
   */
  @Test
  @DisplayName("Test getSectionUnsynchronized(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnloadSection ChunkUnloadQueue.getSectionUnsynchronized(int, int)"})
  void testGetSectionUnsynchronized() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act and Assert
    assertNull(chunkUnloadQueue.getSectionUnsynchronized(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#getSectionUnsynchronized(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ChunkUnloadQueue#ChunkUnloadQueue(int)} with coordinateShift is one.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#getSectionUnsynchronized(int, int)}
   */
  @Test
  @DisplayName(
      "Test getSectionUnsynchronized(int, int); given ChunkUnloadQueue(int) with coordinateShift is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnloadSection ChunkUnloadQueue.getSectionUnsynchronized(int, int)"})
  void testGetSectionUnsynchronized_givenChunkUnloadQueueWithCoordinateShiftIsOne() {
    // Arrange, Act and Assert
    assertNull(new ChunkUnloadQueue(1).getSectionUnsynchronized(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#getSectionUnsynchronized(int, int)}.
   *
   * <ul>
   *   <li>Then return {@link UnloadSection#order} is one.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#getSectionUnsynchronized(int, int)}
   */
  @Test
  @DisplayName("Test getSectionUnsynchronized(int, int); then return order is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnloadSection ChunkUnloadQueue.getSectionUnsynchronized(int, int)"})
  void testGetSectionUnsynchronized_thenReturnOrderIsOne() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(Integer.MIN_VALUE, Integer.SIZE);
    chunkUnloadQueue.addChunk(2, 2);

    // Act
    UnloadSection actualSectionUnsynchronized = chunkUnloadQueue.getSectionUnsynchronized(1, 1);

    // Assert
    assertEquals(1, actualSectionUnsynchronized.chunks.size());
    assertEquals(1L, actualSectionUnsynchronized.order);
  }

  /**
   * Test {@link ChunkUnloadQueue#getSectionUnsynchronized(int, int)}.
   *
   * <ul>
   *   <li>Then return {@link UnloadSection#order} is zero.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#getSectionUnsynchronized(int, int)}
   */
  @Test
  @DisplayName("Test getSectionUnsynchronized(int, int); then return order is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnloadSection ChunkUnloadQueue.getSectionUnsynchronized(int, int)"})
  void testGetSectionUnsynchronized_thenReturnOrderIsZero() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act
    UnloadSection actualSectionUnsynchronized = chunkUnloadQueue.getSectionUnsynchronized(1, 1);

    // Assert
    assertEquals(0L, actualSectionUnsynchronized.order);
    assertEquals(1, actualSectionUnsynchronized.chunks.size());
  }

  /**
   * Test {@link ChunkUnloadQueue#removeSection(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeSection(int, int)}
   */
  @Test
  @DisplayName("Test removeSection(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnloadSection ChunkUnloadQueue.removeSection(int, int)"})
  void testRemoveSection() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act and Assert
    assertNull(chunkUnloadQueue.removeSection(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeSection(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ChunkUnloadQueue#ChunkUnloadQueue(int)} with coordinateShift is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeSection(int, int)}
   */
  @Test
  @DisplayName(
      "Test removeSection(int, int); given ChunkUnloadQueue(int) with coordinateShift is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnloadSection ChunkUnloadQueue.removeSection(int, int)"})
  void testRemoveSection_givenChunkUnloadQueueWithCoordinateShiftIsOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ChunkUnloadQueue(1).removeSection(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeSection(int, int)}.
   *
   * <ul>
   *   <li>Then return {@link UnloadSection#order} is one.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeSection(int, int)}
   */
  @Test
  @DisplayName("Test removeSection(int, int); then return order is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnloadSection ChunkUnloadQueue.removeSection(int, int)"})
  void testRemoveSection_thenReturnOrderIsOne() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(Integer.MIN_VALUE, Integer.SIZE);
    chunkUnloadQueue.addChunk(2, 2);

    // Act
    UnloadSection actualRemoveSectionResult = chunkUnloadQueue.removeSection(1, 1);

    // Assert
    assertEquals(1, actualRemoveSectionResult.chunks.size());
    assertEquals(1L, actualRemoveSectionResult.order);
  }

  /**
   * Test {@link ChunkUnloadQueue#removeSection(int, int)}.
   *
   * <ul>
   *   <li>Then return {@link UnloadSection#order} is zero.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeSection(int, int)}
   */
  @Test
  @DisplayName("Test removeSection(int, int); then return order is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnloadSection ChunkUnloadQueue.removeSection(int, int)"})
  void testRemoveSection_thenReturnOrderIsZero() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act
    UnloadSection actualRemoveSectionResult = chunkUnloadQueue.removeSection(1, 1);

    // Assert
    assertEquals(0L, actualRemoveSectionResult.order);
    assertEquals(1, actualRemoveSectionResult.chunks.size());
  }

  /**
   * Test {@link ChunkUnloadQueue#addChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#addChunk(int, int)}
   */
  @Test
  @DisplayName("Test addChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.addChunk(int, int)"})
  void testAddChunk() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(Integer.MIN_VALUE, Integer.SIZE);
    chunkUnloadQueue.addChunk(2, 2);

    // Act and Assert
    assertFalse(chunkUnloadQueue.addChunk(2, 2));
  }

  /**
   * Test {@link ChunkUnloadQueue#addChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#addChunk(int, int)}
   */
  @Test
  @DisplayName("Test addChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.addChunk(int, int)"})
  void testAddChunk2() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(Integer.MIN_VALUE, Integer.SIZE);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2);

    // Act and Assert
    assertTrue(chunkUnloadQueue.addChunk(2, 2));
  }

  /**
   * Test {@link ChunkUnloadQueue#addChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#addChunk(int, int)}
   */
  @Test
  @DisplayName("Test addChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.addChunk(int, int)"})
  void testAddChunk3() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(Integer.MIN_VALUE, Integer.SIZE);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2);

    // Act and Assert
    assertTrue(chunkUnloadQueue.addChunk(2135587861, 2));
  }

  /**
   * Test {@link ChunkUnloadQueue#addChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#addChunk(int, int)}
   */
  @Test
  @DisplayName("Test addChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.addChunk(int, int)"})
  void testAddChunk4() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(2, Integer.SIZE);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2);

    // Act and Assert
    assertTrue(chunkUnloadQueue.addChunk(2135587861, 2));
  }

  /**
   * Test {@link ChunkUnloadQueue#addChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#addChunk(int, int)}
   */
  @Test
  @DisplayName("Test addChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.addChunk(int, int)"})
  void testAddChunk5() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(2, Integer.SIZE);
    chunkUnloadQueue.addChunk(2135587861, 2);

    // Act and Assert
    assertFalse(chunkUnloadQueue.addChunk(2135587861, 2));
  }

  /**
   * Test {@link ChunkUnloadQueue#addChunk(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ChunkUnloadQueue#ChunkUnloadQueue(int)} with coordinateShift is one addChunk
   *       {@link Integer#SIZE} and two.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#addChunk(int, int)}
   */
  @Test
  @DisplayName(
      "Test addChunk(int, int); given ChunkUnloadQueue(int) with coordinateShift is one addChunk SIZE and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.addChunk(int, int)"})
  void testAddChunk_givenChunkUnloadQueueWithCoordinateShiftIsOneAddChunkSizeAndTwo() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(Integer.MIN_VALUE, Integer.SIZE);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2);

    // Act and Assert
    assertTrue(chunkUnloadQueue.addChunk(2, 2));
  }

  /**
   * Test {@link ChunkUnloadQueue#addChunk(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ChunkUnloadQueue#ChunkUnloadQueue(int)} with coordinateShift is one addChunk
   *       two and two.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#addChunk(int, int)}
   */
  @Test
  @DisplayName(
      "Test addChunk(int, int); given ChunkUnloadQueue(int) with coordinateShift is one addChunk two and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.addChunk(int, int)"})
  void testAddChunk_givenChunkUnloadQueueWithCoordinateShiftIsOneAddChunkTwoAndTwo() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act and Assert
    assertFalse(chunkUnloadQueue.addChunk(2, 2));
  }

  /**
   * Test {@link ChunkUnloadQueue#addChunk(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ChunkUnloadQueue#ChunkUnloadQueue(int)} with coordinateShift is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#addChunk(int, int)}
   */
  @Test
  @DisplayName(
      "Test addChunk(int, int); given ChunkUnloadQueue(int) with coordinateShift is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.addChunk(int, int)"})
  void testAddChunk_givenChunkUnloadQueueWithCoordinateShiftIsOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ChunkUnloadQueue(1).addChunk(2, 2));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act and Assert
    assertFalse(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk2() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(1, 2);

    // Act and Assert
    assertFalse(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk3() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(1, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk4() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(Integer.SIZE, Integer.SIZE);
    chunkUnloadQueue.addChunk(1, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk5() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2135587861);
    chunkUnloadQueue.addChunk(1, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk6() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(Integer.SIZE);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2135587861);
    chunkUnloadQueue.addChunk(1, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk7() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(1, 2);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2135587861);
    chunkUnloadQueue.addChunk(1, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk8() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(0, 2135587861);
    chunkUnloadQueue.addChunk(1, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk9() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(1, 1);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2135587861);
    chunkUnloadQueue.addChunk(1, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk10() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(Integer.SIZE, Integer.SIZE);
    chunkUnloadQueue.addChunk(1, 1);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2135587861);
    chunkUnloadQueue.addChunk(1, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk11() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(1, 1);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2135587861);
    chunkUnloadQueue.addChunk(2, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName("Test removeChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk12() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(-1);
    chunkUnloadQueue.addChunk(2, 2);
    chunkUnloadQueue.addChunk(1, 1);
    chunkUnloadQueue.addChunk(Integer.SIZE, 2135587861);
    chunkUnloadQueue.addChunk(2, 1);

    // Act and Assert
    assertTrue(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ChunkUnloadQueue#ChunkUnloadQueue(int)} with coordinateShift is one addChunk
   *       two and two.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName(
      "Test removeChunk(int, int); given ChunkUnloadQueue(int) with coordinateShift is one addChunk two and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk_givenChunkUnloadQueueWithCoordinateShiftIsOneAddChunkTwoAndTwo() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act and Assert
    assertFalse(chunkUnloadQueue.removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#removeChunk(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ChunkUnloadQueue#ChunkUnloadQueue(int)} with coordinateShift is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#removeChunk(int, int)}
   */
  @Test
  @DisplayName(
      "Test removeChunk(int, int); given ChunkUnloadQueue(int) with coordinateShift is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkUnloadQueue.removeChunk(int, int)"})
  void testRemoveChunk_givenChunkUnloadQueueWithCoordinateShiftIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ChunkUnloadQueue(1).removeChunk(1, 1));
  }

  /**
   * Test {@link ChunkUnloadQueue#toDebugJson()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#toDebugJson()}
   */
  @Test
  @DisplayName("Test toDebugJson(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement ChunkUnloadQueue.toDebugJson()"})
  void testToDebugJson_thenReturnSizeIsOne() {
    // Arrange
    ChunkUnloadQueue chunkUnloadQueue = new ChunkUnloadQueue(1);
    chunkUnloadQueue.addChunk(2, 2);

    // Act
    JsonElement actualToDebugJsonResult = chunkUnloadQueue.toDebugJson();

    // Assert
    assertTrue(actualToDebugJsonResult instanceof JsonArray);
    Iterator<JsonElement> iteratorResult = ((JsonArray) actualToDebugJsonResult).iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(1, ((JsonArray) actualToDebugJsonResult).size());
    assertEquals(4, ((JsonObject) nextResult).size());
    assertFalse(((JsonArray) actualToDebugJsonResult).isEmpty());
    assertFalse(nextResult.isJsonArray());
    assertFalse(nextResult.isJsonNull());
    assertFalse(nextResult.isJsonPrimitive());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link ChunkUnloadQueue#toDebugJson()}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ChunkUnloadQueue#toDebugJson()}
   */
  @Test
  @DisplayName("Test toDebugJson(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement ChunkUnloadQueue.toDebugJson()"})
  void testToDebugJson_thenReturnSizeIsZero() {
    // Arrange and Act
    JsonElement actualToDebugJsonResult = new ChunkUnloadQueue(1).toDebugJson();

    // Assert
    assertTrue(actualToDebugJsonResult instanceof JsonArray);
    assertEquals(0, ((JsonArray) actualToDebugJsonResult).size());
    assertFalse(actualToDebugJsonResult.isJsonNull());
    assertFalse(actualToDebugJsonResult.isJsonObject());
    assertFalse(actualToDebugJsonResult.isJsonPrimitive());
    assertFalse(((JsonArray) actualToDebugJsonResult).iterator().hasNext());
    assertTrue(((JsonArray) actualToDebugJsonResult).isEmpty());
    assertTrue(actualToDebugJsonResult.isJsonArray());
    JsonArray actualAsJsonArray = actualToDebugJsonResult.getAsJsonArray();
    assertSame(actualToDebugJsonResult, actualAsJsonArray);
  }

  /**
   * Test UnloadSection {@link UnloadSection#UnloadSection(long)}.
   *
   * <p>Method under test: {@link UnloadSection#UnloadSection(long)}
   */
  @Test
  @DisplayName("Test UnloadSection new UnloadSection(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnloadSection.<init>(long)"})
  void testUnloadSectionNewUnloadSection() {
    // Arrange and Act
    UnloadSection actualUnloadSection = new UnloadSection(1L);

    // Assert
    assertEquals(1L, actualUnloadSection.order);
    assertTrue(actualUnloadSection.chunks.isEmpty());
  }
}
