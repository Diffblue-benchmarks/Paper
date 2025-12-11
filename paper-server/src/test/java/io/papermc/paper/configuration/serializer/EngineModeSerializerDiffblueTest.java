package io.papermc.paper.configuration.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.configuration.type.EngineMode;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class EngineModeSerializerDiffblueTest {
  /**
   * Test new {@link EngineModeSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EngineModeSerializer}
   */
  @Test
  @DisplayName("Test new EngineModeSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EngineModeSerializer.<init>()"})
  void testNewEngineModeSerializer() {
    // Arrange, Act and Assert
    TypeToken<EngineMode> typeResult = new EngineModeSerializer().type();
    AnnotatedType annotatedType = typeResult.getAnnotatedType();
    assertNull(annotatedType.getAnnotatedOwnerType());
    assertEquals(annotatedType, typeResult.getCanonicalType());
  }

  /**
   * Test {@link EngineModeSerializer#deserialize(Type, Object)} with {@code Type}, {@code Object}.
   *
   * <ul>
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link EngineModeSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EngineMode EngineModeSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    EngineModeSerializer engineModeSerializer = new EngineModeSerializer();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () ->
            engineModeSerializer.deserialize(
                new PlaceholderForType(1), ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link EngineModeSerializer#deserialize(Type, Object)} with {@code Type}, {@code Object}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code HIDE}.
   * </ul>
   *
   * <p>Method under test: {@link EngineModeSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName("Test deserialize(Type, Object) with 'Type', 'Object'; when one; then return 'HIDE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EngineMode EngineModeSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenOne_thenReturnHide() throws SerializationException {
    // Arrange
    EngineModeSerializer engineModeSerializer = new EngineModeSerializer();

    // Act and Assert
    assertEquals(EngineMode.HIDE, engineModeSerializer.deserialize(new PlaceholderForType(1), 1));
  }

  /**
   * Test {@link EngineModeSerializer#deserialize(Type, Object)} with {@code Type}, {@code Object}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link EngineModeSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; when zero; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EngineMode EngineModeSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenZero_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    EngineModeSerializer engineModeSerializer = new EngineModeSerializer();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> engineModeSerializer.deserialize(new PlaceholderForType(1), 0));
  }

  /**
   * Test {@link EngineModeSerializer#serialize(EngineMode, Predicate)} with {@code EngineMode},
   * {@code Predicate}.
   *
   * <p>Method under test: {@link EngineModeSerializer#serialize(EngineMode, Predicate)}
   */
  @Test
  @DisplayName("Test serialize(EngineMode, Predicate) with 'EngineMode', 'Predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EngineModeSerializer.serialize(EngineMode, Predicate)"})
  void testSerializeWithEngineModePredicate() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        ((Integer) new EngineModeSerializer().serialize(EngineMode.HIDE, mock(Predicate.class)))
            .intValue());
  }
}
