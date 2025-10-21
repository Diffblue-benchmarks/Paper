package org.bukkit.potion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PotionDataDiffblueTest {
  /**
   * Test {@link PotionData#PotionData(PotionType)}.
   *
   * <ul>
   *   <li>When {@code AWKWARD}.
   *   <li>Then return Type is {@code AWKWARD}.
   * </ul>
   *
   * <p>Method under test: {@link PotionData#PotionData(PotionType)}
   */
  @Test
  @DisplayName("Test new PotionData(PotionType); when 'AWKWARD'; then return Type is 'AWKWARD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PotionData.<init>(PotionType)"})
  void testNewPotionData_whenAwkward_thenReturnTypeIsAwkward() {
    // Arrange and Act
    PotionData actualPotionData = new PotionData(PotionType.AWKWARD);

    // Assert
    assertEquals(PotionType.AWKWARD, actualPotionData.getType());
    assertFalse(actualPotionData.isExtended());
    assertFalse(actualPotionData.isUpgraded());
  }

  /**
   * Test {@link PotionData#PotionData(PotionType, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code AWKWARD}.
   *   <li>Then return Type is {@code AWKWARD}.
   * </ul>
   *
   * <p>Method under test: {@link PotionData#PotionData(PotionType, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PotionData(PotionType, boolean, boolean); when 'AWKWARD'; then return Type is 'AWKWARD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PotionData.<init>(PotionType, boolean, boolean)"})
  void testNewPotionData_whenAwkward_thenReturnTypeIsAwkward2() {
    // Arrange and Act
    PotionData actualPotionData = new PotionData(PotionType.AWKWARD, false, false);

    // Assert
    assertEquals(PotionType.AWKWARD, actualPotionData.getType());
    assertFalse(actualPotionData.isExtended());
    assertFalse(actualPotionData.isUpgraded());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PotionData#getType()}
   *   <li>{@link PotionData#isExtended()}
   *   <li>{@link PotionData#isUpgraded()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PotionType PotionData.getType()",
    "boolean PotionData.isExtended()",
    "boolean PotionData.isUpgraded()"
  })
  void testGettersAndSetters() {
    // Arrange
    PotionData potionData = new PotionData(PotionType.AWKWARD);

    // Act
    PotionType actualType = potionData.getType();
    boolean actualIsExtendedResult = potionData.isExtended();

    // Assert
    assertEquals(PotionType.AWKWARD, actualType);
    assertFalse(actualIsExtendedResult);
    assertFalse(potionData.isUpgraded());
  }

  /**
   * Test {@link PotionData#equals(Object)}, and {@link PotionData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PotionData#equals(Object)}
   *   <li>{@link PotionData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PotionData.equals(Object)", "int PotionData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PotionData potionData = new PotionData(PotionType.AWKWARD);
    PotionData potionData2 = new PotionData(PotionType.AWKWARD);

    // Act and Assert
    assertEquals(potionData, potionData2);
    assertEquals(potionData.hashCode(), potionData2.hashCode());
  }

  /**
   * Test {@link PotionData#equals(Object)}, and {@link PotionData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PotionData#equals(Object)}
   *   <li>{@link PotionData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PotionData.equals(Object)", "int PotionData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PotionData potionData = new PotionData(PotionType.AWKWARD);

    // Act and Assert
    assertEquals(potionData, potionData);
    int expectedHashCodeResult = potionData.hashCode();
    assertEquals(expectedHashCodeResult, potionData.hashCode());
  }

  /**
   * Test {@link PotionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PotionData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PotionData.equals(Object)", "int PotionData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PotionData potionData = new PotionData(PotionType.FIRE_RESISTANCE);

    // Act and Assert
    assertNotEquals(potionData, new PotionData(PotionType.AWKWARD));
  }

  /**
   * Test {@link PotionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PotionData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PotionData.equals(Object)", "int PotionData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PotionData(PotionType.AWKWARD), null);
  }

  /**
   * Test {@link PotionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PotionData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PotionData.equals(Object)", "int PotionData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PotionData(PotionType.AWKWARD), "Different type to PotionData");
  }
}
