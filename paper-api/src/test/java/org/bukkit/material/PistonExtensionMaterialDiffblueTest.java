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

class PistonExtensionMaterialDiffblueTest {
  /**
   * Test {@link PistonExtensionMaterial#PistonExtensionMaterial(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#PistonExtensionMaterial(Material, byte)}
   */
  @Test
  @DisplayName(
      "Test new PistonExtensionMaterial(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PistonExtensionMaterial.<init>(Material)",
    "void PistonExtensionMaterial.<init>(Material, byte)"
  })
  void testNewPistonExtensionMaterial_whenA_thenReturnDataIsA() {
    // Arrange and Act
    PistonExtensionMaterial actualPistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualPistonExtensionMaterial.getItemType());
    assertEquals('A', actualPistonExtensionMaterial.getData());
  }

  /**
   * Test {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)}
   */
  @Test
  @DisplayName(
      "Test new PistonExtensionMaterial(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PistonExtensionMaterial.<init>(Material)",
    "void PistonExtensionMaterial.<init>(Material, byte)"
  })
  void testNewPistonExtensionMaterial_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    PistonExtensionMaterial actualPistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualPistonExtensionMaterial.getData());
    assertEquals(Material.ACACIA_BOAT, actualPistonExtensionMaterial.getItemType());
  }

  /**
   * Test {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}.
   *
   * <p>Method under test: {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonExtensionMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    pistonExtensionMaterial.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, pistonExtensionMaterial.getData());
    assertEquals(BlockFace.NORTH, pistonExtensionMaterial.getAttachedFace());
    assertEquals(BlockFace.SOUTH, pistonExtensionMaterial.getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT' Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonExtensionMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonExtensionMaterialWithTypeIsAcaciaBoatDataIsFive() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    pistonExtensionMaterial.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, pistonExtensionMaterial.getData());
    assertEquals(BlockFace.EAST, pistonExtensionMaterial.getFacing());
    assertEquals(BlockFace.WEST, pistonExtensionMaterial.getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT' Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonExtensionMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonExtensionMaterialWithTypeIsAcaciaBoatDataIsFour() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    pistonExtensionMaterial.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, pistonExtensionMaterial.getData());
    assertEquals(BlockFace.EAST, pistonExtensionMaterial.getAttachedFace());
    assertEquals(BlockFace.WEST, pistonExtensionMaterial.getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT' Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonExtensionMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonExtensionMaterialWithTypeIsAcaciaBoatDataIsOne() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    pistonExtensionMaterial.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 1, pistonExtensionMaterial.getData());
    assertEquals(BlockFace.DOWN, pistonExtensionMaterial.getAttachedFace());
    assertEquals(BlockFace.UP, pistonExtensionMaterial.getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT' Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonExtensionMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonExtensionMaterialWithTypeIsAcaciaBoatDataIsTwo() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    pistonExtensionMaterial.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, pistonExtensionMaterial.getData());
    assertEquals(BlockFace.NORTH, pistonExtensionMaterial.getFacing());
    assertEquals(BlockFace.SOUTH, pistonExtensionMaterial.getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonExtensionMaterial.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenPistonExtensionMaterialWithTypeIsAcaciaBoatDataIsZero() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    pistonExtensionMaterial.setFacingDirection(BlockFace.DOWN);

    // Assert that nothing has changed
    assertEquals((byte) 0, pistonExtensionMaterial.getData());
    assertEquals(BlockFace.DOWN, pistonExtensionMaterial.getFacing());
    assertEquals(BlockFace.UP, pistonExtensionMaterial.getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT'; then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getFacing()"})
  void testGetFacing_givenPistonExtensionMaterialWithTypeIsAcaciaBoat_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new PistonExtensionMaterial(Material.ACACIA_BOAT).getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getFacing()"})
  void testGetFacing_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST, new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 5).getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getFacing()"})
  void testGetFacing_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH, new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 2).getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getFacing()"})
  void testGetFacing_thenReturnSelf() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SELF, new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 7).getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getFacing()"})
  void testGetFacing_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SOUTH, new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 3).getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getFacing()"})
  void testGetFacing_thenReturnUp() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.UP, new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 'A').getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getFacing()"})
  void testGetFacing_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.WEST, new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 4).getFacing());
  }

  /**
   * Test {@link PistonExtensionMaterial#isSticky()}.
   *
   * <ul>
   *   <li>Given {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#isSticky()}
   */
  @Test
  @DisplayName(
      "Test isSticky(); given PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PistonExtensionMaterial.isSticky()"})
  void testIsSticky_givenPistonExtensionMaterialWithTypeIsAcaciaBoat_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PistonExtensionMaterial(Material.ACACIA_BOAT).isSticky());
  }

  /**
   * Test {@link PistonExtensionMaterial#isSticky()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#isSticky()}
   */
  @Test
  @DisplayName("Test isSticky(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PistonExtensionMaterial.isSticky()"})
  void testIsSticky_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 'X').isSticky());
  }

  /**
   * Test {@link PistonExtensionMaterial#setSticky(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#setSticky(boolean)}
   */
  @Test
  @DisplayName(
      "Test setSticky(boolean); then PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonExtensionMaterial.setSticky(boolean)"})
  void testSetSticky_thenPistonExtensionMaterialWithTypeIsAcaciaBoatDataIsZero() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    pistonExtensionMaterial.setSticky(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, pistonExtensionMaterial.getData());
    assertFalse(pistonExtensionMaterial.isSticky());
  }

  /**
   * Test {@link PistonExtensionMaterial#setSticky(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PistonExtensionMaterial#PistonExtensionMaterial(Material)} with type is
   *       {@code ACACIA_BOAT} Sticky.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#setSticky(boolean)}
   */
  @Test
  @DisplayName(
      "Test setSticky(boolean); when 'true'; then PistonExtensionMaterial(Material) with type is 'ACACIA_BOAT' Sticky")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PistonExtensionMaterial.setSticky(boolean)"})
  void testSetSticky_whenTrue_thenPistonExtensionMaterialWithTypeIsAcaciaBoatSticky() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    pistonExtensionMaterial.setSticky(true);

    // Assert
    assertTrue(pistonExtensionMaterial.isSticky());
    assertEquals('\b', pistonExtensionMaterial.getData());
  }

  /**
   * Test {@link PistonExtensionMaterial#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getAttachedFace()"})
  void testGetAttachedFace_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.DOWN,
        new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 'A').getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getAttachedFace()"})
  void testGetAttachedFace_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST,
        new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 4).getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getAttachedFace()"})
  void testGetAttachedFace_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH,
        new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 3).getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getAttachedFace()"})
  void testGetAttachedFace_thenReturnSelf() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SELF,
        new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 7).getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getAttachedFace()"})
  void testGetAttachedFace_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SOUTH,
        new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 2).getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getAttachedFace()"})
  void testGetAttachedFace_thenReturnUp() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.UP, new PistonExtensionMaterial(Material.ACACIA_BOAT).getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link PistonExtensionMaterial#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace PistonExtensionMaterial.getAttachedFace()"})
  void testGetAttachedFace_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.WEST,
        new PistonExtensionMaterial(Material.ACACIA_BOAT, (byte) 5).getAttachedFace());
  }

  /**
   * Test {@link PistonExtensionMaterial#clone()}.
   *
   * <p>Method under test: {@link PistonExtensionMaterial#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PistonExtensionMaterial PistonExtensionMaterial.clone()"})
  void testClone() {
    // Arrange
    PistonExtensionMaterial pistonExtensionMaterial =
        new PistonExtensionMaterial(Material.ACACIA_BOAT);

    // Act
    PistonExtensionMaterial actualCloneResult = pistonExtensionMaterial.clone();

    // Assert
    assertEquals(pistonExtensionMaterial, actualCloneResult);
  }
}
