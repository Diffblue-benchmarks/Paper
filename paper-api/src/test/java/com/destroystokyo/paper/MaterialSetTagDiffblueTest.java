package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MaterialSetTagDiffblueTest {
  /**
   * Test {@link MaterialSetTag#MaterialSetTag(Predicate)}.
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(Predicate)}
   */
  @Test
  @DisplayName("Test new MaterialSetTag(Predicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(Predicate)"})
  void testNewMaterialSetTag() {
    // Arrange
    Predicate<Material> filter = mock(Predicate.class);
    when(filter.test(Mockito.<Material>any())).thenReturn(true);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(filter);

    // Assert
    verify(filter, atLeast(1)).test(Mockito.<Material>any());
    Set<Material> allPossibleValues = actualMaterialSetTag.getAllPossibleValues();
    assertEquals(2031, allPossibleValues.size());
    assertFalse(actualMaterialSetTag.isLocked());
    assertTrue(allPossibleValues.contains(Material.BROWN_CANDLE));
    assertTrue(allPossibleValues.contains(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS));
    assertTrue(allPossibleValues.contains(Material.LEGACY_CAKE));
    assertTrue(allPossibleValues.contains(Material.LIGHT_BLUE_BANNER));
    assertTrue(allPossibleValues.contains(Material.POTTED_DEAD_BUSH));
    assertTrue(allPossibleValues.contains(Material.WAXED_CUT_COPPER_STAIRS));
    assertEquals(allPossibleValues, actualMaterialSetTag.getValues());
    NamespacedKey key = actualMaterialSetTag.getKey();
    assertEquals(NamespacedTag.BUKKIT, key.getNamespace());
    assertEquals(NamespacedTag.BUKKIT, key.namespace());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(Collection)}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_BOAT}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(Collection)}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(Collection); given 'ACACIA_BOAT'; then return Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(Collection)"})
  void testNewMaterialSetTag_givenAcaciaBoat_thenReturnValuesSizeIsOne() {
    // Arrange
    ArrayList<Material> materials = new ArrayList<>();
    materials.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(materials);

    // Assert
    Set<Material> values = actualMaterialSetTag.getValues();
    assertEquals(1, values.size());
    Set<Material> allPossibleValues = actualMaterialSetTag.getAllPossibleValues();
    assertEquals(2031, allPossibleValues.size());
    assertFalse(actualMaterialSetTag.isLocked());
    assertTrue(allPossibleValues.contains(Material.BROWN_CANDLE));
    assertTrue(allPossibleValues.contains(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS));
    assertTrue(allPossibleValues.contains(Material.LEGACY_CAKE));
    assertTrue(allPossibleValues.contains(Material.LIGHT_BLUE_BANNER));
    assertTrue(allPossibleValues.contains(Material.POTTED_DEAD_BUSH));
    assertTrue(allPossibleValues.contains(Material.WAXED_CUT_COPPER_STAIRS));
    assertTrue(values.contains(Material.ACACIA_BOAT));
    NamespacedKey key = actualMaterialSetTag.getKey();
    assertEquals(NamespacedTag.BUKKIT, key.getNamespace());
    assertEquals(NamespacedTag.BUKKIT, key.namespace());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_BOAT}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Collection); given 'ACACIA_BOAT'; then return Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Collection)"})
  void testNewMaterialSetTag_givenAcaciaBoat_thenReturnValuesSizeIsOne2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ArrayList<Material> materials = new ArrayList<>();
    materials.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(key, materials);

    // Assert
    Set<Material> values = actualMaterialSetTag.getValues();
    assertEquals(1, values.size());
    assertTrue(values.contains(Material.ACACIA_BOAT));
    assertSame(key, actualMaterialSetTag.getKey());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection, Predicate[])}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_BOAT}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection,
   * Predicate[])}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Collection, Predicate[]); given 'ACACIA_BOAT'; then return Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Collection, Predicate[])"})
  void testNewMaterialSetTag_givenAcaciaBoat_thenReturnValuesSizeIsOne3() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ArrayList<Material> materials = new ArrayList<>();
    materials.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(key, materials, mock(Predicate.class));

    // Assert
    Set<Material> values = actualMaterialSetTag.getValues();
    assertEquals(1, values.size());
    assertTrue(values.contains(Material.ACACIA_BOAT));
    assertSame(key, actualMaterialSetTag.getKey());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(Collection)}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_CHEST_BOAT}.
   *   <li>Then return Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(Collection)}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(Collection); given 'ACACIA_CHEST_BOAT'; then return Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(Collection)"})
  void testNewMaterialSetTag_givenAcaciaChestBoat_thenReturnValuesSizeIsTwo() {
    // Arrange
    ArrayList<Material> materials = new ArrayList<>();
    materials.add(Material.ACACIA_CHEST_BOAT);
    materials.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(materials);

    // Assert
    Set<Material> values = actualMaterialSetTag.getValues();
    assertEquals(2, values.size());
    Set<Material> allPossibleValues = actualMaterialSetTag.getAllPossibleValues();
    assertEquals(2031, allPossibleValues.size());
    assertFalse(actualMaterialSetTag.isLocked());
    assertTrue(allPossibleValues.contains(Material.BROWN_CANDLE));
    assertTrue(allPossibleValues.contains(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS));
    assertTrue(allPossibleValues.contains(Material.LEGACY_CAKE));
    assertTrue(allPossibleValues.contains(Material.LIGHT_BLUE_BANNER));
    assertTrue(allPossibleValues.contains(Material.POTTED_DEAD_BUSH));
    assertTrue(allPossibleValues.contains(Material.WAXED_CUT_COPPER_STAIRS));
    assertTrue(values.contains(Material.ACACIA_BOAT));
    assertTrue(values.contains(Material.ACACIA_CHEST_BOAT));
    NamespacedKey key = actualMaterialSetTag.getKey();
    assertEquals(NamespacedTag.BUKKIT, key.getNamespace());
    assertEquals(NamespacedTag.BUKKIT, key.namespace());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_CHEST_BOAT}.
   *   <li>Then return Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Collection); given 'ACACIA_CHEST_BOAT'; then return Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Collection)"})
  void testNewMaterialSetTag_givenAcaciaChestBoat_thenReturnValuesSizeIsTwo2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ArrayList<Material> materials = new ArrayList<>();
    materials.add(Material.ACACIA_CHEST_BOAT);
    materials.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(key, materials);

    // Assert
    Set<Material> values = actualMaterialSetTag.getValues();
    assertEquals(2, values.size());
    assertTrue(values.contains(Material.ACACIA_BOAT));
    assertTrue(values.contains(Material.ACACIA_CHEST_BOAT));
    assertSame(key, actualMaterialSetTag.getKey());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection, Predicate[])}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_CHEST_BOAT}.
   *   <li>Then return Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection,
   * Predicate[])}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Collection, Predicate[]); given 'ACACIA_CHEST_BOAT'; then return Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Collection, Predicate[])"})
  void testNewMaterialSetTag_givenAcaciaChestBoat_thenReturnValuesSizeIsTwo3() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ArrayList<Material> materials = new ArrayList<>();
    materials.add(Material.ACACIA_CHEST_BOAT);
    materials.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(key, materials, mock(Predicate.class));

    // Assert
    Set<Material> values = actualMaterialSetTag.getValues();
    assertEquals(2, values.size());
    assertTrue(values.contains(Material.ACACIA_BOAT));
    assertTrue(values.contains(Material.ACACIA_CHEST_BOAT));
    assertSame(key, actualMaterialSetTag.getKey());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(Material[])}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(Material[])}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(Material[]); when 'ACACIA_BOAT'; then return Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(Material[])"})
  void testNewMaterialSetTag_whenAcaciaBoat_thenReturnValuesSizeIsOne() {
    // Arrange and Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(Material.ACACIA_BOAT);

    // Assert
    Set<Material> values = actualMaterialSetTag.getValues();
    assertEquals(1, values.size());
    Set<Material> allPossibleValues = actualMaterialSetTag.getAllPossibleValues();
    assertEquals(2031, allPossibleValues.size());
    assertFalse(actualMaterialSetTag.isLocked());
    assertTrue(allPossibleValues.contains(Material.BROWN_CANDLE));
    assertTrue(allPossibleValues.contains(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS));
    assertTrue(allPossibleValues.contains(Material.LEGACY_CAKE));
    assertTrue(allPossibleValues.contains(Material.LIGHT_BLUE_BANNER));
    assertTrue(allPossibleValues.contains(Material.POTTED_DEAD_BUSH));
    assertTrue(allPossibleValues.contains(Material.WAXED_CUT_COPPER_STAIRS));
    assertTrue(values.contains(Material.ACACIA_BOAT));
    NamespacedKey key = actualMaterialSetTag.getKey();
    assertEquals(NamespacedTag.BUKKIT, key.getNamespace());
    assertEquals(NamespacedTag.BUKKIT, key.namespace());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(Collection)}
   */
  @Test
  @DisplayName("Test new MaterialSetTag(Collection); when ArrayList(); then return Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(Collection)"})
  void testNewMaterialSetTag_whenArrayList_thenReturnValuesEmpty() {
    // Arrange and Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(new ArrayList<>());

    // Assert
    Set<Material> allPossibleValues = actualMaterialSetTag.getAllPossibleValues();
    assertEquals(2031, allPossibleValues.size());
    assertFalse(actualMaterialSetTag.isLocked());
    assertTrue(allPossibleValues.contains(Material.BROWN_CANDLE));
    assertTrue(allPossibleValues.contains(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS));
    assertTrue(allPossibleValues.contains(Material.LEGACY_CAKE));
    assertTrue(allPossibleValues.contains(Material.LIGHT_BLUE_BANNER));
    assertTrue(allPossibleValues.contains(Material.POTTED_DEAD_BUSH));
    assertTrue(allPossibleValues.contains(Material.WAXED_CUT_COPPER_STAIRS));
    assertTrue(actualMaterialSetTag.getValues().isEmpty());
    NamespacedKey key = actualMaterialSetTag.getKey();
    assertEquals(NamespacedTag.BUKKIT, key.getNamespace());
    assertEquals(NamespacedTag.BUKKIT, key.namespace());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Collection); when ArrayList(); then return Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Collection)"})
  void testNewMaterialSetTag_whenArrayList_thenReturnValuesEmpty2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(key, new ArrayList<>());

    // Assert
    assertTrue(actualMaterialSetTag.getValues().isEmpty());
    assertSame(key, actualMaterialSetTag.getKey());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection, Predicate[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection,
   * Predicate[])}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Collection, Predicate[]); when ArrayList(); then return Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Collection, Predicate[])"})
  void testNewMaterialSetTag_whenArrayList_thenReturnValuesEmpty3() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    MaterialSetTag actualMaterialSetTag =
        new MaterialSetTag(key, new ArrayList<>(), mock(Predicate.class));

    // Assert
    assertTrue(actualMaterialSetTag.getValues().isEmpty());
    assertSame(key, actualMaterialSetTag.getKey());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Key Namespace is {@link NamespacedTag#BUKKIT}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Collection); when 'null'; then return Key Namespace is BUKKIT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Collection)"})
  void testNewMaterialSetTag_whenNull_thenReturnKeyNamespaceIsBukkit() {
    // Arrange and Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(null, new ArrayList<>());

    // Assert
    assertTrue(actualMaterialSetTag.getValues().isEmpty());
    NamespacedKey key = actualMaterialSetTag.getKey();
    assertEquals(NamespacedTag.BUKKIT, key.getNamespace());
    assertEquals(NamespacedTag.BUKKIT, key.namespace());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection, Predicate[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Key Namespace is {@link NamespacedTag#BUKKIT}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Collection,
   * Predicate[])}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Collection, Predicate[]); when 'null'; then return Key Namespace is BUKKIT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Collection, Predicate[])"})
  void testNewMaterialSetTag_whenNull_thenReturnKeyNamespaceIsBukkit2() {
    // Arrange and Act
    MaterialSetTag actualMaterialSetTag =
        new MaterialSetTag(null, new ArrayList<>(), mock(Predicate.class));

    // Assert
    assertTrue(actualMaterialSetTag.getValues().isEmpty());
    NamespacedKey key = actualMaterialSetTag.getKey();
    assertEquals(NamespacedTag.BUKKIT, key.getNamespace());
    assertEquals(NamespacedTag.BUKKIT, key.namespace());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Predicate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Key Namespace is {@link NamespacedTag#BUKKIT}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Predicate); when 'null'; then return Key Namespace is BUKKIT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Predicate)"})
  void testNewMaterialSetTag_whenNull_thenReturnKeyNamespaceIsBukkit3() {
    // Arrange
    Predicate<Material> filter = mock(Predicate.class);
    when(filter.test(Mockito.<Material>any())).thenReturn(true);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(null, filter);

    // Assert
    verify(filter, atLeast(1)).test(Mockito.<Material>any());
    NamespacedKey key = actualMaterialSetTag.getKey();
    assertEquals(NamespacedTag.BUKKIT, key.getNamespace());
    assertEquals(NamespacedTag.BUKKIT, key.namespace());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Predicate)}.
   *
   * <ul>
   *   <li>When randomKey.
   *   <li>Then return Key is randomKey.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Predicate); when randomKey; then return Key is randomKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Predicate)"})
  void testNewMaterialSetTag_whenRandomKey_thenReturnKeyIsRandomKey() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    Predicate<Material> filter = mock(Predicate.class);
    when(filter.test(Mockito.<Material>any())).thenReturn(true);

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(key, filter);

    // Assert
    verify(filter, atLeast(1)).test(Mockito.<Material>any());
    assertSame(key, actualMaterialSetTag.getKey());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Material[])}.
   *
   * <ul>
   *   <li>When randomKey.
   *   <li>Then return Key is randomKey.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#MaterialSetTag(NamespacedKey, Material[])}
   */
  @Test
  @DisplayName(
      "Test new MaterialSetTag(NamespacedKey, Material[]); when randomKey; then return Key is randomKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaterialSetTag.<init>(NamespacedKey, Material[])"})
  void testNewMaterialSetTag_whenRandomKey_thenReturnKeyIsRandomKey2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    MaterialSetTag actualMaterialSetTag = new MaterialSetTag(key, Material.ACACIA_BOAT);

    // Assert
    Set<Material> values = actualMaterialSetTag.getValues();
    assertEquals(1, values.size());
    Set<Material> allPossibleValues = actualMaterialSetTag.getAllPossibleValues();
    assertEquals(2031, allPossibleValues.size());
    assertFalse(actualMaterialSetTag.isLocked());
    assertTrue(allPossibleValues.contains(Material.BROWN_CANDLE));
    assertTrue(allPossibleValues.contains(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS));
    assertTrue(allPossibleValues.contains(Material.LEGACY_CAKE));
    assertTrue(allPossibleValues.contains(Material.LIGHT_BLUE_BANNER));
    assertTrue(allPossibleValues.contains(Material.POTTED_DEAD_BUSH));
    assertTrue(allPossibleValues.contains(Material.WAXED_CUT_COPPER_STAIRS));
    assertTrue(values.contains(Material.ACACIA_BOAT));
    assertSame(key, actualMaterialSetTag.getKey());
    assertSame(key, actualMaterialSetTag.key());
  }

  /**
   * Test {@link MaterialSetTag#getAllPossibleValues()}.
   *
   * <p>Method under test: {@link MaterialSetTag#getAllPossibleValues()}
   */
  @Test
  @DisplayName("Test getAllPossibleValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MaterialSetTag.getAllPossibleValues()"})
  void testGetAllPossibleValues() {
    // Arrange and Act
    Set<Material> actualAllPossibleValues =
        new MaterialSetTag(new ArrayList<>()).getAllPossibleValues();

    // Assert
    assertEquals(2031, actualAllPossibleValues.size());
    assertTrue(actualAllPossibleValues.contains(Material.BROWN_CANDLE));
    assertTrue(actualAllPossibleValues.contains(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS));
    assertTrue(actualAllPossibleValues.contains(Material.CYAN_TERRACOTTA));
    assertTrue(actualAllPossibleValues.contains(Material.DARK_OAK_BUTTON));
    assertTrue(actualAllPossibleValues.contains(Material.LEGACY_CAKE));
    assertTrue(actualAllPossibleValues.contains(Material.LIGHT_BLUE_BANNER));
    assertTrue(actualAllPossibleValues.contains(Material.POTTED_DEAD_BUSH));
    assertTrue(actualAllPossibleValues.contains(Material.SPRUCE_BUTTON));
    assertTrue(actualAllPossibleValues.contains(Material.VERDANT_FROGLIGHT));
    assertTrue(actualAllPossibleValues.contains(Material.WARPED_STEM));
    assertTrue(actualAllPossibleValues.contains(Material.WAXED_CUT_COPPER_STAIRS));
  }

  /**
   * Test {@link MaterialSetTag#getName(Material)} with {@code value}.
   *
   * <p>Method under test: {@link MaterialSetTag#getName(Material)}
   */
  @Test
  @DisplayName("Test getName(Material) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String MaterialSetTag.getName(Material)"})
  void testGetNameWithValue() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT", new MaterialSetTag(new ArrayList<>()).getName(Material.ACACIA_BOAT));
  }

  /**
   * Test {@link MaterialSetTag#isTagged(BlockData)} with {@code BlockData}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(BlockData)}
   */
  @Test
  @DisplayName("Test isTagged(BlockData) with 'BlockData'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(BlockData)"})
  void testIsTaggedWithBlockData_thenReturnFalse() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    BlockData block = mock(BlockData.class);
    when(block.getMaterial()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsTaggedResult = materialSetTag.isTagged(block);

    // Assert
    verify(block).getMaterial();
    assertFalse(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(BlockData)} with {@code BlockData}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(BlockData)}
   */
  @Test
  @DisplayName("Test isTagged(BlockData) with 'BlockData'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(BlockData)"})
  void testIsTaggedWithBlockData_thenReturnTrue() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(Material.ACACIA_BOAT);

    BlockData block = mock(BlockData.class);
    when(block.getMaterial()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsTaggedResult = materialSetTag.isTagged(block);

    // Assert
    verify(block).getMaterial();
    assertTrue(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(BlockState)} with {@code BlockState}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(BlockState)}
   */
  @Test
  @DisplayName("Test isTagged(BlockState) with 'BlockState'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(BlockState)"})
  void testIsTaggedWithBlockState_thenReturnFalse() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    BlockState block = mock(BlockState.class);
    when(block.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsTaggedResult = materialSetTag.isTagged(block);

    // Assert
    verify(block).getType();
    assertFalse(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(BlockState)} with {@code BlockState}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(BlockState)}
   */
  @Test
  @DisplayName("Test isTagged(BlockState) with 'BlockState'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(BlockState)"})
  void testIsTaggedWithBlockState_thenReturnTrue() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(Material.ACACIA_BOAT);

    BlockState block = mock(BlockState.class);
    when(block.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsTaggedResult = materialSetTag.isTagged(block);

    // Assert
    verify(block).getType();
    assertTrue(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(Block)} with {@code Block}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(Block)}
   */
  @Test
  @DisplayName("Test isTagged(Block) with 'Block'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(Block)"})
  void testIsTaggedWithBlock_thenReturnFalse() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    Block block = mock(Block.class);
    when(block.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsTaggedResult = materialSetTag.isTagged(block);

    // Assert
    verify(block).getType();
    assertFalse(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(Block)} with {@code Block}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(Block)}
   */
  @Test
  @DisplayName("Test isTagged(Block) with 'Block'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(Block)"})
  void testIsTaggedWithBlock_thenReturnTrue() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(Material.ACACIA_BOAT);

    Block block = mock(Block.class);
    when(block.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsTaggedResult = materialSetTag.isTagged(block);

    // Assert
    verify(block).getType();
    assertTrue(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(ItemStack)} with {@code ItemStack}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(ItemStack)}
   */
  @Test
  @DisplayName("Test isTagged(ItemStack) with 'ItemStack'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(ItemStack)"})
  void testIsTaggedWithItemStack_thenReturnFalse() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    ItemStack item = mock(ItemStack.class);
    when(item.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsTaggedResult = materialSetTag.isTagged(item);

    // Assert
    verify(item).getType();
    assertFalse(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(ItemStack)} with {@code ItemStack}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(ItemStack)}
   */
  @Test
  @DisplayName("Test isTagged(ItemStack) with 'ItemStack'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(ItemStack)"})
  void testIsTaggedWithItemStack_thenReturnTrue() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(Material.ACACIA_BOAT);

    ItemStack item = mock(ItemStack.class);
    when(item.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    boolean actualIsTaggedResult = materialSetTag.isTagged(item);

    // Assert
    verify(item).getType();
    assertTrue(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(Material)} with {@code Material}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(Material)}
   */
  @Test
  @DisplayName(
      "Test isTagged(Material) with 'Material'; given Predicate test(Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(Material)"})
  void testIsTaggedWithMaterial_givenPredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    Predicate<Material> filter = mock(Predicate.class);
    when(filter.test(Mockito.<Material>any())).thenReturn(true);

    // Act
    boolean actualIsTaggedResult = new MaterialSetTag(filter).isTagged(Material.ACACIA_BOAT);

    // Assert
    verify(filter, atLeast(1)).test(Mockito.<Material>any());
    assertTrue(actualIsTaggedResult);
  }

  /**
   * Test {@link MaterialSetTag#isTagged(Material)} with {@code Material}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MaterialSetTag#isTagged(Material)}
   */
  @Test
  @DisplayName("Test isTagged(Material) with 'Material'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialSetTag.isTagged(Material)"})
  void testIsTaggedWithMaterial_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MaterialSetTag(new ArrayList<>()).isTagged(Material.ACACIA_BOAT));
  }
}
