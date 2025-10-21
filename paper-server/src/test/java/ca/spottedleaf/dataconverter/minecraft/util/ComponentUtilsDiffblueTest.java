package ca.spottedleaf.dataconverter.minecraft.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ComponentUtilsDiffblueTest {
  /**
   * Test {@link ComponentUtils#createPlainTextComponent(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link ComponentUtils#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#createPlainTextComponent(String)}
   */
  @Test
  @DisplayName("Test createPlainTextComponent(String); when empty string; then return EMPTY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.createPlainTextComponent(String)"})
  void testCreatePlainTextComponent_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(ComponentUtils.EMPTY, ComponentUtils.createPlainTextComponent(""));
  }

  /**
   * Test {@link ComponentUtils#createPlainTextComponent(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code {"text":null}}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#createPlainTextComponent(String)}
   */
  @Test
  @DisplayName("Test createPlainTextComponent(String); when 'null'; then return '{\"text\":null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.createPlainTextComponent(String)"})
  void testCreatePlainTextComponent_whenNull_thenReturnTextNull() {
    // Arrange, Act and Assert
    assertEquals("{\"text\":null}", ComponentUtils.createPlainTextComponent(null));
  }

  /**
   * Test {@link ComponentUtils#createPlainTextComponent(String)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then return {@code {"text":"Text"}}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#createPlainTextComponent(String)}
   */
  @Test
  @DisplayName(
      "Test createPlainTextComponent(String); when 'Text'; then return '{\"text\":\"Text\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.createPlainTextComponent(String)"})
  void testCreatePlainTextComponent_whenText_thenReturnTextText() {
    // Arrange, Act and Assert
    assertEquals("{\"text\":\"Text\"}", ComponentUtils.createPlainTextComponent("Text"));
  }

  /**
   * Test {@link ComponentUtils#createTranslatableComponent(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code {"translate":""}}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#createTranslatableComponent(String)}
   */
  @Test
  @DisplayName(
      "Test createTranslatableComponent(String); when empty string; then return '{\"translate\":\"\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.createTranslatableComponent(String)"})
  void testCreateTranslatableComponent_whenEmptyString_thenReturnTranslate() {
    // Arrange, Act and Assert
    assertEquals("{\"translate\":\"\"}", ComponentUtils.createTranslatableComponent(""));
  }

  /**
   * Test {@link ComponentUtils#createTranslatableComponent(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code {"translate":"Key"}}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#createTranslatableComponent(String)}
   */
  @Test
  @DisplayName(
      "Test createTranslatableComponent(String); when 'Key'; then return '{\"translate\":\"Key\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.createTranslatableComponent(String)"})
  void testCreateTranslatableComponent_whenKey_thenReturnTranslateKey() {
    // Arrange, Act and Assert
    assertEquals("{\"translate\":\"Key\"}", ComponentUtils.createTranslatableComponent("Key"));
  }

  /**
   * Test {@link ComponentUtils#createTranslatableComponent(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code {"translate":null}}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#createTranslatableComponent(String)}
   */
  @Test
  @DisplayName(
      "Test createTranslatableComponent(String); when 'null'; then return '{\"translate\":null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.createTranslatableComponent(String)"})
  void testCreateTranslatableComponent_whenNull_thenReturnTranslateNull() {
    // Arrange, Act and Assert
    assertEquals("{\"translate\":null}", ComponentUtils.createTranslatableComponent(null));
  }

  /**
   * Test {@link ComponentUtils#retrieveTranslationString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#retrieveTranslationString(String)}
   */
  @Test
  @DisplayName("Test retrieveTranslationString(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.retrieveTranslationString(String)"})
  void testRetrieveTranslationString_when42() {
    // Arrange, Act and Assert
    assertNull(ComponentUtils.retrieveTranslationString("42"));
  }

  /**
   * Test {@link ComponentUtils#retrieveTranslationString(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#retrieveTranslationString(String)}
   */
  @Test
  @DisplayName("Test retrieveTranslationString(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.retrieveTranslationString(String)"})
  void testRetrieveTranslationString_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(ComponentUtils.retrieveTranslationString(""));
  }

  /**
   * Test {@link ComponentUtils#retrieveTranslationString(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#retrieveTranslationString(String)}
   */
  @Test
  @DisplayName("Test retrieveTranslationString(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.retrieveTranslationString(String)"})
  void testRetrieveTranslationString_whenNull() {
    // Arrange, Act and Assert
    assertNull(ComponentUtils.retrieveTranslationString(null));
  }

  /**
   * Test {@link ComponentUtils#retrieveTranslationString(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#retrieveTranslationString(String)}
   */
  @Test
  @DisplayName("Test retrieveTranslationString(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.retrieveTranslationString(String)"})
  void testRetrieveTranslationString_whenNull2() {
    // Arrange, Act and Assert
    assertNull(ComponentUtils.retrieveTranslationString("null"));
  }

  /**
   * Test {@link ComponentUtils#retrieveTranslationString(String)}.
   *
   * <ul>
   *   <li>When {@code nullPossible Json}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#retrieveTranslationString(String)}
   */
  @Test
  @DisplayName("Test retrieveTranslationString(String); when 'nullPossible Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.retrieveTranslationString(String)"})
  void testRetrieveTranslationString_whenNullPossibleJson() {
    // Arrange, Act and Assert
    assertNull(ComponentUtils.retrieveTranslationString("nullPossible Json"));
  }

  /**
   * Test {@link ComponentUtils#retrieveTranslationString(String)}.
   *
   * <ul>
   *   <li>When {@code Possible Json}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#retrieveTranslationString(String)}
   */
  @Test
  @DisplayName("Test retrieveTranslationString(String); when 'Possible Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.retrieveTranslationString(String)"})
  void testRetrieveTranslationString_whenPossibleJson() {
    // Arrange, Act and Assert
    assertNull(ComponentUtils.retrieveTranslationString("Possible Json"));
  }

  /**
   * Test {@link ComponentUtils#retrieveTranslationString(String)}.
   *
   * <ul>
   *   <li>When {@code translate}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#retrieveTranslationString(String)}
   */
  @Test
  @DisplayName("Test retrieveTranslationString(String); when 'translate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.retrieveTranslationString(String)"})
  void testRetrieveTranslationString_whenTranslate() {
    // Arrange, Act and Assert
    assertNull(ComponentUtils.retrieveTranslationString("translate"));
  }

  /**
   * Test {@link ComponentUtils#convertFromLenient(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link ComponentUtils#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#convertFromLenient(String)}
   */
  @Test
  @DisplayName("Test convertFromLenient(String); when empty string; then return EMPTY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.convertFromLenient(String)"})
  void testConvertFromLenient_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(ComponentUtils.EMPTY, ComponentUtils.convertFromLenient(""));
  }

  /**
   * Test {@link ComponentUtils#convertFromLenient(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code {"text":"Input"}}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#convertFromLenient(String)}
   */
  @Test
  @DisplayName("Test convertFromLenient(String); when 'Input'; then return '{\"text\":\"Input\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.convertFromLenient(String)"})
  void testConvertFromLenient_whenInput_thenReturnTextInput() {
    // Arrange, Act and Assert
    assertEquals("{\"text\":\"Input\"}", ComponentUtils.convertFromLenient("Input"));
  }

  /**
   * Test {@link ComponentUtils#convertFromLenient(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link ComponentUtils#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#convertFromLenient(String)}
   */
  @Test
  @DisplayName("Test convertFromLenient(String); when 'null'; then return EMPTY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.convertFromLenient(String)"})
  void testConvertFromLenient_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(ComponentUtils.EMPTY, ComponentUtils.convertFromLenient("null"));
  }

  /**
   * Test {@link ComponentUtils#convertFromLenient(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#convertFromLenient(String)}
   */
  @Test
  @DisplayName("Test convertFromLenient(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ComponentUtils.convertFromLenient(String)"})
  void testConvertFromLenient_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ComponentUtils.convertFromLenient(null));
  }

  /**
   * Test {@link ComponentUtils#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#isValidJson(String)}
   */
  @Test
  @DisplayName("Test isValidJson(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComponentUtils.isValidJson(String)"})
  void testIsValidJson_when42() {
    // Arrange, Act and Assert
    assertTrue(ComponentUtils.isValidJson("42"));
  }

  /**
   * Test {@link ComponentUtils#isValidJson(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#isValidJson(String)}
   */
  @Test
  @DisplayName("Test isValidJson(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComponentUtils.isValidJson(String)"})
  void testIsValidJson_whenEmptyString() {
    // Arrange, Act and Assert
    assertTrue(ComponentUtils.isValidJson(""));
  }

  /**
   * Test {@link ComponentUtils#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#isValidJson(String)}
   */
  @Test
  @DisplayName("Test isValidJson(String); when 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComponentUtils.isValidJson(String)"})
  void testIsValidJson_whenInput() {
    // Arrange, Act and Assert
    assertTrue(ComponentUtils.isValidJson("Input"));
  }

  /**
   * Test {@link ComponentUtils#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#isValidJson(String)}
   */
  @Test
  @DisplayName("Test isValidJson(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComponentUtils.isValidJson(String)"})
  void testIsValidJson_whenNull() {
    // Arrange, Act and Assert
    assertTrue(ComponentUtils.isValidJson("null"));
  }

  /**
   * Test {@link ComponentUtils#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code nullInput}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#isValidJson(String)}
   */
  @Test
  @DisplayName("Test isValidJson(String); when 'nullInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComponentUtils.isValidJson(String)"})
  void testIsValidJson_whenNullInput() {
    // Arrange, Act and Assert
    assertTrue(ComponentUtils.isValidJson("nullInput"));
  }

  /**
   * Test {@link ComponentUtils#isValidJson(String)}.
   *
   * <ul>
   *   <li>When {@code translate}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentUtils#isValidJson(String)}
   */
  @Test
  @DisplayName("Test isValidJson(String); when 'translate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComponentUtils.isValidJson(String)"})
  void testIsValidJson_whenTranslate() {
    // Arrange, Act and Assert
    assertTrue(ComponentUtils.isValidJson("translate"));
  }
}
