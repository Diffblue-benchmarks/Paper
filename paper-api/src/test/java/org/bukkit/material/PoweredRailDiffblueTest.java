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

class PoweredRailDiffblueTest {
  /**
   * Test {@link PoweredRail#PoweredRail()}.
   *
   * <p>Method under test: {@link PoweredRail#PoweredRail()}
   */
  @Test
  @DisplayName("Test new PoweredRail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PoweredRail.<init>()"})
  void testNewPoweredRail() {
    // Arrange and Act
    PoweredRail actualPoweredRail = new PoweredRail();

    // Assert
    assertEquals((byte) 0, actualPoweredRail.getConvertedData());
    assertEquals((byte) 0, actualPoweredRail.getData());
    assertEquals(Material.LEGACY_POWERED_RAIL, actualPoweredRail.getItemType());
    assertEquals(BlockFace.SOUTH, actualPoweredRail.getDirection());
    assertFalse(actualPoweredRail.isCurve());
    assertFalse(actualPoweredRail.isPowered());
    assertFalse(actualPoweredRail.isOnSlope());
  }

  /**
   * Test {@link PoweredRail#PoweredRail(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PoweredRail#PoweredRail(Material, byte)}
   */
  @Test
  @DisplayName("Test new PoweredRail(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PoweredRail.<init>(Material)",
    "void PoweredRail.<init>(Material, byte)"
  })
  void testNewPoweredRail_whenA_thenReturnDataIsA() {
    // Arrange and Act
    PoweredRail actualPoweredRail = new PoweredRail(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualPoweredRail.getItemType());
    assertEquals('A', actualPoweredRail.getData());
  }

  /**
   * Test {@link PoweredRail#PoweredRail(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PoweredRail#PoweredRail(Material)}
   */
  @Test
  @DisplayName("Test new PoweredRail(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PoweredRail.<init>(Material)",
    "void PoweredRail.<init>(Material, byte)"
  })
  void testNewPoweredRail_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    PoweredRail actualPoweredRail = new PoweredRail(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualPoweredRail.getData());
    assertEquals(Material.ACACIA_BOAT, actualPoweredRail.getItemType());
  }

  /**
   * Test {@link PoweredRail#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link PoweredRail#PoweredRail(Material, byte)} with type is {@code ACACIA_BOAT}
   *       and data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PoweredRail#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given PoweredRail(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PoweredRail.isPowered()"})
  void testIsPowered_givenPoweredRailWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PoweredRail(Material.ACACIA_BOAT, (byte) 'X').isPowered());
  }

  /**
   * Test {@link PoweredRail#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link PoweredRail#PoweredRail()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PoweredRail#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given PoweredRail(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PoweredRail.isPowered()"})
  void testIsPowered_givenPoweredRail_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PoweredRail().isPowered());
  }

  /**
   * Test {@link PoweredRail#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PoweredRail#PoweredRail()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link PoweredRail#setPowered(boolean)}
   */
  @Test
  @DisplayName("Test setPowered(boolean); when 'false'; then PoweredRail() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PoweredRail.setPowered(boolean)"})
  void testSetPowered_whenFalse_thenPoweredRailDataIsZero() {
    // Arrange
    PoweredRail poweredRail = new PoweredRail();

    // Act
    poweredRail.setPowered(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, poweredRail.getData());
    assertFalse(poweredRail.isPowered());
  }

  /**
   * Test {@link PoweredRail#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PoweredRail#PoweredRail()} Powered.
   * </ul>
   *
   * <p>Method under test: {@link PoweredRail#setPowered(boolean)}
   */
  @Test
  @DisplayName("Test setPowered(boolean); when 'true'; then PoweredRail() Powered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PoweredRail.setPowered(boolean)"})
  void testSetPowered_whenTrue_thenPoweredRailPowered() {
    // Arrange
    PoweredRail poweredRail = new PoweredRail();

    // Act
    poweredRail.setPowered(true);

    // Assert
    assertTrue(poweredRail.isPowered());
    assertEquals('\b', poweredRail.getData());
  }

  /**
   * Test {@link PoweredRail#clone()}.
   *
   * <p>Method under test: {@link PoweredRail#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PoweredRail PoweredRail.clone()"})
  void testClone() {
    // Arrange
    PoweredRail poweredRail = new PoweredRail();

    // Act
    PoweredRail actualCloneResult = poweredRail.clone();

    // Assert
    assertEquals(poweredRail, actualCloneResult);
  }
}
