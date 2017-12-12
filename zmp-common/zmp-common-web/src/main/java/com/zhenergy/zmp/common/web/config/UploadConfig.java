package com.zhenergy.zmp.common.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhenergy.zmp.common.upload.DiskFileOperator;
import com.zhenergy.zmp.common.upload.FileOperator;
import com.zhenergy.zmp.common.upload.util.FileManager;

/**
 * 文件上传配置
 *
 */
@Configuration
public class UploadConfig {

    /**
     * Oss file operator oss file operator.
     *
     * @return the oss file operator
     */
    @Bean
    @ConfigurationProperties("upload")
    public DiskFileOperator diskFileOperator() {
        return new DiskFileOperator();
    }

    /**
     * File manager file manager.
     *
     * @param fileOperator the file operator
     * @return the file manager
     */
    @Bean
    public FileManager fileManager(FileOperator fileOperator) {
        FileManager fileManager = new FileManager();
        fileManager.setFileOperator(fileOperator);
        return fileManager;
    }

}