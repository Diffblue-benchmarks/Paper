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

class HopperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code ACACIA_BOAT(65) facing DOWN}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Hopper#Hopper(Material, byte)}
   *   <li>{@link Hopper#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'A'; then return toString is 'ACACIA_BOAT(65) facing DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Hopper.<init>(Material)",
    "void Hopper.<init>(Material, byte)",
    "java.lang.String Hopper.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsAcaciaBoat65FacingDown() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) facing DOWN", actualHopper.toString());
    assertEquals(Material.ACACIA_BOAT, actualHopper.getItemType());
    assertEquals('A', actualHopper.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code ACACIA_BOAT(0) facing DOWN}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Hopper#Hopper(Material)}
   *   <li>{@link Hopper#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'ACACIA_BOAT(0) facing DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Hopper.<init>(Material)",
    "void Hopper.<init>(Material, byte)",
    "java.lang.String Hopper.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsAcaciaBoat0FacingDown() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) facing DOWN", actualHopper.toString());
    assertEquals((byte) 0, actualHopper.getData());
    assertEquals(Material.ACACIA_BOAT, actualHopper.getItemType());
  }

  /**
   * Test {@link Hopper#Hopper()}.
   *
   * <p>Method under test: {@link Hopper#Hopper()}
   */
  @Test
  @DisplayName("Test new Hopper()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>()"})
  void testNewHopper() {
    // Arrange and Act
    Hopper actualHopper = new Hopper();

    // Assert
    assertEquals((byte) 0, actualHopper.getData());
    assertEquals(Material.LEGACY_HOPPER, actualHopper.getItemType());
    assertEquals(BlockFace.DOWN, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then return Data is backspace.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace, boolean); when 'DOWN'; then return Data is backspace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace, boolean)"})
  void testNewHopper_whenDown_thenReturnDataIsBackspace() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.DOWN, false);

    // Assert
    assertEquals(BlockFace.DOWN, actualHopper.getFacing());
    assertFalse(actualHopper.isActive());
    assertTrue(actualHopper.isPowered());
    assertEquals('\b', actualHopper.getData());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace); when 'DOWN'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace)"})
  void testNewHopper_whenDown_thenReturnDataIsZero() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.DOWN);

    // Assert
    assertEquals((byte) 0, actualHopper.getData());
    assertEquals(Material.LEGACY_HOPPER, actualHopper.getItemType());
    assertEquals(BlockFace.DOWN, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace); when 'EAST'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace)"})
  void testNewHopper_whenEast_thenReturnDataIsFive() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, actualHopper.getData());
    assertEquals(Material.LEGACY_HOPPER, actualHopper.getItemType());
    assertEquals(BlockFace.EAST, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Facing is {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace, boolean); when 'EAST'; then return Facing is 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace, boolean)"})
  void testNewHopper_whenEast_thenReturnFacingIsEast() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.EAST, false);

    // Assert
    assertEquals(BlockFace.EAST, actualHopper.getFacing());
    assertFalse(actualHopper.isActive());
    assertTrue(actualHopper.isPowered());
    assertEquals('\r', actualHopper.getData());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace)"})
  void testNewHopper_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualHopper.getData());
    assertEquals(Material.LEGACY_HOPPER, actualHopper.getItemType());
    assertEquals(BlockFace.NORTH, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace, boolean); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace, boolean)"})
  void testNewHopper_whenNorth_thenReturnDataIsTwo2() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.NORTH, true);

    // Assert
    assertEquals((byte) 2, actualHopper.getData());
    assertEquals(BlockFace.NORTH, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is eleven.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace, boolean); when 'SOUTH'; then return Data is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace, boolean)"})
  void testNewHopper_whenSouth_thenReturnDataIsEleven() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.SOUTH, false);

    // Assert
    assertEquals((byte) 11, actualHopper.getData());
    assertEquals(BlockFace.SOUTH, actualHopper.getFacing());
    assertFalse(actualHopper.isActive());
    assertTrue(actualHopper.isPowered());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace)"})
  void testNewHopper_whenSouth_thenReturnDataIsThree() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, actualHopper.getData());
    assertEquals(Material.LEGACY_HOPPER, actualHopper.getItemType());
    assertEquals(BlockFace.SOUTH, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace); when 'UP'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace)"})
  void testNewHopper_whenUp_thenReturnDataIsZero() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.UP);

    // Assert
    assertEquals((byte) 0, actualHopper.getData());
    assertEquals(Material.LEGACY_HOPPER, actualHopper.getItemType());
    assertEquals(BlockFace.DOWN, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace, boolean); when 'UP'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace, boolean)"})
  void testNewHopper_whenUp_thenReturnDataIsZero2() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.UP, true);

    // Assert
    assertEquals((byte) 0, actualHopper.getData());
    assertEquals(BlockFace.DOWN, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace); when 'WEST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace)"})
  void testNewHopper_whenWest_thenReturnDataIsFour() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, actualHopper.getData());
    assertEquals(Material.LEGACY_HOPPER, actualHopper.getItemType());
    assertEquals(BlockFace.WEST, actualHopper.getFacing());
    assertFalse(actualHopper.isPowered());
    assertTrue(actualHopper.isActive());
  }

  /**
   * Test {@link Hopper#Hopper(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Facing is {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#Hopper(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Hopper(BlockFace, boolean); when 'WEST'; then return Facing is 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.<init>(BlockFace, boolean)"})
  void testNewHopper_whenWest_thenReturnFacingIsWest() {
    // Arrange and Act
    Hopper actualHopper = new Hopper(BlockFace.WEST, false);

    // Assert
    assertEquals(BlockFace.WEST, actualHopper.getFacing());
    assertFalse(actualHopper.isActive());
    assertTrue(actualHopper.isPowered());
    assertEquals('\f', actualHopper.getData());
  }

  /**
   * Test {@link Hopper#setActive(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link Hopper#Hopper()} Active.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#setActive(boolean)}
   */
  @Test
  @DisplayName("Test setActive(boolean); when 'false'; then not Hopper() Active")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.setActive(boolean)"})
  void testSetActive_whenFalse_thenNotHopperActive() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    hopper.setActive(false);

    // Assert
    assertFalse(hopper.isActive());
    assertTrue(hopper.isPowered());
    assertEquals('\b', hopper.getData());
  }

  /**
   * Test {@link Hopper#setActive(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Hopper#Hopper()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#setActive(boolean)}
   */
  @Test
  @DisplayName("Test setActive(boolean); when 'true'; then Hopper() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.setActive(boolean)"})
  void testSetActive_whenTrue_thenHopperDataIsZero() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    hopper.setActive(true);

    // Assert that nothing has changed
    assertEquals((byte) 0, hopper.getData());
    assertFalse(hopper.isPowered());
    assertTrue(hopper.isActive());
  }

  /**
   * Test {@link Hopper#isActive()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper()} Data is {@code X}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#isActive()}
   */
  @Test
  @DisplayName("Test isActive(); given Hopper() Data is 'X'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Hopper.isActive()"})
  void testIsActive_givenHopperDataIsX_thenReturnFalse() {
    // Arrange
    Hopper hopper = new Hopper();
    hopper.setData((byte) 'X');

    // Act and Assert
    assertFalse(hopper.isActive());
  }

  /**
   * Test {@link Hopper#isActive()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#isActive()}
   */
  @Test
  @DisplayName("Test isActive(); given Hopper(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Hopper.isActive()"})
  void testIsActive_givenHopper_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Hopper().isActive());
  }

  /**
   * Test {@link Hopper#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then {@link Hopper#Hopper()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'DOWN'; then Hopper() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenDown_thenHopperDataIsZero() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    hopper.setFacingDirection(BlockFace.DOWN);

    // Assert that nothing has changed
    assertEquals((byte) 0, hopper.getData());
    assertEquals(BlockFace.DOWN, hopper.getFacing());
  }

  /**
   * Test {@link Hopper#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Hopper#Hopper()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Hopper() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenHopperDataIsFive() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    hopper.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, hopper.getData());
    assertEquals(BlockFace.EAST, hopper.getFacing());
  }

  /**
   * Test {@link Hopper#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Hopper#Hopper()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Hopper() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenHopperDataIsTwo() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    hopper.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, hopper.getData());
    assertEquals(BlockFace.NORTH, hopper.getFacing());
  }

  /**
   * Test {@link Hopper#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Hopper#Hopper()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Hopper() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenHopperDataIsThree() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    hopper.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, hopper.getData());
    assertEquals(BlockFace.SOUTH, hopper.getFacing());
  }

  /**
   * Test {@link Hopper#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Hopper#Hopper()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'UP'; then Hopper() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenUp_thenHopperDataIsZero() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    hopper.setFacingDirection(BlockFace.UP);

    // Assert that nothing has changed
    assertEquals((byte) 0, hopper.getData());
    assertEquals(BlockFace.DOWN, hopper.getFacing());
  }

  /**
   * Test {@link Hopper#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Hopper#Hopper()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Hopper() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Hopper.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenHopperDataIsFour() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    hopper.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, hopper.getData());
    assertEquals(BlockFace.WEST, hopper.getFacing());
  }

  /**
   * Test {@link Hopper#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper(BlockFace)} with facingDirection is {@code EAST}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Hopper(BlockFace) with facingDirection is 'EAST'; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Hopper.getFacing()"})
  void testGetFacing_givenHopperWithFacingDirectionIsEast_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Hopper(BlockFace.EAST).getFacing());
  }

  /**
   * Test {@link Hopper#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper(BlockFace)} with facingDirection is {@code NORTH}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Hopper(BlockFace) with facingDirection is 'NORTH'; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Hopper.getFacing()"})
  void testGetFacing_givenHopperWithFacingDirectionIsNorth_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Hopper(BlockFace.NORTH).getFacing());
  }

  /**
   * Test {@link Hopper#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper(BlockFace)} with facingDirection is {@code SOUTH}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Hopper(BlockFace) with facingDirection is 'SOUTH'; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Hopper.getFacing()"})
  void testGetFacing_givenHopperWithFacingDirectionIsSouth_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Hopper(BlockFace.SOUTH).getFacing());
  }

  /**
   * Test {@link Hopper#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper(BlockFace)} with facingDirection is {@code WEST}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Hopper(BlockFace) with facingDirection is 'WEST'; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Hopper.getFacing()"})
  void testGetFacing_givenHopperWithFacingDirectionIsWest_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Hopper(BlockFace.WEST).getFacing());
  }

  /**
   * Test {@link Hopper#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper()}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Hopper(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Hopper.getFacing()"})
  void testGetFacing_givenHopper_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Hopper().getFacing());
  }

  /**
   * Test {@link Hopper#clone()}.
   *
   * <p>Method under test: {@link Hopper#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Hopper Hopper.clone()"})
  void testClone() {
    // Arrange
    Hopper hopper = new Hopper();

    // Act
    Hopper actualCloneResult = hopper.clone();

    // Assert
    assertEquals(hopper, actualCloneResult);
  }

  /**
   * Test {@link Hopper#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper()} Data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Hopper() Data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Hopper.isPowered()"})
  void testIsPowered_givenHopperDataIsX_thenReturnTrue() {
    // Arrange
    Hopper hopper = new Hopper();
    hopper.setData((byte) 'X');

    // Act and Assert
    assertTrue(hopper.isPowered());
  }

  /**
   * Test {@link Hopper#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Hopper#Hopper()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Hopper#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Hopper(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Hopper.isPowered()"})
  void testIsPowered_givenHopper_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Hopper().isPowered());
  }
}
