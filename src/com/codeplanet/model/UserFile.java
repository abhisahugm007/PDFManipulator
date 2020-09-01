package com.codeplanet.model;

import org.springframework.web.multipart.MultipartFile;

public class UserFile {
		int start;
		int end;
		String name;
		MultipartFile userfile;
		MultipartFile[] userfiles;
		String userfileString;
		
		public String getUserfileString() {
			return userfileString;
		}
		public void setUserfileString(String userfileString) {
			this.userfileString = userfileString;
		}
		public int getend() {
			return end;
		}
		public void setend(int end) {
			this.end = end;
		}
		public int getstart() {
			return start;
		}
		public void setstart(int start) {
			this.start = start;
		}
		public MultipartFile[] getUserfiles() {
			return userfiles;
		}
		public void setUserfiles(MultipartFile[] userfiles) {
			this.userfiles = userfiles;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public MultipartFile getUserfile() {
			return userfile;
		}
		public void setUserfile(MultipartFile userfile) {
			this.userfile = userfile;
		}
}
