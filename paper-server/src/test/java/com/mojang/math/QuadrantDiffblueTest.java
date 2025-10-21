package com.mojang.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuadrantDiffblueTest {
  /**
   * Test {@link Quadrant#parseJson(int)}.
   *
   * <ul>
   *   <li>When ninety.
   *   <li>Then return {@code R90}.
   * </ul>
   *
   * <p>Method under test: {@link Quadrant#parseJson(int)}
   */
  @Test
  @DisplayName("Test parseJson(int); when ninety; then return 'R90'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quadrant Quadrant.parseJson(int)"})
  void testParseJson_whenNinety_thenReturnR90() {
    // Arrange, Act and Assert
    assertEquals(Quadrant.R90, Quadrant.parseJson(90));
  }

  /**
   * Test {@link Quadrant#parseJson(int)}.
   *
   * <ul>
   *   <li>When one hundred eighty.
   *   <li>Then return {@code R180}.
   * </ul>
   *
   * <p>Method under test: {@link Quadrant#parseJson(int)}
   */
  @Test
  @DisplayName("Test parseJson(int); when one hundred eighty; then return 'R180'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quadrant Quadrant.parseJson(int)"})
  void testParseJson_whenOneHundredEighty_thenReturnR180() {
    // Arrange, Act and Assert
    assertEquals(Quadrant.R180, Quadrant.parseJson(180));
  }

  /**
   * Test {@link Quadrant#parseJson(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link Quadrant#parseJson(int)}
   */
  @Test
  @DisplayName("Test parseJson(int); when one; then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quadrant Quadrant.parseJson(int)"})
  void testParseJson_whenOne_thenThrowJsonParseException() {
    // Arrange, Act and Assert
    assertThrows(JsonParseException.class, () -> Quadrant.parseJson(1));
  }

  /**
   * Test {@link Quadrant#parseJson(int)}.
   *
   * <ul>
   *   <li>When three hundred sixty.
   *   <li>Then return {@code R0}.
   * </ul>
   *
   * <p>Method under test: {@link Quadrant#parseJson(int)}
   */
  @Test
  @DisplayName("Test parseJson(int); when three hundred sixty; then return 'R0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quadrant Quadrant.parseJson(int)"})
  void testParseJson_whenThreeHundredSixty_thenReturnR0() {
    // Arrange, Act and Assert
    assertEquals(Quadrant.R0, Quadrant.parseJson(360));
  }

  /**
   * Test {@link Quadrant#parseJson(int)}.
   *
   * <ul>
   *   <li>When two hundred seventy.
   *   <li>Then return {@code R270}.
   * </ul>
   *
   * <p>Method under test: {@link Quadrant#parseJson(int)}
   */
  @Test
  @DisplayName("Test parseJson(int); when two hundred seventy; then return 'R270'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quadrant Quadrant.parseJson(int)"})
  void testParseJson_whenTwoHundredSeventy_thenReturnR270() {
    // Arrange, Act and Assert
    assertEquals(Quadrant.R270, Quadrant.parseJson(270));
  }

  /**
   * Test {@link Quadrant#rotateVertexIndex(int)}.
   *
   * <p>Method under test: {@link Quadrant#rotateVertexIndex(int)}
   */
  @Test
  @DisplayName("Test rotateVertexIndex(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Quadrant.rotateVertexIndex(int)"})
  void testRotateVertexIndex() {
    // Arrange, Act and Assert
    assertEquals(1, Quadrant.R0.rotateVertexIndex(1));
  }
}
