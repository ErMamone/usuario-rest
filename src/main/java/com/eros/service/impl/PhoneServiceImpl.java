package com.eros.service.impl;

import com.eros.entity.Phone;
import com.eros.repository.PhoneRepository;
import com.eros.service.PhoneService;
import com.eros.shared.dto.PhoneDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

	private final PhoneRepository phoneRepository;

	@Override
	public List<Phone> saveList(List<PhoneDTO> phones) {
		List<Phone> responseList = new ArrayList<>();

		for (var phone : phones) {
			responseList.add(save(new Phone(phone)));
		}

		return responseList;
	}

	@Override
	@Transactional
	public Phone save(Phone phone) {
		return phoneRepository.save(phone);
	}
}
