package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.GrassSpecies;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowerPotDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code ACACIA_BOAT(0) containing null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FlowerPot#FlowerPot(Material)}
   *   <li>{@link FlowerPot#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'ACACIA_BOAT(0) containing null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FlowerPot.<init>(Material)",
    "void FlowerPot.<init>(Material, byte)",
    "java.lang.String FlowerPot.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsAcaciaBoat0ContainingNull() {
    // Arrange and Act
    FlowerPot actualFlowerPot = new FlowerPot(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) containing null", actualFlowerPot.toString());
    assertEquals((byte) 0, actualFlowerPot.getData());
    assertEquals(Material.ACACIA_BOAT, actualFlowerPot.getItemType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code ACACIA_BOAT(65) containing null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FlowerPot#FlowerPot(Material, byte)}
   *   <li>{@link FlowerPot#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'A'; then return toString is 'ACACIA_BOAT(65) containing null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FlowerPot.<init>(Material)",
    "void FlowerPot.<init>(Material, byte)",
    "java.lang.String FlowerPot.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsAcaciaBoat65ContainingNull() {
    // Arrange and Act
    FlowerPot actualFlowerPot = new FlowerPot(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) containing null", actualFlowerPot.toString());
    assertEquals(Material.ACACIA_BOAT, actualFlowerPot.getItemType());
    assertEquals('A', actualFlowerPot.getData());
  }

  /**
   * Test {@link FlowerPot#FlowerPot()}.
   *
   * <p>Method under test: {@link FlowerPot#FlowerPot()}
   */
  @Test
  @DisplayName("Test new FlowerPot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowerPot.<init>()"})
  void testNewFlowerPot() {
    // Arrange and Act
    FlowerPot actualFlowerPot = new FlowerPot();

    // Assert
    assertNull(actualFlowerPot.getContents());
    assertEquals((byte) 0, actualFlowerPot.getData());
    assertEquals(Material.LEGACY_FLOWER_POT, actualFlowerPot.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Given {@link FlowerPot#FlowerPot()} Data is eleven.
   *   <li>Then return {@link LongGrass}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given FlowerPot() Data is eleven; then return LongGrass")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_givenFlowerPotDataIsEleven_thenReturnLongGrass() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();
    flowerPot.setData((byte) 11);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertTrue(actualContents instanceof LongGrass);
    assertEquals((byte) 2, actualContents.getData());
    assertEquals(GrassSpecies.FERN_LIKE, ((LongGrass) actualContents).getSpecies());
    assertEquals(Material.LEGACY_LONG_GRASS, actualContents.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Given {@link FlowerPot#FlowerPot(Material)} with type is {@code ACACIA_BOAT} Data is
   *       eleven.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName(
      "Test getContents(); given FlowerPot(Material) with type is 'ACACIA_BOAT' Data is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_givenFlowerPotWithTypeIsAcaciaBoatDataIsEleven() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) 11);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertTrue(actualContents instanceof LongGrass);
    assertEquals((byte) 2, actualContents.getData());
    assertEquals(GrassSpecies.FERN_LIKE, ((LongGrass) actualContents).getSpecies());
    assertEquals(Material.LEGACY_LONG_GRASS, actualContents.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Given {@link FlowerPot#FlowerPot(Material)} with type is {@code ACACIA_BOAT} Data is
   *       four.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName(
      "Test getContents(); given FlowerPot(Material) with type is 'ACACIA_BOAT' Data is four; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_givenFlowerPotWithTypeIsAcaciaBoatDataIsFour_thenReturnDataIsOne() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) 4);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertTrue(actualContents instanceof Tree);
    assertEquals((byte) 1, actualContents.getData());
    assertEquals(Material.LEGACY_LOG, actualContents.getItemType());
    assertEquals(TreeSpecies.REDWOOD, ((Tree) actualContents).getSpecies());
    assertEquals(BlockFace.UP, ((Tree) actualContents).getDirection());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Given {@link FlowerPot#FlowerPot()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given FlowerPot(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_givenFlowerPot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FlowerPot().getContents());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnDataIsThree() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) 6);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertTrue(actualContents instanceof Tree);
    assertEquals((byte) 3, actualContents.getData());
    assertEquals(Material.LEGACY_LOG, actualContents.getItemType());
    assertEquals(TreeSpecies.JUNGLE, ((Tree) actualContents).getSpecies());
    assertEquals(BlockFace.UP, ((Tree) actualContents).getDirection());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_BROWN_MUSHROOM}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return ItemType is 'LEGACY_BROWN_MUSHROOM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnItemTypeIsLegacyBrownMushroom() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) '\b');

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertEquals((byte) 0, actualContents.getData());
    assertEquals(Material.LEGACY_BROWN_MUSHROOM, actualContents.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_CACTUS}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return ItemType is 'LEGACY_CACTUS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnItemTypeIsLegacyCactus() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) '\t');

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertEquals((byte) 0, actualContents.getData());
    assertEquals(Material.LEGACY_CACTUS, actualContents.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_DEAD_BUSH}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return ItemType is 'LEGACY_DEAD_BUSH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnItemTypeIsLegacyDeadBush() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) '\n');

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertEquals((byte) 0, actualContents.getData());
    assertEquals(Material.LEGACY_DEAD_BUSH, actualContents.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_RED_MUSHROOM}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return ItemType is 'LEGACY_RED_MUSHROOM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnItemTypeIsLegacyRedMushroom() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) 7);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertEquals((byte) 0, actualContents.getData());
    assertEquals(Material.LEGACY_RED_MUSHROOM, actualContents.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_RED_ROSE}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return ItemType is 'LEGACY_RED_ROSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnItemTypeIsLegacyRedRose() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) 1);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertEquals((byte) 0, actualContents.getData());
    assertEquals(Material.LEGACY_RED_ROSE, actualContents.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return ItemType is {@code LEGACY_YELLOW_FLOWER}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return ItemType is 'LEGACY_YELLOW_FLOWER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnItemTypeIsLegacyYellowFlower() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) 2);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertEquals((byte) 0, actualContents.getData());
    assertEquals(Material.LEGACY_YELLOW_FLOWER, actualContents.getItemType());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return Species is {@code BIRCH}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return Species is 'BIRCH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnSpeciesIsBirch() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) 5);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertTrue(actualContents instanceof Tree);
    assertEquals((byte) 2, actualContents.getData());
    assertEquals(Material.LEGACY_LOG, actualContents.getItemType());
    assertEquals(TreeSpecies.BIRCH, ((Tree) actualContents).getSpecies());
    assertEquals(BlockFace.UP, ((Tree) actualContents).getDirection());
  }

  /**
   * Test {@link FlowerPot#getContents()}.
   *
   * <ul>
   *   <li>Then return Species is {@code GENERIC}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return Species is 'GENERIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData FlowerPot.getContents()"})
  void testGetContents_thenReturnSpeciesIsGeneric() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot(Material.ACACIA_BOAT);
    flowerPot.setData((byte) 3);

    // Act
    MaterialData actualContents = flowerPot.getContents();

    // Assert
    assertTrue(actualContents instanceof Tree);
    assertEquals(Material.LEGACY_LOG, actualContents.getItemType());
    assertEquals(TreeSpecies.GENERIC, ((Tree) actualContents).getSpecies());
    assertEquals(BlockFace.UP, ((Tree) actualContents).getDirection());
  }

  /**
   * Test {@link FlowerPot#setContents(MaterialData)}.
   *
   * <p>Method under test: {@link FlowerPot#setContents(MaterialData)}
   */
  @Test
  @DisplayName("Test setContents(MaterialData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowerPot.setContents(MaterialData)"})
  void testSetContents() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();
    MaterialData materialData = new MaterialData(Material.LEGACY_BROWN_MUSHROOM);

    // Act
    flowerPot.setContents(materialData);

    // Assert
    assertEquals(materialData, flowerPot.getContents());
    assertEquals('\b', flowerPot.getData());
  }

  /**
   * Test {@link FlowerPot#setContents(MaterialData)}.
   *
   * <ul>
   *   <li>Then {@link FlowerPot#FlowerPot()} Contents is {@link
   *       MaterialData#MaterialData(Material)} with type is {@link Material#LEGACY_CACTUS}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#setContents(MaterialData)}
   */
  @Test
  @DisplayName(
      "Test setContents(MaterialData); then FlowerPot() Contents is MaterialData(Material) with type is LEGACY_CACTUS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowerPot.setContents(MaterialData)"})
  void testSetContents_thenFlowerPotContentsIsMaterialDataWithTypeIsLegacy_cactus() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();
    MaterialData materialData = new MaterialData(Material.LEGACY_CACTUS);

    // Act
    flowerPot.setContents(materialData);

    // Assert
    assertEquals(materialData, flowerPot.getContents());
    assertEquals('\t', flowerPot.getData());
  }

  /**
   * Test {@link FlowerPot#setContents(MaterialData)}.
   *
   * <ul>
   *   <li>Then {@link FlowerPot#FlowerPot()} Contents is {@link
   *       MaterialData#MaterialData(Material)} with type is {@link Material#LEGACY_DEAD_BUSH}.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#setContents(MaterialData)}
   */
  @Test
  @DisplayName(
      "Test setContents(MaterialData); then FlowerPot() Contents is MaterialData(Material) with type is LEGACY_DEAD_BUSH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowerPot.setContents(MaterialData)"})
  void testSetContents_thenFlowerPotContentsIsMaterialDataWithTypeIsLegacy_dead_bush() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();
    MaterialData materialData = new MaterialData(Material.LEGACY_DEAD_BUSH);

    // Act
    flowerPot.setContents(materialData);

    // Assert
    assertEquals(materialData, flowerPot.getContents());
    assertEquals('\n', flowerPot.getData());
  }

  /**
   * Test {@link FlowerPot#setContents(MaterialData)}.
   *
   * <ul>
   *   <li>Then {@link FlowerPot#FlowerPot()} Data is seven.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#setContents(MaterialData)}
   */
  @Test
  @DisplayName("Test setContents(MaterialData); then FlowerPot() Data is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowerPot.setContents(MaterialData)"})
  void testSetContents_thenFlowerPotDataIsSeven() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();
    MaterialData materialData = new MaterialData(Material.LEGACY_RED_MUSHROOM);

    // Act
    flowerPot.setContents(materialData);

    // Assert
    assertEquals((byte) 7, flowerPot.getData());
    assertEquals(materialData, flowerPot.getContents());
  }

  /**
   * Test {@link FlowerPot#setContents(MaterialData)}.
   *
   * <ul>
   *   <li>Then {@link FlowerPot#FlowerPot()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#setContents(MaterialData)}
   */
  @Test
  @DisplayName("Test setContents(MaterialData); then FlowerPot() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowerPot.setContents(MaterialData)"})
  void testSetContents_thenFlowerPotDataIsTwo() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();
    MaterialData materialData = new MaterialData(Material.LEGACY_YELLOW_FLOWER);

    // Act
    flowerPot.setContents(materialData);

    // Assert
    assertEquals((byte) 2, flowerPot.getData());
    assertEquals(materialData, flowerPot.getContents());
  }

  /**
   * Test {@link FlowerPot#setContents(MaterialData)}.
   *
   * <ul>
   *   <li>When {@link MaterialData#MaterialData(Material)} with type is {@code ACACIA_BOAT}.
   *   <li>Then {@link FlowerPot#FlowerPot()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#setContents(MaterialData)}
   */
  @Test
  @DisplayName(
      "Test setContents(MaterialData); when MaterialData(Material) with type is 'ACACIA_BOAT'; then FlowerPot() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowerPot.setContents(MaterialData)"})
  void testSetContents_whenMaterialDataWithTypeIsAcaciaBoat_thenFlowerPotDataIsZero() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();

    // Act
    flowerPot.setContents(new MaterialData(Material.ACACIA_BOAT));

    // Assert that nothing has changed
    assertEquals((byte) 0, flowerPot.getData());
  }

  /**
   * Test {@link FlowerPot#setContents(MaterialData)}.
   *
   * <ul>
   *   <li>When {@link MaterialData#MaterialData(Material)} with type is {@link
   *       Material#LEGACY_RED_ROSE}.
   *   <li>Then {@link FlowerPot#FlowerPot()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link FlowerPot#setContents(MaterialData)}
   */
  @Test
  @DisplayName(
      "Test setContents(MaterialData); when MaterialData(Material) with type is LEGACY_RED_ROSE; then FlowerPot() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowerPot.setContents(MaterialData)"})
  void testSetContents_whenMaterialDataWithTypeIsLegacy_red_rose_thenFlowerPotDataIsOne() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();
    MaterialData materialData = new MaterialData(Material.LEGACY_RED_ROSE);

    // Act
    flowerPot.setContents(materialData);

    // Assert
    assertEquals((byte) 1, flowerPot.getData());
    assertEquals(materialData, flowerPot.getContents());
  }

  /**
   * Test {@link FlowerPot#clone()}.
   *
   * <p>Method under test: {@link FlowerPot#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowerPot FlowerPot.clone()"})
  void testClone() {
    // Arrange
    FlowerPot flowerPot = new FlowerPot();

    // Act
    FlowerPot actualCloneResult = flowerPot.clone();

    // Assert
    assertEquals(flowerPot, actualCloneResult);
  }
}
