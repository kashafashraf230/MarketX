package marketX;

import marketX.Gender;
import marketX.Customer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataProcessor {


        public static void main(String[] args) {
            List<Customer> customers = createSampleDataset();

            // Stream Operations
            List<String> filteredNames = customers.stream()
                    .filter(customer -> customer.getAge() >= 25 && customer.getAge() <= 40)
                    .filter(customer -> customer.getCity().equals("New York"))
                    .filter(customer -> customer.getGender() == Gender.Male || customer.getGender() == Gender.Female)
                    .map(Customer::getName)
                    .sorted()
                    .collect(Collectors.toList());

            double totalPurchaseAmount = customers.stream()
                    .mapToDouble(Customer::getPurchaseAmount)
                    .sum();

            Optional<Customer> customerWithHighestPurchaseAmount = customers.stream()
                    .max(Comparator.comparingDouble(Customer::getPurchaseAmount));

            Map<String, Double> averagePurchaseByCity = customers.stream()
                    .collect(Collectors.groupingBy(Customer::getCity, Collectors.averagingDouble(Customer::getPurchaseAmount)));

            List<Customer> filteredCustomersList = customers.stream()
                    .filter(customer -> customer.getAge() >= 25 && customer.getAge() <= 40)
                    .filter(customer -> customer.getCity().equals("New York"))
                    .filter(customer -> customer.getGender() == Gender.Male || customer.getGender() == Gender.Female)
                    .collect(Collectors.toList());

            // Report Generation
            System.out.println("Filtered Customers (Alphabetical Order): " + filteredNames);
            System.out.println("Total Purchase Amount: " + totalPurchaseAmount);
            System.out.println("Customer(s) with Highest Purchase Amount: " + customerWithHighestPurchaseAmount.orElse(null));
            System.out.println("Average Purchase Amount by City: " + averagePurchaseByCity);
        }

        private static List<Customer> createSampleDataset() {
            List<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Richard Joe", 30, "New York", Gender.Male, 100.0));
            customers.add(new Customer("Jane Smith", 35, "Los Angeles", Gender.Female, 150.0));
            customers.add(new Customer("Bob Johnson", 26, "New York", Gender.Male, 80.0));
            customers.add(new Customer("Alice Brown", 28, "Chicago", Gender.Female, 120.0));
            customers.add(new Customer("Mike Davis", 39, "New York", Gender.Male, 200.0));
            customers.add(new Customer("Emily Lee", 38, "Chicago", Gender.Female, 180.0));
            customers.add(new Customer("Chris Wilson", 32, "San Francisco", Gender.Other, 90.0));
            return customers;
        }
    }

