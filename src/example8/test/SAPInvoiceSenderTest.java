package example8.test;
import example8.main.Invoice;
import example8.main.InvoiceFilter;
import example8.main.SAP;
import example8.main.SAPInvoiceSender;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static java.util.Collections.emptyList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SAPInvoiceSenderTest {
    //InvoiceFilter is a class that returns a list of low-valued invoices.
    //Note. Usually, use stubs and mocks as fields, so you do not need
    //to instantiate them in every test method.
    private InvoiceFilter filter =
            mock(InvoiceFilter.class);
    private SAP sap = mock(SAP.class);

    //Passing the stub and the mock to the class under test
    private SAPInvoiceSender sender =
            new SAPInvoiceSender(filter, sap);

    @Test
    void sendToSap() {
        Invoice mauricio = new Invoice("Mauricio", 20);
        Invoice frank = new Invoice("Frank", 99);
        //Setting up the InvoiceFilter stub. It will return two
        //invoices whenever lowValueInvoices() is called.
        List<Invoice> invoices = Arrays.asList(mauricio, frank);
        when(filter.lowValueInvoices()).thenReturn(invoices);
        //Calling the method under test, knowing
        //that these two invoices will be sent to SAP
        sender.sendLowValuedInvoices();
        //Ensuring that the send method
        //was called for both invoices
        verify(sap).send(mauricio);
        verify(sap).send(frank);
    }
}
