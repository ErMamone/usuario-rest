package com.eros.service;

import com.eros.entity.Phone;
import com.eros.shared.dto.PhoneDTO;

import java.util.List;

public interface PhoneService {

	List<Phone> saveList(List<PhoneDTO> phones);

	Phone save (Phone phone);
}
