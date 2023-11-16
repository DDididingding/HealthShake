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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhgpt.model.dto.Video;
import com.jhgpt.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
@Api(tags = "비디오 컨트롤러")
public class VideoRestController {

@Autowired
private VideoService videoService;

@GetMapping("/video")
@ApiOperation(value = "등록된 모든 비디오 정보 반환.", response = Video.class)
public ResponseEntity<?> getVideoList() {
    List<Video> list = videoService.getVideoList();
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
    videoService.registVideo(video);

    return new ResponseEntity<Video>(video, HttpStatus.CREATED);
}

// GetMapping
// select(READ)
@GetMapping("/video/{video_id}")
@ApiOperation(value = "{video_id}에 해당하는 user를 반환한다.", response = Video.class)
public ResponseEntity<?> selectVideo(@PathVariable int video_id) {
    Video list = videoService.selectVideo(video_id);
    if (list == null) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<Video>(list, HttpStatus.OK);
}

// DeleteMapping
// delete(DELETE)
@DeleteMapping("/video/{video_id}")
@ApiOperation(value = "video 객체를 삭제한다.", response = Integer.class)
public ResponseEntity<?> deleteVideo(@PathVariable int video_id) {
    videoService.deleteVideo(video_id);
    return new ResponseEntity<Void>(HttpStatus.OK);
}

private ResponseEntity<String> exceptionHandling(Exception e) {
    e.printStackTrace();
    return new ResponseEntity<String>("sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}
}