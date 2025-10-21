package ca.spottedleaf.dataconverter.minecraft.converters.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AddFlagIfAbsentDiffblueTest {
  /**
   * Test {@link AddFlagIfAbsent#AddFlagIfAbsent(int, int, String, boolean)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link AddFlagIfAbsent#AddFlagIfAbsent(int, int, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddFlagIfAbsent(int, int, String, boolean); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddFlagIfAbsent.<init>(int, int, String, boolean)",
    "void AddFlagIfAbsent.<init>(int, String, boolean)"
  })
  void testNewAddFlagIfAbsent_thenReturnVersionStepIsOne() {
    // Arrange and Act
    AddFlagIfAbsent actualAddFlagIfAbsent = new AddFlagIfAbsent(1, 1, "Path", true);

    // Assert
    assertEquals(1, actualAddFlagIfAbsent.getToVersion());
    assertEquals(1, actualAddFlagIfAbsent.getVersionStep());
  }

  /**
   * Test {@link AddFlagIfAbsent#AddFlagIfAbsent(int, String, boolean)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link AddFlagIfAbsent#AddFlagIfAbsent(int, String, boolean)}
   */
  @Test
  @DisplayName("Test new AddFlagIfAbsent(int, String, boolean); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddFlagIfAbsent.<init>(int, int, String, boolean)",
    "void AddFlagIfAbsent.<init>(int, String, boolean)"
  })
  void testNewAddFlagIfAbsent_thenReturnVersionStepIsZero() {
    // Arrange and Act
    AddFlagIfAbsent actualAddFlagIfAbsent = new AddFlagIfAbsent(1, "Path", true);

    // Assert
    assertEquals(0, actualAddFlagIfAbsent.getVersionStep());
    assertEquals(1, actualAddFlagIfAbsent.getToVersion());
  }

  /**
   * Test {@link AddFlagIfAbsent#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddFlagIfAbsent#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType AddFlagIfAbsent.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    AddFlagIfAbsent addFlagIfAbsent = new AddFlagIfAbsent(1, "Path", true);
    NBTMapType data = new NBTMapType();

    // Act and Assert
    assertNull(addFlagIfAbsent.convert(data, 1L, 1L));
    assertEquals(1, data.size());
    CompoundTag tag = data.getTag();
    assertEquals(1, tag.size());
    assertFalse(data.isEmpty());
    assertFalse(tag.isEmpty());
  }
}
