package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChestDiffblueTest {
  /**
   * Test {@link Chest#Chest()}.
   *
   * <p>Method under test: {@link Chest#Chest()}
   */
  @Test
  @DisplayName("Test new Chest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chest.<init>()"})
  void testNewChest() {
    // Arrange and Act
    Chest actualChest = new Chest();

    // Assert
    assertEquals((byte) 0, actualChest.getData());
    assertEquals(Material.LEGACY_CHEST, actualChest.getItemType());
    assertEquals(BlockFace.EAST, actualChest.getFacing());
  }

  /**
   * Test {@link Chest#Chest(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Chest#Chest(Material, byte)}
   */
  @Test
  @DisplayName("Test new Chest(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chest.<init>(Material)", "void Chest.<init>(Material, byte)"})
  void testNewChest_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Chest actualChest = new Chest(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualChest.getItemType());
    assertEquals('A', actualChest.getData());
  }

  /**
   * Test {@link Chest#Chest(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Chest#Chest(Material)}
   */
  @Test
  @DisplayName("Test new Chest(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chest.<init>(Material)", "void Chest.<init>(Material, byte)"})
  void testNewChest_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Chest actualChest = new Chest(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualChest.getData());
    assertEquals(Material.ACACIA_BOAT, actualChest.getItemType());
  }

  /**
   * Test {@link Chest#Chest(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Chest#Chest(BlockFace)}
   */
  @Test
  @DisplayName("Test new Chest(BlockFace); when 'EAST'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chest.<init>(BlockFace)"})
  void testNewChest_whenEast_thenReturnDataIsFive() {
    // Arrange and Act
    Chest actualChest = new Chest(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, actualChest.getData());
    assertEquals(Material.LEGACY_CHEST, actualChest.getItemType());
    assertEquals(BlockFace.EAST, actualChest.getFacing());
  }

  /**
   * Test {@link Chest#Chest(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Chest#Chest(BlockFace)}
   */
  @Test
  @DisplayName("Test new Chest(BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chest.<init>(BlockFace)"})
  void testNewChest_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    Chest actualChest = new Chest(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualChest.getData());
    assertEquals(Material.LEGACY_CHEST, actualChest.getItemType());
    assertEquals(BlockFace.NORTH, actualChest.getFacing());
  }

  /**
   * Test {@link Chest#Chest(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Chest#Chest(BlockFace)}
   */
  @Test
  @DisplayName("Test new Chest(BlockFace); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chest.<init>(BlockFace)"})
  void testNewChest_whenSouth_thenReturnDataIsThree() {
    // Arrange and Act
    Chest actualChest = new Chest(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, actualChest.getData());
    assertEquals(Material.LEGACY_CHEST, actualChest.getItemType());
    assertEquals(BlockFace.SOUTH, actualChest.getFacing());
  }

  /**
   * Test {@link Chest#Chest(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Chest#Chest(BlockFace)}
   */
  @Test
  @DisplayName("Test new Chest(BlockFace); when 'WEST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chest.<init>(BlockFace)"})
  void testNewChest_whenWest_thenReturnDataIsFour() {
    // Arrange and Act
    Chest actualChest = new Chest(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, actualChest.getData());
    assertEquals(Material.LEGACY_CHEST, actualChest.getItemType());
    assertEquals(BlockFace.WEST, actualChest.getFacing());
  }

  /**
   * Test {@link Chest#clone()}.
   *
   * <p>Method under test: {@link Chest#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chest Chest.clone()"})
  void testClone() {
    // Arrange
    Chest chest = new Chest();

    // Act
    Chest actualCloneResult = chest.clone();

    // Assert
    assertEquals(chest, actualCloneResult);
  }
}
