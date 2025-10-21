package com.destroystokyo.paper.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.configuration.PluginMeta;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPluginLoggerDiffblueTest {
  /**
   * Test {@link PaperPluginLogger#getLogger(PluginDescriptionFile)} with {@code description}.
   *
   * <ul>
   *   <li>Then return Name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginLogger#getLogger(PluginDescriptionFile)}
   */
  @Test
  @DisplayName("Test getLogger(PluginDescriptionFile) with 'description'; then return Name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Logger PaperPluginLogger.getLogger(PluginDescriptionFile)"})
  void testGetLoggerWithDescription_thenReturnNameIs42() {
    // Arrange
    PluginDescriptionFile description = new PluginDescriptionFile("42", "1.0.2", "Main Class");

    // Act
    Logger actualLogger = PaperPluginLogger.getLogger(description);

    // Assert
    assertTrue(actualLogger instanceof PaperPluginLogger);
    Logger parent = actualLogger.getParent();
    assertEquals("", parent.getName());
    assertEquals("42", actualLogger.getName());
    assertNull(parent.getResourceBundleName());
    assertNull(actualLogger.getResourceBundleName());
    assertNull(parent.getResourceBundle());
    assertNull(actualLogger.getResourceBundle());
    assertNull(parent.getFilter());
    assertNull(actualLogger.getFilter());
    assertNull(actualLogger.getLevel());
    assertNull(parent.getParent());
    assertEquals(0, actualLogger.getHandlers().length);
    assertEquals(1, parent.getHandlers().length);
    assertTrue(parent.getUseParentHandlers());
    assertTrue(actualLogger.getUseParentHandlers());
  }

  /**
   * Test {@link PaperPluginLogger#getLogger(PluginDescriptionFile)} with {@code description}.
   *
   * <ul>
   *   <li>Then return Name is {@code Plugin_Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginLogger#getLogger(PluginDescriptionFile)}
   */
  @Test
  @DisplayName(
      "Test getLogger(PluginDescriptionFile) with 'description'; then return Name is 'Plugin_Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Logger PaperPluginLogger.getLogger(PluginDescriptionFile)"})
  void testGetLoggerWithDescription_thenReturnNameIsPluginName() {
    // Arrange
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act
    Logger actualLogger = PaperPluginLogger.getLogger(description);

    // Assert
    assertTrue(actualLogger instanceof PaperPluginLogger);
    Logger parent = actualLogger.getParent();
    assertEquals("", parent.getName());
    assertEquals("Plugin_Name", actualLogger.getName());
    assertNull(parent.getResourceBundleName());
    assertNull(actualLogger.getResourceBundleName());
    assertNull(parent.getResourceBundle());
    assertNull(actualLogger.getResourceBundle());
    assertNull(parent.getFilter());
    assertNull(actualLogger.getFilter());
    assertNull(actualLogger.getLevel());
    assertNull(parent.getParent());
    assertEquals(0, actualLogger.getHandlers().length);
    assertEquals(1, parent.getHandlers().length);
    assertTrue(parent.getUseParentHandlers());
    assertTrue(actualLogger.getUseParentHandlers());
  }

  /**
   * Test {@link PaperPluginLogger#getLogger(PluginMeta)} with {@code meta}.
   *
   * <p>Method under test: {@link PaperPluginLogger#getLogger(PluginMeta)}
   */
  @Test
  @DisplayName("Test getLogger(PluginMeta) with 'meta'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Logger PaperPluginLogger.getLogger(PluginMeta)"})
  void testGetLoggerWithMeta() {
    // Arrange
    PluginDescriptionFile meta = new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act
    Logger actualLogger = PaperPluginLogger.getLogger((PluginMeta) meta);

    // Assert
    assertTrue(actualLogger instanceof PaperPluginLogger);
    Logger parent = actualLogger.getParent();
    assertEquals("", parent.getName());
    assertEquals("Plugin_Name", actualLogger.getName());
    assertNull(parent.getResourceBundleName());
    assertNull(actualLogger.getResourceBundleName());
    assertNull(parent.getResourceBundle());
    assertNull(actualLogger.getResourceBundle());
    assertNull(parent.getFilter());
    assertNull(actualLogger.getFilter());
    assertNull(actualLogger.getLevel());
    assertNull(parent.getParent());
    assertEquals(0, actualLogger.getHandlers().length);
    assertEquals(1, parent.getHandlers().length);
    assertTrue(parent.getUseParentHandlers());
    assertTrue(actualLogger.getUseParentHandlers());
  }

  /**
   * Test {@link PaperPluginLogger#getLogger(PluginMeta)} with {@code meta}.
   *
   * <p>Method under test: {@link PaperPluginLogger#getLogger(PluginMeta)}
   */
  @Test
  @DisplayName("Test getLogger(PluginMeta) with 'meta'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Logger PaperPluginLogger.getLogger(PluginMeta)"})
  void testGetLoggerWithMeta2() {
    // Arrange
    PluginDescriptionFile meta =
        new PluginDescriptionFile(
            "Plugin Name", "Setting plugin logger parent to {0}", "Main Class");

    // Act
    Logger actualLogger = PaperPluginLogger.getLogger((PluginMeta) meta);

    // Assert
    assertTrue(actualLogger instanceof PaperPluginLogger);
    Logger parent = actualLogger.getParent();
    assertEquals("", parent.getName());
    assertEquals("Plugin_Name", actualLogger.getName());
    assertNull(parent.getResourceBundleName());
    assertNull(actualLogger.getResourceBundleName());
    assertNull(parent.getResourceBundle());
    assertNull(actualLogger.getResourceBundle());
    assertNull(parent.getFilter());
    assertNull(actualLogger.getFilter());
    assertNull(actualLogger.getLevel());
    assertNull(parent.getParent());
    assertEquals(0, actualLogger.getHandlers().length);
    assertEquals(1, parent.getHandlers().length);
    assertTrue(parent.getUseParentHandlers());
    assertTrue(actualLogger.getUseParentHandlers());
  }
}
