package ca.spottedleaf.moonrise.patches.chunk_system.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.patches.chunk_system.player.RegionizedPlayerChunkLoader.ViewDistances;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegionizedPlayerChunkLoaderDiffblueTest {
  /**
   * Test ViewDistances {@link ViewDistances#toJson()}.
   *
   * <p>Method under test: {@link ViewDistances#toJson()}
   */
  @Test
  @DisplayName("Test ViewDistances toJson()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject ViewDistances.toJson()"})
  void testViewDistancesToJson() {
    // Arrange and Act
    JsonObject actualToJsonResult = new ViewDistances(1, 1, 3).toJson();

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

  /**
   * Test ViewDistances {@link ViewDistances#toJson()}.
   *
   * <p>Method under test: {@link ViewDistances#toJson()}
   */
  @Test
  @DisplayName("Test ViewDistances toJson()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject ViewDistances.toJson()"})
  void testViewDistancesToJson2() {
    // Arrange and Act
    JsonObject actualToJsonResult = new ViewDistances(0, 1, 3).toJson();

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
