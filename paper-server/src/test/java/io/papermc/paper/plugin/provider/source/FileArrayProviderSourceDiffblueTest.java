package io.papermc.paper.plugin.provider.source;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import net.minecraft.server.players.OldUsersConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FileArrayProviderSourceDiffblueTest {
  /**
   * Test {@link FileArrayProviderSource#prepareContext(File[])} with {@code context}.
   *
   * <p>Method under test: {@link FileArrayProviderSource#prepareContext(File[])}
   */
  @Test
  @DisplayName("Test prepareContext(File[]) with 'context'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List FileArrayProviderSource.prepareContext(File[])"})
  void testPrepareContextWithContext() {
    // Arrange, Act and Assert
    assertTrue(
        FileArrayProviderSource.INSTANCE
            .prepareContext(
                new File[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()})
            .isEmpty());
  }

  /**
   * Test {@link FileArrayProviderSource#prepareContext(File[])} with {@code context}.
   *
   * <ul>
   *   <li>When array of {@link File} with {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FileArrayProviderSource#prepareContext(File[])}
   */
  @Test
  @DisplayName("Test prepareContext(File[]) with 'context'; when array of File with 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List FileArrayProviderSource.prepareContext(File[])"})
  void testPrepareContextWithContext_whenArrayOfFileWithNull() {
    // Arrange, Act and Assert
    assertTrue(FileArrayProviderSource.INSTANCE.prepareContext(new File[] {null}).isEmpty());
  }

  /**
   * Test {@link FileArrayProviderSource#prepareContext(File[])} with {@code context}.
   *
   * <ul>
   *   <li>When array of {@link File} with {@link OldUsersConverter#OLD_IPBANLIST}.
   * </ul>
   *
   * <p>Method under test: {@link FileArrayProviderSource#prepareContext(File[])}
   */
  @Test
  @DisplayName("Test prepareContext(File[]) with 'context'; when array of File with OLD_IPBANLIST")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List FileArrayProviderSource.prepareContext(File[])"})
  void testPrepareContextWithContext_whenArrayOfFileWithOld_ipbanlist() {
    // Arrange, Act and Assert
    assertTrue(
        FileArrayProviderSource.INSTANCE
            .prepareContext(new File[] {OldUsersConverter.OLD_IPBANLIST})
            .isEmpty());
  }
}
