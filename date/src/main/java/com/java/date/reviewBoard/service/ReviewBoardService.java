package com.java.date.reviewBoard.service;

public interface ReviewBoardService {

	public int replyWrite(int star, String place_code,String nickName, String writeReply);
	public int replyDelete(int review_code);
	public int replyUpdate(int review_code, String review_content);
}
