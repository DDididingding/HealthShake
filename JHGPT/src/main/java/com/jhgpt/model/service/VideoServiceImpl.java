package com.jhgpt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhgpt.model.dao.VideoDao;
import com.jhgpt.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
    private VideoDao videoDao;


    @Override
    public List<Video> getAllVideos() {
        return videoDao.selectAllVideos();
    }

    @Override
    public List<Video> getTrainerVideos(int member_code) {
        return videoDao.selectTrainerVideos(member_code);
    }

    @Override
    public Video getVideoByCode(int video_code) {
        return videoDao.selectOneVideo(video_code);
    }

    @Override
    public void addVideo(Video video) {
        videoDao.insertVideo(video);
    }

    @Override
    public void deleteVideo(int video_id) {
        videoDao.deleteVideo(video_id);
    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Override
    public void updateViewCnt(int video_id) {
        videoDao.updateViewCnt(video_id);
    }

//	@Override
//	public List<Video> getVideosByUploader(int video_uploader_code) {
//		// TODO Auto-generated method stub
//		//이거 나중에 수정해야해
//		return videoDao.selectTrainerVideos(video_uploader_code);
//	}

    // 다른 비디오 관련 기능을 추가하려면 여기에 메소드를 계속해서 추가할 수 있습니다.
}
