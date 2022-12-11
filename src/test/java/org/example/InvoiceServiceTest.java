package org.example;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;
    @Before
    public void setUp() throws Exception{
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary=  invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
