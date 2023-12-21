package com.example.shopping.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {

  @Id
  private String id;

  private String name;

  private float price;

  private String image;

  private String description;

  private int stock;

  private List<Variant> variants;

  private Category category;
}
