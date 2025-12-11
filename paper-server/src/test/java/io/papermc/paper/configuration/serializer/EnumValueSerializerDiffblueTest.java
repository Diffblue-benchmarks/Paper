package io.papermc.paper.configuration.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.leangen.geantyref.TypeToken;
import java.lang.Character.UnicodeScript;
import java.lang.reflect.AnnotatedType;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnumValueSerializerDiffblueTest {
  /**
   * Test new {@link EnumValueSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EnumValueSerializer}
   */
  @Test
  @DisplayName("Test new EnumValueSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EnumValueSerializer.<init>()"})
  void testNewEnumValueSerializer() {
    // Arrange, Act and Assert
    TypeToken<Enum<?>> typeResult = new EnumValueSerializer().type();
    assertEquals("java.lang.Enum<?>", typeResult.getType().getTypeName());
    assertNull(typeResult.getAnnotatedType().getAnnotatedOwnerType());
  }

  /**
   * Test {@link EnumValueSerializer#serialize(AnnotatedType, Enum, Predicate)} with {@code
   * AnnotatedType}, {@code Enum}, {@code Predicate}.
   *
   * <ul>
   *   <li>Then return {@code COMMON}.
   * </ul>
   *
   * <p>Method under test: {@link EnumValueSerializer#serialize(AnnotatedType, Object, Predicate)}
   */
  @Test
  @DisplayName(
      "Test serialize(AnnotatedType, Enum, Predicate) with 'AnnotatedType', 'Enum', 'Predicate'; then return 'COMMON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EnumValueSerializer.serialize(AnnotatedType, Enum, Predicate)"})
  void testSerializeWithAnnotatedTypeEnumPredicate_thenReturnCommon() {
    // Arrange
    EnumValueSerializer enumValueSerializer = new EnumValueSerializer();

    // Act and Assert
    assertEquals(
        "COMMON", enumValueSerializer.serialize(null, UnicodeScript.of(1), mock(Predicate.class)));
  }
}
