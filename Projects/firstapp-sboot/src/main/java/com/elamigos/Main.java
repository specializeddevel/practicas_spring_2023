package com.elamigos;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Proyecto para aprendizaje de Spring Boot e Spring data
 * @author raulb
 * @version 1.0
 */
@SpringBootApplication
//@SpringBootApplication hace en una sola linea tod o lo que hacen las siguientes anotations
//@ComponentScan(basePackages = "com.elamigos")
//@EnableAutoConfiguration
//@SprigBootConfiguration
@RestController
@RequestMapping("api/v1/customers")
public class Main {
    //Inicio de la Inyeccion de dependencias mediante constructor
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Esta forma de inyectar las dependencias tambien es valida
    //No se neceista instanciar el objeto, el @Autowired lo hace automaticamente
    //@Autowired
    //private CustomerRepository customerRepository2;
    //Fin de la inmyeccion de dependencias mediante constructor
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){}

    @GetMapping("{customerName}")
    public Customer searchCustomersByName(@PathVariable("customerName") String name){
        return customerRepository.searchCustomerByName(name);
    }

    @PostMapping
    @Transactional
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    @Transactional
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest request){

        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        optionalCustomer.ifPresent(customer -> {
            customer.setName(request.name());
            customer.setEmail(request.email());
            customer.setAge(request.age());
            customerRepository.save(customer);
        });
    }

//    @GetMapping("/greet")
//    public GreetResponse greet(){
//        return new GreetResponse(
//                "Hello",
//                List.of("Java", "Golang", "JavaScript"),
//                new Person("Alex", 28, 30_000)
//        );
//
//    }
//
//    record Person(String name, int age, double savings){}
//    record GreetResponse(
//            String greet,
//            List<String> favProgrammingLanguages,
//            Person person
//    ){}

}
