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

class ComparatorDiffblueTest {
  /**
   * Test {@link Comparator#Comparator()}.
   *
   * <p>Method under test: {@link Comparator#Comparator()}
   */
  @Test
  @DisplayName("Test new Comparator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>()"})
  void testNewComparator() {
    // Arrange and Act
    Comparator actualComparator = new Comparator();

    // Assert
    assertEquals((byte) 0, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.NORTH, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(Material, byte)}
   */
  @Test
  @DisplayName("Test new Comparator(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(Material)", "void Comparator.<init>(Material, byte)"})
  void testNewComparator_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualComparator.getItemType());
    assertEquals('A', actualComparator.getData());
  }

  /**
   * Test {@link Comparator#Comparator(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(Material)}
   */
  @Test
  @DisplayName("Test new Comparator(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(Material)", "void Comparator.<init>(Material, byte)"})
  void testNewComparator_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualComparator.getData());
    assertEquals(Material.ACACIA_BOAT, actualComparator.getItemType());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace)}
   */
  @Test
  @DisplayName("Test new Comparator(BlockFace); when 'EAST'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace)"})
  void testNewComparator_whenEast_thenReturnDataIsOne() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.EAST);

    // Assert
    assertEquals((byte) 1, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.EAST, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Comparator(BlockFace, boolean); when 'EAST'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace, boolean)"})
  void testNewComparator_whenEast_thenReturnDataIsOne2() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.EAST, false);

    // Assert
    assertEquals((byte) 1, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.EAST, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Comparator(BlockFace, boolean, boolean); when 'EAST'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace, boolean, boolean)"})
  void testNewComparator_whenEast_thenReturnDataIsOne3() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.EAST, false, false);

    // Assert
    assertEquals((byte) 1, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.EAST, actualComparator.getFacing());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Comparator(BlockFace, boolean); when 'NORTH'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace, boolean)"})
  void testNewComparator_whenNorth_thenReturnDataIsFour() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.NORTH, true);

    // Assert
    assertEquals((byte) 4, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.NORTH, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertTrue(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Comparator(BlockFace, boolean, boolean); when 'NORTH'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace, boolean, boolean)"})
  void testNewComparator_whenNorth_thenReturnDataIsFour2() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.NORTH, true, true);

    // Assert
    assertEquals((byte) 4, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_ON, actualComparator.getItemType());
    assertEquals(BlockFace.NORTH, actualComparator.getFacing());
    assertTrue(actualComparator.isPowered());
    assertTrue(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace)}
   */
  @Test
  @DisplayName("Test new Comparator(BlockFace); when 'NORTH'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace)"})
  void testNewComparator_whenNorth_thenReturnDataIsZero() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 0, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.NORTH, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace)}
   */
  @Test
  @DisplayName("Test new Comparator(BlockFace); when 'SOUTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace)"})
  void testNewComparator_whenSouth_thenReturnDataIsTwo() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 2, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.SOUTH, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Comparator(BlockFace, boolean); when 'SOUTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace, boolean)"})
  void testNewComparator_whenSouth_thenReturnDataIsTwo2() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.SOUTH, false);

    // Assert
    assertEquals((byte) 2, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.SOUTH, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Comparator(BlockFace, boolean, boolean); when 'SOUTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace, boolean, boolean)"})
  void testNewComparator_whenSouth_thenReturnDataIsTwo3() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.SOUTH, false, false);

    // Assert
    assertEquals((byte) 2, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.SOUTH, actualComparator.getFacing());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace)}
   */
  @Test
  @DisplayName("Test new Comparator(BlockFace); when 'WEST'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace)"})
  void testNewComparator_whenWest_thenReturnDataIsThree() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.WEST);

    // Assert
    assertEquals((byte) 3, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.WEST, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Comparator(BlockFace, boolean); when 'WEST'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace, boolean)"})
  void testNewComparator_whenWest_thenReturnDataIsThree2() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 3, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.WEST, actualComparator.getFacing());
    assertFalse(actualComparator.isBeingPowered());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#Comparator(BlockFace, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#Comparator(BlockFace, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Comparator(BlockFace, boolean, boolean); when 'WEST'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.<init>(BlockFace, boolean, boolean)"})
  void testNewComparator_whenWest_thenReturnDataIsThree3() {
    // Arrange and Act
    Comparator actualComparator = new Comparator(BlockFace.WEST, false, false);

    // Assert
    assertEquals((byte) 3, actualComparator.getData());
    assertEquals(Material.LEGACY_REDSTONE_COMPARATOR_OFF, actualComparator.getItemType());
    assertEquals(BlockFace.WEST, actualComparator.getFacing());
    assertFalse(actualComparator.isPowered());
    assertFalse(actualComparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#setSubtractionMode(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Comparator#Comparator()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#setSubtractionMode(boolean)}
   */
  @Test
  @DisplayName("Test setSubtractionMode(boolean); when 'false'; then Comparator() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.setSubtractionMode(boolean)"})
  void testSetSubtractionMode_whenFalse_thenComparatorDataIsZero() {
    // Arrange
    Comparator comparator = new Comparator();

    // Act
    comparator.setSubtractionMode(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, comparator.getData());
    assertFalse(comparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#setSubtractionMode(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Comparator#Comparator()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#setSubtractionMode(boolean)}
   */
  @Test
  @DisplayName("Test setSubtractionMode(boolean); when 'true'; then Comparator() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.setSubtractionMode(boolean)"})
  void testSetSubtractionMode_whenTrue_thenComparatorDataIsFour() {
    // Arrange
    Comparator comparator = new Comparator();

    // Act
    comparator.setSubtractionMode(true);

    // Assert
    assertEquals((byte) 4, comparator.getData());
    assertTrue(comparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#isSubtractionMode()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()} Data is minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#isSubtractionMode()}
   */
  @Test
  @DisplayName("Test isSubtractionMode(); given Comparator() Data is minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Comparator.isSubtractionMode()"})
  void testIsSubtractionMode_givenComparatorDataIsMinusOne_thenReturnTrue() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) -1);

    // Act and Assert
    assertTrue(comparator.isSubtractionMode());
  }

  /**
   * Test {@link Comparator#isSubtractionMode()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#isSubtractionMode()}
   */
  @Test
  @DisplayName("Test isSubtractionMode(); given Comparator(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Comparator.isSubtractionMode()"})
  void testIsSubtractionMode_givenComparator_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Comparator().isSubtractionMode());
  }

  /**
   * Test {@link Comparator#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Comparator#Comparator()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Comparator() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenComparatorDataIsOne() {
    // Arrange
    Comparator comparator = new Comparator();

    // Act
    comparator.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 1, comparator.getData());
    assertEquals(BlockFace.EAST, comparator.getFacing());
  }

  /**
   * Test {@link Comparator#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Comparator#Comparator()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Comparator() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenComparatorDataIsZero() {
    // Arrange
    Comparator comparator = new Comparator();

    // Act
    comparator.setFacingDirection(BlockFace.NORTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, comparator.getData());
    assertEquals(BlockFace.NORTH, comparator.getFacing());
  }

  /**
   * Test {@link Comparator#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Comparator#Comparator()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Comparator() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenComparatorDataIsTwo() {
    // Arrange
    Comparator comparator = new Comparator();

    // Act
    comparator.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 2, comparator.getData());
    assertEquals(BlockFace.SOUTH, comparator.getFacing());
  }

  /**
   * Test {@link Comparator#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Comparator#Comparator()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Comparator() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Comparator.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenComparatorDataIsThree() {
    // Arrange
    Comparator comparator = new Comparator();

    // Act
    comparator.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 3, comparator.getData());
    assertEquals(BlockFace.WEST, comparator.getFacing());
  }

  /**
   * Test {@link Comparator#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()} Data is {@code A}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Comparator() Data is 'A'; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Comparator.getFacing()"})
  void testGetFacing_givenComparatorDataIsA_thenReturnEast() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) 'A');

    // Act and Assert
    assertEquals(BlockFace.EAST, comparator.getFacing());
  }

  /**
   * Test {@link Comparator#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()} Data is three.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Comparator() Data is three; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Comparator.getFacing()"})
  void testGetFacing_givenComparatorDataIsThree_thenReturnWest() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.WEST, comparator.getFacing());
  }

  /**
   * Test {@link Comparator#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()} Data is two.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Comparator() Data is two; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Comparator.getFacing()"})
  void testGetFacing_givenComparatorDataIsTwo_thenReturnSouth() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, comparator.getFacing());
  }

  /**
   * Test {@link Comparator#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Comparator(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Comparator.getFacing()"})
  void testGetFacing_givenComparator_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Comparator().getFacing());
  }

  /**
   * Test {@link Comparator#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_REDSTONE_COMPARATOR_OFF(0) facing NORTH in comparator mode}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'LEGACY_REDSTONE_COMPARATOR_OFF(0) facing NORTH in comparator mode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Comparator.toString()"})
  void testToString_thenReturnLegacyRedstoneComparatorOff0FacingNorthInComparatorMode() {
    // Arrange, Act and Assert
    assertEquals(
        "LEGACY_REDSTONE_COMPARATOR_OFF(0) facing NORTH in comparator mode",
        new Comparator().toString());
  }

  /**
   * Test {@link Comparator#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_REDSTONE_COMPARATOR_OFF(2) facing SOUTH in comparator mode}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'LEGACY_REDSTONE_COMPARATOR_OFF(2) facing SOUTH in comparator mode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Comparator.toString()"})
  void testToString_thenReturnLegacyRedstoneComparatorOff2FacingSouthInComparatorMode() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) 2);

    // Act and Assert
    assertEquals(
        "LEGACY_REDSTONE_COMPARATOR_OFF(2) facing SOUTH in comparator mode", comparator.toString());
  }

  /**
   * Test {@link Comparator#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_REDSTONE_COMPARATOR_OFF(3) facing WEST in comparator mode}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'LEGACY_REDSTONE_COMPARATOR_OFF(3) facing WEST in comparator mode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Comparator.toString()"})
  void testToString_thenReturnLegacyRedstoneComparatorOff3FacingWestInComparatorMode() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) 3);

    // Act and Assert
    assertEquals(
        "LEGACY_REDSTONE_COMPARATOR_OFF(3) facing WEST in comparator mode", comparator.toString());
  }

  /**
   * Test {@link Comparator#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_REDSTONE_COMPARATOR_OFF(4) facing NORTH in subtraction mode}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'LEGACY_REDSTONE_COMPARATOR_OFF(4) facing NORTH in subtraction mode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Comparator.toString()"})
  void testToString_thenReturnLegacyRedstoneComparatorOff4FacingNorthInSubtractionMode() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) 4);

    // Act and Assert
    assertEquals(
        "LEGACY_REDSTONE_COMPARATOR_OFF(4) facing NORTH in subtraction mode",
        comparator.toString());
  }

  /**
   * Test {@link Comparator#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_REDSTONE_COMPARATOR_OFF(65) facing EAST in comparator mode}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'LEGACY_REDSTONE_COMPARATOR_OFF(65) facing EAST in comparator mode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Comparator.toString()"})
  void testToString_thenReturnLegacyRedstoneComparatorOff65FacingEastInComparatorMode() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) 'A');

    // Act and Assert
    assertEquals(
        "LEGACY_REDSTONE_COMPARATOR_OFF(65) facing EAST in comparator mode", comparator.toString());
  }

  /**
   * Test {@link Comparator#clone()}.
   *
   * <p>Method under test: {@link Comparator#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparator Comparator.clone()"})
  void testClone() {
    // Arrange
    Comparator comparator = new Comparator();

    // Act
    Comparator actualCloneResult = comparator.clone();

    // Assert
    assertEquals(comparator, actualCloneResult);
  }

  /**
   * Test {@link Comparator#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Comparator(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Comparator.isPowered()"})
  void testIsPowered_givenComparator_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Comparator().isPowered());
  }

  /**
   * Test {@link Comparator#isPowered()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Comparator.isPowered()"})
  void testIsPowered_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Comparator(Material.LEGACY_REDSTONE_COMPARATOR_ON).isPowered());
  }

  /**
   * Test {@link Comparator#isBeingPowered()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()} Data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#isBeingPowered()}
   */
  @Test
  @DisplayName("Test isBeingPowered(); given Comparator() Data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Comparator.isBeingPowered()"})
  void testIsBeingPowered_givenComparatorDataIsX_thenReturnTrue() {
    // Arrange
    Comparator comparator = new Comparator();
    comparator.setData((byte) 'X');

    // Act and Assert
    assertTrue(comparator.isBeingPowered());
  }

  /**
   * Test {@link Comparator#isBeingPowered()}.
   *
   * <ul>
   *   <li>Given {@link Comparator#Comparator()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Comparator#isBeingPowered()}
   */
  @Test
  @DisplayName("Test isBeingPowered(); given Comparator(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Comparator.isBeingPowered()"})
  void testIsBeingPowered_givenComparator_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Comparator().isBeingPowered());
  }
}
