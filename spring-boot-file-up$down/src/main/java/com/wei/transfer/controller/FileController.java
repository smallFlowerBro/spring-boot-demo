package com.wei.transfer.controller;
import com.wei.transfer.db.entity.ConfigEntity;
import com.wei.transfer.db.entity.FileEntity;
import com.wei.transfer.db.service.ConfigService;
import com.wei.transfer.db.service.FileService;
import com.wei.transfer.util.Rando;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author weiyongjian
 * @Description //文件控制器
 * @Date
 */
@RestController
@RequestMapping("/api/file")
public class FileController{

    @Autowired
    private ConfigService configService;

    @Autowired
    private  FileService fileService;

    @PostMapping("upload")
    public String  upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        ConfigEntity file_prefix = configService.findConfigByName("FILE_PREFIX");
        String originalFilename = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();
        BufferedInputStream bi=new BufferedInputStream(inputStream);
        String suffix =originalFilename.lastIndexOf('.')!=-1?originalFilename.substring(originalFilename.lastIndexOf('.')):"";
        String file_id = Rando.getFileID();
        String file_name = file_prefix.getValue()+ file_id+suffix;
        File file = new File(file_name);
        FileEntity fileEntity = new FileEntity(file_id, file_id+suffix);
        fileService.save(fileEntity);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer= new byte[1024];
        int c;
        while((c= bi.read(buffer))!=-1){
            outputStream.write(buffer,0,c);
        }
        outputStream.flush();
        outputStream.close();
        bi.close();
        inputStream.close();
        return "true";
    }

    @GetMapping("download")
    public  void downLoad(HttpServletRequest request, HttpServletResponse response,@RequestParam("file_id") String file_id) throws IOException {
        response.reset();
        response.setContentType("application/x-msdownload");

        FileEntity fileEntity = fileService.findByFileID(file_id);
        ConfigEntity file_prefix = configService.findConfigByName("FILE_PREFIX");
        String _prefix=file_prefix.getValue();
        String file_name=_prefix+fileEntity.getFile_path();
        File file = new File(file_name);
        FileInputStream fileInputStream = new FileInputStream(file);
        response.setContentLength((int)file.length());
        response.setHeader("Content-Disposition","attachment;filename="+file.getName());

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] buffer=new byte[1024];
        int c;
        ServletOutputStream outputStream = response.getOutputStream();
        while((c=bufferedInputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,c);
        }
        outputStream.flush();
        outputStream.close();
        bufferedInputStream.close();
        fileInputStream.close();
    }

    @GetMapping("fileList")
    public List<FileEntity> getFileEnityList(){
        List<FileEntity> fileEntities;
        fileEntities =fileService.findAll();
        return fileEntities;
    }
}
