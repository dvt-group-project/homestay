package com.thinkpad.homestay.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.thinkpad.homestay.models.House;
import com.thinkpad.homestay.models.ImageHouse;
import com.thinkpad.homestay.models.Reservation;
import com.thinkpad.homestay.services.HouseService;
import com.thinkpad.homestay.services.ImageHouseService;
import com.thinkpad.homestay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.Date;

@Controller
public class HouseController {
    @Autowired
    private UserService userService;

    @Autowired
    private ImageHouseService imageHouseService;
    @Autowired
    private HouseService houseService;

    @ModelAttribute("houses")
    public Iterable<House> houses() {
        return houseService.findAll();
    }

    @GetMapping("/detail-house/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id) {

        String userName = getUserName();
        Iterable<ImageHouse> imageHouseList = imageHouseService.findAll(id);
        Optional<House> house = houseService.findById(id);
        ModelAndView modelAndView = new ModelAndView("house/room-single");
        modelAndView.addObject("house", house.get());
        modelAndView.addObject("reservation", new Reservation());
        modelAndView.addObject("imageHouseList", imageHouseList);
        modelAndView.addObject("userName", userName);
        modelAndView.addObject("user", userService.findByName(userName));
//        Collection<ImageHouse> imageHouses = house.get().imageHouses;
//        Iterator iterator = imageHouses.iterator();
//        while (iterator.hasNext()) {
//            ImageHouse imageHouse = (ImageHouse) iterator.next();
//            if (imageHouse.getAvatar() == 0) {
//                modelAndView.addObject("avatar", imageHouse);
//            }
//        }

        return modelAndView;
    }

    public String getUserName() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        }
        else {
            userName = principal.toString();
        }
        return userName;
    }

    @GetMapping("/houses")
    public ModelAndView listHouse(@PageableDefault(5) Pageable pageable) {
        Page<House> houses = houseService.findAll(pageable);
        return new ModelAndView("house/list", "houses", houses);
    }

    @GetMapping("/create-house")
    public ModelAndView showCreateHouseForm() {
        return new ModelAndView("house/create", "house", new House());
    }

    @PostMapping("/create-house")
    public ModelAndView createHouse(@Validated @ModelAttribute("house") House house, @RequestParam("file-image") MultipartFile avartaImage, @RequestParam("file-images") MultipartFile[] files, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("house/create");
        } else {
            houseService.save(house);
            return doUpload(avartaImage, files, house);
//            ModelAndView modelAndView = new ModelAndView("house/create", "house", new House());
//            modelAndView.addObject("message", "Create successfully");
//            return modelAndView;
        }
    }

    @GetMapping("/edit-house/{id}")
    public ModelAndView showEditHouseForm(@PathVariable("id") Integer id) {
        return new ModelAndView("house/edit", "house", houseService.findById(id));
    }

    @PostMapping("/edit-house")
    public ModelAndView editHouse(@ModelAttribute House house) {
        houseService.save(house);
        ModelAndView modelAndView = new ModelAndView("house/edit", "house", house);
        modelAndView.addObject("message", "Update successfully");
        return modelAndView;
    }

    @GetMapping("/delete-house/{id}")
    public ModelAndView showDeleteHouseForm(@PathVariable("id") Integer id) {
        return new ModelAndView("house/delete", "house", houseService.findById(id));
    }

    @PostMapping("/delete-house")
    public ModelAndView deleteHouse(@ModelAttribute House house) {
        houseService.delete(house.getId());
        ModelAndView modelAndView = new ModelAndView("house/delete", "house", house);
        modelAndView.addObject("message", "Delete successfully");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("address") String address,@PageableDefault(3) Pageable pageable) {
        Page<House> houses = houseService.findAllByAddress(address,pageable);
        List<House> leasingHouse = new ArrayList<>();
        for (House house:houses) {
            if (house.getStatus()==true) {
                leasingHouse.add(house);
            }
        }
            ModelAndView modelAndView = new ModelAndView("house/rooms-list");
        modelAndView.addObject("houses", leasingHouse);
        return modelAndView;
    }
    public ModelAndView doUpload(MultipartFile avartaImage, MultipartFile[] files, House house) {

        //Thu muc goc de save fileupload tren server
//        String uploadRootPath = httpServletRequest.getServletContext().getRealPath("/home/dat/upload");
//        System.out.println("uploadRootPath = " + uploadRootPath);

//        File uploadRootDir = new File("/home/dat/uploads");
//
//        //Tao thu muc goc neu no khong ton tai
//        if (!uploadRootDir.exists()) {
//            uploadRootDir.mkdirs();
//        }

        uploadAvartaImage(avartaImage, house);
        uploadDetailImages(files, house);
//        MultipartFile[] files = uploadFile.getMultipartFiles();


        ModelAndView modelAndView = new ModelAndView("house/create");
        modelAndView.addObject("house", new House());
//        modelAndView.addObject("uploadFiles", uploadedFiles);
//        modelAndView.addObject("failedFiles", failedFiles);
        return modelAndView;
    }

    private void uploadAvartaImage(MultipartFile file, House house) {
        File uploadRootDir = new File("/home/dat/uploads");

        //Tao thu muc goc neu no khong ton tai
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
//        String failedFile = "";

        String name = file.getOriginalFilename();
        System.out.println("Client File Name = " + name);

        Date date = new Date();

        String url = "";
        url = String.valueOf((name + date.toString()).hashCode());
        ImageHouse image = new ImageHouse(url, house, 0);
        imageHouseService.save(image);

        if (name != null && name.length() > 0) {
            try {
                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + url);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(file.getBytes());
                stream.close();
//                System.out.println("Write file: " + serverFile);
            } catch (IOException e) {
//                failedFile = "Error Write file: " + name;
            }
        }

    }

    private void uploadDetailImages(MultipartFile[] files, House house) {
        File uploadRootDir = new File("/home/dat/uploads");

        //Tao thu muc goc neu no khong ton tai
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
//        List<File> uploadedFiles = new ArrayList<>();
//        List<String> failedFiles = new ArrayList<>();

        for (MultipartFile file : files) {
            //Ten goc tai Client
            String name = file.getOriginalFilename();
            System.out.println("Client File Name = " + name);

            Date date = new Date();

            String url = "";
            url = String.valueOf((name + date.toString()).hashCode());
            ImageHouse image = new ImageHouse(url, house, 1);
            imageHouseService.save(image);

            if (name != null && name.length() > 0) {
                try {
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + url);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(file.getBytes());
                    stream.close();
                    //
//                    uploadedFiles.add(serverFile);
//                    System.out.println("Write file: " + serverFile);
                } catch (IOException e) {
//                    System.out.println("Error Write file: " + name);
//                    failedFiles.add(name);
                }
            }
        }
    }
}
