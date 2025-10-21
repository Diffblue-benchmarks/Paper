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

class DetectorRailDiffblueTest {
  /**
   * Test {@link DetectorRail#DetectorRail()}.
   *
   * <p>Method under test: {@link DetectorRail#DetectorRail()}
   */
  @Test
  @DisplayName("Test new DetectorRail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DetectorRail.<init>()"})
  void testNewDetectorRail() {
    // Arrange and Act
    DetectorRail actualDetectorRail = new DetectorRail();

    // Assert
    assertEquals((byte) 0, actualDetectorRail.getConvertedData());
    assertEquals((byte) 0, actualDetectorRail.getData());
    assertEquals(Material.LEGACY_DETECTOR_RAIL, actualDetectorRail.getItemType());
    assertEquals(BlockFace.SOUTH, actualDetectorRail.getDirection());
    assertFalse(actualDetectorRail.isPressed());
    assertFalse(actualDetectorRail.isCurve());
    assertFalse(actualDetectorRail.isOnSlope());
  }

  /**
   * Test {@link DetectorRail#DetectorRail(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link DetectorRail#DetectorRail(Material, byte)}
   */
  @Test
  @DisplayName("Test new DetectorRail(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DetectorRail.<init>(Material)",
    "void DetectorRail.<init>(Material, byte)"
  })
  void testNewDetectorRail_whenA_thenReturnDataIsA() {
    // Arrange and Act
    DetectorRail actualDetectorRail = new DetectorRail(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualDetectorRail.getItemType());
    assertEquals('A', actualDetectorRail.getData());
  }

  /**
   * Test {@link DetectorRail#DetectorRail(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link DetectorRail#DetectorRail(Material)}
   */
  @Test
  @DisplayName("Test new DetectorRail(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DetectorRail.<init>(Material)",
    "void DetectorRail.<init>(Material, byte)"
  })
  void testNewDetectorRail_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    DetectorRail actualDetectorRail = new DetectorRail(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualDetectorRail.getData());
    assertEquals(Material.ACACIA_BOAT, actualDetectorRail.getItemType());
  }

  /**
   * Test {@link DetectorRail#isPressed()}.
   *
   * <ul>
   *   <li>Given {@link DetectorRail#DetectorRail(Material, byte)} with type is {@code ACACIA_BOAT}
   *       and data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DetectorRail#isPressed()}
   */
  @Test
  @DisplayName(
      "Test isPressed(); given DetectorRail(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DetectorRail.isPressed()"})
  void testIsPressed_givenDetectorRailWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new DetectorRail(Material.ACACIA_BOAT, (byte) 'X').isPressed());
  }

  /**
   * Test {@link DetectorRail#isPressed()}.
   *
   * <ul>
   *   <li>Given {@link DetectorRail#DetectorRail()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DetectorRail#isPressed()}
   */
  @Test
  @DisplayName("Test isPressed(); given DetectorRail(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DetectorRail.isPressed()"})
  void testIsPressed_givenDetectorRail_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DetectorRail().isPressed());
  }

  /**
   * Test {@link DetectorRail#setPressed(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link DetectorRail#DetectorRail()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link DetectorRail#setPressed(boolean)}
   */
  @Test
  @DisplayName("Test setPressed(boolean); when 'false'; then DetectorRail() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DetectorRail.setPressed(boolean)"})
  void testSetPressed_whenFalse_thenDetectorRailDataIsZero() {
    // Arrange
    DetectorRail detectorRail = new DetectorRail();

    // Act
    detectorRail.setPressed(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, detectorRail.getData());
    assertFalse(detectorRail.isPressed());
  }

  /**
   * Test {@link DetectorRail#setPressed(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link DetectorRail#DetectorRail()} Pressed.
   * </ul>
   *
   * <p>Method under test: {@link DetectorRail#setPressed(boolean)}
   */
  @Test
  @DisplayName("Test setPressed(boolean); when 'true'; then DetectorRail() Pressed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DetectorRail.setPressed(boolean)"})
  void testSetPressed_whenTrue_thenDetectorRailPressed() {
    // Arrange
    DetectorRail detectorRail = new DetectorRail();

    // Act
    detectorRail.setPressed(true);

    // Assert
    assertTrue(detectorRail.isPressed());
    assertEquals('\b', detectorRail.getData());
  }

  /**
   * Test {@link DetectorRail#clone()}.
   *
   * <p>Method under test: {@link DetectorRail#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DetectorRail DetectorRail.clone()"})
  void testClone() {
    // Arrange
    DetectorRail detectorRail = new DetectorRail();

    // Act
    DetectorRail actualCloneResult = detectorRail.clone();

    // Assert
    assertEquals(detectorRail, actualCloneResult);
  }
}
