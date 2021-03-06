package com.java.date.member.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.date.member.dao.MemberDao;
import com.java.date.member.dto.MemberDto;
import com.java.date.member.dto.MemberZipcodeDto;



@Component
public class MemberServiceImpl implements MemberService {
	Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private MemberDao memberDao;

	
	/**
	 * @name : register
	 * @date : 2015. 6. 22.
	 * @author : 유기빈
	 * @description : register.jsp에서 받은 dto를 dao로 넘겨 check값을 받아와 registerOk.jsp로 넘김.
	 */
	@Override
	public void memberRegisterOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		MemberDto memberDto=(MemberDto)map.get("memberDto");
		logger.info("memberDto:"+memberDto+"--------------------------");
		
	/*	System.out.println("id:"+memberDto.getId());
		System.out.println("pw:"+memberDto.getPw());
		System.out.println("addr:"+memberDto.getAddr());
		System.out.println("age:"+memberDto.getAge());
		System.out.println("birth:"+memberDto.getBirthday());
		System.out.println("nickname:"+memberDto.getNickName());
		System.out.println("phone:"+memberDto.getPhone());*/
		
		memberDto.setMember_level("BB");
		
		int firstCheck=memberDao.memberRegister(memberDto);		//회원가입
		logger.info("firstCheck:"+firstCheck);
		
		String id=memberDto.getId();
		logger.info(id);
		//회원가입이 완료되면 기본 포인트를 지급한다.
		int check=0;
		if(firstCheck>0){
			check=memberDao.memberPoint(id);
			logger.info("check: "+check);
		}		
		
		mav.addObject("check", check);
		mav.setViewName("member/registerOk");	
	}
	
	/**
	 * @name : idCheck
	 * @date : 2015. 6. 22.
	 * @author : 유기빈
	 * @description : 아이디 중복여부를 체크하기 위해 id 값을 읽어와 dao로 넘기고 check값과 id를 idCheck.jsp로 넘김.
	 */
	@Override
	public void idCheck(ModelAndView mav) {		
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id=request.getParameter("id");
		logger.info("id:"+id);
		
		int check=memberDao.idCheck(id);
		logger.info("check:"+check);
		
		mav.addObject("check", check);
		mav.addObject("id", id);
		
		mav.setViewName("member/idCheck");
		
	}

	/**
	 * @name : nickNameCheck
	 * @date : 2015. 6. 22.
	 * @author : 유기빈
	 * @description : 닉네임 중복여부를 체크하기 위해 nickName 값을 읽어와 dao로 넘기고 check값과 nickName을 nickNameCheck.jsp로 넘김.
	 */
	@Override
	public void nickNameCheck(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String nickName=request.getParameter("nickName");
		logger.info("nickName:"+nickName);
		int check=memberDao.nickNameCheck(nickName);
		logger.info("check:"+check);
		mav.addObject("check", check);
		mav.addObject("nickName", nickName);
		mav.setViewName("member/nickNameCheck");
		
	}
	
	
	/**
	 * @name : zipcode
	 * @date : 2015. 6. 22.
	 * @author : 유기빈
	 * @description : 회원가입시 dong값을 dao로 넘기고 그에 해당하는 값들을 zipcode.jsp로 넘김.
	 */
	@Override
	public void zipcode(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String dong=request.getParameter("dong");
		logger.info("dong:"+dong);
		List<MemberZipcodeDto> list=null;
		if(dong!=null){
			list=memberDao.zipcode(dong);
			logger.info("zipcodeDto:"+list.size());
		}
		mav.addObject("list", list);
		mav.setViewName("member/zipcode");
		
	}
	
	/**
	 * @name : login
	 * @date : 2015. 6. 22.
	 * @author : 유기빈
	 * @description : 로그인하기위해 id값과 password를 받아와 해당하는 레코드가 맞는지 확인하기위해 dao로넘겨주고 loginOk로 이동하기 위한 함수
	 */
	@Override
	public void login(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		logger.info("id:"+id+", password:"+password);
		MemberDto member=memberDao.login(id, password);
		//logger.info(member);
		if(member !=null){
			logger.info("member:"+member);
			//String memberLevel=member.getMemberLevel();
			//System.out.println("memberLevel"+memberLevel);
			//우리도 멤버레벨 추가시켜야함 밑에꺼 일단 보류 .
			//mav.addObject("memberLevel", member.getMemberLevel());
			mav.addObject("id", member.getId());
			mav.addObject("nickName", member.getNickName());
			if(member.getMember_level()!=null){
				mav.addObject("memberLevel", member.getMember_level());
			}
			mav.setViewName("member/loginOk");
			
		}
	}
	
	/**
	 * @name : delete
	 * @date : 2015. 6. 22.
	 * @author : 유기빈
	 * @description : id와 password값을 통해 dao로 넘겨 delete 여부를 확인하기 위해 check값을 받아오고 deleteOk.jsp로 넘어가기위한 함수.
	 */
	@Override
	public void delete(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		int check=memberDao.delete(id, password);
		logger.info("check:"+check);			
		
		mav.addObject("check", check);
		mav.setViewName("member/deleteOk");
		
	}
	
	/**
	 * @name : delete
	 * @date : 2015. 6. 22.
	 * @author : 유기빈
	 * @description : id값을 dao로 넘겨 해당하는 레코드값을 MemerDto를 가져와 update.jsp로 넘어가기 위한 함수.
	 */
	@Override
	public void update(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String id=request.getParameter("id");
		logger.info("id:"+id);
		MemberDto member=memberDao.select(id);
		logger.info("member:"+ member);
		
		mav.addObject("member", member);
		
		mav.setViewName("member/update");
	}

	@Override
	public void updateOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		//HttpServletRequest request=(HttpServletRequest)map.get("request");
		MemberDto member=(MemberDto)map.get("member");
		logger.info("member:"+member);
		logger.info("member id: "+member.getId());
		logger.info("member addr: "+member.getAddr());
		logger.info("member birthday: "+member.getBirthday());
		
		int check=memberDao.update(member);
		logger.info("check:"+check);
		mav.addObject("check", check);
		mav.setViewName("member/updateOk");
	}
	
	/**
	 * @name : findID
	 * @date : 2015. 7. 20.
	 * @author : JeongSuhyun
	 * @description : 넘겨받은 nickName과 phone을 DB에서 비교하여 해당 id를 반환받아 jsp페이지로 이동한다.
	 */
	@Override
	public void findID(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String nickName=request.getParameter("nickName");
		String phone=request.getParameter("phone");
		logger.info("nickName: "+nickName+" phone: "+phone);
		
		HashMap<String, String> hMap=new HashMap<String, String>();
		hMap.put("nickName", nickName);
		hMap.put("phone", phone);
		
		String id=memberDao.findID(hMap);
		logger.info("findID: "+id);
		
		mav.addObject("id",id);
		
		mav.setViewName("member/findID");
		
	}

	/**
	 * @name : findPW
	 * @date : 2015. 7. 20.
	 * @author : JeongSuhyun
	 * @description : 넘겨받은 id과 phone을 DB에서 비교하여 해당 password를 반환받아 jsp페이지로 이동한다.
	 */
	@Override
	public void findPW(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String id=request.getParameter("id");
		String phone=request.getParameter("phone");
		logger.info("id: "+id+" phone: "+phone);
		
		HashMap<String, String> hMap=new HashMap<String, String>();
		hMap.put("id", id);
		hMap.put("phone", phone);
		
		String password=memberDao.findPW(hMap);
		logger.info("findPW: "+password);
		
		mav.addObject("password",password);
		
		mav.setViewName("member/findPW");
		
	}
}
