package io.papermc.paper.plugin.lifecycle.event.registrar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.registrar.RegistrarEventImpl.ReloadableImpl;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegistrarEventImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegistrarEventImpl#RegistrarEventImpl(PaperRegistrar, Class)}
   *   <li>{@link RegistrarEventImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegistrarEventImpl.<init>(PaperRegistrar, Class)",
    "java.lang.String RegistrarEventImpl.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    // Act
    RegistrarEventImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        actualRegistrarEventImpl = new RegistrarEventImpl<>(paperRegistrar, ownerClass);
    actualRegistrarEventImpl.toString();

    // Assert
    assertSame(paperRegistrar, actualRegistrarEventImpl.registrar());
  }

  /**
   * Test ReloadableImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReloadableImpl#ReloadableImpl(PaperRegistrar, Class, Cause)}
   *   <li>{@link ReloadableImpl#toString()}
   *   <li>{@link ReloadableImpl#cause()}
   * </ul>
   */
  @Test
  @DisplayName("Test ReloadableImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReloadableImpl.<init>(PaperRegistrar, Class, Cause)",
    "Cause ReloadableImpl.cause()",
    "java.lang.String ReloadableImpl.toString()"
  })
  void testReloadableImplGettersAndSetters() {
    // Arrange
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    // Act
    ReloadableImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        actualReloadableImpl = new ReloadableImpl<>(paperRegistrar, ownerClass, Cause.INITIAL);
    actualReloadableImpl.toString();

    // Assert
    assertEquals(Cause.INITIAL, actualReloadableImpl.cause());
  }

  /**
   * Test {@link RegistrarEventImpl#setOwner(LifecycleEventOwner)}.
   *
   * <p>Method under test: {@link RegistrarEventImpl#setOwner(LifecycleEventOwner)}
   */
  @Test
  @DisplayName("Test setOwner(LifecycleEventOwner)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegistrarEventImpl.setOwner(LifecycleEventOwner)"})
  void testSetOwner() {
    // Arrange
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    doNothing().when(paperRegistrar).setCurrentContext(Mockito.<LifecycleEventOwner>any());
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    RegistrarEventImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        registrarEventImpl = new RegistrarEventImpl<>(paperRegistrar, ownerClass);

    // Act
    registrarEventImpl.setOwner(mock(LifecycleEventOwner.class));

    // Assert
    verify(paperRegistrar).setCurrentContext(isA(LifecycleEventOwner.class));
  }

  /**
   * Test {@link RegistrarEventImpl#castOwner(LifecycleEventOwner)}.
   *
   * <ul>
   *   <li>Then return {@link LifecycleEventOwner}.
   * </ul>
   *
   * <p>Method under test: {@link RegistrarEventImpl#castOwner(LifecycleEventOwner)}
   */
  @Test
  @DisplayName("Test castOwner(LifecycleEventOwner); then return LifecycleEventOwner")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecycleEventOwner RegistrarEventImpl.castOwner(LifecycleEventOwner)"})
  void testCastOwner_thenReturnLifecycleEventOwner() {
    // Arrange
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    RegistrarEventImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        registrarEventImpl = new RegistrarEventImpl<>(paperRegistrar, ownerClass);
    LifecycleEventOwner owner = mock(LifecycleEventOwner.class);

    // Act
    LifecycleEventOwner actualCastOwnerResult = registrarEventImpl.castOwner(owner);

    // Assert
    assertSame(owner, actualCastOwnerResult);
  }

  /**
   * Test {@link RegistrarEventImpl#invalidate()}.
   *
   * <p>Method under test: {@link RegistrarEventImpl#invalidate()}
   */
  @Test
  @DisplayName("Test invalidate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegistrarEventImpl.invalidate()"})
  void testInvalidate() {
    // Arrange
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    doNothing().when(paperRegistrar).invalidate();
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    RegistrarEventImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        registrarEventImpl = new RegistrarEventImpl<>(paperRegistrar, ownerClass);

    // Act
    registrarEventImpl.invalidate();

    // Assert
    verify(paperRegistrar).invalidate();
  }
}
