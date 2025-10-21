package io.papermc.paper.configuration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.GlobalConfiguration.PacketLimiter;
import io.papermc.paper.configuration.GlobalConfiguration.PacketLimiter.PacketLimit;
import io.papermc.paper.configuration.GlobalConfiguration.PacketLimiter.PacketLimit.ViolateAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlobalConfigurationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GlobalConfiguration}
   *   <li>{@link GlobalConfiguration#get()}
   *   <li>{@link GlobalConfiguration#set(GlobalConfiguration)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GlobalConfiguration.<init>()",
    "GlobalConfiguration GlobalConfiguration.get()",
    "void GlobalConfiguration.set(GlobalConfiguration)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GlobalConfiguration actualGlobalConfiguration = new GlobalConfiguration();
    GlobalConfiguration actualGetResult = actualGlobalConfiguration.get();
    actualGlobalConfiguration.set(GlobalConfiguration.get());

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test PacketLimiter_PacketLimit {@link PacketLimiter.PacketLimit#isEnabled()}.
   *
   * <p>Method under test: {@link PacketLimiter.PacketLimit#isEnabled()}
   */
  @Test
  @DisplayName("Test PacketLimiter_PacketLimit isEnabled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PacketLimiter.PacketLimit.isEnabled()"})
  void testPacketLimiter_PacketLimitIsEnabled() {
    // Arrange, Act and Assert
    assertFalse(new PacketLimit(0.0d, 0.0d, ViolateAction.KICK).isEnabled());
  }

  /**
   * Test PacketLimiter_PacketLimit {@link PacketLimiter.PacketLimit#isEnabled()}.
   *
   * <p>Method under test: {@link PacketLimiter.PacketLimit#isEnabled()}
   */
  @Test
  @DisplayName("Test PacketLimiter_PacketLimit isEnabled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PacketLimiter.PacketLimit.isEnabled()"})
  void testPacketLimiter_PacketLimitIsEnabled2() {
    // Arrange, Act and Assert
    assertFalse(new PacketLimit(1.0E-10d, 0.0d, ViolateAction.KICK).isEnabled());
  }

  /**
   * Test PacketLimiter_PacketLimit {@link PacketLimiter.PacketLimit#isEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PacketLimiter.PacketLimit#isEnabled()}
   */
  @Test
  @DisplayName("Test PacketLimiter_PacketLimit isEnabled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PacketLimiter.PacketLimit.isEnabled()"})
  void testPacketLimiter_PacketLimitIsEnabled_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PacketLimit(10.0d, 10.0d, ViolateAction.KICK).isEnabled());
  }
}
