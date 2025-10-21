package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TexturedMaterialDiffblueTest {
  /**
   * Test {@link TexturedMaterial#getMaterial()}.
   *
   * <ul>
   *   <li>Given {@link MonsterEggs#MonsterEggs(Material, byte)} with type is {@code ACACIA_BOAT}
   *       and data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TexturedMaterial#getMaterial()}
   */
  @Test
  @DisplayName(
      "Test getMaterial(); given MonsterEggs(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material TexturedMaterial.getMaterial()"})
  void testGetMaterial_givenMonsterEggsWithTypeIsAcaciaBoatAndDataIsA() {
    // Arrange, Act and Assert
    assertEquals(
        Material.LEGACY_STONE, new MonsterEggs(Material.ACACIA_BOAT, (byte) 'A').getMaterial());
  }

  /**
   * Test {@link TexturedMaterial#getMaterial()}.
   *
   * <ul>
   *   <li>Given {@link MonsterEggs#MonsterEggs()}.
   *   <li>Then return {@code LEGACY_STONE}.
   * </ul>
   *
   * <p>Method under test: {@link TexturedMaterial#getMaterial()}
   */
  @Test
  @DisplayName("Test getMaterial(); given MonsterEggs(); then return 'LEGACY_STONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material TexturedMaterial.getMaterial()"})
  void testGetMaterial_givenMonsterEggs_thenReturnLegacyStone() {
    // Arrange, Act and Assert
    assertEquals(Material.LEGACY_STONE, new MonsterEggs().getMaterial());
  }

  /**
   * Test {@link TexturedMaterial#getTextureIndex()}.
   *
   * <p>Method under test: {@link TexturedMaterial#getTextureIndex()}
   */
  @Test
  @DisplayName("Test getTextureIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TexturedMaterial.getTextureIndex()"})
  void testGetTextureIndex() {
    // Arrange, Act and Assert
    assertEquals(0, new MonsterEggs().getTextureIndex());
  }

  /**
   * Test {@link TexturedMaterial#setTextureIndex(int)}.
   *
   * <p>Method under test: {@link TexturedMaterial#setTextureIndex(int)}
   */
  @Test
  @DisplayName("Test setTextureIndex(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TexturedMaterial.setTextureIndex(int)"})
  void testSetTextureIndex() {
    // Arrange
    MonsterEggs monsterEggs = new MonsterEggs();

    // Act
    monsterEggs.setTextureIndex(1);

    // Assert
    assertEquals(1, monsterEggs.getTextureIndex());
    assertEquals((byte) 1, monsterEggs.getData());
    assertEquals(Material.LEGACY_COBBLESTONE, monsterEggs.getMaterial());
  }

  /**
   * Test {@link TexturedMaterial#toString()}.
   *
   * <ul>
   *   <li>Given {@link MonsterEggs#MonsterEggs()}.
   *   <li>Then return {@code LEGACY_STONE LEGACY_MONSTER_EGGS(0)}.
   * </ul>
   *
   * <p>Method under test: {@link TexturedMaterial#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given MonsterEggs(); then return 'LEGACY_STONE LEGACY_MONSTER_EGGS(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TexturedMaterial.toString()"})
  void testToString_givenMonsterEggs_thenReturnLegacyStoneLegacyMonsterEggs0() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_STONE LEGACY_MONSTER_EGGS(0)", new MonsterEggs().toString());
  }

  /**
   * Test {@link TexturedMaterial#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_STONE ACACIA_BOAT(65)}.
   * </ul>
   *
   * <p>Method under test: {@link TexturedMaterial#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_STONE ACACIA_BOAT(65)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TexturedMaterial.toString()"})
  void testToString_thenReturnLegacyStoneAcaciaBoat65() {
    // Arrange, Act and Assert
    assertEquals(
        "LEGACY_STONE ACACIA_BOAT(65)",
        new MonsterEggs(Material.ACACIA_BOAT, (byte) 'A').toString());
  }

  /**
   * Test {@link TexturedMaterial#clone()}.
   *
   * <p>Method under test: {@link TexturedMaterial#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TexturedMaterial TexturedMaterial.clone()"})
  void testClone() {
    // Arrange
    MonsterEggs monsterEggs = new MonsterEggs();

    // Act
    MonsterEggs actualCloneResult = monsterEggs.clone();

    // Assert
    assertTrue(actualCloneResult instanceof MonsterEggs);
    assertEquals(monsterEggs, actualCloneResult);
  }
}
