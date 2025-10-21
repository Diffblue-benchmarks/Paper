package io.papermc.paper.adventure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdventureComponentDiffblueTest {
  /**
   * Test {@link AdventureComponent#AdventureComponent(Component)}.
   *
   * <p>Method under test: {@link AdventureComponent#AdventureComponent(Component)}
   */
  @Test
  @DisplayName("Test new AdventureComponent(Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdventureComponent.<init>(Component)"})
  void testNewAdventureComponent() {
    // Arrange and Act
    AdventureComponent actualAdventureComponent = new AdventureComponent(mock(Component.class));

    // Assert
    Component expectedAdventure$componentResult = actualAdventureComponent.adventure;
    assertSame(expectedAdventure$componentResult, actualAdventureComponent.adventure$component());
  }

  /**
   * Test {@link AdventureComponent#deepConvertedIfPresent()}.
   *
   * <p>Method under test: {@link AdventureComponent#deepConvertedIfPresent()}
   */
  @Test
  @DisplayName("Test deepConvertedIfPresent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.network.chat.Component AdventureComponent.deepConvertedIfPresent()"
  })
  void testDeepConvertedIfPresent() {
    // Arrange, Act and Assert
    assertNull(new AdventureComponent(mock(Component.class)).deepConvertedIfPresent());
  }

  /**
   * Test {@link AdventureComponent#getString()}.
   *
   * <p>Method under test: {@link AdventureComponent#getString()}
   */
  @Test
  @DisplayName("Test getString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdventureComponent.getString()"})
  void testGetString() {
    // Arrange
    Component adventure = mock(Component.class);
    when(adventure.children()).thenReturn(new ArrayList<>());
    when(adventure.style()).thenReturn(mock(Style.class));

    // Act
    String actualString = new AdventureComponent(adventure).getString();

    // Assert
    verify(adventure).children();
    verify(adventure).style();
    assertEquals("", actualString);
  }

  /**
   * Test {@link AdventureComponent#adventure$component()}.
   *
   * <p>Method under test: {@link AdventureComponent#adventure$component()}
   */
  @Test
  @DisplayName("Test adventure$component()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component AdventureComponent.adventure$component()"})
  void testAdventure$component() {
    // Arrange
    AdventureComponent adventureComponent = new AdventureComponent(mock(Component.class));

    // Act
    Component actualAdventure$componentResult = adventureComponent.adventure$component();

    // Assert
    assertSame(adventureComponent.adventure, actualAdventure$componentResult);
  }

  /**
   * Test {@link AdventureComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link AdventureComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same; then throw exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdventureComponent.equals(Object)",
    "int AdventureComponent.hashCode()"
  })
  void testEquals_whenOtherIsSame_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(
        NoClassDefFoundError.class,
        () ->
            new AdventureComponent(mock(Component.class))
                .equals(new AdventureComponent(mock(Component.class))));
  }

  /**
   * Test {@link AdventureComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link AdventureComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then throw exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdventureComponent.equals(Object)",
    "int AdventureComponent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(
        NoClassDefFoundError.class,
        () ->
            new AdventureComponent(mock(Component.class))
                .equals("Different type to AdventureComponent"));
  }
}
