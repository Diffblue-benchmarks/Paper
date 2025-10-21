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

class PaperVersionCommandDiffblueTest {
  /**
   * Test {@link PaperVersionCommand#create()}.
   *
   * <p>Method under test: {@link PaperVersionCommand#create()}
   */
  @Test
  @DisplayName("Test create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode PaperVersionCommand.create()"})
  void testCreate() {
    // Arrange and Act
    LiteralCommandNode<CommandSourceStack> actualCreateResult = PaperVersionCommand.create();

    // Assert
    Collection<String> examples = actualCreateResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("version", actualCreateResult.getLiteral());
    assertEquals("version", actualCreateResult.getName());
    assertEquals("version", actualCreateResult.getUsageText());
    assertNull(actualCreateResult.getRedirectModifier());
    assertNull(actualCreateResult.getRedirect());
    assertNull(actualCreateResult.clientNode);
    assertNull(actualCreateResult.unwrappedCached);
    assertNull(actualCreateResult.wrappedCached);
    assertNull(actualCreateResult.apiCommandMeta);
    assertEquals(1, actualCreateResult.getChildren().size());
    assertFalse(actualCreateResult.isFork());
  }
}
