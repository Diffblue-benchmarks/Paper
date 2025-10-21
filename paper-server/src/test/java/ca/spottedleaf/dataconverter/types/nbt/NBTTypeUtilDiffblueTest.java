package ca.spottedleaf.dataconverter.types.nbt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.ListType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.ObjectType;
import ca.spottedleaf.dataconverter.types.TypeUtil;
import ca.spottedleaf.dataconverter.types.Types;
import ca.spottedleaf.dataconverter.types.json.JsonListType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.json.JsonTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.EndTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.StringTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class NBTTypeUtilDiffblueTest {
  /**
   * Test {@link NBTTypeUtil#createEmptyList()}.
   *
   * <p>Method under test: {@link NBTTypeUtil#createEmptyList()}
   */
  @Test
  @DisplayName("Test createEmptyList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.createEmptyList()"})
  void testCreateEmptyList() {
    // Arrange
    NBTTypeUtil nbtTypeUtil = Types.NBT;

    // Act
    ListType actualCreateEmptyListResult = nbtTypeUtil.createEmptyList();

    // Assert
    assertTrue(actualCreateEmptyListResult instanceof NBTListType);
    TypeUtil<?> typeUtil = actualCreateEmptyListResult.getTypeUtil();
    assertTrue(typeUtil instanceof NBTTypeUtil);
    assertEquals(0, actualCreateEmptyListResult.size());
    assertEquals(ObjectType.NONE, actualCreateEmptyListResult.getUniformType());
    assertTrue(((NBTListType) actualCreateEmptyListResult).getTag().isEmpty());
    assertSame(nbtTypeUtil, typeUtil);
  }

  /**
   * Test {@link NBTTypeUtil#createEmptyMap()}.
   *
   * <p>Method under test: {@link NBTTypeUtil#createEmptyMap()}
   */
  @Test
  @DisplayName("Test createEmptyMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.createEmptyMap()"})
  void testCreateEmptyMap() {
    // Arrange
    NBTTypeUtil nbtTypeUtil = Types.NBT;

    // Act
    MapType actualCreateEmptyMapResult = nbtTypeUtil.createEmptyMap();

    // Assert
    assertTrue(actualCreateEmptyMapResult instanceof NBTMapType);
    TypeUtil<?> typeUtil = actualCreateEmptyMapResult.getTypeUtil();
    assertTrue(typeUtil instanceof NBTTypeUtil);
    assertEquals(0, actualCreateEmptyMapResult.size());
    CompoundTag tag = ((NBTMapType) actualCreateEmptyMapResult).getTag();
    assertEquals(0, tag.size());
    assertTrue(actualCreateEmptyMapResult.isEmpty());
    assertTrue(tag.isEmpty());
    assertEquals('\n', tag.getId());
    assertSame(nbtTypeUtil, typeUtil);
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   *   <li>Then Json iterator next return {@link JsonArray}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); given NBTListType(); then Json iterator next return JsonArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_givenNBTListType_thenJsonIteratorNextReturnJsonArray() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addList(new NBTListType());
    nbtListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.NBT.convertTo(nbtListType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertToResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonArray);
    JsonElement nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof JsonPrimitive);
    assertEquals(0, ((JsonArray) nextResult).size());
    assertFalse(iteratorResult.hasNext());
    assertFalse(((JsonArray) nextResult).iterator().hasNext());
    assertTrue(((JsonArray) nextResult).isEmpty());
    assertTrue(nextResult.isJsonArray());
    assertSame(nextResult, nextResult.getAsJsonArray());
    assertArrayEquals(new byte[] {'A'}, nextResult2.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then Json iterator next return {@link JsonObject}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); given NBTMapType(); then Json iterator next return JsonObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_givenNBTMapType_thenJsonIteratorNextReturnJsonObject() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addMap(new NBTMapType());
    nbtListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.NBT.convertTo(nbtListType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertToResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    JsonElement nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof JsonPrimitive);
    assertEquals(0, ((JsonObject) nextResult).size());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertTrue(((JsonObject) nextResult).isEmpty());
    assertSame(nextResult, nextResult.getAsJsonObject());
    assertArrayEquals(new byte[] {'A'}, nextResult2.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Then Json iterator next AsNumber return {@link LazilyParsedNumber}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); then Json iterator next AsNumber return LazilyParsedNumber")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_thenJsonIteratorNextAsNumberReturnLazilyParsedNumber() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addString("ca.spottedleaf.dataconverter.types.nbt.NBTListType");
    nbtListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.NBT.convertTo(nbtListType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertToResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    JsonElement nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof JsonPrimitive);
    Number asNumber = nextResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("ca.spottedleaf.dataconverter.types.nbt.NBTListType", nextResult.getAsString());
    assertEquals("ca.spottedleaf.dataconverter.types.nbt.NBTListType", asNumber.toString());
    assertEquals('c', nextResult.getAsCharacter());
    assertFalse(((JsonPrimitive) nextResult).isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(((JsonPrimitive) nextResult).isString());
    assertArrayEquals(new byte[] {'A'}, nextResult2.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Then return Json iterator next AsNumber longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); then return Json iterator next AsNumber longValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_thenReturnJsonIteratorNextAsNumberLongValueIsMinusOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(-1L);
    nbtListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.NBT.convertTo(nbtListType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertToResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    JsonElement nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof JsonPrimitive);
    assertEquals(-1L, nextResult.getAsNumber().longValue());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {-1}, nextResult.getAsBigInteger().toByteArray());
    assertArrayEquals(new byte[] {'A'}, nextResult2.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Then return Json iterator next AsNumber shortValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); then return Json iterator next AsNumber shortValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_thenReturnJsonIteratorNextAsNumberShortValueIsMinusOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) -1);
    nbtListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.NBT.convertTo(nbtListType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertToResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    JsonElement nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof JsonPrimitive);
    assertEquals((short) -1, nextResult.getAsNumber().shortValue());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {-1}, nextResult.getAsBigInteger().toByteArray());
    assertArrayEquals(new byte[] {'A'}, nextResult2.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", Types.NBT.convertTo("42", new JsonTypeUtil(true)));
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when 'A'; then return byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenA_thenReturnByteValueIsA() {
    // Arrange, Act and Assert
    assertEquals('A', ((Byte) Types.NBT.convertTo((byte) 'A', new JsonTypeUtil(true))).byteValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) Types.NBT.convertTo(false, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when forty-two; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) Types.NBT.convertTo(42, new JsonTypeUtil(true))).intValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when forty-two; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenFortyTwo_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, ((Long) Types.NBT.convertTo(42L, new JsonTypeUtil(true))).longValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link NBTListType#NBTListType()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when NBTListType(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenNBTListType_thenReturnSizeIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    Object actualConvertToResult = Types.NBT.convertTo(nbtListType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonListType);
    assertEquals(0, ((JsonListType) actualConvertToResult).size());
    JsonArray json = ((JsonListType) actualConvertToResult).getJson();
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when NBTMapType(); then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenNBTMapType_thenReturnJsonMapType() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    Object actualConvertToResult = Types.NBT.convertTo(nbtMapType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil = ((JsonMapType) actualConvertToResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, ((JsonMapType) actualConvertToResult).size());
    JsonObject json = ((JsonMapType) actualConvertToResult).getJson();
    assertEquals(0, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    assertTrue(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.NBT.convertTo(null, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return shortValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when one; then return shortValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenOne_thenReturnShortValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        (short) 1, ((Short) Types.NBT.convertTo((short) 1, new JsonTypeUtil(true))).shortValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when ten; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenTen_thenReturnDoubleValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d, ((Double) Types.NBT.convertTo(10.0d, new JsonTypeUtil(true))).doubleValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when ten; then return floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenTen_thenReturnFloatValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, ((Float) Types.NBT.convertTo(10.0f, new JsonTypeUtil(true))).floatValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) Types.NBT.convertTo(true, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link NBTTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when WILDCARD_OBJECT; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenWildcard_object_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            Types.NBT.convertTo(
                ConfigurationTransformation.WILDCARD_OBJECT, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putString("42", "net.minecraft.nbt.CompoundTag");
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(2, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo2() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putString("42", "net.minecraft.nbt.CompoundTag");
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@code -0.5}.
   *   <li>When {@link CompoundTag#CompoundTag()} Double {@code 42} is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given '-0.5'; when CompoundTag() Double '42' is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_given05_whenCompoundTagDouble42Is05() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putDouble("42", -0.5d);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(2, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@code -0.5}.
   *   <li>When {@link CompoundTag#CompoundTag()} Double {@code 42} is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given '-0.5'; when CompoundTag() Double '42' is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_given05_whenCompoundTagDouble42Is052() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putDouble("42", -0.5d);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@code 0.5}.
   *   <li>When {@link CompoundTag#CompoundTag()} Float {@code 42} is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given '0.5'; when CompoundTag() Float '42' is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_given05_whenCompoundTagFloat42Is05() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putFloat("42", 0.5f);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(2, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@code 0.5}.
   *   <li>When {@link CompoundTag#CompoundTag()} Float {@code 42} is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given '0.5'; when CompoundTag() Float '42' is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_given05_whenCompoundTagFloat42Is052() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putFloat("42", 0.5f);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenA() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putByteArray("42", new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given array of {@code int} with forty-two and minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given array of int with forty-two and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenArrayOfIntWithFortyTwoAndMinusOne() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putIntArray("42", new int[] {42, -1, 42, -1});
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given array of {@code long} with forty-two and minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given array of long with forty-two and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenArrayOfLongWithFortyTwoAndMinusOne() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putLongArray("42", new long[] {42L, -1L, 42L, -1L});
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given CompoundTag()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenCompoundTag() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.put("net.minecraft.nbt.CompoundTag", new CompoundTag());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>Then return Json size is three.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given 'Key'; then return Json size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenKey_thenReturnJsonSizeIsThree() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.put("Key", ByteTag.ONE);
    input.putShort("42", (short) 2);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(3, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(3, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>Then return Tag size is three.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given 'Key'; then return Tag size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenKey_thenReturnTagSizeIsThree() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.put("Key", ByteTag.ONE);
    input.putShort("42", (short) 2);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(3, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(3, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given {@link ListTag#ListTag()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given ListTag()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenListTag() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.put("net.minecraft.nbt.CompoundTag", new ListTag());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link CompoundTag#CompoundTag()} Int {@code 42} is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given one; when CompoundTag() Int '42' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenOne_whenCompoundTagInt42IsOne() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putInt("42", 1);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(2, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link CompoundTag#CompoundTag()} Int {@code 42} is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given one; when CompoundTag() Int '42' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenOne_whenCompoundTagInt42IsOne2() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putInt("42", 1);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link CompoundTag#CompoundTag()} Long {@code 42} is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given one; when CompoundTag() Long '42' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenOne_whenCompoundTagLong42IsOne() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putLong("42", 1L);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(2, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link CompoundTag#CompoundTag()} Long {@code 42} is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given one; when CompoundTag() Long '42' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenOne_whenCompoundTagLong42IsOne2() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putLong("42", 1L);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link CompoundTag#CompoundTag()} Short {@code 42} is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given two; when CompoundTag() Short '42' is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenTwo_whenCompoundTagShort42IsTwo() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putShort("42", (short) 2);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(2, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link CompoundTag#CompoundTag()} Short {@code 42} is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; given two; when CompoundTag() Short '42' is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_givenTwo_whenCompoundTagShort42IsTwo2() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.putShort("42", (short) 2);
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(2, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Then return intValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; then return intValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_thenReturnIntValueIsMinusOne() {
    // Arrange
    IntTag input = IntTag.valueOf(-1);

    // Act and Assert
    assertEquals(
        -1,
        ((Integer) Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true))).intValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Then return Json size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; then return Json size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_thenReturnJsonSizeIsOne() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.isEmpty());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>Then return longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; then return longValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_thenReturnLongValueIsMinusOne() {
    // Arrange
    LongTag input = LongTag.valueOf(-1L);

    // Act and Assert
    assertEquals(
        -1L,
        ((Long) Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true))).longValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()}.
   *   <li>Then return Json size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when CompoundTag(); then return Json size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenCompoundTag_thenReturnJsonSizeIsZero() {
    // Arrange
    CompoundTag input = new CompoundTag();

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(0, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    assertTrue(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()}.
   *   <li>Then return Tag size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when CompoundTag(); then return Tag size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenCompoundTag_thenReturnTagSizeIsZero() {
    // Arrange
    CompoundTag input = new CompoundTag();

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(0, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(0, tag.size());
    assertTrue(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link EndTag#INSTANCE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when INSTANCE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenInstance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.NBT.convertFromBaseToGeneric(EndTag.INSTANCE, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link ListTag#ListTag()}.
   *   <li>Then return {@link JsonListType}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when ListTag(); then return JsonListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenListTag_thenReturnJsonListType() {
    // Arrange
    ListTag input = new ListTag();

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonListType);
    assertEquals(0, ((JsonListType) actualConvertFromBaseToGenericResult).size());
    JsonArray json = ((JsonListType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link ListTag#ListTag()}.
   *   <li>Then return {@link NBTListType}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when ListTag(); then return NBTListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenListTag_thenReturnNBTListType() {
    // Arrange
    NBTTypeUtil nbtTypeUtil = Types.NBT;
    ListTag input = new ListTag();

    // Act
    Object actualConvertFromBaseToGenericResult =
        nbtTypeUtil.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTListType);
    TypeUtil<net.minecraft.nbt.Tag> typeUtil =
        ((NBTListType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof NBTTypeUtil);
    assertEquals(0, ((NBTListType) actualConvertFromBaseToGenericResult).size());
    assertEquals(
        ObjectType.NONE, ((NBTListType) actualConvertFromBaseToGenericResult).getUniformType());
    assertEquals(input, ((NBTListType) actualConvertFromBaseToGenericResult).getTag());
    assertSame(nbtTypeUtil, typeUtil);
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link NBTTypeUtil} (default constructor).
   *   <li>Then return Tag size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when NBTTypeUtil (default constructor); then return Tag size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenNBTTypeUtil_thenReturnTagSizeIsOne() {
    // Arrange
    CompoundTag input = new CompoundTag();
    input.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.NBT.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(1, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.NBT.convertFromBaseToGeneric(null, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link ByteTag#ONE}.
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when ONE; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenOne_thenReturnByteValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        (byte) 1,
        ((Byte) Types.NBT.convertFromBaseToGeneric(ByteTag.ONE, new JsonTypeUtil(true)))
            .byteValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link DoubleTag#ZERO}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when ZERO; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenZero_thenReturnDoubleValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d,
        ((Double) Types.NBT.convertFromBaseToGeneric(DoubleTag.ZERO, new JsonTypeUtil(true)))
            .doubleValue());
  }

  /**
   * Test {@link NBTTypeUtil#convertFromBaseToGeneric(Tag, TypeUtil)} with {@code input}, {@code
   * to}.
   *
   * <ul>
   *   <li>When {@link FloatTag#ZERO}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertFromBaseToGeneric(net.minecraft.nbt.Tag,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(Tag, TypeUtil) with 'input', 'to'; when ZERO; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object NBTTypeUtil.convertFromBaseToGeneric(net.minecraft.nbt.Tag, TypeUtil)"
  })
  void testConvertFromBaseToGenericWithInputTo_whenZero_thenReturnFloatValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0f,
        ((Float) Types.NBT.convertFromBaseToGeneric(FloatTag.ZERO, new JsonTypeUtil(true)))
            .floatValue());
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName("Test baseToGeneric(Tag) with 'input'; when CompoundTag(); then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenCompoundTag_thenReturnNBTMapType() {
    // Arrange
    NBTTypeUtil nbtTypeUtil = Types.NBT;
    CompoundTag input = new CompoundTag();

    // Act
    Object actualBaseToGenericResult = nbtTypeUtil.baseToGeneric(input);

    // Assert
    assertTrue(actualBaseToGenericResult instanceof NBTMapType);
    TypeUtil<net.minecraft.nbt.Tag> typeUtil =
        ((NBTMapType) actualBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof NBTTypeUtil);
    assertEquals(0, ((NBTMapType) actualBaseToGenericResult).size());
    assertTrue(((NBTMapType) actualBaseToGenericResult).isEmpty());
    assertSame(input, ((NBTMapType) actualBaseToGenericResult).getTag());
    assertSame(nbtTypeUtil, typeUtil);
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link EndTag#INSTANCE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName("Test baseToGeneric(Tag) with 'input'; when INSTANCE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenInstance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.NBT.baseToGeneric(EndTag.INSTANCE));
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link ListTag#ListTag()}.
   *   <li>Then return {@link NBTListType}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName("Test baseToGeneric(Tag) with 'input'; when ListTag(); then return NBTListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenListTag_thenReturnNBTListType() {
    // Arrange
    NBTTypeUtil nbtTypeUtil = Types.NBT;
    ListTag input = new ListTag();

    // Act
    Object actualBaseToGenericResult = nbtTypeUtil.baseToGeneric(input);

    // Assert
    assertTrue(actualBaseToGenericResult instanceof NBTListType);
    TypeUtil<net.minecraft.nbt.Tag> typeUtil =
        ((NBTListType) actualBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof NBTTypeUtil);
    assertEquals(0, ((NBTListType) actualBaseToGenericResult).size());
    assertEquals(ObjectType.NONE, ((NBTListType) actualBaseToGenericResult).getUniformType());
    assertSame(input, ((NBTListType) actualBaseToGenericResult).getTag());
    assertSame(nbtTypeUtil, typeUtil);
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName("Test baseToGeneric(Tag) with 'input'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.NBT.baseToGeneric(null));
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link ByteTag#ONE}.
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName("Test baseToGeneric(Tag) with 'input'; when ONE; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenOne_thenReturnByteValueIsOne() {
    // Arrange, Act and Assert
    assertEquals((byte) 1, ((Byte) Types.NBT.baseToGeneric(ByteTag.ONE)).byteValue());
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When valueOf {@code Data}.
   *   <li>Then return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName("Test baseToGeneric(Tag) with 'input'; when valueOf 'Data'; then return 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenValueOfData_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals("Data", Types.NBT.baseToGeneric(StringTag.valueOf("Data")));
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When valueOf minus one.
   *   <li>Then return intValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName(
      "Test baseToGeneric(Tag) with 'input'; when valueOf minus one; then return intValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenValueOfMinusOne_thenReturnIntValueIsMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ((Integer) Types.NBT.baseToGeneric(IntTag.valueOf(-1))).intValue());
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When valueOf minus one.
   *   <li>Then return longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName(
      "Test baseToGeneric(Tag) with 'input'; when valueOf minus one; then return longValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenValueOfMinusOne_thenReturnLongValueIsMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, ((Long) Types.NBT.baseToGeneric(LongTag.valueOf(-1L))).longValue());
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link DoubleTag#ZERO}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName("Test baseToGeneric(Tag) with 'input'; when ZERO; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenZero_thenReturnDoubleValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, ((Double) Types.NBT.baseToGeneric(DoubleTag.ZERO)).doubleValue());
  }

  /**
   * Test {@link NBTTypeUtil#baseToGeneric(Tag)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link FloatTag#ZERO}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#baseToGeneric(net.minecraft.nbt.Tag)}
   */
  @Test
  @DisplayName("Test baseToGeneric(Tag) with 'input'; when ZERO; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTTypeUtil.baseToGeneric(net.minecraft.nbt.Tag)"})
  void testBaseToGenericWithInput_whenZero_thenReturnFloatValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, ((Float) Types.NBT.baseToGeneric(FloatTag.ZERO)).floatValue());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>Then return value is minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); then return value is minus one hundred twenty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_thenReturnValueIsMinusOneHundredTwentyEight() {
    // Arrange and Act
    net.minecraft.nbt.Tag actualGenericToBaseResult = Types.NBT.genericToBase(-128);

    // Assert
    assertTrue(actualGenericToBaseResult instanceof IntTag);
    assertEquals(-128, ((IntTag) actualGenericToBaseResult).value());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>Then return value is minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); then return value is minus one hundred twenty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_thenReturnValueIsMinusOneHundredTwentyEight2() {
    // Arrange and Act
    net.minecraft.nbt.Tag actualGenericToBaseResult = Types.NBT.genericToBase(-128L);

    // Assert
    assertTrue(actualGenericToBaseResult instanceof LongTag);
    assertEquals(-128L, ((LongTag) actualGenericToBaseResult).value());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>Then return value is minus one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); then return value is minus one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_thenReturnValueIsMinusOneHundredTwentyNine() {
    // Arrange and Act
    net.minecraft.nbt.Tag actualGenericToBaseResult = Types.NBT.genericToBase(-129);

    // Assert
    assertTrue(actualGenericToBaseResult instanceof IntTag);
    assertEquals(-129, ((IntTag) actualGenericToBaseResult).value());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>Then return value is minus one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); then return value is minus one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_thenReturnValueIsMinusOneHundredTwentyNine2() {
    // Arrange and Act
    net.minecraft.nbt.Tag actualGenericToBaseResult = Types.NBT.genericToBase(-129L);

    // Assert
    assertTrue(actualGenericToBaseResult instanceof LongTag);
    assertEquals(-129L, ((LongTag) actualGenericToBaseResult).value());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@code 1025}.
   *   <li>Then return value is {@code 1025}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when '1025'; then return value is '1025'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_when1025_thenReturnValueIs1025() {
    // Arrange and Act
    net.minecraft.nbt.Tag actualGenericToBaseResult = Types.NBT.genericToBase(1025);

    // Assert
    assertTrue(actualGenericToBaseResult instanceof IntTag);
    assertEquals(1025, ((IntTag) actualGenericToBaseResult).value());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@code 1025}.
   *   <li>Then return value is {@code 1025}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when '1025'; then return value is '1025'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_when1025_thenReturnValueIs10252() {
    // Arrange and Act
    net.minecraft.nbt.Tag actualGenericToBaseResult = Types.NBT.genericToBase(1025L);

    // Assert
    assertTrue(actualGenericToBaseResult instanceof LongTag);
    assertEquals(1025L, ((LongTag) actualGenericToBaseResult).value());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return value is empty string.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when empty string; then return value is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenEmptyString_thenReturnValueIsEmptyString() {
    // Arrange and Act
    net.minecraft.nbt.Tag actualGenericToBaseResult = Types.NBT.genericToBase("");

    // Assert
    assertTrue(actualGenericToBaseResult instanceof StringTag);
    assertEquals("", ((StringTag) actualGenericToBaseResult).value());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return value is {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when 'Input'; then return value is 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenInput_thenReturnValueIsInput() {
    // Arrange and Act
    net.minecraft.nbt.Tag actualGenericToBaseResult = Types.NBT.genericToBase("Input");

    // Assert
    assertTrue(actualGenericToBaseResult instanceof StringTag);
    assertEquals("Input", ((StringTag) actualGenericToBaseResult).value());
  }

  /**
   * Test {@link NBTTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when WILDCARD_OBJECT; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.nbt.Tag NBTTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenWildcard_object_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> Types.NBT.genericToBase(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.putInt("net.minecraft.nbt.CompoundTag", 1);
    nbt.put("Key", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(2, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag2() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.putLong("net.minecraft.nbt.CompoundTag", 1L);
    nbt.put("Key", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(2, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag3() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.putDouble("net.minecraft.nbt.CompoundTag", 0.5d);
    nbt.put("Key", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(2, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag4() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.putIntArray("42", new int[] {42, 1, 42, 1});

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag5() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.putLongArray("42", new long[] {42L, 1L, 42L, 1L});

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given {@code -0.5}.
   *   <li>When {@link CompoundTag#CompoundTag()} Double {@code 42} is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given '-0.5'; when CompoundTag() Double '42' is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_given05_whenCompoundTagDouble42Is05() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.putDouble("42", -0.5d);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given {@code 0.5}.
   *   <li>When {@link CompoundTag#CompoundTag()} Float {@code 42} is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given '0.5'; when CompoundTag() Float '42' is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_given05_whenCompoundTagFloat42Is05() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.putFloat("42", 0.5f);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given {@code 0.8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given '0.8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_given08() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.putFloat("net.minecraft.nbt.CompoundTag", 0.8f);
    nbt.put("Key", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(2, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.putByteArray("42", "AXAXAXAX".getBytes("UTF-8"));

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given CompoundTag()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_givenCompoundTag() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.put("Key", new CompoundTag());

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(1, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given eight.
   *   <li>When {@link CompoundTag#CompoundTag()} Short {@code 42} is eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given eight; when CompoundTag() Short '42' is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_givenEight_whenCompoundTagShort42IsEight() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.putShort("42", (short) 8);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given {@link ListTag#ListTag()}.
   *   <li>When {@link CompoundTag#CompoundTag()} {@code Key} is {@link ListTag#ListTag()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given ListTag(); when CompoundTag() 'Key' is ListTag()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_givenListTag_whenCompoundTagKeyIsListTag() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.put("Key", new ListTag());

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(1, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_givenMinusOne() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.putShort("net.minecraft.nbt.CompoundTag", (short) -1);
    nbt.put("Key", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(2, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(2, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given minus one; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_givenMinusOne_thenReturnSizeIsThree() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.put("42", ByteTag.ONE);
    nbt.putShort("net.minecraft.nbt.CompoundTag", (short) -1);
    nbt.put("Key", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(3, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(3, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link CompoundTag#CompoundTag()} Int {@code 42} is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given zero; when CompoundTag() Int '42' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_givenZero_whenCompoundTagInt42IsZero() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.putInt("42", 0);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link CompoundTag#CompoundTag()} Long {@code 42} is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; given zero; when CompoundTag() Long '42' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_givenZero_whenCompoundTagLong42IsZero() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.putLong("42", 0L);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>Then return Json size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; then return Json size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_thenReturnJsonSizeIsOne() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag nbt = new CompoundTag();
    nbt.put("Key", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(1, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; when CompoundTag() '42' is ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_whenCompoundTag42IsOne() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.put("42", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; when CompoundTag() '42' is ONE; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_whenCompoundTag42IsOne_thenReturnSizeIsTwo() {
    // Arrange
    CompoundTag nbt = new CompoundTag();
    nbt.put("Key", ByteTag.ONE);
    nbt.put("42", ByteTag.ONE);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(2, actualConvertNBTResult.size());
    assertFalse(actualConvertNBTResult.isEmpty());
    assertEquals(nbt, ((NBTMapType) actualConvertNBTResult).getTag());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()}.
   *   <li>Then return Json size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; when CompoundTag(); then return Json size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_whenCompoundTag_thenReturnJsonSizeIsZero() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    // Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, new CompoundTag());

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonMapType);
    assertEquals(0, actualConvertNBTResult.size());
    JsonObject json = ((JsonMapType) actualConvertNBTResult).getJson();
    assertEquals(0, json.size());
    assertTrue(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)} with {@code TypeUtil}, {@code
   * CompoundTag}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()}.
   *   <li>Then return Tag size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, CompoundTag) with 'TypeUtil', 'CompoundTag'; when CompoundTag(); then return Tag size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTTypeUtil.convertNBT(TypeUtil, CompoundTag)"})
  void testConvertNBTWithTypeUtilCompoundTag_whenCompoundTag_thenReturnTagSizeIsZero() {
    // Arrange and Act
    MapType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, new CompoundTag());

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTMapType);
    assertEquals(0, actualConvertNBTResult.size());
    CompoundTag tag = ((NBTMapType) actualConvertNBTResult).getTag();
    assertEquals(0, tag.size());
    assertTrue(actualConvertNBTResult.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putString("42", "net.minecraft.nbt.CompoundTag");
    compoundTag.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag2() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putShort("net.minecraft.nbt.CompoundTag", (short) -1);
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag3() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putInt("net.minecraft.nbt.CompoundTag", 1);
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag4() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putLong("net.minecraft.nbt.CompoundTag", 1L);
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag5() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putFloat("net.minecraft.nbt.CompoundTag", 0.8f);
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag6() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putDouble("net.minecraft.nbt.CompoundTag", 0.5d);
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag7() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putString("net.minecraft.nbt.CompoundTag", "Value");
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag8() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putByteArray(
        "net.minecraft.nbt.CompoundTag", new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag9() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putIntArray("net.minecraft.nbt.CompoundTag", new int[] {42, 1, 42, 1});
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag10() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putLongArray("net.minecraft.nbt.CompoundTag", new long[] {42L, 1L, 42L, 1L});
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag11() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.put("net.minecraft.nbt.CompoundTag", new CompoundTag());

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(1, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag12() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.put("net.minecraft.nbt.CompoundTag", new ListTag());

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(1, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given CompoundTag() '42' is ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenCompoundTag42IsOne() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.put("42", ByteTag.ONE);
    compoundTag.putShort("net.minecraft.nbt.CompoundTag", (short) -1);
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Double {@code 42} is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given CompoundTag() Double '42' is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenCompoundTagDouble42Is05() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putDouble("42", -0.5d);
    compoundTag.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Float {@code 42} is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given CompoundTag() Float '42' is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenCompoundTagFloat42Is05() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putFloat("42", 0.5f);
    compoundTag.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Int {@code 42} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given CompoundTag() Int '42' is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenCompoundTagInt42IsMinusOne() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putInt("42", -1);
    compoundTag.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Long {@code 42} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given CompoundTag() Long '42' is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenCompoundTagLong42IsMinusOne() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putLong("42", -1L);
    compoundTag.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code 42} is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given CompoundTag() Short '42' is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenCompoundTagShort42IsTwo() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putShort("42", (short) 2);
    compoundTag.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()}.
   *   <li>Then return UniformType is {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given CompoundTag(); then return UniformType is 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenCompoundTag_thenReturnUniformTypeIsMap() {
    // Arrange
    ListTag nbt = new ListTag();
    CompoundTag compoundTag = new CompoundTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link ListTag#ListTag()}.
   *   <li>Then return UniformType is {@code LIST}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given ListTag(); then return UniformType is 'LIST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenListTag_thenReturnUniformTypeIsList() {
    // Arrange
    ListTag nbt = new ListTag();
    nbt.add(new ListTag());

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.LIST, actualConvertNBTResult.getUniformType());
    assertTrue(((List<Object>) tag.get(0)).isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link ByteTag#ONE}.
   *   <li>Then return Json AsNumber byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given ONE; then return Json AsNumber byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenOne_thenReturnJsonAsNumberByteValueIsOne() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    ListTag nbt = new ListTag();
    nbt.add(ByteTag.ONE);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    JsonArray json = ((JsonListType) actualConvertNBTResult).getJson();
    Iterator<JsonElement> iteratorResult = json.iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    assertEquals((byte) 1, json.getAsNumber().byteValue());
    assertEquals((byte) 1, nextResult.getAsNumber().byteValue());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {1}, json.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link ByteTag#ONE}.
   *   <li>Then return Json iterator next.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given ONE; then return Json iterator next")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenOne_thenReturnJsonIteratorNext() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    ListTag nbt = new ListTag();
    nbt.add(ByteTag.ONE);
    nbt.add(ByteTag.ONE);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    JsonArray json = ((JsonListType) actualConvertNBTResult).getJson();
    Iterator<JsonElement> iteratorResult = json.iterator();
    JsonElement expectedJsonPrimitive = iteratorResult.next();
    JsonElement nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof JsonPrimitive);
    assertEquals(expectedJsonPrimitive, nextResult);
    assertEquals(2, json.size());
    assertEquals(2, actualConvertNBTResult.size());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link ByteTag#ONE}.
   *   <li>Then return UniformType is {@code BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given ONE; then return UniformType is 'BYTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenOne_thenReturnUniformTypeIsByte() {
    // Arrange
    ListTag nbt = new ListTag();
    nbt.add(ByteTag.ONE);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    assertEquals(1, actualConvertNBTResult.size());
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals((byte) 1, ((ByteTag) tag.get(0)).value());
    assertEquals(ObjectType.BYTE, actualConvertNBTResult.getUniformType());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given valueOf one.
   *   <li>Then return UniformType is {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given valueOf one; then return UniformType is 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenValueOfOne_thenReturnUniformTypeIsInt() {
    // Arrange
    ListTag nbt = new ListTag();
    IntTag valueOfResult = IntTag.valueOf(1);
    nbt.add(valueOfResult);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(0);
    assertEquals(1, ((IntTag) getResult).value());
    assertEquals(ObjectType.INT, actualConvertNBTResult.getUniformType());
    assertSame(valueOfResult, getResult);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given valueOf one.
   *   <li>Then return UniformType is {@code LONG}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given valueOf one; then return UniformType is 'LONG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenValueOfOne_thenReturnUniformTypeIsLong() {
    // Arrange
    ListTag nbt = new ListTag();
    LongTag valueOfResult = LongTag.valueOf(1L);
    nbt.add(valueOfResult);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(0);
    assertEquals(1L, ((LongTag) getResult).value());
    assertEquals(ObjectType.LONG, actualConvertNBTResult.getUniformType());
    assertSame(valueOfResult, getResult);
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>Then return Tag first value is ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given valueOf ten; then return Tag first value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenValueOfTen_thenReturnTagFirstValueIsTen() {
    // Arrange
    ListTag nbt = new ListTag();
    nbt.add(DoubleTag.valueOf(10.0d));

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(10.0d, ((DoubleTag) tag.get(0)).value());
    assertEquals(ObjectType.DOUBLE, actualConvertNBTResult.getUniformType());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>Then return Tag first value is ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given valueOf ten; then return Tag first value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenValueOfTen_thenReturnTagFirstValueIsTen2() {
    // Arrange
    ListTag nbt = new ListTag();
    nbt.add(FloatTag.valueOf(10.0f));

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(10.0f, ((FloatTag) tag.get(0)).value());
    assertEquals(ObjectType.FLOAT, actualConvertNBTResult.getUniformType());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link DoubleTag#ZERO}.
   *   <li>Then return Tag first value is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given ZERO; then return Tag first value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenZero_thenReturnTagFirstValueIsZero() {
    // Arrange
    ListTag nbt = new ListTag();
    nbt.add(DoubleTag.ZERO);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(0.0d, ((DoubleTag) tag.get(0)).value());
    assertEquals(1, actualConvertNBTResult.size());
    assertEquals(ObjectType.DOUBLE, actualConvertNBTResult.getUniformType());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Given {@link FloatTag#ZERO}.
   *   <li>Then return Tag first value is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; given ZERO; then return Tag first value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_givenZero_thenReturnTagFirstValueIsZero2() {
    // Arrange
    ListTag nbt = new ListTag();
    nbt.add(FloatTag.ZERO);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(0.0f, ((FloatTag) tag.get(0)).value());
    assertEquals(1, actualConvertNBTResult.size());
    assertEquals(ObjectType.FLOAT, actualConvertNBTResult.getUniformType());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then Json iterator next return {@link JsonArray}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then Json iterator next return JsonArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenJsonIteratorNextReturnJsonArray() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    ListTag nbt = new ListTag();
    nbt.add(new ListTag());

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonArray);
    assertEquals(0, ((JsonArray) nextResult).size());
    assertFalse(iteratorResult.hasNext());
    assertFalse(((JsonArray) nextResult).iterator().hasNext());
    assertTrue(((JsonArray) nextResult).isEmpty());
    assertTrue(nextResult.isJsonArray());
    assertSame(nextResult, nextResult.getAsJsonArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then return Json AsNumber doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then return Json AsNumber doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenReturnJsonAsNumberDoubleValueIsZero() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    ListTag nbt = new ListTag();
    nbt.add(DoubleTag.ZERO);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    JsonArray json = ((JsonListType) actualConvertNBTResult).getJson();
    Iterator<JsonElement> iteratorResult = json.iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    assertEquals(0.0d, json.getAsNumber().doubleValue());
    assertEquals(0.0d, nextResult.getAsNumber().doubleValue());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then return Json AsNumber floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then return Json AsNumber floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenReturnJsonAsNumberFloatValueIsZero() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    ListTag nbt = new ListTag();
    nbt.add(FloatTag.ZERO);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    JsonArray json = ((JsonListType) actualConvertNBTResult).getJson();
    Iterator<JsonElement> iteratorResult = json.iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    assertEquals(0.0f, json.getAsNumber().floatValue());
    assertEquals(0.0f, nextResult.getAsNumber().floatValue());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then return Json AsNumber intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then return Json AsNumber intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenReturnJsonAsNumberIntValueIsOne() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    ListTag nbt = new ListTag();
    nbt.add(IntTag.valueOf(1));

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    JsonArray json = ((JsonListType) actualConvertNBTResult).getJson();
    Iterator<JsonElement> iteratorResult = json.iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    assertEquals(1, json.getAsNumber().intValue());
    assertEquals(1, nextResult.getAsNumber().intValue());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {1}, json.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then return Json AsNumber longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then return Json AsNumber longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenReturnJsonAsNumberLongValueIsOne() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    ListTag nbt = new ListTag();
    nbt.add(LongTag.valueOf(1L));

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    JsonArray json = ((JsonListType) actualConvertNBTResult).getJson();
    Iterator<JsonElement> iteratorResult = json.iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    assertEquals(1L, json.getAsNumber().longValue());
    assertEquals(1L, nextResult.getAsNumber().longValue());
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {1}, json.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then return Json iterator next size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then return Json iterator next size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenReturnJsonIteratorNextSizeIsOne() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(1, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then return Json iterator next size is three.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then return Json iterator next size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenReturnJsonIteratorNextSizeIsThree() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    CompoundTag compoundTag = new CompoundTag();
    compoundTag.put("Key", ByteTag.ONE);
    compoundTag.putShort("42", (short) 2);
    compoundTag.put("net.minecraft.nbt.CompoundTag", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(3, ((JsonObject) nextResult).size());
    assertFalse(((JsonObject) nextResult).isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then return Json iterator next size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then return Json iterator next size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenReturnJsonIteratorNextSizeIsZero() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    ListTag nbt = new ListTag();
    nbt.add(new CompoundTag());

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertNBTResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(0, ((JsonObject) nextResult).size());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertTrue(((JsonObject) nextResult).isEmpty());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>Then return UniformType is {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; then return UniformType is 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_thenReturnUniformTypeIsMap() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.put("Key", ByteTag.ONE);

    ListTag nbt = new ListTag();
    nbt.add(compoundTag);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(Types.NBT, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertNBTResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.MAP, actualConvertNBTResult.getUniformType());
    assertEquals(compoundTag, tag.get(0));
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>When {@link ListTag#ListTag()}.
   *   <li>Then return Json size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; when ListTag(); then return Json size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_whenListTag_thenReturnJsonSizeIsZero() {
    // Arrange
    JsonTypeUtil resultTo = new JsonTypeUtil(true);

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, new ListTag());

    // Assert
    assertTrue(actualConvertNBTResult instanceof JsonListType);
    assertEquals(0, actualConvertNBTResult.size());
    JsonArray json = ((JsonListType) actualConvertNBTResult).getJson();
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }

  /**
   * Test {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)} with {@code TypeUtil}, {@code ListTag}.
   *
   * <ul>
   *   <li>When {@link ListTag#ListTag()}.
   *   <li>Then TypeUtil return {@link NBTTypeUtil}.
   * </ul>
   *
   * <p>Method under test: {@link NBTTypeUtil#convertNBT(TypeUtil, ListTag)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeUtil, ListTag) with 'TypeUtil', 'ListTag'; when ListTag(); then TypeUtil return NBTTypeUtil")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTTypeUtil.convertNBT(TypeUtil, ListTag)"})
  void testConvertNBTWithTypeUtilListTag_whenListTag_thenTypeUtilReturnNBTTypeUtil() {
    // Arrange
    NBTTypeUtil resultTo = Types.NBT;
    ListTag nbt = new ListTag();

    // Act
    ListType actualConvertNBTResult = NBTTypeUtil.convertNBT(resultTo, nbt);

    // Assert
    assertTrue(actualConvertNBTResult instanceof NBTListType);
    TypeUtil<?> typeUtil = actualConvertNBTResult.getTypeUtil();
    assertTrue(typeUtil instanceof NBTTypeUtil);
    assertEquals(0, actualConvertNBTResult.size());
    assertEquals(ObjectType.NONE, actualConvertNBTResult.getUniformType());
    assertEquals(nbt, ((NBTListType) actualConvertNBTResult).getTag());
    assertSame(resultTo, typeUtil);
  }
}
