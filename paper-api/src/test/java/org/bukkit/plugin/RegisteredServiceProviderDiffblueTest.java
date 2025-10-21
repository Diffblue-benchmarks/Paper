package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegisteredServiceProviderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegisteredServiceProvider#RegisteredServiceProvider(Class, Object,
   *       ServicePriority, Plugin)}
   *   <li>{@link RegisteredServiceProvider#getPlugin()}
   *   <li>{@link RegisteredServiceProvider#getPriority()}
   *   <li>{@link RegisteredServiceProvider#getProvider()}
   *   <li>{@link RegisteredServiceProvider#getService()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegisteredServiceProvider.<init>(Class, Object, ServicePriority, Plugin)",
    "Plugin RegisteredServiceProvider.getPlugin()",
    "ServicePriority RegisteredServiceProvider.getPriority()",
    "Object RegisteredServiceProvider.getProvider()",
    "Class RegisteredServiceProvider.getService()"
  })
  void testGettersAndSetters() {
    // Arrange
    Class<Object> service = Object.class;
    TestPlugin plugin = new TestPlugin("Plugin Name");

    // Act
    RegisteredServiceProvider<Object> actualRegisteredServiceProvider =
        new RegisteredServiceProvider<>(service, "Provider", ServicePriority.Lowest, plugin);
    Plugin actualPlugin = actualRegisteredServiceProvider.getPlugin();
    ServicePriority actualPriority = actualRegisteredServiceProvider.getPriority();
    Object actualProvider = actualRegisteredServiceProvider.getProvider();
    Class<Object> actualService = actualRegisteredServiceProvider.getService();

    // Assert
    assertEquals("Provider", actualProvider);
    assertEquals(ServicePriority.Lowest, actualPriority);
    Class<Object> expectedService = Object.class;
    assertEquals(expectedService, actualService);
    assertSame(plugin, actualPlugin);
    assertSame(service, actualService);
  }

  /**
   * Test {@link RegisteredServiceProvider#compareTo(RegisteredServiceProvider)} with {@code other}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RegisteredServiceProvider#compareTo(RegisteredServiceProvider)}
   */
  @Test
  @DisplayName("Test compareTo(RegisteredServiceProvider) with 'other'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RegisteredServiceProvider.compareTo(RegisteredServiceProvider)"})
  void testCompareToWithOther_thenReturnMinusOne() {
    // Arrange
    Class<Object> service = Object.class;
    RegisteredServiceProvider<Object> registeredServiceProvider =
        new RegisteredServiceProvider<>(
            service, "Provider", ServicePriority.Low, new TestPlugin("Plugin Name"));
    Class<Object> service2 = Object.class;
    RegisteredServiceProvider<Object> other =
        new RegisteredServiceProvider<>(
            service2, "Provider", ServicePriority.Lowest, new TestPlugin("Plugin Name"));

    // Act
    int actualCompareToResult = registeredServiceProvider.compareTo(other);

    // Assert
    assertEquals(-1, actualCompareToResult);
  }

  /**
   * Test {@link RegisteredServiceProvider#compareTo(RegisteredServiceProvider)} with {@code other}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RegisteredServiceProvider#compareTo(RegisteredServiceProvider)}
   */
  @Test
  @DisplayName("Test compareTo(RegisteredServiceProvider) with 'other'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RegisteredServiceProvider.compareTo(RegisteredServiceProvider)"})
  void testCompareToWithOther_thenReturnOne() {
    // Arrange
    Class<Object> service = Object.class;
    RegisteredServiceProvider<Object> registeredServiceProvider =
        new RegisteredServiceProvider<>(
            service, "Provider", ServicePriority.Lowest, new TestPlugin("Plugin Name"));
    Class<Object> service2 = Object.class;
    RegisteredServiceProvider<Object> other =
        new RegisteredServiceProvider<>(
            service2, "Provider", ServicePriority.Low, new TestPlugin("Plugin Name"));

    // Act
    int actualCompareToResult = registeredServiceProvider.compareTo(other);

    // Assert
    assertEquals(1, actualCompareToResult);
  }

  /**
   * Test {@link RegisteredServiceProvider#compareTo(RegisteredServiceProvider)} with {@code other}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RegisteredServiceProvider#compareTo(RegisteredServiceProvider)}
   */
  @Test
  @DisplayName("Test compareTo(RegisteredServiceProvider) with 'other'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RegisteredServiceProvider.compareTo(RegisteredServiceProvider)"})
  void testCompareToWithOther_thenReturnZero() {
    // Arrange
    Class<Object> service = Object.class;
    RegisteredServiceProvider<Object> registeredServiceProvider =
        new RegisteredServiceProvider<>(
            service, "Provider", ServicePriority.Lowest, new TestPlugin("Plugin Name"));
    Class<Object> service2 = Object.class;
    RegisteredServiceProvider<Object> other =
        new RegisteredServiceProvider<>(
            service2, "Provider", ServicePriority.Lowest, new TestPlugin("Plugin Name"));

    // Act
    int actualCompareToResult = registeredServiceProvider.compareTo(other);

    // Assert
    assertEquals(0, actualCompareToResult);
  }
}
