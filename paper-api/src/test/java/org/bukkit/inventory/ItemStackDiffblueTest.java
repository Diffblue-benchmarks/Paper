package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ItemStackDiffblueTest {
  /**
   * Test {@link ItemStack#serializeItemsAsBytes(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ItemStack#serializeItemsAsBytes(Collection)}
   */
  @Test
  @DisplayName(
      "Test serializeItemsAsBytes(Collection) with 'Collection'; given 'null'; when LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ItemStack.serializeItemsAsBytes(Collection)"})
  void testSerializeItemsAsBytesWithCollection_givenNull_whenLinkedHashSetAddNull() {
    // Arrange
    LinkedHashSet<ItemStack> items = new LinkedHashSet<>();
    items.add(null);

    // Act and Assert
    assertArrayEquals(
        new byte[] {1, 0, 0, 0, 1, 0, 0, 0, 0}, ItemStack.serializeItemsAsBytes(items));
  }

  /**
   * Test {@link ItemStack#serializeItemsAsBytes(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ItemStack#serializeItemsAsBytes(Collection)}
   */
  @Test
  @DisplayName("Test serializeItemsAsBytes(Collection) with 'Collection'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ItemStack.serializeItemsAsBytes(Collection)"})
  void testSerializeItemsAsBytesWithCollection_whenArrayList() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {1, 0, 0, 0, 0}, ItemStack.serializeItemsAsBytes(new ArrayList<>()));
  }

  /**
   * Test {@link ItemStack#deserializeItemsFromBytes(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ItemStack#deserializeItemsFromBytes(byte[])}
   */
  @Test
  @DisplayName("Test deserializeItemsFromBytes(byte[]); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack[] ItemStack.deserializeItemsFromBytes(byte[])"})
  void testDeserializeItemsFromBytes_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ItemStack.deserializeItemsFromBytes("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ItemStack#deserializeItemsFromBytes(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ItemStack#deserializeItemsFromBytes(byte[])}
   */
  @Test
  @DisplayName("Test deserializeItemsFromBytes(byte[]); when array of byte with one and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack[] ItemStack.deserializeItemsFromBytes(byte[])"})
  void testDeserializeItemsFromBytes_whenArrayOfByteWithOneAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ItemStack.deserializeItemsFromBytes(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ItemStack#deserializeItemsFromBytes(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ItemStack#deserializeItemsFromBytes(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserializeItemsFromBytes(byte[]); when empty array of byte; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack[] ItemStack.deserializeItemsFromBytes(byte[])"})
  void testDeserializeItemsFromBytes_whenEmptyArrayOfByte_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ItemStack.deserializeItemsFromBytes(new byte[] {}));
  }
}
