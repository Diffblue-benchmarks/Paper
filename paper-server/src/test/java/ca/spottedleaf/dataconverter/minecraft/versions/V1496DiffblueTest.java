package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyByte;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.minecraft.versions.V1496.LeavesSection;
import ca.spottedleaf.dataconverter.minecraft.versions.V1496.Section;
import ca.spottedleaf.dataconverter.types.ListType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.ObjectType;
import ca.spottedleaf.dataconverter.types.TypeUtil;
import ca.spottedleaf.dataconverter.types.json.JsonListType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.json.JsonTypeUtil;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class V1496DiffblueTest {
  /**
   * Test {@link V1496#getIndex(int, int, int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return eight hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getIndex(int, int, int)}
   */
  @Test
  @DisplayName("Test getIndex(int, int, int); when eight; then return eight hundred twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getIndex(int, int, int)"})
  void testGetIndex_whenEight_thenReturnEightHundredTwentyFour() {
    // Arrange, Act and Assert
    assertEquals(824, V1496.getIndex(8, 3, 3));
  }

  /**
   * Test {@link V1496#getIndex(int, int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return eight hundred twenty.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getIndex(int, int, int)}
   */
  @Test
  @DisplayName("Test getIndex(int, int, int); when four; then return eight hundred twenty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getIndex(int, int, int)"})
  void testGetIndex_whenFour_thenReturnEightHundredTwenty() {
    // Arrange, Act and Assert
    assertEquals(820, V1496.getIndex(4, 3, 3));
  }

  /**
   * Test {@link V1496#getIndex(int, int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return eight hundred nineteen.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getIndex(int, int, int)}
   */
  @Test
  @DisplayName("Test getIndex(int, int, int); when three; then return eight hundred nineteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getIndex(int, int, int)"})
  void testGetIndex_whenThree_thenReturnEightHundredNineteen() {
    // Arrange, Act and Assert
    assertEquals(819, V1496.getIndex(3, 3, 3));
  }

  /**
   * Test {@link V1496#getIndex(int, int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return eight hundred eighteen.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getIndex(int, int, int)}
   */
  @Test
  @DisplayName("Test getIndex(int, int, int); when two; then return eight hundred eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getIndex(int, int, int)"})
  void testGetIndex_whenTwo_thenReturnEightHundredEighteen() {
    // Arrange, Act and Assert
    assertEquals(818, V1496.getIndex(2, 3, 3));
  }

  /**
   * Test {@link V1496#getX(int)}.
   *
   * <p>Method under test: {@link V1496#getX(int)}
   */
  @Test
  @DisplayName("Test getX(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getX(int)"})
  void testGetX() {
    // Arrange, Act and Assert
    assertEquals(1, V1496.getX(1));
  }

  /**
   * Test {@link V1496#getY(int)}.
   *
   * <p>Method under test: {@link V1496#getY(int)}
   */
  @Test
  @DisplayName("Test getY(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getY(int)"})
  void testGetY() {
    // Arrange, Act and Assert
    assertEquals(0, V1496.getY(1));
  }

  /**
   * Test {@link V1496#getZ(int)}.
   *
   * <p>Method under test: {@link V1496#getZ(int)}
   */
  @Test
  @DisplayName("Test getZ(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getZ(int)"})
  void testGetZ() {
    // Arrange, Act and Assert
    assertEquals(0, V1496.getZ(1));
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'false'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenFalse_thenReturnEight() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(false, true, false, true);

    // Assert
    assertEquals(8, actualSideMask);
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'false'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenFalse_thenReturnOne() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(false, false, true, true);

    // Assert
    assertEquals(1, actualSideMask);
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'false'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenFalse_thenReturnSize() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(false, false, false, true);

    // Assert
    assertEquals(Short.SIZE, actualSideMask);
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenFalse_thenReturnZero() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(false, false, false, false);

    // Assert
    assertEquals(0, actualSideMask);
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnFour() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(true, true, false, false);

    // Assert
    assertEquals(4, actualSideMask);
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return one hundred twenty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnOneHundredTwentyEight() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(true, false, true, true);

    // Assert
    assertEquals(128, actualSideMask);
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnSize() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(true, true, false, true);

    // Assert
    assertEquals(Integer.SIZE, actualSideMask);
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@link Double#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnSize2() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(true, false, false, false);

    // Assert
    assertEquals(Double.SIZE, actualSideMask);
  }

  /**
   * Test {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link V1496#getSideMask(boolean, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getSideMask(boolean, boolean, boolean, boolean); when 'true'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int V1496.getSideMask(boolean, boolean, boolean, boolean)"})
  void testGetSideMask_whenTrue_thenReturnTwo() {
    // Arrange and Act
    int actualSideMask = V1496.getSideMask(true, true, true, true);

    // Assert
    assertEquals(2, actualSideMask);
  }

  /**
   * Test LeavesSection {@link LeavesSection#initSkippable()}.
   *
   * <p>Method under test: {@link LeavesSection#initSkippable()}
   */
  @Test
  @DisplayName("Test LeavesSection initSkippable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LeavesSection.initSkippable()"})
  void testLeavesSectionInitSkippable() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new JsonListType(true));
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualInitSkippableResult = new LeavesSection(section).initSkippable();

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertTrue(actualInitSkippableResult);
  }

  /**
   * Test LeavesSection {@link LeavesSection#initSkippable()}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#initSkippable()}
   */
  @Test
  @DisplayName(
      "Test LeavesSection initSkippable(); given JsonMapType getList(String, ObjectType) return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LeavesSection.initSkippable()"})
  void testLeavesSectionInitSkippable_givenJsonMapTypeGetListReturnNBTListType() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualInitSkippableResult = new LeavesSection(section).initSkippable();

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertTrue(actualInitSkippableResult);
  }

  /**
   * Test LeavesSection {@link LeavesSection#initSkippable()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addMap {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#initSkippable()}
   */
  @Test
  @DisplayName(
      "Test LeavesSection initSkippable(); given NBTListType() addMap NBTMapType(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LeavesSection.initSkippable()"})
  void testLeavesSectionInitSkippable_givenNBTListTypeAddMapNBTMapType_thenReturnTrue() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addMap(new NBTMapType());

    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any())).thenReturn(nbtListType);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualInitSkippableResult = new LeavesSection(section).initSkippable();

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertTrue(actualInitSkippableResult);
  }

  /**
   * Test LeavesSection {@link LeavesSection#isLeaf(int)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#isLeaf(int)}
   */
  @Test
  @DisplayName(
      "Test LeavesSection isLeaf(int); given JsonMapType getList(String, ObjectType) return NBTListType(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LeavesSection.isLeaf(int)"})
  void testLeavesSectionIsLeaf_givenJsonMapTypeGetListReturnNBTListType_thenReturnFalse() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualIsLeafResult = new LeavesSection(section).isLeaf(1);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertFalse(actualIsLeafResult);
  }

  /**
   * Test LeavesSection {@link LeavesSection#isLeaf(int)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#isLeaf(int)}
   */
  @Test
  @DisplayName(
      "Test LeavesSection isLeaf(int); given JsonMapType getList(String, ObjectType) return NBTListType(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LeavesSection.isLeaf(int)"})
  void testLeavesSectionIsLeaf_givenJsonMapTypeGetListReturnNBTListType_thenReturnFalse2() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualIsLeafResult = new LeavesSection(section).isLeaf(0);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertFalse(actualIsLeafResult);
  }

  /**
   * Test LeavesSection {@link LeavesSection#isLog(int)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#isLog(int)}
   */
  @Test
  @DisplayName(
      "Test LeavesSection isLog(int); given JsonMapType getList(String, ObjectType) return NBTListType(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LeavesSection.isLog(int)"})
  void testLeavesSectionIsLog_givenJsonMapTypeGetListReturnNBTListType_thenReturnFalse() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualIsLogResult = new LeavesSection(section).isLog(1);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertFalse(actualIsLogResult);
  }

  /**
   * Test LeavesSection {@link LeavesSection#isLog(int)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#isLog(int)}
   */
  @Test
  @DisplayName(
      "Test LeavesSection isLog(int); given JsonMapType getList(String, ObjectType) return NBTListType(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LeavesSection.isLog(int)"})
  void testLeavesSectionIsLog_givenJsonMapTypeGetListReturnNBTListType_thenReturnFalse2() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualIsLogResult = new LeavesSection(section).isLog(0);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertFalse(actualIsLogResult);
  }

  /**
   * Test LeavesSection {@link LeavesSection#LeavesSection(MapType)}.
   *
   * <p>Method under test: {@link LeavesSection#LeavesSection(MapType)}
   */
  @Test
  @DisplayName("Test LeavesSection new LeavesSection(MapType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LeavesSection.<init>(MapType)"})
  void testLeavesSectionNewLeavesSection() {
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
    LeavesSection actualLeavesSection = new LeavesSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    verify(nbtListType).addByte((byte) 65);
    verify(nbtListType, atLeast(1)).getMap(anyInt());
    verify(nbtListType, atLeast(1)).size();
    assertNull(actualLeavesSection.storage);
    assertEquals(1, actualLeavesSection.getSectionY());
    assertTrue(actualLeavesSection.isSkippable());
  }

  /**
   * Test LeavesSection {@link LeavesSection#LeavesSection(MapType)}.
   *
   * <ul>
   *   <li>Given {@link NBTListType} {@link NBTListType#getMap(int)} return {@link
   *       NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#LeavesSection(MapType)}
   */
  @Test
  @DisplayName(
      "Test LeavesSection new LeavesSection(MapType); given NBTListType getMap(int) return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LeavesSection.<init>(MapType)"})
  void testLeavesSectionNewLeavesSection_givenNBTListTypeGetMapReturnNBTMapType() {
    // Arrange
    NBTListType nbtListType = mock(NBTListType.class);
    when(nbtListType.getMap(anyInt())).thenReturn(new NBTMapType());
    when(nbtListType.size()).thenReturn(3);
    doNothing().when(nbtListType).addByte(anyByte());
    nbtListType.addByte((byte) 'A');

    MapType section = mock(MapType.class);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any())).thenReturn(nbtListType);

    // Act
    LeavesSection actualLeavesSection = new LeavesSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    verify(nbtListType).addByte((byte) 65);
    verify(nbtListType, atLeast(1)).getMap(anyInt());
    verify(nbtListType, atLeast(1)).size();
    assertNull(actualLeavesSection.storage);
    assertEquals(1, actualLeavesSection.getSectionY());
    assertTrue(actualLeavesSection.isSkippable());
  }

  /**
   * Test LeavesSection {@link LeavesSection#LeavesSection(MapType)}.
   *
   * <ul>
   *   <li>Then calls {@link MapType#getString(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#LeavesSection(MapType)}
   */
  @Test
  @DisplayName(
      "Test LeavesSection new LeavesSection(MapType); then calls getString(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LeavesSection.<init>(MapType)"})
  void testLeavesSectionNewLeavesSection_thenCallsGetString() {
    // Arrange
    MapType mapType = mock(MapType.class);
    when(mapType.getString(Mockito.<String>any(), Mockito.<String>any())).thenReturn("String");

    NBTListType nbtListType = mock(NBTListType.class);
    when(nbtListType.getMap(anyInt())).thenReturn(mapType);
    when(nbtListType.size()).thenReturn(3);
    doNothing().when(nbtListType).addByte(anyByte());
    nbtListType.addByte((byte) 'A');

    MapType section = mock(MapType.class);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any())).thenReturn(nbtListType);

    // Act
    LeavesSection actualLeavesSection = new LeavesSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    verify(mapType, atLeast(1)).getString("Name", "");
    verify(nbtListType).addByte((byte) 65);
    verify(nbtListType, atLeast(1)).getMap(anyInt());
    verify(nbtListType, atLeast(1)).size();
    assertNull(actualLeavesSection.storage);
    assertEquals(1, actualLeavesSection.getSectionY());
    assertTrue(actualLeavesSection.isSkippable());
  }

  /**
   * Test LeavesSection {@link LeavesSection#LeavesSection(MapType)}.
   *
   * <ul>
   *   <li>Then {@link Section#palette} return {@link JsonListType}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#LeavesSection(MapType)}
   */
  @Test
  @DisplayName("Test LeavesSection new LeavesSection(MapType); then palette return JsonListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LeavesSection.<init>(MapType)"})
  void testLeavesSectionNewLeavesSection_thenPaletteReturnJsonListType() {
    // Arrange
    MapType section = mock(MapType.class);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new JsonListType(true));

    // Act
    LeavesSection actualLeavesSection = new LeavesSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    ListType listType = actualLeavesSection.palette;
    assertTrue(listType instanceof JsonListType);
    TypeUtil<?> typeUtil = listType.getTypeUtil();
    assertTrue(typeUtil instanceof JsonTypeUtil);
    assertEquals(0, listType.size());
    JsonArray json = ((JsonListType) listType).getJson();
    assertEquals(0, json.size());
    assertEquals(ObjectType.UNDEFINED, listType.getUniformType());
    assertFalse(json.isJsonNull());
    assertFalse(json.isJsonObject());
    assertFalse(json.isJsonPrimitive());
    assertFalse(json.iterator().hasNext());
    assertTrue(((JsonTypeUtil) typeUtil).isCompressed());
    assertTrue(json.isEmpty());
    assertTrue(json.isJsonArray());
    JsonArray actualAsJsonArray = json.getAsJsonArray();
    assertSame(json, actualAsJsonArray);
  }

  /**
   * Test LeavesSection {@link LeavesSection#LeavesSection(MapType)}.
   *
   * <ul>
   *   <li>Then return {@link Section#palette} Tag size is one.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#LeavesSection(MapType)}
   */
  @Test
  @DisplayName("Test LeavesSection new LeavesSection(MapType); then return palette Tag size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LeavesSection.<init>(MapType)"})
  void testLeavesSectionNewLeavesSection_thenReturnPaletteTagSizeIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addMap(new NBTMapType());

    MapType section = mock(MapType.class);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any())).thenReturn(nbtListType);

    // Act
    LeavesSection actualLeavesSection = new LeavesSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    ListType listType = actualLeavesSection.palette;
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
   * Test LeavesSection {@link LeavesSection#LeavesSection(MapType)}.
   *
   * <ul>
   *   <li>Then return {@link Section#palette} UniformType is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link LeavesSection#LeavesSection(MapType)}
   */
  @Test
  @DisplayName(
      "Test LeavesSection new LeavesSection(MapType); then return palette UniformType is 'NONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LeavesSection.<init>(MapType)"})
  void testLeavesSectionNewLeavesSection_thenReturnPaletteUniformTypeIsNone() {
    // Arrange
    MapType section = mock(MapType.class);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());

    // Act
    LeavesSection actualLeavesSection = new LeavesSection(section);

    // Assert
    verify(section).getInt("Y");
    verify(section).getList("Palette", ObjectType.MAP);
    ListType listType = actualLeavesSection.palette;
    assertTrue(listType instanceof NBTListType);
    assertEquals(0, listType.size());
    assertEquals(ObjectType.NONE, listType.getUniformType());
    assertTrue(((NBTListType) listType).getTag().isEmpty());
  }

  /**
   * Test Section {@link Section#getSectionY()}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Section#getSectionY()}
   */
  @Test
  @DisplayName(
      "Test Section getSectionY(); given JsonMapType getList(String, ObjectType) return NBTListType(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Section.getSectionY()"})
  void testSectionGetSectionY_givenJsonMapTypeGetListReturnNBTListType_thenReturnOne() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    int actualSectionY = new LeavesSection(section).getSectionY();

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertEquals(1, actualSectionY);
  }

  /**
   * Test Section {@link Section#getStateId(String, boolean, int)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Section#getStateId(String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test Section getStateId(String, boolean, int); given JsonMapType getList(String, ObjectType) return NBTListType(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Section.getStateId(String, boolean, int)"})
  void testSectionGetStateId_givenJsonMapTypeGetListReturnNBTListType_thenReturnOne() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    int actualStateId = new LeavesSection(section).getStateId("Name", false, 1);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertEquals(1, actualStateId);
  }

  /**
   * Test Section {@link Section#getStateId(String, boolean, int)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return seventeen.
   * </ul>
   *
   * <p>Method under test: {@link Section#getStateId(String, boolean, int)}
   */
  @Test
  @DisplayName("Test Section getStateId(String, boolean, int); when '42'; then return seventeen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Section.getStateId(String, boolean, int)"})
  void testSectionGetStateId_when42_thenReturnSeventeen() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    int actualStateId = new LeavesSection(section).getStateId("42", true, 1);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertEquals(17, actualStateId);
  }

  /**
   * Test Section {@link Section#getStateId(String, boolean, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Section#getStateId(String, boolean, int)}
   */
  @Test
  @DisplayName("Test Section getStateId(String, boolean, int); when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Section.getStateId(String, boolean, int)"})
  void testSectionGetStateId_whenNull_thenReturnOne() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    int actualStateId = new LeavesSection(section).getStateId(null, false, 1);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertEquals(1, actualStateId);
  }

  /**
   * Test Section {@link Section#getStateId(String, boolean, int)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return seventeen.
   * </ul>
   *
   * <p>Method under test: {@link Section#getStateId(String, boolean, int)}
   */
  @Test
  @DisplayName("Test Section getStateId(String, boolean, int); when 'true'; then return seventeen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Section.getStateId(String, boolean, int)"})
  void testSectionGetStateId_whenTrue_thenReturnSeventeen() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    int actualStateId = new LeavesSection(section).getStateId("Name", true, 1);

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertEquals(17, actualStateId);
  }

  /**
   * Test Section {@link Section#isSkippable()}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Section#isSkippable()}
   */
  @Test
  @DisplayName(
      "Test Section isSkippable(); given JsonMapType getList(String, ObjectType) return NBTListType(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Section.isSkippable()"})
  void testSectionIsSkippable_givenJsonMapTypeGetListReturnNBTListType_thenReturnTrue() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);

    // Act
    boolean actualIsSkippableResult = new LeavesSection(section).isSkippable();

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
    assertTrue(actualIsSkippableResult);
  }

  /**
   * Test Section {@link Section#readStorage(MapType)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then calls {@link JsonMapType#getList(String, ObjectType)}.
   * </ul>
   *
   * <p>Method under test: {@link Section#readStorage(MapType)}
   */
  @Test
  @DisplayName(
      "Test Section readStorage(MapType); given JsonMapType getList(String, ObjectType) return NBTListType(); then calls getList(String, ObjectType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Section.readStorage(MapType)"})
  void testSectionReadStorage_givenJsonMapTypeGetListReturnNBTListType_thenCallsGetList() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    LeavesSection leavesSection = new LeavesSection(section);

    // Act
    leavesSection.readStorage(new NBTMapType());

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
  }

  /**
   * Test Section {@link Section#readStorage(MapType)}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addMap {@link NBTMapType#NBTMapType()}.
   *   <li>Then calls {@link JsonMapType#getList(String, ObjectType)}.
   * </ul>
   *
   * <p>Method under test: {@link Section#readStorage(MapType)}
   */
  @Test
  @DisplayName(
      "Test Section readStorage(MapType); given NBTListType() addMap NBTMapType(); then calls getList(String, ObjectType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Section.readStorage(MapType)"})
  void testSectionReadStorage_givenNBTListTypeAddMapNBTMapType_thenCallsGetList() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addMap(new NBTMapType());

    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any())).thenReturn(nbtListType);
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    LeavesSection leavesSection = new LeavesSection(section);

    // Act
    leavesSection.readStorage(new NBTMapType());

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
  }

  /**
   * Test Section {@link Section#writeInto(MapType)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getList(String, ObjectType)} return {@link
   *       NBTListType#NBTListType()}.
   *   <li>Then calls {@link JsonMapType#getList(String, ObjectType)}.
   * </ul>
   *
   * <p>Method under test: {@link Section#writeInto(MapType)}
   */
  @Test
  @DisplayName(
      "Test Section writeInto(MapType); given JsonMapType getList(String, ObjectType) return NBTListType(); then calls getList(String, ObjectType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Section.writeInto(MapType)"})
  void testSectionWriteInto_givenJsonMapTypeGetListReturnNBTListType_thenCallsGetList() {
    // Arrange
    JsonMapType section = mock(JsonMapType.class);
    when(section.getList(Mockito.<String>any(), Mockito.<ObjectType>any()))
        .thenReturn(new NBTListType());
    when(section.getInt(Mockito.<String>any())).thenReturn(1);
    LeavesSection leavesSection = new LeavesSection(section);

    // Act
    leavesSection.writeInto(new NBTMapType());

    // Assert
    verify(section).getList("Palette", ObjectType.MAP);
    verify(section).getInt("Y");
  }
}
