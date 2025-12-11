package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.Fireworks.Builder;
import io.papermc.paper.datacomponent.item.PaperFireworks.BuilderImpl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperFireworksDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addEffects(List)}.
   *
   * <p>Method under test: {@link BuilderImpl#addEffects(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addEffects(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addEffects(List)"})
  void testBuilderImplAddEffects() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddEffectsResult = builderImpl.addEffects(new ArrayList<>());

    // Assert
    assertSame(builderImpl, actualAddEffectsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Fireworks BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    Fireworks actualFireworks = new BuilderImpl().build();

    // Assert
    assertTrue(actualFireworks instanceof PaperFireworks);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#flightDuration(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link BuilderImpl} (default constructor) build {@link PaperFireworks}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#flightDuration(int)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl flightDuration(int); when one; then BuilderImpl (default constructor) build PaperFireworks")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.flightDuration(int)"})
  void testBuilderImplFlightDuration_whenOne_thenBuilderImplBuildPaperFireworks() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualFlightDurationResult = builderImpl.flightDuration(1);

    // Assert
    Fireworks fireworks = builderImpl.build();
    assertTrue(fireworks instanceof PaperFireworks);
    assertEquals(1, ((PaperFireworks) fireworks).getHandle().flightDuration());
    assertSame(builderImpl, actualFlightDurationResult);
  }

  /**
   * Test BuilderImpl new {@link BuilderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BuilderImpl}
   */
  @Test
  @DisplayName("Test BuilderImpl new BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>()"})
  void testBuilderImplNewBuilderImpl() {
    // Arrange, Act and Assert
    Fireworks fireworks = new BuilderImpl().build();
    assertTrue(fireworks instanceof PaperFireworks);
    net.minecraft.world.item.component.Fireworks handle = ((PaperFireworks) fireworks).getHandle();
    assertEquals(0, handle.flightDuration());
    assertTrue(handle.explosions().isEmpty());
    assertSame(handle, ((PaperFireworks) fireworks).impl());
  }

  /**
   * Test {@link PaperFireworks#getHandle()}.
   *
   * <p>Method under test: {@link PaperFireworks#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.world.item.component.Fireworks PaperFireworks.getHandle()"})
  void testGetHandle() {
    // Arrange
    net.minecraft.world.item.component.Fireworks impl =
        new net.minecraft.world.item.component.Fireworks(1, new ArrayList<>());

    // Act and Assert
    assertSame(impl, new PaperFireworks(impl).getHandle());
  }

  /**
   * Test {@link PaperFireworks#effects()}.
   *
   * <ul>
   *   <li>Given {@link net.minecraft.world.item.component.Fireworks#Fireworks(int, List)} with
   *       flightDuration is one and explosions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperFireworks#effects()}
   */
  @Test
  @DisplayName(
      "Test effects(); given Fireworks(int, List) with flightDuration is one and explosions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperFireworks.effects()"})
  void testEffects_givenFireworksWithFlightDurationIsOneAndExplosionsIsArrayList() {
    // Arrange
    net.minecraft.world.item.component.Fireworks impl =
        new net.minecraft.world.item.component.Fireworks(1, new ArrayList<>());

    // Act and Assert
    assertTrue(new PaperFireworks(impl).effects().isEmpty());
  }

  /**
   * Test {@link PaperFireworks#effects()}.
   *
   * <ul>
   *   <li>Given {@link net.minecraft.world.item.component.Fireworks#Fireworks(int, List)} with
   *       flightDuration is one and explosions is {@link LinkedList#LinkedList()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperFireworks#effects()}
   */
  @Test
  @DisplayName(
      "Test effects(); given Fireworks(int, List) with flightDuration is one and explosions is LinkedList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperFireworks.effects()"})
  void testEffects_givenFireworksWithFlightDurationIsOneAndExplosionsIsLinkedList() {
    // Arrange
    net.minecraft.world.item.component.Fireworks impl =
        new net.minecraft.world.item.component.Fireworks(1, new LinkedList<>());

    // Act and Assert
    assertTrue(new PaperFireworks(impl).effects().isEmpty());
  }

  /**
   * Test {@link PaperFireworks#flightDuration()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PaperFireworks#flightDuration()}
   */
  @Test
  @DisplayName("Test flightDuration(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperFireworks.flightDuration()"})
  void testFlightDuration_thenReturnOne() {
    // Arrange
    net.minecraft.world.item.component.Fireworks impl =
        new net.minecraft.world.item.component.Fireworks(1, new ArrayList<>());

    // Act and Assert
    assertEquals(1, new PaperFireworks(impl).flightDuration());
  }
}
