package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CakeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code ACACIA_BOAT(0) 0/6 slices eaten/remaining}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Cake#Cake(Material)}
   *   <li>{@link Cake#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return toString is 'ACACIA_BOAT(0) 0/6 slices eaten/remaining'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Cake.<init>(Material)",
    "void Cake.<init>(Material, byte)",
    "java.lang.String Cake.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsAcaciaBoat006SlicesEatenRemaining() {
    // Arrange and Act
    Cake actualCake = new Cake(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) 0/6 slices eaten/remaining", actualCake.toString());
    assertEquals((byte) 0, actualCake.getData());
    assertEquals(Material.ACACIA_BOAT, actualCake.getItemType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code ACACIA_BOAT(65) 65/-59 slices eaten/remaining}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Cake#Cake(Material, byte)}
   *   <li>{@link Cake#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return toString is 'ACACIA_BOAT(65) 65/-59 slices eaten/remaining'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Cake.<init>(Material)",
    "void Cake.<init>(Material, byte)",
    "java.lang.String Cake.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsAcaciaBoat656559SlicesEatenRemaining() {
    // Arrange and Act
    Cake actualCake = new Cake(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) 65/-59 slices eaten/remaining", actualCake.toString());
    assertEquals(Material.ACACIA_BOAT, actualCake.getItemType());
    assertEquals('A', actualCake.getData());
  }

  /**
   * Test {@link Cake#Cake()}.
   *
   * <p>Method under test: {@link Cake#Cake()}
   */
  @Test
  @DisplayName("Test new Cake()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cake.<init>()"})
  void testNewCake() {
    // Arrange and Act
    Cake actualCake = new Cake();

    // Assert
    assertEquals(0, actualCake.getSlicesEaten());
    assertEquals((byte) 0, actualCake.getData());
    assertEquals(6, actualCake.getSlicesRemaining());
    assertEquals(Material.LEGACY_CAKE_BLOCK, actualCake.getItemType());
  }

  /**
   * Test {@link Cake#getSlicesEaten()}.
   *
   * <p>Method under test: {@link Cake#getSlicesEaten()}
   */
  @Test
  @DisplayName("Test getSlicesEaten()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Cake.getSlicesEaten()"})
  void testGetSlicesEaten() {
    // Arrange, Act and Assert
    assertEquals(0, new Cake().getSlicesEaten());
  }

  /**
   * Test {@link Cake#getSlicesRemaining()}.
   *
   * <p>Method under test: {@link Cake#getSlicesRemaining()}
   */
  @Test
  @DisplayName("Test getSlicesRemaining()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Cake.getSlicesRemaining()"})
  void testGetSlicesRemaining() {
    // Arrange, Act and Assert
    assertEquals(6, new Cake().getSlicesRemaining());
  }

  /**
   * Test {@link Cake#setSlicesEaten(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link Cake#Cake()} SlicesEaten is one.
   * </ul>
   *
   * <p>Method under test: {@link Cake#setSlicesEaten(int)}
   */
  @Test
  @DisplayName("Test setSlicesEaten(int); when one; then Cake() SlicesEaten is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cake.setSlicesEaten(int)"})
  void testSetSlicesEaten_whenOne_thenCakeSlicesEatenIsOne() {
    // Arrange
    Cake cake = new Cake();

    // Act
    cake.setSlicesEaten(1);

    // Assert
    assertEquals(1, cake.getSlicesEaten());
    assertEquals((byte) 1, cake.getData());
    assertEquals(5, cake.getSlicesRemaining());
  }

  /**
   * Test {@link Cake#setSlicesEaten(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then {@link Cake#Cake()} SlicesEaten is zero.
   * </ul>
   *
   * <p>Method under test: {@link Cake#setSlicesEaten(int)}
   */
  @Test
  @DisplayName("Test setSlicesEaten(int); when six; then Cake() SlicesEaten is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cake.setSlicesEaten(int)"})
  void testSetSlicesEaten_whenSix_thenCakeSlicesEatenIsZero() {
    // Arrange
    Cake cake = new Cake();

    // Act
    cake.setSlicesEaten(6);

    // Assert that nothing has changed
    assertEquals(0, cake.getSlicesEaten());
    assertEquals((byte) 0, cake.getData());
    assertEquals(6, cake.getSlicesRemaining());
  }

  /**
   * Test {@link Cake#setSlicesRemaining(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link Cake#Cake()} SlicesRemaining is one.
   * </ul>
   *
   * <p>Method under test: {@link Cake#setSlicesRemaining(int)}
   */
  @Test
  @DisplayName("Test setSlicesRemaining(int); when one; then Cake() SlicesRemaining is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cake.setSlicesRemaining(int)"})
  void testSetSlicesRemaining_whenOne_thenCakeSlicesRemainingIsOne() {
    // Arrange
    Cake cake = new Cake();

    // Act
    cake.setSlicesRemaining(1);

    // Assert
    assertEquals(1, cake.getSlicesRemaining());
    assertEquals(5, cake.getSlicesEaten());
    assertEquals((byte) 5, cake.getData());
  }

  /**
   * Test {@link Cake#setSlicesRemaining(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then {@link Cake#Cake()} SlicesEaten is zero.
   * </ul>
   *
   * <p>Method under test: {@link Cake#setSlicesRemaining(int)}
   */
  @Test
  @DisplayName("Test setSlicesRemaining(int); when seven; then Cake() SlicesEaten is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cake.setSlicesRemaining(int)"})
  void testSetSlicesRemaining_whenSeven_thenCakeSlicesEatenIsZero() {
    // Arrange
    Cake cake = new Cake();

    // Act
    cake.setSlicesRemaining(7);

    // Assert that nothing has changed
    assertEquals(0, cake.getSlicesEaten());
    assertEquals((byte) 0, cake.getData());
    assertEquals(6, cake.getSlicesRemaining());
  }

  /**
   * Test {@link Cake#clone()}.
   *
   * <p>Method under test: {@link Cake#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Cake Cake.clone()"})
  void testClone() {
    // Arrange
    Cake cake = new Cake();

    // Act
    Cake actualCloneResult = cake.clone();

    // Assert
    assertEquals(cake, actualCloneResult);
  }
}
