package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EquipmentSlotDiffblueTest {
  /**
   * Test {@link EquipmentSlot#getGroup()}.
   *
   * <ul>
   *   <li>Given {@code BODY}.
   *   <li>Then return {@link EquipmentSlotGroup#BODY}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given 'BODY'; then return BODY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlot.getGroup()"})
  void testGetGroup_givenBody_thenReturnBody() {
    // Arrange, Act and Assert
    assertSame(EquipmentSlotGroup.BODY, EquipmentSlot.BODY.getGroup());
  }

  /**
   * Test {@link EquipmentSlot#getGroup()}.
   *
   * <ul>
   *   <li>Given {@code CHEST}.
   *   <li>Then return {@link EquipmentSlotGroup#CHEST}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given 'CHEST'; then return CHEST")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlot.getGroup()"})
  void testGetGroup_givenChest_thenReturnChest() {
    // Arrange, Act and Assert
    assertSame(EquipmentSlotGroup.CHEST, EquipmentSlot.CHEST.getGroup());
  }

  /**
   * Test {@link EquipmentSlot#getGroup()}.
   *
   * <ul>
   *   <li>Given {@code FEET}.
   *   <li>Then return {@link EquipmentSlotGroup#FEET}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given 'FEET'; then return FEET")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlot.getGroup()"})
  void testGetGroup_givenFeet_thenReturnFeet() {
    // Arrange, Act and Assert
    assertSame(EquipmentSlotGroup.FEET, EquipmentSlot.FEET.getGroup());
  }

  /**
   * Test {@link EquipmentSlot#getGroup()}.
   *
   * <ul>
   *   <li>Given {@code HAND}.
   *   <li>Then return {@link EquipmentSlotGroup#MAINHAND}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given 'HAND'; then return MAINHAND")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlot.getGroup()"})
  void testGetGroup_givenHand_thenReturnMainhand() {
    // Arrange, Act and Assert
    assertSame(EquipmentSlotGroup.MAINHAND, EquipmentSlot.HAND.getGroup());
  }

  /**
   * Test {@link EquipmentSlot#getGroup()}.
   *
   * <ul>
   *   <li>Given {@code HEAD}.
   *   <li>Then return {@link EquipmentSlotGroup#HEAD}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given 'HEAD'; then return HEAD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlot.getGroup()"})
  void testGetGroup_givenHead_thenReturnHead() {
    // Arrange, Act and Assert
    assertSame(EquipmentSlotGroup.HEAD, EquipmentSlot.HEAD.getGroup());
  }

  /**
   * Test {@link EquipmentSlot#getGroup()}.
   *
   * <ul>
   *   <li>Given {@code LEGS}.
   *   <li>Then return {@link EquipmentSlotGroup#LEGS}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given 'LEGS'; then return LEGS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlot.getGroup()"})
  void testGetGroup_givenLegs_thenReturnLegs() {
    // Arrange, Act and Assert
    assertSame(EquipmentSlotGroup.LEGS, EquipmentSlot.LEGS.getGroup());
  }

  /**
   * Test {@link EquipmentSlot#getGroup()}.
   *
   * <ul>
   *   <li>Given {@code OFF_HAND}.
   *   <li>Then return {@link EquipmentSlotGroup#OFFHAND}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given 'OFF_HAND'; then return OFFHAND")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlot.getGroup()"})
  void testGetGroup_givenOffHand_thenReturnOffhand() {
    // Arrange, Act and Assert
    assertSame(EquipmentSlotGroup.OFFHAND, EquipmentSlot.OFF_HAND.getGroup());
  }

  /**
   * Test {@link EquipmentSlot#getGroup()}.
   *
   * <ul>
   *   <li>Given {@code SADDLE}.
   *   <li>Then return {@link EquipmentSlotGroup#SADDLE}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given 'SADDLE'; then return SADDLE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlot.getGroup()"})
  void testGetGroup_givenSaddle_thenReturnSaddle() {
    // Arrange, Act and Assert
    assertSame(EquipmentSlotGroup.SADDLE, EquipmentSlot.SADDLE.getGroup());
  }

  /**
   * Test {@link EquipmentSlot#isHand()}.
   *
   * <ul>
   *   <li>Given {@code FEET}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isHand()}
   */
  @Test
  @DisplayName("Test isHand(); given 'FEET'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isHand()"})
  void testIsHand_givenFeet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EquipmentSlot.FEET.isHand());
  }

  /**
   * Test {@link EquipmentSlot#isHand()}.
   *
   * <ul>
   *   <li>Given {@code HAND}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isHand()}
   */
  @Test
  @DisplayName("Test isHand(); given 'HAND'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isHand()"})
  void testIsHand_givenHand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlot.HAND.isHand());
  }

  /**
   * Test {@link EquipmentSlot#isHand()}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlot#OFF_HAND}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isHand()}
   */
  @Test
  @DisplayName("Test isHand(); given OFF_HAND; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isHand()"})
  void testIsHand_givenOff_hand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlot.OFF_HAND.isHand());
  }

  /**
   * Test {@link EquipmentSlot#getOppositeHand()}.
   *
   * <ul>
   *   <li>Given {@code FEET}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getOppositeHand()}
   */
  @Test
  @DisplayName("Test getOppositeHand(); given 'FEET'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlot EquipmentSlot.getOppositeHand()"})
  void testGetOppositeHand_givenFeet_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> EquipmentSlot.FEET.getOppositeHand());
  }

  /**
   * Test {@link EquipmentSlot#getOppositeHand()}.
   *
   * <ul>
   *   <li>Given {@code HAND}.
   *   <li>Then return {@code OFF_HAND}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getOppositeHand()}
   */
  @Test
  @DisplayName("Test getOppositeHand(); given 'HAND'; then return 'OFF_HAND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlot EquipmentSlot.getOppositeHand()"})
  void testGetOppositeHand_givenHand_thenReturnOffHand() {
    // Arrange, Act and Assert
    assertEquals(EquipmentSlot.OFF_HAND, EquipmentSlot.HAND.getOppositeHand());
  }

  /**
   * Test {@link EquipmentSlot#getOppositeHand()}.
   *
   * <ul>
   *   <li>Given {@code OFF_HAND}.
   *   <li>Then return {@code HAND}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#getOppositeHand()}
   */
  @Test
  @DisplayName("Test getOppositeHand(); given 'OFF_HAND'; then return 'HAND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlot EquipmentSlot.getOppositeHand()"})
  void testGetOppositeHand_givenOffHand_thenReturnHand() {
    // Arrange, Act and Assert
    assertEquals(EquipmentSlot.HAND, EquipmentSlot.OFF_HAND.getOppositeHand());
  }

  /**
   * Test {@link EquipmentSlot#isArmor()}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlot#BODY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isArmor()}
   */
  @Test
  @DisplayName("Test isArmor(); given BODY; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isArmor()"})
  void testIsArmor_givenBody_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlot.BODY.isArmor());
  }

  /**
   * Test {@link EquipmentSlot#isArmor()}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlot#CHEST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isArmor()}
   */
  @Test
  @DisplayName("Test isArmor(); given CHEST; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isArmor()"})
  void testIsArmor_givenChest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlot.CHEST.isArmor());
  }

  /**
   * Test {@link EquipmentSlot#isArmor()}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlot#FEET}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isArmor()}
   */
  @Test
  @DisplayName("Test isArmor(); given FEET; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isArmor()"})
  void testIsArmor_givenFeet_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlot.FEET.isArmor());
  }

  /**
   * Test {@link EquipmentSlot#isArmor()}.
   *
   * <ul>
   *   <li>Given {@code HAND}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isArmor()}
   */
  @Test
  @DisplayName("Test isArmor(); given 'HAND'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isArmor()"})
  void testIsArmor_givenHand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EquipmentSlot.HAND.isArmor());
  }

  /**
   * Test {@link EquipmentSlot#isArmor()}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlot#HEAD}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isArmor()}
   */
  @Test
  @DisplayName("Test isArmor(); given HEAD; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isArmor()"})
  void testIsArmor_givenHead_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlot.HEAD.isArmor());
  }

  /**
   * Test {@link EquipmentSlot#isArmor()}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlot#LEGS}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlot#isArmor()}
   */
  @Test
  @DisplayName("Test isArmor(); given LEGS; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlot.isArmor()"})
  void testIsArmor_givenLegs_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlot.LEGS.isArmor());
  }
}
