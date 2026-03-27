package top.lrj.springbootweek04.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import top.lrj.springbootweek04.exception.BusinessException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;


@Slf4j
public class FileUpLoadUtil {
    private static final String UPLOAD_DIR = getUploadDir();

    static{
        File dir = new File(UPLOAD_DIR);
        if(!dir.exists()){
            if(!dir.mkdirs()){
                throw new RuntimeException("创建目录失败"+UPLOAD_DIR);
            }
        }
    }
    public static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            ".jpg",".jpeg",".png",".gif",".bmp",".webp",
            ".pdf",".doc",".docx",".xls",".xlsx",".ppt",".pptx",
            ".txt",".md",".csv",
            ".zip",".rar",".7z",
            ".json",".xml"
    );
    public static String getUploadDir(){
        try{
            String baseDir = ResourceUtils.getURL("classpath:").getPath();
            if (baseDir.startsWith("/")) {
                baseDir = baseDir.substring(1);
            }
            Path uploadPath = Paths.get(baseDir, "static/upload/");
            Files.createDirectories(uploadPath);
            String uploadDir = uploadPath.toAbsolutePath() + "/";
            log.info("上传目录：{}", uploadDir);
            return uploadDir;
        }catch (IOException e){
            throw new RuntimeException("获取上传目录失败",e);
        }
        }

    public static String upload(MultipartFile file) throws  IOException{
        String originalFileName = file.getOriginalFilename();
        if(originalFileName==null||originalFileName.isEmpty()){
            throw new BusinessException(400,"文件名不能为空");
        }
        String suffix =
                originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();
        if(!ALLOWED_EXTENSIONS.contains(suffix)){
            throw new BusinessException(400,"不支持的文件类型"+suffix);
        }
        String fileName= UUID.randomUUID().toString()+suffix;
        File dest = new File(UPLOAD_DIR+fileName);
        file.transferTo(dest);
        return fileName;
    }
}