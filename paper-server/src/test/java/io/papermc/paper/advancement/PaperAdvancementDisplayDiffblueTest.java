package io.papermc.paper.advancement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.advancement.AdvancementDisplay.Frame;
import net.minecraft.advancements.AdvancementType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperAdvancementDisplayDiffblueTest {
  /**
   * Test {@link PaperAdvancementDisplay#asPaperFrame(AdvancementType)}.
   *
   * <ul>
   *   <li>When {@code CHALLENGE}.
   *   <li>Then return {@code CHALLENGE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdvancementDisplay#asPaperFrame(AdvancementType)}
   */
  @Test
  @DisplayName("Test asPaperFrame(AdvancementType); when 'CHALLENGE'; then return 'CHALLENGE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Frame PaperAdvancementDisplay.asPaperFrame(AdvancementType)"})
  void testAsPaperFrame_whenChallenge_thenReturnChallenge() {
    // Arrange, Act and Assert
    assertEquals(Frame.CHALLENGE, PaperAdvancementDisplay.asPaperFrame(AdvancementType.CHALLENGE));
  }

  /**
   * Test {@link PaperAdvancementDisplay#asPaperFrame(AdvancementType)}.
   *
   * <ul>
   *   <li>When {@code GOAL}.
   *   <li>Then return {@code GOAL}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdvancementDisplay#asPaperFrame(AdvancementType)}
   */
  @Test
  @DisplayName("Test asPaperFrame(AdvancementType); when 'GOAL'; then return 'GOAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Frame PaperAdvancementDisplay.asPaperFrame(AdvancementType)"})
  void testAsPaperFrame_whenGoal_thenReturnGoal() {
    // Arrange, Act and Assert
    assertEquals(Frame.GOAL, PaperAdvancementDisplay.asPaperFrame(AdvancementType.GOAL));
  }

  /**
   * Test {@link PaperAdvancementDisplay#asPaperFrame(AdvancementType)}.
   *
   * <ul>
   *   <li>When {@code TASK}.
   *   <li>Then return {@code TASK}.
   * </ul>
   *
   * <p>Method under test: {@link PaperAdvancementDisplay#asPaperFrame(AdvancementType)}
   */
  @Test
  @DisplayName("Test asPaperFrame(AdvancementType); when 'TASK'; then return 'TASK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Frame PaperAdvancementDisplay.asPaperFrame(AdvancementType)"})
  void testAsPaperFrame_whenTask_thenReturnTask() {
    // Arrange, Act and Assert
    assertEquals(Frame.TASK, PaperAdvancementDisplay.asPaperFrame(AdvancementType.TASK));
  }
}
