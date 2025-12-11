package ca.spottedleaf.dataconverter.minecraft.converters.chunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk.DataLayer;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk.Direction;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk.Direction.Axis;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk.Direction.AxisDirection;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk.Section;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk.Section.Palette;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk.UpgradeChunk;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.TypeUtil;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.json.JsonTypeUtil;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.UnsupportedEncodingException;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ConverterFlattenChunkDiffblueTest {
  @InjectMocks private Palette palette;

  /**
   * Test DataLayer {@link DataLayer#getOrCreate(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#getOrCreate(byte[])}
   */
  @Test
  @DisplayName("Test DataLayer getOrCreate(byte[]); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataLayer DataLayer.getOrCreate(byte[])"})
  void testDataLayerGetOrCreate_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> DataLayer.getOrCreate("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test DataLayer {@link DataLayer#getOrCreate(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return second is zero.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#getOrCreate(byte[])}
   */
  @Test
  @DisplayName("Test DataLayer getOrCreate(byte[]); when 'null'; then return second is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataLayer DataLayer.getOrCreate(byte[])"})
  void testDataLayerGetOrCreate_whenNull_thenReturnSecondIsZero() {
    // Arrange and Act
    DataLayer actualOrCreate = DataLayer.getOrCreate(null);

    // Assert
    assertEquals(0, actualOrCreate.get(1));
  }

  /**
   * Test DataLayer {@link DataLayer#getOrNull(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#getOrNull(byte[])}
   */
  @Test
  @DisplayName(
      "Test DataLayer getOrNull(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataLayer DataLayer.getOrNull(byte[])"})
  void testDataLayerGetOrNull_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> DataLayer.getOrNull("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test DataLayer {@link DataLayer#getOrNull(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#getOrNull(byte[])}
   */
  @Test
  @DisplayName("Test DataLayer getOrNull(byte[]); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataLayer DataLayer.getOrNull(byte[])"})
  void testDataLayerGetOrNull_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DataLayer.getOrNull(null));
  }

  /**
   * Test DataLayer {@link DataLayer#get(int)} with {@code index}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#get(int)}
   */
  @Test
  @DisplayName("Test DataLayer get(int) with 'index'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataLayer.get(int)"})
  void testDataLayerGetWithIndex_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DataLayer().get(1));
  }

  /**
   * Test DataLayer {@link DataLayer#get(int, int, int)} with {@code x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#get(int, int, int)}
   */
  @Test
  @DisplayName("Test DataLayer get(int, int, int) with 'x', 'y', 'z'; when eight; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataLayer.get(int, int, int)"})
  void testDataLayerGetWithXYZ_whenEight_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DataLayer().get(8, 3, 3));
  }

  /**
   * Test DataLayer {@link DataLayer#get(int, int, int)} with {@code x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#get(int, int, int)}
   */
  @Test
  @DisplayName("Test DataLayer get(int, int, int) with 'x', 'y', 'z'; when four; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataLayer.get(int, int, int)"})
  void testDataLayerGetWithXYZ_whenFour_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DataLayer().get(4, 3, 3));
  }

  /**
   * Test DataLayer {@link DataLayer#get(int, int, int)} with {@code x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#get(int, int, int)}
   */
  @Test
  @DisplayName("Test DataLayer get(int, int, int) with 'x', 'y', 'z'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataLayer.get(int, int, int)"})
  void testDataLayerGetWithXYZ_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DataLayer().get(1, 3, 3));
  }

  /**
   * Test DataLayer {@link DataLayer#get(int, int, int)} with {@code x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataLayer#get(int, int, int)}
   */
  @Test
  @DisplayName("Test DataLayer get(int, int, int) with 'x', 'y', 'z'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataLayer.get(int, int, int)"})
  void testDataLayerGetWithXYZ_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DataLayer().get(2, 3, 3));
  }

  /**
   * Test DataLayer {@link DataLayer#DataLayer()}.
   *
   * <p>Method under test: {@link DataLayer#DataLayer()}
   */
  @Test
  @DisplayName("Test DataLayer new DataLayer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataLayer.<init>()"})
  void testDataLayerNewDataLayer() {
    // Arrange, Act and Assert
    assertEquals(0, new DataLayer().get(1));
  }

  /**
   * Test DataLayer {@link DataLayer#DataLayer(byte[])}.
   *
   * <p>Method under test: {@link DataLayer#DataLayer(byte[])}
   */
  @Test
  @DisplayName("Test DataLayer new DataLayer(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataLayer.<init>(byte[])"})
  void testDataLayerNewDataLayer2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DataLayer("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Direction getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Direction#getAxis()}
   *   <li>{@link Direction#getAxisDirection()}
   * </ul>
   */
  @Test
  @DisplayName("Test Direction getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Direction.Axis Direction.getAxis()",
    "Direction.AxisDirection Direction.getAxisDirection()"
  })
  void testDirectionGettersAndSetters() {
    // Arrange
    Direction valueOfResult = Direction.valueOf("DOWN");

    // Act
    Axis actualAxis = valueOfResult.getAxis();

    // Assert
    assertEquals(Axis.Y, actualAxis);
    assertEquals(AxisDirection.NEGATIVE, valueOfResult.getAxisDirection());
  }

  /**
   * Test Direction_AxisDirection {@link Direction.AxisDirection#getStep()}.
   *
   * <p>Method under test: {@link Direction.AxisDirection#getStep()}
   */
  @Test
  @DisplayName("Test Direction_AxisDirection getStep()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Direction.AxisDirection.getStep()"})
  void testDirection_AxisDirectionGetStep() {
    // Arrange, Act and Assert
    assertEquals(1, AxisDirection.valueOf("POSITIVE").getStep());
  }

  /**
   * Test new {@link ConverterFlattenChunk} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ConverterFlattenChunk}
   */
  @Test
  @DisplayName("Test new ConverterFlattenChunk (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConverterFlattenChunk.<init>()"})
  void testNewConverterFlattenChunk() {
    // Arrange and Act
    ConverterFlattenChunk actualConverterFlattenChunk = new ConverterFlattenChunk();

    // Assert
    assertEquals(1, actualConverterFlattenChunk.getVersionStep());
    assertEquals(1451, actualConverterFlattenChunk.getToVersion());
  }

  /**
   * Test {@link ConverterFlattenChunk#getName(MapType)}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then return {@code minecraft:air}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getName(MapType)}
   */
  @Test
  @DisplayName("Test getName(MapType); when AIR; then return 'minecraft:air'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConverterFlattenChunk.getName(MapType)"})
  void testGetName_whenAir_thenReturnMinecraftAir() {
    // Arrange, Act and Assert
    assertEquals("minecraft:air", ConverterFlattenChunk.getName(ConverterFlattenChunk.AIR));
  }

  /**
   * Test {@link ConverterFlattenChunk#getName(MapType)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getName(MapType)}
   */
  @Test
  @DisplayName(
      "Test getName(MapType); when JsonMapType(boolean) with compressed is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConverterFlattenChunk.getName(MapType)"})
  void testGetName_whenJsonMapTypeWithCompressedIsTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ConverterFlattenChunk.getName(new JsonMapType(true)));
  }

  /**
   * Test {@link ConverterFlattenChunk#getProperty(MapType, String)}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getProperty(MapType, String)}
   */
  @Test
  @DisplayName("Test getProperty(MapType, String); when AIR; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConverterFlattenChunk.getProperty(MapType, String)"})
  void testGetProperty_whenAir_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ConverterFlattenChunk.getProperty(ConverterFlattenChunk.AIR, "Property Name"));
  }

  /**
   * Test {@link ConverterFlattenChunk#getProperty(MapType, String)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getProperty(MapType, String)}
   */
  @Test
  @DisplayName(
      "Test getProperty(MapType, String); when JsonMapType(boolean) with compressed is 'true'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConverterFlattenChunk.getProperty(MapType, String)"})
  void testGetProperty_whenJsonMapTypeWithCompressedIsTrue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ConverterFlattenChunk.getProperty(new JsonMapType(true), "Property Name"));
  }

  /**
   * Test {@link ConverterFlattenChunk#getProperty(MapType, String)}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#SNOWY_GRASS}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getProperty(MapType, String)}
   */
  @Test
  @DisplayName("Test getProperty(MapType, String); when SNOWY_GRASS; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConverterFlattenChunk.getProperty(MapType, String)"})
  void testGetProperty_whenSnowy_grass_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "", ConverterFlattenChunk.getProperty(ConverterFlattenChunk.SNOWY_GRASS, "Property Name"));
  }

  /**
   * Test {@link ConverterFlattenChunk#getProperty(MapType, String)}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#SNOWY_GRASS}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getProperty(MapType, String)}
   */
  @Test
  @DisplayName("Test getProperty(MapType, String); when SNOWY_GRASS; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConverterFlattenChunk.getProperty(MapType, String)"})
  void testGetProperty_whenSnowy_grass_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", ConverterFlattenChunk.getProperty(ConverterFlattenChunk.SNOWY_GRASS, null));
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'false'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenFalse_thenReturnEight() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(false, true, false, true);

    // Assert
    assertEquals(8, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'false'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenFalse_thenReturnOne() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(false, false, true, true);

    // Assert
    assertEquals(1, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'false'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenFalse_thenReturnSize() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(false, false, false, true);

    // Assert
    assertEquals(Short.SIZE, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenFalse_thenReturnZero() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(false, false, false, false);

    // Assert
    assertEquals(0, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnFour() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(true, true, false, false);

    // Assert
    assertEquals(4, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return one hundred twenty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnOneHundredTwentyEight() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(true, false, true, true);

    // Assert
    assertEquals(128, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnSize() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(true, true, false, true);

    // Assert
    assertEquals(Integer.SIZE, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@link Double#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnSize2() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(true, false, false, false);

    // Assert
    assertEquals(Double.SIZE, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#getSideMask(boolean, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName("Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConverterFlattenChunk.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnTwo() {
    // Arrange and Act
    int actualSideMask = ConverterFlattenChunk.getSideMask(true, true, true, true);

    // Assert
    assertEquals(2, actualSideMask);
  }

  /**
   * Test {@link ConverterFlattenChunk#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when AIR; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterFlattenChunk.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenAir_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ConverterFlattenChunk().convert(ConverterFlattenChunk.AIR, 1L, 1L));
  }

  /**
   * Test {@link ConverterFlattenChunk#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenChunk#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when JsonMapType(boolean) with compressed is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterFlattenChunk.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenJsonMapTypeWithCompressedIsTrue() {
    // Arrange
    ConverterFlattenChunk converterFlattenChunk = new ConverterFlattenChunk();

    // Act and Assert
    assertNull(converterFlattenChunk.convert(new JsonMapType(true), 1L, 1L));
  }

  /**
   * Test Section {@link Section#getBlock(int)}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   * </ul>
   *
   * <p>Method under test: {@link Section#getBlock(int)}
   */
  @Test
  @DisplayName("Test Section getBlock(int); when '4096'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType Section.getBlock(int)"})
  void testSectionGetBlock_when4096() {
    // Arrange
    Section section = new Section(ConverterFlattenChunk.AIR);

    // Act
    MapType actualBlock = section.getBlock(4096);

    // Assert
    assertSame(section.section, actualBlock);
  }

  /**
   * Test Section {@link Section#getBlock(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link Section#getBlock(int)}
   */
  @Test
  @DisplayName("Test Section getBlock(int); when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType Section.getBlock(int)"})
  void testSectionGetBlock_whenMinusOne() {
    // Arrange
    Section section = new Section(ConverterFlattenChunk.AIR);

    // Act
    MapType actualBlock = section.getBlock(-1);

    // Assert
    assertSame(section.section, actualBlock);
  }

  /**
   * Test Section {@link Section#getBlock(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link Section#getBlock(int)}
   */
  @Test
  @DisplayName("Test Section getBlock(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType Section.getBlock(int)"})
  void testSectionGetBlock_whenOne() {
    // Arrange
    Section section = new Section(ConverterFlattenChunk.AIR);

    // Act
    MapType actualBlock = section.getBlock(1);

    // Assert
    assertSame(section.section, actualBlock);
  }

  /**
   * Test Section {@link Section#Section(MapType)}.
   *
   * <ul>
   *   <li>Then {@link Section#section} return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link Section#Section(MapType)}
   */
  @Test
  @DisplayName("Test Section new Section(MapType); then section return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Section.<init>(MapType)"})
  void testSectionNewSection_thenSectionReturnJsonMapType() {
    // Arrange and Act
    Section actualSection = new Section(new JsonMapType(true));

    // Assert
    MapType mapType = actualSection.section;
    assertTrue(mapType instanceof JsonMapType);
    TypeUtil<?> typeUtil = mapType.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, mapType.size());
    JsonObject json = ((JsonMapType) mapType).getJson();
    assertEquals(0, json.size());
    assertFalse(json.isJsonArray());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonPrimitive());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isJsonObject());
    assertTrue(json.isEmpty());
    Palette expectedIntArrayListMap = actualSection.palette;
    assertEquals(expectedIntArrayListMap, actualSection.toFix);
    JsonObject actualAsJsonObject = json.getAsJsonObject();
    assertSame(json, actualAsJsonObject);
  }

  /**
   * Test Section {@link Section#Section(MapType)}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then {@link Section#section} return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link Section#Section(MapType)}
   */
  @Test
  @DisplayName("Test Section new Section(MapType); when AIR; then section return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Section.<init>(MapType)"})
  void testSectionNewSection_whenAir_thenSectionReturnNBTMapType() {
    // Arrange and Act
    Section actualSection = new Section(ConverterFlattenChunk.AIR);

    // Assert
    MapType mapType = actualSection.section;
    assertTrue(mapType instanceof NBTMapType);
    assertTrue(mapType.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, mapType.size());
    CompoundTag tag = ((NBTMapType) mapType).getTag();
    assertEquals(1, tag.size());
    assertFalse(mapType.isEmpty());
    assertFalse(tag.isEmpty());
    Palette expectedIntArrayListMap = actualSection.palette;
    assertEquals(expectedIntArrayListMap, actualSection.toFix);
    assertEquals('\n', tag.getId());
  }

  /**
   * Test Section {@link Section#setBlock(int, MapType)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code Name} and {@code
   *       %%FILTER_ME%%}.
   * </ul>
   *
   * <p>Method under test: {@link Section#setBlock(int, MapType)}
   */
  @Test
  @DisplayName(
      "Test Section setBlock(int, MapType); given 'Name'; when JsonObject (default constructor) addProperty 'Name' and '%%FILTER_ME%%'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Section.setBlock(int, MapType)"})
  void testSectionSetBlock_givenName_whenJsonObjectAddPropertyNameAndFilterMe() {
    // Arrange
    Section section = new Section(ConverterFlattenChunk.AIR);

    JsonObject map = new JsonObject();
    map.addProperty("Name", "%%FILTER_ME%%");
    map.add("%%FILTER_ME%%", new JsonArray());

    // Act
    section.setBlock(1, new JsonMapType(map, true));

    // Assert
    int[] intArray = section.buffer;
    assertEquals(0, intArray[1]);
    assertEquals(1, section.palette.size());
    assertEquals(4096, intArray.length);
  }

  /**
   * Test Section {@link Section#setBlock(int, MapType)}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then second element is zero.
   * </ul>
   *
   * <p>Method under test: {@link Section#setBlock(int, MapType)}
   */
  @Test
  @DisplayName("Test Section setBlock(int, MapType); when AIR; then second element is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Section.setBlock(int, MapType)"})
  void testSectionSetBlock_whenAir_thenSecondElementIsZero() {
    // Arrange
    Section section = new Section(ConverterFlattenChunk.AIR);

    // Act
    section.setBlock(1, ConverterFlattenChunk.AIR);

    // Assert
    int[] intArray = section.buffer;
    assertEquals(0, intArray[1]);
    assertEquals(1, section.palette.size());
    assertEquals(4096, intArray.length);
  }

  /**
   * Test Section {@link Section#setBlock(int, MapType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then second element is minus one.
   * </ul>
   *
   * <p>Method under test: {@link Section#setBlock(int, MapType)}
   */
  @Test
  @DisplayName("Test Section setBlock(int, MapType); when 'null'; then second element is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Section.setBlock(int, MapType)"})
  void testSectionSetBlock_whenNull_thenSecondElementIsMinusOne() {
    // Arrange
    Section section = new Section(ConverterFlattenChunk.AIR);

    // Act
    section.setBlock(1, null);

    // Assert
    int[] intArray = section.buffer;
    assertEquals(-1, intArray[1]);
    assertEquals(4096, intArray.length);
    assertTrue(section.palette.isEmpty());
  }

  /**
   * Test Section {@link Section#upgrade(int)}.
   *
   * <p>Method under test: {@link Section#upgrade(int)}
   */
  @Test
  @DisplayName("Test Section upgrade(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Section.upgrade(int)"})
  void testSectionUpgrade() {
    // Arrange, Act and Assert
    assertEquals(1, new Section(ConverterFlattenChunk.AIR).upgrade(1));
  }

  /**
   * Test Section {@link Section#writeBackToSection()}.
   *
   * <p>Method under test: {@link Section#writeBackToSection()}
   */
  @Test
  @DisplayName("Test Section writeBackToSection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType Section.writeBackToSection()"})
  void testSectionWriteBackToSection() {
    // Arrange
    Section section = new Section(ConverterFlattenChunk.AIR);

    // Act
    MapType actualWriteBackToSectionResult = section.writeBackToSection();

    // Assert
    assertSame(section.section, actualWriteBackToSectionResult);
  }

  /**
   * Test Section_Palette {@link Palette#getOrCreateId(MapType)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then {@link Palette} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Palette#getOrCreateId(MapType)}
   */
  @Test
  @DisplayName(
      "Test Section_Palette getOrCreateId(MapType); given 'Name'; then Palette size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Palette.getOrCreateId(MapType)"})
  void testSection_PaletteGetOrCreateId_givenName_thenPaletteSizeIsOne() {
    // Arrange
    JsonObject map = new JsonObject();
    map.addProperty("Name", "%%FILTER_ME%%");
    map.add("%%FILTER_ME%%", new JsonArray());

    // Act and Assert
    assertEquals(0, palette.getOrCreateId(new JsonMapType(map, true)));
    assertEquals(1, palette.size());
  }

  /**
   * Test Section_Palette {@link Palette#getOrCreateId(MapType)}.
   *
   * <ul>
   *   <li>Given {@link Palette} (default constructor) {@link ConverterFlattenChunk#AIR} is one.
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Palette#getOrCreateId(MapType)}
   */
  @Test
  @DisplayName(
      "Test Section_Palette getOrCreateId(MapType); given Palette (default constructor) AIR is one; when AIR; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Palette.getOrCreateId(MapType)"})
  void testSection_PaletteGetOrCreateId_givenPaletteAirIsOne_whenAir_thenReturnOne() {
    // Arrange
    Palette palette = new Palette();
    palette.put(ConverterFlattenChunk.AIR, 1);

    // Act and Assert
    assertEquals(1, palette.getOrCreateId(ConverterFlattenChunk.AIR));
    assertEquals(1, palette.size());
  }

  /**
   * Test Section_Palette {@link Palette#getOrCreateId(MapType)}.
   *
   * <ul>
   *   <li>Given {@link Palette} (default constructor).
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Palette#getOrCreateId(MapType)}
   */
  @Test
  @DisplayName(
      "Test Section_Palette getOrCreateId(MapType); given Palette (default constructor); when AIR; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Palette.getOrCreateId(MapType)"})
  void testSection_PaletteGetOrCreateId_givenPalette_whenAir_thenReturnZero() {
    // Arrange
    Palette palette = new Palette();

    // Act and Assert
    assertEquals(0, palette.getOrCreateId(ConverterFlattenChunk.AIR));
    assertEquals(1, palette.size());
  }

  /**
   * Test Section_Palette {@link Palette#getOrCreateId(MapType)}.
   *
   * <ul>
   *   <li>Given {@link Palette} (default constructor).
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Palette#getOrCreateId(MapType)}
   */
  @Test
  @DisplayName(
      "Test Section_Palette getOrCreateId(MapType); given Palette (default constructor); when NBTMapType(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Palette.getOrCreateId(MapType)"})
  void testSection_PaletteGetOrCreateId_givenPalette_whenNBTMapType_thenReturnZero() {
    // Arrange
    Palette palette = new Palette();

    // Act and Assert
    assertEquals(0, palette.getOrCreateId(new NBTMapType()));
    assertEquals(1, palette.size());
  }

  /**
   * Test Section_Palette {@link Palette#getOrCreateId(MapType)}.
   *
   * <ul>
   *   <li>Given {@link Palette} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link Palette#getOrCreateId(MapType)}
   */
  @Test
  @DisplayName(
      "Test Section_Palette getOrCreateId(MapType); given Palette (default constructor); when 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Palette.getOrCreateId(MapType)"})
  void testSection_PaletteGetOrCreateId_givenPalette_whenNull_thenReturnMinusOne() {
    // Arrange
    Palette palette = new Palette();

    // Act and Assert
    assertEquals(-1, palette.getOrCreateId(null));
    assertTrue(palette.isEmpty());
  }

  /**
   * Test Section_Palette new {@link Palette} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Palette}
   */
  @Test
  @DisplayName("Test Section_Palette new Palette (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Palette.<init>()"})
  void testSection_PaletteNewPalette() {
    // Arrange, Act and Assert
    assertTrue(new Palette().isEmpty());
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#getBlock(int)}.
   *
   * <ul>
   *   <li>When {@code 65536}.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#getBlock(int)}
   */
  @Test
  @DisplayName("Test UpgradeChunk getBlock(int); when '65536'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType UpgradeChunk.getBlock(int)"})
  void testUpgradeChunkGetBlock_when65536() {
    // Arrange
    UpgradeChunk upgradeChunk = new UpgradeChunk(ConverterFlattenChunk.AIR);

    // Act
    MapType actualBlock = upgradeChunk.getBlock(65536);

    // Assert
    assertSame(upgradeChunk.level, actualBlock);
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#getBlock(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#getBlock(int)}
   */
  @Test
  @DisplayName("Test UpgradeChunk getBlock(int); when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType UpgradeChunk.getBlock(int)"})
  void testUpgradeChunkGetBlock_whenMinusOne() {
    // Arrange
    UpgradeChunk upgradeChunk = new UpgradeChunk(ConverterFlattenChunk.AIR);

    // Act
    MapType actualBlock = upgradeChunk.getBlock(-1);

    // Assert
    assertSame(upgradeChunk.level, actualBlock);
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#getBlock(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#getBlock(int)}
   */
  @Test
  @DisplayName("Test UpgradeChunk getBlock(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType UpgradeChunk.getBlock(int)"})
  void testUpgradeChunkGetBlock_whenOne() {
    // Arrange
    UpgradeChunk upgradeChunk = new UpgradeChunk(ConverterFlattenChunk.AIR);

    // Act
    MapType actualBlock = upgradeChunk.getBlock(1);

    // Assert
    assertSame(upgradeChunk.level, actualBlock);
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#UpgradeChunk(MapType)}.
   *
   * <ul>
   *   <li>Then {@link UpgradeChunk#level} return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#UpgradeChunk(MapType)}
   */
  @Test
  @DisplayName("Test UpgradeChunk new UpgradeChunk(MapType); then level return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpgradeChunk.<init>(MapType)"})
  void testUpgradeChunkNewUpgradeChunk_thenLevelReturnJsonMapType() {
    // Arrange, Act and Assert
    MapType mapType = new UpgradeChunk(new JsonMapType(true)).level;
    assertTrue(mapType instanceof JsonMapType);
    TypeUtil<?> typeUtil = mapType.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, mapType.size());
    JsonObject json = ((JsonMapType) mapType).getJson();
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
   * Test UpgradeChunk {@link UpgradeChunk#UpgradeChunk(MapType)}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then {@link UpgradeChunk#level} return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#UpgradeChunk(MapType)}
   */
  @Test
  @DisplayName(
      "Test UpgradeChunk new UpgradeChunk(MapType); when AIR; then level return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UpgradeChunk.<init>(MapType)"})
  void testUpgradeChunkNewUpgradeChunk_whenAir_thenLevelReturnNBTMapType() {
    // Arrange, Act and Assert
    MapType mapType = new UpgradeChunk(ConverterFlattenChunk.AIR).level;
    assertTrue(mapType instanceof NBTMapType);
    assertTrue(mapType.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, mapType.size());
    CompoundTag tag = ((NBTMapType) mapType).getTag();
    assertEquals(1, tag.size());
    assertFalse(mapType.isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#relative(int, Direction)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#relative(int, Direction)}
   */
  @Test
  @DisplayName("Test UpgradeChunk relative(int, Direction); when 'DOWN'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UpgradeChunk.relative(int, Direction)"})
  void testUpgradeChunkRelative_whenDown_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, UpgradeChunk.relative(1, Direction.DOWN));
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#relative(int, Direction)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#relative(int, Direction)}
   */
  @Test
  @DisplayName("Test UpgradeChunk relative(int, Direction); when 'EAST'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UpgradeChunk.relative(int, Direction)"})
  void testUpgradeChunkRelative_whenEast_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, UpgradeChunk.relative(-1, Direction.EAST));
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#relative(int, Direction)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#relative(int, Direction)}
   */
  @Test
  @DisplayName("Test UpgradeChunk relative(int, Direction); when minus one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UpgradeChunk.relative(int, Direction)"})
  void testUpgradeChunkRelative_whenMinusOne_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, UpgradeChunk.relative(-1, Direction.SOUTH));
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#relative(int, Direction)}.
   *
   * <ul>
   *   <li>When minus sixteen.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#relative(int, Direction)}
   */
  @Test
  @DisplayName(
      "Test UpgradeChunk relative(int, Direction); when minus sixteen; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UpgradeChunk.relative(int, Direction)"})
  void testUpgradeChunkRelative_whenMinusSixteen_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, UpgradeChunk.relative(-16, Direction.WEST));
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#relative(int, Direction)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#relative(int, Direction)}
   */
  @Test
  @DisplayName("Test UpgradeChunk relative(int, Direction); when 'NORTH'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UpgradeChunk.relative(int, Direction)"})
  void testUpgradeChunkRelative_whenNorth_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, UpgradeChunk.relative(1, Direction.NORTH));
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#relative(int, Direction)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return seventeen.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#relative(int, Direction)}
   */
  @Test
  @DisplayName("Test UpgradeChunk relative(int, Direction); when 'SOUTH'; then return seventeen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UpgradeChunk.relative(int, Direction)"})
  void testUpgradeChunkRelative_whenSouth_thenReturnSeventeen() {
    // Arrange, Act and Assert
    assertEquals(17, UpgradeChunk.relative(1, Direction.SOUTH));
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#relative(int, Direction)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return two hundred fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#relative(int, Direction)}
   */
  @Test
  @DisplayName(
      "Test UpgradeChunk relative(int, Direction); when 'UP'; then return two hundred fifty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UpgradeChunk.relative(int, Direction)"})
  void testUpgradeChunkRelative_whenUp_thenReturnTwoHundredFiftySeven() {
    // Arrange, Act and Assert
    assertEquals(257, UpgradeChunk.relative(1, Direction.UP));
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#relative(int, Direction)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UpgradeChunk#relative(int, Direction)}
   */
  @Test
  @DisplayName("Test UpgradeChunk relative(int, Direction); when 'WEST'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UpgradeChunk.relative(int, Direction)"})
  void testUpgradeChunkRelative_whenWest_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, UpgradeChunk.relative(1, Direction.WEST));
  }

  /**
   * Test UpgradeChunk {@link UpgradeChunk#writeBackToLevel()}.
   *
   * <p>Method under test: {@link UpgradeChunk#writeBackToLevel()}
   */
  @Test
  @DisplayName("Test UpgradeChunk writeBackToLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType UpgradeChunk.writeBackToLevel()"})
  void testUpgradeChunkWriteBackToLevel() {
    // Arrange
    UpgradeChunk upgradeChunk = new UpgradeChunk(ConverterFlattenChunk.AIR);

    // Act
    MapType actualWriteBackToLevelResult = upgradeChunk.writeBackToLevel();

    // Assert
    assertSame(upgradeChunk.level, actualWriteBackToLevelResult);
  }
}
