package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ObserverDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code ACACIA_BOAT(65) facing UP}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Observer#Observer(Material, byte)}
   *   <li>{@link Observer#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'A'; then return toString is 'ACACIA_BOAT(65) facing UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Observer.<init>(Material)",
    "void Observer.<init>(Material, byte)",
    "java.lang.String Observer.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsAcaciaBoat65FacingUp() {
    // Arrange and Act
    Observer actualObserver = new Observer(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) facing UP", actualObserver.toString());
    assertEquals(Material.ACACIA_BOAT, actualObserver.getItemType());
    assertEquals('A', actualObserver.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code ACACIA_BOAT(0) facing DOWN}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Observer#Observer(Material)}
   *   <li>{@link Observer#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'ACACIA_BOAT(0) facing DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Observer.<init>(Material)",
    "void Observer.<init>(Material, byte)",
    "java.lang.String Observer.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsAcaciaBoat0FacingDown() {
    // Arrange and Act
    Observer actualObserver = new Observer(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) facing DOWN", actualObserver.toString());
    assertEquals((byte) 0, actualObserver.getData());
    assertEquals(Material.ACACIA_BOAT, actualObserver.getItemType());
  }

  /**
   * Test {@link Observer#Observer()}.
   *
   * <p>Method under test: {@link Observer#Observer()}
   */
  @Test
  @DisplayName("Test new Observer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.<init>()"})
  void testNewObserver() {
    // Arrange and Act
    Observer actualObserver = new Observer();

    // Assert
    assertEquals((byte) 0, actualObserver.getData());
    assertEquals(Material.LEGACY_OBSERVER, actualObserver.getItemType());
    assertEquals(BlockFace.DOWN, actualObserver.getFacing());
    assertFalse(actualObserver.isPowered());
  }

  /**
   * Test {@link Observer#Observer(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Observer#Observer(BlockFace)}
   */
  @Test
  @DisplayName("Test new Observer(BlockFace); when 'DOWN'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.<init>(BlockFace)"})
  void testNewObserver_whenDown_thenReturnDataIsZero() {
    // Arrange and Act
    Observer actualObserver = new Observer(BlockFace.DOWN);

    // Assert
    assertEquals((byte) 0, actualObserver.getData());
    assertEquals(Material.LEGACY_OBSERVER, actualObserver.getItemType());
    assertEquals(BlockFace.DOWN, actualObserver.getFacing());
    assertFalse(actualObserver.isPowered());
  }

  /**
   * Test {@link Observer#Observer(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Observer#Observer(BlockFace)}
   */
  @Test
  @DisplayName("Test new Observer(BlockFace); when 'EAST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.<init>(BlockFace)"})
  void testNewObserver_whenEast_thenReturnDataIsFour() {
    // Arrange and Act
    Observer actualObserver = new Observer(BlockFace.EAST);

    // Assert
    assertEquals((byte) 4, actualObserver.getData());
    assertEquals(Material.LEGACY_OBSERVER, actualObserver.getItemType());
    assertEquals(BlockFace.EAST, actualObserver.getFacing());
    assertFalse(actualObserver.isPowered());
  }

  /**
   * Test {@link Observer#Observer(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Observer#Observer(BlockFace)}
   */
  @Test
  @DisplayName("Test new Observer(BlockFace); when 'NORTH_EAST'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.<init>(BlockFace)"})
  void testNewObserver_whenNorthEast_thenReturnDataIsZero() {
    // Arrange and Act
    Observer actualObserver = new Observer(BlockFace.NORTH_EAST);

    // Assert
    assertEquals((byte) 0, actualObserver.getData());
    assertEquals(Material.LEGACY_OBSERVER, actualObserver.getItemType());
    assertEquals(BlockFace.DOWN, actualObserver.getFacing());
    assertFalse(actualObserver.isPowered());
  }

  /**
   * Test {@link Observer#Observer(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Observer#Observer(BlockFace)}
   */
  @Test
  @DisplayName("Test new Observer(BlockFace); when 'NORTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.<init>(BlockFace)"})
  void testNewObserver_whenNorth_thenReturnDataIsThree() {
    // Arrange and Act
    Observer actualObserver = new Observer(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 3, actualObserver.getData());
    assertEquals(Material.LEGACY_OBSERVER, actualObserver.getItemType());
    assertEquals(BlockFace.NORTH, actualObserver.getFacing());
    assertFalse(actualObserver.isPowered());
  }

  /**
   * Test {@link Observer#Observer(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Observer#Observer(BlockFace)}
   */
  @Test
  @DisplayName("Test new Observer(BlockFace); when 'SOUTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.<init>(BlockFace)"})
  void testNewObserver_whenSouth_thenReturnDataIsTwo() {
    // Arrange and Act
    Observer actualObserver = new Observer(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 2, actualObserver.getData());
    assertEquals(Material.LEGACY_OBSERVER, actualObserver.getItemType());
    assertEquals(BlockFace.SOUTH, actualObserver.getFacing());
    assertFalse(actualObserver.isPowered());
  }

  /**
   * Test {@link Observer#Observer(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Observer#Observer(BlockFace)}
   */
  @Test
  @DisplayName("Test new Observer(BlockFace); when 'UP'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.<init>(BlockFace)"})
  void testNewObserver_whenUp_thenReturnDataIsOne() {
    // Arrange and Act
    Observer actualObserver = new Observer(BlockFace.UP);

    // Assert
    assertEquals((byte) 1, actualObserver.getData());
    assertEquals(Material.LEGACY_OBSERVER, actualObserver.getItemType());
    assertEquals(BlockFace.UP, actualObserver.getFacing());
    assertFalse(actualObserver.isPowered());
  }

  /**
   * Test {@link Observer#Observer(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Observer#Observer(BlockFace)}
   */
  @Test
  @DisplayName("Test new Observer(BlockFace); when 'WEST'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.<init>(BlockFace)"})
  void testNewObserver_whenWest_thenReturnDataIsFive() {
    // Arrange and Act
    Observer actualObserver = new Observer(BlockFace.WEST);

    // Assert
    assertEquals((byte) 5, actualObserver.getData());
    assertEquals(Material.LEGACY_OBSERVER, actualObserver.getItemType());
    assertEquals(BlockFace.WEST, actualObserver.getFacing());
    assertFalse(actualObserver.isPowered());
  }

  /**
   * Test {@link Observer#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer()} Data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Observer() Data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Observer.isPowered()"})
  void testIsPowered_givenObserverDataIsX_thenReturnTrue() {
    // Arrange
    Observer observer = new Observer();
    observer.setData((byte) 'X');

    // Act and Assert
    assertTrue(observer.isPowered());
  }

  /**
   * Test {@link Observer#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Observer(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Observer.isPowered()"})
  void testIsPowered_givenObserver_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Observer().isPowered());
  }

  /**
   * Test {@link Observer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then {@link Observer#Observer()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Observer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'DOWN'; then Observer() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenDown_thenObserverDataIsZero() {
    // Arrange
    Observer observer = new Observer();

    // Act
    observer.setFacingDirection(BlockFace.DOWN);

    // Assert that nothing has changed
    assertEquals((byte) 0, observer.getData());
    assertEquals(BlockFace.DOWN, observer.getFacing());
  }

  /**
   * Test {@link Observer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Observer#Observer()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Observer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Observer() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenObserverDataIsFour() {
    // Arrange
    Observer observer = new Observer();

    // Act
    observer.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 4, observer.getData());
    assertEquals(BlockFace.EAST, observer.getFacing());
  }

  /**
   * Test {@link Observer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then {@link Observer#Observer()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Observer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'NORTH_EAST'; then Observer() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorthEast_thenObserverDataIsZero() {
    // Arrange
    Observer observer = new Observer();

    // Act
    observer.setFacingDirection(BlockFace.NORTH_EAST);

    // Assert that nothing has changed
    assertEquals((byte) 0, observer.getData());
    assertEquals(BlockFace.DOWN, observer.getFacing());
  }

  /**
   * Test {@link Observer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Observer#Observer()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Observer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Observer() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenObserverDataIsThree() {
    // Arrange
    Observer observer = new Observer();

    // Act
    observer.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 3, observer.getData());
    assertEquals(BlockFace.NORTH, observer.getFacing());
  }

  /**
   * Test {@link Observer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Observer#Observer()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Observer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Observer() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenObserverDataIsTwo() {
    // Arrange
    Observer observer = new Observer();

    // Act
    observer.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 2, observer.getData());
    assertEquals(BlockFace.SOUTH, observer.getFacing());
  }

  /**
   * Test {@link Observer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Observer#Observer()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Observer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'UP'; then Observer() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenUp_thenObserverDataIsOne() {
    // Arrange
    Observer observer = new Observer();

    // Act
    observer.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 1, observer.getData());
    assertEquals(BlockFace.UP, observer.getFacing());
  }

  /**
   * Test {@link Observer#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Observer#Observer()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Observer#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Observer() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Observer.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenObserverDataIsFive() {
    // Arrange
    Observer observer = new Observer();

    // Act
    observer.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 5, observer.getData());
    assertEquals(BlockFace.WEST, observer.getFacing());
  }

  /**
   * Test {@link Observer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer()} Data is {@code A}.
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Observer() Data is 'A'; then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Observer.getFacing()"})
  void testGetFacing_givenObserverDataIsA_thenReturnUp() {
    // Arrange
    Observer observer = new Observer();
    observer.setData((byte) 'A');

    // Act and Assert
    assertEquals(BlockFace.UP, observer.getFacing());
  }

  /**
   * Test {@link Observer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer()} Data is five.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Observer() Data is five; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Observer.getFacing()"})
  void testGetFacing_givenObserverDataIsFive_thenReturnWest() {
    // Arrange
    Observer observer = new Observer();
    observer.setData((byte) 5);

    // Act and Assert
    assertEquals(BlockFace.WEST, observer.getFacing());
  }

  /**
   * Test {@link Observer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer()} Data is four.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Observer() Data is four; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Observer.getFacing()"})
  void testGetFacing_givenObserverDataIsFour_thenReturnEast() {
    // Arrange
    Observer observer = new Observer();
    observer.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.EAST, observer.getFacing());
  }

  /**
   * Test {@link Observer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer()} Data is seven.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Observer() Data is seven; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Observer.getFacing()"})
  void testGetFacing_givenObserverDataIsSeven_thenThrowIllegalArgumentException() {
    // Arrange
    Observer observer = new Observer();
    observer.setData((byte) 7);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> observer.getFacing());
  }

  /**
   * Test {@link Observer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer()} Data is two.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Observer() Data is two; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Observer.getFacing()"})
  void testGetFacing_givenObserverDataIsTwo_thenReturnSouth() {
    // Arrange
    Observer observer = new Observer();
    observer.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, observer.getFacing());
  }

  /**
   * Test {@link Observer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer(BlockFace)} with direction is {@code NORTH}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Observer(BlockFace) with direction is 'NORTH'; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Observer.getFacing()"})
  void testGetFacing_givenObserverWithDirectionIsNorth_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Observer(BlockFace.NORTH).getFacing());
  }

  /**
   * Test {@link Observer#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Observer#Observer()}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Observer#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Observer(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Observer.getFacing()"})
  void testGetFacing_givenObserver_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Observer().getFacing());
  }

  /**
   * Test {@link Observer#clone()}.
   *
   * <p>Method under test: {@link Observer#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Observer Observer.clone()"})
  void testClone() {
    // Arrange
    Observer observer = new Observer();

    // Act
    Observer actualCloneResult = observer.clone();

    // Assert
    assertEquals(observer, actualCloneResult);
  }
}
