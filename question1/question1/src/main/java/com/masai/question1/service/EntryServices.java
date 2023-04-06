package com.masai.question1.service;

import com.masai.question1.exceptions.ResourceNotFoundException;
import com.masai.question1.modeldto.EntryResponseDto;
import com.masai.question1.model.Entry;
import com.masai.question1.payloads.ApiResponse;

import java.security.KeyStore;
import java.util.List;

public interface EntryServices {

    public ApiResponse saveEntry(KeyStore.Entry entries) throws ResourceNotFoundException;

    List<EntryResponseDto> getAllEntries();
}
