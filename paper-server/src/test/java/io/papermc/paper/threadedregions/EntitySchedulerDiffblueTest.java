package io.papermc.paper.threadedregions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.threadedregions.EntityScheduler.EntitySchedulerTickList;
import java.util.function.Consumer;
import org.bukkit.craftbukkit.entity.CraftAgeable;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntitySchedulerDiffblueTest {
  @Mock private CraftEntity craftEntity;

  @InjectMocks private EntityScheduler entityScheduler;

  /**
   * Test EntitySchedulerTickList {@link EntitySchedulerTickList#add(EntityScheduler)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySchedulerTickList#add(EntityScheduler)}
   */
  @Test
  @DisplayName(
      "Test EntitySchedulerTickList add(EntityScheduler); when 'null'; then first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntitySchedulerTickList.add(EntityScheduler)"})
  void testEntitySchedulerTickListAdd_whenNull_thenFirstElementIsNull() {
    // Arrange
    EntitySchedulerTickList entitySchedulerTickList = new EntitySchedulerTickList();

    // Act
    boolean actualAddResult = entitySchedulerTickList.add(null);

    // Assert
    EntityScheduler[] allSchedulers = entitySchedulerTickList.getAllSchedulers();
    assertNull(allSchedulers[0]);
    assertEquals(1, allSchedulers.length);
    assertTrue(actualAddResult);
  }

  /**
   * Test EntitySchedulerTickList {@link EntitySchedulerTickList#getAllSchedulers()}.
   *
   * <p>Method under test: {@link EntitySchedulerTickList#getAllSchedulers()}
   */
  @Test
  @DisplayName("Test EntitySchedulerTickList getAllSchedulers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityScheduler[] EntitySchedulerTickList.getAllSchedulers()"})
  void testEntitySchedulerTickListGetAllSchedulers() {
    // Arrange, Act and Assert
    assertEquals(0, new EntitySchedulerTickList().getAllSchedulers().length);
  }

  /**
   * Test EntitySchedulerTickList new {@link EntitySchedulerTickList} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EntitySchedulerTickList}
   */
  @Test
  @DisplayName("Test EntitySchedulerTickList new EntitySchedulerTickList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySchedulerTickList.<init>()"})
  void testEntitySchedulerTickListNewEntitySchedulerTickList() {
    // Arrange, Act and Assert
    assertEquals(0, new EntitySchedulerTickList().getAllSchedulers().length);
  }

  /**
   * Test {@link EntityScheduler#EntityScheduler(CraftEntity)}.
   *
   * <ul>
   *   <li>When {@link CraftEntity}.
   *   <li>Then return not Retired.
   * </ul>
   *
   * <p>Method under test: {@link EntityScheduler#EntityScheduler(CraftEntity)}
   */
  @Test
  @DisplayName("Test new EntityScheduler(CraftEntity); when CraftEntity; then return not Retired")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.<init>(CraftEntity)"})
  void testNewEntityScheduler_whenCraftEntity_thenReturnNotRetired() {
    // Arrange, Act and Assert
    assertFalse(new EntityScheduler(craftEntity).isRetired());
  }

  /**
   * Test {@link EntityScheduler#registerTo(EntitySchedulerTickList)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityScheduler#registerTo(EntitySchedulerTickList)}
   */
  @Test
  @DisplayName(
      "Test registerTo(EntitySchedulerTickList); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.registerTo(EntitySchedulerTickList)"})
  void testRegisterTo_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    EntityScheduler entityScheduler = new EntityScheduler(mock(CraftAgeable.class));
    entityScheduler.schedule(mock(Consumer.class), mock(Consumer.class), 1L);

    EntitySchedulerTickList newTickList = mock(EntitySchedulerTickList.class);
    when(newTickList.add(Mockito.<EntityScheduler>any())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> entityScheduler.registerTo(newTickList));
    verify(newTickList).add(isA(EntityScheduler.class));
  }

  /**
   * Test {@link EntityScheduler#registerTo(EntitySchedulerTickList)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link EntitySchedulerTickList} {@link EntitySchedulerTickList#add(EntityScheduler)}
   *       return {@code true}.
   *   <li>Then calls {@link EntitySchedulerTickList#add(EntityScheduler)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityScheduler#registerTo(EntitySchedulerTickList)}
   */
  @Test
  @DisplayName(
      "Test registerTo(EntitySchedulerTickList); given 'true'; when EntitySchedulerTickList add(EntityScheduler) return 'true'; then calls add(EntityScheduler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.registerTo(EntitySchedulerTickList)"})
  void testRegisterTo_givenTrue_whenEntitySchedulerTickListAddReturnTrue_thenCallsAdd() {
    // Arrange
    EntityScheduler entityScheduler = new EntityScheduler(mock(CraftAgeable.class));
    entityScheduler.schedule(mock(Consumer.class), mock(Consumer.class), 1L);

    EntitySchedulerTickList newTickList = mock(EntitySchedulerTickList.class);
    when(newTickList.add(Mockito.<EntityScheduler>any())).thenReturn(true);

    // Act
    entityScheduler.registerTo(newTickList);

    // Assert
    verify(newTickList).add(isA(EntityScheduler.class));
  }

  /**
   * Test {@link EntityScheduler#registerTo(EntitySchedulerTickList)}.
   *
   * <ul>
   *   <li>Then array length is two.
   * </ul>
   *
   * <p>Method under test: {@link EntityScheduler#registerTo(EntitySchedulerTickList)}
   */
  @Test
  @DisplayName("Test registerTo(EntitySchedulerTickList); then array length is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.registerTo(EntitySchedulerTickList)"})
  void testRegisterTo_thenArrayLengthIsTwo() {
    // Arrange
    EntityScheduler entityScheduler = new EntityScheduler(mock(CraftAgeable.class));
    entityScheduler.schedule(mock(Consumer.class), mock(Consumer.class), 1L);

    EntitySchedulerTickList newTickList = new EntitySchedulerTickList();
    newTickList.add(new EntityScheduler(mock(CraftAgeable.class)));

    // Act
    entityScheduler.registerTo(newTickList);

    // Assert
    EntityScheduler[] allSchedulers = newTickList.getAllSchedulers();
    assertEquals(2, allSchedulers.length);
    assertSame(entityScheduler, allSchedulers[1]);
  }

  /**
   * Test {@link EntityScheduler#registerTo(EntitySchedulerTickList)}.
   *
   * <ul>
   *   <li>When {@link EntitySchedulerTickList} (default constructor).
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityScheduler#registerTo(EntitySchedulerTickList)}
   */
  @Test
  @DisplayName(
      "Test registerTo(EntitySchedulerTickList); when EntitySchedulerTickList (default constructor); then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.registerTo(EntitySchedulerTickList)"})
  void testRegisterTo_whenEntitySchedulerTickList_thenArrayLengthIsOne() {
    // Arrange
    EntityScheduler entityScheduler = new EntityScheduler(mock(CraftAgeable.class));
    entityScheduler.schedule(mock(Consumer.class), mock(Consumer.class), 1L);
    EntitySchedulerTickList newTickList = new EntitySchedulerTickList();

    // Act
    entityScheduler.registerTo(newTickList);

    // Assert
    EntityScheduler[] allSchedulers = newTickList.getAllSchedulers();
    assertEquals(1, allSchedulers.length);
    assertSame(entityScheduler, allSchedulers[0]);
  }

  /**
   * Test {@link EntityScheduler#registerTo(EntitySchedulerTickList)}.
   *
   * <ul>
   *   <li>When {@link EntitySchedulerTickList} (default constructor).
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityScheduler#registerTo(EntitySchedulerTickList)}
   */
  @Test
  @DisplayName(
      "Test registerTo(EntitySchedulerTickList); when EntitySchedulerTickList (default constructor); then array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.registerTo(EntitySchedulerTickList)"})
  void testRegisterTo_whenEntitySchedulerTickList_thenArrayLengthIsZero() {
    // Arrange
    EntityScheduler entityScheduler = new EntityScheduler(mock(CraftAgeable.class));
    EntitySchedulerTickList newTickList = new EntitySchedulerTickList();

    // Act
    entityScheduler.registerTo(newTickList);

    // Assert that nothing has changed
    assertEquals(0, newTickList.getAllSchedulers().length);
  }

  /**
   * Test {@link EntityScheduler#registerTo(EntitySchedulerTickList)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link EntityScheduler#registerTo(EntitySchedulerTickList)}
   */
  @Test
  @DisplayName("Test registerTo(EntitySchedulerTickList); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.registerTo(EntitySchedulerTickList)"})
  void testRegisterTo_whenNull_thenDoesNotThrow() {
    // Arrange
    EntityScheduler entityScheduler = new EntityScheduler(mock(CraftAgeable.class));
    entityScheduler.schedule(mock(Consumer.class), mock(Consumer.class), 1L);

    // Act and Assert
    assertDoesNotThrow(() -> entityScheduler.registerTo(null));
  }

  /**
   * Test {@link EntityScheduler#isRetired()}.
   *
   * <p>Method under test: {@link EntityScheduler#isRetired()}
   */
  @Test
  @DisplayName("Test isRetired()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityScheduler.isRetired()"})
  void testIsRetired() {
    // Arrange, Act and Assert
    assertFalse(entityScheduler.isRetired());
  }

  /**
   * Test {@link EntityScheduler#retire()}.
   *
   * <p>Method under test: {@link EntityScheduler#retire()}
   */
  @Test
  @DisplayName("Test retire()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.retire()"})
  void testRetire() {
    // Arrange
    when(craftEntity.getHandleRaw()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> entityScheduler.retire());
    verify(craftEntity).getHandleRaw();
  }

  /**
   * Test {@link EntityScheduler#schedule(Consumer, Consumer, long)}.
   *
   * <ul>
   *   <li>When {@link Consumer}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityScheduler#schedule(Consumer, Consumer, long)}
   */
  @Test
  @DisplayName("Test schedule(Consumer, Consumer, long); when Consumer; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityScheduler.schedule(Consumer, Consumer, long)"})
  void testSchedule_whenConsumer_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(entityScheduler.schedule(mock(Consumer.class), mock(Consumer.class), 1L));
  }

  /**
   * Test {@link EntityScheduler#executeTick()}.
   *
   * <p>Method under test: {@link EntityScheduler#executeTick()}
   */
  @Test
  @DisplayName("Test executeTick()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityScheduler.executeTick()"})
  void testExecuteTick() {
    // Arrange
    when(craftEntity.getHandleRaw()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> entityScheduler.executeTick());
    verify(craftEntity).getHandleRaw();
  }
}
