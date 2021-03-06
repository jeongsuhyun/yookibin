package com.java.date.mypage.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.java.date.member.dto.EventBoardDto;
import com.java.date.mypage.dto.MypageDto;
import com.java.date.recommandPlace.dto.LoadCourseDto;

public interface MypageService {

	public int delete(int num);

	public List<LoadCourseDto> getMyCourse(String id,String like);

	//public void pointCheck(ModelAndView mav);

	//public void usingevent(ModelAndView mav);
	
	public List<MypageDto> pointCheck(String id);
	
	public List<EventBoardDto> usingCheck(String id);

	public int remainCheck(String id);

}
