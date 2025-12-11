package io.papermc.paper.command.brigadier.argument;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.arguments.MessageArgument.Message;
import net.minecraft.commands.arguments.MessageArgument.Part;
import net.minecraft.commands.arguments.selector.EntitySelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SignedMessageResolverImplDiffblueTest {
  /**
   * Test {@link SignedMessageResolverImpl#content()}.
   *
   * <ul>
   *   <li>Then return {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link SignedMessageResolverImpl#content()}
   */
  @Test
  @DisplayName("Test content(); then return 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SignedMessageResolverImpl.content()"})
  void testContent_thenReturnText() {
    // Arrange
    Part[] parts = new Part[] {new Part(1, 3, mock(EntitySelector.class))};
    Message message = new Message("Text", parts);

    // Act and Assert
    assertEquals("Text", new SignedMessageResolverImpl(message).content());
  }
}
