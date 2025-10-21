package io.papermc.paper.configuration.type.fallback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.type.fallback.FallbackValue.ContextKey;
import io.papermc.paper.configuration.type.fallback.FallbackValue.Int;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spigotmc.SpigotWorldConfig;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class FallbackValueDiffblueTest {
  /**
   * Test ContextKey getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ContextKey#ContextKey(String)}
   *   <li>{@link ContextKey#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test ContextKey getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContextKey.<init>(String)", "String ContextKey.toString()"})
  void testContextKeyGettersAndSetters() {
    // Arrange and Act
    ContextKey<Object> actualContextKey = new ContextKey<>("Name");

    // Assert
    assertEquals("Name", actualContextKey.toString());
  }

  /**
   * Test ContextKey {@link ContextKey#singleton(Object)}.
   *
   * <p>Method under test: {@link ContextKey#singleton(Object)}
   */
  @Test
  @DisplayName("Test ContextKey singleton(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map ContextKey.singleton(Object)"})
  void testContextKeySingleton() {
    // Arrange
    ContextKey<Object> contextKey = new ContextKey<>("Name");

    // Act and Assert
    assertEquals(1, contextKey.singleton(ConfigurationTransformation.WILDCARD_OBJECT).size());
  }

  /**
   * Test Int {@link Int#fromObject(Object)}.
   *
   * <ul>
   *   <li>When {@code -1}.
   *   <li>Then return AsInt is minus one.
   * </ul>
   *
   * <p>Method under test: {@link Int#fromObject(Object)}
   */
  @Test
  @DisplayName("Test Int fromObject(Object); when '-1'; then return AsInt is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Int.fromObject(Object)"})
  void testIntFromObject_when1_thenReturnAsIntIsMinusOne() throws SerializationException {
    // Arrange and Act
    OptionalInt actualFromObjectResult = Int.fromObject("-1");

    // Assert
    assertEquals(-1, actualFromObjectResult.getAsInt());
    assertTrue(actualFromObjectResult.isPresent());
  }

  /**
   * Test Int {@link Int#fromObject(Object)}.
   *
   * <ul>
   *   <li>When {@code 1}.
   *   <li>Then return AsInt is one.
   * </ul>
   *
   * <p>Method under test: {@link Int#fromObject(Object)}
   */
  @Test
  @DisplayName("Test Int fromObject(Object); when '1'; then return AsInt is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Int.fromObject(Object)"})
  void testIntFromObject_when1_thenReturnAsIntIsOne() throws SerializationException {
    // Arrange and Act
    OptionalInt actualFromObjectResult = Int.fromObject("1");

    // Assert
    assertEquals(1, actualFromObjectResult.getAsInt());
    assertTrue(actualFromObjectResult.isPresent());
  }

  /**
   * Test Int {@link Int#fromObject(Object)}.
   *
   * <ul>
   *   <li>When {@code default}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link Int#fromObject(Object)}
   */
  @Test
  @DisplayName("Test Int fromObject(Object); when 'default'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Int.fromObject(Object)"})
  void testIntFromObject_whenDefault_thenReturnNotPresent() throws SerializationException {
    // Arrange, Act and Assert
    assertFalse(Int.fromObject("default").isPresent());
  }

  /**
   * Test Int {@link Int#fromObject(Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link Int#fromObject(Object)}
   */
  @Test
  @DisplayName("Test Int fromObject(Object); when empty string; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Int.fromObject(Object)"})
  void testIntFromObject_whenEmptyString_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(SerializationException.class, () -> Int.fromObject(""));
  }

  /**
   * Test Int {@link Int#fromObject(Object)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link Int#fromObject(Object)}
   */
  @Test
  @DisplayName("Test Int fromObject(Object); when empty; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Int.fromObject(Object)"})
  void testIntFromObject_whenEmpty_thenReturnNotPresent() throws SerializationException {
    // Arrange, Act and Assert
    assertFalse(Int.fromObject(OptionalInt.empty()).isPresent());
  }

  /**
   * Test Int {@link Int#fromObject(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link Int#fromObject(Object)}
   */
  @Test
  @DisplayName("Test Int fromObject(Object); when 'Obj'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Int.fromObject(Object)"})
  void testIntFromObject_whenObj_thenThrowSerializationException() throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(SerializationException.class, () -> Int.fromObject("Obj"));
  }

  /**
   * Test Int {@link Int#fromObject(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return AsInt is one.
   * </ul>
   *
   * <p>Method under test: {@link Int#fromObject(Object)}
   */
  @Test
  @DisplayName("Test Int fromObject(Object); when one; then return AsInt is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Int.fromObject(Object)"})
  void testIntFromObject_whenOne_thenReturnAsIntIsOne() throws SerializationException {
    // Arrange and Act
    OptionalInt actualFromObjectResult = Int.fromObject(1);

    // Assert
    assertEquals(1, actualFromObjectResult.getAsInt());
    assertTrue(actualFromObjectResult.isPresent());
  }

  /**
   * Test Int {@link Int#fromObject(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link Int#fromObject(Object)}
   */
  @Test
  @DisplayName(
      "Test Int fromObject(Object); when WILDCARD_OBJECT; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Int.fromObject(Object)"})
  void testIntFromObject_whenWildcard_object_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(
        SerializationException.class,
        () -> Int.fromObject(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test Int {@link Int#serialize()}.
   *
   * <ul>
   *   <li>Given def {@link SpigotWorldConfig}.
   *   <li>Then return {@code default}.
   * </ul>
   *
   * <p>Method under test: {@link Int#serialize()}
   */
  @Test
  @DisplayName("Test Int serialize(); given def SpigotWorldConfig; then return 'default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Int.serialize()"})
  void testIntSerialize_givenDefSpigotWorldConfig_thenReturnDefault() {
    // Arrange, Act and Assert
    assertEquals("default", ArrowDespawnRate.def(mock(SpigotWorldConfig.class)).serialize());
  }

  /**
   * Test Int {@link Int#value()}.
   *
   * <ul>
   *   <li>Given def {@link SpigotWorldConfig}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Int#value()}
   */
  @Test
  @DisplayName("Test Int value(); given def SpigotWorldConfig; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Int.value()"})
  void testIntValue_givenDefSpigotWorldConfig_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrowDespawnRate.def(mock(SpigotWorldConfig.class)).value());
  }
}
