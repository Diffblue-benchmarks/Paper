package io.papermc.paper.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.MaterialSetTag;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BaseTagDiffblueTest {
  /**
   * Test {@link BaseTag#lock()}.
   *
   * <p>Method under test: {@link BaseTag#lock()}
   */
  @Test
  @DisplayName("Test lock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.lock()"})
  void testLock() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualLockResult = materialSetTag.lock();

    // Assert
    assertTrue(materialSetTag.isLocked());
    assertSame(materialSetTag, actualLockResult);
  }

  /**
   * Test {@link BaseTag#isLocked()}.
   *
   * <p>Method under test: {@link BaseTag#isLocked()}
   */
  @Test
  @DisplayName("Test isLocked()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTag.isLocked()"})
  void testIsLocked() {
    // Arrange, Act and Assert
    assertFalse(new MaterialSetTag(new ArrayList<>()).isLocked());
  }

  /**
   * Test {@link BaseTag#getKey()}.
   *
   * <p>Method under test: {@link BaseTag#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey BaseTag.getKey()"})
  void testGetKey() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    NamespacedKey actualKey = materialSetTag.getKey();

    // Assert
    assertSame(materialSetTag.key, actualKey);
  }

  /**
   * Test {@link BaseTag#getValues()}.
   *
   * <p>Method under test: {@link BaseTag#getValues()}
   */
  @Test
  @DisplayName("Test getValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BaseTag.getValues()"})
  void testGetValues() {
    // Arrange, Act and Assert
    assertTrue(new MaterialSetTag(new ArrayList<>()).getValues().isEmpty());
  }

  /**
   * Test {@link BaseTag#isTagged(Keyed)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#isTagged(Keyed)}
   */
  @Test
  @DisplayName(
      "Test isTagged(Keyed); given Predicate test(Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTag.isTagged(Keyed)"})
  void testIsTagged_givenPredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    Predicate<EntityType> filter = mock(Predicate.class);
    when(filter.test(Mockito.<EntityType>any())).thenReturn(true);
    EntitySetTag entitySetTag = new EntitySetTag(NamespacedKey.randomKey(), filter);

    // Act
    boolean actualIsTaggedResult = entitySetTag.isTagged(EntityType.ACACIA_BOAT);

    // Assert
    verify(filter, atLeast(1)).test(Mockito.<EntityType>any());
    assertTrue(actualIsTaggedResult);
  }

  /**
   * Test {@link BaseTag#isTagged(Keyed)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#isTagged(Keyed)}
   */
  @Test
  @DisplayName("Test isTagged(Keyed); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseTag.isTagged(Keyed)"})
  void testIsTagged_thenReturnFalse() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();
    EntitySetTag entitySetTag = new EntitySetTag(key, new ArrayList<>());

    // Act and Assert
    assertFalse(entitySetTag.isTagged(EntityType.ACACIA_BOAT));
  }

  /**
   * Test {@link BaseTag#add(Collection)} with {@code collection}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#add(Collection)}
   */
  @Test
  @DisplayName(
      "Test add(Collection) with 'collection'; then MaterialSetTag(Collection) with materials is ArrayList() Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.add(Collection)"})
  void testAddWithCollection_thenMaterialSetTagWithMaterialsIsArrayListValuesEmpty() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualAddResult = materialSetTag.add(new ArrayList<>());

    // Assert
    assertTrue(materialSetTag.getValues().isEmpty());
    assertTrue(actualAddResult.getValues().isEmpty());
    assertTrue(materialSetTag.tagged.isEmpty());
    assertTrue(actualAddResult.tagged.isEmpty());
  }

  /**
   * Test {@link BaseTag#add(Collection)} with {@code collection}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#add(Collection)}
   */
  @Test
  @DisplayName(
      "Test add(Collection) with 'collection'; then MaterialSetTag(Collection) with materials is ArrayList() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.add(Collection)"})
  void testAddWithCollection_thenMaterialSetTagWithMaterialsIsArrayListValuesSizeIsOne() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    ArrayList<Material> collection = new ArrayList<>();
    collection.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualAddResult = materialSetTag.add(collection);

    // Assert
    assertEquals(1, materialSetTag.getValues().size());
    assertEquals(1, actualAddResult.getValues().size());
    assertEquals(1, materialSetTag.tagged.size());
    assertEquals(1, actualAddResult.tagged.size());
  }

  /**
   * Test {@link BaseTag#add(Collection)} with {@code collection}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#add(Collection)}
   */
  @Test
  @DisplayName(
      "Test add(Collection) with 'collection'; then MaterialSetTag(Collection) with materials is ArrayList() Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.add(Collection)"})
  void testAddWithCollection_thenMaterialSetTagWithMaterialsIsArrayListValuesSizeIsTwo() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    ArrayList<Material> collection = new ArrayList<>();
    collection.add(Material.ACACIA_CHEST_BOAT);
    collection.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualAddResult = materialSetTag.add(collection);

    // Assert
    Set<Material> values = materialSetTag.getValues();
    assertEquals(2, values.size());
    Set<Material> values2 = actualAddResult.getValues();
    assertEquals(2, values2.size());
    Set<Material> materialSet = materialSetTag.tagged;
    assertEquals(2, materialSet.size());
    Set<Material> materialSet2 = actualAddResult.tagged;
    assertEquals(2, materialSet2.size());
    assertTrue(values.contains(Material.ACACIA_CHEST_BOAT));
    assertTrue(values2.contains(Material.ACACIA_CHEST_BOAT));
    assertTrue(materialSet.contains(Material.ACACIA_CHEST_BOAT));
    assertTrue(materialSet2.contains(Material.ACACIA_CHEST_BOAT));
  }

  /**
   * Test {@link BaseTag#add(Predicate)} with {@code filter}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Predicate)} with filter is {@link Predicate}
   *       Values is {@link BaseTag#tagged}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#add(Predicate)}
   */
  @Test
  @DisplayName(
      "Test add(Predicate) with 'filter'; then MaterialSetTag(Predicate) with filter is Predicate Values is tagged")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.add(Predicate)"})
  void testAddWithFilter_thenMaterialSetTagWithFilterIsPredicateValuesIsTagged() {
    // Arrange
    Predicate<Material> filter = mock(Predicate.class);
    when(filter.test(Mockito.<Material>any())).thenReturn(true);
    MaterialSetTag materialSetTag = new MaterialSetTag(filter);
    Predicate<Material> filter2 = materialSetTag::isTagged;

    // Act
    MaterialSetTag actualAddResult = materialSetTag.add(filter2);

    // Assert
    verify(filter, atLeast(1)).test(Mockito.<Material>any());
    assertEquals(actualAddResult.tagged, materialSetTag.getValues());
    assertSame(materialSetTag, actualAddResult);
  }

  /**
   * Test {@link BaseTag#add(Predicate)} with {@code filter}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#add(Predicate)}
   */
  @Test
  @DisplayName(
      "Test add(Predicate) with 'filter'; then MaterialSetTag(Collection) with materials is ArrayList() Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.add(Predicate)"})
  void testAddWithFilter_thenMaterialSetTagWithMaterialsIsArrayListValuesEmpty() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());
    Predicate<Material> filter = materialSetTag::isTagged;

    // Act
    MaterialSetTag actualAddResult = materialSetTag.add(filter);

    // Assert
    assertTrue(materialSetTag.getValues().isEmpty());
    assertSame(materialSetTag, actualAddResult);
  }

  /**
   * Test {@link BaseTag#add(Tag[])} with {@code tags}.
   *
   * <p>Method under test: {@link BaseTag#add(org.bukkit.Tag[])}
   */
  @Test
  @DisplayName("Test add(Tag[]) with 'tags'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.add(org.bukkit.Tag[])"})
  void testAddWithTags() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualAddResult = materialSetTag.add(new MaterialSetTag(new ArrayList<>()));

    // Assert
    assertSame(materialSetTag, actualAddResult);
  }

  /**
   * Test {@link BaseTag#add(Keyed[])} with {@code values}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#add(Keyed[])}
   */
  @Test
  @DisplayName(
      "Test add(Keyed[]) with 'values'; then MaterialSetTag(Collection) with materials is ArrayList() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.add(Keyed[])"})
  void testAddWithValues_thenMaterialSetTagWithMaterialsIsArrayListValuesSizeIsOne() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualAddResult = materialSetTag.add(Material.ACACIA_BOAT);

    // Assert
    Set<Material> values = materialSetTag.getValues();
    assertEquals(1, values.size());
    Set<Material> materialSet = materialSetTag.tagged;
    assertEquals(1, materialSet.size());
    assertTrue(values.contains(Material.ACACIA_BOAT));
    assertTrue(materialSet.contains(Material.ACACIA_BOAT));
    assertSame(materialSetTag, actualAddResult);
  }

  /**
   * Test {@link BaseTag#contains(String)}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} {@link BaseTag#tagged} size is {@code 1568}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#contains(String)}
   */
  @Test
  @DisplayName(
      "Test contains(String); then MaterialSetTag(Collection) with materials is ArrayList() tagged size is '1568'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.contains(String)"})
  void testContains_thenMaterialSetTagWithMaterialsIsArrayListTaggedSizeIs1568() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualContainsResult = materialSetTag.contains("");

    // Assert
    assertEquals(1568, materialSetTag.tagged.size());
    assertEquals(1568, actualContainsResult.tagged.size());
    Set<Material> materialSet = actualContainsResult.tagged;
    assertEquals(materialSet, materialSetTag.getValues());
    assertEquals(materialSet, actualContainsResult.getValues());
  }

  /**
   * Test {@link BaseTag#contains(String)}.
   *
   * <ul>
   *   <li>When {@code With}.
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#contains(String)}
   */
  @Test
  @DisplayName(
      "Test contains(String); when 'With'; then MaterialSetTag(Collection) with materials is ArrayList() Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.contains(String)"})
  void testContains_whenWith_thenMaterialSetTagWithMaterialsIsArrayListValuesEmpty() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualContainsResult = materialSetTag.contains("With");

    // Assert
    assertTrue(materialSetTag.getValues().isEmpty());
    assertTrue(actualContainsResult.getValues().isEmpty());
    assertTrue(materialSetTag.tagged.isEmpty());
    assertTrue(actualContainsResult.tagged.isEmpty());
  }

  /**
   * Test {@link BaseTag#endsWith(String)}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} {@link BaseTag#tagged} size is {@code 1568}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#endsWith(String)}
   */
  @Test
  @DisplayName(
      "Test endsWith(String); then MaterialSetTag(Collection) with materials is ArrayList() tagged size is '1568'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.endsWith(String)"})
  void testEndsWith_thenMaterialSetTagWithMaterialsIsArrayListTaggedSizeIs1568() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualEndsWithResult = materialSetTag.endsWith("");

    // Assert
    assertEquals(1568, materialSetTag.tagged.size());
    assertEquals(1568, actualEndsWithResult.tagged.size());
    Set<Material> materialSet = actualEndsWithResult.tagged;
    assertEquals(materialSet, materialSetTag.getValues());
    assertEquals(materialSet, actualEndsWithResult.getValues());
  }

  /**
   * Test {@link BaseTag#endsWith(String)}.
   *
   * <ul>
   *   <li>When {@code With}.
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#endsWith(String)}
   */
  @Test
  @DisplayName(
      "Test endsWith(String); when 'With'; then MaterialSetTag(Collection) with materials is ArrayList() Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.endsWith(String)"})
  void testEndsWith_whenWith_thenMaterialSetTagWithMaterialsIsArrayListValuesEmpty() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualEndsWithResult = materialSetTag.endsWith("With");

    // Assert
    assertTrue(materialSetTag.getValues().isEmpty());
    assertTrue(actualEndsWithResult.getValues().isEmpty());
    assertTrue(materialSetTag.tagged.isEmpty());
    assertTrue(actualEndsWithResult.tagged.isEmpty());
  }

  /**
   * Test {@link BaseTag#startsWith(String)}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} {@link BaseTag#tagged} size is {@code 1568}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#startsWith(String)}
   */
  @Test
  @DisplayName(
      "Test startsWith(String); then MaterialSetTag(Collection) with materials is ArrayList() tagged size is '1568'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.startsWith(String)"})
  void testStartsWith_thenMaterialSetTagWithMaterialsIsArrayListTaggedSizeIs1568() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualStartsWithResult = materialSetTag.startsWith("");

    // Assert
    assertEquals(1568, materialSetTag.tagged.size());
    assertEquals(1568, actualStartsWithResult.tagged.size());
    Set<Material> materialSet = actualStartsWithResult.tagged;
    assertEquals(materialSet, materialSetTag.getValues());
    assertEquals(materialSet, actualStartsWithResult.getValues());
  }

  /**
   * Test {@link BaseTag#startsWith(String)}.
   *
   * <ul>
   *   <li>When {@code With}.
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#startsWith(String)}
   */
  @Test
  @DisplayName(
      "Test startsWith(String); when 'With'; then MaterialSetTag(Collection) with materials is ArrayList() Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.startsWith(String)"})
  void testStartsWith_whenWith_thenMaterialSetTagWithMaterialsIsArrayListValuesEmpty() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualStartsWithResult = materialSetTag.startsWith("With");

    // Assert
    assertTrue(materialSetTag.getValues().isEmpty());
    assertTrue(actualStartsWithResult.getValues().isEmpty());
    assertTrue(materialSetTag.tagged.isEmpty());
    assertTrue(actualStartsWithResult.tagged.isEmpty());
  }

  /**
   * Test {@link BaseTag#not(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_BOAT}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACACIA_BOAT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#not(Collection)}
   */
  @Test
  @DisplayName(
      "Test not(Collection) with 'Collection'; given 'ACACIA_BOAT'; when ArrayList() add 'ACACIA_BOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.not(Collection)"})
  void testNotWithCollection_givenAcaciaBoat_whenArrayListAddAcaciaBoat() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    ArrayList<Material> values = new ArrayList<>();
    values.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualNotResult = materialSetTag.not(values);

    // Assert
    assertSame(materialSetTag, actualNotResult);
  }

  /**
   * Test {@link BaseTag#not(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_CHEST_BOAT}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACACIA_CHEST_BOAT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#not(Collection)}
   */
  @Test
  @DisplayName(
      "Test not(Collection) with 'Collection'; given 'ACACIA_CHEST_BOAT'; when ArrayList() add 'ACACIA_CHEST_BOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.not(Collection)"})
  void testNotWithCollection_givenAcaciaChestBoat_whenArrayListAddAcaciaChestBoat() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    ArrayList<Material> values = new ArrayList<>();
    values.add(Material.ACACIA_CHEST_BOAT);
    values.add(Material.ACACIA_BOAT);

    // Act
    MaterialSetTag actualNotResult = materialSetTag.not(values);

    // Assert
    assertSame(materialSetTag, actualNotResult);
  }

  /**
   * Test {@link BaseTag#not(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#not(Collection)}
   */
  @Test
  @DisplayName("Test not(Collection) with 'Collection'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.not(Collection)"})
  void testNotWithCollection_whenArrayList() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotResult = materialSetTag.not(new ArrayList<>());

    // Assert
    assertSame(materialSetTag, actualNotResult);
  }

  /**
   * Test {@link BaseTag#not(Keyed[])} with {@code Material[]}.
   *
   * <ul>
   *   <li>Then return {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#not(Keyed[])}
   */
  @Test
  @DisplayName(
      "Test not(Keyed[]) with 'Material[]'; then return MaterialSetTag(Collection) with materials is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.not(Keyed[])"})
  void testNotWithMaterial_thenReturnMaterialSetTagWithMaterialsIsArrayList() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotResult = materialSetTag.not(Material.ACACIA_BOAT);

    // Assert
    assertSame(materialSetTag, actualNotResult);
  }

  /**
   * Test {@link BaseTag#not(Predicate)} with {@code Predicate}.
   *
   * <p>Method under test: {@link BaseTag#not(Predicate)}
   */
  @Test
  @DisplayName("Test not(Predicate) with 'Predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.not(Predicate)"})
  void testNotWithPredicate() {
    // Arrange
    Predicate<Material> filter = mock(Predicate.class);
    when(filter.test(Mockito.<Material>any())).thenReturn(true);
    MaterialSetTag materialSetTag = new MaterialSetTag(filter);
    Predicate<Material> filter2 = materialSetTag::isTagged;

    // Act
    MaterialSetTag actualNotResult = materialSetTag.not(filter2);

    // Assert
    verify(filter, atLeast(1)).test(Mockito.<Material>any());
    assertEquals(463, materialSetTag.tagged.size());
    assertEquals(actualNotResult.tagged, materialSetTag.getValues());
    assertSame(materialSetTag, actualNotResult);
  }

  /**
   * Test {@link BaseTag#not(Predicate)} with {@code Predicate}.
   *
   * <ul>
   *   <li>Then {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()} Values Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#not(Predicate)}
   */
  @Test
  @DisplayName(
      "Test not(Predicate) with 'Predicate'; then MaterialSetTag(Collection) with materials is ArrayList() Values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.not(Predicate)"})
  void testNotWithPredicate_thenMaterialSetTagWithMaterialsIsArrayListValuesEmpty() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());
    Predicate<Material> filter = materialSetTag::isTagged;

    // Act
    MaterialSetTag actualNotResult = materialSetTag.not(filter);

    // Assert
    assertTrue(materialSetTag.getValues().isEmpty());
    assertTrue(materialSetTag.tagged.isEmpty());
    assertSame(materialSetTag, actualNotResult);
  }

  /**
   * Test {@link BaseTag#not(Tag[])} with {@code Tag[]}.
   *
   * <p>Method under test: {@link BaseTag#not(org.bukkit.Tag[])}
   */
  @Test
  @DisplayName("Test not(Tag[]) with 'Tag[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.not(org.bukkit.Tag[])"})
  void testNotWithTag() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotResult = materialSetTag.not(new MaterialSetTag(new ArrayList<>()));

    // Assert
    assertSame(materialSetTag, actualNotResult);
  }

  /**
   * Test {@link BaseTag#notContains(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#notContains(String)}
   */
  @Test
  @DisplayName("Test notContains(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.notContains(String)"})
  void testNotContains_whenEmptyString() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotContainsResult = materialSetTag.notContains("");

    // Assert
    assertSame(materialSetTag, actualNotContainsResult);
  }

  /**
   * Test {@link BaseTag#notContains(String)}.
   *
   * <ul>
   *   <li>When {@code With}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#notContains(String)}
   */
  @Test
  @DisplayName("Test notContains(String); when 'With'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.notContains(String)"})
  void testNotContains_whenWith() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotContainsResult = materialSetTag.notContains("With");

    // Assert
    assertSame(materialSetTag, actualNotContainsResult);
  }

  /**
   * Test {@link BaseTag#notEndsWith(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#notEndsWith(String)}
   */
  @Test
  @DisplayName("Test notEndsWith(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.notEndsWith(String)"})
  void testNotEndsWith_whenEmptyString() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotEndsWithResult = materialSetTag.notEndsWith("");

    // Assert
    assertSame(materialSetTag, actualNotEndsWithResult);
  }

  /**
   * Test {@link BaseTag#notEndsWith(String)}.
   *
   * <ul>
   *   <li>When {@code With}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#notEndsWith(String)}
   */
  @Test
  @DisplayName("Test notEndsWith(String); when 'With'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.notEndsWith(String)"})
  void testNotEndsWith_whenWith() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotEndsWithResult = materialSetTag.notEndsWith("With");

    // Assert
    assertSame(materialSetTag, actualNotEndsWithResult);
  }

  /**
   * Test {@link BaseTag#notStartsWith(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#notStartsWith(String)}
   */
  @Test
  @DisplayName("Test notStartsWith(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.notStartsWith(String)"})
  void testNotStartsWith_whenEmptyString() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotStartsWithResult = materialSetTag.notStartsWith("");

    // Assert
    assertSame(materialSetTag, actualNotStartsWithResult);
  }

  /**
   * Test {@link BaseTag#notStartsWith(String)}.
   *
   * <ul>
   *   <li>When {@code With}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#notStartsWith(String)}
   */
  @Test
  @DisplayName("Test notStartsWith(String); when 'With'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.notStartsWith(String)"})
  void testNotStartsWith_whenWith() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualNotStartsWithResult = materialSetTag.notStartsWith("With");

    // Assert
    assertSame(materialSetTag, actualNotStartsWithResult);
  }

  /**
   * Test {@link BaseTag#ensureSize(String, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#ensureSize(String, int)}
   */
  @Test
  @DisplayName("Test ensureSize(String, int); when three; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.ensureSize(String, int)"})
  void testEnsureSize_whenThree_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new MaterialSetTag(new ArrayList<>()).ensureSize("Label", 3));
  }

  /**
   * Test {@link BaseTag#ensureSize(String, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@link MaterialSetTag#MaterialSetTag(Collection)} with materials is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTag#ensureSize(String, int)}
   */
  @Test
  @DisplayName(
      "Test ensureSize(String, int); when zero; then return MaterialSetTag(Collection) with materials is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseTag BaseTag.ensureSize(String, int)"})
  void testEnsureSize_whenZero_thenReturnMaterialSetTagWithMaterialsIsArrayList() {
    // Arrange
    MaterialSetTag materialSetTag = new MaterialSetTag(new ArrayList<>());

    // Act
    MaterialSetTag actualEnsureSizeResult = materialSetTag.ensureSize("Label", 0);

    // Assert
    assertSame(materialSetTag, actualEnsureSizeResult);
  }
}
