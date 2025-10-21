package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SmoothBrickDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SmoothBrick#SmoothBrick(Material, byte)}
   *   <li>{@link SmoothBrick#getTextures()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SmoothBrick.<init>(Material, byte)", "List SmoothBrick.getTextures()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SmoothBrick actualSmoothBrick = new SmoothBrick(Material.ACACIA_BOAT, (byte) 'A');
    List<Material> actualTextures = actualSmoothBrick.getTextures();

    // Assert
    assertEquals(4, actualTextures.size());
    assertEquals(Material.ACACIA_BOAT, actualSmoothBrick.getItemType());
    assertEquals(Material.LEGACY_COBBLESTONE, actualTextures.get(2));
    assertEquals(Material.LEGACY_MOSSY_COBBLESTONE, actualTextures.get(1));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, actualTextures.get(3));
    assertEquals(Material.LEGACY_STONE, actualTextures.get(0));
    assertEquals('A', actualSmoothBrick.getData());
  }

  /**
   * Test {@link SmoothBrick#SmoothBrick()}.
   *
   * <p>Method under test: {@link SmoothBrick#SmoothBrick()}
   */
  @Test
  @DisplayName("Test new SmoothBrick()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SmoothBrick.<init>()"})
  void testNewSmoothBrick() {
    // Arrange and Act
    SmoothBrick actualSmoothBrick = new SmoothBrick();

    // Assert
    assertEquals(0, actualSmoothBrick.getTextureIndex());
    assertEquals((byte) 0, actualSmoothBrick.getData());
    List<Material> textures = actualSmoothBrick.getTextures();
    assertEquals(4, textures.size());
    assertEquals(Material.LEGACY_COBBLESTONE, textures.get(2));
    assertEquals(Material.LEGACY_MOSSY_COBBLESTONE, textures.get(1));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, textures.get(3));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, actualSmoothBrick.getItemType());
    assertEquals(Material.LEGACY_STONE, textures.get(0));
    assertEquals(Material.LEGACY_STONE, actualSmoothBrick.getMaterial());
  }

  /**
   * Test {@link SmoothBrick#SmoothBrick(Material)}.
   *
   * <p>Method under test: {@link SmoothBrick#SmoothBrick(Material)}
   */
  @Test
  @DisplayName("Test new SmoothBrick(Material)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SmoothBrick.<init>(Material)"})
  void testNewSmoothBrick2() {
    // Arrange and Act
    SmoothBrick actualSmoothBrick = new SmoothBrick(Material.ACACIA_BOAT);

    // Assert
    assertEquals(0, actualSmoothBrick.getTextureIndex());
    assertEquals((byte) 0, actualSmoothBrick.getData());
    List<Material> textures = actualSmoothBrick.getTextures();
    assertEquals(4, textures.size());
    assertEquals(Material.ACACIA_BOAT, actualSmoothBrick.getItemType());
    assertEquals(Material.LEGACY_COBBLESTONE, textures.get(2));
    assertEquals(Material.LEGACY_MOSSY_COBBLESTONE, textures.get(1));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, textures.get(3));
    assertEquals(Material.LEGACY_STONE, textures.get(0));
    assertEquals(Material.LEGACY_STONE, actualSmoothBrick.getMaterial());
  }

  /**
   * Test {@link SmoothBrick#clone()}.
   *
   * <p>Method under test: {@link SmoothBrick#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SmoothBrick SmoothBrick.clone()"})
  void testClone() {
    // Arrange
    SmoothBrick smoothBrick = new SmoothBrick();

    // Act
    SmoothBrick actualCloneResult = smoothBrick.clone();

    // Assert
    assertEquals(smoothBrick, actualCloneResult);
  }
}
