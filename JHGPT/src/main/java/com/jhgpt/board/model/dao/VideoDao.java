package com.jhgpt.board.model.dao;

import java.util.List;

import com.jhgpt.board.model.dto.Video;


public interface VideoDao {
	//전체 비디오 리스트 들고오기
	public List<Video> selectAll();
	
	//아이디로 비디오 하나 가져오기
	public Video selectOne(int video_id);
	
	//비디오 등록
	public void insertVideo(Video video);
	
	//비디오 삭제
	public void deleteVideo(int video_id);
	
	//비디오 수정
	public void updateVideo(Video video);
	
	//조회수 증가
	public void updateViewCnt(int video_id);

}
