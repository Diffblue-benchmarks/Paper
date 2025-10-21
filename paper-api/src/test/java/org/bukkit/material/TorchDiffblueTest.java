package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TorchDiffblueTest {
  /**
   * Test {@link Torch#Torch()}.
   *
   * <p>Method under test: {@link Torch#Torch()}
   */
  @Test
  @DisplayName("Test new Torch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Torch.<init>()"})
  void testNewTorch() {
    // Arrange and Act
    Torch actualTorch = new Torch();

    // Assert
    assertEquals((byte) 0, actualTorch.getData());
    assertEquals(Material.LEGACY_TORCH, actualTorch.getItemType());
    assertEquals(BlockFace.DOWN, actualTorch.getAttachedFace());
    assertEquals(BlockFace.UP, actualTorch.getFacing());
  }

  /**
   * Test {@link Torch#Torch(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Torch#Torch(Material, byte)}
   */
  @Test
  @DisplayName("Test new Torch(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Torch.<init>(Material)", "void Torch.<init>(Material, byte)"})
  void testNewTorch_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Torch actualTorch = new Torch(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualTorch.getItemType());
    assertEquals('A', actualTorch.getData());
  }

  /**
   * Test {@link Torch#Torch(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Torch#Torch(Material)}
   */
  @Test
  @DisplayName("Test new Torch(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Torch.<init>(Material)", "void Torch.<init>(Material, byte)"})
  void testNewTorch_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Torch actualTorch = new Torch(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualTorch.getData());
    assertEquals(Material.ACACIA_BOAT, actualTorch.getItemType());
  }

  /**
   * Test {@link Torch#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Torch#Torch(Material)} with type is {@code ACACIA_BOAT} Data is four.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Torch#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Torch(Material) with type is 'ACACIA_BOAT' Data is four; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Torch.getAttachedFace()"})
  void testGetAttachedFace_givenTorchWithTypeIsAcaciaBoatDataIsFour_thenReturnSouth() {
    // Arrange
    Torch torch = new Torch(Material.ACACIA_BOAT);
    torch.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, torch.getAttachedFace());
  }

  /**
   * Test {@link Torch#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Torch#Torch(Material)} with type is {@code ACACIA_BOAT} Data is one.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Torch#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Torch(Material) with type is 'ACACIA_BOAT' Data is one; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Torch.getAttachedFace()"})
  void testGetAttachedFace_givenTorchWithTypeIsAcaciaBoatDataIsOne_thenReturnWest() {
    // Arrange
    Torch torch = new Torch(Material.ACACIA_BOAT);
    torch.setData((byte) 1);

    // Act and Assert
    assertEquals(BlockFace.WEST, torch.getAttachedFace());
  }

  /**
   * Test {@link Torch#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Torch#Torch(Material)} with type is {@code ACACIA_BOAT} Data is three.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Torch#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Torch(Material) with type is 'ACACIA_BOAT' Data is three; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Torch.getAttachedFace()"})
  void testGetAttachedFace_givenTorchWithTypeIsAcaciaBoatDataIsThree_thenReturnNorth() {
    // Arrange
    Torch torch = new Torch(Material.ACACIA_BOAT);
    torch.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.NORTH, torch.getAttachedFace());
  }

  /**
   * Test {@link Torch#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Torch#Torch(Material)} with type is {@code ACACIA_BOAT} Data is two.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Torch#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Torch(Material) with type is 'ACACIA_BOAT' Data is two; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Torch.getAttachedFace()"})
  void testGetAttachedFace_givenTorchWithTypeIsAcaciaBoatDataIsTwo_thenReturnEast() {
    // Arrange
    Torch torch = new Torch(Material.ACACIA_BOAT);
    torch.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.EAST, torch.getAttachedFace());
  }

  /**
   * Test {@link Torch#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Torch#Torch()}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Torch#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given Torch(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Torch.getAttachedFace()"})
  void testGetAttachedFace_givenTorch_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Torch().getAttachedFace());
  }

  /**
   * Test {@link Torch#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Torch#Torch()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Torch#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Torch() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Torch.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenTorchDataIsOne() {
    // Arrange
    Torch torch = new Torch();

    // Act
    torch.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 1, torch.getData());
    assertEquals(BlockFace.EAST, torch.getFacing());
    assertEquals(BlockFace.WEST, torch.getAttachedFace());
  }

  /**
   * Test {@link Torch#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Torch#Torch()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Torch#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Torch() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Torch.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenTorchDataIsFour() {
    // Arrange
    Torch torch = new Torch();

    // Act
    torch.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 4, torch.getData());
    assertEquals(BlockFace.NORTH, torch.getFacing());
    assertEquals(BlockFace.SOUTH, torch.getAttachedFace());
  }

  /**
   * Test {@link Torch#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Torch#Torch()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Torch#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Torch() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Torch.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenTorchDataIsThree() {
    // Arrange
    Torch torch = new Torch();

    // Act
    torch.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, torch.getData());
    assertEquals(BlockFace.NORTH, torch.getAttachedFace());
    assertEquals(BlockFace.SOUTH, torch.getFacing());
  }

  /**
   * Test {@link Torch#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Torch#Torch()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Torch#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'UP'; then Torch() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Torch.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenUp_thenTorchDataIsFive() {
    // Arrange
    Torch torch = new Torch();

    // Act
    torch.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 5, torch.getData());
    assertEquals(BlockFace.DOWN, torch.getAttachedFace());
    assertEquals(BlockFace.UP, torch.getFacing());
  }

  /**
   * Test {@link Torch#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Torch#Torch()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Torch#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Torch() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Torch.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenTorchDataIsTwo() {
    // Arrange
    Torch torch = new Torch();

    // Act
    torch.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 2, torch.getData());
    assertEquals(BlockFace.EAST, torch.getAttachedFace());
    assertEquals(BlockFace.WEST, torch.getFacing());
  }

  /**
   * Test {@link Torch#clone()}.
   *
   * <p>Method under test: {@link Torch#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Torch Torch.clone()"})
  void testClone() {
    // Arrange
    Torch torch = new Torch();

    // Act
    Torch actualCloneResult = torch.clone();

    // Assert
    assertEquals(torch, actualCloneResult);
  }
}
