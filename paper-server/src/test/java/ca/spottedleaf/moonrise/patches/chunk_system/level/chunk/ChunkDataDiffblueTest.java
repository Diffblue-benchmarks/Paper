package ca.spottedleaf.moonrise.patches.chunk_system.level.chunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChunkDataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ChunkData}
   *   <li>{@link ChunkData#decreaseRef()}
   *   <li>{@link ChunkData#increaseRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChunkData.<init>()",
    "int ChunkData.decreaseRef()",
    "int ChunkData.increaseRef()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ChunkData actualChunkData = new ChunkData();
    int actualDecreaseRefResult = actualChunkData.decreaseRef();

    // Assert
    assertEquals(-1, actualDecreaseRefResult);
    assertEquals(0, actualChunkData.increaseRef());
  }
}
