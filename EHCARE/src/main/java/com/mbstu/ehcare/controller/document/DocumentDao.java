package com.mbstu.ehcare.controller.document;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tanmoy on 3/5/2017.
 */
@Repository
@Transactional
public class DocumentDao {
    @Autowired
    SessionFactory _sessionFactory;


    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    /**
     * Created by Tanmoy on 05/03/2017.
     * @return: void.
     * @param: cibReportEntity.
     * @usage: CibReportService->saveOrUpdateCibReport;
     * @usage: CreditMemoController->generateCreditMemo;
     */
    public void saveDocument(DocumentEntity documentEntity) {
        getSession().saveOrUpdate(documentEntity);
    }

    /**
     * Created by Tanmoy on 05/03/2017.
     * @return: void.
     * @param: loanId,cibReportId.
     * @usage: DocumentService->getDocumentByLoanIdandCibReportId;
     */
    @SuppressWarnings("unchecked")
	public List<DocumentEntity> getDocumentByLoanIdandCibReportId(String loanId, Integer cibReportId) {
        Criteria criteria=getSession().createCriteria(DocumentEntity.class);
        criteria.createCriteria("doc.cibReportEntity","cibreport", JoinType.INNER_JOIN, Restrictions.eq("cibReportId",cibReportId));
        criteria.add(Restrictions.eq("loanId",loanId));
        return criteria.list();
    }

    public DocumentEntity getDocumentEntityById(Integer id){
        Criteria criteria=getSession().createCriteria(DocumentEntity.class);
        criteria.add(Restrictions.eq("uploadFileId",id));
//        criteria.add(Restrictions.eq("isDeleted",false));
    return (DocumentEntity) criteria.uniqueResult();
    }

    public DocumentEntity getDocumentEntityByDmsId(String dmsFileId){
        Criteria criteria=getSession().createCriteria(DocumentEntity.class);
        criteria.add(Restrictions.like("dmsFileId",dmsFileId));
//        criteria.add(Restrictions.eq("isDeleted",false));
    return (DocumentEntity) criteria.uniqueResult();
    }
    
    public String findDocumentFieldByLoanId(String londId){
    	Criteria criteria = getSession().createCriteria(DocumentEntity.class,"doc");
    	criteria.setProjection(Projections.property("doc.dmsFileId"));
    	criteria.add(Restrictions.eq("doc.loanId", londId));
    	return (String)criteria.uniqueResult();
    }


}
