package com.example.shopping.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Variant {

  private String name;

  @Nullable
  private String color;

  @Nullable
  private String image;
}
