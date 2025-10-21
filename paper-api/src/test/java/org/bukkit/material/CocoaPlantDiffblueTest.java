package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.CocoaPlant.CocoaPlantSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CocoaPlantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CocoaPlant#CocoaPlant(Material, byte)}
   *   <li>{@link CocoaPlant#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CocoaPlant.<init>(Material, byte)",
    "java.lang.String CocoaPlant.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) facing WEST SMALL", actualCocoaPlant.toString());
    assertEquals(Material.ACACIA_BOAT, actualCocoaPlant.getItemType());
    assertEquals('A', actualCocoaPlant.getData());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant()}.
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant()}
   */
  @Test
  @DisplayName("Test new CocoaPlant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>()"})
  void testNewCocoaPlant() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant();

    // Assert
    assertEquals((byte) 0, actualCocoaPlant.getData());
    assertEquals(Material.LEGACY_COCOA, actualCocoaPlant.getItemType());
    assertEquals(BlockFace.NORTH, actualCocoaPlant.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualCocoaPlant.getFacing());
    assertEquals(CocoaPlantSize.SMALL, actualCocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new CocoaPlant(CocoaPlantSize, BlockFace); when 'EAST'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize, BlockFace)"})
  void testNewCocoaPlant_whenEast_thenReturnDataIsThree() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.SMALL, BlockFace.EAST);

    // Assert
    assertEquals((byte) 3, actualCocoaPlant.getData());
    assertEquals(BlockFace.EAST, actualCocoaPlant.getFacing());
    assertEquals(BlockFace.WEST, actualCocoaPlant.getAttachedFace());
    assertEquals(CocoaPlantSize.SMALL, actualCocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize)}.
   *
   * <ul>
   *   <li>When {@code LARGE}.
   *   <li>Then return Size is {@code LARGE}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize)}
   */
  @Test
  @DisplayName("Test new CocoaPlant(CocoaPlantSize); when 'LARGE'; then return Size is 'LARGE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize)"})
  void testNewCocoaPlant_whenLarge_thenReturnSizeIsLarge() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.LARGE);

    // Assert
    assertEquals(Material.LEGACY_COCOA, actualCocoaPlant.getItemType());
    assertEquals(BlockFace.NORTH, actualCocoaPlant.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualCocoaPlant.getFacing());
    assertEquals(CocoaPlantSize.LARGE, actualCocoaPlant.getSize());
    assertEquals('\b', actualCocoaPlant.getData());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code LARGE}.
   *   <li>Then return Size is {@code LARGE}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new CocoaPlant(CocoaPlantSize, BlockFace); when 'LARGE'; then return Size is 'LARGE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize, BlockFace)"})
  void testNewCocoaPlant_whenLarge_thenReturnSizeIsLarge2() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.LARGE, BlockFace.SOUTH);

    // Assert
    assertEquals(BlockFace.NORTH, actualCocoaPlant.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualCocoaPlant.getFacing());
    assertEquals(CocoaPlantSize.LARGE, actualCocoaPlant.getSize());
    assertEquals('\b', actualCocoaPlant.getData());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize)}.
   *
   * <ul>
   *   <li>When {@code MEDIUM}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize)}
   */
  @Test
  @DisplayName("Test new CocoaPlant(CocoaPlantSize); when 'MEDIUM'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize)"})
  void testNewCocoaPlant_whenMedium_thenReturnDataIsFour() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.MEDIUM);

    // Assert
    assertEquals((byte) 4, actualCocoaPlant.getData());
    assertEquals(Material.LEGACY_COCOA, actualCocoaPlant.getItemType());
    assertEquals(BlockFace.NORTH, actualCocoaPlant.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualCocoaPlant.getFacing());
    assertEquals(CocoaPlantSize.MEDIUM, actualCocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code MEDIUM}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new CocoaPlant(CocoaPlantSize, BlockFace); when 'MEDIUM'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize, BlockFace)"})
  void testNewCocoaPlant_whenMedium_thenReturnDataIsFour2() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.MEDIUM, BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 4, actualCocoaPlant.getData());
    assertEquals(BlockFace.NORTH, actualCocoaPlant.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualCocoaPlant.getFacing());
    assertEquals(CocoaPlantSize.MEDIUM, actualCocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new CocoaPlant(CocoaPlantSize, BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize, BlockFace)"})
  void testNewCocoaPlant_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.SMALL, BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualCocoaPlant.getData());
    assertEquals(BlockFace.NORTH, actualCocoaPlant.getFacing());
    assertEquals(BlockFace.SOUTH, actualCocoaPlant.getAttachedFace());
    assertEquals(CocoaPlantSize.SMALL, actualCocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize)}.
   *
   * <ul>
   *   <li>When {@code SMALL}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize)}
   */
  @Test
  @DisplayName("Test new CocoaPlant(CocoaPlantSize); when 'SMALL'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize)"})
  void testNewCocoaPlant_whenSmall_thenReturnDataIsZero() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.SMALL);

    // Assert
    assertEquals((byte) 0, actualCocoaPlant.getData());
    assertEquals(Material.LEGACY_COCOA, actualCocoaPlant.getItemType());
    assertEquals(BlockFace.NORTH, actualCocoaPlant.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualCocoaPlant.getFacing());
    assertEquals(CocoaPlantSize.SMALL, actualCocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new CocoaPlant(CocoaPlantSize, BlockFace); when 'SOUTH'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize, BlockFace)"})
  void testNewCocoaPlant_whenSouth_thenReturnDataIsZero() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.SMALL, BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 0, actualCocoaPlant.getData());
    assertEquals(BlockFace.NORTH, actualCocoaPlant.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualCocoaPlant.getFacing());
    assertEquals(CocoaPlantSize.SMALL, actualCocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#CocoaPlant(CocoaPlantSize, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new CocoaPlant(CocoaPlantSize, BlockFace); when 'WEST'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.<init>(CocoaPlantSize, BlockFace)"})
  void testNewCocoaPlant_whenWest_thenReturnDataIsOne() {
    // Arrange and Act
    CocoaPlant actualCocoaPlant = new CocoaPlant(CocoaPlantSize.SMALL, BlockFace.WEST);

    // Assert
    assertEquals((byte) 1, actualCocoaPlant.getData());
    assertEquals(BlockFace.EAST, actualCocoaPlant.getAttachedFace());
    assertEquals(BlockFace.WEST, actualCocoaPlant.getFacing());
    assertEquals(CocoaPlantSize.SMALL, actualCocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#getSize()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant(CocoaPlantSize)} with sz is {@code MEDIUM}.
   *   <li>Then return {@code MEDIUM}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getSize()}
   */
  @Test
  @DisplayName(
      "Test getSize(); given CocoaPlant(CocoaPlantSize) with sz is 'MEDIUM'; then return 'MEDIUM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CocoaPlantSize CocoaPlant.getSize()"})
  void testGetSize_givenCocoaPlantWithSzIsMedium_thenReturnMedium() {
    // Arrange, Act and Assert
    assertEquals(CocoaPlantSize.MEDIUM, new CocoaPlant(CocoaPlantSize.MEDIUM).getSize());
  }

  /**
   * Test {@link CocoaPlant#getSize()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant(Material, byte)} with type is {@code ACACIA_BOAT} and
   *       data is {@code X}.
   *   <li>Then return {@code LARGE}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getSize()}
   */
  @Test
  @DisplayName(
      "Test getSize(); given CocoaPlant(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'LARGE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CocoaPlantSize CocoaPlant.getSize()"})
  void testGetSize_givenCocoaPlantWithTypeIsAcaciaBoatAndDataIsX_thenReturnLarge() {
    // Arrange, Act and Assert
    assertEquals(CocoaPlantSize.LARGE, new CocoaPlant(Material.ACACIA_BOAT, (byte) 'X').getSize());
  }

  /**
   * Test {@link CocoaPlant#getSize()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant()}.
   *   <li>Then return {@code SMALL}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getSize()}
   */
  @Test
  @DisplayName("Test getSize(); given CocoaPlant(); then return 'SMALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CocoaPlantSize CocoaPlant.getSize()"})
  void testGetSize_givenCocoaPlant_thenReturnSmall() {
    // Arrange, Act and Assert
    assertEquals(CocoaPlantSize.SMALL, new CocoaPlant().getSize());
  }

  /**
   * Test {@link CocoaPlant#setSize(CocoaPlantSize)}.
   *
   * <ul>
   *   <li>When {@code LARGE}.
   *   <li>Then {@link CocoaPlant#CocoaPlant()} Size is {@code LARGE}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#setSize(CocoaPlantSize)}
   */
  @Test
  @DisplayName("Test setSize(CocoaPlantSize); when 'LARGE'; then CocoaPlant() Size is 'LARGE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.setSize(CocoaPlantSize)"})
  void testSetSize_whenLarge_thenCocoaPlantSizeIsLarge() {
    // Arrange
    CocoaPlant cocoaPlant = new CocoaPlant();

    // Act
    cocoaPlant.setSize(CocoaPlantSize.LARGE);

    // Assert
    assertEquals(CocoaPlantSize.LARGE, cocoaPlant.getSize());
    assertEquals('\b', cocoaPlant.getData());
  }

  /**
   * Test {@link CocoaPlant#setSize(CocoaPlantSize)}.
   *
   * <ul>
   *   <li>When {@code MEDIUM}.
   *   <li>Then {@link CocoaPlant#CocoaPlant()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#setSize(CocoaPlantSize)}
   */
  @Test
  @DisplayName("Test setSize(CocoaPlantSize); when 'MEDIUM'; then CocoaPlant() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.setSize(CocoaPlantSize)"})
  void testSetSize_whenMedium_thenCocoaPlantDataIsFour() {
    // Arrange
    CocoaPlant cocoaPlant = new CocoaPlant();

    // Act
    cocoaPlant.setSize(CocoaPlantSize.MEDIUM);

    // Assert
    assertEquals((byte) 4, cocoaPlant.getData());
    assertEquals(CocoaPlantSize.MEDIUM, cocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#setSize(CocoaPlantSize)}.
   *
   * <ul>
   *   <li>When {@code SMALL}.
   *   <li>Then {@link CocoaPlant#CocoaPlant()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#setSize(CocoaPlantSize)}
   */
  @Test
  @DisplayName("Test setSize(CocoaPlantSize); when 'SMALL'; then CocoaPlant() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.setSize(CocoaPlantSize)"})
  void testSetSize_whenSmall_thenCocoaPlantDataIsZero() {
    // Arrange
    CocoaPlant cocoaPlant = new CocoaPlant();

    // Act
    cocoaPlant.setSize(CocoaPlantSize.SMALL);

    // Assert that nothing has changed
    assertEquals((byte) 0, cocoaPlant.getData());
    assertEquals(CocoaPlantSize.SMALL, cocoaPlant.getSize());
  }

  /**
   * Test {@link CocoaPlant#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant(Material, byte)} with type is {@code ACACIA_BOAT} and
   *       data is {@code A}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given CocoaPlant(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace CocoaPlant.getAttachedFace()"})
  void testGetAttachedFace_givenCocoaPlantWithTypeIsAcaciaBoatAndDataIsA_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST, new CocoaPlant(Material.ACACIA_BOAT, (byte) 'A').getAttachedFace());
  }

  /**
   * Test {@link CocoaPlant#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant()}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given CocoaPlant(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace CocoaPlant.getAttachedFace()"})
  void testGetAttachedFace_givenCocoaPlant_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new CocoaPlant().getAttachedFace());
  }

  /**
   * Test {@link CocoaPlant#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace CocoaPlant.getAttachedFace()"})
  void testGetAttachedFace_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new CocoaPlant(Material.ACACIA_BOAT, (byte) 2).getAttachedFace());
  }

  /**
   * Test {@link CocoaPlant#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace CocoaPlant.getAttachedFace()"})
  void testGetAttachedFace_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new CocoaPlant(Material.ACACIA_BOAT, (byte) 3).getAttachedFace());
  }

  /**
   * Test {@link CocoaPlant#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link CocoaPlant#CocoaPlant()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then CocoaPlant() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenCocoaPlantDataIsThree() {
    // Arrange
    CocoaPlant cocoaPlant = new CocoaPlant();

    // Act
    cocoaPlant.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 3, cocoaPlant.getData());
    assertEquals(BlockFace.EAST, cocoaPlant.getFacing());
    assertEquals(BlockFace.WEST, cocoaPlant.getAttachedFace());
  }

  /**
   * Test {@link CocoaPlant#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link CocoaPlant#CocoaPlant()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then CocoaPlant() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenCocoaPlantDataIsTwo() {
    // Arrange
    CocoaPlant cocoaPlant = new CocoaPlant();

    // Act
    cocoaPlant.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, cocoaPlant.getData());
    assertEquals(BlockFace.NORTH, cocoaPlant.getFacing());
    assertEquals(BlockFace.SOUTH, cocoaPlant.getAttachedFace());
  }

  /**
   * Test {@link CocoaPlant#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link CocoaPlant#CocoaPlant()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then CocoaPlant() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenCocoaPlantDataIsZero() {
    // Arrange
    CocoaPlant cocoaPlant = new CocoaPlant();

    // Act
    cocoaPlant.setFacingDirection(BlockFace.SOUTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, cocoaPlant.getData());
    assertEquals(BlockFace.NORTH, cocoaPlant.getAttachedFace());
    assertEquals(BlockFace.SOUTH, cocoaPlant.getFacing());
  }

  /**
   * Test {@link CocoaPlant#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link CocoaPlant#CocoaPlant()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then CocoaPlant() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CocoaPlant.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenCocoaPlantDataIsOne() {
    // Arrange
    CocoaPlant cocoaPlant = new CocoaPlant();

    // Act
    cocoaPlant.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 1, cocoaPlant.getData());
    assertEquals(BlockFace.EAST, cocoaPlant.getAttachedFace());
    assertEquals(BlockFace.WEST, cocoaPlant.getFacing());
  }

  /**
   * Test {@link CocoaPlant#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant(Material, byte)} with type is {@code ACACIA_BOAT} and
   *       data is {@code A}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given CocoaPlant(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace CocoaPlant.getFacing()"})
  void testGetFacing_givenCocoaPlantWithTypeIsAcaciaBoatAndDataIsA_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new CocoaPlant(Material.ACACIA_BOAT, (byte) 'A').getFacing());
  }

  /**
   * Test {@link CocoaPlant#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant(Material, byte)} with type is {@code ACACIA_BOAT} and
   *       data is three.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given CocoaPlant(Material, byte) with type is 'ACACIA_BOAT' and data is three; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace CocoaPlant.getFacing()"})
  void testGetFacing_givenCocoaPlantWithTypeIsAcaciaBoatAndDataIsThree_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new CocoaPlant(Material.ACACIA_BOAT, (byte) 3).getFacing());
  }

  /**
   * Test {@link CocoaPlant#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant(Material, byte)} with type is {@code ACACIA_BOAT} and
   *       data is two.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given CocoaPlant(Material, byte) with type is 'ACACIA_BOAT' and data is two; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace CocoaPlant.getFacing()"})
  void testGetFacing_givenCocoaPlantWithTypeIsAcaciaBoatAndDataIsTwo_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new CocoaPlant(Material.ACACIA_BOAT, (byte) 2).getFacing());
  }

  /**
   * Test {@link CocoaPlant#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link CocoaPlant#CocoaPlant()}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link CocoaPlant#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given CocoaPlant(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace CocoaPlant.getFacing()"})
  void testGetFacing_givenCocoaPlant_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new CocoaPlant().getFacing());
  }

  /**
   * Test {@link CocoaPlant#clone()}.
   *
   * <p>Method under test: {@link CocoaPlant#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CocoaPlant CocoaPlant.clone()"})
  void testClone() {
    // Arrange
    CocoaPlant cocoaPlant = new CocoaPlant();

    // Act
    CocoaPlant actualCloneResult = cocoaPlant.clone();

    // Assert
    assertEquals(cocoaPlant, actualCloneResult);
  }
}
