package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.GrassSpecies;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LongGrassDiffblueTest {
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
   *   <li>{@link LongGrass#LongGrass(Material, byte)}
   *   <li>{@link LongGrass#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return toString is 'null ACACIA_BOAT(65)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LongGrass.<init>(Material)",
    "void LongGrass.<init>(Material, byte)",
    "java.lang.String LongGrass.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsNullAcaciaBoat65() {
    // Arrange and Act
    LongGrass actualLongGrass = new LongGrass(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("null ACACIA_BOAT(65)", actualLongGrass.toString());
    assertEquals(Material.ACACIA_BOAT, actualLongGrass.getItemType());
    assertEquals('A', actualLongGrass.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code DEAD ACACIA_BOAT(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongGrass#LongGrass(Material)}
   *   <li>{@link LongGrass#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'DEAD ACACIA_BOAT(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LongGrass.<init>(Material)",
    "void LongGrass.<init>(Material, byte)",
    "java.lang.String LongGrass.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsDeadAcaciaBoat0() {
    // Arrange and Act
    LongGrass actualLongGrass = new LongGrass(Material.ACACIA_BOAT);

    // Assert
    assertEquals("DEAD ACACIA_BOAT(0)", actualLongGrass.toString());
    assertEquals((byte) 0, actualLongGrass.getData());
    assertEquals(Material.ACACIA_BOAT, actualLongGrass.getItemType());
  }

  /**
   * Test {@link LongGrass#LongGrass()}.
   *
   * <p>Method under test: {@link LongGrass#LongGrass()}
   */
  @Test
  @DisplayName("Test new LongGrass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LongGrass.<init>()"})
  void testNewLongGrass() {
    // Arrange and Act
    LongGrass actualLongGrass = new LongGrass();

    // Assert
    assertEquals((byte) 0, actualLongGrass.getData());
    assertEquals(GrassSpecies.DEAD, actualLongGrass.getSpecies());
    assertEquals(Material.LEGACY_LONG_GRASS, actualLongGrass.getItemType());
  }

  /**
   * Test {@link LongGrass#LongGrass(GrassSpecies)}.
   *
   * <p>Method under test: {@link LongGrass#LongGrass(GrassSpecies)}
   */
  @Test
  @DisplayName("Test new LongGrass(GrassSpecies)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LongGrass.<init>(GrassSpecies)"})
  void testNewLongGrass2() {
    // Arrange and Act
    LongGrass actualLongGrass = new LongGrass(GrassSpecies.DEAD);

    // Assert
    assertEquals((byte) 0, actualLongGrass.getData());
    assertEquals(GrassSpecies.DEAD, actualLongGrass.getSpecies());
    assertEquals(Material.LEGACY_LONG_GRASS, actualLongGrass.getItemType());
  }

  /**
   * Test {@link LongGrass#getSpecies()}.
   *
   * <p>Method under test: {@link LongGrass#getSpecies()}
   */
  @Test
  @DisplayName("Test getSpecies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GrassSpecies LongGrass.getSpecies()"})
  void testGetSpecies() {
    // Arrange, Act and Assert
    assertEquals(GrassSpecies.DEAD, new LongGrass().getSpecies());
  }

  /**
   * Test {@link LongGrass#clone()}.
   *
   * <p>Method under test: {@link LongGrass#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongGrass LongGrass.clone()"})
  void testClone() {
    // Arrange
    LongGrass longGrass = new LongGrass();

    // Act
    LongGrass actualCloneResult = longGrass.clone();

    // Assert
    assertEquals(longGrass, actualCloneResult);
  }
}
