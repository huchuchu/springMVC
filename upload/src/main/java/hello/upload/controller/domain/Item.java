package hello.upload.controller.domain;

import lombok.Data;

import java.util.List;
import java.util.Locale;

@Data
public class Item {
    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;

}
