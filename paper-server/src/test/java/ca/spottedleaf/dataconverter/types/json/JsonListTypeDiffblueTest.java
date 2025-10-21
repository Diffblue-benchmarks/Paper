package ca.spottedleaf.dataconverter.types.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonListTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonListType#JsonListType(JsonArray, boolean)}
   *   <li>{@link JsonListType#toString()}
   *   <li>{@link JsonListType#getJson()}
   *   <li>{@link JsonListType#getUniformType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JsonListType.<init>(JsonArray, boolean)",
    "JsonArray JsonListType.getJson()",
    "ObjectType JsonListType.getUniformType()",
    "String JsonListType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    JsonArray array = new JsonArray(3);

    // Act
    JsonListType actualJsonListType = new JsonListType(array, true);
    String actualToStringResult = actualJsonListType.toString();
    JsonArray actualJson = actualJsonListType.getJson();

    // Assert
    assertEquals("JsonListType{array=[], compressed=true}", actualToStringResult);
    assertEquals(ObjectType.UNDEFINED, actualJsonListType.getUniformType());
    assertSame(array, actualJson);
  }

  /**
   * Test {@link JsonListType#JsonListType(boolean)}.
   *
   * <p>Method under test: {@link JsonListType#JsonListType(boolean)}
   */
  @Test
  @DisplayName("Test new JsonListType(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.<init>(boolean)"})
  void testNewJsonListType() {
    // Arrange and Act
    JsonListType actualJsonListType = new JsonListType(true);

    // Assert
    TypeUtil<JsonElement> typeUtil = actualJsonListType.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, actualJsonListType.size());
    JsonArray json = actualJsonListType.getJson();
    assertEquals(0, json.size());
    assertEquals(ObjectType.UNDEFINED, actualJsonListType.getUniformType());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonObject());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.iterator().hasNext());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isEmpty());
    assertTrue(json.isJsonArray());
    assertTrue(actualJsonListType.compressed);
    JsonArray actualAsJsonArray = json.getAsJsonArray();
    assertSame(json, actualAsJsonArray);
  }

  /**
   * Test {@link JsonListType#getTypeUtil()}.
   *
   * <ul>
   *   <li>Given {@link JsonListType#JsonListType(boolean)} with compressed is {@code false}.
   *   <li>Then return not Compressed.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getTypeUtil()}
   */
  @Test
  @DisplayName(
      "Test getTypeUtil(); given JsonListType(boolean) with compressed is 'false'; then return not Compressed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeUtil JsonListType.getTypeUtil()"})
  void testGetTypeUtil_givenJsonListTypeWithCompressedIsFalse_thenReturnNotCompressed() {
    // Arrange and Act
    TypeUtil<JsonElement> actualTypeUtil = new JsonListType(false).getTypeUtil();

    // Assert
    assertTrue(actualTypeUtil instanceof JsonTypeUtil);
    assertFalse(((JsonTypeUtil) actualTypeUtil).isCompressed());
  }

  /**
   * Test {@link JsonListType#getTypeUtil()}.
   *
   * <ul>
   *   <li>Given {@link JsonListType#JsonListType(boolean)} with compressed is {@code true}.
   *   <li>Then return Compressed.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getTypeUtil()}
   */
  @Test
  @DisplayName(
      "Test getTypeUtil(); given JsonListType(boolean) with compressed is 'true'; then return Compressed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeUtil JsonListType.getTypeUtil()"})
  void testGetTypeUtil_givenJsonListTypeWithCompressedIsTrue_thenReturnCompressed() {
    // Arrange and Act
    TypeUtil<JsonElement> actualTypeUtil = new JsonListType(true).getTypeUtil();

    // Assert
    assertTrue(actualTypeUtil instanceof JsonTypeUtil);
    assertTrue(((JsonTypeUtil) actualTypeUtil).isCompressed());
  }

  /**
   * Test {@link JsonListType#equals(Object)}, and {@link JsonListType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonListType#equals(Object)}
   *   <li>{@link JsonListType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonListType.equals(Object)", "int JsonListType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    JsonListType jsonListType2 = new JsonListType(true);

    // Act and Assert
    assertEquals(jsonListType, jsonListType2);
    assertEquals(jsonListType.hashCode(), jsonListType2.hashCode());
  }

  /**
   * Test {@link JsonListType#equals(Object)}, and {@link JsonListType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonListType#equals(Object)}
   *   <li>{@link JsonListType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonListType.equals(Object)", "int JsonListType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);

    // Act and Assert
    assertEquals(jsonListType, jsonListType);
    int expectedHashCodeResult = jsonListType.hashCode();
    assertEquals(expectedHashCodeResult, jsonListType.hashCode());
  }

  /**
   * Test {@link JsonListType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonListType.equals(Object)", "int JsonListType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertNotEquals(jsonListType, new JsonListType(true));
  }

  /**
   * Test {@link JsonListType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonListType.equals(Object)", "int JsonListType.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonListType(true), null);
  }

  /**
   * Test {@link JsonListType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonListType.equals(Object)", "int JsonListType.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonListType(true), "Different type to JsonListType");
  }

  /**
   * Test {@link JsonListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link JsonListType#JsonListType(boolean)} with compressed is {@code true}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given JsonListType(boolean) with compressed is 'true'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType JsonListType.copy()"})
  void testCopy_givenJsonListTypeWithCompressedIsTrue_thenReturnSizeIsZero() {
    // Arrange and Act
    ListType actualCopyResult = new JsonListType(true).copy();

    // Assert
    assertTrue(actualCopyResult instanceof JsonListType);
    assertEquals(0, actualCopyResult.size());
    JsonArray json = ((JsonListType) actualCopyResult).getJson();
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }

  /**
   * Test {@link JsonListType#size()}.
   *
   * <p>Method under test: {@link JsonListType#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonListType.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new JsonListType(true).size());
  }

  /**
   * Test {@link JsonListType#getGeneric(int)}.
   *
   * <ul>
   *   <li>Then return byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getGeneric(int)}
   */
  @Test
  @DisplayName("Test getGeneric(int); then return byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonListType.getGeneric(int)"})
  void testGetGeneric_thenReturnByteValueIsA() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals('A', ((Byte) jsonListType.getGeneric(1)).byteValue());
  }

  /**
   * Test {@link JsonListType#getGeneric(int)}.
   *
   * <ul>
   *   <li>Then return shortValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getGeneric(int)}
   */
  @Test
  @DisplayName("Test getGeneric(int); then return shortValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonListType.getGeneric(int)"})
  void testGetGeneric_thenReturnShortValueIsOne() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'A');
    jsonListType.addShort((short) 1);

    // Act and Assert
    assertEquals((short) 1, ((Short) jsonListType.getGeneric(1)).shortValue());
  }

  /**
   * Test {@link JsonListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@link AtomicLong}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName("Test getNumber(int, Number) with 'index', 'dfl'; then return AtomicLong")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_thenReturnAtomicLong() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("String");
    jsonListType.addByte((byte) 0);
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = jsonListType.getNumber(0, dfl);

    // Assert
    assertTrue(actualNumber instanceof AtomicLong);
    assertEquals(-1L, ((AtomicLong) actualNumber).get());
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link JsonListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return byteValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName("Test getNumber(int, Number) with 'index', 'dfl'; then return byteValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_thenReturnByteValueIsZero() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals((byte) 0, jsonListType.getNumber(0, Bootstrap.bootstrapDuration).byteValue());
  }

  /**
   * Test {@link JsonListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName("Test getNumber(int, Number) with 'index', 'dfl'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_thenReturnIntValueIsFortyTwo() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("42");

    // Act and Assert
    assertEquals(42, jsonListType.getNumber(0, Bootstrap.bootstrapDuration).intValue());
  }

  /**
   * Test {@link JsonListType#getNumber(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getNumber(int)}
   */
  @Test
  @DisplayName("Test getNumber(int) with 'index'; then return byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number JsonListType.getNumber(int)"})
  void testGetNumberWithIndex_thenReturnByteValueIsA() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals('A', jsonListType.getNumber(1).byteValue());
  }

  /**
   * Test {@link JsonListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getByte(int, byte)}
   */
  @Test
  @DisplayName("Test getByte(int, byte) with 'index', 'dfl'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_thenReturnA() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("String");
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals('A', jsonListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link JsonListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getByte(int, byte)}
   */
  @Test
  @DisplayName("Test getByte(int, byte) with 'index', 'dfl'; then return '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_thenReturnAsterisk() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("42");

    // Act and Assert
    assertEquals('*', jsonListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link JsonListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getByte(int, byte)}
   */
  @Test
  @DisplayName("Test getByte(int, byte) with 'index', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_thenReturnZero() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals((byte) 0, jsonListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link JsonListType#getByte(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link JsonListType#JsonListType(boolean)} with compressed is {@code true} addByte
   *       {@code X}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getByte(int)}
   */
  @Test
  @DisplayName(
      "Test getByte(int) with 'index'; given JsonListType(boolean) with compressed is 'true' addByte 'X'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte JsonListType.getByte(int)"})
  void testGetByteWithIndex_givenJsonListTypeWithCompressedIsTrueAddByteX_thenReturnA() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals('A', jsonListType.getByte(1));
  }

  /**
   * Test {@link JsonListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getShort(int, short)}
   */
  @Test
  @DisplayName("Test getShort(int, short) with 'index', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_thenReturnFortyTwo() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("42");

    // Act and Assert
    assertEquals((short) 42, jsonListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link JsonListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return seven.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getShort(int, short)}
   */
  @Test
  @DisplayName("Test getShort(int, short) with 'index', 'dfl'; then return seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_thenReturnSeven() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("String");
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals((short) 7, jsonListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link JsonListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getShort(int, short)}
   */
  @Test
  @DisplayName("Test getShort(int, short) with 'index', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_thenReturnZero() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals((short) 0, jsonListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link JsonListType#getShort(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getShort(int)}
   */
  @Test
  @DisplayName("Test getShort(int) with 'index'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short JsonListType.getShort(int)"})
  void testGetShortWithIndex_thenReturnSixtyFive() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals((short) 65, jsonListType.getShort(1));
  }

  /**
   * Test {@link JsonListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getInt(int, int)}
   */
  @Test
  @DisplayName("Test getInt(int, int) with 'index', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_thenReturnFortyTwo() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("42");

    // Act and Assert
    assertEquals(42, jsonListType.getInt(0, 3));
  }

  /**
   * Test {@link JsonListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getInt(int, int)}
   */
  @Test
  @DisplayName("Test getInt(int, int) with 'index', 'dfl'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_thenReturnThree() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("String");
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(3, jsonListType.getInt(0, 3));
  }

  /**
   * Test {@link JsonListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getInt(int, int)}
   */
  @Test
  @DisplayName("Test getInt(int, int) with 'index', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_thenReturnZero() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(0, jsonListType.getInt(0, 3));
  }

  /**
   * Test {@link JsonListType#getInt(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getInt(int)}
   */
  @Test
  @DisplayName("Test getInt(int) with 'index'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonListType.getInt(int)"})
  void testGetIntWithIndex_thenReturnSixtyFive() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals(65, jsonListType.getInt(1));
  }

  /**
   * Test {@link JsonListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getLong(int, long)}
   */
  @Test
  @DisplayName("Test getLong(int, long) with 'index', 'dfl'; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_thenReturnFive() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("String");
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(5L, jsonListType.getLong(0, 5L));
  }

  /**
   * Test {@link JsonListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getLong(int, long)}
   */
  @Test
  @DisplayName("Test getLong(int, long) with 'index', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_thenReturnFortyTwo() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("42");

    // Act and Assert
    assertEquals(42L, jsonListType.getLong(0, 5L));
  }

  /**
   * Test {@link JsonListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getLong(int, long)}
   */
  @Test
  @DisplayName("Test getLong(int, long) with 'index', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_thenReturnZero() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(0L, jsonListType.getLong(0, 5L));
  }

  /**
   * Test {@link JsonListType#getLong(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getLong(int)}
   */
  @Test
  @DisplayName("Test getLong(int) with 'index'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long JsonListType.getLong(int)"})
  void testGetLongWithIndex_thenReturnSixtyFive() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals(65L, jsonListType.getLong(1));
  }

  /**
   * Test {@link JsonListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getFloat(int, float)}
   */
  @Test
  @DisplayName("Test getFloat(int, float) with 'index', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_thenReturnFortyTwo() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("42");

    // Act and Assert
    assertEquals(42.0f, jsonListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link JsonListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getFloat(int, float)}
   */
  @Test
  @DisplayName("Test getFloat(int, float) with 'index', 'dfl'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_thenReturnTen() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("String");
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(10.0f, jsonListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link JsonListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getFloat(int, float)}
   */
  @Test
  @DisplayName("Test getFloat(int, float) with 'index', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_thenReturnZero() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(0.0f, jsonListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link JsonListType#getFloat(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getFloat(int)}
   */
  @Test
  @DisplayName("Test getFloat(int) with 'index'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float JsonListType.getFloat(int)"})
  void testGetFloatWithIndex_thenReturnSixtyFive() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals(65.0f, jsonListType.getFloat(1));
  }

  /**
   * Test {@link JsonListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getDouble(int, double)}
   */
  @Test
  @DisplayName("Test getDouble(int, double) with 'index', 'dfl'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_thenReturnFortyTwo() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("42");

    // Act and Assert
    assertEquals(42.0d, jsonListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link JsonListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getDouble(int, double)}
   */
  @Test
  @DisplayName("Test getDouble(int, double) with 'index', 'dfl'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_thenReturnTen() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("String");
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(10.0d, jsonListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link JsonListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getDouble(int, double)}
   */
  @Test
  @DisplayName("Test getDouble(int, double) with 'index', 'dfl'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_thenReturnZero() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(0.0d, jsonListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link JsonListType#getDouble(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getDouble(int)}
   */
  @Test
  @DisplayName("Test getDouble(int) with 'index'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double JsonListType.getDouble(int)"})
  void testGetDoubleWithIndex_thenReturnSixtyFive() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals(65.0d, jsonListType.getDouble(1));
  }

  /**
   * Test {@link JsonListType#getBytes(int)} with {@code index}.
   *
   * <p>Method under test: {@link JsonListType#getBytes(int)}
   */
  @Test
  @DisplayName("Test getBytes(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JsonListType.getBytes(int)"})
  void testGetBytesWithIndex() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new JsonListType(true).getBytes(1));
  }

  /**
   * Test {@link JsonListType#getBytes(int, byte[])} with {@code index}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonListType#getBytes(int, byte[])}
   */
  @Test
  @DisplayName("Test getBytes(int, byte[]) with 'index', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JsonListType.getBytes(int, byte[])"})
  void testGetBytesWithIndexDfl() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).getBytes(1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JsonListType#setBytes(int, byte[])}.
   *
   * <p>Method under test: {@link JsonListType#setBytes(int, byte[])}
   */
  @Test
  @DisplayName("Test setBytes(int, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.setBytes(int, byte[])"})
  void testSetBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).setBytes(1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JsonListType#getShorts(int)} with {@code index}.
   *
   * <p>Method under test: {@link JsonListType#getShorts(int)}
   */
  @Test
  @DisplayName("Test getShorts(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short[] JsonListType.getShorts(int)"})
  void testGetShortsWithIndex() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new JsonListType(true).getShorts(1));
  }

  /**
   * Test {@link JsonListType#getShorts(int, short[])} with {@code index}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonListType#getShorts(int, short[])}
   */
  @Test
  @DisplayName("Test getShorts(int, short[]) with 'index', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short[] JsonListType.getShorts(int, short[])"})
  void testGetShortsWithIndexDfl() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).getShorts(1, new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JsonListType#setShorts(int, short[])}.
   *
   * <p>Method under test: {@link JsonListType#setShorts(int, short[])}
   */
  @Test
  @DisplayName("Test setShorts(int, short[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.setShorts(int, short[])"})
  void testSetShorts() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).setShorts(1, new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JsonListType#getInts(int)} with {@code index}.
   *
   * <p>Method under test: {@link JsonListType#getInts(int)}
   */
  @Test
  @DisplayName("Test getInts(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] JsonListType.getInts(int)"})
  void testGetIntsWithIndex() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new JsonListType(true).getInts(1));
  }

  /**
   * Test {@link JsonListType#getInts(int, int[])} with {@code index}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonListType#getInts(int, int[])}
   */
  @Test
  @DisplayName("Test getInts(int, int[]) with 'index', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] JsonListType.getInts(int, int[])"})
  void testGetIntsWithIndexDfl() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).getInts(1, new int[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JsonListType#setInts(int, int[])}.
   *
   * <p>Method under test: {@link JsonListType#setInts(int, int[])}
   */
  @Test
  @DisplayName("Test setInts(int, int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.setInts(int, int[])"})
  void testSetInts() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).setInts(1, new int[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JsonListType#getLongs(int)} with {@code index}.
   *
   * <p>Method under test: {@link JsonListType#getLongs(int)}
   */
  @Test
  @DisplayName("Test getLongs(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JsonListType.getLongs(int)"})
  void testGetLongsWithIndex() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new JsonListType(true).getLongs(1));
  }

  /**
   * Test {@link JsonListType#getLongs(int, long[])} with {@code index}, {@code dfl}.
   *
   * <p>Method under test: {@link JsonListType#getLongs(int, long[])}
   */
  @Test
  @DisplayName("Test getLongs(int, long[]) with 'index', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] JsonListType.getLongs(int, long[])"})
  void testGetLongsWithIndexDfl() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).getLongs(1, new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link JsonListType#setLongs(int, long[])}.
   *
   * <p>Method under test: {@link JsonListType#setLongs(int, long[])}
   */
  @Test
  @DisplayName("Test setLongs(int, long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.setLongs(int, long[])"})
  void testSetLongs() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).setLongs(1, new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link JsonListType#getList(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getList(int)}
   */
  @Test
  @DisplayName("Test getList(int) with 'index'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType JsonListType.getList(int)"})
  void testGetListWithIndex_thenReturnNull() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertNull(jsonListType.getList(1));
  }

  /**
   * Test {@link JsonListType#getMap(int, MapType)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getMap(int, MapType)}
   */
  @Test
  @DisplayName("Test getMap(int, MapType) with 'index', 'dfl'; then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonListType.getMap(int, MapType)"})
  void testGetMapWithIndexDfl_thenReturnNBTMapType() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = jsonListType.getMap(1, dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link JsonListType#getMap(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link JsonListType#JsonListType(boolean)} with compressed is {@code true} addByte
   *       {@code X}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getMap(int)}
   */
  @Test
  @DisplayName(
      "Test getMap(int) with 'index'; given JsonListType(boolean) with compressed is 'true' addByte 'X'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonListType.getMap(int)"})
  void testGetMapWithIndex_givenJsonListTypeWithCompressedIsTrueAddByteX_thenReturnNull() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertNull(jsonListType.getMap(1));
  }

  /**
   * Test {@link JsonListType#getString(int, String)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code 65}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getString(int, String)}
   */
  @Test
  @DisplayName("Test getString(int, String) with 'index', 'dfl'; then return '65'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonListType.getString(int, String)"})
  void testGetStringWithIndexDfl_thenReturn65() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals("65", jsonListType.getString(1, "Dfl"));
  }

  /**
   * Test {@link JsonListType#getString(int, String)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getString(int, String)}
   */
  @Test
  @DisplayName("Test getString(int, String) with 'index', 'dfl'; then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonListType.getString(int, String)"})
  void testGetStringWithIndexDfl_thenReturnDfl() {
    // Arrange
    JsonListType jsonListType = new JsonListType(false);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals("Dfl", jsonListType.getString(1, "Dfl"));
  }

  /**
   * Test {@link JsonListType#getString(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return {@code 65}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getString(int)}
   */
  @Test
  @DisplayName("Test getString(int) with 'index'; then return '65'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonListType.getString(int)"})
  void testGetStringWithIndex_thenReturn65() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals("65", jsonListType.getString(1));
  }

  /**
   * Test {@link JsonListType#getString(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonListType#getString(int)}
   */
  @Test
  @DisplayName("Test getString(int) with 'index'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonListType.getString(int)"})
  void testGetStringWithIndex_thenReturnNull() {
    // Arrange
    JsonListType jsonListType = new JsonListType(false);
    jsonListType.addByte((byte) 'X');
    jsonListType.addByte((byte) 'A');

    // Act and Assert
    assertNull(jsonListType.getString(1));
  }

  /**
   * Test {@link JsonListType#addByte(int, byte)} with {@code index}, {@code b}.
   *
   * <p>Method under test: {@link JsonListType#addByte(int, byte)}
   */
  @Test
  @DisplayName("Test addByte(int, byte) with 'index', 'b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addByte(int, byte)"})
  void testAddByteWithIndexB() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new JsonListType(true).addByte(1, (byte) 'A'));
  }

  /**
   * Test {@link JsonListType#addShort(int, short)} with {@code index}, {@code s}.
   *
   * <p>Method under test: {@link JsonListType#addShort(int, short)}
   */
  @Test
  @DisplayName("Test addShort(int, short) with 'index', 's'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addShort(int, short)"})
  void testAddShortWithIndexS() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new JsonListType(true).addShort(1, (short) 1));
  }

  /**
   * Test {@link JsonListType#addInt(int, int)} with {@code index}, {@code i}.
   *
   * <p>Method under test: {@link JsonListType#addInt(int, int)}
   */
  @Test
  @DisplayName("Test addInt(int, int) with 'index', 'i'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addInt(int, int)"})
  void testAddIntWithIndexI() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new JsonListType(true).addInt(1, 2));
  }

  /**
   * Test {@link JsonListType#addLong(int, long)} with {@code index}, {@code l}.
   *
   * <p>Method under test: {@link JsonListType#addLong(int, long)}
   */
  @Test
  @DisplayName("Test addLong(int, long) with 'index', 'l'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addLong(int, long)"})
  void testAddLongWithIndexL() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new JsonListType(true).addLong(1, 1L));
  }

  /**
   * Test {@link JsonListType#addFloat(int, float)} with {@code index}, {@code f}.
   *
   * <p>Method under test: {@link JsonListType#addFloat(int, float)}
   */
  @Test
  @DisplayName("Test addFloat(int, float) with 'index', 'f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addFloat(int, float)"})
  void testAddFloatWithIndexF() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new JsonListType(true).addFloat(1, 10.0f));
  }

  /**
   * Test {@link JsonListType#addDouble(int, double)} with {@code index}, {@code d}.
   *
   * <p>Method under test: {@link JsonListType#addDouble(int, double)}
   */
  @Test
  @DisplayName("Test addDouble(int, double) with 'index', 'd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addDouble(int, double)"})
  void testAddDoubleWithIndexD() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new JsonListType(true).addDouble(1, 10.0d));
  }

  /**
   * Test {@link JsonListType#addByteArray(byte[])} with {@code arr}.
   *
   * <p>Method under test: {@link JsonListType#addByteArray(byte[])}
   */
  @Test
  @DisplayName("Test addByteArray(byte[]) with 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addByteArray(byte[])"})
  void testAddByteArrayWithArr() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).addByteArray("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JsonListType#addByteArray(int, byte[])} with {@code index}, {@code arr}.
   *
   * <p>Method under test: {@link JsonListType#addByteArray(int, byte[])}
   */
  @Test
  @DisplayName("Test addByteArray(int, byte[]) with 'index', 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addByteArray(int, byte[])"})
  void testAddByteArrayWithIndexArr() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).addByteArray(1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JsonListType#addShortArray(short[])} with {@code arr}.
   *
   * <p>Method under test: {@link JsonListType#addShortArray(short[])}
   */
  @Test
  @DisplayName("Test addShortArray(short[]) with 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addShortArray(short[])"})
  void testAddShortArrayWithArr() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).addShortArray(new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JsonListType#addShortArray(int, short[])} with {@code index}, {@code arr}.
   *
   * <p>Method under test: {@link JsonListType#addShortArray(int, short[])}
   */
  @Test
  @DisplayName("Test addShortArray(int, short[]) with 'index', 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addShortArray(int, short[])"})
  void testAddShortArrayWithIndexArr() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).addShortArray(1, new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JsonListType#addIntArray(int[])} with {@code arr}.
   *
   * <p>Method under test: {@link JsonListType#addIntArray(int[])}
   */
  @Test
  @DisplayName("Test addIntArray(int[]) with 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addIntArray(int[])"})
  void testAddIntArrayWithArr() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).addIntArray(new int[] {2, 1, 2, 1}));
  }

  /**
   * Test {@link JsonListType#addIntArray(int, int[])} with {@code index}, {@code arr}.
   *
   * <p>Method under test: {@link JsonListType#addIntArray(int, int[])}
   */
  @Test
  @DisplayName("Test addIntArray(int, int[]) with 'index', 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addIntArray(int, int[])"})
  void testAddIntArrayWithIndexArr() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).addIntArray(1, new int[] {2, 1, 2, 1}));
  }

  /**
   * Test {@link JsonListType#addLongArray(long[])} with {@code arr}.
   *
   * <p>Method under test: {@link JsonListType#addLongArray(long[])}
   */
  @Test
  @DisplayName("Test addLongArray(long[]) with 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addLongArray(long[])"})
  void testAddLongArrayWithArr() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).addLongArray(new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link JsonListType#addLongArray(int, long[])} with {@code index}, {@code arr}.
   *
   * <p>Method under test: {@link JsonListType#addLongArray(int, long[])}
   */
  @Test
  @DisplayName("Test addLongArray(int, long[]) with 'index', 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addLongArray(int, long[])"})
  void testAddLongArrayWithIndexArr() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new JsonListType(true).addLongArray(1, new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link JsonListType#addList(int, ListType)} with {@code index}, {@code list}.
   *
   * <p>Method under test: {@link JsonListType#addList(int, ListType)}
   */
  @Test
  @DisplayName("Test addList(int, ListType) with 'index', 'list'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addList(int, ListType)"})
  void testAddListWithIndexList() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> jsonListType.addList(1, new NBTListType()));
  }

  /**
   * Test {@link JsonListType#addMap(int, MapType)} with {@code index}, {@code map}.
   *
   * <p>Method under test: {@link JsonListType#addMap(int, MapType)}
   */
  @Test
  @DisplayName("Test addMap(int, MapType) with 'index', 'map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addMap(int, MapType)"})
  void testAddMapWithIndexMap() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> jsonListType.addMap(1, new NBTMapType()));
  }

  /**
   * Test {@link JsonListType#addString(int, String)} with {@code index}, {@code string}.
   *
   * <p>Method under test: {@link JsonListType#addString(int, String)}
   */
  @Test
  @DisplayName("Test addString(int, String) with 'index', 'string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addString(int, String)"})
  void testAddStringWithIndexString() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new JsonListType(true).addString(1, "String"));
  }

  /**
   * Test {@link JsonListType#addString(String)} with {@code string}.
   *
   * <p>Method under test: {@link JsonListType#addString(String)}
   */
  @Test
  @DisplayName("Test addString(String) with 'string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addString(String)"})
  void testAddStringWithString() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);

    // Act
    jsonListType.addString("String");

    // Assert
    JsonArray json = jsonListType.getJson();
    Iterator<JsonElement> iteratorResult = json.iterator();
    assertTrue(iteratorResult.next() instanceof JsonPrimitive);
    Number asNumber = json.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("String", json.getAsString());
    assertEquals("String", asNumber.toString());
    assertEquals('S', json.getAsCharacter());
    assertFalse(json.getAsBoolean());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link JsonListType#addString(String)} with {@code string}.
   *
   * <p>Method under test: {@link JsonListType#addString(String)}
   */
  @Test
  @DisplayName("Test addString(String) with 'string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonListType.addString(String)"})
  void testAddStringWithString2() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);

    // Act
    jsonListType.addString(null);

    // Assert
    Iterator<JsonElement> iteratorResult = jsonListType.getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonNull);
    assertFalse(nextResult.isJsonPrimitive());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonNull());
    assertSame(nextResult, nextResult.getAsJsonNull());
  }
}
