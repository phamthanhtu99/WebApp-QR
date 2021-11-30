package com.example.Service;

public interface  Abstract <T>{
         T save(T value) ;
         T upate (T value);
         boolean delete(long[] longs);
}