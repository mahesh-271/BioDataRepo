//package com.luv2code.cruddemo.webclient;
//
//import com.luv2code.cruddemo.entity.Address;
//import com.luv2code.cruddemo.repository.AddressRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class AddressUtility implements CommandLineRunner {
//
//    private final AddressRepository addressRepository;
//    @Override
//    public void run(String... args) throws Exception {
//
//        Address address = Address.builder()
//                .state("Karnataka")
//                .mandal("Puttaparathi")
//                .villageName("Marathalli")
//                .pincode(515652)
//                .build();
//
//        addressRepository.save(address);
//
//    }
//}
