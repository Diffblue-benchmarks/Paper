package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.Message;
import io.papermc.paper.adventure.AdventureComponent;
import java.util.ArrayList;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MessageComponentSerializerImplDiffblueTest {
  /**
   * Test {@link MessageComponentSerializerImpl#serialize(Component)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return String is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MessageComponentSerializerImpl#serialize(Component)}
   */
  @Test
  @DisplayName("Test serialize(Component); given ArrayList(); then return String is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageComponentSerializerImpl.serialize(Component)"})
  void testSerialize_givenArrayList_thenReturnStringIsEmptyString() {
    // Arrange
    MessageComponentSerializerImpl messageComponentSerializerImpl =
        new MessageComponentSerializerImpl();

    Component component = mock(Component.class);
    when(component.children()).thenReturn(new ArrayList<>());
    when(component.style()).thenReturn(mock(Style.class));

    // Act
    Message actualSerializeResult = messageComponentSerializerImpl.serialize(component);
    String actualString = actualSerializeResult.getString();

    // Assert
    verify(component).children();
    verify(component).style();
    assertTrue(actualSerializeResult instanceof AdventureComponent);
    assertEquals("", actualSerializeResult.getString());
    assertEquals("", actualString);
    assertNull(messageComponentSerializerImpl.deseializeOrNull(null));
    assertNull(messageComponentSerializerImpl.deserializeOrNull(null));
    assertSame(component, ((AdventureComponent) actualSerializeResult).adventure$component());
  }

  /**
   * Test {@link MessageComponentSerializerImpl#serialize(Component)}.
   *
   * <ul>
   *   <li>When {@link Component}.
   *   <li>Then return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link MessageComponentSerializerImpl#serialize(Component)}
   */
  @Test
  @DisplayName("Test serialize(Component); when Component; then return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageComponentSerializerImpl.serialize(Component)"})
  void testSerialize_whenComponent_thenReturnAdventureComponent() {
    // Arrange
    MessageComponentSerializerImpl messageComponentSerializerImpl =
        new MessageComponentSerializerImpl();
    Component component = mock(Component.class);

    // Act
    Message actualSerializeResult = messageComponentSerializerImpl.serialize(component);

    // Assert
    assertTrue(actualSerializeResult instanceof AdventureComponent);
    assertNull(messageComponentSerializerImpl.deseializeOrNull(null));
    assertNull(messageComponentSerializerImpl.deserializeOrNull(null));
    assertSame(component, ((AdventureComponent) actualSerializeResult).adventure$component());
  }

  /**
   * Test {@link MessageComponentSerializerImpl#serialize(Component)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessageComponentSerializerImpl#serialize(Component)}
   */
  @Test
  @DisplayName("Test serialize(Component); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageComponentSerializerImpl.serialize(Component)"})
  void testSerialize_whenNull_thenReturnNull() {
    // Arrange
    MessageComponentSerializerImpl messageComponentSerializerImpl =
        new MessageComponentSerializerImpl();

    // Act and Assert
    assertNull(messageComponentSerializerImpl.serialize(null));
    assertNull(null);
    assertNull(messageComponentSerializerImpl.deseializeOrNull(null));
    assertNull(messageComponentSerializerImpl.deserializeOrNull(null));
  }
}
