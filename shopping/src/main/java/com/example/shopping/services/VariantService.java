package com.example.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.models.Variant;
import com.example.shopping.repositories.VariantRepository;

@Service
public class VariantService {

  @Autowired
  private VariantRepository variantRepository;

  public void addVariant(Variant variant, String productImage) {
    if (variant.getImage() == null) {
      variant.setImage(productImage);
    }
    variantRepository.save(variant);
  }
}
