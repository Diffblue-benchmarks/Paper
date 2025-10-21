package io.papermc.paper.persistence;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.EndTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.inventory.tags.DeprecatedItemTagType;
import org.bukkit.craftbukkit.persistence.CraftPersistentDataContainer;
import org.bukkit.craftbukkit.persistence.CraftPersistentDataTypeRegistry;
import org.bukkit.inventory.meta.tags.ItemTagType;
import org.bukkit.persistence.PersistentDataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class PaperPersistentDataContainerViewDiffblueTest {
  /**
   * Test {@link PaperPersistentDataContainerView#has(NamespacedKey, PersistentDataType)} with
   * {@code key}, {@code type}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#has(NamespacedKey,
   * PersistentDataType)}
   */
  @Test
  @DisplayName(
      "Test has(NamespacedKey, PersistentDataType) with 'key', 'type'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaperPersistentDataContainerView.has(NamespacedKey, PersistentDataType)"
  })
  void testHasWithKeyType_thenReturnFalse() {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    NamespacedKey key = NamespacedKey.randomKey();

    // Act and Assert
    assertFalse(
        craftPersistentDataContainer.has(
            key, new DeprecatedItemTagType<>(mock(ItemTagType.class))));
  }

  /**
   * Test {@link PaperPersistentDataContainerView#has(NamespacedKey)} with {@code key}.
   *
   * <ul>
   *   <li>When randomKey.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#has(NamespacedKey)}
   */
  @Test
  @DisplayName("Test has(NamespacedKey) with 'key'; when randomKey; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperPersistentDataContainerView.has(NamespacedKey)"})
  void testHasWithKey_whenRandomKey_thenReturnFalse() {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());

    // Act and Assert
    assertFalse(craftPersistentDataContainer.has(NamespacedKey.randomKey()));
  }

  /**
   * Test {@link PaperPersistentDataContainerView#get(NamespacedKey, PersistentDataType)}.
   *
   * <ul>
   *   <li>When randomKey.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#get(NamespacedKey,
   * PersistentDataType)}
   */
  @Test
  @DisplayName("Test get(NamespacedKey, PersistentDataType); when randomKey; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object PaperPersistentDataContainerView.get(NamespacedKey, PersistentDataType)"
  })
  void testGet_whenRandomKey_thenReturnNull() {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    NamespacedKey key = NamespacedKey.randomKey();

    // Act and Assert
    assertNull(
        craftPersistentDataContainer.get(
            key, new DeprecatedItemTagType<>(mock(ItemTagType.class))));
  }

  /**
   * Test {@link PaperPersistentDataContainerView#getOrDefault(NamespacedKey, PersistentDataType,
   * Object)}.
   *
   * <ul>
   *   <li>When randomKey.
   *   <li>Then return {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#getOrDefault(NamespacedKey,
   * PersistentDataType, Object)}
   */
  @Test
  @DisplayName(
      "Test getOrDefault(NamespacedKey, PersistentDataType, Object); when randomKey; then return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object PaperPersistentDataContainerView.getOrDefault(NamespacedKey, PersistentDataType, Object)"
  })
  void testGetOrDefault_whenRandomKey_thenReturnWildcard_object() {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    NamespacedKey key = NamespacedKey.randomKey();
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualOrDefault =
        craftPersistentDataContainer.getOrDefault(
            key, new DeprecatedItemTagType<>(mock(ItemTagType.class)), object);

    // Assert
    assertSame(object, actualOrDefault);
  }

  /**
   * Test {@link PaperPersistentDataContainerView#getKeys()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#getKeys()}
   */
  @Test
  @DisplayName("Test getKeys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPersistentDataContainerView.getKeys()"})
  void testGetKeys() {
    // Arrange, Act and Assert
    assertTrue(
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry())
            .getKeys()
            .isEmpty());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#getKeys()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#getKeys()}
   */
  @Test
  @DisplayName("Test getKeys(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPersistentDataContainerView.getKeys()"})
  void testGetKeys_thenReturnEmpty() {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", ByteTag.ONE);

    // Act and Assert
    assertTrue(craftPersistentDataContainer.getKeys().isEmpty());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#getKeys()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#getKeys()}
   */
  @Test
  @DisplayName("Test getKeys(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPersistentDataContainerView.getKeys()"})
  void testGetKeys_thenReturnSizeIsOne() {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put(":", ByteTag.ONE);
    craftPersistentDataContainer.put("Key", ByteTag.ONE);

    // Act and Assert
    assertEquals(1, craftPersistentDataContainer.getKeys().size());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperPersistentDataContainerView.isEmpty()"})
  void testIsEmpty_thenReturnFalse() {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", ByteTag.ONE);

    // Act and Assert
    assertFalse(craftPersistentDataContainer.isEmpty());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperPersistentDataContainerView.isEmpty()"})
  void testIsEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry()).isEmpty());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, 0},
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry()).serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes2() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, 1, 0, 3, 'K', 'e', 'y', 1, 0},
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes3() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", DoubleTag.ZERO);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, 6, 0, 3, 'K', 'e', 'y', 0, 0, 0, 0, 0, 0, 0, 0, 0},
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes4() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", FloatTag.ZERO);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, 5, 0, 3, 'K', 'e', 'y', 0, 0, 0, 0, 0},
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes5() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", EndTag.INSTANCE);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, 0, 0}, craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes6() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", new ByteArrayTag("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', 0, 0, 7, 0, 3, 'K', 'e', 'y', 0, 0, 0, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X',
          0
        },
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes7() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", new CompoundTag());

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, '\n', 0, 3, 'K', 'e', 'y', 0, 0},
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes8() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", new ListTag());

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, '\t', 0, 3, 'K', 'e', 'y', 0, 0, 0, 0, 0, 0},
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes9() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", IntTag.valueOf(1));

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, 3, 0, 3, 'K', 'e', 'y', 0, 0, 0, 1, 0},
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName("Test serializeToBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes10() throws IOException {
    // Arrange
    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("42", ByteTag.ONE);
    craftPersistentDataContainer.put("Key", ByteTag.ONE);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, 1, 0, 3, 'K', 'e', 'y', 1, 1, 0, 2, '4', '2', 1, 0},
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Long {@code CompoundTag} is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName(
      "Test serializeToBytes(); given CompoundTag() Long 'net.minecraft.nbt.CompoundTag' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes_givenCompoundTagLongNetMinecraftNbtCompoundTagIsOne()
      throws IOException {
    // Arrange
    CompoundTag base = new CompoundTag();
    base.putLong("net.minecraft.nbt.CompoundTag", 1L);

    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", base);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', 0, 0, '\n', 0, 3, 'K', 'e', 'y', 4, 0, 29, 'n', 'e', 't', '.', 'm', 'i', 'n', 'e',
          'c', 'r', 'a', 'f', 't', '.', 'n', 'b', 't', '.', 'C', 'o', 'm', 'p', 'o', 'u', 'n', 'd',
          'T', 'a', 'g', 0, 0, 0, 0, 0, 0, 0, 1, 0, 0
        },
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} Short {@code CompoundTag} is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName(
      "Test serializeToBytes(); given CompoundTag() Short 'net.minecraft.nbt.CompoundTag' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes_givenCompoundTagShortNetMinecraftNbtCompoundTagIsZero()
      throws IOException {
    // Arrange
    CompoundTag base = new CompoundTag();
    base.putShort("net.minecraft.nbt.CompoundTag", (short) 0);

    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", base);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', 0, 0, '\n', 0, 3, 'K', 'e', 'y', 2, 0, 29, 'n', 'e', 't', '.', 'm', 'i', 'n', 'e',
          'c', 'r', 'a', 'f', 't', '.', 'n', 'b', 't', '.', 'C', 'o', 'm', 'p', 'o', 'u', 'n', 'd',
          'T', 'a', 'g', 0, 0, 0, 0
        },
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <ul>
   *   <li>Given {@link CompoundTag#CompoundTag()} String {@code CompoundTag} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName(
      "Test serializeToBytes(); given CompoundTag() String 'net.minecraft.nbt.CompoundTag' is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes_givenCompoundTagStringNetMinecraftNbtCompoundTagIsValue()
      throws IOException {
    // Arrange
    CompoundTag base = new CompoundTag();
    base.putString("net.minecraft.nbt.CompoundTag", "Value");

    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", base);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', 0, 0, '\n', 0, 3, 'K', 'e', 'y', '\b', 0, 29, 'n', 'e', 't', '.', 'm', 'i', 'n',
          'e', 'c', 'r', 'a', 'f', 't', '.', 'n', 'b', 't', '.', 'C', 'o', 'm', 'p', 'o', 'u', 'n',
          'd', 'T', 'a', 'g', 0, 5, 'V', 'a', 'l', 'u', 'e', 0, 0
        },
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <ul>
   *   <li>Given {@link ListTag#ListTag()} add {@link ByteTag#ONE}.
   *   <li>Then return array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName(
      "Test serializeToBytes(); given ListTag() add ONE; then return array of byte with lf and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes_givenListTagAddOne_thenReturnArrayOfByteWithLfAndZero()
      throws IOException {
    // Arrange
    ListTag base = new ListTag();
    base.add(ByteTag.ONE);

    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", base);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, '\t', 0, 3, 'K', 'e', 'y', 1, 0, 0, 0, 1, 1, 0},
        craftPersistentDataContainer.serializeToBytes());
  }

  /**
   * Test {@link PaperPersistentDataContainerView#serializeToBytes()}.
   *
   * <ul>
   *   <li>Given {@link ListTag#ListTag()} add {@link ByteTag#ONE}.
   *   <li>Then return array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperPersistentDataContainerView#serializeToBytes()}
   */
  @Test
  @DisplayName(
      "Test serializeToBytes(); given ListTag() add ONE; then return array of byte with lf and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PaperPersistentDataContainerView.serializeToBytes()"})
  void testSerializeToBytes_givenListTagAddOne_thenReturnArrayOfByteWithLfAndZero2()
      throws IOException {
    // Arrange
    ListTag base = new ListTag();
    base.add(ByteTag.ONE);
    base.add(ByteTag.ONE);

    CraftPersistentDataContainer craftPersistentDataContainer =
        new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
    craftPersistentDataContainer.put("Key", base);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\n', 0, 0, '\t', 0, 3, 'K', 'e', 'y', 1, 0, 0, 0, 2, 1, 1, 0},
        craftPersistentDataContainer.serializeToBytes());
  }
}
