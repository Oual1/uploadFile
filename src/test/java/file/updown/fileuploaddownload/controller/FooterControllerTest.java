//package file.updown.fileuploaddownload.controller;
//
//import file.updown.fileuploaddownload.entities.File;
//import file.updown.fileuploaddownload.enums.FileState;
//import file.updown.fileuploaddownload.enums.FileType;
//import file.updown.fileuploaddownload.services.FileService;
//import file.updown.fileuploaddownload.services.FooterService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//@SpringBootTest
//class FooterControllerTest {
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    private MockMvc mockMvc;
//    @MockBean
//    private FooterService footerService;
//    @MockBean
//    private FileService fileService;
//
//    @BeforeEach
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//
//
//    @Test
//    public void testGetFooterById() throws Exception {
//
//        // Create a sample file
//        File file = new File();
//        file.setId(1L);
//        file.setFileName("test.txt");
//        file.setType(FileType.BORDEREAU_FACTURATION);
//        file.setState(FileState.FILE_DROPPED);
//        fileService.segregateContentById(1L);
//
//        // Mock the fileService to return the sample file
//        when(fileService.retreiveFile(1L)).thenReturn(file);
//
//        // Perform the GET request to /files/1
//        mockMvc.perform(get("/files/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.fileName").value("test.txt"))
//                .andExpect(jsonPath("$.state").value("FILE_DROPPED"))
//                .andExpect(jsonPath("$.type").value("REJET_PLUS5"));
//
//        // Verify that the fileService was called with the correct ID
//        verify(fileService).retreiveFile(1L);
//    }
//
//    @Test
//    public void testGetAllFooters() throws Exception {
//        // Create sample files
//        List<File> files = new ArrayList<>();
//        files.add(new File(1L, "file1.txt", FileState.FILE_DROPPED, FileType.REJET_PLUS5));
//        files.add(new File(2L, "file2.txt", FileState.FILE_DROPPED, FileType.DECOMPTE_REJET));
//
//        // Mock the fileService to return the sample files
//        when(fileService.getAllFiles()).thenReturn(files);
//
//        // Perform the GET request to /files
//        mockMvc.perform(get("/files"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].fileName").value("file1.txt"))
//                .andExpect(jsonPath("$[0].state").value("FILE_DROPPED"))
//                .andExpect(jsonPath("$[0].type").value("REJET_PLUS5"))
//                .andExpect(jsonPath("$[1].id").value(2))
//                .andExpect(jsonPath("$[1].fileName").value("file2.txt"))
//                .andExpect(jsonPath("$[1].state").value("FILE_DROPPED"))
//                .andExpect(jsonPath("$[1].type").value("DECOMPTE_REJET"));
//
//
//
//        // Verify that the fileService was called
//        verify(fileService).getAllFiles();
//    }
//
//    @Test
//    public void testFirstSegregationSuccess() throws Exception {
//        // Mock the fileService to return a successful response
//        doNothing().when(fileService).segregateContentById(1L);
//
//        // Perform the GET request to /file/1
//        mockMvc.perform(get("/file/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.message").value("file segregated successfully."));
//
//        // Verify that the fileService was called with the correct ID
//        verify(fileService).segregateContentById(1L);
//
//    }
//    @Test
//    public void testFirstSegregationNotFound() throws Exception {
//        // Mock the fileService to throw a RuntimeException
//        doThrow(new RuntimeException()).when(fileService).segregateContentById(1L);
//
//        // Perform the GET request to /file/1
//        mockMvc.perform(get("/file/1"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.message").value("File id is not exist."));
//
//        // Verify that the fileService was called with the correct ID
//        verify(fileService).segregateContentById(1L);
//    }
//
//    @Test
//    public void testDeleteFileByIdSuccess() throws Exception {
//        // Mock the fileService to return a successful response
//        doNothing().when(fileService).deleteFileById(1L);
//
//        // Perform the DELETE request to /files/1
//        mockMvc.perform(delete("/files/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.message").value("Deleted the file successfully."));
//
//        // Verify that the fileService was called with the correct ID
//        verify(fileService).deleteFileById(1L);
//    }
//
//
//    @Test
//    public void testDeleteFileByIdNotFound() throws Exception {
//        // Mock the fileService to throw a RuntimeException
//        doThrow(new RuntimeException()).when(fileService).deleteFileById(1L);
//
//        // Perform the DELETE request to /files/1
//        mockMvc.perform(delete("/files/1"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.message").value("Deleting file is not exist."));
//
//        // Verify that the fileService was called with the correct ID
//        verify(fileService).deleteFileById(1L);
//    }
//
//
//}
