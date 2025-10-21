package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WoodDiffblueTest {
  /**
   * Test {@link Wood#Wood(Material, byte)}.
   *
   * <p>Method under test: {@link Wood#Wood(Material, byte)}
   */
  @Test
  @DisplayName("Test new Wood(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material, byte)", "java.lang.String Wood.toString()"})
  void testNewWood() {
    // Arrange and Act
    Wood actualWood = new Wood(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualWood.getItemType());
    assertEquals('A', actualWood.getData());
  }

  /**
   * Test {@link Wood#Wood()}.
   *
   * <p>Method under test: {@link Wood#Wood()}
   */
  @Test
  @DisplayName("Test new Wood()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>()"})
  void testNewWood2() {
    // Arrange and Act
    Wood actualWood = new Wood();

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_WOOD, actualWood.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material)}
   */
  @Test
  @DisplayName("Test new Wood(Material); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material)"})
  void testNewWood_whenAcaciaBoat_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Wood(Material.ACACIA_BOAT));
  }

  /**
   * Test {@link Wood#Wood(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Wood(Material, TreeSpecies); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material, TreeSpecies)"})
  void testNewWood_whenAcaciaBoat_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new Wood(Material.ACACIA_BOAT, TreeSpecies.GENERIC));
  }

  /**
   * Test {@link Wood#Wood(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(TreeSpecies)}
   */
  @Test
  @DisplayName("Test new Wood(TreeSpecies); when 'ACACIA'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(TreeSpecies)"})
  void testNewWood_whenAcacia_thenReturnDataIsFour() {
    // Arrange and Act
    Wood actualWood = new Wood(TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 4, actualWood.getData());
    assertEquals(Material.LEGACY_WOOD, actualWood.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(TreeSpecies)}
   */
  @Test
  @DisplayName("Test new Wood(TreeSpecies); when 'GENERIC'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(TreeSpecies)"})
  void testNewWood_whenGeneric_thenReturnDataIsZero() {
    // Arrange and Act
    Wood actualWood = new Wood(TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_WOOD, actualWood.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(Material)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material)}
   */
  @Test
  @DisplayName(
      "Test new Wood(Material); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material)"})
  void testNewWood_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves() {
    // Arrange and Act
    Wood actualWood = new Wood(Material.LEGACY_LEAVES_2);

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_LEAVES, actualWood.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Wood(Material, TreeSpecies); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material, TreeSpecies)"})
  void testNewWood_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Wood actualWood = new Wood(Material.LEGACY_LEAVES_2, TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_LEAVES, actualWood.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES_2}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Wood(Material, TreeSpecies); when 'LEGACY_LEAVES'; then return ItemType is 'LEGACY_LEAVES_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material, TreeSpecies)"})
  void testNewWood_whenLegacyLeaves_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Wood actualWood = new Wood(Material.LEGACY_LEAVES, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_LEAVES_2, actualWood.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(Material)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material)}
   */
  @Test
  @DisplayName("Test new Wood(Material); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material)"})
  void testNewWood_whenLegacyLog2_thenReturnItemTypeIsLegacyLog() {
    // Arrange and Act
    Wood actualWood = new Wood(Material.LEGACY_LOG_2);

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_LOG, actualWood.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Wood(Material, TreeSpecies); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material, TreeSpecies)"})
  void testNewWood_whenLegacyLog2_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Wood actualWood = new Wood(Material.LEGACY_LOG_2, TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_LOG, actualWood.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Wood(Material, TreeSpecies); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material, TreeSpecies)"})
  void testNewWood_whenLegacyLog2_thenReturnItemTypeIsLegacyLog22() {
    // Arrange and Act
    Wood actualWood = new Wood(Material.LEGACY_LOG_2, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_LOG_2, actualWood.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#Wood(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#Wood(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Wood(Material, TreeSpecies); when 'LEGACY_LOG'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.<init>(Material, TreeSpecies)"})
  void testNewWood_whenLegacyLog_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Wood actualWood = new Wood(Material.LEGACY_LOG, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualWood.getData());
    assertEquals(Material.LEGACY_LOG_2, actualWood.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualWood.getSpecies());
  }

  /**
   * Test {@link Wood#getSpecies()}.
   *
   * <ul>
   *   <li>Given {@link Wood#Wood()}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#getSpecies()}
   */
  @Test
  @DisplayName("Test getSpecies(); given Wood()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreeSpecies Wood.getSpecies()"})
  void testGetSpecies_givenWood() {
    // Arrange, Act and Assert
    assertEquals(TreeSpecies.GENERIC, new Wood().getSpecies());
  }

  /**
   * Test {@link Wood#getSpecies()}.
   *
   * <ul>
   *   <li>Given {@link Wood#Wood(Material)} with type is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#getSpecies()}
   */
  @Test
  @DisplayName("Test getSpecies(); given Wood(Material) with type is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreeSpecies Wood.getSpecies()"})
  void testGetSpecies_givenWoodWithTypeIsLegacyLog2() {
    // Arrange, Act and Assert
    assertEquals(TreeSpecies.GENERIC, new Wood(Material.LEGACY_LOG_2).getSpecies());
  }

  /**
   * Test {@link Wood#setSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>Given {@link Leaves#Leaves(TreeSpecies)} with species is {@code ACACIA}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#setSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test setSpecies(TreeSpecies); given Leaves(TreeSpecies) with species is 'ACACIA'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.setSpecies(TreeSpecies)"})
  void testSetSpecies_givenLeavesWithSpeciesIsAcacia_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Leaves(TreeSpecies.ACACIA).setSpecies(TreeSpecies.GENERIC));
  }

  /**
   * Test {@link Wood#setSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>Given {@link Leaves#Leaves()}.
   *   <li>When {@code ACACIA}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#setSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test setSpecies(TreeSpecies); given Leaves(); when 'ACACIA'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.setSpecies(TreeSpecies)"})
  void testSetSpecies_givenLeaves_whenAcacia_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Leaves().setSpecies(TreeSpecies.ACACIA));
  }

  /**
   * Test {@link Wood#setSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>Given {@link WoodenStep#WoodenStep(Material, byte)} with type is {@code ACACIA_BOAT} and
   *       data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Wood#setSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test setSpecies(TreeSpecies); given WoodenStep(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wood.setSpecies(TreeSpecies)"})
  void testSetSpecies_givenWoodenStepWithTypeIsAcaciaBoatAndDataIsA() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new WoodenStep(Material.ACACIA_BOAT, (byte) 'A').setSpecies(TreeSpecies.GENERIC));
  }

  /**
   * Test {@link Wood#clone()}.
   *
   * <p>Method under test: {@link Wood#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Wood Wood.clone()"})
  void testClone() {
    // Arrange
    Wood wood = new Wood();

    // Act
    Wood actualCloneResult = wood.clone();

    // Assert
    assertEquals(wood, actualCloneResult);
  }
}
