package ho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ho.dto.MemberDTO;
import ho.model.MemberDAO;

@Service
public class LoginService implements LoginServiceInterface {

	@Autowired
	MemberDAO dao;
	
	public MemberDTO getUserInformation(MemberDTO dto) {
		dto = dao.getUserInformation(dto);
		return dto;
	}
 

	public int login(MemberDTO dto) {

		String userPasswd = dao.checkUser(dto.getUser_email());

		if (userPasswd != null) {
			if (dto.getUser_password().equals(userPasswd)) {
				return 1; // �α��μ���
			} else {
				return 2; // ��й�ȣ Ʋ��
			}

		} else {
			return 0; // ȸ�������� ����.
		}
	}

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	public String register(MemberDTO dto) {
		
		if(dao.registerUser(dto)==1) {
		return "�ӹ�����";
		}
		return "�ӹ�����";
	}



	
}
