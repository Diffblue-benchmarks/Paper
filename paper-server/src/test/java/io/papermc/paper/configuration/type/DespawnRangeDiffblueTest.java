package io.papermc.paper.configuration.type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import io.papermc.paper.configuration.type.DespawnRange.Serializer;
import io.papermc.paper.configuration.type.DespawnRange.Shape;
import io.papermc.paper.configuration.type.number.IntOr;
import io.papermc.paper.configuration.type.number.IntOr.Default;
import java.lang.reflect.Type;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

class DespawnRangeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return not wasDefinedViaLongSyntax.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DespawnRange#DespawnRange(IntOr.Default)}
   *   <li>{@link DespawnRange#wasDefinedViaLongSyntax()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return not wasDefinedViaLongSyntax")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DespawnRange.<init>(IntOr.Default)",
    "void DespawnRange.<init>(IntOr.Default, IntOr.Default, boolean)",
    "boolean DespawnRange.wasDefinedViaLongSyntax()"
  })
  void testGettersAndSetters_thenReturnNotWasDefinedViaLongSyntax() {
    // Arrange, Act and Assert
    assertFalse(new DespawnRange(new Default(OptionalInt.empty())).wasDefinedViaLongSyntax());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return wasDefinedViaLongSyntax.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DespawnRange#DespawnRange(IntOr.Default, IntOr.Default, boolean)}
   *   <li>{@link DespawnRange#wasDefinedViaLongSyntax()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'; then return wasDefinedViaLongSyntax")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DespawnRange.<init>(IntOr.Default)",
    "void DespawnRange.<init>(IntOr.Default, IntOr.Default, boolean)",
    "boolean DespawnRange.wasDefinedViaLongSyntax()"
  })
  void testGettersAndSetters_whenTrue_thenReturnWasDefinedViaLongSyntax() {
    // Arrange
    Default horizontalLimit = new Default(OptionalInt.empty());

    // Act
    DespawnRange actualDespawnRange =
        new DespawnRange(horizontalLimit, new Default(OptionalInt.empty()), true);

    // Assert
    assertTrue(actualDespawnRange.wasDefinedViaLongSyntax());
  }

  /**
   * Test {@link DespawnRange#preComputed(int, String)}.
   *
   * <ul>
   *   <li>Given {@link OptionalInt} with one.
   *   <li>When zero.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link DespawnRange#preComputed(int, String)}
   */
  @Test
  @DisplayName(
      "Test preComputed(int, String); given OptionalInt with one; when zero; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DespawnRange.preComputed(int, String)"})
  void testPreComputed_givenOptionalIntWithOne_whenZero_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    Default horizontalLimit = new Default(OptionalInt.empty());
    OptionalInt value = OptionalInt.of(1);
    Default verticalLimit = new Default(value);

    DespawnRange despawnRange = new DespawnRange(horizontalLimit, verticalLimit, true);

    // Act and Assert
    assertThrows(SerializationException.class, () -> despawnRange.preComputed(0, "42"));
  }

  /**
   * Test {@link DespawnRange#preComputed(int, String)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link DespawnRange#preComputed(int, String)}
   */
  @Test
  @DisplayName("Test preComputed(int, String); when zero; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DespawnRange.preComputed(int, String)"})
  void testPreComputed_whenZero_thenThrowSerializationException() throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(
        SerializationException.class,
        () -> new DespawnRange(new Default(OptionalInt.empty())).preComputed(0, "42"));
  }

  /**
   * Test Serializer {@link Serializer#deserialize(Type, ConfigurationNode)} with {@code Type},
   * {@code ConfigurationNode}.
   *
   * <p>Method under test: {@link Serializer#deserialize(Type, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test Serializer deserialize(Type, ConfigurationNode) with 'Type', 'ConfigurationNode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DespawnRange Serializer.deserialize(Type, ConfigurationNode)"})
  void testSerializerDeserializeWithTypeConfigurationNode() throws SerializationException {
    // Arrange
    Serializer serializer = new Serializer();
    PlaceholderForType type = new PlaceholderForType(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.hasChild(isA(Object[].class))).thenReturn(false);
    when(node.require(Mockito.<Class<Default>>any())).thenReturn(new Default(OptionalInt.empty()));

    // Act
    DespawnRange actualDeserializeResult = serializer.deserialize(type, node);

    // Assert
    verify(node, atLeast(1)).hasChild(isA(Object[].class));
    verify(node).require(isA(Class.class));
    assertFalse(actualDeserializeResult.wasDefinedViaLongSyntax());
  }

  /**
   * Test Serializer {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)} with {@code
   * type}, {@code despawnRange}, {@code node}.
   *
   * <p>Method under test: {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test Serializer serialize(Type, DespawnRange, ConfigurationNode) with 'type', 'despawnRange', 'node'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Serializer.serialize(Type, DespawnRange, ConfigurationNode)"})
  void testSerializerSerializeWithTypeDespawnRangeNode() throws SerializationException {
    // Arrange
    Serializer serializer = new Serializer();
    PlaceholderForType type = new PlaceholderForType(1);
    DespawnRange despawnRange = new DespawnRange(new Default(OptionalInt.empty()));

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    // Act
    serializer.serialize(type, despawnRange, node);

    // Assert
    verify(node).set(isA(Object.class));
  }

  /**
   * Test Serializer {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)} with {@code
   * type}, {@code despawnRange}, {@code node}.
   *
   * <p>Method under test: {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test Serializer serialize(Type, DespawnRange, ConfigurationNode) with 'type', 'despawnRange', 'node'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Serializer.serialize(Type, DespawnRange, ConfigurationNode)"})
  void testSerializerSerializeWithTypeDespawnRangeNode2() throws SerializationException {
    // Arrange
    Serializer serializer = new Serializer();
    PlaceholderForType type = new PlaceholderForType(1);
    DespawnRange despawnRange = new DespawnRange(new Default(OptionalInt.empty()));

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.set(Mockito.<Object>any()))
        .thenThrow(new SerializationException("An error occurred"));

    // Act and Assert
    assertThrows(
        SerializationException.class, () -> serializer.serialize(type, despawnRange, node));
    verify(node).set(isA(Object.class));
  }

  /**
   * Test Serializer {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)} with {@code
   * type}, {@code despawnRange}, {@code node}.
   *
   * <p>Method under test: {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test Serializer serialize(Type, DespawnRange, ConfigurationNode) with 'type', 'despawnRange', 'node'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Serializer.serialize(Type, DespawnRange, ConfigurationNode)"})
  void testSerializerSerializeWithTypeDespawnRangeNode3() throws SerializationException {
    // Arrange
    Serializer serializer = new Serializer();
    PlaceholderForType type = new PlaceholderForType(1);
    Default horizontalLimit = new Default(OptionalInt.empty());
    DespawnRange despawnRange =
        new DespawnRange(horizontalLimit, new Default(OptionalInt.empty()), true);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    serializer.serialize(type, despawnRange, node);

    // Assert
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode, atLeast(1)).set(isA(Object.class));
  }

  /**
   * Test Serializer {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)} with {@code
   * type}, {@code despawnRange}, {@code node}.
   *
   * <p>Method under test: {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test Serializer serialize(Type, DespawnRange, ConfigurationNode) with 'type', 'despawnRange', 'node'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Serializer.serialize(Type, DespawnRange, ConfigurationNode)"})
  void testSerializerSerializeWithTypeDespawnRangeNode4() throws SerializationException {
    // Arrange
    Serializer serializer = new Serializer();
    PlaceholderForType type = new PlaceholderForType(1);
    Default horizontalLimit = new Default(OptionalInt.empty());
    DespawnRange despawnRange =
        new DespawnRange(horizontalLimit, new Default(OptionalInt.empty()), true);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any()))
        .thenThrow(new SerializationException("An error occurred"));

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act and Assert
    assertThrows(
        SerializationException.class, () -> serializer.serialize(type, despawnRange, node));
    verify(node).node(isA(Object[].class));
    verify(configurationNode).set(isA(Object.class));
  }

  /**
   * Test Serializer {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)} with {@code
   * type}, {@code despawnRange}, {@code node}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link ConfigurationNode#raw(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Serializer#serialize(Type, DespawnRange, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test Serializer serialize(Type, DespawnRange, ConfigurationNode) with 'type', 'despawnRange', 'node'; when 'null'; then calls raw(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Serializer.serialize(Type, DespawnRange, ConfigurationNode)"})
  void testSerializerSerializeWithTypeDespawnRangeNode_whenNull_thenCallsRaw()
      throws SerializationException {
    // Arrange
    Serializer serializer = new Serializer();
    PlaceholderForType type = new PlaceholderForType(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    // Act
    serializer.serialize(type, null, node);

    // Assert
    verify(node).raw(isNull());
  }

  /**
   * Test {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}.
   *
   * <ul>
   *   <li>Given {@link IntOr.Default#Default(OptionalInt)} with value is empty.
   *   <li>When {@code CYLINDER}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shouldDespawn(Shape, double, double, double, double); given Default(OptionalInt) with value is empty; when 'CYLINDER'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DespawnRange.shouldDespawn(Shape, double, double, double, double)"})
  void testShouldDespawn_givenDefaultWithValueIsEmpty_whenCylinder_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new DespawnRange(new Default(OptionalInt.empty()))
            .shouldDespawn(Shape.CYLINDER, Double.NaN, 10.0d, 10.0d, Double.NaN));
  }

  /**
   * Test {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}.
   *
   * <ul>
   *   <li>Given {@link IntOr.Default#Default(OptionalInt)} with value is empty.
   *   <li>When {@code CYLINDER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shouldDespawn(Shape, double, double, double, double); given Default(OptionalInt) with value is empty; when 'CYLINDER'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DespawnRange.shouldDespawn(Shape, double, double, double, double)"})
  void testShouldDespawn_givenDefaultWithValueIsEmpty_whenCylinder_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new DespawnRange(new Default(OptionalInt.empty()))
            .shouldDespawn(Shape.CYLINDER, 10.0d, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}.
   *
   * <ul>
   *   <li>Given {@link IntOr.Default#Default(OptionalInt)} with value is empty.
   *   <li>When {@code CYLINDER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shouldDespawn(Shape, double, double, double, double); given Default(OptionalInt) with value is empty; when 'CYLINDER'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DespawnRange.shouldDespawn(Shape, double, double, double, double)"})
  void testShouldDespawn_givenDefaultWithValueIsEmpty_whenCylinder_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(
        new DespawnRange(new Default(OptionalInt.empty()))
            .shouldDespawn(Shape.CYLINDER, Double.NaN, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}.
   *
   * <ul>
   *   <li>Given {@link IntOr.Default#Default(OptionalInt)} with value is empty.
   *   <li>When {@code ELLIPSOID}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shouldDespawn(Shape, double, double, double, double); given Default(OptionalInt) with value is empty; when 'ELLIPSOID'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DespawnRange.shouldDespawn(Shape, double, double, double, double)"})
  void testShouldDespawn_givenDefaultWithValueIsEmpty_whenEllipsoid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new DespawnRange(new Default(OptionalInt.empty()))
            .shouldDespawn(Shape.ELLIPSOID, Double.NaN, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}.
   *
   * <ul>
   *   <li>Given {@link IntOr.Default#Default(OptionalInt)} with value is empty.
   *   <li>When {@link Shape#ELLIPSOID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DespawnRange#shouldDespawn(Shape, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shouldDespawn(Shape, double, double, double, double); given Default(OptionalInt) with value is empty; when ELLIPSOID; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DespawnRange.shouldDespawn(Shape, double, double, double, double)"})
  void testShouldDespawn_givenDefaultWithValueIsEmpty_whenEllipsoid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new DespawnRange(new Default(OptionalInt.empty()))
            .shouldDespawn(Shape.ELLIPSOID, 10.0d, 10.0d, 10.0d, 10.0d));
  }
}
