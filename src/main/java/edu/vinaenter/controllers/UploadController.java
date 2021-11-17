package edu.vinaenter.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.vinaenter.model.User;
import edu.vinaenter.validator.PictureValidate;

@Controller
public class UploadController {

	@Autowired
	private PictureValidate pictureValid;

	@GetMapping("upload")
	public String upload() {
		return "upload";
	}

	@PostMapping("upload")
	public String upload(@Valid @ModelAttribute("userError") User user, BindingResult rs,
			@RequestParam("pic") MultipartFile multipartFile, HttpServletRequest rq, Model model) {
		pictureValid.PictureValid(multipartFile, rs);
		if (rs.hasErrors()) {
			return "upload";
		}
		System.out.println("Ok=========================");
		String dirUpload = rq.getServletContext().getRealPath("WEB-INF/resources/uploads");
		String fileName = multipartFile.getOriginalFilename();
		System.out.println(dirUpload);

//		fileName = FilenameUtils.getBaseName(fileName) + "-" + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
		fileName = "vne-" + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);

		File dir = new File(dirUpload);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String filePath = dirUpload + File.separator + fileName;
		try {
			multipartFile.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("fileName", fileName);
		model.addAttribute("success", "tải ảnh thành công");
		return "upload";
	}
}
