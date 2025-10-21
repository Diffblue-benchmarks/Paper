package io.papermc.paper.tag;

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
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntitySetTagDiffblueTest {
  /**
   * Test {@link EntitySetTag#EntitySetTag(NamespacedKey, Predicate)}.
   *
   * <p>Method under test: {@link EntitySetTag#EntitySetTag(NamespacedKey, Predicate)}
   */
  @Test
  @DisplayName("Test new EntitySetTag(NamespacedKey, Predicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySetTag.<init>(NamespacedKey, Predicate)"})
  void testNewEntitySetTag() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    Predicate<EntityType> filter = mock(Predicate.class);
    when(filter.test(Mockito.<EntityType>any())).thenReturn(true);

    // Act
    EntitySetTag actualEntitySetTag = new EntitySetTag(key, filter);

    // Assert
    verify(filter, atLeast(1)).test(Mockito.<EntityType>any());
    assertEquals(152, actualEntitySetTag.tagged.size());
    assertFalse(actualEntitySetTag.isLocked());
    Set<EntityType> entityTypeSet = actualEntitySetTag.tagged;
    assertEquals(entityTypeSet, actualEntitySetTag.getValues());
    assertEquals(entityTypeSet, actualEntitySetTag.getAllPossibleValues());
    assertSame(key, actualEntitySetTag.getKey());
    assertSame(key, actualEntitySetTag.key());
  }

  /**
   * Test {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_BOAT}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test new EntitySetTag(NamespacedKey, Collection); given 'ACACIA_BOAT'; then return Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySetTag.<init>(NamespacedKey, Collection)"})
  void testNewEntitySetTag_givenAcaciaBoat_thenReturnValuesSizeIsOne() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ArrayList<EntityType> values = new ArrayList<>();
    values.add(EntityType.ACACIA_BOAT);

    // Act
    EntitySetTag actualEntitySetTag = new EntitySetTag(key, values);

    // Assert
    Set<EntityType> values2 = actualEntitySetTag.getValues();
    assertEquals(1, values2.size());
    Set<EntityType> entityTypeSet = actualEntitySetTag.tagged;
    assertEquals(1, entityTypeSet.size());
    assertTrue(values2.contains(EntityType.ACACIA_BOAT));
    assertTrue(entityTypeSet.contains(EntityType.ACACIA_BOAT));
  }

  /**
   * Test {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection, Predicate[])}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_BOAT}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection, Predicate[])}
   */
  @Test
  @DisplayName(
      "Test new EntitySetTag(NamespacedKey, Collection, Predicate[]); given 'ACACIA_BOAT'; then return Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySetTag.<init>(NamespacedKey, Collection, Predicate[])"})
  void testNewEntitySetTag_givenAcaciaBoat_thenReturnValuesSizeIsOne2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ArrayList<EntityType> values = new ArrayList<>();
    values.add(EntityType.ACACIA_BOAT);

    // Act
    EntitySetTag actualEntitySetTag = new EntitySetTag(key, values, mock(Predicate.class));

    // Assert
    Set<EntityType> values2 = actualEntitySetTag.getValues();
    assertEquals(1, values2.size());
    Set<EntityType> entityTypeSet = actualEntitySetTag.tagged;
    assertEquals(1, entityTypeSet.size());
    assertTrue(values2.contains(EntityType.ACACIA_BOAT));
    assertTrue(entityTypeSet.contains(EntityType.ACACIA_BOAT));
  }

  /**
   * Test {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection)}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_CHEST_BOAT}.
   *   <li>Then return Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test new EntitySetTag(NamespacedKey, Collection); given 'ACACIA_CHEST_BOAT'; then return Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySetTag.<init>(NamespacedKey, Collection)"})
  void testNewEntitySetTag_givenAcaciaChestBoat_thenReturnValuesSizeIsTwo() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ArrayList<EntityType> values = new ArrayList<>();
    values.add(EntityType.ACACIA_CHEST_BOAT);
    values.add(EntityType.ACACIA_BOAT);

    // Act
    EntitySetTag actualEntitySetTag = new EntitySetTag(key, values);

    // Assert
    Set<EntityType> values2 = actualEntitySetTag.getValues();
    assertEquals(2, values2.size());
    Set<EntityType> entityTypeSet = actualEntitySetTag.tagged;
    assertEquals(2, entityTypeSet.size());
    assertTrue(values2.contains(EntityType.ACACIA_CHEST_BOAT));
    assertTrue(entityTypeSet.contains(EntityType.ACACIA_CHEST_BOAT));
  }

  /**
   * Test {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection, Predicate[])}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_CHEST_BOAT}.
   *   <li>Then return Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection, Predicate[])}
   */
  @Test
  @DisplayName(
      "Test new EntitySetTag(NamespacedKey, Collection, Predicate[]); given 'ACACIA_CHEST_BOAT'; then return Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySetTag.<init>(NamespacedKey, Collection, Predicate[])"})
  void testNewEntitySetTag_givenAcaciaChestBoat_thenReturnValuesSizeIsTwo2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ArrayList<EntityType> values = new ArrayList<>();
    values.add(EntityType.ACACIA_CHEST_BOAT);
    values.add(EntityType.ACACIA_BOAT);

    // Act
    EntitySetTag actualEntitySetTag = new EntitySetTag(key, values, mock(Predicate.class));

    // Assert
    Set<EntityType> values2 = actualEntitySetTag.getValues();
    assertEquals(2, values2.size());
    Set<EntityType> entityTypeSet = actualEntitySetTag.tagged;
    assertEquals(2, entityTypeSet.size());
    assertTrue(values2.contains(EntityType.ACACIA_CHEST_BOAT));
    assertTrue(entityTypeSet.contains(EntityType.ACACIA_CHEST_BOAT));
  }

  /**
   * Test {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection)}.
   *
   * <ul>
   *   <li>Then return AllPossibleValues size is one hundred fifty-two.
   * </ul>
   *
   * <p>Method under test: {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection)}
   */
  @Test
  @DisplayName(
      "Test new EntitySetTag(NamespacedKey, Collection); then return AllPossibleValues size is one hundred fifty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySetTag.<init>(NamespacedKey, Collection)"})
  void testNewEntitySetTag_thenReturnAllPossibleValuesSizeIsOneHundredFiftyTwo() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    EntitySetTag actualEntitySetTag = new EntitySetTag(key, new ArrayList<>());

    // Assert
    Set<EntityType> allPossibleValues = actualEntitySetTag.getAllPossibleValues();
    assertEquals(152, allPossibleValues.size());
    assertFalse(actualEntitySetTag.isLocked());
    assertTrue(allPossibleValues.contains(EntityType.GLOW_SQUID));
    assertTrue(allPossibleValues.contains(EntityType.JUNGLE_CHEST_BOAT));
    assertTrue(allPossibleValues.contains(EntityType.OAK_CHEST_BOAT));
    assertTrue(allPossibleValues.contains(EntityType.SALMON));
    assertTrue(allPossibleValues.contains(EntityType.TNT));
    assertTrue(allPossibleValues.contains(EntityType.WITHER));
    assertTrue(actualEntitySetTag.getValues().isEmpty());
    assertTrue(actualEntitySetTag.tagged.isEmpty());
    assertSame(key, actualEntitySetTag.getKey());
    assertSame(key, actualEntitySetTag.key());
  }

  /**
   * Test {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection, Predicate[])}.
   *
   * <ul>
   *   <li>Then return AllPossibleValues size is one hundred fifty-two.
   * </ul>
   *
   * <p>Method under test: {@link EntitySetTag#EntitySetTag(NamespacedKey, Collection, Predicate[])}
   */
  @Test
  @DisplayName(
      "Test new EntitySetTag(NamespacedKey, Collection, Predicate[]); then return AllPossibleValues size is one hundred fifty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySetTag.<init>(NamespacedKey, Collection, Predicate[])"})
  void testNewEntitySetTag_thenReturnAllPossibleValuesSizeIsOneHundredFiftyTwo2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    EntitySetTag actualEntitySetTag =
        new EntitySetTag(key, new ArrayList<>(), mock(Predicate.class));

    // Assert
    Set<EntityType> allPossibleValues = actualEntitySetTag.getAllPossibleValues();
    assertEquals(152, allPossibleValues.size());
    assertFalse(actualEntitySetTag.isLocked());
    assertTrue(allPossibleValues.contains(EntityType.GLOW_SQUID));
    assertTrue(allPossibleValues.contains(EntityType.JUNGLE_CHEST_BOAT));
    assertTrue(allPossibleValues.contains(EntityType.OAK_CHEST_BOAT));
    assertTrue(allPossibleValues.contains(EntityType.SALMON));
    assertTrue(allPossibleValues.contains(EntityType.TNT));
    assertTrue(allPossibleValues.contains(EntityType.WITHER));
    assertTrue(actualEntitySetTag.getValues().isEmpty());
    assertTrue(actualEntitySetTag.tagged.isEmpty());
    assertSame(key, actualEntitySetTag.getKey());
    assertSame(key, actualEntitySetTag.key());
  }

  /**
   * Test {@link EntitySetTag#EntitySetTag(NamespacedKey, EntityType[])}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntitySetTag#EntitySetTag(NamespacedKey, EntityType[])}
   */
  @Test
  @DisplayName(
      "Test new EntitySetTag(NamespacedKey, EntityType[]); when 'ACACIA_BOAT'; then return Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySetTag.<init>(NamespacedKey, EntityType[])"})
  void testNewEntitySetTag_whenAcaciaBoat_thenReturnValuesSizeIsOne() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    EntitySetTag actualEntitySetTag = new EntitySetTag(key, EntityType.ACACIA_BOAT);

    // Assert
    Set<EntityType> values = actualEntitySetTag.getValues();
    assertEquals(1, values.size());
    Set<EntityType> entityTypeSet = actualEntitySetTag.tagged;
    assertEquals(1, entityTypeSet.size());
    Set<EntityType> allPossibleValues = actualEntitySetTag.getAllPossibleValues();
    assertEquals(152, allPossibleValues.size());
    assertFalse(actualEntitySetTag.isLocked());
    assertTrue(values.contains(EntityType.ACACIA_BOAT));
    assertTrue(allPossibleValues.contains(EntityType.GLOW_SQUID));
    assertTrue(allPossibleValues.contains(EntityType.JUNGLE_CHEST_BOAT));
    assertTrue(allPossibleValues.contains(EntityType.OAK_CHEST_BOAT));
    assertTrue(allPossibleValues.contains(EntityType.SALMON));
    assertTrue(allPossibleValues.contains(EntityType.TNT));
    assertTrue(allPossibleValues.contains(EntityType.WITHER));
    assertTrue(entityTypeSet.contains(EntityType.ACACIA_BOAT));
    assertSame(key, actualEntitySetTag.getKey());
    assertSame(key, actualEntitySetTag.key());
  }

  /**
   * Test {@link EntitySetTag#getAllPossibleValues()}.
   *
   * <p>Method under test: {@link EntitySetTag#getAllPossibleValues()}
   */
  @Test
  @DisplayName("Test getAllPossibleValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntitySetTag.getAllPossibleValues()"})
  void testGetAllPossibleValues() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();
    EntitySetTag entitySetTag = new EntitySetTag(key, new ArrayList<>());

    // Act
    Set<EntityType> actualAllPossibleValues = entitySetTag.getAllPossibleValues();

    // Assert
    assertEquals(152, actualAllPossibleValues.size());
    assertTrue(actualAllPossibleValues.contains(EntityType.ACACIA_CHEST_BOAT));
    assertTrue(actualAllPossibleValues.contains(EntityType.COW));
    assertTrue(actualAllPossibleValues.contains(EntityType.FROG));
    assertTrue(actualAllPossibleValues.contains(EntityType.GLOW_SQUID));
    assertTrue(actualAllPossibleValues.contains(EntityType.JUNGLE_CHEST_BOAT));
    assertTrue(actualAllPossibleValues.contains(EntityType.OAK_CHEST_BOAT));
    assertTrue(actualAllPossibleValues.contains(EntityType.POLAR_BEAR));
    assertTrue(actualAllPossibleValues.contains(EntityType.SALMON));
    assertTrue(actualAllPossibleValues.contains(EntityType.SLIME));
    assertTrue(actualAllPossibleValues.contains(EntityType.TNT));
    assertTrue(actualAllPossibleValues.contains(EntityType.WITHER));
  }

  /**
   * Test {@link EntitySetTag#getName(EntityType)} with {@code value}.
   *
   * <p>Method under test: {@link EntitySetTag#getName(EntityType)}
   */
  @Test
  @DisplayName("Test getName(EntityType) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntitySetTag.getName(EntityType)"})
  void testGetNameWithValue() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();
    EntitySetTag entitySetTag = new EntitySetTag(key, new ArrayList<>());

    // Act and Assert
    assertEquals("ACACIA_BOAT", entitySetTag.getName(EntityType.ACACIA_BOAT));
  }
}
