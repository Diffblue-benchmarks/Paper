package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.item.component.OminousBottleAmplifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperOminousBottleAmplifierDiffblueTest {
  /**
   * Test {@link PaperOminousBottleAmplifier#getHandle()}.
   *
   * <p>Method under test: {@link PaperOminousBottleAmplifier#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OminousBottleAmplifier PaperOminousBottleAmplifier.getHandle()"})
  void testGetHandle() {
    // Arrange
    OminousBottleAmplifier impl = new OminousBottleAmplifier(42);

    // Act
    OminousBottleAmplifier actualHandle = new PaperOminousBottleAmplifier(impl).getHandle();

    // Assert
    assertEquals(42, actualHandle.value());
    assertSame(impl, actualHandle);
  }

  /**
   * Test {@link PaperOminousBottleAmplifier#amplifier()}.
   *
   * <ul>
   *   <li>Given {@link OminousBottleAmplifier#OminousBottleAmplifier(int)} with value is forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link PaperOminousBottleAmplifier#amplifier()}
   */
  @Test
  @DisplayName(
      "Test amplifier(); given OminousBottleAmplifier(int) with value is forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperOminousBottleAmplifier.amplifier()"})
  void testAmplifier_givenOminousBottleAmplifierWithValueIsFortyTwo_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new PaperOminousBottleAmplifier(new OminousBottleAmplifier(42)).amplifier());
  }
}
