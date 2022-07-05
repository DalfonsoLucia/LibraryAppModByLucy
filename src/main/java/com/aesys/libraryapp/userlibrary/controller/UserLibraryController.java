package com.aesys.libraryapp.userlibrary.controller;

import com.aesys.libraryapp.userlibrary.data.dto.UserLibraryDto;
import com.aesys.libraryapp.userlibrary.data.dto.UserLibraryMapper;
import com.aesys.libraryapp.userlibrary.data.model.UserLibrary;
import com.aesys.libraryapp.userlibrary.data.model.UserLibrarySpec;
import com.aesys.libraryapp.userlibrary.repository.UserLibraryRepository;
import com.aesys.libraryapp.userlibrary.service.UserLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userLibrary")
public class UserLibraryController {

    @Autowired
    private UserLibraryService userLibraryService;
    @Autowired
    private UserLibraryRepository userLibraryRepository;
    @Autowired
    private UserLibraryMapper mapper;

    /*@GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserLibraryDto getUserLibraryById(@PathVariable String id) {
        return userLibraryService.getUserLibrary(id);
    }*/

    @GetMapping(value="/{firstName}")
    public UserLibraryDto getUserByName(@PathVariable String firstName)
    { return mapper.userLibraryToUserLibraryDto(userLibraryRepository.
            findEverything(UserLibrarySpec.getByName(firstName)).get(0)); }

    @GetMapping
    public List<UserLibrary> getUserNameLastNameFilter(@RequestParam String firstName, @RequestParam String lastName)
    {
        return userLibraryRepository.findAll(UserLibrarySpec.getByNameAndLastName(firstName, lastName));
    }
}
