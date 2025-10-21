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

class BedDiffblueTest {
  /**
   * Test {@link Bed#Bed()}.
   *
   * <p>Method under test: {@link Bed#Bed()}
   */
  @Test
  @DisplayName("Test new Bed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.<init>()"})
  void testNewBed() {
    // Arrange and Act
    Bed actualBed = new Bed();

    // Assert
    assertEquals((byte) 0, actualBed.getData());
    assertEquals(Material.LEGACY_BED_BLOCK, actualBed.getItemType());
    assertEquals(BlockFace.SOUTH, actualBed.getFacing());
    assertFalse(actualBed.isHeadOfBed());
  }

  /**
   * Test {@link Bed#Bed(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#Bed(Material, byte)}
   */
  @Test
  @DisplayName("Test new Bed(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.<init>(Material)", "void Bed.<init>(Material, byte)"})
  void testNewBed_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Bed actualBed = new Bed(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualBed.getItemType());
    assertEquals('A', actualBed.getData());
  }

  /**
   * Test {@link Bed#Bed(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Bed#Bed(Material)}
   */
  @Test
  @DisplayName("Test new Bed(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.<init>(Material)", "void Bed.<init>(Material, byte)"})
  void testNewBed_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Bed actualBed = new Bed(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualBed.getData());
    assertEquals(Material.ACACIA_BOAT, actualBed.getItemType());
  }

  /**
   * Test {@link Bed#Bed(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Bed#Bed(BlockFace)}
   */
  @Test
  @DisplayName("Test new Bed(BlockFace); when 'EAST'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.<init>(BlockFace)"})
  void testNewBed_whenEast_thenReturnDataIsThree() {
    // Arrange and Act
    Bed actualBed = new Bed(BlockFace.EAST);

    // Assert
    assertEquals((byte) 3, actualBed.getData());
    assertEquals(Material.LEGACY_BED_BLOCK, actualBed.getItemType());
    assertEquals(BlockFace.EAST, actualBed.getFacing());
    assertFalse(actualBed.isHeadOfBed());
  }

  /**
   * Test {@link Bed#Bed(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Bed#Bed(BlockFace)}
   */
  @Test
  @DisplayName("Test new Bed(BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.<init>(BlockFace)"})
  void testNewBed_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    Bed actualBed = new Bed(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualBed.getData());
    assertEquals(Material.LEGACY_BED_BLOCK, actualBed.getItemType());
    assertEquals(BlockFace.NORTH, actualBed.getFacing());
    assertFalse(actualBed.isHeadOfBed());
  }

  /**
   * Test {@link Bed#Bed(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Bed#Bed(BlockFace)}
   */
  @Test
  @DisplayName("Test new Bed(BlockFace); when 'SOUTH'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.<init>(BlockFace)"})
  void testNewBed_whenSouth_thenReturnDataIsZero() {
    // Arrange and Act
    Bed actualBed = new Bed(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 0, actualBed.getData());
    assertEquals(Material.LEGACY_BED_BLOCK, actualBed.getItemType());
    assertEquals(BlockFace.SOUTH, actualBed.getFacing());
    assertFalse(actualBed.isHeadOfBed());
  }

  /**
   * Test {@link Bed#Bed(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Bed#Bed(BlockFace)}
   */
  @Test
  @DisplayName("Test new Bed(BlockFace); when 'WEST'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.<init>(BlockFace)"})
  void testNewBed_whenWest_thenReturnDataIsOne() {
    // Arrange and Act
    Bed actualBed = new Bed(BlockFace.WEST);

    // Assert
    assertEquals((byte) 1, actualBed.getData());
    assertEquals(Material.LEGACY_BED_BLOCK, actualBed.getItemType());
    assertEquals(BlockFace.WEST, actualBed.getFacing());
    assertFalse(actualBed.isHeadOfBed());
  }

  /**
   * Test {@link Bed#isHeadOfBed()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()} Data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#isHeadOfBed()}
   */
  @Test
  @DisplayName("Test isHeadOfBed(); given Bed() Data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Bed.isHeadOfBed()"})
  void testIsHeadOfBed_givenBedDataIsX_thenReturnTrue() {
    // Arrange
    Bed bed = new Bed();
    bed.setData((byte) 'X');

    // Act and Assert
    assertTrue(bed.isHeadOfBed());
  }

  /**
   * Test {@link Bed#isHeadOfBed()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#isHeadOfBed()}
   */
  @Test
  @DisplayName("Test isHeadOfBed(); given Bed(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Bed.isHeadOfBed()"})
  void testIsHeadOfBed_givenBed_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Bed().isHeadOfBed());
  }

  /**
   * Test {@link Bed#setHeadOfBed(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Bed#Bed()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Bed#setHeadOfBed(boolean)}
   */
  @Test
  @DisplayName("Test setHeadOfBed(boolean); when 'false'; then Bed() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.setHeadOfBed(boolean)"})
  void testSetHeadOfBed_whenFalse_thenBedDataIsZero() {
    // Arrange
    Bed bed = new Bed();

    // Act
    bed.setHeadOfBed(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, bed.getData());
    assertFalse(bed.isHeadOfBed());
  }

  /**
   * Test {@link Bed#setHeadOfBed(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Bed#Bed()} HeadOfBed.
   * </ul>
   *
   * <p>Method under test: {@link Bed#setHeadOfBed(boolean)}
   */
  @Test
  @DisplayName("Test setHeadOfBed(boolean); when 'true'; then Bed() HeadOfBed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.setHeadOfBed(boolean)"})
  void testSetHeadOfBed_whenTrue_thenBedHeadOfBed() {
    // Arrange
    Bed bed = new Bed();

    // Act
    bed.setHeadOfBed(true);

    // Assert
    assertTrue(bed.isHeadOfBed());
    assertEquals('\b', bed.getData());
  }

  /**
   * Test {@link Bed#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()} Data is {@code X}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Bed#Bed()} Data is lf.
   * </ul>
   *
   * <p>Method under test: {@link Bed#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Bed() Data is 'X'; when 'NORTH'; then Bed() Data is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBedDataIsX_whenNorth_thenBedDataIsLf() {
    // Arrange
    Bed bed = new Bed();
    bed.setData((byte) 'X');

    // Act
    bed.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals(BlockFace.NORTH, bed.getFacing());
    assertEquals('\n', bed.getData());
  }

  /**
   * Test {@link Bed#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()}.
   *   <li>When {@code EAST}.
   *   <li>Then {@link Bed#Bed()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Bed#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Bed(); when 'EAST'; then Bed() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBed_whenEast_thenBedDataIsThree() {
    // Arrange
    Bed bed = new Bed();

    // Act
    bed.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 3, bed.getData());
    assertEquals(BlockFace.EAST, bed.getFacing());
  }

  /**
   * Test {@link Bed#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Bed#Bed()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Bed#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Bed(); when 'NORTH'; then Bed() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBed_whenNorth_thenBedDataIsTwo() {
    // Arrange
    Bed bed = new Bed();

    // Act
    bed.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, bed.getData());
    assertEquals(BlockFace.NORTH, bed.getFacing());
  }

  /**
   * Test {@link Bed#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()}.
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Bed#Bed()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Bed#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Bed(); when 'SOUTH'; then Bed() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBed_whenSouth_thenBedDataIsZero() {
    // Arrange
    Bed bed = new Bed();

    // Act
    bed.setFacingDirection(BlockFace.SOUTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, bed.getData());
    assertEquals(BlockFace.SOUTH, bed.getFacing());
  }

  /**
   * Test {@link Bed#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()}.
   *   <li>When {@code WEST}.
   *   <li>Then {@link Bed#Bed()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Bed#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Bed(); when 'WEST'; then Bed() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Bed.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBed_whenWest_thenBedDataIsOne() {
    // Arrange
    Bed bed = new Bed();

    // Act
    bed.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 1, bed.getData());
    assertEquals(BlockFace.WEST, bed.getFacing());
  }

  /**
   * Test {@link Bed#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()} Data is {@code A}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Bed() Data is 'A'; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Bed.getFacing()"})
  void testGetFacing_givenBedDataIsA_thenReturnWest() {
    // Arrange
    Bed bed = new Bed();
    bed.setData((byte) 'A');

    // Act and Assert
    assertEquals(BlockFace.WEST, bed.getFacing());
  }

  /**
   * Test {@link Bed#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()} Data is seven.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Bed() Data is seven; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Bed.getFacing()"})
  void testGetFacing_givenBedDataIsSeven_thenReturnEast() {
    // Arrange
    Bed bed = new Bed();
    bed.setData((byte) 7);

    // Act and Assert
    assertEquals(BlockFace.EAST, bed.getFacing());
  }

  /**
   * Test {@link Bed#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed(BlockFace)} with direction is {@code NORTH}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Bed(BlockFace) with direction is 'NORTH'; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Bed.getFacing()"})
  void testGetFacing_givenBedWithDirectionIsNorth_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Bed(BlockFace.NORTH).getFacing());
  }

  /**
   * Test {@link Bed#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Bed(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Bed.getFacing()"})
  void testGetFacing_givenBed_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Bed().getFacing());
  }

  /**
   * Test {@link Bed#toString()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()} Data is {@code A}.
   *   <li>Then return {@code FOOT of LEGACY_BED_BLOCK(65) facing WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Bed() Data is 'A'; then return 'FOOT of LEGACY_BED_BLOCK(65) facing WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Bed.toString()"})
  void testToString_givenBedDataIsA_thenReturnFootOfLegacyBedBlock65FacingWest() {
    // Arrange
    Bed bed = new Bed();
    bed.setData((byte) 'A');

    // Act and Assert
    assertEquals("FOOT of LEGACY_BED_BLOCK(65) facing WEST", bed.toString());
  }

  /**
   * Test {@link Bed#toString()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()} Data is backspace.
   *   <li>Then return {@code HEAD of LEGACY_BED_BLOCK(8) facing SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Bed() Data is backspace; then return 'HEAD of LEGACY_BED_BLOCK(8) facing SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Bed.toString()"})
  void testToString_givenBedDataIsBackspace_thenReturnHeadOfLegacyBedBlock8FacingSouth() {
    // Arrange
    Bed bed = new Bed();
    bed.setData((byte) '\b');

    // Act and Assert
    assertEquals("HEAD of LEGACY_BED_BLOCK(8) facing SOUTH", bed.toString());
  }

  /**
   * Test {@link Bed#toString()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()} Data is seven.
   *   <li>Then return {@code FOOT of LEGACY_BED_BLOCK(7) facing EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Bed() Data is seven; then return 'FOOT of LEGACY_BED_BLOCK(7) facing EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Bed.toString()"})
  void testToString_givenBedDataIsSeven_thenReturnFootOfLegacyBedBlock7FacingEast() {
    // Arrange
    Bed bed = new Bed();
    bed.setData((byte) 7);

    // Act and Assert
    assertEquals("FOOT of LEGACY_BED_BLOCK(7) facing EAST", bed.toString());
  }

  /**
   * Test {@link Bed#toString()}.
   *
   * <ul>
   *   <li>Given {@link Bed#Bed()}.
   *   <li>Then return {@code FOOT of LEGACY_BED_BLOCK(0) facing SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Bed(); then return 'FOOT of LEGACY_BED_BLOCK(0) facing SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Bed.toString()"})
  void testToString_givenBed_thenReturnFootOfLegacyBedBlock0FacingSouth() {
    // Arrange, Act and Assert
    assertEquals("FOOT of LEGACY_BED_BLOCK(0) facing SOUTH", new Bed().toString());
  }

  /**
   * Test {@link Bed#toString()}.
   *
   * <ul>
   *   <li>Then return {@code FOOT of LEGACY_BED_BLOCK(2) facing NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Bed#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'FOOT of LEGACY_BED_BLOCK(2) facing NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Bed.toString()"})
  void testToString_thenReturnFootOfLegacyBedBlock2FacingNorth() {
    // Arrange, Act and Assert
    assertEquals("FOOT of LEGACY_BED_BLOCK(2) facing NORTH", new Bed(BlockFace.NORTH).toString());
  }

  /**
   * Test {@link Bed#clone()}.
   *
   * <p>Method under test: {@link Bed#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bed Bed.clone()"})
  void testClone() {
    // Arrange
    Bed bed = new Bed();

    // Act
    Bed actualCloneResult = bed.clone();

    // Assert
    assertEquals(bed, actualCloneResult);
  }
}
