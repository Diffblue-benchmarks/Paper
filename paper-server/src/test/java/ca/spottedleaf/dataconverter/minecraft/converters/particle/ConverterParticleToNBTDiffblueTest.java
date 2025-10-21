package ca.spottedleaf.dataconverter.minecraft.converters.particle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.TypeUtil;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.json.JsonTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterParticleToNBTDiffblueTest {
  /**
   * Test {@link ConverterParticleToNBT#convert(String, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterParticleToNBT#convert(String, TypeUtil)}
   */
  @Test
  @DisplayName("Test convert(String, TypeUtil); when '42'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterParticleToNBT.convert(String, TypeUtil)"})
  void testConvert_when42_thenReturnJsonMapType() {
    // Arrange and Act
    MapType actualConvertResult = ConverterParticleToNBT.convert("42", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertResult instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualConvertResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, actualConvertResult.size());
    JsonObject json = ((JsonMapType) actualConvertResult).getJson();
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
   * Test {@link ConverterParticleToNBT#convert(String, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code Flat}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterParticleToNBT#convert(String, TypeUtil)}
   */
  @Test
  @DisplayName("Test convert(String, TypeUtil); when 'Flat'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterParticleToNBT.convert(String, TypeUtil)"})
  void testConvert_whenFlat_thenReturnJsonMapType() {
    // Arrange and Act
    MapType actualConvertResult = ConverterParticleToNBT.convert("Flat", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertResult instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualConvertResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, actualConvertResult.size());
    JsonObject json = ((JsonMapType) actualConvertResult).getJson();
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
   * Test {@link ConverterParticleToNBT#convert(String, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code minecraft:block_marker}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterParticleToNBT#convert(String, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convert(String, TypeUtil); when 'minecraft:block_marker'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterParticleToNBT.convert(String, TypeUtil)"})
  void testConvert_whenMinecraftBlockMarker_thenReturnJsonMapType() {
    // Arrange and Act
    MapType actualConvertResult =
        ConverterParticleToNBT.convert("minecraft:block_marker", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertResult instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualConvertResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, actualConvertResult.size());
    JsonObject json = ((JsonMapType) actualConvertResult).getJson();
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
   * Test {@link ConverterParticleToNBT#convert(String, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code minecraft:block}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterParticleToNBT#convert(String, TypeUtil)}
   */
  @Test
  @DisplayName("Test convert(String, TypeUtil); when 'minecraft:block'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterParticleToNBT.convert(String, TypeUtil)"})
  void testConvert_whenMinecraftBlock_thenReturnJsonMapType() {
    // Arrange and Act
    MapType actualConvertResult =
        ConverterParticleToNBT.convert("minecraft:block", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertResult instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualConvertResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, actualConvertResult.size());
    JsonObject json = ((JsonMapType) actualConvertResult).getJson();
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
   * Test {@link ConverterParticleToNBT#convert(String, TypeUtil)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterParticleToNBT#convert(String, TypeUtil)}
   */
  @Test
  @DisplayName("Test convert(String, TypeUtil); when space; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterParticleToNBT.convert(String, TypeUtil)"})
  void testConvert_whenSpace_thenReturnJsonMapType() {
    // Arrange and Act
    MapType actualConvertResult = ConverterParticleToNBT.convert(" ", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertResult instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualConvertResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, actualConvertResult.size());
    JsonObject json = ((JsonMapType) actualConvertResult).getJson();
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
   * Test {@link ConverterParticleToNBT#convert(String, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@code type}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterParticleToNBT#convert(String, TypeUtil)}
   */
  @Test
  @DisplayName("Test convert(String, TypeUtil); when 'type'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterParticleToNBT.convert(String, TypeUtil)"})
  void testConvert_whenType_thenReturnJsonMapType() {
    // Arrange and Act
    MapType actualConvertResult = ConverterParticleToNBT.convert("type", new JsonTypeUtil(true));

    // Assert
    assertTrue(actualConvertResult instanceof JsonMapType);
    TypeUtil<?> typeUtil = actualConvertResult.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(1, actualConvertResult.size());
    JsonObject json = ((JsonMapType) actualConvertResult).getJson();
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
}
