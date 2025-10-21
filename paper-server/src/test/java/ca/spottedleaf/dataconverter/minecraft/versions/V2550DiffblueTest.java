package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class V2550DiffblueTest {
  /**
   * Test {@link V2550#noise(long, String, MapType)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#noise(long, String, MapType)}
   */
  @Test
  @DisplayName("Test noise(long, String, MapType); when empty string; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.noise(long, String, MapType)"})
  void testNoise_whenEmptyString_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualNoiseResult = V2550.noise(42L, "", new NBTMapType());

    // Assert
    assertTrue(actualNoiseResult instanceof NBTMapType);
    assertTrue(actualNoiseResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualNoiseResult.size());
    CompoundTag tag = ((NBTMapType) actualNoiseResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualNoiseResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#noise(long, String, MapType)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#noise(long, String, MapType)}
   */
  @Test
  @DisplayName("Test noise(long, String, MapType); when forty-two; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.noise(long, String, MapType)"})
  void testNoise_whenFortyTwo_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualNoiseResult = V2550.noise(42L, "World Type", new NBTMapType());

    // Assert
    assertTrue(actualNoiseResult instanceof NBTMapType);
    assertTrue(actualNoiseResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualNoiseResult.size());
    CompoundTag tag = ((NBTMapType) actualNoiseResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualNoiseResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#noise(long, String, MapType)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#noise(long, String, MapType)}
   */
  @Test
  @DisplayName("Test noise(long, String, MapType); when MAX_VALUE; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.noise(long, String, MapType)"})
  void testNoise_whenMax_value_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualNoiseResult = V2550.noise(Long.MAX_VALUE, "World Type", new NBTMapType());

    // Assert
    assertTrue(actualNoiseResult instanceof NBTMapType);
    assertTrue(actualNoiseResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualNoiseResult.size());
    CompoundTag tag = ((NBTMapType) actualNoiseResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualNoiseResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#noise(long, String, MapType)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#noise(long, String, MapType)}
   */
  @Test
  @DisplayName("Test noise(long, String, MapType); when MIN_VALUE; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.noise(long, String, MapType)"})
  void testNoise_whenMin_value_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualNoiseResult = V2550.noise(Long.MIN_VALUE, "World Type", new NBTMapType());

    // Assert
    assertTrue(actualNoiseResult instanceof NBTMapType);
    assertTrue(actualNoiseResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualNoiseResult.size());
    CompoundTag tag = ((NBTMapType) actualNoiseResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualNoiseResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaBiomeSource(long, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaBiomeSource(long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test vanillaBiomeSource(long, boolean, boolean); when 'false'; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaBiomeSource(long, boolean, boolean)"})
  void testVanillaBiomeSource_whenFalse_thenReturnSizeIsFour() {
    // Arrange and Act
    MapType actualVanillaBiomeSourceResult = V2550.vanillaBiomeSource(42L, true, false);

    // Assert
    assertTrue(actualVanillaBiomeSourceResult instanceof NBTMapType);
    assertTrue(actualVanillaBiomeSourceResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualVanillaBiomeSourceResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaBiomeSourceResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualVanillaBiomeSourceResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaBiomeSource(long, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaBiomeSource(long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test vanillaBiomeSource(long, boolean, boolean); when 'false'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaBiomeSource(long, boolean, boolean)"})
  void testVanillaBiomeSource_whenFalse_thenReturnSizeIsThree() {
    // Arrange and Act
    MapType actualVanillaBiomeSourceResult = V2550.vanillaBiomeSource(42L, false, true);

    // Assert
    assertTrue(actualVanillaBiomeSourceResult instanceof NBTMapType);
    assertTrue(actualVanillaBiomeSourceResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualVanillaBiomeSourceResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaBiomeSourceResult).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualVanillaBiomeSourceResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaBiomeSource(long, boolean, boolean)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaBiomeSource(long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test vanillaBiomeSource(long, boolean, boolean); when forty-two; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaBiomeSource(long, boolean, boolean)"})
  void testVanillaBiomeSource_whenFortyTwo_thenReturnSizeIsFour() {
    // Arrange and Act
    MapType actualVanillaBiomeSourceResult = V2550.vanillaBiomeSource(42L, true, true);

    // Assert
    assertTrue(actualVanillaBiomeSourceResult instanceof NBTMapType);
    assertTrue(actualVanillaBiomeSourceResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualVanillaBiomeSourceResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaBiomeSourceResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualVanillaBiomeSourceResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaBiomeSource(long, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaBiomeSource(long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test vanillaBiomeSource(long, boolean, boolean); when MAX_VALUE; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaBiomeSource(long, boolean, boolean)"})
  void testVanillaBiomeSource_whenMax_value_thenReturnSizeIsFour() {
    // Arrange and Act
    MapType actualVanillaBiomeSourceResult = V2550.vanillaBiomeSource(Long.MAX_VALUE, true, true);

    // Assert
    assertTrue(actualVanillaBiomeSourceResult instanceof NBTMapType);
    assertTrue(actualVanillaBiomeSourceResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualVanillaBiomeSourceResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaBiomeSourceResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualVanillaBiomeSourceResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaBiomeSource(long, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaBiomeSource(long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test vanillaBiomeSource(long, boolean, boolean); when MIN_VALUE; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaBiomeSource(long, boolean, boolean)"})
  void testVanillaBiomeSource_whenMin_value_thenReturnSizeIsFour() {
    // Arrange and Act
    MapType actualVanillaBiomeSourceResult = V2550.vanillaBiomeSource(Long.MIN_VALUE, true, true);

    // Assert
    assertTrue(actualVanillaBiomeSourceResult instanceof NBTMapType);
    assertTrue(actualVanillaBiomeSourceResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualVanillaBiomeSourceResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaBiomeSourceResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualVanillaBiomeSourceResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#fixFlatStructures(MapType)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link V2550#fixFlatStructures(MapType)}
   */
  @Test
  @DisplayName(
      "Test fixFlatStructures(MapType); when JsonMapType(boolean) with compressed is 'true'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.fixFlatStructures(MapType)"})
  void testFixFlatStructures_whenJsonMapTypeWithCompressedIsTrue_thenReturnSizeIsOne() {
    // Arrange and Act
    MapType actualFixFlatStructuresResult = V2550.fixFlatStructures(new JsonMapType(true));

    // Assert
    assertTrue(actualFixFlatStructuresResult instanceof NBTMapType);
    assertTrue(actualFixFlatStructuresResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, actualFixFlatStructuresResult.size());
    CompoundTag tag = ((NBTMapType) actualFixFlatStructuresResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(actualFixFlatStructuresResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#fixFlatStructures(MapType)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link V2550#fixFlatStructures(MapType)}
   */
  @Test
  @DisplayName("Test fixFlatStructures(MapType); when NBTMapType(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.fixFlatStructures(MapType)"})
  void testFixFlatStructures_whenNBTMapType_thenReturnSizeIsOne() {
    // Arrange and Act
    MapType actualFixFlatStructuresResult = V2550.fixFlatStructures(new NBTMapType());

    // Assert
    assertTrue(actualFixFlatStructuresResult instanceof NBTMapType);
    assertTrue(actualFixFlatStructuresResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, actualFixFlatStructuresResult.size());
    CompoundTag tag = ((NBTMapType) actualFixFlatStructuresResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(actualFixFlatStructuresResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#fixFlatStructures(MapType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link V2550#fixFlatStructures(MapType)}
   */
  @Test
  @DisplayName("Test fixFlatStructures(MapType); when 'null'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.fixFlatStructures(MapType)"})
  void testFixFlatStructures_whenNull_thenReturnSizeIsTwo() {
    // Arrange and Act
    MapType actualFixFlatStructuresResult = V2550.fixFlatStructures(null);

    // Assert
    assertTrue(actualFixFlatStructuresResult instanceof NBTMapType);
    assertTrue(actualFixFlatStructuresResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(2, actualFixFlatStructuresResult.size());
    CompoundTag tag = ((NBTMapType) actualFixFlatStructuresResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(actualFixFlatStructuresResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaLevels(long, MapType, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaLevels(long, MapType, boolean)}
   */
  @Test
  @DisplayName("Test vanillaLevels(long, MapType, boolean); when 'false'; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaLevels(long, MapType, boolean)"})
  void testVanillaLevels_whenFalse_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualVanillaLevelsResult = V2550.vanillaLevels(42L, new NBTMapType(), false);

    // Assert
    assertTrue(actualVanillaLevelsResult instanceof NBTMapType);
    assertTrue(actualVanillaLevelsResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualVanillaLevelsResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaLevelsResult).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualVanillaLevelsResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaLevels(long, MapType, boolean)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaLevels(long, MapType, boolean)}
   */
  @Test
  @DisplayName("Test vanillaLevels(long, MapType, boolean); when forty-two; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaLevels(long, MapType, boolean)"})
  void testVanillaLevels_whenFortyTwo_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualVanillaLevelsResult = V2550.vanillaLevels(42L, new NBTMapType(), true);

    // Assert
    assertTrue(actualVanillaLevelsResult instanceof NBTMapType);
    assertTrue(actualVanillaLevelsResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualVanillaLevelsResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaLevelsResult).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualVanillaLevelsResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaLevels(long, MapType, boolean)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaLevels(long, MapType, boolean)}
   */
  @Test
  @DisplayName("Test vanillaLevels(long, MapType, boolean); when MAX_VALUE; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaLevels(long, MapType, boolean)"})
  void testVanillaLevels_whenMax_value_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualVanillaLevelsResult = V2550.vanillaLevels(Long.MAX_VALUE, new NBTMapType(), true);

    // Assert
    assertTrue(actualVanillaLevelsResult instanceof NBTMapType);
    assertTrue(actualVanillaLevelsResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualVanillaLevelsResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaLevelsResult).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualVanillaLevelsResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#vanillaLevels(long, MapType, boolean)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#vanillaLevels(long, MapType, boolean)}
   */
  @Test
  @DisplayName("Test vanillaLevels(long, MapType, boolean); when MIN_VALUE; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.vanillaLevels(long, MapType, boolean)"})
  void testVanillaLevels_whenMin_value_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualVanillaLevelsResult = V2550.vanillaLevels(Long.MIN_VALUE, new NBTMapType(), true);

    // Assert
    assertTrue(actualVanillaLevelsResult instanceof NBTMapType);
    assertTrue(actualVanillaLevelsResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualVanillaLevelsResult.size());
    CompoundTag tag = ((NBTMapType) actualVanillaLevelsResult).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualVanillaLevelsResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#defaultOverworld(long)}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link V2550#defaultOverworld(long)}
   */
  @Test
  @DisplayName("Test defaultOverworld(long); when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.defaultOverworld(long)"})
  void testDefaultOverworld_whenFortyTwo() {
    // Arrange and Act
    MapType actualDefaultOverworldResult = V2550.defaultOverworld(42L);

    // Assert
    assertTrue(actualDefaultOverworldResult instanceof NBTMapType);
    assertTrue(actualDefaultOverworldResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualDefaultOverworldResult.size());
    CompoundTag tag = ((NBTMapType) actualDefaultOverworldResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualDefaultOverworldResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#defaultOverworld(long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#defaultOverworld(long)}
   */
  @Test
  @DisplayName("Test defaultOverworld(long); when MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.defaultOverworld(long)"})
  void testDefaultOverworld_whenMax_value() {
    // Arrange and Act
    MapType actualDefaultOverworldResult = V2550.defaultOverworld(Long.MAX_VALUE);

    // Assert
    assertTrue(actualDefaultOverworldResult instanceof NBTMapType);
    assertTrue(actualDefaultOverworldResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualDefaultOverworldResult.size());
    CompoundTag tag = ((NBTMapType) actualDefaultOverworldResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualDefaultOverworldResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2550#defaultOverworld(long)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link V2550#defaultOverworld(long)}
   */
  @Test
  @DisplayName("Test defaultOverworld(long); when MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2550.defaultOverworld(long)"})
  void testDefaultOverworld_whenMin_value() {
    // Arrange and Act
    MapType actualDefaultOverworldResult = V2550.defaultOverworld(Long.MIN_VALUE);

    // Assert
    assertTrue(actualDefaultOverworldResult instanceof NBTMapType);
    assertTrue(actualDefaultOverworldResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(4, actualDefaultOverworldResult.size());
    CompoundTag tag = ((NBTMapType) actualDefaultOverworldResult).getTag();
    assertEquals(4, tag.size());
    assertFalse(actualDefaultOverworldResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }
}
