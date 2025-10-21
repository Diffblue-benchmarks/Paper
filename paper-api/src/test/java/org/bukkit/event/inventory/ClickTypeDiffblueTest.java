package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClickTypeDiffblueTest {
  /**
   * Test {@link ClickType#isKeyboardClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#CONTROL_DROP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isKeyboardClick()}
   */
  @Test
  @DisplayName("Test isKeyboardClick(); given CONTROL_DROP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isKeyboardClick()"})
  void testIsKeyboardClick_givenControl_drop_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.CONTROL_DROP.isKeyboardClick());
  }

  /**
   * Test {@link ClickType#isKeyboardClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#DROP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isKeyboardClick()}
   */
  @Test
  @DisplayName("Test isKeyboardClick(); given DROP; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isKeyboardClick()"})
  void testIsKeyboardClick_givenDrop_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.DROP.isKeyboardClick());
  }

  /**
   * Test {@link ClickType#isKeyboardClick()}.
   *
   * <ul>
   *   <li>Given {@code LEFT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isKeyboardClick()}
   */
  @Test
  @DisplayName("Test isKeyboardClick(); given 'LEFT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isKeyboardClick()"})
  void testIsKeyboardClick_givenLeft_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClickType.LEFT.isKeyboardClick());
  }

  /**
   * Test {@link ClickType#isKeyboardClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#NUMBER_KEY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isKeyboardClick()}
   */
  @Test
  @DisplayName("Test isKeyboardClick(); given NUMBER_KEY; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isKeyboardClick()"})
  void testIsKeyboardClick_givenNumber_key_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.NUMBER_KEY.isKeyboardClick());
  }

  /**
   * Test {@link ClickType#isKeyboardClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#SWAP_OFFHAND}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isKeyboardClick()}
   */
  @Test
  @DisplayName("Test isKeyboardClick(); given SWAP_OFFHAND; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isKeyboardClick()"})
  void testIsKeyboardClick_givenSwap_offhand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.SWAP_OFFHAND.isKeyboardClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#DOUBLE_CLICK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given DOUBLE_CLICK; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenDouble_click_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.DOUBLE_CLICK.isMouseClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@code LEFT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given 'LEFT'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenLeft_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.LEFT.isMouseClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#MIDDLE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given MIDDLE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenMiddle_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.MIDDLE.isMouseClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@code NUMBER_KEY}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given 'NUMBER_KEY'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenNumberKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClickType.NUMBER_KEY.isMouseClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#RIGHT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given RIGHT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenRight_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.RIGHT.isMouseClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#SHIFT_LEFT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given SHIFT_LEFT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenShift_left_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.SHIFT_LEFT.isMouseClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#SHIFT_RIGHT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given SHIFT_RIGHT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenShift_right_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.SHIFT_RIGHT.isMouseClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#WINDOW_BORDER_LEFT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given WINDOW_BORDER_LEFT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenWindow_border_left_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.WINDOW_BORDER_LEFT.isMouseClick());
  }

  /**
   * Test {@link ClickType#isMouseClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#WINDOW_BORDER_RIGHT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isMouseClick()}
   */
  @Test
  @DisplayName("Test isMouseClick(); given WINDOW_BORDER_RIGHT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isMouseClick()"})
  void testIsMouseClick_givenWindow_border_right_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.WINDOW_BORDER_RIGHT.isMouseClick());
  }

  /**
   * Test {@link ClickType#isCreativeAction()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#CREATIVE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isCreativeAction()}
   */
  @Test
  @DisplayName("Test isCreativeAction(); given CREATIVE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isCreativeAction()"})
  void testIsCreativeAction_givenCreative_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.CREATIVE.isCreativeAction());
  }

  /**
   * Test {@link ClickType#isCreativeAction()}.
   *
   * <ul>
   *   <li>Given {@code LEFT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isCreativeAction()}
   */
  @Test
  @DisplayName("Test isCreativeAction(); given 'LEFT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isCreativeAction()"})
  void testIsCreativeAction_givenLeft_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClickType.LEFT.isCreativeAction());
  }

  /**
   * Test {@link ClickType#isCreativeAction()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#MIDDLE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isCreativeAction()}
   */
  @Test
  @DisplayName("Test isCreativeAction(); given MIDDLE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isCreativeAction()"})
  void testIsCreativeAction_givenMiddle_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.MIDDLE.isCreativeAction());
  }

  /**
   * Test {@link ClickType#isRightClick()}.
   *
   * <ul>
   *   <li>Given {@code LEFT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isRightClick()}
   */
  @Test
  @DisplayName("Test isRightClick(); given 'LEFT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isRightClick()"})
  void testIsRightClick_givenLeft_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClickType.LEFT.isRightClick());
  }

  /**
   * Test {@link ClickType#isRightClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#RIGHT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isRightClick()}
   */
  @Test
  @DisplayName("Test isRightClick(); given RIGHT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isRightClick()"})
  void testIsRightClick_givenRight_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.RIGHT.isRightClick());
  }

  /**
   * Test {@link ClickType#isRightClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#SHIFT_RIGHT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isRightClick()}
   */
  @Test
  @DisplayName("Test isRightClick(); given SHIFT_RIGHT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isRightClick()"})
  void testIsRightClick_givenShift_right_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.SHIFT_RIGHT.isRightClick());
  }

  /**
   * Test {@link ClickType#isLeftClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#CREATIVE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); given CREATIVE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isLeftClick()"})
  void testIsLeftClick_givenCreative_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.CREATIVE.isLeftClick());
  }

  /**
   * Test {@link ClickType#isLeftClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#DOUBLE_CLICK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); given DOUBLE_CLICK; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isLeftClick()"})
  void testIsLeftClick_givenDouble_click_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.DOUBLE_CLICK.isLeftClick());
  }

  /**
   * Test {@link ClickType#isLeftClick()}.
   *
   * <ul>
   *   <li>Given {@code LEFT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); given 'LEFT'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isLeftClick()"})
  void testIsLeftClick_givenLeft_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.LEFT.isLeftClick());
  }

  /**
   * Test {@link ClickType#isLeftClick()}.
   *
   * <ul>
   *   <li>Given {@code RIGHT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); given 'RIGHT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isLeftClick()"})
  void testIsLeftClick_givenRight_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClickType.RIGHT.isLeftClick());
  }

  /**
   * Test {@link ClickType#isLeftClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#SHIFT_LEFT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); given SHIFT_LEFT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isLeftClick()"})
  void testIsLeftClick_givenShift_left_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.SHIFT_LEFT.isLeftClick());
  }

  /**
   * Test {@link ClickType#isShiftClick()}.
   *
   * <ul>
   *   <li>Given {@code LEFT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isShiftClick()}
   */
  @Test
  @DisplayName("Test isShiftClick(); given 'LEFT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isShiftClick()"})
  void testIsShiftClick_givenLeft_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClickType.LEFT.isShiftClick());
  }

  /**
   * Test {@link ClickType#isShiftClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#SHIFT_LEFT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isShiftClick()}
   */
  @Test
  @DisplayName("Test isShiftClick(); given SHIFT_LEFT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isShiftClick()"})
  void testIsShiftClick_givenShift_left_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.SHIFT_LEFT.isShiftClick());
  }

  /**
   * Test {@link ClickType#isShiftClick()}.
   *
   * <ul>
   *   <li>Given {@link ClickType#SHIFT_RIGHT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClickType#isShiftClick()}
   */
  @Test
  @DisplayName("Test isShiftClick(); given SHIFT_RIGHT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClickType.isShiftClick()"})
  void testIsShiftClick_givenShift_right_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ClickType.SHIFT_RIGHT.isShiftClick());
  }
}
