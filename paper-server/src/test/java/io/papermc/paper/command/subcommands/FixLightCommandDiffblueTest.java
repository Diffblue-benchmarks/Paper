package io.papermc.paper.command.subcommands;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.brigadier.NullCommandSender;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FixLightCommandDiffblueTest {
  /**
   * Test {@link FixLightCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@link NullCommandSender#INSTANCE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FixLightCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[]); when INSTANCE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FixLightCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenInstance_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new FixLightCommand()
            .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"}));
  }
}
