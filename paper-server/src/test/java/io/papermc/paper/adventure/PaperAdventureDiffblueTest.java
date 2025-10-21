package io.papermc.paper.adventure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.adventure.providers.ClickCallbackProviderImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.bossbar.BossBar.Color;
import net.kyori.adventure.bossbar.BossBar.Flag;
import net.kyori.adventure.bossbar.BossBar.Overlay;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.nbt.api.BinaryTagHolder;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.sound.Sound.Source;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.DataComponentValue;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEvent.ShowEntity;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.ShadowColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.kyori.examination.ExaminableProperty;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.RunningOnDifferentThreadException;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaperAdventureDiffblueTest {
  /**
   * Test {@link PaperAdventure#asAdventure(BossBarColor)} with {@code color}.
   *
   * <ul>
   *   <li>When {@code BLUE}.
   *   <li>Then return {@code BLUE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossBarColor)}
   */
  @Test
  @DisplayName("Test asAdventure(BossBarColor) with 'color'; when 'BLUE'; then return 'BLUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Color PaperAdventure.asAdventure(BossBarColor)"})
  void testAsAdventureWithColor_whenBlue_thenReturnBlue() {
    // Arrange, Act and Assert
    assertEquals(Color.BLUE, PaperAdventure.asAdventure(BossBarColor.BLUE));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarColor)} with {@code color}.
   *
   * <ul>
   *   <li>When {@code GREEN}.
   *   <li>Then return {@code GREEN}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossBarColor)}
   */
  @Test
  @DisplayName("Test asAdventure(BossBarColor) with 'color'; when 'GREEN'; then return 'GREEN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Color PaperAdventure.asAdventure(BossBarColor)"})
  void testAsAdventureWithColor_whenGreen_thenReturnGreen() {
    // Arrange, Act and Assert
    assertEquals(Color.GREEN, PaperAdventure.asAdventure(BossBarColor.GREEN));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarColor)} with {@code color}.
   *
   * <ul>
   *   <li>When {@code PINK}.
   *   <li>Then return {@code PINK}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossBarColor)}
   */
  @Test
  @DisplayName("Test asAdventure(BossBarColor) with 'color'; when 'PINK'; then return 'PINK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Color PaperAdventure.asAdventure(BossBarColor)"})
  void testAsAdventureWithColor_whenPink_thenReturnPink() {
    // Arrange, Act and Assert
    assertEquals(Color.PINK, PaperAdventure.asAdventure(BossBarColor.PINK));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarColor)} with {@code color}.
   *
   * <ul>
   *   <li>When {@code PURPLE}.
   *   <li>Then return {@code PURPLE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossBarColor)}
   */
  @Test
  @DisplayName("Test asAdventure(BossBarColor) with 'color'; when 'PURPLE'; then return 'PURPLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Color PaperAdventure.asAdventure(BossBarColor)"})
  void testAsAdventureWithColor_whenPurple_thenReturnPurple() {
    // Arrange, Act and Assert
    assertEquals(Color.PURPLE, PaperAdventure.asAdventure(BossBarColor.PURPLE));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarColor)} with {@code color}.
   *
   * <ul>
   *   <li>When {@code RED}.
   *   <li>Then return {@code RED}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossBarColor)}
   */
  @Test
  @DisplayName("Test asAdventure(BossBarColor) with 'color'; when 'RED'; then return 'RED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Color PaperAdventure.asAdventure(BossBarColor)"})
  void testAsAdventureWithColor_whenRed_thenReturnRed() {
    // Arrange, Act and Assert
    assertEquals(Color.RED, PaperAdventure.asAdventure(BossBarColor.RED));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarColor)} with {@code color}.
   *
   * <ul>
   *   <li>When {@code WHITE}.
   *   <li>Then return {@code WHITE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossBarColor)}
   */
  @Test
  @DisplayName("Test asAdventure(BossBarColor) with 'color'; when 'WHITE'; then return 'WHITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Color PaperAdventure.asAdventure(BossBarColor)"})
  void testAsAdventureWithColor_whenWhite_thenReturnWhite() {
    // Arrange, Act and Assert
    assertEquals(Color.WHITE, PaperAdventure.asAdventure(BossBarColor.WHITE));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarColor)} with {@code color}.
   *
   * <ul>
   *   <li>When {@code YELLOW}.
   *   <li>Then return {@code YELLOW}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossBarColor)}
   */
  @Test
  @DisplayName("Test asAdventure(BossBarColor) with 'color'; when 'YELLOW'; then return 'YELLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Color PaperAdventure.asAdventure(BossBarColor)"})
  void testAsAdventureWithColor_whenYellow_thenReturnYellow() {
    // Arrange, Act and Assert
    assertEquals(Color.YELLOW, PaperAdventure.asAdventure(BossBarColor.YELLOW));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(Component)} with {@code component}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(net.minecraft.network.chat.Component)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(Component) with 'component'; when 'null'; then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component PaperAdventure.asAdventure(net.minecraft.network.chat.Component)"})
  void testAsAdventureWithComponent_whenNull_thenReturnInsertionIsNull() {
    // Arrange and Act
    Component actualAsAdventureResult =
        PaperAdventure.asAdventure((net.minecraft.network.chat.Component) null);

    // Assert
    assertNull(actualAsAdventureResult.insertion());
    assertNull(actualAsAdventureResult.font());
    assertNull(actualAsAdventureResult.color());
    Map<TextDecoration, State> decorationsResult = actualAsAdventureResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualAsAdventureResult.hasStyling());
    Component actualCompactResult = actualAsAdventureResult.compact();
    assertSame(actualAsAdventureResult, actualCompactResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code AQUA}.
   *   <li>Then return toString is {@code aqua}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'AQUA'; then return toString is 'aqua'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenAqua_thenReturnToStringIsAqua() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.AQUA);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("aqua", actualAsAdventureResult.toString());
    assertEquals(5636095, actualAsAdventureResult.value());
    assertEquals(5636095, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code BLACK}.
   *   <li>Then return toString is {@code black}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'BLACK'; then return toString is 'black'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenBlack_thenReturnToStringIsBlack() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.BLACK);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("black", actualAsAdventureResult.toString());
    assertEquals(0, actualAsAdventureResult.value());
    assertEquals(0, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code BLUE}.
   *   <li>Then return toString is {@code blue}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'BLUE'; then return toString is 'blue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenBlue_thenReturnToStringIsBlue() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.BLUE);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("blue", actualAsAdventureResult.toString());
    assertEquals(5592575, actualAsAdventureResult.value());
    assertEquals(5592575, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code DARK_AQUA}.
   *   <li>Then return toString is {@code dark_aqua}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'DARK_AQUA'; then return toString is 'dark_aqua'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenDarkAqua_thenReturnToStringIsDarkAqua() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.DARK_AQUA);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("dark_aqua", actualAsAdventureResult.toString());
    assertEquals(43690, actualAsAdventureResult.value());
    assertEquals(43690, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code DARK_BLUE}.
   *   <li>Then return toString is {@code dark_blue}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'DARK_BLUE'; then return toString is 'dark_blue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenDarkBlue_thenReturnToStringIsDarkBlue() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.DARK_BLUE);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("dark_blue", actualAsAdventureResult.toString());
    assertEquals(170, actualAsAdventureResult.value());
    assertEquals(170, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code DARK_GRAY}.
   *   <li>Then return toString is {@code dark_gray}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'DARK_GRAY'; then return toString is 'dark_gray'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenDarkGray_thenReturnToStringIsDarkGray() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.DARK_GRAY);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("dark_gray", actualAsAdventureResult.toString());
    assertEquals(5592405, actualAsAdventureResult.value());
    assertEquals(5592405, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code DARK_GREEN}.
   *   <li>Then return toString is {@code dark_green}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'DARK_GREEN'; then return toString is 'dark_green'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenDarkGreen_thenReturnToStringIsDarkGreen() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.DARK_GREEN);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("dark_green", actualAsAdventureResult.toString());
    assertEquals(43520, actualAsAdventureResult.value());
    assertEquals(43520, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code DARK_PURPLE}.
   *   <li>Then return toString is {@code dark_purple}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'DARK_PURPLE'; then return toString is 'dark_purple'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenDarkPurple_thenReturnToStringIsDarkPurple() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.DARK_PURPLE);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("dark_purple", actualAsAdventureResult.toString());
    assertEquals(11141290, actualAsAdventureResult.value());
    assertEquals(11141290, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code DARK_RED}.
   *   <li>Then return toString is {@code dark_red}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'DARK_RED'; then return toString is 'dark_red'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenDarkRed_thenReturnToStringIsDarkRed() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.DARK_RED);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("dark_red", actualAsAdventureResult.toString());
    assertEquals(11141120, actualAsAdventureResult.value());
    assertEquals(11141120, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code GOLD}.
   *   <li>Then return toString is {@code gold}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'GOLD'; then return toString is 'gold'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenGold_thenReturnToStringIsGold() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.GOLD);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("gold", actualAsAdventureResult.toString());
    assertEquals(16755200, actualAsAdventureResult.value());
    assertEquals(16755200, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code GRAY}.
   *   <li>Then return toString is {@code gray}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'GRAY'; then return toString is 'gray'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenGray_thenReturnToStringIsGray() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.GRAY);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("gray", actualAsAdventureResult.toString());
    assertEquals(11184810, actualAsAdventureResult.value());
    assertEquals(11184810, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code GREEN}.
   *   <li>Then return toString is {@code green}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'GREEN'; then return toString is 'green'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenGreen_thenReturnToStringIsGreen() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.GREEN);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("green", actualAsAdventureResult.toString());
    assertEquals(5635925, actualAsAdventureResult.value());
    assertEquals(5635925, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code LIGHT_PURPLE}.
   *   <li>Then return toString is {@code light_purple}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'LIGHT_PURPLE'; then return toString is 'light_purple'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenLightPurple_thenReturnToStringIsLightPurple() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.LIGHT_PURPLE);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("light_purple", actualAsAdventureResult.toString());
    assertEquals(16733695, actualAsAdventureResult.value());
    assertEquals(16733695, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code RED}.
   *   <li>Then return toString is {@code red}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'RED'; then return toString is 'red'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenRed_thenReturnToStringIsRed() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.RED);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("red", actualAsAdventureResult.toString());
    assertEquals(16733525, actualAsAdventureResult.value());
    assertEquals(16733525, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code WHITE}.
   *   <li>Then return toString is {@code white}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'WHITE'; then return toString is 'white'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenWhite_thenReturnToStringIsWhite() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.WHITE);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("white", actualAsAdventureResult.toString());
    assertEquals(16777215, actualAsAdventureResult.value());
    assertEquals(16777215, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ChatFormatting)} with {@code formatting}.
   *
   * <ul>
   *   <li>When {@code YELLOW}.
   *   <li>Then return toString is {@code yellow}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ChatFormatting)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ChatFormatting) with 'formatting'; when 'YELLOW'; then return toString is 'yellow'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor PaperAdventure.asAdventure(ChatFormatting)"})
  void testAsAdventureWithFormatting_whenYellow_thenReturnToStringIsYellow() {
    // Arrange and Act
    TextColor actualAsAdventureResult = PaperAdventure.asAdventure(ChatFormatting.YELLOW);
    int actualValueResult = actualAsAdventureResult.value();

    // Assert
    assertTrue(actualAsAdventureResult instanceof NamedTextColor);
    assertEquals("yellow", actualAsAdventureResult.toString());
    assertEquals(16777045, actualAsAdventureResult.value());
    assertEquals(16777045, actualValueResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(ResourceLocation)} with {@code key}.
   *
   * <ul>
   *   <li>Then return examinableName is {@code KeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(ResourceLocation)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(ResourceLocation) with 'key'; then return examinableName is 'KeyImpl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperAdventure.asAdventure(ResourceLocation)"})
  void testAsAdventureWithKey_thenReturnExaminableNameIsKeyImpl() {
    // Arrange and Act
    Key actualAsAdventureResult =
        PaperAdventure.asAdventure(ResourceLocation.withDefaultNamespace("argument.id.invalid"));

    // Assert
    assertEquals("KeyImpl", actualAsAdventureResult.examinableName());
    assertEquals("argument.id.invalid", actualAsAdventureResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualAsAdventureResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarOverlay)} with {@code overlay}.
   *
   * <ul>
   *   <li>When {@code NOTCHED_6}.
   *   <li>Then return {@code NOTCHED_6}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossEvent.BossBarOverlay)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(BossBarOverlay) with 'overlay'; when 'NOTCHED_6'; then return 'NOTCHED_6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Overlay PaperAdventure.asAdventure(BossEvent.BossBarOverlay)"})
  void testAsAdventureWithOverlay_whenNotched6_thenReturnNotched6() {
    // Arrange, Act and Assert
    assertEquals(Overlay.NOTCHED_6, PaperAdventure.asAdventure(BossBarOverlay.NOTCHED_6));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarOverlay)} with {@code overlay}.
   *
   * <ul>
   *   <li>When {@code NOTCHED_10}.
   *   <li>Then return {@code NOTCHED_10}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossEvent.BossBarOverlay)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(BossBarOverlay) with 'overlay'; when 'NOTCHED_10'; then return 'NOTCHED_10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Overlay PaperAdventure.asAdventure(BossEvent.BossBarOverlay)"})
  void testAsAdventureWithOverlay_whenNotched10_thenReturnNotched10() {
    // Arrange, Act and Assert
    assertEquals(Overlay.NOTCHED_10, PaperAdventure.asAdventure(BossBarOverlay.NOTCHED_10));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarOverlay)} with {@code overlay}.
   *
   * <ul>
   *   <li>When {@code NOTCHED_12}.
   *   <li>Then return {@code NOTCHED_12}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossEvent.BossBarOverlay)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(BossBarOverlay) with 'overlay'; when 'NOTCHED_12'; then return 'NOTCHED_12'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Overlay PaperAdventure.asAdventure(BossEvent.BossBarOverlay)"})
  void testAsAdventureWithOverlay_whenNotched12_thenReturnNotched12() {
    // Arrange, Act and Assert
    assertEquals(Overlay.NOTCHED_12, PaperAdventure.asAdventure(BossBarOverlay.NOTCHED_12));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarOverlay)} with {@code overlay}.
   *
   * <ul>
   *   <li>When {@code NOTCHED_20}.
   *   <li>Then return {@code NOTCHED_20}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossEvent.BossBarOverlay)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(BossBarOverlay) with 'overlay'; when 'NOTCHED_20'; then return 'NOTCHED_20'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Overlay PaperAdventure.asAdventure(BossEvent.BossBarOverlay)"})
  void testAsAdventureWithOverlay_whenNotched20_thenReturnNotched20() {
    // Arrange, Act and Assert
    assertEquals(Overlay.NOTCHED_20, PaperAdventure.asAdventure(BossBarOverlay.NOTCHED_20));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(BossBarOverlay)} with {@code overlay}.
   *
   * <ul>
   *   <li>When {@code PROGRESS}.
   *   <li>Then return {@code PROGRESS}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(BossEvent.BossBarOverlay)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(BossBarOverlay) with 'overlay'; when 'PROGRESS'; then return 'PROGRESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBar.Overlay PaperAdventure.asAdventure(BossEvent.BossBarOverlay)"})
  void testAsAdventureWithOverlay_whenProgress_thenReturnProgress() {
    // Arrange, Act and Assert
    assertEquals(Overlay.PROGRESS, PaperAdventure.asAdventure(BossBarOverlay.PROGRESS));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(DataComponentPatch)} with {@code patch}.
   *
   * <ul>
   *   <li>When {@link DataComponentPatch#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(DataComponentPatch)}
   */
  @Test
  @DisplayName("Test asAdventure(DataComponentPatch) with 'patch'; when EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperAdventure.asAdventure(DataComponentPatch)"})
  void testAsAdventureWithPatch_whenEmpty_thenReturnEmpty() {
    // Arrange and Act
    Map<Key, ? extends DataComponentValue> actualAsAdventureResult =
        PaperAdventure.asAdventure(DataComponentPatch.EMPTY);

    // Assert
    assertTrue(actualAsAdventureResult.isEmpty());
  }

  /**
   * Test {@link PaperAdventure#asAdventure(List)} with {@code vanillas}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return first insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(List)}
   */
  @Test
  @DisplayName(
      "Test asAdventure(List) with 'vanillas'; given 'null'; then return first insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList PaperAdventure.asAdventure(List)"})
  void testAsAdventureWithVanillas_givenNull_thenReturnFirstInsertionIsNull() {
    // Arrange
    ArrayList<? extends net.minecraft.network.chat.Component> vanillas = new ArrayList<>();
    vanillas.add(null);

    // Act
    ArrayList<Component> actualAsAdventureResult = PaperAdventure.asAdventure(vanillas);

    // Assert
    assertEquals(1, actualAsAdventureResult.size());
    Component getResult = actualAsAdventureResult.get(0);
    assertNull(getResult.insertion());
    assertNull(getResult.font());
    assertNull(getResult.color());
    Map<TextDecoration, State> decorationsResult = getResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(getResult.hasStyling());
    Component actualCompactResult = getResult.compact();
    assertSame(getResult, actualCompactResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventure(List)} with {@code vanillas}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(List)}
   */
  @Test
  @DisplayName("Test asAdventure(List) with 'vanillas'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList PaperAdventure.asAdventure(List)"})
  void testAsAdventureWithVanillas_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<net.minecraft.network.chat.Component> vanillas = new ArrayList<>();
    AdventureComponent adventureComponent = new AdventureComponent(mock(Component.class));
    vanillas.add(adventureComponent);
    AdventureComponent adventureComponent2 = new AdventureComponent(mock(Component.class));
    vanillas.add(adventureComponent2);

    // Act
    ArrayList<Component> actualAsAdventureResult = PaperAdventure.asAdventure(vanillas);

    // Assert
    assertEquals(2, actualAsAdventureResult.size());
    assertSame(adventureComponent.adventure, actualAsAdventureResult.get(0));
    assertSame(adventureComponent2.adventure, actualAsAdventureResult.get(1));
  }

  /**
   * Test {@link PaperAdventure#asAdventure(List)} with {@code vanillas}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventure(List)}
   */
  @Test
  @DisplayName("Test asAdventure(List) with 'vanillas'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList PaperAdventure.asAdventure(List)"})
  void testAsAdventureWithVanillas_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    ArrayList<Component> actualAsAdventureResult = PaperAdventure.asAdventure(new ArrayList<>());

    // Assert
    assertTrue(actualAsAdventureResult.isEmpty());
  }

  /**
   * Test {@link PaperAdventure#setFlag(BossBar, Flag, boolean)}.
   *
   * <p>Method under test: {@link PaperAdventure#setFlag(BossBar, BossBar.Flag, boolean)}
   */
  @Test
  @DisplayName("Test setFlag(BossBar, Flag, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperAdventure.setFlag(BossBar, BossBar.Flag, boolean)"})
  void testSetFlag() {
    // Arrange
    BossBar bar = mock(BossBar.class);
    when(bar.addFlag(Mockito.<Flag>any()))
        .thenThrow(
            new MatchException(
                "0123456789ABCDEF", RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD));

    // Act and Assert
    assertThrows(MatchException.class, () -> PaperAdventure.setFlag(bar, Flag.DARKEN_SCREEN, true));
    verify(bar).addFlag(Flag.DARKEN_SCREEN);
  }

  /**
   * Test {@link PaperAdventure#setFlag(BossBar, Flag, boolean)}.
   *
   * <p>Method under test: {@link PaperAdventure#setFlag(BossBar, BossBar.Flag, boolean)}
   */
  @Test
  @DisplayName("Test setFlag(BossBar, Flag, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperAdventure.setFlag(BossBar, BossBar.Flag, boolean)"})
  void testSetFlag2() {
    // Arrange
    BossBar bar = mock(BossBar.class);
    when(bar.removeFlag(Mockito.<Flag>any()))
        .thenThrow(
            new MatchException(
                "0123456789ABCDEF", RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD));

    // Act and Assert
    assertThrows(
        MatchException.class, () -> PaperAdventure.setFlag(bar, Flag.DARKEN_SCREEN, false));
    verify(bar).removeFlag(Flag.DARKEN_SCREEN);
  }

  /**
   * Test {@link PaperAdventure#setFlag(BossBar, Flag, boolean)}.
   *
   * <ul>
   *   <li>Given {@link BossBar}.
   *   <li>When {@link BossBar} {@link BossBar#addFlag(Flag)} return {@link BossBar}.
   *   <li>Then calls {@link BossBar#addFlag(Flag)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#setFlag(BossBar, BossBar.Flag, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFlag(BossBar, Flag, boolean); given BossBar; when BossBar addFlag(Flag) return BossBar; then calls addFlag(Flag)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperAdventure.setFlag(BossBar, BossBar.Flag, boolean)"})
  void testSetFlag_givenBossBar_whenBossBarAddFlagReturnBossBar_thenCallsAddFlag() {
    // Arrange
    BossBar bar = mock(BossBar.class);
    when(bar.addFlag(Mockito.<Flag>any())).thenReturn(mock(BossBar.class));

    // Act
    PaperAdventure.setFlag(bar, Flag.DARKEN_SCREEN, true);

    // Assert
    verify(bar).addFlag(Flag.DARKEN_SCREEN);
  }

  /**
   * Test {@link PaperAdventure#setFlag(BossBar, Flag, boolean)}.
   *
   * <ul>
   *   <li>Given {@link BossBar}.
   *   <li>When {@link BossBar} {@link BossBar#removeFlag(Flag)} return {@link BossBar}.
   *   <li>Then calls {@link BossBar#removeFlag(Flag)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#setFlag(BossBar, BossBar.Flag, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFlag(BossBar, Flag, boolean); given BossBar; when BossBar removeFlag(Flag) return BossBar; then calls removeFlag(Flag)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperAdventure.setFlag(BossBar, BossBar.Flag, boolean)"})
  void testSetFlag_givenBossBar_whenBossBarRemoveFlagReturnBossBar_thenCallsRemoveFlag() {
    // Arrange
    BossBar bar = mock(BossBar.class);
    when(bar.removeFlag(Mockito.<Flag>any())).thenReturn(mock(BossBar.class));

    // Act
    PaperAdventure.setFlag(bar, Flag.DARKEN_SCREEN, false);

    // Assert
    verify(bar).removeFlag(Flag.DARKEN_SCREEN);
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@code BLUE}.
   *   <li>Then return {@code BLUE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Color)}
   */
  @Test
  @DisplayName("Test asVanilla(Color) with 'Color'; when 'BLUE'; then return 'BLUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBarColor PaperAdventure.asVanilla(BossBar.Color)"})
  void testAsVanillaWithColor_whenBlue_thenReturnBlue() {
    // Arrange, Act and Assert
    assertEquals(BossBarColor.BLUE, PaperAdventure.asVanilla(Color.BLUE));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@code GREEN}.
   *   <li>Then return {@code GREEN}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Color)}
   */
  @Test
  @DisplayName("Test asVanilla(Color) with 'Color'; when 'GREEN'; then return 'GREEN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBarColor PaperAdventure.asVanilla(BossBar.Color)"})
  void testAsVanillaWithColor_whenGreen_thenReturnGreen() {
    // Arrange, Act and Assert
    assertEquals(BossBarColor.GREEN, PaperAdventure.asVanilla(Color.GREEN));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@code PINK}.
   *   <li>Then return {@code PINK}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Color)}
   */
  @Test
  @DisplayName("Test asVanilla(Color) with 'Color'; when 'PINK'; then return 'PINK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBarColor PaperAdventure.asVanilla(BossBar.Color)"})
  void testAsVanillaWithColor_whenPink_thenReturnPink() {
    // Arrange, Act and Assert
    assertEquals(BossBarColor.PINK, PaperAdventure.asVanilla(Color.PINK));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@code PURPLE}.
   *   <li>Then return {@code PURPLE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Color)}
   */
  @Test
  @DisplayName("Test asVanilla(Color) with 'Color'; when 'PURPLE'; then return 'PURPLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBarColor PaperAdventure.asVanilla(BossBar.Color)"})
  void testAsVanillaWithColor_whenPurple_thenReturnPurple() {
    // Arrange, Act and Assert
    assertEquals(BossBarColor.PURPLE, PaperAdventure.asVanilla(Color.PURPLE));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@code RED}.
   *   <li>Then return {@code RED}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Color)}
   */
  @Test
  @DisplayName("Test asVanilla(Color) with 'Color'; when 'RED'; then return 'RED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBarColor PaperAdventure.asVanilla(BossBar.Color)"})
  void testAsVanillaWithColor_whenRed_thenReturnRed() {
    // Arrange, Act and Assert
    assertEquals(BossBarColor.RED, PaperAdventure.asVanilla(Color.RED));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@code WHITE}.
   *   <li>Then return {@code WHITE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Color)}
   */
  @Test
  @DisplayName("Test asVanilla(Color) with 'Color'; when 'WHITE'; then return 'WHITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBarColor PaperAdventure.asVanilla(BossBar.Color)"})
  void testAsVanillaWithColor_whenWhite_thenReturnWhite() {
    // Arrange, Act and Assert
    assertEquals(BossBarColor.WHITE, PaperAdventure.asVanilla(Color.WHITE));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@code YELLOW}.
   *   <li>Then return {@code YELLOW}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Color)}
   */
  @Test
  @DisplayName("Test asVanilla(Color) with 'Color'; when 'YELLOW'; then return 'YELLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBarColor PaperAdventure.asVanilla(BossBar.Color)"})
  void testAsVanillaWithColor_whenYellow_thenReturnYellow() {
    // Arrange, Act and Assert
    assertEquals(BossBarColor.YELLOW, PaperAdventure.asVanilla(Color.YELLOW));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Component)} with {@code Component}.
   *
   * <ul>
   *   <li>When {@link Component}.
   *   <li>Then return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Component)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(Component) with 'Component'; when Component; then return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.network.chat.Component PaperAdventure.asVanilla(Component)"})
  void testAsVanillaWithComponent_whenComponent_thenReturnAdventureComponent() {
    // Arrange and Act
    net.minecraft.network.chat.Component actualAsVanillaResult =
        PaperAdventure.asVanilla(mock(Component.class));

    // Assert
    assertTrue(actualAsVanillaResult instanceof AdventureComponent);
    Component expectedAdventure$componentResult =
        ((AdventureComponent) actualAsVanillaResult).adventure;
    assertSame(
        expectedAdventure$componentResult,
        ((AdventureComponent) actualAsVanillaResult).adventure$component());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Component)} with {@code Component}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Component)}
   */
  @Test
  @DisplayName("Test asVanilla(Component) with 'Component'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.network.chat.Component PaperAdventure.asVanilla(Component)"})
  void testAsVanillaWithComponent_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PaperAdventure.asVanilla((Component) null));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Key)} with {@code Key}.
   *
   * <ul>
   *   <li>Then return Path is {@code dialog_click_callback}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Key)}
   */
  @Test
  @DisplayName("Test asVanilla(Key) with 'Key'; then return Path is 'dialog_click_callback'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceLocation PaperAdventure.asVanilla(Key)"})
  void testAsVanillaWithKey_thenReturnPathIsDialogClickCallback() {
    // Arrange and Act
    ResourceLocation actualAsVanillaResult =
        PaperAdventure.asVanilla(ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY);

    // Assert
    assertEquals("dialog_click_callback", actualAsVanillaResult.getPath());
    assertEquals("paper", actualAsVanillaResult.getNamespace());
    assertEquals("paper.dialog_click_callback", actualAsVanillaResult.toShortLanguageKey());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Key)} with {@code Key}.
   *
   * <ul>
   *   <li>When {@link ServerBuildInfo#BRAND_PAPER_ID}.
   *   <li>Then return Path is {@code paper}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Key)}
   */
  @Test
  @DisplayName("Test asVanilla(Key) with 'Key'; when BRAND_PAPER_ID; then return Path is 'paper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceLocation PaperAdventure.asVanilla(Key)"})
  void testAsVanillaWithKey_whenBrand_paper_id_thenReturnPathIsPaper() {
    // Arrange and Act
    ResourceLocation actualAsVanillaResult =
        PaperAdventure.asVanilla(ServerBuildInfo.BRAND_PAPER_ID);

    // Assert
    assertEquals("paper", actualAsVanillaResult.getPath());
    assertEquals("papermc", actualAsVanillaResult.getNamespace());
    assertEquals("papermc.paper", actualAsVanillaResult.toShortLanguageKey());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Key)} with {@code Key}.
   *
   * <ul>
   *   <li>When randomKey.
   *   <li>Then return Namespace is {@code bukkit}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Key)}
   */
  @Test
  @DisplayName("Test asVanilla(Key) with 'Key'; when randomKey; then return Namespace is 'bukkit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceLocation PaperAdventure.asVanilla(Key)"})
  void testAsVanillaWithKey_whenRandomKey_thenReturnNamespaceIsBukkit() {
    // Arrange, Act and Assert
    assertEquals("bukkit", PaperAdventure.asVanilla(NamespacedKey.randomKey()).getNamespace());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Component}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(List)}
   */
  @Test
  @DisplayName("Test asVanilla(List) with 'List'; given Component; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperAdventure.asVanilla(List)"})
  void testAsVanillaWithList_givenComponent_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Component> adventures = new ArrayList<>();
    adventures.add(mock(Component.class));
    adventures.add(mock(Component.class));

    // Act
    List<net.minecraft.network.chat.Component> actualAsVanillaResult =
        PaperAdventure.asVanilla(adventures);

    // Assert
    assertEquals(2, actualAsVanillaResult.size());
    assertTrue(actualAsVanillaResult.get(0) instanceof AdventureComponent);
    assertTrue(actualAsVanillaResult.get(1) instanceof AdventureComponent);
  }

  /**
   * Test {@link PaperAdventure#asVanilla(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(List)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(List) with 'List'; given 'null'; when ArrayList() add 'null'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperAdventure.asVanilla(List)"})
  void testAsVanillaWithList_givenNull_whenArrayListAddNull_thenReturnArrayList() {
    // Arrange
    ArrayList<? extends Component> adventures = new ArrayList<>();
    adventures.add(null);

    // Act
    List<net.minecraft.network.chat.Component> actualAsVanillaResult =
        PaperAdventure.asVanilla(adventures);

    // Assert
    assertEquals(adventures, actualAsVanillaResult);
  }

  /**
   * Test {@link PaperAdventure#asVanilla(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(List)}
   */
  @Test
  @DisplayName("Test asVanilla(List) with 'List'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperAdventure.asVanilla(List)"})
  void testAsVanillaWithList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<net.minecraft.network.chat.Component> actualAsVanillaResult =
        PaperAdventure.asVanilla(new ArrayList<>());

    // Assert
    assertTrue(actualAsVanillaResult.isEmpty());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Map)} with {@code Map}.
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Map)}
   */
  @Test
  @DisplayName("Test asVanilla(Map) with 'Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataComponentPatch PaperAdventure.asVanilla(Map)"})
  void testAsVanillaWithMap() {
    // Arrange and Act
    DataComponentPatch actualAsVanillaResult = PaperAdventure.asVanilla(new HashMap<>());

    // Assert
    assertEquals(0, actualAsVanillaResult.size());
    assertTrue(actualAsVanillaResult.isEmpty());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Overlay)} with {@code Overlay}.
   *
   * <ul>
   *   <li>When {@code NOTCHED_6}.
   *   <li>Then return {@code NOTCHED_6}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Overlay)}
   */
  @Test
  @DisplayName("Test asVanilla(Overlay) with 'Overlay'; when 'NOTCHED_6'; then return 'NOTCHED_6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossEvent.BossBarOverlay PaperAdventure.asVanilla(BossBar.Overlay)"})
  void testAsVanillaWithOverlay_whenNotched6_thenReturnNotched6() {
    // Arrange, Act and Assert
    assertEquals(BossBarOverlay.NOTCHED_6, PaperAdventure.asVanilla(Overlay.NOTCHED_6));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Overlay)} with {@code Overlay}.
   *
   * <ul>
   *   <li>When {@code NOTCHED_10}.
   *   <li>Then return {@code NOTCHED_10}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Overlay)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(Overlay) with 'Overlay'; when 'NOTCHED_10'; then return 'NOTCHED_10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossEvent.BossBarOverlay PaperAdventure.asVanilla(BossBar.Overlay)"})
  void testAsVanillaWithOverlay_whenNotched10_thenReturnNotched10() {
    // Arrange, Act and Assert
    assertEquals(BossBarOverlay.NOTCHED_10, PaperAdventure.asVanilla(Overlay.NOTCHED_10));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Overlay)} with {@code Overlay}.
   *
   * <ul>
   *   <li>When {@code NOTCHED_12}.
   *   <li>Then return {@code NOTCHED_12}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Overlay)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(Overlay) with 'Overlay'; when 'NOTCHED_12'; then return 'NOTCHED_12'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossEvent.BossBarOverlay PaperAdventure.asVanilla(BossBar.Overlay)"})
  void testAsVanillaWithOverlay_whenNotched12_thenReturnNotched12() {
    // Arrange, Act and Assert
    assertEquals(BossBarOverlay.NOTCHED_12, PaperAdventure.asVanilla(Overlay.NOTCHED_12));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Overlay)} with {@code Overlay}.
   *
   * <ul>
   *   <li>When {@code NOTCHED_20}.
   *   <li>Then return {@code NOTCHED_20}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Overlay)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(Overlay) with 'Overlay'; when 'NOTCHED_20'; then return 'NOTCHED_20'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossEvent.BossBarOverlay PaperAdventure.asVanilla(BossBar.Overlay)"})
  void testAsVanillaWithOverlay_whenNotched20_thenReturnNotched20() {
    // Arrange, Act and Assert
    assertEquals(BossBarOverlay.NOTCHED_20, PaperAdventure.asVanilla(Overlay.NOTCHED_20));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Overlay)} with {@code Overlay}.
   *
   * <ul>
   *   <li>When {@code PROGRESS}.
   *   <li>Then return {@code PROGRESS}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(BossBar.Overlay)}
   */
  @Test
  @DisplayName("Test asVanilla(Overlay) with 'Overlay'; when 'PROGRESS'; then return 'PROGRESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossEvent.BossBarOverlay PaperAdventure.asVanilla(BossBar.Overlay)"})
  void testAsVanillaWithOverlay_whenProgress_thenReturnProgress() {
    // Arrange, Act and Assert
    assertEquals(BossBarOverlay.PROGRESS, PaperAdventure.asVanilla(Overlay.PROGRESS));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(ResourceKey, Key)} with {@code ResourceKey}, {@code Key}.
   *
   * <ul>
   *   <li>Then return location Namespace is {@code bukkit}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(ResourceKey, Key)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(ResourceKey, Key) with 'ResourceKey', 'Key'; then return location Namespace is 'bukkit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceKey PaperAdventure.asVanilla(ResourceKey, Key)"})
  void testAsVanillaWithResourceKeyKey_thenReturnLocationNamespaceIsBukkit() {
    // Arrange
    ResourceKey<? extends Registry<Object>> registry = mock(ResourceKey.class);

    // Act
    ResourceKey<Object> actualAsVanillaResult =
        PaperAdventure.asVanilla(registry, NamespacedKey.randomKey());

    // Assert
    assertEquals("bukkit", actualAsVanillaResult.location().getNamespace());
    assertNull(actualAsVanillaResult.registry());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(ResourceKey, Key)} with {@code ResourceKey}, {@code Key}.
   *
   * <ul>
   *   <li>Then return location Path is {@code dialog_click_callback}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(ResourceKey, Key)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(ResourceKey, Key) with 'ResourceKey', 'Key'; then return location Path is 'dialog_click_callback'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceKey PaperAdventure.asVanilla(ResourceKey, Key)"})
  void testAsVanillaWithResourceKeyKey_thenReturnLocationPathIsDialogClickCallback() {
    // Arrange and Act
    ResourceKey<Object> actualAsVanillaResult =
        PaperAdventure.asVanilla(
            mock(ResourceKey.class), ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY);

    // Assert
    ResourceLocation locationResult = actualAsVanillaResult.location();
    assertEquals("dialog_click_callback", locationResult.getPath());
    assertEquals("paper", locationResult.getNamespace());
    assertEquals("paper.dialog_click_callback", locationResult.toShortLanguageKey());
    assertNull(actualAsVanillaResult.registry());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(ResourceKey, Key)} with {@code ResourceKey}, {@code Key}.
   *
   * <ul>
   *   <li>When {@link ServerBuildInfo#BRAND_PAPER_ID}.
   *   <li>Then return location Path is {@code paper}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(ResourceKey, Key)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(ResourceKey, Key) with 'ResourceKey', 'Key'; when BRAND_PAPER_ID; then return location Path is 'paper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceKey PaperAdventure.asVanilla(ResourceKey, Key)"})
  void testAsVanillaWithResourceKeyKey_whenBrand_paper_id_thenReturnLocationPathIsPaper() {
    // Arrange and Act
    ResourceKey<Object> actualAsVanillaResult =
        PaperAdventure.asVanilla(mock(ResourceKey.class), ServerBuildInfo.BRAND_PAPER_ID);

    // Assert
    ResourceLocation locationResult = actualAsVanillaResult.location();
    assertEquals("paper", locationResult.getPath());
    assertEquals("papermc", locationResult.getNamespace());
    assertEquals("papermc.paper", locationResult.toShortLanguageKey());
    assertNull(actualAsVanillaResult.registry());
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code AMBIENT}.
   *   <li>Then return {@code AMBIENT}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'AMBIENT'; then return 'AMBIENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenAmbient_thenReturnAmbient() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.AMBIENT, PaperAdventure.asVanilla(Source.AMBIENT));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code BLOCK}.
   *   <li>Then return {@code BLOCKS}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'BLOCK'; then return 'BLOCKS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenBlock_thenReturnBlocks() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.BLOCKS, PaperAdventure.asVanilla(Source.BLOCK));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code HOSTILE}.
   *   <li>Then return {@code HOSTILE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'HOSTILE'; then return 'HOSTILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenHostile_thenReturnHostile() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.HOSTILE, PaperAdventure.asVanilla(Source.HOSTILE));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code MASTER}.
   *   <li>Then return {@code MASTER}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'MASTER'; then return 'MASTER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenMaster_thenReturnMaster() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.MASTER, PaperAdventure.asVanilla(Source.MASTER));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code MUSIC}.
   *   <li>Then return {@code MUSIC}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'MUSIC'; then return 'MUSIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenMusic_thenReturnMusic() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.MUSIC, PaperAdventure.asVanilla(Source.MUSIC));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code NEUTRAL}.
   *   <li>Then return {@code NEUTRAL}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'NEUTRAL'; then return 'NEUTRAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenNeutral_thenReturnNeutral() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.NEUTRAL, PaperAdventure.asVanilla(Source.NEUTRAL));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code PLAYER}.
   *   <li>Then return {@code PLAYERS}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'PLAYER'; then return 'PLAYERS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenPlayer_thenReturnPlayers() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.PLAYERS, PaperAdventure.asVanilla(Source.PLAYER));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code RECORD}.
   *   <li>Then return {@code RECORDS}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'RECORD'; then return 'RECORDS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenRecord_thenReturnRecords() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.RECORDS, PaperAdventure.asVanilla(Source.RECORD));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code UI}.
   *   <li>Then return {@code UI}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'UI'; then return 'UI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenUi_thenReturnUi() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.UI, PaperAdventure.asVanilla(Source.UI));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code VOICE}.
   *   <li>Then return {@code VOICE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'VOICE'; then return 'VOICE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenVoice_thenReturnVoice() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.VOICE, PaperAdventure.asVanilla(Source.VOICE));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@code WEATHER}.
   *   <li>Then return {@code WEATHER}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanilla(Source) with 'Source'; when 'WEATHER'; then return 'WEATHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanilla(Sound.Source)"})
  void testAsVanillaWithSource_whenWeather_thenReturnWeather() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.WEATHER, PaperAdventure.asVanilla(Source.WEATHER));
  }

  /**
   * Test {@link PaperAdventure#asVanilla(TextColor)} with {@code TextColor}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(TextColor)}
   */
  @Test
  @DisplayName("Test asVanilla(TextColor) with 'TextColor'; given forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatFormatting PaperAdventure.asVanilla(TextColor)"})
  void testAsVanillaWithTextColor_givenFortyTwo_thenReturnNull() {
    // Arrange
    TextColor color = mock(TextColor.class);
    when(color.value()).thenReturn(42);

    // Act
    ChatFormatting actualAsVanillaResult = PaperAdventure.asVanilla(color);

    // Assert
    verify(color).value();
    assertNull(actualAsVanillaResult);
  }

  /**
   * Test {@link PaperAdventure#asVanilla(TextColor)} with {@code TextColor}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return {@code BLACK}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(TextColor)}
   */
  @Test
  @DisplayName("Test asVanilla(TextColor) with 'TextColor'; given zero; then return 'BLACK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatFormatting PaperAdventure.asVanilla(TextColor)"})
  void testAsVanillaWithTextColor_givenZero_thenReturnBlack() {
    // Arrange
    TextColor color = mock(TextColor.class);
    when(color.value()).thenReturn(0);

    // Act
    ChatFormatting actualAsVanillaResult = PaperAdventure.asVanilla(color);

    // Assert
    verify(color).value();
    assertEquals(ChatFormatting.BLACK, actualAsVanillaResult);
  }

  /**
   * Test {@link PaperAdventure#asVanilla(TextColor)} with {@code TextColor}.
   *
   * <ul>
   *   <li>Then throw {@link MatchException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanilla(TextColor)}
   */
  @Test
  @DisplayName("Test asVanilla(TextColor) with 'TextColor'; then throw MatchException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatFormatting PaperAdventure.asVanilla(TextColor)"})
  void testAsVanillaWithTextColor_thenThrowMatchException() {
    // Arrange
    TextColor color = mock(TextColor.class);
    when(color.value())
        .thenThrow(
            new MatchException(
                "0123456789ABCDEF", RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD));

    // Act and Assert
    assertThrows(MatchException.class, () -> PaperAdventure.asVanilla(color));
    verify(color).value();
  }

  /**
   * Test {@link PaperAdventure#asSoundPacket(Sound, double, double, double, long, BiConsumer)} with
   * {@code sound}, {@code x}, {@code y}, {@code z}, {@code seed}, {@code packetConsumer}.
   *
   * <p>Method under test: {@link PaperAdventure#asSoundPacket(Sound, double, double, double, long,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test asSoundPacket(Sound, double, double, double, long, BiConsumer) with 'sound', 'x', 'y', 'z', 'seed', 'packetConsumer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.network.protocol.Packet PaperAdventure.asSoundPacket(Sound, double, double, double, long, BiConsumer)"
  })
  void testAsSoundPacketWithSoundXYZSeedPacketConsumer() {
    // Arrange
    Sound sound = mock(Sound.class);
    when(sound.name())
        .thenThrow(
            new MatchException(
                "0123456789ABCDEF", RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD));

    // Act and Assert
    assertThrows(
        MatchException.class,
        () -> PaperAdventure.asSoundPacket(sound, 2.0d, 3.0d, 10.0d, 42L, mock(BiConsumer.class)));
    verify(sound).name();
  }

  /**
   * Test {@link PaperAdventure#asBinaryTagHolder(CompoundTag)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link CompoundTag#CompoundTag()} String {@code Key} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asBinaryTagHolder(CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test asBinaryTagHolder(CompoundTag); given 'Key'; when CompoundTag() String 'Key' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinaryTagHolder PaperAdventure.asBinaryTagHolder(CompoundTag)"})
  void testAsBinaryTagHolder_givenKey_whenCompoundTagStringKeyIs42() {
    // Arrange
    CompoundTag tag = new CompoundTag();
    tag.putString("Key", "42");

    // Act
    BinaryTagHolder actualAsBinaryTagHolderResult = PaperAdventure.asBinaryTagHolder(tag);

    // Assert
    assertEquals("BinaryTagHolderImpl", actualAsBinaryTagHolderResult.examinableName());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualAsBinaryTagHolderResult.examinableProperties();
    assertTrue(examinablePropertiesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link PaperAdventure#asBinaryTagHolder(CompoundTag)}.
   *
   * <ul>
   *   <li>When {@link CompoundTag#CompoundTag()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asBinaryTagHolder(CompoundTag)}
   */
  @Test
  @DisplayName("Test asBinaryTagHolder(CompoundTag); when CompoundTag()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinaryTagHolder PaperAdventure.asBinaryTagHolder(CompoundTag)"})
  void testAsBinaryTagHolder_whenCompoundTag() {
    // Arrange and Act
    BinaryTagHolder actualAsBinaryTagHolderResult =
        PaperAdventure.asBinaryTagHolder(new CompoundTag());

    // Assert
    assertEquals("BinaryTagHolderImpl", actualAsBinaryTagHolderResult.examinableName());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualAsBinaryTagHolderResult.examinableProperties();
    assertTrue(examinablePropertiesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link PaperAdventure#asBinaryTagHolder(CompoundTag)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asBinaryTagHolder(CompoundTag)}
   */
  @Test
  @DisplayName("Test asBinaryTagHolder(CompoundTag); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinaryTagHolder PaperAdventure.asBinaryTagHolder(CompoundTag)"})
  void testAsBinaryTagHolder_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PaperAdventure.asBinaryTagHolder(null));
  }

  /**
   * Test {@link PaperAdventure#asAdventureKey(ResourceKey)}.
   *
   * <ul>
   *   <li>Then return examinableName is {@code KeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventureKey(ResourceKey)}
   */
  @Test
  @DisplayName("Test asAdventureKey(ResourceKey); then return examinableName is 'KeyImpl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperAdventure.asAdventureKey(ResourceKey)"})
  void testAsAdventureKey_thenReturnExaminableNameIsKeyImpl() {
    // Arrange
    ResourceKey<?> key = mock(ResourceKey.class);
    when(key.location()).thenReturn(ResourceLocation.withDefaultNamespace("argument.id.invalid"));

    // Act
    Key actualAsAdventureKeyResult = PaperAdventure.asAdventureKey(key);

    // Assert
    verify(key).location();
    assertEquals("KeyImpl", actualAsAdventureKeyResult.examinableName());
    assertEquals("argument.id.invalid", actualAsAdventureKeyResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualAsAdventureKeyResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }

  /**
   * Test {@link PaperAdventure#asAdventureKey(ResourceKey)}.
   *
   * <ul>
   *   <li>Then throw {@link MatchException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventureKey(ResourceKey)}
   */
  @Test
  @DisplayName("Test asAdventureKey(ResourceKey); then throw MatchException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperAdventure.asAdventureKey(ResourceKey)"})
  void testAsAdventureKey_thenThrowMatchException() {
    // Arrange
    ResourceKey<?> key = mock(ResourceKey.class);
    when(key.location())
        .thenThrow(
            new MatchException(
                "0123456789ABCDEF", RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD));

    // Act and Assert
    assertThrows(MatchException.class, () -> PaperAdventure.asAdventureKey(key));
    verify(key).location();
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Key)} with {@code key}.
   *
   * <ul>
   *   <li>Then return Path is {@code dialog_click_callback}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Key)}
   */
  @Test
  @DisplayName(
      "Test asVanillaNullable(Key) with 'key'; then return Path is 'dialog_click_callback'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceLocation PaperAdventure.asVanillaNullable(Key)"})
  void testAsVanillaNullableWithKey_thenReturnPathIsDialogClickCallback() {
    // Arrange and Act
    ResourceLocation actualAsVanillaNullableResult =
        PaperAdventure.asVanillaNullable(ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY);

    // Assert
    assertEquals("dialog_click_callback", actualAsVanillaNullableResult.getPath());
    assertEquals("paper", actualAsVanillaNullableResult.getNamespace());
    assertEquals("paper.dialog_click_callback", actualAsVanillaNullableResult.toShortLanguageKey());
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Key)} with {@code key}.
   *
   * <ul>
   *   <li>When {@link ServerBuildInfo#BRAND_PAPER_ID}.
   *   <li>Then return Path is {@code paper}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Key)}
   */
  @Test
  @DisplayName(
      "Test asVanillaNullable(Key) with 'key'; when BRAND_PAPER_ID; then return Path is 'paper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceLocation PaperAdventure.asVanillaNullable(Key)"})
  void testAsVanillaNullableWithKey_whenBrand_paper_id_thenReturnPathIsPaper() {
    // Arrange and Act
    ResourceLocation actualAsVanillaNullableResult =
        PaperAdventure.asVanillaNullable(ServerBuildInfo.BRAND_PAPER_ID);

    // Assert
    assertEquals("paper", actualAsVanillaNullableResult.getPath());
    assertEquals("papermc", actualAsVanillaNullableResult.getNamespace());
    assertEquals("papermc.paper", actualAsVanillaNullableResult.toShortLanguageKey());
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Key)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Key)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Key) with 'key'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceLocation PaperAdventure.asVanillaNullable(Key)"})
  void testAsVanillaNullableWithKey_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PaperAdventure.asVanillaNullable((Key) null));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Key)} with {@code key}.
   *
   * <ul>
   *   <li>When randomKey.
   *   <li>Then return Namespace is {@code bukkit}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Key)}
   */
  @Test
  @DisplayName(
      "Test asVanillaNullable(Key) with 'key'; when randomKey; then return Namespace is 'bukkit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceLocation PaperAdventure.asVanillaNullable(Key)"})
  void testAsVanillaNullableWithKey_whenRandomKey_thenReturnNamespaceIsBukkit() {
    // Arrange, Act and Assert
    assertEquals(
        "bukkit", PaperAdventure.asVanillaNullable(NamespacedKey.randomKey()).getNamespace());
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code AMBIENT}.
   *   <li>Then return {@code AMBIENT}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName(
      "Test asVanillaNullable(Source) with 'source'; when 'AMBIENT'; then return 'AMBIENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenAmbient_thenReturnAmbient() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.AMBIENT, PaperAdventure.asVanillaNullable(Source.AMBIENT));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code BLOCK}.
   *   <li>Then return {@code BLOCKS}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Source) with 'source'; when 'BLOCK'; then return 'BLOCKS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenBlock_thenReturnBlocks() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.BLOCKS, PaperAdventure.asVanillaNullable(Source.BLOCK));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code HOSTILE}.
   *   <li>Then return {@code HOSTILE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName(
      "Test asVanillaNullable(Source) with 'source'; when 'HOSTILE'; then return 'HOSTILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenHostile_thenReturnHostile() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.HOSTILE, PaperAdventure.asVanillaNullable(Source.HOSTILE));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code MASTER}.
   *   <li>Then return {@code MASTER}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Source) with 'source'; when 'MASTER'; then return 'MASTER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenMaster_thenReturnMaster() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.MASTER, PaperAdventure.asVanillaNullable(Source.MASTER));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code MUSIC}.
   *   <li>Then return {@code MUSIC}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Source) with 'source'; when 'MUSIC'; then return 'MUSIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenMusic_thenReturnMusic() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.MUSIC, PaperAdventure.asVanillaNullable(Source.MUSIC));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code NEUTRAL}.
   *   <li>Then return {@code NEUTRAL}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName(
      "Test asVanillaNullable(Source) with 'source'; when 'NEUTRAL'; then return 'NEUTRAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenNeutral_thenReturnNeutral() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.NEUTRAL, PaperAdventure.asVanillaNullable(Source.NEUTRAL));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Source) with 'source'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PaperAdventure.asVanillaNullable((Source) null));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code PLAYER}.
   *   <li>Then return {@code PLAYERS}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Source) with 'source'; when 'PLAYER'; then return 'PLAYERS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenPlayer_thenReturnPlayers() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.PLAYERS, PaperAdventure.asVanillaNullable(Source.PLAYER));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code RECORD}.
   *   <li>Then return {@code RECORDS}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Source) with 'source'; when 'RECORD'; then return 'RECORDS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenRecord_thenReturnRecords() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.RECORDS, PaperAdventure.asVanillaNullable(Source.RECORD));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code UI}.
   *   <li>Then return {@code UI}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Source) with 'source'; when 'UI'; then return 'UI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenUi_thenReturnUi() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.UI, PaperAdventure.asVanillaNullable(Source.UI));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code VOICE}.
   *   <li>Then return {@code VOICE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName("Test asVanillaNullable(Source) with 'source'; when 'VOICE'; then return 'VOICE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenVoice_thenReturnVoice() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.VOICE, PaperAdventure.asVanillaNullable(Source.VOICE));
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullable(Source)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code WEATHER}.
   *   <li>Then return {@code WEATHER}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullable(Sound.Source)}
   */
  @Test
  @DisplayName(
      "Test asVanillaNullable(Source) with 'source'; when 'WEATHER'; then return 'WEATHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoundSource PaperAdventure.asVanillaNullable(Sound.Source)"})
  void testAsVanillaNullableWithSource_whenWeather_thenReturnWeather() {
    // Arrange, Act and Assert
    assertEquals(SoundSource.WEATHER, PaperAdventure.asVanillaNullable(Source.WEATHER));
  }

  /**
   * Test {@link PaperAdventure#asAdventureFromJson(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventureFromJson(List)}
   */
  @Test
  @DisplayName(
      "Test asAdventureFromJson(List); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList PaperAdventure.asAdventureFromJson(List)"})
  void testAsAdventureFromJson_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<String> jsonStrings = new ArrayList<>();
    jsonStrings.add("42");
    jsonStrings.add("foo");

    // Act
    ArrayList<Component> actualAsAdventureFromJsonResult =
        PaperAdventure.asAdventureFromJson(jsonStrings);

    // Assert
    assertEquals(2, actualAsAdventureFromJsonResult.size());
    Component getResult = actualAsAdventureFromJsonResult.get(1);
    assertNull(getResult.insertion());
    assertNull(getResult.font());
    assertNull(getResult.color());
    assertFalse(getResult.hasStyling());
    Component actualCompactResult = getResult.compact();
    assertEquals(getResult, actualCompactResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventureFromJson(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventureFromJson(List)}
   */
  @Test
  @DisplayName(
      "Test asAdventureFromJson(List); given 'foo'; when ArrayList() add 'foo'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList PaperAdventure.asAdventureFromJson(List)"})
  void testAsAdventureFromJson_givenFoo_whenArrayListAddFoo_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<String> jsonStrings = new ArrayList<>();
    jsonStrings.add("foo");

    // Act
    ArrayList<Component> actualAsAdventureFromJsonResult =
        PaperAdventure.asAdventureFromJson(jsonStrings);

    // Assert
    assertEquals(1, actualAsAdventureFromJsonResult.size());
    Component getResult = actualAsAdventureFromJsonResult.get(0);
    assertNull(getResult.insertion());
    assertNull(getResult.font());
    assertNull(getResult.color());
    Map<TextDecoration, State> decorationsResult = getResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(getResult.hasStyling());
    Component actualCompactResult = getResult.compact();
    assertEquals(getResult, actualCompactResult);
  }

  /**
   * Test {@link PaperAdventure#asAdventureFromJson(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asAdventureFromJson(List)}
   */
  @Test
  @DisplayName("Test asAdventureFromJson(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList PaperAdventure.asAdventureFromJson(List)"})
  void testAsAdventureFromJson_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    ArrayList<Component> actualAsAdventureFromJsonResult =
        PaperAdventure.asAdventureFromJson(new ArrayList<>());

    // Assert
    assertTrue(actualAsAdventureFromJsonResult.isEmpty());
  }

  /**
   * Test {@link PaperAdventure#asJson(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asJson(List)}
   */
  @Test
  @DisplayName("Test asJson(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperAdventure.asJson(List)"})
  void testAsJson_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualAsJsonResult = PaperAdventure.asJson(new ArrayList<>());

    // Assert
    assertTrue(actualAsJsonResult.isEmpty());
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullToEmpty(Component)}.
   *
   * <ul>
   *   <li>When {@link Component}.
   *   <li>Then return {@link AdventureComponent}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullToEmpty(Component)}
   */
  @Test
  @DisplayName(
      "Test asVanillaNullToEmpty(Component); when Component; then return AdventureComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.network.chat.Component PaperAdventure.asVanillaNullToEmpty(Component)"
  })
  void testAsVanillaNullToEmpty_whenComponent_thenReturnAdventureComponent() {
    // Arrange and Act
    net.minecraft.network.chat.Component actualAsVanillaNullToEmptyResult =
        PaperAdventure.asVanillaNullToEmpty(mock(Component.class));

    // Assert
    assertTrue(actualAsVanillaNullToEmptyResult instanceof AdventureComponent);
    Component expectedAdventure$componentResult =
        ((AdventureComponent) actualAsVanillaNullToEmptyResult).adventure;
    assertSame(
        expectedAdventure$componentResult,
        ((AdventureComponent) actualAsVanillaNullToEmptyResult).adventure$component());
  }

  /**
   * Test {@link PaperAdventure#asVanillaNullToEmpty(Component)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link MutableComponent}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asVanillaNullToEmpty(Component)}
   */
  @Test
  @DisplayName("Test asVanillaNullToEmpty(Component); when 'null'; then return MutableComponent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.network.chat.Component PaperAdventure.asVanillaNullToEmpty(Component)"
  })
  void testAsVanillaNullToEmpty_whenNull_thenReturnMutableComponent() {
    // Arrange and Act
    net.minecraft.network.chat.Component actualAsVanillaNullToEmptyResult =
        PaperAdventure.asVanillaNullToEmpty(null);

    // Assert
    assertTrue(actualAsVanillaNullToEmptyResult instanceof MutableComponent);
    assertTrue(actualAsVanillaNullToEmptyResult.getSiblings().isEmpty());
    assertEquals("", actualAsVanillaNullToEmptyResult.getString());
    net.minecraft.network.chat.Style style = actualAsVanillaNullToEmptyResult.getStyle();
    assertNull(style.getClickEvent());
    assertNull(style.getColor());
    assertNull(style.getHoverEvent());
    assertNull(style.getInsertion());
    assertNull(style.getShadowColor());
    assertFalse(style.isBold());
    assertTrue(style.isEmpty());
    assertFalse(style.isItalic());
    assertFalse(style.isObfuscated());
    assertFalse(style.isStrikethrough());
    assertFalse(style.isUnderlined());
    Iterator<net.minecraft.network.chat.Component> iteratorResult =
        actualAsVanillaNullToEmptyResult.iterator();
    net.minecraft.network.chat.Component actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(actualAsVanillaNullToEmptyResult, actualNextResult);
    assertTrue(actualAsVanillaNullToEmptyResult.toFlatList().isEmpty());
  }

  /**
   * Test {@link PaperAdventure#asJsonString(Component, Locale)}.
   *
   * <p>Method under test: {@link PaperAdventure#asJsonString(Component, Locale)}
   */
  @Test
  @DisplayName("Test asJsonString(Component, Locale)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperAdventure.asJsonString(Component, Locale)"})
  void testAsJsonString() {
    // Arrange
    Component component = mock(Component.class);
    when(component.hasStyling())
        .thenThrow(
            new MatchException(
                "0123456789ABCDEF", RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD));

    // Act and Assert
    assertThrows(
        MatchException.class, () -> PaperAdventure.asJsonString(component, Locale.getDefault()));
    verify(component).hasStyling();
  }

  /**
   * Test {@link PaperAdventure#asJsonString(Component, Locale)}.
   *
   * <ul>
   *   <li>Then calls {@link Component#children()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asJsonString(Component, Locale)}
   */
  @Test
  @DisplayName("Test asJsonString(Component, Locale); then calls children()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperAdventure.asJsonString(Component, Locale)"})
  void testAsJsonString_thenCallsChildren() {
    // Arrange
    Component component = mock(Component.class);
    when(component.hasStyling())
        .thenThrow(
            new MatchException(
                "0123456789ABCDEF", RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD));

    ArrayList<Component> componentList = new ArrayList<>();
    componentList.add(component);

    ShadowColor shadowColor = mock(ShadowColor.class);
    when(shadowColor.value()).thenReturn(42);

    TextColor textColor = mock(TextColor.class);
    when(textColor.value()).thenReturn(42);

    Style style = mock(Style.class);
    when(style.insertion()).thenReturn("Insertion");
    when(style.font()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);
    when(style.clickEvent()).thenReturn(ClickEvent.changePage(1));
    Mockito.<HoverEvent<?>>when(style.hoverEvent()).thenReturn(null);
    when(style.shadowColor()).thenReturn(shadowColor);
    when(style.color()).thenReturn(textColor);
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component name = mock(Component.class);
    when(name.style()).thenReturn(style);
    when(name.children()).thenReturn(componentList);
    when(name.hasStyling()).thenReturn(true);
    ShowEntity entity = ShowEntity.of(ServerBuildInfo.BRAND_PAPER_ID, Util.NIL_UUID, name);
    HoverEvent<ShowEntity> showEntityResult = HoverEvent.showEntity(entity);

    ShadowColor shadowColor2 = mock(ShadowColor.class);
    when(shadowColor2.value()).thenReturn(42);

    TextColor textColor2 = mock(TextColor.class);
    when(textColor2.value()).thenReturn(42);

    Style style2 = mock(Style.class);
    when(style2.insertion()).thenReturn("Insertion");
    when(style2.clickEvent()).thenReturn(ClickEvent.changePage(1));
    Mockito.<HoverEvent<?>>when(style2.hoverEvent()).thenReturn(showEntityResult);
    when(style2.shadowColor()).thenReturn(shadowColor2);
    when(style2.color()).thenReturn(textColor2);
    when(style2.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component component2 = mock(Component.class);
    when(component2.style()).thenReturn(style2);
    when(component2.hasStyling()).thenReturn(true);

    // Act and Assert
    assertThrows(
        MatchException.class, () -> PaperAdventure.asJsonString(component2, Locale.getDefault()));
    verify(name, atLeast(1)).children();
    verify(component2).hasStyling();
    verify(name).hasStyling();
    verify(component).hasStyling();
    verify(component2).style();
    verify(name).style();
    verify(shadowColor).value();
    verify(shadowColor2).value();
    verify(style2).clickEvent();
    verify(style).clickEvent();
    verify(style2).color();
    verify(style).color();
    verify(style2, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    verify(style).font();
    verify(style2).hoverEvent();
    verify(style).hoverEvent();
    verify(style2).insertion();
    verify(style).insertion();
    verify(style2).shadowColor();
    verify(style).shadowColor();
    verify(textColor).value();
    verify(textColor2).value();
  }

  /**
   * Test {@link PaperAdventure#asJsonString(Component, Locale)}.
   *
   * <ul>
   *   <li>Then calls {@link Component#style()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asJsonString(Component, Locale)}
   */
  @Test
  @DisplayName("Test asJsonString(Component, Locale); then calls style()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperAdventure.asJsonString(Component, Locale)"})
  void testAsJsonString_thenCallsStyle() {
    // Arrange
    Component name = mock(Component.class);
    when(name.hasStyling())
        .thenThrow(
            new MatchException(
                "0123456789ABCDEF", RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD));
    ShowEntity entity = ShowEntity.of(ServerBuildInfo.BRAND_PAPER_ID, Util.NIL_UUID, name);
    HoverEvent<ShowEntity> showEntityResult = HoverEvent.showEntity(entity);

    ShadowColor shadowColor = mock(ShadowColor.class);
    when(shadowColor.value()).thenReturn(42);

    TextColor textColor = mock(TextColor.class);
    when(textColor.value()).thenReturn(42);

    Style style = mock(Style.class);
    when(style.insertion()).thenReturn("Insertion");
    when(style.clickEvent()).thenReturn(ClickEvent.changePage(1));
    Mockito.<HoverEvent<?>>when(style.hoverEvent()).thenReturn(showEntityResult);
    when(style.shadowColor()).thenReturn(shadowColor);
    when(style.color()).thenReturn(textColor);
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component component = mock(Component.class);
    when(component.style()).thenReturn(style);
    when(component.hasStyling()).thenReturn(true);

    // Act and Assert
    assertThrows(
        MatchException.class, () -> PaperAdventure.asJsonString(component, Locale.getDefault()));
    verify(component).hasStyling();
    verify(name).hasStyling();
    verify(component).style();
    verify(shadowColor).value();
    verify(style).clickEvent();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    verify(style).hoverEvent();
    verify(style).insertion();
    verify(style).shadowColor();
    verify(textColor).value();
  }

  /**
   * Test {@link PaperAdventure#hasAnyTranslations()}.
   *
   * <p>Method under test: {@link PaperAdventure#hasAnyTranslations()}
   */
  @Test
  @DisplayName("Test hasAnyTranslations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperAdventure.hasAnyTranslations()"})
  void testHasAnyTranslations() {
    // Arrange, Act and Assert
    assertFalse(PaperAdventure.hasAnyTranslations());
  }

  /**
   * Test {@link PaperAdventure#asPlain(Component, Locale)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asPlain(Component, Locale)}
   */
  @Test
  @DisplayName("Test asPlain(Component, Locale); given ArrayList(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperAdventure.asPlain(Component, Locale)"})
  void testAsPlain_givenArrayList_thenReturnEmptyString() {
    // Arrange
    Component component = mock(Component.class);
    when(component.children()).thenReturn(new ArrayList<>());
    when(component.style()).thenReturn(mock(Style.class));

    // Act
    String actualAsPlainResult = PaperAdventure.asPlain(component, Locale.getDefault());

    // Assert
    verify(component).children();
    verify(component).style();
    assertEquals("", actualAsPlainResult);
  }

  /**
   * Test {@link PaperAdventure#asPlain(Component, Locale)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdventure#asPlain(Component, Locale)}
   */
  @Test
  @DisplayName(
      "Test asPlain(Component, Locale); given ArrayList(); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperAdventure.asPlain(Component, Locale)"})
  void testAsPlain_givenArrayList_whenNull_thenReturnEmptyString() {
    // Arrange
    Component component = mock(Component.class);
    when(component.children()).thenReturn(new ArrayList<>());
    when(component.style()).thenReturn(mock(Style.class));

    // Act
    String actualAsPlainResult = PaperAdventure.asPlain(component, null);

    // Assert
    verify(component).children();
    verify(component).style();
    assertEquals("", actualAsPlainResult);
  }
}
