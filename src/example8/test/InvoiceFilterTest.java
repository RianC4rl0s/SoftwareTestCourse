package example8.test;

import example8.main.DatabaseConnection;
import example8.main.Invoice;
import example8.main.InvoiceFilter;
import example8.main.IssuedInvoices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvoiceFilterTest {
    //Class.forName("org.hsqldb.jdbc.JDBCDriver");
    private IssuedInvoices invoices;
    private DatabaseConnection dbConneection;

    @BeforeEach
    public void open() {
        dbConneection = new DatabaseConnection();
        invoices = new IssuedInvoices(dbConneection);

        dbConneection.resetDatabase();
    }

    @AfterEach
    public void close() {
        if (dbConneection != null) {
            dbConneection.close();
        }
    }

    @Test
    void filterInvoices() {
        //Instantiates a stub for the IssuedInvoices class
        IssuedInvoices issuedInvoices = mock(IssuedInvoices.class);
        Invoice m = new Invoice("Mauricio", 20);
        Invoice s = new Invoice("Steve", 99);
        Invoice f = new Invoice("Frank", 100);
        List<Invoice> listOfInvoices = Arrays.asList(m, s, f);
        //stub returns the list of invoices if all() is called
        when(issuedInvoices.all()).thenReturn(listOfInvoices);
        //Instantiates the class under test (stub as a dependency)
        InvoiceFilter filter = new InvoiceFilter(issuedInvoices);
        //method under test returns a new list with only two invoices
        assertThat(filter.lowValueInvoices()).
                containsExactlyInAnyOrder(m, s);
    }


}
