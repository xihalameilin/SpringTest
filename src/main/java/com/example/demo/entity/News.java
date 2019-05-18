package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class News {


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
