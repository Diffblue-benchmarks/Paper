package io.papermc.paper.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.Message;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.PlainTextContents;
import net.minecraft.network.chat.contents.PlainTextContents.LiteralContents;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagParseCommandSyntaxExceptionDiffblueTest {
  /**
   * Test {@link TagParseCommandSyntaxException#TagParseCommandSyntaxException(String)}.
   *
   * <p>Method under test: {@link
   * TagParseCommandSyntaxException#TagParseCommandSyntaxException(String)}
   */
  @Test
  @DisplayName("Test new TagParseCommandSyntaxException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagParseCommandSyntaxException.<init>(String)"})
  void testNewTagParseCommandSyntaxException() {
    // Arrange and Act
    TagParseCommandSyntaxException actualTagParseCommandSyntaxException =
        new TagParseCommandSyntaxException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTagParseCommandSyntaxException.getLocalizedMessage());
    assertEquals("An error occurred", actualTagParseCommandSyntaxException.getMessage());
    Message rawMessage = actualTagParseCommandSyntaxException.getRawMessage();
    assertTrue(rawMessage instanceof MutableComponent);
    ComponentContents contents = ((MutableComponent) rawMessage).getContents();
    assertTrue(contents instanceof LiteralContents);
    assertEquals("An error occurred", ((LiteralContents) contents).text());
    assertEquals("An error occurred", rawMessage.getString());
    Iterator<Component> iteratorResult = ((MutableComponent) rawMessage).iterator();
    Component actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(rawMessage, actualNextResult);
    List<Component> toFlatListResult = ((MutableComponent) rawMessage).toFlatList();
    assertEquals(1, toFlatListResult.size());
    Component getResult = toFlatListResult.get(0);
    assertTrue(getResult instanceof MutableComponent);
    assertEquals(rawMessage, getResult);
  }

  /**
   * Test {@link TagParseCommandSyntaxException#TagParseCommandSyntaxException(String)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * TagParseCommandSyntaxException#TagParseCommandSyntaxException(String)}
   */
  @Test
  @DisplayName(
      "Test new TagParseCommandSyntaxException(String); then return LocalizedMessage is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagParseCommandSyntaxException.<init>(String)"})
  void testNewTagParseCommandSyntaxException_thenReturnLocalizedMessageIsEmptyString() {
    // Arrange and Act
    TagParseCommandSyntaxException actualTagParseCommandSyntaxException =
        new TagParseCommandSyntaxException("");

    // Assert
    assertEquals("", actualTagParseCommandSyntaxException.getLocalizedMessage());
    assertEquals("", actualTagParseCommandSyntaxException.getMessage());
    Message rawMessage = actualTagParseCommandSyntaxException.getRawMessage();
    assertTrue(rawMessage instanceof MutableComponent);
    assertEquals("", rawMessage.getString());
    Iterator<Component> iteratorResult = ((MutableComponent) rawMessage).iterator();
    Component actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(rawMessage, actualNextResult);
    assertTrue(((MutableComponent) rawMessage).toFlatList().isEmpty());
  }
}
