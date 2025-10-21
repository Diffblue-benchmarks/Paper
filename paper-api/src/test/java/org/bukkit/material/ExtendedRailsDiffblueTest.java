package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExtendedRailsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtendedRails#ExtendedRails(Material, byte)}
   *   <li>{@link ExtendedRails#isCurve()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExtendedRails.<init>(Material)",
    "void ExtendedRails.<init>(Material, byte)",
    "boolean ExtendedRails.isCurve()"
  })
  void testGettersAndSetters_whenA_thenReturnDataIsA() {
    // Arrange and Act
    ExtendedRails actualExtendedRails = new ExtendedRails(Material.ACACIA_BOAT, (byte) 'A');
    boolean actualIsCurveResult = actualExtendedRails.isCurve();

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualExtendedRails.getItemType());
    assertFalse(actualIsCurveResult);
    assertEquals('A', actualExtendedRails.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtendedRails#ExtendedRails(Material)}
   *   <li>{@link ExtendedRails#isCurve()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExtendedRails.<init>(Material)",
    "void ExtendedRails.<init>(Material, byte)",
    "boolean ExtendedRails.isCurve()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    ExtendedRails actualExtendedRails = new ExtendedRails(Material.ACACIA_BOAT);
    boolean actualIsCurveResult = actualExtendedRails.isCurve();

    // Assert
    assertEquals((byte) 0, actualExtendedRails.getData());
    assertEquals(Material.ACACIA_BOAT, actualExtendedRails.getItemType());
    assertFalse(actualIsCurveResult);
  }

  /**
   * Test {@link ExtendedRails#getConvertedData()}.
   *
   * <p>Method under test: {@link ExtendedRails#getConvertedData()}
   */
  @Test
  @DisplayName("Test getConvertedData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte ExtendedRails.getConvertedData()"})
  void testGetConvertedData() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, new ExtendedRails(Material.ACACIA_BOAT).getConvertedData());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setDirection(BlockFace, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection() {
    // Arrange
    DetectorRail detectorRail = new DetectorRail(Material.ACACIA_BOAT, (byte) 'X');

    // Act
    detectorRail.setDirection(BlockFace.NORTH, true);

    // Assert
    assertEquals((byte) 4, detectorRail.getConvertedData());
    assertEquals(BlockFace.NORTH, detectorRail.getDirection());
    assertTrue(detectorRail.isOnSlope());
    assertEquals('\f', detectorRail.getData());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link ExtendedRails#ExtendedRails(Material)} with type is {@code ACACIA_BOAT}
   *       ConvertedData is five.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); then ExtendedRails(Material) with type is 'ACACIA_BOAT' ConvertedData is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_thenExtendedRailsWithTypeIsAcaciaBoatConvertedDataIsFive() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    extendedRails.setDirection(BlockFace.SOUTH, true);

    // Assert
    assertEquals((byte) 5, extendedRails.getConvertedData());
    assertEquals((byte) 5, extendedRails.getData());
    assertEquals(BlockFace.SOUTH, extendedRails.getDirection());
    assertTrue(extendedRails.isOnSlope());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link ExtendedRails#ExtendedRails(Material)} with type is {@code ACACIA_BOAT}
   *       ConvertedData is four.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); then ExtendedRails(Material) with type is 'ACACIA_BOAT' ConvertedData is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_thenExtendedRailsWithTypeIsAcaciaBoatConvertedDataIsFour() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    extendedRails.setDirection(BlockFace.NORTH, true);

    // Assert
    assertEquals((byte) 4, extendedRails.getConvertedData());
    assertEquals((byte) 4, extendedRails.getData());
    assertEquals(BlockFace.NORTH, extendedRails.getDirection());
    assertTrue(extendedRails.isOnSlope());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link ExtendedRails#ExtendedRails(Material)} with type is {@code ACACIA_BOAT}
   *       ConvertedData is one.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); then ExtendedRails(Material) with type is 'ACACIA_BOAT' ConvertedData is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_thenExtendedRailsWithTypeIsAcaciaBoatConvertedDataIsOne() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    extendedRails.setDirection(BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 1, extendedRails.getConvertedData());
    assertEquals((byte) 1, extendedRails.getData());
    assertEquals(BlockFace.EAST, extendedRails.getDirection());
    assertFalse(extendedRails.isOnSlope());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link ExtendedRails#ExtendedRails(Material)} with type is {@code ACACIA_BOAT}
   *       ConvertedData is three.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); then ExtendedRails(Material) with type is 'ACACIA_BOAT' ConvertedData is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_thenExtendedRailsWithTypeIsAcaciaBoatConvertedDataIsThree() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    extendedRails.setDirection(BlockFace.WEST, true);

    // Assert
    assertEquals((byte) 3, extendedRails.getConvertedData());
    assertEquals((byte) 3, extendedRails.getData());
    assertEquals(BlockFace.WEST, extendedRails.getDirection());
    assertTrue(extendedRails.isOnSlope());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link ExtendedRails#ExtendedRails(Material)} with type is {@code ACACIA_BOAT}
   *       ConvertedData is two.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); then ExtendedRails(Material) with type is 'ACACIA_BOAT' ConvertedData is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_thenExtendedRailsWithTypeIsAcaciaBoatConvertedDataIsTwo() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    extendedRails.setDirection(BlockFace.EAST, true);

    // Assert
    assertEquals((byte) 2, extendedRails.getConvertedData());
    assertEquals((byte) 2, extendedRails.getData());
    assertEquals(BlockFace.EAST, extendedRails.getDirection());
    assertTrue(extendedRails.isOnSlope());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link ExtendedRails#ExtendedRails(Material)} with type is {@code ACACIA_BOAT}
   *       ConvertedData is zero.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); then ExtendedRails(Material) with type is 'ACACIA_BOAT' ConvertedData is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_thenExtendedRailsWithTypeIsAcaciaBoatConvertedDataIsZero() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    extendedRails.setDirection(BlockFace.SOUTH, false);

    // Assert that nothing has changed
    assertEquals((byte) 0, extendedRails.getConvertedData());
    assertEquals((byte) 0, extendedRails.getData());
    assertEquals(BlockFace.SOUTH, extendedRails.getDirection());
    assertFalse(extendedRails.isOnSlope());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@link BlockFace#EAST}.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setDirection(BlockFace, boolean); when EAST")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_whenEast() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    extendedRails.setDirection(BlockFace.EAST, false);

    // Assert
    assertEquals((byte) 1, extendedRails.getConvertedData());
    assertEquals((byte) 1, extendedRails.getData());
    assertEquals(BlockFace.EAST, extendedRails.getDirection());
    assertFalse(extendedRails.isOnSlope());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@link BlockFace#NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setDirection(BlockFace, boolean); when NORTH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_whenNorth() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    extendedRails.setDirection(BlockFace.NORTH, false);

    // Assert that nothing has changed
    assertEquals((byte) 0, extendedRails.getConvertedData());
    assertEquals((byte) 0, extendedRails.getData());
    assertEquals(BlockFace.SOUTH, extendedRails.getDirection());
    assertFalse(extendedRails.isOnSlope());
  }

  /**
   * Test {@link ExtendedRails#setDirection(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code NORTH_WEST}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ExtendedRails#setDirection(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setDirection(BlockFace, boolean); when 'NORTH_WEST'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtendedRails.setDirection(BlockFace, boolean)"})
  void testSetDirection_whenNorthWest_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ExtendedRails(Material.ACACIA_BOAT).setDirection(BlockFace.NORTH_WEST, false));
  }

  /**
   * Test {@link ExtendedRails#clone()}.
   *
   * <p>Method under test: {@link ExtendedRails#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtendedRails ExtendedRails.clone()"})
  void testClone() {
    // Arrange
    ExtendedRails extendedRails = new ExtendedRails(Material.ACACIA_BOAT);

    // Act
    ExtendedRails actualCloneResult = extendedRails.clone();

    // Assert
    assertEquals(extendedRails, actualCloneResult);
  }
}
