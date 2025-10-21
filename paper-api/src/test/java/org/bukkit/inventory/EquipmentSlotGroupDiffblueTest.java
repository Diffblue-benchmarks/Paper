package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EquipmentSlotGroupDiffblueTest {
  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#ANY}.
   *   <li>When {@code HAND}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName("Test test(EquipmentSlot) with 'test'; given ANY; when 'HAND'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenAny_whenHand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.ANY.test(EquipmentSlot.HAND));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#ARMOR}.
   *   <li>When {@code BODY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName("Test test(EquipmentSlot) with 'test'; given ARMOR; when 'BODY'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenArmor_whenBody_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.ARMOR.test(EquipmentSlot.BODY));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#ARMOR}.
   *   <li>When {@code CHEST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test test(EquipmentSlot) with 'test'; given ARMOR; when 'CHEST'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenArmor_whenChest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.ARMOR.test(EquipmentSlot.CHEST));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#ARMOR}.
   *   <li>When {@code FEET}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName("Test test(EquipmentSlot) with 'test'; given ARMOR; when 'FEET'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenArmor_whenFeet_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.ARMOR.test(EquipmentSlot.FEET));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#ARMOR}.
   *   <li>When {@code HAND}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test test(EquipmentSlot) with 'test'; given ARMOR; when 'HAND'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenArmor_whenHand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EquipmentSlotGroup.ARMOR.test(EquipmentSlot.HAND));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#ARMOR}.
   *   <li>When {@code HEAD}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName("Test test(EquipmentSlot) with 'test'; given ARMOR; when 'HEAD'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenArmor_whenHead_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.ARMOR.test(EquipmentSlot.HEAD));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#ARMOR}.
   *   <li>When {@code LEGS}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName("Test test(EquipmentSlot) with 'test'; given ARMOR; when 'LEGS'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenArmor_whenLegs_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.ARMOR.test(EquipmentSlot.LEGS));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#BODY}.
   *   <li>When {@code HAND}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName("Test test(EquipmentSlot) with 'test'; given BODY; when 'HAND'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenBody_whenHand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EquipmentSlotGroup.BODY.test(EquipmentSlot.HAND));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#HAND}.
   *   <li>When {@code FEET}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName("Test test(EquipmentSlot) with 'test'; given HAND; when 'FEET'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenHand_whenFeet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EquipmentSlotGroup.HAND.test(EquipmentSlot.FEET));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#HAND}.
   *   <li>When {@code HAND}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName("Test test(EquipmentSlot) with 'test'; given HAND; when 'HAND'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenHand_whenHand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.HAND.test(EquipmentSlot.HAND));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#HAND}.
   *   <li>When {@code OFF_HAND}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test test(EquipmentSlot) with 'test'; given HAND; when 'OFF_HAND'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenHand_whenOffHand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.HAND.test(EquipmentSlot.OFF_HAND));
  }

  /**
   * Test {@link EquipmentSlotGroup#test(EquipmentSlot)} with {@code test}.
   *
   * <ul>
   *   <li>Given {@link EquipmentSlotGroup#MAINHAND}.
   *   <li>When {@code HAND}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#test(EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test test(EquipmentSlot) with 'test'; given MAINHAND; when 'HAND'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EquipmentSlotGroup.test(EquipmentSlot)"})
  void testTestWithTest_givenMainhand_whenHand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EquipmentSlotGroup.MAINHAND.test(EquipmentSlot.HAND));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EquipmentSlotGroup#getExample()}
   *   <li>{@link EquipmentSlotGroup#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EquipmentSlot EquipmentSlotGroup.getExample()",
    "String EquipmentSlotGroup.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    EquipmentSlotGroup equipmentSlotGroup = EquipmentSlotGroup.ANY;

    // Act
    EquipmentSlot actualExample = equipmentSlotGroup.getExample();

    // Assert
    assertEquals("any", equipmentSlotGroup.toString());
    assertEquals(EquipmentSlot.HAND, actualExample);
  }

  /**
   * Test {@link EquipmentSlotGroup#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EquipmentSlotGroup#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlotGroup EquipmentSlotGroup.getByName(String)"})
  void testGetByName_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EquipmentSlotGroup.getByName("Name"));
  }
}
