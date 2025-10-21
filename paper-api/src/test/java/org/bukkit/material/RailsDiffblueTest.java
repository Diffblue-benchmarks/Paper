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

class RailsDiffblueTest {
  /**
   * Test {@link Rails#Rails()}.
   *
   * <p>Method under test: {@link Rails#Rails()}
   */
  @Test
  @DisplayName("Test new Rails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.<init>()"})
  void testNewRails() {
    // Arrange and Act
    Rails actualRails = new Rails();

    // Assert
    assertEquals((byte) 0, actualRails.getData());
    assertEquals((byte) 0, actualRails.getConvertedData());
    assertEquals(Material.LEGACY_RAILS, actualRails.getItemType());
    assertEquals(BlockFace.SOUTH, actualRails.getDirection());
    assertFalse(actualRails.isCurve());
    assertFalse(actualRails.isOnSlope());
  }

  /**
   * Test {@link Rails#Rails(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#Rails(Material, byte)}
   */
  @Test
  @DisplayName("Test new Rails(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.<init>(Material)", "void Rails.<init>(Material, byte)"})
  void testNewRails_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Rails actualRails = new Rails(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualRails.getItemType());
    assertEquals('A', actualRails.getData());
  }

  /**
   * Test {@link Rails#Rails(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Rails#Rails(Material)}
   */
  @Test
  @DisplayName("Test new Rails(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.<init>(Material)", "void Rails.<init>(Material, byte)"})
  void testNewRails_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Rails actualRails = new Rails(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualRails.getData());
    assertEquals(Material.ACACIA_BOAT, actualRails.getItemType());
  }

  /**
   * Test {@link Rails#isOnSlope()}.
   *
   * <ul>
   *   <li>Given {@link DetectorRail#DetectorRail()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isOnSlope()}
   */
  @Test
  @DisplayName("Test isOnSlope(); given DetectorRail(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isOnSlope()"})
  void testIsOnSlope_givenDetectorRail_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DetectorRail().isOnSlope());
  }

  /**
   * Test {@link Rails#isOnSlope()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is five.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isOnSlope()}
   */
  @Test
  @DisplayName(
      "Test isOnSlope(); given Rails(Material) with type is 'ACACIA_BOAT' Data is five; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isOnSlope()"})
  void testIsOnSlope_givenRailsWithTypeIsAcaciaBoatDataIsFive_thenReturnTrue() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 5);

    // Act and Assert
    assertTrue(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#isOnSlope()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is four.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isOnSlope()}
   */
  @Test
  @DisplayName(
      "Test isOnSlope(); given Rails(Material) with type is 'ACACIA_BOAT' Data is four; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isOnSlope()"})
  void testIsOnSlope_givenRailsWithTypeIsAcaciaBoatDataIsFour_thenReturnTrue() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 4);

    // Act and Assert
    assertTrue(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#isOnSlope()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isOnSlope()}
   */
  @Test
  @DisplayName(
      "Test isOnSlope(); given Rails(Material) with type is 'ACACIA_BOAT' Data is three; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isOnSlope()"})
  void testIsOnSlope_givenRailsWithTypeIsAcaciaBoatDataIsThree_thenReturnTrue() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 3);

    // Act and Assert
    assertTrue(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#isOnSlope()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isOnSlope()}
   */
  @Test
  @DisplayName(
      "Test isOnSlope(); given Rails(Material) with type is 'ACACIA_BOAT' Data is two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isOnSlope()"})
  void testIsOnSlope_givenRailsWithTypeIsAcaciaBoatDataIsTwo_thenReturnTrue() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 2);

    // Act and Assert
    assertTrue(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#isOnSlope()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isOnSlope()}
   */
  @Test
  @DisplayName("Test isOnSlope(); given Rails(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isOnSlope()"})
  void testIsOnSlope_givenRails_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Rails().isOnSlope());
  }

  /**
   * Test {@link Rails#isCurve()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is backspace.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isCurve()}
   */
  @Test
  @DisplayName(
      "Test isCurve(); given Rails(Material) with type is 'ACACIA_BOAT' Data is backspace; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isCurve()"})
  void testIsCurve_givenRailsWithTypeIsAcaciaBoatDataIsBackspace_thenReturnTrue() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) '\b');

    // Act and Assert
    assertTrue(rails.isCurve());
  }

  /**
   * Test {@link Rails#isCurve()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is seven.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isCurve()}
   */
  @Test
  @DisplayName(
      "Test isCurve(); given Rails(Material) with type is 'ACACIA_BOAT' Data is seven; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isCurve()"})
  void testIsCurve_givenRailsWithTypeIsAcaciaBoatDataIsSeven_thenReturnTrue() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 7);

    // Act and Assert
    assertTrue(rails.isCurve());
  }

  /**
   * Test {@link Rails#isCurve()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is six.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isCurve()}
   */
  @Test
  @DisplayName(
      "Test isCurve(); given Rails(Material) with type is 'ACACIA_BOAT' Data is six; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isCurve()"})
  void testIsCurve_givenRailsWithTypeIsAcaciaBoatDataIsSix_thenReturnTrue() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 6);

    // Act and Assert
    assertTrue(rails.isCurve());
  }

  /**
   * Test {@link Rails#isCurve()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is tab.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isCurve()}
   */
  @Test
  @DisplayName(
      "Test isCurve(); given Rails(Material) with type is 'ACACIA_BOAT' Data is tab; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isCurve()"})
  void testIsCurve_givenRailsWithTypeIsAcaciaBoatDataIsTab_thenReturnTrue() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) '\t');

    // Act and Assert
    assertTrue(rails.isCurve());
  }

  /**
   * Test {@link Rails#isCurve()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#isCurve()}
   */
  @Test
  @DisplayName("Test isCurve(); given Rails(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rails.isCurve()"})
  void testIsCurve_givenRails_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Rails().isCurve());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link DetectorRail#DetectorRail()}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given DetectorRail(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenDetectorRail_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new DetectorRail().getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is five.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName(
      "Test getDirection(); given Rails(Material) with type is 'ACACIA_BOAT' Data is five; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRailsWithTypeIsAcaciaBoatDataIsFive_thenReturnSouth() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 5);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, rails.getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is four.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName(
      "Test getDirection(); given Rails(Material) with type is 'ACACIA_BOAT' Data is four; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRailsWithTypeIsAcaciaBoatDataIsFour_thenReturnNorth() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.NORTH, rails.getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is one.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName(
      "Test getDirection(); given Rails(Material) with type is 'ACACIA_BOAT' Data is one; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRailsWithTypeIsAcaciaBoatDataIsOne_thenReturnEast() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 1);

    // Act and Assert
    assertEquals(BlockFace.EAST, rails.getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is seven.
   *   <li>Then return {@code NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName(
      "Test getDirection(); given Rails(Material) with type is 'ACACIA_BOAT' Data is seven; then return 'NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRailsWithTypeIsAcaciaBoatDataIsSeven_thenReturnNorthEast() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 7);

    // Act and Assert
    assertEquals(BlockFace.NORTH_EAST, rails.getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is six.
   *   <li>Then return {@code NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName(
      "Test getDirection(); given Rails(Material) with type is 'ACACIA_BOAT' Data is six; then return 'NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRailsWithTypeIsAcaciaBoatDataIsSix_thenReturnNorthWest() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 6);

    // Act and Assert
    assertEquals(BlockFace.NORTH_WEST, rails.getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is tab.
   *   <li>Then return {@code SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName(
      "Test getDirection(); given Rails(Material) with type is 'ACACIA_BOAT' Data is tab; then return 'SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRailsWithTypeIsAcaciaBoatDataIsTab_thenReturnSouthWest() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) '\t');

    // Act and Assert
    assertEquals(BlockFace.SOUTH_WEST, rails.getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is three.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName(
      "Test getDirection(); given Rails(Material) with type is 'ACACIA_BOAT' Data is three; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRailsWithTypeIsAcaciaBoatDataIsThree_thenReturnWest() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.WEST, rails.getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails(Material)} with type is {@code ACACIA_BOAT} Data is two.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName(
      "Test getDirection(); given Rails(Material) with type is 'ACACIA_BOAT' Data is two; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRailsWithTypeIsAcaciaBoatDataIsTwo_thenReturnEast() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.EAST, rails.getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given Rails(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_givenRails_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Rails().getDirection());
  }

  /**
   * Test {@link Rails#getDirection()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); then return 'SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Rails.getDirection()"})
  void testGetDirection_thenReturnSouthEast() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) '\b');

    // Act and Assert
    assertEquals(BlockFace.SOUTH_EAST, rails.getDirection());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Given {@link DetectorRail#DetectorRail()}.
   *   <li>Then return {@code LEGACY_DETECTOR_RAIL(0) facing SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given DetectorRail(); then return 'LEGACY_DETECTOR_RAIL(0) facing SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_givenDetectorRail_thenReturnLegacyDetectorRail0FacingSouth() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_DETECTOR_RAIL(0) facing SOUTH", new DetectorRail().toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>Then return {@code LEGACY_RAILS(0) facing SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Rails(); then return 'LEGACY_RAILS(0) facing SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_givenRails_thenReturnLegacyRails0FacingSouth() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_RAILS(0) facing SOUTH", new Rails().toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(1) facing EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(1) facing EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat1FacingEast() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 1);

    // Act and Assert
    assertEquals("ACACIA_BOAT(1) facing EAST", rails.toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(2) facing EAST on a slope}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(2) facing EAST on a slope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat2FacingEastOnASlope() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 2);

    // Act and Assert
    assertEquals("ACACIA_BOAT(2) facing EAST on a slope", rails.toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(3) facing WEST on a slope}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(3) facing WEST on a slope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat3FacingWestOnASlope() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 3);

    // Act and Assert
    assertEquals("ACACIA_BOAT(3) facing WEST on a slope", rails.toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(4) facing NORTH on a slope}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(4) facing NORTH on a slope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat4FacingNorthOnASlope() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 4);

    // Act and Assert
    assertEquals("ACACIA_BOAT(4) facing NORTH on a slope", rails.toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(5) facing SOUTH on a slope}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(5) facing SOUTH on a slope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat5FacingSouthOnASlope() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 5);

    // Act and Assert
    assertEquals("ACACIA_BOAT(5) facing SOUTH on a slope", rails.toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(6) facing NORTH_WEST on a curve}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(6) facing NORTH_WEST on a curve'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat6FacingNorthWestOnACurve() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 6);

    // Act and Assert
    assertEquals("ACACIA_BOAT(6) facing NORTH_WEST on a curve", rails.toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(7) facing NORTH_EAST on a curve}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(7) facing NORTH_EAST on a curve'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat7FacingNorthEastOnACurve() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) 7);

    // Act and Assert
    assertEquals("ACACIA_BOAT(7) facing NORTH_EAST on a curve", rails.toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(8) facing SOUTH_EAST on a curve}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(8) facing SOUTH_EAST on a curve'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat8FacingSouthEastOnACurve() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) '\b');

    // Act and Assert
    assertEquals("ACACIA_BOAT(8) facing SOUTH_EAST on a curve", rails.toString());
  }

  /**
   * Test {@link Rails#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(9) facing SOUTH_WEST on a curve}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(9) facing SOUTH_WEST on a curve'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Rails.toString()"})
  void testToString_thenReturnAcaciaBoat9FacingSouthWestOnACurve() {
    // Arrange
    Rails rails = new Rails(Material.ACACIA_BOAT);
    rails.setData((byte) '\t');

    // Act and Assert
    assertEquals("ACACIA_BOAT(9) facing SOUTH_WEST on a curve", rails.toString());
  }

  /**
   * Test {@link Rails#getConvertedData()}.
   *
   * <ul>
   *   <li>Given {@link DetectorRail#DetectorRail()}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getConvertedData()}
   */
  @Test
  @DisplayName("Test getConvertedData(); given DetectorRail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Rails.getConvertedData()"})
  void testGetConvertedData_givenDetectorRail() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, new DetectorRail().getConvertedData());
  }

  /**
   * Test {@link Rails#getConvertedData()}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#getConvertedData()}
   */
  @Test
  @DisplayName("Test getConvertedData(); given Rails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Rails.getConvertedData()"})
  void testGetConvertedData_givenRails() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, new Rails().getConvertedData());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DetectorRail#DetectorRail()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link DetectorRail#DetectorRail()} ConvertedData is four.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given DetectorRail(); when 'NORTH'; then DetectorRail() ConvertedData is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenDetectorRail_whenNorth_thenDetectorRailConvertedDataIsFour() {
    // Arrange
    DetectorRail detectorRail = new DetectorRail();

    // Act
    detectorRail.setDirection(BlockFace.NORTH, true);

    // Assert
    assertEquals((byte) 4, detectorRail.getConvertedData());
    assertEquals((byte) 4, detectorRail.getData());
    assertEquals(BlockFace.NORTH, detectorRail.getDirection());
    assertTrue(detectorRail.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code EAST}.
   *   <li>Then {@link Rails#Rails()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'EAST'; then Rails() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenEast_thenRailsDataIsOne() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.EAST, false);

    // Assert
    assertEquals((byte) 1, rails.getData());
    assertEquals((byte) 1, rails.getConvertedData());
    assertEquals(BlockFace.EAST, rails.getDirection());
    assertFalse(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code EAST}.
   *   <li>Then {@link Rails#Rails()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'EAST'; then Rails() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenEast_thenRailsDataIsTwo() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.EAST, true);

    // Assert
    assertEquals((byte) 2, rails.getData());
    assertEquals((byte) 2, rails.getConvertedData());
    assertEquals(BlockFace.EAST, rails.getDirection());
    assertTrue(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then {@link Rails#Rails()} Data is seven.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'NORTH_EAST'; then Rails() Data is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenNorthEast_thenRailsDataIsSeven() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.NORTH_EAST, false);

    // Assert
    assertEquals((byte) 7, rails.getData());
    assertEquals((byte) 7, rails.getConvertedData());
    assertEquals(BlockFace.NORTH_EAST, rails.getDirection());
    assertTrue(rails.isCurve());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code NORTH_WEST}.
   *   <li>Then {@link Rails#Rails()} Data is six.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'NORTH_WEST'; then Rails() Data is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenNorthWest_thenRailsDataIsSix() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.NORTH_WEST, false);

    // Assert
    assertEquals((byte) 6, rails.getData());
    assertEquals((byte) 6, rails.getConvertedData());
    assertEquals(BlockFace.NORTH_WEST, rails.getDirection());
    assertTrue(rails.isCurve());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Rails#Rails()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'NORTH'; then Rails() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenNorth_thenRailsDataIsFour() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.NORTH, true);

    // Assert
    assertEquals((byte) 4, rails.getData());
    assertEquals((byte) 4, rails.getConvertedData());
    assertEquals(BlockFace.NORTH, rails.getDirection());
    assertTrue(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Rails#Rails()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'NORTH'; then Rails() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenNorth_thenRailsDataIsZero() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.NORTH, false);

    // Assert that nothing has changed
    assertEquals((byte) 0, rails.getData());
    assertEquals((byte) 0, rails.getConvertedData());
    assertEquals(BlockFace.SOUTH, rails.getDirection());
    assertFalse(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code SOUTH_EAST}.
   *   <li>Then {@link Rails#Rails()} Direction is {@code SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'SOUTH_EAST'; then Rails() Direction is 'SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenSouthEast_thenRailsDirectionIsSouthEast() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.SOUTH_EAST, false);

    // Assert
    assertEquals(BlockFace.SOUTH_EAST, rails.getDirection());
    assertTrue(rails.isCurve());
    assertEquals('\b', rails.getData());
    assertEquals('\b', rails.getConvertedData());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code SOUTH_WEST}.
   *   <li>Then {@link Rails#Rails()} Direction is {@code SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'SOUTH_WEST'; then Rails() Direction is 'SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenSouthWest_thenRailsDirectionIsSouthWest() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.SOUTH_WEST, false);

    // Assert
    assertEquals(BlockFace.SOUTH_WEST, rails.getDirection());
    assertTrue(rails.isCurve());
    assertEquals('\t', rails.getData());
    assertEquals('\t', rails.getConvertedData());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Rails#Rails()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'SOUTH'; then Rails() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenSouth_thenRailsDataIsFive() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.SOUTH, true);

    // Assert
    assertEquals((byte) 5, rails.getData());
    assertEquals((byte) 5, rails.getConvertedData());
    assertEquals(BlockFace.SOUTH, rails.getDirection());
    assertTrue(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Rails#Rails()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'SOUTH'; then Rails() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenSouth_thenRailsDataIsZero() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.SOUTH, false);

    // Assert that nothing has changed
    assertEquals((byte) 0, rails.getData());
    assertEquals((byte) 0, rails.getConvertedData());
    assertEquals(BlockFace.SOUTH, rails.getDirection());
    assertFalse(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code UP}.
   *   <li>Then {@link Rails#Rails()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'UP'; then Rails() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenUp_thenRailsDataIsZero() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.UP, true);

    // Assert that nothing has changed
    assertEquals((byte) 0, rails.getData());
    assertEquals((byte) 0, rails.getConvertedData());
    assertEquals(BlockFace.SOUTH, rails.getDirection());
    assertFalse(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code WEST}.
   *   <li>Then {@link Rails#Rails()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'WEST'; then Rails() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenWest_thenRailsDataIsOne() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 1, rails.getData());
    assertEquals((byte) 1, rails.getConvertedData());
    assertEquals(BlockFace.EAST, rails.getDirection());
    assertFalse(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Rails#Rails()}.
   *   <li>When {@code WEST}.
   *   <li>Then {@link Rails#Rails()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Rails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); given Rails(); when 'WEST'; then Rails() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rails.setDirection(BlockFace, boolean)"})
  void testSetDirection_givenRails_whenWest_thenRailsDataIsThree() {
    // Arrange
    Rails rails = new Rails();

    // Act
    rails.setDirection(BlockFace.WEST, true);

    // Assert
    assertEquals((byte) 3, rails.getData());
    assertEquals((byte) 3, rails.getConvertedData());
    assertEquals(BlockFace.WEST, rails.getDirection());
    assertTrue(rails.isOnSlope());
  }

  /**
   * Test {@link Rails#clone()}.
   *
   * <p>Method under test: {@link Rails#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rails Rails.clone()"})
  void testClone() {
    // Arrange
    Rails rails = new Rails();

    // Act
    Rails actualCloneResult = rails.clone();

    // Assert
    assertEquals(rails, actualCloneResult);
  }
}
