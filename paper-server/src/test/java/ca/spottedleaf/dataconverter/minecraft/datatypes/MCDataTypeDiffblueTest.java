package ca.spottedleaf.dataconverter.minecraft.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.converters.DataConverter;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MCDataTypeDiffblueTest {
  /**
   * Test {@link MCDataType#MCDataType(String)}.
   *
   * <p>Method under test: {@link MCDataType#MCDataType(String)}
   */
  @Test
  @DisplayName("Test new MCDataType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MCDataType.<init>(String)"})
  void testNewMCDataType() {
    // Arrange and Act
    MCDataType actualMcDataType = new MCDataType("Name");

    // Assert
    assertEquals("Name", actualMcDataType.name);
    assertTrue(actualMcDataType.structureConverters.isEmpty());
  }

  /**
   * Test {@link MCDataType#addStructureConverter(DataConverter)}.
   *
   * <ul>
   *   <li>Then {@link MCDataType#MCDataType(String)} with {@code Name} {@link
   *       MCDataType#structureConverters} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MCDataType#addStructureConverter(DataConverter)}
   */
  @Test
  @DisplayName(
      "Test addStructureConverter(DataConverter); then MCDataType(String) with 'Name' structureConverters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MCDataType.addStructureConverter(DataConverter)"})
  void testAddStructureConverter_thenMCDataTypeWithNameStructureConvertersSizeIsOne() {
    // Arrange
    MCDataType mcDataType = new MCDataType("Name");
    ConverterFlattenChunk converter = new ConverterFlattenChunk();

    // Act
    mcDataType.addStructureConverter(converter);

    // Assert
    ArrayList<DataConverter<MapType, MapType>> dataConverterList = mcDataType.structureConverters;
    assertEquals(1, dataConverterList.size());
    assertSame(converter, dataConverterList.get(0));
  }

  /**
   * Test {@link MCDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#ADVANCEMENTS}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given ADVANCEMENTS; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType MCDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenAdvancements_thenReturnNull() {
    // Arrange
    NBTMapType data = new NBTMapType();

    // Act and Assert
    assertNull(MCTypeRegistry.ADVANCEMENTS.convert(data, 1L, 1L));
    assertEquals(0, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(0, tag.size());
    assertTrue(data.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link MCDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#ADVANCEMENTS}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given ADVANCEMENTS; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType MCDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenAdvancements_thenReturnNull2() {
    // Arrange
    NBTMapType data = new NBTMapType();

    // Act and Assert
    assertNull(MCTypeRegistry.ADVANCEMENTS.convert(data, Long.MAX_VALUE, 1L));
    assertEquals(0, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(0, tag.size());
    assertTrue(data.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link MCDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#ADVANCEMENTS}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given ADVANCEMENTS; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType MCDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenAdvancements_thenReturnNull3() {
    // Arrange
    NBTMapType data = new NBTMapType();

    // Act and Assert
    assertNull(MCTypeRegistry.ADVANCEMENTS.convert(data, 1L, Long.MAX_VALUE));
    assertEquals(0, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(0, tag.size());
    assertTrue(data.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link MCDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#ENTITY}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given ENTITY; when MAX_VALUE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType MCDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenEntity_whenMax_value_thenReturnNull() {
    // Arrange
    NBTMapType data = new NBTMapType();

    // Act and Assert
    assertNull(MCTypeRegistry.ENTITY.convert(data, 1L, Long.MAX_VALUE));
    assertEquals(0, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(0, tag.size());
    assertTrue(data.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link MCDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link IDDataType#IDDataType(String)} with name is {@code Equipment}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given IDDataType(String) with name is 'Equipment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType MCDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenIDDataTypeWithNameIsEquipment() {
    // Arrange
    IDDataType idDataType = new IDDataType("Equipment");
    NBTMapType data = new NBTMapType();

    // Act and Assert
    assertNull(idDataType.convert(data, 1L, Long.MAX_VALUE));
    assertEquals(0, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(0, tag.size());
    assertTrue(data.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link MCDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#LEVEL}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MCDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given LEVEL; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType MCDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenLevel_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType data = new NBTMapType();

    // Act
    MCTypeRegistry.LEVEL.convert(data, 1L, Long.MAX_VALUE);

    // Assert
    assertEquals(1, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(1, tag.size());
    assertFalse(data.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MCDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link MCDataType#MCDataType(String)} with {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given MCDataType(String) with 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType MCDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenMCDataTypeWithName_thenReturnNull() {
    // Arrange
    MCDataType mcDataType = new MCDataType("Name");
    NBTMapType data = new NBTMapType();

    // Act and Assert
    assertNull(mcDataType.convert(data, 1L, 1L));
    assertEquals(0, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(0, tag.size());
    assertTrue(data.isEmpty());
    assertTrue(tag.isEmpty());
  }
}
