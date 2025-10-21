package io.papermc.paper.registry.data.client;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import net.kyori.adventure.key.Key;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClientTextureAssetDiffblueTest {
  /**
   * Test {@link ClientTextureAsset#clientTextureAsset(Key, Key)} with {@code Key}, {@code Key}.
   *
   * <p>Method under test: {@link ClientTextureAsset#clientTextureAsset(Key, Key)}
   */
  @Test
  @DisplayName("Test clientTextureAsset(Key, Key) with 'Key', 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientTextureAsset ClientTextureAsset.clientTextureAsset(Key, Key)"})
  void testClientTextureAssetWithKeyKey() {
    // Arrange
    Key texturePath = ServerBuildInfo.BRAND_PAPER_ID;

    // Act
    ClientTextureAsset actualClientTextureAssetResult =
        ClientTextureAsset.clientTextureAsset(ServerBuildInfo.BRAND_PAPER_ID, texturePath);

    // Assert
    assertTrue(actualClientTextureAssetResult instanceof ClientTextureAssetImpl);
    assertSame(texturePath, actualClientTextureAssetResult.identifier());
    assertSame(texturePath, actualClientTextureAssetResult.texturePath());
  }

  /**
   * Test {@link ClientTextureAsset#clientTextureAsset(Key)} with {@code Key}.
   *
   * <ul>
   *   <li>Then return {@link ClientTextureAssetImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ClientTextureAsset#clientTextureAsset(Key)}
   */
  @Test
  @DisplayName("Test clientTextureAsset(Key) with 'Key'; then return ClientTextureAssetImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientTextureAsset ClientTextureAsset.clientTextureAsset(Key)"})
  void testClientTextureAssetWithKey_thenReturnClientTextureAssetImpl() {
    // Arrange
    Key identifier = ServerBuildInfo.BRAND_PAPER_ID;

    // Act
    ClientTextureAsset actualClientTextureAssetResult =
        ClientTextureAsset.clientTextureAsset(identifier);

    // Assert
    assertTrue(actualClientTextureAssetResult instanceof ClientTextureAssetImpl);
    assertSame(identifier, actualClientTextureAssetResult.identifier());
  }

  /**
   * Test {@link ClientTextureAsset#clientTextureAsset(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link ClientTextureAssetImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ClientTextureAsset#clientTextureAsset(String)}
   */
  @Test
  @DisplayName(
      "Test clientTextureAsset(String) with 'String'; when '42'; then return ClientTextureAssetImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientTextureAsset ClientTextureAsset.clientTextureAsset(String)"})
  void testClientTextureAssetWithString_when42_thenReturnClientTextureAssetImpl() {
    // Arrange, Act and Assert
    assertTrue(ClientTextureAsset.clientTextureAsset("42") instanceof ClientTextureAssetImpl);
  }
}
