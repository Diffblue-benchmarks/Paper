package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TripwireDiffblueTest {
  /**
   * Test {@link Tripwire#Tripwire(Material, byte)}.
   *
   * <p>Method under test: {@link Tripwire#Tripwire(Material, byte)}
   */
  @Test
  @DisplayName("Test new Tripwire(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tripwire.<init>(Material, byte)"})
  void testNewTripwire() {
    // Arrange and Act
    Tripwire actualTripwire = new Tripwire(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualTripwire.getItemType());
    assertEquals('A', actualTripwire.getData());
  }

  /**
   * Test {@link Tripwire#Tripwire()}.
   *
   * <p>Method under test: {@link Tripwire#Tripwire()}
   */
  @Test
  @DisplayName("Test new Tripwire()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tripwire.<init>()"})
  void testNewTripwire2() {
    // Arrange and Act
    Tripwire actualTripwire = new Tripwire();

    // Assert
    assertEquals((byte) 0, actualTripwire.getData());
    assertEquals(Material.LEGACY_TRIPWIRE, actualTripwire.getItemType());
    assertFalse(actualTripwire.isActivated());
    assertFalse(actualTripwire.isObjectTriggering());
  }

  /**
   * Test {@link Tripwire#isActivated()}.
   *
   * <ul>
   *   <li>Given {@link Tripwire#Tripwire()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#isActivated()}
   */
  @Test
  @DisplayName("Test isActivated(); given Tripwire(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tripwire.isActivated()"})
  void testIsActivated_givenTripwire_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Tripwire().isActivated());
  }

  /**
   * Test {@link Tripwire#isActivated()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#isActivated()}
   */
  @Test
  @DisplayName("Test isActivated(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tripwire.isActivated()"})
  void testIsActivated_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Tripwire(Material.ACACIA_BOAT, (byte) -1).isActivated());
  }

  /**
   * Test {@link Tripwire#setActivated(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Tripwire#Tripwire()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#setActivated(boolean)}
   */
  @Test
  @DisplayName("Test setActivated(boolean); when 'false'; then Tripwire() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tripwire.setActivated(boolean)"})
  void testSetActivated_whenFalse_thenTripwireDataIsZero() {
    // Arrange
    Tripwire tripwire = new Tripwire();

    // Act
    tripwire.setActivated(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, tripwire.getData());
    assertFalse(tripwire.isActivated());
  }

  /**
   * Test {@link Tripwire#setActivated(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Tripwire#Tripwire()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#setActivated(boolean)}
   */
  @Test
  @DisplayName("Test setActivated(boolean); when 'true'; then Tripwire() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tripwire.setActivated(boolean)"})
  void testSetActivated_whenTrue_thenTripwireDataIsFour() {
    // Arrange
    Tripwire tripwire = new Tripwire();

    // Act
    tripwire.setActivated(true);

    // Assert
    assertEquals((byte) 4, tripwire.getData());
    assertTrue(tripwire.isActivated());
  }

  /**
   * Test {@link Tripwire#isObjectTriggering()}.
   *
   * <ul>
   *   <li>Given {@link Tripwire#Tripwire()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#isObjectTriggering()}
   */
  @Test
  @DisplayName("Test isObjectTriggering(); given Tripwire(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tripwire.isObjectTriggering()"})
  void testIsObjectTriggering_givenTripwire_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Tripwire().isObjectTriggering());
  }

  /**
   * Test {@link Tripwire#isObjectTriggering()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#isObjectTriggering()}
   */
  @Test
  @DisplayName("Test isObjectTriggering(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tripwire.isObjectTriggering()"})
  void testIsObjectTriggering_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Tripwire(Material.ACACIA_BOAT, (byte) 'A').isObjectTriggering());
  }

  /**
   * Test {@link Tripwire#setObjectTriggering(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Tripwire#Tripwire()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#setObjectTriggering(boolean)}
   */
  @Test
  @DisplayName("Test setObjectTriggering(boolean); when 'false'; then Tripwire() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tripwire.setObjectTriggering(boolean)"})
  void testSetObjectTriggering_whenFalse_thenTripwireDataIsZero() {
    // Arrange
    Tripwire tripwire = new Tripwire();

    // Act
    tripwire.setObjectTriggering(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, tripwire.getData());
    assertFalse(tripwire.isObjectTriggering());
  }

  /**
   * Test {@link Tripwire#setObjectTriggering(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Tripwire#Tripwire()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#setObjectTriggering(boolean)}
   */
  @Test
  @DisplayName("Test setObjectTriggering(boolean); when 'true'; then Tripwire() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tripwire.setObjectTriggering(boolean)"})
  void testSetObjectTriggering_whenTrue_thenTripwireDataIsOne() {
    // Arrange
    Tripwire tripwire = new Tripwire();

    // Act
    tripwire.setObjectTriggering(true);

    // Assert
    assertEquals((byte) 1, tripwire.getData());
    assertTrue(tripwire.isObjectTriggering());
  }

  /**
   * Test {@link Tripwire#clone()}.
   *
   * <p>Method under test: {@link Tripwire#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tripwire Tripwire.clone()"})
  void testClone() {
    // Arrange
    Tripwire tripwire = new Tripwire();

    // Act
    Tripwire actualCloneResult = tripwire.clone();

    // Assert
    assertEquals(tripwire, actualCloneResult);
  }

  /**
   * Test {@link Tripwire#toString()}.
   *
   * <ul>
   *   <li>Given {@link Tripwire#Tripwire()}.
   *   <li>Then return {@code LEGACY_TRIPWIRE(0)}.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Tripwire(); then return 'LEGACY_TRIPWIRE(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Tripwire.toString()"})
  void testToString_givenTripwire_thenReturnLegacyTripwire0() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_TRIPWIRE(0)", new Tripwire().toString());
  }

  /**
   * Test {@link Tripwire#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(4) Activated}.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(4) Activated'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Tripwire.toString()"})
  void testToString_thenReturnAcaciaBoat4Activated() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(4) Activated", new Tripwire(Material.ACACIA_BOAT, (byte) 4).toString());
  }

  /**
   * Test {@link Tripwire#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(65) Triggered}.
   * </ul>
   *
   * <p>Method under test: {@link Tripwire#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(65) Triggered'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Tripwire.toString()"})
  void testToString_thenReturnAcaciaBoat65Triggered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(65) Triggered", new Tripwire(Material.ACACIA_BOAT, (byte) 'A').toString());
  }
}
