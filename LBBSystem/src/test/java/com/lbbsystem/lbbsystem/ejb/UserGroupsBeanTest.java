package com.lbbsystem.lbbsystem.ejb;

import static org.junit.jupiter.api.Assertions.*;
import com.lbbsystem.lbbsystem.roles.UserRole;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import jakarta.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

class UserGroupsBeanTest {

    @InjectMocks
    private UserGroupsBean userGroupsBean;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test findAllAdmins with available admins")
    void testFindAllAdmins() {
        // Arrange
        List<String> mockAdminsList = Arrays.asList("lastname.firstname@ulbsibiu.ro", "lastname2.firstname@ulbsibiu.ro");
        TypedQuery<String> mockedTypedQuery = Mockito.mock(TypedQuery.class);

        Mockito.when(entityManager.createQuery(Mockito.anyString(), Mockito.eq(String.class)))
                .thenReturn(mockedTypedQuery);
        Mockito.when(mockedTypedQuery.setParameter(Mockito.anyString(), Mockito.eq(UserRole.ADMIN)))
                .thenReturn(mockedTypedQuery);
        Mockito.when(mockedTypedQuery.getResultList())
                .thenReturn(mockAdminsList);

        // Act
        String[] adminsArray = userGroupsBean.findAllAdmins();

        // Assert
        assertArrayEquals(new String[]{"lastname.firstname@ulbsibiu.ro", "lastname2.firstname@ulbsibiu.ro"}, adminsArray);
    }

    @Test
    @DisplayName("Test findAllAdmins with no available admins")
    void testFindAllAdminsWithNoAdmins() {
        // Arrange
        TypedQuery<String> mockedTypedQuery = Mockito.mock(TypedQuery.class);

        Mockito.when(entityManager.createQuery(Mockito.anyString(), Mockito.eq(String.class)))
                .thenReturn(mockedTypedQuery);
        Mockito.when(mockedTypedQuery.setParameter(Mockito.anyString(), Mockito.eq(UserRole.ADMIN)))
                .thenReturn(mockedTypedQuery);
        Mockito.when(mockedTypedQuery.getResultList())
                .thenReturn(Arrays.asList());

        // Act
        String[] adminsArray = userGroupsBean.findAllAdmins();

        // Assert
        assertArrayEquals(new String[]{}, adminsArray);
    }

    @Test
    @DisplayName("Test findAllAdmins with exception during query execution")
    void testFindAllAdminsWithException() {
        // Arrange
        TypedQuery<String> mockedTypedQuery = Mockito.mock(TypedQuery.class);

        Mockito.when(entityManager.createQuery(Mockito.anyString(), Mockito.eq(String.class)))
                .thenReturn(mockedTypedQuery);
        Mockito.when(mockedTypedQuery.setParameter(Mockito.anyString(), Mockito.eq(UserRole.ADMIN)))
                .thenReturn(mockedTypedQuery);
        Mockito.when(mockedTypedQuery.getResultList())
                .thenThrow(new RuntimeException("Simulated exception during query execution"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> userGroupsBean.findAllAdmins());
    }
}
