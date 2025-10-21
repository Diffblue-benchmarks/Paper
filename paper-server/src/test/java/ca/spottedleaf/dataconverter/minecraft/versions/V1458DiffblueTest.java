package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class V1458DiffblueTest {
  /**
   * Test {@link V1458#updateCustomName(MapType)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V1458#updateCustomName(MapType)}
   */
  @Test
  @DisplayName(
      "Test updateCustomName(MapType); when JsonMapType(boolean) with compressed is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V1458.updateCustomName(MapType)"})
  void testUpdateCustomName_whenJsonMapTypeWithCompressedIsTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(V1458.updateCustomName(new JsonMapType(true)));
  }

  /**
   * Test {@link V1458#updateCustomName(MapType)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V1458#updateCustomName(MapType)}
   */
  @Test
  @DisplayName("Test updateCustomName(MapType); when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType V1458.updateCustomName(MapType)"})
  void testUpdateCustomName_whenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(V1458.updateCustomName(new NBTMapType()));
  }
}
