package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.sound.Sound.Source;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SoundCategoryDiffblueTest {
  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code AMBIENT}.
   *   <li>Then return {@code AMBIENT}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'AMBIENT'; then return 'AMBIENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenAmbient_thenReturnAmbient() {
    // Arrange, Act and Assert
    assertEquals(Source.AMBIENT, SoundCategory.AMBIENT.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code BLOCKS}.
   *   <li>Then return {@code BLOCK}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'BLOCKS'; then return 'BLOCK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenBlocks_thenReturnBlock() {
    // Arrange, Act and Assert
    assertEquals(Source.BLOCK, SoundCategory.BLOCKS.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code HOSTILE}.
   *   <li>Then return {@code HOSTILE}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'HOSTILE'; then return 'HOSTILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenHostile_thenReturnHostile() {
    // Arrange, Act and Assert
    assertEquals(Source.HOSTILE, SoundCategory.HOSTILE.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code MASTER}.
   *   <li>Then return {@code MASTER}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'MASTER'; then return 'MASTER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenMaster_thenReturnMaster() {
    // Arrange, Act and Assert
    assertEquals(Source.MASTER, SoundCategory.MASTER.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code MUSIC}.
   *   <li>Then return {@code MUSIC}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'MUSIC'; then return 'MUSIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenMusic_thenReturnMusic() {
    // Arrange, Act and Assert
    assertEquals(Source.MUSIC, SoundCategory.MUSIC.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code NEUTRAL}.
   *   <li>Then return {@code NEUTRAL}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'NEUTRAL'; then return 'NEUTRAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenNeutral_thenReturnNeutral() {
    // Arrange, Act and Assert
    assertEquals(Source.NEUTRAL, SoundCategory.NEUTRAL.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code PLAYERS}.
   *   <li>Then return {@code PLAYER}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'PLAYERS'; then return 'PLAYER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenPlayers_thenReturnPlayer() {
    // Arrange, Act and Assert
    assertEquals(Source.PLAYER, SoundCategory.PLAYERS.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code RECORDS}.
   *   <li>Then return {@code RECORD}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'RECORDS'; then return 'RECORD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenRecords_thenReturnRecord() {
    // Arrange, Act and Assert
    assertEquals(Source.RECORD, SoundCategory.RECORDS.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code UI}.
   *   <li>Then return {@code UI}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'UI'; then return 'UI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenUi_thenReturnUi() {
    // Arrange, Act and Assert
    assertEquals(Source.UI, SoundCategory.UI.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code VOICE}.
   *   <li>Then return {@code VOICE}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'VOICE'; then return 'VOICE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenVoice_thenReturnVoice() {
    // Arrange, Act and Assert
    assertEquals(Source.VOICE, SoundCategory.VOICE.soundSource());
  }

  /**
   * Test {@link SoundCategory#soundSource()}.
   *
   * <ul>
   *   <li>Given {@code WEATHER}.
   *   <li>Then return {@code WEATHER}.
   * </ul>
   *
   * <p>Method under test: {@link SoundCategory#soundSource()}
   */
  @Test
  @DisplayName("Test soundSource(); given 'WEATHER'; then return 'WEATHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sound.Source SoundCategory.soundSource()"})
  void testSoundSource_givenWeather_thenReturnWeather() {
    // Arrange, Act and Assert
    assertEquals(Source.WEATHER, SoundCategory.WEATHER.soundSource());
  }
}
