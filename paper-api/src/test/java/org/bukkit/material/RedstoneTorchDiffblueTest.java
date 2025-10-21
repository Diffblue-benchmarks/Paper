package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RedstoneTorchDiffblueTest {
  /**
   * Test {@link RedstoneTorch#RedstoneTorch()}.
   *
   * <p>Method under test: {@link RedstoneTorch#RedstoneTorch()}
   */
  @Test
  @DisplayName("Test new RedstoneTorch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RedstoneTorch.<init>()"})
  void testNewRedstoneTorch() {
    // Arrange and Act
    RedstoneTorch actualRedstoneTorch = new RedstoneTorch();

    // Assert
    assertEquals((byte) 0, actualRedstoneTorch.getData());
    assertEquals(Material.LEGACY_REDSTONE_TORCH_ON, actualRedstoneTorch.getItemType());
    assertEquals(BlockFace.DOWN, actualRedstoneTorch.getAttachedFace());
    assertEquals(BlockFace.UP, actualRedstoneTorch.getFacing());
    assertTrue(actualRedstoneTorch.isPowered());
  }

  /**
   * Test {@link RedstoneTorch#RedstoneTorch(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneTorch#RedstoneTorch(Material, byte)}
   */
  @Test
  @DisplayName("Test new RedstoneTorch(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RedstoneTorch.<init>(Material)",
    "void RedstoneTorch.<init>(Material, byte)"
  })
  void testNewRedstoneTorch_whenA_thenReturnDataIsA() {
    // Arrange and Act
    RedstoneTorch actualRedstoneTorch = new RedstoneTorch(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualRedstoneTorch.getItemType());
    assertEquals('A', actualRedstoneTorch.getData());
  }

  /**
   * Test {@link RedstoneTorch#RedstoneTorch(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneTorch#RedstoneTorch(Material)}
   */
  @Test
  @DisplayName("Test new RedstoneTorch(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RedstoneTorch.<init>(Material)",
    "void RedstoneTorch.<init>(Material, byte)"
  })
  void testNewRedstoneTorch_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    RedstoneTorch actualRedstoneTorch = new RedstoneTorch(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualRedstoneTorch.getData());
    assertEquals(Material.ACACIA_BOAT, actualRedstoneTorch.getItemType());
  }

  /**
   * Test {@link RedstoneTorch#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link RedstoneTorch#RedstoneTorch(Material)} with type is {@code ACACIA_BOAT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneTorch#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given RedstoneTorch(Material) with type is 'ACACIA_BOAT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RedstoneTorch.isPowered()"})
  void testIsPowered_givenRedstoneTorchWithTypeIsAcaciaBoat_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RedstoneTorch(Material.ACACIA_BOAT).isPowered());
  }

  /**
   * Test {@link RedstoneTorch#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link RedstoneTorch#RedstoneTorch()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneTorch#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given RedstoneTorch(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RedstoneTorch.isPowered()"})
  void testIsPowered_givenRedstoneTorch_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new RedstoneTorch().isPowered());
  }

  /**
   * Test {@link RedstoneTorch#toString()}.
   *
   * <ul>
   *   <li>Given {@link RedstoneTorch#RedstoneTorch()}.
   *   <li>Then return {@code LEGACY_REDSTONE_TORCH_ON(0) facing UP POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneTorch#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given RedstoneTorch(); then return 'LEGACY_REDSTONE_TORCH_ON(0) facing UP POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RedstoneTorch.toString()"})
  void testToString_givenRedstoneTorch_thenReturnLegacyRedstoneTorchOn0FacingUpPowered() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_REDSTONE_TORCH_ON(0) facing UP POWERED", new RedstoneTorch().toString());
  }

  /**
   * Test {@link RedstoneTorch#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(0) facing UP NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneTorch#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(0) facing UP NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RedstoneTorch.toString()"})
  void testToString_thenReturnAcaciaBoat0FacingUpNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(0) facing UP NOT POWERED", new RedstoneTorch(Material.ACACIA_BOAT).toString());
  }

  /**
   * Test {@link RedstoneTorch#clone()}.
   *
   * <p>Method under test: {@link RedstoneTorch#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RedstoneTorch RedstoneTorch.clone()"})
  void testClone() {
    // Arrange
    RedstoneTorch redstoneTorch = new RedstoneTorch();

    // Act
    RedstoneTorch actualCloneResult = redstoneTorch.clone();

    // Assert
    assertEquals(redstoneTorch, actualCloneResult);
  }
}
