package com.aurovind.springdata.filedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aurovind.springdata.filedata.entity.Image;
import com.aurovind.springdata.filedata.repos.ImageRepository;

@SpringBootTest
class FiledataApplicationTests {

	@Autowired
	ImageRepository imageRepository;
	
	@Test
	public void testImage() throws IOException {
		Image image = new Image();
		image.setId(1);
		image.setName("MAVEN.JPG");
		
		File file = new File("/users");
		byte fileContent[] = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(fileContent);
		
		image.setData(fileContent);
		imageRepository.save(image);
		fis.close();
		
	}
	
	@Test
	public void testReadImage() {
		Image image = imageRepository.findById(1L).get();
		File file = new File("/Users/" + image.getName());//location where you want to save the file in laptop
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(image.getData());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
