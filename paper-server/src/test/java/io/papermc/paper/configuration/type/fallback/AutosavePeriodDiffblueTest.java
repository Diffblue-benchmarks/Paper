package io.papermc.paper.configuration.type.fallback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.type.fallback.FallbackValue.ContextKey;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class AutosavePeriodDiffblueTest {
  /**
   * Test {@link AutosavePeriod#AutosavePeriod(Map, Object)}.
   *
   * <ul>
   *   <li>When {@link ContextKey#ContextKey(String)} with name is {@code default}.
   * </ul>
   *
   * <p>Method under test: {@link AutosavePeriod#AutosavePeriod(Map, Object)}
   */
  @Test
  @DisplayName(
      "Test new AutosavePeriod(Map, Object); when ContextKey(String) with name is 'default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutosavePeriod.<init>(Map, Object)"})
  void testNewAutosavePeriod_whenContextKeyWithNameIsDefault() throws SerializationException {
    // Arrange
    HashMap<ContextKey<?>, Object> contextMap = new HashMap<>();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> new AutosavePeriod(contextMap, new ContextKey<>("default")));
  }

  /**
   * Test {@link AutosavePeriod#AutosavePeriod(Map, Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link AutosavePeriod#AutosavePeriod(Map, Object)}
   */
  @Test
  @DisplayName(
      "Test new AutosavePeriod(Map, Object); when empty string; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutosavePeriod.<init>(Map, Object)"})
  void testNewAutosavePeriod_whenEmptyString_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(SerializationException.class, () -> new AutosavePeriod(new HashMap<>(), ""));
  }

  /**
   * Test {@link AutosavePeriod#AutosavePeriod(Map, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link AutosavePeriod#AutosavePeriod(Map, Object)}
   */
  @Test
  @DisplayName(
      "Test new AutosavePeriod(Map, Object); when 'Value'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutosavePeriod.<init>(Map, Object)"})
  void testNewAutosavePeriod_whenValue_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(SerializationException.class, () -> new AutosavePeriod(new HashMap<>(), "Value"));
  }

  /**
   * Test {@link AutosavePeriod#AutosavePeriod(Map, Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link AutosavePeriod#AutosavePeriod(Map, Object)}
   */
  @Test
  @DisplayName(
      "Test new AutosavePeriod(Map, Object); when WILDCARD_OBJECT; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutosavePeriod.<init>(Map, Object)"})
  void testNewAutosavePeriod_whenWildcard_object_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(
        SerializationException.class,
        () -> new AutosavePeriod(new HashMap<>(), ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link AutosavePeriod#process(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return AsInt is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AutosavePeriod#process(int)}
   */
  @Test
  @DisplayName("Test process(int); when forty-two; then return AsInt is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt AutosavePeriod.process(int)"})
  void testProcess_whenFortyTwo_thenReturnAsIntIsFortyTwo() {
    // Arrange and Act
    OptionalInt actualProcessResult = AutosavePeriod.def().process(42);

    // Assert
    assertEquals(42, actualProcessResult.getAsInt());
    assertTrue(actualProcessResult.isPresent());
  }

  /**
   * Test {@link AutosavePeriod#process(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link AutosavePeriod#process(int)}
   */
  @Test
  @DisplayName("Test process(int); when minus one; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt AutosavePeriod.process(int)"})
  void testProcess_whenMinusOne_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(AutosavePeriod.def().process(-1).isPresent());
  }

  /**
   * Test {@link AutosavePeriod#required()}.
   *
   * <p>Method under test: {@link AutosavePeriod#required()}
   */
  @Test
  @DisplayName("Test required()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AutosavePeriod.required()"})
  void testRequired() {
    // Arrange, Act and Assert
    assertEquals(1, AutosavePeriod.def().required().size());
  }

  /**
   * Test {@link AutosavePeriod#def()}.
   *
   * <p>Method under test: {@link AutosavePeriod#def()}
   */
  @Test
  @DisplayName("Test def()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AutosavePeriod AutosavePeriod.def()"})
  void testDef() {
    // Arrange and Act
    AutosavePeriod actualDefResult = AutosavePeriod.def();

    // Assert
    assertEquals("default", actualDefResult.serialize());
    assertEquals(1, actualDefResult.required().size());
  }
}
