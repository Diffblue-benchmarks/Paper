package org.bukkit.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.ref.WeakReference;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FixedMetadataValueDiffblueTest {
  /**
   * Test {@link FixedMetadataValue#FixedMetadataValue(Plugin, Object)}.
   *
   * <ul>
   *   <li>Then return not {@link MetadataValueAdapter#owningPlugin} Enqueued.
   * </ul>
   *
   * <p>Method under test: {@link FixedMetadataValue#FixedMetadataValue(Plugin, Object)}
   */
  @Test
  @DisplayName("Test new FixedMetadataValue(Plugin, Object); then return not owningPlugin Enqueued")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FixedMetadataValue.<init>(Plugin, Object)"})
  void testNewFixedMetadataValue_thenReturnNotOwningPluginEnqueued() {
    // Arrange
    TestPlugin owningPlugin = new TestPlugin("Plugin Name");

    // Act
    FixedMetadataValue actualFixedMetadataValue = new FixedMetadataValue(owningPlugin, "Value");

    // Assert
    WeakReference<Plugin> weakReference = actualFixedMetadataValue.owningPlugin;
    assertFalse(weakReference.isEnqueued());
    assertSame(owningPlugin, weakReference.get());
    assertSame(owningPlugin, actualFixedMetadataValue.getOwningPlugin());
  }

  /**
   * Test {@link FixedMetadataValue#value()}.
   *
   * <p>Method under test: {@link FixedMetadataValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FixedMetadataValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("Value", new FixedMetadataValue(new TestPlugin("Plugin Name"), "Value").value());
  }
}
