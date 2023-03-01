package com.wei.demo.db.service;

import com.wei.demo.db.entity.FileEntity;
import com.wei.demo.db.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public FileEntity save(FileEntity fileEntity){return fileRepository.save(fileEntity);}

    public FileEntity findByFileID(String file_id){return fileRepository.findByFileID(file_id);};

    public List<FileEntity> findAll(){return  fileRepository.findAll();}
}
