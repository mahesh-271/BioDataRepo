package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.Exceptions.ResourceNotFoundException;
import com.luv2code.cruddemo.entity.Address;
import com.luv2code.cruddemo.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;


@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address getAddressById(Integer id) {

        var addreess = addressRepository.findById(id).orElseThrow(
                ()->
                {
                     throw new ResourceNotFoundException("Address not found with id: " + id + " please check with id");
                });
        return addreess;
    }

}
