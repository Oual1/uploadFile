package file.updown.fileuploaddownload.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import file.updown.fileuploaddownload.entities.File;
import file.updown.fileuploaddownload.enums.FileState;
import file.updown.fileuploaddownload.enums.FileType;
import file.updown.fileuploaddownload.message.ResponseMessage;
import file.updown.fileuploaddownload.services.FileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest

class FileControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    @MockBean
    private FileService fileService;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void uploadTxtFileTest() throws Exception {
        // Create a text file to upload
        String fileName = "example.txt";
        String fileContent ="920000Test text file content.";
        byte[] fileBytes = fileContent.getBytes();


        MockMultipartFile file = new MockMultipartFile("file", fileName, MediaType.MULTIPART_FORM_DATA_VALUE, fileBytes);

        // Perform the file upload request and get the response
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.multipart("/uploads")
                        .file(file))
                .andExpect(status().isOk())
                .andReturn();


        // Check the response message
        String expectedMessage = "Uploaded the file successfully: " + fileName.substring(0, fileName.length() - 4) + "_" + LocalDate.now().toString() + ".txt";

        String actualMessagee = mvcResult.getResponse().getContentAsString();
        String actualMessage= actualMessagee.substring(12, actualMessagee.length()-2); //a vérifier
        assertEquals(expectedMessage, actualMessage);

    }
    @Test
    void uploadTxtNotAcceptableFileTest() throws Exception {
        // Create a text file to upload
        String fileName = "example.txt";
        String fileContent ="Test text file content.";
        byte[] fileBytes = fileContent.getBytes();


        MockMultipartFile file = new MockMultipartFile("file", fileName, MediaType.MULTIPART_FORM_DATA_VALUE, fileBytes);

        // Perform the file upload request and get the response
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.multipart("/uploads")
                        .file(file))
                .andExpect(status().isNotAcceptable())
                .andReturn();


        // Check the response message
        String expectedMessage = "Content Not Acceptable:";

        String actualMessagee = mvcResult.getResponse().getContentAsString();
        String actualMessage= actualMessagee.substring(12, actualMessagee.length()-2); //a vérifier
        assertEquals(expectedMessage, actualMessage);

    }


    @Test
    void uploadNonTxtFileTest() throws Exception {
        // Créer un fichier non-texte à télécharger
        String fileName = "example.pdf";
        byte[] fileBytes = {1, 2, 3, 4};
        MockMultipartFile file = new MockMultipartFile("file", fileName, MediaType.MULTIPART_FORM_DATA_VALUE, fileBytes);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.multipart("/uploads")
                        .file(file))
                .andExpect(status().isUnsupportedMediaType())
                .andReturn();

        String actualMessagee = mvcResult.getResponse().getContentAsString();
        String actualMessage= actualMessagee.substring(12, actualMessagee.length()-2);
        // Vérifier que la réponse a le message attendu
        String expectedMessage = "Unsupported file type:";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testFindFile() throws Exception {

        // Create a sample file
        File file = new File();
        file.setId(1L);
        file.setFileName("test.txt");
        file.setType(FileType.REJET_PLUS5);
        file.setState(FileState.FILE_DROPPED);

        // Mock the fileService to return the sample file
        when(fileService.retreiveFile(1L)).thenReturn(file);

        // Perform the GET request to /files/1
        mockMvc.perform(get("/files/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.fileName").value("test.txt"))
                .andExpect(jsonPath("$.state").value("FILE_DROPPED"))
                .andExpect(jsonPath("$.type").value("REJET_PLUS5"));

        // Verify that the fileService was called with the correct ID
        verify(fileService).retreiveFile(1L);
    }

    @Test
    public void testGetAllFiles() throws Exception {
        // Create sample files
        List<File> files = new ArrayList<>();
        files.add(new File(1L, "file1.txt", FileState.FILE_DROPPED, FileType.REJET_PLUS5));
        files.add(new File(2L, "file2.txt", FileState.FILE_DROPPED, FileType.DECOMPTE_REJET));

        // Mock the fileService to return the sample files
        when(fileService.getAllFiles()).thenReturn(files);

        // Perform the GET request to /files
        mockMvc.perform(get("/files"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].fileName").value("file1.txt"))
                .andExpect(jsonPath("$[0].state").value("FILE_DROPPED"))
                .andExpect(jsonPath("$[0].type").value("REJET_PLUS5"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].fileName").value("file2.txt"))
                .andExpect(jsonPath("$[1].state").value("FILE_DROPPED"))
                .andExpect(jsonPath("$[1].type").value("DECOMPTE_REJET"));



        // Verify that the fileService was called
        verify(fileService).getAllFiles();
    }

    @Test
    public void testFirstSegregationSuccess() throws Exception {
        // Mock the fileService to return a successful response
        doNothing().when(fileService).segregateContentById(1L);

        // Perform the GET request to /file/1
        mockMvc.perform(get("/file/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("file segregated successfully."));

        // Verify that the fileService was called with the correct ID
        verify(fileService).segregateContentById(1L);

    }
    @Test
    public void testFirstSegregationNotFound() throws Exception {
        // Mock the fileService to throw a RuntimeException
        doThrow(new RuntimeException()).when(fileService).segregateContentById(1L);

        // Perform the GET request to /file/1
        mockMvc.perform(get("/file/1"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("File id is not exist."));

        // Verify that the fileService was called with the correct ID
        verify(fileService).segregateContentById(1L);
    }

    @Test
    public void testDeleteFileByIdSuccess() throws Exception {
        // Mock the fileService to return a successful response
        doNothing().when(fileService).deleteFileById(1L);

        // Perform the DELETE request to /files/1
        mockMvc.perform(delete("/files/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Deleted the file successfully."));

        // Verify that the fileService was called with the correct ID
        verify(fileService).deleteFileById(1L);
    }


    @Test
    public void testDeleteFileByIdNotFound() throws Exception {
        // Mock the fileService to throw a RuntimeException
        doThrow(new RuntimeException()).when(fileService).deleteFileById(1L);

        // Perform the DELETE request to /files/1
        mockMvc.perform(delete("/files/1"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Deleting file is not exist."));

        // Verify that the fileService was called with the correct ID
        verify(fileService).deleteFileById(1L);
    }


}


