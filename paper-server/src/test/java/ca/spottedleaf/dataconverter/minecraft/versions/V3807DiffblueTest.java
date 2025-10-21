package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class V3807DiffblueTest {
  /**
   * Test {@link V3807#flattenBlockPos(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@link MapType} {@link MapType#getMap(String)} return {@link
   *       NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link V3807#flattenBlockPos(MapType, String)}
   */
  @Test
  @DisplayName(
      "Test flattenBlockPos(MapType, String); given NBTMapType(); when MapType getMap(String) return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V3807.flattenBlockPos(MapType, String)"})
  void testFlattenBlockPos_givenNBTMapType_whenMapTypeGetMapReturnNBTMapType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    // Act
    V3807.flattenBlockPos(data, "Path");

    // Assert
    verify(data).getMap("Path");
  }

  /**
   * Test {@link V3807#flattenBlockPos(MapType, String)}.
   *
   * <ul>
   *   <li>Then calls {@link MapType#setInts(String, int[])}.
   * </ul>
   *
   * <p>Method under test: {@link V3807#flattenBlockPos(MapType, String)}
   */
  @Test
  @DisplayName("Test flattenBlockPos(MapType, String); then calls setInts(String, int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V3807.flattenBlockPos(MapType, String)"})
  void testFlattenBlockPos_thenCallsSetInts() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getNumber(Mockito.<String>any())).thenReturn(Bootstrap.bootstrapDuration);

    MapType data = mock(MapType.class);
    doNothing().when(data).setInts(Mockito.<String>any(), Mockito.<int[]>any());
    when(data.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    // Act
    V3807.flattenBlockPos(data, "Path");

    // Assert
    verify(data).getMap("Path");
    verify(data).setInts(eq("Path"), isA(int[].class));
    verify(jsonMapType, atLeast(1)).getNumber(Mockito.<String>any());
  }
}
