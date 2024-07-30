package MVCPatternExample;

class StudentModel {
    private String studentName;
    private int studentId;
    private String studentGrade;

    public StudentModel(String studentName, int studentId, String studentGrade) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentGrade = studentGrade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
}

class StudentView {
    public void displayStudentDetails(StudentModel studentModel) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentModel.getStudentName());
        System.out.println("ID: " + studentModel.getStudentId());
        System.out.println("Grade: " + studentModel.getStudentGrade());
    }
}

class StudentController {
    private StudentModel studentModel;
    private StudentView studentView;

    public StudentController(StudentModel studentModel, StudentView studentView) {
        this.studentModel = studentModel;
        this.studentView = studentView;
    }

    public void setStudentName(String studentName) {
        studentModel.setStudentName(studentName);
    }

    public String getStudentName() {
        return studentModel.getStudentName();
    }

    public void updateView() {
        studentView.displayStudentDetails(studentModel);
    }
}

public class MVCPatternExample {
    public static void main(String[] args) {
        StudentModel studentModel = new StudentModel("Pooja Ghosh", 10, "A");
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(studentModel, studentView);
        
        // Display
        studentController.updateView(); 

        // Update student details and display again
        studentController.setStudentName("Pooja Das");
        studentController.updateView();
    }
}
