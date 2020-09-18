package com.hjh.fileuploadex.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;
import net.coobird.thumbnailator.Thumbnailator;

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
		for (MultipartFile multiPartFile : uploadFile) {
			log.info("-----------------------------------------------");
			log.info("Upload File Name : " + multiPartFile.getOriginalFilename());
			log.info("Upload File Size : " + multiPartFile.getSize());

			File saveFile = new File("e:\\upload", multiPartFile.getOriginalFilename());
			try {
				multiPartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.info(e.getMessage());
			}
		}
	}

	@PostMapping("/uploadAjaxAction")
	public ResponseEntity<String> uploadAjaxPost(MultipartFile[] uploadFile, Model model) {
		String msg = null;
		String uploadFolder = "e:\\upload";
		File uploadPath = new File(uploadFolder, getFolder());
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs(); // 파일있으면 말고, 파일없으면 생성
		}

		for (MultipartFile multiPartFile : uploadFile) {
			log.info("-----------------------------------------------");
			log.info("Upload File Name : " + multiPartFile.getOriginalFilename());
			log.info("Upload File Size : " + multiPartFile.getSize());

			UUID uuid = UUID.randomUUID();
			String uploadFileName = uuid.toString() + "_" + multiPartFile.getOriginalFilename();
			File saveFile = new File(uploadPath, uploadFileName);
			// File saveFile = new File(uploadPath, multiPartFile.getOriginalFilename());
			try {
				multiPartFile.transferTo(saveFile);
				msg = "success";
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(
							new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(multiPartFile.getInputStream(),
							thumbnail, 100, 100);
					thumbnail.close();
				}
				
			} catch (Exception e) {
				log.info(e.getMessage());
				msg = "error";
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
