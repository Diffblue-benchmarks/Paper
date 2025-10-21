package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FurnaceDiffblueTest {
  /**
   * Test {@link Furnace#Furnace()}.
   *
   * <p>Method under test: {@link Furnace#Furnace()}
   */
  @Test
  @DisplayName("Test new Furnace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Furnace.<init>()"})
  void testNewFurnace() {
    // Arrange and Act
    Furnace actualFurnace = new Furnace();

    // Assert
    assertEquals((byte) 0, actualFurnace.getData());
    assertEquals(Material.LEGACY_FURNACE, actualFurnace.getItemType());
    assertEquals(BlockFace.EAST, actualFurnace.getFacing());
  }

  /**
   * Test {@link Furnace#Furnace(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Furnace#Furnace(Material, byte)}
   */
  @Test
  @DisplayName("Test new Furnace(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Furnace.<init>(Material)", "void Furnace.<init>(Material, byte)"})
  void testNewFurnace_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Furnace actualFurnace = new Furnace(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualFurnace.getItemType());
    assertEquals('A', actualFurnace.getData());
  }

  /**
   * Test {@link Furnace#Furnace(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Furnace#Furnace(Material)}
   */
  @Test
  @DisplayName("Test new Furnace(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Furnace.<init>(Material)", "void Furnace.<init>(Material, byte)"})
  void testNewFurnace_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Furnace actualFurnace = new Furnace(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualFurnace.getData());
    assertEquals(Material.ACACIA_BOAT, actualFurnace.getItemType());
  }

  /**
   * Test {@link Furnace#Furnace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Furnace#Furnace(BlockFace)}
   */
  @Test
  @DisplayName("Test new Furnace(BlockFace); when 'EAST'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Furnace.<init>(BlockFace)"})
  void testNewFurnace_whenEast_thenReturnDataIsFive() {
    // Arrange and Act
    Furnace actualFurnace = new Furnace(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, actualFurnace.getData());
    assertEquals(Material.LEGACY_FURNACE, actualFurnace.getItemType());
    assertEquals(BlockFace.EAST, actualFurnace.getFacing());
  }

  /**
   * Test {@link Furnace#Furnace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Furnace#Furnace(BlockFace)}
   */
  @Test
  @DisplayName("Test new Furnace(BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Furnace.<init>(BlockFace)"})
  void testNewFurnace_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    Furnace actualFurnace = new Furnace(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualFurnace.getData());
    assertEquals(Material.LEGACY_FURNACE, actualFurnace.getItemType());
    assertEquals(BlockFace.NORTH, actualFurnace.getFacing());
  }

  /**
   * Test {@link Furnace#Furnace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Furnace#Furnace(BlockFace)}
   */
  @Test
  @DisplayName("Test new Furnace(BlockFace); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Furnace.<init>(BlockFace)"})
  void testNewFurnace_whenSouth_thenReturnDataIsThree() {
    // Arrange and Act
    Furnace actualFurnace = new Furnace(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, actualFurnace.getData());
    assertEquals(Material.LEGACY_FURNACE, actualFurnace.getItemType());
    assertEquals(BlockFace.SOUTH, actualFurnace.getFacing());
  }

  /**
   * Test {@link Furnace#Furnace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Furnace#Furnace(BlockFace)}
   */
  @Test
  @DisplayName("Test new Furnace(BlockFace); when 'WEST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Furnace.<init>(BlockFace)"})
  void testNewFurnace_whenWest_thenReturnDataIsFour() {
    // Arrange and Act
    Furnace actualFurnace = new Furnace(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, actualFurnace.getData());
    assertEquals(Material.LEGACY_FURNACE, actualFurnace.getItemType());
    assertEquals(BlockFace.WEST, actualFurnace.getFacing());
  }

  /**
   * Test {@link Furnace#clone()}.
   *
   * <p>Method under test: {@link Furnace#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Furnace Furnace.clone()"})
  void testClone() {
    // Arrange
    Furnace furnace = new Furnace();

    // Act
    Furnace actualCloneResult = furnace.clone();

    // Assert
    assertEquals(furnace, actualCloneResult);
  }
}
