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

class GateDiffblueTest {
  /**
   * Test {@link Gate#Gate(Material, byte)}.
   *
   * <p>Method under test: {@link Gate#Gate(Material, byte)}
   */
  @Test
  @DisplayName("Test new Gate(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.<init>(Material, byte)"})
  void testNewGate() {
    // Arrange and Act
    Gate actualGate = new Gate(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualGate.getItemType());
    assertEquals('A', actualGate.getData());
  }

  /**
   * Test {@link Gate#Gate()}.
   *
   * <p>Method under test: {@link Gate#Gate()}
   */
  @Test
  @DisplayName("Test new Gate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.<init>()"})
  void testNewGate2() {
    // Arrange and Act
    Gate actualGate = new Gate();

    // Assert
    assertEquals((byte) 0, actualGate.getData());
    assertEquals(Material.LEGACY_FENCE_GATE, actualGate.getItemType());
    assertEquals(BlockFace.EAST, actualGate.getFacing());
    assertFalse(actualGate.isOpen());
  }

  /**
   * Test {@link Gate#Gate(byte)}.
   *
   * <p>Method under test: {@link Gate#Gate(byte)}
   */
  @Test
  @DisplayName("Test new Gate(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.<init>(byte)"})
  void testNewGate3() {
    // Arrange and Act
    Gate actualGate = new Gate((byte) 'A');

    // Assert
    assertEquals(Material.LEGACY_FENCE_GATE, actualGate.getItemType());
    assertEquals(BlockFace.SOUTH, actualGate.getFacing());
    assertFalse(actualGate.isOpen());
    assertEquals('A', actualGate.getData());
  }

  /**
   * Test {@link Gate#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Gate#Gate()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Gate#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Gate() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenGateDataIsZero() {
    // Arrange
    Gate gate = new Gate();

    // Act
    gate.setFacingDirection(BlockFace.EAST);

    // Assert that nothing has changed
    assertEquals((byte) 0, gate.getData());
    assertEquals(BlockFace.EAST, gate.getFacing());
  }

  /**
   * Test {@link Gate#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Gate#Gate()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Gate#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Gate() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenGateDataIsThree() {
    // Arrange
    Gate gate = new Gate();

    // Act
    gate.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 3, gate.getData());
    assertEquals(BlockFace.NORTH, gate.getFacing());
  }

  /**
   * Test {@link Gate#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Gate#Gate()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Gate#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Gate() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenGateDataIsOne() {
    // Arrange
    Gate gate = new Gate();

    // Act
    gate.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 1, gate.getData());
    assertEquals(BlockFace.SOUTH, gate.getFacing());
  }

  /**
   * Test {@link Gate#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Gate#Gate()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Gate#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Gate() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenGateDataIsTwo() {
    // Arrange
    Gate gate = new Gate();

    // Act
    gate.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 2, gate.getData());
    assertEquals(BlockFace.WEST, gate.getFacing());
  }

  /**
   * Test {@link Gate#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate(byte)} with data is {@code A}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Gate(byte) with data is 'A'; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Gate.getFacing()"})
  void testGetFacing_givenGateWithDataIsA_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Gate((byte) 'A').getFacing());
  }

  /**
   * Test {@link Gate#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate(byte)} with data is three.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Gate(byte) with data is three; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Gate.getFacing()"})
  void testGetFacing_givenGateWithDataIsThree_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Gate((byte) 3).getFacing());
  }

  /**
   * Test {@link Gate#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate(byte)} with data is two.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Gate(byte) with data is two; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Gate.getFacing()"})
  void testGetFacing_givenGateWithDataIsTwo_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Gate((byte) 2).getFacing());
  }

  /**
   * Test {@link Gate#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate()}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Gate(); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Gate.getFacing()"})
  void testGetFacing_givenGate_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Gate().getFacing());
  }

  /**
   * Test {@link Gate#isOpen()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate(byte)} with data is minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#isOpen()}
   */
  @Test
  @DisplayName("Test isOpen(); given Gate(byte) with data is minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Gate.isOpen()"})
  void testIsOpen_givenGateWithDataIsMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Gate((byte) -1).isOpen());
  }

  /**
   * Test {@link Gate#isOpen()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#isOpen()}
   */
  @Test
  @DisplayName("Test isOpen(); given Gate(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Gate.isOpen()"})
  void testIsOpen_givenGate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Gate().isOpen());
  }

  /**
   * Test {@link Gate#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Gate#Gate()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Gate#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'false'; then Gate() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.setOpen(boolean)"})
  void testSetOpen_whenFalse_thenGateDataIsZero() {
    // Arrange
    Gate gate = new Gate();

    // Act
    gate.setOpen(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, gate.getData());
    assertFalse(gate.isOpen());
  }

  /**
   * Test {@link Gate#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Gate#Gate()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Gate#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'true'; then Gate() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Gate.setOpen(boolean)"})
  void testSetOpen_whenTrue_thenGateDataIsFour() {
    // Arrange
    Gate gate = new Gate();

    // Act
    gate.setOpen(true);

    // Assert
    assertEquals((byte) 4, gate.getData());
    assertTrue(gate.isOpen());
  }

  /**
   * Test {@link Gate#toString()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate(byte)} with data is {@code A}.
   *   <li>Then return {@code CLOSED facing and opening SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Gate(byte) with data is 'A'; then return 'CLOSED facing and opening SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Gate.toString()"})
  void testToString_givenGateWithDataIsA_thenReturnClosedFacingAndOpeningSouth() {
    // Arrange, Act and Assert
    assertEquals("CLOSED  facing and opening SOUTH", new Gate((byte) 'A').toString());
  }

  /**
   * Test {@link Gate#toString()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate(byte)} with data is four.
   *   <li>Then return {@code OPEN facing and opening EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Gate(byte) with data is four; then return 'OPEN facing and opening EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Gate.toString()"})
  void testToString_givenGateWithDataIsFour_thenReturnOpenFacingAndOpeningEast() {
    // Arrange, Act and Assert
    assertEquals("OPEN  facing and opening EAST", new Gate((byte) 4).toString());
  }

  /**
   * Test {@link Gate#toString()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate(byte)} with data is three.
   *   <li>Then return {@code CLOSED facing and opening NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Gate(byte) with data is three; then return 'CLOSED facing and opening NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Gate.toString()"})
  void testToString_givenGateWithDataIsThree_thenReturnClosedFacingAndOpeningNorth() {
    // Arrange, Act and Assert
    assertEquals("CLOSED  facing and opening NORTH", new Gate((byte) 3).toString());
  }

  /**
   * Test {@link Gate#toString()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate(byte)} with data is two.
   *   <li>Then return {@code CLOSED facing and opening WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Gate(byte) with data is two; then return 'CLOSED facing and opening WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Gate.toString()"})
  void testToString_givenGateWithDataIsTwo_thenReturnClosedFacingAndOpeningWest() {
    // Arrange, Act and Assert
    assertEquals("CLOSED  facing and opening WEST", new Gate((byte) 2).toString());
  }

  /**
   * Test {@link Gate#toString()}.
   *
   * <ul>
   *   <li>Given {@link Gate#Gate()}.
   *   <li>Then return {@code CLOSED facing and opening EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Gate#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Gate(); then return 'CLOSED facing and opening EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Gate.toString()"})
  void testToString_givenGate_thenReturnClosedFacingAndOpeningEast() {
    // Arrange, Act and Assert
    assertEquals("CLOSED  facing and opening EAST", new Gate().toString());
  }

  /**
   * Test {@link Gate#clone()}.
   *
   * <p>Method under test: {@link Gate#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Gate Gate.clone()"})
  void testClone() {
    // Arrange
    Gate gate = new Gate();

    // Act
    Gate actualCloneResult = gate.clone();

    // Assert
    assertEquals(gate, actualCloneResult);
  }
}
