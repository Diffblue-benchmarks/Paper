package ca.spottedleaf.moonrise.common.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityListDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityList#getRawData()}
   *   <li>{@link EntityList#size()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] EntityList.getRawData()", "int EntityList.size()"})
  void testGettersAndSetters() {
    // Arrange
    EntityList entityList = new EntityList();

    // Act
    Entity[] actualRawData = entityList.getRawData();

    // Assert
    assertEquals(0, entityList.size());
    assertEquals(0, actualRawData.length);
  }

  /**
   * Test {@link EntityList#iterator()}.
   *
   * <p>Method under test: {@link EntityList#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator EntityList.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new EntityList().iterator().hasNext());
  }

  /**
   * Test new {@link EntityList} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EntityList}
   */
  @Test
  @DisplayName("Test new EntityList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityList.<init>()"})
  void testNewEntityList() {
    // Arrange and Act
    EntityList actualEntityList = new EntityList();

    // Assert
    assertEquals(0, actualEntityList.size());
    assertEquals(0, actualEntityList.getRawData().length);
    assertFalse(actualEntityList.iterator().hasNext());
  }
}
