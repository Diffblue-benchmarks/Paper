package ca.spottedleaf.dataconverter.minecraft.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.converters.DataConverter;
import ca.spottedleaf.dataconverter.converters.datatypes.DataWalker;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk;
import ca.spottedleaf.dataconverter.minecraft.hooks.DataHookEnforceNamespacedID;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.util.Long2ObjectArraySortedMap;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IDDataTypeDiffblueTest {
  /**
   * Test {@link IDDataType#IDDataType(String)}.
   *
   * <p>Method under test: {@link IDDataType#IDDataType(String)}
   */
  @Test
  @DisplayName("Test new IDDataType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.<init>(String)"})
  void testNewIDDataType() {
    // Arrange and Act
    IDDataType actualIdDataType = new IDDataType("Name");

    // Assert
    assertEquals("Name", actualIdDataType.name);
    assertTrue(actualIdDataType.structureConverters.isEmpty());
    assertTrue(actualIdDataType.walkersById.isEmpty());
  }

  /**
   * Test {@link IDDataType#addConverterForId(String, DataConverter)}.
   *
   * <ul>
   *   <li>Then {@link IDDataType#IDDataType(String)} with {@code Name} {@link
   *       MCDataType#structureConverters} size is one.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#addConverterForId(String, DataConverter)}
   */
  @Test
  @DisplayName(
      "Test addConverterForId(String, DataConverter); then IDDataType(String) with 'Name' structureConverters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.addConverterForId(String, DataConverter)"})
  void testAddConverterForId_thenIDDataTypeWithNameStructureConvertersSizeIsOne() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");

    // Act
    idDataType.addConverterForId("42", new ConverterFlattenChunk());

    // Assert
    ArrayList<DataConverter<MapType, MapType>> dataConverterList = idDataType.structureConverters;
    assertEquals(1, dataConverterList.size());
    DataConverter<MapType, MapType> getResult = dataConverterList.get(0);
    assertEquals(1, getResult.getVersionStep());
    assertEquals(1451, getResult.getToVersion());
    assertEquals(6231997546497L, getResult.getEncodedVersion());
  }

  /**
   * Test {@link IDDataType#hasWalkers(String)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#ENTITY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#hasWalkers(String)}
   */
  @Test
  @DisplayName("Test hasWalkers(String); given ENTITY; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IDDataType.hasWalkers(String)"})
  void testHasWalkers_givenEntity_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MCTypeRegistry.ENTITY.hasWalkers("42"));
  }

  /**
   * Test {@link IDDataType#hasWalkers(String)}.
   *
   * <ul>
   *   <li>Given {@link IDDataType#IDDataType(String)} with {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#hasWalkers(String)}
   */
  @Test
  @DisplayName("Test hasWalkers(String); given IDDataType(String) with 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IDDataType.hasWalkers(String)"})
  void testHasWalkers_givenIDDataTypeWithName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new IDDataType("Name").hasWalkers("42"));
  }

  /**
   * Test {@link IDDataType#addWalker(int, String, DataWalker)} with {@code minVersion}, {@code id},
   * {@code walker}.
   *
   * <ul>
   *   <li>Then {@link IDDataType#IDDataType(String)} with {@code Name} {@link
   *       IDDataType#walkersById} size is one.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#addWalker(int, String, DataWalker)}
   */
  @Test
  @DisplayName(
      "Test addWalker(int, String, DataWalker) with 'minVersion', 'id', 'walker'; then IDDataType(String) with 'Name' walkersById size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.addWalker(int, String, DataWalker)"})
  void testAddWalkerWithMinVersionIdWalker_thenIDDataTypeWithNameWalkersByIdSizeIsOne() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");

    // Act
    idDataType.addWalker(1, "42", mock(DataWalker.class));

    // Assert
    Map<String, Long2ObjectArraySortedMap<List<DataWalker<MapType>>>>
        stringLong2ObjectArraySortedMapMap = idDataType.walkersById;
    assertEquals(1, stringLong2ObjectArraySortedMapMap.size());
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("42"));
  }

  /**
   * Test {@link IDDataType#addWalker(int, int, String, DataWalker)} with {@code minVersion}, {@code
   * versionStep}, {@code id}, {@code walker}.
   *
   * <p>Method under test: {@link IDDataType#addWalker(int, int, String, DataWalker)}
   */
  @Test
  @DisplayName(
      "Test addWalker(int, int, String, DataWalker) with 'minVersion', 'versionStep', 'id', 'walker'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.addWalker(int, int, String, DataWalker)"})
  void testAddWalkerWithMinVersionVersionStepIdWalker() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");

    // Act
    idDataType.addWalker(1, 2, "42", mock(DataWalker.class));

    // Assert
    Map<String, Long2ObjectArraySortedMap<List<DataWalker<MapType>>>>
        stringLong2ObjectArraySortedMapMap = idDataType.walkersById;
    assertEquals(1, stringLong2ObjectArraySortedMapMap.size());
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("42"));
  }

  /**
   * Test {@link IDDataType#copyWalkers(int, String, String)} with {@code minVersion}, {@code
   * fromId}, {@code toId}.
   *
   * <p>Method under test: {@link IDDataType#copyWalkers(int, String, String)}
   */
  @Test
  @DisplayName("Test copyWalkers(int, String, String) with 'minVersion', 'fromId', 'toId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.copyWalkers(int, String, String)"})
  void testCopyWalkersWithMinVersionFromIdToId() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");
    idDataType.addWalker(1, 2, "42", mock(DataWalker.class));

    // Act
    idDataType.copyWalkers(1, "42", "42");

    // Assert that nothing has changed
    Map<String, Long2ObjectArraySortedMap<List<DataWalker<MapType>>>>
        stringLong2ObjectArraySortedMapMap = idDataType.walkersById;
    assertEquals(1, stringLong2ObjectArraySortedMapMap.size());
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("42"));
  }

  /**
   * Test {@link IDDataType#copyWalkers(int, String, String)} with {@code minVersion}, {@code
   * fromId}, {@code toId}.
   *
   * <p>Method under test: {@link IDDataType#copyWalkers(int, String, String)}
   */
  @Test
  @DisplayName("Test copyWalkers(int, String, String) with 'minVersion', 'fromId', 'toId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.copyWalkers(int, String, String)"})
  void testCopyWalkersWithMinVersionFromIdToId2() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");
    idDataType.addWalker(0, "42", mock(DataWalker.class));

    // Act
    idDataType.copyWalkers(1, "42", "42");

    // Assert that nothing has changed
    Map<String, Long2ObjectArraySortedMap<List<DataWalker<MapType>>>>
        stringLong2ObjectArraySortedMapMap = idDataType.walkersById;
    assertEquals(1, stringLong2ObjectArraySortedMapMap.size());
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("42"));
  }

  /**
   * Test {@link IDDataType#copyWalkers(int, String, String)} with {@code minVersion}, {@code
   * fromId}, {@code toId}.
   *
   * <p>Method under test: {@link IDDataType#copyWalkers(int, String, String)}
   */
  @Test
  @DisplayName("Test copyWalkers(int, String, String) with 'minVersion', 'fromId', 'toId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.copyWalkers(int, String, String)"})
  void testCopyWalkersWithMinVersionFromIdToId3() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");
    idDataType.addWalker(0, "42", mock(DataWalker.class));

    // Act
    idDataType.copyWalkers(1, "42", "To Id");

    // Assert
    Map<String, Long2ObjectArraySortedMap<List<DataWalker<MapType>>>>
        stringLong2ObjectArraySortedMapMap = idDataType.walkersById;
    assertEquals(2, stringLong2ObjectArraySortedMapMap.size());
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("42"));
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("To Id"));
  }

  /**
   * Test {@link IDDataType#copyWalkers(int, String, String)} with {@code minVersion}, {@code
   * fromId}, {@code toId}.
   *
   * <ul>
   *   <li>Then {@link IDDataType#IDDataType(String)} with {@code Name} {@link
   *       IDDataType#walkersById} Empty.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#copyWalkers(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test copyWalkers(int, String, String) with 'minVersion', 'fromId', 'toId'; then IDDataType(String) with 'Name' walkersById Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.copyWalkers(int, String, String)"})
  void testCopyWalkersWithMinVersionFromIdToId_thenIDDataTypeWithNameWalkersByIdEmpty() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");

    // Act
    idDataType.copyWalkers(1, "42", "42");

    // Assert that nothing has changed
    assertTrue(idDataType.walkersById.isEmpty());
  }

  /**
   * Test {@link IDDataType#copyWalkers(int, int, String, String)} with {@code minVersion}, {@code
   * versionStep}, {@code fromId}, {@code toId}.
   *
   * <p>Method under test: {@link IDDataType#copyWalkers(int, int, String, String)}
   */
  @Test
  @DisplayName(
      "Test copyWalkers(int, int, String, String) with 'minVersion', 'versionStep', 'fromId', 'toId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.copyWalkers(int, int, String, String)"})
  void testCopyWalkersWithMinVersionVersionStepFromIdToId() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");

    // Act
    idDataType.copyWalkers(1, 1, "42", "42");

    // Assert that nothing has changed
    assertTrue(idDataType.walkersById.isEmpty());
  }

  /**
   * Test {@link IDDataType#copyWalkers(int, int, String, String)} with {@code minVersion}, {@code
   * versionStep}, {@code fromId}, {@code toId}.
   *
   * <p>Method under test: {@link IDDataType#copyWalkers(int, int, String, String)}
   */
  @Test
  @DisplayName(
      "Test copyWalkers(int, int, String, String) with 'minVersion', 'versionStep', 'fromId', 'toId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.copyWalkers(int, int, String, String)"})
  void testCopyWalkersWithMinVersionVersionStepFromIdToId2() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");
    idDataType.addWalker(1, "42", mock(DataWalker.class));

    // Act
    idDataType.copyWalkers(1, 1, "42", "42");

    // Assert that nothing has changed
    Map<String, Long2ObjectArraySortedMap<List<DataWalker<MapType>>>>
        stringLong2ObjectArraySortedMapMap = idDataType.walkersById;
    assertEquals(1, stringLong2ObjectArraySortedMapMap.size());
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("42"));
  }

  /**
   * Test {@link IDDataType#copyWalkers(int, int, String, String)} with {@code minVersion}, {@code
   * versionStep}, {@code fromId}, {@code toId}.
   *
   * <p>Method under test: {@link IDDataType#copyWalkers(int, int, String, String)}
   */
  @Test
  @DisplayName(
      "Test copyWalkers(int, int, String, String) with 'minVersion', 'versionStep', 'fromId', 'toId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.copyWalkers(int, int, String, String)"})
  void testCopyWalkersWithMinVersionVersionStepFromIdToId3() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");
    idDataType.addWalker(1, 2, "42", mock(DataWalker.class));

    // Act
    idDataType.copyWalkers(1, 1, "42", "42");

    // Assert that nothing has changed
    Map<String, Long2ObjectArraySortedMap<List<DataWalker<MapType>>>>
        stringLong2ObjectArraySortedMapMap = idDataType.walkersById;
    assertEquals(1, stringLong2ObjectArraySortedMapMap.size());
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("42"));
  }

  /**
   * Test {@link IDDataType#copyWalkers(int, int, String, String)} with {@code minVersion}, {@code
   * versionStep}, {@code fromId}, {@code toId}.
   *
   * <p>Method under test: {@link IDDataType#copyWalkers(int, int, String, String)}
   */
  @Test
  @DisplayName(
      "Test copyWalkers(int, int, String, String) with 'minVersion', 'versionStep', 'fromId', 'toId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IDDataType.copyWalkers(int, int, String, String)"})
  void testCopyWalkersWithMinVersionVersionStepFromIdToId4() {
    // Arrange
    IDDataType idDataType = new IDDataType("Name");
    idDataType.addWalker(1, "42", mock(DataWalker.class));

    // Act
    idDataType.copyWalkers(1, 1, "42", "To Id");

    // Assert
    Map<String, Long2ObjectArraySortedMap<List<DataWalker<MapType>>>>
        stringLong2ObjectArraySortedMapMap = idDataType.walkersById;
    assertEquals(2, stringLong2ObjectArraySortedMapMap.size());
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("42"));
    assertTrue(stringLong2ObjectArraySortedMapMap.containsKey("To Id"));
  }

  /**
   * Test {@link IDDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <p>Method under test: {@link IDDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName("Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType IDDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion() {
    // Arrange
    DataWalker<MapType> walker = mock(DataWalker.class);
    when(walker.walk(Mockito.<MapType>any(), anyLong(), anyLong())).thenReturn(null);

    IDDataType idDataType = new IDDataType("id");
    idDataType.addStructureHook(-1, new DataHookEnforceNamespacedID("id"));
    idDataType.addStructureWalker(0, walker);

    // Act
    MapType actualConvertResult = idDataType.convert(new NBTMapType(), 1L, 1L);

    // Assert
    verify(walker).walk(isA(MapType.class), eq(1L), eq(1L));
    assertNull(actualConvertResult);
  }

  /**
   * Test {@link IDDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link DataWalker} {@link DataWalker#walk(Object, long, long)} return {@link
   *       NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given DataWalker walk(Object, long, long) return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType IDDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenDataWalkerWalkReturnNBTMapType() {
    // Arrange
    DataWalker<MapType> walker = mock(DataWalker.class);
    NBTMapType nbtMapType = new NBTMapType();
    when(walker.walk(Mockito.<MapType>any(), anyLong(), anyLong())).thenReturn(nbtMapType);

    IDDataType idDataType = new IDDataType("id");
    idDataType.addStructureWalker(0, walker);

    // Act
    MapType actualConvertResult = idDataType.convert(new NBTMapType(), 1L, 1L);

    // Assert
    verify(walker).walk(isA(MapType.class), eq(1L), eq(1L));
    assertSame(nbtMapType, actualConvertResult);
  }

  /**
   * Test {@link IDDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link IDDataType#IDDataType(String)} with name is {@code id}.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; given IDDataType(String) with name is 'id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType IDDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_givenIDDataTypeWithNameIsId() {
    // Arrange
    IDDataType idDataType = new IDDataType("id");

    // Act and Assert
    assertNull(idDataType.convert(new NBTMapType(), 1L, 1L));
  }

  /**
   * Test {@link IDDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType IDDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_thenReturnNull() {
    // Arrange
    DataWalker<MapType> walker = mock(DataWalker.class);
    when(walker.walk(Mockito.<MapType>any(), anyLong(), anyLong())).thenReturn(null);

    IDDataType idDataType = new IDDataType("id");
    idDataType.addStructureWalker(0, walker);

    // Act
    MapType actualConvertResult = idDataType.convert(new NBTMapType(), 1L, 1L);

    // Assert
    verify(walker).walk(isA(MapType.class), eq(1L), eq(1L));
    assertNull(actualConvertResult);
  }

  /**
   * Test {@link IDDataType#convert(MapType, long, long)} with {@code data}, {@code fromVersion},
   * {@code toVersion}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link IDDataType#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType IDDataType.convert(MapType, long, long)"})
  void testConvertWithDataFromVersionToVersion_whenZero() {
    // Arrange
    DataWalker<MapType> walker = mock(DataWalker.class);
    NBTMapType nbtMapType = new NBTMapType();
    when(walker.walk(Mockito.<MapType>any(), anyLong(), anyLong())).thenReturn(nbtMapType);

    IDDataType idDataType = new IDDataType("id");
    idDataType.addStructureWalker(0, walker);

    // Act
    MapType actualConvertResult = idDataType.convert(new NBTMapType(), 1L, 0L);

    // Assert
    verify(walker).walk(isA(MapType.class), eq(1L), eq(0L));
    assertSame(nbtMapType, actualConvertResult);
  }
}
