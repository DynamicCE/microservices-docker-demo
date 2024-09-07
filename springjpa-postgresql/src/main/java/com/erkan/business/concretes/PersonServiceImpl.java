package com.erkan.business.concretes;

import com.erkan.business.abstracts.PersonService;
import com.erkan.dto.PersonDto;
import com.erkan.entity.Address;
import com.erkan.entity.Person;
import com.erkan.repository.AddressRepo;
import com.erkan.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public
class PersonServiceImpl implements PersonService {
    private final
    PersonRepo personRepo;
    private final
    AddressRepo addressRepo;

    @Override
    @Transactional
    public
    PersonDto save ( PersonDto personDto ) {
        Person person = new Person (  );
        person.setFirstName ( personDto.getFirstName ( ) );
        person.setLastName ( personDto.getLastName ( ) );
        final Person persondb = personRepo.save ( person );

        List<Address> list = new ArrayList<> (  );
        personDto.getAddresses ().forEach ( item ->{
            Address address = new Address (  );
            address.setAddress ( item );
            address.setAddressType ( Address.AddressType.OTHER );
            address.setIsActive ( true );
            address.setPerson ( persondb );
            list.add ( address );
        } );
        addressRepo.saveAll ( list );
        personDto.setId ( personDto.getId ( ) );
        return personDto;
    }

    @Override
    public
    void delete ( Long id ) {

    }

    @Override
    public
    List<PersonDto> getAll () {
        List<Person> personList = personRepo.findAll ();
        personList.forEach ( item ->{
            PersonDto personDto = new PersonDto ();
            personDto.setId ( item.getId ( ) );
            personDto.setFirstName ( item.getFirstName () );
            personDto.setLastName ( item.getLastName ( ) );
            personDto.setAddresses ( item.getAddresses () );
        } );
        return null;
    }

    @Override
    public
    Page<PersonDto> getAll ( Pageable pageable ) {
        return null;
    }
}
