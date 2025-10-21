package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PressurePlateDiffblueTest {
  /**
   * Test {@link PressurePlate#PressurePlate()}.
   *
   * <p>Method under test: {@link PressurePlate#PressurePlate()}
   */
  @Test
  @DisplayName("Test new PressurePlate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PressurePlate.<init>()"})
  void testNewPressurePlate() {
    // Arrange and Act
    PressurePlate actualPressurePlate = new PressurePlate();

    // Assert
    assertEquals((byte) 0, actualPressurePlate.getData());
    assertEquals(Material.LEGACY_WOOD_PLATE, actualPressurePlate.getItemType());
    assertFalse(actualPressurePlate.isPressed());
  }

  /**
   * Test {@link PressurePlate#PressurePlate(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PressurePlate#PressurePlate(Material, byte)}
   */
  @Test
  @DisplayName("Test new PressurePlate(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PressurePlate.<init>(Material)",
    "void PressurePlate.<init>(Material, byte)"
  })
  void testNewPressurePlate_whenA_thenReturnDataIsA() {
    // Arrange and Act
    PressurePlate actualPressurePlate = new PressurePlate(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualPressurePlate.getItemType());
    assertEquals('A', actualPressurePlate.getData());
  }

  /**
   * Test {@link PressurePlate#PressurePlate(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PressurePlate#PressurePlate(Material)}
   */
  @Test
  @DisplayName("Test new PressurePlate(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PressurePlate.<init>(Material)",
    "void PressurePlate.<init>(Material, byte)"
  })
  void testNewPressurePlate_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    PressurePlate actualPressurePlate = new PressurePlate(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualPressurePlate.getData());
    assertEquals(Material.ACACIA_BOAT, actualPressurePlate.getItemType());
  }

  /**
   * Test {@link PressurePlate#isPressed()}.
   *
   * <ul>
   *   <li>Given {@link PressurePlate#PressurePlate(Material)} with type is {@code ACACIA_BOAT} Data
   *       is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PressurePlate#isPressed()}
   */
  @Test
  @DisplayName(
      "Test isPressed(); given PressurePlate(Material) with type is 'ACACIA_BOAT' Data is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PressurePlate.isPressed()"})
  void testIsPressed_givenPressurePlateWithTypeIsAcaciaBoatDataIsOne_thenReturnTrue() {
    // Arrange
    PressurePlate pressurePlate = new PressurePlate(Material.ACACIA_BOAT);
    pressurePlate.setData((byte) 1);

    // Act and Assert
    assertTrue(pressurePlate.isPressed());
  }

  /**
   * Test {@link PressurePlate#isPressed()}.
   *
   * <ul>
   *   <li>Given {@link PressurePlate#PressurePlate()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PressurePlate#isPressed()}
   */
  @Test
  @DisplayName("Test isPressed(); given PressurePlate(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PressurePlate.isPressed()"})
  void testIsPressed_givenPressurePlate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PressurePlate().isPressed());
  }

  /**
   * Test {@link PressurePlate#toString()}.
   *
   * <ul>
   *   <li>Given {@link PressurePlate#PressurePlate()}.
   *   <li>Then return {@code LEGACY_WOOD_PLATE(0)}.
   * </ul>
   *
   * <p>Method under test: {@link PressurePlate#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PressurePlate(); then return 'LEGACY_WOOD_PLATE(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PressurePlate.toString()"})
  void testToString_givenPressurePlate_thenReturnLegacyWoodPlate0() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_WOOD_PLATE(0)", new PressurePlate().toString());
  }

  /**
   * Test {@link PressurePlate#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(1) PRESSED}.
   * </ul>
   *
   * <p>Method under test: {@link PressurePlate#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(1) PRESSED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PressurePlate.toString()"})
  void testToString_thenReturnAcaciaBoat1Pressed() {
    // Arrange
    PressurePlate pressurePlate = new PressurePlate(Material.ACACIA_BOAT);
    pressurePlate.setData((byte) 1);

    // Act and Assert
    assertEquals("ACACIA_BOAT(1) PRESSED", pressurePlate.toString());
  }

  /**
   * Test {@link PressurePlate#clone()}.
   *
   * <p>Method under test: {@link PressurePlate#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PressurePlate PressurePlate.clone()"})
  void testClone() {
    // Arrange
    PressurePlate pressurePlate = new PressurePlate();

    // Act
    PressurePlate actualCloneResult = pressurePlate.clone();

    // Assert
    assertEquals(pressurePlate, actualCloneResult);
  }
}
