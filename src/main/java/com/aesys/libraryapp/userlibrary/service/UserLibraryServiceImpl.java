package com.aesys.libraryapp.userlibrary.service;

import com.aesys.libraryapp.userlibrary.data.dto.UserLibraryDto;
import com.aesys.libraryapp.userlibrary.data.dto.UserLibraryMapper;
import com.aesys.libraryapp.userlibrary.data.model.UserLibrary;
import com.aesys.libraryapp.userlibrary.repository.UserLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLibraryServiceImpl implements UserLibraryService{

    @Autowired
    private UserLibraryRepository userLibraryRepository;

    @Autowired
    private UserLibraryMapper mapper;

    @Override
    public void addUserLibrary(UserLibrary newUserLibrary) {
        userLibraryRepository.save(newUserLibrary);
    }

    @Override
    public UserLibraryDto getUserLibrary(String id) {
        return userLibraryRepository.findById(id).map(userLibrary -> mapper.userLibraryToUserLibraryDto(userLibrary)).get();
    }

    @Override
    public void deleteUserLibrary(String id) {
        userLibraryRepository.deleteById(id);
    }

    @Override
    public void updateUserLibrary(UserLibrary updated) {
        this.addUserLibrary(updated);
    }
}
