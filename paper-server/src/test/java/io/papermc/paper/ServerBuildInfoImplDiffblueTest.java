package io.papermc.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo.StringRepresentation;
import java.util.Optional;
import java.util.OptionalInt;
import org.bukkit.craftbukkit.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerBuildInfoImplDiffblueTest {
  /**
   * Test {@link ServerBuildInfoImpl#asString(StringRepresentation)}.
   *
   * <p>Method under test: {@link ServerBuildInfoImpl#asString(StringRepresentation)}
   */
  @Test
  @DisplayName("Test asString(StringRepresentation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ServerBuildInfoImpl.asString(StringRepresentation)"})
  void testAsString() {
    // Arrange
    OptionalInt buildNumber = OptionalInt.empty();
    Optional<String> gitBranch = Optional.empty();
    Optional<String> gitCommit = Optional.of("DEV");

    ServerBuildInfoImpl serverBuildInfoImpl =
        new ServerBuildInfoImpl(
            ServerBuildInfo.BRAND_PAPER_ID,
            "DEV",
            "42",
            "1.0.2",
            buildNumber,
            Main.BOOT_TIME,
            gitBranch,
            gitCommit);

    // Act and Assert
    assertEquals("42-DEV-DEV", serverBuildInfoImpl.asString(StringRepresentation.VERSION_SIMPLE));
  }

  /**
   * Test {@link ServerBuildInfoImpl#asString(StringRepresentation)}.
   *
   * <ul>
   *   <li>Given {@link OptionalInt} with forty-five.
   *   <li>When {@code VERSION_SIMPLE}.
   *   <li>Then return {@code 42-45-DEV}.
   * </ul>
   *
   * <p>Method under test: {@link ServerBuildInfoImpl#asString(StringRepresentation)}
   */
  @Test
  @DisplayName(
      "Test asString(StringRepresentation); given OptionalInt with forty-five; when 'VERSION_SIMPLE'; then return '42-45-DEV'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ServerBuildInfoImpl.asString(StringRepresentation)"})
  void testAsString_givenOptionalIntWithFortyFive_whenVersionSimple_thenReturn4245Dev() {
    // Arrange
    OptionalInt buildNumber = OptionalInt.of(45);
    Optional<String> gitBranch = Optional.of("DEV");
    Optional<String> gitCommit = Optional.of("DEV");

    ServerBuildInfoImpl serverBuildInfoImpl =
        new ServerBuildInfoImpl(
            ServerBuildInfo.BRAND_PAPER_ID,
            "DEV",
            "42",
            "1.0.2",
            buildNumber,
            Main.BOOT_TIME,
            gitBranch,
            gitCommit);

    // Act and Assert
    assertEquals("42-45-DEV", serverBuildInfoImpl.asString(StringRepresentation.VERSION_SIMPLE));
  }

  /**
   * Test {@link ServerBuildInfoImpl#asString(StringRepresentation)}.
   *
   * <ul>
   *   <li>Then return {@code 42-DEV-DEV}.
   * </ul>
   *
   * <p>Method under test: {@link ServerBuildInfoImpl#asString(StringRepresentation)}
   */
  @Test
  @DisplayName("Test asString(StringRepresentation); then return '42-DEV-DEV'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ServerBuildInfoImpl.asString(StringRepresentation)"})
  void testAsString_thenReturn42DevDev() {
    // Arrange
    OptionalInt buildNumber = OptionalInt.empty();
    Optional<String> gitBranch = Optional.of("DEV");
    Optional<String> gitCommit = Optional.of("DEV");

    ServerBuildInfoImpl serverBuildInfoImpl =
        new ServerBuildInfoImpl(
            ServerBuildInfo.BRAND_PAPER_ID,
            "DEV",
            "42",
            "1.0.2",
            buildNumber,
            Main.BOOT_TIME,
            gitBranch,
            gitCommit);

    // Act and Assert
    assertEquals("42-DEV-DEV", serverBuildInfoImpl.asString(StringRepresentation.VERSION_SIMPLE));
  }
}
