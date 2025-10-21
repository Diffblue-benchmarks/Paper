package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class V1451DiffblueTest {
  /**
   * Test {@link V1451#packWithDot(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code minecraft.42}.
   * </ul>
   *
   * <p>Method under test: {@link V1451#packWithDot(String)}
   */
  @Test
  @DisplayName("Test packWithDot(String); when '42'; then return 'minecraft.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V1451.packWithDot(String)"})
  void testPackWithDot_when42_thenReturnMinecraft42() {
    // Arrange, Act and Assert
    assertEquals("minecraft.42", V1451.packWithDot("42"));
  }

  /**
   * Test {@link V1451#packWithDot(String)}.
   *
   * <ul>
   *   <li>When {@code 42minecraft:arrow}.
   *   <li>Then return {@code 42minecraft.arrow}.
   * </ul>
   *
   * <p>Method under test: {@link V1451#packWithDot(String)}
   */
  @Test
  @DisplayName(
      "Test packWithDot(String); when '42minecraft:arrow'; then return '42minecraft.arrow'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V1451.packWithDot(String)"})
  void testPackWithDot_when42minecraftArrow_thenReturn42minecraftArrow() {
    // Arrange, Act and Assert
    assertEquals("42minecraft.arrow", V1451.packWithDot("42minecraft:arrow"));
  }

  /**
   * Test {@link V1451#packWithDot(String)}.
   *
   * <ul>
   *   <li>When {@code blockState}.
   *   <li>Then return {@code blockState}.
   * </ul>
   *
   * <p>Method under test: {@link V1451#packWithDot(String)}
   */
  @Test
  @DisplayName("Test packWithDot(String); when 'blockState'; then return 'blockState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V1451.packWithDot(String)"})
  void testPackWithDot_whenBlockState_thenReturnBlockState() {
    // Arrange, Act and Assert
    assertEquals("blockState", V1451.packWithDot("blockState"));
  }

  /**
   * Test {@link V1451#packWithDot(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:arrowString}.
   *   <li>Then return {@code minecraft:arrowString}.
   * </ul>
   *
   * <p>Method under test: {@link V1451#packWithDot(String)}
   */
  @Test
  @DisplayName(
      "Test packWithDot(String); when 'minecraft:arrowString'; then return 'minecraft:arrowString'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V1451.packWithDot(String)"})
  void testPackWithDot_whenMinecraftArrowString_thenReturnMinecraftArrowString() {
    // Arrange, Act and Assert
    assertEquals("minecraft:arrowString", V1451.packWithDot("minecraft:arrowString"));
  }

  /**
   * Test {@link V1451#packWithDot(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:arrow}.
   *   <li>Then return {@code minecraft.arrow}.
   * </ul>
   *
   * <p>Method under test: {@link V1451#packWithDot(String)}
   */
  @Test
  @DisplayName("Test packWithDot(String); when 'minecraft:arrow'; then return 'minecraft.arrow'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V1451.packWithDot(String)"})
  void testPackWithDot_whenMinecraftArrow_thenReturnMinecraftArrow() {
    // Arrange, Act and Assert
    assertEquals("minecraft.arrow", V1451.packWithDot("minecraft:arrow"));
  }

  /**
   * Test {@link V1451#packWithDot(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:chest_minecart}.
   *   <li>Then return {@code minecraft.chest_minecart}.
   * </ul>
   *
   * <p>Method under test: {@link V1451#packWithDot(String)}
   */
  @Test
  @DisplayName(
      "Test packWithDot(String); when 'minecraft:chest_minecart'; then return 'minecraft.chest_minecart'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V1451.packWithDot(String)"})
  void testPackWithDot_whenMinecraftChestMinecart_thenReturnMinecraftChestMinecart() {
    // Arrange, Act and Assert
    assertEquals("minecraft.chest_minecart", V1451.packWithDot("minecraft:chest_minecart"));
  }

  /**
   * Test {@link V1451#packWithDot(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link V1451#packWithDot(String)}
   */
  @Test
  @DisplayName("Test packWithDot(String); when 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V1451.packWithDot(String)"})
  void testPackWithDot_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", V1451.packWithDot("String"));
  }

  /**
   * Test {@link V1451#packWithDot(String)}.
   *
   * <ul>
   *   <li>When {@code Stringminecraft:arrow}.
   *   <li>Then return {@code Stringminecraft:arrow}.
   * </ul>
   *
   * <p>Method under test: {@link V1451#packWithDot(String)}
   */
  @Test
  @DisplayName(
      "Test packWithDot(String); when 'Stringminecraft:arrow'; then return 'Stringminecraft:arrow'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V1451.packWithDot(String)"})
  void testPackWithDot_whenStringminecraftArrow_thenReturnStringminecraftArrow() {
    // Arrange, Act and Assert
    assertEquals("Stringminecraft:arrow", V1451.packWithDot("Stringminecraft:arrow"));
  }
}
