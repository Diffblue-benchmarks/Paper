package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.Commands;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperCommandsDiffblueTest {
  /**
   * Test {@link PaperCommands#setDispatcher(Commands, CommandBuildContext)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PaperCommands#INSTANCE} BuildContext is {@link CommandBuildContext}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#setDispatcher(Commands, CommandBuildContext)}
   */
  @Test
  @DisplayName(
      "Test setDispatcher(Commands, CommandBuildContext); when 'null'; then INSTANCE BuildContext is CommandBuildContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperCommands.setDispatcher(Commands, CommandBuildContext)"})
  void testSetDispatcher_whenNull_thenInstanceBuildContextIsCommandBuildContext() {
    // Arrange
    PaperCommands paperCommands = PaperCommands.INSTANCE;
    CommandBuildContext commandBuildContext = mock(CommandBuildContext.class);

    // Act
    paperCommands.setDispatcher(null, commandBuildContext);

    // Assert
    assertSame(commandBuildContext, paperCommands.getBuildContext());
  }
}
