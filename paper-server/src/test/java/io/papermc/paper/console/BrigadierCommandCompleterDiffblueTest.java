package io.papermc.paper.console;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.console.BrigadierCommandCompleter.PaperCandidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BrigadierCommandCompleterDiffblueTest {
  /**
   * Test PaperCandidate {@link PaperCandidate#PaperCandidate(String, String, String, String,
   * String, String, boolean)}.
   *
   * <p>Method under test: {@link PaperCandidate#PaperCandidate(String, String, String, String,
   * String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test PaperCandidate new PaperCandidate(String, String, String, String, String, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperCandidate.<init>(String, String, String, String, String, String, boolean)"
  })
  void testPaperCandidateNewPaperCandidate() {
    // Arrange and Act
    PaperCandidate actualPaperCandidate =
        new PaperCandidate("42", "Display", "Group", "Descr", "Suffix", "Key", true);

    // Assert
    assertEquals("42", actualPaperCandidate.value());
    assertEquals("Descr", actualPaperCandidate.descr());
    assertEquals("Display", actualPaperCandidate.displ());
    assertEquals("Group", actualPaperCandidate.group());
    assertEquals("Key", actualPaperCandidate.key());
    assertEquals("Suffix", actualPaperCandidate.suffix());
    assertTrue(actualPaperCandidate.complete());
  }
}
