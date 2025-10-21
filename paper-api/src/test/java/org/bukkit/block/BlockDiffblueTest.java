package org.bukkit.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockDiffblueTest {
  /**
   * Test {@link Block#getBlockKey(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When {@code 134217727}.
   *   <li>Then return {@code 54043196065316863}.
   * </ul>
   *
   * <p>Method under test: {@link Block#getBlockKey(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getBlockKey(int, int, int) with 'int', 'int', 'int'; when '134217727'; then return '54043196065316863'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Block.getBlockKey(int, int, int)"})
  void testGetBlockKeyWithIntIntInt_when134217727_thenReturn54043196065316863() {
    // Arrange, Act and Assert
    assertEquals(54043196065316863L, Block.getBlockKey(134217727, 3, 3));
  }

  /**
   * Test {@link Block#getBlockKey(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When fifty-four.
   *   <li>Then return {@code 54043195931099190}.
   * </ul>
   *
   * <p>Method under test: {@link Block#getBlockKey(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getBlockKey(int, int, int) with 'int', 'int', 'int'; when fifty-four; then return '54043195931099190'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Block.getBlockKey(int, int, int)"})
  void testGetBlockKeyWithIntIntInt_whenFiftyFour_thenReturn54043195931099190() {
    // Arrange, Act and Assert
    assertEquals(54043195931099190L, Block.getBlockKey(54, 3, 3));
  }

  /**
   * Test {@link Block#getBlockKey(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When twenty-seven.
   *   <li>Then return {@code 54043195931099163}.
   * </ul>
   *
   * <p>Method under test: {@link Block#getBlockKey(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getBlockKey(int, int, int) with 'int', 'int', 'int'; when twenty-seven; then return '54043195931099163'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Block.getBlockKey(int, int, int)"})
  void testGetBlockKeyWithIntIntInt_whenTwentySeven_thenReturn54043195931099163() {
    // Arrange, Act and Assert
    assertEquals(54043195931099163L, Block.getBlockKey(27, 3, 3));
  }

  /**
   * Test {@link Block#getBlockKey(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 54043195931099138}.
   * </ul>
   *
   * <p>Method under test: {@link Block#getBlockKey(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getBlockKey(int, int, int) with 'int', 'int', 'int'; when two; then return '54043195931099138'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Block.getBlockKey(int, int, int)"})
  void testGetBlockKeyWithIntIntInt_whenTwo_thenReturn54043195931099138() {
    // Arrange, Act and Assert
    assertEquals(54043195931099138L, Block.getBlockKey(2, 3, 3));
  }

  /**
   * Test {@link Block#getBlockKeyX(long)}.
   *
   * <p>Method under test: {@link Block#getBlockKeyX(long)}
   */
  @Test
  @DisplayName("Test getBlockKeyX(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Block.getBlockKeyX(long)"})
  void testGetBlockKeyX() {
    // Arrange, Act and Assert
    assertEquals(1, Block.getBlockKeyX(1L));
  }

  /**
   * Test {@link Block#getBlockKeyY(long)}.
   *
   * <p>Method under test: {@link Block#getBlockKeyY(long)}
   */
  @Test
  @DisplayName("Test getBlockKeyY(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Block.getBlockKeyY(long)"})
  void testGetBlockKeyY() {
    // Arrange, Act and Assert
    assertEquals(0, Block.getBlockKeyY(1L));
  }

  /**
   * Test {@link Block#getBlockKeyZ(long)}.
   *
   * <p>Method under test: {@link Block#getBlockKeyZ(long)}
   */
  @Test
  @DisplayName("Test getBlockKeyZ(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Block.getBlockKeyZ(long)"})
  void testGetBlockKeyZ() {
    // Arrange, Act and Assert
    assertEquals(0, Block.getBlockKeyZ(1L));
  }
}
