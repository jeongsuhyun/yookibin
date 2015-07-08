package com.java.date.reviewBoard.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.date.reviewBoard.dto.ReviewBoardDto;
import com.java.date.reviewBoard.service.ReviewBoardService;

@Controller
public class ReviewBoardController {
	private final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ReviewBoardService reviewBoardService;
	
	/**
	 * @name : replyWrite
	 * @date : 2015. 7. 3.
	 * @author : 정희준
	 * @description : 평가하기를 눌렀을때, AJAX를 통해 각 멤버변수들이 들어와 해당 변수들을 reviewBoardService로 리턴해주는 함수
	 */
	
	@RequestMapping("/reviewBoard/insertReview.do")
	@ResponseBody
	public List<ReviewBoardDto> replyWrite(int star, String place_code, String nickName, String writeReply){
		logger.info("-------------------replyWrite");
		return reviewBoardService.replyWrite(star,place_code,nickName,writeReply);
	}
	
	/**
	 * @name : replyDelete
	 * @date :  2015. 7. 5.
	 * @author : 정희준
	 * @description : 삭제버튼을 눌렀을 시 AJAX를 통해 각 멤버변수들이 들어와 해당 변수들을 reviewBoardService로 리턴해주는 함수
	 */
	
	
	@RequestMapping("/reviewBoard/deleteReview.do")
	@ResponseBody
	public int replyDelete(int review_code){
		logger.info("-------------------replyDelete");
		return reviewBoardService.replyDelete(review_code);
	}
	
	
	/**
	 * @name : replyUpdate
	 * @date :  2015. 7. 8.
	 * @author : 정희준
	 * @description : 수정버튼을 눌렀을 시 AJAX를 통해 각 멤버변수들이 들어와 해당 변수들을 reviewBoardService로 리턴해주는 함수
	 */
	
	@RequestMapping("reviewBoard/updateReview.do")
	@ResponseBody
	public ReviewBoardDto replyUpdate(int review_code){
		logger.info("-------------------replyUpdate");
		return reviewBoardService.replyUpdate(review_code);
	}
}