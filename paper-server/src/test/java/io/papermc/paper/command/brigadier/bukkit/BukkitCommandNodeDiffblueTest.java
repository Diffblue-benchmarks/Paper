package io.papermc.paper.command.brigadier.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.command.MSPTCommand;
import java.util.Collection;
import java.util.Set;
import org.bukkit.command.Command;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BukkitCommandNodeDiffblueTest {
  /**
   * Test {@link BukkitCommandNode#of(String, Command)}.
   *
   * <ul>
   *   <li>When {@code minecraft:}.
   *   <li>Then return Literal is {@code minecraft:}.
   * </ul>
   *
   * <p>Method under test: {@link BukkitCommandNode#of(String, Command)}
   */
  @Test
  @DisplayName("Test of(String, Command); when 'minecraft:'; then return Literal is 'minecraft:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BukkitCommandNode BukkitCommandNode.of(String, Command)"})
  void testOf_whenMinecraft_thenReturnLiteralIsMinecraft() {
    // Arrange and Act
    BukkitCommandNode actualOfResult = BukkitCommandNode.of("minecraft:", new MSPTCommand("Name"));

    // Assert
    Collection<String> examples = actualOfResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("minecraft:", actualOfResult.getLiteral());
    assertEquals("minecraft:", actualOfResult.getName());
    assertEquals("minecraft:", actualOfResult.getUsageText());
    assertTrue(examples.contains("minecraft:"));
  }

  /**
   * Test {@link BukkitCommandNode#of(String, Command)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Literal is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link BukkitCommandNode#of(String, Command)}
   */
  @Test
  @DisplayName("Test of(String, Command); when 'Name'; then return Literal is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BukkitCommandNode BukkitCommandNode.of(String, Command)"})
  void testOf_whenName_thenReturnLiteralIsName() {
    // Arrange and Act
    BukkitCommandNode actualOfResult = BukkitCommandNode.of("Name", new MSPTCommand("Name"));

    // Assert
    Collection<String> examples = actualOfResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("Name", actualOfResult.getLiteral());
    assertEquals("Name", actualOfResult.getName());
    assertEquals("Name", actualOfResult.getUsageText());
    assertTrue(examples.contains("Name"));
  }

  /**
   * Test {@link BukkitCommandNode#getBukkitCommand()}.
   *
   * <p>Method under test: {@link BukkitCommandNode#getBukkitCommand()}
   */
  @Test
  @DisplayName("Test getBukkitCommand()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command BukkitCommandNode.getBukkitCommand()"})
  void testGetBukkitCommand() {
    // Arrange
    MSPTCommand command = new MSPTCommand("Name");

    // Act and Assert
    assertSame(command, BukkitCommandNode.of("Name", command).getBukkitCommand());
  }
}
