package top.lrj.springbootweek03.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.lrj.springbootweek03.common.Result;
import top.lrj.springbootweek03.exception.BusinessException;

import java.io.File;

/**
 * Hutool工具接口
 */
@RestController
@RequestMapping("/api/hutool")
public class HutoolController {

    // UUID生成
    @GetMapping("/id")
    public Result<IdVO> generateId() {
        IdVO vo = new IdVO();
        vo.setFastSimpleUUID(IdUtil.fastSimpleUUID()); // 无横杠UUID
        vo.setSnowflakeId(IdUtil.getSnowflakeNextId()); // 雪花ID
        return Result.success(vo);
    }

    // MD5加密
    @GetMapping("/md5")
    public Result<Md5VO> md5Encrypt(@RequestParam String text) {
        if (text == null || text.isEmpty()) {
            throw new BusinessException(400, "加密文本不能为空");
        }
        Md5VO vo = new Md5VO();
        vo.setOriginalText(text);
        vo.setMd532(DigestUtil.md5Hex(text)); // 32位MD5
        return Result.success(vo);
    }

    // 文件上传
    @PostMapping("/upload")
    public Result<UploadVO> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new BusinessException(400, "上传文件不能为空");
        }
        // 保存路径：项目根目录/upload
        String uploadDir = System.getProperty("user.dir") + "/upload";
        FileUtil.mkdir(uploadDir);

        // 生成唯一文件名（大作业验收点）
        String originalName = file.getOriginalFilename();
        String extName = FileUtil.extName(originalName);
        String uniqueFileName = IdUtil.simpleUUID() + "." + extName;

        try {
            File destFile = new File(uploadDir + "/" + uniqueFileName);
            file.transferTo(destFile);
            UploadVO vo = new UploadVO();
            vo.setOriginalName(originalName);
            vo.setUniqueFileName(uniqueFileName);
            vo.setFilePath(destFile.getAbsolutePath());
            return Result.success(vo);
        } catch (Exception e) {
            throw new BusinessException(500, "文件上传失败：" + e.getMessage());
        }
    }

    // 内部VO：避免Map，仅封装数据
    @lombok.Data
    private static class IdVO {
        private String fastSimpleUUID;
        private Long snowflakeId;
    }

    @lombok.Data
    private static class Md5VO {
        private String originalText;
        private String md532;
    }

    @lombok.Data
    private static class UploadVO {
        private String originalName;
        private String uniqueFileName;
        private String filePath;
    }
}