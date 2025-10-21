package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MonsterEggsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MonsterEggs#MonsterEggs(Material, byte)}
   *   <li>{@link MonsterEggs#getTextures()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MonsterEggs.<init>(Material, byte)", "List MonsterEggs.getTextures()"})
  void testGettersAndSetters() {
    // Arrange and Act
    MonsterEggs actualMonsterEggs = new MonsterEggs(Material.ACACIA_BOAT, (byte) 'A');
    List<Material> actualTextures = actualMonsterEggs.getTextures();

    // Assert
    assertEquals(3, actualTextures.size());
    assertEquals(Material.ACACIA_BOAT, actualMonsterEggs.getItemType());
    assertEquals(Material.LEGACY_COBBLESTONE, actualTextures.get(1));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, actualTextures.get(2));
    assertEquals(Material.LEGACY_STONE, actualTextures.get(0));
    assertEquals('A', actualMonsterEggs.getData());
  }

  /**
   * Test {@link MonsterEggs#MonsterEggs()}.
   *
   * <p>Method under test: {@link MonsterEggs#MonsterEggs()}
   */
  @Test
  @DisplayName("Test new MonsterEggs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MonsterEggs.<init>()"})
  void testNewMonsterEggs() {
    // Arrange and Act
    MonsterEggs actualMonsterEggs = new MonsterEggs();

    // Assert
    assertEquals(0, actualMonsterEggs.getTextureIndex());
    assertEquals((byte) 0, actualMonsterEggs.getData());
    List<Material> textures = actualMonsterEggs.getTextures();
    assertEquals(3, textures.size());
    assertEquals(Material.LEGACY_COBBLESTONE, textures.get(1));
    assertEquals(Material.LEGACY_MONSTER_EGGS, actualMonsterEggs.getItemType());
    assertEquals(Material.LEGACY_SMOOTH_BRICK, textures.get(2));
    assertEquals(Material.LEGACY_STONE, textures.get(0));
    assertEquals(Material.LEGACY_STONE, actualMonsterEggs.getMaterial());
  }

  /**
   * Test {@link MonsterEggs#MonsterEggs(Material)}.
   *
   * <p>Method under test: {@link MonsterEggs#MonsterEggs(Material)}
   */
  @Test
  @DisplayName("Test new MonsterEggs(Material)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MonsterEggs.<init>(Material)"})
  void testNewMonsterEggs2() {
    // Arrange and Act
    MonsterEggs actualMonsterEggs = new MonsterEggs(Material.ACACIA_BOAT);

    // Assert
    assertEquals(0, actualMonsterEggs.getTextureIndex());
    assertEquals((byte) 0, actualMonsterEggs.getData());
    List<Material> textures = actualMonsterEggs.getTextures();
    assertEquals(3, textures.size());
    assertEquals(Material.ACACIA_BOAT, actualMonsterEggs.getItemType());
    assertEquals(Material.LEGACY_COBBLESTONE, textures.get(1));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, textures.get(2));
    assertEquals(Material.LEGACY_STONE, textures.get(0));
    assertEquals(Material.LEGACY_STONE, actualMonsterEggs.getMaterial());
  }

  /**
   * Test {@link MonsterEggs#clone()}.
   *
   * <p>Method under test: {@link MonsterEggs#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MonsterEggs MonsterEggs.clone()"})
  void testClone() {
    // Arrange
    MonsterEggs monsterEggs = new MonsterEggs();

    // Act
    MonsterEggs actualCloneResult = monsterEggs.clone();

    // Assert
    assertEquals(monsterEggs, actualCloneResult);
  }
}
