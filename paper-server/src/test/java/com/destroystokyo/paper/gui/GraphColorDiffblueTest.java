package com.destroystokyo.paper.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.color.ICC_ColorSpace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphColorDiffblueTest {
  /**
   * Test {@link GraphColor#getLineColor(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link GraphColor#getLineColor(int)}
   */
  @Test
  @DisplayName("Test getLineColor(int); when one; then ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color GraphColor.getLineColor(int)"})
  void testGetLineColor_whenOne_thenColorSpaceReturnICC_ColorSpace() {
    // Arrange and Act
    Color actualLineColor = GraphColor.getLineColor(1);

    // Assert
    assertTrue(actualLineColor.getColorSpace() instanceof ICC_ColorSpace);
    assertEquals(-16744704, actualLineColor.getRGB());
    assertEquals(0, actualLineColor.getBlue());
    assertEquals(0, actualLineColor.getRed());
    assertEquals(1, actualLineColor.getTransparency());
    assertEquals(255, actualLineColor.getAlpha());
    assertEquals(Float.MAX_EXPONENT, actualLineColor.getGreen());
  }

  /**
   * Test {@link GraphColor#getFillColor(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link GraphColor#getFillColor(int)}
   */
  @Test
  @DisplayName("Test getFillColor(int); when one; then ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color GraphColor.getFillColor(int)"})
  void testGetFillColor_whenOne_thenColorSpaceReturnICC_ColorSpace() {
    // Arrange and Act
    Color actualFillColor = GraphColor.getFillColor(1);

    // Assert
    assertTrue(actualFillColor.getColorSpace() instanceof ICC_ColorSpace);
    assertEquals(0, actualFillColor.getBlue());
    assertEquals(0, actualFillColor.getRed());
    assertEquals(125, actualFillColor.getAlpha());
    assertEquals(2097184512, actualFillColor.getRGB());
    assertEquals(3, actualFillColor.getTransparency());
    assertEquals(Float.MAX_EXPONENT, actualFillColor.getGreen());
  }
}
