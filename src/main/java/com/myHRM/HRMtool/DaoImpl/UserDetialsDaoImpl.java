package com.myHRM.HRMtool.DaoImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.myHRM.HRMtool.DAO.FileStorageDao;
import com.myHRM.HRMtool.DAO.UserDetailsDao;
import com.myHRM.HRMtool.Service.UserDetailsService;
import com.myHRM.HRMtool.model.UserDetails;

@Service
public class UserDetialsDaoImpl implements UserDetailsService{

	@Autowired
	UserDetailsDao dao;
	
	@Autowired
	FileStorageDao fileStoreDao;
	
	@Override
	public void createUser(UserDetails user) {
		if(!user.getProfileImage().isEmpty()) {
			try {
				DBObject metaData = new BasicDBObject();
				metaData.put("UserDetails", user);
				InputStream inputStream;
				inputStream = new FileInputStream(user.getProfileImage());
				String id = fileStoreDao.store(inputStream, user.getId()+"_"+user.getFirstName()+"_"+user.getProfileImage(), "image/png", metaData);
				user.setProfileImage(id);
			}catch(IOException e){
				System.out.println("File out Failed"+e.getMessage());
			}
			
			
		}
//		try {
//			System.out.println(user.getId());
//			DBObject metaData = new BasicDBObject();
//			metaData.put("UserDetails", user);
//			InputStream inputStream;
//			inputStream = new FileInputStream(user.getProfileImage());
//			String id = fileStoreDao.store(inputStream, user.getId()+"_"+user.getFirstName()+"_"+user.getProfileImage(), "image/png", metaData);
//			user.setProfileImage(id);
//			System.out.println(id);
//			
//			GridFSFile byId = fileStoreDao.getById(id);
//			   System.out.println("File Name:- " + byId.getFilename());
//			   
//			   
//			   System.out.println("Find By Filename----------------------");
//			   GridFSFile byFileName = fileStoreDao.getByFilename(byId.getFilename());
//			   System.out.println("File Name:- " + byFileName.getFilename());
//			   
//			   GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDbFactory.getDb());
//			   GridFSFile retrive = fileStoreDao.retrive(byId.getFilename());
//			   
//			   File file = new File("/home/krishnaverma/Documents/new.png");
//			   FileOutputStream streamToDownloadTo = new FileOutputStream(file);
//			   gridFSBucket.downloadToStream(byId.getId(), streamToDownloadTo);
//               streamToDownloadTo.close();
//			   
//			   
//		} catch (IOException e) {
//System.out.println("THis shit Failed");			e.printStackTrace();
//		}
		
		dao.save(user);
	}

	@Override
	public List<UserDetails> getAllUserDetials() {
		return dao.findAll();
	}

	@Override
	public Optional<UserDetails> findUserDetialsById(int id) {
		return dao.findById(id);
	}

	@Override
	public void deleteUserDetialsById(int id) {
		dao.deleteById(id);
	}

	@Override
	public void updateUserDetials(UserDetails user) {
		dao.save(user);
	}

	@Override
	public void deleteAllUserDetials() {
		System.out.println("Delete all the accouts");
	}

	@Override
	public void createUsers(List<UserDetails> users) {
		dao.saveAll(users);
	}

	@Override
	public UserDetails findUserByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	@Override
	public GridFsResource getImage(String id) {
		return fileStoreDao.getById(id);
	}
	
}
