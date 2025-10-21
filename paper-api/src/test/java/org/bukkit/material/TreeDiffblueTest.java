package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TreeDiffblueTest {
  /**
   * Test {@link Tree#Tree(Material, byte)}.
   *
   * <p>Method under test: {@link Tree#Tree(Material, byte)}
   */
  @Test
  @DisplayName("Test new Tree(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, byte)", "java.lang.String Tree.toString()"})
  void testNewTree() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualTree.getItemType());
    assertEquals('A', actualTree.getData());
  }

  /**
   * Test {@link Tree#Tree()}.
   *
   * <p>Method under test: {@link Tree#Tree()}
   */
  @Test
  @DisplayName("Test new Tree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>()"})
  void testNewTree2() {
    // Arrange and Act
    Tree actualTree = new Tree();

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material)}
   */
  @Test
  @DisplayName("Test new Tree(Material); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material)"})
  void testNewTree_whenAcaciaBoat_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Tree(Material.ACACIA_BOAT));
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies)"})
  void testNewTree_whenAcaciaBoat_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new Tree(Material.ACACIA_BOAT, TreeSpecies.GENERIC));
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies, BlockFace); when 'ACACIA_BOAT'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies, BlockFace)"})
  void testNewTree_whenAcaciaBoat_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Tree(Material.ACACIA_BOAT, TreeSpecies.GENERIC, BlockFace.NORTH));
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies, BlockFace); when 'ACACIA'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies, BlockFace)"})
  void testNewTree_whenAcacia_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG_2, TreeSpecies.ACACIA, BlockFace.UP);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG_2, actualTree.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(TreeSpecies)}
   */
  @Test
  @DisplayName("Test new Tree(TreeSpecies); when 'ACACIA'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(TreeSpecies)"})
  void testNewTree_whenAcacia_thenReturnItemTypeIsLegacyLog22() {
    // Arrange and Act
    Tree actualTree = new Tree(TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG_2, actualTree.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code ACACIA}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(TreeSpecies, BlockFace); when 'ACACIA'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(TreeSpecies, BlockFace)"})
  void testNewTree_whenAcacia_thenReturnItemTypeIsLegacyLog23() {
    // Arrange and Act
    Tree actualTree = new Tree(TreeSpecies.ACACIA, BlockFace.UP);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG_2, actualTree.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code GENERIC}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(TreeSpecies)}
   */
  @Test
  @DisplayName("Test new Tree(TreeSpecies); when 'GENERIC'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(TreeSpecies)"})
  void testNewTree_whenGeneric_thenReturnItemTypeIsLegacyLog() {
    // Arrange and Act
    Tree actualTree = new Tree(TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material)"})
  void testNewTree_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LEAVES_2);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LEAVES, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies)"})
  void testNewTree_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LEAVES_2, TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LEAVES, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES_2}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies, BlockFace); when 'LEGACY_LEAVES_2'; then return ItemType is 'LEGACY_LEAVES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies, BlockFace)"})
  void testNewTree_whenLegacyLeaves2_thenReturnItemTypeIsLegacyLeaves3() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LEAVES_2, TreeSpecies.GENERIC, BlockFace.UP);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LEAVES, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LEAVES}.
   *   <li>Then return ItemType is {@code LEGACY_LEAVES_2}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies); when 'LEGACY_LEAVES'; then return ItemType is 'LEGACY_LEAVES_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies)"})
  void testNewTree_whenLegacyLeaves_thenReturnItemTypeIsLegacyLeaves2() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LEAVES, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LEAVES_2, actualTree.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material)}
   */
  @Test
  @DisplayName("Test new Tree(Material); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material)"})
  void testNewTree_whenLegacyLog2_thenReturnItemTypeIsLegacyLog() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG_2);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies)"})
  void testNewTree_whenLegacyLog2_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG_2, TreeSpecies.GENERIC);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG_2}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies); when 'LEGACY_LOG_2'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies)"})
  void testNewTree_whenLegacyLog2_thenReturnItemTypeIsLegacyLog22() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG_2, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG_2, actualTree.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies)}.
   *
   * <ul>
   *   <li>When {@code LEGACY_LOG}.
   *   <li>Then return ItemType is {@code LEGACY_LOG_2}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies); when 'LEGACY_LOG'; then return ItemType is 'LEGACY_LOG_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies)"})
  void testNewTree_whenLegacyLog_thenReturnItemTypeIsLegacyLog2() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG, TreeSpecies.ACACIA);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG_2, actualTree.getItemType());
    assertEquals(TreeSpecies.ACACIA, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Direction is {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies, BlockFace); when 'NORTH'; then return Direction is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies, BlockFace)"})
  void testNewTree_whenNorth_thenReturnDirectionIsNorth() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG_2, TreeSpecies.GENERIC, BlockFace.NORTH);

    // Assert
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.NORTH, actualTree.getDirection());
    assertEquals('\b', actualTree.getData());
  }

  /**
   * Test {@link Tree#Tree(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Direction is {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(TreeSpecies, BlockFace); when 'NORTH'; then return Direction is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(TreeSpecies, BlockFace)"})
  void testNewTree_whenNorth_thenReturnDirectionIsNorth2() {
    // Arrange and Act
    Tree actualTree = new Tree(TreeSpecies.GENERIC, BlockFace.NORTH);

    // Assert
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.NORTH, actualTree.getDirection());
    assertEquals('\b', actualTree.getData());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SELF}.
   *   <li>Then return Direction is {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies, BlockFace); when 'SELF'; then return Direction is 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies, BlockFace)"})
  void testNewTree_whenSelf_thenReturnDirectionIsSelf() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG_2, TreeSpecies.GENERIC, BlockFace.SELF);

    // Assert
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.SELF, actualTree.getDirection());
    assertEquals('\f', actualTree.getData());
  }

  /**
   * Test {@link Tree#Tree(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SELF}.
   *   <li>Then return Direction is {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(TreeSpecies, BlockFace); when 'SELF'; then return Direction is 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(TreeSpecies, BlockFace)"})
  void testNewTree_whenSelf_thenReturnDirectionIsSelf2() {
    // Arrange and Act
    Tree actualTree = new Tree(TreeSpecies.GENERIC, BlockFace.SELF);

    // Assert
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.SELF, actualTree.getDirection());
    assertEquals('\f', actualTree.getData());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies, BlockFace); when 'UP'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies, BlockFace)"})
  void testNewTree_whenUp_thenReturnDataIsZero() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG_2, TreeSpecies.GENERIC, BlockFace.UP);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName("Test new Tree(TreeSpecies, BlockFace); when 'UP'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(TreeSpecies, BlockFace)"})
  void testNewTree_whenUp_thenReturnDataIsZero2() {
    // Arrange and Act
    Tree actualTree = new Tree(TreeSpecies.GENERIC, BlockFace.UP);

    // Assert
    assertEquals((byte) 0, actualTree.getData());
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.UP, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(Material, TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(Material, TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new Tree(Material, TreeSpecies, BlockFace); when 'WEST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(Material, TreeSpecies, BlockFace)"})
  void testNewTree_whenWest_thenReturnDataIsFour() {
    // Arrange and Act
    Tree actualTree = new Tree(Material.LEGACY_LOG_2, TreeSpecies.GENERIC, BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, actualTree.getData());
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.WEST, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#Tree(TreeSpecies, BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Tree#Tree(TreeSpecies, BlockFace)}
   */
  @Test
  @DisplayName("Test new Tree(TreeSpecies, BlockFace); when 'WEST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.<init>(TreeSpecies, BlockFace)"})
  void testNewTree_whenWest_thenReturnDataIsFour2() {
    // Arrange and Act
    Tree actualTree = new Tree(TreeSpecies.GENERIC, BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, actualTree.getData());
    assertEquals(Material.LEGACY_LOG, actualTree.getItemType());
    assertEquals(TreeSpecies.GENERIC, actualTree.getSpecies());
    assertEquals(BlockFace.WEST, actualTree.getDirection());
  }

  /**
   * Test {@link Tree#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Tree#Tree()} Data is minus one.
   *   <li>Then return {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given Tree() Data is minus one; then return 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Tree.getDirection()"})
  void testGetDirection_givenTreeDataIsMinusOne_thenReturnSelf() {
    // Arrange
    Tree tree = new Tree();
    tree.setData((byte) -1);

    // Act and Assert
    assertEquals(BlockFace.SELF, tree.getDirection());
  }

  /**
   * Test {@link Tree#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Tree#Tree()} Data is {@code X}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given Tree() Data is 'X'; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Tree.getDirection()"})
  void testGetDirection_givenTreeDataIsX_thenReturnNorth() {
    // Arrange
    Tree tree = new Tree();
    tree.setData((byte) 'X');

    // Act and Assert
    assertEquals(BlockFace.NORTH, tree.getDirection());
  }

  /**
   * Test {@link Tree#getDirection()}.
   *
   * <ul>
   *   <li>Given {@link Tree#Tree()}.
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given Tree(); then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Tree.getDirection()"})
  void testGetDirection_givenTree_thenReturnUp() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.UP, new Tree().getDirection());
  }

  /**
   * Test {@link Tree#setDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Tree#Tree()} Direction is {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#setDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setDirection(BlockFace); when 'NORTH'; then Tree() Direction is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.setDirection(BlockFace)"})
  void testSetDirection_whenNorth_thenTreeDirectionIsNorth() {
    // Arrange
    Tree tree = new Tree();

    // Act
    tree.setDirection(BlockFace.NORTH);

    // Assert
    assertEquals(BlockFace.NORTH, tree.getDirection());
    assertEquals('\b', tree.getData());
  }

  /**
   * Test {@link Tree#setDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SELF}.
   *   <li>Then {@link Tree#Tree()} Direction is {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link Tree#setDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setDirection(BlockFace); when 'SELF'; then Tree() Direction is 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.setDirection(BlockFace)"})
  void testSetDirection_whenSelf_thenTreeDirectionIsSelf() {
    // Arrange
    Tree tree = new Tree();

    // Act
    tree.setDirection(BlockFace.SELF);

    // Assert
    assertEquals(BlockFace.SELF, tree.getDirection());
    assertEquals('\f', tree.getData());
  }

  /**
   * Test {@link Tree#setDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Tree#Tree()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Tree#setDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setDirection(BlockFace); when 'UP'; then Tree() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.setDirection(BlockFace)"})
  void testSetDirection_whenUp_thenTreeDataIsZero() {
    // Arrange
    Tree tree = new Tree();

    // Act
    tree.setDirection(BlockFace.UP);

    // Assert that nothing has changed
    assertEquals((byte) 0, tree.getData());
    assertEquals(BlockFace.UP, tree.getDirection());
  }

  /**
   * Test {@link Tree#setDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Tree#Tree()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Tree#setDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setDirection(BlockFace); when 'WEST'; then Tree() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tree.setDirection(BlockFace)"})
  void testSetDirection_whenWest_thenTreeDataIsFour() {
    // Arrange
    Tree tree = new Tree();

    // Act
    tree.setDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, tree.getData());
    assertEquals(BlockFace.WEST, tree.getDirection());
  }

  /**
   * Test {@link Tree#clone()}.
   *
   * <p>Method under test: {@link Tree#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tree Tree.clone()"})
  void testClone() {
    // Arrange
    Tree tree = new Tree();

    // Act
    Tree actualCloneResult = tree.clone();

    // Assert
    assertEquals(tree, actualCloneResult);
  }
}
