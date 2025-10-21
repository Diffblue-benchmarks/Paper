package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.types.MushroomBlockTexture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MushroomDiffblueTest {
  /**
   * Test {@link Mushroom#Mushroom(Material)}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_HUGE_MUSHROOM_1}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#Mushroom(Material)}
   */
  @Test
  @DisplayName("Test new Mushroom(Material); then return ItemType is 'LEGACY_HUGE_MUSHROOM_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.<init>(Material)"})
  void testNewMushroom_thenReturnItemTypeIsLegacyHugeMushroom1() {
    // Arrange and Act
    Mushroom actualMushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);

    // Assert
    assertEquals((byte) 0, actualMushroom.getData());
    assertEquals(Material.LEGACY_HUGE_MUSHROOM_1, actualMushroom.getItemType());
    assertEquals(MushroomBlockTexture.ALL_PORES, actualMushroom.getBlockTexture());
    assertFalse(actualMushroom.isStem());
    assertTrue(actualMushroom.getPaintedFaces().isEmpty());
  }

  /**
   * Test {@link Mushroom#Mushroom(Material)}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_HUGE_MUSHROOM_2}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#Mushroom(Material)}
   */
  @Test
  @DisplayName("Test new Mushroom(Material); then return ItemType is 'LEGACY_HUGE_MUSHROOM_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.<init>(Material)"})
  void testNewMushroom_thenReturnItemTypeIsLegacyHugeMushroom2() {
    // Arrange and Act
    Mushroom actualMushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_2);

    // Assert
    assertEquals((byte) 0, actualMushroom.getData());
    assertEquals(Material.LEGACY_HUGE_MUSHROOM_2, actualMushroom.getItemType());
    assertEquals(MushroomBlockTexture.ALL_PORES, actualMushroom.getBlockTexture());
    assertFalse(actualMushroom.isStem());
    assertTrue(actualMushroom.getPaintedFaces().isEmpty());
  }

  /**
   * Test {@link Mushroom#Mushroom(Material, byte)}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_HUGE_MUSHROOM_1}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#Mushroom(Material, byte)}
   */
  @Test
  @DisplayName(
      "Test new Mushroom(Material, byte); then return ItemType is 'LEGACY_HUGE_MUSHROOM_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.<init>(Material, byte)"})
  void testNewMushroom_thenReturnItemTypeIsLegacyHugeMushroom12() {
    // Arrange and Act
    Mushroom actualMushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1, (byte) 'A');

    // Assert
    assertNull(actualMushroom.getBlockTexture());
    Set<BlockFace> paintedFaces = actualMushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals(Material.LEGACY_HUGE_MUSHROOM_1, actualMushroom.getItemType());
    assertFalse(actualMushroom.isStem());
    assertTrue(paintedFaces.contains(BlockFace.EAST));
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('A', actualMushroom.getData());
  }

  /**
   * Test {@link Mushroom#Mushroom(Material, BlockFace)}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_HUGE_MUSHROOM_1}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#Mushroom(Material, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Mushroom(Material, BlockFace); then return ItemType is 'LEGACY_HUGE_MUSHROOM_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.<init>(Material, BlockFace)"})
  void testNewMushroom_thenReturnItemTypeIsLegacyHugeMushroom13() {
    // Arrange and Act
    Mushroom actualMushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1, BlockFace.NORTH);

    // Assert
    Set<BlockFace> paintedFaces = actualMushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 2, actualMushroom.getData());
    assertEquals(Material.LEGACY_HUGE_MUSHROOM_1, actualMushroom.getItemType());
    assertEquals(MushroomBlockTexture.CAP_NORTH, actualMushroom.getBlockTexture());
    assertFalse(actualMushroom.isStem());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertTrue(paintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#Mushroom(Material, MushroomBlockTexture)}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_HUGE_MUSHROOM_1}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#Mushroom(Material, MushroomBlockTexture)}
   */
  @Test
  @DisplayName(
      "Test new Mushroom(Material, MushroomBlockTexture); then return ItemType is 'LEGACY_HUGE_MUSHROOM_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.<init>(Material, MushroomBlockTexture)"})
  void testNewMushroom_thenReturnItemTypeIsLegacyHugeMushroom14() {
    // Arrange and Act
    Mushroom actualMushroom =
        new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1, MushroomBlockTexture.ALL_PORES);

    // Assert
    assertEquals((byte) 0, actualMushroom.getData());
    assertEquals(Material.LEGACY_HUGE_MUSHROOM_1, actualMushroom.getItemType());
    assertEquals(MushroomBlockTexture.ALL_PORES, actualMushroom.getBlockTexture());
    assertFalse(actualMushroom.isStem());
    assertTrue(actualMushroom.getPaintedFaces().isEmpty());
  }

  /**
   * Test {@link Mushroom#Mushroom(Material, byte)}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_HUGE_MUSHROOM_2}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#Mushroom(Material, byte)}
   */
  @Test
  @DisplayName(
      "Test new Mushroom(Material, byte); then return ItemType is 'LEGACY_HUGE_MUSHROOM_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.<init>(Material, byte)"})
  void testNewMushroom_thenReturnItemTypeIsLegacyHugeMushroom22() {
    // Arrange and Act
    Mushroom actualMushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_2, (byte) 'A');

    // Assert
    assertNull(actualMushroom.getBlockTexture());
    Set<BlockFace> paintedFaces = actualMushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals(Material.LEGACY_HUGE_MUSHROOM_2, actualMushroom.getItemType());
    assertFalse(actualMushroom.isStem());
    assertTrue(paintedFaces.contains(BlockFace.EAST));
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('A', actualMushroom.getData());
  }

  /**
   * Test {@link Mushroom#Mushroom(Material, BlockFace)}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_HUGE_MUSHROOM_2}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#Mushroom(Material, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Mushroom(Material, BlockFace); then return ItemType is 'LEGACY_HUGE_MUSHROOM_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.<init>(Material, BlockFace)"})
  void testNewMushroom_thenReturnItemTypeIsLegacyHugeMushroom23() {
    // Arrange and Act
    Mushroom actualMushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_2, BlockFace.NORTH);

    // Assert
    Set<BlockFace> paintedFaces = actualMushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 2, actualMushroom.getData());
    assertEquals(Material.LEGACY_HUGE_MUSHROOM_2, actualMushroom.getItemType());
    assertEquals(MushroomBlockTexture.CAP_NORTH, actualMushroom.getBlockTexture());
    assertFalse(actualMushroom.isStem());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertTrue(paintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#Mushroom(Material, MushroomBlockTexture)}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_HUGE_MUSHROOM_2}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#Mushroom(Material, MushroomBlockTexture)}
   */
  @Test
  @DisplayName(
      "Test new Mushroom(Material, MushroomBlockTexture); then return ItemType is 'LEGACY_HUGE_MUSHROOM_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.<init>(Material, MushroomBlockTexture)"})
  void testNewMushroom_thenReturnItemTypeIsLegacyHugeMushroom24() {
    // Arrange and Act
    Mushroom actualMushroom =
        new Mushroom(Material.LEGACY_HUGE_MUSHROOM_2, MushroomBlockTexture.ALL_PORES);

    // Assert
    assertEquals((byte) 0, actualMushroom.getData());
    assertEquals(Material.LEGACY_HUGE_MUSHROOM_2, actualMushroom.getItemType());
    assertEquals(MushroomBlockTexture.ALL_PORES, actualMushroom.getBlockTexture());
    assertFalse(actualMushroom.isStem());
    assertTrue(actualMushroom.getPaintedFaces().isEmpty());
  }

  /**
   * Test {@link Mushroom#isStem()}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isStem()}
   */
  @Test
  @DisplayName(
      "Test isStem(); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isStem()"})
  void testIsStem_givenMushroomWithShroomIsLegacy_huge_mushroom_1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1).isStem());
  }

  /**
   * Test {@link Mushroom#setStem()}.
   *
   * <p>Method under test: {@link Mushroom#setStem()}
   */
  @Test
  @DisplayName("Test setStem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setStem()"})
  void testSetStem() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);

    // Act
    mushroom.setStem();

    // Assert
    assertEquals(MushroomBlockTexture.STEM_SIDES, mushroom.getBlockTexture());
    assertTrue(mushroom.isStem());
    assertEquals('\n', mushroom.getData());
  }

  /**
   * Test {@link Mushroom#getBlockTexture()}.
   *
   * <ul>
   *   <li>Then return {@code ALL_PORES}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#getBlockTexture()}
   */
  @Test
  @DisplayName("Test getBlockTexture(); then return 'ALL_PORES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MushroomBlockTexture Mushroom.getBlockTexture()"})
  void testGetBlockTexture_thenReturnAllPores() {
    // Arrange, Act and Assert
    assertEquals(
        MushroomBlockTexture.ALL_PORES,
        new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1).getBlockTexture());
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1() {
    // Arrange, Act and Assert
    assertFalse(new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1).isFacePainted(BlockFace.NORTH));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsA() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act and Assert
    assertFalse(mushroom.isFacePainted(BlockFace.NORTH));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFifteen() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 15);

    // Act and Assert
    assertFalse(mushroom.isFacePainted(BlockFace.NORTH));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFourteen() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 14);

    // Act and Assert
    assertTrue(mushroom.isFacePainted(BlockFace.DOWN));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is lf.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsLf() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) '\n');

    // Act and Assert
    assertFalse(mushroom.isFacePainted(BlockFace.NORTH));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsOne() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act and Assert
    assertFalse(mushroom.isFacePainted(BlockFace.EAST));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsOne2() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act and Assert
    assertTrue(mushroom.isFacePainted(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsOne3() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act and Assert
    assertTrue(mushroom.isFacePainted(BlockFace.SOUTH));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isFacePainted(BlockFace); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsThree() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 3);

    // Act and Assert
    assertTrue(mushroom.isFacePainted(BlockFace.NORTH));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName("Test isFacePainted(BlockFace); when 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_whenDown() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act and Assert
    assertFalse(mushroom.isFacePainted(BlockFace.DOWN));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName("Test isFacePainted(BlockFace); when 'EAST'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_whenEast_thenReturnTrue() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act and Assert
    assertTrue(mushroom.isFacePainted(BlockFace.EAST));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName("Test isFacePainted(BlockFace); when 'NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_whenNorthEast() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act and Assert
    assertFalse(mushroom.isFacePainted(BlockFace.NORTH_EAST));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName("Test isFacePainted(BlockFace); when 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_whenSouth() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act and Assert
    assertFalse(mushroom.isFacePainted(BlockFace.SOUTH));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName("Test isFacePainted(BlockFace); when 'UP'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_whenUp_thenReturnTrue() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act and Assert
    assertTrue(mushroom.isFacePainted(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#isFacePainted(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#isFacePainted(BlockFace)}
   */
  @Test
  @DisplayName("Test isFacePainted(BlockFace); when 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mushroom.isFacePainted(BlockFace)"})
  void testIsFacePainted_whenWest() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act and Assert
    assertFalse(mushroom.isFacePainted(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);

    // Act
    mushroom.setFacePainted(BlockFace.EAST, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals(MushroomBlockTexture.CAP_SOUTH, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.EAST));
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('\b', mushroom.getData());
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted2() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);

    // Act
    mushroom.setFacePainted(BlockFace.SOUTH, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 4, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_WEST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.SOUTH));
    assertTrue(paintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted3() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);

    // Act
    mushroom.setFacePainted(BlockFace.UP, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(1, paintedFaces.size());
    assertEquals((byte) 5, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_TOP, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted4() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act
    mushroom.setFacePainted(BlockFace.WEST, true);

    // Assert
    assertNull(mushroom.getBlockTexture());
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('>', mushroom.getData());
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted5() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act
    mushroom.setFacePainted(BlockFace.SOUTH, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(3, paintedFaces.size());
    assertTrue(paintedFaces.contains(BlockFace.SOUTH));
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('@', mushroom.getData());
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted6() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act
    mushroom.setFacePainted(BlockFace.EAST, false);

    // Assert
    assertNull(mushroom.getBlockTexture());
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('>', mushroom.getData());
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted7() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 14);

    // Act
    mushroom.setFacePainted(BlockFace.DOWN, false);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(1, paintedFaces.size());
    assertEquals((byte) 5, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_TOP, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFifteen() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 15);

    // Act
    mushroom.setFacePainted(BlockFace.NORTH, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 6, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_EAST, mushroom.getBlockTexture());
    assertFalse(mushroom.isStem());
    assertTrue(paintedFaces.contains(BlockFace.NORTH));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFour() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 4);

    // Act
    mushroom.setFacePainted(BlockFace.DOWN, false);

    // Assert that nothing has changed
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 4, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_WEST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFour2() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 4);

    // Act
    mushroom.setFacePainted(BlockFace.NORTH_EAST, false);

    // Assert that nothing has changed
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 4, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_WEST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is lf.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsLf() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) '\n');

    // Act
    mushroom.setFacePainted(BlockFace.NORTH, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 6, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_EAST, mushroom.getBlockTexture());
    assertFalse(mushroom.isStem());
    assertTrue(paintedFaces.contains(BlockFace.NORTH));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsThree() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 3);

    // Act
    mushroom.setFacePainted(BlockFace.NORTH, false);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 2, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_NORTH, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertTrue(paintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsA() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act
    mushroom.setFacePainted(BlockFace.EAST, true);

    // Assert that nothing has changed
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('A', mushroom.getData());
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is 'B'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsB() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act
    mushroom.setFacePainted(BlockFace.NORTH, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(3, paintedFaces.size());
    assertTrue(paintedFaces.contains(BlockFace.EAST));
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('B', mushroom.getData());
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFour() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act
    mushroom.setFacePainted(BlockFace.EAST, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 4, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_WEST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFour2() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act
    mushroom.setFacePainted(BlockFace.WEST, false);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 4, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_WEST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFourteen() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 4);

    // Act
    mushroom.setFacePainted(BlockFace.DOWN, true);

    // Assert
    assertEquals((byte) 14, mushroom.getData());
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(3, paintedFaces.size());
    assertEquals(MushroomBlockTexture.ALL_CAP, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.DOWN));
    assertTrue(paintedFaces.contains(BlockFace.EAST));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsOne() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act
    mushroom.setFacePainted(BlockFace.WEST, true);

    // Assert that nothing has changed
    assertEquals((byte) 1, mushroom.getData());
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(3, paintedFaces.size());
    assertEquals(MushroomBlockTexture.CAP_NORTH_WEST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsOne2() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act
    mushroom.setFacePainted(BlockFace.SOUTH, true);

    // Assert that nothing has changed
    assertEquals((byte) 1, mushroom.getData());
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(3, paintedFaces.size());
    assertEquals(MushroomBlockTexture.CAP_NORTH_WEST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is six.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsSix() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);

    // Act
    mushroom.setFacePainted(BlockFace.NORTH, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 6, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_EAST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.NORTH));
    assertTrue(paintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsThree() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 3);

    // Act
    mushroom.setFacePainted(BlockFace.NORTH, true);

    // Assert that nothing has changed
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(3, paintedFaces.size());
    assertEquals((byte) 3, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_NORTH_EAST, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsTwo() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);

    // Act
    mushroom.setFacePainted(BlockFace.WEST, true);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 2, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_NORTH, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertTrue(paintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsTwo2() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act
    mushroom.setFacePainted(BlockFace.SOUTH, false);

    // Assert
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertEquals((byte) 2, mushroom.getData());
    assertEquals(MushroomBlockTexture.CAP_NORTH, mushroom.getBlockTexture());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertTrue(paintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsZero() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act
    mushroom.setFacePainted(BlockFace.UP, false);

    // Assert
    assertEquals((byte) 0, mushroom.getData());
    assertEquals(MushroomBlockTexture.ALL_PORES, mushroom.getBlockTexture());
    assertFalse(mushroom.isStem());
    assertTrue(mushroom.getPaintedFaces().isEmpty());
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenThrowIllegalArgumentException() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 4);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> mushroom.setFacePainted(BlockFace.NORTH_EAST, true));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test setFacePainted(BlockFace, boolean); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_thenThrowIllegalArgumentException2() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 14);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> mushroom.setFacePainted(BlockFace.NORTH_EAST, true));
  }

  /**
   * Test {@link Mushroom#setFacePainted(BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#setFacePainted(BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFacePainted(BlockFace, boolean); when 'UP'; then Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mushroom.setFacePainted(BlockFace, boolean)"})
  void testSetFacePainted_whenUp_thenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsA() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act
    mushroom.setFacePainted(BlockFace.UP, true);

    // Assert that nothing has changed
    Set<BlockFace> paintedFaces = mushroom.getPaintedFaces();
    assertEquals(2, paintedFaces.size());
    assertTrue(paintedFaces.contains(BlockFace.UP));
    assertEquals('A', mushroom.getData());
  }

  /**
   * Test {@link Mushroom#getPaintedFaces()}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#getPaintedFaces()}
   */
  @Test
  @DisplayName(
      "Test getPaintedFaces(); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Mushroom.getPaintedFaces()"})
  void testGetPaintedFaces_givenMushroomWithShroomIsLegacy_huge_mushroom_1() {
    // Arrange, Act and Assert
    assertTrue(new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1).getPaintedFaces().isEmpty());
  }

  /**
   * Test {@link Mushroom#getPaintedFaces()}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#getPaintedFaces()}
   */
  @Test
  @DisplayName(
      "Test getPaintedFaces(); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Mushroom.getPaintedFaces()"})
  void testGetPaintedFaces_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFifteen() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 15);

    // Act and Assert
    assertTrue(mushroom.getPaintedFaces().isEmpty());
  }

  /**
   * Test {@link Mushroom#getPaintedFaces()}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is lf.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#getPaintedFaces()}
   */
  @Test
  @DisplayName(
      "Test getPaintedFaces(); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Mushroom.getPaintedFaces()"})
  void testGetPaintedFaces_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsLf() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) '\n');

    // Act and Assert
    assertTrue(mushroom.getPaintedFaces().isEmpty());
  }

  /**
   * Test {@link Mushroom#getPaintedFaces()}.
   *
   * <ul>
   *   <li>Then return contains {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#getPaintedFaces()}
   */
  @Test
  @DisplayName("Test getPaintedFaces(); then return contains 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Mushroom.getPaintedFaces()"})
  void testGetPaintedFaces_thenReturnContainsNorth() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 3);

    // Act
    Set<BlockFace> actualPaintedFaces = mushroom.getPaintedFaces();

    // Assert
    assertEquals(3, actualPaintedFaces.size());
    assertTrue(actualPaintedFaces.contains(BlockFace.NORTH));
    assertTrue(actualPaintedFaces.contains(BlockFace.UP));
    assertTrue(actualPaintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#getPaintedFaces()}.
   *
   * <ul>
   *   <li>Then return contains {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#getPaintedFaces()}
   */
  @Test
  @DisplayName("Test getPaintedFaces(); then return contains 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Mushroom.getPaintedFaces()"})
  void testGetPaintedFaces_thenReturnContainsSouth() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act
    Set<BlockFace> actualPaintedFaces = mushroom.getPaintedFaces();

    // Assert
    assertEquals(3, actualPaintedFaces.size());
    assertTrue(actualPaintedFaces.contains(BlockFace.SOUTH));
    assertTrue(actualPaintedFaces.contains(BlockFace.UP));
    assertTrue(actualPaintedFaces.contains(BlockFace.WEST));
  }

  /**
   * Test {@link Mushroom#getPaintedFaces()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#getPaintedFaces()}
   */
  @Test
  @DisplayName("Test getPaintedFaces(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Mushroom.getPaintedFaces()"})
  void testGetPaintedFaces_thenReturnSizeIsTwo() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act
    Set<BlockFace> actualPaintedFaces = mushroom.getPaintedFaces();

    // Assert
    assertEquals(2, actualPaintedFaces.size());
    assertTrue(actualPaintedFaces.contains(BlockFace.EAST));
    assertTrue(actualPaintedFaces.contains(BlockFace.UP));
  }

  /**
   * Test {@link Mushroom#toString()}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Mushroom.toString()"})
  void testToString_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsFifteen() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 15);

    // Act and Assert
    assertEquals("LEGACY_HUGE_MUSHROOM_1 STEM []", mushroom.toString());
  }

  /**
   * Test {@link Mushroom#toString()}.
   *
   * <ul>
   *   <li>Given {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1} Data is lf.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1 Data is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Mushroom.toString()"})
  void testToString_givenMushroomWithShroomIsLegacy_huge_mushroom_1DataIsLf() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) '\n');

    // Act and Assert
    assertEquals("LEGACY_HUGE_MUSHROOM_1 STEM []", mushroom.toString());
  }

  /**
   * Test {@link Mushroom#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_HUGE_MUSHROOM_1 CAP []}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_HUGE_MUSHROOM_1 CAP []'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Mushroom.toString()"})
  void testToString_thenReturnLegacyHugeMushroom1Cap() {
    // Arrange, Act and Assert
    assertEquals(
        "LEGACY_HUGE_MUSHROOM_1 CAP []", new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1).toString());
  }

  /**
   * Test {@link Mushroom#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_HUGE_MUSHROOM_1 CAP [EAST, UP]}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_HUGE_MUSHROOM_1 CAP [EAST, UP]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Mushroom.toString()"})
  void testToString_thenReturnLegacyHugeMushroom1CapEastUp() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 'A');

    // Act and Assert
    assertEquals("LEGACY_HUGE_MUSHROOM_1 CAP [EAST, UP]", mushroom.toString());
  }

  /**
   * Test {@link Mushroom#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_HUGE_MUSHROOM_1 CAP [NORTH, WEST, UP]}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_HUGE_MUSHROOM_1 CAP [NORTH, WEST, UP]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Mushroom.toString()"})
  void testToString_thenReturnLegacyHugeMushroom1CapNorthWestUp() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 3);

    // Act and Assert
    assertEquals("LEGACY_HUGE_MUSHROOM_1 CAP [NORTH, WEST, UP]", mushroom.toString());
  }

  /**
   * Test {@link Mushroom#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_HUGE_MUSHROOM_1 CAP [SOUTH, WEST, UP]}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_HUGE_MUSHROOM_1 CAP [SOUTH, WEST, UP]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Mushroom.toString()"})
  void testToString_thenReturnLegacyHugeMushroom1CapSouthWestUp() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);
    mushroom.setData((byte) 1);

    // Act and Assert
    assertEquals("LEGACY_HUGE_MUSHROOM_1 CAP [SOUTH, WEST, UP]", mushroom.toString());
  }

  /**
   * Test {@link Mushroom#clone()}.
   *
   * <ul>
   *   <li>Then return {@link Mushroom#Mushroom(Material)} with shroom is {@link
   *       Material#LEGACY_HUGE_MUSHROOM_1}.
   * </ul>
   *
   * <p>Method under test: {@link Mushroom#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return Mushroom(Material) with shroom is LEGACY_HUGE_MUSHROOM_1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Mushroom Mushroom.clone()"})
  void testClone_thenReturnMushroomWithShroomIsLegacy_huge_mushroom_1() {
    // Arrange
    Mushroom mushroom = new Mushroom(Material.LEGACY_HUGE_MUSHROOM_1);

    // Act
    Mushroom actualCloneResult = mushroom.clone();

    // Assert
    assertEquals(mushroom, actualCloneResult);
  }
}
