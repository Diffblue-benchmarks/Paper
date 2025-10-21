package ca.spottedleaf.dataconverter.minecraft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.converters.datatypes.DataType;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCDataType;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCTypeRegistry;
import ca.spottedleaf.dataconverter.types.TypeUtil;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.json.JsonTypeUtil;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MCDataConverterDiffblueTest {
  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code 0.5}.
   *   <li>When {@link CompoundTag#CompoundTag()} Double {@code CompoundTag} is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given '0.5'; when CompoundTag() Double 'net.minecraft.nbt.CompoundTag' is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_given05_whenCompoundTagDoubleNetMinecraftNbtCompoundTagIs05() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putDouble("net.minecraft.nbt.CompoundTag", 0.5d);
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code 0.8}.
   *   <li>When {@link CompoundTag#CompoundTag()} Float {@code CompoundTag} is {@code 0.8}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given '0.8'; when CompoundTag() Float 'net.minecraft.nbt.CompoundTag' is '0.8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_given08_whenCompoundTagFloatNetMinecraftNbtCompoundTagIs08() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putFloat("net.minecraft.nbt.CompoundTag", 0.8f);
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName("Test copy(Object); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenA() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putByteArray(
        "net.minecraft.nbt.CompoundTag", new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName("Test copy(Object); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenEmptyString() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("", new JsonArray(3));
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.addProperty("42", "Value");

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given empty string; when JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenEmptyString_whenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("", new JsonArray(3));
    jsonObject.add("42", new JsonArray(3));

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given empty string; when JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenEmptyString_whenJsonObjectAdd42AndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("", new JsonArray(3));
    jsonObject.add("42", new JsonArray(3));
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.add("", new JsonArray(3));
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.addProperty("42", "Value");

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@link CompoundTag}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given 'Key'; when CompoundTag() 'Key' is ONE; then return CompoundTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenKey_whenCompoundTagKeyIsOne_thenReturnCompoundTag() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link CompoundTag#CompoundTag()} Int {@code CompoundTag} is one.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given one; when CompoundTag() Int 'net.minecraft.nbt.CompoundTag' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenOne_whenCompoundTagIntNetMinecraftNbtCompoundTagIsOne() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putInt("net.minecraft.nbt.CompoundTag", 1);
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link CompoundTag#CompoundTag()} Long {@code CompoundTag} is one.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given one; when CompoundTag() Long 'net.minecraft.nbt.CompoundTag' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenOne_whenCompoundTagLongNetMinecraftNbtCompoundTagIsOne() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putLong("net.minecraft.nbt.CompoundTag", 1L);
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>When {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given 'Property'; when JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenProperty_whenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("42", new JsonArray(3));
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.add("", new JsonArray(3));
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.addProperty("42", "Value");

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>When {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given 'Property'; when JsonObject (default constructor) add 'Property' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenProperty_whenJsonObjectAddPropertyAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.addProperty("42", "Value");

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>When {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given 'Property'; when JsonObject (default constructor) add 'Property' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenProperty_whenJsonObjectAddPropertyAndJsonArrayWithCapacityIsThree2() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.add("", new JsonArray(3));
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.addProperty("42", "Value");

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>When {@link CompoundTag#CompoundTag()} String {@code CompoundTag} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given 'Value'; when CompoundTag() String 'net.minecraft.nbt.CompoundTag' is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenValue_whenCompoundTagStringNetMinecraftNbtCompoundTagIsValue() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putString("net.minecraft.nbt.CompoundTag", "Value");
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code 42} and {@code Value}.
   *   <li>Then return {@link JsonObject}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given 'Value'; when JsonObject (default constructor) addProperty '42' and 'Value'; then return JsonObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenValue_whenJsonObjectAddProperty42AndValue_thenReturnJsonObject() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("42", "Value");

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@link CompoundTag}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given zero; when CompoundTag() '42' is ONE; then return CompoundTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenZero_whenCompoundTag42IsOne_thenReturnCompoundTag() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.put("42", ByteTag.ONE);
    compoundTag.putShort("net.minecraft.nbt.CompoundTag", (short) 0);
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link CompoundTag#CompoundTag()} Short {@code CompoundTag} is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); given zero; when CompoundTag() Short 'net.minecraft.nbt.CompoundTag' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_givenZero_whenCompoundTagShortNetMinecraftNbtCompoundTagIsZero() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();
    compoundTag.putShort("net.minecraft.nbt.CompoundTag", (short) 0);
    compoundTag.put("Key", ByteTag.ONE);

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()}.
   *   <li>Then return {@link CompoundTag}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName("Test copy(Object); when CompoundTag(); then return CompoundTag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_whenCompoundTag_thenReturnCompoundTag() {
    // Arrange
    CompoundTag compoundTag = new CompoundTag();

    // Act
    Object actualCopyResult = MCDataConverter.copy(compoundTag);

    // Assert
    assertTrue(actualCopyResult instanceof CompoundTag);
    assertEquals(compoundTag, actualCopyResult);
    assertSame(((CompoundTag) actualCopyResult).TYPE, compoundTag.getType());
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName(
      "Test copy(Object); when JsonObject (default constructor) add '42' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_whenJsonObjectAdd42AndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("42", new JsonArray(3));

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#copy(Object)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return {@link JsonObject}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#copy(Object)}
   */
  @Test
  @DisplayName("Test copy(Object); when JsonObject (default constructor); then return JsonObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.copy(Object)"})
  void testCopy_whenJsonObject_thenReturnJsonObject() {
    // Arrange
    JsonObject jsonObject = new JsonObject();

    // Act
    Object actualCopyResult = MCDataConverter.copy(jsonObject);

    // Assert
    assertTrue(actualCopyResult instanceof JsonObject);
    assertEquals(jsonObject, actualCopyResult);
  }

  /**
   * Test {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link CompoundTag#CompoundTag()} String {@code id} is {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}
   */
  @Test
  @DisplayName(
      "Test convertTag(MCDataType, CompoundTag, int, int); given '42'; when CompoundTag() String 'id' is '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompoundTag MCDataConverter.convertTag(MCDataType, CompoundTag, int, int)"})
  void testConvertTag_given42_whenCompoundTagStringIdIs42_thenReturnSizeIsOne() {
    // Arrange
    CompoundTag data = new CompoundTag();
    data.putString("id", "42");

    // Act
    CompoundTag actualConvertTagResult =
        MCDataConverter.convertTag(MCTypeRegistry.ENTITY, data, 1, 1);

    // Assert
    assertEquals(1, actualConvertTagResult.size());
    assertFalse(actualConvertTagResult.isEmpty());
    assertEquals('\n', actualConvertTagResult.getId());
    assertSame(CompoundTag.TYPE, actualConvertTagResult.getType());
  }

  /**
   * Test {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>Given {@link ByteTag#ONE}.
   *   <li>When {@link CompoundTag#CompoundTag()} {@code id} is {@link ByteTag#ONE}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}
   */
  @Test
  @DisplayName(
      "Test convertTag(MCDataType, CompoundTag, int, int); given ONE; when CompoundTag() 'id' is ONE; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompoundTag MCDataConverter.convertTag(MCDataType, CompoundTag, int, int)"})
  void testConvertTag_givenOne_whenCompoundTagIdIsOne_thenReturnSizeIsOne() {
    // Arrange
    CompoundTag data = new CompoundTag();
    data.put("id", ByteTag.ONE);

    // Act
    CompoundTag actualConvertTagResult =
        MCDataConverter.convertTag(MCTypeRegistry.ENTITY, data, 1, 1);

    // Assert
    assertEquals(1, actualConvertTagResult.size());
    assertFalse(actualConvertTagResult.isEmpty());
    assertEquals('\n', actualConvertTagResult.getId());
    assertSame(CompoundTag.TYPE, actualConvertTagResult.getType());
  }

  /**
   * Test {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ADVANCEMENTS}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}
   */
  @Test
  @DisplayName(
      "Test convertTag(MCDataType, CompoundTag, int, int); when ADVANCEMENTS; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompoundTag MCDataConverter.convertTag(MCDataType, CompoundTag, int, int)"})
  void testConvertTag_whenAdvancements_thenReturnSizeIsZero() {
    // Arrange and Act
    CompoundTag actualConvertTagResult =
        MCDataConverter.convertTag(MCTypeRegistry.ADVANCEMENTS, new CompoundTag(), 1, 1);

    // Assert
    assertEquals(0, actualConvertTagResult.size());
    assertTrue(actualConvertTagResult.isEmpty());
    assertEquals('\n', actualConvertTagResult.getId());
    assertSame(CompoundTag.TYPE, actualConvertTagResult.getType());
  }

  /**
   * Test {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY_CHUNK}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}
   */
  @Test
  @DisplayName(
      "Test convertTag(MCDataType, CompoundTag, int, int); when ENTITY_CHUNK; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompoundTag MCDataConverter.convertTag(MCDataType, CompoundTag, int, int)"})
  void testConvertTag_whenEntity_chunk_thenReturnSizeIsZero() {
    // Arrange and Act
    CompoundTag actualConvertTagResult =
        MCDataConverter.convertTag(MCTypeRegistry.ENTITY_CHUNK, new CompoundTag(), 1, 1);

    // Assert
    assertEquals(0, actualConvertTagResult.size());
    assertTrue(actualConvertTagResult.isEmpty());
    assertEquals('\n', actualConvertTagResult.getId());
    assertSame(CompoundTag.TYPE, actualConvertTagResult.getType());
  }

  /**
   * Test {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertTag(MCDataType, CompoundTag, int, int)}
   */
  @Test
  @DisplayName(
      "Test convertTag(MCDataType, CompoundTag, int, int); when ENTITY; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompoundTag MCDataConverter.convertTag(MCDataType, CompoundTag, int, int)"})
  void testConvertTag_whenEntity_thenReturnSizeIsZero() {
    // Arrange and Act
    CompoundTag actualConvertTagResult =
        MCDataConverter.convertTag(MCTypeRegistry.ENTITY, new CompoundTag(), 1, 1);

    // Assert
    assertEquals(0, actualConvertTagResult.size());
    assertTrue(actualConvertTagResult.isEmpty());
    assertEquals('\n', actualConvertTagResult.getId());
    assertSame(CompoundTag.TYPE, actualConvertTagResult.getType());
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code id} and {@code 42}.
   *   <li>Then return not Empty.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); given '42'; when JsonObject (default constructor) addProperty 'id' and '42'; then return not Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_given42_whenJsonObjectAddPropertyIdAnd42_thenReturnNotEmpty() {
    // Arrange
    JsonObject data = new JsonObject();
    data.addProperty("id", "42");

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY, data, true, 1, 1);

    // Assert
    assertEquals(1, data.size());
    assertEquals(1, actualConvertJsonResult.size());
    assertFalse(data.isEmpty());
    assertFalse(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>Given {@link Bootstrap#bootstrapDuration}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); given bootstrapDuration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_givenBootstrapDuration() {
    // Arrange
    JsonObject data = new JsonObject();
    data.addProperty("id", Bootstrap.bootstrapDuration);

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY, data, true, 1, 1);

    // Assert
    assertEquals(1, data.size());
    assertEquals(1, actualConvertJsonResult.size());
    assertFalse(data.isEmpty());
    assertFalse(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName("Test convertJson(MCDataType, JsonObject, boolean, int, int); given 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_givenProperty() {
    // Arrange
    JsonObject data = new JsonObject();
    data.add("Property", new JsonArray(3));

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY, data, true, 1, 1);

    // Assert
    assertEquals(1, data.size());
    assertEquals(1, actualConvertJsonResult.size());
    assertFalse(data.isEmpty());
    assertFalse(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>Then {@link JsonObject} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); given 'Property'; then JsonObject (default constructor) size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_givenProperty_thenJsonObjectSizeIsTwo() {
    // Arrange
    JsonObject data = new JsonObject();
    data.add("Property", new JsonArray(3));
    data.add("id", new JsonArray(3));

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY, data, true, 1, 1);

    // Assert
    assertEquals(2, data.size());
    assertEquals(2, actualConvertJsonResult.size());
    assertFalse(data.isEmpty());
    assertFalse(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ADVANCEMENTS}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ADVANCEMENTS; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenAdvancements_thenJsonObjectSizeIsZero() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ADVANCEMENTS, data, true, 1, 1);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ADVANCEMENTS}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ADVANCEMENTS; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenAdvancements_thenJsonObjectSizeIsZero2() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ADVANCEMENTS, data, true, Integer.MAX_VALUE, 1);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ADVANCEMENTS}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ADVANCEMENTS; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenAdvancements_thenJsonObjectSizeIsZero3() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ADVANCEMENTS, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#BLOCK_STATE}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when BLOCK_STATE; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenBlock_state_thenJsonObjectSizeIsZero() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.BLOCK_STATE, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#DATA_COMPONENTS}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when DATA_COMPONENTS; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenData_components_thenJsonObjectSizeIsZero() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(
            MCTypeRegistry.DATA_COMPONENTS, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY_CHUNK}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ENTITY_CHUNK; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenEntity_chunk_thenJsonObjectSizeIsZero() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY_CHUNK, data, true, 1, 1);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY_CHUNK}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ENTITY_CHUNK; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenEntity_chunk_thenJsonObjectSizeIsZero2() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY_CHUNK, data, true, Integer.MAX_VALUE, 1);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY_CHUNK}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ENTITY_CHUNK; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenEntity_chunk_thenJsonObjectSizeIsZero3() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY_CHUNK, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ENTITY; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenEntity_thenJsonObjectSizeIsZero() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY, data, true, 1, 1);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY}.
   *   <li>Then {@link JsonObject} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ENTITY; then JsonObject (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenEntity_thenJsonObjectSizeIsZero2() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(0, data.size());
    assertEquals(0, actualConvertJsonResult.size());
    assertTrue(data.isEmpty());
    assertTrue(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ITEM_STACK}.
   *   <li>Then return {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when ITEM_STACK; then return JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenItem_stack_thenReturnJsonObject() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ITEM_STACK, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(data, actualConvertJsonResult);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add {@code id} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when JsonObject (default constructor) add 'id' and JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenJsonObjectAddIdAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject data = new JsonObject();
    data.add("id", new JsonArray(3));

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.ENTITY, data, true, 1, 1);

    // Assert
    assertEquals(1, data.size());
    assertEquals(1, actualConvertJsonResult.size());
    assertFalse(data.isEmpty());
    assertFalse(actualConvertJsonResult.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#LEVEL}.
   *   <li>Then {@link JsonObject} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when LEVEL; then JsonObject (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenLevel_thenJsonObjectSizeIsOne() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.LEVEL, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(1, data.size());
    assertEquals(1, actualConvertJsonResult.size());
    assertFalse(data.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#OBJECTIVE}.
   *   <li>Then {@link JsonObject} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when OBJECTIVE; then JsonObject (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenObjective_thenJsonObjectSizeIsOne() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.OBJECTIVE, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(1, data.size());
    assertEquals(1, actualConvertJsonResult.size());
    assertFalse(data.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#OPTIONS}.
   *   <li>Then {@link JsonObject} (default constructor) size is three.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertJson(MCDataType, JsonObject, boolean, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertJson(MCDataType, JsonObject, boolean, int, int); when OPTIONS; then JsonObject (default constructor) size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonObject MCDataConverter.convertJson(MCDataType, JsonObject, boolean, int, int)"
  })
  void testConvertJson_whenOptions_thenJsonObjectSizeIsThree() {
    // Arrange
    JsonObject data = new JsonObject();

    // Act
    JsonObject actualConvertJsonResult =
        MCDataConverter.convertJson(MCTypeRegistry.OPTIONS, data, true, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(3, data.size());
    assertEquals(3, actualConvertJsonResult.size());
    assertFalse(data.isEmpty());
    JsonObject actualAsJsonObject = actualConvertJsonResult.getAsJsonObject();
    assertSame(actualConvertJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link MCDataConverter#convert(DataType, Object, int, int)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convert(DataType, Object, int, int)}
   */
  @Test
  @DisplayName("Test convert(DataType, Object, int, int); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convert(DataType, Object, int, int)"})
  void testConvert_when42_thenReturn42() {
    // Arrange and Act
    Object actualConvertResult =
        MCDataConverter.convert(MCTypeRegistry.TEXT_COMPONENT, "42", 1, Integer.MAX_VALUE);

    // Assert
    assertEquals("42", actualConvertResult);
  }

  /**
   * Test {@link MCDataConverter#convert(DataType, Object, int, int)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code minecraft:42}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convert(DataType, Object, int, int)}
   */
  @Test
  @DisplayName("Test convert(DataType, Object, int, int); when '42'; then return 'minecraft:42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convert(DataType, Object, int, int)"})
  void testConvert_when42_thenReturnMinecraft42() {
    // Arrange and Act
    Object actualConvertResult =
        MCDataConverter.convert(MCTypeRegistry.BIOME, "42", 1, Integer.MAX_VALUE);

    // Assert
    assertEquals("minecraft:42", actualConvertResult);
  }

  /**
   * Test {@link MCDataConverter#convert(DataType, Object, int, int)}.
   *
   * <ul>
   *   <li>When {@code Data}.
   *   <li>Then return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convert(DataType, Object, int, int)}
   */
  @Test
  @DisplayName("Test convert(DataType, Object, int, int); when 'Data'; then return 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convert(DataType, Object, int, int)"})
  void testConvert_whenData_thenReturnData() {
    // Arrange and Act
    Object actualConvertResult =
        MCDataConverter.convert(MCTypeRegistry.TEXT_COMPONENT, "Data", 1, Integer.MAX_VALUE);

    // Assert
    assertEquals("Data", actualConvertResult);
  }

  /**
   * Test {@link MCDataConverter#convert(DataType, Object, int, int)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convert(DataType, Object, int, int)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, Object, int, int); when JsonMapType(boolean) with compressed is 'true'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convert(DataType, Object, int, int)"})
  void testConvert_whenJsonMapTypeWithCompressedIsTrue_thenReturnJsonMapType() {
    // Arrange and Act
    Object actualConvertResult =
        MCDataConverter.convert(
            MCTypeRegistry.PARTICLE, new JsonMapType(true), 1, Integer.MAX_VALUE);

    // Assert
    assertTrue(actualConvertResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil = ((JsonMapType) actualConvertResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, ((JsonMapType) actualConvertResult).size());
    JsonObject json = ((JsonMapType) actualConvertResult).getJson();
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
   * Test {@link MCDataConverter#convert(DataType, Object, int, int)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#PARTICLE}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convert(DataType, Object, int, int)}
   */
  @Test
  @DisplayName("Test convert(DataType, Object, int, int); when PARTICLE; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convert(DataType, Object, int, int)"})
  void testConvert_whenParticle_thenReturnNBTMapType() {
    // Arrange and Act
    Object actualConvertResult =
        MCDataConverter.convert(MCTypeRegistry.PARTICLE, "42", 1, Integer.MAX_VALUE);

    // Assert
    assertTrue(actualConvertResult instanceof NBTMapType);
    assertTrue(((NBTMapType) actualConvertResult).getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, ((NBTMapType) actualConvertResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(((NBTMapType) actualConvertResult).isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link MCDataConverter#convertWithSubVersion(DataType, Object, long, long)}.
   *
   * <ul>
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertWithSubVersion(DataType, Object, long,
   * long)}
   */
  @Test
  @DisplayName("Test convertWithSubVersion(DataType, Object, long, long); then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convertWithSubVersion(DataType, Object, long, long)"})
  void testConvertWithSubVersion_thenReturnJsonMapType() {
    // Arrange and Act
    Object actualConvertWithSubVersionResult =
        MCDataConverter.convertWithSubVersion(
            MCTypeRegistry.PARTICLE, new JsonMapType(true), 1L, Long.MAX_VALUE);

    // Assert
    assertTrue(actualConvertWithSubVersionResult instanceof JsonMapType);
    TypeUtil<JsonElement> typeUtil =
        ((JsonMapType) actualConvertWithSubVersionResult).getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, ((JsonMapType) actualConvertWithSubVersionResult).size());
    JsonObject json = ((JsonMapType) actualConvertWithSubVersionResult).getJson();
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
   * Test {@link MCDataConverter#convertWithSubVersion(DataType, Object, long, long)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertWithSubVersion(DataType, Object, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test convertWithSubVersion(DataType, Object, long, long); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convertWithSubVersion(DataType, Object, long, long)"})
  void testConvertWithSubVersion_when42_thenReturn42() {
    // Arrange and Act
    Object actualConvertWithSubVersionResult =
        MCDataConverter.convertWithSubVersion(
            MCTypeRegistry.TEXT_COMPONENT, "42", 1L, Long.MAX_VALUE);

    // Assert
    assertEquals("42", actualConvertWithSubVersionResult);
  }

  /**
   * Test {@link MCDataConverter#convertWithSubVersion(DataType, Object, long, long)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code minecraft:42}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertWithSubVersion(DataType, Object, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test convertWithSubVersion(DataType, Object, long, long); when '42'; then return 'minecraft:42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convertWithSubVersion(DataType, Object, long, long)"})
  void testConvertWithSubVersion_when42_thenReturnMinecraft42() {
    // Arrange and Act
    Object actualConvertWithSubVersionResult =
        MCDataConverter.convertWithSubVersion(MCTypeRegistry.BIOME, "42", 1L, Long.MAX_VALUE);

    // Assert
    assertEquals("minecraft:42", actualConvertWithSubVersionResult);
  }

  /**
   * Test {@link MCDataConverter#convertWithSubVersion(DataType, Object, long, long)}.
   *
   * <ul>
   *   <li>When {@code Data}.
   *   <li>Then return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertWithSubVersion(DataType, Object, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test convertWithSubVersion(DataType, Object, long, long); when 'Data'; then return 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convertWithSubVersion(DataType, Object, long, long)"})
  void testConvertWithSubVersion_whenData_thenReturnData() {
    // Arrange and Act
    Object actualConvertWithSubVersionResult =
        MCDataConverter.convertWithSubVersion(
            MCTypeRegistry.TEXT_COMPONENT, "Data", 1L, Long.MAX_VALUE);

    // Assert
    assertEquals("Data", actualConvertWithSubVersionResult);
  }

  /**
   * Test {@link MCDataConverter#convertWithSubVersion(DataType, Object, long, long)}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#PARTICLE}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataConverter#convertWithSubVersion(DataType, Object, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test convertWithSubVersion(DataType, Object, long, long); when PARTICLE; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCDataConverter.convertWithSubVersion(DataType, Object, long, long)"})
  void testConvertWithSubVersion_whenParticle_thenReturnNBTMapType() {
    // Arrange and Act
    Object actualConvertWithSubVersionResult =
        MCDataConverter.convertWithSubVersion(MCTypeRegistry.PARTICLE, "42", 1L, Long.MAX_VALUE);

    // Assert
    assertTrue(actualConvertWithSubVersionResult instanceof NBTMapType);
    assertTrue(
        ((NBTMapType) actualConvertWithSubVersionResult).getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, ((NBTMapType) actualConvertWithSubVersionResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertWithSubVersionResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(((NBTMapType) actualConvertWithSubVersionResult).isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }
}
