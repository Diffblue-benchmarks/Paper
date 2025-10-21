package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperWeapon.BuilderImpl;
import io.papermc.paper.datacomponent.item.Weapon.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperWeaponDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BuilderImpl#build()}
   *   <li>default or parameterless constructor of {@link BuilderImpl}
   * </ul>
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>()", "Weapon BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    Weapon actualWeapon = new BuilderImpl().build();

    // Assert
    assertTrue(actualWeapon instanceof PaperWeapon);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#disableBlockingForSeconds(float)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link BuilderImpl} (default constructor) build {@link PaperWeapon}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#disableBlockingForSeconds(float)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl disableBlockingForSeconds(float); when ten; then BuilderImpl (default constructor) build PaperWeapon")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.disableBlockingForSeconds(float)"})
  void testBuilderImplDisableBlockingForSeconds_whenTen_thenBuilderImplBuildPaperWeapon() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualDisableBlockingForSecondsResult = builderImpl.disableBlockingForSeconds(10.0f);

    // Assert
    Weapon weapon = builderImpl.build();
    assertTrue(weapon instanceof PaperWeapon);
    assertEquals(10.0f, ((PaperWeapon) weapon).getHandle().disableBlockingForSeconds());
    assertSame(builderImpl, actualDisableBlockingForSecondsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#itemDamagePerAttack(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link BuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#itemDamagePerAttack(int)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl itemDamagePerAttack(int); when one; then return BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.itemDamagePerAttack(int)"})
  void testBuilderImplItemDamagePerAttack_whenOne_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualItemDamagePerAttackResult = builderImpl.itemDamagePerAttack(1);

    // Assert
    assertSame(builderImpl, actualItemDamagePerAttackResult);
  }

  /**
   * Test {@link PaperWeapon#getHandle()}.
   *
   * <p>Method under test: {@link PaperWeapon#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.world.item.component.Weapon PaperWeapon.getHandle()"})
  void testGetHandle() {
    // Arrange
    net.minecraft.world.item.component.Weapon impl =
        new net.minecraft.world.item.component.Weapon(42);

    // Act and Assert
    assertSame(impl, new PaperWeapon(impl).getHandle());
  }

  /**
   * Test {@link PaperWeapon#itemDamagePerAttack()}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link PaperWeapon#itemDamagePerAttack()}
   */
  @Test
  @DisplayName("Test itemDamagePerAttack(); then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperWeapon.itemDamagePerAttack()"})
  void testItemDamagePerAttack_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42,
        new PaperWeapon(new net.minecraft.world.item.component.Weapon(42)).itemDamagePerAttack());
  }

  /**
   * Test {@link PaperWeapon#disableBlockingForSeconds()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperWeapon#disableBlockingForSeconds()}
   */
  @Test
  @DisplayName("Test disableBlockingForSeconds(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperWeapon.disableBlockingForSeconds()"})
  void testDisableBlockingForSeconds_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0f,
        new PaperWeapon(new net.minecraft.world.item.component.Weapon(42))
            .disableBlockingForSeconds());
  }
}
