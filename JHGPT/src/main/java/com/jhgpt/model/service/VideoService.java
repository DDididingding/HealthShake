package com.jhgpt.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhgpt.model.dto.Video;

@Service
public interface VideoService {
    
    List<Video> getAllVideos();
    
    Video getVideoByCode(int video_code);
    
    void addVideo(Video video);
    
    void deleteVideo(int video_code);
    
    void updateVideo(Video video);
    
//    List<Video> getVideosByUploader(int video_uploader_code);

	List<Video> getTrainerVideos(int member_code);

	void updateViewCnt(int video_code);
    // 다른 비디오 관련 기능을 추가하려면 여기에 메소드를 계속해서 추가할 수 있습니다.
}
