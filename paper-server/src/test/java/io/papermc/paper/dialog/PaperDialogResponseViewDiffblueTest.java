package io.papermc.paper.dialog;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDialogResponseViewDiffblueTest {
  /**
   * Test {@link PaperDialogResponseView#createUnvalidatedResponse(CompoundTag)}.
   *
   * <p>Method under test: {@link PaperDialogResponseView#createUnvalidatedResponse(CompoundTag)}
   */
  @Test
  @DisplayName("Test createUnvalidatedResponse(CompoundTag)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.dialog.DialogResponseView PaperDialogResponseView.createUnvalidatedResponse(CompoundTag)"
  })
  void testCreateUnvalidatedResponse() {
    // Arrange, Act and Assert
    assertTrue(
        PaperDialogResponseView.createUnvalidatedResponse(new CompoundTag())
            instanceof PaperDialogResponseView);
  }
}
