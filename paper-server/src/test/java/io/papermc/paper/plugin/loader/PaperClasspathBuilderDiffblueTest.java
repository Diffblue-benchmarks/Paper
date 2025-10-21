package io.papermc.paper.plugin.loader;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import io.papermc.paper.plugin.loader.library.ClassPathLibrary;
import io.papermc.paper.plugin.loader.library.LibraryLoadingException;
import io.papermc.paper.plugin.loader.library.LibraryStore;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.nio.file.Path;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaperClasspathBuilderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperClasspathBuilder#PaperClasspathBuilder(PluginProviderContext)}
   *   <li>{@link PaperClasspathBuilder#getContext()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperClasspathBuilder.<init>(PluginProviderContext)",
    "PluginProviderContext PaperClasspathBuilder.getContext()"
  })
  void testGettersAndSetters() {
    // Arrange
    PluginBootstrapContextImpl context =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    // Act and Assert
    assertSame(context, new PaperClasspathBuilder(context).getContext());
  }

  /**
   * Test {@link PaperClasspathBuilder#addLibrary(ClassPathLibrary)}.
   *
   * <p>Method under test: {@link PaperClasspathBuilder#addLibrary(ClassPathLibrary)}
   */
  @Test
  @DisplayName("Test addLibrary(ClassPathLibrary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PluginClasspathBuilder PaperClasspathBuilder.addLibrary(ClassPathLibrary)"})
  void testAddLibrary() {
    // Arrange
    PluginBootstrapContextImpl context =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    PaperClasspathBuilder paperClasspathBuilder = new PaperClasspathBuilder(context);

    // Act
    PluginClasspathBuilder actualAddLibraryResult =
        paperClasspathBuilder.addLibrary(mock(ClassPathLibrary.class));

    // Assert
    assertSame(paperClasspathBuilder, actualAddLibraryResult);
  }

  /**
   * Test {@link PaperClasspathBuilder#buildLibraryPaths(boolean)}.
   *
   * <ul>
   *   <li>Given {@link ClassPathLibrary} {@link ClassPathLibrary#register(LibraryStore)} does
   *       nothing.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperClasspathBuilder#buildLibraryPaths(boolean)}
   */
  @Test
  @DisplayName(
      "Test buildLibraryPaths(boolean); given ClassPathLibrary register(LibraryStore) does nothing; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperClasspathBuilder.buildLibraryPaths(boolean)"})
  void testBuildLibraryPaths_givenClassPathLibraryRegisterDoesNothing_thenReturnEmpty()
      throws LibraryLoadingException {
    // Arrange
    ClassPathLibrary classPathLibrary = mock(ClassPathLibrary.class);
    doNothing().when(classPathLibrary).register(Mockito.<LibraryStore>any());
    PluginBootstrapContextImpl context =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);

    PaperClasspathBuilder paperClasspathBuilder = new PaperClasspathBuilder(context);
    paperClasspathBuilder.addLibrary(classPathLibrary);

    // Act
    List<Path> actualBuildLibraryPathsResult = paperClasspathBuilder.buildLibraryPaths(false);

    // Assert
    verify(classPathLibrary).register(isA(LibraryStore.class));
    assertTrue(actualBuildLibraryPathsResult.isEmpty());
  }
}
