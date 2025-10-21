package io.papermc.paper.world.damagesource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FallLocationTypeImplDiffblueTest {
  /**
   * Test {@link FallLocationTypeImpl#translationKey()}.
   *
   * <p>Method under test: {@link FallLocationTypeImpl#translationKey()}
   */
  @Test
  @DisplayName("Test translationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FallLocationTypeImpl.translationKey()"})
  void testTranslationKey() {
    // Arrange, Act and Assert
    assertEquals("death.fell.accident.42", new FallLocationTypeImpl("42").translationKey());
  }
}
