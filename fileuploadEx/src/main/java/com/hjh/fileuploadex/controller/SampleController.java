package com.hjh.fileuploadex.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hjh.fileuploadex.domain.AttachFileDTO;

import lombok.extern.java.Log;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log
@RequestMapping("/sample")
public class SampleController {
	
	List<AttachFileDTO> test;

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

//	@PostMapping("/uploadAjaxAction")
//	public ResponseEntity<String> uploadAjaxPost(MultipartFile[] uploadFile, Model model) {
//		String msg = null;
//		String uploadFolder = "e:\\upload";
//		File uploadPath = new File(uploadFolder, getFolder());
//		if (uploadPath.exists() == false) {
//			uploadPath.mkdirs(); // 파일있으면 말고, 파일없으면 생성
//		}
//
//		for (MultipartFile multiPartFile : uploadFile) {
//			log.info("-----------------------------------------------");
//			log.info("Upload File Name : " + multiPartFile.getOriginalFilename());
//			log.info("Upload File Size : " + multiPartFile.getSize());
//
//			UUID uuid = UUID.randomUUID();
//			String uploadFileName = uuid.toString() + "_" + multiPartFile.getOriginalFilename();
//			File saveFile = new File(uploadPath, uploadFileName);
//			// File saveFile = new File(uploadPath, multiPartFile.getOriginalFilename());
//			try {
//				multiPartFile.transferTo(saveFile);
//				msg = "success";
//				if(checkImageType(saveFile)) {
//					FileOutputStream thumbnail = new FileOutputStream(
//							new File(uploadPath, "s_" + uploadFileName));
//					Thumbnailator.createThumbnail(multiPartFile.getInputStream(),
//							thumbnail, 100, 100);
//					thumbnail.close();
//				}
//				
//			} catch (Exception e) {
//				log.info(e.getMessage());
//				msg = "error";
//			}
//		}
//
//		return ResponseEntity.status(HttpStatus.OK).body(msg);
//	}

	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {

		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
		String uploadFolder = "C:\\upload";

		String uploadFolderPath = getFolder();
		// make folder --------
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		// make yyyy/MM/dd folder

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name: " + uploadFileName);
			attachDTO.setFileName(uploadFileName);

			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;

			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);

				// check image type file
				if (checkImageType(saveFile)) {

					attachDTO.setImage(true);

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}

				// add to List
				list.add(attachDTO);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end for
		test = list;
		return new ResponseEntity<List<AttachFileDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> deleteFile(String fileName, String type) {
		log.info("deleteFile: " + fileName);

		File file;
		try {
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			if (type.equals("image")) {

				String largeFileName = file.getAbsolutePath().replace("s_", "");

				log.info("largeFileName: " + largeFileName);

				file = new File(largeFileName);

				file.delete();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<List<AttachFileDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AttachFileDTO>>(test, HttpStatus.OK);
	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName) {
		log.info("download file: " + fileName);
		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		log.info("resource: " + resource);
		String resourceName = resource.getFilename();
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition",
					"attachment; filename=" + new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {

		log.info("fileName: " + fileName);

		File file = new File("c:\\upload\\" + fileName);

		log.info("file: " + file);

		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();

			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	//파일이 이미지인지 검사 메서드.
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
