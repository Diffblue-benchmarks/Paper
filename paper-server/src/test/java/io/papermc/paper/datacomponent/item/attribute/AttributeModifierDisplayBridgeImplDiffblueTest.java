package io.papermc.paper.datacomponent.item.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
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
   * <p>Method under test: {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}
   */
  @Test
  @DisplayName("Test override(ComponentLike)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverrideText AttributeModifierDisplayBridgeImpl.override(ComponentLike)"})
  void testOverride() {
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
   * <p>Method under test: {@link AttributeModifierDisplayBridgeImpl#override(ComponentLike)}
   */
  @Test
  @DisplayName("Test override(ComponentLike)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverrideText AttributeModifierDisplayBridgeImpl.override(ComponentLike)"})
  void testOverride2() {
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
}
