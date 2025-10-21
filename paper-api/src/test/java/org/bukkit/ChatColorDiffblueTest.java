package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChatColorDiffblueTest {
  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code AQUA}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#AQUA}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'AQUA'; then return AQUA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenAqua_thenReturnAqua() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.AQUA, ChatColor.AQUA.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code BLACK}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#BLACK}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'BLACK'; then return BLACK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenBlack_thenReturnBlack() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.BLACK, ChatColor.BLACK.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code BLUE}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#BLUE}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'BLUE'; then return BLUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenBlue_thenReturnBlue() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.BLUE, ChatColor.BLUE.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code BOLD}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#BOLD}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'BOLD'; then return BOLD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenBold_thenReturnBold() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.BOLD, ChatColor.BOLD.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code DARK_AQUA}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#DARK_AQUA}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'DARK_AQUA'; then return DARK_AQUA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenDarkAqua_thenReturnDark_aqua() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.DARK_AQUA, ChatColor.DARK_AQUA.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code DARK_BLUE}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#DARK_BLUE}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'DARK_BLUE'; then return DARK_BLUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenDarkBlue_thenReturnDark_blue() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.DARK_BLUE, ChatColor.DARK_BLUE.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code DARK_GRAY}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#DARK_GRAY}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'DARK_GRAY'; then return DARK_GRAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenDarkGray_thenReturnDark_gray() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.DARK_GRAY, ChatColor.DARK_GRAY.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code DARK_GREEN}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#DARK_GREEN}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'DARK_GREEN'; then return DARK_GREEN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenDarkGreen_thenReturnDark_green() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.DARK_GREEN, ChatColor.DARK_GREEN.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code DARK_PURPLE}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#DARK_PURPLE}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'DARK_PURPLE'; then return DARK_PURPLE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenDarkPurple_thenReturnDark_purple() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.DARK_PURPLE, ChatColor.DARK_PURPLE.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code DARK_RED}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#DARK_RED}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'DARK_RED'; then return DARK_RED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenDarkRed_thenReturnDark_red() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.DARK_RED, ChatColor.DARK_RED.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code GOLD}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#GOLD}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'GOLD'; then return GOLD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenGold_thenReturnGold() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.GOLD, ChatColor.GOLD.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code GRAY}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#GRAY}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'GRAY'; then return GRAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenGray_thenReturnGray() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.GRAY, ChatColor.GRAY.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code GREEN}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#GREEN}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'GREEN'; then return GREEN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenGreen_thenReturnGreen() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.GREEN, ChatColor.GREEN.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code LIGHT_PURPLE}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#LIGHT_PURPLE}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'LIGHT_PURPLE'; then return LIGHT_PURPLE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenLightPurple_thenReturnLight_purple() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.LIGHT_PURPLE, ChatColor.LIGHT_PURPLE.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code MAGIC}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#MAGIC}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'MAGIC'; then return MAGIC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenMagic_thenReturnMagic() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.MAGIC, ChatColor.MAGIC.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code RED}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#RED}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'RED'; then return RED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenRed_thenReturnRed() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.RED, ChatColor.RED.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code STRIKETHROUGH}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#STRIKETHROUGH}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'STRIKETHROUGH'; then return STRIKETHROUGH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenStrikethrough_thenReturnStrikethrough() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.STRIKETHROUGH, ChatColor.STRIKETHROUGH.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code UNDERLINE}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#UNDERLINE}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'UNDERLINE'; then return UNDERLINE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenUnderline_thenReturnUnderline() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.UNDERLINE, ChatColor.UNDERLINE.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code WHITE}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#WHITE}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'WHITE'; then return WHITE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenWhite_thenReturnWhite() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.WHITE, ChatColor.WHITE.asBungee());
  }

  /**
   * Test {@link ChatColor#asBungee()}.
   *
   * <ul>
   *   <li>Given {@code YELLOW}.
   *   <li>Then return {@link net.md_5.bungee.api.ChatColor#YELLOW}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#asBungee()}
   */
  @Test
  @DisplayName("Test asBungee(); given 'YELLOW'; then return YELLOW")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.md_5.bungee.api.ChatColor ChatColor.asBungee()"})
  void testAsBungee_givenYellow_thenReturnYellow() {
    // Arrange, Act and Assert
    assertSame(net.md_5.bungee.api.ChatColor.YELLOW, ChatColor.YELLOW.asBungee());
  }

  /**
   * Test {@link ChatColor#isColor()}.
   *
   * <ul>
   *   <li>Given {@code BLACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#isColor()}
   */
  @Test
  @DisplayName("Test isColor(); given 'BLACK'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChatColor.isColor()"})
  void testIsColor_givenBlack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ChatColor.BLACK.isColor());
  }

  /**
   * Test {@link ChatColor#isColor()}.
   *
   * <ul>
   *   <li>Given {@code MAGIC}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#isColor()}
   */
  @Test
  @DisplayName("Test isColor(); given 'MAGIC'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChatColor.isColor()"})
  void testIsColor_givenMagic_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ChatColor.MAGIC.isColor());
  }

  /**
   * Test {@link ChatColor#isColor()}.
   *
   * <ul>
   *   <li>Given {@link ChatColor#RESET}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChatColor#isColor()}
   */
  @Test
  @DisplayName("Test isColor(); given RESET; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChatColor.isColor()"})
  void testIsColor_givenReset_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ChatColor.RESET.isColor());
  }

  /**
   * Test {@link ChatColor#getByChar(char)} with {@code char}.
   *
   * <p>Method under test: {@link ChatColor#getByChar(char)}
   */
  @Test
  @DisplayName("Test getByChar(char) with 'char'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatColor ChatColor.getByChar(char)"})
  void testGetByCharWithChar() {
    // Arrange, Act and Assert
    assertNull(ChatColor.getByChar('A'));
  }
}
