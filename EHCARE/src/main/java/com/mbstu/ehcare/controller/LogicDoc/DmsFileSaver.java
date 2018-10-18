package com.mbstu.ehcare.controller.LogicDoc;

import com.csinfotechbd.cryptography.AESCrypto;
import com.csinfotechbd.cryptography.CryptoException;
import com.csinfotechbd.logicdoc.LogiDocDao;
import com.csinfotechbd.logicdoc.LogiDocSettingsEntity;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.exceptions.CmisConnectionException;
import org.apache.chemistry.opencmis.commons.impl.MimeTypes;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class DmsFileSaver {
    @Autowired
    private StringManipulator stringManipulator;

    @Autowired
    private LogiDocDao logiDocDao;

    private Session cmisSession() throws CmisConnectionException {

        LogiDocSettingsEntity lDoc = logiDocDao.findLogiDocData();
        SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
        Map<String, String> parameter = new HashMap<String, String>();
        parameter.put(SessionParameter.USER, lDoc.getUsername());
        parameter.put(SessionParameter.PASSWORD, lDoc.getPassword());
        parameter.put(SessionParameter.ATOMPUB_URL, "http://" + lDoc.getIp() + ":" + lDoc.getPort() + "/service/cmis");
        parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
        List<Repository> repositories = new ArrayList<Repository>();
        repositories = sessionFactory.getRepositories(parameter);
        Repository repository = repositories.get(0);
        parameter.put(SessionParameter.REPOSITORY_ID, repository.getId());
        Session session = sessionFactory.createSession(parameter);
        return session;

    }

    public Folder folderCreate(String folderName, String path) {
        Folder root = (Folder) cmisSession().getObjectByPath(path);
        Map<String, String> newFolderProps = new HashMap<String, String>();
        newFolderProps.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder");
        newFolderProps.put(PropertyIds.NAME, folderName);
        root.createFolder(newFolderProps);
        return root;
    }

    public String saveFiletoDms(MultipartFile fileUpload, String parentFolderName, String childFolderName) throws IOException, CryptoException {
        // TODO Auto-generated method stub
        Folder targetFolder;
        if (cmisSession().existsPath("/Default/" + parentFolderName)) {
        } else {
            folderCreate(parentFolderName, "/Default/");
        }

        if (cmisSession().existsPath("/Default/" + parentFolderName + "/" + childFolderName)) {
            targetFolder = (Folder) cmisSession().getObjectByPath("/Default/" + parentFolderName + "/" + childFolderName);
            //System.out.println("if: /Default/" + parentFolderName + "/" + childFolderName);
        } else {
            folderCreate(childFolderName, "/Default/" + parentFolderName);
            targetFolder = (Folder) cmisSession().getObjectByPath("/Default/" + parentFolderName + "/" + childFolderName);
            //System.out.println("else: /Default/" + parentFolderName + "/" + childFolderName);
        }
        //System.out.println(targetFolder.getPath().toString());
        return getIDofCreatedDoc(targetFolder, fileUpload);
    }

    public String saveFiletoDms(MultipartFile fileUpload, String parentFolderName, String childFolderName, String fileName) throws IOException, CryptoException {
        // TODO Auto-generated method stub
        Folder targetFolder;
        if (cmisSession().existsPath("/Default/" + parentFolderName)) {
        } else {
            folderCreate(parentFolderName, "/Default/");
        }

        if (cmisSession().existsPath("/Default/" + parentFolderName + "/" + childFolderName)) {
            targetFolder = (Folder) cmisSession().getObjectByPath("/Default/" + parentFolderName + "/" + childFolderName);
            //System.out.println("if: /Default/" + parentFolderName + "/" + childFolderName);
        } else {
            folderCreate(childFolderName, "/Default/" + parentFolderName);
            targetFolder = (Folder) cmisSession().getObjectByPath("/Default/" + parentFolderName + "/" + childFolderName);
            //System.out.println("else: /Default/" + parentFolderName + "/" + childFolderName);
        }
        //System.out.println(targetFolder.getPath().toString());
        return getIDofCreatedDoc(targetFolder, fileUpload,fileName);
    }

    public String getIDofCreatedDoc(Folder targetFolder, MultipartFile fileUpload) throws IOException, CryptoException {
        String filename = fileUpload.getOriginalFilename();
        if (filename.indexOf(".") >= 0) {
            List<String> s = stringManipulator.cutStringByDelimeter(filename, ".");
            s.remove(s.size() - 1);
            filename = String.join(".", s);
        }
        String fileType = fileUpload.getContentType();
        return createFileToDms(targetFolder, filename, fileType, fileUpload.getInputStream()).getId();
    }

    public String getIDofCreatedDoc(Folder targetFolder, MultipartFile fileUpload, String fileName) throws IOException, CryptoException {
        String fileType = fileUpload.getContentType();
        return createFileToDms(targetFolder, fileName, fileType, fileUpload.getInputStream()).getId();
    }

    public Document createFileToDms(Folder folder, String filename, String fileType, InputStream inputStream) throws IOException, CryptoException {
        //encrypt
        byte[] encryptedBytes= AESCrypto.encrypt("it's crypto time", IOUtils.toByteArray(inputStream));

        ContentStream contentStream = new ContentStreamImpl(filename, null, fileType, new ByteArrayInputStream(encryptedBytes));
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
        String extension = MimeTypes.getExtension(fileType);
        properties.put(PropertyIds.NAME, filename + extension);
        properties.put(PropertyIds.CONTENT_STREAM_FILE_NAME, filename);
        properties.put(PropertyIds.CONTENT_STREAM_MIME_TYPE, fileType);
        Document doc = folder.createDocument(properties, contentStream, VersioningState.MAJOR);
        return doc;
    }

    /*
     * public void retriveFile(String documentId,Session documentSession){
     *
     *
     * }
     */
    public String getDocumentURL(String documentId) {
        Document doc = (Document) cmisSession().getObject(cmisSession().createObjectId(documentId));
        String conLink = doc.getContentUrl();
        return conLink;
    }

    public InputStream getContentStream(String documentId) throws IOException, CryptoException {
        Document doc = (Document) cmisSession().getObject(cmisSession().createObjectId(documentId));
        ContentStream docContentStream = cmisSession().getContentStream(doc);
        //decrypt
        byte[] decryptedBytes=AESCrypto.decrypt("it's crypto time", IOUtils.toByteArray(docContentStream.getStream()));
        return new ByteArrayInputStream(decryptedBytes);
    }

    /**
     * Created by Tanmoy on 05/03/2017.
     *
     * @return: void.
     * @param: documentId.
     * @usage: LoanInitService->findLoanByLoanIdWithBranchCusstomerAddress;
     */
    public String getDocumentName(String documentId) {
        Document doc = (Document) cmisSession().getObject(cmisSession().createObjectId(documentId));
        return doc.getName();
    }

    /**
     * Created by Tanmoy on 05/03/2017.
     *
     * @return: void.
     * @param: documentId.
     * @usage: LoanInitService->findLoanByLoanIdWithBranchCusstomerAddress;
     */
    public String getDocumentType(String documentId) {
        Document doc = (Document) cmisSession().getObject(cmisSession().createObjectId(documentId));
        return doc.getContentStreamMimeType();
    }

    /**
     * Created by Tanmoy on 29/03/2017.
     *
     * @return: Folder.
     * @param: path.
     * @usage: CreditMemoService->saveCreditMemoToDms;
     */
    public Folder getFolderByPath(String path) {
        return (Folder) cmisSession().getObjectByPath(path);
    }

    /**
     * Created by Tanmoy on 29/03/2017.
     *
     * @return: Folder.
     * @param: path.
     * @usage: CreditMemoService->saveCreditMemoToDms;
     */
    public boolean isFolderExistsByPath(String path) {
        return cmisSession().existsPath(path);
    }

    /**
     * Created by Tanmoy on 12/03/2017.
     *
     * @return: string.
     * @param: doc.
     * @usage: CreditMemoService->generateCreditMemo
     */
    public String getDocumentId(Document document) {
        return document.getId();
    }
}
