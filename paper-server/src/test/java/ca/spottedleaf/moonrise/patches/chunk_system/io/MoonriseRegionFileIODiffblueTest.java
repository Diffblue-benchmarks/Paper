package ca.spottedleaf.moonrise.patches.chunk_system.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.concurrentutil.util.Priority;
import ca.spottedleaf.moonrise.patches.chunk_system.io.MoonriseRegionFileIO.RegionFileData;
import ca.spottedleaf.moonrise.patches.chunk_system.io.MoonriseRegionFileIO.RegionFileType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import net.minecraft.gametest.framework.GameTestServer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.RunningOnDifferentThreadException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MoonriseRegionFileIODiffblueTest {
  /**
   * Test {@link MoonriseRegionFileIO#flush(MinecraftServer)} with {@code server}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link GameTestServer} {@link GameTestServer#getAllLevels()} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MoonriseRegionFileIO#flush(MinecraftServer)}
   */
  @Test
  @DisplayName(
      "Test flush(MinecraftServer) with 'server'; given ArrayList(); when GameTestServer getAllLevels() return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MoonriseRegionFileIO.flush(MinecraftServer)"})
  void testFlushWithServer_givenArrayList_whenGameTestServerGetAllLevelsReturnArrayList() {
    // Arrange
    GameTestServer server = mock(GameTestServer.class);
    when(server.getAllLevels()).thenReturn(new ArrayList<>());

    // Act
    MoonriseRegionFileIO.flush(server);

    // Assert
    verify(server).getAllLevels();
  }

  /**
   * Test {@link MoonriseRegionFileIO#flush(MinecraftServer)} with {@code server}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MoonriseRegionFileIO#flush(MinecraftServer)}
   */
  @Test
  @DisplayName(
      "Test flush(MinecraftServer) with 'server'; given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MoonriseRegionFileIO.flush(MinecraftServer)"})
  void testFlushWithServer_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    GameTestServer server = mock(GameTestServer.class);
    when(server.getAllLevels()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> MoonriseRegionFileIO.flush(server));
    verify(server).getAllLevels();
  }

  /**
   * Test {@link MoonriseRegionFileIO#getIOBlockingPriorityForCurrentThread()}.
   *
   * <p>Method under test: {@link MoonriseRegionFileIO#getIOBlockingPriorityForCurrentThread()}
   */
  @Test
  @DisplayName("Test getIOBlockingPriorityForCurrentThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Priority MoonriseRegionFileIO.getIOBlockingPriorityForCurrentThread()"})
  void testGetIOBlockingPriorityForCurrentThread() {
    // Arrange, Act and Assert
    assertEquals(Priority.HIGHEST, MoonriseRegionFileIO.getIOBlockingPriorityForCurrentThread());
  }

  /**
   * Test RegionFileData {@link RegionFileData#getData(RegionFileType)}.
   *
   * <p>Method under test: {@link RegionFileData#getData(RegionFileType)}
   */
  @Test
  @DisplayName("Test RegionFileData getData(RegionFileType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompoundTag RegionFileData.getData(RegionFileType)"})
  void testRegionFileDataGetData() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new RegionFileData().getData(RegionFileType.CHUNK_DATA));
  }

  /**
   * Test RegionFileData {@link RegionFileData#getThrowable(RegionFileType)}.
   *
   * <p>Method under test: {@link RegionFileData#getThrowable(RegionFileType)}
   */
  @Test
  @DisplayName("Test RegionFileData getThrowable(RegionFileType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Throwable RegionFileData.getThrowable(RegionFileType)"})
  void testRegionFileDataGetThrowable() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new RegionFileData().getThrowable(RegionFileType.CHUNK_DATA));
  }

  /**
   * Test RegionFileData {@link RegionFileData#hasResult(RegionFileType)}.
   *
   * <p>Method under test: {@link RegionFileData#hasResult(RegionFileType)}
   */
  @Test
  @DisplayName("Test RegionFileData hasResult(RegionFileType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionFileData.hasResult(RegionFileType)"})
  void testRegionFileDataHasResult() {
    // Arrange, Act and Assert
    assertFalse(new RegionFileData().hasResult(RegionFileType.CHUNK_DATA));
  }

  /**
   * Test RegionFileData new {@link RegionFileData} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link RegionFileData}
   */
  @Test
  @DisplayName("Test RegionFileData new RegionFileData (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegionFileData.<init>()"})
  void testRegionFileDataNewRegionFileData() {
    // Arrange, Act and Assert
    assertFalse(new RegionFileData().hasResult(RegionFileType.CHUNK_DATA));
  }

  /**
   * Test RegionFileData {@link RegionFileData#setData(RegionFileType, CompoundTag)}.
   *
   * <p>Method under test: {@link RegionFileData#setData(RegionFileType, CompoundTag)}
   */
  @Test
  @DisplayName("Test RegionFileData setData(RegionFileType, CompoundTag)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegionFileData.setData(RegionFileType, CompoundTag)"})
  void testRegionFileDataSetData() {
    // Arrange
    RegionFileData regionFileData = new RegionFileData();
    CompoundTag data = new CompoundTag();

    // Act
    regionFileData.setData(RegionFileType.CHUNK_DATA, data);

    // Assert
    assertNull(regionFileData.getThrowable(RegionFileType.CHUNK_DATA));
    assertTrue(regionFileData.hasResult(RegionFileType.CHUNK_DATA));
    assertSame(data, regionFileData.getData(RegionFileType.CHUNK_DATA));
  }

  /**
   * Test RegionFileData {@link RegionFileData#setThrowable(RegionFileType, Throwable)}.
   *
   * <p>Method under test: {@link RegionFileData#setThrowable(RegionFileType, Throwable)}
   */
  @Test
  @DisplayName("Test RegionFileData setThrowable(RegionFileType, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegionFileData.setThrowable(RegionFileType, Throwable)"})
  void testRegionFileDataSetThrowable() {
    // Arrange
    RegionFileData regionFileData = new RegionFileData();

    // Act
    regionFileData.setThrowable(
        RegionFileType.CHUNK_DATA, RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD);

    // Assert
    assertNull(regionFileData.getData(RegionFileType.CHUNK_DATA));
    assertTrue(regionFileData.hasResult(RegionFileType.CHUNK_DATA));
    assertSame(
        RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD,
        regionFileData.getThrowable(RegionFileType.CHUNK_DATA));
  }
}
