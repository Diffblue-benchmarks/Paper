package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DispenserDiffblueTest {
  /**
   * Test {@link Dispenser#Dispenser()}.
   *
   * <p>Method under test: {@link Dispenser#Dispenser()}
   */
  @Test
  @DisplayName("Test new Dispenser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>()"})
  void testNewDispenser() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser();

    // Assert
    assertEquals((byte) 0, actualDispenser.getData());
    assertEquals(Material.LEGACY_DISPENSER, actualDispenser.getItemType());
    assertEquals(BlockFace.DOWN, actualDispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#Dispenser(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#Dispenser(Material, byte)}
   */
  @Test
  @DisplayName("Test new Dispenser(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>(Material)", "void Dispenser.<init>(Material, byte)"})
  void testNewDispenser_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualDispenser.getItemType());
    assertEquals('A', actualDispenser.getData());
  }

  /**
   * Test {@link Dispenser#Dispenser(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#Dispenser(Material)}
   */
  @Test
  @DisplayName("Test new Dispenser(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>(Material)", "void Dispenser.<init>(Material, byte)"})
  void testNewDispenser_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualDispenser.getData());
    assertEquals(Material.ACACIA_BOAT, actualDispenser.getItemType());
  }

  /**
   * Test {@link Dispenser#Dispenser(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#Dispenser(BlockFace)}
   */
  @Test
  @DisplayName("Test new Dispenser(BlockFace); when 'DOWN'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>(BlockFace)"})
  void testNewDispenser_whenDown_thenReturnDataIsZero() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser(BlockFace.DOWN);

    // Assert
    assertEquals((byte) 0, actualDispenser.getData());
    assertEquals(Material.LEGACY_DISPENSER, actualDispenser.getItemType());
    assertEquals(BlockFace.DOWN, actualDispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#Dispenser(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#Dispenser(BlockFace)}
   */
  @Test
  @DisplayName("Test new Dispenser(BlockFace); when 'EAST'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>(BlockFace)"})
  void testNewDispenser_whenEast_thenReturnDataIsFive() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, actualDispenser.getData());
    assertEquals(Material.LEGACY_DISPENSER, actualDispenser.getItemType());
    assertEquals(BlockFace.EAST, actualDispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#Dispenser(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#Dispenser(BlockFace)}
   */
  @Test
  @DisplayName("Test new Dispenser(BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>(BlockFace)"})
  void testNewDispenser_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualDispenser.getData());
    assertEquals(Material.LEGACY_DISPENSER, actualDispenser.getItemType());
    assertEquals(BlockFace.NORTH, actualDispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#Dispenser(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#Dispenser(BlockFace)}
   */
  @Test
  @DisplayName("Test new Dispenser(BlockFace); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>(BlockFace)"})
  void testNewDispenser_whenSouth_thenReturnDataIsThree() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, actualDispenser.getData());
    assertEquals(Material.LEGACY_DISPENSER, actualDispenser.getItemType());
    assertEquals(BlockFace.SOUTH, actualDispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#Dispenser(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#Dispenser(BlockFace)}
   */
  @Test
  @DisplayName("Test new Dispenser(BlockFace); when 'UP'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>(BlockFace)"})
  void testNewDispenser_whenUp_thenReturnDataIsOne() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser(BlockFace.UP);

    // Assert
    assertEquals((byte) 1, actualDispenser.getData());
    assertEquals(Material.LEGACY_DISPENSER, actualDispenser.getItemType());
    assertEquals(BlockFace.UP, actualDispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#Dispenser(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#Dispenser(BlockFace)}
   */
  @Test
  @DisplayName("Test new Dispenser(BlockFace); when 'WEST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.<init>(BlockFace)"})
  void testNewDispenser_whenWest_thenReturnDataIsFour() {
    // Arrange and Act
    Dispenser actualDispenser = new Dispenser(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, actualDispenser.getData());
    assertEquals(Material.LEGACY_DISPENSER, actualDispenser.getItemType());
    assertEquals(BlockFace.WEST, actualDispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then {@link Dispenser#Dispenser()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'DOWN'; then Dispenser() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenDown_thenDispenserDataIsZero() {
    // Arrange
    Dispenser dispenser = new Dispenser();

    // Act
    dispenser.setFacingDirection(BlockFace.DOWN);

    // Assert that nothing has changed
    assertEquals((byte) 0, dispenser.getData());
    assertEquals(BlockFace.DOWN, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Dispenser#Dispenser()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Dispenser() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenDispenserDataIsFive() {
    // Arrange
    Dispenser dispenser = new Dispenser();

    // Act
    dispenser.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, dispenser.getData());
    assertEquals(BlockFace.EAST, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Dispenser#Dispenser()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Dispenser() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenDispenserDataIsTwo() {
    // Arrange
    Dispenser dispenser = new Dispenser();

    // Act
    dispenser.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, dispenser.getData());
    assertEquals(BlockFace.NORTH, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Dispenser#Dispenser()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Dispenser() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenDispenserDataIsThree() {
    // Arrange
    Dispenser dispenser = new Dispenser();

    // Act
    dispenser.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, dispenser.getData());
    assertEquals(BlockFace.SOUTH, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Dispenser#Dispenser()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'UP'; then Dispenser() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenUp_thenDispenserDataIsOne() {
    // Arrange
    Dispenser dispenser = new Dispenser();

    // Act
    dispenser.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 1, dispenser.getData());
    assertEquals(BlockFace.UP, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Dispenser#Dispenser()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Dispenser() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dispenser.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenDispenserDataIsFour() {
    // Arrange
    Dispenser dispenser = new Dispenser();

    // Act
    dispenser.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, dispenser.getData());
    assertEquals(BlockFace.WEST, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Dispenser#Dispenser()} Data is {@code A}.
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Dispenser() Data is 'A'; then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Dispenser.getFacing()"})
  void testGetFacing_givenDispenserDataIsA_thenReturnUp() {
    // Arrange
    Dispenser dispenser = new Dispenser();
    dispenser.setData((byte) 'A');

    // Act and Assert
    assertEquals(BlockFace.UP, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Dispenser#Dispenser()} Data is four.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Dispenser() Data is four; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Dispenser.getFacing()"})
  void testGetFacing_givenDispenserDataIsFour_thenReturnWest() {
    // Arrange
    Dispenser dispenser = new Dispenser();
    dispenser.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.WEST, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Dispenser#Dispenser()} Data is seven.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Dispenser() Data is seven; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Dispenser.getFacing()"})
  void testGetFacing_givenDispenserDataIsSeven_thenReturnEast() {
    // Arrange
    Dispenser dispenser = new Dispenser();
    dispenser.setData((byte) 7);

    // Act and Assert
    assertEquals(BlockFace.EAST, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Dispenser#Dispenser()} Data is three.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Dispenser() Data is three; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Dispenser.getFacing()"})
  void testGetFacing_givenDispenserDataIsThree_thenReturnSouth() {
    // Arrange
    Dispenser dispenser = new Dispenser();
    dispenser.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, dispenser.getFacing());
  }

  /**
   * Test {@link Dispenser#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Dispenser#Dispenser(BlockFace)} with direction is {@code NORTH}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Dispenser(BlockFace) with direction is 'NORTH'; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Dispenser.getFacing()"})
  void testGetFacing_givenDispenserWithDirectionIsNorth_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Dispenser(BlockFace.NORTH).getFacing());
  }

  /**
   * Test {@link Dispenser#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Dispenser#Dispenser()}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Dispenser#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Dispenser(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Dispenser.getFacing()"})
  void testGetFacing_givenDispenser_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Dispenser().getFacing());
  }

  /**
   * Test {@link Dispenser#clone()}.
   *
   * <p>Method under test: {@link Dispenser#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dispenser Dispenser.clone()"})
  void testClone() {
    // Arrange
    Dispenser dispenser = new Dispenser();

    // Act
    Dispenser actualCloneResult = dispenser.clone();

    // Assert
    assertEquals(dispenser, actualCloneResult);
  }
}
