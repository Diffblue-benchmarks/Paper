package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.minecraft.versions.V2841.SimplePaletteReader;
import ca.spottedleaf.dataconverter.types.ListType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.ObjectType;
import ca.spottedleaf.dataconverter.types.json.JsonListType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class V2841DiffblueTest {
  /**
   * Test {@link V2841#migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   *   <li>Then return {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#migrateTickList(ListType, boolean, Int2ObjectOpenHashMap,
   * int, int, int)}
   */
  @Test
  @DisplayName(
      "Test migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int); given NBTListType(); then return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListType V2841.migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int)"
  })
  void testMigrateTickList_givenNBTListType_thenReturnNBTListType() {
    // Arrange
    NBTListType ticks = new NBTListType();
    NBTListType list = new NBTListType();
    ticks.addList(list);

    // Act
    ListType actualMigrateTickListResult =
        V2841.migrateTickList(ticks, true, new Int2ObjectOpenHashMap<>(), 1, 1, 1);

    // Assert
    assertTrue(actualMigrateTickListResult instanceof NBTListType);
    assertEquals(list, actualMigrateTickListResult);
  }

  /**
   * Test {@link V2841#migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link JsonListType#JsonListType(boolean)} with compressed is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#migrateTickList(ListType, boolean, Int2ObjectOpenHashMap,
   * int, int, int)}
   */
  @Test
  @DisplayName(
      "Test migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int); when JsonListType(boolean) with compressed is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListType V2841.migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int)"
  })
  void testMigrateTickList_whenJsonListTypeWithCompressedIsTrue() {
    // Arrange
    JsonListType ticks = new JsonListType(true);

    // Act
    ListType actualMigrateTickListResult =
        V2841.migrateTickList(ticks, true, new Int2ObjectOpenHashMap<>(), 1, 1, 1);

    // Assert
    assertTrue(actualMigrateTickListResult instanceof NBTListType);
    assertTrue(actualMigrateTickListResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, actualMigrateTickListResult.size());
    assertEquals(ObjectType.NONE, actualMigrateTickListResult.getUniformType());
    assertTrue(((NBTListType) actualMigrateTickListResult).getTag().isEmpty());
  }

  /**
   * Test {@link V2841#migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link NBTListType#NBTListType()}.
   *   <li>Then return {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#migrateTickList(ListType, boolean, Int2ObjectOpenHashMap,
   * int, int, int)}
   */
  @Test
  @DisplayName(
      "Test migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int); when NBTListType(); then return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListType V2841.migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int)"
  })
  void testMigrateTickList_whenNBTListType_thenReturnNBTListType() {
    // Arrange
    NBTListType ticks = new NBTListType();

    // Act
    ListType actualMigrateTickListResult =
        V2841.migrateTickList(ticks, true, new Int2ObjectOpenHashMap<>(), 1, 1, 1);

    // Assert
    assertTrue(actualMigrateTickListResult instanceof NBTListType);
    assertEquals(ticks, actualMigrateTickListResult);
  }

  /**
   * Test {@link V2841#migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then TypeUtil return {@link NBTTypeUtil}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#migrateTickList(ListType, boolean, Int2ObjectOpenHashMap,
   * int, int, int)}
   */
  @Test
  @DisplayName(
      "Test migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int); when 'null'; then TypeUtil return NBTTypeUtil")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListType V2841.migrateTickList(ListType, boolean, Int2ObjectOpenHashMap, int, int, int)"
  })
  void testMigrateTickList_whenNull_thenTypeUtilReturnNBTTypeUtil() {
    // Arrange and Act
    ListType actualMigrateTickListResult =
        V2841.migrateTickList(null, true, new Int2ObjectOpenHashMap<>(), 1, 1, 1);

    // Assert
    assertTrue(actualMigrateTickListResult instanceof NBTListType);
    assertTrue(actualMigrateTickListResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, actualMigrateTickListResult.size());
    assertEquals(ObjectType.NONE, actualMigrateTickListResult.getUniformType());
    assertTrue(((NBTListType) actualMigrateTickListResult).getTag().isEmpty());
  }

  /**
   * Test {@link V2841#createNewTick(String, int, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#createNewTick(String, int, int, int, int)}
   */
  @Test
  @DisplayName("Test createNewTick(String, int, int, int, int); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2841.createNewTick(String, int, int, int, int)"})
  void testCreateNewTick_when42() {
    // Arrange and Act
    MapType actualCreateNewTickResult = V2841.createNewTick("42", 1, 1, 1, 1);

    // Assert
    assertTrue(actualCreateNewTickResult instanceof NBTMapType);
    assertTrue(actualCreateNewTickResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(6, actualCreateNewTickResult.size());
    CompoundTag tag = ((NBTMapType) actualCreateNewTickResult).getTag();
    assertEquals(6, tag.size());
    assertFalse(actualCreateNewTickResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2841#createNewTick(String, int, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code 2841}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#createNewTick(String, int, int, int, int)}
   */
  @Test
  @DisplayName("Test createNewTick(String, int, int, int, int); when '2841'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2841.createNewTick(String, int, int, int, int)"})
  void testCreateNewTick_when2841() {
    // Arrange and Act
    MapType actualCreateNewTickResult = V2841.createNewTick("42", 1, 2841, 1, 1);

    // Assert
    assertTrue(actualCreateNewTickResult instanceof NBTMapType);
    assertTrue(actualCreateNewTickResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(6, actualCreateNewTickResult.size());
    CompoundTag tag = ((NBTMapType) actualCreateNewTickResult).getTag();
    assertEquals(6, tag.size());
    assertFalse(actualCreateNewTickResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2841#createNewTick(String, int, int, int, int)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link V2841#createNewTick(String, int, int, int, int)}
   */
  @Test
  @DisplayName("Test createNewTick(String, int, int, int, int); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V2841.createNewTick(String, int, int, int, int)"})
  void testCreateNewTick_whenEmptyString() {
    // Arrange and Act
    MapType actualCreateNewTickResult = V2841.createNewTick("", 1, 1, 1, 1);

    // Assert
    assertTrue(actualCreateNewTickResult instanceof NBTMapType);
    assertTrue(actualCreateNewTickResult.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(6, actualCreateNewTickResult.size());
    CompoundTag tag = ((NBTMapType) actualCreateNewTickResult).getTag();
    assertEquals(6, tag.size());
    assertFalse(actualCreateNewTickResult.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link V2841#getBlockId(MapType)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@code minecraft:air}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#getBlockId(MapType)}
   */
  @Test
  @DisplayName(
      "Test getBlockId(MapType); when JsonMapType(boolean) with compressed is 'true'; then return 'minecraft:air'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V2841.getBlockId(MapType)"})
  void testGetBlockId_whenJsonMapTypeWithCompressedIsTrue_thenReturnMinecraftAir() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", V2841.getBlockId(new JsonMapType(true)));
  }

  /**
   * Test {@link V2841#getBlockId(MapType)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code minecraft:air}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#getBlockId(MapType)}
   */
  @Test
  @DisplayName("Test getBlockId(MapType); when NBTMapType(); then return 'minecraft:air'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V2841.getBlockId(MapType)"})
  void testGetBlockId_whenNBTMapType_thenReturnMinecraftAir() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", V2841.getBlockId(new NBTMapType()));
  }

  /**
   * Test {@link V2841#getBlockId(MapType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code minecraft:air}.
   * </ul>
   *
   * <p>Method under test: {@link V2841#getBlockId(MapType)}
   */
  @Test
  @DisplayName("Test getBlockId(MapType); when 'null'; then return 'minecraft:air'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String V2841.getBlockId(MapType)"})
  void testGetBlockId_whenNull_thenReturnMinecraftAir() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", V2841.getBlockId(null));
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#getState(int)} with {@code index}.
   *
   * <p>Method under test: {@link SimplePaletteReader#getState(int)}
   */
  @Test
  @DisplayName("Test SimplePaletteReader getState(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType SimplePaletteReader.getState(int)"})
  void testSimplePaletteReaderGetStateWithIndex() {
    // Arrange
    NBTListType palette = new NBTListType();
    palette.addByte((byte) 1);
    palette.addByte((byte) 'A');
    SimplePaletteReader simplePaletteReader = new SimplePaletteReader(palette, new long[] {});

    // Act and Assert
    assertNull(simplePaletteReader.getState(1));
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#getState(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#getState(int)}
   */
  @Test
  @DisplayName("Test SimplePaletteReader getState(int) with 'index'; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType SimplePaletteReader.getState(int)"})
  void testSimplePaletteReaderGetStateWithIndex_thenReturnNBTMapType() {
    // Arrange
    NBTListType palette = new NBTListType();
    NBTMapType map = new NBTMapType();
    palette.addMap(map);
    palette.addByte((byte) 'A');
    SimplePaletteReader simplePaletteReader =
        new SimplePaletteReader(palette, new long[] {1L, -1L, 1L, -1L});

    // Act
    MapType actualState = simplePaletteReader.getState(1);

    // Assert
    assertTrue(actualState instanceof NBTMapType);
    assertEquals(map, actualState);
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#getState(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#getState(int)}
   */
  @Test
  @DisplayName("Test SimplePaletteReader getState(int) with 'index'; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType SimplePaletteReader.getState(int)"})
  void testSimplePaletteReaderGetStateWithIndex_thenReturnNBTMapType2() {
    // Arrange
    NBTListType palette = new NBTListType();
    NBTMapType map = new NBTMapType();
    palette.addMap(map);
    SimplePaletteReader simplePaletteReader =
        new SimplePaletteReader(palette, new long[] {1L, -1L, 1L, -1L});

    // Act
    MapType actualState = simplePaletteReader.getState(1);

    // Assert
    assertTrue(actualState instanceof NBTMapType);
    assertEquals(map, actualState);
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#getState(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#getState(int)}
   */
  @Test
  @DisplayName("Test SimplePaletteReader getState(int) with 'index'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType SimplePaletteReader.getState(int)"})
  void testSimplePaletteReaderGetStateWithIndex_thenReturnNull() {
    // Arrange
    SimplePaletteReader simplePaletteReader =
        new SimplePaletteReader(new NBTListType(), new long[] {1L, -1L, 1L, -1L});

    // Act and Assert
    assertNull(simplePaletteReader.getState(1));
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#getState(int, int, int)} with {@code x},
   * {@code y}, {@code z}.
   *
   * <ul>
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#getState(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test SimplePaletteReader getState(int, int, int) with 'x', 'y', 'z'; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType SimplePaletteReader.getState(int, int, int)"})
  void testSimplePaletteReaderGetStateWithXYZ_thenReturnNBTMapType() {
    // Arrange
    NBTListType palette = new NBTListType();
    NBTMapType map = new NBTMapType();
    palette.addMap(map);
    SimplePaletteReader simplePaletteReader =
        new SimplePaletteReader(palette, new long[] {1L, -1L, 1L, -1L});

    // Act
    MapType actualState = simplePaletteReader.getState(2, 3, 1);

    // Assert
    assertTrue(actualState instanceof NBTMapType);
    assertEquals(map, actualState);
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#getState(int, int, int)} with {@code x},
   * {@code y}, {@code z}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#getState(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test SimplePaletteReader getState(int, int, int) with 'x', 'y', 'z'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType SimplePaletteReader.getState(int, int, int)"})
  void testSimplePaletteReaderGetStateWithXYZ_thenReturnNull() {
    // Arrange
    SimplePaletteReader simplePaletteReader =
        new SimplePaletteReader(new NBTListType(), new long[] {1L, -1L, 1L, -1L});

    // Act and Assert
    assertNull(simplePaletteReader.getState(2, 3, 1));
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#getState(int, int, int)} with {@code x},
   * {@code y}, {@code z}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#getState(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test SimplePaletteReader getState(int, int, int) with 'x', 'y', 'z'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType SimplePaletteReader.getState(int, int, int)"})
  void testSimplePaletteReaderGetStateWithXYZ_thenReturnNull2() {
    // Arrange
    NBTListType palette = new NBTListType();
    palette.addByte((byte) 4);
    palette.addByte((byte) 'A');
    SimplePaletteReader simplePaletteReader =
        new SimplePaletteReader(palette, new long[] {1L, -1L, 1L, -1L});

    // Act and Assert
    assertNull(simplePaletteReader.getState(2, 3, 1));
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#SimplePaletteReader(ListType, long[])}.
   *
   * <ul>
   *   <li>Then {@link SimplePaletteReader#palette} return {@link NBTListType}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#SimplePaletteReader(ListType, long[])}
   */
  @Test
  @DisplayName(
      "Test SimplePaletteReader new SimplePaletteReader(ListType, long[]); then palette return NBTListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePaletteReader.<init>(ListType, long[])"})
  void testSimplePaletteReaderNewSimplePaletteReader_thenPaletteReturnNBTListType() {
    // Arrange
    NBTListType palette = new NBTListType();
    palette.addByte((byte) 'A');

    // Act
    SimplePaletteReader actualSimplePaletteReader =
        new SimplePaletteReader(palette, new long[] {1L, -1L, 1L, -1L});

    // Assert
    ListType listType = actualSimplePaletteReader.palette;
    assertTrue(listType instanceof NBTListType);
    assertTrue(listType.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, listType.size());
    ListTag tag = ((NBTListType) listType).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.BYTE, listType.getUniformType());
    assertEquals('A', ((ByteTag) tag.get(0)).value());
    assertArrayEquals(new long[] {1L, -1L, 1L, -1L}, actualSimplePaletteReader.data);
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#SimplePaletteReader(ListType, long[])}.
   *
   * <ul>
   *   <li>When {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#SimplePaletteReader(ListType, long[])}
   */
  @Test
  @DisplayName(
      "Test SimplePaletteReader new SimplePaletteReader(ListType, long[]); when NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePaletteReader.<init>(ListType, long[])"})
  void testSimplePaletteReaderNewSimplePaletteReader_whenNBTListType() {
    // Arrange and Act
    SimplePaletteReader actualSimplePaletteReader =
        new SimplePaletteReader(new NBTListType(), new long[] {1L, -1L, 1L, -1L});

    // Assert
    assertNull(actualSimplePaletteReader.palette);
    assertArrayEquals(new long[] {1L, -1L, 1L, -1L}, actualSimplePaletteReader.data);
  }

  /**
   * Test SimplePaletteReader {@link SimplePaletteReader#SimplePaletteReader(ListType, long[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link SimplePaletteReader#palette} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePaletteReader#SimplePaletteReader(ListType, long[])}
   */
  @Test
  @DisplayName(
      "Test SimplePaletteReader new SimplePaletteReader(ListType, long[]); when 'null'; then return palette is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePaletteReader.<init>(ListType, long[])"})
  void testSimplePaletteReaderNewSimplePaletteReader_whenNull_thenReturnPaletteIsNull() {
    // Arrange and Act
    SimplePaletteReader actualSimplePaletteReader =
        new SimplePaletteReader(null, new long[] {1L, -1L, 1L, -1L});

    // Assert
    assertNull(actualSimplePaletteReader.palette);
    assertArrayEquals(new long[] {1L, -1L, 1L, -1L}, actualSimplePaletteReader.data);
  }
}
