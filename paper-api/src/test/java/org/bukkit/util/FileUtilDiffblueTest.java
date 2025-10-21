package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FileUtilDiffblueTest {
  /**
   * Test {@link FileUtil#copy(File, File)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} and {@code 42} toFile.
   * </ul>
   *
   * <p>Method under test: {@link FileUtil#copy(File, File)}
   */
  @Test
  @DisplayName("Test copy(File, File); when Property is 'java.io.tmpdir' is 'foo' and '42' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtil.copy(File, File)"})
  void testCopy_whenPropertyIsJavaIoTmpdirIsFooAnd42ToFile() {
    // Arrange
    Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42", "foo");

    // Act
    boolean actualCopyResult =
        FileUtil.copy(
            getResult.toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertFalse(actualCopyResult);
  }

  /**
   * Test {@link FileUtil#copy(File, File)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.
   * </ul>
   *
   * <p>Method under test: {@link FileUtil#copy(File, File)}
   */
  @Test
  @DisplayName("Test copy(File, File); when Property is 'java.io.tmpdir' is 'test.txt' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtil.copy(File, File)"})
  void testCopy_whenPropertyIsJavaIoTmpdirIsTestTxtToFile() {
    // Arrange and Act
    boolean actualCopyResult =
        FileUtil.copy(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertFalse(actualCopyResult);
  }
}
