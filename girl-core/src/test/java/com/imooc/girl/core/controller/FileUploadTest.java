package com.imooc.girl.core.controller;


/**
 * Created by hmh on 2017/8/2.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class FileUploadTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private StorageService storageService;

//    @Test
//    public void shouldListAllFiles() throws Exception {
//        given(this.storageService.loadAll())
//                .willReturn(Stream.of(Paths.get("first.txt"), Paths.get("second.txt")));
//
//        this.mvc.perform(get("/")).andExpect(status().isOk())
//                .andExpect(model().attribute("z-file",
//                        Matchers.contains("http://localhost/z-file/first.txt",
//                                "http://localhost/z-file/second.txt")));
//    }

//    @Test
//    public void shouldSaveUploadedFile() throws Exception {
//        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
//                "text/plain", "Spring Framework".getBytes());
//        this.mvc.perform(fileUpload("/").file(multipartFile))
//                .andExpect(status().isFound())
//                .andExpect(header().string("Location", "/"));
//
//        then(this.storageService).should().store(multipartFile);
//    }

//    @Test
//    public void should404WhenMissingFile() throws Exception {
//        given(this.storageService.loadAsResource("test.txt"))
//                .willThrow(FileNotFoundException.class);
//
//        this.mvc.perform(get("/z-file/test.txt")).andExpect(status().isNotFound());
//    }
//}
