package com.mbstu.ehcare.controller.document;

import com.csinfotechbd.base.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name="los_tb_m_document")
@Data
@EqualsAndHashCode(callSuper=false)
public class DocumentEntity extends BaseInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer uploadFileId;
	private String loanId;
	private String customerId;
	private String dmsFileId;
	private String verificationComments;
	@Transient
	private MultipartFile fileUpload;
	@Transient
	private String documentUrl;
	@Transient
	private String documentName;
	@Transient
	private String documentType;
	@Transient
	private int isDisbursement;

//	@ManyToOne(optional = true)
//	@JoinColumn(name = "documentId")
//	private DocumentChecklistEntity documentChecklistEntity;
//
//	@ManyToOne(optional= true)
//	@JoinColumn(name= "verificationTypeId")
//	private VerificationTypeEntity verificationTypeEntity;
//
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "cibReportId")
//	private CibReportEntity cibReportEntity;
//
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "loanstatusid")
//	private LoanStatusEntity loanStatusEntity;
//
//	@Override
//	public String toString() {
//		return "DocumentEntity [loanId=" + loanId + ", customerId=" + customerId + ", dmsFileId=" + dmsFileId
//				+ ", verificationComments=" + verificationComments + ", fileUpload=" + fileUpload + ", documentUrl="
//				+ documentUrl + ", documentName=" + documentName + ", documentType=" + documentType
//				+ ", isDisbursement=" + isDisbursement + ", documentChecklistEntity=" + documentChecklistEntity
//				+ ", verificationTypeEntity=" + verificationTypeEntity + ", cibReportEntity=" + cibReportEntity
//				+ ", loanStatusEntity=" + loanStatusEntity + "]";
//	}
	
}
