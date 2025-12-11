package ca.spottedleaf.dataconverter.minecraft.walkers.generic;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.converters.datatypes.DataType;
import ca.spottedleaf.dataconverter.converters.datatypes.DataWalker;
import ca.spottedleaf.dataconverter.minecraft.datatypes.IDDataType;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCDataType;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCTypeRegistry;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCValueType;
import ca.spottedleaf.dataconverter.types.ListType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonListType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class WalkerUtilsDiffblueTest {
  /**
   * Test {@link WalkerUtils#convert(DataType, ListType, long, long)} with {@code DataType}, {@code
   * ListType}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Then calls {@link DataType#convert(Object, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(DataType, ListType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, ListType, long, long) with 'DataType', 'ListType', 'long', 'long'; then calls convert(Object, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(DataType, ListType, long, long)"})
  void testConvertWithDataTypeListTypeLongLong_thenCallsConvert() {
    // Arrange
    DataType<Object, Object> type = mock(DataType.class);
    when(type.convert(Mockito.<Object>any(), anyLong(), anyLong()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    JsonListType data = mock(JsonListType.class);
    doNothing().when(data).setGeneric(anyInt(), Mockito.<Object>any());
    when(data.getGeneric(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(data.size()).thenReturn(3);

    // Act
    WalkerUtils.convert(type, data, 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(Object.class), eq(1L), eq(1L));
    verify(data, atLeast(1)).setGeneric(anyInt(), isA(Object.class));
    verify(data, atLeast(1)).getGeneric(anyInt());
    verify(data).size();
  }

  /**
   * Test {@link WalkerUtils#convert(DataType, ListType, long, long)} with {@code DataType}, {@code
   * ListType}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#BIOME}.
   *   <li>Then calls {@link JsonListType#getGeneric(int)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(DataType, ListType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, ListType, long, long) with 'DataType', 'ListType', 'long', 'long'; when BIOME; then calls getGeneric(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(DataType, ListType, long, long)"})
  void testConvertWithDataTypeListTypeLongLong_whenBiome_thenCallsGetGeneric() {
    // Arrange
    JsonListType data = mock(JsonListType.class);
    when(data.getGeneric(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(data.size()).thenReturn(3);

    // Act
    WalkerUtils.convert(MCTypeRegistry.BIOME, data, 1L, 1L);

    // Assert
    verify(data, atLeast(1)).getGeneric(anyInt());
    verify(data).size();
  }

  /**
   * Test {@link WalkerUtils#convert(DataType, ListType, long, long)} with {@code DataType}, {@code
   * ListType}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#DATACONVERTER_CUSTOM_TYPE_COMMAND}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(DataType, ListType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, ListType, long, long) with 'DataType', 'ListType', 'long', 'long'; when DATACONVERTER_CUSTOM_TYPE_COMMAND")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(DataType, ListType, long, long)"})
  void testConvertWithDataTypeListTypeLongLong_whenDataconverter_custom_type_command() {
    // Arrange
    JsonListType data = mock(JsonListType.class);
    when(data.getGeneric(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(data.size()).thenReturn(3);

    // Act
    WalkerUtils.convert(MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND, data, 1L, 1L);

    // Assert
    verify(data, atLeast(1)).getGeneric(anyInt());
    verify(data).size();
  }

  /**
   * Test {@link WalkerUtils#convert(DataType, ListType, long, long)} with {@code DataType}, {@code
   * ListType}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCValueType#MCValueType(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(DataType, ListType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, ListType, long, long) with 'DataType', 'ListType', 'long', 'long'; when MCValueType(String) with 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(DataType, ListType, long, long)"})
  void testConvertWithDataTypeListTypeLongLong_whenMCValueTypeWithName() {
    // Arrange
    MCValueType type = new MCValueType("Name");

    JsonListType data = mock(JsonListType.class);
    when(data.getGeneric(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(data.size()).thenReturn(3);

    // Act
    WalkerUtils.convert(type, data, 1L, 1L);

    // Assert
    verify(data, atLeast(1)).getGeneric(anyInt());
    verify(data).size();
  }

  /**
   * Test {@link WalkerUtils#convert(DataType, MapType, String, long, long)} with {@code DataType},
   * {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convert(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(DataType, MapType, String, long, long)"})
  void testConvertWithDataTypeMapTypeStringLongLong() {
    // Arrange
    JsonMapType data = mock(JsonMapType.class);
    when(data.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    WalkerUtils.convert(MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND, data, "Path", 1L, 1L);

    // Assert
    verify(data).getGeneric("Path");
  }

  /**
   * Test {@link WalkerUtils#convert(DataType, MapType, String, long, long)} with {@code DataType},
   * {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link DataType#convert(Object, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'; given 'true'; then calls convert(Object, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(DataType, MapType, String, long, long)"})
  void testConvertWithDataTypeMapTypeStringLongLong_givenTrue_thenCallsConvert() {
    // Arrange
    DataType<Object, Object> type = mock(DataType.class);
    when(type.convert(Mockito.<Object>any(), anyLong(), anyLong())).thenReturn(true);

    JsonMapType data = mock(JsonMapType.class);
    doNothing().when(data).setGeneric(Mockito.<String>any(), Mockito.<Object>any());
    when(data.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    WalkerUtils.convert(type, data, "Path", 1L, 1L);

    // Assert
    verify(type).convert(isA(Object.class), eq(1L), eq(1L));
    verify(data).setGeneric(eq("Path"), isA(Object.class));
    verify(data).getGeneric("Path");
  }

  /**
   * Test {@link WalkerUtils#convert(DataType, MapType, String, long, long)} with {@code DataType},
   * {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#BIOME}.
   *   <li>Then calls {@link JsonMapType#getGeneric(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'; when BIOME; then calls getGeneric(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(DataType, MapType, String, long, long)"})
  void testConvertWithDataTypeMapTypeStringLongLong_whenBiome_thenCallsGetGeneric() {
    // Arrange
    JsonMapType data = mock(JsonMapType.class);
    when(data.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    WalkerUtils.convert(MCTypeRegistry.BIOME, data, "Path", 1L, 1L);

    // Assert
    verify(data).getGeneric("Path");
  }

  /**
   * Test {@link WalkerUtils#convert(DataType, MapType, String, long, long)} with {@code DataType},
   * {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCValueType#MCValueType(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'; when MCValueType(String) with 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(DataType, MapType, String, long, long)"})
  void testConvertWithDataTypeMapTypeStringLongLong_whenMCValueTypeWithName() {
    // Arrange
    MCValueType type = new MCValueType("Name");

    JsonMapType data = mock(JsonMapType.class);
    when(data.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    WalkerUtils.convert(type, data, "Path", 1L, 1L);

    // Assert
    verify(data).getGeneric("Path");
  }

  /**
   * Test {@link WalkerUtils#convert(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Then calls {@link MCDataType#convert(MapType, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; then calls convert(MapType, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(MCDataType, MapType, String, long, long)"})
  void testConvertWithMCDataTypeMapTypeStringLongLong_thenCallsConvert() {
    // Arrange
    MCDataType type = mock(MCDataType.class);
    when(type.convert(Mockito.<MapType>any(), anyLong(), anyLong())).thenReturn(new NBTMapType());

    MapType data = mock(MapType.class);
    doNothing().when(data).setMap(Mockito.<String>any(), Mockito.<MapType>any());
    when(data.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    // Act
    WalkerUtils.convert(type, data, "Path", 1L, 1L);

    // Assert
    verify(type).convert(isA(MapType.class), eq(1L), eq(1L));
    verify(data).getMap("Path");
    verify(data).setMap(eq("Path"), isA(MapType.class));
  }

  /**
   * Test {@link WalkerUtils#convert(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ADVANCEMENTS}.
   *   <li>Then calls {@link MapType#getMap(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; when ADVANCEMENTS; then calls getMap(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(MCDataType, MapType, String, long, long)"})
  void testConvertWithMCDataTypeMapTypeStringLongLong_whenAdvancements_thenCallsGetMap() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    // Act
    WalkerUtils.convert(MCTypeRegistry.ADVANCEMENTS, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
  }

  /**
   * Test {@link WalkerUtils#convert(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY_CHUNK}.
   *   <li>Then calls {@link MapType#getMap(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; when ENTITY_CHUNK; then calls getMap(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(MCDataType, MapType, String, long, long)"})
  void testConvertWithMCDataTypeMapTypeStringLongLong_whenEntity_chunk_thenCallsGetMap() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    // Act
    WalkerUtils.convert(MCTypeRegistry.ENTITY_CHUNK, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
  }

  /**
   * Test {@link WalkerUtils#convert(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY}.
   *   <li>Then calls {@link MapType#getMap(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convert(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; when ENTITY; then calls getMap(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convert(MCDataType, MapType, String, long, long)"})
  void testConvertWithMCDataTypeMapTypeStringLongLong_whenEntity_thenCallsGetMap() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    // Act
    WalkerUtils.convert(MCTypeRegistry.ENTITY, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
  }

  /**
   * Test {@link WalkerUtils#convertList(DataType, MapType, String, long, long)} with {@code
   * DataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertList(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(DataType, MapType, String, long, long)"})
  void testConvertListWithDataTypeMapTypeStringLongLong() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getGeneric(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getGeneric(anyInt());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertList(DataType, MapType, String, long, long)} with {@code
   * DataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'; given NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(DataType, MapType, String, long, long)"})
  void testConvertListWithDataTypeMapTypeStringLongLong_givenNBTListType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(new NBTListType());

    // Act
    WalkerUtils.convertList(MCTypeRegistry.BIOME, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
  }

  /**
   * Test {@link WalkerUtils#convertList(DataType, MapType, String, long, long)} with {@code
   * DataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Then calls {@link DataType#convert(Object, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'; then calls convert(Object, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(DataType, MapType, String, long, long)"})
  void testConvertListWithDataTypeMapTypeStringLongLong_thenCallsConvert() {
    // Arrange
    DataType<Object, Object> type = mock(DataType.class);
    when(type.convert(Mockito.<Object>any(), anyLong(), anyLong()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    JsonListType jsonListType = mock(JsonListType.class);
    doNothing().when(jsonListType).setGeneric(anyInt(), Mockito.<Object>any());
    when(jsonListType.getGeneric(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(type, data, "Path", 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(Object.class), eq(1L), eq(1L));
    verify(jsonListType, atLeast(1)).setGeneric(anyInt(), isA(Object.class));
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getGeneric(anyInt());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertList(DataType, MapType, String, long, long)} with {@code
   * DataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#BIOME}.
   *   <li>Then calls {@link JsonListType#getGeneric(int)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'; when BIOME; then calls getGeneric(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(DataType, MapType, String, long, long)"})
  void testConvertListWithDataTypeMapTypeStringLongLong_whenBiome_thenCallsGetGeneric() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getGeneric(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(MCTypeRegistry.BIOME, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getGeneric(anyInt());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertList(DataType, MapType, String, long, long)} with {@code
   * DataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCValueType#MCValueType(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(DataType, MapType, String, long, long) with 'DataType', 'MapType', 'String', 'long', 'long'; when MCValueType(String) with 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(DataType, MapType, String, long, long)"})
  void testConvertListWithDataTypeMapTypeStringLongLong_whenMCValueTypeWithName() {
    // Arrange
    MCValueType type = new MCValueType("Name");

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getGeneric(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(type, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getGeneric(anyInt());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(MCDataType, MapType, String, long, long)"})
  void testConvertListWithMCDataTypeMapTypeStringLongLong() {
    // Arrange
    MCDataType type = mock(MCDataType.class);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(null);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(type, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; given NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(MCDataType, MapType, String, long, long)"})
  void testConvertListWithMCDataTypeMapTypeStringLongLong_givenNBTListType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(new NBTListType());

    // Act
    WalkerUtils.convertList(MCTypeRegistry.ADVANCEMENTS, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
  }

  /**
   * Test {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Then calls {@link MCDataType#convert(MapType, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; then calls convert(MapType, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(MCDataType, MapType, String, long, long)"})
  void testConvertListWithMCDataTypeMapTypeStringLongLong_thenCallsConvert() {
    // Arrange
    MCDataType type = mock(MCDataType.class);
    when(type.convert(Mockito.<MapType>any(), anyLong(), anyLong())).thenReturn(new NBTMapType());

    JsonListType jsonListType = mock(JsonListType.class);
    doNothing().when(jsonListType).setMap(anyInt(), Mockito.<MapType>any());
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(type, data, "Path", 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(MapType.class), eq(1L), eq(1L));
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType, atLeast(1)).setMap(anyInt(), isA(MapType.class));
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ADVANCEMENTS}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; when ADVANCEMENTS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(MCDataType, MapType, String, long, long)"})
  void testConvertListWithMCDataTypeMapTypeStringLongLong_whenAdvancements() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(MCTypeRegistry.ADVANCEMENTS, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY_CHUNK}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; when ENTITY_CHUNK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(MCDataType, MapType, String, long, long)"})
  void testConvertListWithMCDataTypeMapTypeStringLongLong_whenEntity_chunk() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(MCTypeRegistry.ENTITY_CHUNK, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)} with {@code
   * MCDataType}, {@code MapType}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY}.
   *   <li>Then calls {@link JsonListType#getMap(int, MapType)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertList(MCDataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertList(MCDataType, MapType, String, long, long) with 'MCDataType', 'MapType', 'String', 'long', 'long'; when ENTITY; then calls getMap(int, MapType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertList(MCDataType, MapType, String, long, long)"})
  void testConvertListWithMCDataTypeMapTypeStringLongLong_whenEntity_thenCallsGetMap() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertList(MCTypeRegistry.ENTITY, data, "Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, long, long)} with
   * {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringLongLong() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(MCTypeRegistry.BIOME, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, long, long)} with
   * {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringLongLong2() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(null);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(MCTypeRegistry.BIOME, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, long, long)} with
   * {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringLongLong3() {
    // Arrange
    MapType mapType = mock(MapType.class);
    when(mapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND,
        data,
        "List Path",
        "Element Path",
        1L,
        1L);

    // Assert
    verify(mapType, atLeast(1)).getGeneric("Element Path");
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, long, long)} with
   * {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringLongLong4() {
    // Arrange
    MCValueType type = new MCValueType("Name");

    MapType mapType = mock(MapType.class);
    when(mapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(type, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(mapType, atLeast(1)).getGeneric("Element Path");
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, long, long)} with
   * {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'long', 'long'; given NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringLongLong_givenNBTListType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(new NBTListType());

    // Act
    WalkerUtils.convertListPath(MCTypeRegistry.BIOME, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, long, long)} with
   * {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Then calls {@link DataType#convert(Object, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'long', 'long'; then calls convert(Object, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringLongLong_thenCallsConvert() {
    // Arrange
    DataType<Object, Object> type = mock(DataType.class);
    when(type.convert(Mockito.<Object>any(), anyLong(), anyLong())).thenReturn(true);

    MapType mapType = mock(MapType.class);
    doNothing().when(mapType).setGeneric(Mockito.<String>any(), Mockito.<Object>any());
    when(mapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(type, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(Object.class), eq(1L), eq(1L));
    verify(mapType, atLeast(1)).getGeneric("Element Path");
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).setGeneric(eq("Element Path"), isA(Object.class));
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, long, long)} with
   * {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Then calls {@link MapType#getGeneric(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'long', 'long'; then calls getGeneric(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringLongLong_thenCallsGetGeneric() {
    // Arrange
    MapType mapType = mock(MapType.class);
    when(mapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(MCTypeRegistry.BIOME, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(mapType, atLeast(1)).getGeneric("Element Path");
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, String, long, long)}
   * with {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code String}, {@code
   * long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringStringLongLong() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(new NBTListType());

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.BIOME, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, String, long, long)}
   * with {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code String}, {@code
   * long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringStringLongLong2() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.BIOME, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, String, long, long)}
   * with {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code String}, {@code
   * long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringStringLongLong3() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(null);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.BIOME, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, String, long, long)}
   * with {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code String}, {@code
   * long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringStringLongLong4() {
    // Arrange
    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.BIOME, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, String, long, long)}
   * with {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code String}, {@code
   * long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringStringLongLong5() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.BIOME, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
    verify(jsonMapType, atLeast(1)).getGeneric("Element Path2");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, String, long, long)}
   * with {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code String}, {@code
   * long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringStringLongLong6() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND,
        data,
        "List Path",
        "Element Path1",
        "Element Path2",
        1L,
        1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
    verify(jsonMapType, atLeast(1)).getGeneric("Element Path2");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, String, long, long)}
   * with {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code String}, {@code
   * long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringStringLongLong7() {
    // Arrange
    MCValueType type = new MCValueType("Name");

    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(type, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
    verify(jsonMapType, atLeast(1)).getGeneric("Element Path2");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(DataType, MapType, String, String, String, long, long)}
   * with {@code DataType}, {@code MapType}, {@code String}, {@code String}, {@code String}, {@code
   * long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(DataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(DataType, MapType, String, String, String, long, long) with 'DataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(DataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithDataTypeMapTypeStringStringStringLongLong8() {
    // Arrange
    DataType<Object, Object> type = mock(DataType.class);
    when(type.convert(Mockito.<Object>any(), anyLong(), anyLong())).thenReturn(true);

    JsonMapType jsonMapType = mock(JsonMapType.class);
    doNothing().when(jsonMapType).setGeneric(Mockito.<String>any(), Mockito.<Object>any());
    when(jsonMapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(type, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(Object.class), eq(1L), eq(1L));
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonMapType, atLeast(1)).setGeneric(eq("Element Path2"), isA(Object.class));
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
    verify(jsonMapType, atLeast(1)).getGeneric("Element Path2");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, long, long)} with
   * {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code
   * long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringLongLong() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, long, long)} with
   * {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code
   * long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringLongLong2() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(null);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, long, long)} with
   * {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code
   * long}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'long', 'long'; given NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringLongLong_givenNBTListType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(new NBTListType());

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, long, long)} with
   * {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code
   * long}.
   *
   * <ul>
   *   <li>Then calls {@link MCDataType#convert(MapType, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'long', 'long'; then calls convert(MapType, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringLongLong_thenCallsConvert() {
    // Arrange
    MCDataType type = mock(MCDataType.class);
    when(type.convert(Mockito.<MapType>any(), anyLong(), anyLong())).thenReturn(new NBTMapType());

    MapType mapType = mock(MapType.class);
    doNothing().when(mapType).setMap(Mockito.<String>any(), Mockito.<MapType>any());
    when(mapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(type, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(MapType.class), eq(1L), eq(1L));
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path");
    verify(mapType, atLeast(1)).setMap(eq("Element Path"), isA(MapType.class));
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, long, long)} with
   * {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code
   * long}.
   *
   * <ul>
   *   <li>Then calls {@link MapType#getMap(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'long', 'long'; then calls getMap(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringLongLong_thenCallsGetMap() {
    // Arrange
    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, long, long)} with
   * {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code
   * long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'long', 'long'; when ENTITY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringLongLong_whenEntity() {
    // Arrange
    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(MCTypeRegistry.ENTITY, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, long, long)} with
   * {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code long}, {@code
   * long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY_CHUNK}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'long', 'long'; when ENTITY_CHUNK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringLongLong_whenEntity_chunk() {
    // Arrange
    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ENTITY_CHUNK, data, "List Path", "Element Path", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, String, long,
   * long)} with {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code
   * String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringStringLongLong() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(new NBTListType());

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, String, long,
   * long)} with {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code
   * String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringStringLongLong2() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, String, long,
   * long)} with {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code
   * String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringStringLongLong3() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(null);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, String, long,
   * long)} with {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code
   * String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringStringLongLong4() {
    // Arrange
    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, String, long,
   * long)} with {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code
   * String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringStringLongLong5() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ADVANCEMENTS, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
    verify(jsonMapType, atLeast(1)).getMap("Element Path2");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, String, long,
   * long)} with {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code
   * String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringStringLongLong6() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ENTITY_CHUNK, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
    verify(jsonMapType, atLeast(1)).getMap("Element Path2");
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, String, long,
   * long)} with {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code
   * String}, {@code long}, {@code long}.
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'String', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringStringLongLong7() {
    // Arrange
    MCDataType type = mock(MCDataType.class);
    when(type.convert(Mockito.<MapType>any(), anyLong(), anyLong())).thenReturn(new NBTMapType());

    JsonMapType jsonMapType = mock(JsonMapType.class);
    doNothing().when(jsonMapType).setMap(Mockito.<String>any(), Mockito.<MapType>any());
    when(jsonMapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(type, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(MapType.class), eq(1L), eq(1L));
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
    verify(jsonMapType, atLeast(1)).getMap("Element Path2");
    verify(jsonMapType, atLeast(1)).setMap(eq("Element Path2"), isA(MapType.class));
  }

  /**
   * Test {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String, String, long,
   * long)} with {@code MCDataType}, {@code MapType}, {@code String}, {@code String}, {@code
   * String}, {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertListPath(MCDataType, MapType, String, String,
   * String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertListPath(MCDataType, MapType, String, String, String, long, long) with 'MCDataType', 'MapType', 'String', 'String', 'String', 'long', 'long'; when ENTITY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WalkerUtils.convertListPath(MCDataType, MapType, String, String, String, long, long)"
  })
  void testConvertListPathWithMCDataTypeMapTypeStringStringStringLongLong_whenEntity() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    MapType mapType = mock(MapType.class);
    when(mapType.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    WalkerUtils.convertListPath(
        MCTypeRegistry.ENTITY, data, "List Path", "Element Path1", "Element Path2", 1L, 1L);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getMap("Element Path1");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
    verify(jsonMapType, atLeast(1)).getMap("Element Path2");
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, long, long)} with {@code type}, {@code
   * data}, {@code fromVersion}, {@code toVersion}.
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, long, long) with 'type', 'data', 'fromVersion', 'toVersion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, long, long)"})
  void testConvertKeysWithTypeDataFromVersionToVersion() {
    // Arrange
    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType data = mock(MapType.class);
    when(data.keys()).thenReturn(stringSet);

    // Act
    WalkerUtils.convertKeys(MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND, data, 1L, 1L);

    // Assert
    verify(data).keys();
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, long, long)} with {@code type}, {@code
   * data}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@code Convert}.
   *   <li>Then calls {@link DataType#convert(Object, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, long, long) with 'type', 'data', 'fromVersion', 'toVersion'; given 'Convert'; then calls convert(Object, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, long, long)"})
  void testConvertKeysWithTypeDataFromVersionToVersion_givenConvert_thenCallsConvert() {
    // Arrange
    DataType<Object, Object> type = mock(DataType.class);
    when(type.convert(Mockito.<Object>any(), anyLong(), anyLong())).thenReturn("Convert");

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType data = mock(MapType.class);
    when(data.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    doNothing().when(data).remove(Mockito.<String>any());
    doNothing().when(data).setGeneric(Mockito.<String>any(), Mockito.<Object>any());
    when(data.keys()).thenReturn(stringSet);

    // Act
    WalkerUtils.convertKeys(type, data, 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(Object.class), eq(1L), eq(1L));
    verify(data, atLeast(1)).getGeneric("Keys");
    verify(data, atLeast(1)).keys();
    verify(data, atLeast(1)).remove("Keys");
    verify(data, atLeast(1)).setGeneric(eq("Convert"), isA(Object.class));
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, long, long)} with {@code type}, {@code
   * data}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#BIOME}.
   *   <li>Then calls {@link MapType#keys()}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, long, long) with 'type', 'data', 'fromVersion', 'toVersion'; when BIOME; then calls keys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, long, long)"})
  void testConvertKeysWithTypeDataFromVersionToVersion_whenBiome_thenCallsKeys() {
    // Arrange
    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType data = mock(MapType.class);
    when(data.keys()).thenReturn(stringSet);

    // Act
    WalkerUtils.convertKeys(MCTypeRegistry.BIOME, data, 1L, 1L);

    // Assert
    verify(data).keys();
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, long, long)} with {@code type}, {@code
   * data}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link MCValueType#MCValueType(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, long, long) with 'type', 'data', 'fromVersion', 'toVersion'; when MCValueType(String) with 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, long, long)"})
  void testConvertKeysWithTypeDataFromVersionToVersion_whenMCValueTypeWithName() {
    // Arrange
    MCValueType type = new MCValueType("Name");

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType data = mock(MapType.class);
    when(data.keys()).thenReturn(stringSet);

    // Act
    WalkerUtils.convertKeys(type, data, 1L, 1L);

    // Assert
    verify(data).keys();
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)} with {@code type},
   * {@code data}, {@code path}, {@code fromVersion}, {@code toVersion}.
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, String, long, long) with 'type', 'data', 'path', 'fromVersion', 'toVersion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, String, long, long)"})
  void testConvertKeysWithTypeDataPathFromVersionToVersion() {
    // Arrange
    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType mapType = mock(MapType.class);
    when(mapType.keys()).thenReturn(stringSet);

    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(mapType);

    // Act
    WalkerUtils.convertKeys(MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
    verify(mapType).keys();
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)} with {@code type},
   * {@code data}, {@code path}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, String, long, long) with 'type', 'data', 'path', 'fromVersion', 'toVersion'; given NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, String, long, long)"})
  void testConvertKeysWithTypeDataPathFromVersionToVersion_givenNBTMapType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    // Act
    WalkerUtils.convertKeys(MCTypeRegistry.BIOME, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)} with {@code type},
   * {@code data}, {@code path}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Then calls {@link DataType#convert(Object, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, String, long, long) with 'type', 'data', 'path', 'fromVersion', 'toVersion'; then calls convert(Object, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, String, long, long)"})
  void testConvertKeysWithTypeDataPathFromVersionToVersion_thenCallsConvert() {
    // Arrange
    DataType<Object, Object> type = mock(DataType.class);
    when(type.convert(Mockito.<Object>any(), anyLong(), anyLong())).thenReturn("Convert");

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType mapType = mock(MapType.class);
    when(mapType.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    doNothing().when(mapType).remove(Mockito.<String>any());
    doNothing().when(mapType).setGeneric(Mockito.<String>any(), Mockito.<Object>any());
    when(mapType.keys()).thenReturn(stringSet);

    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(mapType);

    // Act
    WalkerUtils.convertKeys(type, data, "Path", 1L, 1L);

    // Assert
    verify(type, atLeast(1)).convert(isA(Object.class), eq(1L), eq(1L));
    verify(mapType, atLeast(1)).getGeneric("Keys");
    verify(data).getMap("Path");
    verify(mapType, atLeast(1)).keys();
    verify(mapType, atLeast(1)).remove("Keys");
    verify(mapType, atLeast(1)).setGeneric(eq("Convert"), isA(Object.class));
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)} with {@code type},
   * {@code data}, {@code path}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link MCTypeRegistry#BIOME}.
   *   <li>Then calls {@link MapType#keys()}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, String, long, long) with 'type', 'data', 'path', 'fromVersion', 'toVersion'; when BIOME; then calls keys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, String, long, long)"})
  void testConvertKeysWithTypeDataPathFromVersionToVersion_whenBiome_thenCallsKeys() {
    // Arrange
    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType mapType = mock(MapType.class);
    when(mapType.keys()).thenReturn(stringSet);

    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(mapType);

    // Act
    WalkerUtils.convertKeys(MCTypeRegistry.BIOME, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
    verify(mapType).keys();
  }

  /**
   * Test {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)} with {@code type},
   * {@code data}, {@code path}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link MCValueType#MCValueType(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertKeys(DataType, MapType, String, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertKeys(DataType, MapType, String, long, long) with 'type', 'data', 'path', 'fromVersion', 'toVersion'; when MCValueType(String) with 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertKeys(DataType, MapType, String, long, long)"})
  void testConvertKeysWithTypeDataPathFromVersionToVersion_whenMCValueTypeWithName() {
    // Arrange
    MCValueType type = new MCValueType("Name");

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType mapType = mock(MapType.class);
    when(mapType.keys()).thenReturn(stringSet);

    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(mapType);

    // Act
    WalkerUtils.convertKeys(type, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
    verify(mapType).keys();
  }

  /**
   * Test {@link WalkerUtils#convertValues(MCDataType, MapType, long, long)} with {@code type},
   * {@code data}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Then calls {@link DataWalker#walk(Object, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertValues(MCDataType, MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertValues(MCDataType, MapType, long, long) with 'type', 'data', 'fromVersion', 'toVersion'; then calls walk(Object, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertValues(MCDataType, MapType, long, long)"})
  void testConvertValuesWithTypeDataFromVersionToVersion_thenCallsWalk() {
    // Arrange
    DataWalker<MapType> walker = mock(DataWalker.class);
    when(walker.walk(Mockito.<MapType>any(), anyLong(), anyLong()))
        .thenReturn(new JsonMapType(true));

    IDDataType type = new IDDataType("Name");
    type.addStructureWalker(0, walker);

    JsonObject map = new JsonObject();
    map.add("", new JsonArray());
    map.add("Property", new JsonObject());

    // Act
    WalkerUtils.convertValues(type, new JsonMapType(map, true), 1L, 1L);

    // Assert
    verify(walker).walk(isA(MapType.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link WalkerUtils#convertValues(MCDataType, MapType, String, long, long)} with {@code
   * type}, {@code data}, {@code path}, {@code fromVersion}, {@code toVersion}.
   *
   * <p>Method under test: {@link WalkerUtils#convertValues(MCDataType, MapType, String, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test convertValues(MCDataType, MapType, String, long, long) with 'type', 'data', 'path', 'fromVersion', 'toVersion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertValues(MCDataType, MapType, String, long, long)"})
  void testConvertValuesWithTypeDataPathFromVersionToVersion() {
    // Arrange
    JsonObject map = new JsonObject();
    map.add("Property", new JsonArray());

    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new JsonMapType(map, true));

    // Act
    WalkerUtils.convertValues(MCTypeRegistry.ADVANCEMENTS, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
  }

  /**
   * Test {@link WalkerUtils#convertValues(MCDataType, MapType, String, long, long)} with {@code
   * type}, {@code data}, {@code path}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertValues(MCDataType, MapType, String, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test convertValues(MCDataType, MapType, String, long, long) with 'type', 'data', 'path', 'fromVersion', 'toVersion'; given NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertValues(MCDataType, MapType, String, long, long)"})
  void testConvertValuesWithTypeDataPathFromVersionToVersion_givenNBTMapType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    // Act
    WalkerUtils.convertValues(MCTypeRegistry.ADVANCEMENTS, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
  }

  /**
   * Test {@link WalkerUtils#convertValues(MCDataType, MapType, String, long, long)} with {@code
   * type}, {@code data}, {@code path}, {@code fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link MCDataType#MCDataType(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WalkerUtils#convertValues(MCDataType, MapType, String, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test convertValues(MCDataType, MapType, String, long, long) with 'type', 'data', 'path', 'fromVersion', 'toVersion'; when MCDataType(String) with 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WalkerUtils.convertValues(MCDataType, MapType, String, long, long)"})
  void testConvertValuesWithTypeDataPathFromVersionToVersion_whenMCDataTypeWithName() {
    // Arrange
    MCDataType type = new MCDataType("Name");

    JsonObject map = new JsonObject();
    map.add("Property", new JsonObject());

    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new JsonMapType(map, true));

    // Act
    WalkerUtils.convertValues(type, data, "Path", 1L, 1L);

    // Assert
    verify(data).getMap("Path");
  }
}
