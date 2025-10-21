package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.minecraft.versions.V111.EntityRotationFix;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class V111DiffblueTest {
  /**
   * Test EntityRotationFix {@link EntityRotationFix#convert(MapType, long, long)} with {@code
   * data}, {@code sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRotationFix#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test EntityRotationFix convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType EntityRotationFix.convert(MapType, long, long)"})
  void testEntityRotationFixConvertWithDataSourceVersionToVersion_thenReturnNull() {
    // Arrange
    EntityRotationFix entityRotationFix = new EntityRotationFix(1);
    NBTMapType data = new NBTMapType();

    // Act and Assert
    assertNull(entityRotationFix.convert(data, 1L, 1L));
    assertEquals(1, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(1, tag.size());
    assertFalse(data.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test EntityRotationFix {@link EntityRotationFix#EntityRotationFix(int)}.
   *
   * <p>Method under test: {@link EntityRotationFix#EntityRotationFix(int)}
   */
  @Test
  @DisplayName("Test EntityRotationFix new EntityRotationFix(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRotationFix.<init>(int)"})
  void testEntityRotationFixNewEntityRotationFix() {
    // Arrange and Act
    EntityRotationFix actualEntityRotationFix = new EntityRotationFix(1);

    // Assert
    assertEquals(0, actualEntityRotationFix.getVersionStep());
    assertEquals(1, actualEntityRotationFix.getToVersion());
  }
}
