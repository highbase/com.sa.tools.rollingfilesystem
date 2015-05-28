package com.sa.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sa.utils.VO.FileTypeVO;

public class FileCount {

	static final Logger logger = LoggerFactory.getLogger(FileCount.class);
	
	public static void main(String[] args) {
		
		File pwd = new File("E:\\home\\test\\test-rolling");
		
		FilenameFilter fileFilter = new WildcardFileFilter("2015*");
		
		new FileCount().count(pwd, fileFilter);
	}

	public int count(File pwd, FilenameFilter fileFilter) {
		FileTypeVO fileType = new FileTypeVO();
		fileType.isFile = true;
		fileType.isDirectory = true;

		File[] files = pwd.listFiles(fileFilter);
		List<File> list = getListFiles(fileType, files);
		
		return list.size();
	}

	public List<File> getListFiles(FileTypeVO fileType, File[] files) {
		List<File> list = new ArrayList<File>();
		
		int i = 0;
		for (File file : files) {
			if (fileType.isFile && file.isFile()) {
				list.add(file);
				logger.debug("[{}] {}", ++i, file.getName());
			}
			if (fileType.isDirectory && file.isDirectory()) {
				list.add(file);
				logger.debug("[{}] {}", ++i, file.getName());
			}
		}
		logger.debug("total count of files: {}", i);
		
		return list;
	}

}
