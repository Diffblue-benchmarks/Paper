package io.papermc.paper.command.brigadier.bukkit;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.command.MSPTCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BukkitCommandNodeDiffblueTest {
  /**
   * Test {@link BukkitCommandNode#getBukkitCommand()}.
   *
   * <p>Method under test: {@link BukkitCommandNode#getBukkitCommand()}
   */
  @Test
  @DisplayName("Test getBukkitCommand()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command BukkitCommandNode.getBukkitCommand()"})
  void testGetBukkitCommand() {
    // Arrange
    MSPTCommand command = new MSPTCommand("Name");

    // Act and Assert
    assertSame(command, BukkitCommandNode.of("Name", command).getBukkitCommand());
  }
}
