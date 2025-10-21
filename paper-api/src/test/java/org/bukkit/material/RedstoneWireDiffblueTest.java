package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RedstoneWireDiffblueTest {
  /**
   * Test {@link RedstoneWire#RedstoneWire()}.
   *
   * <p>Method under test: {@link RedstoneWire#RedstoneWire()}
   */
  @Test
  @DisplayName("Test new RedstoneWire()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RedstoneWire.<init>()"})
  void testNewRedstoneWire() {
    // Arrange and Act
    RedstoneWire actualRedstoneWire = new RedstoneWire();

    // Assert
    assertEquals((byte) 0, actualRedstoneWire.getData());
    assertEquals(Material.LEGACY_REDSTONE_WIRE, actualRedstoneWire.getItemType());
    assertFalse(actualRedstoneWire.isPowered());
  }

  /**
   * Test {@link RedstoneWire#RedstoneWire(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneWire#RedstoneWire(Material, byte)}
   */
  @Test
  @DisplayName("Test new RedstoneWire(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RedstoneWire.<init>(Material)",
    "void RedstoneWire.<init>(Material, byte)"
  })
  void testNewRedstoneWire_whenA_thenReturnDataIsA() {
    // Arrange and Act
    RedstoneWire actualRedstoneWire = new RedstoneWire(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualRedstoneWire.getItemType());
    assertEquals('A', actualRedstoneWire.getData());
  }

  /**
   * Test {@link RedstoneWire#RedstoneWire(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneWire#RedstoneWire(Material)}
   */
  @Test
  @DisplayName("Test new RedstoneWire(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RedstoneWire.<init>(Material)",
    "void RedstoneWire.<init>(Material, byte)"
  })
  void testNewRedstoneWire_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    RedstoneWire actualRedstoneWire = new RedstoneWire(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualRedstoneWire.getData());
    assertEquals(Material.ACACIA_BOAT, actualRedstoneWire.getItemType());
  }

  /**
   * Test {@link RedstoneWire#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link RedstoneWire#RedstoneWire(Material)} with type is {@code ACACIA_BOAT} Data
   *       is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneWire#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given RedstoneWire(Material) with type is 'ACACIA_BOAT' Data is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RedstoneWire.isPowered()"})
  void testIsPowered_givenRedstoneWireWithTypeIsAcaciaBoatDataIsOne_thenReturnTrue() {
    // Arrange
    RedstoneWire redstoneWire = new RedstoneWire(Material.ACACIA_BOAT);
    redstoneWire.setData((byte) 1);

    // Act and Assert
    assertTrue(redstoneWire.isPowered());
  }

  /**
   * Test {@link RedstoneWire#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link RedstoneWire#RedstoneWire()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneWire#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given RedstoneWire(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RedstoneWire.isPowered()"})
  void testIsPowered_givenRedstoneWire_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RedstoneWire().isPowered());
  }

  /**
   * Test {@link RedstoneWire#toString()}.
   *
   * <ul>
   *   <li>Given {@link RedstoneWire#RedstoneWire()}.
   *   <li>Then return {@code LEGACY_REDSTONE_WIRE(0) NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneWire#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given RedstoneWire(); then return 'LEGACY_REDSTONE_WIRE(0) NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RedstoneWire.toString()"})
  void testToString_givenRedstoneWire_thenReturnLegacyRedstoneWire0NotPowered() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_REDSTONE_WIRE(0) NOT POWERED", new RedstoneWire().toString());
  }

  /**
   * Test {@link RedstoneWire#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(1) POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneWire#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(1) POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RedstoneWire.toString()"})
  void testToString_thenReturnAcaciaBoat1Powered() {
    // Arrange
    RedstoneWire redstoneWire = new RedstoneWire(Material.ACACIA_BOAT);
    redstoneWire.setData((byte) 1);

    // Act and Assert
    assertEquals("ACACIA_BOAT(1) POWERED", redstoneWire.toString());
  }

  /**
   * Test {@link RedstoneWire#clone()}.
   *
   * <p>Method under test: {@link RedstoneWire#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RedstoneWire RedstoneWire.clone()"})
  void testClone() {
    // Arrange
    RedstoneWire redstoneWire = new RedstoneWire();

    // Act
    RedstoneWire actualCloneResult = redstoneWire.clone();

    // Assert
    assertEquals(redstoneWire, actualCloneResult);
  }
}
