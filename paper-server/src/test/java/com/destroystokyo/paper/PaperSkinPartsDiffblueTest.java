package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperSkinPartsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperSkinParts#PaperSkinParts(int)}
   *   <li>{@link PaperSkinParts#toString()}
   *   <li>{@link PaperSkinParts#getRaw()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperSkinParts.<init>(int)",
    "int PaperSkinParts.getRaw()",
    "String PaperSkinParts.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PaperSkinParts actualPaperSkinParts = new PaperSkinParts(1);
    String actualToStringResult = actualPaperSkinParts.toString();

    // Assert
    assertEquals(
        "PaperSkinParts[raw=1, cape=true, jacket=false, leftSleeve=false, rightSleeve=false, leftPants=false,"
            + " rightPants=false, hats=false]",
        actualToStringResult);
    assertEquals(1, actualPaperSkinParts.getRaw());
  }

  /**
   * Test {@link PaperSkinParts#hasCapeEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasCapeEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasCapeEnabled(); given PaperSkinParts(int) with raw is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasCapeEnabled()"})
  void testHasCapeEnabled_givenPaperSkinPartsWithRawIsOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaperSkinParts(1).hasCapeEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasCapeEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasCapeEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasCapeEnabled(); given PaperSkinParts(int) with raw is zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasCapeEnabled()"})
  void testHasCapeEnabled_givenPaperSkinPartsWithRawIsZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperSkinParts(0).hasCapeEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasJacketEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasJacketEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasJacketEnabled(); given PaperSkinParts(int) with raw is minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasJacketEnabled()"})
  void testHasJacketEnabled_givenPaperSkinPartsWithRawIsMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaperSkinParts(-1).hasJacketEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasJacketEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasJacketEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasJacketEnabled(); given PaperSkinParts(int) with raw is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasJacketEnabled()"})
  void testHasJacketEnabled_givenPaperSkinPartsWithRawIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperSkinParts(1).hasJacketEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasLeftSleeveEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasLeftSleeveEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasLeftSleeveEnabled(); given PaperSkinParts(int) with raw is minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasLeftSleeveEnabled()"})
  void testHasLeftSleeveEnabled_givenPaperSkinPartsWithRawIsMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaperSkinParts(-1).hasLeftSleeveEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasLeftSleeveEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasLeftSleeveEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasLeftSleeveEnabled(); given PaperSkinParts(int) with raw is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasLeftSleeveEnabled()"})
  void testHasLeftSleeveEnabled_givenPaperSkinPartsWithRawIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperSkinParts(1).hasLeftSleeveEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasRightSleeveEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasRightSleeveEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasRightSleeveEnabled(); given PaperSkinParts(int) with raw is minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasRightSleeveEnabled()"})
  void testHasRightSleeveEnabled_givenPaperSkinPartsWithRawIsMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaperSkinParts(-1).hasRightSleeveEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasRightSleeveEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasRightSleeveEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasRightSleeveEnabled(); given PaperSkinParts(int) with raw is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasRightSleeveEnabled()"})
  void testHasRightSleeveEnabled_givenPaperSkinPartsWithRawIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperSkinParts(1).hasRightSleeveEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasLeftPantsEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasLeftPantsEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasLeftPantsEnabled(); given PaperSkinParts(int) with raw is minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasLeftPantsEnabled()"})
  void testHasLeftPantsEnabled_givenPaperSkinPartsWithRawIsMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaperSkinParts(-1).hasLeftPantsEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasLeftPantsEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasLeftPantsEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasLeftPantsEnabled(); given PaperSkinParts(int) with raw is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasLeftPantsEnabled()"})
  void testHasLeftPantsEnabled_givenPaperSkinPartsWithRawIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperSkinParts(1).hasLeftPantsEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasRightPantsEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasRightPantsEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasRightPantsEnabled(); given PaperSkinParts(int) with raw is minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasRightPantsEnabled()"})
  void testHasRightPantsEnabled_givenPaperSkinPartsWithRawIsMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaperSkinParts(-1).hasRightPantsEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasRightPantsEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasRightPantsEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasRightPantsEnabled(); given PaperSkinParts(int) with raw is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasRightPantsEnabled()"})
  void testHasRightPantsEnabled_givenPaperSkinPartsWithRawIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperSkinParts(1).hasRightPantsEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasHatsEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasHatsEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasHatsEnabled(); given PaperSkinParts(int) with raw is minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasHatsEnabled()"})
  void testHasHatsEnabled_givenPaperSkinPartsWithRawIsMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaperSkinParts(-1).hasHatsEnabled());
  }

  /**
   * Test {@link PaperSkinParts#hasHatsEnabled()}.
   *
   * <ul>
   *   <li>Given {@link PaperSkinParts#PaperSkinParts(int)} with raw is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#hasHatsEnabled()}
   */
  @Test
  @DisplayName(
      "Test hasHatsEnabled(); given PaperSkinParts(int) with raw is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.hasHatsEnabled()"})
  void testHasHatsEnabled_givenPaperSkinPartsWithRawIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperSkinParts(1).hasHatsEnabled());
  }

  /**
   * Test {@link PaperSkinParts#equals(Object)}, and {@link PaperSkinParts#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperSkinParts#equals(Object)}
   *   <li>{@link PaperSkinParts#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.equals(Object)", "int PaperSkinParts.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaperSkinParts paperSkinParts = new PaperSkinParts(1);
    PaperSkinParts paperSkinParts2 = new PaperSkinParts(1);

    // Act and Assert
    assertEquals(paperSkinParts, paperSkinParts2);
    assertEquals(paperSkinParts.hashCode(), paperSkinParts2.hashCode());
  }

  /**
   * Test {@link PaperSkinParts#equals(Object)}, and {@link PaperSkinParts#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperSkinParts#equals(Object)}
   *   <li>{@link PaperSkinParts#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.equals(Object)", "int PaperSkinParts.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaperSkinParts paperSkinParts = new PaperSkinParts(1);

    // Act and Assert
    assertEquals(paperSkinParts, paperSkinParts);
    int expectedHashCodeResult = paperSkinParts.hashCode();
    assertEquals(expectedHashCodeResult, paperSkinParts.hashCode());
  }

  /**
   * Test {@link PaperSkinParts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.equals(Object)", "int PaperSkinParts.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PaperSkinParts paperSkinParts = new PaperSkinParts(0);

    // Act and Assert
    assertNotEquals(paperSkinParts, new PaperSkinParts(1));
  }

  /**
   * Test {@link PaperSkinParts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.equals(Object)", "int PaperSkinParts.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PaperSkinParts(1), null);
  }

  /**
   * Test {@link PaperSkinParts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaperSkinParts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSkinParts.equals(Object)", "int PaperSkinParts.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PaperSkinParts(1), "Different type to PaperSkinParts");
  }
}
