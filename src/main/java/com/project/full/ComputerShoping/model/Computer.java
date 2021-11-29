package com.project.full.ComputerShoping.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2,message = "invalid brand name")
    private String brand;

    @NotEmpty(message = "invalid capacity")
    @Min(value = 4,message = "at least 4 GB")
    @Max(value = 256,message = "max 256 GB")
    private int RAM;

    @NotEmpty(message = "invalid model")
    private String model;

    @NotEmpty(message = "invalid processor")
    private String processor;

    @NotEmpty(message = "invalid cost")
    private int cost;

    @NotEmpty(message = "invalid capacity")
    private int ROM;

    @NotEmpty(message = "write something")
    @Size(min = 10, message = "at least 10 digits")
    private String condition;

    @NotEmpty(message = "invalid operating system")
    private String operating_system;

    @NotEmpty(message = "invalid video card")
    private String video_card;

    @NotEmpty(message = "put some photo")
    private String photo;
}
