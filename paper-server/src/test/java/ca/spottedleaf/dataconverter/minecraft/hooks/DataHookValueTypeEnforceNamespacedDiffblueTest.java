package ca.spottedleaf.dataconverter.minecraft.hooks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DataHookValueTypeEnforceNamespacedDiffblueTest {
  /**
   * Test {@link DataHookValueTypeEnforceNamespaced#preHook(Object, long, long)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code minecraft:42}.
   * </ul>
   *
   * <p>Method under test: {@link DataHookValueTypeEnforceNamespaced#preHook(Object, long, long)}
   */
  @Test
  @DisplayName("Test preHook(Object, long, long); when '42'; then return 'minecraft:42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataHookValueTypeEnforceNamespaced.preHook(Object, long, long)"})
  void testPreHook_when42_thenReturnMinecraft42() {
    // Arrange, Act and Assert
    assertEquals("minecraft:42", new DataHookValueTypeEnforceNamespaced().preHook("42", 1L, 1L));
  }

  /**
   * Test {@link DataHookValueTypeEnforceNamespaced#preHook(Object, long, long)}.
   *
   * <ul>
   *   <li>When {@code Data}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataHookValueTypeEnforceNamespaced#preHook(Object, long, long)}
   */
  @Test
  @DisplayName("Test preHook(Object, long, long); when 'Data'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataHookValueTypeEnforceNamespaced.preHook(Object, long, long)"})
  void testPreHook_whenData_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DataHookValueTypeEnforceNamespaced().preHook("Data", 1L, 1L));
  }

  /**
   * Test {@link DataHookValueTypeEnforceNamespaced#preHook(Object, long, long)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataHookValueTypeEnforceNamespaced#preHook(Object, long, long)}
   */
  @Test
  @DisplayName("Test preHook(Object, long, long); when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataHookValueTypeEnforceNamespaced.preHook(Object, long, long)"})
  void testPreHook_whenWildcard_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DataHookValueTypeEnforceNamespaced()
            .preHook(ConfigurationTransformation.WILDCARD_OBJECT, 1L, 1L));
  }

  /**
   * Test {@link DataHookValueTypeEnforceNamespaced#postHook(Object, long, long)}.
   *
   * <p>Method under test: {@link DataHookValueTypeEnforceNamespaced#postHook(Object, long, long)}
   */
  @Test
  @DisplayName("Test postHook(Object, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataHookValueTypeEnforceNamespaced.postHook(Object, long, long)"})
  void testPostHook() {
    // Arrange, Act and Assert
    assertNull(
        new DataHookValueTypeEnforceNamespaced()
            .postHook(ConfigurationTransformation.WILDCARD_OBJECT, 1L, 1L));
  }
}
