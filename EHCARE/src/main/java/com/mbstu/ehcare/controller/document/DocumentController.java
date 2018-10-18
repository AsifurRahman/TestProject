package com.mbstu.ehcare.controller.document;

import com.csinfotechbd.task.TaskService;
import org.bouncycastle.crypto.CryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/card/document/uploadfile")
public class DocumentController {

	@Autowired
	private DocumentService uploadFileService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private TaskService taskService;

//	@GetMapping(value = "uploadfile/create")
//	public String getFormFile(Model model, HttpSession session, Principal principal) {
//		List<DocumentChecklistEntity> documentsEntities = documentChecklistService.mandatoryDocumentList();
//		for (DocumentChecklistEntity documentEntity : documentsEntities) {
//			System.out.println("document Name: " + documentEntity.getName());
//
//		}
//		model.addAttribute("documentsEntity", documentsEntities);
//		model.addAttribute("uploadFileEntity", new DocumentEntity());
//		model.addAttribute("body", "uploadFile/uploadForm");
//		// must add tasks to model otherwise inbox sub-menu won't be visible.
//		model.addAttribute("tasks", taskService.getTaskListByAuthenticatedRole(session, principal));
//		return "layouts/default";
//	}

	@PostMapping(value = "/create")
	public @ResponseBody
    String postUploadedFile(@RequestParam("file") List<MultipartFile> multipartFile,
                            @RequestParam("customerId") String customerId,
			/* @RequestParam("documentIds")List<String> docIds, */WebRequest request)
			throws IOException, CryptoException, com.csinfotechbd.cryptography.CryptoException {

		System.out.println("Hit into Controller!!!!");

//		String customerId = request.getParameter("customerId");
		System.out.println("customerId: " + customerId);

		/*
		 * for(String p: docIds){ System.out.println("document Id: "+ p); }
		 */
		System.out.println(multipartFile.toString());

		for (MultipartFile indFile : multipartFile) {

			DocumentEntity uploadFileEntity = new DocumentEntity();
			uploadFileEntity.setCustomerId(customerId);
			uploadFileEntity.setFileUpload(indFile);
			uploadFileService.saveFile(uploadFileEntity);
		}
		return "/uploadfile/create";
	}

//	@GetMapping(value = "/uploadfile/view/{id}")
//	public String viewFile(Model model, @PathVariable String id) {
//		DocumentEntity documentEntity = uploadFileService.getDocumentEntity(Integer.parseInt(id));
//		String documentId = documentEntity.getDmsFileId();
//		String documentUrl = uploadFileService.getDocumentUrl(documentId);
//		String fileShow = "redirect:" + documentUrl;
//		return fileShow;
//	}

//	@ResponseBody
//	@RequestMapping(value = "/docVerificationResult/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public DocumentDto saveVerificationResult(@RequestBody DocumentDto docVerificationResultDto, BindingResult result,
//			Principal principal) {
//		System.out.println("uploadFileIdDto " + docVerificationResultDto.getUploadFileId());
//		return uploadFileService.saveVerificationResult(docVerificationResultDto);
//
//	}
//
//	@RequestMapping(value = "/document")
//	public void previewDocument(WebRequest request, HttpServletResponse httpServletResponse) throws Exception {
//		httpServletResponse.setContentType(request.getParameter("type"));
//		httpServletResponse.setHeader("Cache-Control", "private, max-age=5");
//
//		httpServletResponse.setHeader("Pragma", "");
//		ServletOutputStream ouputStream = httpServletResponse.getOutputStream();
//		InputStream is = documentService.getDocumentStream(request.getParameter("dId"));
//		try {
//			int b;
//			while ((b = is.read()) != -1) {
//				ouputStream.write(b);
//			}
//		} finally {
//			ouputStream.flush();
//			ouputStream.close();
//			is.close();
//		}
//	}
//
//	@GetMapping(value = "/corp/uploadfile/view/{id}")
//	public String viewFileCorp(Model model, @PathVariable long loanId) {
//		String documentId = uploadFileService.getDmsField(loanId);
//		//String documentId = documentEntity.getDmsFileId();
//		String documentUrl = uploadFileService.getDocumentUrl(documentId);
//		String fileShow = "redirect:" + documentUrl;
//		return fileShow;
//	}
}
