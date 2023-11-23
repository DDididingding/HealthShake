package com.jhgpt.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhgpt.model.dto.Video;
import com.jhgpt.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "비디오 컨트롤러")
public class VideoRestController {

@Autowired
private VideoService videoService;

@GetMapping("/video")
@ApiOperation(value = "등록된 모든 비디오 정보 반환.", response = Video.class)
public ResponseEntity<?> getVideoList() {
    List<Video> list = videoService.getAllVideos();
    if (list == null || list.size() == 0) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
}

// GetMapping
// select(READ)
@GetMapping("/video/{video_code}")
@ApiOperation(value = "{video_code}인 video하나 가져오기.", response = Video.class)
public ResponseEntity<?> selectVideo(@PathVariable int video_code) {
    Video video = videoService.getVideoByCode(video_code);
    if (video == null) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<Video>(video, HttpStatus.OK);
}

@GetMapping("/video/trainer/{member_code}")
@ApiOperation(value = "{member_code}인 trainer의 video들 가져오기.", response = Video.class)
public ResponseEntity<?> selectTrainerVideo(@PathVariable int member_code) {
    List<Video> list = videoService.getTrainerVideos(member_code);
    if (list == null || list.size() == 0) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
}

// PostMapping
// insert(CREATE)
@PostMapping("/video")
@ApiOperation(value = "video 객체를 저장한다.", response = Integer.class)
public ResponseEntity<?> registVideo(@RequestBody Video video) throws Exception, IOException {
    videoService.addVideo(video);

    return new ResponseEntity<Video>(video, HttpStatus.CREATED);
}


// DeleteMapping
// delete(DELETE)
@DeleteMapping("/video/{video_code}")
@ApiOperation(value = "video 객체를 삭제한다.", response = Integer.class)
public ResponseEntity<?> deleteVideo(@PathVariable int video_code) {
    videoService.deleteVideo(video_code);
    return new ResponseEntity<Void>(HttpStatus.OK);
}

// PutMapping
// update(UPDATE)
@PutMapping("/video/{video_code}")
@ApiOperation(value = "video 객체를 수정한다.", response = Integer.class)
public ResponseEntity<?> updateVideo(@PathVariable int video_code, @RequestBody Video video) {
    Video originVideo = videoService.getVideoByCode(video_code);
    if (originVideo == null) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    video.setVideo_code(video_code);
    videoService.updateVideo(video);
    return new ResponseEntity<Void>(HttpStatus.OK);
}

//putMapping
//update(UPDATE)
@PutMapping("/video/view/{video_code}")
@ApiOperation(value = "video 객체의 조회수를 증가시킨다.", response = Integer.class)
public ResponseEntity<?> updateViewCnt(@PathVariable int video_code) {
    Video originVideo = videoService.getVideoByCode(video_code);
    if (originVideo == null) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    videoService.updateViewCnt(video_code);
    return new ResponseEntity<Void>(HttpStatus.OK);
}


private ResponseEntity<String> exceptionHandling(Exception e) {
    e.printStackTrace();
    return new ResponseEntity<String>("sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}
}