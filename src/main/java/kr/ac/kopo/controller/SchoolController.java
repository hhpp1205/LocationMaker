//package kr.ac.kopo.controller;
//
//import kr.ac.kopo.domain.SchoolVO;
//import kr.ac.kopo.service.SchoolService;
//import kr.ac.kopo.util.pager.Pager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("school/")
//public class SchoolController {
//
//    private final SchoolService schoolService;
//    final String path = "school/";
//
//    @GetMapping
//    public String getAllSchool(Model model, Pager pager) {
//        List<SchoolVO> list = schoolService.list(pager);
//        model.addAttribute("list", list);
//        return "list";
//    }
//
//    @GetMapping("/add")
//    public String add() {
//        return path + "add";
//    }
//
//    @PostMapping("/add")
//    public String add(SchoolVO schoolVO) {
//        schoolService.add(schoolVO);
//        return "redirect:list";
//    }
//
//    @GetMapping("/update/{id}")
//    public String update(@PathVariable int id, Model model) {
//        SchoolVO item = schoolService.findById(id);
//        model.addAttribute("item", item);
//        return path + "update";
//    }
//
//    @PostMapping("/update/{id}")
//    public String update(@PathVariable int id, SchoolVO schoolVO) {
//        schoolService.update(schoolVO);
//        return "학교페이지로 이동(redirect)";
//    }
//
//    @GetMapping("/school/{id}")
//    public String delete(@PathVariable int id) {
//        schoolService.delete(id);
//        return "recirect:../list";
//    }
//}
