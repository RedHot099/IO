package put.io.testing.mocks;

import org.junit.*;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExpenseRepositoryTest {

    private ExpenseRepository repo;
    private List<Expense> expenses;
    private IFancyDatabase fancyDatabase;
    private Expense expense = new Expense("Title", "A", 100);
    //private List<Expense> lista;

    @Before
    public void setUp() {
        repo = new ExpenseRepository(new MyDatabase());
        fancyDatabase = new MyDatabase();
    }

    @Test
    public void testLoadExpenses() {

        MyDatabase mockObject = mock(MyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.singletonList("first"));
        ExpenseRepository testedObject = new ExpenseRepository(mockObject);
        testedObject.loadExpenses();
        verify(mockObject).connect();
        verify(mockObject).queryAll();
        verify(mockObject).close();
    }

    @Test
    public void testGetExpenses() {

        Expense e1 = new Expense("Title1", "A", 100);
        Expense e2 = new Expense("Title2", "B", 200);
        Expense e3 = new Expense("Title3", "C", 300);
        repo.addExpense(e1); repo.addExpense(e2); repo.addExpense(e3);
        List<Expense> lista = repo.getExpenses();
        for (Expense e : lista){
            System.out.println(e.getAmount());
        }

    }

    @Test
    public void testSaveExpenses() {

        MyDatabase mockO = mock(MyDatabase.class);
        ExpenseRepository test = new ExpenseRepository(mockO);
        test.addExpense(expense);
        test.saveExpenses();
        verify(mockO).persist(any(Expense.class));
    }
}
