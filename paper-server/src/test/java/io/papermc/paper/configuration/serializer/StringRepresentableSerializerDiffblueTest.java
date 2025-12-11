package io.papermc.paper.configuration.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.mojang.serialization.codecs.KeyDispatchCodec;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.adventure.AdventureCodecs;
import io.papermc.paper.adventure.AdventureCodecs.ClickEventType;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.util.function.Function;
import java.util.function.Predicate;
import net.kyori.adventure.text.event.ClickEvent;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.StringRepresentable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringRepresentableSerializerDiffblueTest {
  /**
   * Test new {@link StringRepresentableSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * StringRepresentableSerializer}
   */
  @Test
  @DisplayName("Test new StringRepresentableSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringRepresentableSerializer.<init>()"})
  void testNewStringRepresentableSerializer() {
    // Arrange, Act and Assert
    TypeToken<StringRepresentable> typeResult = new StringRepresentableSerializer().type();
    AnnotatedType annotatedType = typeResult.getAnnotatedType();
    assertNull(annotatedType.getAnnotatedOwnerType());
    assertEquals(annotatedType, typeResult.getCanonicalType());
  }

  /**
   * Test {@link StringRepresentableSerializer#isValidFor(Type)}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringRepresentableSerializer#isValidFor(Type)}
   */
  @Test
  @DisplayName(
      "Test isValidFor(Type); when PlaceholderForType(int) with ordinal is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringRepresentableSerializer.isValidFor(Type)"})
  void testIsValidFor_whenPlaceholderForTypeWithOrdinalIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringRepresentableSerializer.isValidFor(new PlaceholderForType(1)));
  }

  /**
   * Test {@link StringRepresentableSerializer#serialize(StringRepresentable, Predicate)} with
   * {@code StringRepresentable}, {@code Predicate}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StringRepresentableSerializer#serialize(StringRepresentable,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test serialize(StringRepresentable, Predicate) with 'StringRepresentable', 'Predicate'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object StringRepresentableSerializer.serialize(StringRepresentable, Predicate)"
  })
  void testSerializeWithStringRepresentablePredicate_thenReturn42() {
    // Arrange
    StringRepresentableSerializer stringRepresentableSerializer =
        new StringRepresentableSerializer();
    KeyDispatchCodec<Object, ClickEvent> codec =
        new KeyDispatchCodec<>(
            "Type Key", ExtraCodecs.JAVA, mock(Function.class), mock(Function.class));

    // Act and Assert
    assertEquals(
        "42",
        stringRepresentableSerializer.serialize(
            new ClickEventType(codec, "42"), mock(Predicate.class)));
  }
}
