package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyByte;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.minecraft.versions.V1496.Section;
import ca.spottedleaf.dataconverter.minecraft.versions.V1624.TrappedChestSection;
import ca.spottedleaf.dataconverter.types.ListType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.ObjectType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class V1624DiffblueTest {
  /**
   * Test TrappedChestSection {@link TrappedChestSection#initSkippable()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addMap {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link TrappedChestSection#initSkippable()}
   */
  @Test
  @DisplayName("Test TrappedChestSection initSkippable(); given NBTListType() addMap NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrappedChestSection.initSkippable()"})
  void testTrappedChestSectionInitSkippable_givenNBTListTypeAddMapNBTMapType() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addMap(new NBTMapType());

    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any())).thenReturn(nbtListType);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualInitSkippableResult = new TrappedChestSection(section).initSkippable();

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertTrue(actualInitSkippableResult);
  }

  /**
   * Test TrappedChestSection {@link TrappedChestSection#initSkippable()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TrappedChestSection#initSkippable()}
   */
  @Test
  @DisplayName("Test TrappedChestSection initSkippable(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrappedChestSection.initSkippable()"})
  void testTrappedChestSectionInitSkippable_thenReturnTrue() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualInitSkippableResult = new TrappedChestSection(section).initSkippable();

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertTrue(actualInitSkippableResult);
  }

  /**
   * Test TrappedChestSection {@link TrappedChestSection#isTrappedChest(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrappedChestSection#isTrappedChest(int)}
   */
  @Test
  @DisplayName("Test TrappedChestSection isTrappedChest(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrappedChestSection.isTrappedChest(int)"})
  void testTrappedChestSectionIsTrappedChest_thenReturnFalse() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualIsTrappedChestResult = new TrappedChestSection(section).isTrappedChest(1);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertFalse(actualIsTrappedChestResult);
  }

  /**
   * Test TrappedChestSection {@link TrappedChestSection#isTrappedChest(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrappedChestSection#isTrappedChest(int)}
   */
  @Test
  @DisplayName("Test TrappedChestSection isTrappedChest(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrappedChestSection.isTrappedChest(int)"})
  void testTrappedChestSectionIsTrappedChest_thenReturnFalse2() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualIsTrappedChestResult = new TrappedChestSection(section).isTrappedChest(0);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertFalse(actualIsTrappedChestResult);
  }

  /**
   * Test TrappedChestSection {@link TrappedChestSection#TrappedChestSection(MapType)}.
   *
   * <ul>
   *   <li>Then return {@link Section#palette} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrappedChestSection#TrappedChestSection(MapType)}
   */
  @Test
  @DisplayName(
      "Test TrappedChestSection new TrappedChestSection(MapType); then return palette size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrappedChestSection.<init>(MapType)"})
  void testTrappedChestSectionNewTrappedChestSection_thenReturnPaletteSizeIsZero() {
    // Arrange
    MapType section = mock(MapType.class);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());

    // Act
    TrappedChestSection actualTrappedChestSection = new TrappedChestSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    ListType listType = actualTrappedChestSection.palette;
    assertTrue(listType instanceof NBTListType);
    assertEquals(0, listType.size());
    assertEquals(ObjectType.NONE, listType.getUniformType());
    assertTrue(((NBTListType) listType).getTag().isEmpty());
  }

  /**
   * Test TrappedChestSection {@link TrappedChestSection#TrappedChestSection(MapType)}.
   *
   * <ul>
   *   <li>Then return {@link Section#palette} Tag size is one.
   * </ul>
   *
   * <p>Method under test: {@link TrappedChestSection#TrappedChestSection(MapType)}
   */
  @Test
  @DisplayName(
      "Test TrappedChestSection new TrappedChestSection(MapType); then return palette Tag size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrappedChestSection.<init>(MapType)"})
  void testTrappedChestSectionNewTrappedChestSection_thenReturnPaletteTagSizeIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addMap(new NBTMapType());

    MapType section = mock(MapType.class);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any())).thenReturn(nbtListType);

    // Act
    TrappedChestSection actualTrappedChestSection = new TrappedChestSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    ListType listType = actualTrappedChestSection.palette;
    assertTrue(listType instanceof NBTListType);
    ListTag tag = ((NBTListType) listType).getTag();
    assertEquals(1, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(0);
    assertEquals(0, ((CompoundTag) getResult).size());
    assertEquals(1, listType.size());
    assertEquals(ObjectType.MAP, listType.getUniformType());
    assertTrue(((CompoundTag) getResult).isEmpty());
    assertEquals('\n', getResult.getId());
  }

  /**
   * Test TrappedChestSection {@link TrappedChestSection#TrappedChestSection(MapType)}.
   *
   * <ul>
   *   <li>Then return {@link Section#storage} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrappedChestSection#TrappedChestSection(MapType)}
   */
  @Test
  @DisplayName(
      "Test TrappedChestSection new TrappedChestSection(MapType); then return storage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrappedChestSection.<init>(MapType)"})
  void testTrappedChestSectionNewTrappedChestSection_thenReturnStorageIsNull() {
    // Arrange
    NBTListType nbtListType = mock(NBTListType.class);
    when(nbtListType.getMap(anyInt())).thenReturn(new JsonMapType(true));
    when(nbtListType.size()).thenReturn(3);
    doNothing().when(nbtListType).addByte(anyByte());
    nbtListType.addByte((byte) 'A');

    MapType section = mock(MapType.class);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any())).thenReturn(nbtListType);

    // Act
    TrappedChestSection actualTrappedChestSection = new TrappedChestSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    verify(nbtListType).addByte((byte) 65);
    verify(nbtListType, atLeast(1)).getMap(anyInt());
    verify(nbtListType, atLeast(1)).size();
    assertNull(actualTrappedChestSection.storage);
    assertEquals(1, actualTrappedChestSection.getSectionY());
    assertTrue(actualTrappedChestSection.isSkippable());
  }
}
