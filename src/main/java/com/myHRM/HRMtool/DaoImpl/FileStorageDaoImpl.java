package com.myHRM.HRMtool.DaoImpl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.myHRM.HRMtool.DAO.FileStorageDao;

@Service
public class FileStorageDaoImpl implements FileStorageDao{

	@Autowired
	GridFsTemplate gridFsTemplate;
	
	@Autowired
    private MongoDbFactory mongoDbFactory;

	@Override
	public String store(InputStream inputStream, String fileName,
			String contentType, DBObject metaData) {
		return this.gridFsTemplate
				.store(inputStream, fileName, contentType, metaData).toString();
	}

	@Override
	public GridFsResource getById(String id) {
		GridFSFile fsfile = this.gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
		System.out.println(fsfile.getFilename());
		GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDbFactory.getDb());
		return new GridFsResource(fsfile, gridFSBucket.openDownloadStream(fsfile.getObjectId()));
	}

	@Override
	public GridFSFile getByFilename(String fileName) {
		return gridFsTemplate.findOne(new Query(Criteria.where("filename").is(
				fileName)));
	}

	@Override
	public GridFSFile retrive(String fileName) {
		return gridFsTemplate.findOne(
				new Query(Criteria.where("filename").is(fileName)));
	}

}
