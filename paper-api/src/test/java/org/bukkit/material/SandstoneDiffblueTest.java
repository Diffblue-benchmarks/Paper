package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.SandstoneType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SandstoneDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code null ACACIA_BOAT(65)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Sandstone#Sandstone(Material, byte)}
   *   <li>{@link Sandstone#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return toString is 'null ACACIA_BOAT(65)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Sandstone.<init>(Material)",
    "void Sandstone.<init>(Material, byte)",
    "java.lang.String Sandstone.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsNullAcaciaBoat65() {
    // Arrange and Act
    Sandstone actualSandstone = new Sandstone(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("null ACACIA_BOAT(65)", actualSandstone.toString());
    assertEquals(Material.ACACIA_BOAT, actualSandstone.getItemType());
    assertEquals('A', actualSandstone.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code CRACKED ACACIA_BOAT(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Sandstone#Sandstone(Material)}
   *   <li>{@link Sandstone#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'CRACKED ACACIA_BOAT(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Sandstone.<init>(Material)",
    "void Sandstone.<init>(Material, byte)",
    "java.lang.String Sandstone.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsCrackedAcaciaBoat0() {
    // Arrange and Act
    Sandstone actualSandstone = new Sandstone(Material.ACACIA_BOAT);

    // Assert
    assertEquals("CRACKED ACACIA_BOAT(0)", actualSandstone.toString());
    assertEquals((byte) 0, actualSandstone.getData());
    assertEquals(Material.ACACIA_BOAT, actualSandstone.getItemType());
  }

  /**
   * Test {@link Sandstone#Sandstone()}.
   *
   * <p>Method under test: {@link Sandstone#Sandstone()}
   */
  @Test
  @DisplayName("Test new Sandstone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sandstone.<init>()"})
  void testNewSandstone() {
    // Arrange and Act
    Sandstone actualSandstone = new Sandstone();

    // Assert
    assertEquals((byte) 0, actualSandstone.getData());
    assertEquals(Material.LEGACY_SANDSTONE, actualSandstone.getItemType());
    assertEquals(SandstoneType.CRACKED, actualSandstone.getType());
  }

  /**
   * Test {@link Sandstone#Sandstone(SandstoneType)}.
   *
   * <p>Method under test: {@link Sandstone#Sandstone(SandstoneType)}
   */
  @Test
  @DisplayName("Test new Sandstone(SandstoneType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Sandstone.<init>(SandstoneType)"})
  void testNewSandstone2() {
    // Arrange and Act
    Sandstone actualSandstone = new Sandstone(SandstoneType.CRACKED);

    // Assert
    assertEquals((byte) 0, actualSandstone.getData());
    assertEquals(Material.LEGACY_SANDSTONE, actualSandstone.getItemType());
    assertEquals(SandstoneType.CRACKED, actualSandstone.getType());
  }

  /**
   * Test {@link Sandstone#getType()}.
   *
   * <p>Method under test: {@link Sandstone#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SandstoneType Sandstone.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(SandstoneType.CRACKED, new Sandstone().getType());
  }

  /**
   * Test {@link Sandstone#clone()}.
   *
   * <p>Method under test: {@link Sandstone#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sandstone Sandstone.clone()"})
  void testClone() {
    // Arrange
    Sandstone sandstone = new Sandstone();

    // Act
    Sandstone actualCloneResult = sandstone.clone();

    // Assert
    assertEquals(sandstone, actualCloneResult);
  }
}
