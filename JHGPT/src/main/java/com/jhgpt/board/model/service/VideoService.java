package com.jhgpt.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhgpt.board.model.dto.Video;

@Service
public interface VideoService {
	
	public List<Video> getVideoList();
	
	public void registVideo(Video video);
	
	public Video selectVideo(int video_id);
	
	public void deleteVideo(int video_id);
}
