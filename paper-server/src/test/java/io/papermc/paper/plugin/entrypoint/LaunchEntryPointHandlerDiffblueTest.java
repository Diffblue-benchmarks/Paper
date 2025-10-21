package io.papermc.paper.plugin.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.provider.PluginProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LaunchEntryPointHandlerDiffblueTest {
  /**
   * Test {@link LaunchEntryPointHandler#LaunchEntryPointHandler()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link LaunchEntryPointHandler}
   */
  @Test
  @DisplayName("Test new LaunchEntryPointHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LaunchEntryPointHandler.<init>()"})
  void testNewLaunchEntryPointHandler() {
    // Arrange, Act and Assert
    assertEquals(2, new LaunchEntryPointHandler().getStorage().size());
  }

  /**
   * Test {@link LaunchEntryPointHandler#enter(Entrypoint)}.
   *
   * <p>Method under test: {@link LaunchEntryPointHandler#enter(Entrypoint)}
   */
  @Test
  @DisplayName("Test enter(Entrypoint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LaunchEntryPointHandler.enter(Entrypoint)"})
  void testEnter() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LaunchEntryPointHandler.INSTANCE.enter(mock(Entrypoint.class)));
  }

  /**
   * Test {@link LaunchEntryPointHandler#register(Entrypoint, PluginProvider)}.
   *
   * <p>Method under test: {@link LaunchEntryPointHandler#register(Entrypoint, PluginProvider)}
   */
  @Test
  @DisplayName("Test register(Entrypoint, PluginProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LaunchEntryPointHandler.register(Entrypoint, PluginProvider)"})
  void testRegister() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            LaunchEntryPointHandler.INSTANCE.register(
                mock(Entrypoint.class), mock(PluginProvider.class)));
  }

  /**
   * Test {@link LaunchEntryPointHandler#get(Entrypoint)}.
   *
   * <p>Method under test: {@link LaunchEntryPointHandler#get(Entrypoint)}
   */
  @Test
  @DisplayName("Test get(Entrypoint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.storage.ProviderStorage LaunchEntryPointHandler.get(Entrypoint)"
  })
  void testGet() {
    // Arrange, Act and Assert
    assertNull(LaunchEntryPointHandler.INSTANCE.get(mock(Entrypoint.class)));
  }

  /**
   * Test {@link LaunchEntryPointHandler#getStorage()}.
   *
   * <p>Method under test: {@link LaunchEntryPointHandler#getStorage()}
   */
  @Test
  @DisplayName("Test getStorage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map LaunchEntryPointHandler.getStorage()"})
  void testGetStorage() {
    // Arrange, Act and Assert
    assertEquals(2, new LaunchEntryPointHandler().getStorage().size());
  }

  /**
   * Test {@link LaunchEntryPointHandler#hasEntered(Entrypoint)}.
   *
   * <ul>
   *   <li>When {@link Entrypoint}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchEntryPointHandler#hasEntered(Entrypoint)}
   */
  @Test
  @DisplayName("Test hasEntered(Entrypoint); when Entrypoint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LaunchEntryPointHandler.hasEntered(Entrypoint)"})
  void testHasEntered_whenEntrypoint() {
    // Arrange, Act and Assert
    assertFalse(LaunchEntryPointHandler.INSTANCE.hasEntered(mock(Entrypoint.class)));
  }

  /**
   * Test {@link LaunchEntryPointHandler#hasEntered(Entrypoint)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LaunchEntryPointHandler#hasEntered(Entrypoint)}
   */
  @Test
  @DisplayName("Test hasEntered(Entrypoint); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LaunchEntryPointHandler.hasEntered(Entrypoint)"})
  void testHasEntered_whenNull() {
    // Arrange, Act and Assert
    assertFalse(LaunchEntryPointHandler.INSTANCE.hasEntered(null));
  }
}
