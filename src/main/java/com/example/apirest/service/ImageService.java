package com.example.apirest.service;

import com.example.apirest.entity.Image;

import java.util.List;

public interface ImageService {
    Image saveImage(Image image);
    List<Image> listImage();
    Image updateImage(Image image, Integer id);
    void deleteImageById(Integer id);

}
