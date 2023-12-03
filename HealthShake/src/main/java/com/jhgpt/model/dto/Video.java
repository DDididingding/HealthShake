package com.jhgpt.model.dto;

public class Video {
	private int video_code;
	private String video_title;
	private String video_readme;
	private String video_url;
	private int video_viewcnt;
	private int video_uploader;

	public int getVideo_code() {
		return video_code;
	}

	public void setVideo_code(int video_code) {
		this.video_code = video_code;
	}

	public String getVideo_title() {
		return video_title;
	}

	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}

	public String getVideo_readme() {
		return video_readme;
	}

	public void setVideo_readme(String video_readme) {
		this.video_readme = video_readme;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public int getVideo_viewcnt() {
		return video_viewcnt;
	}

	public void setVideo_viewcnt(int video_viewcnt) {
		this.video_viewcnt = video_viewcnt;
	}

	public int getVideo_uploader() {
		return video_uploader;
	}

	public void setVideo_uploader(int video_uploader) {
		this.video_uploader = video_uploader;
	}

	@Override
	public String toString() {
		return "Video [video_code=" + video_code + ", video_title=" + video_title + ", video_readme=" + video_readme
				+ ", video_url=" + video_url + ", video_viewcnt=" + video_viewcnt + ", video_uploader=" + video_uploader
				+ "]";
	}
}
