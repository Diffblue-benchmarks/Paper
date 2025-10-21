package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StepDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Step#Step(Material, byte)}
   *   <li>{@link Step#getTextures()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Step.<init>(Material, byte)", "List Step.getTextures()"})
  void testGettersAndSetters() {
    // Arrange and Act
    Step actualStep = new Step(Material.ACACIA_BOAT, (byte) 'A');
    List<Material> actualTextures = actualStep.getTextures();

    // Assert
    assertEquals(8, actualTextures.size());
    assertEquals(Material.ACACIA_BOAT, actualStep.getItemType());
    assertEquals(Material.LEGACY_BRICK, actualTextures.get(4));
    assertEquals(Material.LEGACY_COBBLESTONE, actualTextures.get(3));
    assertEquals(Material.LEGACY_NETHER_BRICK, actualTextures.get(6));
    assertEquals(Material.LEGACY_QUARTZ_BLOCK, actualTextures.get(7));
    assertEquals(Material.LEGACY_SANDSTONE, actualTextures.get(1));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, actualTextures.get(5));
    assertEquals(Material.LEGACY_STONE, actualTextures.get(0));
    assertEquals(Material.LEGACY_WOOD, actualTextures.get(2));
    assertEquals('A', actualStep.getData());
  }

  /**
   * Test {@link Step#Step()}.
   *
   * <p>Method under test: {@link Step#Step()}
   */
  @Test
  @DisplayName("Test new Step()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Step.<init>()"})
  void testNewStep() {
    // Arrange and Act
    Step actualStep = new Step();

    // Assert
    assertEquals(0, actualStep.getTextureIndex());
    assertEquals((byte) 0, actualStep.getData());
    List<Material> textures = actualStep.getTextures();
    assertEquals(8, textures.size());
    assertEquals(Material.LEGACY_NETHER_BRICK, textures.get(6));
    assertEquals(Material.LEGACY_QUARTZ_BLOCK, textures.get(7));
    assertEquals(Material.LEGACY_SANDSTONE, textures.get(1));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, textures.get(5));
    assertEquals(Material.LEGACY_STEP, actualStep.getItemType());
    assertEquals(Material.LEGACY_STONE, textures.get(0));
    assertEquals(Material.LEGACY_STONE, actualStep.getMaterial());
    assertEquals(Material.LEGACY_WOOD, textures.get(2));
    assertFalse(actualStep.isInverted());
  }

  /**
   * Test {@link Step#Step(Material)}.
   *
   * <p>Method under test: {@link Step#Step(Material)}
   */
  @Test
  @DisplayName("Test new Step(Material)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Step.<init>(Material)"})
  void testNewStep2() {
    // Arrange and Act
    Step actualStep = new Step(Material.ACACIA_BOAT);

    // Assert
    assertEquals(0, actualStep.getTextureIndex());
    assertEquals((byte) 0, actualStep.getData());
    List<Material> textures = actualStep.getTextures();
    assertEquals(8, textures.size());
    assertEquals(Material.ACACIA_BOAT, actualStep.getItemType());
    assertEquals(Material.LEGACY_NETHER_BRICK, textures.get(6));
    assertEquals(Material.LEGACY_QUARTZ_BLOCK, textures.get(7));
    assertEquals(Material.LEGACY_SANDSTONE, textures.get(1));
    assertEquals(Material.LEGACY_SMOOTH_BRICK, textures.get(5));
    assertEquals(Material.LEGACY_STONE, textures.get(0));
    assertEquals(Material.LEGACY_STONE, actualStep.getMaterial());
    assertEquals(Material.LEGACY_WOOD, textures.get(2));
    assertFalse(actualStep.isInverted());
  }

  /**
   * Test {@link Step#isInverted()}.
   *
   * <ul>
   *   <li>Given {@link Step#Step(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Step#isInverted()}
   */
  @Test
  @DisplayName(
      "Test isInverted(); given Step(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Step.isInverted()"})
  void testIsInverted_givenStepWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Step(Material.ACACIA_BOAT, (byte) 'X').isInverted());
  }

  /**
   * Test {@link Step#isInverted()}.
   *
   * <ul>
   *   <li>Given {@link Step#Step()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Step#isInverted()}
   */
  @Test
  @DisplayName("Test isInverted(); given Step(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Step.isInverted()"})
  void testIsInverted_givenStep_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Step().isInverted());
  }

  /**
   * Test {@link Step#setInverted(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Step#Step()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Step#setInverted(boolean)}
   */
  @Test
  @DisplayName("Test setInverted(boolean); when 'false'; then Step() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Step.setInverted(boolean)"})
  void testSetInverted_whenFalse_thenStepDataIsZero() {
    // Arrange
    Step step = new Step();

    // Act
    step.setInverted(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, step.getData());
    assertFalse(step.isInverted());
  }

  /**
   * Test {@link Step#setInverted(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Step#Step()} Inverted.
   * </ul>
   *
   * <p>Method under test: {@link Step#setInverted(boolean)}
   */
  @Test
  @DisplayName("Test setInverted(boolean); when 'true'; then Step() Inverted")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Step.setInverted(boolean)"})
  void testSetInverted_whenTrue_thenStepInverted() {
    // Arrange
    Step step = new Step();

    // Act
    step.setInverted(true);

    // Assert
    assertTrue(step.isInverted());
    assertEquals('\b', step.getData());
  }

  /**
   * Test {@link Step#getTextureIndex()}.
   *
   * <p>Method under test: {@link Step#getTextureIndex()}
   */
  @Test
  @DisplayName("Test getTextureIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Step.getTextureIndex()"})
  void testGetTextureIndex() {
    // Arrange, Act and Assert
    assertEquals(0, new Step().getTextureIndex());
  }

  /**
   * Test {@link Step#setTextureIndex(int)}.
   *
   * <p>Method under test: {@link Step#setTextureIndex(int)}
   */
  @Test
  @DisplayName("Test setTextureIndex(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Step.setTextureIndex(int)"})
  void testSetTextureIndex() {
    // Arrange
    Step step = new Step();

    // Act
    step.setTextureIndex(1);

    // Assert
    assertEquals(1, step.getTextureIndex());
    assertEquals((byte) 1, step.getData());
    assertEquals(Material.LEGACY_SANDSTONE, step.getMaterial());
  }

  /**
   * Test {@link Step#clone()}.
   *
   * <p>Method under test: {@link Step#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Step Step.clone()"})
  void testClone() {
    // Arrange
    Step step = new Step();

    // Act
    Step actualCloneResult = step.clone();

    // Assert
    assertEquals(step, actualCloneResult);
  }

  /**
   * Test {@link Step#toString()}.
   *
   * <ul>
   *   <li>Given {@link Step#Step()}.
   *   <li>Then return {@code LEGACY_STONE LEGACY_STEP(0)}.
   * </ul>
   *
   * <p>Method under test: {@link Step#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Step(); then return 'LEGACY_STONE LEGACY_STEP(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Step.toString()"})
  void testToString_givenStep_thenReturnLegacyStoneLegacyStep0() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_STONE LEGACY_STEP(0)", new Step().toString());
  }

  /**
   * Test {@link Step#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_STONE ACACIA_BOAT(88)inverted}.
   * </ul>
   *
   * <p>Method under test: {@link Step#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_STONE ACACIA_BOAT(88)inverted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Step.toString()"})
  void testToString_thenReturnLegacyStoneAcaciaBoat88Inverted() {
    // Arrange, Act and Assert
    assertEquals(
        "LEGACY_STONE ACACIA_BOAT(88)inverted",
        new Step(Material.ACACIA_BOAT, (byte) 'X').toString());
  }
}
