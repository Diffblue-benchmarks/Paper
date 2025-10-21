package io.papermc.paper.registry.tag;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.registry.RegistryKey;
import net.kyori.adventure.key.Key;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagKeyDiffblueTest {
  /**
   * Test {@link TagKey#create(RegistryKey, Key)} with {@code RegistryKey}, {@code Key}.
   *
   * <p>Method under test: {@link TagKey#create(RegistryKey, Key)}
   */
  @Test
  @DisplayName("Test create(RegistryKey, Key) with 'RegistryKey', 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagKey TagKey.create(RegistryKey, Key)"})
  void testCreateWithRegistryKeyKey() {
    // Arrange
    Key key = ServerBuildInfo.BRAND_PAPER_ID;

    // Act
    TagKey<Object> actualCreateResult = TagKey.create(null, key);

    // Assert
    assertTrue(actualCreateResult instanceof TagKeyImpl);
    assertNull(actualCreateResult.registryKey());
    assertSame(key, actualCreateResult.key());
  }

  /**
   * Test {@link TagKey#create(RegistryKey, String)} with {@code RegistryKey}, {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link TagKeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link TagKey#create(RegistryKey, String)}
   */
  @Test
  @DisplayName(
      "Test create(RegistryKey, String) with 'RegistryKey', 'String'; when '42'; then return TagKeyImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagKey TagKey.create(RegistryKey, String)"})
  void testCreateWithRegistryKeyString_when42_thenReturnTagKeyImpl() {
    // Arrange and Act
    TagKey<Object> actualCreateResult = TagKey.create(null, "42");

    // Assert
    assertTrue(actualCreateResult instanceof TagKeyImpl);
    assertNull(actualCreateResult.registryKey());
  }
}
