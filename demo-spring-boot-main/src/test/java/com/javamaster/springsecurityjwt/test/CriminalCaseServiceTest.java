package com.javamaster.springsecurityjwt.test;

import com.javamaster.springsecurityjwt.entity.CriminalCase;
import com.javamaster.springsecurityjwt.repository.CriminalCaseRepository;
import com.javamaster.springsecurityjwt.service.CriminalCaseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CriminalCaseServiceTest {
        @Mock
        CriminalCaseRepository criminalCaseRepository;
        @InjectMocks
        CriminalCaseService criminalCaseService;
        @Test
        void add_success() {
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setNumber("12345");
                Mockito.when(criminalCaseRepository.existsByNumber("12345")).thenReturn(false);
                String kq= criminalCaseService.createCriminalCase(criminalCase);
                assertEquals("thành công", kq);
        }
        }
