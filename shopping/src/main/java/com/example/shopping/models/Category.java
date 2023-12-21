package com.example.shopping.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document
@AllArgsConstructor
public class Category {

  private String name;
}
