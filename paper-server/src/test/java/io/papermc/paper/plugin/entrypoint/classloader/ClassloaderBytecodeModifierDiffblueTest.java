package io.papermc.paper.plugin.entrypoint.classloader;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassloaderBytecodeModifierDiffblueTest {
  /**
   * Test {@link ClassloaderBytecodeModifier#bytecodeModifier()}.
   *
   * <ul>
   *   <li>Then return {@link PaperClassloaderBytecodeModifier}.
   * </ul>
   *
   * <p>Method under test: {@link ClassloaderBytecodeModifier#bytecodeModifier()}
   */
  @Test
  @DisplayName("Test bytecodeModifier(); then return PaperClassloaderBytecodeModifier")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassloaderBytecodeModifier ClassloaderBytecodeModifier.bytecodeModifier()"})
  void testBytecodeModifier_thenReturnPaperClassloaderBytecodeModifier() {
    // Arrange, Act and Assert
    assertTrue(
        ClassloaderBytecodeModifier.bytecodeModifier() instanceof PaperClassloaderBytecodeModifier);
  }
}
