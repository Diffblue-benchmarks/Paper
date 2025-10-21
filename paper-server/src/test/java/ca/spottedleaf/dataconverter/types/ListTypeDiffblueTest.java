package ca.spottedleaf.dataconverter.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.ShortTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ListTypeDiffblueTest {
  /**
   * Test {@link ListType#setGeneric(int, Object)}.
   *
   * <ul>
   *   <li>When {@link Bootstrap#bootstrapDuration}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#setGeneric(int, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(int, Object); when bootstrapDuration; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.setGeneric(int, Object)"})
  void testSetGeneric_whenBootstrapDuration_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NBTListType().setGeneric(1, Bootstrap.bootstrapDuration));
  }

  /**
   * Test {@link ListType#setGeneric(int, Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#setGeneric(int, Object)}
   */
  @Test
  @DisplayName(
      "Test setGeneric(int, Object); when WILDCARD_OBJECT; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.setGeneric(int, Object)"})
  void testSetGeneric_whenWildcard_object_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NBTListType().setGeneric(1, ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is {@code
   *       alice.liddell@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName(
      "Test addGeneric(Object); then NBTListType() Tag first value is 'alice.liddell@example.org'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_thenNBTListTypeTagFirstValueIsAliceLiddellExampleOrg() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addGeneric("alice.liddell@example.org");

    // Assert
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals("alice.liddell@example.org", ((StringTag) tag.get(0)).value());
    assertEquals(1, nbtListType.size());
    assertEquals(ObjectType.STRING, nbtListType.getUniformType());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then {@link NBTListType#NBTListType()} UniformType is {@code BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName("Test addGeneric(Object); when 'A'; then NBTListType() UniformType is 'BYTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenA_thenNBTListTypeUniformTypeIsByte() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addGeneric((byte) 'A');

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(ObjectType.BYTE, nbtListType.getUniformType());
    assertEquals('A', ((ByteTag) tag.get(0)).value());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@link Bootstrap#bootstrapDuration}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName(
      "Test addGeneric(Object); when bootstrapDuration; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenBootstrapDuration_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NBTListType().addGeneric(Bootstrap.bootstrapDuration));
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@link NBTListType#NBTListType()}.
   *   <li>Then {@link NBTListType#NBTListType()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName("Test addGeneric(Object); when NBTListType(); then NBTListType() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenNBTListType_thenNBTListTypeSizeIsZero() {
    // Arrange
    NBTListType nbtListType = new NBTListType();
    NBTListType nbtListType2 = new NBTListType();

    // Act
    nbtListType.addGeneric(nbtListType2);

    // Assert that nothing has changed
    assertEquals(0, nbtListType2.size());
    assertEquals(ObjectType.NONE, nbtListType2.getUniformType());
    assertTrue(nbtListType2.getTag().isEmpty());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then {@link NBTListType#NBTListType()} UniformType is {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName(
      "Test addGeneric(Object); when NBTMapType(); then NBTListType() UniformType is 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenNBTMapType_thenNBTListTypeUniformTypeIsMap() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addGeneric(new NBTMapType());

    // Assert
    assertEquals(1, nbtListType.size());
    assertEquals(1, nbtListType.getTag().size());
    assertEquals(ObjectType.MAP, nbtListType.getUniformType());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link NBTListType#NBTListType()} UniformType is {@code LONG}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName("Test addGeneric(Object); when one; then NBTListType() UniformType is 'LONG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenOne_thenNBTListTypeUniformTypeIsLong() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addGeneric(1L);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(1L, ((LongTag) tag.get(0)).value());
    assertEquals(ObjectType.LONG, nbtListType.getUniformType());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link NBTListType#NBTListType()} UniformType is {@code SHORT}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName("Test addGeneric(Object); when one; then NBTListType() UniformType is 'SHORT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenOne_thenNBTListTypeUniformTypeIsShort() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addGeneric((short) 1);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals((short) 1, ((ShortTag) tag.get(0)).value());
    assertEquals(ObjectType.SHORT, nbtListType.getUniformType());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link NBTListType#NBTListType()} UniformType is {@code DOUBLE}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName("Test addGeneric(Object); when ten; then NBTListType() UniformType is 'DOUBLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenTen_thenNBTListTypeUniformTypeIsDouble() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addGeneric(10.0d);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(10.0d, ((DoubleTag) tag.get(0)).value());
    assertEquals(ObjectType.DOUBLE, nbtListType.getUniformType());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link NBTListType#NBTListType()} UniformType is {@code FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName("Test addGeneric(Object); when ten; then NBTListType() UniformType is 'FLOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenTen_thenNBTListTypeUniformTypeIsFloat() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addGeneric(10.0f);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(10.0f, ((FloatTag) tag.get(0)).value());
    assertEquals(ObjectType.FLOAT, nbtListType.getUniformType());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then {@link NBTListType#NBTListType()} Tag first value is two.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName("Test addGeneric(Object); when two; then NBTListType() Tag first value is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenTwo_thenNBTListTypeTagFirstValueIsTwo() {
    // Arrange
    NBTListType nbtListType = new NBTListType();

    // Act
    nbtListType.addGeneric(2);

    // Assert
    assertEquals(1, nbtListType.size());
    ListTag tag = nbtListType.getTag();
    assertEquals(1, tag.size());
    assertEquals(2, ((IntTag) tag.get(0)).value());
    assertEquals(ObjectType.INT, nbtListType.getUniformType());
  }

  /**
   * Test {@link ListType#addGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ListType#addGeneric(Object)}
   */
  @Test
  @DisplayName("Test addGeneric(Object); when WILDCARD_OBJECT; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListType.addGeneric(Object)"})
  void testAddGeneric_whenWildcard_object_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NBTListType().addGeneric(ConfigurationTransformation.WILDCARD_OBJECT));
  }
}
