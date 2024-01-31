package com.eniot.intern.lib.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Intern {
  @Id
  @Schema(description = "Autogenerated ID by JPA provider")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long internId;
  @Column(length = 20,unique = true)
  @NotEmpty
  @Size.List({
          @Size(min = 3, message = "Name must be at least 3 characters long"),
          @Size(max = 20, message = "Name must be at most 20 characters long")
  })
  @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Name must be alphanumeric with no spaces")
  @Schema(description = "Name must be alphanumeric with no spaces, dun try to be funny",
          minLength = 3,
          maxLength = 20)
  private String name;

  @Column(length = 30)
  @Schema(description = "University of student", maxLength = 30)
  @NotEmpty
  private String school;
}