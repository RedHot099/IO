package put.io.testing.mocks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

import java.rmi.ConnectException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManagerTest {

    private ExpenseRepository repo;
    private Expense e1 = new Expense("Title1", "Home", 100),
                    e2 = new Expense("Title2", "Home", 200),
                    e3 = new Expense("Title3", "Car", 300),
                    e4 = new Expense("Title4", "Car", 100),
                    e5 = new Expense("Title5", "Food", 200),
                    e6 = new Expense("Title6", "Sport", 300);

    @Test
    public void TestCalculateTotal() {

        long suma;
        MyDatabase mockD = mock(MyDatabase.class);
        ExpenseRepository mockR = new ExpenseRepository(mockD);
        mockR.addExpense(e1); mockR.addExpense(e2); mockR.addExpense(e3);
        FancyService mockS = mock(FancyService.class);
        ExpenseManager test = new ExpenseManager(mockR, mockS);
        suma = test.calculateTotal();
        assertEquals(600, suma);
    }

    @Test
    public void TestCalculateTotalForCategory() {

        ExpenseRepository mockR = mock(ExpenseRepository.class);
        mockR.addExpense(e1); mockR.addExpense(e2); mockR.addExpense(e3);
        mockR.addExpense(e4); mockR.addExpense(e5); mockR.addExpense(e6);
        FancyService mockS = mock(FancyService.class);
        ExpenseManager test = new ExpenseManager(mockR, mockS);
        test.calculateTotalForCategory("Home");
        test.calculateTotalForCategory("Car");
        test.calculateTotalForCategory("Food");
        test.calculateTotalForCategory("Sport");
        verify(mockR).getExpensesByCategory("Home");
        verify(mockR).getExpensesByCategory("Car");
    }

    @Test
    public void TestCalculateTotalInDollars() throws ConnectException, java.net.ConnectException {

        ExpenseRepository mockR = mock(ExpenseRepository.class);
        FancyService mockF = mock(FancyService.class);
        when(mockF.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock();
                double dub = (double) args[0];
                return dub / 4;
            }
        });
        mockR.addExpense(e1); mockR.addExpense(e2); mockR.addExpense(e3);
        mockR.addExpense(e4); mockR.addExpense(e5); mockR.addExpense(e6);
        ExpenseManager test = new ExpenseManager(mockR, mockF);
        test.calculateTotalInDollars();
        verify(mockR).getExpenses();
    }
}
