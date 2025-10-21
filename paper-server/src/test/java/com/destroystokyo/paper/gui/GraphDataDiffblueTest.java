package com.destroystokyo.paper.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphDataDiffblueTest {
  /**
   * Test {@link GraphData#GraphData(long, long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then FillColor ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link GraphData#GraphData(long, long, long)}
   */
  @Test
  @DisplayName(
      "Test new GraphData(long, long, long); when one; then FillColor ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphData.<init>(long, long, long)"})
  void testNewGraphData_whenOne_thenFillColorColorSpaceReturnICC_ColorSpace() {
    // Arrange and Act
    GraphData actualGraphData = new GraphData(1L, 1L, 1L);

    // Assert
    Color fillColor = actualGraphData.getFillColor();
    ColorSpace colorSpace = fillColor.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    Color lineColor = actualGraphData.getLineColor();
    assertEquals(-16744704, lineColor.getRGB());
    assertEquals(0, actualGraphData.getUsedPercent());
    assertEquals(0, fillColor.getBlue());
    assertEquals(0, lineColor.getBlue());
    assertEquals(0, fillColor.getRed());
    assertEquals(0, lineColor.getRed());
    assertEquals(0L, actualGraphData.getUsedMem());
    assertEquals(1, lineColor.getTransparency());
    assertEquals(125, fillColor.getAlpha());
    assertEquals(1L, actualGraphData.getTotal());
    assertEquals(2097184512, fillColor.getRGB());
    assertEquals(255, lineColor.getAlpha());
    assertEquals(3, fillColor.getTransparency());
    assertEquals(Float.MAX_EXPONENT, fillColor.getGreen());
    assertEquals(Float.MAX_EXPONENT, lineColor.getGreen());
    assertSame(colorSpace, lineColor.getColorSpace());
  }

  /**
   * Test {@link GraphData#GraphData(long, long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return UsedPercent is minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link GraphData#GraphData(long, long, long)}
   */
  @Test
  @DisplayName(
      "Test new GraphData(long, long, long); when zero; then return UsedPercent is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphData.<init>(long, long, long)"})
  void testNewGraphData_whenZero_thenReturnUsedPercentIsMinusOneHundred() {
    // Arrange and Act
    GraphData actualGraphData = new GraphData(0L, 1L, 1L);

    // Assert
    assertEquals(-100, actualGraphData.getUsedPercent());
    assertEquals(-1L, actualGraphData.getUsedMem());
    assertEquals(0L, actualGraphData.getTotal());
    assertEquals(1L, actualGraphData.getFree());
    assertEquals(1L, actualGraphData.getMax());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphData#getFree()}
   *   <li>{@link GraphData#getMax()}
   *   <li>{@link GraphData#getTotal()}
   *   <li>{@link GraphData#getUsedMem()}
   *   <li>{@link GraphData#getUsedPercent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long GraphData.getFree()",
    "long GraphData.getMax()",
    "long GraphData.getTotal()",
    "long GraphData.getUsedMem()",
    "int GraphData.getUsedPercent()"
  })
  void testGettersAndSetters() {
    // Arrange
    GraphData graphData = new GraphData(1L, 1L, 1L);

    // Act
    long actualFree = graphData.getFree();
    long actualMax = graphData.getMax();
    long actualTotal = graphData.getTotal();
    long actualUsedMem = graphData.getUsedMem();

    // Assert
    assertEquals(0, graphData.getUsedPercent());
    assertEquals(0L, actualUsedMem);
    assertEquals(1L, actualFree);
    assertEquals(1L, actualMax);
    assertEquals(1L, actualTotal);
  }

  /**
   * Test {@link GraphData#getFillColor()}.
   *
   * <ul>
   *   <li>Then ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link GraphData#getFillColor()}
   */
  @Test
  @DisplayName("Test getFillColor(); then ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color GraphData.getFillColor()"})
  void testGetFillColor_thenColorSpaceReturnICC_ColorSpace() {
    // Arrange and Act
    Color actualFillColor = new GraphData(1L, 1L, 1L).getFillColor();

    // Assert
    assertTrue(actualFillColor.getColorSpace() instanceof ICC_ColorSpace);
    assertEquals(0, actualFillColor.getBlue());
    assertEquals(0, actualFillColor.getRed());
    assertEquals(125, actualFillColor.getAlpha());
    assertEquals(2097184512, actualFillColor.getRGB());
    assertEquals(3, actualFillColor.getTransparency());
    assertEquals(Float.MAX_EXPONENT, actualFillColor.getGreen());
  }

  /**
   * Test {@link GraphData#getLineColor()}.
   *
   * <ul>
   *   <li>Then ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link GraphData#getLineColor()}
   */
  @Test
  @DisplayName("Test getLineColor(); then ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color GraphData.getLineColor()"})
  void testGetLineColor_thenColorSpaceReturnICC_ColorSpace() {
    // Arrange and Act
    Color actualLineColor = new GraphData(1L, 1L, 1L).getLineColor();

    // Assert
    assertTrue(actualLineColor.getColorSpace() instanceof ICC_ColorSpace);
    assertEquals(-16744704, actualLineColor.getRGB());
    assertEquals(0, actualLineColor.getBlue());
    assertEquals(0, actualLineColor.getRed());
    assertEquals(1, actualLineColor.getTransparency());
    assertEquals(255, actualLineColor.getAlpha());
    assertEquals(Float.MAX_EXPONENT, actualLineColor.getGreen());
  }
}
