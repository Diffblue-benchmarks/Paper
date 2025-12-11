package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.ItemEnchantments.Builder;
import io.papermc.paper.datacomponent.item.PaperItemEnchantments.BuilderImpl;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.enchantments.Enchantment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperItemEnchantmentsDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addAll(Map)}.
   *
   * <ul>
   *   <li>Given {@link BuilderImpl} (default constructor) add {@code null} and one.
   *   <li>When {@link HashMap#HashMap()} {@code null} is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addAll(Map)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addAll(Map); given BuilderImpl (default constructor) add 'null' and one; when HashMap() 'null' is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addAll(Map)"})
  void testBuilderImplAddAll_givenBuilderImplAddNullAndOne_whenHashMapNullIsFortyTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.add(null, 1);

    HashMap<Enchantment, Integer> enchantments = new HashMap<>();
    enchantments.put(null, 42);

    // Act
    Builder actualAddAllResult = builderImpl.addAll(enchantments);

    // Assert
    assertTrue(actualAddAllResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddAllResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addAll(Map)}.
   *
   * <ul>
   *   <li>Given {@link BuilderImpl} (default constructor).
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link BuilderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addAll(Map)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addAll(Map); given BuilderImpl (default constructor); when HashMap(); then return BuilderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addAll(Map)"})
  void testBuilderImplAddAll_givenBuilderImpl_whenHashMap_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddAllResult = builderImpl.addAll(new HashMap<>());

    // Assert
    assertTrue(actualAddAllResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddAllResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addAll(Map)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>When {@link HashMap#HashMap()} {@code null} is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addAll(Map)}
   */
  @Test
  @DisplayName("Test BuilderImpl addAll(Map); given forty-two; when HashMap() 'null' is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addAll(Map)"})
  void testBuilderImplAddAll_givenFortyTwo_whenHashMapNullIsFortyTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    HashMap<Enchantment, Integer> enchantments = new HashMap<>();
    enchantments.put(null, 42);

    // Act
    Builder actualAddAllResult = builderImpl.addAll(enchantments);

    // Assert
    assertTrue(actualAddAllResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddAllResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#add(Enchantment, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@link BuilderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#add(Enchantment, int)}
   */
  @Test
  @DisplayName("Test BuilderImpl add(Enchantment, int); when two; then return BuilderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.add(Enchantment, int)"})
  void testBuilderImplAdd_whenTwo_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddResult = builderImpl.add(null, 2);

    // Assert
    assertTrue(actualAddResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddResult);
  }

  /**
   * Test {@link PaperItemEnchantments#getHandle()}.
   *
   * <p>Method under test: {@link PaperItemEnchantments#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.enchantment.ItemEnchantments PaperItemEnchantments.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    PaperItemEnchantments paperItemEnchantments = new PaperItemEnchantments(null, new HashMap<>());

    // Act and Assert
    assertNull(paperItemEnchantments.getHandle());
  }
}
