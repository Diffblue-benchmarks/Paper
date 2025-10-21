package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnderChestDiffblueTest {
  /**
   * Test {@link EnderChest#EnderChest()}.
   *
   * <p>Method under test: {@link EnderChest#EnderChest()}
   */
  @Test
  @DisplayName("Test new EnderChest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EnderChest.<init>()"})
  void testNewEnderChest() {
    // Arrange and Act
    EnderChest actualEnderChest = new EnderChest();

    // Assert
    assertEquals((byte) 0, actualEnderChest.getData());
    assertEquals(Material.LEGACY_ENDER_CHEST, actualEnderChest.getItemType());
    assertEquals(BlockFace.EAST, actualEnderChest.getFacing());
  }

  /**
   * Test {@link EnderChest#EnderChest(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link EnderChest#EnderChest(Material, byte)}
   */
  @Test
  @DisplayName("Test new EnderChest(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EnderChest.<init>(Material)", "void EnderChest.<init>(Material, byte)"})
  void testNewEnderChest_whenA_thenReturnDataIsA() {
    // Arrange and Act
    EnderChest actualEnderChest = new EnderChest(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualEnderChest.getItemType());
    assertEquals('A', actualEnderChest.getData());
  }

  /**
   * Test {@link EnderChest#EnderChest(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link EnderChest#EnderChest(Material)}
   */
  @Test
  @DisplayName("Test new EnderChest(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EnderChest.<init>(Material)", "void EnderChest.<init>(Material, byte)"})
  void testNewEnderChest_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    EnderChest actualEnderChest = new EnderChest(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualEnderChest.getData());
    assertEquals(Material.ACACIA_BOAT, actualEnderChest.getItemType());
  }

  /**
   * Test {@link EnderChest#EnderChest(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link EnderChest#EnderChest(BlockFace)}
   */
  @Test
  @DisplayName("Test new EnderChest(BlockFace); when 'EAST'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EnderChest.<init>(BlockFace)"})
  void testNewEnderChest_whenEast_thenReturnDataIsFive() {
    // Arrange and Act
    EnderChest actualEnderChest = new EnderChest(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, actualEnderChest.getData());
    assertEquals(Material.LEGACY_ENDER_CHEST, actualEnderChest.getItemType());
    assertEquals(BlockFace.EAST, actualEnderChest.getFacing());
  }

  /**
   * Test {@link EnderChest#EnderChest(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link EnderChest#EnderChest(BlockFace)}
   */
  @Test
  @DisplayName("Test new EnderChest(BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EnderChest.<init>(BlockFace)"})
  void testNewEnderChest_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    EnderChest actualEnderChest = new EnderChest(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualEnderChest.getData());
    assertEquals(Material.LEGACY_ENDER_CHEST, actualEnderChest.getItemType());
    assertEquals(BlockFace.NORTH, actualEnderChest.getFacing());
  }

  /**
   * Test {@link EnderChest#EnderChest(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link EnderChest#EnderChest(BlockFace)}
   */
  @Test
  @DisplayName("Test new EnderChest(BlockFace); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EnderChest.<init>(BlockFace)"})
  void testNewEnderChest_whenSouth_thenReturnDataIsThree() {
    // Arrange and Act
    EnderChest actualEnderChest = new EnderChest(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, actualEnderChest.getData());
    assertEquals(Material.LEGACY_ENDER_CHEST, actualEnderChest.getItemType());
    assertEquals(BlockFace.SOUTH, actualEnderChest.getFacing());
  }

  /**
   * Test {@link EnderChest#EnderChest(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link EnderChest#EnderChest(BlockFace)}
   */
  @Test
  @DisplayName("Test new EnderChest(BlockFace); when 'WEST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EnderChest.<init>(BlockFace)"})
  void testNewEnderChest_whenWest_thenReturnDataIsFour() {
    // Arrange and Act
    EnderChest actualEnderChest = new EnderChest(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, actualEnderChest.getData());
    assertEquals(Material.LEGACY_ENDER_CHEST, actualEnderChest.getItemType());
    assertEquals(BlockFace.WEST, actualEnderChest.getFacing());
  }

  /**
   * Test {@link EnderChest#clone()}.
   *
   * <p>Method under test: {@link EnderChest#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EnderChest EnderChest.clone()"})
  void testClone() {
    // Arrange
    EnderChest enderChest = new EnderChest();

    // Act
    EnderChest actualCloneResult = enderChest.clone();

    // Assert
    assertEquals(enderChest, actualCloneResult);
  }
}
