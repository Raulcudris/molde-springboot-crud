package com.example.apirest.controller;

import com.example.apirest.entity.Image;
import com.example.apirest.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/images", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ImageController {
    @Autowired
    private ImageService imageService;


    // Save operation
    @PostMapping("create")
    public Image saveImageService(@RequestBody Image image)
    {
        return imageService.saveImage(image);
    }

    // Read operation
    @GetMapping("getall")
    public List<Image> listImages()
    {
        return imageService.listImage();
    }

    // Update operation
    @PutMapping("update{id}")
    public Image updateImage(@RequestBody Image department,
                             @PathVariable("id") Integer id)
    {
        return imageService.updateImage(department, id);
    }

    // Delete operation
    @DeleteMapping("delete/{id}")
    public String deleteImageById(@PathVariable("id")
                                  Integer id)
    {
        imageService.deleteImageById(id);
        return "Deleted Successfully";
    }
}
