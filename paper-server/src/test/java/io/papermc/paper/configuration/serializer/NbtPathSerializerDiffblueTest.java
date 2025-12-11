package io.papermc.paper.configuration.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.commands.arguments.NbtPathArgument;
import net.minecraft.commands.arguments.NbtPathArgument.NbtPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.serialize.SerializationException;

class NbtPathSerializerDiffblueTest {
  /**
   * Test {@link NbtPathSerializer#fromString(List)} with {@code tags}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link NbtPathSerializer#fromString(List)}
   */
  @Test
  @DisplayName(
      "Test fromString(List) with 'tags'; given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List NbtPathSerializer.fromString(List)"})
  void testFromStringWithTags_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<String> tags = new ArrayList<>();
    tags.add("42");
    tags.add("foo");

    // Act
    List<NbtPath> actualFromStringResult = NbtPathSerializer.fromString(tags);

    // Assert
    assertEquals(2, actualFromStringResult.size());
    assertEquals("42", actualFromStringResult.get(0).toString());
    assertEquals("foo", actualFromStringResult.get(1).toString());
  }

  /**
   * Test {@link NbtPathSerializer#fromString(List)} with {@code tags}.
   *
   * <ul>
   *   <li>Given {@code Tags}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Tags}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link NbtPathSerializer#fromString(List)}
   */
  @Test
  @DisplayName(
      "Test fromString(List) with 'tags'; given 'Tags'; when ArrayList() add 'Tags'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List NbtPathSerializer.fromString(List)"})
  void testFromStringWithTags_givenTags_whenArrayListAddTags_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<String> tags = new ArrayList<>();
    tags.add("Tags");

    // Act
    List<NbtPath> actualFromStringResult = NbtPathSerializer.fromString(tags);

    // Assert
    assertEquals(1, actualFromStringResult.size());
    assertEquals("Tags", actualFromStringResult.get(0).toString());
  }

  /**
   * Test {@link NbtPathSerializer#fromString(List)} with {@code tags}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link NbtPathSerializer#fromString(List)}
   */
  @Test
  @DisplayName("Test fromString(List) with 'tags'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List NbtPathSerializer.fromString(List)"})
  void testFromStringWithTags_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<NbtPath> actualFromStringResult = NbtPathSerializer.fromString(new ArrayList<>());

    // Assert
    assertTrue(actualFromStringResult.isEmpty());
  }

  /**
   * Test {@link NbtPathSerializer#deserialize(AnnotatedType, Object)} with {@code AnnotatedType},
   * {@code Object}.
   *
   * <p>Method under test: {@link NbtPathSerializer#deserialize(AnnotatedType, Object)}
   */
  @Test
  @DisplayName("Test deserialize(AnnotatedType, Object) with 'AnnotatedType', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NbtPath NbtPathSerializer.deserialize(AnnotatedType, Object)"})
  void testDeserializeWithAnnotatedTypeObject() throws SerializationException {
    // Arrange, Act and Assert
    assertEquals(
        "net.minecraft.commands.arguments.NbtPathArgument$NbtPath",
        NbtPathSerializer.SERIALIZER
            .deserialize(
                (AnnotatedType) null, "net.minecraft.commands.arguments.NbtPathArgument$NbtPath")
            .toString());
  }

  /**
   * Test {@link NbtPathSerializer#deserialize(AnnotatedType, Object)} with {@code AnnotatedType},
   * {@code Object}.
   *
   * <ul>
   *   <li>Then return toString is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link NbtPathSerializer#deserialize(AnnotatedType, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(AnnotatedType, Object) with 'AnnotatedType', 'Object'; then return toString is 'java.lang.String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NbtPath NbtPathSerializer.deserialize(AnnotatedType, Object)"})
  void testDeserializeWithAnnotatedTypeObject_thenReturnToStringIsJavaLangString()
      throws SerializationException {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang.String",
        NbtPathSerializer.SERIALIZER
            .deserialize((AnnotatedType) null, "java.lang.String")
            .toString());
  }

  /**
   * Test {@link NbtPathSerializer#deserialize(AnnotatedType, Object)} with {@code AnnotatedType},
   * {@code Object}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return toString is {@code Obj}.
   * </ul>
   *
   * <p>Method under test: {@link NbtPathSerializer#deserialize(AnnotatedType, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(AnnotatedType, Object) with 'AnnotatedType', 'Object'; when 'Obj'; then return toString is 'Obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NbtPath NbtPathSerializer.deserialize(AnnotatedType, Object)"})
  void testDeserializeWithAnnotatedTypeObject_whenObj_thenReturnToStringIsObj()
      throws SerializationException {
    // Arrange, Act and Assert
    assertEquals(
        "Obj", NbtPathSerializer.SERIALIZER.deserialize((AnnotatedType) null, "Obj").toString());
  }
}
