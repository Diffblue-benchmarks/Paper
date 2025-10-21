package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.destroystokyo.paper.ClientOption.ChatVisibility;
import com.destroystokyo.paper.ClientOption.ParticleVisibility;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClientOptionDiffblueTest {
  /**
   * Test ChatVisibility {@link ChatVisibility#translationKey()}.
   *
   * <ul>
   *   <li>Given {@code FULL}.
   *   <li>Then return {@code options.chat.visibility.full}.
   * </ul>
   *
   * <p>Method under test: {@link ChatVisibility#translationKey()}
   */
  @Test
  @DisplayName(
      "Test ChatVisibility translationKey(); given 'FULL'; then return 'options.chat.visibility.full'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ChatVisibility.translationKey()"})
  void testChatVisibilityTranslationKey_givenFull_thenReturnOptionsChatVisibilityFull() {
    // Arrange, Act and Assert
    assertEquals("options.chat.visibility.full", ChatVisibility.FULL.translationKey());
  }

  /**
   * Test ChatVisibility {@link ChatVisibility#translationKey()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ChatVisibility#translationKey()}
   */
  @Test
  @DisplayName("Test ChatVisibility translationKey(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ChatVisibility.translationKey()"})
  void testChatVisibilityTranslationKey_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> ChatVisibility.UNKNOWN.translationKey());
  }

  /**
   * Test ParticleVisibility {@link ParticleVisibility#translationKey()}.
   *
   * <p>Method under test: {@link ParticleVisibility#translationKey()}
   */
  @Test
  @DisplayName("Test ParticleVisibility translationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ParticleVisibility.translationKey()"})
  void testParticleVisibilityTranslationKey() {
    // Arrange, Act and Assert
    assertEquals("options.particles.all", ParticleVisibility.ALL.translationKey());
  }
}
