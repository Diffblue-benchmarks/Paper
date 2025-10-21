package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ColorDiffblueTest {
  /**
   * Test {@link Color#fromARGB(int, int, int, int)} with {@code alpha}, {@code red}, {@code green},
   * {@code blue}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Alpha is one.
   * </ul>
   *
   * <p>Method under test: {@link Color#fromARGB(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test fromARGB(int, int, int, int) with 'alpha', 'red', 'green', 'blue'; when one; then return Alpha is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.fromARGB(int, int, int, int)"})
  void testFromARGBWithAlphaRedGreenBlue_whenOne_thenReturnAlphaIsOne()
      throws IllegalArgumentException {
    // Arrange and Act
    Color actualFromARGBResult = Color.fromARGB(1, 1, 1, 1);

    // Assert
    assertEquals(1, actualFromARGBResult.getAlpha());
    assertEquals(1, actualFromARGBResult.getBlue());
    assertEquals(1, actualFromARGBResult.getGreen());
    assertEquals(1, actualFromARGBResult.getRed());
  }

  /**
   * Test {@link Color#fromARGB(int)} with {@code argb}.
   *
   * <p>Method under test: {@link Color#fromARGB(int)}
   */
  @Test
  @DisplayName("Test fromARGB(int) with 'argb'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.fromARGB(int)"})
  void testFromARGBWithArgb() {
    // Arrange and Act
    Color actualFromARGBResult = Color.fromARGB(1);

    // Assert
    assertEquals(0, actualFromARGBResult.getAlpha());
    assertEquals(0, actualFromARGBResult.getGreen());
    assertEquals(0, actualFromARGBResult.getRed());
    assertEquals(1, actualFromARGBResult.getBlue());
  }

  /**
   * Test {@link Color#fromRGB(int, int, int)} with {@code red}, {@code green}, {@code blue}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Blue is one.
   * </ul>
   *
   * <p>Method under test: {@link Color#fromRGB(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test fromRGB(int, int, int) with 'red', 'green', 'blue'; when one; then return Blue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.fromRGB(int, int, int)"})
  void testFromRGBWithRedGreenBlue_whenOne_thenReturnBlueIsOne() throws IllegalArgumentException {
    // Arrange and Act
    Color actualFromRGBResult = Color.fromRGB(1, 1, 1);

    // Assert
    assertEquals(1, actualFromRGBResult.getBlue());
    assertEquals(1, actualFromRGBResult.getGreen());
    assertEquals(1, actualFromRGBResult.getRed());
    assertEquals(255, actualFromRGBResult.getAlpha());
  }

  /**
   * Test {@link Color#fromRGB(int)} with {@code rgb}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Green is zero.
   * </ul>
   *
   * <p>Method under test: {@link Color#fromRGB(int)}
   */
  @Test
  @DisplayName("Test fromRGB(int) with 'rgb'; when one; then return Green is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.fromRGB(int)"})
  void testFromRGBWithRgb_whenOne_thenReturnGreenIsZero() throws IllegalArgumentException {
    // Arrange and Act
    Color actualFromRGBResult = Color.fromRGB(1);

    // Assert
    assertEquals(0, actualFromRGBResult.getGreen());
    assertEquals(0, actualFromRGBResult.getRed());
    assertEquals(1, actualFromRGBResult.getBlue());
    assertEquals(255, actualFromRGBResult.getAlpha());
  }

  /**
   * Test {@link Color#fromBGR(int)} with {@code bgr}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Blue is zero.
   * </ul>
   *
   * <p>Method under test: {@link Color#fromBGR(int)}
   */
  @Test
  @DisplayName("Test fromBGR(int) with 'bgr'; when one; then return Blue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.fromBGR(int)"})
  void testFromBGRWithBgr_whenOne_thenReturnBlueIsZero() throws IllegalArgumentException {
    // Arrange and Act
    Color actualFromBGRResult = Color.fromBGR(1);

    // Assert
    assertEquals(0, actualFromBGRResult.getBlue());
    assertEquals(0, actualFromBGRResult.getGreen());
    assertEquals(1, actualFromBGRResult.getRed());
    assertEquals(255, actualFromBGRResult.getAlpha());
  }

  /**
   * Test {@link Color#fromBGR(int, int, int)} with {@code blue}, {@code green}, {@code red}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Blue is one.
   * </ul>
   *
   * <p>Method under test: {@link Color#fromBGR(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test fromBGR(int, int, int) with 'blue', 'green', 'red'; when one; then return Blue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.fromBGR(int, int, int)"})
  void testFromBGRWithBlueGreenRed_whenOne_thenReturnBlueIsOne() throws IllegalArgumentException {
    // Arrange and Act
    Color actualFromBGRResult = Color.fromBGR(1, 1, 1);

    // Assert
    assertEquals(1, actualFromBGRResult.getBlue());
    assertEquals(1, actualFromBGRResult.getGreen());
    assertEquals(1, actualFromBGRResult.getRed());
    assertEquals(255, actualFromBGRResult.getAlpha());
  }

  /**
   * Test {@link Color#getAlpha()}.
   *
   * <p>Method under test: {@link Color#getAlpha()}
   */
  @Test
  @DisplayName("Test getAlpha()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Color.getAlpha()"})
  void testGetAlpha() {
    // Arrange, Act and Assert
    assertEquals(255, Color.AQUA.getAlpha());
  }

  /**
   * Test {@link Color#setAlpha(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Red is zero.
   * </ul>
   *
   * <p>Method under test: {@link Color#setAlpha(int)}
   */
  @Test
  @DisplayName("Test setAlpha(int); when one; then return Red is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.setAlpha(int)"})
  void testSetAlpha_whenOne_thenReturnRedIsZero() {
    // Arrange and Act
    Color actualSetAlphaResult = Color.AQUA.setAlpha(1);

    // Assert
    assertEquals(0, actualSetAlphaResult.getRed());
    assertEquals(1, actualSetAlphaResult.getAlpha());
    assertEquals(255, actualSetAlphaResult.getBlue());
    assertEquals(255, actualSetAlphaResult.getGreen());
  }

  /**
   * Test {@link Color#getRed()}.
   *
   * <p>Method under test: {@link Color#getRed()}
   */
  @Test
  @DisplayName("Test getRed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Color.getRed()"})
  void testGetRed() {
    // Arrange, Act and Assert
    assertEquals(0, Color.AQUA.getRed());
  }

  /**
   * Test {@link Color#setRed(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Red is one.
   * </ul>
   *
   * <p>Method under test: {@link Color#setRed(int)}
   */
  @Test
  @DisplayName("Test setRed(int); when one; then return Red is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.setRed(int)"})
  void testSetRed_whenOne_thenReturnRedIsOne() {
    // Arrange and Act
    Color actualSetRedResult = Color.AQUA.setRed(1);

    // Assert
    assertEquals(1, actualSetRedResult.getRed());
    assertEquals(255, actualSetRedResult.getAlpha());
    assertEquals(255, actualSetRedResult.getBlue());
    assertEquals(255, actualSetRedResult.getGreen());
  }

  /**
   * Test {@link Color#getGreen()}.
   *
   * <p>Method under test: {@link Color#getGreen()}
   */
  @Test
  @DisplayName("Test getGreen()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Color.getGreen()"})
  void testGetGreen() {
    // Arrange, Act and Assert
    assertEquals(255, Color.AQUA.getGreen());
  }

  /**
   * Test {@link Color#setGreen(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Red is zero.
   * </ul>
   *
   * <p>Method under test: {@link Color#setGreen(int)}
   */
  @Test
  @DisplayName("Test setGreen(int); when one; then return Red is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.setGreen(int)"})
  void testSetGreen_whenOne_thenReturnRedIsZero() {
    // Arrange and Act
    Color actualSetGreenResult = Color.AQUA.setGreen(1);

    // Assert
    assertEquals(0, actualSetGreenResult.getRed());
    assertEquals(1, actualSetGreenResult.getGreen());
    assertEquals(255, actualSetGreenResult.getAlpha());
    assertEquals(255, actualSetGreenResult.getBlue());
  }

  /**
   * Test {@link Color#getBlue()}.
   *
   * <p>Method under test: {@link Color#getBlue()}
   */
  @Test
  @DisplayName("Test getBlue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Color.getBlue()"})
  void testGetBlue() {
    // Arrange, Act and Assert
    assertEquals(255, Color.AQUA.getBlue());
  }

  /**
   * Test {@link Color#setBlue(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Red is zero.
   * </ul>
   *
   * <p>Method under test: {@link Color#setBlue(int)}
   */
  @Test
  @DisplayName("Test setBlue(int); when one; then return Red is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.setBlue(int)"})
  void testSetBlue_whenOne_thenReturnRedIsZero() {
    // Arrange and Act
    Color actualSetBlueResult = Color.AQUA.setBlue(1);

    // Assert
    assertEquals(0, actualSetBlueResult.getRed());
    assertEquals(1, actualSetBlueResult.getBlue());
    assertEquals(255, actualSetBlueResult.getAlpha());
    assertEquals(255, actualSetBlueResult.getGreen());
  }

  /**
   * Test {@link Color#asRGB()}.
   *
   * <p>Method under test: {@link Color#asRGB()}
   */
  @Test
  @DisplayName("Test asRGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Color.asRGB()"})
  void testAsRGB() {
    // Arrange, Act and Assert
    assertEquals(65535, Color.AQUA.asRGB());
  }

  /**
   * Test {@link Color#asARGB()}.
   *
   * <p>Method under test: {@link Color#asARGB()}
   */
  @Test
  @DisplayName("Test asARGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Color.asARGB()"})
  void testAsARGB() {
    // Arrange, Act and Assert
    assertEquals(-16711681, Color.AQUA.asARGB());
  }

  /**
   * Test {@link Color#asBGR()}.
   *
   * <p>Method under test: {@link Color#asBGR()}
   */
  @Test
  @DisplayName("Test asBGR()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Color.asBGR()"})
  void testAsBGR() {
    // Arrange, Act and Assert
    assertEquals(16776960, Color.AQUA.asBGR());
  }

  /**
   * Test {@link Color#mixDyes(DyeColor[])}.
   *
   * <ul>
   *   <li>When {@code WHITE}.
   *   <li>Then return Red is one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link Color#mixDyes(DyeColor[])}
   */
  @Test
  @DisplayName("Test mixDyes(DyeColor[]); when 'WHITE'; then return Red is one hundred twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.mixDyes(DyeColor[])"})
  void testMixDyes_whenWhite_thenReturnRedIsOneHundredTwentyFour() {
    // Arrange and Act
    Color actualMixDyesResult = Color.AQUA.mixDyes(DyeColor.WHITE);

    // Assert
    assertEquals(124, actualMixDyesResult.getRed());
    assertEquals(254, actualMixDyesResult.getBlue());
    assertEquals(255, actualMixDyesResult.getAlpha());
    assertEquals(255, actualMixDyesResult.getGreen());
  }

  /**
   * Test {@link Color#mixColors(Color[])}.
   *
   * <p>Method under test: {@link Color#mixColors(Color[])}
   */
  @Test
  @DisplayName("Test mixColors(Color[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color Color.mixColors(Color[])"})
  void testMixColors() {
    // Arrange, Act and Assert
    assertEquals(Color.AQUA, Color.AQUA.mixColors(Color.AQUA));
  }
}
