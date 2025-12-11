package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.datacomponent.item.PaperUseCooldown.BuilderImpl;
import io.papermc.paper.datacomponent.item.UseCooldown.Builder;
import net.kyori.adventure.key.Key;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperUseCooldownDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UseCooldown BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    UseCooldown actualUseCooldown = new BuilderImpl(10.0f).build();

    // Assert
    assertTrue(actualUseCooldown instanceof PaperUseCooldown);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#cooldownGroup(Key)}.
   *
   * <p>Method under test: {@link BuilderImpl#cooldownGroup(Key)}
   */
  @Test
  @DisplayName("Test BuilderImpl cooldownGroup(Key)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.cooldownGroup(Key)"})
  void testBuilderImplCooldownGroup() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl(10.0f);

    // Act
    Builder actualCooldownGroupResult = builderImpl.cooldownGroup(ServerBuildInfo.BRAND_PAPER_ID);

    // Assert
    assertSame(builderImpl, actualCooldownGroupResult);
  }

  /**
   * Test {@link PaperUseCooldown#getHandle()}.
   *
   * <p>Method under test: {@link PaperUseCooldown#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.world.item.component.UseCooldown PaperUseCooldown.getHandle()"})
  void testGetHandle() {
    // Arrange
    net.minecraft.world.item.component.UseCooldown impl =
        new net.minecraft.world.item.component.UseCooldown(10.0f);

    // Act and Assert
    assertSame(impl, new PaperUseCooldown(impl).getHandle());
  }

  /**
   * Test {@link PaperUseCooldown#seconds()}.
   *
   * <ul>
   *   <li>Given {@link net.minecraft.world.item.component.UseCooldown#UseCooldown(float)} with
   *       seconds is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperUseCooldown#seconds()}
   */
  @Test
  @DisplayName("Test seconds(); given UseCooldown(float) with seconds is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperUseCooldown.seconds()"})
  void testSeconds_givenUseCooldownWithSecondsIsTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f,
        new PaperUseCooldown(new net.minecraft.world.item.component.UseCooldown(10.0f)).seconds());
  }

  /**
   * Test {@link PaperUseCooldown#cooldownGroup()}.
   *
   * <ul>
   *   <li>Given {@link net.minecraft.world.item.component.UseCooldown#UseCooldown(float)} with
   *       seconds is ten.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperUseCooldown#cooldownGroup()}
   */
  @Test
  @DisplayName(
      "Test cooldownGroup(); given UseCooldown(float) with seconds is ten; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperUseCooldown.cooldownGroup()"})
  void testCooldownGroup_givenUseCooldownWithSecondsIsTen_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new PaperUseCooldown(new net.minecraft.world.item.component.UseCooldown(10.0f))
            .cooldownGroup());
  }
}
