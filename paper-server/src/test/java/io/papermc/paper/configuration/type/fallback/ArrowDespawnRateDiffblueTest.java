package io.papermc.paper.configuration.type.fallback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.type.fallback.FallbackValue.ContextKey;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spigotmc.SpigotWorldConfig;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ArrowDespawnRateDiffblueTest {
  /**
   * Test {@link ArrowDespawnRate#ArrowDespawnRate(Map, Object)}.
   *
   * <ul>
   *   <li>When {@link ContextKey#ContextKey(String)} with name is {@code default}.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#ArrowDespawnRate(Map, Object)}
   */
  @Test
  @DisplayName(
      "Test new ArrowDespawnRate(Map, Object); when ContextKey(String) with name is 'default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrowDespawnRate.<init>(Map, Object)"})
  void testNewArrowDespawnRate_whenContextKeyWithNameIsDefault() throws SerializationException {
    // Arrange
    HashMap<ContextKey<?>, Object> context = new HashMap<>();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> new ArrowDespawnRate(context, new ContextKey<>("default")));
  }

  /**
   * Test {@link ArrowDespawnRate#ArrowDespawnRate(Map, Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#ArrowDespawnRate(Map, Object)}
   */
  @Test
  @DisplayName(
      "Test new ArrowDespawnRate(Map, Object); when empty string; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrowDespawnRate.<init>(Map, Object)"})
  void testNewArrowDespawnRate_whenEmptyString_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(SerializationException.class, () -> new ArrowDespawnRate(new HashMap<>(), ""));
  }

  /**
   * Test {@link ArrowDespawnRate#ArrowDespawnRate(Map, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#ArrowDespawnRate(Map, Object)}
   */
  @Test
  @DisplayName(
      "Test new ArrowDespawnRate(Map, Object); when 'Value'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrowDespawnRate.<init>(Map, Object)"})
  void testNewArrowDespawnRate_whenValue_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(
        SerializationException.class, () -> new ArrowDespawnRate(new HashMap<>(), "Value"));
  }

  /**
   * Test {@link ArrowDespawnRate#ArrowDespawnRate(Map, Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#ArrowDespawnRate(Map, Object)}
   */
  @Test
  @DisplayName(
      "Test new ArrowDespawnRate(Map, Object); when WILDCARD_OBJECT; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrowDespawnRate.<init>(Map, Object)"})
  void testNewArrowDespawnRate_whenWildcard_object_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(
        SerializationException.class,
        () -> new ArrowDespawnRate(new HashMap<>(), ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link ArrowDespawnRate#process(int)}.
   *
   * <ul>
   *   <li>Given def {@link SpigotWorldConfig}.
   *   <li>When forty-two.
   *   <li>Then return AsInt is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#process(int)}
   */
  @Test
  @DisplayName(
      "Test process(int); given def SpigotWorldConfig; when forty-two; then return AsInt is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt ArrowDespawnRate.process(int)"})
  void testProcess_givenDefSpigotWorldConfig_whenFortyTwo_thenReturnAsIntIsFortyTwo() {
    // Arrange and Act
    OptionalInt actualProcessResult =
        ArrowDespawnRate.def(mock(SpigotWorldConfig.class)).process(42);

    // Assert
    assertEquals(42, actualProcessResult.getAsInt());
    assertFalse(actualProcessResult.isEmpty());
    assertTrue(actualProcessResult.isPresent());
  }

  /**
   * Test {@link ArrowDespawnRate#process(int)}.
   *
   * <ul>
   *   <li>Given def {@link SpigotWorldConfig}.
   *   <li>When minus one.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#process(int)}
   */
  @Test
  @DisplayName(
      "Test process(int); given def SpigotWorldConfig; when minus one; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt ArrowDespawnRate.process(int)"})
  void testProcess_givenDefSpigotWorldConfig_whenMinusOne_thenReturnNotPresent() {
    // Arrange and Act
    OptionalInt actualProcessResult =
        ArrowDespawnRate.def(mock(SpigotWorldConfig.class)).process(-1);

    // Assert
    assertFalse(actualProcessResult.isPresent());
    assertTrue(actualProcessResult.isEmpty());
  }

  /**
   * Test {@link ArrowDespawnRate#required()}.
   *
   * <ul>
   *   <li>Given def {@link SpigotWorldConfig}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#required()}
   */
  @Test
  @DisplayName("Test required(); given def SpigotWorldConfig; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ArrowDespawnRate.required()"})
  void testRequired_givenDefSpigotWorldConfig_thenReturnSizeIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, ArrowDespawnRate.def(mock(SpigotWorldConfig.class)).required().size());
  }

  /**
   * Test {@link ArrowDespawnRate#fallback()}.
   *
   * <ul>
   *   <li>Given def {@link SpigotWorldConfig}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#fallback()}
   */
  @Test
  @DisplayName("Test fallback(); given def SpigotWorldConfig; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ArrowDespawnRate.fallback()"})
  void testFallback_givenDefSpigotWorldConfig_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrowDespawnRate.def(mock(SpigotWorldConfig.class)).fallback());
  }

  /**
   * Test {@link ArrowDespawnRate#def(SpigotWorldConfig)}.
   *
   * <ul>
   *   <li>When {@link SpigotWorldConfig}.
   *   <li>Then return fallback is zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrowDespawnRate#def(SpigotWorldConfig)}
   */
  @Test
  @DisplayName("Test def(SpigotWorldConfig); when SpigotWorldConfig; then return fallback is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrowDespawnRate ArrowDespawnRate.def(SpigotWorldConfig)"})
  void testDef_whenSpigotWorldConfig_thenReturnFallbackIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrowDespawnRate.def(mock(SpigotWorldConfig.class)).fallback());
  }
}
