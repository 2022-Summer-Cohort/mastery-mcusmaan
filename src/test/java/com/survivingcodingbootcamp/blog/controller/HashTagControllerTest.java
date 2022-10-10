package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import com.survivingcodingbootcamp.blog.service.HashTagStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HashTagControllerTest {

    HashTagController underTest;
    private Model model;


    private HashTagStorage hashTagStorage;

    @BeforeEach
    void setUp() {
        hashTagStorage = mock( HashTagStorage.class);
        underTest = new HashTagController(hashTagStorage);
        model = mock(Model.class);
    }
}
