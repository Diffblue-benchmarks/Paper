package io.papermc.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.command.PaperSubcommand;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FeatureHooksDiffblueTest {
  /**
   * Test {@link FeatureHooks#registerPaperCommands(Map)}.
   *
   * <p>Method under test: {@link FeatureHooks#registerPaperCommands(Map)}
   */
  @Test
  @DisplayName("Test registerPaperCommands(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeatureHooks.registerPaperCommands(Map)"})
  void testRegisterPaperCommands() {
    // Arrange
    HashMap<Set<String>, PaperSubcommand> commands = new HashMap<>();

    // Act
    FeatureHooks.registerPaperCommands(commands);

    // Assert
    assertEquals(2, commands.size());
  }
}
