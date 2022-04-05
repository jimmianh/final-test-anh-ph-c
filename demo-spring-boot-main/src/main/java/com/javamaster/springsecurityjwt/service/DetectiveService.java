package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.dto.ResponseDTO;
import com.javamaster.springsecurityjwt.entity.Detective;
import com.javamaster.springsecurityjwt.repository.DetectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DetectiveService implements IDetectiveService {

	@Autowired
	private DetectiveRepository deteRepository;

	@Override
	public Detective getDetectiveById(Long Id) {

		return deteRepository.findById(Id).get();
	}

	@Override
	public ResponseDTO createDetective(Detective detective) {

		ResponseDTO respo = new ResponseDTO();
		String masage = "BadgeNumber đã tồn tại!";
		if (deteRepository.existsByBadgeNumber(detective.getBadgeNumber())) {
			respo.setCode("error");
			respo.setMassage(masage);
			return respo;
		}

		Detective detective1 = deteRepository.save(detective);
		respo.setCode("susscesfully");
		respo.setMassage("thành công");
		respo.setData(detective1);
		return respo;

	}

	@Override
	public ResponseDTO updateDetective(Detective detective) {
		ResponseDTO respo = new ResponseDTO();
		String message = "Id không tồn tại!";
		if (deteRepository.findById(detective.getDetectiveId()).equals(null)) {
			respo.setCode("error");
			respo.setMassage(message);
			return respo;
		}
		detective.setPerson(detective.getPerson());
		detective.setRanks(detective.getRanks());
		detective.setAmed(detective.getAmed());
		detective.setStatus(detective.getStatus());
		respo.setCode("sussesfully!");
		respo.setMassage("update thành công!");
		respo.setData(deteRepository.save(detective));

		return respo;
	}

	@Override
	public void deleteDetectiveById(Long Id) {

		deteRepository.deleteById(Id);

	}

}
