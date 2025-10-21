package ca.spottedleaf.dataconverter.minecraft.converters.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterFlattenEntityDiffblueTest {
  /**
   * Test {@link ConverterFlattenEntity#ConverterFlattenEntity(String[])}.
   *
   * <p>Method under test: {@link ConverterFlattenEntity#ConverterFlattenEntity(String[])}
   */
  @Test
  @DisplayName("Test new ConverterFlattenEntity(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConverterFlattenEntity.<init>(String[])"})
  void testNewConverterFlattenEntity() {
    // Arrange and Act
    ConverterFlattenEntity actualConverterFlattenEntity = new ConverterFlattenEntity("Paths");

    // Assert
    assertEquals(1451, actualConverterFlattenEntity.getToVersion());
    assertEquals(3, actualConverterFlattenEntity.getVersionStep());
  }

  /**
   * Test {@link ConverterFlattenEntity#getBlockId(String)}.
   *
   * <ul>
   *   <li>When {@code Block}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenEntity#getBlockId(String)}
   */
  @Test
  @DisplayName("Test getBlockId(String); when 'Block'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenEntity.getBlockId(String)"})
  void testGetBlockId_whenBlock_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ConverterFlattenEntity.getBlockId("Block"));
  }

  /**
   * Test {@link ConverterFlattenEntity#getBlockId(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:structure_block}.
   *   <li>Then return two hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenEntity#getBlockId(String)}
   */
  @Test
  @DisplayName(
      "Test getBlockId(String); when 'minecraft:structure_block'; then return two hundred fifty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenEntity.getBlockId(String)"})
  void testGetBlockId_whenMinecraftStructureBlock_thenReturnTwoHundredFiftyFive() {
    // Arrange, Act and Assert
    assertEquals(255, ConverterFlattenEntity.getBlockId("minecraft:structure_block"));
  }

  /**
   * Test {@link ConverterFlattenEntity#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenEntity#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterFlattenEntity.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_thenNBTMapTypeSizeIsOne() {
    // Arrange
    ConverterFlattenEntity converterFlattenEntity =
        new ConverterFlattenEntity("Paths", "DisplayData", "Paths");
    NBTMapType data = new NBTMapType();

    // Act
    converterFlattenEntity.convert(data, 1L, 1L);

    // Assert
    assertEquals(1, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(1, tag.size());
    assertFalse(data.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link ConverterFlattenEntity#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Then {@link NBTMapType#NBTMapType()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenEntity#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; then NBTMapType() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterFlattenEntity.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_thenNBTMapTypeSizeIsZero() {
    // Arrange
    ConverterFlattenEntity converterFlattenEntity = new ConverterFlattenEntity("Paths");
    NBTMapType data = new NBTMapType();

    // Act
    converterFlattenEntity.convert(data, 1L, 1L);

    // Assert that nothing has changed
    assertEquals(0, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(0, tag.size());
    assertTrue(data.isEmpty());
    assertTrue(tag.isEmpty());
  }
}
