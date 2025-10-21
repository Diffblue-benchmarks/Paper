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

class VineDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Vine#Vine(Material, byte)}
   *   <li>{@link Vine#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.<init>(Material, byte)", "java.lang.String Vine.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    Vine actualVine = new Vine(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("VINE", actualVine.toString());
    assertEquals(Material.ACACIA_BOAT, actualVine.getItemType());
    assertEquals('A', actualVine.getData());
  }

  /**
   * Test {@link Vine#Vine()}.
   *
   * <p>Method under test: {@link Vine#Vine()}
   */
  @Test
  @DisplayName("Test new Vine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.<init>()"})
  void testNewVine() {
    // Arrange and Act
    Vine actualVine = new Vine();

    // Assert
    assertEquals((byte) 0, actualVine.getData());
    assertEquals(Material.LEGACY_VINE, actualVine.getItemType());
  }

  /**
   * Test {@link Vine#Vine(byte)}.
   *
   * <p>Method under test: {@link Vine#Vine(byte)}
   */
  @Test
  @DisplayName("Test new Vine(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.<init>(byte)"})
  void testNewVine2() {
    // Arrange and Act
    Vine actualVine = new Vine((byte) 'A');

    // Assert
    assertEquals(Material.LEGACY_VINE, actualVine.getItemType());
    assertEquals('A', actualVine.getData());
  }

  /**
   * Test {@link Vine#Vine(BlockFace[])}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is backspace.
   * </ul>
   *
   * <p>Method under test: {@link Vine#Vine(BlockFace[])}
   */
  @Test
  @DisplayName("Test new Vine(BlockFace[]); when 'EAST'; then return Data is backspace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.<init>(BlockFace[])"})
  void testNewVine_whenEast_thenReturnDataIsBackspace() {
    // Arrange and Act
    Vine actualVine = new Vine(BlockFace.EAST);

    // Assert
    assertEquals(Material.LEGACY_VINE, actualVine.getItemType());
    assertEquals('\b', actualVine.getData());
  }

  /**
   * Test {@link Vine#Vine(BlockFace[])}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Vine#Vine(BlockFace[])}
   */
  @Test
  @DisplayName("Test new Vine(BlockFace[]); when 'NORTH'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.<init>(BlockFace[])"})
  void testNewVine_whenNorth_thenReturnDataIsFour() {
    // Arrange and Act
    Vine actualVine = new Vine(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 4, actualVine.getData());
    assertEquals(Material.LEGACY_VINE, actualVine.getItemType());
  }

  /**
   * Test {@link Vine#Vine(BlockFace[])}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Vine#Vine(BlockFace[])}
   */
  @Test
  @DisplayName("Test new Vine(BlockFace[]); when 'SOUTH'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.<init>(BlockFace[])"})
  void testNewVine_whenSouth_thenReturnDataIsOne() {
    // Arrange and Act
    Vine actualVine = new Vine(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 1, actualVine.getData());
    assertEquals(Material.LEGACY_VINE, actualVine.getItemType());
  }

  /**
   * Test {@link Vine#Vine(BlockFace[])}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Vine#Vine(BlockFace[])}
   */
  @Test
  @DisplayName("Test new Vine(BlockFace[]); when 'WEST'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.<init>(BlockFace[])"})
  void testNewVine_whenWest_thenReturnDataIsTwo() {
    // Arrange and Act
    Vine actualVine = new Vine(BlockFace.WEST);

    // Assert
    assertEquals((byte) 2, actualVine.getData());
    assertEquals(Material.LEGACY_VINE, actualVine.getItemType());
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code EAST}.
   *   <li>When {@code EAST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'EAST'; when 'EAST'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsEast_whenEast_thenReturnTrue() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.EAST);

    // Act and Assert
    assertTrue(vine.isOnFace(BlockFace.EAST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code EAST}.
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'EAST'; when 'NORTH_EAST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsEast_whenNorthEast_thenReturnFalse() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.EAST);

    // Act and Assert
    assertFalse(vine.isOnFace(BlockFace.NORTH_EAST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code EAST}.
   *   <li>When {@code SOUTH_EAST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'EAST'; when 'SOUTH_EAST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsEast_whenSouthEast_thenReturnFalse() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.EAST);

    // Act and Assert
    assertFalse(vine.isOnFace(BlockFace.SOUTH_EAST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code NORTH}.
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'NORTH'; when 'NORTH_EAST'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsNorth_whenNorthEast_thenReturnTrue() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.NORTH);
    vine.putOnFace(BlockFace.EAST);

    // Act and Assert
    assertTrue(vine.isOnFace(BlockFace.NORTH_EAST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code NORTH}.
   *   <li>When {@code NORTH_WEST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'NORTH'; when 'NORTH_WEST'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsNorth_whenNorthWest_thenReturnTrue() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.NORTH);
    vine.putOnFace(BlockFace.WEST);

    // Act and Assert
    assertTrue(vine.isOnFace(BlockFace.NORTH_WEST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code NORTH}.
   *   <li>When {@code NORTH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'NORTH'; when 'NORTH'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsNorth_whenNorth_thenReturnTrue() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.NORTH);

    // Act and Assert
    assertTrue(vine.isOnFace(BlockFace.NORTH));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code WEST}.
   *   <li>When {@code NORTH_WEST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'WEST'; when 'NORTH_WEST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsWest_whenNorthWest_thenReturnFalse() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.WEST);

    // Act and Assert
    assertFalse(vine.isOnFace(BlockFace.NORTH_WEST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code WEST}.
   *   <li>When {@code SOUTH_WEST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'WEST'; when 'SOUTH_WEST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsWest_whenSouthWest_thenReturnFalse() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.WEST);

    // Act and Assert
    assertFalse(vine.isOnFace(BlockFace.SOUTH_WEST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()} OnFace is {@code WEST}.
   *   <li>When {@code WEST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine() OnFace is 'WEST'; when 'WEST'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineOnFaceIsWest_whenWest_thenReturnTrue() {
    // Arrange
    Vine vine = new Vine();
    vine.putOnFace(BlockFace.WEST);

    // Act and Assert
    assertTrue(vine.isOnFace(BlockFace.WEST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine(byte)} with data is {@code A} OnFace is {@code EAST}.
   *   <li>When {@code SOUTH_EAST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine(byte) with data is 'A' OnFace is 'EAST'; when 'SOUTH_EAST'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineWithDataIsAOnFaceIsEast_whenSouthEast_thenReturnTrue() {
    // Arrange
    Vine vine = new Vine((byte) 'A');
    vine.putOnFace(BlockFace.EAST);

    // Act and Assert
    assertTrue(vine.isOnFace(BlockFace.SOUTH_EAST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine(byte)} with data is {@code A} OnFace is {@code WEST}.
   *   <li>When {@code SOUTH_WEST}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine(byte) with data is 'A' OnFace is 'WEST'; when 'SOUTH_WEST'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineWithDataIsAOnFaceIsWest_whenSouthWest_thenReturnTrue() {
    // Arrange
    Vine vine = new Vine((byte) 'A');
    vine.putOnFace(BlockFace.WEST);

    // Act and Assert
    assertTrue(vine.isOnFace(BlockFace.SOUTH_WEST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine(byte)} with data is {@code A}.
   *   <li>When {@code SOUTH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test isOnFace(BlockFace); given Vine(byte) with data is 'A'; when 'SOUTH'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVineWithDataIsA_whenSouth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Vine((byte) 'A').isOnFace(BlockFace.SOUTH));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code DOWN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'DOWN'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenDown_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.DOWN));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code EAST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'EAST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenEast_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.EAST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'NORTH_EAST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenNorthEast_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.NORTH_EAST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code NORTH_WEST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'NORTH_WEST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenNorthWest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.NORTH_WEST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code NORTH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'NORTH'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenNorth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.NORTH));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code SOUTH_EAST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'SOUTH_EAST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenSouthEast_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.SOUTH_EAST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code SOUTH_WEST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'SOUTH_WEST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenSouthWest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.SOUTH_WEST));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code SOUTH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'SOUTH'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenSouth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.SOUTH));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code UP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'UP'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenUp_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Vine().isOnFace(BlockFace.UP));
  }

  /**
   * Test {@link Vine#isOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Vine#Vine()}.
   *   <li>When {@code WEST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#isOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test isOnFace(BlockFace); given Vine(); when 'WEST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Vine.isOnFace(BlockFace)"})
  void testIsOnFace_givenVine_whenWest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Vine().isOnFace(BlockFace.WEST));
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'DOWN'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenDown_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Vine().putOnFace(BlockFace.DOWN));
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Vine#Vine()} Data is backspace.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'EAST'; then Vine() Data is backspace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenEast_thenVineDataIsBackspace() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.EAST);

    // Assert
    assertEquals('\b', vine.getData());
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then {@link Vine#Vine()} Data is form feed (ff).
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'NORTH_EAST'; then Vine() Data is form feed (ff)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenNorthEast_thenVineDataIsFormFeed() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.NORTH_EAST);

    // Assert
    assertEquals('\f', vine.getData());
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH_WEST}.
   *   <li>Then {@link Vine#Vine()} Data is six.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'NORTH_WEST'; then Vine() Data is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenNorthWest_thenVineDataIsSix() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.NORTH_WEST);

    // Assert
    assertEquals((byte) 6, vine.getData());
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Vine#Vine()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'NORTH'; then Vine() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenNorth_thenVineDataIsFour() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 4, vine.getData());
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH_EAST}.
   *   <li>Then {@link Vine#Vine()} Data is tab.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'SOUTH_EAST'; then Vine() Data is tab")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenSouthEast_thenVineDataIsTab() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.SOUTH_EAST);

    // Assert
    assertEquals('\t', vine.getData());
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH_WEST}.
   *   <li>Then {@link Vine#Vine()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'SOUTH_WEST'; then Vine() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenSouthWest_thenVineDataIsThree() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.SOUTH_WEST);

    // Assert
    assertEquals((byte) 3, vine.getData());
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Vine#Vine()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'SOUTH'; then Vine() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenSouth_thenVineDataIsOne() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 1, vine.getData());
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Vine#Vine()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'UP'; then Vine() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenUp_thenVineDataIsZero() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.UP);

    // Assert that nothing has changed
    assertEquals((byte) 0, vine.getData());
  }

  /**
   * Test {@link Vine#putOnFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Vine#Vine()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Vine#putOnFace(BlockFace)}
   */
  @Test
  @DisplayName("Test putOnFace(BlockFace); when 'WEST'; then Vine() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.putOnFace(BlockFace)"})
  void testPutOnFace_whenWest_thenVineDataIsTwo() {
    // Arrange
    Vine vine = new Vine();

    // Act
    vine.putOnFace(BlockFace.WEST);

    // Assert
    assertEquals((byte) 2, vine.getData());
  }

  /**
   * Test {@link Vine#removeFromFace(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Vine#removeFromFace(BlockFace)}
   */
  @Test
  @DisplayName("Test removeFromFace(BlockFace); when 'DOWN'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vine.removeFromFace(BlockFace)"})
  void testRemoveFromFace_whenDown_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Vine().removeFromFace(BlockFace.DOWN));
  }

  /**
   * Test {@link Vine#clone()}.
   *
   * <p>Method under test: {@link Vine#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vine Vine.clone()"})
  void testClone() {
    // Arrange
    Vine vine = new Vine();

    // Act
    Vine actualCloneResult = vine.clone();

    // Assert
    assertEquals(vine, actualCloneResult);
  }
}
