package pl.patrykmuskala.CrmApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.patrykmuskala.CrmApplication.Model.Address;
import pl.patrykmuskala.CrmApplication.Repository.AddressRepository;

@RestController
@RequestMapping("/api/addresses")
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public Iterable<Address> getAddresses(){
        return addressRepository.findAll();
    }
}
