package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    /**
     *
     * @param id
     * @return 根据id查询
     */
    @GetMapping("/query/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserByID(id);
    }

    @GetMapping("/insert/{name}/{age}")
    public int insertUser(@PathVariable String name,@PathVariable int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return userService.insertUser(user);
    }

    @GetMapping("/delete/{id}")
    public int deleteUserByID(@PathVariable int id){
        return userService.deleteUserByID(id);
    }

    @GetMapping("/update/{id}/{name}")
    public int update(@PathVariable int id,@PathVariable String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return userService.updateUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUsers();
    }



    @GetMapping("/user/{age}")
    public void f(@PathVariable Integer age,@RequestParam String sex,@RequestBody User user){
        System.out.println(age);
        System.out.println(sex);
        System.out.println(user.getName());
    }

    @PostMapping("/upload") // 等价于 @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uplaod( @RequestParam("file") MultipartFile file ){//1. 接受上传的文件  @RequestParam("file") MultipartFile file
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = "D:\\images"+File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            //destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "showImg";
    }

}
