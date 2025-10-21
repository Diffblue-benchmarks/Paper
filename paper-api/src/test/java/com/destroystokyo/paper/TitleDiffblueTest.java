package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.destroystokyo.paper.Title.Builder;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_ProfileRGB;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentStyle;
import net.md_5.bungee.api.chat.KeybindComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TitleDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#subtitle(BaseComponent[])}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>()",
    "Title Builder.build()",
    "Builder Builder.subtitle(BaseComponent[])"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualStayResult = Title.builder().fadeIn(1).fadeOut(1).stay(1);
    BaseComponent[] subtitle = new BaseComponent[] {new KeybindComponent()};
    Builder actualSubtitleResult = actualStayResult.subtitle(subtitle);
    BaseComponent[] title = new BaseComponent[] {new KeybindComponent()};
    Title actualTitle = actualSubtitleResult.title(title).build();

    // Assert
    assertEquals(1, actualTitle.getFadeIn());
    assertEquals(1, actualTitle.getFadeOut());
    assertEquals(1, actualTitle.getStay());
    assertSame(subtitle, actualTitle.getSubtitle());
    assertSame(title, actualTitle.getTitle());
  }

  /**
   * Test Builder {@link Builder#fadeIn(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fadeIn(int)}
   */
  @Test
  @DisplayName("Test Builder fadeIn(int); when one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fadeIn(int)"})
  void testBuilderFadeIn_whenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualFadeInResult = builderResult.fadeIn(1);

    // Assert
    assertSame(builderResult, actualFadeInResult);
  }

  /**
   * Test Builder {@link Builder#fadeOut(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fadeOut(int)}
   */
  @Test
  @DisplayName("Test Builder fadeOut(int); when one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fadeOut(int)"})
  void testBuilderFadeOut_whenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualFadeOutResult = builderResult.fadeOut(1);

    // Assert
    assertSame(builderResult, actualFadeOutResult);
  }

  /**
   * Test Builder {@link Builder#stay(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#stay(int)}
   */
  @Test
  @DisplayName("Test Builder stay(int); when one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.stay(int)"})
  void testBuilderStay_whenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualStayResult = builderResult.stay(1);

    // Assert
    assertSame(builderResult, actualStayResult);
  }

  /**
   * Test Builder {@link Builder#subtitle(BaseComponent)} with {@code BaseComponent}.
   *
   * <ul>
   *   <li>When {@link KeybindComponent#KeybindComponent()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#subtitle(BaseComponent)}
   */
  @Test
  @DisplayName("Test Builder subtitle(BaseComponent) with 'BaseComponent'; when KeybindComponent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subtitle(BaseComponent)"})
  void testBuilderSubtitleWithBaseComponent_whenKeybindComponent() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualSubtitleResult = builderResult.subtitle(new KeybindComponent());

    // Assert
    assertSame(builderResult, actualSubtitleResult);
  }

  /**
   * Test Builder {@link Builder#subtitle(BaseComponent)} with {@code BaseComponent}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#subtitle(BaseComponent)}
   */
  @Test
  @DisplayName("Test Builder subtitle(BaseComponent) with 'BaseComponent'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subtitle(BaseComponent)"})
  void testBuilderSubtitleWithBaseComponent_whenNull() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualSubtitleResult = builderResult.subtitle((BaseComponent) null);

    // Assert
    assertSame(builderResult, actualSubtitleResult);
  }

  /**
   * Test Builder {@link Builder#subtitle(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#subtitle(String)}
   */
  @Test
  @DisplayName("Test Builder subtitle(String) with 'String'; when 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subtitle(String)"})
  void testBuilderSubtitleWithString_whenDr() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualSubtitleResult = builderResult.subtitle("Dr");

    // Assert
    assertSame(builderResult, actualSubtitleResult);
  }

  /**
   * Test Builder {@link Builder#subtitle(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#subtitle(String)}
   */
  @Test
  @DisplayName("Test Builder subtitle(String) with 'String'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subtitle(String)"})
  void testBuilderSubtitleWithString_whenNull() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualSubtitleResult = builderResult.subtitle((String) null);

    // Assert
    assertSame(builderResult, actualSubtitleResult);
  }

  /**
   * Test Builder {@link Builder#title(BaseComponent)} with {@code BaseComponent}.
   *
   * <ul>
   *   <li>Then builder build Subtitle is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#title(BaseComponent)}
   */
  @Test
  @DisplayName(
      "Test Builder title(BaseComponent) with 'BaseComponent'; then builder build Subtitle is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.title(BaseComponent)"})
  void testBuilderTitleWithBaseComponent_thenBuilderBuildSubtitleIsNull() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualTitleResult = builderResult.title(new KeybindComponent());

    // Assert
    Title title = builderResult.build();
    assertNull(title.getSubtitle());
    assertEquals(Title.DEFAULT_FADE_IN, title.getFadeIn());
    assertEquals(Title.DEFAULT_FADE_IN, title.getFadeOut());
    assertEquals(Title.DEFAULT_STAY, title.getStay());
    assertSame(builderResult, actualTitleResult);
  }

  /**
   * Test Builder {@link Builder#title(BaseComponent[])} with {@code BaseComponent[]}.
   *
   * <ul>
   *   <li>Then builder build Subtitle is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#title(BaseComponent[])}
   */
  @Test
  @DisplayName(
      "Test Builder title(BaseComponent[]) with 'BaseComponent[]'; then builder build Subtitle is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.title(BaseComponent[])"})
  void testBuilderTitleWithBaseComponent_thenBuilderBuildSubtitleIsNull2() {
    // Arrange
    Builder builderResult = Title.builder();
    BaseComponent[] title = new BaseComponent[] {new KeybindComponent()};

    // Act
    Builder actualTitleResult = builderResult.title(title);

    // Assert
    Title title2 = builderResult.build();
    assertNull(title2.getSubtitle());
    assertEquals(Title.DEFAULT_FADE_IN, title2.getFadeIn());
    assertEquals(Title.DEFAULT_FADE_IN, title2.getFadeOut());
    assertEquals(Title.DEFAULT_STAY, title2.getStay());
    assertSame(builderResult, actualTitleResult);
    assertSame(title, title2.getTitle());
  }

  /**
   * Test Builder {@link Builder#title(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Dr}.
   *   <li>Then builder build Subtitle is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#title(String)}
   */
  @Test
  @DisplayName(
      "Test Builder title(String) with 'String'; when 'Dr'; then builder build Subtitle is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.title(String)"})
  void testBuilderTitleWithString_whenDr_thenBuilderBuildSubtitleIsNull() {
    // Arrange
    Builder builderResult = Title.builder();

    // Act
    Builder actualTitleResult = builderResult.title("Dr");

    // Assert
    Title title = builderResult.build();
    assertNull(title.getSubtitle());
    assertEquals(Title.DEFAULT_FADE_IN, title.getFadeIn());
    assertEquals(Title.DEFAULT_FADE_IN, title.getFadeOut());
    assertEquals(Title.DEFAULT_STAY, title.getStay());
    assertSame(builderResult, actualTitleResult);
  }

  /**
   * Test {@link Title#Title(BaseComponent)}.
   *
   * <p>Method under test: {@link Title#Title(BaseComponent)}
   */
  @Test
  @DisplayName("Test new Title(BaseComponent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(BaseComponent)"})
  void testNewTitle() {
    // Arrange
    KeybindComponent title = new KeybindComponent();

    // Act
    Title actualTitle = new Title(title);

    // Assert
    BaseComponent[] title2 = actualTitle.getTitle();
    BaseComponent baseComponent = title2[0];
    assertTrue(baseComponent instanceof KeybindComponent);
    assertNull(actualTitle.getSubtitle());
    assertEquals(1, title2.length);
    assertEquals(Title.DEFAULT_FADE_IN, actualTitle.getFadeIn());
    assertEquals(Title.DEFAULT_FADE_IN, actualTitle.getFadeOut());
    assertEquals(Title.DEFAULT_STAY, actualTitle.getStay());
    assertSame(title, baseComponent);
  }

  /**
   * Test {@link Title#Title(BaseComponent[])}.
   *
   * <p>Method under test: {@link Title#Title(BaseComponent[])}
   */
  @Test
  @DisplayName("Test new Title(BaseComponent[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(BaseComponent[])"})
  void testNewTitle2() {
    // Arrange
    BaseComponent[] title = new BaseComponent[] {new KeybindComponent()};

    // Act
    Title actualTitle = new Title(title);

    // Assert
    assertNull(actualTitle.getSubtitle());
    assertEquals(Title.DEFAULT_FADE_IN, actualTitle.getFadeIn());
    assertEquals(Title.DEFAULT_FADE_IN, actualTitle.getFadeOut());
    assertEquals(Title.DEFAULT_STAY, actualTitle.getStay());
    assertSame(title, actualTitle.getTitle());
  }

  /**
   * Test {@link Title#Title(BaseComponent[], BaseComponent[])}.
   *
   * <p>Method under test: {@link Title#Title(BaseComponent[], BaseComponent[])}
   */
  @Test
  @DisplayName("Test new Title(BaseComponent[], BaseComponent[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(BaseComponent[], BaseComponent[])"})
  void testNewTitle3() {
    // Arrange
    BaseComponent[] title = new BaseComponent[] {new KeybindComponent()};
    BaseComponent[] subtitle = new BaseComponent[] {new KeybindComponent()};

    // Act
    Title actualTitle = new Title(title, subtitle);

    // Assert
    assertEquals(Title.DEFAULT_FADE_IN, actualTitle.getFadeIn());
    assertEquals(Title.DEFAULT_FADE_IN, actualTitle.getFadeOut());
    assertEquals(Title.DEFAULT_STAY, actualTitle.getStay());
    assertSame(subtitle, actualTitle.getSubtitle());
    assertSame(title, actualTitle.getTitle());
  }

  /**
   * Test {@link Title#Title(String)}.
   *
   * <ul>
   *   <li>Then return first element toPlainText is {@code Negative fadeIn: %s}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(String)}
   */
  @Test
  @DisplayName(
      "Test new Title(String); then return first element toPlainText is 'Negative fadeIn: %s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(String)"})
  void testNewTitle_thenReturnFirstElementToPlainTextIsNegativeFadeInS() {
    // Arrange, Act and Assert
    BaseComponent[] title = new Title("Negative fadeIn: %s").getTitle();
    BaseComponent baseComponent = title[0];
    assertTrue(baseComponent instanceof TextComponent);
    assertEquals("Negative fadeIn: %s", baseComponent.toPlainText());
    assertEquals("Negative fadeIn: %s", ((TextComponent) baseComponent).getText());
    assertEquals("§fNegative fadeIn: %s", baseComponent.toLegacyText());
    assertEquals(1, title.length);
    Color color = baseComponent.getColor().getColor();
    assertEquals(color, color.brighter().brighter());
  }

  /**
   * Test {@link Title#Title(String, String)}.
   *
   * <ul>
   *   <li>Then return first element toPlainText is {@code Negative fadeIn: %s}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(String, String)}
   */
  @Test
  @DisplayName(
      "Test new Title(String, String); then return first element toPlainText is 'Negative fadeIn: %s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(String, String)"})
  void testNewTitle_thenReturnFirstElementToPlainTextIsNegativeFadeInS2() {
    // Arrange and Act
    Title actualTitle = new Title("Negative fadeIn: %s", "Dr");

    // Assert
    BaseComponent[] subtitle = actualTitle.getSubtitle();
    BaseComponent baseComponent = subtitle[0];
    assertTrue(baseComponent instanceof TextComponent);
    BaseComponent[] title = actualTitle.getTitle();
    BaseComponent baseComponent2 = title[0];
    assertTrue(baseComponent2 instanceof TextComponent);
    assertEquals("Negative fadeIn: %s", baseComponent2.toPlainText());
    assertEquals("Negative fadeIn: %s", ((TextComponent) baseComponent2).getText());
    assertEquals("§fNegative fadeIn: %s", baseComponent2.toLegacyText());
    assertEquals(1, subtitle.length);
    assertEquals(1, title.length);
    ChatColor color = baseComponent.getColor();
    Color color2 = color.getColor();
    Color actualBrighterResult = color2.brighter();
    assertEquals(color2, actualBrighterResult);
    assertSame(color, baseComponent2.getColor());
  }

  /**
   * Test {@link Title#Title(String, String, int, int, int)}.
   *
   * <ul>
   *   <li>Then return first element toPlainText is {@code Negative fadeIn: %s}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(String, String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new Title(String, String, int, int, int); then return first element toPlainText is 'Negative fadeIn: %s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(String, String, int, int, int)"})
  void testNewTitle_thenReturnFirstElementToPlainTextIsNegativeFadeInS3() {
    // Arrange and Act
    Title actualTitle = new Title("Negative fadeIn: %s", "Dr", 1, 1, 1);

    // Assert
    BaseComponent[] subtitle = actualTitle.getSubtitle();
    BaseComponent baseComponent = subtitle[0];
    assertTrue(baseComponent instanceof TextComponent);
    BaseComponent[] title = actualTitle.getTitle();
    BaseComponent baseComponent2 = title[0];
    assertTrue(baseComponent2 instanceof TextComponent);
    assertEquals("Negative fadeIn: %s", baseComponent2.toPlainText());
    assertEquals("Negative fadeIn: %s", ((TextComponent) baseComponent2).getText());
    assertEquals("§fNegative fadeIn: %s", baseComponent2.toLegacyText());
    assertEquals(1, subtitle.length);
    assertEquals(1, title.length);
    ChatColor color = baseComponent.getColor();
    Color color2 = color.getColor();
    Color actualBrighterResult = color2.brighter();
    assertEquals(color2, actualBrighterResult);
    assertSame(color, baseComponent2.getColor());
  }

  /**
   * Test {@link Title#Title(BaseComponent[], BaseComponent[], int, int, int)}.
   *
   * <ul>
   *   <li>When array of {@link BaseComponent} with {@link KeybindComponent#KeybindComponent()}.
   *   <li>Then return FadeIn is one.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(BaseComponent[], BaseComponent[], int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new Title(BaseComponent[], BaseComponent[], int, int, int); when array of BaseComponent with KeybindComponent(); then return FadeIn is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(BaseComponent[], BaseComponent[], int, int, int)"})
  void testNewTitle_whenArrayOfBaseComponentWithKeybindComponent_thenReturnFadeInIsOne() {
    // Arrange
    BaseComponent[] title = new BaseComponent[] {new KeybindComponent()};
    BaseComponent[] subtitle = new BaseComponent[] {new KeybindComponent()};

    // Act
    Title actualTitle = new Title(title, subtitle, 1, 1, 1);

    // Assert
    assertEquals(1, actualTitle.getFadeIn());
    assertEquals(1, actualTitle.getFadeOut());
    assertEquals(1, actualTitle.getStay());
    assertSame(subtitle, actualTitle.getSubtitle());
    assertSame(title, actualTitle.getTitle());
  }

  /**
   * Test {@link Title#Title(String, String)}.
   *
   * <ul>
   *   <li>When {@code Dr}.
   *   <li>Then first element Color Color ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(String, String)}
   */
  @Test
  @DisplayName(
      "Test new Title(String, String); when 'Dr'; then first element Color Color ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(String, String)"})
  void testNewTitle_whenDr_thenFirstElementColorColorColorSpaceReturnICC_ColorSpace() {
    // Arrange and Act
    Title actualTitle = new Title("Dr", "Dr");

    // Assert
    BaseComponent[] subtitle = actualTitle.getSubtitle();
    BaseComponent baseComponent = subtitle[0];
    Color color = baseComponent.getColor().getColor();
    ColorSpace colorSpace = color.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    assertTrue(baseComponent instanceof TextComponent);
    BaseComponent[] title = actualTitle.getTitle();
    BaseComponent baseComponent2 = title[0];
    assertTrue(baseComponent2 instanceof TextComponent);
    assertEquals(1, subtitle.length);
    assertEquals(1, title.length);
    assertEquals(color, color.brighter().brighter());
    assertEquals(baseComponent, baseComponent2);
    assertSame(colorSpace, color.darker().getColorSpace());
  }

  /**
   * Test {@link Title#Title(String, String, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code Dr}.
   *   <li>Then first element Color Color ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(String, String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new Title(String, String, int, int, int); when 'Dr'; then first element Color Color ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(String, String, int, int, int)"})
  void testNewTitle_whenDr_thenFirstElementColorColorColorSpaceReturnICC_ColorSpace2() {
    // Arrange and Act
    Title actualTitle = new Title("Dr", "Dr", 1, 1, 1);

    // Assert
    BaseComponent[] subtitle = actualTitle.getSubtitle();
    BaseComponent baseComponent = subtitle[0];
    Color color = baseComponent.getColor().getColor();
    ColorSpace colorSpace = color.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    assertTrue(baseComponent instanceof TextComponent);
    BaseComponent[] title = actualTitle.getTitle();
    BaseComponent baseComponent2 = title[0];
    assertTrue(baseComponent2 instanceof TextComponent);
    assertEquals(1, subtitle.length);
    assertEquals(1, title.length);
    assertEquals(color, color.brighter().brighter());
    assertEquals(baseComponent, baseComponent2);
    assertSame(colorSpace, color.darker().getColorSpace());
  }

  /**
   * Test {@link Title#Title(String)}.
   *
   * <ul>
   *   <li>When {@code Dr}.
   *   <li>Then return first element toPlainText is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(String)}
   */
  @Test
  @DisplayName("Test new Title(String); when 'Dr'; then return first element toPlainText is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(String)"})
  void testNewTitle_whenDr_thenReturnFirstElementToPlainTextIsDr() {
    // Arrange, Act and Assert
    BaseComponent[] title = new Title("Dr").getTitle();
    BaseComponent baseComponent = title[0];
    assertTrue(baseComponent instanceof TextComponent);
    assertEquals("Dr", baseComponent.toPlainText());
    assertEquals("Dr", ((TextComponent) baseComponent).getText());
    assertEquals("§fDr", baseComponent.toLegacyText());
    assertEquals(1, title.length);
    Color color = baseComponent.getColor().getColor();
    assertEquals(color, color.brighter().brighter());
  }

  /**
   * Test {@link Title#Title(BaseComponent, BaseComponent)}.
   *
   * <ul>
   *   <li>When {@link KeybindComponent#KeybindComponent()}.
   *   <li>Then return first element is {@link KeybindComponent#KeybindComponent()}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(BaseComponent, BaseComponent)}
   */
  @Test
  @DisplayName(
      "Test new Title(BaseComponent, BaseComponent); when KeybindComponent(); then return first element is KeybindComponent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(BaseComponent, BaseComponent)"})
  void testNewTitle_whenKeybindComponent_thenReturnFirstElementIsKeybindComponent() {
    // Arrange
    KeybindComponent title = new KeybindComponent();
    KeybindComponent subtitle = new KeybindComponent();

    // Act
    Title actualTitle = new Title(title, subtitle);

    // Assert
    BaseComponent[] subtitle2 = actualTitle.getSubtitle();
    assertEquals(1, subtitle2.length);
    assertSame(subtitle, subtitle2[0]);
  }

  /**
   * Test {@link Title#Title(BaseComponent, BaseComponent, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link KeybindComponent#KeybindComponent()}.
   *   <li>Then return first element is {@link KeybindComponent#KeybindComponent()}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(BaseComponent, BaseComponent, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new Title(BaseComponent, BaseComponent, int, int, int); when KeybindComponent(); then return first element is KeybindComponent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(BaseComponent, BaseComponent, int, int, int)"})
  void testNewTitle_whenKeybindComponent_thenReturnFirstElementIsKeybindComponent2() {
    // Arrange
    KeybindComponent title = new KeybindComponent();
    KeybindComponent subtitle = new KeybindComponent();

    // Act
    Title actualTitle = new Title(title, subtitle, 1, 1, 1);

    // Assert
    BaseComponent[] subtitle2 = actualTitle.getSubtitle();
    assertEquals(1, subtitle2.length);
    assertSame(subtitle, subtitle2[0]);
  }

  /**
   * Test {@link Title#Title(BaseComponent, BaseComponent)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then first element return {@link KeybindComponent}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(BaseComponent, BaseComponent)}
   */
  @Test
  @DisplayName(
      "Test new Title(BaseComponent, BaseComponent); when 'null'; then first element return KeybindComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(BaseComponent, BaseComponent)"})
  void testNewTitle_whenNull_thenFirstElementReturnKeybindComponent() {
    // Arrange and Act
    Title actualTitle = new Title(new KeybindComponent(), null);

    // Assert
    BaseComponent[] title = actualTitle.getTitle();
    BaseComponent baseComponent = title[0];
    assertTrue(baseComponent instanceof KeybindComponent);
    ChatColor color = baseComponent.getColor();
    assertEquals("WHITE", color.name());
    assertEquals("§f", color.toString());
    assertEquals("white", color.getName());
    ComponentStyle style = baseComponent.getStyle();
    assertNull(style.getShadowColor());
    assertNull(style.isBoldRaw());
    assertNull(style.isItalicRaw());
    assertNull(style.isObfuscatedRaw());
    assertNull(style.isStrikethroughRaw());
    assertNull(style.isUnderlinedRaw());
    assertNull(style.getFont());
    assertNull(style.getColor());
    assertNull(actualTitle.getSubtitle());
    assertEquals(1, title.length);
    assertFalse(style.hasColor());
    assertFalse(style.hasFont());
    assertFalse(style.hasShadowColor());
    assertTrue(style.isEmpty());
  }

  /**
   * Test {@link Title#Title(BaseComponent, BaseComponent, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then first element return {@link KeybindComponent}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(BaseComponent, BaseComponent, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new Title(BaseComponent, BaseComponent, int, int, int); when 'null'; then first element return KeybindComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(BaseComponent, BaseComponent, int, int, int)"})
  void testNewTitle_whenNull_thenFirstElementReturnKeybindComponent2() {
    // Arrange and Act
    Title actualTitle = new Title(new KeybindComponent(), null, 1, 1, 1);

    // Assert
    BaseComponent[] title = actualTitle.getTitle();
    BaseComponent baseComponent = title[0];
    assertTrue(baseComponent instanceof KeybindComponent);
    ChatColor color = baseComponent.getColor();
    assertEquals("WHITE", color.name());
    assertEquals("§f", color.toString());
    assertEquals("white", color.getName());
    ComponentStyle style = baseComponent.getStyle();
    assertNull(style.getShadowColor());
    assertNull(style.isBoldRaw());
    assertNull(style.isItalicRaw());
    assertNull(style.isObfuscatedRaw());
    assertNull(style.isStrikethroughRaw());
    assertNull(style.isUnderlinedRaw());
    assertNull(style.getFont());
    assertNull(style.getColor());
    assertNull(actualTitle.getSubtitle());
    assertEquals(1, title.length);
    assertFalse(style.hasColor());
    assertFalse(style.hasFont());
    assertFalse(style.hasShadowColor());
    assertTrue(style.isEmpty());
  }

  /**
   * Test {@link Title#Title(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return first element Color name is {@code WHITE}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(String, String)}
   */
  @Test
  @DisplayName(
      "Test new Title(String, String); when 'null'; then return first element Color name is 'WHITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(String, String)"})
  void testNewTitle_whenNull_thenReturnFirstElementColorNameIsWhite() {
    // Arrange and Act
    Title actualTitle = new Title("Dr", null);

    // Assert
    BaseComponent[] title = actualTitle.getTitle();
    BaseComponent baseComponent = title[0];
    assertTrue(baseComponent instanceof TextComponent);
    ChatColor color = baseComponent.getColor();
    assertEquals("WHITE", color.name());
    assertEquals("§f", color.toString());
    assertEquals("white", color.getName());
    ComponentStyle style = baseComponent.getStyle();
    assertNull(style.getShadowColor());
    assertNull(style.isBoldRaw());
    assertNull(style.isItalicRaw());
    assertNull(style.isObfuscatedRaw());
    assertNull(style.isStrikethroughRaw());
    assertNull(style.isUnderlinedRaw());
    assertNull(style.getFont());
    assertNull(style.getColor());
    assertNull(actualTitle.getSubtitle());
    assertEquals(1, title.length);
    assertFalse(style.hasColor());
    assertFalse(style.hasFont());
    assertFalse(style.hasShadowColor());
    assertTrue(style.isEmpty());
  }

  /**
   * Test {@link Title#Title(String, String, int, int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return first element Color name is {@code WHITE}.
   * </ul>
   *
   * <p>Method under test: {@link Title#Title(String, String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new Title(String, String, int, int, int); when 'null'; then return first element Color name is 'WHITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.<init>(String, String, int, int, int)"})
  void testNewTitle_whenNull_thenReturnFirstElementColorNameIsWhite2() {
    // Arrange and Act
    Title actualTitle = new Title("Dr", null, 1, 1, 1);

    // Assert
    BaseComponent[] title = actualTitle.getTitle();
    BaseComponent baseComponent = title[0];
    assertTrue(baseComponent instanceof TextComponent);
    ChatColor color = baseComponent.getColor();
    assertEquals("WHITE", color.name());
    assertEquals("§f", color.toString());
    assertEquals("white", color.getName());
    ComponentStyle style = baseComponent.getStyle();
    assertNull(style.getShadowColor());
    assertNull(style.isBoldRaw());
    assertNull(style.isItalicRaw());
    assertNull(style.isObfuscatedRaw());
    assertNull(style.isStrikethroughRaw());
    assertNull(style.isUnderlinedRaw());
    assertNull(style.getFont());
    assertNull(style.getColor());
    assertNull(actualTitle.getSubtitle());
    assertEquals(1, title.length);
    assertFalse(style.hasColor());
    assertFalse(style.hasFont());
    assertFalse(style.hasShadowColor());
    assertTrue(style.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Title#getFadeIn()}
   *   <li>{@link Title#getFadeOut()}
   *   <li>{@link Title#getStay()}
   *   <li>{@link Title#getSubtitle()}
   *   <li>{@link Title#getTitle()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int Title.getFadeIn()",
    "int Title.getFadeOut()",
    "int Title.getStay()",
    "BaseComponent[] Title.getSubtitle()",
    "BaseComponent[] Title.getTitle()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder stayResult = Title.builder().fadeIn(1).fadeOut(1).stay(1);
    KeybindComponent keybindComponent = new KeybindComponent();

    Builder subtitleResult = stayResult.subtitle(new BaseComponent[] {keybindComponent});
    KeybindComponent keybindComponent2 = new KeybindComponent();
    Title title = subtitleResult.title(new BaseComponent[] {keybindComponent2}).build();

    // Act
    int actualFadeIn = title.getFadeIn();
    int actualFadeOut = title.getFadeOut();
    int actualStay = title.getStay();
    BaseComponent[] actualSubtitle = title.getSubtitle();
    BaseComponent[] actualTitle = title.getTitle();

    // Assert
    assertEquals(1, actualFadeIn);
    assertEquals(1, actualFadeOut);
    assertEquals(1, actualStay);
    assertEquals(1, actualSubtitle.length);
    assertEquals(1, actualTitle.length);
    assertSame(keybindComponent, actualSubtitle[0]);
    assertSame(keybindComponent2, actualTitle[0]);
  }

  /**
   * Test {@link Title#send(Player)} with {@code Player}.
   *
   * <p>Method under test: {@link Title#send(Player)}
   */
  @Test
  @DisplayName("Test send(Player) with 'Player'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.send(Player)"})
  void testSendWithPlayer() {
    // Arrange
    Title title = new Title("Dr");

    Player player = mock(Player.class);
    doNothing().when(player).sendTitle(Mockito.<Title>any());

    // Act
    title.send(player);

    // Assert
    verify(player).sendTitle(isA(Title.class));
  }

  /**
   * Test {@link Title#send(Player[])} with {@code Player[]}.
   *
   * <p>Method under test: {@link Title#send(Player[])}
   */
  @Test
  @DisplayName("Test send(Player[]) with 'Player[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Title.send(Player[])"})
  void testSendWithPlayer2() {
    // Arrange
    Title title = new Title("Dr");

    Player player = mock(Player.class);
    doNothing().when(player).sendTitle(Mockito.<Title>any());

    // Act
    title.send(new Player[] {player});

    // Assert
    verify(player).sendTitle(isA(Title.class));
  }
}
