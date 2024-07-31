public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create the concrete repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to get customer details
        String customerName = customerService.getCustomerName(1);
        System.out.println("Customer Name: " + customerName);

        // Try with a non-existent customer
        String unknownCustomerName = customerService.getCustomerName(2);
        System.out.println("Customer Name: " + unknownCustomerName);
    }
}

// Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulating database access
        if (id == 1) {
            return "Priya";
        } else {
            return "Customer  found";
        }
    }
}

// Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerName(int id) {
        return customerRepository.findCustomerById(id);
    }
}
