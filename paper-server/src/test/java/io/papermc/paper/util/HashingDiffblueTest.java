package io.papermc.paper.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HashingDiffblueTest {
  /**
   * Test {@link Hashing#sha256(Path)} with {@code file}.
   *
   * <ul>
   *   <li>When {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Hashing#sha256(Path)}
   */
  @Test
  @DisplayName(
      "Test sha256(Path) with 'file'; when PROFILING_RESULTS_DIR; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Hashing.sha256(Path)"})
  void testSha256WithFile_whenProfiling_results_dir_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Hashing.sha256(MetricsPersister.PROFILING_RESULTS_DIR));
  }

  /**
   * Test {@link Hashing#sha256(InputStream)} with {@code stream}.
   *
   * <p>Method under test: {@link Hashing#sha256(InputStream)}
   */
  @Test
  @DisplayName("Test sha256(InputStream) with 'stream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Hashing.sha256(InputStream)"})
  void testSha256WithStream() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "5C5B6209D867A8C020EA0D75A22FB3CCF66CB4D88A4B53E001E1398F1A60BADC", Hashing.sha256(stream));
    int actualReadResult = stream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link Hashing#sha256(InputStream)} with {@code stream}.
   *
   * <p>Method under test: {@link Hashing#sha256(InputStream)}
   */
  @Test
  @DisplayName("Test sha256(InputStream) with 'stream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Hashing.sha256(InputStream)"})
  void testSha256WithStream2() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "B3B8E9BB377EA61EEB38B29303CA700C2ABE0289B83F742F1B4AA1EE3FEC5938", Hashing.sha256(stream));
    int actualReadResult = stream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link Hashing#sha256(InputStream)} with {@code stream}.
   *
   * <p>Method under test: {@link Hashing#sha256(InputStream)}
   */
  @Test
  @DisplayName("Test sha256(InputStream) with 'stream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Hashing.sha256(InputStream)"})
  void testSha256WithStream3() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[] {});

    // Act and Assert
    assertEquals(
        "E3B0C44298FC1C149AFBF4C8996FB92427AE41E4649B934CA495991B7852B855", Hashing.sha256(stream));
    int actualReadResult = stream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }
}
