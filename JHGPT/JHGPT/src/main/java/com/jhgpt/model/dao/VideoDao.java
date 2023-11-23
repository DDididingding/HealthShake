package com.jhgpt.model.dao;

import java.util.List;
import com.jhgpt.model.dto.Video;

public interface VideoDao {
	List<Video> selectAllVideos();
	
	List<Video> selectTrainerVideos(int member_code);

	Video selectOneVideo(int video_code);

	void insertVideo(Video video);

	void deleteVideo(int video_code);

	void updateVideo(Video video);

	void updateViewCnt(int video_code);
}
