package com.cqut.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileController {
    @ResponseBody
    @RequestMapping(value = "/uploadImage")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            // 将文件保存到指定路径
            System.out.println(fileName);
            Path path = Paths.get("D:/aaa/" + fileName);
            Files.write(path, bytes);
            // 返回上传成功的响应
//            return new ResponseEntity<>("{url:\"/" + fileName + "\"}", HttpStatus.OK);
            return '/'+fileName;
        } catch (IOException e) {
            e.printStackTrace();
//            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
            return "error";
        }
    }
}
