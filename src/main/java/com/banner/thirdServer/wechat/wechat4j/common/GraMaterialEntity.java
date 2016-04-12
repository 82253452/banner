package com.banner.thirdServer.wechat.wechat4j.common;

public class GraMaterialEntity {
	String thumb_media_id;
	String author;
	String title;
	String content_source_url;
	String content;
	String digest;
	String show_cover_pic;
	public GraMaterialEntity()
	{}
	public GraMaterialEntity(
			String thumb_media_id,
			String author,
			String title,
			String content_source_url,
			String content,
			String digest,
			String show_cover_pic){
		this.thumb_media_id=thumb_media_id;
		this.author=author;
		this.title=title;
		this.content_source_url=content_source_url;
		this.content=content;
		this.digest=digest;
		this.show_cover_pic=show_cover_pic;	
	}
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_source_url() {
		return content_source_url;
	}
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getShow_cover_pic() {
		return show_cover_pic;
	}
	public void setShow_cover_pic(String show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

	@Override
	public String toString() {
		return this.author;
	}
}
