package io.papermc.paper.datacomponent.item.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.adventure.AdventureComponent;
import io.papermc.paper.datacomponent.item.attribute.AttributeModifierDisplay.Default;
import io.papermc.paper.datacomponent.item.attribute.AttributeModifierDisplay.Hidden;
import io.papermc.paper.datacomponent.item.attribute.AttributeModifierDisplay.OverrideText;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttributeModifierDisplayBridgeImplDiffblueTest {
  /**
   * Test {@link AttributeModifierDisplayBridgeImpl#reset()}.
   *
   * <p>Method under test: {@link AttributeModifierDisplayBridgeImpl#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Default AttributeModifierDisplayBridgeImpl.reset()"})
  void testReset() {
    // Arrange and Act
    Default actualResetResult = new AttributeModifierDisplayBridgeImpl().reset();

    // Assert
    assertTrue(actualResetResult instanceof PaperDefaultDisplay);
    Display.Default handle = ((PaperDefaultDisplay) actualResetResult).getHandle();
    assertEquals(Type.DEFAULT, handle.type());
    assertSame(handle, ((PaperDefaultDisplay) actualResetResult).impl());
  }

  /**
   * Test {@link AttributeModifierDisplayBridgeImpl#hidden()}.
   *
   * <p>Method under test: {@link AttributeModifierDisplayBridgeImpl#hidden()}
   */
  @Test
  @DisplayName("Test hidden()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Hidden AttributeModifierDisplayBridgeImpl.hidden()"})
  void testHidden() {
    // Arrange and Act
    Hidden actualHiddenResult = new AttributeModifierDisplayBridgeImpl().hidden();

    // Assert
    assertTrue(actualHiddenResult instanceof PaperHiddenDisplay);
    Display.Hidden handle = ((PaperHiddenDisplay) actualHiddenResult).getHandle();
    assertEquals(Type.HIDDEN, handle.type());
    assertSame(handle, ((PaperHiddenDisplay) actualHiddenResult).impl());
  }

  /**
   * Test {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}.
   *
   * <ul>
   *   <li>Given {@link Component}.
   *   <li>Then Handle component return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}
   */
  @Test
  @DisplayName(
      "Test override(ComponentLike); given Component; then Handle component return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverrideText AttributeModifierDisplayBridgeImpl.override(ComponentLike)"})
  void testOverride_givenComponent_thenHandleComponentReturnAdventureComponent() {
    // Arrange
    AttributeModifierDisplayBridgeImpl attributeModifierDisplayBridgeImpl =
        new AttributeModifierDisplayBridgeImpl();

    ComponentLike text = mock(ComponentLike.class);
    when(text.asComponent()).thenReturn(mock(Component.class));

    // Act
    OverrideText actualOverrideResult = attributeModifierDisplayBridgeImpl.override(text);

    // Assert
    verify(text).asComponent();
    Display.OverrideText handle = ((PaperOverrideTextDisplay) actualOverrideResult).getHandle();
    assertTrue(handle.component() instanceof AdventureComponent);
    Default resetResult = attributeModifierDisplayBridgeImpl.reset();
    assertTrue(resetResult instanceof PaperDefaultDisplay);
    Hidden hiddenResult = attributeModifierDisplayBridgeImpl.hidden();
    assertTrue(hiddenResult instanceof PaperHiddenDisplay);
    assertTrue(actualOverrideResult instanceof PaperOverrideTextDisplay);
    Display.Default handle2 = ((PaperDefaultDisplay) resetResult).getHandle();
    assertEquals(Type.DEFAULT, handle2.type());
    Display.Hidden handle3 = ((PaperHiddenDisplay) hiddenResult).getHandle();
    assertEquals(Type.HIDDEN, handle3.type());
    assertSame(handle2, ((PaperDefaultDisplay) resetResult).impl());
    assertSame(handle3, ((PaperHiddenDisplay) hiddenResult).impl());
    assertSame(handle, ((PaperOverrideTextDisplay) actualOverrideResult).impl());
  }

  /**
   * Test {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}.
   *
   * <ul>
   *   <li>Given {@link Component}.
   *   <li>Then Handle component return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}
   */
  @Test
  @DisplayName(
      "Test override(ComponentLike); given Component; then Handle component return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverrideText AttributeModifierDisplayBridgeImpl.override(ComponentLike)"})
  void testOverride_givenComponent_thenHandleComponentReturnAdventureComponent2() {
    // Arrange
    AttributeModifierDisplayBridgeImpl attributeModifierDisplayBridgeImpl =
        new AttributeModifierDisplayBridgeImpl();

    ComponentLike text = mock(ComponentLike.class);
    when(text.asComponent()).thenReturn(mock(Component.class));

    // Act
    OverrideText actualOverrideResult = attributeModifierDisplayBridgeImpl.override(text);
    actualOverrideResult.text();

    // Assert
    verify(text).asComponent();
    Display.OverrideText handle = ((PaperOverrideTextDisplay) actualOverrideResult).getHandle();
    assertTrue(handle.component() instanceof AdventureComponent);
    Default resetResult = attributeModifierDisplayBridgeImpl.reset();
    assertTrue(resetResult instanceof PaperDefaultDisplay);
    Hidden hiddenResult = attributeModifierDisplayBridgeImpl.hidden();
    assertTrue(hiddenResult instanceof PaperHiddenDisplay);
    assertTrue(actualOverrideResult instanceof PaperOverrideTextDisplay);
    Display.Default handle2 = ((PaperDefaultDisplay) resetResult).getHandle();
    assertEquals(Type.DEFAULT, handle2.type());
    Display.Hidden handle3 = ((PaperHiddenDisplay) hiddenResult).getHandle();
    assertEquals(Type.HIDDEN, handle3.type());
    assertSame(handle2, ((PaperDefaultDisplay) resetResult).impl());
    assertSame(handle3, ((PaperHiddenDisplay) hiddenResult).impl());
    assertSame(handle, ((PaperOverrideTextDisplay) actualOverrideResult).impl());
  }

  /**
   * Test {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Handle component is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}
   */
  @Test
  @DisplayName("Test override(ComponentLike); given 'null'; then return Handle component is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverrideText AttributeModifierDisplayBridgeImpl.override(ComponentLike)"})
  void testOverride_givenNull_thenReturnHandleComponentIsNull() {
    // Arrange
    AttributeModifierDisplayBridgeImpl attributeModifierDisplayBridgeImpl =
        new AttributeModifierDisplayBridgeImpl();

    ComponentLike text = mock(ComponentLike.class);
    when(text.asComponent()).thenReturn(null);

    // Act
    OverrideText actualOverrideResult = attributeModifierDisplayBridgeImpl.override(text);

    // Assert
    verify(text).asComponent();
    Default resetResult = attributeModifierDisplayBridgeImpl.reset();
    assertTrue(resetResult instanceof PaperDefaultDisplay);
    Hidden hiddenResult = attributeModifierDisplayBridgeImpl.hidden();
    assertTrue(hiddenResult instanceof PaperHiddenDisplay);
    assertTrue(actualOverrideResult instanceof PaperOverrideTextDisplay);
    Display.OverrideText handle = ((PaperOverrideTextDisplay) actualOverrideResult).getHandle();
    assertNull(handle.component());
    Display.Default handle2 = ((PaperDefaultDisplay) resetResult).getHandle();
    assertEquals(Type.DEFAULT, handle2.type());
    Display.Hidden handle3 = ((PaperHiddenDisplay) hiddenResult).getHandle();
    assertEquals(Type.HIDDEN, handle3.type());
    assertSame(handle2, ((PaperDefaultDisplay) resetResult).impl());
    assertSame(handle3, ((PaperHiddenDisplay) hiddenResult).impl());
    assertSame(handle, ((PaperOverrideTextDisplay) actualOverrideResult).impl());
  }

  /**
   * Test {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return text insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}
   */
  @Test
  @DisplayName("Test override(ComponentLike); given 'null'; then return text insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverrideText AttributeModifierDisplayBridgeImpl.override(ComponentLike)"})
  void testOverride_givenNull_thenReturnTextInsertionIsNull() {
    // Arrange
    AttributeModifierDisplayBridgeImpl attributeModifierDisplayBridgeImpl =
        new AttributeModifierDisplayBridgeImpl();

    ComponentLike text = mock(ComponentLike.class);
    when(text.asComponent()).thenReturn(null);

    // Act
    OverrideText actualOverrideResult = attributeModifierDisplayBridgeImpl.override(text);
    Component actualTextResult = actualOverrideResult.text();

    // Assert
    verify(text).asComponent();
    assertTrue(attributeModifierDisplayBridgeImpl.reset() instanceof PaperDefaultDisplay);
    assertTrue(attributeModifierDisplayBridgeImpl.hidden() instanceof PaperHiddenDisplay);
    assertTrue(actualOverrideResult instanceof PaperOverrideTextDisplay);
    assertNull(actualTextResult.insertion());
    assertNull(actualTextResult.font());
    assertNull(actualTextResult.color());
    Map<TextDecoration, State> decorationsResult = actualTextResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(actualTextResult.hasStyling());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.ITALIC));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    Component actualCompactResult = actualTextResult.compact();
    assertSame(actualTextResult, actualCompactResult);
  }
}
