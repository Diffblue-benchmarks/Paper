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

class PistonBaseMaterialDiffblueTest {
  /**
   * Test {@link PistonBaseMaterial#PistonBaseMaterial(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#PistonBaseMaterial(Material, byte)}
   */
  @Test
  @DisplayName("Test new PistonBaseMaterial(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PistonBaseMaterial.<init>(Material)",
    "void PistonBaseMaterial.<init>(Material, byte)"
  })
  void testNewPistonBaseMaterial_whenA_thenReturnDataIsA() {
    // Arrange and Act
    PistonBaseMaterial actualPistonBaseMaterial =
        new PistonBaseMaterial(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualPistonBaseMaterial.getItemType());
    assertEquals('A', actualPistonBaseMaterial.getData());
  }

  /**
   * Test {@link PistonBaseMaterial#PistonBaseMaterial(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#PistonBaseMaterial(Material)}
   */
  @Test
  @DisplayName(
      "Test new PistonBaseMaterial(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PistonBaseMaterial.<init>(Material)",
    "void PistonBaseMaterial.<init>(Material, byte)"
  })
  void testNewPistonBaseMaterial_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    PistonBaseMaterial actualPistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualPistonBaseMaterial.getData());
    assertEquals(Material.ACACIA_BOAT, actualPistonBaseMaterial.getItemType());
  }

  /**
   * Test {@link PistonBaseMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonBaseMaterial(Material) with type is 'ACACIA_BOAT' Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonBaseMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonBaseMaterialWithTypeIsAcaciaBoatDataIsFive() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    pistonBaseMaterial.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, pistonBaseMaterial.getData());
    assertEquals(BlockFace.EAST, pistonBaseMaterial.getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonBaseMaterial(Material) with type is 'ACACIA_BOAT' Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonBaseMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonBaseMaterialWithTypeIsAcaciaBoatDataIsFour() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    pistonBaseMaterial.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, pistonBaseMaterial.getData());
    assertEquals(BlockFace.WEST, pistonBaseMaterial.getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonBaseMaterial(Material) with type is 'ACACIA_BOAT' Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonBaseMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonBaseMaterialWithTypeIsAcaciaBoatDataIsOne() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    pistonBaseMaterial.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 1, pistonBaseMaterial.getData());
    assertEquals(BlockFace.UP, pistonBaseMaterial.getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonBaseMaterial(Material) with type is 'ACACIA_BOAT' Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonBaseMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonBaseMaterialWithTypeIsAcaciaBoatDataIsThree() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    pistonBaseMaterial.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, pistonBaseMaterial.getData());
    assertEquals(BlockFace.SOUTH, pistonBaseMaterial.getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonBaseMaterial(Material) with type is 'ACACIA_BOAT' Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonBaseMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonBaseMaterialWithTypeIsAcaciaBoatDataIsTwo() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    pistonBaseMaterial.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, pistonBaseMaterial.getData());
    assertEquals(BlockFace.NORTH, pistonBaseMaterial.getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonBaseMaterial(Material) with type is 'ACACIA_BOAT' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonBaseMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonBaseMaterialWithTypeIsAcaciaBoatDataIsZero() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    pistonBaseMaterial.setFacingDirection(BlockFace.DOWN);

    // Assert that nothing has changed
    assertEquals((byte) 0, pistonBaseMaterial.getData());
    assertEquals(BlockFace.DOWN, pistonBaseMaterial.getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link PistonBaseMaterial#PistonBaseMaterial(Material, byte)} with type is {@code
   *       ACACIA_BOAT} and data is {@code A}.
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given PistonBaseMaterial(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonBaseMaterial.getFacing()"})
  void testGetFacing_givenPistonBaseMaterialWithTypeIsAcaciaBoatAndDataIsA_thenReturnUp() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.UP, new PistonBaseMaterial(Material.ACACIA_BOAT, (byte) 'A').getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given PistonBaseMaterial(Material) with type is 'ACACIA_BOAT'; then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonBaseMaterial.getFacing()"})
  void testGetFacing_givenPistonBaseMaterialWithTypeIsAcaciaBoat_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new PistonBaseMaterial(Material.ACACIA_BOAT).getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonBaseMaterial.getFacing()"})
  void testGetFacing_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST, new PistonBaseMaterial(Material.ACACIA_BOAT, (byte) 5).getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonBaseMaterial.getFacing()"})
  void testGetFacing_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH, new PistonBaseMaterial(Material.ACACIA_BOAT, (byte) 2).getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonBaseMaterial.getFacing()"})
  void testGetFacing_thenReturnSelf() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SELF, new PistonBaseMaterial(Material.ACACIA_BOAT, (byte) 7).getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonBaseMaterial.getFacing()"})
  void testGetFacing_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SOUTH, new PistonBaseMaterial(Material.ACACIA_BOAT, (byte) 3).getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonBaseMaterial.getFacing()"})
  void testGetFacing_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.WEST, new PistonBaseMaterial(Material.ACACIA_BOAT, (byte) 4).getFacing());
  }

  /**
   * Test {@link PistonBaseMaterial#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given PistonBaseMaterial(Material) with type is 'ACACIA_BOAT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PistonBaseMaterial.isPowered()"})
  void testIsPowered_givenPistonBaseMaterialWithTypeIsAcaciaBoat_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PistonBaseMaterial(Material.ACACIA_BOAT).isPowered());
  }

  /**
   * Test {@link PistonBaseMaterial#isPowered()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PistonBaseMaterial.isPowered()"})
  void testIsPowered_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PistonBaseMaterial(Material.ACACIA_BOAT, (byte) 'X').isPowered());
  }

  /**
   * Test {@link PistonBaseMaterial#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#setPowered(boolean)}
   */
  @Test
  @DisplayName(
      "Test setPowered(boolean); when 'false'; then PistonBaseMaterial(Material) with type is 'ACACIA_BOAT' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonBaseMaterial.setPowered(boolean)"})
  void testSetPowered_whenFalse_thenPistonBaseMaterialWithTypeIsAcaciaBoatDataIsZero() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    pistonBaseMaterial.setPowered(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, pistonBaseMaterial.getData());
    assertFalse(pistonBaseMaterial.isPowered());
  }

  /**
   * Test {@link PistonBaseMaterial#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT} Powered.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#setPowered(boolean)}
   */
  @Test
  @DisplayName(
      "Test setPowered(boolean); when 'true'; then PistonBaseMaterial(Material) with type is 'ACACIA_BOAT' Powered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonBaseMaterial.setPowered(boolean)"})
  void testSetPowered_whenTrue_thenPistonBaseMaterialWithTypeIsAcaciaBoatPowered() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    pistonBaseMaterial.setPowered(true);

    // Assert
    assertTrue(pistonBaseMaterial.isPowered());
    assertEquals('\b', pistonBaseMaterial.getData());
  }

  /**
   * Test {@link PistonBaseMaterial#isSticky()}.
   *
   * <ul>
   *   <li>Given {@link PistonBaseMaterial#PistonBaseMaterial(Material)} with type is {@code
   *       ACACIA_BOAT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#isSticky()}
   */
  @Test
  @DisplayName(
      "Test isSticky(); given PistonBaseMaterial(Material) with type is 'ACACIA_BOAT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PistonBaseMaterial.isSticky()"})
  void testIsSticky_givenPistonBaseMaterialWithTypeIsAcaciaBoat_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PistonBaseMaterial(Material.ACACIA_BOAT).isSticky());
  }

  /**
   * Test {@link PistonBaseMaterial#isSticky()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PistonBaseMaterial#isSticky()}
   */
  @Test
  @DisplayName("Test isSticky(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PistonBaseMaterial.isSticky()"})
  void testIsSticky_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PistonBaseMaterial(Material.LEGACY_PISTON_STICKY_BASE).isSticky());
  }

  /**
   * Test {@link PistonBaseMaterial#clone()}.
   *
   * <p>Method under test: {@link PistonBaseMaterial#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PistonBaseMaterial PistonBaseMaterial.clone()"})
  void testClone() {
    // Arrange
    PistonBaseMaterial pistonBaseMaterial = new PistonBaseMaterial(Material.ACACIA_BOAT);

    // Act
    PistonBaseMaterial actualCloneResult = pistonBaseMaterial.clone();

    // Assert
    assertEquals(pistonBaseMaterial, actualCloneResult);
  }
}
