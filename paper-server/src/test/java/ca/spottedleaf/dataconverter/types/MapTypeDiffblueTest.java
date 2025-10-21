package ca.spottedleaf.dataconverter.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class MapTypeDiffblueTest {
  /**
   * Test {@link MapType#getList(String, ObjectType, ListType)} with {@code key}, {@code type},
   * {@code dfl}.
   *
   * <p>Method under test: {@link MapType#getList(String, ObjectType, ListType)}
   */
  @Test
  @DisplayName("Test getList(String, ObjectType, ListType) with 'key', 'type', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType MapType.getList(String, ObjectType, ListType)"})
  void testGetListWithKeyTypeDfl() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();
    NBTListType dfl = new NBTListType();

    // Act
    ListType actualList = nbtMapType.getList("Key", ObjectType.NONE, dfl);

    // Assert
    assertSame(dfl, actualList);
  }

  /**
   * Test {@link MapType#getList(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapType#getList(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test getList(String, ObjectType) with 'key', 'type'; given NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType MapType.getList(String, ObjectType)"})
  void testGetListWithKeyType_givenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getList("Key", ObjectType.NONE));
  }

  /**
   * Test {@link MapType#getOrCreateMap(String)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link MapType#getOrCreateMap(String)}
   */
  @Test
  @DisplayName("Test getOrCreateMap(String); given NBTMapType(); then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType MapType.getOrCreateMap(String)"})
  void testGetOrCreateMap_givenNBTMapType_thenReturnNBTMapType() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    MapType actualOrCreateMap = nbtMapType.getOrCreateMap("Key");

    // Assert
    assertTrue(actualOrCreateMap instanceof NBTMapType);
    assertTrue(actualOrCreateMap.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, actualOrCreateMap.size());
    CompoundTag tag = ((NBTMapType) actualOrCreateMap).getTag();
    assertEquals(0, tag.size());
    assertEquals(1, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(1, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
    assertTrue(actualOrCreateMap.isEmpty());
    assertTrue(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code 42}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when '42'; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_when42_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", "42");

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code A}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when 'A'; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenA_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", (byte) 'A');

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When forty-two.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when forty-two; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenFortyTwo_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", 42);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When forty-two.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when forty-two; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenFortyTwo_thenNBTMapTypeSizeIsOne2() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", 42L);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@link NBTListType#NBTListType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when NBTListType(); then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenNBTListType_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", new NBTListType());

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when NBTMapType(); then NBTMapType() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenNBTMapType_thenNBTMapTypeSizeIsZero() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();
    NBTMapType nbtMapType2 = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", nbtMapType2);

    // Assert that nothing has changed
    assertEquals(0, nbtMapType2.size());
    CompoundTag tag = nbtMapType2.getTag();
    assertEquals(0, tag.size());
    assertTrue(nbtMapType2.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When one.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when one; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenOne_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", (short) 1);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When ten.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when ten; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenTen_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", 10.0f);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When ten.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when ten; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenTen_thenNBTMapTypeSizeIsOne2() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", 10.0d);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code true}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); given NBTMapType(); when 'true'; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_givenNBTMapType_whenTrue_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setGeneric("Key", true);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>When {@link Bootstrap#bootstrapDuration}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); when bootstrapDuration; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_whenBootstrapDuration_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NBTMapType().setGeneric("Key", Bootstrap.bootstrapDuration));
  }

  /**
   * Test {@link MapType#setGeneric(String, Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MapType#setGeneric(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(String, Object); when WILDCARD_OBJECT; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapType.setGeneric(String, Object)"})
  void testSetGeneric_whenWildcard_object_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NBTMapType().setGeneric("Key", ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link MapType#getOrCreateList(String, ObjectType)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@link NBTListType}.
   * </ul>
   *
   * <p>Method under test: {@link MapType#getOrCreateList(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test getOrCreateList(String, ObjectType); given NBTMapType(); then return NBTListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType MapType.getOrCreateList(String, ObjectType)"})
  void testGetOrCreateList_givenNBTMapType_thenReturnNBTListType() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    ListType actualOrCreateList = nbtMapType.getOrCreateList("Key", ObjectType.NONE);

    // Assert
    assertTrue(actualOrCreateList instanceof NBTListType);
    assertTrue(actualOrCreateList.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, actualOrCreateList.size());
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.NONE, actualOrCreateList.getUniformType());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
    assertTrue(((NBTListType) actualOrCreateList).getTag().isEmpty());
  }
}
