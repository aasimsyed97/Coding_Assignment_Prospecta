package com.masai.question1.controller;

import com.masai.question1.exceptions.ResourceNotFoundException;
import com.masai.question1.model.Entry;
import com.masai.question1.modeldto.Apidata;
import com.masai.question1.modeldto.EntryDetailsResponseDto;
import com.masai.question1.modeldto.EntryResponseDto;
import com.masai.question1.payloads.ApiResponse;
import com.masai.question1.service.EntryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.KeyStore;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EntryController {

    @Autowired
    private EntryServices entryServices;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    // This API will list all the Entries
    // http:localhost:8081/entries

    @GetMapping("/entries")
    public ResponseEntity<List<KeyStore.Entry>> getEntriesHandler() {

        Apidata data = restTemplate.getForObject("https://api.publicapis.org/entries", Apidata.class);

        List<KeyStore.Entry> apiEntries = data.getEntries();



        List<EntryDetailsResponseDto> collect = apiEntries.stream()
                .map(e -> this.modelMapper.map(e, EntryDetailsResponseDto.class)).collect(Collectors.toList());

        return new ResponseEntity<List<KeyStore.Entry>>(apiEntries, HttpStatus.OK);
    }

    // Enter a category as a Request Parameter to get Entries based on Category
    // For Example : List All Entries With title and Descriptions For Animal
    // Category
    // https://api.publicapis.org/entries?category=Animals
    // Note : Category is Case Sensitive

    @GetMapping("/entries/categories")
    public ResponseEntity<List<EntryResponseDto>> getEntriesHandler(@RequestParam String category) {

        String url = "https://api.publicapis.org/entries?category=" + category;

        Apidata data = restTemplate.getForObject(url, Apidata.class);

        List<KeyStore.Entry> apiEntries = data.getEntries();

        List<EntryResponseDto> collect = apiEntries.stream().map(e -> this.modelMapper.map(e, EntryResponseDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<List<EntryResponseDto>>(collect, HttpStatus.OK);
    }

    @PostMapping("/entries")
    public ResponseEntity<ApiResponse> saveEntryHandler(@RequestBody Entry entry) throws ResourceNotFoundException, ResourceNotFoundException {

        ApiResponse apiResponse = this.entryServices.saveEntry((KeyStore.Entry) entry);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
    }

}
