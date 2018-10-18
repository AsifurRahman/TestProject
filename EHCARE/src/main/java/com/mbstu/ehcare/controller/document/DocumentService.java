package com.mbstu.ehcare.controller.document;

import com.csinfotechbd.base.DmsFileSaver;
import com.csinfotechbd.bpmn.StringManipulator;
import com.csinfotechbd.cryptography.CryptoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Repository
@Transactional
public class DocumentService {
    @Autowired
    private DmsFileSaver fileSaver;
    @Autowired
    private DocumentDao documentDao;

    @Autowired
    public SessionFactory _sessionFactory;

    @Autowired
    StringManipulator stringManipulator;

    @Autowired
    DmsFileSaver dmsFileSaver;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void saveFile(DocumentEntity uploadFileEntity) throws IOException, CryptoException {

        // TODO Auto-generated method stub

        uploadFileEntity.setDmsFileId(fileSaver.saveFiletoDms(uploadFileEntity.getFileUpload(),
                uploadFileEntity.getCustomerId(), "carddoc"));

        getSession().saveOrUpdate(uploadFileEntity);

    }
//
//    @SuppressWarnings("unchecked")
//    public List<DocumentEntity> documentList(String loanIdDoc) {
//        // TODO Auto-generated method stub
//        Criteria criteria = getSession().createCriteria(DocumentEntity.class, "doc");
//        criteria.createCriteria("doc.cibReportEntity", "cibreport", JoinType.LEFT_OUTER_JOIN).add(Restrictions.isNull("cibReportId"));
//        criteria.add(Restrictions.eq("loanId", loanIdDoc));
//        criteria.add(Restrictions.isNull("customerId"));
//
//        List<DocumentEntity> documentEntities = criteria.list();
//        List<DocumentEntity> documentEntityList = new ArrayList<>();
//        for (DocumentEntity documentEntity : documentEntities) {
//            documentEntity.setDocumentName(dmsFileSaver.getDocumentName(documentEntity.getDmsFileId()));
//            if (documentEntity.getDocumentChecklistEntity() != null) {
//                documentEntity.getDocumentChecklistEntity().getName();
//            }
//            documentEntityList.add(documentEntity);
//        }
//
//        return documentEntityList;
//
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<DocumentEntity> customerDocumentList(String loanIdDoc, String customerId) {
//        // TODO Auto-generated method stub
//        Criteria criteria = getSession().createCriteria(DocumentEntity.class);
//        criteria.add(Restrictions.eq("loanId", loanIdDoc));
//        criteria.add(Restrictions.eq("customerId", customerId));
//        return criteria.list();
//
//    }
//
//    public List<DocumentEntity> customerDocList(String loanIdDoc, String customerId) {
//        List<DocumentEntity> documententityList = new ArrayList<>();
//        List<DocumentEntity> documentEntities = customerDocumentList(loanIdDoc, customerId);
//        for (DocumentEntity documentEntity : documentEntities) {
//            documentEntity.setDocumentUrl(getDocumentUrl(documentEntity.getDmsFileId()));
//            documentEntity.setDocumentType(getDocumentType(documentEntity.getDmsFileId()));
//            documententityList.add(documentEntity);
//            System.out.println("DocumentUrlForCustomer: " + documentEntity.getDocumentUrl());
//        }
//
//        return documententityList;
//    }
//
//
//    public DocumentEntity getDocumentEntity(int id) {
//        // TODO Auto-generated method stub
//        return (DocumentEntity) getSession().createQuery("from DocumentEntity where id=:id").setParameter("id", id).uniqueResult();
//        //return null;
//    }
//
//
//    public String getDocumentUrl(String documentId) {
//        // TODO Auto-generated method stub
//        return fileSaver.getDocumentURL(documentId);
//    }
//
//    public InputStream getDocumentStream(String documentId) throws IOException, CryptoException {
//        return fileSaver.getContentStream(documentId);
//    }
//
//    public DocumentDto saveVerificationResult(DocumentDto docVerificationResultDto) {
//        // TODO Auto-generated method stub
//        DocumentEntity documentEntity = new DocumentEntity();
//        documentEntity = findDocumentEntityById(docVerificationResultDto.getUploadFileId());
//        documentEntity.setVerificationComments(docVerificationResultDto.getVerificationComments());
//        VerificationTypeEntity verificationTypeEntity = new VerificationTypeEntity(docVerificationResultDto.getVerificationTypeId());
//        documentEntity.setVerificationTypeEntity(verificationTypeEntity);
//        getSession().saveOrUpdate(documentEntity);
//        return docVerificationResultDto;
//
//    }
//
//    public DocumentEntity findDocumentEntityById(Integer uploadFileId) {
//        // TODO Auto-generated method stub
//        Criteria criteria = getSession().createCriteria(DocumentEntity.class);
//        criteria.add(Restrictions.eq("uploadFileId", uploadFileId));
//        return (DocumentEntity) criteria.uniqueResult();
//    }
//
//
//    /**
//     * Created by Tanmoy on 05/03/2017.
//     *
//     * @return: void.
//     * @param: loanId, cibReportId.
//     * @usage:
//     */
//    public List<DocumentEntity> getDocumentByLoanIdandCibReportId(String loanId, Integer cibReportId) {
//        return documentDao.getDocumentByLoanIdandCibReportId(loanId, cibReportId);
//    }
//
//    public String getDocumentType(String documentId) {
//        // TODO Auto-generated method stub
//        return fileSaver.getDocumentType(documentId);
//    }
//
//    public String getDmsField(long loanId){
//    	return documentDao.findDocumentFieldByLoanId(String.valueOf(loanId));
//    }
    
}
