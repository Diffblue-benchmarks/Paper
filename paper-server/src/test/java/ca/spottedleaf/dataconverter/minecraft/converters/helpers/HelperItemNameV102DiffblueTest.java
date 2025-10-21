package ca.spottedleaf.dataconverter.minecraft.converters.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelperItemNameV102DiffblueTest {
  /**
   * Test {@link HelperItemNameV102#getNameFromId(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HelperItemNameV102#getNameFromId(int)}
   */
  @Test
  @DisplayName("Test getNameFromId(int); when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HelperItemNameV102.getNameFromId(int)"})
  void testGetNameFromId_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(HelperItemNameV102.getNameFromId(-1));
  }

  /**
   * Test {@link HelperItemNameV102#getNameFromId(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code minecraft:stone}.
   * </ul>
   *
   * <p>Method under test: {@link HelperItemNameV102#getNameFromId(int)}
   */
  @Test
  @DisplayName("Test getNameFromId(int); when one; then return 'minecraft:stone'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HelperItemNameV102.getNameFromId(int)"})
  void testGetNameFromId_whenOne_thenReturnMinecraftStone() {
    // Arrange, Act and Assert
    assertEquals("minecraft:stone", HelperItemNameV102.getNameFromId(1));
  }

  /**
   * Test {@link HelperItemNameV102#getNameFromId(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code minecraft:air}.
   * </ul>
   *
   * <p>Method under test: {@link HelperItemNameV102#getNameFromId(int)}
   */
  @Test
  @DisplayName("Test getNameFromId(int); when zero; then return 'minecraft:air'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HelperItemNameV102.getNameFromId(int)"})
  void testGetNameFromId_whenZero_thenReturnMinecraftAir() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", HelperItemNameV102.getNameFromId(0));
  }

  /**
   * Test {@link HelperItemNameV102#getPotionNameFromId(short)}.
   *
   * <p>Method under test: {@link HelperItemNameV102#getPotionNameFromId(short)}
   */
  @Test
  @DisplayName("Test getPotionNameFromId(short)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HelperItemNameV102.getPotionNameFromId(short)"})
  void testGetPotionNameFromId() {
    // Arrange, Act and Assert
    assertEquals("minecraft:regeneration", HelperItemNameV102.getPotionNameFromId((short) 1));
  }
}
