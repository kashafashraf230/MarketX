package marketX;

import static org.junit.jupiter.api.Assertions.*;
import marketX.Customer;
import marketX.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

class DataProcessorTest {


        private DataProcessor dataProcessor;
        private List<Customer> mockCustomers;

        @BeforeEach
        void setUp() {
            dataProcessor = new DataProcessor();

            // Create a mock list of customers for testing
            mockCustomers = Arrays.asList(
                    new Customer("John Doe", 30, "New York", Gender.Male, 100.0),
                    new Customer("Jane Smith", 35, "Los Angeles", Gender.Female, 150.0),
                    new Customer("Bob Johnson", 22, "New York", Gender.Male, 80.0),
                    new Customer("Alice Brown", 28, "Chicago", Gender.Female, 120.0),
                    new Customer("Mike Davis", 45, "New York", Gender.Male, 200.0),
                    new Customer("Emily Lee", 38, "Chicago", Gender.Female, 180.0),
                    new Customer("Chris Wilson", 32, "San Francisco", Gender.Other, 90.0)
            );
        }

        @Test
        void testFilteredNames() {
           // List<String> expectedNames = Arrays.asList("John Doe", "Mike Davis");
            List<String> expectedNames = Arrays.asList("John Doe");

            List<String> actualNames = dataProcessor.filteredNames(mockCustomers);

            Assertions.assertEquals(expectedNames, actualNames);
        }

        @Test
        void testTotalPurchaseAmount() {
            double expectedTotalPurchaseAmount = 920.0;

            double actualTotalPurchaseAmount = dataProcessor.totalPurchaseAmount(mockCustomers);

            Assertions.assertEquals(expectedTotalPurchaseAmount, actualTotalPurchaseAmount);
        }

        // Add other test cases for the remaining methods in DataProcessor class


}