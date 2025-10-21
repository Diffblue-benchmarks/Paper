package io.papermc.paper.plugin.loader.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.util.List;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperLibraryStoreDiffblueTest {
  /**
   * Test {@link PaperLibraryStore#addLibrary(Path)}.
   *
   * <p>Method under test: {@link PaperLibraryStore#addLibrary(Path)}
   */
  @Test
  @DisplayName("Test addLibrary(Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLibraryStore.addLibrary(Path)"})
  void testAddLibrary() {
    // Arrange
    PaperLibraryStore paperLibraryStore = new PaperLibraryStore();
    Path library = MetricsPersister.PROFILING_RESULTS_DIR;

    // Act
    paperLibraryStore.addLibrary(library);

    // Assert
    List<Path> paths = paperLibraryStore.getPaths();
    assertEquals(1, paths.size());
    assertSame(library, paths.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PaperLibraryStore}
   *   <li>{@link PaperLibraryStore#getPaths()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLibraryStore.<init>()", "List PaperLibraryStore.getPaths()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new PaperLibraryStore().getPaths().isEmpty());
  }
}
