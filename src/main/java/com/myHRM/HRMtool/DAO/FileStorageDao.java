package com.myHRM.HRMtool.DAO;

import java.io.InputStream;

import org.springframework.data.mongodb.gridfs.GridFsResource;

import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

public interface FileStorageDao {

	public String store(InputStream inputStream, String fileName,
			String contentType, DBObject metaData);

	public GridFSFile retrive(String fileName);

	public GridFsResource getById(String id);

	public GridFSFile getByFilename(String filename);

}
