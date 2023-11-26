package com.muratArslan.postgresqlrestapi.service.impl;

import com.muratArslan.postgresqlrestapi.dto.UserDto;
import com.muratArslan.postgresqlrestapi.entity.Address;
import com.muratArslan.postgresqlrestapi.entity.User;
import com.muratArslan.postgresqlrestapi.repository.AddressRepository;
import com.muratArslan.postgresqlrestapi.repository.UserRepository;
import com.muratArslan.postgresqlrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user=new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userDb=userRepository.save(user);

        List<Address> addressList=new ArrayList<>();
        userDto.getAddressList().forEach(item ->{

            Address address=new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setIsActive(true);
            address.setUser(userDb);
            addressList.add(address);
        });
        addressRepository.saveAll(addressList);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList=userRepository.findAll();
        List<UserDto> userDtoList=new ArrayList<>();
        userList.forEach(user -> {
            UserDto userDto=new UserDto();
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setId(user.getId());
            userDto.setAddressList(user.getAddressList().stream()
                    .map(Address::getAddress)
                    .collect(Collectors.toList()));
            userDtoList.add(userDto);
        });

        return userDtoList;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
