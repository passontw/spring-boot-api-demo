package passon.com.tw.springbootdemo.springbootapidemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import passon.com.tw.springbootdemo.springbootapidemo.bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // http://localhost:8100/students
    @GetMapping
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Ramesh",
                "Fadatare"
        );

//        return new ResponseEntity<Student>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "ramesh").body(student);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudents () {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ramesh", "Fadatare"));
        students.add(new Student(2, "Tomas", "Lin"));

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    /**
     * http://localhost:8100/students/1
     * @param studentId
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId) {
        Student student = new Student(
                studentId,
                "Ramesh",
                "Fadatare"
        );

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    /**
     * http://localhost:8100/students/1
     * @param studentId
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student updateStudent) {
        Student student = new Student(
                studentId,
                updateStudent.getFirstName(),
                updateStudent.getLastName()
        );

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    /**
     * http://localhost:8100/students/query?id=1
     * @param studentId
     * @return
     */
    @GetMapping("/query")
    public ResponseEntity<Student> getStudentById(@RequestParam("id") int studentId) {
        Student student = new Student(
                studentId,
                "Ramesh",
                "Fadatare"
        );

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    /**
     * http://localhost:8100/students
     * @param student
     * @return
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);

    }

    /**
     * http://localhost:8100/students/1
     * @param studentId
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student deleted successfully";
    }
}
