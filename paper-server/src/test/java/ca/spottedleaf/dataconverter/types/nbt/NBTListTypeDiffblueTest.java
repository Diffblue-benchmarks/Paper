package ca.spottedleaf.dataconverter.types.nbt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.types.ListType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.ObjectType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongArrayTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.ShortTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NBTListTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NBTListType#NBTListType(ListTag)}
   *   <li>{@link NBTListType#toString()}
   *   <li>{@link NBTListType#getTag()}
   *   <li>{@link NBTListType#getTypeUtil()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NBTListType.<init>(ListTag)",
    "ListTag NBTListType.getTag()",
    "ca.spottedleaf.dataconverter.types.TypeUtil NBTListType.getTypeUtil()",
    "String NBTListType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ListTag tag = new ListTag();

    // Act
    NBTListType actualNbtListType = new NBTListType(tag);
    String actualToStringResult = actualNbtListType.toString();
    ListTag actualTag = actualNbtListType.getTag();

    // Assert
    assertTrue(actualNbtListType.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals("NBTListType{list=[]}", actualToStringResult);
    assertSame(tag, actualTag);
  }

  /**
   * Test {@link NBTListType#NBTListType()}.
   *
   * <p>Method under test: {@link NBTListType#NBTListType()}
   */
  @Test
  @DisplayName("Test new NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.<init>()"})
  void testNewNBTListType() {
    // Arrange and Act
    NBTListType actualNbtListType = new NBTListType();

    // Assert
    assertTrue(actualNbtListType.getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(0, actualNbtListType.size());
    assertEquals(ObjectType.NONE, actualNbtListType.getUniformType());
    assertTrue(actualNbtListType.getTag().isEmpty());
  }

  /**
   * Test {@link NBTListType#equals(Object)}, and {@link NBTListType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NBTListType#equals(Object)}
   *   <li>{@link NBTListType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTListType.equals(Object)", "int NBTListType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    NBTListType nbtListType2 = new NBTListType();

    // Act and Assert
    assertEquals(nbtListType, nbtListType2);
    assertEquals(nbtListType.hashCode(), nbtListType2.hashCode());
  }

  /**
   * Test {@link NBTListType#equals(Object)}, and {@link NBTListType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NBTListType#equals(Object)}
   *   <li>{@link NBTListType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTListType.equals(Object)", "int NBTListType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act and Assert
    assertEquals(nbtListType, nbtListType);
    int expectedHashCodeResult = nbtListType.hashCode();
    assertEquals(expectedHashCodeResult, nbtListType.hashCode());
  }

  /**
   * Test {@link NBTListType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTListType.equals(Object)", "int NBTListType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertNotEquals(nbtListType, new NBTListType());
  }

  /**
   * Test {@link NBTListType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTListType.equals(Object)", "int NBTListType.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NBTListType(), null);
  }

  /**
   * Test {@link NBTListType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NBTListType.equals(Object)", "int NBTListType.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NBTListType(), "Different type to NBTListType");
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ByteTag#ONE}.
   *   <li>Then return {@link NBTListType#NBTListType(ListTag)} with tag is {@link
   *       ListTag#ListTag(List)}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given ArrayList() add ONE; then return NBTListType(ListTag) with tag is ListTag(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenArrayListAddOne_thenReturnNBTListTypeWithTagIsListTag() {
    // Arrange
    ArrayList<net.minecraft.nbt.Tag> list = new ArrayList<>();
    list.add(ByteTag.ONE);
    NBTListType nbtListType = new NBTListType(new ListTag(list));

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    assertEquals(nbtListType, actualCopyResult);
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addDouble ten.
   *   <li>Then return {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given NBTListType() addDouble ten; then return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListTypeAddDoubleTen_thenReturnNBTListType() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(10.0d);

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    assertEquals(nbtListType, actualCopyResult);
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat ten.
   *   <li>Then return {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given NBTListType() addFloat ten; then return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListTypeAddFloatTen_thenReturnNBTListType() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(10.0f);

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    assertEquals(nbtListType, actualCopyResult);
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt two.
   *   <li>Then return {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given NBTListType() addInt two; then return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListTypeAddIntTwo_thenReturnNBTListType() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(2);

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    assertEquals(nbtListType, actualCopyResult);
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addList {@link NBTListType#NBTListType()}.
   *   <li>Then return UniformType is {@code LIST}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given NBTListType() addList NBTListType(); then return UniformType is 'LIST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListTypeAddListNBTListType_thenReturnUniformTypeIsList() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addList(new NBTListType());

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualCopyResult).getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.LIST, actualCopyResult.getUniformType());
    assertTrue(((List<Object>) tag.get(0)).isEmpty());
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong one.
   *   <li>Then return {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given NBTListType() addLong one; then return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListTypeAddLongOne_thenReturnNBTListType() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(1L);

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    assertEquals(nbtListType, actualCopyResult);
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addMap {@link NBTMapType#NBTMapType()}.
   *   <li>Then return Tag first size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName(
      "Test copy(); given NBTListType() addMap NBTMapType(); then return Tag first size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListTypeAddMapNBTMapType_thenReturnTagFirstSizeIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addMap(new NBTMapType());

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualCopyResult).getTag();
    assertEquals(1, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(0);
    assertEquals(0, ((CompoundTag) getResult).size());
    assertEquals(ObjectType.MAP, actualCopyResult.getUniformType());
    assertTrue(((CompoundTag) getResult).isEmpty());
    assertEquals('\n', getResult.getId());
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addShort one.
   *   <li>Then return {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given NBTListType() addShort one; then return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListTypeAddShortOne_thenReturnNBTListType() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 1);

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    assertEquals(nbtListType, actualCopyResult);
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addString {@code String}.
   *   <li>Then return {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given NBTListType() addString 'String'; then return NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListTypeAddStringString_thenReturnNBTListType() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addString("String");

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    assertEquals(nbtListType, actualCopyResult);
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName("Test copy(); given NBTListType(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_givenNBTListType_thenReturnSizeIsZero() {
    // Arrange and Act
    ListType actualCopyResult = new NBTListType().copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    assertEquals(0, actualCopyResult.size());
    assertEquals(ObjectType.NONE, actualCopyResult.getUniformType());
    assertTrue(((NBTListType) actualCopyResult).getTag().isEmpty());
  }

  /**
   * Test {@link NBTListType#copy()}.
   *
   * <ul>
   *   <li>Then return Tag first stream limit five collect toList size is five.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return Tag first stream limit five collect toList size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.copy()"})
  void testCopy_thenReturnTagFirstStreamLimitFiveCollectToListSizeIsFive()
      throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ListType actualCopyResult = nbtListType.copy();

    // Assert
    assertTrue(actualCopyResult instanceof NBTListType);
    ListTag tag = ((NBTListType) actualCopyResult).getTag();
    assertEquals(1, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(0);
    Stream<net.minecraft.nbt.Tag> streamResult = ((ByteArrayTag) getResult).stream();
    assertEquals(5, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals((byte) 7, getResult.getId());
    assertEquals(8, ((ByteArrayTag) getResult).size());
    assertEquals(ObjectType.BYTE_ARRAY, actualCopyResult.getUniformType());
    assertFalse(((ByteArrayTag) getResult).isEmpty());
    assertTrue(((ByteArrayTag) getResult).iterator().hasNext());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), ((ByteArrayTag) getResult).getAsByteArray());
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when 'A'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenA_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> NBTListType.getType((byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when backspace; then return 'STRING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenBackspace_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.STRING, NBTListType.getType((byte) '\b'));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When eleven.
   *   <li>Then return {@code INT_ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when eleven; then return 'INT_ARRAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenEleven_thenReturnIntArray() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.INT_ARRAY, NBTListType.getType((byte) 11));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when five; then return 'FLOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenFive_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.FLOAT, NBTListType.getType((byte) 5));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When form feed (ff).
   *   <li>Then return {@code LONG_ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when form feed (ff); then return 'LONG_ARRAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenFormFeed_thenReturnLongArray() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.LONG_ARRAY, NBTListType.getType((byte) '\f'));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code LONG}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when four; then return 'LONG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenFour_thenReturnLong() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.LONG, NBTListType.getType((byte) 4));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when lf; then return 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenLf_thenReturnMap() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.MAP, NBTListType.getType((byte) '\n'));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when one; then return 'BYTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenOne_thenReturnByte() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.BYTE, NBTListType.getType((byte) 1));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code BYTE_ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when seven; then return 'BYTE_ARRAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenSeven_thenReturnByteArray() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.BYTE_ARRAY, NBTListType.getType((byte) 7));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code DOUBLE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when six; then return 'DOUBLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenSix_thenReturnDouble() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.DOUBLE, NBTListType.getType((byte) 6));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When tab.
   *   <li>Then return {@code LIST}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when tab; then return 'LIST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenTab_thenReturnList() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.LIST, NBTListType.getType((byte) '\t'));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when three; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenThree_thenReturnInt() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.INT, NBTListType.getType((byte) 3));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code SHORT}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when two; then return 'SHORT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenTwo_thenReturnShort() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.SHORT, NBTListType.getType((byte) 2));
  }

  /**
   * Test {@link NBTListType#getType(byte)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getType(byte)}
   */
  @Test
  @DisplayName("Test getType(byte); when zero; then return 'NONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getType(byte)"})
  void testGetType_whenZero_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.NONE, NBTListType.getType((byte) 0));
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ByteTag#ONE}.
   *   <li>Then return {@code BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given ArrayList() add ONE; then return 'BYTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenArrayListAddOne_thenReturnByte() {
    // Arrange
    ArrayList<net.minecraft.nbt.Tag> list = new ArrayList<>();
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);
    list.add(ByteTag.ONE);

    // Act and Assert
    assertEquals(ObjectType.BYTE, new NBTListType(new ListTag(list)).getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte one.
   *   <li>Then return {@code MIXED}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given NBTListType() addByte one; then return 'MIXED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddByteOne_thenReturnMixed() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 1);
    nbtListType.addShort((short) 1);

    // Act and Assert
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addDouble ten.
   *   <li>Then return {@code DOUBLE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given NBTListType() addDouble ten; then return 'DOUBLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddDoubleTen_thenReturnDouble() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(10.0d);

    // Act and Assert
    assertEquals(ObjectType.DOUBLE, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat ten.
   *   <li>Then return {@code FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given NBTListType() addFloat ten; then return 'FLOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddFloatTen_thenReturnFloat() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(10.0f);

    // Act and Assert
    assertEquals(ObjectType.FLOAT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt two.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given NBTListType() addInt two; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddIntTwo_thenReturnInt() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(2);

    // Act and Assert
    assertEquals(ObjectType.INT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addList {@link NBTListType#NBTListType()}.
   *   <li>Then return {@code LIST}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName(
      "Test getUniformType(); given NBTListType() addList NBTListType(); then return 'LIST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddListNBTListType_thenReturnList() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addList(new NBTListType());

    // Act and Assert
    assertEquals(ObjectType.LIST, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong one.
   *   <li>Then return {@code LONG}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given NBTListType() addLong one; then return 'LONG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddLongOne_thenReturnLong() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(1L);

    // Act and Assert
    assertEquals(ObjectType.LONG, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addMap {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given NBTListType() addMap NBTMapType(); then return 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddMapNBTMapType_thenReturnMap() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addMap(new NBTMapType());

    // Act and Assert
    assertEquals(ObjectType.MAP, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addShort one.
   *   <li>Then return {@code SHORT}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given NBTListType() addShort one; then return 'SHORT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddShortOne_thenReturnShort() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 1);

    // Act and Assert
    assertEquals(ObjectType.SHORT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addString {@code String}.
   *   <li>Then return {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName(
      "Test getUniformType(); given NBTListType() addString 'String'; then return 'STRING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListTypeAddStringString_thenReturnString() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addString("String");

    // Act and Assert
    assertEquals(ObjectType.STRING, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   *   <li>Then return {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); given NBTListType(); then return 'NONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_givenNBTListType_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.NONE, new NBTListType().getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Then return {@code BYTE_ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); then return 'BYTE_ARRAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_thenReturnByteArray() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(ObjectType.BYTE_ARRAY, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Then return {@code INT_ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); then return 'INT_ARRAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_thenReturnIntArray() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addIntArray(new int[] {2, 1, 2, 1});

    // Act and Assert
    assertEquals(ObjectType.INT_ARRAY, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#getUniformType()}.
   *
   * <ul>
   *   <li>Then return {@code LONG_ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getUniformType()}
   */
  @Test
  @DisplayName("Test getUniformType(); then return 'LONG_ARRAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NBTListType.getUniformType()"})
  void testGetUniformType_thenReturnLongArray() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLongArray(new long[] {1L, 0L, 1L, 0L});

    // Act and Assert
    assertEquals(ObjectType.LONG_ARRAY, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#size()}.
   *
   * <p>Method under test: {@link NBTListType#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new NBTListType().size());
  }

  /**
   * Test {@link NBTListType#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then {@link NBTListType#NBTListType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#remove(int)}
   */
  @Test
  @DisplayName("Test remove(int); given NBTListType() addByte 'X'; then NBTListType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.remove(int)"})
  void testRemove_givenNBTListTypeAddByteX_thenNBTListTypeSizeIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.remove(1);

    // Assert
    assertEquals(1, nbtListType.size());
    assertEquals(1, nbtListType.getTag().size());
  }

  /**
   * Test {@link NBTListType#getGeneric(int)}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getGeneric(int)}
   */
  @Test
  @DisplayName(
      "Test getGeneric(int); given NBTListType() addByte 'X'; then return byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object NBTListType.getGeneric(int)"})
  void testGetGeneric_givenNBTListTypeAddByteX_thenReturnByteValueIsA() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals('A', ((Byte) nbtListType.getGeneric(1)).byteValue());
  }

  /**
   * Test {@link NBTListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte zero.
   *   <li>Then return byteValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(int, Number) with 'index', 'dfl'; given NBTListType() addByte zero; then return byteValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_givenNBTListTypeAddByteZero_thenReturnByteValueIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 0);

    // Act and Assert
    assertEquals((byte) 0, nbtListType.getNumber(0, Bootstrap.bootstrapDuration).byteValue());
  }

  /**
   * Test {@link NBTListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(int, Number) with 'index', 'dfl'; given NBTListType() addInt one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_givenNBTListTypeAddIntOne_thenReturnIntValueIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(1);

    // Act and Assert
    assertEquals(1, nbtListType.getNumber(0, Bootstrap.bootstrapDuration).intValue());
  }

  /**
   * Test {@link NBTListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong zero.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName(
      "Test getNumber(int, Number) with 'index', 'dfl'; given NBTListType() addLong zero; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_givenNBTListTypeAddLongZero_thenReturnLongValueIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(0L);

    // Act and Assert
    assertEquals(0L, nbtListType.getNumber(0, Bootstrap.bootstrapDuration).longValue());
  }

  /**
   * Test {@link NBTListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@link AtomicLong}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName("Test getNumber(int, Number) with 'index', 'dfl'; then return AtomicLong")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_thenReturnAtomicLong() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));
    AtomicLong dfl = Bootstrap.bootstrapDuration;

    // Act
    Number actualNumber = nbtListType.getNumber(0, dfl);

    // Assert
    assertTrue(actualNumber instanceof AtomicLong);
    assertEquals(-1L, ((AtomicLong) actualNumber).get());
    assertSame(dfl, actualNumber);
  }

  /**
   * Test {@link NBTListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName("Test getNumber(int, Number) with 'index', 'dfl'; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_thenReturnDoubleValueIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(0.0d);

    // Act and Assert
    assertEquals(0.0d, nbtListType.getNumber(0, Bootstrap.bootstrapDuration).doubleValue());
  }

  /**
   * Test {@link NBTListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName("Test getNumber(int, Number) with 'index', 'dfl'; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_thenReturnFloatValueIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(0.0f);

    // Act and Assert
    assertEquals(0.0f, nbtListType.getNumber(0, Bootstrap.bootstrapDuration).floatValue());
  }

  /**
   * Test {@link NBTListType#getNumber(int, Number)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return shortValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getNumber(int, Number)}
   */
  @Test
  @DisplayName("Test getNumber(int, Number) with 'index', 'dfl'; then return shortValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTListType.getNumber(int, Number)"})
  void testGetNumberWithIndexDfl_thenReturnShortValueIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 0);

    // Act and Assert
    assertEquals((short) 0, nbtListType.getNumber(0, Bootstrap.bootstrapDuration).shortValue());
  }

  /**
   * Test {@link NBTListType#getNumber(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getNumber(int)}
   */
  @Test
  @DisplayName(
      "Test getNumber(int) with 'index'; given NBTListType() addByte 'X'; then return byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number NBTListType.getNumber(int)"})
  void testGetNumberWithIndex_givenNBTListTypeAddByteX_thenReturnByteValueIsA() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals('A', nbtListType.getNumber(1).byteValue());
  }

  /**
   * Test {@link NBTListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(int, byte) with 'index', 'dfl'; given NBTListType() addByte zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_givenNBTListTypeAddByteZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 0);

    // Act and Assert
    assertEquals((byte) 0, nbtListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addDouble zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(int, byte) with 'index', 'dfl'; given NBTListType() addDouble zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_givenNBTListTypeAddDoubleZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(0.0d);

    // Act and Assert
    assertEquals((byte) 0, nbtListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat ten.
   *   <li>When zero.
   *   <li>Then return lf.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(int, byte) with 'index', 'dfl'; given NBTListType() addFloat ten; when zero; then return lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_givenNBTListTypeAddFloatTen_whenZero_thenReturnLf() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(10.0f);
    nbtListType.addByte((byte) 0);

    // Act and Assert
    assertEquals('\n', nbtListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(int, byte) with 'index', 'dfl'; given NBTListType() addFloat zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_givenNBTListTypeAddFloatZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(0.0f);

    // Act and Assert
    assertEquals((byte) 0, nbtListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt one.
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(int, byte) with 'index', 'dfl'; given NBTListType() addInt one; when zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_givenNBTListTypeAddIntOne_whenZero_thenReturnOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(1);

    // Act and Assert
    assertEquals((byte) 1, nbtListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(int, byte) with 'index', 'dfl'; given NBTListType() addLong zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_givenNBTListTypeAddLongZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(0L);

    // Act and Assert
    assertEquals((byte) 0, nbtListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addShort zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int, byte)}
   */
  @Test
  @DisplayName(
      "Test getByte(int, byte) with 'index', 'dfl'; given NBTListType() addShort zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_givenNBTListTypeAddShortZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 0);

    // Act and Assert
    assertEquals((byte) 0, nbtListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getByte(int, byte)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int, byte)}
   */
  @Test
  @DisplayName("Test getByte(int, byte) with 'index', 'dfl'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int, byte)"})
  void testGetByteWithIndexDfl_thenReturnA() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals('A', nbtListType.getByte(0, (byte) 'A'));
  }

  /**
   * Test {@link NBTListType#getByte(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getByte(int)}
   */
  @Test
  @DisplayName("Test getByte(int) with 'index'; given NBTListType() addByte 'X'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NBTListType.getByte(int)"})
  void testGetByteWithIndex_givenNBTListTypeAddByteX_thenReturnA() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals('A', nbtListType.getByte(1));
  }

  /**
   * Test {@link NBTListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(int, short) with 'index', 'dfl'; given NBTListType() addByte zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_givenNBTListTypeAddByteZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 0);

    // Act and Assert
    assertEquals((short) 0, nbtListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link NBTListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addDouble zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(int, short) with 'index', 'dfl'; given NBTListType() addDouble zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_givenNBTListTypeAddDoubleZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(0.0d);

    // Act and Assert
    assertEquals((short) 0, nbtListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link NBTListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(int, short) with 'index', 'dfl'; given NBTListType() addFloat zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_givenNBTListTypeAddFloatZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(0.0f);

    // Act and Assert
    assertEquals((short) 0, nbtListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link NBTListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt one.
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(int, short) with 'index', 'dfl'; given NBTListType() addInt one; when zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_givenNBTListTypeAddIntOne_whenZero_thenReturnOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(1);

    // Act and Assert
    assertEquals((short) 1, nbtListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link NBTListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(int, short) with 'index', 'dfl'; given NBTListType() addLong zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_givenNBTListTypeAddLongZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(0L);

    // Act and Assert
    assertEquals((short) 0, nbtListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link NBTListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addShort zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test getShort(int, short) with 'index', 'dfl'; given NBTListType() addShort zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_givenNBTListTypeAddShortZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 0);

    // Act and Assert
    assertEquals((short) 0, nbtListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link NBTListType#getShort(int, short)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return seven.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getShort(int, short)}
   */
  @Test
  @DisplayName("Test getShort(int, short) with 'index', 'dfl'; then return seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTListType.getShort(int, short)"})
  void testGetShortWithIndexDfl_thenReturnSeven() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals((short) 7, nbtListType.getShort(0, (short) 7));
  }

  /**
   * Test {@link NBTListType#getShort(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getShort(int)}
   */
  @Test
  @DisplayName(
      "Test getShort(int) with 'index'; given NBTListType() addByte 'X'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NBTListType.getShort(int)"})
  void testGetShortWithIndex_givenNBTListTypeAddByteX_thenReturnSixtyFive() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals((short) 65, nbtListType.getShort(1));
  }

  /**
   * Test {@link NBTListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'dfl'; given NBTListType() addByte zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_givenNBTListTypeAddByteZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(0, nbtListType.getInt(0, 3));
  }

  /**
   * Test {@link NBTListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addDouble zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'dfl'; given NBTListType() addDouble zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_givenNBTListTypeAddDoubleZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(0.0d);

    // Act and Assert
    assertEquals(0, nbtListType.getInt(0, 3));
  }

  /**
   * Test {@link NBTListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'dfl'; given NBTListType() addFloat zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_givenNBTListTypeAddFloatZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(0.0f);

    // Act and Assert
    assertEquals(0, nbtListType.getInt(0, 3));
  }

  /**
   * Test {@link NBTListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt one.
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'dfl'; given NBTListType() addInt one; when zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_givenNBTListTypeAddIntOne_whenZero_thenReturnOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(1);

    // Act and Assert
    assertEquals(1, nbtListType.getInt(0, 3));
  }

  /**
   * Test {@link NBTListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'dfl'; given NBTListType() addLong zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_givenNBTListTypeAddLongZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(0L);

    // Act and Assert
    assertEquals(0, nbtListType.getInt(0, 3));
  }

  /**
   * Test {@link NBTListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addShort zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'dfl'; given NBTListType() addShort zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_givenNBTListTypeAddShortZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 0);

    // Act and Assert
    assertEquals(0, nbtListType.getInt(0, 3));
  }

  /**
   * Test {@link NBTListType#getInt(int, int)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInt(int, int)}
   */
  @Test
  @DisplayName("Test getInt(int, int) with 'index', 'dfl'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.getInt(int, int)"})
  void testGetIntWithIndexDfl_thenReturnThree() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(3, nbtListType.getInt(0, 3));
  }

  /**
   * Test {@link NBTListType#getInt(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInt(int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int) with 'index'; given NBTListType() addByte 'X'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NBTListType.getInt(int)"})
  void testGetIntWithIndex_givenNBTListTypeAddByteX_thenReturnSixtyFive() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals(65, nbtListType.getInt(1));
  }

  /**
   * Test {@link NBTListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(int, long) with 'index', 'dfl'; given NBTListType() addByte zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_givenNBTListTypeAddByteZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(0L, nbtListType.getLong(0, 5L));
  }

  /**
   * Test {@link NBTListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addDouble zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(int, long) with 'index', 'dfl'; given NBTListType() addDouble zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_givenNBTListTypeAddDoubleZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(0.0d);

    // Act and Assert
    assertEquals(0L, nbtListType.getLong(0, 5L));
  }

  /**
   * Test {@link NBTListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(int, long) with 'index', 'dfl'; given NBTListType() addFloat zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_givenNBTListTypeAddFloatZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(0.0f);

    // Act and Assert
    assertEquals(0L, nbtListType.getLong(0, 5L));
  }

  /**
   * Test {@link NBTListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt one.
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(int, long) with 'index', 'dfl'; given NBTListType() addInt one; when zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_givenNBTListTypeAddIntOne_whenZero_thenReturnOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(1);

    // Act and Assert
    assertEquals(1L, nbtListType.getLong(0, 5L));
  }

  /**
   * Test {@link NBTListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(int, long) with 'index', 'dfl'; given NBTListType() addLong zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_givenNBTListTypeAddLongZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(0L);

    // Act and Assert
    assertEquals(0L, nbtListType.getLong(0, 5L));
  }

  /**
   * Test {@link NBTListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addShort zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(int, long) with 'index', 'dfl'; given NBTListType() addShort zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_givenNBTListTypeAddShortZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 0);

    // Act and Assert
    assertEquals(0L, nbtListType.getLong(0, 5L));
  }

  /**
   * Test {@link NBTListType#getLong(int, long)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLong(int, long)}
   */
  @Test
  @DisplayName("Test getLong(int, long) with 'index', 'dfl'; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTListType.getLong(int, long)"})
  void testGetLongWithIndexDfl_thenReturnFive() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(5L, nbtListType.getLong(0, 5L));
  }

  /**
   * Test {@link NBTListType#getLong(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLong(int)}
   */
  @Test
  @DisplayName(
      "Test getLong(int) with 'index'; given NBTListType() addByte 'X'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NBTListType.getLong(int)"})
  void testGetLongWithIndex_givenNBTListTypeAddByteX_thenReturnSixtyFive() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals(65L, nbtListType.getLong(1));
  }

  /**
   * Test {@link NBTListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getFloat(int, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(int, float) with 'index', 'dfl'; given NBTListType() addByte zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_givenNBTListTypeAddByteZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(0.0f, nbtListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link NBTListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addDouble zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getFloat(int, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(int, float) with 'index', 'dfl'; given NBTListType() addDouble zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_givenNBTListTypeAddDoubleZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(0.0d);

    // Act and Assert
    assertEquals(0.0f, nbtListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link NBTListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getFloat(int, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(int, float) with 'index', 'dfl'; given NBTListType() addFloat zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_givenNBTListTypeAddFloatZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(0.0f);

    // Act and Assert
    assertEquals(0.0f, nbtListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link NBTListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt one.
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getFloat(int, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(int, float) with 'index', 'dfl'; given NBTListType() addInt one; when zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_givenNBTListTypeAddIntOne_whenZero_thenReturnOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(1);

    // Act and Assert
    assertEquals(1.0f, nbtListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link NBTListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getFloat(int, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(int, float) with 'index', 'dfl'; given NBTListType() addLong zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_givenNBTListTypeAddLongZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(0L);

    // Act and Assert
    assertEquals(0.0f, nbtListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link NBTListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addShort zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getFloat(int, float)}
   */
  @Test
  @DisplayName(
      "Test getFloat(int, float) with 'index', 'dfl'; given NBTListType() addShort zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_givenNBTListTypeAddShortZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 0);

    // Act and Assert
    assertEquals(0.0f, nbtListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link NBTListType#getFloat(int, float)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getFloat(int, float)}
   */
  @Test
  @DisplayName("Test getFloat(int, float) with 'index', 'dfl'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTListType.getFloat(int, float)"})
  void testGetFloatWithIndexDfl_thenReturnTen() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(10.0f, nbtListType.getFloat(0, 10.0f));
  }

  /**
   * Test {@link NBTListType#getFloat(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getFloat(int)}
   */
  @Test
  @DisplayName(
      "Test getFloat(int) with 'index'; given NBTListType() addByte 'X'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NBTListType.getFloat(int)"})
  void testGetFloatWithIndex_givenNBTListTypeAddByteX_thenReturnSixtyFive() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals(65.0f, nbtListType.getFloat(1));
  }

  /**
   * Test {@link NBTListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getDouble(int, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(int, double) with 'index', 'dfl'; given NBTListType() addByte zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_givenNBTListTypeAddByteZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 0);

    // Act and Assert
    assertEquals(0.0d, nbtListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link NBTListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addDouble zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getDouble(int, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(int, double) with 'index', 'dfl'; given NBTListType() addDouble zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_givenNBTListTypeAddDoubleZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addDouble(0.0d);

    // Act and Assert
    assertEquals(0.0d, nbtListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link NBTListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addFloat zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getDouble(int, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(int, double) with 'index', 'dfl'; given NBTListType() addFloat zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_givenNBTListTypeAddFloatZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addFloat(0.0f);

    // Act and Assert
    assertEquals(0.0d, nbtListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link NBTListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addInt one.
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getDouble(int, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(int, double) with 'index', 'dfl'; given NBTListType() addInt one; when zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_givenNBTListTypeAddIntOne_whenZero_thenReturnOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addInt(1);

    // Act and Assert
    assertEquals(1.0d, nbtListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link NBTListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addLong zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getDouble(int, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(int, double) with 'index', 'dfl'; given NBTListType() addLong zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_givenNBTListTypeAddLongZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addLong(0L);

    // Act and Assert
    assertEquals(0.0d, nbtListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link NBTListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addShort zero.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getDouble(int, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(int, double) with 'index', 'dfl'; given NBTListType() addShort zero; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_givenNBTListTypeAddShortZero_whenZero_thenReturnZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addShort((short) 0);

    // Act and Assert
    assertEquals(0.0d, nbtListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link NBTListType#getDouble(int, double)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getDouble(int, double)}
   */
  @Test
  @DisplayName("Test getDouble(int, double) with 'index', 'dfl'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTListType.getDouble(int, double)"})
  void testGetDoubleWithIndexDfl_thenReturnTen() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByteArray("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(10.0d, nbtListType.getDouble(0, 10.0d));
  }

  /**
   * Test {@link NBTListType#getDouble(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getDouble(int)}
   */
  @Test
  @DisplayName(
      "Test getDouble(int) with 'index'; given NBTListType() addByte 'X'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NBTListType.getDouble(int)"})
  void testGetDoubleWithIndex_givenNBTListTypeAddByteX_thenReturnSixtyFive() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals(65.0d, nbtListType.getDouble(1));
  }

  /**
   * Test {@link NBTListType#getBytes(int, byte[])} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getBytes(int, byte[])}
   */
  @Test
  @DisplayName(
      "Test getBytes(int, byte[]) with 'index', 'dfl'; given NBTListType() addByte 'X'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTListType.getBytes(int, byte[])"})
  void testGetBytesWithIndexDfl_givenNBTListTypeAddByteX_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), nbtListType.getBytes(1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link NBTListType#getBytes(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getBytes(int)}
   */
  @Test
  @DisplayName(
      "Test getBytes(int) with 'index'; given NBTListType() addByte 'X'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NBTListType.getBytes(int)"})
  void testGetBytesWithIndex_givenNBTListTypeAddByteX_thenThrowIllegalStateException() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> nbtListType.getBytes(1));
  }

  /**
   * Test {@link NBTListType#setBytes(int, byte[])}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#setBytes(int, byte[])}
   */
  @Test
  @DisplayName(
      "Test setBytes(int, byte[]); given NBTListType() addByte 'X'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.setBytes(int, byte[])"})
  void testSetBytes_givenNBTListTypeAddByteX_thenNBTListTypeTagSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');
    byte[] resultTo = "AXAXAXAX".getBytes("UTF-8");

    // Act
    nbtListType.setBytes(1, resultTo);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ByteArrayTag);
    assertTrue(tag.get(0) instanceof ByteTag);
    Stream<net.minecraft.nbt.Tag> streamResult = ((ByteArrayTag) getResult).stream();
    assertEquals(5, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals((byte) 7, ((ByteArrayTag) getResult).getId());
    assertEquals(8, ((ByteArrayTag) getResult).size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
    assertFalse(((ByteArrayTag) getResult).isEmpty());
    assertTrue(((ByteArrayTag) getResult).iterator().hasNext());
    assertSame(resultTo, ((ByteArrayTag) getResult).getAsByteArray());
  }

  /**
   * Test {@link NBTListType#getShorts(int)} with {@code index}.
   *
   * <p>Method under test: {@link NBTListType#getShorts(int)}
   */
  @Test
  @DisplayName("Test getShorts(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short[] NBTListType.getShorts(int)"})
  void testGetShortsWithIndex() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new NBTListType().getShorts(1));
  }

  /**
   * Test {@link NBTListType#getShorts(int, short[])} with {@code index}, {@code dfl}.
   *
   * <p>Method under test: {@link NBTListType#getShorts(int, short[])}
   */
  @Test
  @DisplayName("Test getShorts(int, short[]) with 'index', 'dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short[] NBTListType.getShorts(int, short[])"})
  void testGetShortsWithIndexDfl() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new NBTListType().getShorts(1, new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link NBTListType#setShorts(int, short[])}.
   *
   * <p>Method under test: {@link NBTListType#setShorts(int, short[])}
   */
  @Test
  @DisplayName("Test setShorts(int, short[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.setShorts(int, short[])"})
  void testSetShorts() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new NBTListType().setShorts(1, new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link NBTListType#getInts(int, int[])} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with one and minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInts(int, int[])}
   */
  @Test
  @DisplayName(
      "Test getInts(int, int[]) with 'index', 'dfl'; then return array of int with one and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTListType.getInts(int, int[])"})
  void testGetIntsWithIndexDfl_thenReturnArrayOfIntWithOneAndMinusOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertArrayEquals(new int[] {1, -1, 1, -1}, nbtListType.getInts(1, new int[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link NBTListType#getInts(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getInts(int)}
   */
  @Test
  @DisplayName(
      "Test getInts(int) with 'index'; given NBTListType() addByte 'X'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] NBTListType.getInts(int)"})
  void testGetIntsWithIndex_givenNBTListTypeAddByteX_thenThrowIllegalStateException() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> nbtListType.getInts(1));
  }

  /**
   * Test {@link NBTListType#setInts(int, int[])}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#setInts(int, int[])}
   */
  @Test
  @DisplayName(
      "Test setInts(int, int[]); given NBTListType() addByte 'X'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.setInts(int, int[])"})
  void testSetInts_givenNBTListTypeAddByteX_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');
    int[] resultTo = new int[] {1, -1, 1, -1};

    // Act
    nbtListType.setInts(1, resultTo);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof IntArrayTag);
    assertEquals((byte) 11, ((IntArrayTag) getResult).getId());
    Stream<net.minecraft.nbt.Tag> streamResult = ((IntArrayTag) getResult).stream();
    assertEquals(4, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals(4, ((IntArrayTag) getResult).size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
    assertFalse(((IntArrayTag) getResult).isEmpty());
    assertTrue(((IntArrayTag) getResult).iterator().hasNext());
    assertSame(resultTo, ((IntArrayTag) getResult).getAsIntArray());
  }

  /**
   * Test {@link NBTListType#getLongs(int, long[])} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Then return array of {@code long} with one and minus one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLongs(int, long[])}
   */
  @Test
  @DisplayName(
      "Test getLongs(int, long[]) with 'index', 'dfl'; then return array of long with one and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTListType.getLongs(int, long[])"})
  void testGetLongsWithIndexDfl_thenReturnArrayOfLongWithOneAndMinusOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertArrayEquals(
        new long[] {1L, -1L, 1L, -1L}, nbtListType.getLongs(1, new long[] {1L, -1L, 1L, -1L}));
  }

  /**
   * Test {@link NBTListType#getLongs(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getLongs(int)}
   */
  @Test
  @DisplayName(
      "Test getLongs(int) with 'index'; given NBTListType() addByte 'X'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] NBTListType.getLongs(int)"})
  void testGetLongsWithIndex_givenNBTListTypeAddByteX_thenThrowIllegalStateException() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> nbtListType.getLongs(1));
  }

  /**
   * Test {@link NBTListType#setLongs(int, long[])}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#setLongs(int, long[])}
   */
  @Test
  @DisplayName(
      "Test setLongs(int, long[]); given NBTListType() addByte 'X'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.setLongs(int, long[])"})
  void testSetLongs_givenNBTListTypeAddByteX_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');
    long[] resultTo = new long[] {1L, -1L, 1L, -1L};

    // Act
    nbtListType.setLongs(1, resultTo);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof LongArrayTag);
    Stream<net.minecraft.nbt.Tag> streamResult = ((LongArrayTag) getResult).stream();
    assertEquals(4, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals(4, ((LongArrayTag) getResult).size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
    assertFalse(((LongArrayTag) getResult).isEmpty());
    assertTrue(((LongArrayTag) getResult).iterator().hasNext());
    assertEquals('\f', ((LongArrayTag) getResult).getId());
    assertSame(resultTo, ((LongArrayTag) getResult).getAsLongArray());
  }

  /**
   * Test {@link NBTListType#getList(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getList(int)}
   */
  @Test
  @DisplayName(
      "Test getList(int) with 'index'; given NBTListType() addByte 'X'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListType NBTListType.getList(int)"})
  void testGetListWithIndex_givenNBTListTypeAddByteX_thenThrowIllegalStateException() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> nbtListType.getList(1));
  }

  /**
   * Test {@link NBTListType#getMap(int, MapType)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return {@link NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getMap(int, MapType)}
   */
  @Test
  @DisplayName(
      "Test getMap(int, MapType) with 'index', 'dfl'; given NBTListType() addByte 'X'; then return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTListType.getMap(int, MapType)"})
  void testGetMapWithIndexDfl_givenNBTListTypeAddByteX_thenReturnNBTMapType() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');
    NBTMapType dfl = new NBTMapType();

    // Act
    MapType actualMap = nbtListType.getMap(1, dfl);

    // Assert
    assertSame(dfl, actualMap);
  }

  /**
   * Test {@link NBTListType#getMap(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getMap(int)}
   */
  @Test
  @DisplayName(
      "Test getMap(int) with 'index'; given NBTListType() addByte 'X'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType NBTListType.getMap(int)"})
  void testGetMapWithIndex_givenNBTListTypeAddByteX_thenThrowIllegalStateException() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> nbtListType.getMap(1));
  }

  /**
   * Test {@link NBTListType#setMap(int, MapType)}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#setMap(int, MapType)}
   */
  @Test
  @DisplayName(
      "Test setMap(int, MapType); given NBTListType() addByte 'X'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.setMap(int, MapType)"})
  void testSetMap_givenNBTListTypeAddByteX_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'X');

    NBTMapType resultTo = mock(NBTMapType.class);
    CompoundTag compoundTag = new CompoundTag();
    when(resultTo.getTag()).thenReturn(compoundTag);

    // Act
    nbtListType.setMap(1, resultTo);

    // Assert
    verify(resultTo).getTag();
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
    assertSame(compoundTag, tag.get(1));
  }

  /**
   * Test {@link NBTListType#getString(int, String)} with {@code index}, {@code dfl}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then return {@code Dfl}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getString(int, String)}
   */
  @Test
  @DisplayName(
      "Test getString(int, String) with 'index', 'dfl'; given NBTListType() addByte 'X'; then return 'Dfl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTListType.getString(int, String)"})
  void testGetStringWithIndexDfl_givenNBTListTypeAddByteX_thenReturnDfl() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertEquals("Dfl", nbtListType.getString(1, "Dfl"));
  }

  /**
   * Test {@link NBTListType#getString(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#getString(int)}
   */
  @Test
  @DisplayName(
      "Test getString(int) with 'index'; given NBTListType() addByte 'X'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NBTListType.getString(int)"})
  void testGetStringWithIndex_givenNBTListTypeAddByteX_thenThrowIllegalStateException() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'X');
    nbtListType.addByte((byte) 'A');

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> nbtListType.getString(1));
  }

  /**
   * Test {@link NBTListType#addByte(byte)} with {@code b}.
   *
   * <p>Method under test: {@link NBTListType#addByte(byte)}
   */
  @Test
  @DisplayName("Test addByte(byte) with 'b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addByte(byte)"})
  void testAddByteWithB() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addByte((byte) 'A');

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.BYTE, nbtListType.getUniformType());
    assertEquals('A', ((ByteTag) tag.get(0)).value());
  }

  /**
   * Test {@link NBTListType#addByte(int, byte)} with {@code index}, {@code b}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code A}.
   *   <li>Then {@link NBTListType#NBTListType()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addByte(int, byte)}
   */
  @Test
  @DisplayName(
      "Test addByte(int, byte) with 'index', 'b'; given NBTListType() addByte 'A'; then NBTListType() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addByte(int, byte)"})
  void testAddByteWithIndexB_givenNBTListTypeAddByteA_thenNBTListTypeSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addByte(1, (byte) 'A');

    // Assert
    assertEquals(2, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag expectedGetResult = tag.get(0);
    assertSame(expectedGetResult, tag.get(1));
  }

  /**
   * Test {@link NBTListType#addShort(int, short)} with {@code index}, {@code s}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is minus one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test addShort(int, short) with 'index', 's'; then NBTListType() Tag second value is minus one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addShort(int, short)"})
  void testAddShortWithIndexS_thenNBTListTypeTagSecondValueIsMinusOneHundredTwentyNine() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addShort(1, (short) -129);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ShortTag);
    assertEquals((short) -129, ((ShortTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addShort(int, short)} with {@code index}, {@code s}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test addShort(int, short) with 'index', 's'; then NBTListType() Tag second value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addShort(int, short)"})
  void testAddShortWithIndexS_thenNBTListTypeTagSecondValueIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addShort(1, (short) 1);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ShortTag);
    assertEquals((short) 1, ((ShortTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addShort(int, short)} with {@code index}, {@code s}.
   *
   * <ul>
   *   <li>When {@code 1025}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is {@code 1025}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addShort(int, short)}
   */
  @Test
  @DisplayName(
      "Test addShort(int, short) with 'index', 's'; when '1025'; then NBTListType() Tag second value is '1025'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addShort(int, short)"})
  void testAddShortWithIndexS_when1025_thenNBTListTypeTagSecondValueIs1025() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addShort(1, (short) 1025);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ShortTag);
    assertEquals((short) 1025, ((ShortTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addShort(short)} with {@code s}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is minus one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addShort(short)}
   */
  @Test
  @DisplayName(
      "Test addShort(short) with 's'; then NBTListType() Tag first value is minus one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addShort(short)"})
  void testAddShortWithS_thenNBTListTypeTagFirstValueIsMinusOneHundredTwentyNine() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addShort((short) -129);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals((short) -129, ((ShortTag) tag.get(0)).value());
    assertEquals(1, nbtListType.size());
    assertEquals(ObjectType.SHORT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addShort(short)} with {@code s}.
   *
   * <ul>
   *   <li>When {@code 1025}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is {@code 1025}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addShort(short)}
   */
  @Test
  @DisplayName(
      "Test addShort(short) with 's'; when '1025'; then NBTListType() Tag first value is '1025'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addShort(short)"})
  void testAddShortWithS_when1025_thenNBTListTypeTagFirstValueIs1025() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addShort((short) 1025);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals((short) 1025, ((ShortTag) tag.get(0)).value());
    assertEquals(ObjectType.SHORT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addShort(short)} with {@code s}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addShort(short)}
   */
  @Test
  @DisplayName("Test addShort(short) with 's'; when one; then NBTListType() Tag first value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addShort(short)"})
  void testAddShortWithS_whenOne_thenNBTListTypeTagFirstValueIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addShort((short) 1);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals((short) 1, ((ShortTag) tag.get(0)).value());
    assertEquals(ObjectType.SHORT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addInt(int)} with {@code i}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is minus one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addInt(int)}
   */
  @Test
  @DisplayName(
      "Test addInt(int) with 'i'; then NBTListType() Tag first value is minus one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addInt(int)"})
  void testAddIntWithI_thenNBTListTypeTagFirstValueIsMinusOneHundredTwentyNine() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addInt(-129);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(-129, ((IntTag) tag.get(0)).value());
    assertEquals(1, nbtListType.size());
    assertEquals(ObjectType.INT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addInt(int)} with {@code i}.
   *
   * <ul>
   *   <li>When {@code 1025}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is {@code 1025}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addInt(int)}
   */
  @Test
  @DisplayName(
      "Test addInt(int) with 'i'; when '1025'; then NBTListType() Tag first value is '1025'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addInt(int)"})
  void testAddIntWithI_when1025_thenNBTListTypeTagFirstValueIs1025() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addInt(1025);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(1025, ((IntTag) tag.get(0)).value());
    assertEquals(ObjectType.INT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addInt(int)} with {@code i}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addInt(int)}
   */
  @Test
  @DisplayName("Test addInt(int) with 'i'; when two; then NBTListType() Tag first value is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addInt(int)"})
  void testAddIntWithI_whenTwo_thenNBTListTypeTagFirstValueIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addInt(2);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(2, ((IntTag) tag.get(0)).value());
    assertEquals(ObjectType.INT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addInt(int, int)} with {@code index}, {@code i}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is minus one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test addInt(int, int) with 'index', 'i'; then NBTListType() Tag second value is minus one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addInt(int, int)"})
  void testAddIntWithIndexI_thenNBTListTypeTagSecondValueIsMinusOneHundredTwentyNine() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addInt(1, -129);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof IntTag);
    assertEquals(-129, ((IntTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addInt(int, int)} with {@code index}, {@code i}.
   *
   * <ul>
   *   <li>When {@code 1025}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is {@code 1025}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test addInt(int, int) with 'index', 'i'; when '1025'; then NBTListType() Tag second value is '1025'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addInt(int, int)"})
  void testAddIntWithIndexI_when1025_thenNBTListTypeTagSecondValueIs1025() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addInt(1, 1025);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof IntTag);
    assertEquals(1025, ((IntTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addInt(int, int)} with {@code index}, {@code i}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test addInt(int, int) with 'index', 'i'; when two; then NBTListType() Tag second value is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addInt(int, int)"})
  void testAddIntWithIndexI_whenTwo_thenNBTListTypeTagSecondValueIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addInt(1, 2);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof IntTag);
    assertEquals(2, nbtListType.size());
    assertEquals(2, ((IntTag) getResult).value());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addLong(int, long)} with {@code index}, {@code l}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is minus one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test addLong(int, long) with 'index', 'l'; then NBTListType() Tag second value is minus one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addLong(int, long)"})
  void testAddLongWithIndexL_thenNBTListTypeTagSecondValueIsMinusOneHundredTwentyNine() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addLong(1, -129L);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof LongTag);
    assertEquals(-129L, ((LongTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addLong(int, long)} with {@code index}, {@code l}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test addLong(int, long) with 'index', 'l'; then NBTListType() Tag second value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addLong(int, long)"})
  void testAddLongWithIndexL_thenNBTListTypeTagSecondValueIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addLong(1, 1L);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof LongTag);
    assertEquals(1L, ((LongTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addLong(int, long)} with {@code index}, {@code l}.
   *
   * <ul>
   *   <li>When {@code 1025}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag second value is {@code 1025}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addLong(int, long)}
   */
  @Test
  @DisplayName(
      "Test addLong(int, long) with 'index', 'l'; when '1025'; then NBTListType() Tag second value is '1025'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addLong(int, long)"})
  void testAddLongWithIndexL_when1025_thenNBTListTypeTagSecondValueIs1025() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addLong(1, 1025L);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof LongTag);
    assertEquals(1025L, ((LongTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addLong(long)} with {@code l}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is minus one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addLong(long)}
   */
  @Test
  @DisplayName(
      "Test addLong(long) with 'l'; then NBTListType() Tag first value is minus one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addLong(long)"})
  void testAddLongWithL_thenNBTListTypeTagFirstValueIsMinusOneHundredTwentyNine() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addLong(-129L);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(-129L, ((LongTag) tag.get(0)).value());
    assertEquals(1, nbtListType.size());
    assertEquals(ObjectType.LONG, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addLong(long)} with {@code l}.
   *
   * <ul>
   *   <li>When {@code 1025}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is {@code 1025}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addLong(long)}
   */
  @Test
  @DisplayName(
      "Test addLong(long) with 'l'; when '1025'; then NBTListType() Tag first value is '1025'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addLong(long)"})
  void testAddLongWithL_when1025_thenNBTListTypeTagFirstValueIs1025() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addLong(1025L);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(1025L, ((LongTag) tag.get(0)).value());
    assertEquals(ObjectType.LONG, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addLong(long)} with {@code l}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addLong(long)}
   */
  @Test
  @DisplayName("Test addLong(long) with 'l'; when one; then NBTListType() Tag first value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addLong(long)"})
  void testAddLongWithL_whenOne_thenNBTListTypeTagFirstValueIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addLong(1L);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(1L, ((LongTag) tag.get(0)).value());
    assertEquals(ObjectType.LONG, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addFloat(float)} with {@code f}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addFloat(float)}
   */
  @Test
  @DisplayName("Test addFloat(float) with 'f'; when ten; then NBTListType() Tag first value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addFloat(float)"})
  void testAddFloatWithF_whenTen_thenNBTListTypeTagFirstValueIsTen() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addFloat(10.0f);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(10.0f, ((FloatTag) tag.get(0)).value());
    assertEquals(ObjectType.FLOAT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addFloat(float)} with {@code f}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addFloat(float)}
   */
  @Test
  @DisplayName(
      "Test addFloat(float) with 'f'; when zero; then NBTListType() Tag first value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addFloat(float)"})
  void testAddFloatWithF_whenZero_thenNBTListTypeTagFirstValueIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addFloat(0.0f);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(0.0f, ((FloatTag) tag.get(0)).value());
    assertEquals(1, nbtListType.size());
    assertEquals(ObjectType.FLOAT, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addFloat(int, float)} with {@code index}, {@code f}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code A}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addFloat(int, float)}
   */
  @Test
  @DisplayName(
      "Test addFloat(int, float) with 'index', 'f'; given NBTListType() addByte 'A'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addFloat(int, float)"})
  void testAddFloatWithIndexF_givenNBTListTypeAddByteA_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addFloat(1, 10.0f);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof FloatTag);
    assertEquals(10.0f, ((FloatTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addDouble(double)} with {@code d}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is ten.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addDouble(double)}
   */
  @Test
  @DisplayName(
      "Test addDouble(double) with 'd'; when ten; then NBTListType() Tag first value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addDouble(double)"})
  void testAddDoubleWithD_whenTen_thenNBTListTypeTagFirstValueIsTen() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addDouble(10.0d);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(10.0d, ((DoubleTag) tag.get(0)).value());
    assertEquals(ObjectType.DOUBLE, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addDouble(double)} with {@code d}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is zero.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addDouble(double)}
   */
  @Test
  @DisplayName(
      "Test addDouble(double) with 'd'; when zero; then NBTListType() Tag first value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addDouble(double)"})
  void testAddDoubleWithD_whenZero_thenNBTListTypeTagFirstValueIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addDouble(0.0d);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(0.0d, ((DoubleTag) tag.get(0)).value());
    assertEquals(1, nbtListType.size());
    assertEquals(ObjectType.DOUBLE, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addDouble(int, double)} with {@code index}, {@code d}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code A}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addDouble(int, double)}
   */
  @Test
  @DisplayName(
      "Test addDouble(int, double) with 'index', 'd'; given NBTListType() addByte 'A'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addDouble(int, double)"})
  void testAddDoubleWithIndexD_givenNBTListTypeAddByteA_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addDouble(1, 10.0d);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof DoubleTag);
    assertEquals(10.0d, ((DoubleTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addByteArray(byte[])} with {@code arr}.
   *
   * <p>Method under test: {@link NBTListType#addByteArray(byte[])}
   */
  @Test
  @DisplayName("Test addByteArray(byte[]) with 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addByteArray(byte[])"})
  void testAddByteArrayWithArr() throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    byte[] arr = "AXAXAXAX".getBytes("UTF-8");

    // Act
    nbtListType.addByteArray(arr);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(0);
    Stream<net.minecraft.nbt.Tag> streamResult = ((ByteArrayTag) getResult).stream();
    assertEquals(5, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals((byte) 7, getResult.getId());
    assertEquals(8, ((ByteArrayTag) getResult).size());
    assertEquals(ObjectType.BYTE_ARRAY, nbtListType.getUniformType());
    assertFalse(((ByteArrayTag) getResult).isEmpty());
    assertTrue(((ByteArrayTag) getResult).iterator().hasNext());
    assertSame(arr, ((ByteArrayTag) getResult).getAsByteArray());
  }

  /**
   * Test {@link NBTListType#addByteArray(int, byte[])} with {@code index}, {@code arr}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addByteArray(int, byte[])}
   */
  @Test
  @DisplayName(
      "Test addByteArray(int, byte[]) with 'index', 'arr'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addByteArray(int, byte[])"})
  void testAddByteArrayWithIndexArr_thenNBTListTypeTagSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');
    byte[] arr = "AXAXAXAX".getBytes("UTF-8");

    // Act
    nbtListType.addByteArray(1, arr);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof ByteArrayTag);
    assertTrue(tag.get(0) instanceof ByteTag);
    assertEquals(2, nbtListType.size());
    Stream<net.minecraft.nbt.Tag> streamResult = ((ByteArrayTag) getResult).stream();
    assertEquals(5, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals((byte) 7, ((ByteArrayTag) getResult).getId());
    assertEquals(8, ((ByteArrayTag) getResult).size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
    assertFalse(((ByteArrayTag) getResult).isEmpty());
    assertTrue(((ByteArrayTag) getResult).iterator().hasNext());
    assertSame(arr, ((ByteArrayTag) getResult).getAsByteArray());
  }

  /**
   * Test {@link NBTListType#addShortArray(short[])} with {@code arr}.
   *
   * <p>Method under test: {@link NBTListType#addShortArray(short[])}
   */
  @Test
  @DisplayName("Test addShortArray(short[]) with 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addShortArray(short[])"})
  void testAddShortArrayWithArr() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new NBTListType().addShortArray(new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link NBTListType#addShortArray(int, short[])} with {@code index}, {@code arr}.
   *
   * <p>Method under test: {@link NBTListType#addShortArray(int, short[])}
   */
  @Test
  @DisplayName("Test addShortArray(int, short[]) with 'index', 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addShortArray(int, short[])"})
  void testAddShortArrayWithIndexArr() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new NBTListType().addShortArray(1, new short[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link NBTListType#addIntArray(int[])} with {@code arr}.
   *
   * <p>Method under test: {@link NBTListType#addIntArray(int[])}
   */
  @Test
  @DisplayName("Test addIntArray(int[]) with 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addIntArray(int[])"})
  void testAddIntArrayWithArr() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    int[] arr = new int[] {2, 1, 2, 1};

    // Act
    nbtListType.addIntArray(arr);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(0);
    assertEquals((byte) 11, getResult.getId());
    Stream<net.minecraft.nbt.Tag> streamResult = ((IntArrayTag) getResult).stream();
    assertEquals(4, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals(4, ((IntArrayTag) getResult).size());
    assertEquals(ObjectType.INT_ARRAY, nbtListType.getUniformType());
    assertFalse(((IntArrayTag) getResult).isEmpty());
    assertTrue(((IntArrayTag) getResult).iterator().hasNext());
    assertSame(arr, ((IntArrayTag) getResult).getAsIntArray());
  }

  /**
   * Test {@link NBTListType#addIntArray(int, int[])} with {@code index}, {@code arr}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code A}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addIntArray(int, int[])}
   */
  @Test
  @DisplayName(
      "Test addIntArray(int, int[]) with 'index', 'arr'; given NBTListType() addByte 'A'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addIntArray(int, int[])"})
  void testAddIntArrayWithIndexArr_givenNBTListTypeAddByteA_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');
    int[] arr = new int[] {2, 1, 2, 1};

    // Act
    nbtListType.addIntArray(1, arr);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof IntArrayTag);
    assertEquals((byte) 11, ((IntArrayTag) getResult).getId());
    assertEquals(2, nbtListType.size());
    Stream<net.minecraft.nbt.Tag> streamResult = ((IntArrayTag) getResult).stream();
    assertEquals(4, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals(4, ((IntArrayTag) getResult).size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
    assertFalse(((IntArrayTag) getResult).isEmpty());
    assertTrue(((IntArrayTag) getResult).iterator().hasNext());
    assertSame(arr, ((IntArrayTag) getResult).getAsIntArray());
  }

  /**
   * Test {@link NBTListType#addLongArray(long[])} with {@code arr}.
   *
   * <p>Method under test: {@link NBTListType#addLongArray(long[])}
   */
  @Test
  @DisplayName("Test addLongArray(long[]) with 'arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addLongArray(long[])"})
  void testAddLongArrayWithArr() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    long[] arr = new long[] {1L, -1L, 1L, -1L};

    // Act
    nbtListType.addLongArray(arr);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    net.minecraft.nbt.Tag getResult = tag.get(0);
    Stream<net.minecraft.nbt.Tag> streamResult = ((LongArrayTag) getResult).stream();
    assertEquals(4, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals(4, ((LongArrayTag) getResult).size());
    assertEquals(ObjectType.LONG_ARRAY, nbtListType.getUniformType());
    assertFalse(((LongArrayTag) getResult).isEmpty());
    assertTrue(((LongArrayTag) getResult).iterator().hasNext());
    assertEquals('\f', getResult.getId());
    assertSame(arr, ((LongArrayTag) getResult).getAsLongArray());
  }

  /**
   * Test {@link NBTListType#addLongArray(int, long[])} with {@code index}, {@code arr}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addLongArray(int, long[])}
   */
  @Test
  @DisplayName(
      "Test addLongArray(int, long[]) with 'index', 'arr'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addLongArray(int, long[])"})
  void testAddLongArrayWithIndexArr_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');
    long[] arr = new long[] {1L, -1L, 1L, -1L};

    // Act
    nbtListType.addLongArray(1, arr);

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof LongArrayTag);
    assertEquals(2, nbtListType.size());
    Stream<net.minecraft.nbt.Tag> streamResult = ((LongArrayTag) getResult).stream();
    assertEquals(4, streamResult.limit(5).collect(Collectors.toList()).size());
    assertEquals(4, ((LongArrayTag) getResult).size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
    assertFalse(((LongArrayTag) getResult).isEmpty());
    assertTrue(((LongArrayTag) getResult).iterator().hasNext());
    assertEquals('\f', ((LongArrayTag) getResult).getId());
    assertSame(arr, ((LongArrayTag) getResult).getAsLongArray());
  }

  /**
   * Test {@link NBTListType#addMap(int, MapType)} with {@code index}, {@code map}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()} addByte {@code A}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addMap(int, MapType)}
   */
  @Test
  @DisplayName(
      "Test addMap(int, MapType) with 'index', 'map'; given NBTListType() addByte 'A'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addMap(int, MapType)"})
  void testAddMapWithIndexMap_givenNBTListTypeAddByteA_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addMap(1, new NBTMapType());

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addMap(MapType)} with {@code map}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTListType#NBTListType()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addMap(MapType)}
   */
  @Test
  @DisplayName("Test addMap(MapType) with 'map'; when NBTMapType(); then NBTListType() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addMap(MapType)"})
  void testAddMapWithMap_whenNBTMapType_thenNBTListTypeSizeIsOne() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addMap(new NBTMapType());

    // Assert
    assertEquals(1, nbtListType.size());
    assertEquals(1, nbtListType.getTag().size());
    assertEquals(ObjectType.MAP, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addString(int, String)} with {@code index}, {@code string}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag size is two.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addString(int, String)}
   */
  @Test
  @DisplayName(
      "Test addString(int, String) with 'index', 'string'; then NBTListType() Tag size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addString(int, String)"})
  void testAddStringWithIndexString_thenNBTListTypeTagSizeIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    nbtListType.addByte((byte) 'A');

    // Act
    nbtListType.addString(1, "String");

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(2, tag.size());
    assertTrue(tag.get(0) instanceof ByteTag);
    net.minecraft.nbt.Tag getResult = tag.get(1);
    assertTrue(getResult instanceof StringTag);
    assertEquals("String", ((StringTag) getResult).value());
    assertEquals(2, nbtListType.size());
    assertEquals(ObjectType.MIXED, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addString(String)} with {@code string}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is empty string.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addString(String)}
   */
  @Test
  @DisplayName(
      "Test addString(String) with 'string'; then NBTListType() Tag first value is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addString(String)"})
  void testAddStringWithString_thenNBTListTypeTagFirstValueIsEmptyString() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addString("");

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals("", ((StringTag) tag.get(0)).value());
    assertEquals(1, nbtListType.size());
    assertEquals(ObjectType.STRING, nbtListType.getUniformType());
  }

  /**
   * Test {@link NBTListType#addString(String)} with {@code string}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link NBTListType#addString(String)}
   */
  @Test
  @DisplayName(
      "Test addString(String) with 'string'; when 'String'; then NBTListType() Tag first value is 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NBTListType.addString(String)"})
  void testAddStringWithString_whenString_thenNBTListTypeTagFirstValueIsString() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addString("String");

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals("String", ((StringTag) tag.get(0)).value());
    assertEquals(1, nbtListType.size());
    assertEquals(ObjectType.STRING, nbtListType.getUniformType());
  }
}
