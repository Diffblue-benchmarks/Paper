package ca.spottedleaf.dataconverter.types.json;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.types.ListType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.ObjectType;
import ca.spottedleaf.dataconverter.types.TypeUtil;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JsonMapTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonMapType#JsonMapType(JsonObject, boolean)}
   *   <li>{@link JsonMapType#toString()}
   *   <li>{@link JsonMapType#getJson()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JsonMapType.<init>(JsonObject, boolean)",
    "JsonObject JsonMapType.getJson()",
    "String JsonMapType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    JsonObject map = new JsonObject();

    // Act
    JsonMapType actualJsonMapType = new JsonMapType(map, true);
    String actualToStringResult = actualJsonMapType.toString();

    // Assert
    assertEquals("JsonMapType{map={}, compressed=true}", actualToStringResult);
    assertSame(map, actualJsonMapType.getJson());
  }

  /**
   * Test {@link JsonMapType#JsonMapType(boolean)}.
   *
   * <p>Method under test: {@link JsonMapType#JsonMapType(boolean)}
   */
  @Test
  @DisplayName("Test new JsonMapType(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.<init>(boolean)"})
  void testNewJsonMapType() {
    // Arrange and Act
    JsonMapType actualJsonMapType = new JsonMapType(true);

    // Assert
    TypeUtil<JsonElement> typeUtil = actualJsonMapType.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, actualJsonMapType.size());
    JsonObject json = actualJsonMapType.getJson();
    assertEquals(0, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    assertTrue(json.isEmpty());
    assertTrue(actualJsonMapType.compressed);
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link JsonMapType#getTypeUtil()}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code false}.
   *   <li>Then return not Compressed.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getTypeUtil()}
   */
  @Test
  @DisplayName(
      "Test getTypeUtil(); given JsonMapType(boolean) with compressed is 'false'; then return not Compressed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeUtil JsonMapType.getTypeUtil()"})
  void testGetTypeUtil_givenJsonMapTypeWithCompressedIsFalse_thenReturnNotCompressed() {
    // Arrange and Act
    TypeUtil<JsonElement> actualTypeUtil = new JsonMapType(false).getTypeUtil();

    // Assert
    assertTrue(actualTypeUtil instanceof JsonTypeUtil);
    assertFalse(((JsonTypeUtil) actualTypeUtil).isCompressed());
  }

  /**
   * Test {@link JsonMapType#getTypeUtil()}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return Compressed.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getTypeUtil()}
   */
  @Test
  @DisplayName(
      "Test getTypeUtil(); given JsonMapType(boolean) with compressed is 'true'; then return Compressed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeUtil JsonMapType.getTypeUtil()"})
  void testGetTypeUtil_givenJsonMapTypeWithCompressedIsTrue_thenReturnCompressed() {
    // Arrange and Act
    TypeUtil<JsonElement> actualTypeUtil = new JsonMapType(true).getTypeUtil();

    // Assert
    assertTrue(actualTypeUtil instanceof JsonTypeUtil);
    assertTrue(((JsonTypeUtil) actualTypeUtil).isCompressed());
  }

  /**
   * Test {@link JsonMapType#equals(Object)}, and {@link JsonMapType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonMapType#equals(Object)}
   *   <li>{@link JsonMapType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.equals(Object)", "int JsonMapType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);
    JsonMapType jsonMapType2 = new JsonMapType(true);

    // Act and Assert
    assertEquals(jsonMapType, jsonMapType2);
    assertEquals(jsonMapType.hashCode(), jsonMapType2.hashCode());
  }

  /**
   * Test {@link JsonMapType#equals(Object)}, and {@link JsonMapType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonMapType#equals(Object)}
   *   <li>{@link JsonMapType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.equals(Object)", "int JsonMapType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act and Assert
    assertEquals(jsonMapType, jsonMapType);
    int expectedHashCodeResult = jsonMapType.hashCode();
    assertEquals(expectedHashCodeResult, jsonMapType.hashCode());
  }

  /**
   * Test {@link JsonMapType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.equals(Object)", "int JsonMapType.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonMapType(true), null);
  }

  /**
   * Test {@link JsonMapType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.equals(Object)", "int JsonMapType.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonMapType(true), "Different type to JsonMapType");
  }

  /**
   * Test {@link JsonMapType#size()}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#size()}
   */
  @Test
  @DisplayName(
      "Test size(); given JsonMapType(boolean) with compressed is 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.size()"})
  void testSize_givenJsonMapTypeWithCompressedIsTrue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new JsonMapType(true).size());
  }

  /**
   * Test {@link JsonMapType#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#isEmpty()}
   */
  @Test
  @DisplayName(
      "Test isEmpty(); given JsonMapType(boolean) with compressed is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.isEmpty()"})
  void testIsEmpty_givenJsonMapTypeWithCompressedIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new JsonMapType(true).isEmpty());
  }

  /**
   * Test {@link JsonMapType#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.isEmpty()"})
  void testIsEmpty_thenReturnFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).isEmpty());
  }

  /**
   * Test {@link JsonMapType#clear()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} {@link JsonObject#entrySet()} return {@link HashSet#HashSet()}.
   *   <li>Then calls {@link JsonObject#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#clear()}
   */
  @Test
  @DisplayName("Test clear(); given JsonObject entrySet() return HashSet(); then calls entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.clear()"})
  void testClear_givenJsonObjectEntrySetReturnHashSet_thenCallsEntrySet() {
    // Arrange
    JsonObject map = mock(JsonObject.class);
    when(map.entrySet()).thenReturn(new HashSet<>());

    // Act
    new JsonMapType(map, true).clear();

    // Assert
    verify(map).entrySet();
  }

  /**
   * Test {@link JsonMapType#keys()}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#keys()}
   */
  @Test
  @DisplayName(
      "Test keys(); given JsonMapType(boolean) with compressed is 'true'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonMapType.keys()"})
  void testKeys_givenJsonMapTypeWithCompressedIsTrue_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new JsonMapType(true).keys().isEmpty());
  }

  /**
   * Test {@link JsonMapType#keys()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#keys()}
   */
  @Test
  @DisplayName("Test keys(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonMapType.keys()"})
  void testKeys_thenReturnSizeIsOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act
    Set<String> actualKeysResult = new JsonMapType(map, true).keys();

    // Assert
    assertEquals(1, actualKeysResult.size());
    assertTrue(actualKeysResult.contains("Property"));
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonArray(int) with capacity is three add JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonArrayWithCapacityIsThreeAddJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(new JsonArray(3));
    value.add(true);

    JsonObject map = new JsonObject();
    map.add("Property", value);
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@link JsonObject}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonArray(int) with capacity is three add JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonArrayWithCapacityIsThreeAddJsonObject() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(new JsonObject());
    value.add(true);

    JsonObject map = new JsonObject();
    map.add("Property", value);
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given JsonArray(int) with capacity is three add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);

    JsonObject map = new JsonObject();
    map.add("Property", value);
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree3() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code 42} and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given JsonObject (default constructor) addProperty '42' and 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAddProperty42AndValue() {
    // Arrange
    JsonObject map = new JsonObject();
    map.addProperty("42", "Value");
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code 42} and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given JsonObject (default constructor) addProperty '42' and 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAddProperty42AndValue2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.addProperty("42", "Value");
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code 42} and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given JsonObject (default constructor) addProperty '42' and 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAddProperty42AndValue3() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    map.addProperty("42", "Value");
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonObject (default constructor) add 'Property' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAddPropertyAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonObject (default constructor) add 'Property' and JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAddPropertyAndJsonObject() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonObject());
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given JsonObject (default constructor) add 'Property' and 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_givenJsonObjectAddPropertyAndNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", null);
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#copy()}.
   *
   * <ul>
   *   <li>Then return {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return JsonMapType(boolean) with compressed is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.copy()"})
  void testCopy_thenReturnJsonMapTypeWithCompressedIsTrue() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    MapType actualCopyResult = jsonMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyResult);
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange, Act and Assert
    assertFalse(new JsonMapType(true).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new JsonMapType(true).hasKey(null, ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, false).hasKey("42", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("42", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link JsonObject}
   *       (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonObject (default constructor) add '42' and JsonObject (default constructor); when '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonObjectAdd42AndJsonObject_when42_thenReturnFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonObject());
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("42", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'true'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsTrue_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("42", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("42", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@code null}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given JsonObject (default constructor) add '42' and 'null'; when '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenJsonObjectAdd42AndNull_when42_thenReturnFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", null);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("42", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>When {@code BYTE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; when 'BYTE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_whenByte_thenReturnTrue() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).hasKey("42", ObjectType.BYTE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_whenKey_thenReturnFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link JsonMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>When {@code UNDEFINED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; when 'UNDEFINED'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_whenUndefined_thenReturnTrue() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).hasKey("42", ObjectType.UNDEFINED));
  }

  /**
   * Test {@link JsonMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String)"})
  void testHasKeyWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new JsonMapType(true).hasKey("Key"));
  }

  /**
   * Test {@link JsonMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String)"})
  void testHasKeyWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new JsonMapType(true).hasKey(null));
  }

  /**
   * Test {@link JsonMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String)"})
  void testHasKeyWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("Key"));
  }

  /**
   * Test {@link JsonMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given JsonObject (default constructor) add 'Property' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String)"})
  void testHasKeyWithKey_givenJsonObjectAddPropertyAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).hasKey("Key"));
  }

  /**
   * Test {@link JsonMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#hasKey(String)}
   */
  @Test
  @DisplayName("Test hasKey(String) with 'key'; when '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.hasKey(String)"})
  void testHasKeyWithKey_when42_thenReturnTrue() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).hasKey("42"));
  }

  /**
   * Test {@link JsonMapType#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.remove(String)"})
  void testRemove_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.remove("42");

    // Assert
    assertEquals(1, jsonMapType.size());
    assertEquals(1, jsonMapType.getJson().size());
  }

  /**
   * Test {@link JsonMapType#remove(String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); then JsonMapType(boolean) with compressed is 'true' size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.remove(String)"})
  void testRemove_thenJsonMapTypeWithCompressedIsTrueSizeIsZero() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.remove("Key");

    // Assert that nothing has changed
    assertEquals(0, jsonMapType.size());
    assertEquals(0, jsonMapType.getJson().size());
  }

  /**
   * Test {@link JsonMapType#remove(String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.remove(String)"})
  void testRemove_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.remove("Key");

    // Assert that nothing has changed
    assertEquals(1, jsonMapType.size());
    assertEquals(1, jsonMapType.getJson().size());
  }

  /**
   * Test {@link JsonMapType#remove(String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.remove(String)"})
  void testRemove_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.remove("Key");

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    assertEquals(2, jsonMapType.getJson().size());
  }

  /**
   * Test {@link JsonMapType#remove(String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.remove(String)"})
  void testRemove_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.remove("42");

    // Assert
    assertEquals(2, jsonMapType.size());
    assertEquals(2, jsonMapType.getJson().size());
  }

  /**
   * Test {@link JsonMapType#remove(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); when '42'; then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.remove(String)"})
  void testRemove_when42_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.remove("42");

    // Assert
    assertEquals(1, jsonMapType.size());
    assertEquals(1, jsonMapType.getJson().size());
  }

  /**
   * Test {@link JsonMapType#remove(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); when '42'; then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.remove(String)"})
  void testRemove_when42_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsOne2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.remove("42");

    // Assert
    assertEquals(1, jsonMapType.size());
    assertEquals(1, jsonMapType.getJson().size());
  }

  /**
   * Test {@link JsonMapType#remove(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#remove(String)}
   */
  @Test
  @DisplayName("Test remove(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.remove(String)"})
  void testRemove_whenEmptyString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.remove("");

    // Assert
    assertEquals(2, jsonMapType.size());
    assertEquals(2, jsonMapType.getJson().size());
  }

  /**
   * Test {@link JsonMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonMapType.getGeneric(String)"})
  void testGetGeneric_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getGeneric("Key"));
  }

  /**
   * Test {@link JsonMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonMapType.getGeneric(String)"})
  void testGetGeneric_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getGeneric(null));
  }

  /**
   * Test {@link JsonMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonMapType.getGeneric(String)"})
  void testGetGeneric_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getGeneric("Key"));
  }

  /**
   * Test {@link JsonMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link JsonObject}
   *       (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given JsonObject (default constructor) add '42' and JsonObject (default constructor); when '42'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonMapType.getGeneric(String)"})
  void testGetGeneric_givenJsonObjectAdd42AndJsonObject_when42_thenReturnJsonMapType() {
    // Arrange
    JsonObject map = new JsonObject();
    JsonObject value = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act
    Object actualGeneric = new JsonMapType(map, true).getGeneric("42");

    // Assert
    assertTrue(actualGeneric instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil = ((JsonMapType) actualGeneric).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, ((JsonMapType) actualGeneric).size());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertSame(value, ((JsonMapType) actualGeneric).getJson());
  }

  /**
   * Test {@link JsonMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@code null}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given JsonObject (default constructor) add '42' and 'null'; when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonMapType.getGeneric(String)"})
  void testGetGeneric_givenJsonObjectAdd42AndNull_when42_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", null);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getGeneric("42"));
  }

  /**
   * Test {@link JsonMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Then return {@link JsonListType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getGeneric(String)}
   */
  @Test
  @DisplayName("Test getGeneric(String); then return JsonListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonMapType.getGeneric(String)"})
  void testGetGeneric_thenReturnJsonListType() {
    // Arrange
    JsonObject map = new JsonObject();
    JsonArray value = new JsonArray(3);
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act
    Object actualGeneric = new JsonMapType(map, true).getGeneric("42");

    // Assert
    assertTrue(actualGeneric instanceof JsonListType);
    TypeUtil<JsonElement> typeUtil = ((JsonListType) actualGeneric).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, ((JsonListType) actualGeneric).size());
    assertEquals(ObjectType.UNDEFINED, ((JsonListType) actualGeneric).getUniformType());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertSame(value, ((JsonListType) actualGeneric).getJson());
  }

  /**
   * Test {@link JsonMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getGeneric(String)}
   */
  @Test
  @DisplayName("Test getGeneric(String); when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonMapType.getGeneric(String)"})
  void testGetGeneric_whenKey_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getGeneric("Key"));
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = new JsonMapType(true).getNumber("Key", dfl);

    // Assert
    assertTrue(actualNumber instanceof AtomicLong);
    assertEquals(-1L, ((AtomicLong) actualNumber).get());
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = new JsonMapType(map, false).getNumber("42", dfl);

    // Assert
    assertTrue(actualNumber instanceof AtomicLong);
    assertEquals(-1L, ((AtomicLong) actualNumber).get());
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = new JsonMapType(map, true).getNumber("Key", dfl);

    // Assert
    assertTrue(actualNumber instanceof AtomicLong);
    assertEquals(-1L, ((AtomicLong) actualNumber).get());
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = new JsonMapType(map, true).getNumber("42", dfl);

    // Assert
    assertTrue(actualNumber instanceof AtomicLong);
    assertEquals(-1L, ((AtomicLong) actualNumber).get());
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName("Test getNumber(String, Number) with 'key', 'dfl'; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_thenReturnByteValueIsOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(
        (byte) 1,
        new JsonMapType(map, true).getNumber("42", Bootstrap.bootstrapDuration).byteValue());
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return byteValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName("Test getNumber(String, Number) with 'key', 'dfl'; then return byteValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_thenReturnByteValueIsZero() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(
        (byte) 0,
        new JsonMapType(map, true).getNumber("42", Bootstrap.bootstrapDuration).byteValue());
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_thenReturnIntValueIsFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(
        42, new JsonMapType(map, true).getNumber("42", Bootstrap.bootstrapDuration).intValue());
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName("Test getNumber(String, Number) with 'key', 'dfl'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getNumber("42", Bootstrap.bootstrapDuration));
  }

  /**
   * Test {@link JsonMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@link AtomicLong}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; when 'Key'; then return AtomicLong")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_whenKey_thenReturnAtomicLong() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = new JsonMapType(map, true).getNumber("Key", dfl);

    // Assert
    assertTrue(actualNumber instanceof AtomicLong);
    assertEquals(-1L, ((AtomicLong) actualNumber).get());
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getNumber("Key"));
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, false).getNumber("42"));
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getNumber("42"));
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getNumber("Key"));
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getNumber("42"));
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'key'; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_thenReturnByteValueIsOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 1, new JsonMapType(map, true).getNumber("42").byteValue());
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return byteValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'key'; then return byteValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_thenReturnByteValueIsZero() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 0, new JsonMapType(map, true).getNumber("42").byteValue());
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'key'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_thenReturnIntValueIsFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42, new JsonMapType(map, true).getNumber("42").intValue());
  }

  /**
   * Test {@link JsonMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'key'; when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonMapType.getNumber(String)"})
  void testGetNumberWithKey_whenKey_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getNumber("Key"));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(String, boolean) with 'key', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).getBoolean("Key", true));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange, Act and Assert
    assertTrue(new JsonMapType(true).getBoolean("Key", true));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertTrue(new JsonMapType(true).getBoolean(null, true));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).getBoolean("Key", true));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).getBoolean("42", true));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsTrue() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).getBoolean("42", true));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).getBoolean("42", true));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'key', 'dfl'; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new JsonMapType(true).getBoolean("Key", false));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange, Act and Assert
    assertFalse(new JsonMapType(true).getBoolean("Key"));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new JsonMapType(true).getBoolean(null));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).getBoolean("Key"));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).getBoolean("42"));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).getBoolean("42"));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String)}
   */
  @Test
  @DisplayName("Test getBoolean(String) with 'key'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String)"})
  void testGetBooleanWithKey_thenReturnTrue() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertTrue(new JsonMapType(map, true).getBoolean("42"));
  }

  /**
   * Test {@link JsonMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getBoolean(String)}
   */
  @Test
  @DisplayName("Test getBoolean(String) with 'key'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonMapType.getBoolean(String)"})
  void testGetBooleanWithKey_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertFalse(new JsonMapType(map, true).getBoolean("Key"));
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("Key", true);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("Key", true);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setBoolean("Key", true);

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsFour() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("Key", true);

    // Assert
    assertEquals(4, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(4, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("Key", true);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("Key", true);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("Key", true);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("Key", true);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test setBoolean(String, boolean); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("42", true);

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test setBoolean(String, boolean); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBoolean(String, boolean)"})
  void testSetBoolean_whenEmptyString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setBoolean("", true);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', new JsonMapType(true).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', new JsonMapType(true).getByte(null, (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals('A', new JsonMapType(map, false).getByte("42", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals('A', new JsonMapType(map, true).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals('A', new JsonMapType(map, true).getByte("42", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals('A', new JsonMapType(map, true).getByte("42", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName("Test getByte(String, byte) with 'key', 'dfl'; then return '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_thenReturnAsterisk() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals('*', new JsonMapType(map, true).getByte("42", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName("Test getByte(String, byte) with 'key', 'dfl'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 1, new JsonMapType(map, true).getByte("42", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName("Test getByte(String, byte) with 'key', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_thenReturnZero() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 0, new JsonMapType(map, true).getByte("42", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName("Test getByte(String, byte) with 'key', 'dfl'; when 'Key'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_whenKey_thenReturnA() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals('A', new JsonMapType(map, true).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, new JsonMapType(true).getByte("Key"));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, new JsonMapType(true).getByte(null));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 0, new JsonMapType(map, false).getByte("42"));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 0, new JsonMapType(map, true).getByte("42"));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 0, new JsonMapType(map, true).getByte("Key"));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'false'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsFalse_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 0, new JsonMapType(map, true).getByte("42"));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 0, new JsonMapType(map, true).getByte("42"));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName("Test getByte(String) with 'key'; then return '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_thenReturnAsterisk() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals('*', new JsonMapType(map, true).getByte("42"));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName("Test getByte(String) with 'key'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 1, new JsonMapType(map, true).getByte("42"));
  }

  /**
   * Test {@link JsonMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getByte(String)}
   */
  @Test
  @DisplayName("Test getByte(String) with 'key'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonMapType.getByte(String)"})
  void testGetByteWithKey_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((byte) 0, new JsonMapType(map, true).getByte("Key"));
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsFour() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(4, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(4, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName("Test setByte(String, byte); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("42", (byte) 'A');

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName("Test setByte(String, byte); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setByte(String, byte)"})
  void testSetByte_whenEmptyString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setByte("", (byte) 'A');

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange, Act and Assert
    assertEquals((short) 1, new JsonMapType(true).getShort("Key", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertEquals((short) 1, new JsonMapType(true).getShort(null, (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 1, new JsonMapType(map, false).getShort("42", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 1, new JsonMapType(map, true).getShort("Key", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 1, new JsonMapType(map, true).getShort("42", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'true'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsTrue_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 1, new JsonMapType(map, true).getShort("42", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 1, new JsonMapType(map, true).getShort("42", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName("Test getShort(String, short) with 'key', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 42, new JsonMapType(map, true).getShort("42", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName("Test getShort(String, short) with 'key', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_thenReturnZero() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 0, new JsonMapType(map, true).getShort("42", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String, short)}
   */
  @Test
  @DisplayName("Test getShort(String, short) with 'key', 'dfl'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 1, new JsonMapType(map, true).getShort("Key", (short) 1));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((short) 0, new JsonMapType(true).getShort("Key"));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((short) 0, new JsonMapType(true).getShort(null));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 0, new JsonMapType(map, false).getShort("42"));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 0, new JsonMapType(map, true).getShort("42"));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 0, new JsonMapType(map, true).getShort("Key"));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'false'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsFalse_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 0, new JsonMapType(map, true).getShort("42"));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 0, new JsonMapType(map, true).getShort("42"));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName("Test getShort(String) with 'key'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 42, new JsonMapType(map, true).getShort("42"));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName("Test getShort(String) with 'key'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 1, new JsonMapType(map, true).getShort("42"));
  }

  /**
   * Test {@link JsonMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getShort(String)}
   */
  @Test
  @DisplayName("Test getShort(String) with 'key'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonMapType.getShort(String)"})
  void testGetShortWithKey_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals((short) 0, new JsonMapType(map, true).getShort("Key"));
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsFour() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(4, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(4, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName("Test setShort(String, short); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("42", (short) 1);

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setShort(String, short)}
   */
  @Test
  @DisplayName("Test setShort(String, short); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShort(String, short)"})
  void testSetShort_whenEmptyString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setShort("", (short) 1);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new JsonMapType(true).getInt("Key", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new JsonMapType(true).getInt(null, 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, new JsonMapType(map, false).getInt("42", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, new JsonMapType(map, true).getInt("42", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, new JsonMapType(map, true).getInt("Key", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'true'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsTrue_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, new JsonMapType(map, true).getInt("42", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, new JsonMapType(map, true).getInt("42", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName("Test getInt(String, int) with 'key', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42, new JsonMapType(map, true).getInt("42", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName("Test getInt(String, int) with 'key', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_thenReturnZero() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0, new JsonMapType(map, true).getInt("42", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String, int)}
   */
  @Test
  @DisplayName("Test getInt(String, int) with 'key', 'dfl'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, new JsonMapType(map, true).getInt("Key", 1));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new JsonMapType(true).getInt("Key"));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new JsonMapType(true).getInt(null));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0, new JsonMapType(map, false).getInt("42"));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrue_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0, new JsonMapType(map, true).getInt("Key"));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0, new JsonMapType(map, true).getInt("42"));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0, new JsonMapType(map, true).getInt("Key"));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'false'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsFalse_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0, new JsonMapType(map, true).getInt("42"));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0, new JsonMapType(map, true).getInt("42"));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'key'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42, new JsonMapType(map, true).getInt("42"));
  }

  /**
   * Test {@link JsonMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'key'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonMapType.getInt(String)"})
  void testGetIntWithKey_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, new JsonMapType(map, true).getInt("42"));
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("Key", 42);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("Key", 42);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setInt("Key", 42);

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsFour() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("Key", 42);

    // Assert
    assertEquals(4, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(4, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("Key", 42);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("Key", 42);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("Key", 42);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("Key", 42);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); when '42'; then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_when42_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("42", 42);

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setInt(String, int)}
   */
  @Test
  @DisplayName("Test setInt(String, int); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInt(String, int)"})
  void testSetInt_whenEmptyString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setInt("", 42);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, new JsonMapType(true).getLong("Key", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertEquals(1L, new JsonMapType(true).getLong(null, 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, new JsonMapType(map, false).getLong("42", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, new JsonMapType(map, true).getLong("Key", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, new JsonMapType(map, true).getLong("42", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'true'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsTrue_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, new JsonMapType(map, true).getLong("42", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, new JsonMapType(map, true).getLong("42", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName("Test getLong(String, long) with 'key', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42L, new JsonMapType(map, true).getLong("42", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName("Test getLong(String, long) with 'key', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_thenReturnZero() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0L, new JsonMapType(map, true).getLong("42", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String, long)}
   */
  @Test
  @DisplayName("Test getLong(String, long) with 'key', 'dfl'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, new JsonMapType(map, true).getLong("Key", 1L));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new JsonMapType(true).getLong("Key"));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new JsonMapType(true).getLong(null));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0L, new JsonMapType(map, false).getLong("42"));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0L, new JsonMapType(map, true).getLong("42"));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0L, new JsonMapType(map, true).getLong("Key"));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'false'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsFalse_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0L, new JsonMapType(map, true).getLong("42"));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0L, new JsonMapType(map, true).getLong("42"));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'key'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42L, new JsonMapType(map, true).getLong("42"));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'key'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, new JsonMapType(map, true).getLong("42"));
  }

  /**
   * Test {@link JsonMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'key'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonMapType.getLong(String)"})
  void testGetLongWithKey_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0L, new JsonMapType(map, true).getLong("Key"));
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("Key", 42L);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("Key", 42L);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setLong("Key", 42L);

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsFour() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("Key", 42L);

    // Assert
    assertEquals(4, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(4, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("Key", 42L);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("Key", 42L);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("Key", 42L);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("Key", 42L);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName("Test setLong(String, long); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("42", 42L);

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setLong(String, long)}
   */
  @Test
  @DisplayName("Test setLong(String, long); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLong(String, long)"})
  void testSetLong_whenEmptyString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setLong("", 42L);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new JsonMapType(true).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new JsonMapType(true).getFloat(null, 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0f, new JsonMapType(map, false).getFloat("42", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0f, new JsonMapType(map, true).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0f, new JsonMapType(map, true).getFloat("42", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0f, new JsonMapType(map, true).getFloat("42", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'key', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42.0f, new JsonMapType(map, true).getFloat("42", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'key', 'dfl'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1.0f, new JsonMapType(map, true).getFloat("42", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'key', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_thenReturnZero() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0f, new JsonMapType(map, true).getFloat("42", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'key', 'dfl'; when 'Key'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_whenKey_thenReturnTen() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0f, new JsonMapType(map, true).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new JsonMapType(true).getFloat("Key"));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new JsonMapType(true).getFloat(null));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0f, new JsonMapType(map, false).getFloat("42"));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0f, new JsonMapType(map, true).getFloat("42"));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0f, new JsonMapType(map, true).getFloat("Key"));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'false'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsFalse_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0f, new JsonMapType(map, true).getFloat("42"));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0f, new JsonMapType(map, true).getFloat("42"));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName("Test getFloat(String) with 'key'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42.0f, new JsonMapType(map, true).getFloat("42"));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName("Test getFloat(String) with 'key'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1.0f, new JsonMapType(map, true).getFloat("42"));
  }

  /**
   * Test {@link JsonMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getFloat(String)}
   */
  @Test
  @DisplayName("Test getFloat(String) with 'key'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonMapType.getFloat(String)"})
  void testGetFloatWithKey_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0f, new JsonMapType(map, true).getFloat("Key"));
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsFour() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(4, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(4, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName("Test setFloat(String, float); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("42", 10.0f);

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName("Test setFloat(String, float); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setFloat(String, float)"})
  void testSetFloat_whenEmptyString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setFloat("", 10.0f);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange, Act and Assert
    assertEquals(10.0d, new JsonMapType(true).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertEquals(10.0d, new JsonMapType(true).getDouble(null, 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0d, new JsonMapType(map, false).getDouble("42", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0d, new JsonMapType(map, true).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0d, new JsonMapType(map, true).getDouble("42", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0d, new JsonMapType(map, true).getDouble("42", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName("Test getDouble(String, double) with 'key', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42.0d, new JsonMapType(map, true).getDouble("42", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName("Test getDouble(String, double) with 'key', 'dfl'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1.0d, new JsonMapType(map, true).getDouble("42", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName("Test getDouble(String, double) with 'key', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_thenReturnZero() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0d, new JsonMapType(map, true).getDouble("42", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName("Test getDouble(String, double) with 'key', 'dfl'; when 'Key'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_whenKey_thenReturnTen() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(10.0d, new JsonMapType(map, true).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new JsonMapType(true).getDouble("Key"));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new JsonMapType(true).getDouble(null));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0d, new JsonMapType(map, false).getDouble("42"));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0d, new JsonMapType(map, true).getDouble("42"));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0d, new JsonMapType(map, true).getDouble("Key"));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'false'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsFalse_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(false));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0d, new JsonMapType(map, true).getDouble("42"));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0d, new JsonMapType(map, true).getDouble("42"));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName("Test getDouble(String) with 'key'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_thenReturnFortyTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("42"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(42.0d, new JsonMapType(map, true).getDouble("42"));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName("Test getDouble(String) with 'key'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_thenReturnOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1.0d, new JsonMapType(map, true).getDouble("42"));
  }

  /**
   * Test {@link JsonMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getDouble(String)}
   */
  @Test
  @DisplayName("Test getDouble(String) with 'key'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonMapType.getDouble(String)"})
  void testGetDoubleWithKey_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(0.0d, new JsonMapType(map, true).getDouble("Key"));
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsFour() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(4, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(4, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName("Test setDouble(String, double); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("42", 10.0d);

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName("Test setDouble(String, double); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setDouble(String, double)"})
  void testSetDouble_whenEmptyString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setDouble("", 10.0d);

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#getBytes(String)} with {@code key}.
   *
   * <p>Method under test: {@link JsonMapType#getBytes(String)}
   */
  @Test
  @DisplayName("Test getBytes(String) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JsonMapType.getBytes(String)"})
  void testGetBytesWithKey() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getBytes("Key"));
  }

  /**
   * Test {@link JsonMapType#getBytes(String, byte[])} with {@code key}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonMapType#getBytes(String, byte[])}
   */
  @Test
  @DisplayName("Test getBytes(String, byte[]) with 'key', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JsonMapType.getBytes(String, byte[])"})
  void testGetBytesWithKeyDfl() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new JsonMapType(true).getBytes("Key", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JsonMapType#setBytes(String, byte[])}.
   *
   * <p>Method under test: {@link JsonMapType#setBytes(String, byte[])}
   */
  @Test
  @DisplayName("Test setBytes(String, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setBytes(String, byte[])"})
  void testSetBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonMapType(true).setBytes("Key", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JsonMapType#getShorts(String)} with {@code key}.
   *
   * <p>Method under test: {@link JsonMapType#getShorts(String)}
   */
  @Test
  @DisplayName("Test getShorts(String) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short[] JsonMapType.getShorts(String)"})
  void testGetShortsWithKey() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getShorts("Key"));
  }

  /**
   * Test {@link JsonMapType#getShorts(String, short[])} with {@code key}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonMapType#getShorts(String, short[])}
   */
  @Test
  @DisplayName("Test getShorts(String, short[]) with 'key', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short[] JsonMapType.getShorts(String, short[])"})
  void testGetShortsWithKeyDfl() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new short[] {1, -1, 1, -1},
        new JsonMapType(true).getShorts("Key", new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JsonMapType#setShorts(String, short[])}.
   *
   * <p>Method under test: {@link JsonMapType#setShorts(String, short[])}
   */
  @Test
  @DisplayName("Test setShorts(String, short[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setShorts(String, short[])"})
  void testSetShorts() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonMapType(true).setShorts("Key", new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JsonMapType#getInts(String)} with {@code key}.
   *
   * <p>Method under test: {@link JsonMapType#getInts(String)}
   */
  @Test
  @DisplayName("Test getInts(String) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] JsonMapType.getInts(String)"})
  void testGetIntsWithKey() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getInts("Key"));
  }

  /**
   * Test {@link JsonMapType#getInts(String, int[])} with {@code key}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonMapType#getInts(String, int[])}
   */
  @Test
  @DisplayName("Test getInts(String, int[]) with 'key', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] JsonMapType.getInts(String, int[])"})
  void testGetIntsWithKeyDfl() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {1, 0, 1, 0}, new JsonMapType(true).getInts("Key", new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link JsonMapType#setInts(String, int[])}.
   *
   * <p>Method under test: {@link JsonMapType#setInts(String, int[])}
   */
  @Test
  @DisplayName("Test setInts(String, int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setInts(String, int[])"})
  void testSetInts() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonMapType(true).setInts("Key", new int[] {42, 1, 42, 1}));
  }

  /**
   * Test {@link JsonMapType#getLongs(String)} with {@code key}.
   *
   * <p>Method under test: {@link JsonMapType#getLongs(String)}
   */
  @Test
  @DisplayName("Test getLongs(String) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JsonMapType.getLongs(String)"})
  void testGetLongsWithKey() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getLongs("Key"));
  }

  /**
   * Test {@link JsonMapType#getLongs(String, long[])} with {@code key}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonMapType#getLongs(String, long[])}
   */
  @Test
  @DisplayName("Test getLongs(String, long[]) with 'key', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JsonMapType.getLongs(String, long[])"})
  void testGetLongsWithKeyDfl() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new long[] {1L, -1L, 1L, -1L},
        new JsonMapType(true).getLongs("Key", new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link JsonMapType#setLongs(String, long[])}.
   *
   * <p>Method under test: {@link JsonMapType#setLongs(String, long[])}
   */
  @Test
  @DisplayName("Test setLongs(String, long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setLongs(String, long[])"})
  void testSetLongs() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonMapType(true).setLongs("Key", new long[] {42L, 1L, 42L, 1L}));
  }

  /**
   * Test {@link JsonMapType#getListUnchecked(String, ListType)} with {@code key}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonMapType#getListUnchecked(String, ListType)}
   */
  @Test
  @DisplayName("Test getListUnchecked(String, ListType) with 'key', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType JsonMapType.getListUnchecked(String, ListType)"})
  void testGetListUncheckedWithKeyDfl() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);
    NBTListType dfl = new NBTListType();

    // Act
    ListType actualListUnchecked = jsonMapType.getListUnchecked("Key", dfl);

    // Assert
    assertSame(dfl, actualListUnchecked);
  }

  /**
   * Test {@link JsonMapType#getListUnchecked(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getListUnchecked(String)}
   */
  @Test
  @DisplayName(
      "Test getListUnchecked(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType JsonMapType.getListUnchecked(String)"})
  void testGetListUncheckedWithKey_givenJsonMapTypeWithCompressedIsTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getListUnchecked("Key"));
  }

  /**
   * Test {@link JsonMapType#getListUnchecked(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getListUnchecked(String)}
   */
  @Test
  @DisplayName(
      "Test getListUnchecked(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType JsonMapType.getListUnchecked(String)"})
  void testGetListUncheckedWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getListUnchecked("Key"));
  }

  /**
   * Test {@link JsonMapType#getListUnchecked(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getListUnchecked(String)}
   */
  @Test
  @DisplayName("Test getListUnchecked(String) with 'key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType JsonMapType.getListUnchecked(String)"})
  void testGetListUncheckedWithKey_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getListUnchecked("Key"));
  }

  /**
   * Test {@link JsonMapType#getListUnchecked(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link JsonListType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getListUnchecked(String)}
   */
  @Test
  @DisplayName("Test getListUnchecked(String) with 'key'; when '42'; then return JsonListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType JsonMapType.getListUnchecked(String)"})
  void testGetListUncheckedWithKey_when42_thenReturnJsonListType() {
    // Arrange
    JsonObject map = new JsonObject();
    JsonArray value = new JsonArray(3);
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act
    ListType actualListUnchecked = new JsonMapType(map, true).getListUnchecked("42");

    // Assert
    assertTrue(actualListUnchecked instanceof JsonListType);
    TypeUtil<?> typeUtil = actualListUnchecked.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, actualListUnchecked.size());
    assertEquals(ObjectType.UNDEFINED, actualListUnchecked.getUniformType());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(((JsonListType) actualListUnchecked).compressed);
    assertSame(value, ((JsonListType) actualListUnchecked).getJson());
  }

  /**
   * Test {@link JsonMapType#setList(String, ListType)}.
   *
   * <ul>
   *   <li>When {@link JsonListType#JsonListType(boolean)} with compressed is {@code true}.
   *   <li>Then calls {@link JsonObject#add(String, JsonElement)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setList(String, ListType)}
   */
  @Test
  @DisplayName(
      "Test setList(String, ListType); when JsonListType(boolean) with compressed is 'true'; then calls add(String, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setList(String, ListType)"})
  void testSetList_whenJsonListTypeWithCompressedIsTrue_thenCallsAdd() {
    // Arrange
    JsonObject map = mock(JsonObject.class);
    doNothing().when(map).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setList("Key", new JsonListType(true));

    // Assert
    verify(map, atLeast(1)).add(Mockito.<String>any(), isA(JsonElement.class));
  }

  /**
   * Test {@link JsonMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(String, MapType) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_thenReturnNBTMapType() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = jsonMapType.getMap("Key", dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link JsonMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(String, MapType) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = jsonMapType.getMap("Key", dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link JsonMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(String, MapType) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = jsonMapType.getMap("42", dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link JsonMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link JsonObject}
   *       (default constructor).
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(String, MapType) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonObject (default constructor); then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_givenJsonObjectAdd42AndJsonObject_thenReturnJsonMapType() {
    // Arrange
    JsonObject map = new JsonObject();
    JsonObject value = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    MapType actualMap = jsonMapType.getMap("42", new NBTMapType());

    // Assert
    assertTrue(actualMap instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualMap.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, actualMap.size());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(((JsonMapType) actualMap).compressed);
    assertSame(value, ((JsonMapType) actualMap).getJson());
  }

  /**
   * Test {@link JsonMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName("Test getMap(String, MapType) with 'key', 'dfl'; then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_thenReturnNBTMapType() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = jsonMapType.getMap("Key", dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link JsonMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String)}
   */
  @Test
  @DisplayName(
      "Test getMap(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String)"})
  void testGetMapWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getMap("Key"));
  }

  /**
   * Test {@link JsonMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String)}
   */
  @Test
  @DisplayName(
      "Test getMap(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String)"})
  void testGetMapWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getMap("Key"));
  }

  /**
   * Test {@link JsonMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String)}
   */
  @Test
  @DisplayName(
      "Test getMap(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String)"})
  void testGetMapWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getMap("42"));
  }

  /**
   * Test {@link JsonMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link JsonObject}
   *       (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String)}
   */
  @Test
  @DisplayName(
      "Test getMap(String) with 'key'; given JsonObject (default constructor) add '42' and JsonObject (default constructor); when '42'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String)"})
  void testGetMapWithKey_givenJsonObjectAdd42AndJsonObject_when42_thenReturnJsonMapType() {
    // Arrange
    JsonObject map = new JsonObject();
    JsonObject value = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act
    MapType actualMap = new JsonMapType(map, true).getMap("42");

    // Assert
    assertTrue(actualMap instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualMap.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, actualMap.size());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(((JsonMapType) actualMap).compressed);
    assertSame(value, ((JsonMapType) actualMap).getJson());
  }

  /**
   * Test {@link JsonMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getMap(String)}
   */
  @Test
  @DisplayName("Test getMap(String) with 'key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonMapType.getMap(String)"})
  void testGetMapWithKey_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getMap("Key"));
  }

  /**
   * Test {@link JsonMapType#setMap(String, MapType)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then calls {@link JsonObject#add(String, JsonElement)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test setMap(String, MapType); when JsonMapType(boolean) with compressed is 'true'; then calls add(String, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setMap(String, MapType)"})
  void testSetMap_whenJsonMapTypeWithCompressedIsTrue_thenCallsAdd() {
    // Arrange
    JsonObject map = mock(JsonObject.class);
    doNothing().when(map).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setMap("Key", new JsonMapType(true));

    // Assert
    verify(map, atLeast(1)).add(Mockito.<String>any(), Mockito.<JsonElement>any());
  }

  /**
   * Test {@link JsonMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange, Act and Assert
    assertEquals("Dfl", new JsonMapType(true).getString("Key", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("Dfl", new JsonMapType(map, false).getString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("Dfl", new JsonMapType(map, true).getString("Key", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("Dfl", new JsonMapType(map, true).getString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsTrue() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("Dfl", new JsonMapType(map, true).getString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String, String)}
   */
  @Test
  @DisplayName("Test getString(String, String) with 'key', 'dfl'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_thenReturnString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("String", new JsonMapType(map, true).getString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String, String)}
   */
  @Test
  @DisplayName("Test getString(String, String) with 'key', 'dfl'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("Dfl", new JsonMapType(map, true).getString("Key", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String)"})
  void testGetStringWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getString("Key"));
  }

  /**
   * Test {@link JsonMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'key'; given JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String)"})
  void testGetStringWithKey_givenJsonMapTypeWithMapIsJsonObjectAndCompressedIsFalse() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, false).getString("42"));
  }

  /**
   * Test {@link JsonMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String)"})
  void testGetStringWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getString("42"));
  }

  /**
   * Test {@link JsonMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'key'; given JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String)"})
  void testGetStringWithKey_givenJsonObjectAdd42AndJsonArrayWithCapacityIsThree_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getString("Key"));
  }

  /**
   * Test {@link JsonMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'key'; given JsonObject (default constructor) add '42' and JsonPrimitive(Boolean) with bool is 'true'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String)"})
  void testGetStringWithKey_givenJsonObjectAdd42AndJsonPrimitiveWithBoolIsTrue_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getString("42"));
  }

  /**
   * Test {@link JsonMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'key'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String)"})
  void testGetStringWithKey_thenReturnString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("String", new JsonMapType(map, true).getString("42"));
  }

  /**
   * Test {@link JsonMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'key'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getString(String)"})
  void testGetStringWithKey_whenKey() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getString("Key"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_thenReturnDfl() {
    // Arrange, Act and Assert
    assertEquals("Dfl", new JsonMapType(true).getForcedString("Key", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertEquals("Dfl", new JsonMapType(true).getForcedString(null, "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@code null}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; given JsonObject (default constructor) add '42' and 'null'; when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_givenJsonObjectAdd42AndNull_when42_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", null);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("null", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code [-1]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName("Test getForcedString(String, String) with 'key', 'dfl'; then return '[-1]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturn1() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(Bootstrap.bootstrapDuration);

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[-1]", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code ["42"]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName("Test getForcedString(String, String) with 'key', 'dfl'; then return '[\"42\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturn42() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add("42");

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[\"42\"]", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code {"42":[],"Property":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; then return '{\"42\":[],\"Property\":[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturn42Property() {
    // Arrange
    JsonObject value = new JsonObject();
    value.add("42", new JsonArray(3));
    value.add("Property", new JsonArray(3));

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(
        "{\"42\":[],\"Property\":[]}", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code [false]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName("Test getForcedString(String, String) with 'key', 'dfl'; then return '[false]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnFalse() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(false);

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[false]", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName("Test getForcedString(String, String) with 'key', 'dfl'; then return '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonObject());
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("{}", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName("Test getForcedString(String, String) with 'key', 'dfl'; then return '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[]", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code {"Property":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; then return '{\"Property\":[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnProperty() {
    // Arrange
    JsonObject value = new JsonObject();
    value.add("Property", new JsonArray(3));

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("{\"Property\":[]}", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code {"Property":null}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; then return '{\"Property\":null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnPropertyNull() {
    // Arrange
    JsonObject value = new JsonObject();
    value.add("Property", null);

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("{\"Property\":null}", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName("Test getForcedString(String, String) with 'key', 'dfl'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("String", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code [true,false]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName("Test getForcedString(String, String) with 'key', 'dfl'; then return '[true,false]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnTrueFalse() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);
    value.add(false);

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[true,false]", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName("Test getForcedString(String, String) with 'key', 'dfl'; then return TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnTrueToString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(Boolean.TRUE.toString(), new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code ["\u0000"]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; then return '[\"\\u0000\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_thenReturnU0000() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add('\u0000');

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[\"\\u0000\"]", new JsonMapType(map, true).getForcedString("42", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; when 'Key'; then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_whenKey_thenReturnDfl() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("Dfl", new JsonMapType(map, true).getForcedString("Key", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String, String) with 'key', 'dfl'; when 'Key'; then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String, String)"})
  void testGetForcedStringWithKeyDfl_whenKey_thenReturnDfl2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("Dfl", new JsonMapType(map, true).getForcedString("Key", "Dfl"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code 42}.
   *   <li>Then return {@code ["42"]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String) with 'key'; given JsonArray(int) with capacity is three add '42'; then return '[\"42\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_givenJsonArrayWithCapacityIsThreeAdd42_thenReturn42() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add("42");

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[\"42\"]", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_givenJsonMapTypeWithCompressedIsTrue_whenKey() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getForcedString("Key"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String) with 'key'; given JsonMapType(boolean) with compressed is 'true'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_givenJsonMapTypeWithCompressedIsTrue_whenNull() {
    // Arrange, Act and Assert
    assertNull(new JsonMapType(true).getForcedString(null));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@link JsonObject}
   *       (default constructor).
   *   <li>Then return {@code {"Property":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String) with 'key'; given JsonObject (default constructor) add '42' and JsonObject (default constructor); then return '{\"Property\":[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_givenJsonObjectAdd42AndJsonObject_thenReturnProperty() {
    // Arrange
    JsonObject value = new JsonObject();
    value.add("Property", new JsonArray(3));

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("{\"Property\":[]}", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code 42} and {@code null}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName(
      "Test getForcedString(String) with 'key'; given JsonObject (default constructor) add '42' and 'null'; when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_givenJsonObjectAdd42AndNull_when42_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", null);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("null", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code [-1]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return '[-1]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturn1() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(Bootstrap.bootstrapDuration);

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[-1]", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code {"42":[],"Property":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return '{\"42\":[],\"Property\":[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturn42Property() {
    // Arrange
    JsonObject value = new JsonObject();
    value.add("42", new JsonArray(3));
    value.add("Property", new JsonArray(3));

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("{\"42\":[],\"Property\":[]}", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code [false]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return '[false]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturnFalse() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(false);

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[false]", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonObject());
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("{}", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[]", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code {"Property":null}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return '{\"Property\":null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturnPropertyNull() {
    // Arrange
    JsonObject value = new JsonObject();
    value.add("Property", null);

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("{\"Property\":null}", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturnString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive("String"));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("String", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code [true,false]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return '[true,false]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturnTrueFalse() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);
    value.add(false);

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[true,false]", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturnTrueToString() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonPrimitive(true));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(Boolean.TRUE.toString(), new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code ["\u0000"]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; then return '[\"\\u0000\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_thenReturnU0000() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add('\u0000');

    JsonObject map = new JsonObject();
    map.add("42", value);
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals("[\"\\u0000\"]", new JsonMapType(map, true).getForcedString("42"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_whenKey_thenReturnNull() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getForcedString("Key"));
  }

  /**
   * Test {@link JsonMapType#getForcedString(String)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#getForcedString(String)}
   */
  @Test
  @DisplayName("Test getForcedString(String) with 'key'; when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonMapType.getForcedString(String)"})
  void testGetForcedStringWithKey_whenKey_thenReturnNull2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));

    // Act and Assert
    assertNull(new JsonMapType(map, true).getForcedString("Key"));
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setString("Key", "Val");

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); given JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_givenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setString("Key", "Val");

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setString("Key", "Val");

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsFour() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setString("Key", "Val");

    // Assert
    assertEquals(4, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(4, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setString("Key", "Val");

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsThree2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setString("Key", "Val");

    // Assert
    assertEquals(3, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setString("Key", "Val");

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Then {@link JsonMapType#JsonMapType(JsonObject, boolean)} with map is {@link JsonObject}
   *       (default constructor) and compressed is {@code true} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); then JsonMapType(JsonObject, boolean) with map is JsonObject (default constructor) and compressed is 'true' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_thenJsonMapTypeWithMapIsJsonObjectAndCompressedIsTrueSizeIsTwo2() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setString("Key", "Val");

    // Assert
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName("Test setString(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_when42() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("42", new JsonArray(3));
    map.add("Property", new JsonArray(3));
    JsonMapType jsonMapType = new JsonMapType(map, true);

    // Act
    jsonMapType.setString("42", "Val");

    // Assert that nothing has changed
    assertEquals(2, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
  }

  /**
   * Test {@link JsonMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JsonMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); when 'null'; then JsonMapType(boolean) with compressed is 'true' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapType.setString(String, String)"})
  void testSetString_whenNull_thenJsonMapTypeWithCompressedIsTrueSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    jsonMapType.setString("Key", null);

    // Assert
    assertEquals(1, jsonMapType.size());
    JsonObject json = jsonMapType.getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
  }
}
