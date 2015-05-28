package com.sa.tools.rollingfilesystem;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sa.utils.VO.FileTypeVO;
import com.sa.utils.FileUtils;

public class RollingFileSystem {

	static final Logger logger = LoggerFactory.getLogger(RollingFileSystem.class);
	
	static final int DEFAULT_MAX_INDEX = 10;
	
	public static void main(String[] args) {
		
		int maxIndex = 3;
		String work = "E:\\home\\test\\test-rolling";
		String filter = "2015*";
		
		doExecute(maxIndex, work, filter);
		
	}

	public static void doExecute(int maxIndex, String work, String filter) {
		int maxBackupIndex = DEFAULT_MAX_INDEX;
		if (maxIndex > 0) {
			maxBackupIndex = maxIndex;
		}
		
		File workDir = new File(work);
		
		FilenameFilter fileFilter = new WildcardFileFilter(filter);
		
		FileTypeVO fileType = new FileTypeVO();
		fileType.isFile = true;
		fileType.isDirectory = true;
		
		List<File> list = FileUtils.getListFiles(fileType, workDir, fileFilter);
		
		int size = list.size();
		
		int deleteCount = size - maxBackupIndex;
		
		if (deleteCount > 0) {
			logger.info("{} file{} must be delete.", deleteCount, deleteCount > 1 ? "s" : "");
		}
		
		int idx = 0;
		for (File file : list) {
			if (idx < deleteCount) {
				if (file.isDirectory()) {
					FileUtils.deleteDirectory(file);
					logger.info("[{}] {} directory deleted.", idx++, file.getName());
				} else if (file.isFile()) {
					FileUtils.deleteQuietly(file);
					logger.info("[{}] {} file deleted.", idx++, file.getName());
				}
			}
		}
	}

}
