package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DoorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Door#Door(Material, byte)}
   *   <li>{@link Door#getHingeCorner()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Door.<init>(Material)",
    "void Door.<init>(Material, byte)",
    "BlockFace Door.getHingeCorner()"
  })
  void testGettersAndSetters_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, (byte) 'A');
    BlockFace actualHingeCorner = actualDoor.getHingeCorner();

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.SELF, actualHingeCorner);
    assertEquals('A', actualDoor.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Door#Door(Material)}
   *   <li>{@link Door#getHingeCorner()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Door.<init>(Material)",
    "void Door.<init>(Material, byte)",
    "BlockFace Door.getHingeCorner()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT);
    BlockFace actualHingeCorner = actualDoor.getHingeCorner();

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.SELF, actualHingeCorner);
  }

  /**
   * Test {@link Door#Door()}.
   *
   * <p>Method under test: {@link Door#Door()}
   */
  @Test
  @DisplayName("Test new Door()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>()"})
  void testNewDoor() {
    // Arrange and Act
    Door actualDoor = new Door();

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.SELF, actualDoor.getHingeCorner());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
    assertFalse(actualDoor.isTopHalf());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return ItemType is {@code LEGACY_ACACIA_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace); when 'ACACIA'; then return ItemType is 'LEGACY_ACACIA_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenAcacia_thenReturnItemTypeIsLegacyAcaciaDoor() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.ACACIA, BlockFace.WEST);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_ACACIA_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return ItemType is {@code LEGACY_ACACIA_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'ACACIA'; then return ItemType is 'LEGACY_ACACIA_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenAcacia_thenReturnItemTypeIsLegacyAcaciaDoor2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.ACACIA, BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_ACACIA_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return ItemType is {@code LEGACY_ACACIA_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, boolean); when 'ACACIA'; then return ItemType is 'LEGACY_ACACIA_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, boolean)"})
  void testNewDoor_whenAcacia_thenReturnItemTypeIsLegacyAcaciaDoor3() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.ACACIA, false);

    // Assert
    assertEquals(Material.LEGACY_ACACIA_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertEquals('\b', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code BIRCH}.
   *   <li>Then return ItemType is {@code LEGACY_BIRCH_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace); when 'BIRCH'; then return ItemType is 'LEGACY_BIRCH_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenBirch_thenReturnItemTypeIsLegacyBirchDoor() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.BIRCH, BlockFace.WEST);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_BIRCH_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code BIRCH}.
   *   <li>Then return ItemType is {@code LEGACY_BIRCH_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'BIRCH'; then return ItemType is 'LEGACY_BIRCH_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenBirch_thenReturnItemTypeIsLegacyBirchDoor2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.BIRCH, BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_BIRCH_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code BIRCH}.
   *   <li>Then return ItemType is {@code LEGACY_BIRCH_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, boolean); when 'BIRCH'; then return ItemType is 'LEGACY_BIRCH_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, boolean)"})
  void testNewDoor_whenBirch_thenReturnItemTypeIsLegacyBirchDoor3() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.BIRCH, false);

    // Assert
    assertEquals(Material.LEGACY_BIRCH_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertEquals('\b', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DARK_OAK}.
   *   <li>Then return ItemType is {@code LEGACY_DARK_OAK_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace); when 'DARK_OAK'; then return ItemType is 'LEGACY_DARK_OAK_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenDarkOak_thenReturnItemTypeIsLegacyDarkOakDoor() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.DARK_OAK, BlockFace.WEST);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_DARK_OAK_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code DARK_OAK}.
   *   <li>Then return ItemType is {@code LEGACY_DARK_OAK_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'DARK_OAK'; then return ItemType is 'LEGACY_DARK_OAK_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenDarkOak_thenReturnItemTypeIsLegacyDarkOakDoor2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.DARK_OAK, BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_DARK_OAK_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code DARK_OAK}.
   *   <li>Then return ItemType is {@code LEGACY_DARK_OAK_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, boolean); when 'DARK_OAK'; then return ItemType is 'LEGACY_DARK_OAK_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, boolean)"})
  void testNewDoor_whenDarkOak_thenReturnItemTypeIsLegacyDarkOakDoor3() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.DARK_OAK, false);

    // Assert
    assertEquals(Material.LEGACY_DARK_OAK_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertEquals('\b', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace)}
   */
  @Test
  @DisplayName("Test new Door(Material, BlockFace); when 'EAST'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace)"})
  void testNewDoor_whenEast_thenReturnDataIsTwo() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.EAST);

    // Assert
    assertEquals((byte) 2, actualDoor.getData());
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.EAST, actualDoor.getFacing());
    assertEquals(BlockFace.SELF, actualDoor.getHingeCorner());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
    assertFalse(actualDoor.isTopHalf());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Door(Material, BlockFace, boolean); when 'EAST'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace, boolean)"})
  void testNewDoor_whenEast_thenReturnDataIsTwo2() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.EAST, false);

    // Assert
    assertEquals((byte) 2, actualDoor.getData());
    assertEquals(BlockFace.EAST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName("Test new Door(TreeSpecies, BlockFace); when 'EAST'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenEast_thenReturnDataIsTwo3() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.EAST);

    // Assert
    assertEquals((byte) 2, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.EAST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'EAST'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenEast_thenReturnDataIsTwo4() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.EAST, false);

    // Assert
    assertEquals((byte) 2, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.EAST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(Material, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return Facing is {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, boolean)}
   */
  @Test
  @DisplayName("Test new Door(Material, boolean); when 'false'; then return Facing is 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, boolean)"})
  void testNewDoor_whenFalse_thenReturnFacingIsWest() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, false);

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.SELF, actualDoor.getHingeCorner());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
    assertTrue(actualDoor.isTopHalf());
    assertEquals('\b', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return ItemType is {@code LEGACY_WOODEN_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace); when 'GENERIC'; then return ItemType is 'LEGACY_WOODEN_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenGeneric_thenReturnItemTypeIsLegacyWoodenDoor() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.WEST);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return ItemType is {@code LEGACY_WOODEN_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'GENERIC'; then return ItemType is 'LEGACY_WOODEN_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenGeneric_thenReturnItemTypeIsLegacyWoodenDoor2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return ItemType is {@code LEGACY_WOODEN_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, boolean); when 'GENERIC'; then return ItemType is 'LEGACY_WOODEN_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, boolean)"})
  void testNewDoor_whenGeneric_thenReturnItemTypeIsLegacyWoodenDoor3() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, false);

    // Assert
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertEquals('\b', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code JUNGLE}.
   *   <li>Then return ItemType is {@code LEGACY_JUNGLE_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace); when 'JUNGLE'; then return ItemType is 'LEGACY_JUNGLE_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenJungle_thenReturnItemTypeIsLegacyJungleDoor() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.JUNGLE, BlockFace.WEST);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_JUNGLE_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code JUNGLE}.
   *   <li>Then return ItemType is {@code LEGACY_JUNGLE_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'JUNGLE'; then return ItemType is 'LEGACY_JUNGLE_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenJungle_thenReturnItemTypeIsLegacyJungleDoor2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.JUNGLE, BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_JUNGLE_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code JUNGLE}.
   *   <li>Then return ItemType is {@code LEGACY_JUNGLE_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, boolean); when 'JUNGLE'; then return ItemType is 'LEGACY_JUNGLE_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, boolean)"})
  void testNewDoor_whenJungle_thenReturnItemTypeIsLegacyJungleDoor3() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.JUNGLE, false);

    // Assert
    assertEquals(Material.LEGACY_JUNGLE_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertEquals('\b', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(Material, BlockFace, boolean); when 'NORTH'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace, boolean)"})
  void testNewDoor_whenNorth_thenReturnDataIsFive() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.NORTH, true);

    // Assert
    assertEquals((byte) 5, actualDoor.getData());
    assertEquals(BlockFace.NORTH, actualDoor.getFacing());
    assertTrue(actualDoor.getHinge());
    assertTrue(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'NORTH'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenNorth_thenReturnDataIsFive2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.NORTH, true);

    // Assert
    assertEquals((byte) 5, actualDoor.getData());
    assertEquals(BlockFace.NORTH, actualDoor.getFacing());
    assertTrue(actualDoor.getHinge());
    assertTrue(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace)}
   */
  @Test
  @DisplayName("Test new Door(Material, BlockFace); when 'NORTH'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace)"})
  void testNewDoor_whenNorth_thenReturnDataIsOne() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.NORTH);

    // Assert
    assertEquals((byte) 1, actualDoor.getData());
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.NORTH, actualDoor.getFacing());
    assertEquals(BlockFace.SELF, actualDoor.getHingeCorner());
    assertFalse(actualDoor.isOpen());
    assertFalse(actualDoor.isTopHalf());
    assertTrue(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName("Test new Door(TreeSpecies, BlockFace); when 'NORTH'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenNorth_thenReturnDataIsOne2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.NORTH);

    // Assert
    assertEquals((byte) 1, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.NORTH, actualDoor.getFacing());
    assertTrue(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code REDWOOD}.
   *   <li>Then return ItemType is {@code LEGACY_SPRUCE_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace); when 'REDWOOD'; then return ItemType is 'LEGACY_SPRUCE_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenRedwood_thenReturnItemTypeIsLegacySpruceDoor() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.REDWOOD, BlockFace.WEST);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_SPRUCE_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code REDWOOD}.
   *   <li>Then return ItemType is {@code LEGACY_SPRUCE_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'REDWOOD'; then return ItemType is 'LEGACY_SPRUCE_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenRedwood_thenReturnItemTypeIsLegacySpruceDoor2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.REDWOOD, BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_SPRUCE_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code REDWOOD}.
   *   <li>Then return ItemType is {@code LEGACY_SPRUCE_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, boolean); when 'REDWOOD'; then return ItemType is 'LEGACY_SPRUCE_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, boolean)"})
  void testNewDoor_whenRedwood_thenReturnItemTypeIsLegacySpruceDoor3() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.REDWOOD, false);

    // Assert
    assertEquals(Material.LEGACY_SPRUCE_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertEquals('\b', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace)}
   */
  @Test
  @DisplayName("Test new Door(Material, BlockFace); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace)"})
  void testNewDoor_whenSouth_thenReturnDataIsThree() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, actualDoor.getData());
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.SELF, actualDoor.getHingeCorner());
    assertEquals(BlockFace.SOUTH, actualDoor.getFacing());
    assertFalse(actualDoor.isOpen());
    assertFalse(actualDoor.isTopHalf());
    assertTrue(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(Material, BlockFace, boolean); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace, boolean)"})
  void testNewDoor_whenSouth_thenReturnDataIsThree2() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.SOUTH, false);

    // Assert
    assertEquals((byte) 3, actualDoor.getData());
    assertEquals(BlockFace.SOUTH, actualDoor.getFacing());
    assertFalse(actualDoor.isOpen());
    assertTrue(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName("Test new Door(TreeSpecies, BlockFace); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenSouth_thenReturnDataIsThree3() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.SOUTH, actualDoor.getFacing());
    assertTrue(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenSouth_thenReturnDataIsThree4() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.SOUTH, false);

    // Assert
    assertEquals((byte) 3, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.SOUTH, actualDoor.getFacing());
    assertTrue(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(Material, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Facing is {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, boolean)}
   */
  @Test
  @DisplayName("Test new Door(Material, boolean); when 'true'; then return Facing is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, boolean)"})
  void testNewDoor_whenTrue_thenReturnFacingIsNorth() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, true);

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.NORTH, actualDoor.getFacing());
    assertEquals(BlockFace.SELF, actualDoor.getHingeCorner());
    assertFalse(actualDoor.isOpen());
    assertTrue(actualDoor.getHinge());
    assertTrue(actualDoor.isTopHalf());
    assertEquals('\t', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Facing is {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, boolean)}
   */
  @Test
  @DisplayName("Test new Door(TreeSpecies, boolean); when 'true'; then return Facing is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, boolean)"})
  void testNewDoor_whenTrue_thenReturnFacingIsNorth2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, true);

    // Assert
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.NORTH, actualDoor.getFacing());
    assertTrue(actualDoor.getHinge());
    assertEquals('\t', actualDoor.getData());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Door(Material, BlockFace, boolean); when 'UP'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace, boolean)"})
  void testNewDoor_whenUp_thenReturnDataIsFour() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.UP, true);

    // Assert
    assertEquals((byte) 4, actualDoor.getData());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertTrue(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace, boolean); when 'UP'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace, boolean)"})
  void testNewDoor_whenUp_thenReturnDataIsFour2() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.UP, true);

    // Assert
    assertEquals((byte) 4, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertTrue(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace)}
   */
  @Test
  @DisplayName("Test new Door(Material, BlockFace); when 'UP'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace)"})
  void testNewDoor_whenUp_thenReturnDataIsZero() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.UP);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.SELF, actualDoor.getHingeCorner());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
    assertFalse(actualDoor.isTopHalf());
  }

  /**
   * Test {@link Door#Door(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return ItemType is {@code LEGACY_WOODEN_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Door(TreeSpecies, BlockFace); when 'UP'; then return ItemType is 'LEGACY_WOODEN_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(TreeSpecies, BlockFace)"})
  void testNewDoor_whenUp_thenReturnItemTypeIsLegacyWoodenDoor() {
    // Arrange and Act
    Door actualDoor = new Door(TreeSpecies.GENERIC, BlockFace.UP);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.LEGACY_WOODEN_DOOR, actualDoor.getItemType());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace)}
   */
  @Test
  @DisplayName("Test new Door(Material, BlockFace); when 'WEST'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace)"})
  void testNewDoor_whenWest_thenReturnDataIsZero() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.WEST);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(Material.ACACIA_BOAT, actualDoor.getItemType());
    assertEquals(BlockFace.SELF, actualDoor.getHingeCorner());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
    assertFalse(actualDoor.isTopHalf());
  }

  /**
   * Test {@link Door#Door(Material, BlockFace, boolean)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Door#Door(Material, BlockFace, boolean)}
   */
  @Test
  @DisplayName("Test new Door(Material, BlockFace, boolean); when 'WEST'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.<init>(Material, BlockFace, boolean)"})
  void testNewDoor_whenWest_thenReturnDataIsZero2() {
    // Arrange and Act
    Door actualDoor = new Door(Material.ACACIA_BOAT, BlockFace.WEST, false);

    // Assert
    assertEquals((byte) 0, actualDoor.getData());
    assertEquals(BlockFace.WEST, actualDoor.getFacing());
    assertFalse(actualDoor.getHinge());
    assertFalse(actualDoor.isOpen());
  }

  /**
   * Test {@link Door#getWoodDoorOfSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return {@code LEGACY_ACACIA_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getWoodDoorOfSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test getWoodDoorOfSpecies(TreeSpecies); when 'ACACIA'; then return 'LEGACY_ACACIA_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material Door.getWoodDoorOfSpecies(TreeSpecies)"})
  void testGetWoodDoorOfSpecies_whenAcacia_thenReturnLegacyAcaciaDoor() {
    // Arrange, Act and Assert
    assertEquals(Material.LEGACY_ACACIA_DOOR, Door.getWoodDoorOfSpecies(TreeSpecies.ACACIA));
  }

  /**
   * Test {@link Door#getWoodDoorOfSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code BIRCH}.
   *   <li>Then return {@code LEGACY_BIRCH_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getWoodDoorOfSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test getWoodDoorOfSpecies(TreeSpecies); when 'BIRCH'; then return 'LEGACY_BIRCH_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material Door.getWoodDoorOfSpecies(TreeSpecies)"})
  void testGetWoodDoorOfSpecies_whenBirch_thenReturnLegacyBirchDoor() {
    // Arrange, Act and Assert
    assertEquals(Material.LEGACY_BIRCH_DOOR, Door.getWoodDoorOfSpecies(TreeSpecies.BIRCH));
  }

  /**
   * Test {@link Door#getWoodDoorOfSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code DARK_OAK}.
   *   <li>Then return {@code LEGACY_DARK_OAK_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getWoodDoorOfSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test getWoodDoorOfSpecies(TreeSpecies); when 'DARK_OAK'; then return 'LEGACY_DARK_OAK_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material Door.getWoodDoorOfSpecies(TreeSpecies)"})
  void testGetWoodDoorOfSpecies_whenDarkOak_thenReturnLegacyDarkOakDoor() {
    // Arrange, Act and Assert
    assertEquals(Material.LEGACY_DARK_OAK_DOOR, Door.getWoodDoorOfSpecies(TreeSpecies.DARK_OAK));
  }

  /**
   * Test {@link Door#getWoodDoorOfSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return {@code LEGACY_WOODEN_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getWoodDoorOfSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test getWoodDoorOfSpecies(TreeSpecies); when 'GENERIC'; then return 'LEGACY_WOODEN_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material Door.getWoodDoorOfSpecies(TreeSpecies)"})
  void testGetWoodDoorOfSpecies_whenGeneric_thenReturnLegacyWoodenDoor() {
    // Arrange, Act and Assert
    assertEquals(Material.LEGACY_WOODEN_DOOR, Door.getWoodDoorOfSpecies(TreeSpecies.GENERIC));
  }

  /**
   * Test {@link Door#getWoodDoorOfSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code JUNGLE}.
   *   <li>Then return {@code LEGACY_JUNGLE_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getWoodDoorOfSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test getWoodDoorOfSpecies(TreeSpecies); when 'JUNGLE'; then return 'LEGACY_JUNGLE_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material Door.getWoodDoorOfSpecies(TreeSpecies)"})
  void testGetWoodDoorOfSpecies_whenJungle_thenReturnLegacyJungleDoor() {
    // Arrange, Act and Assert
    assertEquals(Material.LEGACY_JUNGLE_DOOR, Door.getWoodDoorOfSpecies(TreeSpecies.JUNGLE));
  }

  /**
   * Test {@link Door#getWoodDoorOfSpecies(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code REDWOOD}.
   *   <li>Then return {@code LEGACY_SPRUCE_DOOR}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getWoodDoorOfSpecies(TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test getWoodDoorOfSpecies(TreeSpecies); when 'REDWOOD'; then return 'LEGACY_SPRUCE_DOOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material Door.getWoodDoorOfSpecies(TreeSpecies)"})
  void testGetWoodDoorOfSpecies_whenRedwood_thenReturnLegacySpruceDoor() {
    // Arrange, Act and Assert
    assertEquals(Material.LEGACY_SPRUCE_DOOR, Door.getWoodDoorOfSpecies(TreeSpecies.REDWOOD));
  }

  /**
   * Test {@link Door#isOpen()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       minus nine.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Door#isOpen()}
   */
  @Test
  @DisplayName(
      "Test isOpen(); given Door(Material, byte) with type is 'ACACIA_BOAT' and data is minus nine; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Door.isOpen()"})
  void testIsOpen_givenDoorWithTypeIsAcaciaBoatAndDataIsMinusNine_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Door(Material.ACACIA_BOAT, (byte) -9).isOpen());
  }

  /**
   * Test {@link Door#isOpen()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Door#isOpen()}
   */
  @Test
  @DisplayName("Test isOpen(); given Door(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Door.isOpen()"})
  void testIsOpen_givenDoor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Door().isOpen());
  }

  /**
   * Test {@link Door#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Door#Door()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Door#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'false'; then Door() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setOpen(boolean)"})
  void testSetOpen_whenFalse_thenDoorDataIsZero() {
    // Arrange
    Door door = new Door();

    // Act
    door.setOpen(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, door.getData());
    assertFalse(door.isOpen());
  }

  /**
   * Test {@link Door#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Door#Door()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Door#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'true'; then Door() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setOpen(boolean)"})
  void testSetOpen_whenTrue_thenDoorDataIsFour() {
    // Arrange
    Door door = new Door();

    // Act
    door.setOpen(true);

    // Assert
    assertEquals((byte) 4, door.getData());
    assertTrue(door.isOpen());
  }

  /**
   * Test {@link Door#isTopHalf()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Door#isTopHalf()}
   */
  @Test
  @DisplayName(
      "Test isTopHalf(); given Door(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Door.isTopHalf()"})
  void testIsTopHalf_givenDoorWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Door(Material.ACACIA_BOAT, (byte) 'X').isTopHalf());
  }

  /**
   * Test {@link Door#isTopHalf()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Door#isTopHalf()}
   */
  @Test
  @DisplayName("Test isTopHalf(); given Door(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Door.isTopHalf()"})
  void testIsTopHalf_givenDoor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Door().isTopHalf());
  }

  /**
   * Test {@link Door#setTopHalf(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Door#Door()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Door#setTopHalf(boolean)}
   */
  @Test
  @DisplayName("Test setTopHalf(boolean); when 'false'; then Door() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setTopHalf(boolean)"})
  void testSetTopHalf_whenFalse_thenDoorDataIsZero() {
    // Arrange
    Door door = new Door();

    // Act
    door.setTopHalf(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, door.getData());
    assertFalse(door.isTopHalf());
  }

  /**
   * Test {@link Door#setTopHalf(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Door#Door()} TopHalf.
   * </ul>
   *
   * <p>Method under test: {@link Door#setTopHalf(boolean)}
   */
  @Test
  @DisplayName("Test setTopHalf(boolean); when 'true'; then Door() TopHalf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setTopHalf(boolean)"})
  void testSetTopHalf_whenTrue_thenDoorTopHalf() {
    // Arrange
    Door door = new Door();

    // Act
    door.setTopHalf(true);

    // Assert
    assertTrue(door.isTopHalf());
    assertEquals('\b', door.getData());
  }

  /**
   * Test {@link Door#toString()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door()}.
   *   <li>Then return {@code BOTTOM half of LEGACY_WOODEN_DOOR(0)}.
   * </ul>
   *
   * <p>Method under test: {@link Door#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Door(); then return 'BOTTOM half of LEGACY_WOODEN_DOOR(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Door.toString()"})
  void testToString_givenDoor_thenReturnBottomHalfOfLegacyWoodenDoor0() {
    // Arrange, Act and Assert
    assertEquals("BOTTOM half of LEGACY_WOODEN_DOOR(0)", new Door().toString());
  }

  /**
   * Test {@link Door#toString()}.
   *
   * <ul>
   *   <li>Then return {@code TOP half of ACACIA_BOAT(88)}.
   * </ul>
   *
   * <p>Method under test: {@link Door#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'TOP half of ACACIA_BOAT(88)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Door.toString()"})
  void testToString_thenReturnTopHalfOfAcaciaBoat88() {
    // Arrange, Act and Assert
    assertEquals(
        "TOP half of ACACIA_BOAT(88)", new Door(Material.ACACIA_BOAT, (byte) 'X').toString());
  }

  /**
   * Test {@link Door#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Door#Door()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Door#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Door() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenDoorDataIsTwo() {
    // Arrange
    Door door = new Door();

    // Act
    door.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 2, door.getData());
    assertEquals(BlockFace.EAST, door.getFacing());
    assertFalse(door.getHinge());
  }

  /**
   * Test {@link Door#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Door#Door()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Door#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Door() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenDoorDataIsOne() {
    // Arrange
    Door door = new Door();

    // Act
    door.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 1, door.getData());
    assertEquals(BlockFace.NORTH, door.getFacing());
    assertTrue(door.getHinge());
  }

  /**
   * Test {@link Door#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Door#Door()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Door#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Door() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenDoorDataIsThree() {
    // Arrange
    Door door = new Door();

    // Act
    door.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, door.getData());
    assertEquals(BlockFace.SOUTH, door.getFacing());
    assertTrue(door.getHinge());
  }

  /**
   * Test {@link Door#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Door#Door()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Door#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'UP'; then Door() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenUp_thenDoorDataIsZero() {
    // Arrange
    Door door = new Door();

    // Act
    door.setFacingDirection(BlockFace.UP);

    // Assert that nothing has changed
    assertEquals((byte) 0, door.getData());
    assertEquals(BlockFace.WEST, door.getFacing());
    assertFalse(door.getHinge());
  }

  /**
   * Test {@link Door#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Door#Door()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Door#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Door() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenDoorDataIsZero() {
    // Arrange
    Door door = new Door();

    // Act
    door.setFacingDirection(BlockFace.WEST);

    // Assert that nothing has changed
    assertEquals((byte) 0, door.getData());
    assertEquals(BlockFace.WEST, door.getFacing());
    assertFalse(door.getHinge());
  }

  /**
   * Test {@link Door#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Door(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Door.getFacing()"})
  void testGetFacing_givenDoorWithTypeIsAcaciaBoatAndDataIsA_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Door(Material.ACACIA_BOAT, (byte) 'A').getFacing());
  }

  /**
   * Test {@link Door#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       three.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Door(Material, byte) with type is 'ACACIA_BOAT' and data is three; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Door.getFacing()"})
  void testGetFacing_givenDoorWithTypeIsAcaciaBoatAndDataIsThree_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Door(Material.ACACIA_BOAT, (byte) 3).getFacing());
  }

  /**
   * Test {@link Door#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door(Material, byte)} with type is {@code ACACIA_BOAT} and data is two.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Door(Material, byte) with type is 'ACACIA_BOAT' and data is two; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Door.getFacing()"})
  void testGetFacing_givenDoorWithTypeIsAcaciaBoatAndDataIsTwo_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Door(Material.ACACIA_BOAT, (byte) 2).getFacing());
  }

  /**
   * Test {@link Door#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door()}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Door(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Door.getFacing()"})
  void testGetFacing_givenDoor_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Door().getFacing());
  }

  /**
   * Test {@link Door#getHinge()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getHinge()}
   */
  @Test
  @DisplayName(
      "Test getHinge(); given Door(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Door.getHinge()"})
  void testGetHinge_givenDoorWithTypeIsAcaciaBoatAndDataIsA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Door(Material.ACACIA_BOAT, (byte) 'A').getHinge());
  }

  /**
   * Test {@link Door#getHinge()}.
   *
   * <ul>
   *   <li>Given {@link Door#Door()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Door#getHinge()}
   */
  @Test
  @DisplayName("Test getHinge(); given Door(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Door.getHinge()"})
  void testGetHinge_givenDoor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Door().getHinge());
  }

  /**
   * Test {@link Door#setHinge(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Door#Door()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Door#setHinge(boolean)}
   */
  @Test
  @DisplayName("Test setHinge(boolean); when 'false'; then Door() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setHinge(boolean)"})
  void testSetHinge_whenFalse_thenDoorDataIsZero() {
    // Arrange
    Door door = new Door();

    // Act
    door.setHinge(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, door.getData());
    assertEquals(BlockFace.WEST, door.getFacing());
    assertFalse(door.getHinge());
  }

  /**
   * Test {@link Door#setHinge(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Door#Door()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Door#setHinge(boolean)}
   */
  @Test
  @DisplayName("Test setHinge(boolean); when 'true'; then Door() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Door.setHinge(boolean)"})
  void testSetHinge_whenTrue_thenDoorDataIsOne() {
    // Arrange
    Door door = new Door();

    // Act
    door.setHinge(true);

    // Assert
    assertEquals((byte) 1, door.getData());
    assertEquals(BlockFace.NORTH, door.getFacing());
    assertTrue(door.getHinge());
  }

  /**
   * Test {@link Door#clone()}.
   *
   * <p>Method under test: {@link Door#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Door Door.clone()"})
  void testClone() {
    // Arrange
    Door door = new Door();

    // Act
    Door actualCloneResult = door.clone();

    // Assert
    assertEquals(door, actualCloneResult);
  }
}
