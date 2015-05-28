package com.sa.tools.rollingfilesystem;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class CommandLineInterface {

	public static void main(String[] args) throws IOException {

		int maxIndex = 3;
		String work = "E:\\home\\test\\test-rolling";
		String filter = "*";
		
		if (args.length == 1) {
			String _work = StringUtils.defaultString(args[0]);
			if (_work.length() > 0) {
				work = _work;
			}
			RollingFileSystem.doExecute(maxIndex, work, filter);
		} else if (args.length == 2) {
			String _work = StringUtils.defaultString(args[0]);
			int _maxIndex = NumberUtils.toInt(args[1]);
			if (_work.length() > 0) {
				work = _work;
			}
			if (_maxIndex > 0) {
				maxIndex = _maxIndex;
			}
			RollingFileSystem.doExecute(maxIndex, work, filter);
		} else if (args.length == 3) {
			String _work = StringUtils.defaultString(args[0]);
			int _maxIndex = NumberUtils.toInt(args[1]);
			String _filter = StringUtils.defaultString(args[2]);
			if (_work.length() > 0) {
				work = _work;
			}
			if (_maxIndex > 0) {
				maxIndex = _maxIndex;
			}
			if (_filter.length() > 0) {
				filter = _filter;
			}
			RollingFileSystem.doExecute(maxIndex, work, filter);
		} else {
			usage();
		}
	}
	
	static private void usage() {
		String[] msg = {
			"Usage: RollingFileSystem <work-directory> <rolling-size> <filter>",	
			"",	
		};
		System.out.println(StringUtils.join(msg, "\r\n"));
	}

}
