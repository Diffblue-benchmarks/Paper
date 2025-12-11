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
    Optional<String> gitCommit = Optional.of("42");

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
    assertEquals("42-DEV-42", serverBuildInfoImpl.asString(StringRepresentation.VERSION_SIMPLE));
  }

  /**
   * Test {@link ServerBuildInfoImpl#asString(StringRepresentation)}.
   *
   * <ul>
   *   <li>Given {@link OptionalInt} with forty-two.
   *   <li>When {@code VERSION_SIMPLE}.
   *   <li>Then return {@code 42-42-42}.
   * </ul>
   *
   * <p>Method under test: {@link ServerBuildInfoImpl#asString(StringRepresentation)}
   */
  @Test
  @DisplayName(
      "Test asString(StringRepresentation); given OptionalInt with forty-two; when 'VERSION_SIMPLE'; then return '42-42-42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ServerBuildInfoImpl.asString(StringRepresentation)"})
  void testAsString_givenOptionalIntWithFortyTwo_whenVersionSimple_thenReturn424242() {
    // Arrange
    OptionalInt buildNumber = OptionalInt.of(42);
    Optional<String> gitBranch = Optional.of("42");
    Optional<String> gitCommit = Optional.of("42");

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
    assertEquals("42-42-42", serverBuildInfoImpl.asString(StringRepresentation.VERSION_SIMPLE));
  }

  /**
   * Test {@link ServerBuildInfoImpl#asString(StringRepresentation)}.
   *
   * <ul>
   *   <li>Then return {@code 42-DEV-42}.
   * </ul>
   *
   * <p>Method under test: {@link ServerBuildInfoImpl#asString(StringRepresentation)}
   */
  @Test
  @DisplayName("Test asString(StringRepresentation); then return '42-DEV-42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ServerBuildInfoImpl.asString(StringRepresentation)"})
  void testAsString_thenReturn42Dev42() {
    // Arrange
    OptionalInt buildNumber = OptionalInt.empty();
    Optional<String> gitBranch = Optional.of("42");
    Optional<String> gitCommit = Optional.of("42");

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
    assertEquals("42-DEV-42", serverBuildInfoImpl.asString(StringRepresentation.VERSION_SIMPLE));
  }
}
