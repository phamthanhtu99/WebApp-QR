package com.example.API.store;

import com.example.Dto.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StoreAPI {
    @PostMapping("/v1/save/product")
    public ResponseEntity<?> save (@RequestParam("img") MultipartFile[] file
            , @RequestParam("imgs") MultipartFile[] files, @RequestParam("prduct") String storeDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductDTO productDTO =objectMapper.readValue(storeDTO,ProductDTO.class);
        return ResponseEntity.ok(productDTO);
    }
}
