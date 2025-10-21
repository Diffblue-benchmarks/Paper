package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CauldronDiffblueTest {
  /**
   * Test {@link Cauldron#Cauldron(Material, byte)}.
   *
   * <p>Method under test: {@link Cauldron#Cauldron(Material, byte)}
   */
  @Test
  @DisplayName("Test new Cauldron(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cauldron.<init>(Material, byte)"})
  void testNewCauldron() {
    // Arrange and Act
    Cauldron actualCauldron = new Cauldron(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualCauldron.getItemType());
    assertEquals('A', actualCauldron.getData());
  }

  /**
   * Test {@link Cauldron#Cauldron()}.
   *
   * <p>Method under test: {@link Cauldron#Cauldron()}
   */
  @Test
  @DisplayName("Test new Cauldron()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cauldron.<init>()"})
  void testNewCauldron2() {
    // Arrange and Act
    Cauldron actualCauldron = new Cauldron();

    // Assert
    assertEquals((byte) 0, actualCauldron.getData());
    assertEquals(Material.LEGACY_CAULDRON, actualCauldron.getItemType());
    assertFalse(actualCauldron.isFull());
    assertTrue(actualCauldron.isEmpty());
  }

  /**
   * Test {@link Cauldron#Cauldron(byte)}.
   *
   * <p>Method under test: {@link Cauldron#Cauldron(byte)}
   */
  @Test
  @DisplayName("Test new Cauldron(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cauldron.<init>(byte)"})
  void testNewCauldron3() {
    // Arrange and Act
    Cauldron actualCauldron = new Cauldron((byte) 'A');

    // Assert
    assertEquals(Material.LEGACY_CAULDRON, actualCauldron.getItemType());
    assertFalse(actualCauldron.isEmpty());
    assertTrue(actualCauldron.isFull());
    assertEquals('A', actualCauldron.getData());
  }

  /**
   * Test {@link Cauldron#isFull()}.
   *
   * <ul>
   *   <li>Given {@link Cauldron#Cauldron(byte)} with data is three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Cauldron#isFull()}
   */
  @Test
  @DisplayName("Test isFull(); given Cauldron(byte) with data is three; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Cauldron.isFull()"})
  void testIsFull_givenCauldronWithDataIsThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Cauldron((byte) 3).isFull());
  }

  /**
   * Test {@link Cauldron#isFull()}.
   *
   * <ul>
   *   <li>Given {@link Cauldron#Cauldron()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Cauldron#isFull()}
   */
  @Test
  @DisplayName("Test isFull(); given Cauldron(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Cauldron.isFull()"})
  void testIsFull_givenCauldron_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Cauldron().isFull());
  }

  /**
   * Test {@link Cauldron#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link Cauldron#Cauldron(byte)} with data is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Cauldron#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given Cauldron(byte) with data is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Cauldron.isEmpty()"})
  void testIsEmpty_givenCauldronWithDataIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Cauldron((byte) 1).isEmpty());
  }

  /**
   * Test {@link Cauldron#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link Cauldron#Cauldron()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Cauldron#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given Cauldron(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Cauldron.isEmpty()"})
  void testIsEmpty_givenCauldron_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Cauldron().isEmpty());
  }

  /**
   * Test {@link Cauldron#toString()}.
   *
   * <ul>
   *   <li>Given {@link Cauldron#Cauldron(byte)} with data is one.
   *   <li>Then return {@code 1/3 FULL CAULDRON}.
   * </ul>
   *
   * <p>Method under test: {@link Cauldron#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Cauldron(byte) with data is one; then return '1/3 FULL CAULDRON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Cauldron.toString()"})
  void testToString_givenCauldronWithDataIsOne_thenReturn13FullCauldron() {
    // Arrange, Act and Assert
    assertEquals("1/3 FULL CAULDRON", new Cauldron((byte) 1).toString());
  }

  /**
   * Test {@link Cauldron#toString()}.
   *
   * <ul>
   *   <li>Given {@link Cauldron#Cauldron(byte)} with data is three.
   *   <li>Then return {@code FULL CAULDRON}.
   * </ul>
   *
   * <p>Method under test: {@link Cauldron#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Cauldron(byte) with data is three; then return 'FULL CAULDRON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Cauldron.toString()"})
  void testToString_givenCauldronWithDataIsThree_thenReturnFullCauldron() {
    // Arrange, Act and Assert
    assertEquals("FULL CAULDRON", new Cauldron((byte) 3).toString());
  }

  /**
   * Test {@link Cauldron#toString()}.
   *
   * <ul>
   *   <li>Given {@link Cauldron#Cauldron()}.
   *   <li>Then return {@code EMPTY CAULDRON}.
   * </ul>
   *
   * <p>Method under test: {@link Cauldron#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Cauldron(); then return 'EMPTY CAULDRON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Cauldron.toString()"})
  void testToString_givenCauldron_thenReturnEmptyCauldron() {
    // Arrange, Act and Assert
    assertEquals("EMPTY CAULDRON", new Cauldron().toString());
  }

  /**
   * Test {@link Cauldron#clone()}.
   *
   * <p>Method under test: {@link Cauldron#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Cauldron Cauldron.clone()"})
  void testClone() {
    // Arrange
    Cauldron cauldron = new Cauldron();

    // Act
    Cauldron actualCloneResult = cauldron.clone();

    // Assert
    assertEquals(cauldron, actualCloneResult);
  }
}
