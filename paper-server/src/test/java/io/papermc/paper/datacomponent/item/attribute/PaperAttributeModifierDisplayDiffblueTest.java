package io.papermc.paper.datacomponent.item.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.adventure.AdventureComponent;
import net.kyori.adventure.text.Component;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.Default;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.Hidden;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.OverrideText;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperAttributeModifierDisplayDiffblueTest {
  /**
   * Test {@link PaperAttributeModifierDisplay#fromNms(Display)}.
   *
   * <ul>
   *   <li>Then return {@link PaperOverrideTextDisplay}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperAttributeModifierDisplay#fromNms(ItemAttributeModifiers.Display)}
   */
  @Test
  @DisplayName("Test fromNms(Display); then return PaperOverrideTextDisplay")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttributeModifierDisplay PaperAttributeModifierDisplay.fromNms(ItemAttributeModifiers.Display)"
  })
  void testFromNms_thenReturnPaperOverrideTextDisplay() {
    // Arrange
    AdventureComponent component = new AdventureComponent(mock(Component.class));
    OverrideText display = new OverrideText(component);

    // Act
    AttributeModifierDisplay actualFromNmsResult = PaperAttributeModifierDisplay.fromNms(display);

    // Assert
    assertTrue(actualFromNmsResult instanceof PaperOverrideTextDisplay);
    assertSame(display, ((PaperOverrideTextDisplay) actualFromNmsResult).getHandle());
    assertSame(display, ((PaperOverrideTextDisplay) actualFromNmsResult).impl());
  }

  /**
   * Test {@link PaperAttributeModifierDisplay#fromNms(Display)}.
   *
   * <ul>
   *   <li>When {@link ItemAttributeModifiers.Display.Default} (default constructor).
   *   <li>Then return {@link PaperDefaultDisplay}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperAttributeModifierDisplay#fromNms(ItemAttributeModifiers.Display)}
   */
  @Test
  @DisplayName(
      "Test fromNms(Display); when Default (default constructor); then return PaperDefaultDisplay")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttributeModifierDisplay PaperAttributeModifierDisplay.fromNms(ItemAttributeModifiers.Display)"
  })
  void testFromNms_whenDefault_thenReturnPaperDefaultDisplay() {
    // Arrange
    Default display = new Default();

    // Act
    AttributeModifierDisplay actualFromNmsResult = PaperAttributeModifierDisplay.fromNms(display);

    // Assert
    assertTrue(actualFromNmsResult instanceof PaperDefaultDisplay);
    assertSame(display, ((PaperDefaultDisplay) actualFromNmsResult).getHandle());
    assertSame(display, ((PaperDefaultDisplay) actualFromNmsResult).impl());
  }

  /**
   * Test {@link PaperAttributeModifierDisplay#fromNms(Display)}.
   *
   * <ul>
   *   <li>When {@link ItemAttributeModifiers.Display.Hidden} (default constructor).
   *   <li>Then return {@link PaperHiddenDisplay}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperAttributeModifierDisplay#fromNms(ItemAttributeModifiers.Display)}
   */
  @Test
  @DisplayName(
      "Test fromNms(Display); when Hidden (default constructor); then return PaperHiddenDisplay")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttributeModifierDisplay PaperAttributeModifierDisplay.fromNms(ItemAttributeModifiers.Display)"
  })
  void testFromNms_whenHidden_thenReturnPaperHiddenDisplay() {
    // Arrange
    Hidden display = new Hidden();

    // Act
    AttributeModifierDisplay actualFromNmsResult = PaperAttributeModifierDisplay.fromNms(display);

    // Assert
    assertTrue(actualFromNmsResult instanceof PaperHiddenDisplay);
    assertSame(display, ((PaperHiddenDisplay) actualFromNmsResult).getHandle());
    assertSame(display, ((PaperHiddenDisplay) actualFromNmsResult).impl());
  }

  /**
   * Test {@link PaperAttributeModifierDisplay#toNms(AttributeModifierDisplay)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAttributeModifierDisplay#toNms(AttributeModifierDisplay)}
   */
  @Test
  @DisplayName(
      "Test toNms(AttributeModifierDisplay); when 'null'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ItemAttributeModifiers.Display PaperAttributeModifierDisplay.toNms(AttributeModifierDisplay)"
  })
  void testToNms_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> PaperAttributeModifierDisplay.toNms(null));
  }

  /**
   * Test {@link PaperAttributeModifierDisplay#toNms(AttributeModifierDisplay)}.
   *
   * <ul>
   *   <li>When {@link PaperDefaultDisplay#PaperDefaultDisplay(Default)} with impl is {@link
   *       ItemAttributeModifiers.Display.Default} (default constructor).
   *   <li>Then return {@link ItemAttributeModifiers.Display.Default}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAttributeModifierDisplay#toNms(AttributeModifierDisplay)}
   */
  @Test
  @DisplayName(
      "Test toNms(AttributeModifierDisplay); when PaperDefaultDisplay(Default) with impl is Default (default constructor); then return Default")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ItemAttributeModifiers.Display PaperAttributeModifierDisplay.toNms(AttributeModifierDisplay)"
  })
  void testToNms_whenPaperDefaultDisplayWithImplIsDefault_thenReturnDefault() {
    // Arrange and Act
    Display actualToNmsResult =
        PaperAttributeModifierDisplay.toNms(new PaperDefaultDisplay(new Default()));

    // Assert
    assertTrue(actualToNmsResult instanceof Default);
    assertEquals(Type.DEFAULT, actualToNmsResult.type());
  }
}
