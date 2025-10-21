package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimingsManagerDiffblueTest {
  /**
   * Test {@link TimingsManager#getHandler(String, String, Timing)}.
   *
   * <ul>
   *   <li>Then return {@link TimingHandler#identifier} {@link TimingIdentifier#groupHandler} is
   *       {@link TimingsManager#FULL_SERVER_TICK}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsManager#getHandler(String, String, Timing)}
   */
  @Test
  @DisplayName(
      "Test getHandler(String, String, Timing); then return identifier groupHandler is FULL_SERVER_TICK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimingHandler TimingsManager.getHandler(String, String, Timing)"})
  void testGetHandler_thenReturnIdentifierGroupHandlerIsFull_server_tick() {
    // Arrange
    FullServerTickHandler parent = TimingsManager.FULL_SERVER_TICK;

    // Act
    TimingHandler actualHandler = TimingsManager.getHandler("Group", "Name", parent);

    // Assert
    assertSame(parent, actualHandler.identifier.groupHandler);
  }

  /**
   * Test {@link TimingsManager#getPluginByClassloader(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsManager#getPluginByClassloader(Class)}
   */
  @Test
  @DisplayName("Test getPluginByClassloader(Class); when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.plugin.Plugin TimingsManager.getPluginByClassloader(Class)"})
  void testGetPluginByClassloader_whenJavaLangObject() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(TimingsManager.getPluginByClassloader(clazz));
  }

  /**
   * Test {@link TimingsManager#getPluginByClassloader(Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsManager#getPluginByClassloader(Class)}
   */
  @Test
  @DisplayName("Test getPluginByClassloader(Class); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.plugin.Plugin TimingsManager.getPluginByClassloader(Class)"})
  void testGetPluginByClassloader_whenNull() {
    // Arrange, Act and Assert
    assertNull(TimingsManager.getPluginByClassloader(null));
  }
}
