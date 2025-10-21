package ca.spottedleaf.dataconverter.minecraft.converters.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelperBlockFlatteningV1450DiffblueTest {
  /**
   * Test {@link HelperBlockFlatteningV1450#parseTag(String)}.
   *
   * <ul>
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#parseTag(String)}
   */
  @Test
  @DisplayName("Test parseTag(String); then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.parseTag(String)"})
  void testParseTag_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualParseTagResult =
        HelperBlockFlatteningV1450.parseTag(
            "{Name:'minecraft:structure_block',Properties:{mode:'data'}}");

    // Assert
    assertTrue(actualParseTagResult instanceof NBTMapType);
    assertTrue(actualParseTagResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(2, actualParseTagResult.size());
    CompoundTag tag = ((NBTMapType) actualParseTagResult).getTag();
    assertEquals(2, tag.size());
    assertFalse(actualParseTagResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#parseTag(String)}.
   *
   * <ul>
   *   <li>When {@code 42Blockstate}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#parseTag(String)}
   */
  @Test
  @DisplayName("Test parseTag(String); when '42Blockstate'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.parseTag(String)"})
  void testParseTag_when42Blockstate_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> HelperBlockFlatteningV1450.parseTag("42Blockstate"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#parseTag(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#parseTag(String)}
   */
  @Test
  @DisplayName("Test parseTag(String); when '42'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.parseTag(String)"})
  void testParseTag_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> HelperBlockFlatteningV1450.parseTag("42"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#parseTag(String)}.
   *
   * <ul>
   *   <li>When {@code %9$9d}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#parseTag(String)}
   */
  @Test
  @DisplayName("Test parseTag(String); when '%9$9d'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.parseTag(String)"})
  void testParseTag_when99d_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> HelperBlockFlatteningV1450.parseTag("%9$9d"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#parseTag(String)}.
   *
   * <ul>
   *   <li>When {@code 4242Blockstate}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#parseTag(String)}
   */
  @Test
  @DisplayName("Test parseTag(String); when '4242Blockstate'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.parseTag(String)"})
  void testParseTag_when4242Blockstate_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> HelperBlockFlatteningV1450.parseTag("4242Blockstate"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#parseTag(String)}.
   *
   * <ul>
   *   <li>When {@code Blockstate42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#parseTag(String)}
   */
  @Test
  @DisplayName("Test parseTag(String); when 'Blockstate42'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.parseTag(String)"})
  void testParseTag_whenBlockstate42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> HelperBlockFlatteningV1450.parseTag("Blockstate42"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#parseTag(String)}.
   *
   * <ul>
   *   <li>When {@code Blockstate{Name:'minecraft:structure_block',Properties:{mode:'data'}}}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#parseTag(String)}
   */
  @Test
  @DisplayName(
      "Test parseTag(String); when 'Blockstate{Name:'minecraft:structure_block',Properties:{mode:'data'}}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.parseTag(String)"})
  void testParseTag_whenBlockstateNameMinecraftStructureBlockPropertiesModeData() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            HelperBlockFlatteningV1450.parseTag(
                "Blockstate{Name:'minecraft:structure_block',Properties:{mode:'data'}}"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#parseTag(String)}.
   *
   * <ul>
   *   <li>When {@code Blockstate}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#parseTag(String)}
   */
  @Test
  @DisplayName("Test parseTag(String); when 'Blockstate'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.parseTag(String)"})
  void testParseTag_whenBlockstate_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> HelperBlockFlatteningV1450.parseTag("Blockstate"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#flattenNBT(MapType)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CompoundTag#CompoundTag()} Byte {@code Key} is {@code A}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#flattenNBT(MapType)}
   */
  @Test
  @DisplayName(
      "Test flattenNBT(MapType); given 'Key'; when CompoundTag() Byte 'Key' is 'A'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.flattenNBT(MapType)"})
  void testFlattenNBT_givenKey_whenCompoundTagByteKeyIsA_thenReturnSizeIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putByte("Key", (byte) 'A');

    // Act
    MapType actualFlattenNBTResult = HelperBlockFlatteningV1450.flattenNBT(new NBTMapType(tag));

    // Assert
    assertTrue(actualFlattenNBTResult instanceof NBTMapType);
    assertEquals(1, actualFlattenNBTResult.size());
    assertFalse(actualFlattenNBTResult.isEmpty());
    assertSame(tag, ((NBTMapType) actualFlattenNBTResult).getTag());
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#flattenNBT(MapType)}.
   *
   * <ul>
   *   <li>Given {@code CompoundTag}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#flattenNBT(MapType)}
   */
  @Test
  @DisplayName(
      "Test flattenNBT(MapType); given 'net.minecraft.nbt.CompoundTag'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.flattenNBT(MapType)"})
  void testFlattenNBT_givenNetMinecraftNbtCompoundTag_thenReturnSizeIsTwo() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putLong("net.minecraft.nbt.CompoundTag", -1L);
    tag.putByte("Key", (byte) 'A');

    // Act
    MapType actualFlattenNBTResult = HelperBlockFlatteningV1450.flattenNBT(new NBTMapType(tag));

    // Assert
    assertTrue(actualFlattenNBTResult instanceof NBTMapType);
    assertEquals(2, actualFlattenNBTResult.size());
    assertFalse(actualFlattenNBTResult.isEmpty());
    assertSame(tag, ((NBTMapType) actualFlattenNBTResult).getTag());
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#flattenNBT(MapType)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#flattenNBT(MapType)}
   */
  @Test
  @DisplayName("Test flattenNBT(MapType); when NBTMapType(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.flattenNBT(MapType)"})
  void testFlattenNBT_whenNBTMapType_thenReturnSizeIsZero() {
    // Arrange and Act
    MapType actualFlattenNBTResult = HelperBlockFlatteningV1450.flattenNBT(new NBTMapType());

    // Assert
    assertTrue(actualFlattenNBTResult instanceof NBTMapType);
    assertEquals(0, actualFlattenNBTResult.size());
    CompoundTag tag = ((NBTMapType) actualFlattenNBTResult).getTag();
    assertEquals(0, tag.size());
    assertTrue(actualFlattenNBTResult.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#flattenNBT(MapType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#flattenNBT(MapType)}
   */
  @Test
  @DisplayName("Test flattenNBT(MapType); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.flattenNBT(MapType)"})
  void testFlattenNBT_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(HelperBlockFlatteningV1450.flattenNBT(null));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNewBlockName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNewBlockName(String)}
   */
  @Test
  @DisplayName("Test getNewBlockName(String); when 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelperBlockFlatteningV1450.getNewBlockName(String)"})
  void testGetNewBlockName_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", HelperBlockFlatteningV1450.getNewBlockName("Name"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNewBlockName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNewBlockName(String)}
   */
  @Test
  @DisplayName("Test getNewBlockName(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelperBlockFlatteningV1450.getNewBlockName(String)"})
  void testGetNewBlockName_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(HelperBlockFlatteningV1450.getNewBlockName(null));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNewBlockName(String)}.
   *
   * <ul>
   *   <li>When {@code Old}.
   *   <li>Then return {@code Old}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNewBlockName(String)}
   */
  @Test
  @DisplayName("Test getNewBlockName(String); when 'Old'; then return 'Old'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelperBlockFlatteningV1450.getNewBlockName(String)"})
  void testGetNewBlockName_whenOld_thenReturnOld() {
    // Arrange, Act and Assert
    assertEquals("Old", HelperBlockFlatteningV1450.getNewBlockName("Old"));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNameForId(int)}.
   *
   * <ul>
   *   <li>When {@code 4079}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNameForId(int)}
   */
  @Test
  @DisplayName("Test getNameForId(int); when '4079'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelperBlockFlatteningV1450.getNameForId(int)"})
  void testGetNameForId_when4079() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", HelperBlockFlatteningV1450.getNameForId(4079));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNameForId(int)}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNameForId(int)}
   */
  @Test
  @DisplayName("Test getNameForId(int); when '4096'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelperBlockFlatteningV1450.getNameForId(int)"})
  void testGetNameForId_when4096() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", HelperBlockFlatteningV1450.getNameForId(4096));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNameForId(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNameForId(int)}
   */
  @Test
  @DisplayName("Test getNameForId(int); when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelperBlockFlatteningV1450.getNameForId(int)"})
  void testGetNameForId_whenMinusOne() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", HelperBlockFlatteningV1450.getNameForId(-1));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNameForId(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNameForId(int)}
   */
  @Test
  @DisplayName("Test getNameForId(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelperBlockFlatteningV1450.getNameForId(int)"})
  void testGetNameForId_whenOne() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", HelperBlockFlatteningV1450.getNameForId(1));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNBTForIdRaw(int)}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNBTForIdRaw(int)}
   */
  @Test
  @DisplayName("Test getNBTForIdRaw(int); when '4096'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.getNBTForIdRaw(int)"})
  void testGetNBTForIdRaw_when4096_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(HelperBlockFlatteningV1450.getNBTForIdRaw(4096));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNBTForIdRaw(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNBTForIdRaw(int)}
   */
  @Test
  @DisplayName("Test getNBTForIdRaw(int); when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.getNBTForIdRaw(int)"})
  void testGetNBTForIdRaw_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(HelperBlockFlatteningV1450.getNBTForIdRaw(-1));
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNBTForIdRaw(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNBTForIdRaw(int)}
   */
  @Test
  @DisplayName("Test getNBTForIdRaw(int); when one; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.getNBTForIdRaw(int)"})
  void testGetNBTForIdRaw_whenOne_thenReturnNBTMapType() {
    // Arrange and Act
    MapType actualNBTForIdRaw = HelperBlockFlatteningV1450.getNBTForIdRaw(1);

    // Assert
    assertTrue(actualNBTForIdRaw instanceof NBTMapType);
    assertTrue(actualNBTForIdRaw.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualNBTForIdRaw.size());
    CompoundTag tag = ((NBTMapType) actualNBTForIdRaw).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualNBTForIdRaw.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNBTForId(int)}.
   *
   * <ul>
   *   <li>When {@code 4079}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNBTForId(int)}
   */
  @Test
  @DisplayName("Test getNBTForId(int); when '4079'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.getNBTForId(int)"})
  void testGetNBTForId_when4079() {
    // Arrange and Act
    MapType actualNBTForId = HelperBlockFlatteningV1450.getNBTForId(4079);

    // Assert
    assertTrue(actualNBTForId instanceof NBTMapType);
    assertTrue(actualNBTForId.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualNBTForId.size());
    CompoundTag tag = ((NBTMapType) actualNBTForId).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualNBTForId.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNBTForId(int)}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNBTForId(int)}
   */
  @Test
  @DisplayName("Test getNBTForId(int); when '4096'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.getNBTForId(int)"})
  void testGetNBTForId_when4096() {
    // Arrange and Act
    MapType actualNBTForId = HelperBlockFlatteningV1450.getNBTForId(4096);

    // Assert
    assertTrue(actualNBTForId instanceof NBTMapType);
    assertTrue(actualNBTForId.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualNBTForId.size());
    CompoundTag tag = ((NBTMapType) actualNBTForId).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualNBTForId.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNBTForId(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNBTForId(int)}
   */
  @Test
  @DisplayName("Test getNBTForId(int); when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.getNBTForId(int)"})
  void testGetNBTForId_whenMinusOne() {
    // Arrange and Act
    MapType actualNBTForId = HelperBlockFlatteningV1450.getNBTForId(-1);

    // Assert
    assertTrue(actualNBTForId instanceof NBTMapType);
    assertTrue(actualNBTForId.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualNBTForId.size());
    CompoundTag tag = ((NBTMapType) actualNBTForId).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualNBTForId.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link HelperBlockFlatteningV1450#getNBTForId(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link HelperBlockFlatteningV1450#getNBTForId(int)}
   */
  @Test
  @DisplayName("Test getNBTForId(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType HelperBlockFlatteningV1450.getNBTForId(int)"})
  void testGetNBTForId_whenOne() {
    // Arrange and Act
    MapType actualNBTForId = HelperBlockFlatteningV1450.getNBTForId(1);

    // Assert
    assertTrue(actualNBTForId instanceof NBTMapType);
    assertTrue(actualNBTForId.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(3, actualNBTForId.size());
    CompoundTag tag = ((NBTMapType) actualNBTForId).getTag();
    assertEquals(3, tag.size());
    assertFalse(actualNBTForId.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }
}
