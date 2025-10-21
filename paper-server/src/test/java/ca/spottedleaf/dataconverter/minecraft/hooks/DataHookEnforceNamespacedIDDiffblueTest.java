package ca.spottedleaf.dataconverter.minecraft.hooks;

import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataHookEnforceNamespacedIDDiffblueTest {
  /**
   * Test {@link DataHookEnforceNamespacedID#preHook(MapType, long, long)} with {@code data}, {@code
   * fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataHookEnforceNamespacedID#preHook(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test preHook(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType DataHookEnforceNamespacedID.preHook(MapType, long, long)"})
  void testPreHookWithDataFromVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    DataHookEnforceNamespacedID dataHookEnforceNamespacedID =
        new DataHookEnforceNamespacedID("Path");

    // Act and Assert
    assertNull(dataHookEnforceNamespacedID.preHook(new NBTMapType(), 1L, 1L));
  }

  /**
   * Test {@link DataHookEnforceNamespacedID#preHook(MapType, long, long)} with {@code data}, {@code
   * fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataHookEnforceNamespacedID#preHook(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test preHook(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType DataHookEnforceNamespacedID.preHook(MapType, long, long)"})
  void testPreHookWithDataFromVersionToVersion_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DataHookEnforceNamespacedID("Path").preHook(null, 1L, 1L));
  }

  /**
   * Test {@link DataHookEnforceNamespacedID#postHook(MapType, long, long)} with {@code data},
   * {@code fromVersion}, {@code toVersion}.
   *
   * <p>Method under test: {@link DataHookEnforceNamespacedID#postHook(MapType, long, long)}
   */
  @Test
  @DisplayName("Test postHook(MapType, long, long) with 'data', 'fromVersion', 'toVersion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType DataHookEnforceNamespacedID.postHook(MapType, long, long)"})
  void testPostHookWithDataFromVersionToVersion() {
    // Arrange
    DataHookEnforceNamespacedID dataHookEnforceNamespacedID =
        new DataHookEnforceNamespacedID("Path");

    // Act and Assert
    assertNull(dataHookEnforceNamespacedID.postHook(new NBTMapType(), 1L, 1L));
  }
}
