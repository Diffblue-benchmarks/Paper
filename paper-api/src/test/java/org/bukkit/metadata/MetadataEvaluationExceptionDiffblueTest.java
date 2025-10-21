package org.bukkit.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataEvaluationExceptionDiffblueTest {
  /**
   * Test {@link MetadataEvaluationException#MetadataEvaluationException(Throwable)}.
   *
   * <p>Method under test: {@link
   * MetadataEvaluationException#MetadataEvaluationException(Throwable)}
   */
  @Test
  @DisplayName("Test new MetadataEvaluationException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataEvaluationException.<init>(Throwable)"})
  void testNewMetadataEvaluationException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    MetadataEvaluationException actualMetadataEvaluationException =
        new MetadataEvaluationException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualMetadataEvaluationException.getMessage());
    assertEquals(0, actualMetadataEvaluationException.getSuppressed().length);
    assertSame(cause, actualMetadataEvaluationException.getCause());
  }
}
