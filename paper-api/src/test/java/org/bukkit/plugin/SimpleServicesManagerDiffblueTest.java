package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleServicesManagerDiffblueTest {
  /**
   * Test {@link SimpleServicesManager#load(Class)}.
   *
   * <p>Method under test: {@link SimpleServicesManager#load(Class)}
   */
  @Test
  @DisplayName("Test load(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SimpleServicesManager.load(Class)"})
  void testLoad() {
    // Arrange
    SimpleServicesManager simpleServicesManager = new SimpleServicesManager();
    Class<Object> service = Object.class;

    // Act and Assert
    assertNull(simpleServicesManager.load(service));
  }

  /**
   * Test {@link SimpleServicesManager#getRegistration(Class)}.
   *
   * <p>Method under test: {@link SimpleServicesManager#getRegistration(Class)}
   */
  @Test
  @DisplayName("Test getRegistration(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.bukkit.plugin.RegisteredServiceProvider SimpleServicesManager.getRegistration(Class)"
  })
  void testGetRegistration() {
    // Arrange
    SimpleServicesManager simpleServicesManager = new SimpleServicesManager();
    Class<Object> service = Object.class;

    // Act and Assert
    assertNull(simpleServicesManager.getRegistration(service));
  }

  /**
   * Test {@link SimpleServicesManager#getRegistrations(Plugin)} with {@code plugin}.
   *
   * <p>Method under test: {@link SimpleServicesManager#getRegistrations(Plugin)}
   */
  @Test
  @DisplayName("Test getRegistrations(Plugin) with 'plugin'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SimpleServicesManager.getRegistrations(Plugin)"})
  void testGetRegistrationsWithPlugin() {
    // Arrange
    SimpleServicesManager simpleServicesManager = new SimpleServicesManager();

    // Act and Assert
    assertTrue(simpleServicesManager.getRegistrations(new TestPlugin("Plugin Name")).isEmpty());
  }

  /**
   * Test {@link SimpleServicesManager#getRegistrations(Class)} with {@code service}.
   *
   * <p>Method under test: {@link SimpleServicesManager#getRegistrations(Class)}
   */
  @Test
  @DisplayName("Test getRegistrations(Class) with 'service'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SimpleServicesManager.getRegistrations(Class)"})
  void testGetRegistrationsWithService() {
    // Arrange
    SimpleServicesManager simpleServicesManager = new SimpleServicesManager();
    Class<Object> service = Object.class;

    // Act and Assert
    assertTrue(simpleServicesManager.getRegistrations(service).isEmpty());
  }

  /**
   * Test {@link SimpleServicesManager#getKnownServices()}.
   *
   * <p>Method under test: {@link SimpleServicesManager#getKnownServices()}
   */
  @Test
  @DisplayName("Test getKnownServices()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set SimpleServicesManager.getKnownServices()"})
  void testGetKnownServices() {
    // Arrange, Act and Assert
    assertTrue(new SimpleServicesManager().getKnownServices().isEmpty());
  }

  /**
   * Test {@link SimpleServicesManager#isProvidedFor(Class)}.
   *
   * <p>Method under test: {@link SimpleServicesManager#isProvidedFor(Class)}
   */
  @Test
  @DisplayName("Test isProvidedFor(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleServicesManager.isProvidedFor(Class)"})
  void testIsProvidedFor() {
    // Arrange
    SimpleServicesManager simpleServicesManager = new SimpleServicesManager();
    Class<Object> service = Object.class;

    // Act and Assert
    assertFalse(simpleServicesManager.isProvidedFor(service));
  }

  /**
   * Test new {@link SimpleServicesManager} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SimpleServicesManager}
   */
  @Test
  @DisplayName("Test new SimpleServicesManager (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleServicesManager.<init>()"})
  void testNewSimpleServicesManager() {
    // Arrange, Act and Assert
    assertTrue(new SimpleServicesManager().getKnownServices().isEmpty());
  }
}
