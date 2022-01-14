package com.wei.transfer.db.repository;

import com.wei.transfer.db.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Repository
public interface FileRepository  extends JpaRepository<FileEntity,String> {
    @Query(value = "select  * from file where file_id=?1",nativeQuery = true)
    public FileEntity findByFileID(String file_id);

}
