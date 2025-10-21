package org.bukkit.plugin.java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JavaPluginLoaderDiffblueTest {
  /**
   * Test {@link JavaPluginLoader#JavaPluginLoader(Server)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link JavaPluginLoader#JavaPluginLoader(Server)}
   */
  @Test
  @DisplayName("Test new JavaPluginLoader(Server); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JavaPluginLoader.<init>(Server)"})
  void testNewJavaPluginLoader_thenThrowUnsupportedOperationException() {
    // Arrange
    Server instance = mock(Server.class);
    when(instance.getLogger()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new JavaPluginLoader(instance));
    verify(instance).getLogger();
  }
}
