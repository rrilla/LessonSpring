package com.hjh.fileuploadex.controller;

import java.io.File;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
	}
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		for(MultipartFile multiPartFile : uploadFile) {
			log.info("-----------------------------------------------");
			log.info("Upload File Name : " + multiPartFile.getOriginalFilename());
			log.info("Upload File Size : " + multiPartFile.getSize());
			
			File saveFile = new File("e:\\upload",multiPartFile.getOriginalFilename());
			try {
				multiPartFile.transferTo(saveFile);
			}catch(Exception e) {
				log.info(e.getMessage());
			}
		}
	}
	
	@PostMapping("/uploadAjaxAction")
	public ResponseEntity<String> uploadAjaxPost(MultipartFile[] uploadFile, Model model) {
		String msg = null;
		for(MultipartFile multiPartFile : uploadFile) {
			log.info("-----------------------------------------------");
			log.info("Upload File Name : " + multiPartFile.getOriginalFilename());
			log.info("Upload File Size : " + multiPartFile.getSize());
			
			File saveFile = new File("e:\\upload",multiPartFile.getOriginalFilename());
			try {
				multiPartFile.transferTo(saveFile);
				msg = "success";
			}catch(Exception e) {
				log.info(e.getMessage());
				msg = "error";
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(msg);
		
	}
}
