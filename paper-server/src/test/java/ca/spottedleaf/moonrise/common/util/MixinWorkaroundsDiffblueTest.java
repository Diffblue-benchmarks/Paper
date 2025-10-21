package ca.spottedleaf.moonrise.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MixinWorkaroundsDiffblueTest {
  /**
   * Test {@link MixinWorkarounds#clone(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link MixinWorkarounds#clone(byte[])}
   */
  @Test
  @DisplayName("Test clone(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MixinWorkarounds.clone(byte[])"})
  void testCloneWithByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), MixinWorkarounds.clone("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MixinWorkarounds#clone(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link MixinWorkarounds#clone(long[])}
   */
  @Test
  @DisplayName("Test clone(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] MixinWorkarounds.clone(long[])"})
  void testCloneWithLong() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new long[] {42L, 1L, 42L, 1L}, MixinWorkarounds.clone(new long[] {42L, 1L, 42L, 1L}));
  }
}
