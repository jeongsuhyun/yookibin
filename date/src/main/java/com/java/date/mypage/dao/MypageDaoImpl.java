package com.java.date.mypage.dao;

import java.util.List;
import java.util.logging.Logger;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.date.mypage.dto.MypageDto;
import com.java.date.recommandPlace.dto.SaveCourseDto;

@Component
public class MypageDaoImpl implements MypageDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final Logger logger=Logger.getLogger(getClass().getName());

	@Override
	public int delete(int num) {
		// sqlSession.selectList("dao.recommandPlaceMapper.getPlaceList");
		return sqlSession.delete("dao.myPageMapper.delete", num);
	}

	/**
	 * @name : RandomPlaceController
	 * @date : 2015. 7. 12.
	 * @author : 박종현
	 * @description : 나의코스를 id로 찾아옴
	 */
	@Override
	public List<SaveCourseDto> getMyCourse(String id) {
		// TODO Auto-generated method stub
		System.out.println("여긴디에요?");
		return sqlSession.selectList("dao.myPageMapper.getMyCourse", id);
	}

	@Override
	public List<MypageDto> point(String id) {
		logger.info("id2" + id);

		return sqlSession.selectList("pointcheck", id);
	}

	@Override
	public List<MypageDto> usingevent(String id) {
		logger.info("id3" + id);
		return sqlSession.selectList("usingevent", id);
	}

}
