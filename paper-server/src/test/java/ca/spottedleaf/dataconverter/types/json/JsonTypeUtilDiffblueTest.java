package ca.spottedleaf.dataconverter.types.json;

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
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.ShortTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class JsonTypeUtilDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonTypeUtil#JsonTypeUtil(boolean)}
   *   <li>{@link JsonTypeUtil#isCompressed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonTypeUtil.<init>(boolean)", "boolean JsonTypeUtil.isCompressed()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new JsonTypeUtil(true).isCompressed());
  }

  /**
   * Test {@link JsonTypeUtil#createEmptyList()}.
   *
   * <p>Method under test: {@link JsonTypeUtil#createEmptyList()}
   */
  @Test
  @DisplayName("Test createEmptyList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType JsonTypeUtil.createEmptyList()"})
  void testCreateEmptyList() {
    // Arrange
    JsonTypeUtil jsonTypeUtil = Types.JSON;

    // Act
    ListType actualCreateEmptyListResult = jsonTypeUtil.createEmptyList();

    // Assert
    assertTrue(actualCreateEmptyListResult instanceof JsonListType);
    TypeUtil<?> typeUtil = actualCreateEmptyListResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, actualCreateEmptyListResult.size());
    JsonArray json = ((JsonListType) actualCreateEmptyListResult).getJson();
    assertEquals(0, json.size());
    assertEquals(ObjectType.UNDEFINED, actualCreateEmptyListResult.getUniformType());
    assertFalse(((JsonTypeUtil) typeUtil).isCompressed());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonObject());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.iterator().hasNext());
    assertFalse(((JsonListType) actualCreateEmptyListResult).compressed);
    assertTrue(json.isEmpty());
    assertTrue(json.isJsonArray());
    JsonArray actualAsJsonArray = json.getAsJsonArray();
    assertSame(json, actualAsJsonArray);
    assertSame(jsonTypeUtil, typeUtil);
  }

  /**
   * Test {@link JsonTypeUtil#createEmptyMap()}.
   *
   * <p>Method under test: {@link JsonTypeUtil#createEmptyMap()}
   */
  @Test
  @DisplayName("Test createEmptyMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType JsonTypeUtil.createEmptyMap()"})
  void testCreateEmptyMap() {
    // Arrange
    JsonTypeUtil jsonTypeUtil = Types.JSON;

    // Act
    MapType actualCreateEmptyMapResult = jsonTypeUtil.createEmptyMap();

    // Assert
    assertTrue(actualCreateEmptyMapResult instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualCreateEmptyMapResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, actualCreateEmptyMapResult.size());
    JsonObject json = ((JsonMapType) actualCreateEmptyMapResult).getJson();
    assertEquals(0, json.size());
    assertFalse(((JsonTypeUtil) typeUtil).isCompressed());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertFalse(((JsonMapType) actualCreateEmptyMapResult).compressed);
    assertTrue(json.isJsonObject());
    assertTrue(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
    assertSame(jsonTypeUtil, typeUtil);
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link NBTTypeUtil} (default constructor).
   *   <li>Then return Tag size is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); given 'A'; when NBTTypeUtil (default constructor); then return Tag size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_givenA_whenNBTTypeUtil_thenReturnTagSizeIsOne() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTListType);
    assertEquals(1, ((NBTListType) actualConvertToResult).size());
    ListTag tag = ((NBTListType) actualConvertToResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.BYTE, ((NBTListType) actualConvertToResult).getUniformType());
    assertEquals('A', ((ByteTag) tag.get(0)).value());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then Tag first return {@link IntTag}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); given one; then Tag first return IntTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_givenOne_thenTagFirstReturnIntTag() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addInt(1);
    jsonListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertToResult).getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ByteTag);
    net.minecraft.nbt.Tag getResult2 = tag.get(0);
    assertTrue(getResult2 instanceof IntTag);
    assertEquals(1, ((IntTag) getResult2).value());
    assertEquals(2, ((NBTListType) actualConvertToResult).size());
    assertEquals(ObjectType.MIXED, ((NBTListType) actualConvertToResult).getUniformType());
    assertEquals('A', ((ByteTag) getResult).value());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Then Tag first return {@link DoubleTag}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); then Tag first return DoubleTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_thenTagFirstReturnDoubleTag() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addDouble(0.5d);
    jsonListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertToResult).getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ByteTag);
    net.minecraft.nbt.Tag getResult2 = tag.get(0);
    assertTrue(getResult2 instanceof DoubleTag);
    assertEquals(0.5d, ((DoubleTag) getResult2).value());
    assertEquals(2, ((NBTListType) actualConvertToResult).size());
    assertEquals(ObjectType.MIXED, ((NBTListType) actualConvertToResult).getUniformType());
    assertEquals('A', ((ByteTag) getResult).value());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Then Tag first return {@link FloatTag}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); then Tag first return FloatTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_thenTagFirstReturnFloatTag() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addFloat(0.5f);
    jsonListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertToResult).getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ByteTag);
    net.minecraft.nbt.Tag getResult2 = tag.get(0);
    assertTrue(getResult2 instanceof FloatTag);
    assertEquals(0.5f, ((FloatTag) getResult2).value());
    assertEquals(2, ((NBTListType) actualConvertToResult).size());
    assertEquals(ObjectType.MIXED, ((NBTListType) actualConvertToResult).getUniformType());
    assertEquals('A', ((ByteTag) getResult).value());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Then Tag first return {@link LongTag}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); then Tag first return LongTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_thenTagFirstReturnLongTag() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addLong(2L);
    jsonListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertToResult).getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ByteTag);
    net.minecraft.nbt.Tag getResult2 = tag.get(0);
    assertTrue(getResult2 instanceof LongTag);
    assertEquals(2, ((NBTListType) actualConvertToResult).size());
    assertEquals(2L, ((LongTag) getResult2).value());
    assertEquals(ObjectType.MIXED, ((NBTListType) actualConvertToResult).getUniformType());
    assertEquals('A', ((ByteTag) getResult).value());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Then Tag first return {@link ShortTag}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); then Tag first return ShortTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_thenTagFirstReturnShortTag() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addShort((short) 2);
    jsonListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertToResult).getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ByteTag);
    net.minecraft.nbt.Tag getResult2 = tag.get(0);
    assertTrue(getResult2 instanceof ShortTag);
    assertEquals(2, ((NBTListType) actualConvertToResult).size());
    assertEquals((short) 2, ((ShortTag) getResult2).value());
    assertEquals(ObjectType.MIXED, ((NBTListType) actualConvertToResult).getUniformType());
    assertEquals('A', ((ByteTag) getResult).value());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Then Tag first return {@link StringTag}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); then Tag first return StringTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_thenTagFirstReturnStringTag() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);
    jsonListType.addString("ca.spottedleaf.dataconverter.types.json.JsonListType");
    jsonListType.addByte((byte) 'A');

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertToResult).getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ByteTag);
    net.minecraft.nbt.Tag getResult2 = tag.get(0);
    assertTrue(getResult2 instanceof StringTag);
    assertEquals(
        "ca.spottedleaf.dataconverter.types.json.JsonListType", ((StringTag) getResult2).value());
    assertEquals(2, ((NBTListType) actualConvertToResult).size());
    assertEquals(ObjectType.MIXED, ((NBTListType) actualConvertToResult).getUniformType());
    assertEquals('A', ((ByteTag) getResult).value());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", Types.JSON.convertTo("42", new JsonTypeUtil(true)));
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when 'A'; then return byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenA_thenReturnByteValueIsA() {
    // Arrange, Act and Assert
    assertEquals(
        'A', ((Byte) Types.JSON.convertTo((byte) 'A', new JsonTypeUtil(true))).byteValue());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) Types.JSON.convertTo(false, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when forty-two; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) Types.JSON.convertTo(42, new JsonTypeUtil(true))).intValue());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when forty-two; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenFortyTwo_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, ((Long) Types.JSON.convertTo(42L, new JsonTypeUtil(true))).longValue());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link JsonListType#JsonListType(boolean)} with compressed is {@code true}.
   *   <li>Then return Json size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when JsonListType(boolean) with compressed is 'true'; then return Json size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenJsonListTypeWithCompressedIsTrue_thenReturnJsonSizeIsZero() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonListType);
    assertEquals(0, ((JsonListType) actualConvertToResult).size());
    JsonArray json = ((JsonListType) actualConvertToResult).getJson();
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link JsonListType#JsonListType(boolean)} with compressed is {@code true}.
   *   <li>Then return UniformType is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when JsonListType(boolean) with compressed is 'true'; then return UniformType is 'NONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenJsonListTypeWithCompressedIsTrue_thenReturnUniformTypeIsNone() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonListType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTListType);
    assertEquals(0, ((NBTListType) actualConvertToResult).size());
    assertEquals(ObjectType.NONE, ((NBTListType) actualConvertToResult).getUniformType());
    assertTrue(((NBTListType) actualConvertToResult).getTag().isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when JsonMapType(boolean) with compressed is 'true'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenJsonMapTypeWithCompressedIsTrue_thenReturnJsonMapType() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonMapType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertToResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualConvertToResult);
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when JsonMapType(boolean) with compressed is 'true'; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenJsonMapTypeWithCompressedIsTrue_thenReturnNBTMapType() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    Object actualConvertToResult = Types.JSON.convertTo(jsonMapType, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertToResult instanceof NBTMapType);
    assertTrue(((NBTMapType) actualConvertToResult).getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, ((NBTMapType) actualConvertToResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertToResult).getTag();
    assertEquals(0, tag.size());
    assertTrue(((NBTMapType) actualConvertToResult).isEmpty());
    assertTrue(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.JSON.convertTo(null, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return shortValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when one; then return shortValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenOne_thenReturnShortValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        (short) 1, ((Short) Types.JSON.convertTo((short) 1, new JsonTypeUtil(true))).shortValue());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when ten; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenTen_thenReturnDoubleValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d, ((Double) Types.JSON.convertTo(10.0d, new JsonTypeUtil(true))).doubleValue());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when ten; then return floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenTen_thenReturnFloatValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, ((Float) Types.JSON.convertTo(10.0f, new JsonTypeUtil(true))).floatValue());
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertTo(Object, TypeUtil); when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) Types.JSON.convertTo(true, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link JsonTypeUtil#convertTo(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertTo(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertTo(Object, TypeUtil); when WILDCARD_OBJECT; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertTo(Object, TypeUtil)"})
  void testConvertTo_whenWildcard_object_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            Types.JSON.convertTo(
                ConfigurationTransformation.WILDCARD_OBJECT, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo() {
    // Arrange
    JsonObject input = new JsonObject();
    input.addProperty("", "");

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(1, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo2() {
    // Arrange
    JsonObject input = new JsonObject();
    input.addProperty("", true);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(1, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo3() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("", new JsonObject());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(1, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo4() {
    // Arrange
    JsonObject input = new JsonObject();
    input.addProperty("", "");

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(1, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo5() {
    // Arrange
    JsonObject input = new JsonObject();
    input.addProperty("", Bootstrap.bootstrapDuration);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(1, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo6() {
    // Arrange
    JsonObject input = new JsonObject();
    input.addProperty("", true);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(1, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; given '42'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_given42_thenReturnSizeIsThree() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("42", new JsonArray());
    input.add("Property", new JsonArray());
    input.add("", new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(3, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; given '42'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_given42_thenReturnSizeIsThree2() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("", new JsonArray());
    input.add("42", new JsonArray());
    input.add("Property", new JsonArray());
    input.add("", new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(3, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; given '42'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_given42_thenReturnSizeIsThree3() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("Property", new JsonArray());
    input.add("", new JsonArray());
    input.add("42", new JsonArray());
    input.add("Property", new JsonArray());
    input.add("", new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(3, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; given '42'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_given42_thenReturnSizeIsThree4() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("Property", new JsonArray());
    input.add("42", new JsonArray());
    input.add("Property", new JsonArray());
    input.add("", new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(3, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; given '42'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_given42_thenReturnSizeIsThree5() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("", new JsonArray());
    input.add("Property", new JsonArray());
    input.add("", new JsonArray());
    input.add("42", new JsonArray());
    input.add("Property", new JsonArray());
    input.add("", new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(3, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; given 'Property'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_givenProperty_thenReturnSizeIsTwo() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("Property", new JsonArray());
    input.add("", new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(2, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then Json iterator next return {@link JsonArray}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then Json iterator next return JsonArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenJsonIteratorNextReturnJsonArray() {
    // Arrange
    JsonArray input = new JsonArray();
    JsonArray element = new JsonArray();
    input.add(element);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertFromBaseToGenericResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonArray);
    assertFalse(iteratorResult.hasNext());
    assertEquals(element, nextResult);
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then Json iterator next return {@link JsonObject}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then Json iterator next return JsonObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenJsonIteratorNextReturnJsonObject() {
    // Arrange
    JsonArray input = new JsonArray();
    JsonObject element = new JsonObject();
    input.add(element);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonListType);
    Iterator<JsonElement> iteratorResult =
        ((JsonListType) actualConvertFromBaseToGenericResult).getJson().iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertFalse(iteratorResult.hasNext());
    assertEquals(element, nextResult);
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then Json iterator next return {@link JsonPrimitive}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then Json iterator next return JsonPrimitive")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenJsonIteratorNextReturnJsonPrimitive() {
    // Arrange
    JsonArray input = new JsonArray();
    input.add('\u0001');

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonListType);
    JsonArray json = ((JsonListType) actualConvertFromBaseToGenericResult).getJson();
    Iterator<JsonElement> iteratorResult = json.iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonPrimitive);
    Number asNumber = json.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    Number asNumber2 = nextResult.getAsNumber();
    assertTrue(asNumber2 instanceof LazilyParsedNumber);
    assertEquals("\u0001", json.getAsString());
    assertEquals("\u0001", nextResult.getAsString());
    assertEquals("\u0001", asNumber.toString());
    assertEquals('\u0001', json.getAsCharacter());
    assertEquals('\u0001', nextResult.getAsCharacter());
    assertFalse(((JsonPrimitive) nextResult).isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(((JsonPrimitive) nextResult).isString());
    assertEquals(asNumber, asNumber2);
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then return Json AsString is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then return Json AsString is '-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenReturnJsonAsStringIs1() {
    // Arrange
    JsonArray input = new JsonArray();
    input.add(Bootstrap.bootstrapDuration);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonListType);
    JsonArray json = ((JsonListType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals("-1", json.getAsString());
    assertEquals('-', json.getAsCharacter());
    assertEquals(-1, json.getAsInt());
    assertEquals(-1.0d, json.getAsDouble());
    assertEquals(-1.0f, json.getAsFloat());
    assertEquals(-1L, json.getAsLong());
    assertEquals((byte) -1, json.getAsByte());
    assertEquals((byte) -1, json.getAsNumber().byteValue());
    assertEquals((short) -1, json.getAsShort());
    assertEquals(new BigDecimal("-1"), json.getAsBigDecimal());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then return not Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then return not Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenReturnNotEmpty() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("", new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(1, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then return Tag first value is minus one.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then return Tag first value is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenReturnTagFirstValueIsMinusOne() {
    // Arrange
    JsonArray input = new JsonArray();
    input.add(Bootstrap.bootstrapDuration);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(1, tag.size());
    assertEquals((byte) -1, ((ByteTag) tag.get(0)).value());
    assertEquals(1, ((NBTListType) actualConvertFromBaseToGenericResult).size());
    assertEquals(
        ObjectType.BYTE, ((NBTListType) actualConvertFromBaseToGenericResult).getUniformType());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then return Tag first value is start of heading.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then return Tag first value is start of heading")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenReturnTagFirstValueIsStartOfHeading() {
    // Arrange
    JsonArray input = new JsonArray();
    input.add('\u0001');

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(1, tag.size());
    assertEquals("\u0001", ((StringTag) tag.get(0)).value());
    assertEquals(1, ((NBTListType) actualConvertFromBaseToGenericResult).size());
    assertEquals(
        ObjectType.STRING, ((NBTListType) actualConvertFromBaseToGenericResult).getUniformType());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then return UniformType is {@code LIST}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then return UniformType is 'LIST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenReturnUniformTypeIsList() {
    // Arrange
    JsonArray input = new JsonArray();
    input.add(new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(
        ObjectType.LIST, ((NBTListType) actualConvertFromBaseToGenericResult).getUniformType());
    assertTrue(((List<Object>) tag.get(0)).isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then return UniformType is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then return UniformType is 'NONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenReturnUniformTypeIsNone() {
    // Arrange
    JsonArray input = new JsonArray();

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTListType);
    assertEquals(0, ((NBTListType) actualConvertFromBaseToGenericResult).size());
    assertEquals(
        ObjectType.NONE, ((NBTListType) actualConvertFromBaseToGenericResult).getUniformType());
    assertTrue(((NBTListType) actualConvertFromBaseToGenericResult).getTag().isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>Then TypeUtil return {@link JsonTypeUtil}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; then TypeUtil return JsonTypeUtil")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_thenTypeUtilReturnJsonTypeUtil() {
    // Arrange
    JsonObject input = new JsonObject();
    input.addProperty("", Bootstrap.bootstrapDuration);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertFromBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    JsonObject json = ((JsonMapType) actualConvertFromBaseToGenericResult).getJson();
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   *   <li>Then return Json size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; when JsonArray(); then return Json size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_whenJsonArray_thenReturnJsonSizeIsZero() {
    // Arrange
    JsonArray input = new JsonArray();

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonListType);
    assertEquals(0, ((JsonListType) actualConvertFromBaseToGenericResult).size());
    JsonArray json = ((JsonListType) actualConvertFromBaseToGenericResult).getJson();
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; when JsonNull (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_whenJsonNull_thenReturnNull() {
    // Arrange
    JsonNull input = new JsonNull();

    // Act and Assert
    assertNull(Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; when JsonObject (default constructor) add empty string and JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_whenJsonObjectAddEmptyStringAndJsonArray() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("", new JsonArray());

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(1, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add empty string and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; when JsonObject (default constructor) add empty string and 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_whenJsonObjectAddEmptyStringAndNull() {
    // Arrange
    JsonObject input = new JsonObject();
    input.add("", null);

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

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
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; when JsonObject (default constructor); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_whenJsonObject_thenReturnSizeIsZero() {
    // Arrange
    JsonObject input = new JsonObject();

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof JsonMapType);
    assertEquals(0, ((JsonMapType) actualConvertFromBaseToGenericResult).size());
    assertEquals(input, ((JsonMapType) actualConvertFromBaseToGenericResult).getJson());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Tag size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; when JsonObject (default constructor); then return Tag size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_whenJsonObject_thenReturnTagSizeIsZero() {
    // Arrange
    JsonObject input = new JsonObject();

    // Act
    Object actualConvertFromBaseToGenericResult =
        Types.JSON.convertFromBaseToGeneric(input, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertFromBaseToGenericResult instanceof NBTMapType);
    assertEquals(0, ((NBTMapType) actualConvertFromBaseToGenericResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertFromBaseToGenericResult).getTag();
    assertEquals(0, tag.size());
    assertTrue(((NBTMapType) actualConvertFromBaseToGenericResult).isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)} with {@code input},
   * {@code to}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#convertFromBaseToGeneric(JsonElement, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertFromBaseToGeneric(JsonElement, TypeUtil) with 'input', 'to'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.convertFromBaseToGeneric(JsonElement, TypeUtil)"})
  void testConvertFromBaseToGenericWithInputTo_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.JSON.convertFromBaseToGeneric(null, new JsonTypeUtil(true)));
  }

  /**
   * Test {@link JsonTypeUtil#baseToGeneric(JsonElement)} with {@code input}.
   *
   * <ul>
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#baseToGeneric(JsonElement)}
   */
  @Test
  @DisplayName("Test baseToGeneric(JsonElement) with 'input'; then return TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.baseToGeneric(JsonElement)"})
  void testBaseToGenericWithInput_thenReturnTrueToString() {
    // Arrange and Act
    Object actualBaseToGenericResult =
        Types.JSON.baseToGeneric(new JsonPrimitive(Boolean.TRUE.toString()));

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualBaseToGenericResult);
  }

  /**
   * Test {@link JsonTypeUtil#baseToGeneric(JsonElement)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   *   <li>Then return {@link JsonListType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#baseToGeneric(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test baseToGeneric(JsonElement) with 'input'; when JsonArray(); then return JsonListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.baseToGeneric(JsonElement)"})
  void testBaseToGenericWithInput_whenJsonArray_thenReturnJsonListType() {
    // Arrange
    JsonTypeUtil jsonTypeUtil = Types.JSON;
    JsonArray input = new JsonArray();

    // Act
    Object actualBaseToGenericResult = jsonTypeUtil.baseToGeneric(input);

    // Assert
    assertTrue(actualBaseToGenericResult instanceof JsonListType);
    TypeUtil<JsonElement> typeUtil = ((JsonListType) actualBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, ((JsonListType) actualBaseToGenericResult).size());
    assertEquals(ObjectType.UNDEFINED, ((JsonListType) actualBaseToGenericResult).getUniformType());
    assertFalse(((JsonTypeUtil) typeUtil).isCompressed());
    assertSame(input, ((JsonListType) actualBaseToGenericResult).getJson());
    assertSame(jsonTypeUtil, typeUtil);
  }

  /**
   * Test {@link JsonTypeUtil#baseToGeneric(JsonElement)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#baseToGeneric(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test baseToGeneric(JsonElement) with 'input'; when JsonNull (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.baseToGeneric(JsonElement)"})
  void testBaseToGenericWithInput_whenJsonNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.JSON.baseToGeneric(new JsonNull()));
  }

  /**
   * Test {@link JsonTypeUtil#baseToGeneric(JsonElement)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#baseToGeneric(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test baseToGeneric(JsonElement) with 'input'; when JsonObject (default constructor); then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.baseToGeneric(JsonElement)"})
  void testBaseToGenericWithInput_whenJsonObject_thenReturnJsonMapType() {
    // Arrange
    JsonTypeUtil jsonTypeUtil = Types.JSON;
    JsonObject input = new JsonObject();

    // Act
    Object actualBaseToGenericResult = jsonTypeUtil.baseToGeneric(input);

    // Assert
    assertTrue(actualBaseToGenericResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil = ((JsonMapType) actualBaseToGenericResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, ((JsonMapType) actualBaseToGenericResult).size());
    assertFalse(((JsonTypeUtil) typeUtil).isCompressed());
    assertSame(input, ((JsonMapType) actualBaseToGenericResult).getJson());
    assertSame(jsonTypeUtil, typeUtil);
  }

  /**
   * Test {@link JsonTypeUtil#baseToGeneric(JsonElement)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#baseToGeneric(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test baseToGeneric(JsonElement) with 'input'; when JsonPrimitive(Boolean) with bool is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.baseToGeneric(JsonElement)"})
  void testBaseToGenericWithInput_whenJsonPrimitiveWithBoolIsFalse_thenReturnFalse() {
    // Arrange and Act
    Object actualBaseToGenericResult = Types.JSON.baseToGeneric(new JsonPrimitive(false));

    // Assert
    assertFalse((Boolean) actualBaseToGenericResult);
  }

  /**
   * Test {@link JsonTypeUtil#baseToGeneric(JsonElement)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#baseToGeneric(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test baseToGeneric(JsonElement) with 'input'; when JsonPrimitive(Boolean) with bool is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.baseToGeneric(JsonElement)"})
  void testBaseToGenericWithInput_whenJsonPrimitiveWithBoolIsTrue_thenReturnTrue() {
    // Arrange and Act
    Object actualBaseToGenericResult = Types.JSON.baseToGeneric(new JsonPrimitive(true));

    // Assert
    assertTrue((Boolean) actualBaseToGenericResult);
  }

  /**
   * Test {@link JsonTypeUtil#baseToGeneric(JsonElement)} with {@code input}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#baseToGeneric(JsonElement)}
   */
  @Test
  @DisplayName("Test baseToGeneric(JsonElement) with 'input'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonTypeUtil.baseToGeneric(JsonElement)"})
  void testBaseToGenericWithInput_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Types.JSON.baseToGeneric(null));
  }

  /**
   * Test {@link JsonTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return AsString is {@code 65}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when 'A'; then return AsString is '65'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenA_thenReturnAsStringIs65() {
    // Arrange and Act
    JsonElement actualGenericToBaseResult = Types.JSON.genericToBase((byte) 'A');

    // Assert
    assertTrue(actualGenericToBaseResult instanceof JsonPrimitive);
    assertEquals("65", actualGenericToBaseResult.getAsString());
    assertEquals('6', actualGenericToBaseResult.getAsCharacter());
    assertEquals(65, actualGenericToBaseResult.getAsInt());
    assertEquals(65.0d, actualGenericToBaseResult.getAsDouble());
    assertEquals(65.0f, actualGenericToBaseResult.getAsFloat());
    assertEquals(65L, actualGenericToBaseResult.getAsLong());
    assertEquals((short) 65, actualGenericToBaseResult.getAsShort());
    assertTrue(((JsonPrimitive) actualGenericToBaseResult).isNumber());
    assertEquals(new BigDecimal("65"), actualGenericToBaseResult.getAsBigDecimal());
    assertEquals('A', actualGenericToBaseResult.getAsByte());
    assertEquals('A', actualGenericToBaseResult.getAsNumber().byteValue());
    JsonPrimitive actualAsJsonPrimitive = actualGenericToBaseResult.getAsJsonPrimitive();
    assertSame(actualGenericToBaseResult, actualAsJsonPrimitive);
  }

  /**
   * Test {@link JsonTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then AsNumber return {@link LazilyParsedNumber}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when 'Input'; then AsNumber return LazilyParsedNumber")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenInput_thenAsNumberReturnLazilyParsedNumber() {
    // Arrange and Act
    JsonElement actualGenericToBaseResult = Types.JSON.genericToBase("Input");

    // Assert
    assertTrue(actualGenericToBaseResult instanceof JsonPrimitive);
    Number asNumber = actualGenericToBaseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Input", actualGenericToBaseResult.getAsString());
    assertEquals("Input", asNumber.toString());
    assertEquals('I', actualGenericToBaseResult.getAsCharacter());
    assertTrue(((JsonPrimitive) actualGenericToBaseResult).isString());
    JsonPrimitive actualAsJsonPrimitive = actualGenericToBaseResult.getAsJsonPrimitive();
    assertSame(actualGenericToBaseResult, actualAsJsonPrimitive);
  }

  /**
   * Test {@link JsonTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@link JsonListType#JsonListType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@link JsonArray}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName(
      "Test genericToBase(Object); when JsonListType(boolean) with compressed is 'true'; then return JsonArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenJsonListTypeWithCompressedIsTrue_thenReturnJsonArray() {
    // Arrange and Act
    JsonElement actualGenericToBaseResult = Types.JSON.genericToBase(new JsonListType(true));

    // Assert
    assertTrue(actualGenericToBaseResult instanceof JsonArray);
    assertEquals(0, ((JsonArray) actualGenericToBaseResult).size());
    assertFalse(((JsonArray) actualGenericToBaseResult).iterator().hasNext());
    assertTrue(((JsonArray) actualGenericToBaseResult).isEmpty());
    assertTrue(actualGenericToBaseResult.isJsonArray());
    JsonArray actualAsJsonArray = actualGenericToBaseResult.getAsJsonArray();
    assertSame(actualGenericToBaseResult, actualAsJsonArray);
  }

  /**
   * Test {@link JsonTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@link JsonObject}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName(
      "Test genericToBase(Object); when JsonMapType(boolean) with compressed is 'true'; then return JsonObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenJsonMapTypeWithCompressedIsTrue_thenReturnJsonObject() {
    // Arrange and Act
    JsonElement actualGenericToBaseResult = Types.JSON.genericToBase(new JsonMapType(true));

    // Assert
    assertTrue(actualGenericToBaseResult instanceof JsonObject);
    assertEquals(0, ((JsonObject) actualGenericToBaseResult).size());
    assertTrue(actualGenericToBaseResult.isJsonObject());
    assertTrue(((JsonObject) actualGenericToBaseResult).isEmpty());
    JsonObject actualAsJsonObject = actualGenericToBaseResult.getAsJsonObject();
    assertSame(actualGenericToBaseResult, actualAsJsonObject);
  }

  /**
   * Test {@link JsonTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link JsonNull#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when 'null'; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenNull_thenReturnInstance() {
    // Arrange and Act
    JsonElement actualGenericToBaseResult = Types.JSON.genericToBase(null);

    // Assert
    assertSame(((JsonNull) actualGenericToBaseResult).INSTANCE, actualGenericToBaseResult);
  }

  /**
   * Test {@link JsonTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return AsCharacter is {@code t}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when 'true'; then return AsCharacter is 't'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenTrue_thenReturnAsCharacterIsT() {
    // Arrange and Act
    JsonElement actualGenericToBaseResult = Types.JSON.genericToBase(true);

    // Assert
    assertTrue(actualGenericToBaseResult instanceof JsonPrimitive);
    assertEquals('t', actualGenericToBaseResult.getAsCharacter());
    assertTrue(actualGenericToBaseResult.getAsBoolean());
    assertTrue(((JsonPrimitive) actualGenericToBaseResult).isBoolean());
    assertEquals(Boolean.TRUE.toString(), actualGenericToBaseResult.getAsString());
    JsonPrimitive actualAsJsonPrimitive = actualGenericToBaseResult.getAsJsonPrimitive();
    assertSame(actualGenericToBaseResult, actualAsJsonPrimitive);
  }

  /**
   * Test {@link JsonTypeUtil#genericToBase(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTypeUtil#genericToBase(Object)}
   */
  @Test
  @DisplayName("Test genericToBase(Object); when WILDCARD_OBJECT; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonTypeUtil.genericToBase(Object)"})
  void testGenericToBase_whenWildcard_object_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> Types.JSON.genericToBase(ConfigurationTransformation.WILDCARD_OBJECT));
  }
}
