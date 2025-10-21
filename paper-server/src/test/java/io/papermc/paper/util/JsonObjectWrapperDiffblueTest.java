package io.papermc.paper.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonObjectWrapperDiffblueTest {
  /**
   * Test {@link JsonObjectWrapper#JsonObjectWrapper(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return element is {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonObjectWrapper#JsonObjectWrapper(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test new JsonObjectWrapper(JsonElement); when JsonObject (default constructor); then return element is JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonObjectWrapper.<init>(JsonElement)"})
  void testNewJsonObjectWrapper_whenJsonObject_thenReturnElementIsJsonObject() {
    // Arrange
    JsonObject element = new JsonObject();

    // Act and Assert
    assertSame(element, new JsonObjectWrapper((JsonElement) element).element());
  }

  /**
   * Test {@link JsonObjectWrapper#serialize()}.
   *
   * <ul>
   *   <li>Then return {@code value} is {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonObjectWrapper#serialize()}
   */
  @Test
  @DisplayName("Test serialize(); then return 'value' is '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonObjectWrapper.serialize()"})
  void testSerialize_thenReturnValueIsLeftCurlyBracketRightCurlyBracket() {
    // Arrange and Act
    Map<String, Object> actualSerializeResult =
        new JsonObjectWrapper((JsonElement) new JsonObject()).serialize();

    // Assert
    assertEquals(1, actualSerializeResult.size());
    assertEquals("{}", actualSerializeResult.get("value"));
  }

  /**
   * Test {@link JsonObjectWrapper#serialize()}.
   *
   * <ul>
   *   <li>Then return {@code value} is {@code {"Property":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonObjectWrapper#serialize()}
   */
  @Test
  @DisplayName("Test serialize(); then return 'value' is '{\"Property\":[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonObjectWrapper.serialize()"})
  void testSerialize_thenReturnValueIsProperty() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("Property", new JsonArray(3));

    // Act
    Map<String, Object> actualSerializeResult =
        new JsonObjectWrapper((JsonElement) element).serialize();

    // Assert
    assertEquals(1, actualSerializeResult.size());
    assertEquals("{\"Property\":[]}", actualSerializeResult.get("value"));
  }

  /**
   * Test {@link JsonObjectWrapper#serialize()}.
   *
   * <ul>
   *   <li>Then return {@code value} is {@code {"Property":-1}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonObjectWrapper#serialize()}
   */
  @Test
  @DisplayName("Test serialize(); then return 'value' is '{\"Property\":-1}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonObjectWrapper.serialize()"})
  void testSerialize_thenReturnValueIsProperty1() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("Property", Bootstrap.bootstrapDuration);

    // Act
    Map<String, Object> actualSerializeResult =
        new JsonObjectWrapper((JsonElement) element).serialize();

    // Assert
    assertEquals(1, actualSerializeResult.size());
    assertEquals("{\"Property\":-1}", actualSerializeResult.get("value"));
  }

  /**
   * Test {@link JsonObjectWrapper#serialize()}.
   *
   * <ul>
   *   <li>Then return {@code value} is {@code {"Property":"value"}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonObjectWrapper#serialize()}
   */
  @Test
  @DisplayName("Test serialize(); then return 'value' is '{\"Property\":\"value\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonObjectWrapper.serialize()"})
  void testSerialize_thenReturnValueIsPropertyValue() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("Property", "value");

    // Act
    Map<String, Object> actualSerializeResult =
        new JsonObjectWrapper((JsonElement) element).serialize();

    // Assert
    assertEquals(1, actualSerializeResult.size());
    assertEquals("{\"Property\":\"value\"}", actualSerializeResult.get("value"));
  }
}
