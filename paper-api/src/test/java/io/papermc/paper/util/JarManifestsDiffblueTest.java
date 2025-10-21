package io.papermc.paper.util;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JarManifestsDiffblueTest {
  /**
   * Test {@link JarManifests#manifest(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JarManifests#manifest(Class)}
   */
  @Test
  @DisplayName("Test manifest(Class); when 'java.lang.Object'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.jar.Manifest JarManifests.manifest(Class)"})
  void testManifest_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JarManifests.manifest(clazz));
  }
}
