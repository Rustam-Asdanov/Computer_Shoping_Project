package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.model.Computer;
import com.project.full.ComputerShoping.service.AccountDaoService;
import com.project.full.ComputerShoping.service.ComputerDaoService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;

@RestController
@RequestMapping("/computer/rest")
public class ComputerPageRestController {

    private final ComputerDaoService computerDaoService;
    private final AccountDaoService accountDaoService;

    public ComputerPageRestController(ComputerDaoService computerDaoService, AccountDaoService accountDaoService) {
        this.computerDaoService = computerDaoService;
        this.accountDaoService = accountDaoService;
    }

    @GetMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        System.out.println("delete");
        computerDaoService.deleteComputerById(id);
    }

    private static int counter = 0;
    @GetMapping("/load/{count}")
    public List<Computer> loadComputers(
            @PathVariable("count") int count){

        long id = accountDaoService.getCurrentUserAccount().getId();

        if(count<0 && count<counter){
            counter -= count;
        } else {
            counter += count;
        }

        return computerDaoService.getComputerList(id,count);
    }

    @GetMapping(
            value = "/image/{imageName}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImage(
            @PathVariable("imageName") String imageName
    ) {
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            System.out.println(imageName);
            File file = new File("C:\\Users\\Rustam\\Desktop\\" +
                    "Developia\\FINAL PROJECTS\\BACKEND PROJECT\\" +
                    "ComputerShoping\\ComputerShoping\\src\\main\\resources\\" +
                    "static\\user_images\\"+auth.getName() + "---" + imageName);

            InputStream in = new FileInputStream(file);
            return IOUtils.toByteArray(in);
        } catch (FileNotFoundException fex){
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(
            value = "/image_for_everyone/{userPicture}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageForEveryone(
            @PathVariable("userPicture") String userPicture
    ) {
        try{
            System.out.println(userPicture);
            File file = new File("C:\\Users\\Rustam\\Desktop\\" +
                    "Developia\\FINAL PROJECTS\\BACKEND PROJECT\\" +
                    "ComputerShoping\\ComputerShoping\\src\\main\\resources\\" +
                    "static\\user_images\\" + userPicture);

            InputStream in = new FileInputStream(file);
            return IOUtils.toByteArray(in);
        } catch (FileNotFoundException fex){
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

