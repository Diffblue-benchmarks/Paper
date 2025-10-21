package ca.spottedleaf.dataconverter.minecraft.converters.itemstack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.TypeUtil;
import ca.spottedleaf.dataconverter.types.Types;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.json.JsonTypeUtil;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ConverterItemStackToDataComponentsDiffblueTest {
  /**
   * Test {@link ConverterItemStackToDataComponents#convertBlockStatePredicate(String, TypeUtil)}.
   *
   * <ul>
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConverterItemStackToDataComponents#convertBlockStatePredicate(String, TypeUtil)}
   */
  @Test
  @DisplayName("Test convertBlockStatePredicate(String, TypeUtil); then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MapType ConverterItemStackToDataComponents.convertBlockStatePredicate(String, TypeUtil)"
  })
  void testConvertBlockStatePredicate_thenReturnJsonMapType() {
    // Arrange and Act
    MapType actualConvertBlockStatePredicateResult =
        ConverterItemStackToDataComponents.convertBlockStatePredicate("42", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertBlockStatePredicateResult instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualConvertBlockStatePredicateResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, actualConvertBlockStatePredicateResult.size());
    JsonObject json = ((JsonMapType) actualConvertBlockStatePredicateResult).getJson();
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
   * Test {@link ConverterItemStackToDataComponents#convertBlockStatePredicate(String, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link Types#NBT}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConverterItemStackToDataComponents#convertBlockStatePredicate(String, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertBlockStatePredicate(String, TypeUtil); when NBT; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MapType ConverterItemStackToDataComponents.convertBlockStatePredicate(String, TypeUtil)"
  })
  void testConvertBlockStatePredicate_whenNbt_thenReturnNBTMapType() {
    // Arrange
    NBTTypeUtil type = Types.NBT;

    // Act
    MapType actualConvertBlockStatePredicateResult =
        ConverterItemStackToDataComponents.convertBlockStatePredicate("42", type);

    // Assert
    assertTrue(actualConvertBlockStatePredicateResult instanceof NBTMapType);
    TypeUtil<?> typeUtil = actualConvertBlockStatePredicateResult.getTypeUtil();
    assertTrue(typeUtil instanceof NBTTypeUtil);
    assertEquals(1, actualConvertBlockStatePredicateResult.size());
    CompoundTag tag = ((NBTMapType) actualConvertBlockStatePredicateResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(actualConvertBlockStatePredicateResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
    assertSame(type, typeUtil);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertProfile(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code Input Generic}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertProfile(Object,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertProfile(Object, TypeUtil); when 'Input Generic'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertProfile(Object, TypeUtil)"})
  void testConvertProfile_whenInputGeneric_thenReturnSizeIsZero() {
    // Arrange and Act
    MapType actualConvertProfileResult =
        ConverterItemStackToDataComponents.convertProfile("Input Generic", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertProfileResult instanceof JsonMapType);
    assertEquals(0, actualConvertProfileResult.size());
    JsonObject json = ((JsonMapType) actualConvertProfileResult).getJson();
    assertEquals(0, json.size());
    assertTrue(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertProfile(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return Json size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertProfile(Object,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertProfile(Object, TypeUtil); when JsonMapType(boolean) with compressed is 'true'; then return Json size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertProfile(Object, TypeUtil)"})
  void testConvertProfile_whenJsonMapTypeWithCompressedIsTrue_thenReturnJsonSizeIsOne() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    MapType actualConvertProfileResult =
        ConverterItemStackToDataComponents.convertProfile(jsonMapType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertProfileResult instanceof JsonMapType);
    assertEquals(1, actualConvertProfileResult.size());
    JsonObject json = ((JsonMapType) actualConvertProfileResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertProfile(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return Json size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertProfile(Object,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertProfile(Object, TypeUtil); when NBTMapType(); then return Json size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertProfile(Object, TypeUtil)"})
  void testConvertProfile_whenNBTMapType_thenReturnJsonSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    MapType actualConvertProfileResult =
        ConverterItemStackToDataComponents.convertProfile(nbtMapType, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertProfileResult instanceof JsonMapType);
    assertEquals(1, actualConvertProfileResult.size());
    JsonObject json = ((JsonMapType) actualConvertProfileResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertProfile(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link NBTTypeUtil} (default constructor).
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertProfile(Object,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertProfile(Object, TypeUtil); when NBTTypeUtil (default constructor); then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertProfile(Object, TypeUtil)"})
  void testConvertProfile_whenNBTTypeUtil_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualConvertProfileResult =
        ConverterItemStackToDataComponents.convertProfile(
            ConfigurationTransformation.WILDCARD_OBJECT, new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertProfileResult instanceof NBTMapType);
    assertTrue(actualConvertProfileResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, actualConvertProfileResult.size());
    CompoundTag tag = ((NBTMapType) actualConvertProfileResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(actualConvertProfileResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertProfile(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code name}.
   *   <li>Then return Json size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertProfile(Object,
   * TypeUtil)}
   */
  @Test
  @DisplayName("Test convertProfile(Object, TypeUtil); when 'name'; then return Json size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertProfile(Object, TypeUtil)"})
  void testConvertProfile_whenName_thenReturnJsonSizeIsOne() {
    // Arrange and Act
    MapType actualConvertProfileResult =
        ConverterItemStackToDataComponents.convertProfile("name", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertProfileResult instanceof JsonMapType);
    assertEquals(1, actualConvertProfileResult.size());
    JsonObject json = ((JsonMapType) actualConvertProfileResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertProfile(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code name}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertProfile(Object,
   * TypeUtil)}
   */
  @Test
  @DisplayName("Test convertProfile(Object, TypeUtil); when 'name'; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertProfile(Object, TypeUtil)"})
  void testConvertProfile_whenName_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualConvertProfileResult =
        ConverterItemStackToDataComponents.convertProfile("name", new NBTTypeUtil());

    // Assert
    assertTrue(actualConvertProfileResult instanceof NBTMapType);
    assertTrue(actualConvertProfileResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, actualConvertProfileResult.size());
    CompoundTag tag = ((NBTMapType) actualConvertProfileResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(actualConvertProfileResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertProfile(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return Json size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertProfile(Object,
   * TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertProfile(Object, TypeUtil); when WILDCARD_OBJECT; then return Json size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertProfile(Object, TypeUtil)"})
  void testConvertProfile_whenWildcard_object_thenReturnJsonSizeIsOne() {
    // Arrange and Act
    MapType actualConvertProfileResult =
        ConverterItemStackToDataComponents.convertProfile(
            ConfigurationTransformation.WILDCARD_OBJECT, new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertProfileResult instanceof JsonMapType);
    assertEquals(1, actualConvertProfileResult.size());
    JsonObject json = ((JsonMapType) actualConvertProfileResult).getJson();
    assertEquals(1, json.size());
    assertFalse(json.isEmpty());
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertItem(MapType)}.
   *
   * <ul>
   *   <li>Given {@code id}.
   *   <li>When {@link JsonObject} (default constructor) add {@code id} and {@link
   *       JsonPrimitive#JsonPrimitive(String)} with string is {@code id}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertItem(MapType)}
   */
  @Test
  @DisplayName(
      "Test convertItem(MapType); given 'id'; when JsonObject (default constructor) add 'id' and JsonPrimitive(String) with string is 'id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertItem(MapType)"})
  void testConvertItem_givenId_whenJsonObjectAddIdAndJsonPrimitiveWithStringIsId() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("id", new JsonPrimitive("id"));
    JsonMapType input = new JsonMapType(map, true);

    // Act
    MapType actualConvertItemResult = ConverterItemStackToDataComponents.convertItem(input);

    // Assert
    assertTrue(actualConvertItemResult instanceof JsonMapType);
    assertEquals(input, actualConvertItemResult);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertItem(MapType)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertItem(MapType)}
   */
  @Test
  @DisplayName("Test convertItem(MapType); given JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertItem(MapType)"})
  void testConvertItem_givenJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray(3));
    JsonMapType input = new JsonMapType(map, true);

    // Act
    MapType actualConvertItemResult = ConverterItemStackToDataComponents.convertItem(input);

    // Assert
    assertTrue(actualConvertItemResult instanceof JsonMapType);
    assertEquals(input, actualConvertItemResult);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertItem(MapType)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   *   <li>When {@link JsonObject} (default constructor) add {@code Property} and {@link JsonObject}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertItem(MapType)}
   */
  @Test
  @DisplayName(
      "Test convertItem(MapType); given JsonObject (default constructor); when JsonObject (default constructor) add 'Property' and JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertItem(MapType)"})
  void testConvertItem_givenJsonObject_whenJsonObjectAddPropertyAndJsonObject() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonObject());
    JsonMapType input = new JsonMapType(map, true);

    // Act
    MapType actualConvertItemResult = ConverterItemStackToDataComponents.convertItem(input);

    // Assert
    assertTrue(actualConvertItemResult instanceof JsonMapType);
    assertEquals(input, actualConvertItemResult);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertItem(MapType)}.
   *
   * <ul>
   *   <li>Then return {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertItem(MapType)}
   */
  @Test
  @DisplayName(
      "Test convertItem(MapType); then return JsonMapType(boolean) with compressed is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertItem(MapType)"})
  void testConvertItem_thenReturnJsonMapTypeWithCompressedIsTrue() {
    // Arrange
    JsonMapType input = new JsonMapType(true);

    // Act
    MapType actualConvertItemResult = ConverterItemStackToDataComponents.convertItem(input);

    // Assert
    assertTrue(actualConvertItemResult instanceof JsonMapType);
    assertEquals(input, actualConvertItemResult);
  }

  /**
   * Test {@link ConverterItemStackToDataComponents#convertItem(MapType)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterItemStackToDataComponents#convertItem(MapType)}
   */
  @Test
  @DisplayName("Test convertItem(MapType); when NBTMapType(); then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterItemStackToDataComponents.convertItem(MapType)"})
  void testConvertItem_whenNBTMapType_thenReturnNBTMapType() {
    // Arrange
    NBTMapType input = new NBTMapType();

    // Act
    MapType actualConvertItemResult = ConverterItemStackToDataComponents.convertItem(input);

    // Assert
    assertTrue(actualConvertItemResult instanceof NBTMapType);
    assertEquals(input, actualConvertItemResult);
  }
}
