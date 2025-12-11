package io.papermc.paper.configuration.type.fallback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.leangen.geantyref.TypeToken;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spigotmc.SpigotWorldConfig;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class FallbackValueSerializerDiffblueTest {
  /**
   * Test {@link FallbackValueSerializer#FallbackValueSerializer(Map)}.
   *
   * <p>Method under test: {@link FallbackValueSerializer#FallbackValueSerializer(Map)}
   */
  @Test
  @DisplayName("Test new FallbackValueSerializer(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FallbackValueSerializer.<init>(Map)"})
  void testNewFallbackValueSerializer() {
    // Arrange, Act and Assert
    TypeToken<FallbackValue> typeResult = new FallbackValueSerializer(new HashMap<>()).type();
    AnnotatedType annotatedType = typeResult.getAnnotatedType();
    assertNull(annotatedType.getAnnotatedOwnerType());
    assertEquals(annotatedType, typeResult.getCanonicalType());
  }

  /**
   * Test {@link FallbackValueSerializer#deserialize(Type, Object)} with {@code Type}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then calls {@link GenericArrayType#getGenericComponentType()}.
   * </ul>
   *
   * <p>Method under test: {@link FallbackValueSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; then calls getGenericComponentType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FallbackValue FallbackValueSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_thenCallsGetGenericComponentType()
      throws SerializationException {
    // Arrange
    FallbackValueSerializer fallbackValueSerializer = new FallbackValueSerializer(new HashMap<>());

    GenericArrayType type = mock(GenericArrayType.class);
    Class<Object> forNameResult = Object.class;
    when(type.getGenericComponentType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () ->
            fallbackValueSerializer.deserialize(type, ConfigurationTransformation.WILDCARD_OBJECT));
    verify(type).getGenericComponentType();
  }

  /**
   * Test {@link FallbackValueSerializer#deserialize(Type, Object)} with {@code Type}, {@code
   * Object}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link FallbackValueSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; when 'java.lang.Object'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FallbackValue FallbackValueSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenJavaLangObject_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    FallbackValueSerializer fallbackValueSerializer = new FallbackValueSerializer(new HashMap<>());
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () ->
            fallbackValueSerializer.deserialize(type, ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link FallbackValueSerializer#serialize(FallbackValue, Predicate)} with {@code
   * FallbackValue}, {@code Predicate}.
   *
   * <ul>
   *   <li>When def.
   *   <li>Then return {@code default}.
   * </ul>
   *
   * <p>Method under test: {@link FallbackValueSerializer#serialize(FallbackValue, Predicate)}
   */
  @Test
  @DisplayName(
      "Test serialize(FallbackValue, Predicate) with 'FallbackValue', 'Predicate'; when def; then return 'default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FallbackValueSerializer.serialize(FallbackValue, Predicate)"})
  void testSerializeWithFallbackValuePredicate_whenDef_thenReturnDefault() {
    // Arrange
    FallbackValueSerializer fallbackValueSerializer = new FallbackValueSerializer(new HashMap<>());

    // Act and Assert
    assertEquals(
        "default", fallbackValueSerializer.serialize(AutosavePeriod.def(), mock(Predicate.class)));
  }

  /**
   * Test {@link FallbackValueSerializer#create(SpigotWorldConfig, Supplier)}.
   *
   * <ul>
   *   <li>Then return type AnnotatedType AnnotatedOwnerType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FallbackValueSerializer#create(SpigotWorldConfig, Supplier)}
   */
  @Test
  @DisplayName(
      "Test create(SpigotWorldConfig, Supplier); then return type AnnotatedType AnnotatedOwnerType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FallbackValueSerializer FallbackValueSerializer.create(SpigotWorldConfig, Supplier)"
  })
  void testCreate_thenReturnTypeAnnotatedTypeAnnotatedOwnerTypeIsNull() {
    // Arrange, Act and Assert
    TypeToken<FallbackValue> typeResult =
        FallbackValueSerializer.create(mock(SpigotWorldConfig.class), mock(Supplier.class)).type();
    AnnotatedType annotatedType = typeResult.getAnnotatedType();
    assertNull(annotatedType.getAnnotatedOwnerType());
    assertEquals(annotatedType, typeResult.getCanonicalType());
  }
}
