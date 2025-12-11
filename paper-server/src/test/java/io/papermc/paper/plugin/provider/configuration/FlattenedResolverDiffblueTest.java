package io.papermc.paper.plugin.provider.configuration;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.provider.configuration.FlattenedResolver.Factory;
import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlattenedResolverDiffblueTest {
  /**
   * Test Factory {@link Factory#make(String, AnnotatedElement)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Factory#make(String, AnnotatedElement)}
   */
  @Test
  @DisplayName(
      "Test Factory make(String, AnnotatedElement); when 'java.lang.Object'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.NodeResolver Factory.make(String, AnnotatedElement)"
  })
  void testFactoryMake_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Factory factory = new Factory();
    Class<Object> element = Object.class;

    // Act and Assert
    assertNull(factory.make("Name", element));
  }
}
