package com.joseph.filedownload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Joseph
 */
@Controller
@RequestMapping("/file")
public class FileDownloadController {
	@RequestMapping("/oneFile")
	public void oneFile() {

	}

	@RequestMapping("/zipWithFolder")
	public void zip(HttpServletResponse response) {
		ZipOutputStream out = null;
		InputStream input = null;
		String zipName = "压缩包" + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".zip";
		try {
			response.reset();
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader("Content-Disposition",
					"attachment; filename=" + new String(zipName.getBytes("GBK"), "iso-8859-1"));
			out = new ZipOutputStream(response.getOutputStream());
			File directory = new File("E:\\测试压缩");
			File[] files = directory.listFiles();
			int num = 0;
			for (File file : files) {
				input = new FileInputStream(file);
				//接收json数据
				String json = "";
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = input.read(buffer)) > 0) {
					json=json+new String(Arrays.copyOfRange(buffer,0,len),"GBK");
				}
				out.putNextEntry(new ZipEntry("/test/"+file.getName()));
				out.write(json.getBytes());
				input.close();
				num++;
				if(num==2){
					out.flush();
					out.closeEntry();
				}
			}
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}

}
