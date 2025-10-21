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

class DiodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code ACACIA_BOAT(0) facing NORTH with 1 ticks delay}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diode#Diode(Material)}
   *   <li>{@link Diode#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return toString is 'ACACIA_BOAT(0) facing NORTH with 1 ticks delay'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Diode.<init>(Material)",
    "void Diode.<init>(Material, byte)",
    "java.lang.String Diode.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsAcaciaBoat0FacingNorthWith1TicksDelay() {
    // Arrange and Act
    Diode actualDiode = new Diode(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) facing NORTH with 1 ticks delay", actualDiode.toString());
    assertEquals((byte) 0, actualDiode.getData());
    assertEquals(Material.ACACIA_BOAT, actualDiode.getItemType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code ACACIA_BOAT(65) facing EAST with 17 ticks delay}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Diode#Diode(Material, byte)}
   *   <li>{@link Diode#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return toString is 'ACACIA_BOAT(65) facing EAST with 17 ticks delay'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Diode.<init>(Material)",
    "void Diode.<init>(Material, byte)",
    "java.lang.String Diode.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsAcaciaBoat65FacingEastWith17TicksDelay() {
    // Arrange and Act
    Diode actualDiode = new Diode(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) facing EAST with 17 ticks delay", actualDiode.toString());
    assertEquals(Material.ACACIA_BOAT, actualDiode.getItemType());
    assertEquals('A', actualDiode.getData());
  }

  /**
   * Test {@link Diode#Diode()}.
   *
   * <p>Method under test: {@link Diode#Diode()}
   */
  @Test
  @DisplayName("Test new Diode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>()"})
  void testNewDiode() {
    // Arrange and Act
    Diode actualDiode = new Diode();

    // Assert
    assertEquals((byte) 0, actualDiode.getData());
    assertEquals(1, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_ON, actualDiode.getItemType());
    assertEquals(BlockFace.NORTH, actualDiode.getFacing());
    assertTrue(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is cr.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int); when 'EAST'; then return Data is cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int)"})
  void testNewDiode_whenEast_thenReturnDataIsCr() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.EAST, 4);

    // Assert
    assertEquals(4, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.EAST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
    assertEquals('\r', actualDiode.getData());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is cr.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int, boolean)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int, boolean); when 'EAST'; then return Data is cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int, boolean)"})
  void testNewDiode_whenEast_thenReturnDataIsCr2() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.EAST, 4, false);

    // Assert
    assertEquals(4, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.EAST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
    assertEquals('\r', actualDiode.getData());
  }

  /**
   * Test {@link Diode#Diode(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace); when 'EAST'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace)"})
  void testNewDiode_whenEast_thenReturnDataIsOne() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.EAST);

    // Assert
    assertEquals(1, actualDiode.getDelay());
    assertEquals((byte) 1, actualDiode.getData());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.EAST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return Data is cr.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int); when five; then return Data is cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int)"})
  void testNewDiode_whenFive_thenReturnDataIsCr() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.EAST, 5);

    // Assert
    assertEquals(4, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.EAST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
    assertEquals('\r', actualDiode.getData());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int, boolean)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return Data is cr.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int, boolean)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int, boolean); when five; then return Data is cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int, boolean)"})
  void testNewDiode_whenFive_thenReturnDataIsCr2() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.EAST, 5, false);

    // Assert
    assertEquals(4, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.EAST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
    assertEquals('\r', actualDiode.getData());
  }

  /**
   * Test {@link Diode#Diode(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace); when 'NORTH'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace)"})
  void testNewDiode_whenNorth_thenReturnDataIsZero() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 0, actualDiode.getData());
    assertEquals(1, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.NORTH, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int); when 'NORTH'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int)"})
  void testNewDiode_whenNorth_thenReturnDataIsZero2() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.NORTH, 1);

    // Assert
    assertEquals((byte) 0, actualDiode.getData());
    assertEquals(1, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.NORTH, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int, boolean)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int, boolean); when 'NORTH'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int, boolean)"})
  void testNewDiode_whenNorth_thenReturnDataIsZero3() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.NORTH, 1, true);

    // Assert
    assertEquals((byte) 0, actualDiode.getData());
    assertEquals(Material.LEGACY_DIODE_BLOCK_ON, actualDiode.getItemType());
    assertEquals(BlockFace.NORTH, actualDiode.getFacing());
    assertTrue(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int); when 'SOUTH'; then return Data is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int)"})
  void testNewDiode_whenSouth_thenReturnDataIsFourteen() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.SOUTH, 4);

    // Assert
    assertEquals((byte) 14, actualDiode.getData());
    assertEquals(4, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.SOUTH, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Diode(BlockFace, int, boolean); when 'SOUTH'; then return Data is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int, boolean)"})
  void testNewDiode_whenSouth_thenReturnDataIsFourteen2() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.SOUTH, 4, false);

    // Assert
    assertEquals((byte) 14, actualDiode.getData());
    assertEquals(4, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.SOUTH, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace); when 'SOUTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace)"})
  void testNewDiode_whenSouth_thenReturnDataIsTwo() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.SOUTH);

    // Assert
    assertEquals(1, actualDiode.getDelay());
    assertEquals((byte) 2, actualDiode.getData());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.SOUTH, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int); when 'WEST'; then return Data is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int)"})
  void testNewDiode_whenWest_thenReturnDataIsFifteen() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.WEST, 4);

    // Assert
    assertEquals((byte) 15, actualDiode.getData());
    assertEquals(4, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.WEST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int, boolean)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int, boolean); when 'WEST'; then return Data is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int, boolean)"})
  void testNewDiode_whenWest_thenReturnDataIsFifteen2() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.WEST, 4, false);

    // Assert
    assertEquals((byte) 15, actualDiode.getData());
    assertEquals(4, actualDiode.getDelay());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.WEST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace); when 'WEST'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace)"})
  void testNewDiode_whenWest_thenReturnDataIsThree() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.WEST);

    // Assert
    assertEquals(1, actualDiode.getDelay());
    assertEquals((byte) 3, actualDiode.getData());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.WEST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int); when zero; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int)"})
  void testNewDiode_whenZero_thenReturnDataIsOne() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.EAST, 0);

    // Assert
    assertEquals(1, actualDiode.getDelay());
    assertEquals((byte) 1, actualDiode.getData());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.EAST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#Diode(BlockFace, int, boolean)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Delay is one.
   * </ul>
   *
   * <p>Method under test: {@link Diode#Diode(BlockFace, int, boolean)}
   */
  @Test
  @DisplayName("Test new Diode(BlockFace, int, boolean); when zero; then return Delay is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.<init>(BlockFace, int, boolean)"})
  void testNewDiode_whenZero_thenReturnDelayIsOne() {
    // Arrange and Act
    Diode actualDiode = new Diode(BlockFace.EAST, 0, false);

    // Assert
    assertEquals(1, actualDiode.getDelay());
    assertEquals((byte) 1, actualDiode.getData());
    assertEquals(Material.LEGACY_DIODE_BLOCK_OFF, actualDiode.getItemType());
    assertEquals(BlockFace.EAST, actualDiode.getFacing());
    assertFalse(actualDiode.isPowered());
  }

  /**
   * Test {@link Diode#setDelay(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then {@link Diode#Diode()} Delay is four.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setDelay(int)}
   */
  @Test
  @DisplayName("Test setDelay(int); when five; then Diode() Delay is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setDelay(int)"})
  void testSetDelay_whenFive_thenDiodeDelayIsFour() {
    // Arrange
    Diode diode = new Diode();

    // Act
    diode.setDelay(5);

    // Assert
    assertEquals(4, diode.getDelay());
    assertEquals('\f', diode.getData());
  }

  /**
   * Test {@link Diode#setDelay(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link Diode#Diode()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setDelay(int)}
   */
  @Test
  @DisplayName("Test setDelay(int); when one; then Diode() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setDelay(int)"})
  void testSetDelay_whenOne_thenDiodeDataIsZero() {
    // Arrange
    Diode diode = new Diode();

    // Act
    diode.setDelay(1);

    // Assert that nothing has changed
    assertEquals((byte) 0, diode.getData());
    assertEquals(1, diode.getDelay());
  }

  /**
   * Test {@link Diode#setDelay(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link Diode#Diode()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setDelay(int)}
   */
  @Test
  @DisplayName("Test setDelay(int); when zero; then Diode() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setDelay(int)"})
  void testSetDelay_whenZero_thenDiodeDataIsZero() {
    // Arrange
    Diode diode = new Diode();

    // Act
    diode.setDelay(0);

    // Assert that nothing has changed
    assertEquals((byte) 0, diode.getData());
    assertEquals(1, diode.getDelay());
  }

  /**
   * Test {@link Diode#getDelay()}.
   *
   * <p>Method under test: {@link Diode#getDelay()}
   */
  @Test
  @DisplayName("Test getDelay()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Diode.getDelay()"})
  void testGetDelay() {
    // Arrange, Act and Assert
    assertEquals(1, new Diode().getDelay());
  }

  /**
   * Test {@link Diode#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()} Data is {@code A}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Diode#Diode()} Delay is four.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Diode() Data is 'A'; when 'NORTH'; then Diode() Delay is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenDiodeDataIsA_whenNorth_thenDiodeDelayIsFour() {
    // Arrange
    Diode diode = new Diode();
    diode.setData((byte) 'A');

    // Act
    diode.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals(4, diode.getDelay());
    assertEquals(BlockFace.NORTH, diode.getFacing());
    assertEquals('\f', diode.getData());
  }

  /**
   * Test {@link Diode#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()} Data is minus one.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Diode#Diode()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Diode() Data is minus one; when 'NORTH'; then Diode() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenDiodeDataIsMinusOne_whenNorth_thenDiodeDataIsZero() {
    // Arrange
    Diode diode = new Diode();
    diode.setData((byte) -1);

    // Act
    diode.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 0, diode.getData());
    assertEquals(1, diode.getDelay());
    assertEquals(BlockFace.NORTH, diode.getFacing());
  }

  /**
   * Test {@link Diode#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()}.
   *   <li>When {@code EAST}.
   *   <li>Then {@link Diode#Diode()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Diode(); when 'EAST'; then Diode() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenDiode_whenEast_thenDiodeDataIsOne() {
    // Arrange
    Diode diode = new Diode();

    // Act
    diode.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals(1, diode.getDelay());
    assertEquals((byte) 1, diode.getData());
    assertEquals(BlockFace.EAST, diode.getFacing());
  }

  /**
   * Test {@link Diode#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Diode#Diode()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Diode(); when 'NORTH'; then Diode() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenDiode_whenNorth_thenDiodeDataIsZero() {
    // Arrange
    Diode diode = new Diode();

    // Act
    diode.setFacingDirection(BlockFace.NORTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, diode.getData());
    assertEquals(1, diode.getDelay());
    assertEquals(BlockFace.NORTH, diode.getFacing());
  }

  /**
   * Test {@link Diode#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()}.
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Diode#Diode()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Diode(); when 'SOUTH'; then Diode() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenDiode_whenSouth_thenDiodeDataIsTwo() {
    // Arrange
    Diode diode = new Diode();

    // Act
    diode.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals(1, diode.getDelay());
    assertEquals((byte) 2, diode.getData());
    assertEquals(BlockFace.SOUTH, diode.getFacing());
  }

  /**
   * Test {@link Diode#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()}.
   *   <li>When {@code WEST}.
   *   <li>Then {@link Diode#Diode()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Diode#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Diode(); when 'WEST'; then Diode() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Diode.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenDiode_whenWest_thenDiodeDataIsThree() {
    // Arrange
    Diode diode = new Diode();

    // Act
    diode.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals(1, diode.getDelay());
    assertEquals((byte) 3, diode.getData());
    assertEquals(BlockFace.WEST, diode.getFacing());
  }

  /**
   * Test {@link Diode#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()} Data is {@code A}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Diode#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Diode() Data is 'A'; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Diode.getFacing()"})
  void testGetFacing_givenDiodeDataIsA_thenReturnEast() {
    // Arrange
    Diode diode = new Diode();
    diode.setData((byte) 'A');

    // Act and Assert
    assertEquals(BlockFace.EAST, diode.getFacing());
  }

  /**
   * Test {@link Diode#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()} Data is three.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Diode#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Diode() Data is three; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Diode.getFacing()"})
  void testGetFacing_givenDiodeDataIsThree_thenReturnWest() {
    // Arrange
    Diode diode = new Diode();
    diode.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.WEST, diode.getFacing());
  }

  /**
   * Test {@link Diode#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()} Data is two.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Diode#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Diode() Data is two; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Diode.getFacing()"})
  void testGetFacing_givenDiodeDataIsTwo_thenReturnSouth() {
    // Arrange
    Diode diode = new Diode();
    diode.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, diode.getFacing());
  }

  /**
   * Test {@link Diode#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Diode#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Diode(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Diode.getFacing()"})
  void testGetFacing_givenDiode_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Diode().getFacing());
  }

  /**
   * Test {@link Diode#clone()}.
   *
   * <p>Method under test: {@link Diode#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Diode Diode.clone()"})
  void testClone() {
    // Arrange
    Diode diode = new Diode();

    // Act
    Diode actualCloneResult = diode.clone();

    // Assert
    assertEquals(diode, actualCloneResult);
  }

  /**
   * Test {@link Diode#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode(Material)} with type is {@code ACACIA_BOAT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Diode#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given Diode(Material) with type is 'ACACIA_BOAT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diode.isPowered()"})
  void testIsPowered_givenDiodeWithTypeIsAcaciaBoat_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Diode(Material.ACACIA_BOAT).isPowered());
  }

  /**
   * Test {@link Diode#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Diode#Diode()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Diode#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Diode(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Diode.isPowered()"})
  void testIsPowered_givenDiode_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Diode().isPowered());
  }
}
