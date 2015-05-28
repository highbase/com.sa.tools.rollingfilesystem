package com.sa.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sa.utils.VO.FileTypeVO;

public class FileUtils {
	
	static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

	public static List<File> getListFiles(FileTypeVO fileType, File pwd, FilenameFilter fileFilter) {
		
		List<File> list = new ArrayList<File>();
		
		File[] files = pwd.listFiles(fileFilter);
		
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
	
	public static void deleteDirectory(File directory) {
		try {
			org.apache.commons.io.FileUtils.deleteDirectory(directory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteQuietly(File file) {
		org.apache.commons.io.FileUtils.deleteQuietly(file);
	}
	
	public static void main(String[] args) {
		
	}

}
