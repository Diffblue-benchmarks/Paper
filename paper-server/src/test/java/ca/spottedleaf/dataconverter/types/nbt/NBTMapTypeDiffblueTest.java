package ca.spottedleaf.dataconverter.types.nbt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.types.ListType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.ObjectType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.EndTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NBTMapTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NBTMapType#NBTMapType(CompoundTag)}
   *   <li>{@link NBTMapType#toString()}
   *   <li>{@link NBTMapType#getTag()}
   *   <li>{@link NBTMapType#getTypeUtil()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NBTMapType.<init>(CompoundTag)",
    "CompoundTag NBTMapType.getTag()",
    "ca.spottedleaf.dataconverter.types.TypeUtil NBTMapType.getTypeUtil()",
    "String NBTMapType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    CompoundTag tag = new CompoundTag();

    // Act
    NBTMapType actualNbtMapType = new NBTMapType(tag);
    String actualToStringResult = actualNbtMapType.toString();
    CompoundTag actualTag = actualNbtMapType.getTag();

    // Assert
    assertTrue(actualNbtMapType.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals("NBTMapType{map={}}", actualToStringResult);
    assertSame(tag, actualTag);
  }

  /**
   * Test {@link NBTMapType#NBTMapType()}.
   *
   * <p>Method under test: {@link NBTMapType#NBTMapType()}
   */
  @Test
  @DisplayName("Test new NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.<init>()"})
  void testNewNBTMapType() {
    // Arrange and Act
    NBTMapType actualNbtMapType = new NBTMapType();

    // Assert
    assertTrue(actualNbtMapType.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, actualNbtMapType.size());
    CompoundTag tag = actualNbtMapType.getTag();
    assertEquals(0, tag.size());
    assertTrue(actualNbtMapType.isEmpty());
    assertTrue(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link NBTMapType#equals(Object)}, and {@link NBTMapType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NBTMapType#equals(Object)}
   *   <li>{@link NBTMapType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.equals(Object)", "int NBTMapType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();
    NBTMapType nbtMapType2 = new NBTMapType();

    // Act and Assert
    assertEquals(nbtMapType, nbtMapType2);
    assertEquals(nbtMapType.hashCode(), nbtMapType2.hashCode());
  }

  /**
   * Test {@link NBTMapType#equals(Object)}, and {@link NBTMapType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NBTMapType#equals(Object)}
   *   <li>{@link NBTMapType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.equals(Object)", "int NBTMapType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act and Assert
    assertEquals(nbtMapType, nbtMapType);
    int expectedHashCodeResult = nbtMapType.hashCode();
    assertEquals(expectedHashCodeResult, nbtMapType.hashCode());
  }

  /**
   * Test {@link NBTMapType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.equals(Object)", "int NBTMapType.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NBTMapType(), null);
  }

  /**
   * Test {@link NBTMapType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.equals(Object)", "int NBTMapType.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NBTMapType(), "Different type to NBTMapType");
  }

  /**
   * Test {@link NBTMapType#size()}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#size()}
   */
  @Test
  @DisplayName("Test size(); given NBTMapType(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.size()"})
  void testSize_givenNBTMapType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new NBTMapType().size());
  }

  /**
   * Test {@link NBTMapType#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given CompoundTag() 'Key' is ONE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.isEmpty()"})
  void testIsEmpty_givenCompoundTagKeyIsOne_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).isEmpty());
  }

  /**
   * Test {@link NBTMapType#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given NBTMapType(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.isEmpty()"})
  void testIsEmpty_givenNBTMapType_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new NBTMapType().isEmpty());
  }

  /**
   * Test {@link NBTMapType#clear()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#clear()}
   */
  @Test
  @DisplayName(
      "Test clear(); given CompoundTag() 'Key' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.clear()"})
  void testClear_givenCompoundTagKeyIsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.clear();

    // Assert
    assertEquals(0, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(0, tag2.size());
    assertTrue(nbtMapType.isEmpty());
    assertTrue(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#clear()}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#clear()}
   */
  @Test
  @DisplayName("Test clear(); given NBTMapType(); then NBTMapType() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.clear()"})
  void testClear_givenNBTMapType_thenNBTMapTypeSizeIsZero() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.clear();

    // Assert that nothing has changed
    assertEquals(0, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(0, tag.size());
    assertTrue(nbtMapType.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#keys()}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#keys()}
   */
  @Test
  @DisplayName("Test keys(); given NBTMapType(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set NBTMapType.keys()"})
  void testKeys_givenNBTMapType_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new NBTMapType().keys().isEmpty());
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy() throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putByteArray("net.minecraft.nbt.CompoundTag", "AXAXAXAX".getBytes("UTF-8"));
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given CompoundTag() '42' is ONE; then return NBTMapType(CompoundTag) with tag is CompoundTag()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenCompoundTag42IsOne_thenReturnNBTMapTypeWithTagIsCompoundTag() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.putShort("net.minecraft.nbt.CompoundTag", (short) 0);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Double {@code CompoundTag} is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given CompoundTag() Double 'net.minecraft.nbt.CompoundTag' is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenCompoundTagDoubleNetMinecraftNbtCompoundTagIs05() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putDouble("net.minecraft.nbt.CompoundTag", 0.5d);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Float {@code CompoundTag} is {@code 0.8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given CompoundTag() Float 'net.minecraft.nbt.CompoundTag' is '0.8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenCompoundTagFloatNetMinecraftNbtCompoundTagIs08() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putFloat("net.minecraft.nbt.CompoundTag", 0.8f);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Int {@code CompoundTag} is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given CompoundTag() Int 'net.minecraft.nbt.CompoundTag' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenCompoundTagIntNetMinecraftNbtCompoundTagIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putInt("net.minecraft.nbt.CompoundTag", 1);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given CompoundTag() 'Key' is ONE; then return NBTMapType(CompoundTag) with tag is CompoundTag()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenCompoundTagKeyIsOne_thenReturnNBTMapTypeWithTagIsCompoundTag() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Long {@code CompoundTag} is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given CompoundTag() Long 'net.minecraft.nbt.CompoundTag' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenCompoundTagLongNetMinecraftNbtCompoundTagIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putLong("net.minecraft.nbt.CompoundTag", 1L);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code CompoundTag} is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given CompoundTag() Short 'net.minecraft.nbt.CompoundTag' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenCompoundTagShortNetMinecraftNbtCompoundTagIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("net.minecraft.nbt.CompoundTag", (short) 0);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} String {@code CompoundTag} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given CompoundTag() String 'net.minecraft.nbt.CompoundTag' is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenCompoundTagStringNetMinecraftNbtCompoundTagIsValue() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putString("net.minecraft.nbt.CompoundTag", "Value");
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given NBTMapType(); then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.copy()"})
  void testCopy_givenNBTMapType_thenReturnNBTMapType() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    MapType actualCopyResult = nbtMapType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTMapType);
    assertEquals(nbtMapType, actualCopyResult);
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName("Test hasKey(String, ObjectType) with 'key', 'type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putLongArray("Key", new long[] {42L, 1L, 42L, 1L});
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() '42' is ONE; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTag42IsOne_whenKey_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} ByteArray {@code Key} is {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() ByteArray 'Key' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagByteArrayKeyIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putByteArray("Key", "AXAXAXAX".getBytes("UTF-8"));
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Double {@code Key} is {@code -0.5}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() Double 'Key' is '-0.5'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagDoubleKeyIs05_whenKey_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putDouble("Key", -0.5d);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Float {@code Key} is {@code 0.5}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() Float 'Key' is '0.5'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagFloatKeyIs05_whenKey_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putFloat("Key", 0.5f);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} IntArray {@code Key} is array of {@code int} with
   *       forty-two and one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() IntArray 'Key' is array of int with forty-two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagIntArrayKeyIsArrayOfIntWithFortyTwoAndOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putIntArray("Key", new int[] {42, 1, 42, 1});
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Int {@code Key} is zero.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() Int 'Key' is zero; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagIntKeyIsZero_whenKey_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putInt("Key", 0);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() 'Key' is ONE; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagKeyIsOne_whenKey_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() 'Key' is ONE; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagKeyIsOne_whenKey_thenReturnFalse2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Long {@code Key} is zero.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() Long 'Key' is zero; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagLongKeyIsZero_whenKey_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putLong("Key", 0L);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() Short 'Key' is eight; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagShortKeyIsEight_whenKey_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} String {@code Key} is {@code CompoundTag}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given CompoundTag() String 'Key' is 'net.minecraft.nbt.CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenCompoundTagStringKeyIsNetMinecraftNbtCompoundTag() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putString("Key", "net.minecraft.nbt.CompoundTag");
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given NBTMapType(); when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenNBTMapType_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NBTMapType().hasKey("Key", ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String, ObjectType)} with {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String, ObjectType) with 'key', 'type'; given NBTMapType(); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String, ObjectType)"})
  void testHasKeyWithKeyType_givenNBTMapType_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NBTMapType().hasKey(null, ObjectType.NONE));
  }

  /**
   * Test {@link NBTMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given CompoundTag() '42' is ONE; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String)"})
  void testHasKeyWithKey_givenCompoundTag42IsOne_whenKey_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).hasKey("Key"));
  }

  /**
   * Test {@link NBTMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given CompoundTag() '42' is ONE; when 'Key'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String)"})
  void testHasKeyWithKey_givenCompoundTag42IsOne_whenKey_thenReturnTrue() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertTrue(new NBTMapType(tag).hasKey("Key"));
  }

  /**
   * Test {@link NBTMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given CompoundTag() 'Key' is ONE; when 'Key'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String)"})
  void testHasKeyWithKey_givenCompoundTagKeyIsOne_whenKey_thenReturnTrue() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertTrue(new NBTMapType(tag).hasKey("Key"));
  }

  /**
   * Test {@link NBTMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given NBTMapType(); when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String)"})
  void testHasKeyWithKey_givenNBTMapType_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NBTMapType().hasKey("Key"));
  }

  /**
   * Test {@link NBTMapType#hasKey(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#hasKey(String)}
   */
  @Test
  @DisplayName(
      "Test hasKey(String) with 'key'; given NBTMapType(); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.hasKey(String)"})
  void testHasKeyWithKey_givenNBTMapType_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NBTMapType().hasKey(null));
  }

  /**
   * Test {@link NBTMapType#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.remove(String)"})
  void testRemove_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.remove("Key");

    // Assert that nothing has changed
    assertEquals(1, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(1, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.remove(String)"})
  void testRemove_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.remove("Key");

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(1, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); given CompoundTag() 'Key' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.remove(String)"})
  void testRemove_givenCompoundTagKeyIsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.remove("Key");

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(1, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#remove(String)}
   */
  @Test
  @DisplayName(
      "Test remove(String); given CompoundTag() 'Key' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.remove(String)"})
  void testRemove_givenCompoundTagKeyIsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.remove("Key");

    // Assert
    assertEquals(0, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(0, tag2.size());
    assertTrue(nbtMapType.isEmpty());
    assertTrue(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#remove(String)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#remove(String)}
   */
  @Test
  @DisplayName("Test remove(String); given NBTMapType(); then NBTMapType() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.remove(String)"})
  void testRemove_givenNBTMapType_thenNBTMapTypeSizeIsZero() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.remove("Key");

    // Assert that nothing has changed
    assertEquals(0, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(0, tag.size());
    assertTrue(nbtMapType.isEmpty());
    assertTrue(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() '42' is ONE; when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTag42IsOne_whenKey_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getGeneric("Key"));
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link CompoundTag#CompoundTag()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is CompoundTag(); when 'Key'; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsCompoundTag_whenKey_thenReturnNBTMapType() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    CompoundTag value = new CompoundTag();
    tag.put("Key", value);

    // Act
    Object actualGeneric = new NBTMapType(tag).getGeneric("Key");

    // Assert
    assertTrue(actualGeneric instanceof NBTMapType);
    assertTrue(((NBTMapType) actualGeneric).getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, ((NBTMapType) actualGeneric).size());
    assertTrue(((NBTMapType) actualGeneric).isEmpty());
    assertSame(value, ((NBTMapType) actualGeneric).getTag());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link EndTag#INSTANCE}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is INSTANCE; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsInstance_thenThrowIllegalStateException() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", EndTag.INSTANCE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new NBTMapType(tag).getGeneric("Key"));
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ListTag#ListTag()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@link NBTListType}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is ListTag(); when 'Key'; then return NBTListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsListTag_whenKey_thenReturnNBTListType() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    ListTag value = new ListTag();
    tag.put("Key", value);

    // Act
    Object actualGeneric = new NBTMapType(tag).getGeneric("Key");

    // Assert
    assertTrue(actualGeneric instanceof NBTListType);
    assertTrue(((NBTListType) actualGeneric).getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, ((NBTListType) actualGeneric).size());
    assertEquals(ObjectType.NONE, ((NBTListType) actualGeneric).getUniformType());
    ListTag tag2 = ((NBTListType) actualGeneric).getTag();
    assertTrue(tag2.isEmpty());
    assertSame(value, tag2);
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is ONE; when 'Key'; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsOne_whenKey_thenReturnByteValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 1, ((Byte) new NBTMapType(tag).getGeneric("Key")).byteValue());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>When {@code Key}.
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is ONE; when 'Key'; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsOne_whenKey_thenReturnByteValueIsOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 1, ((Byte) new NBTMapType(tag).getGeneric("Key")).byteValue());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>When {@code Key}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is valueOf one; when 'Key'; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsValueOfOne_whenKey_thenReturnIntValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1, ((Integer) new NBTMapType(tag).getGeneric("Key")).intValue());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>When {@code Key}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is valueOf one; when 'Key'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsValueOfOne_whenKey_thenReturnLongValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1L, ((Long) new NBTMapType(tag).getGeneric("Key")).longValue());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>When {@code Key}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is ZERO; when 'Key'; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsZero_whenKey_thenReturnDoubleValueIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0.0d, ((Double) new NBTMapType(tag).getGeneric("Key")).doubleValue());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>When {@code Key}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() 'Key' is ZERO; when 'Key'; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagKeyIsZero_whenKey_thenReturnFloatValueIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0.0f, ((Float) new NBTMapType(tag).getGeneric("Key")).floatValue());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return shortValue is eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(String); given CompoundTag() Short 'Key' is eight; then return shortValue is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenCompoundTagShortKeyIsEight_thenReturnShortValueIsEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 8, ((Short) new NBTMapType(tag).getGeneric("Key")).shortValue());
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName("Test getGeneric(String); given NBTMapType(); when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenNBTMapType_whenKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getGeneric("Key"));
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName("Test getGeneric(String); given NBTMapType(); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_givenNBTMapType_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getGeneric(null));
  }

  /**
   * Test {@link NBTMapType#getGeneric(String)}.
   *
   * <ul>
   *   <li>Then return {@code CompoundTag}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getGeneric(String)}
   */
  @Test
  @DisplayName("Test getGeneric(String); then return 'net.minecraft.nbt.CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTMapType.getGeneric(String)"})
  void testGetGeneric_thenReturnNetMinecraftNbtCompoundTag() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putString("Key", "net.minecraft.nbt.CompoundTag");
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals("net.minecraft.nbt.CompoundTag", new NBTMapType(tag).getGeneric("Key"));
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@link Bootstrap#bootstrapDuration}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return bootstrapDuration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenCompoundTag42IsOne_thenReturnBootstrapDuration() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = new NBTMapType(tag).getNumber("Key", dfl);

    // Assert
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnByteValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(
        (byte) 1, new NBTMapType(tag).getNumber("Key", Bootstrap.bootstrapDuration).byteValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnByteValueIsOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(
        (byte) 1, new NBTMapType(tag).getNumber("Key", Bootstrap.bootstrapDuration).byteValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnIntValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getNumber("Key", Bootstrap.bootstrapDuration).intValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnLongValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getNumber("Key", Bootstrap.bootstrapDuration).longValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnDoubleValueIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(
        0.0d, new NBTMapType(tag).getNumber("Key", Bootstrap.bootstrapDuration).doubleValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnFloatValueIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(
        0.0f, new NBTMapType(tag).getNumber("Key", Bootstrap.bootstrapDuration).floatValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@link Bootstrap#bootstrapDuration}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String, Number) with 'key', 'dfl'; given NBTMapType(); then return bootstrapDuration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_givenNBTMapType_thenReturnBootstrapDuration() {
    // Arrange
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = new NBTMapType().getNumber("Key", dfl);

    // Assert
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link NBTMapType#getNumber(String, Number)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return shortValue is eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String, Number)}
   */
  @Test
  @DisplayName("Test getNumber(String, Number) with 'key', 'dfl'; then return shortValue is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String, Number)"})
  void testGetNumberWithKeyDfl_thenReturnShortValueIsEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(
        (short) 8, new NBTMapType(tag).getNumber("Key", Bootstrap.bootstrapDuration).shortValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenCompoundTag42IsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getNumber("Key"));
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given CompoundTag() 'Key' is ONE; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenCompoundTagKeyIsOne_thenReturnByteValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getNumber("Key").byteValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return byteValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given CompoundTag() 'Key' is ONE; then return byteValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenCompoundTagKeyIsOne_thenReturnByteValueIsOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getNumber("Key").byteValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnIntValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getNumber("Key").intValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnLongValueIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getNumber("Key").longValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenCompoundTagKeyIsZero_thenReturnDoubleValueIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0.0d, new NBTMapType(tag).getNumber("Key").doubleValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenCompoundTagKeyIsZero_thenReturnFloatValueIsZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0.0f, new NBTMapType(tag).getNumber("Key").floatValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return shortValue is eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName(
      "Test getNumber(String) with 'key'; given CompoundTag() Short 'Key' is eight; then return shortValue is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenCompoundTagShortKeyIsEight_thenReturnShortValueIsEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 8, new NBTMapType(tag).getNumber("Key").shortValue());
  }

  /**
   * Test {@link NBTMapType#getNumber(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'key'; given NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTMapType.getNumber(String)"})
  void testGetNumberWithKey_givenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getNumber("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String, boolean)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'key', 'dfl'; given NBTMapType(); when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String, boolean)"})
  void testGetBooleanWithKeyDfl_givenNBTMapType_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new NBTMapType().getBoolean("Key", true));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given CompoundTag() '42' is ONE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenCompoundTag42IsOne_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertFalse(new NBTMapType(tag).getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenCompoundTagKeyIsOne_thenReturnTrue() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertTrue(new NBTMapType(tag).getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenCompoundTagKeyIsOne_thenReturnTrue2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertTrue(new NBTMapType(tag).getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnTrue() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertTrue(new NBTMapType(tag).getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnTrue2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertTrue(new NBTMapType(tag).getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenCompoundTagKeyIsZero_thenReturnFalse() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertFalse(new NBTMapType(tag).getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenCompoundTagKeyIsZero_thenReturnFalse2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertFalse(new NBTMapType(tag).getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'key'; given CompoundTag() Short 'Key' is eight; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenCompoundTagShortKeyIsEight_thenReturnTrue() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertTrue(new NBTMapType(tag).getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#getBoolean(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBoolean(String)}
   */
  @Test
  @DisplayName("Test getBoolean(String) with 'key'; given NBTMapType(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTMapType.getBoolean(String)"})
  void testGetBooleanWithKey_givenNBTMapType_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NBTMapType().getBoolean("Key"));
  }

  /**
   * Test {@link NBTMapType#setBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code true}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean); given NBTMapType(); when 'true'; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setBoolean(String, boolean)"})
  void testSetBoolean_givenNBTMapType_whenTrue_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setBoolean("Key", true);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenCompoundTag42IsOne_thenReturnA() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals('A', new NBTMapType(tag).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals((byte) 0, new NBTMapType(tag).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals((byte) 0, new NBTMapType(tag).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return backspace.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(String, byte) with 'key', 'dfl'; given CompoundTag() Short 'Key' is eight; then return backspace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenCompoundTagShortKeyIsEight_thenReturnBackspace() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals('\b', new NBTMapType(tag).getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String, byte)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String, byte)}
   */
  @Test
  @DisplayName("Test getByte(String, byte) with 'key', 'dfl'; given NBTMapType(); then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String, byte)"})
  void testGetByteWithKeyDfl_givenNBTMapType_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', new NBTMapType().getByte("Key", (byte) 'A'));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName("Test getByte(String) with 'key'; given CompoundTag() '42' is ONE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenCompoundTag42IsOne_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 0, new NBTMapType(tag).getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName("Test getByte(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName("Test getByte(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals((byte) 1, new NBTMapType(tag).getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals((byte) 0, new NBTMapType(tag).getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals((byte) 0, new NBTMapType(tag).getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return backspace.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName(
      "Test getByte(String) with 'key'; given CompoundTag() Short 'Key' is eight; then return backspace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenCompoundTagShortKeyIsEight_thenReturnBackspace() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals('\b', new NBTMapType(tag).getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#getByte(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getByte(String)}
   */
  @Test
  @DisplayName("Test getByte(String) with 'key'; given NBTMapType(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTMapType.getByte(String)"})
  void testGetByteWithKey_givenNBTMapType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, new NBTMapType().getByte("Key"));
  }

  /**
   * Test {@link NBTMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setByte(String, byte)"})
  void testSetByte_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsTwo() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(2, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(2, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setByte(String, byte)"})
  void testSetByte_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsTwo2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setByte("Key", (byte) 'A');

    // Assert that nothing has changed
    assertEquals(2, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(2, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName(
      "Test setByte(String, byte); given CompoundTag() 'Key' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setByte(String, byte)"})
  void testSetByte_givenCompoundTagKeyIsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setByte("Key", (byte) 'A');

    // Assert that nothing has changed
    assertEquals(1, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(1, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setByte(String, byte)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setByte(String, byte)}
   */
  @Test
  @DisplayName("Test setByte(String, byte); given NBTMapType(); then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setByte(String, byte)"})
  void testSetByte_givenNBTMapType_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setByte("Key", (byte) 'A');

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenCompoundTag42IsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals((short) 0, new NBTMapType(tag).getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals((short) 0, new NBTMapType(tag).getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 8, new NBTMapType(tag).getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String, short)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(String, short) with 'key', 'dfl'; given NBTMapType(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String, short)"})
  void testGetShortWithKeyDfl_givenNBTMapType_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals((short) 1, new NBTMapType().getShort("Key", (short) 1));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given CompoundTag() '42' is ONE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenCompoundTag42IsOne_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 0, new NBTMapType(tag).getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals((short) 1, new NBTMapType(tag).getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals((short) 0, new NBTMapType(tag).getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals((short) 0, new NBTMapType(tag).getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName(
      "Test getShort(String) with 'key'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals((short) 8, new NBTMapType(tag).getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#getShort(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getShort(String)}
   */
  @Test
  @DisplayName("Test getShort(String) with 'key'; given NBTMapType(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTMapType.getShort(String)"})
  void testGetShortWithKey_givenNBTMapType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((short) 0, new NBTMapType().getShort("Key"));
  }

  /**
   * Test {@link NBTMapType#setShort(String, short)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When one.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setShort(String, short)}
   */
  @Test
  @DisplayName(
      "Test setShort(String, short); given NBTMapType(); when one; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setShort(String, short)"})
  void testSetShort_givenNBTMapType_whenOne_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setShort("Key", (short) 1);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenCompoundTag42IsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0, new NBTMapType(tag).getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0, new NBTMapType(tag).getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'key', 'dfl'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(8, new NBTMapType(tag).getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String, int)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String, int)}
   */
  @Test
  @DisplayName("Test getInt(String, int) with 'key', 'dfl'; given NBTMapType(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String, int)"})
  void testGetIntWithKeyDfl_givenNBTMapType_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new NBTMapType().getInt("Key", 1));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'key'; given CompoundTag() '42' is ONE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenCompoundTag42IsOne_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(0, new NBTMapType(tag).getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1, new NBTMapType(tag).getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0, new NBTMapType(tag).getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0, new NBTMapType(tag).getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'key'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(8, new NBTMapType(tag).getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#getInt(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'key'; given NBTMapType(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTMapType.getInt(String)"})
  void testGetIntWithKey_givenNBTMapType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new NBTMapType().getInt("Key"));
  }

  /**
   * Test {@link NBTMapType#setInt(String, int)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When forty-two.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int); given NBTMapType(); when forty-two; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setInt(String, int)"})
  void testSetInt_givenNBTMapType_whenFortyTwo_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setInt("Key", 42);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenCompoundTag42IsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0L, new NBTMapType(tag).getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0L, new NBTMapType(tag).getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'key', 'dfl'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(8L, new NBTMapType(tag).getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String, long)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String, long)}
   */
  @Test
  @DisplayName("Test getLong(String, long) with 'key', 'dfl'; given NBTMapType(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String, long)"})
  void testGetLongWithKeyDfl_givenNBTMapType_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, new NBTMapType().getLong("Key", 1L));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'key'; given CompoundTag() '42' is ONE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenCompoundTag42IsOne_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(0L, new NBTMapType(tag).getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1L, new NBTMapType(tag).getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0L, new NBTMapType(tag).getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0L, new NBTMapType(tag).getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'key'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(8L, new NBTMapType(tag).getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#getLong(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'key'; given NBTMapType(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTMapType.getLong(String)"})
  void testGetLongWithKey_givenNBTMapType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new NBTMapType().getLong("Key"));
  }

  /**
   * Test {@link NBTMapType#setLong(String, long)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When forty-two.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long); given NBTMapType(); when forty-two; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setLong(String, long)"})
  void testSetLong_givenNBTMapType_whenFortyTwo_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setLong("Key", 42L);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenCompoundTag42IsOne_thenReturnTen() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(10.0f, new NBTMapType(tag).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1.0f, new NBTMapType(tag).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1.0f, new NBTMapType(tag).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1.0f, new NBTMapType(tag).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1.0f, new NBTMapType(tag).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0.0f, new NBTMapType(tag).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0.0f, new NBTMapType(tag).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(8.0f, new NBTMapType(tag).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String, float)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String, float) with 'key', 'dfl'; given NBTMapType(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String, float)"})
  void testGetFloatWithKeyDfl_givenNBTMapType_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new NBTMapType().getFloat("Key", 10.0f));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given CompoundTag() '42' is ONE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenCompoundTag42IsOne_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(0.0f, new NBTMapType(tag).getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1.0f, new NBTMapType(tag).getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1.0f, new NBTMapType(tag).getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1.0f, new NBTMapType(tag).getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1.0f, new NBTMapType(tag).getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0.0f, new NBTMapType(tag).getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0.0f, new NBTMapType(tag).getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'key'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(8.0f, new NBTMapType(tag).getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#getFloat(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getFloat(String)}
   */
  @Test
  @DisplayName("Test getFloat(String) with 'key'; given NBTMapType(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTMapType.getFloat(String)"})
  void testGetFloatWithKey_givenNBTMapType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new NBTMapType().getFloat("Key"));
  }

  /**
   * Test {@link NBTMapType#setFloat(String, float)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When ten.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float); given NBTMapType(); when ten; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setFloat(String, float)"})
  void testSetFloat_givenNBTMapType_whenTen_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setFloat("Key", 10.0f);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenCompoundTag42IsOne_thenReturnTen() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(10.0d, new NBTMapType(tag).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1.0d, new NBTMapType(tag).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1.0d, new NBTMapType(tag).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1.0d, new NBTMapType(tag).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1.0d, new NBTMapType(tag).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0.0d, new NBTMapType(tag).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0.0d, new NBTMapType(tag).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(8.0d, new NBTMapType(tag).getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String, double)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'key', 'dfl'; given NBTMapType(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String, double)"})
  void testGetDoubleWithKeyDfl_givenNBTMapType_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0d, new NBTMapType().getDouble("Key", 10.0d));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given CompoundTag() '42' is ONE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenCompoundTag42IsOne_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(0.0d, new NBTMapType(tag).getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenCompoundTagKeyIsOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1.0d, new NBTMapType(tag).getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given CompoundTag() 'Key' is ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenCompoundTagKeyIsOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1.0d, new NBTMapType(tag).getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertEquals(1.0d, new NBTMapType(tag).getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given CompoundTag() 'Key' is valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenCompoundTagKeyIsValueOfOne_thenReturnOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", LongTag.valueOf(1L));

    // Act and Assert
    assertEquals(1.0d, new NBTMapType(tag).getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link DoubleTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenCompoundTagKeyIsZero_thenReturnZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertEquals(0.0d, new NBTMapType(tag).getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link FloatTag#ZERO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given CompoundTag() 'Key' is ZERO; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenCompoundTagKeyIsZero_thenReturnZero2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertEquals(0.0d, new NBTMapType(tag).getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code Key} is eight.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'key'; given CompoundTag() Short 'Key' is eight; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenCompoundTagShortKeyIsEight_thenReturnEight() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putShort("Key", (short) 8);
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals(8.0d, new NBTMapType(tag).getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#getDouble(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getDouble(String)}
   */
  @Test
  @DisplayName("Test getDouble(String) with 'key'; given NBTMapType(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTMapType.getDouble(String)"})
  void testGetDoubleWithKey_givenNBTMapType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new NBTMapType().getDouble("Key"));
  }

  /**
   * Test {@link NBTMapType#setDouble(String, double)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When ten.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test setDouble(String, double); given NBTMapType(); when ten; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setDouble(String, double)"})
  void testSetDouble_givenNBTMapType_whenTen_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setDouble("Key", 10.0d);

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getBytes(String, byte[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test getBytes(String, byte[]) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String, byte[])"})
  void testGetBytesWithKeyDfl_givenCompoundTag42IsOne_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new NBTMapType(tag).getBytes("Key", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link NBTMapType#getBytes(String, byte[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} ByteArray {@code Key} is {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test getBytes(String, byte[]) with 'key', 'dfl'; given CompoundTag() ByteArray 'Key' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String, byte[])"})
  void testGetBytesWithKeyDfl_givenCompoundTagByteArrayKeyIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putByteArray("Key", "AXAXAXAX".getBytes("UTF-8"));
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new NBTMapType(tag).getBytes("Key", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link NBTMapType#getBytes(String, byte[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test getBytes(String, byte[]) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String, byte[])"})
  void testGetBytesWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new NBTMapType(tag).getBytes("Key", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link NBTMapType#getBytes(String, byte[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test getBytes(String, byte[]) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String, byte[])"})
  void testGetBytesWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnAxaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new NBTMapType(tag).getBytes("Key", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link NBTMapType#getBytes(String, byte[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test getBytes(String, byte[]) with 'key', 'dfl'; given NBTMapType(); then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String, byte[])"})
  void testGetBytesWithKeyDfl_givenNBTMapType_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new NBTMapType().getBytes("Key", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link NBTMapType#getBytes(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String)}
   */
  @Test
  @DisplayName(
      "Test getBytes(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String)"})
  void testGetBytesWithKey_givenCompoundTag42IsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getBytes("Key"));
  }

  /**
   * Test {@link NBTMapType#getBytes(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String)}
   */
  @Test
  @DisplayName(
      "Test getBytes(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String)"})
  void testGetBytesWithKey_givenCompoundTagKeyIsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getBytes("Key"));
  }

  /**
   * Test {@link NBTMapType#getBytes(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String)}
   */
  @Test
  @DisplayName(
      "Test getBytes(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String)"})
  void testGetBytesWithKey_givenCompoundTagKeyIsOne_thenReturnNull2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getBytes("Key"));
  }

  /**
   * Test {@link NBTMapType#getBytes(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String)}
   */
  @Test
  @DisplayName("Test getBytes(String) with 'key'; given NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String)"})
  void testGetBytesWithKey_givenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getBytes("Key"));
  }

  /**
   * Test {@link NBTMapType#getBytes(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getBytes(String)}
   */
  @Test
  @DisplayName("Test getBytes(String) with 'key'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTMapType.getBytes(String)"})
  void testGetBytesWithKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putByteArray("Key", "AXAXAXAX".getBytes("UTF-8"));
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), new NBTMapType(tag).getBytes("Key"));
  }

  /**
   * Test {@link NBTMapType#setBytes(String, byte[])}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setBytes(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test setBytes(String, byte[]); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setBytes(String, byte[])"})
  void testSetBytes_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setBytes("Key", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(2, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(2, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setBytes(String, byte[])}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setBytes(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test setBytes(String, byte[]); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setBytes(String, byte[])"})
  void testSetBytes_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsTwo2()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setBytes("Key", "AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertEquals(2, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(2, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setBytes(String, byte[])}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setBytes(String, byte[])}
   */
  @Test
  @DisplayName("Test setBytes(String, byte[]); given NBTMapType(); then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setBytes(String, byte[])"})
  void testSetBytes_givenNBTMapType_thenNBTMapTypeSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setBytes("Key", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setBytes(String, byte[])}.
   *
   * <ul>
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setBytes(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test setBytes(String, byte[]); then NBTMapType(CompoundTag) with tag is CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setBytes(String, byte[])"})
  void testSetBytes_thenNBTMapTypeWithTagIsCompoundTagSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setBytes("Key", "AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertEquals(1, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(1, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getShorts(String)} with {@code key}.
   *
   * <p>Method under test: {@link NBTMapType#getShorts(String)}
   */
  @Test
  @DisplayName("Test getShorts(String) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short[] NBTMapType.getShorts(String)"})
  void testGetShortsWithKey() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getShorts("Key"));
  }

  /**
   * Test {@link NBTMapType#getShorts(String, short[])} with {@code key}, {@code dfl}.
   *
   * <p>Method under test: {@link NBTMapType#getShorts(String, short[])}
   */
  @Test
  @DisplayName("Test getShorts(String, short[]) with 'key', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short[] NBTMapType.getShorts(String, short[])"})
  void testGetShortsWithKeyDfl() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new short[] {1, -1, 1, -1}, new NBTMapType().getShorts("Key", new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link NBTMapType#setShorts(String, short[])}.
   *
   * <p>Method under test: {@link NBTMapType#setShorts(String, short[])}
   */
  @Test
  @DisplayName("Test setShorts(String, short[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setShorts(String, short[])"})
  void testSetShorts() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new NBTMapType().setShorts("Key", new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link NBTMapType#getInts(String, int[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return array of {@code int} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String, int[])}
   */
  @Test
  @DisplayName(
      "Test getInts(String, int[]) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return array of int with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String, int[])"})
  void testGetIntsWithKeyDfl_givenCompoundTag42IsOne_thenReturnArrayOfIntWithOneAndZero() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new int[] {1, 0, 1, 0}, new NBTMapType(tag).getInts("Key", new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link NBTMapType#getInts(String, int[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String, int[])}
   */
  @Test
  @DisplayName("Test getInts(String, int[]) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String, int[])"})
  void testGetIntsWithKeyDfl_givenCompoundTagKeyIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new int[] {1, 0, 1, 0}, new NBTMapType(tag).getInts("Key", new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link NBTMapType#getInts(String, int[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String, int[])}
   */
  @Test
  @DisplayName("Test getInts(String, int[]) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String, int[])"})
  void testGetIntsWithKeyDfl_givenCompoundTagKeyIsOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new int[] {1, 0, 1, 0}, new NBTMapType(tag).getInts("Key", new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link NBTMapType#getInts(String, int[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return array of {@code int} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String, int[])}
   */
  @Test
  @DisplayName(
      "Test getInts(String, int[]) with 'key', 'dfl'; given NBTMapType(); then return array of int with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String, int[])"})
  void testGetIntsWithKeyDfl_givenNBTMapType_thenReturnArrayOfIntWithOneAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {1, 0, 1, 0}, new NBTMapType().getInts("Key", new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link NBTMapType#getInts(String, int[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with forty-two and one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String, int[])}
   */
  @Test
  @DisplayName(
      "Test getInts(String, int[]) with 'key', 'dfl'; then return array of int with forty-two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String, int[])"})
  void testGetIntsWithKeyDfl_thenReturnArrayOfIntWithFortyTwoAndOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putIntArray("Key", new int[] {42, 1, 42, 1});
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new int[] {42, 1, 42, 1}, new NBTMapType(tag).getInts("Key", new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link NBTMapType#getInts(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String)}
   */
  @Test
  @DisplayName(
      "Test getInts(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String)"})
  void testGetIntsWithKey_givenCompoundTag42IsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getInts("Key"));
  }

  /**
   * Test {@link NBTMapType#getInts(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String)}
   */
  @Test
  @DisplayName(
      "Test getInts(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String)"})
  void testGetIntsWithKey_givenCompoundTagKeyIsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getInts("Key"));
  }

  /**
   * Test {@link NBTMapType#getInts(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String)}
   */
  @Test
  @DisplayName(
      "Test getInts(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String)"})
  void testGetIntsWithKey_givenCompoundTagKeyIsOne_thenReturnNull2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getInts("Key"));
  }

  /**
   * Test {@link NBTMapType#getInts(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String)}
   */
  @Test
  @DisplayName("Test getInts(String) with 'key'; given NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String)"})
  void testGetIntsWithKey_givenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getInts("Key"));
  }

  /**
   * Test {@link NBTMapType#getInts(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with forty-two and one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getInts(String)}
   */
  @Test
  @DisplayName("Test getInts(String) with 'key'; then return array of int with forty-two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTMapType.getInts(String)"})
  void testGetIntsWithKey_thenReturnArrayOfIntWithFortyTwoAndOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putIntArray("Key", new int[] {42, 1, 42, 1});
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(new int[] {42, 1, 42, 1}, new NBTMapType(tag).getInts("Key"));
  }

  /**
   * Test {@link NBTMapType#setInts(String, int[])}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setInts(String, int[])}
   */
  @Test
  @DisplayName(
      "Test setInts(String, int[]); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setInts(String, int[])"})
  void testSetInts_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsTwo() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setInts("Key", new int[] {42, 1, 42, 1});

    // Assert
    assertEquals(2, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(2, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setInts(String, int[])}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setInts(String, int[])}
   */
  @Test
  @DisplayName(
      "Test setInts(String, int[]); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setInts(String, int[])"})
  void testSetInts_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsTwo2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setInts("Key", new int[] {42, 1, 42, 1});

    // Assert that nothing has changed
    assertEquals(2, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(2, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setInts(String, int[])}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setInts(String, int[])}
   */
  @Test
  @DisplayName(
      "Test setInts(String, int[]); given CompoundTag() 'Key' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setInts(String, int[])"})
  void testSetInts_givenCompoundTagKeyIsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setInts("Key", new int[] {42, 1, 42, 1});

    // Assert that nothing has changed
    assertEquals(1, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(1, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setInts(String, int[])}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setInts(String, int[])}
   */
  @Test
  @DisplayName("Test setInts(String, int[]); given NBTMapType(); then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setInts(String, int[])"})
  void testSetInts_givenNBTMapType_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setInts("Key", new int[] {42, 1, 42, 1});

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getLongs(String, long[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String, long[])}
   */
  @Test
  @DisplayName("Test getLongs(String, long[]) with 'key', 'dfl'; given CompoundTag() '42' is ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String, long[])"})
  void testGetLongsWithKeyDfl_givenCompoundTag42IsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new long[] {1L, -1L, 1L, -1L},
        new NBTMapType(tag).getLongs("Key", new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link NBTMapType#getLongs(String, long[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String, long[])}
   */
  @Test
  @DisplayName("Test getLongs(String, long[]) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String, long[])"})
  void testGetLongsWithKeyDfl_givenCompoundTagKeyIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new long[] {1L, -1L, 1L, -1L},
        new NBTMapType(tag).getLongs("Key", new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link NBTMapType#getLongs(String, long[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String, long[])}
   */
  @Test
  @DisplayName("Test getLongs(String, long[]) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String, long[])"})
  void testGetLongsWithKeyDfl_givenCompoundTagKeyIsOne2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new long[] {1L, -1L, 1L, -1L},
        new NBTMapType(tag).getLongs("Key", new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link NBTMapType#getLongs(String, long[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return array of {@code long} with one and minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String, long[])}
   */
  @Test
  @DisplayName(
      "Test getLongs(String, long[]) with 'key', 'dfl'; given NBTMapType(); then return array of long with one and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String, long[])"})
  void testGetLongsWithKeyDfl_givenNBTMapType_thenReturnArrayOfLongWithOneAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new long[] {1L, -1L, 1L, -1L},
        new NBTMapType().getLongs("Key", new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link NBTMapType#getLongs(String, long[])} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return array of {@code long} with forty-two and one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String, long[])}
   */
  @Test
  @DisplayName(
      "Test getLongs(String, long[]) with 'key', 'dfl'; then return array of long with forty-two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String, long[])"})
  void testGetLongsWithKeyDfl_thenReturnArrayOfLongWithFortyTwoAndOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putLongArray("Key", new long[] {42L, 1L, 42L, 1L});
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new long[] {42L, 1L, 42L, 1L},
        new NBTMapType(tag).getLongs("Key", new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link NBTMapType#getLongs(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String)}
   */
  @Test
  @DisplayName(
      "Test getLongs(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String)"})
  void testGetLongsWithKey_givenCompoundTag42IsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getLongs("Key"));
  }

  /**
   * Test {@link NBTMapType#getLongs(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String)}
   */
  @Test
  @DisplayName(
      "Test getLongs(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String)"})
  void testGetLongsWithKey_givenCompoundTagKeyIsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getLongs("Key"));
  }

  /**
   * Test {@link NBTMapType#getLongs(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String)}
   */
  @Test
  @DisplayName(
      "Test getLongs(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String)"})
  void testGetLongsWithKey_givenCompoundTagKeyIsOne_thenReturnNull2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getLongs("Key"));
  }

  /**
   * Test {@link NBTMapType#getLongs(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String)}
   */
  @Test
  @DisplayName("Test getLongs(String) with 'key'; given NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String)"})
  void testGetLongsWithKey_givenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getLongs("Key"));
  }

  /**
   * Test {@link NBTMapType#getLongs(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return array of {@code long} with forty-two and one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getLongs(String)}
   */
  @Test
  @DisplayName("Test getLongs(String) with 'key'; then return array of long with forty-two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTMapType.getLongs(String)"})
  void testGetLongsWithKey_thenReturnArrayOfLongWithFortyTwoAndOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putLongArray("Key", new long[] {42L, 1L, 42L, 1L});
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(new long[] {42L, 1L, 42L, 1L}, new NBTMapType(tag).getLongs("Key"));
  }

  /**
   * Test {@link NBTMapType#setLongs(String, long[])}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setLongs(String, long[])}
   */
  @Test
  @DisplayName(
      "Test setLongs(String, long[]); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setLongs(String, long[])"})
  void testSetLongs_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsTwo() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setLongs("Key", new long[] {42L, 1L, 42L, 1L});

    // Assert
    assertEquals(2, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(2, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setLongs(String, long[])}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setLongs(String, long[])}
   */
  @Test
  @DisplayName(
      "Test setLongs(String, long[]); given CompoundTag() '42' is ONE; then NBTMapType(CompoundTag) with tag is CompoundTag() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setLongs(String, long[])"})
  void testSetLongs_givenCompoundTag42IsOne_thenNBTMapTypeWithTagIsCompoundTagSizeIsTwo2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setLongs("Key", new long[] {42L, 1L, 42L, 1L});

    // Assert that nothing has changed
    assertEquals(2, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(2, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setLongs(String, long[])}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setLongs(String, long[])}
   */
  @Test
  @DisplayName("Test setLongs(String, long[]); given NBTMapType(); then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setLongs(String, long[])"})
  void testSetLongs_givenNBTMapType_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setLongs("Key", new long[] {42L, 1L, 42L, 1L});

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#setLongs(String, long[])}.
   *
   * <ul>
   *   <li>Then {@link NBTMapType#NBTMapType(CompoundTag)} with tag is {@link
   *       CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setLongs(String, long[])}
   */
  @Test
  @DisplayName(
      "Test setLongs(String, long[]); then NBTMapType(CompoundTag) with tag is CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setLongs(String, long[])"})
  void testSetLongs_thenNBTMapTypeWithTagIsCompoundTagSizeIsOne() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setLongs("Key", new long[] {42L, 1L, 42L, 1L});

    // Assert that nothing has changed
    assertEquals(1, nbtMapType.size());
    CompoundTag tag2 = nbtMapType.getTag();
    assertEquals(1, tag2.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag2.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getListUnchecked(String, ListType)} with {@code key}, {@code dfl}.
   *
   * <p>Method under test: {@link NBTMapType#getListUnchecked(String, ListType)}
   */
  @Test
  @DisplayName("Test getListUnchecked(String, ListType) with 'key', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTMapType.getListUnchecked(String, ListType)"})
  void testGetListUncheckedWithKeyDfl() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();
    NBTListType dfl = new NBTListType();

    // Act
    ListType actualListUnchecked = nbtMapType.getListUnchecked("Key", dfl);

    // Assert
    assertSame(dfl, actualListUnchecked);
  }

  /**
   * Test {@link NBTMapType#getListUnchecked(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getListUnchecked(String)}
   */
  @Test
  @DisplayName(
      "Test getListUnchecked(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTMapType.getListUnchecked(String)"})
  void testGetListUncheckedWithKey_givenCompoundTag42IsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getListUnchecked("Key"));
  }

  /**
   * Test {@link NBTMapType#getListUnchecked(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getListUnchecked(String)}
   */
  @Test
  @DisplayName(
      "Test getListUnchecked(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTMapType.getListUnchecked(String)"})
  void testGetListUncheckedWithKey_givenCompoundTag42IsOne_thenReturnNull2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getListUnchecked("Key"));
  }

  /**
   * Test {@link NBTMapType#getListUnchecked(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getListUnchecked(String)}
   */
  @Test
  @DisplayName(
      "Test getListUnchecked(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTMapType.getListUnchecked(String)"})
  void testGetListUncheckedWithKey_givenCompoundTagKeyIsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getListUnchecked("Key"));
  }

  /**
   * Test {@link NBTMapType#getListUnchecked(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getListUnchecked(String)}
   */
  @Test
  @DisplayName("Test getListUnchecked(String) with 'key'; given NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTMapType.getListUnchecked(String)"})
  void testGetListUncheckedWithKey_givenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getListUnchecked("Key"));
  }

  /**
   * Test {@link NBTMapType#setList(String, ListType)}.
   *
   * <ul>
   *   <li>When {@link NBTListType#NBTListType()}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setList(String, ListType)}
   */
  @Test
  @DisplayName("Test setList(String, ListType); when NBTListType(); then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setList(String, ListType)"})
  void testSetList_whenNBTListType_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setList("Key", new NBTListType());

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }

  /**
   * Test {@link NBTMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(String, MapType) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_givenCompoundTag42IsOne_thenReturnNBTMapType() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = nbtMapType.getMap("Key", dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link NBTMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(String, MapType) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_givenCompoundTag42IsOne_thenReturnNBTMapType2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = nbtMapType.getMap("Key", dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link NBTMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(String, MapType) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnNBTMapType() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = nbtMapType.getMap("Key", dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link NBTMapType#getMap(String, MapType)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(String, MapType) with 'key', 'dfl'; given NBTMapType(); then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.getMap(String, MapType)"})
  void testGetMapWithKeyDfl_givenNBTMapType_thenReturnNBTMapType() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = nbtMapType.getMap("Key", dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link NBTMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getMap(String)}
   */
  @Test
  @DisplayName(
      "Test getMap(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.getMap(String)"})
  void testGetMapWithKey_givenCompoundTag42IsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getMap("Key"));
  }

  /**
   * Test {@link NBTMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getMap(String)}
   */
  @Test
  @DisplayName(
      "Test getMap(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.getMap(String)"})
  void testGetMapWithKey_givenCompoundTag42IsOne_thenReturnNull2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getMap("Key"));
  }

  /**
   * Test {@link NBTMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getMap(String)}
   */
  @Test
  @DisplayName(
      "Test getMap(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.getMap(String)"})
  void testGetMapWithKey_givenCompoundTagKeyIsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getMap("Key"));
  }

  /**
   * Test {@link NBTMapType#getMap(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getMap(String)}
   */
  @Test
  @DisplayName("Test getMap(String) with 'key'; given NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTMapType.getMap(String)"})
  void testGetMapWithKey_givenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getMap("Key"));
  }

  /**
   * Test {@link NBTMapType#setMap(String, MapType)}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag} {@link CompoundTag#put(String, Tag)} return {@link
   *       ByteTag#ONE}.
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then calls {@link CompoundTag#put(String, Tag)}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setMap(String, MapType)}
   */
  @Test
  @DisplayName(
      "Test setMap(String, MapType); given CompoundTag put(String, Tag) return ONE; when NBTMapType(); then calls put(String, Tag)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setMap(String, MapType)"})
  void testSetMap_givenCompoundTagPutReturnOne_whenNBTMapType_thenCallsPut() {
    // Arrange
    CompoundTag tag = mock(CompoundTag.class);
    when(tag.put(Mockito.<String>any(), Mockito.<net.minecraft.nbt.Tag>any()))
        .thenReturn(ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);
    NBTMapType nbtMapType = new NBTMapType(tag);

    // Act
    nbtMapType.setMap("Key", new NBTMapType());

    // Assert
    verify(tag, atLeast(1)).put(eq("Key"), Mockito.<net.minecraft.nbt.Tag>any());
  }

  /**
   * Test {@link NBTMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given CompoundTag() '42' is ONE; then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenCompoundTag42IsOne_thenReturnDfl() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals("Dfl", new NBTMapType(tag).getString("Key", "Dfl"));
  }

  /**
   * Test {@link NBTMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnDfl() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals("Dfl", new NBTMapType(tag).getString("Key", "Dfl"));
  }

  /**
   * Test {@link NBTMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given CompoundTag() 'Key' is ONE; then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenCompoundTagKeyIsOne_thenReturnDfl2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals("Dfl", new NBTMapType(tag).getString("Key", "Dfl"));
  }

  /**
   * Test {@link NBTMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; given NBTMapType(); then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_givenNBTMapType_thenReturnDfl() {
    // Arrange, Act and Assert
    assertEquals("Dfl", new NBTMapType().getString("Key", "Dfl"));
  }

  /**
   * Test {@link NBTMapType#getString(String, String)} with {@code key}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code CompoundTag}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'key', 'dfl'; then return 'net.minecraft.nbt.CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String, String)"})
  void testGetStringWithKeyDfl_thenReturnNetMinecraftNbtCompoundTag() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putString("Key", "net.minecraft.nbt.CompoundTag");
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals("net.minecraft.nbt.CompoundTag", new NBTMapType(tag).getString("Key", "Dfl"));
  }

  /**
   * Test {@link NBTMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code 42} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'key'; given CompoundTag() '42' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String)"})
  void testGetStringWithKey_givenCompoundTag42IsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getString("Key"));
  }

  /**
   * Test {@link NBTMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String)"})
  void testGetStringWithKey_givenCompoundTagKeyIsOne_thenReturnNull() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getString("Key"));
  }

  /**
   * Test {@link NBTMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} {@code Key} is {@link ByteTag#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'key'; given CompoundTag() 'Key' is ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String)"})
  void testGetStringWithKey_givenCompoundTagKeyIsOne_thenReturnNull2() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.put("42", ByteTag.ONE);
    tag.put("Key", ByteTag.ONE);

    // Act and Assert
    assertNull(new NBTMapType(tag).getString("Key"));
  }

  /**
   * Test {@link NBTMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'key'; given NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String)"})
  void testGetStringWithKey_givenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NBTMapType().getString("Key"));
  }

  /**
   * Test {@link NBTMapType#getString(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code CompoundTag}.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'key'; then return 'net.minecraft.nbt.CompoundTag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTMapType.getString(String)"})
  void testGetStringWithKey_thenReturnNetMinecraftNbtCompoundTag() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putString("Key", "net.minecraft.nbt.CompoundTag");
    tag.put("42", ByteTag.ONE);

    // Act and Assert
    assertEquals("net.minecraft.nbt.CompoundTag", new NBTMapType(tag).getString("Key"));
  }

  /**
   * Test {@link NBTMapType#setString(String, String)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@code Val}.
   *   <li>Then {@link NBTMapType#NBTMapType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTMapType#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String); given NBTMapType(); when 'Val'; then NBTMapType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTMapType.setString(String, String)"})
  void testSetString_givenNBTMapType_whenVal_thenNBTMapTypeSizeIsOne() {
    // Arrange
    NBTMapType nbtMapType = new NBTMapType();

    // Act
    nbtMapType.setString("Key", "Val");

    // Assert
    assertEquals(1, nbtMapType.size());
    CompoundTag tag = nbtMapType.getTag();
    assertEquals(1, tag.size());
    assertFalse(nbtMapType.isEmpty());
    assertFalse(tag.isEmpty());
  }
}
