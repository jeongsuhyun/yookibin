package com.java.date.recommandPlace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.date.recommandPlace.dao.RecommandPlaceDao;
import com.java.date.recommandPlace.dto.LoadCourseDto;
import com.java.date.recommandPlace.dto.PlaceDto;
import com.java.date.recommandPlace.dto.SaveCourseDto;

@Component
public class RecommandPlaceServiceImpl implements RecommandPlaceService {
	@Autowired
	private RecommandPlaceDao dao;
	Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public void placeCourseList(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();

		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String place_name = request.getParameter("place_name");
		String place_season = request.getParameter("place_season");
		String place_weather = request.getParameter("place_weather");
		String place_time = request.getParameter("place_time");
		String place_price = request.getParameter("place_price");
		
		PlaceDto dto = (PlaceDto) map.get("placeDto");
		logger.info("잘나오나" + dto.getPlace_name());
		logger.info("잘나오나" + dto.getPlace_season());
		logger.info("잘나오나" + dto.getPlace_weather());
		logger.info("잘나오나" + dto.getPlace_time());
		logger.info("잘나오나" + dto.getPlace_price());
		List<PlaceDto> placeDtoList = dao.getPlaceDtoList(dto);
//		int a = dao.getPrice("화랑공원");
		System.out.println(placeDtoList.size());
		System.out.println(placeDtoList.get(0).getPlace_name());
		List<List> list = new ArrayList();
		if(placeDtoList.size() >= 3){
			for(int i=0; i<placeDtoList.size()-2;i=i+2){
				List<PlaceDto> placeList = new ArrayList();
				placeList.add(placeDtoList.get(i));
				placeList.add(placeDtoList.get(i+1));
				list.add(placeList); 
			}
		}
		 mav.addObject("list", list);
		 mav.setViewName("recommandPlace/recommandPlaceOk");
		 
	}

	@Override
	public void selectMap(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();

		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String place = request.getParameter("place");
		logger.info("place : " + place);
		mav.addObject("place", place);
		mav.setViewName("map/map2");

	}

	@Override
	public void selectMap0(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();

		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String place = request.getParameter("place");
		logger.info("place : " + place);
		mav.addObject("place", place);
		mav.setViewName("map/map");

	}

	@Override
	public void selectMap2(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();

		HttpServletRequest request = (HttpServletRequest) map.get("request");
		mav.setViewName("map/map3");
	}

	@Override
	public void selectMap3(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();

		HttpServletRequest request = (HttpServletRequest) map.get("request");
		mav.setViewName("map/map4");
	}

	@Override
	public void daumMap(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();

		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String a = request.getParameter("place_name");
		String b = request.getParameter("place_season");
		String c = request.getParameter("place_weather");
		String d = request.getParameter("place_time");
		String e = request.getParameter("place_price");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		PlaceDto dto = (PlaceDto) map.get("placeDto");
		logger.info("잘나오나" + dto.getPlace_name());
		logger.info("잘나오나" + dto.getPlace_season());
		logger.info("잘나오나" + dto.getPlace_weather());
		logger.info("잘나오나" + dto.getPlace_time());
		logger.info("잘나오나" + dto.getPlace_price());
		mav.setViewName("recommandPlace/daumMap");
	}
	
	/**
	 * @name : RecommandPlaceController
	 * @date : 2015. 6. 22.
	 * @author : 종현
	 * @description : 장소코드로 장소DTO를 가져옴.
	 */
	@Override
	public PlaceDto getInfo(String code) {
		
		return dao.getInfo(code);
	}

	/**
	 * @name : RecommandPlaceController
	 * @date : 2015. 6. 22.
	 * @author : 종현
	 * @description : 사용자선택에 의한 장소들을 가져온다.
	 */
	@Override
	public List<PlaceDto> placeList(PlaceDto dto) {
		// TODO Auto-generated method stub
		return dao.placeList(dto);
	}

	/**
	 * @name : RecommandPlaceController
	 * @date : 2015. 6. 22.
	 * @author : 종현
	 * @description : 선택한 코스에 대한 정보를 제공.
	 */
	@Override
	public void selectCourse(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();

		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String courseSelect = request.getParameter("courseSelect");
		logger.info("courseSelect : "+courseSelect);
		String[] result = courseSelect.split(",");
		String placeCode1 = result[0].trim();
		String placeCode2 = result[1].trim();
		System.out.println(placeCode1);	
		System.out.println(placeCode2);	
		List<PlaceDto> placeDtoList = dao.getPlaceDtoList(placeCode1,placeCode2);
		System.out.println(placeDtoList.size());
		mav.addObject("placeDtoList",placeDtoList);
		mav.setViewName("recommandPlace/course");
	}

	@Override
	public List<Object> test12() {
		// TODO Auto-generated method stub
		return dao.test12();
	}

	/**
	 * @name : RecommandPlaceController
	 * @date : 2015. 7. 10.
	 * @author : 종현
	 * @description : 사용자가 선택한 코스를 저장하는 함수.
	 */
	@Override
	public int saveCourse(String place_code1, String place_code2) {
		// TODO Auto-generated method stub
		return dao.saveCourse(place_code1,place_code2);
	}

	/**
	 * @name : RecommandPlaceController
	 * @date : 2015. 7. 12.
	 * @author : 종현
	 * @description : 마이페이지의 내 저장된 코스보기로 이동.
	 */
	@Override
	public void moveMypage(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String cid = request.getParameter("id");
		System.out.println(cid);
		List<SaveCourseDto> cList = dao.moveMypageGetCourse(cid);
		List<LoadCourseDto> lList = new ArrayList();
		for(int i = 0; i< cList.size();i++){
			LoadCourseDto dto = new LoadCourseDto();
			dto.setNum(cList.get(i).getNum());
			dto.setSave_cplace1(dao.getInfo(cList.get(i).getSave_cplace1()));
			dto.setSave_cplace2(dao.getInfo(cList.get(i).getSave_cplace2()));
			dto.setSave_date(cList.get(i).getSave_date());
			lList.add(dto);
		}
		
		mav.addObject("lList", lList);
		mav.setViewName("mypage/recommend");
		
	}
}














