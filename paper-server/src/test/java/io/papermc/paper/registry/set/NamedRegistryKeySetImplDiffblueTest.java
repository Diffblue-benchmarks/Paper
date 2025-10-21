package io.papermc.paper.registry.set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.TypedKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Named;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NamedRegistryKeySetImplDiffblueTest {
  /**
   * Test {@link NamedRegistryKeySetImpl#values()}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link NamedRegistryKeySetImpl#values()}
   */
  @Test
  @DisplayName("Test values(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection NamedRegistryKeySetImpl.values()"})
  void testValues_thenReturnList() {
    // Arrange
    Named<Object> namedSet = mock(Named.class);

    ArrayList<Holder<Object>> holderList = new ArrayList<>();
    when(namedSet.iterator()).thenReturn(holderList.iterator());
    NamedRegistryKeySetImpl<Keyed, Object> namedRegistryKeySetImpl =
        new NamedRegistryKeySetImpl<>(null, namedSet);

    // Act
    Collection<TypedKey<Keyed>> actualValuesResult = namedRegistryKeySetImpl.values();

    // Assert
    verify(namedSet).iterator();
    assertTrue(actualValuesResult instanceof List);
    assertTrue(actualValuesResult.isEmpty());
  }

  /**
   * Test {@link NamedRegistryKeySetImpl#contains(TypedKey)}.
   *
   * <p>Method under test: {@link NamedRegistryKeySetImpl#contains(TypedKey)}
   */
  @Test
  @DisplayName("Test contains(TypedKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedRegistryKeySetImpl.contains(TypedKey)"})
  void testContains() {
    // Arrange
    Named<Object> namedSet = mock(Named.class);

    ArrayList<Holder<Object>> holderList = new ArrayList<>();
    when(namedSet.iterator()).thenReturn(holderList.iterator());
    NamedRegistryKeySetImpl<Keyed, Object> namedRegistryKeySetImpl =
        new NamedRegistryKeySetImpl<>(null, namedSet);

    // Act
    boolean actualContainsResult = namedRegistryKeySetImpl.contains(null);

    // Assert
    verify(namedSet).iterator();
    assertFalse(actualContainsResult);
  }
}
