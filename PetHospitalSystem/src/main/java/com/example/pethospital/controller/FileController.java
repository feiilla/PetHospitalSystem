package com.example.pethospital.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pethospital.pojo.HospitalFile;
import com.example.pethospital.service.FileService;
import com.example.pethospital.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public String saveNewFile(@RequestParam(value = "file", required = false) MultipartFile file){
        JSONObject json = new JSONObject();
        try{
            FileUploadUtil.assertAllowed(file);
            String filePath = System.getProperty("user.dir") + File.separator + "petHospitalFiles" + File.separator;
            String newName = FileUploadUtil.encodedFileName(file);
            if(FileUploadUtil.isVideo(file)){
                filePath += "video";
            }
            else if(FileUploadUtil.isImage(file)){
                filePath += "image";
            }
            else{
                filePath += "file";
            }
            filePath = filePath + File.separator + newName;

            File newFile = new File(filePath);
            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            if(newFile.exists()){
                json.put("code", -1);
                json.put("msg", "file already exists");
                return JSON.toJSONString(json);
            }
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            file.transferTo(newFile);

            int ok = fileService.saveFile(filePath, file.getOriginalFilename(), timestamp, (int)file.getSize());
            if(ok == 1){
                json.put("code", 1);
                json.put("msg", "上传成功");
                json.put("path", filePath);
            }
            else{
                json.put("code", -1);
                json.put("msg", "上传失败");
                newFile.delete();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            json.put("code", -1);
            json.put("msg", "IOException");
        }
        return JSON.toJSONString(json);
    }

    @PostMapping("/delete")
    public String deleteFile(@RequestParam String path){
        JSONObject json = new JSONObject();
        HospitalFile hf = fileService.selectFileByPath(path);
        File file = new File(path);
        if(hf == null || !file.exists() || !file.isFile()){
            json.put("code", -1);
            json.put("msg", "file not exists");
            return JSON.toJSONString(json);
        }
        boolean ok = file.delete();
        if(!ok){
            json.put("code", -1);
            json.put("msg", "fail to delete file");
            return JSON.toJSONString(json);
        }
        fileService.deleteFile(path);
        json.put("code", 1);
        json.put("msg", "delete success");
        return JSON.toJSONString(json);
    }
}
