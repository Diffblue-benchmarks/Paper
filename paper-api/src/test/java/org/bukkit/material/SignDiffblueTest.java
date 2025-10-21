package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SignDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code ACACIA_BOAT(65) facing null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Sign#Sign(Material, byte)}
   *   <li>{@link Sign#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'A'; then return toString is 'ACACIA_BOAT(65) facing null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Sign.<init>(Material)",
    "void Sign.<init>(Material, byte)",
    "java.lang.String Sign.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsAcaciaBoat65FacingNull() {
    // Arrange and Act
    Sign actualSign = new Sign(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) facing null", actualSign.toString());
    assertEquals(Material.ACACIA_BOAT, actualSign.getItemType());
    assertEquals('A', actualSign.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code ACACIA_BOAT(0) facing SOUTH}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Sign#Sign(Material)}
   *   <li>{@link Sign#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'ACACIA_BOAT(0) facing SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Sign.<init>(Material)",
    "void Sign.<init>(Material, byte)",
    "java.lang.String Sign.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsAcaciaBoat0FacingSouth() {
    // Arrange and Act
    Sign actualSign = new Sign(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) facing SOUTH", actualSign.toString());
    assertEquals((byte) 0, actualSign.getData());
    assertEquals(Material.ACACIA_BOAT, actualSign.getItemType());
  }

  /**
   * Test {@link Sign#Sign()}.
   *
   * <p>Method under test: {@link Sign#Sign()}
   */
  @Test
  @DisplayName("Test new Sign()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.<init>()"})
  void testNewSign() {
    // Arrange and Act
    Sign actualSign = new Sign();

    // Assert
    assertEquals((byte) 0, actualSign.getData());
    assertEquals(Material.LEGACY_SIGN_POST, actualSign.getItemType());
    assertEquals(BlockFace.DOWN, actualSign.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualSign.getFacing());
    assertFalse(actualSign.isWallSign());
  }

  /**
   * Test {@link Sign#isWallSign()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#isWallSign()}
   */
  @Test
  @DisplayName(
      "Test isWallSign(); given Sign(Material) with type is LEGACY_WALL_SIGN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sign.isWallSign()"})
  void testIsWallSign_givenSignWithTypeIsLegacy_wall_sign_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Sign(Material.LEGACY_WALL_SIGN).isWallSign());
  }

  /**
   * Test {@link Sign#isWallSign()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#isWallSign()}
   */
  @Test
  @DisplayName("Test isWallSign(); given Sign(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sign.isWallSign()"})
  void testIsWallSign_givenSign_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Sign().isWallSign());
  }

  /**
   * Test {@link Sign#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Sign(Material) with type is LEGACY_WALL_SIGN Data is 'A'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getAttachedFace()"})
  void testGetAttachedFace_givenSignWithTypeIsLegacy_wall_signDataIsA_thenReturnNull() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 'A');

    // Act and Assert
    assertNull(sign.getAttachedFace());
  }

  /**
   * Test {@link Sign#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       five.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Sign(Material) with type is LEGACY_WALL_SIGN Data is five; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getAttachedFace()"})
  void testGetAttachedFace_givenSignWithTypeIsLegacy_wall_signDataIsFive_thenReturnWest() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 5);

    // Act and Assert
    assertEquals(BlockFace.WEST, sign.getAttachedFace());
  }

  /**
   * Test {@link Sign#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       four.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Sign(Material) with type is LEGACY_WALL_SIGN Data is four; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getAttachedFace()"})
  void testGetAttachedFace_givenSignWithTypeIsLegacy_wall_signDataIsFour_thenReturnEast() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.EAST, sign.getAttachedFace());
  }

  /**
   * Test {@link Sign#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       two.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Sign(Material) with type is LEGACY_WALL_SIGN Data is two; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getAttachedFace()"})
  void testGetAttachedFace_givenSignWithTypeIsLegacy_wall_signDataIsTwo_thenReturnSouth() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, sign.getAttachedFace());
  }

  /**
   * Test {@link Sign#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given Sign(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getAttachedFace()"})
  void testGetAttachedFace_givenSign_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Sign().getAttachedFace());
  }

  /**
   * Test {@link Sign#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getAttachedFace()"})
  void testGetAttachedFace_thenReturnNorth() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.NORTH, sign.getAttachedFace());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Sign(Material.ACACIA_BOAT, (byte) 'A').getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       backspace.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is backspace; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsBackspace_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Sign(Material.ACACIA_BOAT, (byte) '\b').getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is cr.
   *   <li>Then return {@code EAST_SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is cr; then return 'EAST_SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsCr_thenReturnEastSouthEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST_SOUTH_EAST, new Sign(Material.ACACIA_BOAT, (byte) '\r').getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       five.
   *   <li>Then return {@code WEST_NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is five; then return 'WEST_NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsFive_thenReturnWestNorthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST_NORTH_WEST, new Sign(Material.ACACIA_BOAT, (byte) 5).getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is form
   *       feed (ff).
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is form feed (ff); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsFormFeed_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Sign(Material.ACACIA_BOAT, (byte) '\f').getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       four.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is four; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsFour_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Sign(Material.ACACIA_BOAT, (byte) 4).getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       fourteen.
   *   <li>Then return {@code SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is fourteen; then return 'SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsFourteen_thenReturnSouthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_EAST, new Sign(Material.ACACIA_BOAT, (byte) 14).getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is lf.
   *   <li>Then return {@code NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is lf; then return 'NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsLf_thenReturnNorthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_EAST, new Sign(Material.ACACIA_BOAT, (byte) '\n').getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is one.
   *   <li>Then return {@code SOUTH_SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is one; then return 'SOUTH_SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsOne_thenReturnSouthSouthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_SOUTH_WEST, new Sign(Material.ACACIA_BOAT, (byte) 1).getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is six.
   *   <li>Then return {@code NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is six; then return 'NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsSix_thenReturnNorthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_WEST, new Sign(Material.ACACIA_BOAT, (byte) 6).getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is tab.
   *   <li>Then return {@code NORTH_NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is tab; then return 'NORTH_NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsTab_thenReturnNorthNorthEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH_NORTH_EAST, new Sign(Material.ACACIA_BOAT, (byte) '\t').getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material, byte)} with type is {@code ACACIA_BOAT} and data is two.
   *   <li>Then return {@code SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material, byte) with type is 'ACACIA_BOAT' and data is two; then return 'SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsAcaciaBoatAndDataIsTwo_thenReturnSouthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_WEST, new Sign(Material.ACACIA_BOAT, (byte) 2).getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       five.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material) with type is LEGACY_WALL_SIGN Data is five; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsLegacy_wall_signDataIsFive_thenReturnEast() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 5);

    // Act and Assert
    assertEquals(BlockFace.EAST, sign.getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       four.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material) with type is LEGACY_WALL_SIGN Data is four; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsLegacy_wall_signDataIsFour_thenReturnWest() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       three.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material) with type is LEGACY_WALL_SIGN Data is three; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsLegacy_wall_signDataIsThree_thenReturnSouth() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, sign.getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       two.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Sign(Material) with type is LEGACY_WALL_SIGN Data is two; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSignWithTypeIsLegacy_wall_signDataIsTwo_thenReturnNorth() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);
    sign.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.NORTH, sign.getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Sign(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_givenSign_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Sign().getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code EAST_NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'EAST_NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_thenReturnEastNorthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST_NORTH_EAST, new Sign(Material.ACACIA_BOAT, (byte) 11).getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH_NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'NORTH_NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_thenReturnNorthNorthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_NORTH_WEST, new Sign(Material.ACACIA_BOAT, (byte) 7).getFacing());
  }

  /**
   * Test {@link Sign#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code WEST_SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'WEST_SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Sign.getFacing()"})
  void testGetFacing_thenReturnWestSouthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST_SOUTH_WEST, new Sign(Material.ACACIA_BOAT, (byte) 3).getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then {@link Sign#Sign()} Facing is {@code NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'NORTH_EAST'; then Sign() Facing is 'NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenNorthEast_thenSignFacingIsNorthEast() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.NORTH_EAST);

    // Assert
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.NORTH_EAST, sign.getFacing());
    assertEquals('\n', sign.getData());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code NORTH_NORTH_WEST}.
   *   <li>Then {@link Sign#Sign()} Data is seven.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'NORTH_NORTH_WEST'; then Sign() Data is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenNorthNorthWest_thenSignDataIsSeven() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.NORTH_NORTH_WEST);

    // Assert
    assertEquals((byte) 7, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.NORTH_NORTH_WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code NORTH_WEST}.
   *   <li>Then {@link Sign#Sign()} Data is six.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'NORTH_WEST'; then Sign() Data is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenNorthWest_thenSignDataIsSix() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.NORTH_WEST);

    // Assert
    assertEquals((byte) 6, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.NORTH_WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Sign#Sign()} Facing is {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'NORTH'; then Sign() Facing is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenNorth_thenSignFacingIsNorth() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.NORTH, sign.getFacing());
    assertEquals('\b', sign.getData());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code SOUTH_SOUTH_WEST}.
   *   <li>Then {@link Sign#Sign()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'SOUTH_SOUTH_WEST'; then Sign() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenSouthSouthWest_thenSignDataIsOne() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.SOUTH_SOUTH_WEST);

    // Assert
    assertEquals((byte) 1, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.SOUTH_SOUTH_WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code SOUTH_WEST}.
   *   <li>Then {@link Sign#Sign()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'SOUTH_WEST'; then Sign() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenSouthWest_thenSignDataIsTwo() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.SOUTH_WEST);

    // Assert
    assertEquals((byte) 2, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.SOUTH_WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code UP}.
   *   <li>Then {@link Sign#Sign()} Data is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'UP'; then Sign() Data is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenUp_thenSignDataIsFourteen() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 14, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.SOUTH_EAST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code WEST_NORTH_WEST}.
   *   <li>Then {@link Sign#Sign()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'WEST_NORTH_WEST'; then Sign() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenWestNorthWest_thenSignDataIsFive() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.WEST_NORTH_WEST);

    // Assert
    assertEquals((byte) 5, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.WEST_NORTH_WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Sign#Sign()}.
   *   <li>When {@code WEST_SOUTH_WEST}.
   *   <li>Then {@link Sign#Sign()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Sign(); when 'WEST_SOUTH_WEST'; then Sign() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenSign_whenWestSouthWest_thenSignDataIsThree() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.WEST_SOUTH_WEST);

    // Assert
    assertEquals((byte) 3, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.WEST_SOUTH_WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Sign#Sign(Material)} with type is {@code ACACIA_BOAT} Data is eleven.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Sign(Material) with type is 'ACACIA_BOAT' Data is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenSignWithTypeIsAcaciaBoatDataIsEleven() {
    // Arrange
    Sign sign = new Sign(Material.ACACIA_BOAT);

    // Act
    sign.setFacingDirection(BlockFace.EAST_NORTH_EAST);

    // Assert
    assertEquals((byte) 11, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.EAST_NORTH_EAST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Sign#Sign(Material)} with type is {@code ACACIA_BOAT} Data is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Sign(Material) with type is 'ACACIA_BOAT' Data is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenSignWithTypeIsAcaciaBoatDataIsFifteen() {
    // Arrange
    Sign sign = new Sign(Material.ACACIA_BOAT);

    // Act
    sign.setFacingDirection(BlockFace.SOUTH_SOUTH_EAST);

    // Assert
    assertEquals((byte) 15, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.SOUTH_SOUTH_EAST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Sign#Sign(Material)} with type is {@code ACACIA_BOAT} Facing is {@code
   *       EAST_SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Sign(Material) with type is 'ACACIA_BOAT' Facing is 'EAST_SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenSignWithTypeIsAcaciaBoatFacingIsEastSouthEast() {
    // Arrange
    Sign sign = new Sign(Material.ACACIA_BOAT);

    // Act
    sign.setFacingDirection(BlockFace.EAST_SOUTH_EAST);

    // Assert
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.EAST_SOUTH_EAST, sign.getFacing());
    assertEquals('\r', sign.getData());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Sign#Sign(Material)} with type is {@code ACACIA_BOAT} Facing is {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'EAST'; then Sign(Material) with type is 'ACACIA_BOAT' Facing is 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenSignWithTypeIsAcaciaBoatFacingIsEast() {
    // Arrange
    Sign sign = new Sign(Material.ACACIA_BOAT);

    // Act
    sign.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.EAST, sign.getFacing());
    assertEquals('\f', sign.getData());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       five.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'EAST'; then Sign(Material) with type is LEGACY_WALL_SIGN Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenSignWithTypeIsLegacy_wall_signDataIsFive() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);

    // Act
    sign.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, sign.getData());
    assertEquals(BlockFace.EAST, sign.getFacing());
    assertEquals(BlockFace.WEST, sign.getAttachedFace());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH_NORTH_EAST}.
   *   <li>Then {@link Sign#Sign()} Facing is {@code NORTH_NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'NORTH_NORTH_EAST'; then Sign() Facing is 'NORTH_NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorthNorthEast_thenSignFacingIsNorthNorthEast() {
    // Arrange
    Sign sign = new Sign();

    // Act
    sign.setFacingDirection(BlockFace.NORTH_NORTH_EAST);

    // Assert
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.NORTH_NORTH_EAST, sign.getFacing());
    assertEquals('\t', sign.getData());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'NORTH'; then Sign(Material) with type is LEGACY_WALL_SIGN Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenSignWithTypeIsLegacy_wall_signDataIsTwo() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);

    // Act
    sign.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, sign.getData());
    assertEquals(BlockFace.NORTH, sign.getFacing());
    assertEquals(BlockFace.SOUTH, sign.getAttachedFace());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Sign#Sign(Material)} with type is {@code ACACIA_BOAT} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'SOUTH'; then Sign(Material) with type is 'ACACIA_BOAT' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenSignWithTypeIsAcaciaBoatDataIsZero() {
    // Arrange
    Sign sign = new Sign(Material.ACACIA_BOAT);

    // Act
    sign.setFacingDirection(BlockFace.SOUTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.SOUTH, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'SOUTH'; then Sign(Material) with type is LEGACY_WALL_SIGN Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenSignWithTypeIsLegacy_wall_signDataIsThree() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);

    // Act
    sign.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, sign.getData());
    assertEquals(BlockFace.NORTH, sign.getAttachedFace());
    assertEquals(BlockFace.SOUTH, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Sign#Sign(Material)} with type is {@code ACACIA_BOAT} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'WEST'; then Sign(Material) with type is 'ACACIA_BOAT' Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenSignWithTypeIsAcaciaBoatDataIsFour() {
    // Arrange
    Sign sign = new Sign(Material.ACACIA_BOAT);

    // Act
    sign.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, sign.getData());
    assertEquals(BlockFace.DOWN, sign.getAttachedFace());
    assertEquals(BlockFace.WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Sign#Sign(Material)} with type is {@link Material#LEGACY_WALL_SIGN} Data is
   *       four.
   * </ul>
   *
   * <p>Method under test: {@link Sign#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'WEST'; then Sign(Material) with type is LEGACY_WALL_SIGN Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sign.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenSignWithTypeIsLegacy_wall_signDataIsFour() {
    // Arrange
    Sign sign = new Sign(Material.LEGACY_WALL_SIGN);

    // Act
    sign.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, sign.getData());
    assertEquals(BlockFace.EAST, sign.getAttachedFace());
    assertEquals(BlockFace.WEST, sign.getFacing());
  }

  /**
   * Test {@link Sign#clone()}.
   *
   * <p>Method under test: {@link Sign#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sign Sign.clone()"})
  void testClone() {
    // Arrange
    Sign sign = new Sign();

    // Act
    Sign actualCloneResult = sign.clone();

    // Assert
    assertEquals(sign, actualCloneResult);
  }
}
