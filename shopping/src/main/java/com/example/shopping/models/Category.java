package com.example.shopping.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Category {

  private String name;
}
