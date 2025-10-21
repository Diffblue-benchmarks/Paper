package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommandsDiffblueTest {
  /**
   * Test {@link Commands#literal(String)}.
   *
   * <p>Method under test: {@link Commands#literal(String)}
   */
  @Test
  @DisplayName("Test literal(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralArgumentBuilder Commands.literal(String)"})
  void testLiteral() {
    // Arrange and Act
    LiteralArgumentBuilder<CommandSourceStack> actualLiteralResult = Commands.literal("Literal");

    // Assert
    assertEquals("Literal", actualLiteralResult.getLiteral());
    assertNull(actualLiteralResult.getCommand());
    assertNull(actualLiteralResult.getRedirectModifier());
    assertNull(actualLiteralResult.getRedirect());
    assertFalse(actualLiteralResult.isFork());
    assertTrue(actualLiteralResult.getArguments().isEmpty());
  }

  /**
   * Test {@link Commands#argument(String, ArgumentType)}.
   *
   * <p>Method under test: {@link Commands#argument(String, ArgumentType)}
   */
  @Test
  @DisplayName("Test argument(String, ArgumentType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequiredArgumentBuilder Commands.argument(String, ArgumentType)"})
  void testArgument() {
    // Arrange
    ArgumentType<Object> argumentType = mock(ArgumentType.class);

    // Act
    RequiredArgumentBuilder<CommandSourceStack, Object> actualArgumentResult =
        Commands.argument("Name", argumentType);

    // Assert
    assertEquals("Name", actualArgumentResult.getName());
    assertNull(actualArgumentResult.getCommand());
    assertNull(actualArgumentResult.getRedirectModifier());
    assertNull(actualArgumentResult.getSuggestionsProvider());
    assertNull(actualArgumentResult.getRedirect());
    assertFalse(actualArgumentResult.isFork());
    assertTrue(actualArgumentResult.getArguments().isEmpty());
    assertSame(argumentType, actualArgumentResult.getType());
  }
}
