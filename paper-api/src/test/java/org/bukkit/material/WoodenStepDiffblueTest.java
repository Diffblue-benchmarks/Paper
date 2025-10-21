package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WoodenStepDiffblueTest {
  /**
   * Test {@link WoodenStep#WoodenStep(Material, byte)}.
   *
   * <p>Method under test: {@link WoodenStep#WoodenStep(Material, byte)}
   */
  @Test
  @DisplayName("Test new WoodenStep(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.<init>(Material, byte)"})
  void testNewWoodenStep() {
    // Arrange and Act
    WoodenStep actualWoodenStep = new WoodenStep(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualWoodenStep.getItemType());
    assertEquals('A', actualWoodenStep.getData());
  }

  /**
   * Test {@link WoodenStep#WoodenStep()}.
   *
   * <p>Method under test: {@link WoodenStep#WoodenStep()}
   */
  @Test
  @DisplayName("Test new WoodenStep()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.<init>()"})
  void testNewWoodenStep2() {
    // Arrange and Act
    WoodenStep actualWoodenStep = new WoodenStep();

    // Assert
    assertEquals((byte) 0, actualWoodenStep.getData());
    assertEquals(Material.LEGACY_WOOD_STEP, actualWoodenStep.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWoodenStep.getSpecies());
    assertFalse(actualWoodenStep.isInverted());
  }

  /**
   * Test {@link WoodenStep#WoodenStep(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#WoodenStep(TreeSpecies)}
   */
  @Test
  @DisplayName("Test new WoodenStep(TreeSpecies); when 'ACACIA'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.<init>(TreeSpecies)"})
  void testNewWoodenStep_whenAcacia_thenReturnDataIsFour() {
    // Arrange and Act
    WoodenStep actualWoodenStep = new WoodenStep(TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 4, actualWoodenStep.getData());
    assertEquals(Material.LEGACY_WOOD_STEP, actualWoodenStep.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualWoodenStep.getSpecies());
    assertFalse(actualWoodenStep.isInverted());
  }

  /**
   * Test {@link WoodenStep#WoodenStep(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#WoodenStep(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName("Test new WoodenStep(TreeSpecies, boolean); when 'ACACIA'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.<init>(TreeSpecies, boolean)"})
  void testNewWoodenStep_whenAcacia_thenReturnDataIsFour2() {
    // Arrange and Act
    WoodenStep actualWoodenStep = new WoodenStep(TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 4, actualWoodenStep.getData());
    assertEquals(Material.LEGACY_WOOD_STEP, actualWoodenStep.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualWoodenStep.getSpecies());
    assertFalse(actualWoodenStep.isInverted());
  }

  /**
   * Test {@link WoodenStep#WoodenStep(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#WoodenStep(TreeSpecies)}
   */
  @Test
  @DisplayName("Test new WoodenStep(TreeSpecies); when 'GENERIC'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.<init>(TreeSpecies)"})
  void testNewWoodenStep_whenGeneric_thenReturnDataIsZero() {
    // Arrange and Act
    WoodenStep actualWoodenStep = new WoodenStep(TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualWoodenStep.getData());
    assertEquals(Material.LEGACY_WOOD_STEP, actualWoodenStep.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWoodenStep.getSpecies());
    assertFalse(actualWoodenStep.isInverted());
  }

  /**
   * Test {@link WoodenStep#WoodenStep(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#WoodenStep(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new WoodenStep(TreeSpecies, boolean); when 'GENERIC'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.<init>(TreeSpecies, boolean)"})
  void testNewWoodenStep_whenGeneric_thenReturnDataIsZero2() {
    // Arrange and Act
    WoodenStep actualWoodenStep = new WoodenStep(TreeSpecies.GENERIC, false);

    // Assert
    assertEquals((byte) 0, actualWoodenStep.getData());
    assertEquals(Material.LEGACY_WOOD_STEP, actualWoodenStep.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWoodenStep.getSpecies());
    assertFalse(actualWoodenStep.isInverted());
  }

  /**
   * Test {@link WoodenStep#WoodenStep(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Inverted.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#WoodenStep(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName("Test new WoodenStep(TreeSpecies, boolean); when 'true'; then return Inverted")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.<init>(TreeSpecies, boolean)"})
  void testNewWoodenStep_whenTrue_thenReturnInverted() {
    // Arrange and Act
    WoodenStep actualWoodenStep = new WoodenStep(TreeSpecies.GENERIC, true);

    // Assert
    assertEquals(Material.LEGACY_WOOD_STEP, actualWoodenStep.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWoodenStep.getSpecies());
    assertTrue(actualWoodenStep.isInverted());
    assertEquals('\b', actualWoodenStep.getData());
  }

  /**
   * Test {@link WoodenStep#isInverted()}.
   *
   * <ul>
   *   <li>Given {@link WoodenStep#WoodenStep(Material, byte)} with type is {@code ACACIA_BOAT} and
   *       data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#isInverted()}
   */
  @Test
  @DisplayName(
      "Test isInverted(); given WoodenStep(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WoodenStep.isInverted()"})
  void testIsInverted_givenWoodenStepWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new WoodenStep(Material.ACACIA_BOAT, (byte) 'X').isInverted());
  }

  /**
   * Test {@link WoodenStep#isInverted()}.
   *
   * <ul>
   *   <li>Given {@link WoodenStep#WoodenStep()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#isInverted()}
   */
  @Test
  @DisplayName("Test isInverted(); given WoodenStep(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WoodenStep.isInverted()"})
  void testIsInverted_givenWoodenStep_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new WoodenStep().isInverted());
  }

  /**
   * Test {@link WoodenStep#setInverted(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link WoodenStep#WoodenStep()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#setInverted(boolean)}
   */
  @Test
  @DisplayName("Test setInverted(boolean); when 'false'; then WoodenStep() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.setInverted(boolean)"})
  void testSetInverted_whenFalse_thenWoodenStepDataIsZero() {
    // Arrange
    WoodenStep woodenStep = new WoodenStep();

    // Act
    woodenStep.setInverted(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, woodenStep.getData());
    assertFalse(woodenStep.isInverted());
  }

  /**
   * Test {@link WoodenStep#setInverted(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link WoodenStep#WoodenStep()} Inverted.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#setInverted(boolean)}
   */
  @Test
  @DisplayName("Test setInverted(boolean); when 'true'; then WoodenStep() Inverted")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WoodenStep.setInverted(boolean)"})
  void testSetInverted_whenTrue_thenWoodenStepInverted() {
    // Arrange
    WoodenStep woodenStep = new WoodenStep();

    // Act
    woodenStep.setInverted(true);

    // Assert
    assertTrue(woodenStep.isInverted());
    assertEquals('\b', woodenStep.getData());
  }

  /**
   * Test {@link WoodenStep#clone()}.
   *
   * <p>Method under test: {@link WoodenStep#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WoodenStep WoodenStep.clone()"})
  void testClone() {
    // Arrange
    WoodenStep woodenStep = new WoodenStep();

    // Act
    WoodenStep actualCloneResult = woodenStep.clone();

    // Assert
    assertEquals(woodenStep, actualCloneResult);
  }

  /**
   * Test {@link WoodenStep#toString()}.
   *
   * <ul>
   *   <li>Given {@link WoodenStep#WoodenStep()}.
   *   <li>Then return {@code GENERIC LEGACY_WOOD_STEP(0) GENERIC}.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given WoodenStep(); then return 'GENERIC LEGACY_WOOD_STEP(0) GENERIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WoodenStep.toString()"})
  void testToString_givenWoodenStep_thenReturnGenericLegacyWoodStep0Generic() {
    // Arrange, Act and Assert
    assertEquals("GENERIC LEGACY_WOOD_STEP(0) GENERIC", new WoodenStep().toString());
  }

  /**
   * Test {@link WoodenStep#toString()}.
   *
   * <ul>
   *   <li>Then return {@code GENERIC LEGACY_WOOD_STEP(88) GENERIC inverted}.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'GENERIC LEGACY_WOOD_STEP(88) GENERIC inverted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WoodenStep.toString()"})
  void testToString_thenReturnGenericLegacyWoodStep88GenericInverted() {
    // Arrange
    WoodenStep woodenStep = new WoodenStep();
    woodenStep.setData((byte) 'X');

    // Act and Assert
    assertEquals("GENERIC LEGACY_WOOD_STEP(88) GENERIC inverted", woodenStep.toString());
  }

  /**
   * Test {@link WoodenStep#toString()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WoodenStep#toString()}
   */
  @Test
  @DisplayName("Test toString(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WoodenStep.toString()"})
  void testToString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new WoodenStep(Material.ACACIA_BOAT, (byte) 'A').toString());
  }
}
