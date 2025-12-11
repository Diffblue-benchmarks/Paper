package ca.spottedleaf.moonrise.patches.chunk_system.scheduling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.patches.chunk_system.scheduling.ChunkTaskScheduler.ChunkInfo;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChunkTaskSchedulerDiffblueTest {
  /**
   * Test ChunkInfo {@link ChunkInfo#toJson()}.
   *
   * <p>Method under test: {@link ChunkInfo#toJson()}
   */
  @Test
  @DisplayName("Test ChunkInfo toJson()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject ChunkInfo.toJson()"})
  void testChunkInfoToJson() {
    // Arrange and Act
    JsonObject actualToJsonResult = new ChunkInfo(1, 1, null).toJson();

    // Assert
    assertEquals(3, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(actualToJsonResult.isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    JsonObject actualAsJsonObject = actualToJsonResult.getAsJsonObject();
    assertSame(actualToJsonResult, actualAsJsonObject);
  }
}
