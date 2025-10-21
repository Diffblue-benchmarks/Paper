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

class PumpkinDiffblueTest {
  /**
   * Test {@link Pumpkin#Pumpkin()}.
   *
   * <p>Method under test: {@link Pumpkin#Pumpkin()}
   */
  @Test
  @DisplayName("Test new Pumpkin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.<init>()"})
  void testNewPumpkin() {
    // Arrange and Act
    Pumpkin actualPumpkin = new Pumpkin();

    // Assert
    assertEquals((byte) 0, actualPumpkin.getData());
    assertEquals(Material.LEGACY_PUMPKIN, actualPumpkin.getItemType());
    assertEquals(BlockFace.NORTH, actualPumpkin.getFacing());
    assertFalse(actualPumpkin.isLit());
  }

  /**
   * Test {@link Pumpkin#Pumpkin(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#Pumpkin(Material, byte)}
   */
  @Test
  @DisplayName("Test new Pumpkin(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.<init>(Material)", "void Pumpkin.<init>(Material, byte)"})
  void testNewPumpkin_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Pumpkin actualPumpkin = new Pumpkin(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualPumpkin.getItemType());
    assertEquals('A', actualPumpkin.getData());
  }

  /**
   * Test {@link Pumpkin#Pumpkin(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#Pumpkin(Material)}
   */
  @Test
  @DisplayName("Test new Pumpkin(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.<init>(Material)", "void Pumpkin.<init>(Material, byte)"})
  void testNewPumpkin_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Pumpkin actualPumpkin = new Pumpkin(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualPumpkin.getData());
    assertEquals(Material.ACACIA_BOAT, actualPumpkin.getItemType());
  }

  /**
   * Test {@link Pumpkin#Pumpkin(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#Pumpkin(BlockFace)}
   */
  @Test
  @DisplayName("Test new Pumpkin(BlockFace); when 'EAST'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.<init>(BlockFace)"})
  void testNewPumpkin_whenEast_thenReturnDataIsOne() {
    // Arrange and Act
    Pumpkin actualPumpkin = new Pumpkin(BlockFace.EAST);

    // Assert
    assertEquals((byte) 1, actualPumpkin.getData());
    assertEquals(Material.LEGACY_PUMPKIN, actualPumpkin.getItemType());
    assertEquals(BlockFace.EAST, actualPumpkin.getFacing());
    assertFalse(actualPumpkin.isLit());
  }

  /**
   * Test {@link Pumpkin#Pumpkin(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#Pumpkin(BlockFace)}
   */
  @Test
  @DisplayName("Test new Pumpkin(BlockFace); when 'NORTH'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.<init>(BlockFace)"})
  void testNewPumpkin_whenNorth_thenReturnDataIsZero() {
    // Arrange and Act
    Pumpkin actualPumpkin = new Pumpkin(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 0, actualPumpkin.getData());
    assertEquals(Material.LEGACY_PUMPKIN, actualPumpkin.getItemType());
    assertEquals(BlockFace.NORTH, actualPumpkin.getFacing());
    assertFalse(actualPumpkin.isLit());
  }

  /**
   * Test {@link Pumpkin#Pumpkin(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#Pumpkin(BlockFace)}
   */
  @Test
  @DisplayName("Test new Pumpkin(BlockFace); when 'SOUTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.<init>(BlockFace)"})
  void testNewPumpkin_whenSouth_thenReturnDataIsTwo() {
    // Arrange and Act
    Pumpkin actualPumpkin = new Pumpkin(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 2, actualPumpkin.getData());
    assertEquals(Material.LEGACY_PUMPKIN, actualPumpkin.getItemType());
    assertEquals(BlockFace.SOUTH, actualPumpkin.getFacing());
    assertFalse(actualPumpkin.isLit());
  }

  /**
   * Test {@link Pumpkin#Pumpkin(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#Pumpkin(BlockFace)}
   */
  @Test
  @DisplayName("Test new Pumpkin(BlockFace); when 'WEST'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.<init>(BlockFace)"})
  void testNewPumpkin_whenWest_thenReturnDataIsThree() {
    // Arrange and Act
    Pumpkin actualPumpkin = new Pumpkin(BlockFace.WEST);

    // Assert
    assertEquals((byte) 3, actualPumpkin.getData());
    assertEquals(Material.LEGACY_PUMPKIN, actualPumpkin.getItemType());
    assertEquals(BlockFace.EAST, actualPumpkin.getFacing());
    assertFalse(actualPumpkin.isLit());
  }

  /**
   * Test {@link Pumpkin#isLit()}.
   *
   * <ul>
   *   <li>Given {@link Pumpkin#Pumpkin(Material)} with type is {@link
   *       Material#LEGACY_JACK_O_LANTERN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#isLit()}
   */
  @Test
  @DisplayName(
      "Test isLit(); given Pumpkin(Material) with type is LEGACY_JACK_O_LANTERN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Pumpkin.isLit()"})
  void testIsLit_givenPumpkinWithTypeIsLegacy_jack_o_lantern_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Pumpkin(Material.LEGACY_JACK_O_LANTERN).isLit());
  }

  /**
   * Test {@link Pumpkin#isLit()}.
   *
   * <ul>
   *   <li>Given {@link Pumpkin#Pumpkin()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#isLit()}
   */
  @Test
  @DisplayName("Test isLit(); given Pumpkin(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Pumpkin.isLit()"})
  void testIsLit_givenPumpkin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Pumpkin().isLit());
  }

  /**
   * Test {@link Pumpkin#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Pumpkin#Pumpkin()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Pumpkin() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenPumpkinDataIsOne() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin();

    // Act
    pumpkin.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 1, pumpkin.getData());
    assertEquals(BlockFace.EAST, pumpkin.getFacing());
  }

  /**
   * Test {@link Pumpkin#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Pumpkin#Pumpkin()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Pumpkin() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenPumpkinDataIsZero() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin();

    // Act
    pumpkin.setFacingDirection(BlockFace.NORTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, pumpkin.getData());
    assertEquals(BlockFace.NORTH, pumpkin.getFacing());
  }

  /**
   * Test {@link Pumpkin#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Pumpkin#Pumpkin()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Pumpkin() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenPumpkinDataIsTwo() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin();

    // Act
    pumpkin.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 2, pumpkin.getData());
    assertEquals(BlockFace.SOUTH, pumpkin.getFacing());
  }

  /**
   * Test {@link Pumpkin#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Pumpkin#Pumpkin()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Pumpkin() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pumpkin.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenPumpkinDataIsThree() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin();

    // Act
    pumpkin.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 3, pumpkin.getData());
    assertEquals(BlockFace.EAST, pumpkin.getFacing());
  }

  /**
   * Test {@link Pumpkin#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Pumpkin#Pumpkin(Material)} with type is {@code ACACIA_BOAT} Data is one.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Pumpkin(Material) with type is 'ACACIA_BOAT' Data is one; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Pumpkin.getFacing()"})
  void testGetFacing_givenPumpkinWithTypeIsAcaciaBoatDataIsOne_thenReturnEast() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin(Material.ACACIA_BOAT);
    pumpkin.setData((byte) 1);

    // Act and Assert
    assertEquals(BlockFace.EAST, pumpkin.getFacing());
  }

  /**
   * Test {@link Pumpkin#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Pumpkin#Pumpkin(Material)} with type is {@code ACACIA_BOAT} Data is three.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Pumpkin(Material) with type is 'ACACIA_BOAT' Data is three; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Pumpkin.getFacing()"})
  void testGetFacing_givenPumpkinWithTypeIsAcaciaBoatDataIsThree_thenReturnEast() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin(Material.ACACIA_BOAT);
    pumpkin.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.EAST, pumpkin.getFacing());
  }

  /**
   * Test {@link Pumpkin#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Pumpkin#Pumpkin(Material)} with type is {@code ACACIA_BOAT} Data is two.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Pumpkin(Material) with type is 'ACACIA_BOAT' Data is two; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Pumpkin.getFacing()"})
  void testGetFacing_givenPumpkinWithTypeIsAcaciaBoatDataIsTwo_thenReturnSouth() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin(Material.ACACIA_BOAT);
    pumpkin.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, pumpkin.getFacing());
  }

  /**
   * Test {@link Pumpkin#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Pumpkin#Pumpkin()}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Pumpkin(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Pumpkin.getFacing()"})
  void testGetFacing_givenPumpkin_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Pumpkin().getFacing());
  }

  /**
   * Test {@link Pumpkin#toString()}.
   *
   * <ul>
   *   <li>Given {@link Pumpkin#Pumpkin()}.
   *   <li>Then return {@code LEGACY_PUMPKIN(0) facing NORTH NOT LIT}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Pumpkin(); then return 'LEGACY_PUMPKIN(0) facing NORTH NOT LIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Pumpkin.toString()"})
  void testToString_givenPumpkin_thenReturnLegacyPumpkin0FacingNorthNotLit() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_PUMPKIN(0) facing NORTH NOT LIT", new Pumpkin().toString());
  }

  /**
   * Test {@link Pumpkin#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_JACK_O_LANTERN(0) facing NORTH LIT}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_JACK_O_LANTERN(0) facing NORTH LIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Pumpkin.toString()"})
  void testToString_thenReturnLegacyJackOLantern0FacingNorthLit() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin(Material.LEGACY_JACK_O_LANTERN);
    pumpkin.setData((byte) 0);

    // Act and Assert
    assertEquals("LEGACY_JACK_O_LANTERN(0) facing NORTH LIT", pumpkin.toString());
  }

  /**
   * Test {@link Pumpkin#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_JACK_O_LANTERN(1) facing EAST LIT}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_JACK_O_LANTERN(1) facing EAST LIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Pumpkin.toString()"})
  void testToString_thenReturnLegacyJackOLantern1FacingEastLit() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin(Material.LEGACY_JACK_O_LANTERN);
    pumpkin.setData((byte) 1);

    // Act and Assert
    assertEquals("LEGACY_JACK_O_LANTERN(1) facing EAST LIT", pumpkin.toString());
  }

  /**
   * Test {@link Pumpkin#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_JACK_O_LANTERN(2) facing SOUTH LIT}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_JACK_O_LANTERN(2) facing SOUTH LIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Pumpkin.toString()"})
  void testToString_thenReturnLegacyJackOLantern2FacingSouthLit() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin(Material.LEGACY_JACK_O_LANTERN);
    pumpkin.setData((byte) 2);

    // Act and Assert
    assertEquals("LEGACY_JACK_O_LANTERN(2) facing SOUTH LIT", pumpkin.toString());
  }

  /**
   * Test {@link Pumpkin#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_JACK_O_LANTERN(3) facing EAST LIT}.
   * </ul>
   *
   * <p>Method under test: {@link Pumpkin#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_JACK_O_LANTERN(3) facing EAST LIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Pumpkin.toString()"})
  void testToString_thenReturnLegacyJackOLantern3FacingEastLit() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin(Material.LEGACY_JACK_O_LANTERN);
    pumpkin.setData((byte) 3);

    // Act and Assert
    assertEquals("LEGACY_JACK_O_LANTERN(3) facing EAST LIT", pumpkin.toString());
  }

  /**
   * Test {@link Pumpkin#clone()}.
   *
   * <p>Method under test: {@link Pumpkin#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pumpkin Pumpkin.clone()"})
  void testClone() {
    // Arrange
    Pumpkin pumpkin = new Pumpkin();

    // Act
    Pumpkin actualCloneResult = pumpkin.clone();

    // Assert
    assertEquals(pumpkin, actualCloneResult);
  }
}
