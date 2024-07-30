package DependencyInjectionExample;

interface CustomerDataRepository {
    String findCustomerById(int id);
}

class CustomerDataRepositoryImpl implements CustomerDataRepository {
    @Override
    public String findCustomerById(int id) {
        return "Customer with ID " + id;
    }
}

class CustomerService {
    private CustomerDataRepository customerDataRepository;

    public CustomerService(CustomerDataRepository customerDataRepository) {
        this.customerDataRepository = customerDataRepository;
    }

    public String getCustomer(int id) {
        return customerDataRepository.findCustomerById(id);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {

        CustomerDataRepository customerDataRepository = new CustomerDataRepositoryImpl();

        CustomerService customerService = new CustomerService(customerDataRepository);

        String customerDetails = customerService.getCustomer(1);
        System.out.println(customerDetails);
    }
}
