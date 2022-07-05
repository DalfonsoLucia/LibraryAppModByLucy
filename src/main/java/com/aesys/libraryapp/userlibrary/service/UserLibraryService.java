package com.aesys.libraryapp.userlibrary.service;

import com.aesys.libraryapp.userlibrary.data.dto.UserLibraryDto;
import com.aesys.libraryapp.userlibrary.data.model.UserLibrary;

public interface UserLibraryService {

    void addUserLibrary(UserLibrary newUserLibrary);

    UserLibraryDto getUserLibrary(String id) ;

    void deleteUserLibrary (String id);

    void updateUserLibrary(UserLibrary updated);
}
