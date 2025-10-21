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

class StairsDiffblueTest {
  /**
   * Test {@link Stairs#Stairs(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#Stairs(Material, byte)}
   */
  @Test
  @DisplayName("Test new Stairs(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stairs.<init>(Material)", "void Stairs.<init>(Material, byte)"})
  void testNewStairs_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Stairs actualStairs = new Stairs(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualStairs.getItemType());
    assertEquals('A', actualStairs.getData());
  }

  /**
   * Test {@link Stairs#Stairs(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#Stairs(Material)}
   */
  @Test
  @DisplayName("Test new Stairs(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stairs.<init>(Material)", "void Stairs.<init>(Material, byte)"})
  void testNewStairs_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Stairs actualStairs = new Stairs(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualStairs.getData());
    assertEquals(Material.ACACIA_BOAT, actualStairs.getItemType());
  }

  /**
   * Test {@link Stairs#getAscendingDirection()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getAscendingDirection()}
   */
  @Test
  @DisplayName(
      "Test getAscendingDirection(); given Stairs(Material) with type is 'ACACIA_BOAT'; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getAscendingDirection()"})
  void testGetAscendingDirection_givenStairsWithTypeIsAcaciaBoat_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Stairs(Material.ACACIA_BOAT).getAscendingDirection());
  }

  /**
   * Test {@link Stairs#getAscendingDirection()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getAscendingDirection()}
   */
  @Test
  @DisplayName("Test getAscendingDirection(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getAscendingDirection()"})
  void testGetAscendingDirection_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH, new Stairs(Material.ACACIA_BOAT, (byte) 3).getAscendingDirection());
  }

  /**
   * Test {@link Stairs#getAscendingDirection()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getAscendingDirection()}
   */
  @Test
  @DisplayName("Test getAscendingDirection(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getAscendingDirection()"})
  void testGetAscendingDirection_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SOUTH, new Stairs(Material.ACACIA_BOAT, (byte) 2).getAscendingDirection());
  }

  /**
   * Test {@link Stairs#getAscendingDirection()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getAscendingDirection()}
   */
  @Test
  @DisplayName("Test getAscendingDirection(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getAscendingDirection()"})
  void testGetAscendingDirection_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.WEST, new Stairs(Material.ACACIA_BOAT, (byte) 'A').getAscendingDirection());
  }

  /**
   * Test {@link Stairs#getDescendingDirection()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getDescendingDirection()}
   */
  @Test
  @DisplayName(
      "Test getDescendingDirection(); given Stairs(Material) with type is 'ACACIA_BOAT'; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getDescendingDirection()"})
  void testGetDescendingDirection_givenStairsWithTypeIsAcaciaBoat_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Stairs(Material.ACACIA_BOAT).getDescendingDirection());
  }

  /**
   * Test {@link Stairs#getDescendingDirection()}.
   *
   * <ul>
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getDescendingDirection()}
   */
  @Test
  @DisplayName("Test getDescendingDirection(); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getDescendingDirection()"})
  void testGetDescendingDirection_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST, new Stairs(Material.ACACIA_BOAT, (byte) 'A').getDescendingDirection());
  }

  /**
   * Test {@link Stairs#getDescendingDirection()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getDescendingDirection()}
   */
  @Test
  @DisplayName("Test getDescendingDirection(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getDescendingDirection()"})
  void testGetDescendingDirection_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH, new Stairs(Material.ACACIA_BOAT, (byte) 2).getDescendingDirection());
  }

  /**
   * Test {@link Stairs#getDescendingDirection()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getDescendingDirection()}
   */
  @Test
  @DisplayName("Test getDescendingDirection(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getDescendingDirection()"})
  void testGetDescendingDirection_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SOUTH, new Stairs(Material.ACACIA_BOAT, (byte) 3).getDescendingDirection());
  }

  /**
   * Test {@link Stairs#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'EAST'; then Stairs(Material) with type is 'ACACIA_BOAT' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stairs.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenStairsWithTypeIsAcaciaBoatDataIsZero() {
    // Arrange
    Stairs stairs = new Stairs(Material.ACACIA_BOAT);

    // Act
    stairs.setFacingDirection(BlockFace.EAST);

    // Assert that nothing has changed
    assertEquals((byte) 0, stairs.getData());
    assertEquals(BlockFace.EAST, stairs.getAscendingDirection());
    assertEquals(BlockFace.WEST, stairs.getDescendingDirection());
    assertEquals(BlockFace.WEST, stairs.getFacing());
  }

  /**
   * Test {@link Stairs#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'NORTH'; then Stairs(Material) with type is 'ACACIA_BOAT' Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stairs.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenStairsWithTypeIsAcaciaBoatDataIsThree() {
    // Arrange
    Stairs stairs = new Stairs(Material.ACACIA_BOAT);

    // Act
    stairs.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 3, stairs.getData());
    assertEquals(BlockFace.NORTH, stairs.getAscendingDirection());
    assertEquals(BlockFace.SOUTH, stairs.getDescendingDirection());
    assertEquals(BlockFace.SOUTH, stairs.getFacing());
  }

  /**
   * Test {@link Stairs#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'SOUTH'; then Stairs(Material) with type is 'ACACIA_BOAT' Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stairs.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenStairsWithTypeIsAcaciaBoatDataIsTwo() {
    // Arrange
    Stairs stairs = new Stairs(Material.ACACIA_BOAT);

    // Act
    stairs.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 2, stairs.getData());
    assertEquals(BlockFace.NORTH, stairs.getDescendingDirection());
    assertEquals(BlockFace.NORTH, stairs.getFacing());
    assertEquals(BlockFace.SOUTH, stairs.getAscendingDirection());
  }

  /**
   * Test {@link Stairs#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'WEST'; then Stairs(Material) with type is 'ACACIA_BOAT' Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stairs.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenStairsWithTypeIsAcaciaBoatDataIsOne() {
    // Arrange
    Stairs stairs = new Stairs(Material.ACACIA_BOAT);

    // Act
    stairs.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 1, stairs.getData());
    assertEquals(BlockFace.EAST, stairs.getDescendingDirection());
    assertEquals(BlockFace.EAST, stairs.getFacing());
    assertEquals(BlockFace.WEST, stairs.getAscendingDirection());
  }

  /**
   * Test {@link Stairs#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Stairs(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getFacing()"})
  void testGetFacing_givenStairsWithTypeIsAcaciaBoatAndDataIsA_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Stairs(Material.ACACIA_BOAT, (byte) 'A').getFacing());
  }

  /**
   * Test {@link Stairs#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       three.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Stairs(Material, byte) with type is 'ACACIA_BOAT' and data is three; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getFacing()"})
  void testGetFacing_givenStairsWithTypeIsAcaciaBoatAndDataIsThree_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Stairs(Material.ACACIA_BOAT, (byte) 3).getFacing());
  }

  /**
   * Test {@link Stairs#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       two.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Stairs(Material, byte) with type is 'ACACIA_BOAT' and data is two; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getFacing()"})
  void testGetFacing_givenStairsWithTypeIsAcaciaBoatAndDataIsTwo_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Stairs(Material.ACACIA_BOAT, (byte) 2).getFacing());
  }

  /**
   * Test {@link Stairs#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Stairs(Material) with type is 'ACACIA_BOAT'; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Stairs.getFacing()"})
  void testGetFacing_givenStairsWithTypeIsAcaciaBoat_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Stairs(Material.ACACIA_BOAT).getFacing());
  }

  /**
   * Test {@link Stairs#isInverted()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       form feed (ff).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#isInverted()}
   */
  @Test
  @DisplayName(
      "Test isInverted(); given Stairs(Material, byte) with type is 'ACACIA_BOAT' and data is form feed (ff); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stairs.isInverted()"})
  void testIsInverted_givenStairsWithTypeIsAcaciaBoatAndDataIsFormFeed_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Stairs(Material.ACACIA_BOAT, (byte) '\f').isInverted());
  }

  /**
   * Test {@link Stairs#isInverted()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#isInverted()}
   */
  @Test
  @DisplayName(
      "Test isInverted(); given Stairs(Material) with type is 'ACACIA_BOAT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stairs.isInverted()"})
  void testIsInverted_givenStairsWithTypeIsAcaciaBoat_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Stairs(Material.ACACIA_BOAT).isInverted());
  }

  /**
   * Test {@link Stairs#setInverted(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#setInverted(boolean)}
   */
  @Test
  @DisplayName(
      "Test setInverted(boolean); when 'false'; then Stairs(Material) with type is 'ACACIA_BOAT' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stairs.setInverted(boolean)"})
  void testSetInverted_whenFalse_thenStairsWithTypeIsAcaciaBoatDataIsZero() {
    // Arrange
    Stairs stairs = new Stairs(Material.ACACIA_BOAT);

    // Act
    stairs.setInverted(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, stairs.getData());
    assertFalse(stairs.isInverted());
  }

  /**
   * Test {@link Stairs#setInverted(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#setInverted(boolean)}
   */
  @Test
  @DisplayName(
      "Test setInverted(boolean); when 'true'; then Stairs(Material) with type is 'ACACIA_BOAT' Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stairs.setInverted(boolean)"})
  void testSetInverted_whenTrue_thenStairsWithTypeIsAcaciaBoatDataIsFour() {
    // Arrange
    Stairs stairs = new Stairs(Material.ACACIA_BOAT);

    // Act
    stairs.setInverted(true);

    // Assert
    assertEquals((byte) 4, stairs.getData());
    assertTrue(stairs.isInverted());
  }

  /**
   * Test {@link Stairs#toString()}.
   *
   * <ul>
   *   <li>Given {@link Stairs#Stairs(Material)} with type is {@code ACACIA_BOAT}.
   *   <li>Then return {@code ACACIA_BOAT(0) facing WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Stairs(Material) with type is 'ACACIA_BOAT'; then return 'ACACIA_BOAT(0) facing WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Stairs.toString()"})
  void testToString_givenStairsWithTypeIsAcaciaBoat_thenReturnAcaciaBoat0FacingWest() {
    // Arrange, Act and Assert
    assertEquals("ACACIA_BOAT(0) facing WEST", new Stairs(Material.ACACIA_BOAT).toString());
  }

  /**
   * Test {@link Stairs#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(2) facing NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(2) facing NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Stairs.toString()"})
  void testToString_thenReturnAcaciaBoat2FacingNorth() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(2) facing NORTH", new Stairs(Material.ACACIA_BOAT, (byte) 2).toString());
  }

  /**
   * Test {@link Stairs#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(3) facing SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(3) facing SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Stairs.toString()"})
  void testToString_thenReturnAcaciaBoat3FacingSouth() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(3) facing SOUTH", new Stairs(Material.ACACIA_BOAT, (byte) 3).toString());
  }

  /**
   * Test {@link Stairs#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(4) facing WEST inverted}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(4) facing WEST inverted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Stairs.toString()"})
  void testToString_thenReturnAcaciaBoat4FacingWestInverted() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(4) facing WEST inverted",
        new Stairs(Material.ACACIA_BOAT, (byte) 4).toString());
  }

  /**
   * Test {@link Stairs#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(65) facing EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Stairs#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(65) facing EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Stairs.toString()"})
  void testToString_thenReturnAcaciaBoat65FacingEast() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(65) facing EAST", new Stairs(Material.ACACIA_BOAT, (byte) 'A').toString());
  }

  /**
   * Test {@link Stairs#clone()}.
   *
   * <p>Method under test: {@link Stairs#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stairs Stairs.clone()"})
  void testClone() {
    // Arrange
    Stairs stairs = new Stairs(Material.ACACIA_BOAT);

    // Act
    Stairs actualCloneResult = stairs.clone();

    // Assert
    assertEquals(stairs, actualCloneResult);
  }
}
