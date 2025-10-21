package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DirectionalContainerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code ACACIA_BOAT(65) facing EAST}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DirectionalContainer#DirectionalContainer(Material, byte)}
   *   <li>{@link DirectionalContainer#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'A'; then return toString is 'ACACIA_BOAT(65) facing EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DirectionalContainer.<init>(Material)",
    "void DirectionalContainer.<init>(Material, byte)",
    "java.lang.String DirectionalContainer.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsAcaciaBoat65FacingEast() {
    // Arrange and Act
    DirectionalContainer actualDirectionalContainer =
        new DirectionalContainer(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) facing EAST", actualDirectionalContainer.toString());
    assertEquals(Material.ACACIA_BOAT, actualDirectionalContainer.getItemType());
    assertEquals('A', actualDirectionalContainer.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code ACACIA_BOAT(0) facing EAST}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DirectionalContainer#DirectionalContainer(Material)}
   *   <li>{@link DirectionalContainer#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'ACACIA_BOAT(0) facing EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DirectionalContainer.<init>(Material)",
    "void DirectionalContainer.<init>(Material, byte)",
    "java.lang.String DirectionalContainer.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsAcaciaBoat0FacingEast() {
    // Arrange and Act
    DirectionalContainer actualDirectionalContainer =
        new DirectionalContainer(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) facing EAST", actualDirectionalContainer.toString());
    assertEquals((byte) 0, actualDirectionalContainer.getData());
    assertEquals(Material.ACACIA_BOAT, actualDirectionalContainer.getItemType());
  }

  /**
   * Test {@link DirectionalContainer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Dispenser#Dispenser()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Dispenser#Dispenser()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Dispenser(); when 'NORTH'; then Dispenser() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DirectionalContainer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenDispenser_whenNorth_thenDispenserDataIsTwo() {
    // Arrange
    Dispenser dispenser = new Dispenser();

    // Act
    dispenser.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, dispenser.getData());
    assertEquals(BlockFace.NORTH, dispenser.getFacing());
  }

  /**
   * Test {@link DirectionalContainer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link DirectionalContainer#DirectionalContainer(Material)} with type is {@code
   *       ACACIA_BOAT} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then DirectionalContainer(Material) with type is 'ACACIA_BOAT' Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DirectionalContainer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenDirectionalContainerWithTypeIsAcaciaBoatDataIsFive() {
    // Arrange
    DirectionalContainer directionalContainer = new DirectionalContainer(Material.ACACIA_BOAT);

    // Act
    directionalContainer.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, directionalContainer.getData());
    assertEquals(BlockFace.EAST, directionalContainer.getFacing());
  }

  /**
   * Test {@link DirectionalContainer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link DirectionalContainer#DirectionalContainer(Material)} with type is {@code
   *       ACACIA_BOAT} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then DirectionalContainer(Material) with type is 'ACACIA_BOAT' Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DirectionalContainer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenDirectionalContainerWithTypeIsAcaciaBoatDataIsFour() {
    // Arrange
    DirectionalContainer directionalContainer = new DirectionalContainer(Material.ACACIA_BOAT);

    // Act
    directionalContainer.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, directionalContainer.getData());
    assertEquals(BlockFace.WEST, directionalContainer.getFacing());
  }

  /**
   * Test {@link DirectionalContainer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link DirectionalContainer#DirectionalContainer(Material)} with type is {@code
   *       ACACIA_BOAT} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then DirectionalContainer(Material) with type is 'ACACIA_BOAT' Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DirectionalContainer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenDirectionalContainerWithTypeIsAcaciaBoatDataIsThree() {
    // Arrange
    DirectionalContainer directionalContainer = new DirectionalContainer(Material.ACACIA_BOAT);

    // Act
    directionalContainer.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, directionalContainer.getData());
    assertEquals(BlockFace.SOUTH, directionalContainer.getFacing());
  }

  /**
   * Test {@link DirectionalContainer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link DirectionalContainer#DirectionalContainer(Material)} with type is {@code
   *       ACACIA_BOAT} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then DirectionalContainer(Material) with type is 'ACACIA_BOAT' Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DirectionalContainer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenDirectionalContainerWithTypeIsAcaciaBoatDataIsTwo() {
    // Arrange
    DirectionalContainer directionalContainer = new DirectionalContainer(Material.ACACIA_BOAT);

    // Act
    directionalContainer.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, directionalContainer.getData());
    assertEquals(BlockFace.NORTH, directionalContainer.getFacing());
  }

  /**
   * Test {@link DirectionalContainer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link DirectionalContainer#DirectionalContainer(Material)} with type is {@code
   *       ACACIA_BOAT}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given DirectionalContainer(Material) with type is 'ACACIA_BOAT'; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace DirectionalContainer.getFacing()"})
  void testGetFacing_givenDirectionalContainerWithTypeIsAcaciaBoat_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new DirectionalContainer(Material.ACACIA_BOAT).getFacing());
  }

  /**
   * Test {@link DirectionalContainer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Dispenser#Dispenser()}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Dispenser(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace DirectionalContainer.getFacing()"})
  void testGetFacing_givenDispenser_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Dispenser().getFacing());
  }

  /**
   * Test {@link DirectionalContainer#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace DirectionalContainer.getFacing()"})
  void testGetFacing_thenReturnNorth() {
    // Arrange
    DirectionalContainer directionalContainer = new DirectionalContainer(Material.ACACIA_BOAT);
    directionalContainer.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.NORTH, directionalContainer.getFacing());
  }

  /**
   * Test {@link DirectionalContainer#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace DirectionalContainer.getFacing()"})
  void testGetFacing_thenReturnSouth() {
    // Arrange
    DirectionalContainer directionalContainer = new DirectionalContainer(Material.ACACIA_BOAT);
    directionalContainer.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, directionalContainer.getFacing());
  }

  /**
   * Test {@link DirectionalContainer#getFacing()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalContainer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace DirectionalContainer.getFacing()"})
  void testGetFacing_thenReturnWest() {
    // Arrange
    DirectionalContainer directionalContainer = new DirectionalContainer(Material.ACACIA_BOAT);
    directionalContainer.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.WEST, directionalContainer.getFacing());
  }

  /**
   * Test {@link DirectionalContainer#clone()}.
   *
   * <p>Method under test: {@link DirectionalContainer#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectionalContainer DirectionalContainer.clone()"})
  void testClone() {
    // Arrange
    DirectionalContainer directionalContainer = new DirectionalContainer(Material.ACACIA_BOAT);

    // Act
    DirectionalContainer actualCloneResult = directionalContainer.clone();

    // Assert
    assertEquals(directionalContainer, actualCloneResult);
  }
}
