package model;

public class AttendanceSession {

    private int attendance_session_id;
    private int attendance_session_teacher_id;
    private String attendance_session_class;
    private String attendance_session_date;
    private String attendance_session_subject;

    public int getAttendance_session_id() {
        return attendance_session_id;
    }
    public void setAttendance_session_id(int attendance_session_id) {
        this.attendance_session_id = attendance_session_id;
    }
    public int getAttendance_session_faculty_id() {
        return attendance_session_teacher_id;
    }
    public void setAttendance_session_teacher_id(int attendance_session_teacher_id) {
        this.attendance_session_teacher_id = attendance_session_teacher_id;
    }
    public String getAttendance_session_class() {
        return attendance_session_class;
    }
    public void setAttendance_session_class(String attendance_session_class) {
        this.attendance_session_class = attendance_session_class;
    }
    public String getAttendance_session_date() {
        return attendance_session_date;
    }
    public void setAttendance_session_date(String attendance_session_date) {
        this.attendance_session_date = attendance_session_date;
    }
    public String getAttendance_session_subject() {
        return attendance_session_subject;
    }
    public void setAttendance_session_subject(String attendance_session_subject) {
        this.attendance_session_subject = attendance_session_subject;
    }

}
