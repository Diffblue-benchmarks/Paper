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

class BannerDiffblueTest {
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
   *   <li>{@link Banner#Banner(Material, byte)}
   *   <li>{@link Banner#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'A'; then return toString is 'ACACIA_BOAT(65) facing null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Banner.<init>(Material)",
    "void Banner.<init>(Material, byte)",
    "java.lang.String Banner.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsAcaciaBoat65FacingNull() {
    // Arrange and Act
    Banner actualBanner = new Banner(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) facing null", actualBanner.toString());
    assertEquals(Material.ACACIA_BOAT, actualBanner.getItemType());
    assertEquals('A', actualBanner.getData());
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
   *   <li>{@link Banner#Banner(Material)}
   *   <li>{@link Banner#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'ACACIA_BOAT(0) facing SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Banner.<init>(Material)",
    "void Banner.<init>(Material, byte)",
    "java.lang.String Banner.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsAcaciaBoat0FacingSouth() {
    // Arrange and Act
    Banner actualBanner = new Banner(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) facing SOUTH", actualBanner.toString());
    assertEquals((byte) 0, actualBanner.getData());
    assertEquals(Material.ACACIA_BOAT, actualBanner.getItemType());
  }

  /**
   * Test {@link Banner#Banner()}.
   *
   * <p>Method under test: {@link Banner#Banner()}
   */
  @Test
  @DisplayName("Test new Banner()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.<init>()"})
  void testNewBanner() {
    // Arrange and Act
    Banner actualBanner = new Banner();

    // Assert
    assertEquals((byte) 0, actualBanner.getData());
    assertEquals(Material.LEGACY_BANNER, actualBanner.getItemType());
    assertEquals(BlockFace.DOWN, actualBanner.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualBanner.getFacing());
    assertFalse(actualBanner.isWallBanner());
  }

  /**
   * Test {@link Banner#isWallBanner()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#isWallBanner()}
   */
  @Test
  @DisplayName(
      "Test isWallBanner(); given Banner(Material) with type is LEGACY_WALL_BANNER; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Banner.isWallBanner()"})
  void testIsWallBanner_givenBannerWithTypeIsLegacy_wall_banner_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Banner(Material.LEGACY_WALL_BANNER).isWallBanner());
  }

  /**
   * Test {@link Banner#isWallBanner()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#isWallBanner()}
   */
  @Test
  @DisplayName("Test isWallBanner(); given Banner(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Banner.isWallBanner()"})
  void testIsWallBanner_givenBanner_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Banner().isWallBanner());
  }

  /**
   * Test {@link Banner#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given Banner(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getAttachedFace()"})
  void testGetAttachedFace_givenBanner_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Banner().getAttachedFace());
  }

  /**
   * Test {@link Banner#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getAttachedFace()"})
  void testGetAttachedFace_thenReturnEast() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.EAST, banner.getAttachedFace());
  }

  /**
   * Test {@link Banner#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getAttachedFace()"})
  void testGetAttachedFace_thenReturnNorth() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.NORTH, banner.getAttachedFace());
  }

  /**
   * Test {@link Banner#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getAttachedFace()"})
  void testGetAttachedFace_thenReturnNull() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 'A');

    // Act and Assert
    assertNull(banner.getAttachedFace());
  }

  /**
   * Test {@link Banner#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getAttachedFace()"})
  void testGetAttachedFace_thenReturnSouth() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, banner.getAttachedFace());
  }

  /**
   * Test {@link Banner#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getAttachedFace()"})
  void testGetAttachedFace_thenReturnWest() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 5);

    // Act and Assert
    assertEquals(BlockFace.WEST, banner.getAttachedFace());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsAcaciaBoatAndDataIsA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Banner(Material.ACACIA_BOAT, (byte) 'A').getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       backspace.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material, byte) with type is 'ACACIA_BOAT' and data is backspace; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsAcaciaBoatAndDataIsBackspace_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Banner(Material.ACACIA_BOAT, (byte) '\b').getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       cr.
   *   <li>Then return {@code EAST_SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material, byte) with type is 'ACACIA_BOAT' and data is cr; then return 'EAST_SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsAcaciaBoatAndDataIsCr_thenReturnEastSouthEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST_SOUTH_EAST, new Banner(Material.ACACIA_BOAT, (byte) '\r').getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       form feed (ff).
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material, byte) with type is 'ACACIA_BOAT' and data is form feed (ff); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsAcaciaBoatAndDataIsFormFeed_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Banner(Material.ACACIA_BOAT, (byte) '\f').getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       four.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material, byte) with type is 'ACACIA_BOAT' and data is four; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsAcaciaBoatAndDataIsFour_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Banner(Material.ACACIA_BOAT, (byte) 4).getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       lf.
   *   <li>Then return {@code NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material, byte) with type is 'ACACIA_BOAT' and data is lf; then return 'NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsAcaciaBoatAndDataIsLf_thenReturnNorthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_EAST, new Banner(Material.ACACIA_BOAT, (byte) '\n').getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       six.
   *   <li>Then return {@code NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material, byte) with type is 'ACACIA_BOAT' and data is six; then return 'NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsAcaciaBoatAndDataIsSix_thenReturnNorthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_WEST, new Banner(Material.ACACIA_BOAT, (byte) 6).getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       two.
   *   <li>Then return {@code SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material, byte) with type is 'ACACIA_BOAT' and data is two; then return 'SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsAcaciaBoatAndDataIsTwo_thenReturnSouthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_WEST, new Banner(Material.ACACIA_BOAT, (byte) 2).getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}
   *       Data is five.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material) with type is LEGACY_WALL_BANNER Data is five; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsLegacy_wall_bannerDataIsFive_thenReturnEast() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 5);

    // Act and Assert
    assertEquals(BlockFace.EAST, banner.getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}
   *       Data is four.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material) with type is LEGACY_WALL_BANNER Data is four; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsLegacy_wall_bannerDataIsFour_thenReturnWest() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}
   *       Data is three.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material) with type is LEGACY_WALL_BANNER Data is three; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsLegacy_wall_bannerDataIsThree_thenReturnSouth() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, banner.getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}
   *       Data is two.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Banner(Material) with type is LEGACY_WALL_BANNER Data is two; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBannerWithTypeIsLegacy_wall_bannerDataIsTwo_thenReturnNorth() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);
    banner.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.NORTH, banner.getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Banner(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_givenBanner_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Banner().getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code EAST_NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'EAST_NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_thenReturnEastNorthEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST_NORTH_EAST, new Banner(Material.ACACIA_BOAT, (byte) 11).getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH_NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'NORTH_NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_thenReturnNorthNorthEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH_NORTH_EAST, new Banner(Material.ACACIA_BOAT, (byte) '\t').getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH_NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'NORTH_NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_thenReturnNorthNorthWest() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.NORTH_NORTH_WEST, new Banner(Material.ACACIA_BOAT, (byte) 7).getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_thenReturnSouthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_EAST, new Banner(Material.ACACIA_BOAT, (byte) 14).getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH_SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'SOUTH_SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_thenReturnSouthSouthWest() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.SOUTH_SOUTH_WEST, new Banner(Material.ACACIA_BOAT, (byte) 1).getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code WEST_NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'WEST_NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_thenReturnWestNorthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST_NORTH_WEST, new Banner(Material.ACACIA_BOAT, (byte) 5).getFacing());
  }

  /**
   * Test {@link Banner#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code WEST_SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'WEST_SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Banner.getFacing()"})
  void testGetFacing_thenReturnWestSouthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST_SOUTH_WEST, new Banner(Material.ACACIA_BOAT, (byte) 3).getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then {@link Banner#Banner()} Facing is {@code NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'NORTH_EAST'; then Banner() Facing is 'NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenNorthEast_thenBannerFacingIsNorthEast() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.NORTH_EAST);

    // Assert
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.NORTH_EAST, banner.getFacing());
    assertEquals('\n', banner.getData());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code NORTH_NORTH_WEST}.
   *   <li>Then {@link Banner#Banner()} Data is seven.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'NORTH_NORTH_WEST'; then Banner() Data is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenNorthNorthWest_thenBannerDataIsSeven() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.NORTH_NORTH_WEST);

    // Assert
    assertEquals((byte) 7, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.NORTH_NORTH_WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code NORTH_WEST}.
   *   <li>Then {@link Banner#Banner()} Data is six.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'NORTH_WEST'; then Banner() Data is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenNorthWest_thenBannerDataIsSix() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.NORTH_WEST);

    // Assert
    assertEquals((byte) 6, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.NORTH_WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Banner#Banner()} Facing is {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'NORTH'; then Banner() Facing is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenNorth_thenBannerFacingIsNorth() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.NORTH, banner.getFacing());
    assertEquals('\b', banner.getData());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code SOUTH_SOUTH_WEST}.
   *   <li>Then {@link Banner#Banner()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'SOUTH_SOUTH_WEST'; then Banner() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenSouthSouthWest_thenBannerDataIsOne() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.SOUTH_SOUTH_WEST);

    // Assert
    assertEquals((byte) 1, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.SOUTH_SOUTH_WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code SOUTH_WEST}.
   *   <li>Then {@link Banner#Banner()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'SOUTH_WEST'; then Banner() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenSouthWest_thenBannerDataIsTwo() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.SOUTH_WEST);

    // Assert
    assertEquals((byte) 2, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.SOUTH_WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code UP}.
   *   <li>Then {@link Banner#Banner()} Data is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'UP'; then Banner() Data is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenUp_thenBannerDataIsFourteen() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 14, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.SOUTH_EAST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code WEST_NORTH_WEST}.
   *   <li>Then {@link Banner#Banner()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'WEST_NORTH_WEST'; then Banner() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenWestNorthWest_thenBannerDataIsFive() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.WEST_NORTH_WEST);

    // Assert
    assertEquals((byte) 5, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.WEST_NORTH_WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Banner#Banner()}.
   *   <li>When {@code WEST_SOUTH_WEST}.
   *   <li>Then {@link Banner#Banner()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Banner(); when 'WEST_SOUTH_WEST'; then Banner() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenBanner_whenWestSouthWest_thenBannerDataIsThree() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.WEST_SOUTH_WEST);

    // Assert
    assertEquals((byte) 3, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.WEST_SOUTH_WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Banner#Banner(Material)} with type is {@code ACACIA_BOAT} Data is eleven.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Banner(Material) with type is 'ACACIA_BOAT' Data is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenBannerWithTypeIsAcaciaBoatDataIsEleven() {
    // Arrange
    Banner banner = new Banner(Material.ACACIA_BOAT);

    // Act
    banner.setFacingDirection(BlockFace.EAST_NORTH_EAST);

    // Assert
    assertEquals((byte) 11, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.EAST_NORTH_EAST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Banner#Banner(Material)} with type is {@code ACACIA_BOAT} Data is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Banner(Material) with type is 'ACACIA_BOAT' Data is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenBannerWithTypeIsAcaciaBoatDataIsFifteen() {
    // Arrange
    Banner banner = new Banner(Material.ACACIA_BOAT);

    // Act
    banner.setFacingDirection(BlockFace.SOUTH_SOUTH_EAST);

    // Assert
    assertEquals((byte) 15, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.SOUTH_SOUTH_EAST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Banner#Banner(Material)} with type is {@code ACACIA_BOAT} Facing is {@code
   *       EAST_SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Banner(Material) with type is 'ACACIA_BOAT' Facing is 'EAST_SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenBannerWithTypeIsAcaciaBoatFacingIsEastSouthEast() {
    // Arrange
    Banner banner = new Banner(Material.ACACIA_BOAT);

    // Act
    banner.setFacingDirection(BlockFace.EAST_SOUTH_EAST);

    // Assert
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.EAST_SOUTH_EAST, banner.getFacing());
    assertEquals('\r', banner.getData());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}
   *       Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Banner(Material) with type is LEGACY_WALL_BANNER Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenBannerWithTypeIsLegacy_wall_bannerDataIsThree() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);

    // Act
    banner.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, banner.getData());
    assertEquals(BlockFace.NORTH, banner.getAttachedFace());
    assertEquals(BlockFace.SOUTH, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Banner#Banner(Material)} with type is {@code ACACIA_BOAT} Facing is {@code
   *       EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'EAST'; then Banner(Material) with type is 'ACACIA_BOAT' Facing is 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenBannerWithTypeIsAcaciaBoatFacingIsEast() {
    // Arrange
    Banner banner = new Banner(Material.ACACIA_BOAT);

    // Act
    banner.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.EAST, banner.getFacing());
    assertEquals('\f', banner.getData());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}
   *       Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'EAST'; then Banner(Material) with type is LEGACY_WALL_BANNER Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenBannerWithTypeIsLegacy_wall_bannerDataIsFive() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);

    // Act
    banner.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, banner.getData());
    assertEquals(BlockFace.EAST, banner.getFacing());
    assertEquals(BlockFace.WEST, banner.getAttachedFace());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH_NORTH_EAST}.
   *   <li>Then {@link Banner#Banner()} Facing is {@code NORTH_NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'NORTH_NORTH_EAST'; then Banner() Facing is 'NORTH_NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorthNorthEast_thenBannerFacingIsNorthNorthEast() {
    // Arrange
    Banner banner = new Banner();

    // Act
    banner.setFacingDirection(BlockFace.NORTH_NORTH_EAST);

    // Assert
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.NORTH_NORTH_EAST, banner.getFacing());
    assertEquals('\t', banner.getData());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}
   *       Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'NORTH'; then Banner(Material) with type is LEGACY_WALL_BANNER Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenBannerWithTypeIsLegacy_wall_bannerDataIsTwo() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);

    // Act
    banner.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, banner.getData());
    assertEquals(BlockFace.NORTH, banner.getFacing());
    assertEquals(BlockFace.SOUTH, banner.getAttachedFace());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Banner#Banner(Material)} with type is {@code ACACIA_BOAT} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'SOUTH'; then Banner(Material) with type is 'ACACIA_BOAT' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenBannerWithTypeIsAcaciaBoatDataIsZero() {
    // Arrange
    Banner banner = new Banner(Material.ACACIA_BOAT);

    // Act
    banner.setFacingDirection(BlockFace.SOUTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.SOUTH, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Banner#Banner(Material)} with type is {@code ACACIA_BOAT} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'WEST'; then Banner(Material) with type is 'ACACIA_BOAT' Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenBannerWithTypeIsAcaciaBoatDataIsFour() {
    // Arrange
    Banner banner = new Banner(Material.ACACIA_BOAT);

    // Act
    banner.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, banner.getData());
    assertEquals(BlockFace.DOWN, banner.getAttachedFace());
    assertEquals(BlockFace.WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Banner#Banner(Material)} with type is {@link Material#LEGACY_WALL_BANNER}
   *       Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Banner#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'WEST'; then Banner(Material) with type is LEGACY_WALL_BANNER Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Banner.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenBannerWithTypeIsLegacy_wall_bannerDataIsFour() {
    // Arrange
    Banner banner = new Banner(Material.LEGACY_WALL_BANNER);

    // Act
    banner.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, banner.getData());
    assertEquals(BlockFace.EAST, banner.getAttachedFace());
    assertEquals(BlockFace.WEST, banner.getFacing());
  }

  /**
   * Test {@link Banner#clone()}.
   *
   * <p>Method under test: {@link Banner#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Banner Banner.clone()"})
  void testClone() {
    // Arrange
    Banner banner = new Banner();

    // Act
    Banner actualCloneResult = banner.clone();

    // Assert
    assertEquals(banner, actualCloneResult);
  }
}
