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

class LeavesDiffblueTest {
  /**
   * Test {@link Leaves#Leaves(Material, byte)}.
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, byte)}
   */
  @Test
  @DisplayName("Test new Leaves(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, byte)"})
  void testNewLeaves() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualLeaves.getItemType());
    assertEquals('A', actualLeaves.getData());
  }

  /**
   * Test {@link Leaves#Leaves()}.
   *
   * <p>Method under test: {@link Leaves#Leaves()}
   */
  @Test
  @DisplayName("Test new Leaves()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>()"})
  void testNewLeaves2() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves();

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material)}
   */
  @Test
  @DisplayName("Test new Leaves(Material); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material)"})
  void testNewLeaves_whenAcaciaBoat_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Leaves(Material.ACACIA_BOAT));
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies)"})
  void testNewLeaves_whenAcaciaBoat_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Leaves(Material.ACACIA_BOAT, TreeSpecies.GENERIC));
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies, boolean); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies, boolean)"})
  void testNewLeaves_whenAcaciaBoat_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Leaves(Material.ACACIA_BOAT, TreeSpecies.GENERIC, true));
  }

  /**
   * Test {@link Leaves#Leaves(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES_2}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(TreeSpecies); when 'ACACIA'; then return ItemType is 'LEGACY_LEAVES_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(TreeSpecies)"})
  void testNewLeaves_whenAcacia_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES_2, actualLeaves.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES_2}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(TreeSpecies, boolean); when 'ACACIA'; then return ItemType is 'LEGACY_LEAVES_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(TreeSpecies, boolean)"})
  void testNewLeaves_whenAcacia_thenReturnItemTypeIsLegacyLeaves22() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 4, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES_2, actualLeaves.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName("Test new Leaves(TreeSpecies, boolean); when 'GENERIC'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(TreeSpecies, boolean)"})
  void testNewLeaves_whenGeneric_thenReturnDataIsFour() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(TreeSpecies.GENERIC, false);

    // Assert
    assertEquals((byte) 4, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(TreeSpecies); when 'GENERIC'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(TreeSpecies)"})
  void testNewLeaves_whenGeneric_thenReturnItemTypeIsLegacyLeaves() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material)"})
  void testNewLeaves_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LEAVES_2);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies)"})
  void testNewLeaves_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LEAVES_2, TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies, boolean); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies, boolean)"})
  void testNewLeaves_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves3() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LEAVES_2, TreeSpecies.GENERIC, false);

    // Assert
    assertEquals((byte) 4, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES_2}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies); when 'LEGACY_LEAVES'; then return ItemType is 'LEGACY_LEAVES_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies)"})
  void testNewLeaves_whenLegacyLeaves_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LEAVES, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES_2, actualLeaves.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES_2}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies, boolean); when 'LEGACY_LEAVES'; then return ItemType is 'LEGACY_LEAVES_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies, boolean)"})
  void testNewLeaves_whenLegacyLeaves_thenReturnItemTypeIsLegacyLeaves22() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LEAVES, TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 4, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES_2, actualLeaves.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material)"})
  void testNewLeaves_whenLegacyLog2_thenReturnItemTypeIsLegacyLog() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LOG_2);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LOG, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies)"})
  void testNewLeaves_whenLegacyLog2_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LOG_2, TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LOG, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies, boolean); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies, boolean)"})
  void testNewLeaves_whenLegacyLog2_thenReturnItemTypeIsLegacyLog3() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LOG_2, TreeSpecies.GENERIC, false);

    // Assert
    assertEquals((byte) 4, actualLeaves.getData());
    assertEquals(Material.LEGACY_LOG, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies)"})
  void testNewLeaves_whenLegacyLog2_thenReturnItemTypeIsLegacyLog22() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LOG_2, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LOG_2, actualLeaves.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies, boolean); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies, boolean)"})
  void testNewLeaves_whenLegacyLog2_thenReturnItemTypeIsLegacyLog23() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LOG_2, TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 4, actualLeaves.getData());
    assertEquals(Material.LEGACY_LOG_2, actualLeaves.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies); when 'LEGACY_LOG'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies)"})
  void testNewLeaves_whenLegacyLog_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LOG, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LOG_2, actualLeaves.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecaying());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies, boolean); when 'LEGACY_LOG'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies, boolean)"})
  void testNewLeaves_whenLegacyLog_thenReturnItemTypeIsLegacyLog22() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LOG, TreeSpecies.ACACIA, false);

    // Assert
    assertEquals((byte) 4, actualLeaves.getData());
    assertEquals(Material.LEGACY_LOG_2, actualLeaves.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualLeaves.getSpecies());
    assertFalse(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(Material, TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(Material, TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Leaves(Material, TreeSpecies, boolean); when 'true'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(Material, TreeSpecies, boolean)"})
  void testNewLeaves_whenTrue_thenReturnDataIsZero() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(Material.LEGACY_LOG_2, TreeSpecies.GENERIC, true);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LOG, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#Leaves(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#Leaves(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName("Test new Leaves(TreeSpecies, boolean); when 'true'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.<init>(TreeSpecies, boolean)"})
  void testNewLeaves_whenTrue_thenReturnDataIsZero2() {
    // Arrange and Act
    Leaves actualLeaves = new Leaves(TreeSpecies.GENERIC, true);

    // Assert
    assertEquals((byte) 0, actualLeaves.getData());
    assertEquals(Material.LEGACY_LEAVES, actualLeaves.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualLeaves.getSpecies());
    assertTrue(actualLeaves.isDecayable());
  }

  /**
   * Test {@link Leaves#isDecaying()}.
   *
   * <ul>
   *   <li>Given {@link Leaves#Leaves()} Data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#isDecaying()}
   */
  @Test
  @DisplayName("Test isDecaying(); given Leaves() Data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Leaves.isDecaying()"})
  void testIsDecaying_givenLeavesDataIsX_thenReturnTrue() {
    // Arrange
    Leaves leaves = new Leaves();
    leaves.setData((byte) 'X');

    // Act and Assert
    assertTrue(leaves.isDecaying());
  }

  /**
   * Test {@link Leaves#isDecaying()}.
   *
   * <ul>
   *   <li>Given {@link Leaves#Leaves()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#isDecaying()}
   */
  @Test
  @DisplayName("Test isDecaying(); given Leaves(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Leaves.isDecaying()"})
  void testIsDecaying_givenLeaves_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Leaves().isDecaying());
  }

  /**
   * Test {@link Leaves#setDecaying(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Leaves#Leaves()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#setDecaying(boolean)}
   */
  @Test
  @DisplayName("Test setDecaying(boolean); when 'false'; then Leaves() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.setDecaying(boolean)"})
  void testSetDecaying_whenFalse_thenLeavesDataIsZero() {
    // Arrange
    Leaves leaves = new Leaves();

    // Act
    leaves.setDecaying(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, leaves.getData());
    assertFalse(leaves.isDecaying());
  }

  /**
   * Test {@link Leaves#setDecaying(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Leaves#Leaves()} Decaying.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#setDecaying(boolean)}
   */
  @Test
  @DisplayName("Test setDecaying(boolean); when 'true'; then Leaves() Decaying")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.setDecaying(boolean)"})
  void testSetDecaying_whenTrue_thenLeavesDecaying() {
    // Arrange
    Leaves leaves = new Leaves();

    // Act
    leaves.setDecaying(true);

    // Assert
    assertTrue(leaves.isDecaying());
    assertEquals('\b', leaves.getData());
  }

  /**
   * Test {@link Leaves#isDecayable()}.
   *
   * <ul>
   *   <li>Given {@link Leaves#Leaves()} Data is minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#isDecayable()}
   */
  @Test
  @DisplayName("Test isDecayable(); given Leaves() Data is minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Leaves.isDecayable()"})
  void testIsDecayable_givenLeavesDataIsMinusOne_thenReturnFalse() {
    // Arrange
    Leaves leaves = new Leaves();
    leaves.setData((byte) -1);

    // Act and Assert
    assertFalse(leaves.isDecayable());
  }

  /**
   * Test {@link Leaves#isDecayable()}.
   *
   * <ul>
   *   <li>Given {@link Leaves#Leaves()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#isDecayable()}
   */
  @Test
  @DisplayName("Test isDecayable(); given Leaves(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Leaves.isDecayable()"})
  void testIsDecayable_givenLeaves_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Leaves().isDecayable());
  }

  /**
   * Test {@link Leaves#setDecayable(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Leaves#Leaves()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#setDecayable(boolean)}
   */
  @Test
  @DisplayName("Test setDecayable(boolean); when 'false'; then Leaves() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.setDecayable(boolean)"})
  void testSetDecayable_whenFalse_thenLeavesDataIsFour() {
    // Arrange
    Leaves leaves = new Leaves();

    // Act
    leaves.setDecayable(false);

    // Assert
    assertEquals((byte) 4, leaves.getData());
    assertFalse(leaves.isDecayable());
  }

  /**
   * Test {@link Leaves#setDecayable(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Leaves#Leaves()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#setDecayable(boolean)}
   */
  @Test
  @DisplayName("Test setDecayable(boolean); when 'true'; then Leaves() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Leaves.setDecayable(boolean)"})
  void testSetDecayable_whenTrue_thenLeavesDataIsZero() {
    // Arrange
    Leaves leaves = new Leaves();

    // Act
    leaves.setDecayable(true);

    // Assert that nothing has changed
    assertEquals((byte) 0, leaves.getData());
    assertTrue(leaves.isDecayable());
  }

  /**
   * Test {@link Leaves#toString()}.
   *
   * <ul>
   *   <li>Given {@link Leaves#Leaves()}.
   *   <li>Then return {@code GENERIC DECAYABLE GENERIC LEGACY_LEAVES(0)}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Leaves(); then return 'GENERIC DECAYABLE GENERIC LEGACY_LEAVES(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Leaves.toString()"})
  void testToString_givenLeaves_thenReturnGenericDecayableGenericLegacyLeaves0() {
    // Arrange, Act and Assert
    assertEquals("GENERIC DECAYABLE  GENERIC LEGACY_LEAVES(0)", new Leaves().toString());
  }

  /**
   * Test {@link Leaves#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA DECAYABLE ACACIA LEGACY_LEAVES_2(0)}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA DECAYABLE ACACIA LEGACY_LEAVES_2(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Leaves.toString()"})
  void testToString_thenReturnAcaciaDecayableAcaciaLegacyLeaves20() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA DECAYABLE  ACACIA LEGACY_LEAVES_2(0)", new Leaves(TreeSpecies.ACACIA).toString());
  }

  /**
   * Test {@link Leaves#toString()}.
   *
   * <ul>
   *   <li>Then return {@code GENERIC DECAYABLE DECAYING GENERIC LEGACY_LEAVES(88)}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'GENERIC DECAYABLE DECAYING GENERIC LEGACY_LEAVES(88)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Leaves.toString()"})
  void testToString_thenReturnGenericDecayableDecayingGenericLegacyLeaves88() {
    // Arrange
    Leaves leaves = new Leaves();
    leaves.setData((byte) 'X');

    // Act and Assert
    assertEquals("GENERIC DECAYABLE  DECAYING GENERIC LEGACY_LEAVES(88)", leaves.toString());
  }

  /**
   * Test {@link Leaves#toString()}.
   *
   * <ul>
   *   <li>Then return {@code JUNGLE PERMANENT DECAYING JUNGLE LEGACY_LEAVES(-1)}.
   * </ul>
   *
   * <p>Method under test: {@link Leaves#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'JUNGLE PERMANENT DECAYING JUNGLE LEGACY_LEAVES(-1)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Leaves.toString()"})
  void testToString_thenReturnJunglePermanentDecayingJungleLegacyLeaves1() {
    // Arrange
    Leaves leaves = new Leaves();
    leaves.setData((byte) -1);

    // Act and Assert
    assertEquals("JUNGLE PERMANENT  DECAYING JUNGLE LEGACY_LEAVES(-1)", leaves.toString());
  }

  /**
   * Test {@link Leaves#clone()}.
   *
   * <p>Method under test: {@link Leaves#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Leaves Leaves.clone()"})
  void testClone() {
    // Arrange
    Leaves leaves = new Leaves();

    // Act
    Leaves actualCloneResult = leaves.clone();

    // Assert
    assertEquals(leaves, actualCloneResult);
  }
}
