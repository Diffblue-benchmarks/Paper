package ca.spottedleaf.moonrise.patches.chunk_system.io.datacontroller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import ca.spottedleaf.moonrise.patches.chunk_system.io.datacontroller.EntityDataController.EntityRegionFileStorage;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import net.minecraft.world.level.chunk.storage.RegionFileStorage;
import net.minecraft.world.level.chunk.storage.RegionStorageInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityDataControllerDiffblueTest {
  /**
   * Test EntityRegionFileStorage {@link
   * EntityRegionFileStorage#EntityRegionFileStorage(RegionStorageInfo, Path, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link RegionFileStorage#regionCache} Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRegionFileStorage#EntityRegionFileStorage(RegionStorageInfo,
   * Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test EntityRegionFileStorage new EntityRegionFileStorage(RegionStorageInfo, Path, boolean); then return regionCache Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRegionFileStorage.<init>(RegionStorageInfo, Path, boolean)"})
  void testEntityRegionFileStorageNewEntityRegionFileStorage_thenReturnRegionCacheEmpty() {
    // Arrange
    RegionStorageInfo regionStorageInfo =
        new RegionStorageInfo("Level", mock(ResourceKey.class), "Type");

    // Act
    EntityRegionFileStorage actualEntityRegionFileStorage =
        new EntityRegionFileStorage(
            regionStorageInfo, MetricsPersister.PROFILING_RESULTS_DIR, true);

    // Assert
    assertTrue(actualEntityRegionFileStorage.regionCache.isEmpty());
    assertSame(regionStorageInfo, actualEntityRegionFileStorage.info());
  }
}
