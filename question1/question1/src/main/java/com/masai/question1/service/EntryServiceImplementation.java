package com.masai.question1.service;

import com.masai.question1.exceptions.ResourceNotFoundException;
import com.masai.question1.modeldto.EntryDetailsResponseDto;
import com.masai.question1.modeldto.EntryResponseDto;
import com.masai.question1.model.Entry;
import com.masai.question1.payloads.ApiResponse;
import com.masai.question1.repositories.EntryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryServiceImplementation implements EntryServices {

    @Autowired
    private EntryRepo eRepo;

    @Autowired
    private ModelMapper modelmapper;

    @Override
    public ApiResponse saveEntry(Entry entry) throws ResourceNotFoundException {

        Entry findByApi = this.eRepo.findByApi(entry.getApi())
                .orElseThrow(() -> new ResourceNotFoundException("Entry", "API", entry.getApi()));

        EntryDetailsResponseDto entryDetailsResponseDto = this.toEntryDetailsResponseDto(entry);

        return new ApiResponse(LocalDateTime.now(), "Entry Saved Successfully !", true, entryDetailsResponseDto);
    }

    @Override
    public List<EntryResponseDto> getAllEntries() {

        List<Entry> list = this.eRepo.findAll();

        return list.stream().map(e -> this.toEntryResponseDto(e)).collect(Collectors.toList());

    }

    private EntryDetailsResponseDto toEntryDetailsResponseDto(Entry entry) {

        return this.modelmapper.map(entry, EntryDetailsResponseDto.class);

    }

    private EntryResponseDto toEntryResponseDto(Entry entry) {

        return this.modelmapper.map(entry, EntryResponseDto.class);
    }

}
