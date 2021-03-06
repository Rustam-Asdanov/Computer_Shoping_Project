package com.project.full.ComputerShoping.service;

import com.project.full.ComputerShoping.model.Computer;
import com.project.full.ComputerShoping.repository.ComputerRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerDaoService {

    private final ComputerRepository computerRepository;

    public ComputerDaoService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public void addComputer(Computer computer) {
        computerRepository.save(computer);
    }

    public String addComputerImage(MultipartFile multipartFile,int pic_num){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String image_name = "";
        image_name += multipartFile.getOriginalFilename().split("\\.")[0];
        image_name += "_-_" + (pic_num+1);
        image_name += "." + multipartFile.getOriginalFilename().split("\\.")[1];

        try {
            multipartFile.transferTo(
                    new File(
                            "C:\\Users\\Rustam\\Desktop\\Developia\\" +
                                    "FINAL PROJECTS\\BACKEND PROJECT\\ComputerShoping\\" +
                                    "ComputerShoping\\src\\main\\resources\\" +
                                    "static\\user_images\\"+auth.getName()+"---"+image_name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image_name;
    }

    public int checkImageName(String originalFilename) {
        return computerRepository.checkImageName(originalFilename.split("\\.")[0]);
    }

    public void deleteComputerById(long id) {
        computerRepository.deleteById(id);
    }

    public Computer getComputerById(long id) {
        return computerRepository.getComputerById(id);
    }


    public List<Computer> getComputerList(long id,int counter) {
        List<Computer> listComputers = computerRepository
                .findAll().stream()
                .filter(computer -> computer.getTheAccount().getId()==id)
                .collect(Collectors.toList());

        if(listComputers.size()>5){
            return listComputers.subList(counter,counter+5);
        } else {
            return listComputers;
        }
    }

    public List<Computer> getComputerListForShop(int counter) {
        List<Computer> computerList = computerRepository.findAll();
        if(computerList.size()>5){
            return computerList.subList(counter,counter+5);
        } else {
            return computerList;
        }
    }
}
