package com.groupdocs.watermark.examples;

import com.groupdocs.watermark.internal.c.a.s.exceptions.E;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CREATED BY L.C.Y on 2019-1-11
 */

@RestController
@RequestMapping
public class PDFWatermarkCleanController {

    @RequestMapping(value = "/pdf", method = RequestMethod.GET)
    public String cleanWatermark(String STORAGE_PATH, String OUTPUT_PATH, String FILE_NAME, String watermark) {
        if (STORAGE_PATH == null || STORAGE_PATH.trim().isEmpty()) {
            return "error: STORAGE_PATH存储路径不能为空";
        }
        if (OUTPUT_PATH == null || OUTPUT_PATH.trim().isEmpty()) {
            return "error: OUTPUT_PATH输出路径不能为空";
        }
        if (FILE_NAME == null || FILE_NAME.trim().isEmpty()) {
            return "error: FILE_NAME文件名称不能为空";
        }
        if (watermark == null || watermark.isEmpty()) {
            return "error: watermark去除水印不能为空";
        }

        try {
            Documents.PDF.removeWatermark(STORAGE_PATH, OUTPUT_PATH, FILE_NAME, watermark);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
}
