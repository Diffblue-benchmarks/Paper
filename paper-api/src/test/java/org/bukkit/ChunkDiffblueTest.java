package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChunkDiffblueTest {
  /**
   * Test {@link Chunk#getChunkKey(Location)} with {@code loc}.
   *
   * <p>Method under test: {@link Chunk#getChunkKey(Location)}
   */
  @Test
  @DisplayName("Test getChunkKey(Location) with 'loc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Chunk.getChunkKey(Location)"})
  void testGetChunkKeyWithLoc() {
    // Arrange, Act and Assert
    assertEquals(0L, Chunk.getChunkKey(Location.deserialize(new HashMap<>())));
  }

  /**
   * Test {@link Chunk#getChunkKey(int, int)} with {@code x}, {@code z}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code 17179869183}.
   * </ul>
   *
   * <p>Method under test: {@link Chunk#getChunkKey(int, int)}
   */
  @Test
  @DisplayName(
      "Test getChunkKey(int, int) with 'x', 'z'; when minus one; then return '17179869183'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Chunk.getChunkKey(int, int)"})
  void testGetChunkKeyWithXZ_whenMinusOne_thenReturn17179869183() {
    // Arrange, Act and Assert
    assertEquals(17179869183L, Chunk.getChunkKey(-1, 3));
  }

  /**
   * Test {@link Chunk#getChunkKey(int, int)} with {@code x}, {@code z}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then return {@code 12884901920}.
   * </ul>
   *
   * <p>Method under test: {@link Chunk#getChunkKey(int, int)}
   */
  @Test
  @DisplayName("Test getChunkKey(int, int) with 'x', 'z'; when SIZE; then return '12884901920'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Chunk.getChunkKey(int, int)"})
  void testGetChunkKeyWithXZ_whenSize_thenReturn12884901920() {
    // Arrange, Act and Assert
    assertEquals(12884901920L, Chunk.getChunkKey(Integer.SIZE, 3));
  }

  /**
   * Test {@link Chunk#getChunkKey(int, int)} with {@code x}, {@code z}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 12884901891}.
   * </ul>
   *
   * <p>Method under test: {@link Chunk#getChunkKey(int, int)}
   */
  @Test
  @DisplayName("Test getChunkKey(int, int) with 'x', 'z'; when three; then return '12884901891'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Chunk.getChunkKey(int, int)"})
  void testGetChunkKeyWithXZ_whenThree_thenReturn12884901891() {
    // Arrange, Act and Assert
    assertEquals(12884901891L, Chunk.getChunkKey(3, 3));
  }

  /**
   * Test {@link Chunk#getChunkKey(int, int)} with {@code x}, {@code z}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 12884901890}.
   * </ul>
   *
   * <p>Method under test: {@link Chunk#getChunkKey(int, int)}
   */
  @Test
  @DisplayName("Test getChunkKey(int, int) with 'x', 'z'; when two; then return '12884901890'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Chunk.getChunkKey(int, int)"})
  void testGetChunkKeyWithXZ_whenTwo_thenReturn12884901890() {
    // Arrange, Act and Assert
    assertEquals(12884901890L, Chunk.getChunkKey(2, 3));
  }
}
