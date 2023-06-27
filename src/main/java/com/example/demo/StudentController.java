package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public String insert(@RequestBody @Valid Student student) {

        studentRepository.save(student);

        return "執行資料庫的 Create 操作";
    }

    @PutMapping("/students/{studentId}")
    public String updata(@PathVariable Integer studentId,
                         @RequestBody Student student) {

        Student s = studentRepository.findById(studentId).orElse(null);

        if (s != null) {
            s.setName(student.getName()); //←←這邊就使用set修改資料了。
            studentRepository.save(s); //←←這裡意思，就相較於修改完後做儲存。

            return "執行資料庫的 Updata 操作";
        } else {
            return "Undate 失敗，數據不存在";
        }
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {

        studentRepository.deleteById(studentId);

        return "執行資料庫的 Delete 操作";
    }

    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer studentId) {

        Student student = studentRepository.findById(studentId).orElse(null);

        return student;
    }

}
