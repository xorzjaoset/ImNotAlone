package en.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import en.dto.BlackDTO;
import en.model.BlackDAO;

@Service
public class BlackListService {

	@Autowired
	BlackDAO dao;

	public List<BlackDTO> BlackWait(BlackDTO dto) {
		System.out.println("블랙대기리스트 들어왓니?");
		return dao.selectBlack(dto);
	}

	public int waitinsert(BlackDTO dto) {
		System.out.println("블랙대기인서트 들어왔니?");
		return dao.waitinsert(dto);
	}

	public List<BlackDTO> BlackList(BlackDTO dto) {
		System.out.println("블랙확정 들어왔니?");
		return dao.selectBlack1(dto);
	}
}
