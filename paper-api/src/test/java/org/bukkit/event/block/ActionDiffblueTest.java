package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ActionDiffblueTest {
  /**
   * Test {@link Action#isLeftClick()}.
   *
   * <ul>
   *   <li>Given {@code LEFT_CLICK_BLOCK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Action#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); given 'LEFT_CLICK_BLOCK'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Action.isLeftClick()"})
  void testIsLeftClick_givenLeftClickBlock_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Action.LEFT_CLICK_BLOCK.isLeftClick());
  }

  /**
   * Test {@link Action#isLeftClick()}.
   *
   * <ul>
   *   <li>Given {@link Action#LEFT_CLICK_AIR}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Action#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); given LEFT_CLICK_AIR; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Action.isLeftClick()"})
  void testIsLeftClick_givenLeft_click_air_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Action.LEFT_CLICK_AIR.isLeftClick());
  }

  /**
   * Test {@link Action#isLeftClick()}.
   *
   * <ul>
   *   <li>Given {@code RIGHT_CLICK_BLOCK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Action#isLeftClick()}
   */
  @Test
  @DisplayName("Test isLeftClick(); given 'RIGHT_CLICK_BLOCK'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Action.isLeftClick()"})
  void testIsLeftClick_givenRightClickBlock_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Action.RIGHT_CLICK_BLOCK.isLeftClick());
  }

  /**
   * Test {@link Action#isRightClick()}.
   *
   * <ul>
   *   <li>Given {@code LEFT_CLICK_BLOCK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Action#isRightClick()}
   */
  @Test
  @DisplayName("Test isRightClick(); given 'LEFT_CLICK_BLOCK'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Action.isRightClick()"})
  void testIsRightClick_givenLeftClickBlock_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Action.LEFT_CLICK_BLOCK.isRightClick());
  }

  /**
   * Test {@link Action#isRightClick()}.
   *
   * <ul>
   *   <li>Given {@link Action#RIGHT_CLICK_AIR}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Action#isRightClick()}
   */
  @Test
  @DisplayName("Test isRightClick(); given RIGHT_CLICK_AIR; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Action.isRightClick()"})
  void testIsRightClick_givenRight_click_air_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Action.RIGHT_CLICK_AIR.isRightClick());
  }

  /**
   * Test {@link Action#isRightClick()}.
   *
   * <ul>
   *   <li>Given {@link Action#RIGHT_CLICK_BLOCK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Action#isRightClick()}
   */
  @Test
  @DisplayName("Test isRightClick(); given RIGHT_CLICK_BLOCK; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Action.isRightClick()"})
  void testIsRightClick_givenRight_click_block_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Action.RIGHT_CLICK_BLOCK.isRightClick());
  }
}
