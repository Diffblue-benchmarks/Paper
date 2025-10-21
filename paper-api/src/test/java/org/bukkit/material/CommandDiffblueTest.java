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

class CommandDiffblueTest {
  /**
   * Test {@link Command#Command()}.
   *
   * <p>Method under test: {@link Command#Command()}
   */
  @Test
  @DisplayName("Test new Command()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.<init>()"})
  void testNewCommand() {
    // Arrange and Act
    Command actualCommand = new Command();

    // Assert
    assertEquals((byte) 0, actualCommand.getData());
    assertEquals(Material.LEGACY_COMMAND, actualCommand.getItemType());
    assertFalse(actualCommand.isPowered());
  }

  /**
   * Test {@link Command#Command(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Command#Command(Material, byte)}
   */
  @Test
  @DisplayName("Test new Command(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.<init>(Material)", "void Command.<init>(Material, byte)"})
  void testNewCommand_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Command actualCommand = new Command(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualCommand.getItemType());
    assertEquals('A', actualCommand.getData());
  }

  /**
   * Test {@link Command#Command(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Command#Command(Material)}
   */
  @Test
  @DisplayName("Test new Command(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.<init>(Material)", "void Command.<init>(Material, byte)"})
  void testNewCommand_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Command actualCommand = new Command(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualCommand.getData());
    assertEquals(Material.ACACIA_BOAT, actualCommand.getItemType());
  }

  /**
   * Test {@link Command#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Command#Command(Material, byte)} with type is {@code ACACIA_BOAT} and data
   *       is {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Command#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given Command(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.isPowered()"})
  void testIsPowered_givenCommandWithTypeIsAcaciaBoatAndDataIsA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Command(Material.ACACIA_BOAT, (byte) 'A').isPowered());
  }

  /**
   * Test {@link Command#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Command#Command()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Command#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Command(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.isPowered()"})
  void testIsPowered_givenCommand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Command().isPowered());
  }

  /**
   * Test {@link Command#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Command#Command()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Command#setPowered(boolean)}
   */
  @Test
  @DisplayName("Test setPowered(boolean); when 'false'; then Command() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.setPowered(boolean)"})
  void testSetPowered_whenFalse_thenCommandDataIsZero() {
    // Arrange
    Command command = new Command();

    // Act
    command.setPowered(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, command.getData());
    assertFalse(command.isPowered());
  }

  /**
   * Test {@link Command#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Command#Command()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Command#setPowered(boolean)}
   */
  @Test
  @DisplayName("Test setPowered(boolean); when 'true'; then Command() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.setPowered(boolean)"})
  void testSetPowered_whenTrue_thenCommandDataIsOne() {
    // Arrange
    Command command = new Command();

    // Act
    command.setPowered(true);

    // Assert
    assertEquals((byte) 1, command.getData());
    assertTrue(command.isPowered());
  }

  /**
   * Test {@link Command#toString()}.
   *
   * <ul>
   *   <li>Given {@link Command#Command()}.
   *   <li>Then return {@code LEGACY_COMMAND(0) NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Command#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Command(); then return 'LEGACY_COMMAND(0) NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Command.toString()"})
  void testToString_givenCommand_thenReturnLegacyCommand0NotPowered() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_COMMAND(0) NOT POWERED", new Command().toString());
  }

  /**
   * Test {@link Command#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(65) POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Command#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(65) POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Command.toString()"})
  void testToString_thenReturnAcaciaBoat65Powered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(65) POWERED", new Command(Material.ACACIA_BOAT, (byte) 'A').toString());
  }

  /**
   * Test {@link Command#clone()}.
   *
   * <p>Method under test: {@link Command#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.clone()"})
  void testClone() {
    // Arrange
    Command command = new Command();

    // Act
    Command actualCloneResult = command.clone();

    // Assert
    assertEquals(command, actualCloneResult);
  }
}
