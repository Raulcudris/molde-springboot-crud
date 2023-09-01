package com.example.apirest.service;

import com.example.apirest.entity.Image;
import com.example.apirest.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ImageServiceImpl implements  ImageService {
    @Autowired
    private ImageRepository repository;

    @Override
    public Image saveImage(Image image) {
        return  repository.save(image);
    }

    @Override
    public List<Image> listImage() {
        return (List<Image>) repository.findAll();
    }

    @Override
    public Image updateImage(Image image, Integer id) {
        Image newImage = repository.findById(id).get();
        if(Objects.nonNull(image.getName())&& !"".equalsIgnoreCase(image.getName()))
        {
            newImage.setName(image.getName());
        }
        if(Objects.nonNull(image.getType())&& !"".equalsIgnoreCase(image.getType()))
        {
            newImage.setType(image.getType());
        }
        if(Objects.nonNull(image.getImage())&& !"".equalsIgnoreCase(image.getImage()))
        {
            newImage.setName(image.getImage());
        }
        return  repository.save(newImage);
    }

    @Override
    public void deleteImageById(Integer id) {
        repository.deleteById(id);
    }
}
