package io.papermc.paper.registry.data.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.kyori.adventure.key.Key;
import net.kyori.examination.ExaminableProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClientTextureAssetImplDiffblueTest {
  /**
   * Test {@link ClientTextureAssetImpl#pathFromIdentifier(Key)}.
   *
   * <ul>
   *   <li>When {@link ServerBuildInfo#BRAND_PAPER_ID}.
   *   <li>Then return examinableName is {@code KeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ClientTextureAssetImpl#pathFromIdentifier(Key)}
   */
  @Test
  @DisplayName(
      "Test pathFromIdentifier(Key); when BRAND_PAPER_ID; then return examinableName is 'KeyImpl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key ClientTextureAssetImpl.pathFromIdentifier(Key)"})
  void testPathFromIdentifier_whenBrand_paper_id_thenReturnExaminableNameIsKeyImpl() {
    // Arrange and Act
    Key actualPathFromIdentifierResult =
        ClientTextureAssetImpl.pathFromIdentifier(ServerBuildInfo.BRAND_PAPER_ID);

    // Assert
    assertEquals("KeyImpl", actualPathFromIdentifierResult.examinableName());
    assertEquals("papermc:textures/paper.png", actualPathFromIdentifierResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualPathFromIdentifierResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }
}
