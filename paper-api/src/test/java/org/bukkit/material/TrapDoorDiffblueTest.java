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

class TrapDoorDiffblueTest {
  /**
   * Test {@link TrapDoor#TrapDoor()}.
   *
   * <p>Method under test: {@link TrapDoor#TrapDoor()}
   */
  @Test
  @DisplayName("Test new TrapDoor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.<init>()"})
  void testNewTrapDoor() {
    // Arrange and Act
    TrapDoor actualTrapDoor = new TrapDoor();

    // Assert
    assertEquals((byte) 0, actualTrapDoor.getData());
    assertEquals(Material.LEGACY_TRAP_DOOR, actualTrapDoor.getItemType());
    assertEquals(BlockFace.NORTH, actualTrapDoor.getFacing());
    assertEquals(BlockFace.SOUTH, actualTrapDoor.getAttachedFace());
    assertFalse(actualTrapDoor.isInverted());
    assertFalse(actualTrapDoor.isOpen());
  }

  /**
   * Test {@link TrapDoor#TrapDoor(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#TrapDoor(Material, byte)}
   */
  @Test
  @DisplayName("Test new TrapDoor(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.<init>(Material)", "void TrapDoor.<init>(Material, byte)"})
  void testNewTrapDoor_whenA_thenReturnDataIsA() {
    // Arrange and Act
    TrapDoor actualTrapDoor = new TrapDoor(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualTrapDoor.getItemType());
    assertEquals('A', actualTrapDoor.getData());
  }

  /**
   * Test {@link TrapDoor#TrapDoor(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#TrapDoor(Material)}
   */
  @Test
  @DisplayName("Test new TrapDoor(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.<init>(Material)", "void TrapDoor.<init>(Material, byte)"})
  void testNewTrapDoor_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    TrapDoor actualTrapDoor = new TrapDoor(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualTrapDoor.getData());
    assertEquals(Material.ACACIA_BOAT, actualTrapDoor.getItemType());
  }

  /**
   * Test {@link TrapDoor#isOpen()}.
   *
   * <ul>
   *   <li>Given {@link TrapDoor#TrapDoor(Material, byte)} with type is {@code ACACIA_BOAT} and data
   *       is seven.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#isOpen()}
   */
  @Test
  @DisplayName(
      "Test isOpen(); given TrapDoor(Material, byte) with type is 'ACACIA_BOAT' and data is seven; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrapDoor.isOpen()"})
  void testIsOpen_givenTrapDoorWithTypeIsAcaciaBoatAndDataIsSeven_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new TrapDoor(Material.ACACIA_BOAT, (byte) 7).isOpen());
  }

  /**
   * Test {@link TrapDoor#isOpen()}.
   *
   * <ul>
   *   <li>Given {@link TrapDoor#TrapDoor()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#isOpen()}
   */
  @Test
  @DisplayName("Test isOpen(); given TrapDoor(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrapDoor.isOpen()"})
  void testIsOpen_givenTrapDoor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TrapDoor().isOpen());
  }

  /**
   * Test {@link TrapDoor#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link TrapDoor#TrapDoor()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'false'; then TrapDoor() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.setOpen(boolean)"})
  void testSetOpen_whenFalse_thenTrapDoorDataIsZero() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    trapDoor.setOpen(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, trapDoor.getData());
    assertFalse(trapDoor.isOpen());
  }

  /**
   * Test {@link TrapDoor#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link TrapDoor#TrapDoor()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'true'; then TrapDoor() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.setOpen(boolean)"})
  void testSetOpen_whenTrue_thenTrapDoorDataIsFour() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    trapDoor.setOpen(true);

    // Assert
    assertEquals((byte) 4, trapDoor.getData());
    assertTrue(trapDoor.isOpen());
  }

  /**
   * Test {@link TrapDoor#isInverted()}.
   *
   * <ul>
   *   <li>Given {@link TrapDoor#TrapDoor(Material, byte)} with type is {@code ACACIA_BOAT} and data
   *       is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#isInverted()}
   */
  @Test
  @DisplayName(
      "Test isInverted(); given TrapDoor(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrapDoor.isInverted()"})
  void testIsInverted_givenTrapDoorWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new TrapDoor(Material.ACACIA_BOAT, (byte) 'X').isInverted());
  }

  /**
   * Test {@link TrapDoor#isInverted()}.
   *
   * <ul>
   *   <li>Given {@link TrapDoor#TrapDoor()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#isInverted()}
   */
  @Test
  @DisplayName("Test isInverted(); given TrapDoor(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrapDoor.isInverted()"})
  void testIsInverted_givenTrapDoor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TrapDoor().isInverted());
  }

  /**
   * Test {@link TrapDoor#setInverted(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link TrapDoor#TrapDoor()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#setInverted(boolean)}
   */
  @Test
  @DisplayName("Test setInverted(boolean); when 'false'; then TrapDoor() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.setInverted(boolean)"})
  void testSetInverted_whenFalse_thenTrapDoorDataIsZero() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    trapDoor.setInverted(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, trapDoor.getData());
    assertFalse(trapDoor.isInverted());
  }

  /**
   * Test {@link TrapDoor#setInverted(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link TrapDoor#TrapDoor()} Inverted.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#setInverted(boolean)}
   */
  @Test
  @DisplayName("Test setInverted(boolean); when 'true'; then TrapDoor() Inverted")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.setInverted(boolean)"})
  void testSetInverted_whenTrue_thenTrapDoorInverted() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    trapDoor.setInverted(true);

    // Assert
    assertTrue(trapDoor.isInverted());
    assertEquals('\b', trapDoor.getData());
  }

  /**
   * Test {@link TrapDoor#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link TrapDoor#TrapDoor(Material, byte)} with type is {@code ACACIA_BOAT} and data
   *       is {@code A}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given TrapDoor(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace TrapDoor.getAttachedFace()"})
  void testGetAttachedFace_givenTrapDoorWithTypeIsAcaciaBoatAndDataIsA_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new TrapDoor(Material.ACACIA_BOAT, (byte) 'A').getAttachedFace());
  }

  /**
   * Test {@link TrapDoor#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link TrapDoor#TrapDoor(Material, byte)} with type is {@code ACACIA_BOAT} and data
   *       is two.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given TrapDoor(Material, byte) with type is 'ACACIA_BOAT' and data is two; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace TrapDoor.getAttachedFace()"})
  void testGetAttachedFace_givenTrapDoorWithTypeIsAcaciaBoatAndDataIsTwo_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new TrapDoor(Material.ACACIA_BOAT, (byte) 2).getAttachedFace());
  }

  /**
   * Test {@link TrapDoor#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link TrapDoor#TrapDoor()}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given TrapDoor(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace TrapDoor.getAttachedFace()"})
  void testGetAttachedFace_givenTrapDoor_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new TrapDoor().getAttachedFace());
  }

  /**
   * Test {@link TrapDoor#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace TrapDoor.getAttachedFace()"})
  void testGetAttachedFace_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new TrapDoor(Material.ACACIA_BOAT, (byte) 3).getAttachedFace());
  }

  /**
   * Test {@link TrapDoor#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link TrapDoor#TrapDoor()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then TrapDoor() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenTrapDoorDataIsThree() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    trapDoor.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 3, trapDoor.getData());
    assertEquals(BlockFace.EAST, trapDoor.getFacing());
    assertEquals(BlockFace.WEST, trapDoor.getAttachedFace());
  }

  /**
   * Test {@link TrapDoor#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link TrapDoor#TrapDoor()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then TrapDoor() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenTrapDoorDataIsZero() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    trapDoor.setFacingDirection(BlockFace.NORTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, trapDoor.getData());
    assertEquals(BlockFace.NORTH, trapDoor.getFacing());
    assertEquals(BlockFace.SOUTH, trapDoor.getAttachedFace());
  }

  /**
   * Test {@link TrapDoor#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link TrapDoor#TrapDoor()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then TrapDoor() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenTrapDoorDataIsOne() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    trapDoor.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 1, trapDoor.getData());
    assertEquals(BlockFace.NORTH, trapDoor.getAttachedFace());
    assertEquals(BlockFace.SOUTH, trapDoor.getFacing());
  }

  /**
   * Test {@link TrapDoor#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link TrapDoor#TrapDoor()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then TrapDoor() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrapDoor.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenTrapDoorDataIsTwo() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    trapDoor.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 2, trapDoor.getData());
    assertEquals(BlockFace.EAST, trapDoor.getAttachedFace());
    assertEquals(BlockFace.WEST, trapDoor.getFacing());
  }

  /**
   * Test {@link TrapDoor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code CLOSED ACACIA_BOAT(2) facing WEST with hinges set EAST}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'CLOSED ACACIA_BOAT(2) facing WEST with hinges set EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TrapDoor.toString()"})
  void testToString_thenReturnClosedAcaciaBoat2FacingWestWithHingesSetEast() {
    // Arrange, Act and Assert
    assertEquals(
        "CLOSED ACACIA_BOAT(2) facing WEST with hinges set EAST",
        new TrapDoor(Material.ACACIA_BOAT, (byte) 2).toString());
  }

  /**
   * Test {@link TrapDoor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code CLOSED ACACIA_BOAT(3) facing EAST with hinges set WEST}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'CLOSED ACACIA_BOAT(3) facing EAST with hinges set WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TrapDoor.toString()"})
  void testToString_thenReturnClosedAcaciaBoat3FacingEastWithHingesSetWest() {
    // Arrange, Act and Assert
    assertEquals(
        "CLOSED ACACIA_BOAT(3) facing EAST with hinges set WEST",
        new TrapDoor(Material.ACACIA_BOAT, (byte) 3).toString());
  }

  /**
   * Test {@link TrapDoor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code CLOSED ACACIA_BOAT(65) facing SOUTH with hinges set NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'CLOSED ACACIA_BOAT(65) facing SOUTH with hinges set NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TrapDoor.toString()"})
  void testToString_thenReturnClosedAcaciaBoat65FacingSouthWithHingesSetNorth() {
    // Arrange, Act and Assert
    assertEquals(
        "CLOSED ACACIA_BOAT(65) facing SOUTH with hinges set NORTH",
        new TrapDoor(Material.ACACIA_BOAT, (byte) 'A').toString());
  }

  /**
   * Test {@link TrapDoor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code CLOSED ACACIA_BOAT(88) facing NORTH with hinges set SOUTH inverted}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'CLOSED ACACIA_BOAT(88) facing NORTH with hinges set SOUTH inverted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TrapDoor.toString()"})
  void testToString_thenReturnClosedAcaciaBoat88FacingNorthWithHingesSetSouthInverted() {
    // Arrange, Act and Assert
    assertEquals(
        "CLOSED ACACIA_BOAT(88) facing NORTH with hinges set SOUTH inverted",
        new TrapDoor(Material.ACACIA_BOAT, (byte) 'X').toString());
  }

  /**
   * Test {@link TrapDoor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code CLOSED LEGACY_TRAP_DOOR(0) facing NORTH with hinges set SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'CLOSED LEGACY_TRAP_DOOR(0) facing NORTH with hinges set SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TrapDoor.toString()"})
  void testToString_thenReturnClosedLegacyTrapDoor0FacingNorthWithHingesSetSouth() {
    // Arrange, Act and Assert
    assertEquals(
        "CLOSED LEGACY_TRAP_DOOR(0) facing NORTH with hinges set SOUTH", new TrapDoor().toString());
  }

  /**
   * Test {@link TrapDoor#toString()}.
   *
   * <ul>
   *   <li>Then return {@code OPEN ACACIA_BOAT(4) facing NORTH with hinges set SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link TrapDoor#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'OPEN ACACIA_BOAT(4) facing NORTH with hinges set SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TrapDoor.toString()"})
  void testToString_thenReturnOpenAcaciaBoat4FacingNorthWithHingesSetSouth() {
    // Arrange, Act and Assert
    assertEquals(
        "OPEN ACACIA_BOAT(4) facing NORTH with hinges set SOUTH",
        new TrapDoor(Material.ACACIA_BOAT, (byte) 4).toString());
  }

  /**
   * Test {@link TrapDoor#clone()}.
   *
   * <p>Method under test: {@link TrapDoor#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrapDoor TrapDoor.clone()"})
  void testClone() {
    // Arrange
    TrapDoor trapDoor = new TrapDoor();

    // Act
    TrapDoor actualCloneResult = trapDoor.clone();

    // Assert
    assertEquals(trapDoor, actualCloneResult);
  }
}
