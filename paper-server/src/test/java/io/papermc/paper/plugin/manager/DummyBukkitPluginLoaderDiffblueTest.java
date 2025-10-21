package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import net.minecraft.server.players.OldUsersConverter;
import org.bukkit.plugin.InvalidDescriptionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DummyBukkitPluginLoaderDiffblueTest {
  /**
   * Test {@link DummyBukkitPluginLoader#getPluginDescription(File)}.
   *
   * <p>Method under test: {@link DummyBukkitPluginLoader#getPluginDescription(File)}
   */
  @Test
  @DisplayName("Test getPluginDescription(File)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.bukkit.plugin.PluginDescriptionFile DummyBukkitPluginLoader.getPluginDescription(File)"
  })
  void testGetPluginDescription() throws InvalidDescriptionException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidDescriptionException.class,
        () -> new DummyBukkitPluginLoader().getPluginDescription(OldUsersConverter.OLD_IPBANLIST));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DummyBukkitPluginLoader}
   *   <li>{@link DummyBukkitPluginLoader#getPluginFileFilters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DummyBukkitPluginLoader.<init>()",
    "java.util.regex.Pattern[] DummyBukkitPluginLoader.getPluginFileFilters()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, new DummyBukkitPluginLoader().getPluginFileFilters().length);
  }
}
