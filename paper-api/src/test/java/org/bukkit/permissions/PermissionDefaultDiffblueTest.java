package org.bukkit.permissions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PermissionDefaultDiffblueTest {
  /**
   * Test {@link PermissionDefault#getValue(boolean)}.
   *
   * <ul>
   *   <li>Given {@code FALSE}.
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getValue(boolean)}
   */
  @Test
  @DisplayName("Test getValue(boolean); given 'FALSE'; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionDefault.getValue(boolean)"})
  void testGetValue_givenFalse_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PermissionDefault.FALSE.getValue(false));
  }

  /**
   * Test {@link PermissionDefault#getValue(boolean)}.
   *
   * <ul>
   *   <li>Given {@code NOT_OP}.
   *   <li>When {@code false}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getValue(boolean)}
   */
  @Test
  @DisplayName("Test getValue(boolean); given 'NOT_OP'; when 'false'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionDefault.getValue(boolean)"})
  void testGetValue_givenNotOp_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PermissionDefault.NOT_OP.getValue(false));
  }

  /**
   * Test {@link PermissionDefault#getValue(boolean)}.
   *
   * <ul>
   *   <li>Given {@code NOT_OP}.
   *   <li>When {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getValue(boolean)}
   */
  @Test
  @DisplayName("Test getValue(boolean); given 'NOT_OP'; when 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionDefault.getValue(boolean)"})
  void testGetValue_givenNotOp_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PermissionDefault.NOT_OP.getValue(true));
  }

  /**
   * Test {@link PermissionDefault#getValue(boolean)}.
   *
   * <ul>
   *   <li>Given {@code OP}.
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getValue(boolean)}
   */
  @Test
  @DisplayName("Test getValue(boolean); given 'OP'; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionDefault.getValue(boolean)"})
  void testGetValue_givenOp_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PermissionDefault.OP.getValue(false));
  }

  /**
   * Test {@link PermissionDefault#getValue(boolean)}.
   *
   * <ul>
   *   <li>Given {@code TRUE}.
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getValue(boolean)}
   */
  @Test
  @DisplayName("Test getValue(boolean); given 'TRUE'; when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionDefault.getValue(boolean)"})
  void testGetValue_givenTrue_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PermissionDefault.TRUE.getValue(true));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42AZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("42[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42!admin}.
   *   <li>Then return {@code NOT_OP}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42!admin'; then return 'NOT_OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42Admin_thenReturnNotOp() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.NOT_OP, PermissionDefault.getByName("42!admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42Name_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("42Name"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42admin}.
   *   <li>Then return {@code OP}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42admin'; then return 'OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42admin_thenReturnOp() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.OP, PermissionDefault.getByName("42admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42FALSE}.
   *   <li>Then return {@code FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42FALSE'; then return 'FALSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42false_thenReturnFalse() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.FALSE, PermissionDefault.getByName("42FALSE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42isadmin}.
   *   <li>Then return {@code OP}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42isadmin'; then return 'OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42isadmin_thenReturnOp() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.OP, PermissionDefault.getByName("42isadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42notadmin}.
   *   <li>Then return {@code NOT_OP}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42notadmin'; then return 'NOT_OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42notadmin_thenReturnNotOp() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.NOT_OP, PermissionDefault.getByName("42notadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42TRUE}.
   *   <li>Then return {@code TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42TRUE'; then return 'TRUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42true_thenReturnTrue() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.TRUE, PermissionDefault.getByName("42TRUE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 42U}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '42U'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when42u_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("42U"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '4242'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_when4242_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("4242"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZ42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!][^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!][^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!][^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]!admin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]!admin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZAdmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]!admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]admin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]admin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZAdmin_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]FALSE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]FALSE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]isadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]isadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZIsadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]isadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]Name"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]notadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]notadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZNotadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]notadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]TRUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]TRUE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]TRUE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]U42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]U42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZU42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]U42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]U[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]U[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]U[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]U!admin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]U!admin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUAdmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]U!admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]UName}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]UName'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]UName"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]U}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]U'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZU_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]U"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]Uadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]Uadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]Uadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]UFALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]UFALSE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUfalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]UFALSE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]Uisadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]Uisadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUisadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]Uisadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]Unotadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]Unotadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUnotadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]Unotadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]UTRUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]UTRUE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUtrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]UTRUE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]UU}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]UU'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZUu_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]UU"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code !admin42}.
   *   <li>Then return {@code NOT_OP}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '!admin42'; then return 'NOT_OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAdmin42_thenReturnNotOp() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.NOT_OP, PermissionDefault.getByName("!admin42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code admin42}.
   *   <li>Then return {@code OP}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'admin42'; then return 'OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAdmin42_thenReturnOp() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.OP, PermissionDefault.getByName("admin42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code !admin[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when '!admin[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAdminAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("!admin[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code admin[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'admin[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenAdminAZ_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("admin[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code FALSE42}.
   *   <li>Then return {@code FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'FALSE42'; then return 'FALSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenFalse42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.FALSE, PermissionDefault.getByName("FALSE42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code FALSE[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'FALSE[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenFalseAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("FALSE[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code isadmin42}.
   *   <li>Then return {@code OP}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'isadmin42'; then return 'OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenIsadmin42_thenReturnOp() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.OP, PermissionDefault.getByName("isadmin42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code isadmin[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'isadmin[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenIsadminAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("isadmin[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Name42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Name42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenName42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Name42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Name[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Name[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenNameAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Name[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Name"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code notadmin42}.
   *   <li>Then return {@code NOT_OP}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'notadmin42'; then return 'NOT_OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenNotadmin42_thenReturnNotOp() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.NOT_OP, PermissionDefault.getByName("notadmin42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code notadmin[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'notadmin[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenNotadminAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("notadmin[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code TRUE42}.
   *   <li>Then return {@code TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'TRUE42'; then return 'TRUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenTrue42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.TRUE, PermissionDefault.getByName("TRUE42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code TRUE[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'TRUE[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenTrueAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("TRUE[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42AZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42!admin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42!admin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42Admin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42!admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42Name_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42Name"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42admin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42admin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42admin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42FALSE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42false_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42FALSE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42isadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42isadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42isadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42isadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42notadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42notadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42notadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42notadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42TRUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42TRUE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42true_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42TRUE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U42U}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U42U'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU42u_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U42U"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U4242}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U4242'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenU4242_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U4242"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZ42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!][^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!][^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!][^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]!admin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]!admin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZAdmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]!admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]admin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]admin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZAdmin_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]admin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]FALSE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]FALSE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]isadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]isadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZIsadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]isadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]Name"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]notadmin}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]notadmin'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZNotadmin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]notadmin"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]TRUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]TRUE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]TRUE"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]U}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]U'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZU_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]U"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U!admin42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U!admin42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAdmin42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U!admin42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code U!admin[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'U!admin[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUAdminAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("U!admin[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code UName42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'UName42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUName42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("UName42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code UName[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'UName[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUNameAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("UName[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Uadmin42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Uadmin42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUadmin42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Uadmin42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Uadmin[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Uadmin[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUadminAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Uadmin[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code UFALSE42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'UFALSE42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUfalse42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("UFALSE42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code UFALSE[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'UFALSE[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUfalseAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("UFALSE[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Uisadmin42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Uisadmin42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUisadmin42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Uisadmin42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Uisadmin[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Uisadmin[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUisadminAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Uisadmin[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Unotadmin42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Unotadmin42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUnotadmin42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Unotadmin42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code Unotadmin[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'Unotadmin[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUnotadminAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("Unotadmin[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code UTRUE42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'UTRUE42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUtrue42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("UTRUE42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code UTRUE[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'UTRUE[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUtrueAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("UTRUE[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code UU42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'UU42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUu42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("UU42"));
  }

  /**
   * Test {@link PermissionDefault#getByName(String)}.
   *
   * <ul>
   *   <li>When {@code UU[^a-z!]}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionDefault#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String); when 'UU[^a-z!]'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PermissionDefault.getByName(String)"})
  void testGetByName_whenUuAZ_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PermissionDefault.getByName("UU[^a-z!]"));
  }

  /**
   * Test {@link PermissionDefault#toString()}.
   *
   * <p>Method under test: {@link PermissionDefault#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PermissionDefault.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(Boolean.TRUE.toString(), PermissionDefault.valueOf("TRUE").toString());
  }
}
