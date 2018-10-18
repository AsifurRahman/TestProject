package com.mbstu.ehcare.controller.document;

import java.util.List;

/**
 * @Author: Tanmoy.
 * @Date&Time: ${Date} ${Time}.
 * @Package: com.csinfotechbd.los.document.
 */

public class DocumentDto {
    String customerId;
    /**
     * ASAD
     */
    private Integer uploadFileId;
    private Integer verificationTypeId;
    private String verificationComments;
   
    List<DocumentEntity> documentEntityList;
    
    public DocumentDto() {
		//super();
	}
	public DocumentDto(String customerId,List<DocumentEntity> documentEntityList){
        this.customerId=customerId;
        this.documentEntityList=documentEntityList;
    }
	public DocumentDto( Integer uploadFileId, Integer verificationTypeId, String verificationComments
			) {
		
		
		this.uploadFileId = uploadFileId;
		this.verificationTypeId = verificationTypeId;
		this.verificationComments = verificationComments;
		
		
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Integer getUploadFileId() {
		return uploadFileId;
	}
	public void setUploadFileId(Integer uploadFileId) {
		this.uploadFileId = uploadFileId;
	}
	public Integer getVerificationTypeId() {
		return verificationTypeId;
	}
	public void setVerificationTypeId(Integer verificationTypeId) {
		this.verificationTypeId = verificationTypeId;
	}
	public String getVerificationComments() {
		return verificationComments;
	}
	public void setVerificationComments(String verificationComments) {
		this.verificationComments = verificationComments;
	}
	public List<DocumentEntity> getDocumentEntityList() {
		return documentEntityList;
	}
	public void setDocumentEntityList(List<DocumentEntity> documentEntityList) {
		this.documentEntityList = documentEntityList;
	}
	
	
	
    
    

}
