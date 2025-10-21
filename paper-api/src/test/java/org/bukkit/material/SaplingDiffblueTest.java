package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SaplingDiffblueTest {
  /**
   * Test {@link Sapling#Sapling(Material, byte)}.
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, byte)}
   */
  @Test
  @DisplayName("Test new Sapling(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, byte)"})
  void testNewSapling() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualSapling.getItemType());
    assertEquals('A', actualSapling.getData());
  }

  /**
   * Test {@link Sapling#Sapling()}.
   *
   * <p>Method under test: {@link Sapling#Sapling()}
   */
  @Test
  @DisplayName("Test new Sapling()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>()"})
  void testNewSapling2() {
    // Arrange and Act
    Sapling actualSapling = new Sapling();

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_SAPLING, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material)"})
  void testNewSapling_whenAcaciaBoat_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Sapling(Material.ACACIA_BOAT));
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies)"})
  void testNewSapling_whenAcaciaBoat_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Sapling(Material.ACACIA_BOAT, TreeSpecies.GENERIC));
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies, boolean); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies, boolean)"})
  void testNewSapling_whenAcaciaBoat_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Sapling(Material.ACACIA_BOAT, TreeSpecies.GENERIC, true));
  }

  /**
   * Test {@link Sapling#Sapling(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(TreeSpecies)}
   */
  @Test
  @DisplayName("Test new Sapling(TreeSpecies); when 'ACACIA'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(TreeSpecies)"})
  void testNewSapling_whenAcacia_thenReturnDataIsFour() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 4, actualSapling.getData());
    assertEquals(Material.LEGACY_SAPLING, actualSapling.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName("Test new Sapling(TreeSpecies, boolean); when 'ACACIA'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(TreeSpecies, boolean)"})
  void testNewSapling_whenAcacia_thenReturnDataIsFour2() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 4, actualSapling.getData());
    assertEquals(Material.LEGACY_SAPLING, actualSapling.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(TreeSpecies)}
   */
  @Test
  @DisplayName("Test new Sapling(TreeSpecies); when 'GENERIC'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(TreeSpecies)"})
  void testNewSapling_whenGeneric_thenReturnDataIsZero() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_SAPLING, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName("Test new Sapling(TreeSpecies, boolean); when 'GENERIC'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(TreeSpecies, boolean)"})
  void testNewSapling_whenGeneric_thenReturnDataIsZero2() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(TreeSpecies.GENERIC, false);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_SAPLING, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material)"})
  void testNewSapling_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LEAVES_2);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LEAVES, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies)"})
  void testNewSapling_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LEAVES_2, TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LEAVES, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies, boolean); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies, boolean)"})
  void testNewSapling_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves3() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LEAVES_2, TreeSpecies.GENERIC, false);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LEAVES, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES_2}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies); when 'LEGACY_LEAVES'; then return ItemType is 'LEGACY_LEAVES_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies)"})
  void testNewSapling_whenLegacyLeaves_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LEAVES, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LEAVES_2, actualSapling.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES_2}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies, boolean); when 'LEGACY_LEAVES'; then return ItemType is 'LEGACY_LEAVES_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies, boolean)"})
  void testNewSapling_whenLegacyLeaves_thenReturnItemTypeIsLegacyLeaves22() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LEAVES, TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LEAVES_2, actualSapling.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material)"})
  void testNewSapling_whenLegacyLog2_thenReturnItemTypeIsLegacyLog() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LOG_2);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LOG, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies)"})
  void testNewSapling_whenLegacyLog2_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LOG_2, TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LOG, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies, boolean); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies, boolean)"})
  void testNewSapling_whenLegacyLog2_thenReturnItemTypeIsLegacyLog3() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LOG_2, TreeSpecies.GENERIC, false);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LOG, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies)"})
  void testNewSapling_whenLegacyLog2_thenReturnItemTypeIsLegacyLog22() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LOG_2, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LOG_2, actualSapling.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies, boolean); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies, boolean)"})
  void testNewSapling_whenLegacyLog2_thenReturnItemTypeIsLegacyLog23() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LOG_2, TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LOG_2, actualSapling.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies); when 'LEGACY_LOG'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies)"})
  void testNewSapling_whenLegacyLog_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LOG, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LOG_2, actualSapling.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies, boolean); when 'LEGACY_LOG'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies, boolean)"})
  void testNewSapling_whenLegacyLog_thenReturnItemTypeIsLegacyLog22() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LOG, TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 0, actualSapling.getData());
    assertEquals(Material.LEGACY_LOG_2, actualSapling.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualSapling.getSpecies());
    assertFalse(actualSapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#Sapling(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return InstantGrowable.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Sapling(Material, TreeSpecies, boolean); when 'true'; then return InstantGrowable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(Material, TreeSpecies, boolean)"})
  void testNewSapling_whenTrue_thenReturnInstantGrowable() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(Material.LEGACY_LOG_2, TreeSpecies.GENERIC, true);

    // Assert
    assertEquals(Material.LEGACY_LOG, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertTrue(actualSapling.isInstantGrowable());
    assertEquals('\b', actualSapling.getData());
  }

  /**
   * Test {@link Sapling#Sapling(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return InstantGrowable.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#Sapling(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName("Test new Sapling(TreeSpecies, boolean); when 'true'; then return InstantGrowable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.<init>(TreeSpecies, boolean)"})
  void testNewSapling_whenTrue_thenReturnInstantGrowable2() {
    // Arrange and Act
    Sapling actualSapling = new Sapling(TreeSpecies.GENERIC, true);

    // Assert
    assertEquals(Material.LEGACY_SAPLING, actualSapling.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualSapling.getSpecies());
    assertTrue(actualSapling.isInstantGrowable());
    assertEquals('\b', actualSapling.getData());
  }

  /**
   * Test {@link Sapling#isInstantGrowable()}.
   *
   * <ul>
   *   <li>Given {@link Sapling#Sapling()} Data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#isInstantGrowable()}
   */
  @Test
  @DisplayName("Test isInstantGrowable(); given Sapling() Data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sapling.isInstantGrowable()"})
  void testIsInstantGrowable_givenSaplingDataIsX_thenReturnTrue() {
    // Arrange
    Sapling sapling = new Sapling();
    sapling.setData((byte) 'X');

    // Act and Assert
    assertTrue(sapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#isInstantGrowable()}.
   *
   * <ul>
   *   <li>Given {@link Sapling#Sapling()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#isInstantGrowable()}
   */
  @Test
  @DisplayName("Test isInstantGrowable(); given Sapling(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sapling.isInstantGrowable()"})
  void testIsInstantGrowable_givenSapling_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Sapling().isInstantGrowable());
  }

  /**
   * Test {@link Sapling#setIsInstantGrowable(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Sapling#Sapling()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#setIsInstantGrowable(boolean)}
   */
  @Test
  @DisplayName("Test setIsInstantGrowable(boolean); when 'false'; then Sapling() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.setIsInstantGrowable(boolean)"})
  void testSetIsInstantGrowable_whenFalse_thenSaplingDataIsZero() {
    // Arrange
    Sapling sapling = new Sapling();

    // Act
    sapling.setIsInstantGrowable(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, sapling.getData());
    assertFalse(sapling.isInstantGrowable());
  }

  /**
   * Test {@link Sapling#setIsInstantGrowable(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Sapling#Sapling()} InstantGrowable.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#setIsInstantGrowable(boolean)}
   */
  @Test
  @DisplayName("Test setIsInstantGrowable(boolean); when 'true'; then Sapling() InstantGrowable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sapling.setIsInstantGrowable(boolean)"})
  void testSetIsInstantGrowable_whenTrue_thenSaplingInstantGrowable() {
    // Arrange
    Sapling sapling = new Sapling();

    // Act
    sapling.setIsInstantGrowable(true);

    // Assert
    assertTrue(sapling.isInstantGrowable());
    assertEquals('\b', sapling.getData());
  }

  /**
   * Test {@link Sapling#toString()}.
   *
   * <ul>
   *   <li>Given {@link Sapling#Sapling(Material)} with type is {@code LEGACY_LOG_2}.
   *   <li>Then return {@code GENERIC GENERIC LEGACY_LOG(0)}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Sapling(Material) with type is 'LEGACY_LOG_2'; then return 'GENERIC GENERIC LEGACY_LOG(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Sapling.toString()"})
  void testToString_givenSaplingWithTypeIsLegacyLog2_thenReturnGenericGenericLegacyLog0() {
    // Arrange, Act and Assert
    assertEquals("GENERIC  GENERIC LEGACY_LOG(0)", new Sapling(Material.LEGACY_LOG_2).toString());
  }

  /**
   * Test {@link Sapling#toString()}.
   *
   * <ul>
   *   <li>Given {@link Sapling#Sapling()}.
   *   <li>Then return {@code GENERIC GENERIC LEGACY_SAPLING(0)}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Sapling(); then return 'GENERIC GENERIC LEGACY_SAPLING(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Sapling.toString()"})
  void testToString_givenSapling_thenReturnGenericGenericLegacySapling0() {
    // Arrange, Act and Assert
    assertEquals("GENERIC  GENERIC LEGACY_SAPLING(0)", new Sapling().toString());
  }

  /**
   * Test {@link Sapling#toString()}.
   *
   * <ul>
   *   <li>Then return {@code GENERIC IS_INSTANT_GROWABLE GENERIC LEGACY_SAPLING(88)}.
   * </ul>
   *
   * <p>Method under test: {@link Sapling#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'GENERIC IS_INSTANT_GROWABLE GENERIC LEGACY_SAPLING(88)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Sapling.toString()"})
  void testToString_thenReturnGenericIsInstantGrowableGenericLegacySapling88() {
    // Arrange
    Sapling sapling = new Sapling();
    sapling.setData((byte) 'X');

    // Act and Assert
    assertEquals("GENERIC  IS_INSTANT_GROWABLE  GENERIC LEGACY_SAPLING(88)", sapling.toString());
  }

  /**
   * Test {@link Sapling#clone()}.
   *
   * <p>Method under test: {@link Sapling#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sapling Sapling.clone()"})
  void testClone() {
    // Arrange
    Sapling sapling = new Sapling();

    // Act
    Sapling actualCloneResult = sapling.clone();

    // Assert
    assertEquals(sapling, actualCloneResult);
  }
}
