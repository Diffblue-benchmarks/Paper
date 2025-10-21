package io.papermc.paper.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPluginsCommandDiffblueTest {
  /**
   * Test {@link PaperPluginsCommand#create()}.
   *
   * <p>Method under test: {@link PaperPluginsCommand#create()}
   */
  @Test
  @DisplayName("Test create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode PaperPluginsCommand.create()"})
  void testCreate() {
    // Arrange and Act
    LiteralCommandNode<CommandSourceStack> actualCreateResult = PaperPluginsCommand.create();

    // Assert
    Collection<String> examples = actualCreateResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("plugins", actualCreateResult.getLiteral());
    assertEquals("plugins", actualCreateResult.getName());
    assertEquals("plugins", actualCreateResult.getUsageText());
    assertNull(actualCreateResult.getRedirectModifier());
    assertNull(actualCreateResult.getRedirect());
    assertNull(actualCreateResult.clientNode);
    assertNull(actualCreateResult.unwrappedCached);
    assertNull(actualCreateResult.wrappedCached);
    assertNull(actualCreateResult.apiCommandMeta);
    assertFalse(actualCreateResult.isFork());
    assertTrue(actualCreateResult.getChildren().isEmpty());
  }
}
