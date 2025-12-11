package ca.spottedleaf.moonrise.patches.blockstate_propertyaccess.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ZeroCollidingReferenceStateTableDiffblueTest {
  /**
   * Test {@link ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}.
   *
   * <ul>
   *   <li>Then return Properties size is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}
   */
  @Test
  @DisplayName(
      "Test new ZeroCollidingReferenceStateTable(Collection); then return Properties size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZeroCollidingReferenceStateTable.<init>(Collection)"})
  void testNewZeroCollidingReferenceStateTable_thenReturnPropertiesSizeIsFive() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));

    // Act
    ZeroCollidingReferenceStateTable<Object, Object> actualZeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    // Assert
    assertEquals(5, actualZeroCollidingReferenceStateTable.getProperties().size());
    assertFalse(actualZeroCollidingReferenceStateTable.isLoaded());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}.
   *
   * <ul>
   *   <li>Then return Properties size is four.
   * </ul>
   *
   * <p>Method under test: {@link
   * ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}
   */
  @Test
  @DisplayName(
      "Test new ZeroCollidingReferenceStateTable(Collection); then return Properties size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZeroCollidingReferenceStateTable.<init>(Collection)"})
  void testNewZeroCollidingReferenceStateTable_thenReturnPropertiesSizeIsFour() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));

    // Act
    ZeroCollidingReferenceStateTable<Object, Object> actualZeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    // Assert
    assertEquals(4, actualZeroCollidingReferenceStateTable.getProperties().size());
    assertFalse(actualZeroCollidingReferenceStateTable.isLoaded());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}.
   *
   * <ul>
   *   <li>Then return Properties size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}
   */
  @Test
  @DisplayName(
      "Test new ZeroCollidingReferenceStateTable(Collection); then return Properties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZeroCollidingReferenceStateTable.<init>(Collection)"})
  void testNewZeroCollidingReferenceStateTable_thenReturnPropertiesSizeIsOne() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));

    // Act
    ZeroCollidingReferenceStateTable<Object, Object> actualZeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    // Assert
    assertEquals(1, actualZeroCollidingReferenceStateTable.getProperties().size());
    assertFalse(actualZeroCollidingReferenceStateTable.isLoaded());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}.
   *
   * <ul>
   *   <li>Then return Properties size is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}
   */
  @Test
  @DisplayName(
      "Test new ZeroCollidingReferenceStateTable(Collection); then return Properties size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZeroCollidingReferenceStateTable.<init>(Collection)"})
  void testNewZeroCollidingReferenceStateTable_thenReturnPropertiesSizeIsThree() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));

    // Act
    ZeroCollidingReferenceStateTable<Object, Object> actualZeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    // Assert
    assertEquals(3, actualZeroCollidingReferenceStateTable.getProperties().size());
    assertFalse(actualZeroCollidingReferenceStateTable.isLoaded());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}.
   *
   * <ul>
   *   <li>Then return Properties size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}
   */
  @Test
  @DisplayName(
      "Test new ZeroCollidingReferenceStateTable(Collection); then return Properties size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZeroCollidingReferenceStateTable.<init>(Collection)"})
  void testNewZeroCollidingReferenceStateTable_thenReturnPropertiesSizeIsTwo() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));

    // Act
    ZeroCollidingReferenceStateTable<Object, Object> actualZeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    // Assert
    assertEquals(2, actualZeroCollidingReferenceStateTable.getProperties().size());
    assertFalse(actualZeroCollidingReferenceStateTable.isLoaded());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ZeroCollidingReferenceStateTable#ZeroCollidingReferenceStateTable(Collection)}
   */
  @Test
  @DisplayName(
      "Test new ZeroCollidingReferenceStateTable(Collection); when ArrayList(); then return Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZeroCollidingReferenceStateTable.<init>(Collection)"})
  void testNewZeroCollidingReferenceStateTable_whenArrayList_thenReturnPropertiesEmpty() {
    // Arrange and Act
    ZeroCollidingReferenceStateTable<Object, Object> actualZeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    // Assert
    assertFalse(actualZeroCollidingReferenceStateTable.isLoaded());
    assertTrue(actualZeroCollidingReferenceStateTable.getProperties().isEmpty());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create {@code Name}.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}
   */
  @Test
  @DisplayName(
      "Test hasProperty(Property); given ArrayList() add create 'Name'; when Property moonrise$getId() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroCollidingReferenceStateTable.hasProperty(Property)"})
  void testHasProperty_givenArrayListAddCreateName_whenPropertyMoonrise$getIdReturnOne() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.addAll(new ArrayList<>());
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    boolean actualHasPropertyResult = zeroCollidingReferenceStateTable.hasProperty(property);

    // Assert
    verify(property).moonrise$getId();
    assertFalse(actualHasPropertyResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create {@code Name}.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}
   */
  @Test
  @DisplayName(
      "Test hasProperty(Property); given ArrayList() add create 'Name'; when Property moonrise$getId() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroCollidingReferenceStateTable.hasProperty(Property)"})
  void testHasProperty_givenArrayListAddCreateName_whenPropertyMoonrise$getIdReturnOne2() {
    // Arrange
    ArrayList<Property<?>> propertyList = new ArrayList<>();
    propertyList.add(BooleanProperty.create("Name"));

    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.addAll(propertyList);
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    boolean actualHasPropertyResult = zeroCollidingReferenceStateTable.hasProperty(property);

    // Assert
    verify(property).moonrise$getId();
    assertFalse(actualHasPropertyResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}
   */
  @Test
  @DisplayName(
      "Test hasProperty(Property); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroCollidingReferenceStateTable.hasProperty(Property)"})
  void testHasProperty_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> zeroCollidingReferenceStateTable.hasProperty(property));
    verify(property).moonrise$getId();
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}
   */
  @Test
  @DisplayName(
      "Test hasProperty(Property); given one; when Property moonrise$getId() return one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroCollidingReferenceStateTable.hasProperty(Property)"})
  void testHasProperty_givenOne_whenPropertyMoonrise$getIdReturnOne_thenReturnFalse() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    boolean actualHasPropertyResult = zeroCollidingReferenceStateTable.hasProperty(property);

    // Assert
    verify(property).moonrise$getId();
    assertFalse(actualHasPropertyResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#hasProperty(Property)}
   */
  @Test
  @DisplayName(
      "Test hasProperty(Property); given zero; when Property moonrise$getId() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroCollidingReferenceStateTable.hasProperty(Property)"})
  void testHasProperty_givenZero_whenPropertyMoonrise$getIdReturnZero_thenReturnFalse() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(0);

    // Act
    boolean actualHasPropertyResult = zeroCollidingReferenceStateTable.hasProperty(property);

    // Assert
    verify(property).moonrise$getId();
    assertFalse(actualHasPropertyResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#isLoaded()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#isLoaded()}
   */
  @Test
  @DisplayName("Test isLoaded(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroCollidingReferenceStateTable.isLoaded()"})
  void testIsLoaded_thenReturnFalse() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    // Act and Assert
    assertFalse(zeroCollidingReferenceStateTable.isLoaded());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#isLoaded()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#isLoaded()}
   */
  @Test
  @DisplayName("Test isLoaded(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroCollidingReferenceStateTable.isLoaded()"})
  void testIsLoaded_thenReturnTrue() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());
    zeroCollidingReferenceStateTable.loadInTable(new HashMap<>());

    // Act and Assert
    assertTrue(zeroCollidingReferenceStateTable.isLoaded());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#loadInTable(Map)}.
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#loadInTable(Map)}
   */
  @Test
  @DisplayName("Test loadInTable(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZeroCollidingReferenceStateTable.loadInTable(Map)"})
  void testLoadInTable() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    // Act
    zeroCollidingReferenceStateTable.loadInTable(new HashMap<>());

    // Assert
    assertTrue(zeroCollidingReferenceStateTable.isLoaded());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#loadInTable(Map)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#loadInTable(Map)}
   */
  @Test
  @DisplayName("Test loadInTable(Map); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZeroCollidingReferenceStateTable.loadInTable(Map)"})
  void testLoadInTable_thenThrowIllegalStateException() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());
    zeroCollidingReferenceStateTable.loadInTable(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> zeroCollidingReferenceStateTable.loadInTable(new HashMap<>()));
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#get(long, Property)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create {@code Name}.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#get(long, Property)}
   */
  @Test
  @DisplayName(
      "Test get(long, Property); given ArrayList() add create 'Name'; when Property moonrise$getId() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparable ZeroCollidingReferenceStateTable.get(long, Property)"})
  void testGet_givenArrayListAddCreateName_whenPropertyMoonrise$getIdReturnOne() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    File actualGetResult = zeroCollidingReferenceStateTable.get(1L, property);

    // Assert
    verify(property).moonrise$getId();
    assertNull(actualGetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#get(long, Property)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create {@code Name}.
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#get(long, Property)}
   */
  @Test
  @DisplayName(
      "Test get(long, Property); given ArrayList() add create 'Name'; when zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparable ZeroCollidingReferenceStateTable.get(long, Property)"})
  void testGet_givenArrayListAddCreateName_whenZero_thenReturnNull() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.add(BooleanProperty.create("Name"));
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    File actualGetResult = zeroCollidingReferenceStateTable.get(0L, property);

    // Assert
    verify(property).moonrise$getId();
    assertNull(actualGetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#get(long, Property)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#get(long, Property)}
   */
  @Test
  @DisplayName(
      "Test get(long, Property); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparable ZeroCollidingReferenceStateTable.get(long, Property)"})
  void testGet_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> zeroCollidingReferenceStateTable.get(1L, property));
    verify(property).moonrise$getId();
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#get(long, Property)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#get(long, Property)}
   */
  @Test
  @DisplayName(
      "Test get(long, Property); given one; when Property moonrise$getId() return one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparable ZeroCollidingReferenceStateTable.get(long, Property)"})
  void testGet_givenOne_whenPropertyMoonrise$getIdReturnOne_thenReturnNull() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    File actualGetResult = zeroCollidingReferenceStateTable.get(1L, property);

    // Assert
    verify(property).moonrise$getId();
    assertNull(actualGetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#get(long, Property)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#get(long, Property)}
   */
  @Test
  @DisplayName(
      "Test get(long, Property); given zero; when Property moonrise$getId() return zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparable ZeroCollidingReferenceStateTable.get(long, Property)"})
  void testGet_givenZero_whenPropertyMoonrise$getIdReturnZero_thenReturnNull() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(0);

    // Act
    File actualGetResult = zeroCollidingReferenceStateTable.get(1L, property);

    // Assert
    verify(property).moonrise$getId();
    assertNull(actualGetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create {@code Name}.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}
   */
  @Test
  @DisplayName(
      "Test set(long, Property, Comparable); given ArrayList() add create 'Name'; when Property moonrise$getId() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ZeroCollidingReferenceStateTable.set(long, Property, Comparable)"})
  void testSet_givenArrayListAddCreateName_whenPropertyMoonrise$getIdReturnOne() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.addAll(new ArrayList<>());
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    Property<File> property = mock(Property.class);
    when(property.moonrise$getIdFor(Mockito.<File>any())).thenReturn(1);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    Object actualSetResult =
        zeroCollidingReferenceStateTable.set(1L, property, OldUsersConverter.OLD_IPBANLIST);

    // Assert
    verify(property).moonrise$getId();
    verify(property).moonrise$getIdFor(isA(File.class));
    assertNull(actualSetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create {@code Name}.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}
   */
  @Test
  @DisplayName(
      "Test set(long, Property, Comparable); given ArrayList() add create 'Name'; when Property moonrise$getId() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ZeroCollidingReferenceStateTable.set(long, Property, Comparable)"})
  void testSet_givenArrayListAddCreateName_whenPropertyMoonrise$getIdReturnOne2() {
    // Arrange
    ArrayList<Property<?>> propertyList = new ArrayList<>();
    propertyList.add(BooleanProperty.create("Name"));
    propertyList.add(BooleanProperty.create("Name"));

    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.addAll(propertyList);
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    Property<File> property = mock(Property.class);
    when(property.moonrise$getIdFor(Mockito.<File>any())).thenReturn(1);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    Object actualSetResult =
        zeroCollidingReferenceStateTable.set(1L, property, OldUsersConverter.OLD_IPBANLIST);

    // Assert
    verify(property).moonrise$getId();
    verify(property).moonrise$getIdFor(isA(File.class));
    assertNull(actualSetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link Property} {@link Property#moonrise$getIdFor(Comparable)} return minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}
   */
  @Test
  @DisplayName(
      "Test set(long, Property, Comparable); given minus one; when Property moonrise$getIdFor(Comparable) return minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ZeroCollidingReferenceStateTable.set(long, Property, Comparable)"})
  void testSet_givenMinusOne_whenPropertyMoonrise$getIdForReturnMinusOne_thenReturnNull() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getIdFor(Mockito.<File>any())).thenReturn(-1);

    // Act
    Object actualSetResult =
        zeroCollidingReferenceStateTable.set(1L, property, OldUsersConverter.OLD_IPBANLIST);

    // Assert
    verify(property).moonrise$getIdFor(isA(File.class));
    assertNull(actualSetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   *   <li>Then calls {@link Property#moonrise$getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}
   */
  @Test
  @DisplayName(
      "Test set(long, Property, Comparable); given one; when Property moonrise$getId() return one; then calls moonrise$getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ZeroCollidingReferenceStateTable.set(long, Property, Comparable)"})
  void testSet_givenOne_whenPropertyMoonrise$getIdReturnOne_thenCallsMoonrise$getId() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getIdFor(Mockito.<File>any())).thenReturn(1);
    when(property.moonrise$getId()).thenReturn(1);

    // Act
    Object actualSetResult =
        zeroCollidingReferenceStateTable.set(1L, property, OldUsersConverter.OLD_IPBANLIST);

    // Assert
    verify(property).moonrise$getId();
    verify(property).moonrise$getIdFor(isA(File.class));
    assertNull(actualSetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return zero.
   *   <li>Then calls {@link Property#moonrise$getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#set(long, Property, Comparable)}
   */
  @Test
  @DisplayName(
      "Test set(long, Property, Comparable); given zero; when Property moonrise$getId() return zero; then calls moonrise$getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ZeroCollidingReferenceStateTable.set(long, Property, Comparable)"})
  void testSet_givenZero_whenPropertyMoonrise$getIdReturnZero_thenCallsMoonrise$getId() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getIdFor(Mockito.<File>any())).thenReturn(1);
    when(property.moonrise$getId()).thenReturn(0);

    // Act
    Object actualSetResult =
        zeroCollidingReferenceStateTable.set(1L, property, OldUsersConverter.OLD_IPBANLIST);

    // Assert
    verify(property).moonrise$getId();
    verify(property).moonrise$getIdFor(isA(File.class));
    assertNull(actualSetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#trySet(long, Property, Comparable, Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create {@code Name}.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#trySet(long, Property,
   * Comparable, Object)}
   */
  @Test
  @DisplayName(
      "Test trySet(long, Property, Comparable, Object); given ArrayList() add create 'Name'; when Property moonrise$getId() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ZeroCollidingReferenceStateTable.trySet(long, Property, Comparable, Object)"
  })
  void testTrySet_givenArrayListAddCreateName_whenPropertyMoonrise$getIdReturnOne() {
    // Arrange
    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.addAll(new ArrayList<>());
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualTrySetResult =
        zeroCollidingReferenceStateTable.trySet(
            1L, property, OldUsersConverter.OLD_IPBANLIST, object);

    // Assert
    verify(property).moonrise$getId();
    assertSame(object, actualTrySetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#trySet(long, Property, Comparable, Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add create {@code Name}.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#trySet(long, Property,
   * Comparable, Object)}
   */
  @Test
  @DisplayName(
      "Test trySet(long, Property, Comparable, Object); given ArrayList() add create 'Name'; when Property moonrise$getId() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ZeroCollidingReferenceStateTable.trySet(long, Property, Comparable, Object)"
  })
  void testTrySet_givenArrayListAddCreateName_whenPropertyMoonrise$getIdReturnOne2() {
    // Arrange
    ArrayList<Property<?>> propertyList = new ArrayList<>();
    propertyList.add(BooleanProperty.create("Name"));

    ArrayList<Property<?>> properties = new ArrayList<>();
    properties.add(BooleanProperty.create("Name"));
    properties.addAll(propertyList);
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(properties);

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualTrySetResult =
        zeroCollidingReferenceStateTable.trySet(
            1L, property, OldUsersConverter.OLD_IPBANLIST, object);

    // Assert
    verify(property).moonrise$getId();
    assertSame(object, actualTrySetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#trySet(long, Property, Comparable, Object)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#trySet(long, Property,
   * Comparable, Object)}
   */
  @Test
  @DisplayName(
      "Test trySet(long, Property, Comparable, Object); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ZeroCollidingReferenceStateTable.trySet(long, Property, Comparable, Object)"
  })
  void testTrySet_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            zeroCollidingReferenceStateTable.trySet(
                1L,
                property,
                OldUsersConverter.OLD_IPBANLIST,
                ConfigurationTransformation.WILDCARD_OBJECT));
    verify(property).moonrise$getId();
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#trySet(long, Property, Comparable, Object)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#trySet(long, Property,
   * Comparable, Object)}
   */
  @Test
  @DisplayName(
      "Test trySet(long, Property, Comparable, Object); given one; when Property moonrise$getId() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ZeroCollidingReferenceStateTable.trySet(long, Property, Comparable, Object)"
  })
  void testTrySet_givenOne_whenPropertyMoonrise$getIdReturnOne() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(1);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualTrySetResult =
        zeroCollidingReferenceStateTable.trySet(
            1L, property, OldUsersConverter.OLD_IPBANLIST, object);

    // Assert
    verify(property).moonrise$getId();
    assertSame(object, actualTrySetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#trySet(long, Property, Comparable, Object)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link Property} {@link Property#moonrise$getId()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#trySet(long, Property,
   * Comparable, Object)}
   */
  @Test
  @DisplayName(
      "Test trySet(long, Property, Comparable, Object); given zero; when Property moonrise$getId() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ZeroCollidingReferenceStateTable.trySet(long, Property, Comparable, Object)"
  })
  void testTrySet_givenZero_whenPropertyMoonrise$getIdReturnZero() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    Property<File> property = mock(Property.class);
    when(property.moonrise$getId()).thenReturn(0);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualTrySetResult =
        zeroCollidingReferenceStateTable.trySet(
            1L, property, OldUsersConverter.OLD_IPBANLIST, object);

    // Assert
    verify(property).moonrise$getId();
    assertSame(object, actualTrySetResult);
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#getProperties()}.
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ZeroCollidingReferenceStateTable.getProperties()"})
  void testGetProperties() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    // Act and Assert
    assertTrue(zeroCollidingReferenceStateTable.getProperties().isEmpty());
  }

  /**
   * Test {@link ZeroCollidingReferenceStateTable#getMapView(long)}.
   *
   * <p>Method under test: {@link ZeroCollidingReferenceStateTable#getMapView(long)}
   */
  @Test
  @DisplayName("Test getMapView(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ZeroCollidingReferenceStateTable.getMapView(long)"})
  void testGetMapView() {
    // Arrange
    ZeroCollidingReferenceStateTable<Object, Object> zeroCollidingReferenceStateTable =
        new ZeroCollidingReferenceStateTable<>(new ArrayList<>());

    // Act and Assert
    assertTrue(zeroCollidingReferenceStateTable.getMapView(1L).isEmpty());
  }
}
