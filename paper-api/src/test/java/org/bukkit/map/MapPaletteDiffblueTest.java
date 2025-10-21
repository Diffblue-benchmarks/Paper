package org.bukkit.map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.SinglePixelPackedSampleModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapPaletteDiffblueTest {
  /**
   * Test {@link MapPalette#resizeImage(Image)}.
   *
   * <p>Method under test: {@link MapPalette#resizeImage(Image)}
   */
  @Test
  @DisplayName("Test resizeImage(Image)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage MapPalette.resizeImage(Image)"})
  void testResizeImage() {
    // Arrange and Act
    BufferedImage actualResizeImageResult = MapPalette.resizeImage(new BufferedImage(1, 1, 1));

    // Assert
    assertTrue(actualResizeImageResult.getColorModel() instanceof DirectColorModel);
    assertTrue(actualResizeImageResult.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertNull(actualResizeImageResult.getPropertyNames());
    assertNull(actualResizeImageResult.getSources());
    assertEquals(0, actualResizeImageResult.getMinTileX());
    assertEquals(0, actualResizeImageResult.getMinTileY());
    assertEquals(0, actualResizeImageResult.getMinX());
    assertEquals(0, actualResizeImageResult.getMinY());
    assertEquals(0, actualResizeImageResult.getTileGridXOffset());
    assertEquals(0, actualResizeImageResult.getTileGridYOffset());
    assertEquals(0.5f, actualResizeImageResult.getAccelerationPriority());
    assertEquals(1, actualResizeImageResult.getNumXTiles());
    assertEquals(1, actualResizeImageResult.getNumYTiles());
    assertEquals(1, actualResizeImageResult.getWritableTileIndices().length);
    assertEquals(128, actualResizeImageResult.getHeight());
    assertEquals(128, actualResizeImageResult.getTileHeight());
    assertEquals(128, actualResizeImageResult.getTileWidth());
    assertEquals(128, actualResizeImageResult.getWidth());
    assertEquals(2, actualResizeImageResult.getType());
    assertEquals(3, actualResizeImageResult.getTransparency());
    assertFalse(actualResizeImageResult.isAlphaPremultiplied());
    assertTrue(actualResizeImageResult.hasTileWriters());
  }

  /**
   * Test {@link MapPalette#imageToBytes(Image)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#imageToBytes(Image)}
   */
  @Test
  @DisplayName("Test imageToBytes(Image); then return array of byte with minus forty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MapPalette.imageToBytes(Image)"})
  void testImageToBytes_thenReturnArrayOfByteWithMinusFortyNine() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-49}, MapPalette.imageToBytes(new BufferedImage(1, 1, 1)));
  }

  /**
   * Test {@link MapPalette#imageToBytes(Image)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@link MapPalette#TRANSPARENT}.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#imageToBytes(Image)}
   */
  @Test
  @DisplayName("Test imageToBytes(Image); then return array of byte with TRANSPARENT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MapPalette.imageToBytes(Image)"})
  void testImageToBytes_thenReturnArrayOfByteWithTransparent() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {MapPalette.TRANSPARENT}, MapPalette.imageToBytes(new BufferedImage(1, 1, 2)));
  }

  /**
   * Test {@link MapPalette#matchColor(Color)} with {@code color}.
   *
   * <ul>
   *   <li>When Color is {@code A}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#matchColor(Color)}
   */
  @Test
  @DisplayName("Test matchColor(Color) with 'color'; when Color is 'A'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MapPalette.matchColor(Color)"})
  void testMatchColorWithColor_whenColorIsA_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', MapPalette.matchColor(MapPalette.getColor((byte) 'A')));
  }

  /**
   * Test {@link MapPalette#matchColor(Color)} with {@code color}.
   *
   * <ul>
   *   <li>When Color is {@link Byte#MIN_VALUE}.
   *   <li>Then return {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#matchColor(Color)}
   */
  @Test
  @DisplayName(
      "Test matchColor(Color) with 'color'; when Color is MIN_VALUE; then return MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MapPalette.matchColor(Color)"})
  void testMatchColorWithColor_whenColorIsMin_value_thenReturnMin_value() {
    // Arrange, Act and Assert
    assertEquals(Byte.MIN_VALUE, MapPalette.matchColor(MapPalette.getColor(Byte.MIN_VALUE)));
  }

  /**
   * Test {@link MapPalette#matchColor(Color)} with {@code color}.
   *
   * <ul>
   *   <li>When Color is {@link MapPalette#TRANSPARENT}.
   *   <li>Then return {@link MapPalette#TRANSPARENT}.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#matchColor(Color)}
   */
  @Test
  @DisplayName(
      "Test matchColor(Color) with 'color'; when Color is TRANSPARENT; then return TRANSPARENT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MapPalette.matchColor(Color)"})
  void testMatchColorWithColor_whenColorIsTransparent_thenReturnTransparent() {
    // Arrange, Act and Assert
    assertEquals(
        MapPalette.TRANSPARENT, MapPalette.matchColor(MapPalette.getColor(MapPalette.TRANSPARENT)));
  }

  /**
   * Test {@link MapPalette#matchColor(int, int, int)} with {@code r}, {@code g}, {@code b}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return minus forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#matchColor(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test matchColor(int, int, int) with 'r', 'g', 'b'; when four; then return minus forty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MapPalette.matchColor(int, int, int)"})
  void testMatchColorWithRGB_whenFour_thenReturnMinusFortyNine() {
    // Arrange, Act and Assert
    assertEquals((byte) -49, MapPalette.matchColor(4, 3, 3));
  }

  /**
   * Test {@link MapPalette#matchColor(int, int, int)} with {@code r}, {@code g}, {@code b}.
   *
   * <ul>
   *   <li>When one hundred twenty-eight.
   *   <li>Then return nineteen.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#matchColor(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test matchColor(int, int, int) with 'r', 'g', 'b'; when one hundred twenty-eight; then return nineteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MapPalette.matchColor(int, int, int)"})
  void testMatchColorWithRGB_whenOneHundredTwentyEight_thenReturnNineteen() {
    // Arrange, Act and Assert
    assertEquals((byte) 19, MapPalette.matchColor(128, 3, 3));
  }

  /**
   * Test {@link MapPalette#matchColor(int, int, int)} with {@code r}, {@code g}, {@code b}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return minus forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#matchColor(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test matchColor(int, int, int) with 'r', 'g', 'b'; when three; then return minus forty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MapPalette.matchColor(int, int, int)"})
  void testMatchColorWithRGB_whenThree_thenReturnMinusFortyNine() {
    // Arrange, Act and Assert
    assertEquals((byte) -49, MapPalette.matchColor(3, 3, 3));
  }

  /**
   * Test {@link MapPalette#matchColor(int, int, int)} with {@code r}, {@code g}, {@code b}.
   *
   * <ul>
   *   <li>When two hundred fifty-five.
   *   <li>Then return eighteen.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#matchColor(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test matchColor(int, int, int) with 'r', 'g', 'b'; when two hundred fifty-five; then return eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MapPalette.matchColor(int, int, int)"})
  void testMatchColorWithRGB_whenTwoHundredFiftyFive_thenReturnEighteen() {
    // Arrange, Act and Assert
    assertEquals((byte) 18, MapPalette.matchColor(255, 3, 3));
  }

  /**
   * Test {@link MapPalette#getColor(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return brighter RGB is {@code -2466561}.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#getColor(byte)}
   */
  @Test
  @DisplayName("Test getColor(byte); when 'A'; then return brighter RGB is '-2466561'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color MapPalette.getColor(byte)"})
  void testGetColor_whenA_thenReturnBrighterRgbIs2466561() {
    // Arrange and Act
    Color actualColor = MapPalette.getColor((byte) 'A');

    // Assert
    Color brighterResult = actualColor.brighter();
    assertEquals(-2466561, brighterResult.getRGB());
    assertEquals(-6733382, actualColor.getRGB());
    Color darkerResult = actualColor.darker();
    assertEquals(-9753214, darkerResult.getRGB());
    assertEquals(107, darkerResult.getRed());
    assertEquals(130, darkerResult.getBlue());
    assertEquals(153, actualColor.getRed());
    assertEquals(186, actualColor.getBlue());
    assertEquals(218, brighterResult.getRed());
    assertEquals(45, darkerResult.getGreen());
    assertEquals(65, actualColor.getGreen());
    assertEquals(92, brighterResult.getGreen());
  }

  /**
   * Test {@link MapPalette#getColor(byte)}.
   *
   * <ul>
   *   <li>When {@link Byte#MIN_VALUE}.
   *   <li>Then return brighter RGB is {@code -11894529}.
   * </ul>
   *
   * <p>Method under test: {@link MapPalette#getColor(byte)}
   */
  @Test
  @DisplayName("Test getColor(byte); when MIN_VALUE; then return brighter RGB is '-11894529'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color MapPalette.getColor(byte)"})
  void testGetColor_whenMin_value_thenReturnBrighterRgbIs11894529() {
    // Arrange and Act
    Color actualColor = MapPalette.getColor(Byte.MIN_VALUE);

    // Assert
    Color brighterResult = actualColor.brighter();
    assertEquals(-11894529, brighterResult.getRGB());
    assertEquals(-13346124, actualColor.getRGB());
    Color darkerResult = actualColor.darker();
    assertEquals(-14401923, darkerResult.getRGB());
    assertEquals(125, darkerResult.getBlue());
    assertEquals(128, brighterResult.getGreen());
    assertEquals(180, actualColor.getBlue());
    assertEquals(36, darkerResult.getRed());
    assertEquals(52, actualColor.getRed());
    assertEquals(62, darkerResult.getGreen());
    assertEquals(74, brighterResult.getRed());
    assertEquals(90, actualColor.getGreen());
  }
}
