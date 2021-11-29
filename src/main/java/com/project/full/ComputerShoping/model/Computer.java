package com.project.full.ComputerShoping.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table
@Data
@NoArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2,message = "invalid brand name")
    private String brand;

    @Min(value = 4,message = "at least 4 GB")
    @Max(value = 256,message = "max 256 GB")
    private int RAM;

    @NotEmpty(message = "invalid model")
    private String model;

    @NotEmpty(message = "invalid processor")
    private String processor;

    @Min(value = 100,message = "at least $100")
    private int cost;

    @Min(value = 256, message = "at least 256 GB")
    private int ROM;

    @NotEmpty(message = "select some option")
    private String ROM_type;

    @NotEmpty(message = "select some option")
    private String comp_condition;

    @NotEmpty(message = "write something")
    @Size(min = 10, message = "at least 10 digits")
    private String comp_description;

    @NotEmpty(message = "invalid operating system")
    private String operating_system;

    @NotEmpty(message = "invalid video card")
    private String video_card;

    private String photo_name;

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(MultipartFile multipartFile) {
        this.photo_name = multipartFile.getOriginalFilename();
    }
}
